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
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.QuickImInputData;
import com.baidu.live.data.bo;
import com.baidu.live.data.q;
import com.baidu.live.data.z;
import com.baidu.live.gift.v;
import com.baidu.live.im.data.ImForbiddenStateData;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.view.quick.a;
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
/* loaded from: classes3.dex */
public class d implements com.baidu.live.view.input.c {
    private int aMv;
    public CustomMessageListener aPg;
    private CustomMessageListener aVB;
    private c.a aVS;
    private com.baidu.live.im.view.quick.a aVT;
    private String[] aVU;
    private List<String> aVV;
    private CustomMessageListener aVW;
    private bo aVX;
    private boolean aVY;
    private int aVZ;
    private AlaLiveInfoData aWb;
    private BdAlertDialog mDialog;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private int mPos;
    private String mText;
    private String mUserName;
    private String mVid;
    private int aWa = 0;
    public CustomMessageListener aWc = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.b.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.aWa == 5) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(d.this.mPageContext.getPageActivity(), d.this.mPageContext.getPageActivity().getResources().getString(a.i.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        d.this.a(d.this.mPos, d.this.mText, d.this.aVX);
                    } else {
                        d.this.a(imForbiddenStateData);
                    }
                }
                d.this.aWa = 0;
            }
        }
    };

    @Override // com.baidu.live.view.input.c
    public void a(c.a aVar) {
        this.aVS = aVar;
    }

    @Override // com.baidu.live.view.input.c
    public void a(q qVar, String str) {
        if (qVar != null) {
            this.aWb = qVar.mLiveInfo;
        }
        this.mVid = "";
        if (qVar != null && qVar.mLiveInfo != null && qVar.mLiveInfo.feed_id != null) {
            this.mVid = qVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        DW();
        DX();
        MessageManager.getInstance().registerListener(this.aWc);
        Bf();
    }

    @Override // com.baidu.live.view.input.c
    public void c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aVT = new com.baidu.live.im.view.quick.a(this.mPageContext.getPageActivity());
        this.aVT.a(new a.InterfaceC0168a() { // from class: com.baidu.live.im.b.d.1
            @Override // com.baidu.live.im.view.quick.a.InterfaceC0168a
            public boolean Dd() {
                return d.this.aVS != null && d.this.aVS.Dd();
            }

            @Override // com.baidu.live.im.view.quick.a.InterfaceC0168a
            public void Eb() {
                if (d.this.aVS != null) {
                    d.this.aVS.KK();
                }
            }

            @Override // com.baidu.live.im.view.quick.a.InterfaceC0168a
            public void onDismiss() {
                if (d.this.aVS != null) {
                    d.this.aVS.KL();
                }
            }

            @Override // com.baidu.live.im.view.quick.a.InterfaceC0168a
            public void b(int i, String str, bo boVar) {
                d.this.mPos = i;
                d.this.mText = str;
                d.this.aVX = boVar;
                if (com.baidu.live.v.a.Hm().aZp.aAQ == 1 && !LoginManager.getInstance(d.this.mPageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(d.this.mPageContext.getPageActivity(), d.this.mPageContext.getPageActivity().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.v.a.Hm().aZp.aAP == 1) {
                    if (!d.this.aVY) {
                        d.this.a(i, str, boVar);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    d.this.aWa = 5;
                } else {
                    d.this.a(i, str, boVar);
                }
            }

            @Override // com.baidu.live.im.view.quick.a.InterfaceC0168a
            public boolean Ec() {
                return d.this.aVS != null && d.this.aVS.Ec();
            }

            @Override // com.baidu.live.im.view.quick.a.InterfaceC0168a
            public int Di() {
                if (d.this.aVS != null) {
                    return d.this.aVS.Di();
                }
                return 0;
            }
        });
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.aVT.a(DT(), DR());
            v.eT("quick_im");
        }
    }

    private boolean DR() {
        return (this.aWb == null || this.aWb.mAlaLiveSwitchData == null || !this.aWb.mAlaLiveSwitchData.mPayBarrageInvalid) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, bo boVar) {
        if (this.aVS != null && this.aVS.Dd()) {
            ImSendMsgData imSendMsgData = new ImSendMsgData(str);
            if (boVar != null) {
                imSendMsgData.msgType = (short) 126;
                imSendMsgData.barrageType = boVar.type;
                imSendMsgData.barrageId = boVar.id;
                imSendMsgData.price = boVar.price;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
        }
        fc(str);
        this.aVT.dismiss();
        LogManager.getCommonLogger().doClickQuickImListLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
    }

    @Override // com.baidu.live.view.input.c
    public void b(boolean z, int i, int i2, String str) {
        this.aVY = z;
        this.aVZ = i;
        this.aMv = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.mPageContext.getPageActivity();
        if (pageActivity != null) {
            if (imForbiddenStateData.globalBan == 1) {
                if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.aWm == 1) {
                    format = pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_block);
                } else {
                    format = String.format(pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.aWn);
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
    public void cA(int i) {
        if (this.aVT != null && this.aVT.isShowing()) {
            this.aVT.cA(i);
        }
    }

    @Override // com.baidu.live.view.input.c
    public List<String> DS() {
        QuickImInputData quickImInputData;
        List<String> list;
        if (this.aVV == null) {
            this.aVV = new ArrayList();
        }
        this.aVV.clear();
        z zVar = com.baidu.live.v.a.Hm().aZp;
        if (zVar != null && (quickImInputData = zVar.aAw) != null && (list = quickImInputData.sortedTexts) != null && !list.isEmpty()) {
            this.aVV.addAll(list);
        }
        if (this.aVV.isEmpty()) {
            Collections.addAll(this.aVV, DT());
        }
        return this.aVV;
    }

    @Override // com.baidu.live.view.input.c
    public void fc(String str) {
        if (!TextUtils.isEmpty(str) && this.aVV != null && !this.aVV.isEmpty() && this.aVV.indexOf(str) > 1) {
            if (this.aVV.remove(str)) {
                this.aVV.add(1, str);
            }
            z zVar = com.baidu.live.v.a.Hm().aZp;
            if (zVar != null) {
                QuickImInputData quickImInputData = zVar.aAw;
                if (quickImInputData == null) {
                    quickImInputData = new QuickImInputData();
                }
                if (quickImInputData.sortedTexts == null) {
                    quickImInputData.sortedTexts = new ArrayList();
                }
                quickImInputData.sortedTexts.clear();
                quickImInputData.sortedTexts.addAll(this.aVV);
            }
        }
    }

    @Override // com.baidu.live.view.input.c
    public void yW() {
        if (this.aVT != null) {
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.aVT.dismiss();
            }
            this.aVT = null;
            DY();
            DZ();
            MessageManager.getInstance().unRegisterListener(this.aWc);
            Ea();
        }
    }

    @Override // com.baidu.live.view.input.c
    public void release() {
        yW();
    }

    private String[] DT() {
        if (this.aVU == null || this.aVU.length == 0) {
            List<String> DU = DU();
            if (DU != null && !DU.isEmpty()) {
                this.aVU = (String[]) DU.toArray(new String[DU.size()]);
            } else {
                this.aVU = DV();
            }
        }
        return this.aVU;
    }

    private List<String> DU() {
        QuickImInputData quickImInputData;
        List<String> list;
        z zVar = com.baidu.live.v.a.Hm().aZp;
        if (zVar == null || (quickImInputData = zVar.aAw) == null || (list = quickImInputData.originTexts) == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    private String[] DV() {
        return new String[]{"66666", "牛批牛批", "赤道以北，主播最美", "全民女神", "哈哈哈哈哈哈", "扎心了", "老铁，走一个", "请开始你的表演"};
    }

    private void DW() {
        if (this.aVW == null) {
            this.aVW = new CustomMessageListener(2913122) { // from class: com.baidu.live.im.b.d.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (d.this.aVT != null && d.this.aVT.isShowing()) {
                        d.this.aVT.Fi();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.aVW);
        }
    }

    private void DX() {
        if (this.aVB == null) {
            this.aVB = new CustomMessageListener(2913095) { // from class: com.baidu.live.im.b.d.6
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
            MessageManager.getInstance().registerListener(this.aVB);
        }
    }

    private void DY() {
        if (this.aVW != null) {
            MessageManager.getInstance().unRegisterListener(this.aVW);
            this.aVW = null;
        }
    }

    private void DZ() {
        if (this.aVB != null) {
            MessageManager.getInstance().unRegisterListener(this.aVB);
        }
    }

    private void Ea() {
        if (this.aPg != null) {
            MessageManager.getInstance().unRegisterListener(this.aPg);
        }
    }

    private void Bf() {
        if (this.aPg == null) {
            this.aPg = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.b.d.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (d.this.mDialog != null && d.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        d.this.mDialog.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.aPg);
        }
    }
}
