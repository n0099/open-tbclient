package com.baidu.live.im.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.im.data.ImForbiddenStateData;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends b {
    private static ImSendMsgData bpV;
    private BdPageContext boN;
    public CustomMessageListener bpW;
    private BdAlertDialog mDialog;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity(), com.baidu.live.im.a.bls);
        this.bpW = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ImForbiddenStateData)) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(f.this.mContext, f.this.mContext.getResources().getString(a.h.ala_im_ban_no_net_tips));
                    } else if (imForbiddenStateData.banState != 0 || f.bpV == null) {
                        f.this.a(imForbiddenStateData);
                    } else {
                        a.d(f.bpV);
                        ImSendMsgData unused = f.bpV = null;
                    }
                }
            }
        };
        this.boN = bdPageContext;
    }

    @Override // com.baidu.live.im.a.b
    protected void MW() {
        if (MX()) {
            MY();
        } else {
            MZ();
        }
    }

    @Override // com.baidu.live.im.a.b
    protected int getColor() {
        if (MX()) {
            return -1;
        }
        return this.mContext.getResources().getColor(a.c.sdk_common_color_10034);
    }

    @Override // com.baidu.live.im.a.b
    protected SpannableStringBuilder b(com.baidu.live.im.data.b bVar, com.baidu.live.im.c cVar) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        boolean z = (bVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) bVar).LO().equals(bVar.Nw().userId);
        if (z) {
            com.baidu.live.view.b bVar2 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_anchor);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("  ");
            spannableStringBuilder2.setSpan(bVar2, 0, 1, 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        }
        a(spannableStringBuilder, bVar.Nw(), cVar, z, true, true);
        if (z) {
            cj(false);
        }
        String content = bVar.getContent();
        SpannableString valueOf = SpannableString.valueOf(content + " ");
        if (content != null) {
            valueOf.setSpan(new ForegroundColorSpan(-1), 0, content.length(), 33);
        }
        spannableStringBuilder.append((CharSequence) valueOf);
        boolean equals = TextUtils.equals(bVar.Nw().userId, TbadkCoreApplication.getCurrentAccount());
        if (!((bVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) bVar).LO().equals(TbadkCoreApplication.getCurrentAccount())) && hQ(content) && !equals) {
            com.baidu.live.view.b bVar3 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_followone);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(" ");
            spannableStringBuilder3.setSpan(bVar3, 0, 1, 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
            a aVar = new a(this.mContext, content);
            aVar.setClickable(true);
            spannableStringBuilder.setSpan(aVar, 0, spannableStringBuilder.length(), 33);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("msg", content);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "quickadd_show").setContentExt(null, "popup", jSONObject));
        }
        return spannableStringBuilder;
    }

    private boolean hQ(String str) {
        return com.baidu.live.af.a.SE().bwi.aOG != null && com.baidu.live.af.a.SE().bwi.aOG.originTexts != null && com.baidu.live.af.a.SE().bwi.aOG.originTexts.size() > 0 && com.baidu.live.af.a.SE().bwi.aOG.originTexts.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bqL == 1) {
                format = this.mContext.getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(this.boN.getPageActivity().getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bqM);
            }
            this.mDialog = new BdAlertDialog(TbadkCoreApplication.getInst().getCurrentActivity());
            this.mDialog.setMessage(format);
            this.mDialog.setPositiveButton(this.boN.getPageActivity().getResources().getString(a.h.ala_forbidden_words_btn_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.im.a.f.2
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                        BrowserHelper.startInternalWebActivity(f.this.boN.getPageActivity(), "https%3A%2F%2Fufosdk.baidu.com%2F%3Fm%3DClient%26a%3DpostViewNew%26appid%3D238780%26needFbtype%3Dtrue%26hasRt%3Dfalse%26hasTitleBar%3Dfalse%26fbtnPlace%3Dbr%26channelId%3D90953");
                    } else {
                        BrowserHelper.startInternalWebActivity(f.this.boN.getPageActivity(), "https://ufosdk.baidu.com/?m=Client&a=postViewNew&appid=238780&needFbtype=true&hasRt=false&hasTitleBar=false&fbtnPlace=br&channelId=90953");
                    }
                    bdAlertDialog.dismiss();
                }
            });
            this.mDialog.setNegativeButton(this.boN.getPageActivity().getResources().getString(a.h.ala_forbidden_words_btn_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.im.a.f.3
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    bdAlertDialog.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.mDialog.setPositiveButtonTextColor(this.boN.getPageActivity().getResources().getColorStateList(a.e.sdk_dialog_blue_button_txt_selector));
                this.mDialog.setNagetiveButtonTextColor(this.boN.getPageActivity().getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
            } else {
                this.mDialog.setPositiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
                this.mDialog.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.mDialog.create(this.boN);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(this.boN.getPageActivity(), this.boN.getPageActivity().getResources().getString(a.h.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(this.boN.getPageActivity(), this.boN.getPageActivity().getResources().getString(a.h.ala_forbidden_words_is_block_1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a extends ClickableSpan {
        private boolean bpK;
        private long bpY;
        private long bpZ = 2000;
        private String content;
        private Context context;

        public a(Context context, String str) {
            this.context = context;
            this.content = str;
        }

        public void setClickable(boolean z) {
            this.bpK = z;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
        }

        protected static void d(ImSendMsgData imSendMsgData) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("msg", imSendMsgData.text);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quickadd_clk").setContentExt(null, "popup", jSONObject));
        }

        private boolean ME() {
            if (TbadkCoreApplication.isLogin()) {
                return true;
            }
            ViewHelper.skipToLoginActivity(this.context);
            return false;
        }

        private boolean Ni() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.bpY < this.bpZ) {
                return false;
            }
            this.bpY = currentTimeMillis;
            return true;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913288, true));
            if (Ni()) {
                ImSendMsgData unused = f.bpV = new ImSendMsgData(this.content);
                if (!TextUtils.isEmpty(this.content) && ME()) {
                    if (com.baidu.live.af.a.SE().bwi.aPf == 1 && !LoginManager.getInstance(this.context).isIMLogined()) {
                        BdUtilHelper.showToast(this.context, this.context.getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                        return;
                    } else if (com.baidu.live.af.a.SE().bwi.aPe != 1) {
                        d(f.bpV);
                        return;
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                }
                return;
            }
            BdUtilHelper.showToast(this.context, "您按的太快，我都跟不上了~");
        }
    }

    public void Ng() {
        MessageManager.getInstance().unRegisterListener(this.bpW);
    }
}
