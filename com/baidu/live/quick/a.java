package com.baidu.live.quick;

import android.app.Activity;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.QuickImInputData;
import com.baidu.live.data.an;
import com.baidu.live.data.ck;
import com.baidu.live.data.x;
import com.baidu.live.gift.ac;
import com.baidu.live.im.data.ImForbiddenStateData;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.quick.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.view.input.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a implements d {
    private ck aCr;
    private int bad;
    public CustomMessageListener bdo;
    private CustomMessageListener bly;
    private boolean bnc;
    private int bne;
    private AlaLiveInfoData bnl;
    private d.a bul;
    private b bum;
    private String[] bun;
    private List<String> buo;
    private CustomMessageListener bup;
    private x buq;
    private BdAlertDialog mDialog;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private int mPos;
    private String mText;
    private String mUserName;
    private String mVid;
    private int bng = 0;
    public CustomMessageListener blj = new CustomMessageListener(2913193) { // from class: com.baidu.live.quick.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && a.this.bng == 5) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        a.this.a(a.this.mPos, a.this.mText, a.this.aCr);
                    } else {
                        a.this.a(imForbiddenStateData);
                    }
                }
                a.this.bng = 0;
            }
        }
    };

    @Override // com.baidu.live.view.input.d
    public void a(d.a aVar) {
        this.bul = aVar;
    }

    @Override // com.baidu.live.view.input.d
    public void b(x xVar, String str) {
        this.buq = xVar;
        if (xVar != null) {
            this.bnl = xVar.mLiveInfo;
        }
        this.mVid = "";
        if (xVar != null && xVar.mLiveInfo != null && xVar.mLiveInfo.feed_id != null) {
            this.mVid = xVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        NQ();
        NR();
        MessageManager.getInstance().registerListener(this.blj);
        Gz();
    }

    @Override // com.baidu.live.view.input.d
    public void d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bum = new b(this.mPageContext);
        this.bum.a(new b.a() { // from class: com.baidu.live.quick.a.1
            @Override // com.baidu.live.quick.b.a
            public boolean IJ() {
                return a.this.bul != null && a.this.bul.IJ();
            }

            @Override // com.baidu.live.quick.b.a
            public void onShow() {
                if (a.this.bul != null) {
                    a.this.bul.Wh();
                }
            }

            @Override // com.baidu.live.quick.b.a
            public void onDismiss() {
                if (a.this.bul != null) {
                    a.this.bul.Wi();
                }
            }

            @Override // com.baidu.live.quick.b.a
            public void b(int i, String str, ck ckVar) {
                a.this.mPos = i;
                a.this.mText = str;
                a.this.aCr = ckVar;
                if (com.baidu.live.af.a.OJ().bru.aKs == 1 && !LoginManager.getInstance(a.this.mPageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.af.a.OJ().bru.aKr == 1) {
                    if (!a.this.bnc) {
                        a.this.a(i, str, ckVar);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    a.this.bng = 5;
                } else {
                    a.this.a(i, str, ckVar);
                }
            }

            @Override // com.baidu.live.quick.b.a
            public boolean Jy() {
                return a.this.bul != null && a.this.bul.Jy();
            }

            @Override // com.baidu.live.quick.b.a
            public int IP() {
                if (a.this.bul != null) {
                    return a.this.bul.IP();
                }
                return 0;
            }

            @Override // com.baidu.live.quick.b.a
            public boolean IQ() {
                return a.this.bul != null && a.this.bul.IQ();
            }
        });
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.bum.a(NN(), KE());
            ac.fP("quick_im");
        }
    }

    private boolean KE() {
        return (this.bnl == null || this.bnl.mAlaLiveSwitchData == null || !this.bnl.mAlaLiveSwitchData.isPayBarrageUnabled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, ck ckVar) {
        if (this.bul != null && this.bul.IJ()) {
            ImSendMsgData imSendMsgData = new ImSendMsgData(str);
            imSendMsgData.text = str;
            if (ckVar != null) {
                imSendMsgData.msgType = (short) 126;
                imSendMsgData.barrageType = ckVar.type;
                imSendMsgData.barrageId = ckVar.id;
                imSendMsgData.price = ckVar.price;
                imSendMsgData.isQuickBarrage = true;
            } else {
                imSendMsgData.isQuick = true;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913288, true));
        gb(str);
        this.bum.dismiss();
        LogManager.getCommonLogger().doClickQuickImListLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("msg", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_QUICK_CLICK).setContentExt(null, UbcStatConstant.SubPage.POPUP, "in", jSONObject));
    }

    @Override // com.baidu.live.view.input.d
    public void b(boolean z, int i, int i2, String str) {
        this.bnc = z;
        this.bne = i;
        this.bad = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.mPageContext.getPageActivity();
        if (pageActivity != null) {
            if (imForbiddenStateData.globalBan == 1) {
                if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.blY == 1) {
                    format = pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_block);
                } else {
                    format = String.format(pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.blZ);
                }
                this.mDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.mDialog.setMessage(format);
                this.mDialog.setPositiveButton(pageActivity.getResources().getString(a.h.ala_forbidden_words_btn_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.quick.a.3
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                            BrowserHelper.startInternalWebActivity(pageActivity, "https%3A%2F%2Fufosdk.baidu.com%2F%3Fm%3DClient%26a%3DpostViewNew%26appid%3D238780%26needFbtype%3Dtrue%26hasRt%3Dfalse%26hasTitleBar%3Dfalse%26fbtnPlace%3Dbr%26channelId%3D90953");
                        } else {
                            BrowserHelper.startInternalWebActivity(pageActivity, "https://ufosdk.baidu.com/?m=Client&a=postViewNew&appid=238780&needFbtype=true&hasRt=false&hasTitleBar=false&fbtnPlace=br&channelId=90953");
                        }
                        bdAlertDialog.dismiss();
                    }
                });
                this.mDialog.setNegativeButton(pageActivity.getResources().getString(a.h.ala_forbidden_words_btn_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.quick.a.4
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        bdAlertDialog.dismiss();
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.mDialog.setPositiveButtonTextColor(pageActivity.getResources().getColorStateList(a.e.sdk_dialog_blue_button_txt_selector));
                    this.mDialog.setNagetiveButtonTextColor(pageActivity.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
                } else {
                    this.mDialog.setPositiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
                    this.mDialog.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
                }
                this.mDialog.create(this.mPageContext);
                this.mDialog.setCanceledOnTouchOutside(false);
                this.mDialog.show();
            } else if (imForbiddenStateData.anchorBan == 1) {
                BdUtilHelper.showToast(pageActivity, pageActivity.getResources().getString(a.h.ala_forbidden_words_is_block_2));
            } else if (imForbiddenStateData.liveBan == 1) {
                BdUtilHelper.showToast(pageActivity, pageActivity.getResources().getString(a.h.ala_forbidden_words_is_block_1));
            }
        }
    }

    @Override // com.baidu.live.view.input.d
    public void co(int i) {
        if (this.bum != null && this.bum.isShowing()) {
            this.bum.co(i);
        }
    }

    @Override // com.baidu.live.view.input.d
    public List<String> NM() {
        an anVar;
        QuickImInputData quickImInputData;
        List<String> list;
        List<String> list2;
        if (this.buo == null) {
            this.buo = new ArrayList();
        } else {
            this.buo.clear();
        }
        if (this.buq != null && this.buq.aGB != null && (list2 = this.buq.aGB.sortedTexts) != null && !list2.isEmpty()) {
            this.buo.addAll(list2);
        }
        if (this.buo.isEmpty() && (anVar = com.baidu.live.af.a.OJ().bru) != null && (quickImInputData = anVar.aJT) != null && (list = quickImInputData.sortedTexts) != null && !list.isEmpty()) {
            this.buo.addAll(list);
        }
        if (this.buo.isEmpty()) {
            Collections.addAll(this.buo, NN());
        }
        return this.buo;
    }

    @Override // com.baidu.live.view.input.d
    public void gb(String str) {
        List<String> list;
        if (!TextUtils.isEmpty(str) && this.buo != null && !this.buo.isEmpty() && this.buo.indexOf(str) > 1) {
            if (this.buo.remove(str)) {
                this.buo.add(1, str);
            }
            if (this.buq != null && this.buq.aGB != null && (list = this.buq.aGB.sortedTexts) != null && !list.isEmpty()) {
                list.clear();
                list.addAll(this.buo);
                return;
            }
            an anVar = com.baidu.live.af.a.OJ().bru;
            if (anVar != null) {
                QuickImInputData quickImInputData = anVar.aJT;
                if (quickImInputData == null) {
                    quickImInputData = new QuickImInputData();
                }
                if (quickImInputData.sortedTexts == null) {
                    quickImInputData.sortedTexts = new ArrayList();
                }
                quickImInputData.sortedTexts.clear();
                quickImInputData.sortedTexts.addAll(this.buo);
            }
        }
    }

    @Override // com.baidu.live.view.input.d
    public void Ei() {
        if (this.bum != null) {
            if (this.buo != null) {
                this.buo.clear();
            }
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.bum.dismiss();
            }
            this.bum = null;
            NS();
            NT();
            MessageManager.getInstance().unRegisterListener(this.blj);
            NU();
        }
    }

    @Override // com.baidu.live.view.input.d
    public void release() {
        Ei();
    }

    private String[] NN() {
        if (this.bun == null || this.bun.length == 0) {
            List<String> NO = NO();
            if (NO != null && !NO.isEmpty()) {
                this.bun = (String[]) NO.toArray(new String[NO.size()]);
            } else {
                this.bun = NP();
            }
        }
        return this.bun;
    }

    private List<String> NO() {
        List<String> list;
        List<String> list2;
        ArrayList arrayList = new ArrayList();
        if (this.buq == null || this.buq.aGB == null || (list = this.buq.aGB.sortedTexts) == null || list.isEmpty()) {
            list = arrayList;
        }
        if (list == null || list.isEmpty()) {
            an anVar = com.baidu.live.af.a.OJ().bru;
            if (anVar == null) {
                return null;
            }
            QuickImInputData quickImInputData = anVar.aJT;
            if (quickImInputData == null || (list2 = quickImInputData.originTexts) == null || list2.isEmpty()) {
                return null;
            }
            return list2;
        }
        return list;
    }

    private String[] NP() {
        return new String[]{"66666", "牛批牛批", "赤道以北，主播最美", "全民女神", "哈哈哈哈哈哈", "扎心了", "老铁，走一个", "请开始你的表演"};
    }

    private void NQ() {
        if (this.bup == null) {
            this.bup = new CustomMessageListener(2913122) { // from class: com.baidu.live.quick.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.bum != null && a.this.bum.isShowing()) {
                        a.this.bum.NV();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bup);
        }
    }

    private void NR() {
        if (this.bly == null) {
            this.bly = new CustomMessageListener(2913095) { // from class: com.baidu.live.quick.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                        String str = (String) customResponsedMessage.getData();
                        if (str == null) {
                            str = "";
                        }
                        a.this.mOtherParams = str;
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bly);
        }
    }

    private void NS() {
        if (this.bup != null) {
            MessageManager.getInstance().unRegisterListener(this.bup);
            this.bup = null;
        }
    }

    private void NT() {
        if (this.bly != null) {
            MessageManager.getInstance().unRegisterListener(this.bly);
        }
    }

    private void NU() {
        if (this.bdo != null) {
            MessageManager.getInstance().unRegisterListener(this.bdo);
        }
    }

    private void Gz() {
        if (this.bdo == null) {
            this.bdo = new CustomMessageListener(2913097) { // from class: com.baidu.live.quick.a.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.mDialog != null && a.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        a.this.mDialog.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bdo);
        }
    }
}
