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
    private br aBj;
    private int aTf;
    public CustomMessageListener aVP;
    private CustomMessageListener bck;
    private boolean bdo;
    private int bdp;
    private AlaLiveInfoData bdu;
    private c.a bgV;
    private b bgW;
    private String[] bgX;
    private List<String> bgY;
    private CustomMessageListener bgZ;
    private r bha;
    private BdAlertDialog mDialog;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private int mPos;
    private String mText;
    private String mUserName;
    private String mVid;
    private int bdr = 0;
    public CustomMessageListener bdw = new CustomMessageListener(2913193) { // from class: com.baidu.live.quick.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && a.this.bdr == 5) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.this.mPageContext.getPageActivity().getResources().getString(a.i.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        a.this.a(a.this.mPos, a.this.mText, a.this.aBj);
                    } else {
                        a.this.a(imForbiddenStateData);
                    }
                }
                a.this.bdr = 0;
            }
        }
    };

    @Override // com.baidu.live.view.input.c
    public void a(c.a aVar) {
        this.bgV = aVar;
    }

    @Override // com.baidu.live.view.input.c
    public void b(r rVar, String str) {
        this.bha = rVar;
        if (rVar != null) {
            this.bdu = rVar.mLiveInfo;
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
        MessageManager.getInstance().registerListener(this.bdw);
        Hk();
    }

    @Override // com.baidu.live.view.input.c
    public void d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bgW = new b(this.mPageContext);
        this.bgW.a(new b.a() { // from class: com.baidu.live.quick.a.1
            @Override // com.baidu.live.quick.b.a
            public boolean Ji() {
                return a.this.bgV != null && a.this.bgV.Ji();
            }

            @Override // com.baidu.live.quick.b.a
            public void Mr() {
                if (a.this.bgV != null) {
                    a.this.bgV.QQ();
                }
            }

            @Override // com.baidu.live.quick.b.a
            public void onDismiss() {
                if (a.this.bgV != null) {
                    a.this.bgV.QR();
                }
            }

            @Override // com.baidu.live.quick.b.a
            public void b(int i, String str, br brVar) {
                a.this.mPos = i;
                a.this.mText = str;
                a.this.aBj = brVar;
                if (com.baidu.live.w.a.Nk().beJ.aHp == 1 && !LoginManager.getInstance(a.this.mPageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.this.mPageContext.getPageActivity().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.w.a.Nk().beJ.aHo == 1) {
                    if (!a.this.bdo) {
                        a.this.a(i, str, brVar);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    a.this.bdr = 5;
                } else {
                    a.this.a(i, str, brVar);
                }
            }

            @Override // com.baidu.live.quick.b.a
            public boolean JJ() {
                return a.this.bgV != null && a.this.bgV.JJ();
            }

            @Override // com.baidu.live.quick.b.a
            public int Jn() {
                if (a.this.bgV != null) {
                    return a.this.bgV.Jn();
                }
                return 0;
            }
        });
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.bgW.a(Mj(), KC());
            v.gn("quick_im");
        }
    }

    private boolean KC() {
        return (this.bdu == null || this.bdu.mAlaLiveSwitchData == null || !this.bdu.mAlaLiveSwitchData.isPayBarrageUnabled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, br brVar) {
        if (this.bgV != null && this.bgV.Ji()) {
            ImSendMsgData imSendMsgData = new ImSendMsgData(str);
            if (brVar != null) {
                imSendMsgData.msgType = (short) 126;
                imSendMsgData.barrageType = brVar.type;
                imSendMsgData.barrageId = brVar.id;
                imSendMsgData.price = brVar.price;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
        }
        gx(str);
        this.bgW.dismiss();
        LogManager.getCommonLogger().doClickQuickImListLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
    }

    @Override // com.baidu.live.view.input.c
    public void b(boolean z, int i, int i2, String str) {
        this.bdo = z;
        this.bdp = i;
        this.aTf = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.mPageContext.getPageActivity();
        if (pageActivity != null) {
            if (imForbiddenStateData.globalBan == 1) {
                if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bcy == 1) {
                    format = pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_block);
                } else {
                    format = String.format(pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bcz);
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
        if (this.bgW != null && this.bgW.isShowing()) {
            this.bgW.dz(i);
        }
    }

    @Override // com.baidu.live.view.input.c
    public List<String> Mi() {
        ab abVar;
        QuickImInputData quickImInputData;
        List<String> list;
        List<String> list2;
        if (this.bgY == null) {
            this.bgY = new ArrayList();
        } else {
            this.bgY.clear();
        }
        if (this.bha != null && this.bha.aEu != null && (list2 = this.bha.aEu.sortedTexts) != null && !list2.isEmpty()) {
            this.bgY.addAll(list2);
        }
        if (this.bgY.isEmpty() && (abVar = com.baidu.live.w.a.Nk().beJ) != null && (quickImInputData = abVar.aGV) != null && (list = quickImInputData.sortedTexts) != null && !list.isEmpty()) {
            this.bgY.addAll(list);
        }
        if (this.bgY.isEmpty()) {
            Collections.addAll(this.bgY, Mj());
        }
        return this.bgY;
    }

    @Override // com.baidu.live.view.input.c
    public void gx(String str) {
        List<String> list;
        if (!TextUtils.isEmpty(str) && this.bgY != null && !this.bgY.isEmpty() && this.bgY.indexOf(str) > 1) {
            if (this.bgY.remove(str)) {
                this.bgY.add(1, str);
            }
            if (this.bha != null && this.bha.aEu != null && (list = this.bha.aEu.sortedTexts) != null && !list.isEmpty()) {
                list.clear();
                list.addAll(this.bgY);
                return;
            }
            ab abVar = com.baidu.live.w.a.Nk().beJ;
            if (abVar != null) {
                QuickImInputData quickImInputData = abVar.aGV;
                if (quickImInputData == null) {
                    quickImInputData = new QuickImInputData();
                }
                if (quickImInputData.sortedTexts == null) {
                    quickImInputData.sortedTexts = new ArrayList();
                }
                quickImInputData.sortedTexts.clear();
                quickImInputData.sortedTexts.addAll(this.bgY);
            }
        }
    }

    @Override // com.baidu.live.view.input.c
    public void Fb() {
        if (this.bgW != null) {
            if (this.bgY != null) {
                this.bgY.clear();
            }
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.bgW.dismiss();
            }
            this.bgW = null;
            Mo();
            Mp();
            MessageManager.getInstance().unRegisterListener(this.bdw);
            Mq();
        }
    }

    @Override // com.baidu.live.view.input.c
    public void release() {
        Fb();
    }

    private String[] Mj() {
        if (this.bgX == null || this.bgX.length == 0) {
            List<String> Mk = Mk();
            if (Mk != null && !Mk.isEmpty()) {
                this.bgX = (String[]) Mk.toArray(new String[Mk.size()]);
            } else {
                this.bgX = Ml();
            }
        }
        return this.bgX;
    }

    private List<String> Mk() {
        List<String> list;
        List<String> list2;
        ArrayList arrayList = new ArrayList();
        if (this.bha == null || this.bha.aEu == null || (list = this.bha.aEu.sortedTexts) == null || list.isEmpty()) {
            list = arrayList;
        }
        if (list == null || list.isEmpty()) {
            ab abVar = com.baidu.live.w.a.Nk().beJ;
            if (abVar == null) {
                return null;
            }
            QuickImInputData quickImInputData = abVar.aGV;
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
        if (this.bgZ == null) {
            this.bgZ = new CustomMessageListener(2913122) { // from class: com.baidu.live.quick.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.bgW != null && a.this.bgW.isShowing()) {
                        a.this.bgW.Ms();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bgZ);
        }
    }

    private void Mn() {
        if (this.bck == null) {
            this.bck = new CustomMessageListener(2913095) { // from class: com.baidu.live.quick.a.6
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
            MessageManager.getInstance().registerListener(this.bck);
        }
    }

    private void Mo() {
        if (this.bgZ != null) {
            MessageManager.getInstance().unRegisterListener(this.bgZ);
            this.bgZ = null;
        }
    }

    private void Mp() {
        if (this.bck != null) {
            MessageManager.getInstance().unRegisterListener(this.bck);
        }
    }

    private void Mq() {
        if (this.aVP != null) {
            MessageManager.getInstance().unRegisterListener(this.aVP);
        }
    }

    private void Hk() {
        if (this.aVP == null) {
            this.aVP = new CustomMessageListener(2913097) { // from class: com.baidu.live.quick.a.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.mDialog != null && a.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        a.this.mDialog.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.aVP);
        }
    }
}
