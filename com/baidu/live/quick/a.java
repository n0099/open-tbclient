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
/* loaded from: classes11.dex */
public class a implements d {
    private ck aHe;
    private int beT;
    public CustomMessageListener bih;
    private CustomMessageListener bql;
    private boolean brO;
    private int brQ;
    private AlaLiveInfoData brX;
    private d.a byX;
    private b byY;
    private String[] byZ;
    private List<String> bza;
    private CustomMessageListener bzb;
    private x bzc;
    private BdAlertDialog mDialog;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private int mPos;
    private String mText;
    private String mUserName;
    private String mVid;
    private int brS = 0;
    public CustomMessageListener bpW = new CustomMessageListener(2913193) { // from class: com.baidu.live.quick.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && a.this.brS == 5) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        a.this.a(a.this.mPos, a.this.mText, a.this.aHe);
                    } else {
                        a.this.a(imForbiddenStateData);
                    }
                }
                a.this.brS = 0;
            }
        }
    };

    @Override // com.baidu.live.view.input.d
    public void a(d.a aVar) {
        this.byX = aVar;
    }

    @Override // com.baidu.live.view.input.d
    public void b(x xVar, String str) {
        this.bzc = xVar;
        if (xVar != null) {
            this.brX = xVar.mLiveInfo;
        }
        this.mVid = "";
        if (xVar != null && xVar.mLiveInfo != null && xVar.mLiveInfo.feed_id != null) {
            this.mVid = xVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        RL();
        RM();
        MessageManager.getInstance().registerListener(this.bpW);
        Ku();
    }

    @Override // com.baidu.live.view.input.d
    public void d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.byY = new b(this.mPageContext);
        this.byY.a(new b.a() { // from class: com.baidu.live.quick.a.1
            @Override // com.baidu.live.quick.b.a
            public boolean ME() {
                return a.this.byX != null && a.this.byX.ME();
            }

            @Override // com.baidu.live.quick.b.a
            public void onShow() {
                if (a.this.byX != null) {
                    a.this.byX.aaa();
                }
            }

            @Override // com.baidu.live.quick.b.a
            public void onDismiss() {
                if (a.this.byX != null) {
                    a.this.byX.aab();
                }
            }

            @Override // com.baidu.live.quick.b.a
            public void b(int i, String str, ck ckVar) {
                a.this.mPos = i;
                a.this.mText = str;
                a.this.aHe = ckVar;
                if (com.baidu.live.af.a.SE().bwi.aPf == 1 && !LoginManager.getInstance(a.this.mPageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.af.a.SE().bwi.aPe == 1) {
                    if (!a.this.brO) {
                        a.this.a(i, str, ckVar);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    a.this.brS = 5;
                } else {
                    a.this.a(i, str, ckVar);
                }
            }

            @Override // com.baidu.live.quick.b.a
            public boolean Nt() {
                return a.this.byX != null && a.this.byX.Nt();
            }

            @Override // com.baidu.live.quick.b.a
            public int MK() {
                if (a.this.byX != null) {
                    return a.this.byX.MK();
                }
                return 0;
            }

            @Override // com.baidu.live.quick.b.a
            public boolean ML() {
                return a.this.byX != null && a.this.byX.ML();
            }
        });
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.byY.a(RI(), Oz());
            ac.hb("quick_im");
        }
    }

    private boolean Oz() {
        return (this.brX == null || this.brX.mAlaLiveSwitchData == null || !this.brX.mAlaLiveSwitchData.isPayBarrageUnabled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, ck ckVar) {
        if (this.byX != null && this.byX.ME()) {
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
        hn(str);
        this.byY.dismiss();
        LogManager.getCommonLogger().doClickQuickImListLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("msg", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_QUICK_CLICK).setContentExt(null, "popup", "in", jSONObject));
    }

    @Override // com.baidu.live.view.input.d
    public void b(boolean z, int i, int i2, String str) {
        this.brO = z;
        this.brQ = i;
        this.beT = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.mPageContext.getPageActivity();
        if (pageActivity != null) {
            if (imForbiddenStateData.globalBan == 1) {
                if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bqL == 1) {
                    format = pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_block);
                } else {
                    format = String.format(pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bqM);
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
    public void dU(int i) {
        if (this.byY != null && this.byY.isShowing()) {
            this.byY.dU(i);
        }
    }

    @Override // com.baidu.live.view.input.d
    public List<String> RH() {
        an anVar;
        QuickImInputData quickImInputData;
        List<String> list;
        List<String> list2;
        if (this.bza == null) {
            this.bza = new ArrayList();
        } else {
            this.bza.clear();
        }
        if (this.bzc != null && this.bzc.aLo != null && (list2 = this.bzc.aLo.sortedTexts) != null && !list2.isEmpty()) {
            this.bza.addAll(list2);
        }
        if (this.bza.isEmpty() && (anVar = com.baidu.live.af.a.SE().bwi) != null && (quickImInputData = anVar.aOG) != null && (list = quickImInputData.sortedTexts) != null && !list.isEmpty()) {
            this.bza.addAll(list);
        }
        if (this.bza.isEmpty()) {
            Collections.addAll(this.bza, RI());
        }
        return this.bza;
    }

    @Override // com.baidu.live.view.input.d
    public void hn(String str) {
        List<String> list;
        if (!TextUtils.isEmpty(str) && this.bza != null && !this.bza.isEmpty() && this.bza.indexOf(str) > 1) {
            if (this.bza.remove(str)) {
                this.bza.add(1, str);
            }
            if (this.bzc != null && this.bzc.aLo != null && (list = this.bzc.aLo.sortedTexts) != null && !list.isEmpty()) {
                list.clear();
                list.addAll(this.bza);
                return;
            }
            an anVar = com.baidu.live.af.a.SE().bwi;
            if (anVar != null) {
                QuickImInputData quickImInputData = anVar.aOG;
                if (quickImInputData == null) {
                    quickImInputData = new QuickImInputData();
                }
                if (quickImInputData.sortedTexts == null) {
                    quickImInputData.sortedTexts = new ArrayList();
                }
                quickImInputData.sortedTexts.clear();
                quickImInputData.sortedTexts.addAll(this.bza);
            }
        }
    }

    @Override // com.baidu.live.view.input.d
    public void Id() {
        if (this.byY != null) {
            if (this.bza != null) {
                this.bza.clear();
            }
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.byY.dismiss();
            }
            this.byY = null;
            RN();
            RO();
            MessageManager.getInstance().unRegisterListener(this.bpW);
            RP();
        }
    }

    @Override // com.baidu.live.view.input.d
    public void release() {
        Id();
    }

    private String[] RI() {
        if (this.byZ == null || this.byZ.length == 0) {
            List<String> RJ = RJ();
            if (RJ != null && !RJ.isEmpty()) {
                this.byZ = (String[]) RJ.toArray(new String[RJ.size()]);
            } else {
                this.byZ = RK();
            }
        }
        return this.byZ;
    }

    private List<String> RJ() {
        List<String> list;
        List<String> list2;
        ArrayList arrayList = new ArrayList();
        if (this.bzc == null || this.bzc.aLo == null || (list = this.bzc.aLo.sortedTexts) == null || list.isEmpty()) {
            list = arrayList;
        }
        if (list == null || list.isEmpty()) {
            an anVar = com.baidu.live.af.a.SE().bwi;
            if (anVar == null) {
                return null;
            }
            QuickImInputData quickImInputData = anVar.aOG;
            if (quickImInputData == null || (list2 = quickImInputData.originTexts) == null || list2.isEmpty()) {
                return null;
            }
            return list2;
        }
        return list;
    }

    private String[] RK() {
        return new String[]{"66666", "牛批牛批", "赤道以北，主播最美", "全民女神", "哈哈哈哈哈哈", "扎心了", "老铁，走一个", "请开始你的表演"};
    }

    private void RL() {
        if (this.bzb == null) {
            this.bzb = new CustomMessageListener(2913122) { // from class: com.baidu.live.quick.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.byY != null && a.this.byY.isShowing()) {
                        a.this.byY.RQ();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bzb);
        }
    }

    private void RM() {
        if (this.bql == null) {
            this.bql = new CustomMessageListener(2913095) { // from class: com.baidu.live.quick.a.6
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
            MessageManager.getInstance().registerListener(this.bql);
        }
    }

    private void RN() {
        if (this.bzb != null) {
            MessageManager.getInstance().unRegisterListener(this.bzb);
            this.bzb = null;
        }
    }

    private void RO() {
        if (this.bql != null) {
            MessageManager.getInstance().unRegisterListener(this.bql);
        }
    }

    private void RP() {
        if (this.bih != null) {
            MessageManager.getInstance().unRegisterListener(this.bih);
        }
    }

    private void Ku() {
        if (this.bih == null) {
            this.bih = new CustomMessageListener(2913097) { // from class: com.baidu.live.quick.a.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.mDialog != null && a.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        a.this.mDialog.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bih);
        }
    }
}
