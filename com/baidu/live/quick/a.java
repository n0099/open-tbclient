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
import com.baidu.live.data.ak;
import com.baidu.live.data.cg;
import com.baidu.live.data.w;
import com.baidu.live.gift.aa;
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
    private cg aFS;
    private int bbu;
    public CustomMessageListener bek;
    private CustomMessageListener blw;
    private boolean bmI;
    private int bmJ;
    private AlaLiveInfoData bmO;
    private c.a bqN;
    private b bqO;
    private String[] bqP;
    private List<String> bqQ;
    private CustomMessageListener bqR;
    private w bqS;
    private BdAlertDialog mDialog;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private int mPos;
    private String mText;
    private String mUserName;
    private String mVid;
    private int bmL = 0;
    public CustomMessageListener bmQ = new CustomMessageListener(2913193) { // from class: com.baidu.live.quick.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && a.this.bmL == 5) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        a.this.a(a.this.mPos, a.this.mText, a.this.aFS);
                    } else {
                        a.this.a(imForbiddenStateData);
                    }
                }
                a.this.bmL = 0;
            }
        }
    };

    @Override // com.baidu.live.view.input.c
    public void a(c.a aVar) {
        this.bqN = aVar;
    }

    @Override // com.baidu.live.view.input.c
    public void b(w wVar, String str) {
        this.bqS = wVar;
        if (wVar != null) {
            this.bmO = wVar.mLiveInfo;
        }
        this.mVid = "";
        if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.feed_id != null) {
            this.mVid = wVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        OX();
        OY();
        MessageManager.getInstance().registerListener(this.bmQ);
        JC();
    }

    @Override // com.baidu.live.view.input.c
    public void d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bqO = new b(this.mPageContext);
        this.bqO.a(new b.a() { // from class: com.baidu.live.quick.a.1
            @Override // com.baidu.live.quick.b.a
            public boolean LM() {
                return a.this.bqN != null && a.this.bqN.LM();
            }

            @Override // com.baidu.live.quick.b.a
            public void Pc() {
                if (a.this.bqN != null) {
                    a.this.bqN.WS();
                }
            }

            @Override // com.baidu.live.quick.b.a
            public void onDismiss() {
                if (a.this.bqN != null) {
                    a.this.bqN.WT();
                }
            }

            @Override // com.baidu.live.quick.b.a
            public void b(int i, String str, cg cgVar) {
                a.this.mPos = i;
                a.this.mText = str;
                a.this.aFS = cgVar;
                if (com.baidu.live.aa.a.PQ().bod.aNo == 1 && !LoginManager.getInstance(a.this.mPageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.aa.a.PQ().bod.aNn == 1) {
                    if (!a.this.bmI) {
                        a.this.a(i, str, cgVar);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    a.this.bmL = 5;
                } else {
                    a.this.a(i, str, cgVar);
                }
            }

            @Override // com.baidu.live.quick.b.a
            public boolean Mn() {
                return a.this.bqN != null && a.this.bqN.Mn();
            }

            @Override // com.baidu.live.quick.b.a
            public int LR() {
                if (a.this.bqN != null) {
                    return a.this.bqN.LR();
                }
                return 0;
            }
        });
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.bqO.a(OU(), Ni());
            aa.hb("quick_im");
        }
    }

    private boolean Ni() {
        return (this.bmO == null || this.bmO.mAlaLiveSwitchData == null || !this.bmO.mAlaLiveSwitchData.isPayBarrageUnabled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, cg cgVar) {
        if (this.bqN != null && this.bqN.LM()) {
            ImSendMsgData imSendMsgData = new ImSendMsgData(str);
            if (cgVar != null) {
                imSendMsgData.msgType = (short) 126;
                imSendMsgData.barrageType = cgVar.type;
                imSendMsgData.barrageId = cgVar.id;
                imSendMsgData.price = cgVar.price;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
        }
        hn(str);
        this.bqO.dismiss();
        LogManager.getCommonLogger().doClickQuickImListLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
    }

    @Override // com.baidu.live.view.input.c
    public void b(boolean z, int i, int i2, String str) {
        this.bmI = z;
        this.bmJ = i;
        this.bbu = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.mPageContext.getPageActivity();
        if (pageActivity != null) {
            if (imForbiddenStateData.globalBan == 1) {
                if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.blL == 1) {
                    format = pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_block);
                } else {
                    format = String.format(pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.blM);
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

    @Override // com.baidu.live.view.input.c
    public void dI(int i) {
        if (this.bqO != null && this.bqO.isShowing()) {
            this.bqO.dI(i);
        }
    }

    @Override // com.baidu.live.view.input.c
    public List<String> OT() {
        ak akVar;
        QuickImInputData quickImInputData;
        List<String> list;
        List<String> list2;
        if (this.bqQ == null) {
            this.bqQ = new ArrayList();
        } else {
            this.bqQ.clear();
        }
        if (this.bqS != null && this.bqS.aJN != null && (list2 = this.bqS.aJN.sortedTexts) != null && !list2.isEmpty()) {
            this.bqQ.addAll(list2);
        }
        if (this.bqQ.isEmpty() && (akVar = com.baidu.live.aa.a.PQ().bod) != null && (quickImInputData = akVar.aMS) != null && (list = quickImInputData.sortedTexts) != null && !list.isEmpty()) {
            this.bqQ.addAll(list);
        }
        if (this.bqQ.isEmpty()) {
            Collections.addAll(this.bqQ, OU());
        }
        return this.bqQ;
    }

    @Override // com.baidu.live.view.input.c
    public void hn(String str) {
        List<String> list;
        if (!TextUtils.isEmpty(str) && this.bqQ != null && !this.bqQ.isEmpty() && this.bqQ.indexOf(str) > 1) {
            if (this.bqQ.remove(str)) {
                this.bqQ.add(1, str);
            }
            if (this.bqS != null && this.bqS.aJN != null && (list = this.bqS.aJN.sortedTexts) != null && !list.isEmpty()) {
                list.clear();
                list.addAll(this.bqQ);
                return;
            }
            ak akVar = com.baidu.live.aa.a.PQ().bod;
            if (akVar != null) {
                QuickImInputData quickImInputData = akVar.aMS;
                if (quickImInputData == null) {
                    quickImInputData = new QuickImInputData();
                }
                if (quickImInputData.sortedTexts == null) {
                    quickImInputData.sortedTexts = new ArrayList();
                }
                quickImInputData.sortedTexts.clear();
                quickImInputData.sortedTexts.addAll(this.bqQ);
            }
        }
    }

    @Override // com.baidu.live.view.input.c
    public void Ht() {
        if (this.bqO != null) {
            if (this.bqQ != null) {
                this.bqQ.clear();
            }
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.bqO.dismiss();
            }
            this.bqO = null;
            OZ();
            Pa();
            MessageManager.getInstance().unRegisterListener(this.bmQ);
            Pb();
        }
    }

    @Override // com.baidu.live.view.input.c
    public void release() {
        Ht();
    }

    private String[] OU() {
        if (this.bqP == null || this.bqP.length == 0) {
            List<String> OV = OV();
            if (OV != null && !OV.isEmpty()) {
                this.bqP = (String[]) OV.toArray(new String[OV.size()]);
            } else {
                this.bqP = OW();
            }
        }
        return this.bqP;
    }

    private List<String> OV() {
        List<String> list;
        List<String> list2;
        ArrayList arrayList = new ArrayList();
        if (this.bqS == null || this.bqS.aJN == null || (list = this.bqS.aJN.sortedTexts) == null || list.isEmpty()) {
            list = arrayList;
        }
        if (list == null || list.isEmpty()) {
            ak akVar = com.baidu.live.aa.a.PQ().bod;
            if (akVar == null) {
                return null;
            }
            QuickImInputData quickImInputData = akVar.aMS;
            if (quickImInputData == null || (list2 = quickImInputData.originTexts) == null || list2.isEmpty()) {
                return null;
            }
            return list2;
        }
        return list;
    }

    private String[] OW() {
        return new String[]{"66666", "牛批牛批", "赤道以北，主播最美", "全民女神", "哈哈哈哈哈哈", "扎心了", "老铁，走一个", "请开始你的表演"};
    }

    private void OX() {
        if (this.bqR == null) {
            this.bqR = new CustomMessageListener(2913122) { // from class: com.baidu.live.quick.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.bqO != null && a.this.bqO.isShowing()) {
                        a.this.bqO.Pd();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bqR);
        }
    }

    private void OY() {
        if (this.blw == null) {
            this.blw = new CustomMessageListener(2913095) { // from class: com.baidu.live.quick.a.6
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
            MessageManager.getInstance().registerListener(this.blw);
        }
    }

    private void OZ() {
        if (this.bqR != null) {
            MessageManager.getInstance().unRegisterListener(this.bqR);
            this.bqR = null;
        }
    }

    private void Pa() {
        if (this.blw != null) {
            MessageManager.getInstance().unRegisterListener(this.blw);
        }
    }

    private void Pb() {
        if (this.bek != null) {
            MessageManager.getInstance().unRegisterListener(this.bek);
        }
    }

    private void JC() {
        if (this.bek == null) {
            this.bek = new CustomMessageListener(2913097) { // from class: com.baidu.live.quick.a.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.mDialog != null && a.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        a.this.mDialog.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bek);
        }
    }
}
