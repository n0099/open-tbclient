package com.baidu.live.yuyinquick;

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
import com.baidu.live.gift.aj;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.data.YuyinImForbiddenStateData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.view.input.e;
import com.baidu.live.yuyinquick.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements e {
    private ci aGN;
    private e.a bYj;
    private a bYk;
    private int bdi;
    public CustomMessageListener bgy;
    private CustomMessageListener boC;
    private boolean bqg;
    private int bqh;
    private AlaLiveInfoData bqm;
    private String[] buo;
    private List<String> bup;
    private CustomMessageListener buq;
    private BdAlertDialog mDialog;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private int mPos;
    private String mText;
    private String mUserName;
    private String mVid;
    private int bqj = 0;
    public CustomMessageListener bon = new CustomMessageListener(2913193) { // from class: com.baidu.live.yuyinquick.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.bqj == 5) {
                if (customResponsedMessage.getData() instanceof YuyinImForbiddenStateData) {
                    YuyinImForbiddenStateData yuyinImForbiddenStateData = (YuyinImForbiddenStateData) customResponsedMessage.getData();
                    if (yuyinImForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_im_ban_no_net_tips));
                        return;
                    } else if (yuyinImForbiddenStateData.banState == 0) {
                        b.this.a(b.this.mPos, b.this.mText, b.this.aGN);
                    } else {
                        b.this.a(yuyinImForbiddenStateData);
                    }
                }
                b.this.bqj = 0;
            }
        }
    };

    @Override // com.baidu.live.view.input.e
    public void a(e.a aVar) {
        this.bYj = aVar;
    }

    @Override // com.baidu.live.view.input.e
    public void b(w wVar, String str) {
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

    @Override // com.baidu.live.view.input.e
    public void d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bYk = new a(this.mPageContext);
        this.bYk.a(new a.InterfaceC0250a() { // from class: com.baidu.live.yuyinquick.b.1
            @Override // com.baidu.live.yuyinquick.a.InterfaceC0250a
            public boolean Nh() {
                return b.this.bYj != null && b.this.bYj.Nh();
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0250a
            public void QM() {
                if (b.this.bYj != null) {
                    b.this.bYj.YJ();
                }
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0250a
            public void onDismiss() {
                if (b.this.bYj != null) {
                    b.this.bYj.YK();
                }
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0250a
            public void b(int i, String str, ci ciVar) {
                b.this.mPos = i;
                b.this.mText = str;
                b.this.aGN = ciVar;
                if (com.baidu.live.ae.a.RB().brA.aOy == 1 && !LoginManager.getInstance(b.this.mPageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.ae.a.RB().brA.aOx == 1) {
                    if (!b.this.bqg) {
                        b.this.a(i, str, ciVar);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    b.this.bqj = 5;
                } else {
                    b.this.a(i, str, ciVar);
                }
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0250a
            public boolean NR() {
                return b.this.bYj != null && b.this.bYj.NR();
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0250a
            public int Nm() {
                if (b.this.bYj != null) {
                    return b.this.bYj.Nm();
                }
                return 0;
            }
        });
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.bYk.a(QE(), OU());
            aj.hq("quick_im");
        }
    }

    private boolean OU() {
        return (this.bqm == null || this.bqm.mAlaLiveSwitchData == null || !this.bqm.mAlaLiveSwitchData.isYuyinPayBarrageUnabled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, ci ciVar) {
        if (this.bYj != null && this.bYj.Nh()) {
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
        this.bYk.dismiss();
        LogManager.getCommonLogger().doClickQuickImListLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
    }

    @Override // com.baidu.live.view.input.e
    public void b(boolean z, int i, int i2, String str) {
        this.bqg = z;
        this.bqh = i;
        this.bdi = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YuyinImForbiddenStateData yuyinImForbiddenStateData) {
        String format;
        final Activity pageActivity = this.mPageContext.getPageActivity();
        if (pageActivity != null) {
            if (yuyinImForbiddenStateData.globalBan == 1) {
                if (yuyinImForbiddenStateData.foreverInfo != null && yuyinImForbiddenStateData.foreverInfo.bpe == 1) {
                    format = pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_block);
                } else {
                    format = String.format(pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_forever), yuyinImForbiddenStateData.foreverInfo.bpf);
                }
                this.mDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.mDialog.setMessage(format);
                this.mDialog.setPositiveButton(pageActivity.getResources().getString(a.h.ala_forbidden_words_btn_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.yuyinquick.b.3
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
                this.mDialog.setNegativeButton(pageActivity.getResources().getString(a.h.ala_forbidden_words_btn_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.yuyinquick.b.4
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
            } else if (yuyinImForbiddenStateData.anchorBan == 1) {
                BdUtilHelper.showToast(pageActivity, pageActivity.getResources().getString(a.h.ala_forbidden_words_is_block_2));
            } else if (yuyinImForbiddenStateData.liveBan == 1) {
                BdUtilHelper.showToast(pageActivity, pageActivity.getResources().getString(a.h.ala_forbidden_words_is_block_1));
            }
        }
    }

    @Override // com.baidu.live.view.input.e
    public List<String> QD() {
        QuickImInputData quickImInputData;
        List<String> list;
        if (this.bup == null) {
            this.bup = new ArrayList();
        }
        this.bup.clear();
        al alVar = com.baidu.live.ae.a.RB().brA;
        if (alVar != null && (quickImInputData = alVar.aOd) != null && (list = quickImInputData.sortedTexts) != null && !list.isEmpty()) {
            this.bup.addAll(list);
        }
        if (this.bup.isEmpty()) {
            Collections.addAll(this.bup, QE());
        }
        return this.bup;
    }

    @Override // com.baidu.live.view.input.e
    public void hC(String str) {
        if (!TextUtils.isEmpty(str) && this.bup != null && !this.bup.isEmpty() && this.bup.indexOf(str) > 1) {
            if (this.bup.remove(str)) {
                this.bup.add(1, str);
            }
            al alVar = com.baidu.live.ae.a.RB().brA;
            if (alVar != null) {
                QuickImInputData quickImInputData = alVar.aOd;
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

    @Override // com.baidu.live.view.input.e
    public void IB() {
        if (this.bYk != null) {
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.bYk.dismiss();
            }
            this.bYk = null;
            QJ();
            QK();
            MessageManager.getInstance().unRegisterListener(this.bon);
            QL();
        }
    }

    @Override // com.baidu.live.view.input.e
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
        QuickImInputData quickImInputData;
        List<String> list;
        al alVar = com.baidu.live.ae.a.RB().brA;
        if (alVar == null || (quickImInputData = alVar.aOd) == null || (list = quickImInputData.originTexts) == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    private String[] QG() {
        return new String[]{"终于等到你", "这个声音我爱了", "活捉一只小可爱", "我耳朵都要怀孕了", "求交往", "小姐姐声音真好听"};
    }

    private void QH() {
        if (this.buq == null) {
            this.buq = new CustomMessageListener(2913122) { // from class: com.baidu.live.yuyinquick.b.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (b.this.bYk != null && b.this.bYk.isShowing()) {
                        b.this.bYk.QN();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.buq);
        }
    }

    private void QI() {
        if (this.boC == null) {
            this.boC = new CustomMessageListener(2913095) { // from class: com.baidu.live.yuyinquick.b.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                        String str = (String) customResponsedMessage.getData();
                        if (str == null) {
                            str = "";
                        }
                        b.this.mOtherParams = str;
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
            this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyinquick.b.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (b.this.mDialog != null && b.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        b.this.mDialog.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bgy);
        }
    }
}
