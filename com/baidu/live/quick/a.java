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
import com.baidu.live.data.ab;
import com.baidu.live.data.ar;
import com.baidu.live.data.cr;
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
    private cr aEe;
    private int bdk;
    public CustomMessageListener bgy;
    private CustomMessageListener boT;
    private boolean bqD;
    private int bqF;
    private AlaLiveInfoData bqM;
    private d.a bxI;
    private b bxJ;
    private String[] bxK;
    private List<String> bxL;
    private CustomMessageListener bxM;
    private ab bxN;
    private BdAlertDialog mDialog;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private int mPos;
    private String mText;
    private String mUserName;
    private String mVid;
    private int bqH = 0;
    public CustomMessageListener boE = new CustomMessageListener(2913193) { // from class: com.baidu.live.quick.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && a.this.bqH == 5) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        a.this.a(a.this.mPos, a.this.mText, a.this.aEe);
                    } else if (!imForbiddenStateData.hasShowForbiddenToast) {
                        a.this.a(imForbiddenStateData);
                        imForbiddenStateData.hasShowForbiddenToast = true;
                    }
                }
                a.this.bqH = 0;
            }
        }
    };

    @Override // com.baidu.live.view.input.d
    public void a(d.a aVar) {
        this.bxI = aVar;
    }

    @Override // com.baidu.live.view.input.d
    public void b(ab abVar, String str) {
        this.bxN = abVar;
        if (abVar != null) {
            this.bqM = abVar.mLiveInfo;
        }
        this.mVid = "";
        if (abVar != null && abVar.mLiveInfo != null && abVar.mLiveInfo.feed_id != null) {
            this.mVid = abVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        Pp();
        Pq();
        MessageManager.getInstance().registerListener(this.boE);
        HP();
    }

    @Override // com.baidu.live.view.input.d
    public void d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bxJ = new b(this.mPageContext);
        this.bxJ.a(new b.a() { // from class: com.baidu.live.quick.a.1
            @Override // com.baidu.live.quick.b.a
            public boolean Kh() {
                return a.this.bxI != null && a.this.bxI.Kh();
            }

            @Override // com.baidu.live.quick.b.a
            public void onShow() {
                if (a.this.bxI != null) {
                    a.this.bxI.XS();
                }
            }

            @Override // com.baidu.live.quick.b.a
            public void onDismiss() {
                if (a.this.bxI != null) {
                    a.this.bxI.XT();
                }
            }

            @Override // com.baidu.live.quick.b.a
            public void b(int i, String str, cr crVar) {
                a.this.mPos = i;
                a.this.mText = str;
                a.this.aEe = crVar;
                if (com.baidu.live.ae.a.Qj().buX.aNf == 1 && !LoginManager.getInstance(a.this.mPageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.ae.a.Qj().buX.aNe == 1) {
                    if (!a.this.bqD) {
                        a.this.a(i, str, crVar);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    a.this.bqH = 5;
                } else {
                    a.this.a(i, str, crVar);
                }
            }

            @Override // com.baidu.live.quick.b.a
            public boolean KW() {
                return a.this.bxI != null && a.this.bxI.KW();
            }

            @Override // com.baidu.live.quick.b.a
            public int Kn() {
                if (a.this.bxI != null) {
                    return a.this.bxI.Kn();
                }
                return 0;
            }

            @Override // com.baidu.live.quick.b.a
            public boolean Ko() {
                return a.this.bxI != null && a.this.bxI.Ko();
            }
        });
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.bxJ.a(Pm(), Mc());
            ac.gl("quick_im");
        }
    }

    private boolean Mc() {
        return (this.bqM == null || this.bqM.mAlaLiveSwitchData == null || !this.bqM.mAlaLiveSwitchData.isPayBarrageUnabled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, cr crVar) {
        if (this.bxI != null && this.bxI.Kh()) {
            ImSendMsgData imSendMsgData = new ImSendMsgData(str);
            imSendMsgData.text = str;
            if (crVar != null) {
                imSendMsgData.msgType = (short) 126;
                imSendMsgData.barrageType = crVar.type;
                imSendMsgData.barrageId = crVar.id;
                imSendMsgData.price = crVar.price;
                imSendMsgData.isQuickBarrage = true;
            } else {
                imSendMsgData.isQuick = true;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913288, true));
        gz(str);
        this.bxJ.dismiss();
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
        this.bqD = z;
        this.bqF = i;
        this.bdk = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.mPageContext.getPageActivity();
        if (pageActivity != null) {
            if (imForbiddenStateData.globalBan == 1) {
                if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bpt == 1) {
                    format = pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_block);
                } else {
                    format = String.format(pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bpu);
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
    public void cr(int i) {
        if (this.bxJ != null && this.bxJ.isShowing()) {
            this.bxJ.cr(i);
        }
    }

    @Override // com.baidu.live.view.input.d
    public List<String> Pl() {
        ar arVar;
        QuickImInputData quickImInputData;
        List<String> list;
        List<String> list2;
        if (this.bxL == null) {
            this.bxL = new ArrayList();
        } else {
            this.bxL.clear();
        }
        if (this.bxN != null && this.bxN.aIX != null && (list2 = this.bxN.aIX.sortedTexts) != null && !list2.isEmpty()) {
            this.bxL.addAll(list2);
        }
        if (this.bxL.isEmpty() && (arVar = com.baidu.live.ae.a.Qj().buX) != null && (quickImInputData = arVar.aME) != null && (list = quickImInputData.sortedTexts) != null && !list.isEmpty()) {
            this.bxL.addAll(list);
        }
        if (this.bxL.isEmpty()) {
            Collections.addAll(this.bxL, Pm());
        }
        return this.bxL;
    }

    @Override // com.baidu.live.view.input.d
    public void gz(String str) {
        List<String> list;
        if (!TextUtils.isEmpty(str) && this.bxL != null && !this.bxL.isEmpty() && this.bxL.indexOf(str) > 1) {
            if (this.bxL.remove(str)) {
                this.bxL.add(1, str);
            }
            if (this.bxN != null && this.bxN.aIX != null && (list = this.bxN.aIX.sortedTexts) != null && !list.isEmpty()) {
                list.clear();
                list.addAll(this.bxL);
                return;
            }
            ar arVar = com.baidu.live.ae.a.Qj().buX;
            if (arVar != null) {
                QuickImInputData quickImInputData = arVar.aME;
                if (quickImInputData == null) {
                    quickImInputData = new QuickImInputData();
                }
                if (quickImInputData.sortedTexts == null) {
                    quickImInputData.sortedTexts = new ArrayList();
                }
                quickImInputData.sortedTexts.clear();
                quickImInputData.sortedTexts.addAll(this.bxL);
            }
        }
    }

    @Override // com.baidu.live.view.input.d
    public void Fy() {
        if (this.bxJ != null) {
            if (this.bxL != null) {
                this.bxL.clear();
            }
            if (this.bxK != null) {
                this.bxK = null;
            }
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.bxJ.dismiss();
            }
            this.bxJ = null;
            Pr();
            Ps();
            MessageManager.getInstance().unRegisterListener(this.boE);
            Pt();
        }
    }

    @Override // com.baidu.live.view.input.d
    public void release() {
        Fy();
    }

    private String[] Pm() {
        if (this.bxK == null || this.bxK.length == 0) {
            List<String> Pn = Pn();
            if (Pn != null && !Pn.isEmpty()) {
                this.bxK = (String[]) Pn.toArray(new String[Pn.size()]);
            } else {
                this.bxK = Po();
            }
        }
        return this.bxK;
    }

    private List<String> Pn() {
        List<String> list;
        List<String> list2;
        ArrayList arrayList = new ArrayList();
        if (this.bxN == null || this.bxN.aIX == null || (list = this.bxN.aIX.sortedTexts) == null || list.isEmpty()) {
            list = arrayList;
        }
        if (list == null || list.isEmpty()) {
            ar arVar = com.baidu.live.ae.a.Qj().buX;
            if (arVar == null) {
                return null;
            }
            QuickImInputData quickImInputData = arVar.aME;
            if (quickImInputData == null || (list2 = quickImInputData.originTexts) == null || list2.isEmpty()) {
                return null;
            }
            return list2;
        }
        return list;
    }

    private String[] Po() {
        return new String[]{"66666", "牛批牛批", "赤道以北，主播最美", "全民女神", "哈哈哈哈哈哈", "扎心了", "老铁，走一个", "请开始你的表演"};
    }

    private void Pp() {
        if (this.bxM == null) {
            this.bxM = new CustomMessageListener(2913122) { // from class: com.baidu.live.quick.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.bxJ != null && a.this.bxJ.isShowing()) {
                        a.this.bxJ.Pu();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bxM);
        }
    }

    private void Pq() {
        if (this.boT == null) {
            this.boT = new CustomMessageListener(2913095) { // from class: com.baidu.live.quick.a.6
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
            MessageManager.getInstance().registerListener(this.boT);
        }
    }

    private void Pr() {
        if (this.bxM != null) {
            MessageManager.getInstance().unRegisterListener(this.bxM);
            this.bxM = null;
        }
    }

    private void Ps() {
        if (this.boT != null) {
            MessageManager.getInstance().unRegisterListener(this.boT);
        }
    }

    private void Pt() {
        if (this.bgy != null) {
            MessageManager.getInstance().unRegisterListener(this.bgy);
        }
    }

    private void HP() {
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
