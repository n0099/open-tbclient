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
/* loaded from: classes10.dex */
public class a implements d {
    private cr aFE;
    private int beM;
    public CustomMessageListener bhY;
    private CustomMessageListener bqt;
    private boolean bsd;
    private int bsf;
    private AlaLiveInfoData bsm;
    private d.a bzi;
    private b bzj;
    private String[] bzk;
    private List<String> bzl;
    private CustomMessageListener bzm;
    private ab bzn;
    private BdAlertDialog mDialog;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private int mPos;
    private String mText;
    private String mUserName;
    private String mVid;
    private int bsh = 0;
    public CustomMessageListener bqe = new CustomMessageListener(2913193) { // from class: com.baidu.live.quick.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && a.this.bsh == 5) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        a.this.a(a.this.mPos, a.this.mText, a.this.aFE);
                    } else if (!imForbiddenStateData.hasShowForbiddenToast) {
                        a.this.a(imForbiddenStateData);
                        imForbiddenStateData.hasShowForbiddenToast = true;
                    }
                }
                a.this.bsh = 0;
            }
        }
    };

    @Override // com.baidu.live.view.input.d
    public void a(d.a aVar) {
        this.bzi = aVar;
    }

    @Override // com.baidu.live.view.input.d
    public void b(ab abVar, String str) {
        this.bzn = abVar;
        if (abVar != null) {
            this.bsm = abVar.mLiveInfo;
        }
        this.mVid = "";
        if (abVar != null && abVar.mLiveInfo != null && abVar.mLiveInfo.feed_id != null) {
            this.mVid = abVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        Ps();
        Pt();
        MessageManager.getInstance().registerListener(this.bqe);
        HS();
    }

    @Override // com.baidu.live.view.input.d
    public void d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bzj = new b(this.mPageContext);
        this.bzj.a(new b.a() { // from class: com.baidu.live.quick.a.1
            @Override // com.baidu.live.quick.b.a
            public boolean Kk() {
                return a.this.bzi != null && a.this.bzi.Kk();
            }

            @Override // com.baidu.live.quick.b.a
            public void onShow() {
                if (a.this.bzi != null) {
                    a.this.bzi.XV();
                }
            }

            @Override // com.baidu.live.quick.b.a
            public void onDismiss() {
                if (a.this.bzi != null) {
                    a.this.bzi.XW();
                }
            }

            @Override // com.baidu.live.quick.b.a
            public void b(int i, String str, cr crVar) {
                a.this.mPos = i;
                a.this.mText = str;
                a.this.aFE = crVar;
                if (com.baidu.live.ae.a.Qm().bwx.aOF == 1 && !LoginManager.getInstance(a.this.mPageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.ae.a.Qm().bwx.aOE == 1) {
                    if (!a.this.bsd) {
                        a.this.a(i, str, crVar);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    a.this.bsh = 5;
                } else {
                    a.this.a(i, str, crVar);
                }
            }

            @Override // com.baidu.live.quick.b.a
            public boolean KZ() {
                return a.this.bzi != null && a.this.bzi.KZ();
            }

            @Override // com.baidu.live.quick.b.a
            public int Kq() {
                if (a.this.bzi != null) {
                    return a.this.bzi.Kq();
                }
                return 0;
            }

            @Override // com.baidu.live.quick.b.a
            public boolean Kr() {
                return a.this.bzi != null && a.this.bzi.Kr();
            }
        });
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.bzj.a(Pp(), Mf());
            ac.gr("quick_im");
        }
    }

    private boolean Mf() {
        return (this.bsm == null || this.bsm.mAlaLiveSwitchData == null || !this.bsm.mAlaLiveSwitchData.isPayBarrageUnabled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, cr crVar) {
        if (this.bzi != null && this.bzi.Kk()) {
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
        gF(str);
        this.bzj.dismiss();
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
        this.bsd = z;
        this.bsf = i;
        this.beM = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.mPageContext.getPageActivity();
        if (pageActivity != null) {
            if (imForbiddenStateData.globalBan == 1) {
                if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bqT == 1) {
                    format = pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_block);
                } else {
                    format = String.format(pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bqU);
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
    public void cs(int i) {
        if (this.bzj != null && this.bzj.isShowing()) {
            this.bzj.cs(i);
        }
    }

    @Override // com.baidu.live.view.input.d
    public List<String> Po() {
        ar arVar;
        QuickImInputData quickImInputData;
        List<String> list;
        List<String> list2;
        if (this.bzl == null) {
            this.bzl = new ArrayList();
        } else {
            this.bzl.clear();
        }
        if (this.bzn != null && this.bzn.aKx != null && (list2 = this.bzn.aKx.sortedTexts) != null && !list2.isEmpty()) {
            this.bzl.addAll(list2);
        }
        if (this.bzl.isEmpty() && (arVar = com.baidu.live.ae.a.Qm().bwx) != null && (quickImInputData = arVar.aOe) != null && (list = quickImInputData.sortedTexts) != null && !list.isEmpty()) {
            this.bzl.addAll(list);
        }
        if (this.bzl.isEmpty()) {
            Collections.addAll(this.bzl, Pp());
        }
        return this.bzl;
    }

    @Override // com.baidu.live.view.input.d
    public void gF(String str) {
        List<String> list;
        if (!TextUtils.isEmpty(str) && this.bzl != null && !this.bzl.isEmpty() && this.bzl.indexOf(str) > 1) {
            if (this.bzl.remove(str)) {
                this.bzl.add(1, str);
            }
            if (this.bzn != null && this.bzn.aKx != null && (list = this.bzn.aKx.sortedTexts) != null && !list.isEmpty()) {
                list.clear();
                list.addAll(this.bzl);
                return;
            }
            ar arVar = com.baidu.live.ae.a.Qm().bwx;
            if (arVar != null) {
                QuickImInputData quickImInputData = arVar.aOe;
                if (quickImInputData == null) {
                    quickImInputData = new QuickImInputData();
                }
                if (quickImInputData.sortedTexts == null) {
                    quickImInputData.sortedTexts = new ArrayList();
                }
                quickImInputData.sortedTexts.clear();
                quickImInputData.sortedTexts.addAll(this.bzl);
            }
        }
    }

    @Override // com.baidu.live.view.input.d
    public void FB() {
        if (this.bzj != null) {
            if (this.bzl != null) {
                this.bzl.clear();
            }
            if (this.bzk != null) {
                this.bzk = null;
            }
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.bzj.dismiss();
            }
            this.bzj = null;
            Pu();
            Pv();
            MessageManager.getInstance().unRegisterListener(this.bqe);
            Pw();
        }
    }

    @Override // com.baidu.live.view.input.d
    public void release() {
        FB();
    }

    private String[] Pp() {
        if (this.bzk == null || this.bzk.length == 0) {
            List<String> Pq = Pq();
            if (Pq != null && !Pq.isEmpty()) {
                this.bzk = (String[]) Pq.toArray(new String[Pq.size()]);
            } else {
                this.bzk = Pr();
            }
        }
        return this.bzk;
    }

    private List<String> Pq() {
        List<String> list;
        List<String> list2;
        ArrayList arrayList = new ArrayList();
        if (this.bzn == null || this.bzn.aKx == null || (list = this.bzn.aKx.sortedTexts) == null || list.isEmpty()) {
            list = arrayList;
        }
        if (list == null || list.isEmpty()) {
            ar arVar = com.baidu.live.ae.a.Qm().bwx;
            if (arVar == null) {
                return null;
            }
            QuickImInputData quickImInputData = arVar.aOe;
            if (quickImInputData == null || (list2 = quickImInputData.originTexts) == null || list2.isEmpty()) {
                return null;
            }
            return list2;
        }
        return list;
    }

    private String[] Pr() {
        return new String[]{"66666", "牛批牛批", "赤道以北，主播最美", "全民女神", "哈哈哈哈哈哈", "扎心了", "老铁，走一个", "请开始你的表演"};
    }

    private void Ps() {
        if (this.bzm == null) {
            this.bzm = new CustomMessageListener(2913122) { // from class: com.baidu.live.quick.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.bzj != null && a.this.bzj.isShowing()) {
                        a.this.bzj.Px();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bzm);
        }
    }

    private void Pt() {
        if (this.bqt == null) {
            this.bqt = new CustomMessageListener(2913095) { // from class: com.baidu.live.quick.a.6
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
            MessageManager.getInstance().registerListener(this.bqt);
        }
    }

    private void Pu() {
        if (this.bzm != null) {
            MessageManager.getInstance().unRegisterListener(this.bzm);
            this.bzm = null;
        }
    }

    private void Pv() {
        if (this.bqt != null) {
            MessageManager.getInstance().unRegisterListener(this.bqt);
        }
    }

    private void Pw() {
        if (this.bhY != null) {
            MessageManager.getInstance().unRegisterListener(this.bhY);
        }
    }

    private void HS() {
        if (this.bhY == null) {
            this.bhY = new CustomMessageListener(2913097) { // from class: com.baidu.live.quick.a.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.mDialog != null && a.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        a.this.mDialog.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bhY);
        }
    }
}
