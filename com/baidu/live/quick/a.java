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
import com.baidu.live.data.ab;
import com.baidu.live.data.br;
import com.baidu.live.data.r;
import com.baidu.live.gift.v;
import com.baidu.live.im.data.ImForbiddenStateData;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.quick.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.view.input.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class a implements c {
    private br aBh;
    private int aTd;
    public CustomMessageListener aVN;
    private CustomMessageListener bci;
    private boolean bdm;
    private int bdn;
    private AlaLiveInfoData bds;
    private c.a bgS;
    private b bgT;
    private String[] bgU;
    private List<String> bgV;
    private CustomMessageListener bgW;
    private r bgX;
    private BdAlertDialog mDialog;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private int mPos;
    private String mText;
    private String mUserName;
    private String mVid;
    private int bdp = 0;
    public CustomMessageListener bdu = new CustomMessageListener(2913193) { // from class: com.baidu.live.quick.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && a.this.bdp == 5) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.this.mPageContext.getPageActivity().getResources().getString(a.i.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        a.this.a(a.this.mPos, a.this.mText, a.this.aBh);
                    } else {
                        a.this.a(imForbiddenStateData);
                    }
                }
                a.this.bdp = 0;
            }
        }
    };

    @Override // com.baidu.live.view.input.c
    public void a(c.a aVar) {
        this.bgS = aVar;
    }

    @Override // com.baidu.live.view.input.c
    public void b(r rVar, String str) {
        this.bgX = rVar;
        if (rVar != null) {
            this.bds = rVar.mLiveInfo;
        }
        this.mVid = "";
        if (rVar != null && rVar.mLiveInfo != null && rVar.mLiveInfo.feed_id != null) {
            this.mVid = rVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        Mm();
        Mn();
        MessageManager.getInstance().registerListener(this.bdu);
        Hk();
    }

    @Override // com.baidu.live.view.input.c
    public void d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bgT = new b(this.mPageContext);
        this.bgT.a(new b.a() { // from class: com.baidu.live.quick.a.1
            @Override // com.baidu.live.quick.b.a
            public boolean Ji() {
                return a.this.bgS != null && a.this.bgS.Ji();
            }

            @Override // com.baidu.live.quick.b.a
            public void Mr() {
                if (a.this.bgS != null) {
                    a.this.bgS.QQ();
                }
            }

            @Override // com.baidu.live.quick.b.a
            public void onDismiss() {
                if (a.this.bgS != null) {
                    a.this.bgS.QR();
                }
            }

            @Override // com.baidu.live.quick.b.a
            public void b(int i, String str, br brVar) {
                a.this.mPos = i;
                a.this.mText = str;
                a.this.aBh = brVar;
                if (com.baidu.live.w.a.Nk().beH.aHn == 1 && !LoginManager.getInstance(a.this.mPageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.this.mPageContext.getPageActivity().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.w.a.Nk().beH.aHm == 1) {
                    if (!a.this.bdm) {
                        a.this.a(i, str, brVar);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    a.this.bdp = 5;
                } else {
                    a.this.a(i, str, brVar);
                }
            }

            @Override // com.baidu.live.quick.b.a
            public boolean JJ() {
                return a.this.bgS != null && a.this.bgS.JJ();
            }

            @Override // com.baidu.live.quick.b.a
            public int Jn() {
                if (a.this.bgS != null) {
                    return a.this.bgS.Jn();
                }
                return 0;
            }
        });
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.bgT.a(Mj(), KC());
            v.gm("quick_im");
        }
    }

    private boolean KC() {
        return (this.bds == null || this.bds.mAlaLiveSwitchData == null || !this.bds.mAlaLiveSwitchData.isPayBarrageUnabled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, br brVar) {
        if (this.bgS != null && this.bgS.Ji()) {
            ImSendMsgData imSendMsgData = new ImSendMsgData(str);
            if (brVar != null) {
                imSendMsgData.msgType = (short) 126;
                imSendMsgData.barrageType = brVar.type;
                imSendMsgData.barrageId = brVar.id;
                imSendMsgData.price = brVar.price;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
        }
        gw(str);
        this.bgT.dismiss();
        LogManager.getCommonLogger().doClickQuickImListLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
    }

    @Override // com.baidu.live.view.input.c
    public void b(boolean z, int i, int i2, String str) {
        this.bdm = z;
        this.bdn = i;
        this.aTd = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.mPageContext.getPageActivity();
        if (pageActivity != null) {
            if (imForbiddenStateData.globalBan == 1) {
                if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bcw == 1) {
                    format = pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_block);
                } else {
                    format = String.format(pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bcx);
                }
                this.mDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.mDialog.setMessage(format);
                this.mDialog.setPositiveButton(pageActivity.getResources().getString(a.i.ala_forbidden_words_btn_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.quick.a.3
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
                this.mDialog.setNegativeButton(pageActivity.getResources().getString(a.i.ala_forbidden_words_btn_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.quick.a.4
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
    public void dz(int i) {
        if (this.bgT != null && this.bgT.isShowing()) {
            this.bgT.dz(i);
        }
    }

    @Override // com.baidu.live.view.input.c
    public List<String> Mi() {
        ab abVar;
        QuickImInputData quickImInputData;
        List<String> list;
        List<String> list2;
        if (this.bgV == null) {
            this.bgV = new ArrayList();
        } else {
            this.bgV.clear();
        }
        if (this.bgX != null && this.bgX.aEs != null && (list2 = this.bgX.aEs.sortedTexts) != null && !list2.isEmpty()) {
            this.bgV.addAll(list2);
        }
        if (this.bgV.isEmpty() && (abVar = com.baidu.live.w.a.Nk().beH) != null && (quickImInputData = abVar.aGT) != null && (list = quickImInputData.sortedTexts) != null && !list.isEmpty()) {
            this.bgV.addAll(list);
        }
        if (this.bgV.isEmpty()) {
            Collections.addAll(this.bgV, Mj());
        }
        return this.bgV;
    }

    @Override // com.baidu.live.view.input.c
    public void gw(String str) {
        List<String> list;
        if (!TextUtils.isEmpty(str) && this.bgV != null && !this.bgV.isEmpty() && this.bgV.indexOf(str) > 1) {
            if (this.bgV.remove(str)) {
                this.bgV.add(1, str);
            }
            if (this.bgX != null && this.bgX.aEs != null && (list = this.bgX.aEs.sortedTexts) != null && !list.isEmpty()) {
                list.clear();
                list.addAll(this.bgV);
                return;
            }
            ab abVar = com.baidu.live.w.a.Nk().beH;
            if (abVar != null) {
                QuickImInputData quickImInputData = abVar.aGT;
                if (quickImInputData == null) {
                    quickImInputData = new QuickImInputData();
                }
                if (quickImInputData.sortedTexts == null) {
                    quickImInputData.sortedTexts = new ArrayList();
                }
                quickImInputData.sortedTexts.clear();
                quickImInputData.sortedTexts.addAll(this.bgV);
            }
        }
    }

    @Override // com.baidu.live.view.input.c
    public void Fb() {
        if (this.bgT != null) {
            if (this.bgV != null) {
                this.bgV.clear();
            }
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.bgT.dismiss();
            }
            this.bgT = null;
            Mo();
            Mp();
            MessageManager.getInstance().unRegisterListener(this.bdu);
            Mq();
        }
    }

    @Override // com.baidu.live.view.input.c
    public void release() {
        Fb();
    }

    private String[] Mj() {
        if (this.bgU == null || this.bgU.length == 0) {
            List<String> Mk = Mk();
            if (Mk != null && !Mk.isEmpty()) {
                this.bgU = (String[]) Mk.toArray(new String[Mk.size()]);
            } else {
                this.bgU = Ml();
            }
        }
        return this.bgU;
    }

    private List<String> Mk() {
        List<String> list;
        List<String> list2;
        ArrayList arrayList = new ArrayList();
        if (this.bgX == null || this.bgX.aEs == null || (list = this.bgX.aEs.sortedTexts) == null || list.isEmpty()) {
            list = arrayList;
        }
        if (list == null || list.isEmpty()) {
            ab abVar = com.baidu.live.w.a.Nk().beH;
            if (abVar == null) {
                return null;
            }
            QuickImInputData quickImInputData = abVar.aGT;
            if (quickImInputData == null || (list2 = quickImInputData.originTexts) == null || list2.isEmpty()) {
                return null;
            }
            return list2;
        }
        return list;
    }

    private String[] Ml() {
        return new String[]{"66666", "牛批牛批", "赤道以北，主播最美", "全民女神", "哈哈哈哈哈哈", "扎心了", "老铁，走一个", "请开始你的表演"};
    }

    private void Mm() {
        if (this.bgW == null) {
            this.bgW = new CustomMessageListener(2913122) { // from class: com.baidu.live.quick.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.bgT != null && a.this.bgT.isShowing()) {
                        a.this.bgT.Ms();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bgW);
        }
    }

    private void Mn() {
        if (this.bci == null) {
            this.bci = new CustomMessageListener(2913095) { // from class: com.baidu.live.quick.a.6
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
            MessageManager.getInstance().registerListener(this.bci);
        }
    }

    private void Mo() {
        if (this.bgW != null) {
            MessageManager.getInstance().unRegisterListener(this.bgW);
            this.bgW = null;
        }
    }

    private void Mp() {
        if (this.bci != null) {
            MessageManager.getInstance().unRegisterListener(this.bci);
        }
    }

    private void Mq() {
        if (this.aVN != null) {
            MessageManager.getInstance().unRegisterListener(this.aVN);
        }
    }

    private void Hk() {
        if (this.aVN == null) {
            this.aVN = new CustomMessageListener(2913097) { // from class: com.baidu.live.quick.a.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.mDialog != null && a.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        a.this.mDialog.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.aVN);
        }
    }
}
