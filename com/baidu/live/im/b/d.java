package com.baidu.live.im.b;

import android.app.Activity;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.QuickImInputData;
import com.baidu.live.data.bj;
import com.baidu.live.data.q;
import com.baidu.live.data.y;
import com.baidu.live.gift.v;
import com.baidu.live.im.data.ImForbiddenStateData;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.view.quick.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.u.a;
import com.baidu.live.view.input.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public class d implements com.baidu.live.view.input.c {
    private int aJP;
    public CustomMessageListener aMA;
    private CustomMessageListener aSV;
    private c.a aTm;
    private com.baidu.live.im.view.quick.a aTn;
    private String[] aTo;
    private List<String> aTp;
    private CustomMessageListener aTq;
    private bj aTr;
    private boolean aTs;
    private int aTt;
    private int aTu = 0;
    public CustomMessageListener aTv = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.b.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.aTu == 5) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(d.this.mPageContext.getPageActivity(), d.this.mPageContext.getPageActivity().getResources().getString(a.i.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        d.this.a(d.this.mPos, d.this.mText, d.this.aTr);
                    } else {
                        d.this.a(imForbiddenStateData);
                    }
                }
                d.this.aTu = 0;
            }
        }
    };
    private BdAlertDialog mDialog;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private int mPos;
    private String mText;
    private String mUserName;
    private String mVid;

    @Override // com.baidu.live.view.input.c
    public void a(c.a aVar) {
        this.aTm = aVar;
    }

    @Override // com.baidu.live.view.input.c
    public void a(q qVar, String str) {
        this.mVid = "";
        if (qVar != null && qVar.mLiveInfo != null && qVar.mLiveInfo.feed_id != null) {
            this.mVid = qVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        Du();
        Dv();
        MessageManager.getInstance().registerListener(this.aTv);
        AF();
    }

    @Override // com.baidu.live.view.input.c
    public void c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aTn = new com.baidu.live.im.view.quick.a(this.mPageContext.getPageActivity());
        this.aTn.a(new a.InterfaceC0166a() { // from class: com.baidu.live.im.b.d.1
            @Override // com.baidu.live.im.view.quick.a.InterfaceC0166a
            public boolean CC() {
                return d.this.aTm != null && d.this.aTm.CC();
            }

            @Override // com.baidu.live.im.view.quick.a.InterfaceC0166a
            public void Dz() {
                if (d.this.aTm != null) {
                    d.this.aTm.JA();
                }
            }

            @Override // com.baidu.live.im.view.quick.a.InterfaceC0166a
            public void onDismiss() {
                if (d.this.aTm != null) {
                    d.this.aTm.JB();
                }
            }

            @Override // com.baidu.live.im.view.quick.a.InterfaceC0166a
            public void b(int i, String str, bj bjVar) {
                d.this.mPos = i;
                d.this.mText = str;
                d.this.aTr = bjVar;
                if (com.baidu.live.v.a.Ge().aWF.ayB == 1 && !LoginManager.getInstance(d.this.mPageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(d.this.mPageContext.getPageActivity(), d.this.mPageContext.getPageActivity().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.v.a.Ge().aWF.ayA == 1) {
                    if (!d.this.aTs) {
                        d.this.a(i, str, bjVar);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    d.this.aTu = 5;
                } else {
                    d.this.a(i, str, bjVar);
                }
            }

            @Override // com.baidu.live.im.view.quick.a.InterfaceC0166a
            public boolean DA() {
                return d.this.aTm != null && d.this.aTm.DA();
            }

            @Override // com.baidu.live.im.view.quick.a.InterfaceC0166a
            public int CH() {
                if (d.this.aTm != null) {
                    return d.this.aTm.CH();
                }
                return 0;
            }
        });
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.aTn.l(Dr());
            v.eN("quick_im");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, bj bjVar) {
        if (this.aTm != null && this.aTm.CC()) {
            ImSendMsgData imSendMsgData = new ImSendMsgData(str);
            if (bjVar != null) {
                imSendMsgData.msgType = (short) 126;
                imSendMsgData.barrageType = bjVar.type;
                imSendMsgData.barrageId = bjVar.id;
                imSendMsgData.price = bjVar.price;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
        }
        eW(str);
        this.aTn.dismiss();
        LogManager.getCommonLogger().doClickQuickImListLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
    }

    @Override // com.baidu.live.view.input.c
    public void b(boolean z, int i, int i2, String str) {
        this.aTs = z;
        this.aTt = i;
        this.aJP = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.mPageContext.getPageActivity();
        if (pageActivity != null) {
            if (imForbiddenStateData.globalBan == 1) {
                if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.aTF == 1) {
                    format = pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_block);
                } else {
                    format = String.format(pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.aTG);
                }
                this.mDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.mDialog.setMessage(format);
                this.mDialog.setPositiveButton(pageActivity.getResources().getString(a.i.ala_forbidden_words_btn_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.im.b.d.3
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
                this.mDialog.setNegativeButton(pageActivity.getResources().getString(a.i.ala_forbidden_words_btn_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.im.b.d.4
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        bdAlertDialog.dismiss();
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.mDialog.setPositiveButtonTextColor(pageActivity.getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
                    this.mDialog.setNagetiveButtonTextColor(pageActivity.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                } else {
                    this.mDialog.setPositiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
                    this.mDialog.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
                }
                this.mDialog.create(this.mPageContext);
                this.mDialog.setCanceledOnTouchOutside(false);
                this.mDialog.show();
            } else if (imForbiddenStateData.anchorBan == 1) {
                BdUtilHelper.showToast(pageActivity, pageActivity.getResources().getString(a.i.ala_forbidden_words_is_block_2));
            } else if (imForbiddenStateData.liveBan == 1) {
                BdUtilHelper.showToast(pageActivity, pageActivity.getResources().getString(a.i.ala_forbidden_words_is_block_1));
            }
        }
    }

    @Override // com.baidu.live.view.input.c
    public void cs(int i) {
        if (this.aTn != null && this.aTn.isShowing()) {
            this.aTn.cs(i);
        }
    }

    @Override // com.baidu.live.view.input.c
    public List<String> Dq() {
        QuickImInputData quickImInputData;
        List<String> list;
        if (this.aTp == null) {
            this.aTp = new ArrayList();
        }
        this.aTp.clear();
        y yVar = com.baidu.live.v.a.Ge().aWF;
        if (yVar != null && (quickImInputData = yVar.ayh) != null && (list = quickImInputData.sortedTexts) != null && !list.isEmpty()) {
            this.aTp.addAll(list);
        }
        if (this.aTp.isEmpty()) {
            Collections.addAll(this.aTp, Dr());
        }
        return this.aTp;
    }

    @Override // com.baidu.live.view.input.c
    public void eW(String str) {
        if (!TextUtils.isEmpty(str) && this.aTp != null && !this.aTp.isEmpty() && this.aTp.indexOf(str) > 1) {
            if (this.aTp.remove(str)) {
                this.aTp.add(1, str);
            }
            y yVar = com.baidu.live.v.a.Ge().aWF;
            if (yVar != null) {
                QuickImInputData quickImInputData = yVar.ayh;
                if (quickImInputData == null) {
                    quickImInputData = new QuickImInputData();
                }
                if (quickImInputData.sortedTexts == null) {
                    quickImInputData.sortedTexts = new ArrayList();
                }
                quickImInputData.sortedTexts.clear();
                quickImInputData.sortedTexts.addAll(this.aTp);
            }
        }
    }

    @Override // com.baidu.live.view.input.c
    public void yw() {
        if (this.aTn != null) {
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.aTn.dismiss();
            }
            this.aTn = null;
            Dw();
            Dx();
            MessageManager.getInstance().unRegisterListener(this.aTv);
            Dy();
        }
    }

    @Override // com.baidu.live.view.input.c
    public void release() {
        yw();
    }

    private String[] Dr() {
        if (this.aTo == null || this.aTo.length == 0) {
            List<String> Ds = Ds();
            if (Ds != null && !Ds.isEmpty()) {
                this.aTo = (String[]) Ds.toArray(new String[Ds.size()]);
            } else {
                this.aTo = Dt();
            }
        }
        return this.aTo;
    }

    private List<String> Ds() {
        QuickImInputData quickImInputData;
        List<String> list;
        y yVar = com.baidu.live.v.a.Ge().aWF;
        if (yVar == null || (quickImInputData = yVar.ayh) == null || (list = quickImInputData.originTexts) == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    private String[] Dt() {
        return new String[]{"66666", "牛批牛批", "赤道以北，主播最美", "全民女神", "哈哈哈哈哈哈", "扎心了", "老铁，走一个", "请开始你的表演"};
    }

    private void Du() {
        if (this.aTq == null) {
            this.aTq = new CustomMessageListener(2913122) { // from class: com.baidu.live.im.b.d.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (d.this.aTn != null && d.this.aTn.isShowing()) {
                        d.this.aTn.EE();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.aTq);
        }
    }

    private void Dv() {
        if (this.aSV == null) {
            this.aSV = new CustomMessageListener(2913095) { // from class: com.baidu.live.im.b.d.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                        String str = (String) customResponsedMessage.getData();
                        if (str == null) {
                            str = "";
                        }
                        d.this.mOtherParams = str;
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.aSV);
        }
    }

    private void Dw() {
        if (this.aTq != null) {
            MessageManager.getInstance().unRegisterListener(this.aTq);
            this.aTq = null;
        }
    }

    private void Dx() {
        if (this.aSV != null) {
            MessageManager.getInstance().unRegisterListener(this.aSV);
        }
    }

    private void Dy() {
        if (this.aMA != null) {
            MessageManager.getInstance().unRegisterListener(this.aMA);
        }
    }

    private void AF() {
        if (this.aMA == null) {
            this.aMA = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.b.d.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (d.this.mDialog != null && d.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        d.this.mDialog.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.aMA);
        }
    }
}
