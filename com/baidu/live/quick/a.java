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
import com.baidu.live.data.ag;
import com.baidu.live.data.bz;
import com.baidu.live.data.u;
import com.baidu.live.gift.w;
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
/* loaded from: classes4.dex */
public class a implements c {
    private bz aEU;
    private int aYE;
    public CustomMessageListener bbC;
    private CustomMessageListener biH;
    private boolean bjT;
    private int bjU;
    private AlaLiveInfoData bjZ;
    private c.a bnH;
    private b bnI;
    private String[] bnJ;
    private List<String> bnK;
    private CustomMessageListener bnL;
    private u bnM;
    private BdAlertDialog mDialog;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private int mPos;
    private String mText;
    private String mUserName;
    private String mVid;
    private int bjW = 0;
    public CustomMessageListener bkb = new CustomMessageListener(2913193) { // from class: com.baidu.live.quick.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && a.this.bjW == 5) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.this.mPageContext.getPageActivity().getResources().getString(a.i.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        a.this.a(a.this.mPos, a.this.mText, a.this.aEU);
                    } else {
                        a.this.a(imForbiddenStateData);
                    }
                }
                a.this.bjW = 0;
            }
        }
    };

    @Override // com.baidu.live.view.input.c
    public void a(c.a aVar) {
        this.bnH = aVar;
    }

    @Override // com.baidu.live.view.input.c
    public void b(u uVar, String str) {
        this.bnM = uVar;
        if (uVar != null) {
            this.bjZ = uVar.mLiveInfo;
        }
        this.mVid = "";
        if (uVar != null && uVar.mLiveInfo != null && uVar.mLiveInfo.feed_id != null) {
            this.mVid = uVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        NZ();
        Oa();
        MessageManager.getInstance().registerListener(this.bkb);
        II();
    }

    @Override // com.baidu.live.view.input.c
    public void d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bnI = new b(this.mPageContext);
        this.bnI.a(new b.a() { // from class: com.baidu.live.quick.a.1
            @Override // com.baidu.live.quick.b.a
            public boolean KS() {
                return a.this.bnH != null && a.this.bnH.KS();
            }

            @Override // com.baidu.live.quick.b.a
            public void Oe() {
                if (a.this.bnH != null) {
                    a.this.bnH.Ts();
                }
            }

            @Override // com.baidu.live.quick.b.a
            public void onDismiss() {
                if (a.this.bnH != null) {
                    a.this.bnH.Tt();
                }
            }

            @Override // com.baidu.live.quick.b.a
            public void b(int i, String str, bz bzVar) {
                a.this.mPos = i;
                a.this.mText = str;
                a.this.aEU = bzVar;
                if (com.baidu.live.x.a.OS().blo.aLK == 1 && !LoginManager.getInstance(a.this.mPageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.this.mPageContext.getPageActivity().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.x.a.OS().blo.aLJ == 1) {
                    if (!a.this.bjT) {
                        a.this.a(i, str, bzVar);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    a.this.bjW = 5;
                } else {
                    a.this.a(i, str, bzVar);
                }
            }

            @Override // com.baidu.live.quick.b.a
            public boolean Ls() {
                return a.this.bnH != null && a.this.bnH.Ls();
            }

            @Override // com.baidu.live.quick.b.a
            public int KX() {
                if (a.this.bnH != null) {
                    return a.this.bnH.KX();
                }
                return 0;
            }
        });
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.bnI.a(NW(), Mo());
            w.gL("quick_im");
        }
    }

    private boolean Mo() {
        return (this.bjZ == null || this.bjZ.mAlaLiveSwitchData == null || !this.bjZ.mAlaLiveSwitchData.isPayBarrageUnabled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, bz bzVar) {
        if (this.bnH != null && this.bnH.KS()) {
            ImSendMsgData imSendMsgData = new ImSendMsgData(str);
            if (bzVar != null) {
                imSendMsgData.msgType = (short) 126;
                imSendMsgData.barrageType = bzVar.type;
                imSendMsgData.barrageId = bzVar.id;
                imSendMsgData.price = bzVar.price;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
        }
        gV(str);
        this.bnI.dismiss();
        LogManager.getCommonLogger().doClickQuickImListLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
    }

    @Override // com.baidu.live.view.input.c
    public void b(boolean z, int i, int i2, String str) {
        this.bjT = z;
        this.bjU = i;
        this.aYE = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.mPageContext.getPageActivity();
        if (pageActivity != null) {
            if (imForbiddenStateData.globalBan == 1) {
                if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.biW == 1) {
                    format = pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_block);
                } else {
                    format = String.format(pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.biX);
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
    public void dI(int i) {
        if (this.bnI != null && this.bnI.isShowing()) {
            this.bnI.dI(i);
        }
    }

    @Override // com.baidu.live.view.input.c
    public List<String> NV() {
        ag agVar;
        QuickImInputData quickImInputData;
        List<String> list;
        List<String> list2;
        if (this.bnK == null) {
            this.bnK = new ArrayList();
        } else {
            this.bnK.clear();
        }
        if (this.bnM != null && this.bnM.aIx != null && (list2 = this.bnM.aIx.sortedTexts) != null && !list2.isEmpty()) {
            this.bnK.addAll(list2);
        }
        if (this.bnK.isEmpty() && (agVar = com.baidu.live.x.a.OS().blo) != null && (quickImInputData = agVar.aLo) != null && (list = quickImInputData.sortedTexts) != null && !list.isEmpty()) {
            this.bnK.addAll(list);
        }
        if (this.bnK.isEmpty()) {
            Collections.addAll(this.bnK, NW());
        }
        return this.bnK;
    }

    @Override // com.baidu.live.view.input.c
    public void gV(String str) {
        List<String> list;
        if (!TextUtils.isEmpty(str) && this.bnK != null && !this.bnK.isEmpty() && this.bnK.indexOf(str) > 1) {
            if (this.bnK.remove(str)) {
                this.bnK.add(1, str);
            }
            if (this.bnM != null && this.bnM.aIx != null && (list = this.bnM.aIx.sortedTexts) != null && !list.isEmpty()) {
                list.clear();
                list.addAll(this.bnK);
                return;
            }
            ag agVar = com.baidu.live.x.a.OS().blo;
            if (agVar != null) {
                QuickImInputData quickImInputData = agVar.aLo;
                if (quickImInputData == null) {
                    quickImInputData = new QuickImInputData();
                }
                if (quickImInputData.sortedTexts == null) {
                    quickImInputData.sortedTexts = new ArrayList();
                }
                quickImInputData.sortedTexts.clear();
                quickImInputData.sortedTexts.addAll(this.bnK);
            }
        }
    }

    @Override // com.baidu.live.view.input.c
    public void Gx() {
        if (this.bnI != null) {
            if (this.bnK != null) {
                this.bnK.clear();
            }
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.bnI.dismiss();
            }
            this.bnI = null;
            Ob();
            Oc();
            MessageManager.getInstance().unRegisterListener(this.bkb);
            Od();
        }
    }

    @Override // com.baidu.live.view.input.c
    public void release() {
        Gx();
    }

    private String[] NW() {
        if (this.bnJ == null || this.bnJ.length == 0) {
            List<String> NX = NX();
            if (NX != null && !NX.isEmpty()) {
                this.bnJ = (String[]) NX.toArray(new String[NX.size()]);
            } else {
                this.bnJ = NY();
            }
        }
        return this.bnJ;
    }

    private List<String> NX() {
        List<String> list;
        List<String> list2;
        ArrayList arrayList = new ArrayList();
        if (this.bnM == null || this.bnM.aIx == null || (list = this.bnM.aIx.sortedTexts) == null || list.isEmpty()) {
            list = arrayList;
        }
        if (list == null || list.isEmpty()) {
            ag agVar = com.baidu.live.x.a.OS().blo;
            if (agVar == null) {
                return null;
            }
            QuickImInputData quickImInputData = agVar.aLo;
            if (quickImInputData == null || (list2 = quickImInputData.originTexts) == null || list2.isEmpty()) {
                return null;
            }
            return list2;
        }
        return list;
    }

    private String[] NY() {
        return new String[]{"66666", "牛批牛批", "赤道以北，主播最美", "全民女神", "哈哈哈哈哈哈", "扎心了", "老铁，走一个", "请开始你的表演"};
    }

    private void NZ() {
        if (this.bnL == null) {
            this.bnL = new CustomMessageListener(2913122) { // from class: com.baidu.live.quick.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.bnI != null && a.this.bnI.isShowing()) {
                        a.this.bnI.Of();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bnL);
        }
    }

    private void Oa() {
        if (this.biH == null) {
            this.biH = new CustomMessageListener(2913095) { // from class: com.baidu.live.quick.a.6
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
            MessageManager.getInstance().registerListener(this.biH);
        }
    }

    private void Ob() {
        if (this.bnL != null) {
            MessageManager.getInstance().unRegisterListener(this.bnL);
            this.bnL = null;
        }
    }

    private void Oc() {
        if (this.biH != null) {
            MessageManager.getInstance().unRegisterListener(this.biH);
        }
    }

    private void Od() {
        if (this.bbC != null) {
            MessageManager.getInstance().unRegisterListener(this.bbC);
        }
    }

    private void II() {
        if (this.bbC == null) {
            this.bbC = new CustomMessageListener(2913097) { // from class: com.baidu.live.quick.a.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.mDialog != null && a.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        a.this.mDialog.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bbC);
        }
    }
}
