package com.baidu.live.quick;

import android.app.Activity;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.QuickImInputData;
import com.baidu.live.data.al;
import com.baidu.live.data.ci;
import com.baidu.live.data.w;
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
import com.baidu.live.view.input.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements d {
    private ci aGN;
    private int bdi;
    public CustomMessageListener bgy;
    private CustomMessageListener boC;
    private boolean bqg;
    private int bqh;
    private AlaLiveInfoData bqm;
    private d.a bum;
    private b bun;
    private String[] buo;
    private List<String> bup;
    private CustomMessageListener buq;
    private w bur;
    private BdAlertDialog mDialog;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private int mPos;
    private String mText;
    private String mUserName;
    private String mVid;
    private int bqj = 0;
    public CustomMessageListener bon = new CustomMessageListener(2913193) { // from class: com.baidu.live.quick.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && a.this.bqj == 5) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        a.this.a(a.this.mPos, a.this.mText, a.this.aGN);
                    } else {
                        a.this.a(imForbiddenStateData);
                    }
                }
                a.this.bqj = 0;
            }
        }
    };

    @Override // com.baidu.live.view.input.d
    public void a(d.a aVar) {
        this.bum = aVar;
    }

    @Override // com.baidu.live.view.input.d
    public void b(w wVar, String str) {
        this.bur = wVar;
        if (wVar != null) {
            this.bqm = wVar.mLiveInfo;
        }
        this.mVid = "";
        if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.feed_id != null) {
            this.mVid = wVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        QH();
        QI();
        MessageManager.getInstance().registerListener(this.bon);
        KU();
    }

    @Override // com.baidu.live.view.input.d
    public void d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bun = new b(this.mPageContext);
        this.bun.a(new b.a() { // from class: com.baidu.live.quick.a.1
            @Override // com.baidu.live.quick.b.a
            public boolean Nh() {
                return a.this.bum != null && a.this.bum.Nh();
            }

            @Override // com.baidu.live.quick.b.a
            public void QM() {
                if (a.this.bum != null) {
                    a.this.bum.YJ();
                }
            }

            @Override // com.baidu.live.quick.b.a
            public void onDismiss() {
                if (a.this.bum != null) {
                    a.this.bum.YK();
                }
            }

            @Override // com.baidu.live.quick.b.a
            public void b(int i, String str, ci ciVar) {
                a.this.mPos = i;
                a.this.mText = str;
                a.this.aGN = ciVar;
                if (com.baidu.live.ae.a.RB().brA.aOy == 1 && !LoginManager.getInstance(a.this.mPageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.ae.a.RB().brA.aOx == 1) {
                    if (!a.this.bqg) {
                        a.this.a(i, str, ciVar);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    a.this.bqj = 5;
                } else {
                    a.this.a(i, str, ciVar);
                }
            }

            @Override // com.baidu.live.quick.b.a
            public boolean NR() {
                return a.this.bum != null && a.this.bum.NR();
            }

            @Override // com.baidu.live.quick.b.a
            public int Nm() {
                if (a.this.bum != null) {
                    return a.this.bum.Nm();
                }
                return 0;
            }
        });
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.bun.a(QE(), OU());
            ac.hq("quick_im");
        }
    }

    private boolean OU() {
        return (this.bqm == null || this.bqm.mAlaLiveSwitchData == null || !this.bqm.mAlaLiveSwitchData.isPayBarrageUnabled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, ci ciVar) {
        if (this.bum != null && this.bum.Nh()) {
            ImSendMsgData imSendMsgData = new ImSendMsgData(str);
            if (ciVar != null) {
                imSendMsgData.msgType = (short) 126;
                imSendMsgData.barrageType = ciVar.type;
                imSendMsgData.barrageId = ciVar.id;
                imSendMsgData.price = ciVar.price;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
        }
        hC(str);
        this.bun.dismiss();
        LogManager.getCommonLogger().doClickQuickImListLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
    }

    @Override // com.baidu.live.view.input.d
    public void b(boolean z, int i, int i2, String str) {
        this.bqg = z;
        this.bqh = i;
        this.bdi = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.mPageContext.getPageActivity();
        if (pageActivity != null) {
            if (imForbiddenStateData.globalBan == 1) {
                if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bpe == 1) {
                    format = pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_block);
                } else {
                    format = String.format(pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bpf);
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
    public void dX(int i) {
        if (this.bun != null && this.bun.isShowing()) {
            this.bun.dX(i);
        }
    }

    @Override // com.baidu.live.view.input.d
    public List<String> QD() {
        al alVar;
        QuickImInputData quickImInputData;
        List<String> list;
        List<String> list2;
        if (this.bup == null) {
            this.bup = new ArrayList();
        } else {
            this.bup.clear();
        }
        if (this.bur != null && this.bur.aKO != null && (list2 = this.bur.aKO.sortedTexts) != null && !list2.isEmpty()) {
            this.bup.addAll(list2);
        }
        if (this.bup.isEmpty() && (alVar = com.baidu.live.ae.a.RB().brA) != null && (quickImInputData = alVar.aOc) != null && (list = quickImInputData.sortedTexts) != null && !list.isEmpty()) {
            this.bup.addAll(list);
        }
        if (this.bup.isEmpty()) {
            Collections.addAll(this.bup, QE());
        }
        return this.bup;
    }

    @Override // com.baidu.live.view.input.d
    public void hC(String str) {
        List<String> list;
        if (!TextUtils.isEmpty(str) && this.bup != null && !this.bup.isEmpty() && this.bup.indexOf(str) > 1) {
            if (this.bup.remove(str)) {
                this.bup.add(1, str);
            }
            if (this.bur != null && this.bur.aKO != null && (list = this.bur.aKO.sortedTexts) != null && !list.isEmpty()) {
                list.clear();
                list.addAll(this.bup);
                return;
            }
            al alVar = com.baidu.live.ae.a.RB().brA;
            if (alVar != null) {
                QuickImInputData quickImInputData = alVar.aOc;
                if (quickImInputData == null) {
                    quickImInputData = new QuickImInputData();
                }
                if (quickImInputData.sortedTexts == null) {
                    quickImInputData.sortedTexts = new ArrayList();
                }
                quickImInputData.sortedTexts.clear();
                quickImInputData.sortedTexts.addAll(this.bup);
            }
        }
    }

    @Override // com.baidu.live.view.input.d
    public void IB() {
        if (this.bun != null) {
            if (this.bup != null) {
                this.bup.clear();
            }
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.bun.dismiss();
            }
            this.bun = null;
            QJ();
            QK();
            MessageManager.getInstance().unRegisterListener(this.bon);
            QL();
        }
    }

    @Override // com.baidu.live.view.input.d
    public void release() {
        IB();
    }

    private String[] QE() {
        if (this.buo == null || this.buo.length == 0) {
            List<String> QF = QF();
            if (QF != null && !QF.isEmpty()) {
                this.buo = (String[]) QF.toArray(new String[QF.size()]);
            } else {
                this.buo = QG();
            }
        }
        return this.buo;
    }

    private List<String> QF() {
        List<String> list;
        List<String> list2;
        ArrayList arrayList = new ArrayList();
        if (this.bur == null || this.bur.aKO == null || (list = this.bur.aKO.sortedTexts) == null || list.isEmpty()) {
            list = arrayList;
        }
        if (list == null || list.isEmpty()) {
            al alVar = com.baidu.live.ae.a.RB().brA;
            if (alVar == null) {
                return null;
            }
            QuickImInputData quickImInputData = alVar.aOc;
            if (quickImInputData == null || (list2 = quickImInputData.originTexts) == null || list2.isEmpty()) {
                return null;
            }
            return list2;
        }
        return list;
    }

    private String[] QG() {
        return new String[]{"66666", "牛批牛批", "赤道以北，主播最美", "全民女神", "哈哈哈哈哈哈", "扎心了", "老铁，走一个", "请开始你的表演"};
    }

    private void QH() {
        if (this.buq == null) {
            this.buq = new CustomMessageListener(2913122) { // from class: com.baidu.live.quick.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.bun != null && a.this.bun.isShowing()) {
                        a.this.bun.QN();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.buq);
        }
    }

    private void QI() {
        if (this.boC == null) {
            this.boC = new CustomMessageListener(2913095) { // from class: com.baidu.live.quick.a.6
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
            MessageManager.getInstance().registerListener(this.boC);
        }
    }

    private void QJ() {
        if (this.buq != null) {
            MessageManager.getInstance().unRegisterListener(this.buq);
            this.buq = null;
        }
    }

    private void QK() {
        if (this.boC != null) {
            MessageManager.getInstance().unRegisterListener(this.boC);
        }
    }

    private void QL() {
        if (this.bgy != null) {
            MessageManager.getInstance().unRegisterListener(this.bgy);
        }
    }

    private void KU() {
        if (this.bgy == null) {
            this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.live.quick.a.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.mDialog != null && a.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        a.this.mDialog.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bgy);
        }
    }
}
