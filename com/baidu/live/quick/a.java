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
    private bz aBP;
    private int aVt;
    public CustomMessageListener aYi;
    private CustomMessageListener beU;
    private boolean bgd;
    private int bge;
    private AlaLiveInfoData bgj;
    private c.a bjU;
    private b bjV;
    private String[] bjW;
    private List<String> bjX;
    private CustomMessageListener bjY;
    private u bjZ;
    private BdAlertDialog mDialog;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private int mPos;
    private String mText;
    private String mUserName;
    private String mVid;
    private int bgg = 0;
    public CustomMessageListener bgl = new CustomMessageListener(2913193) { // from class: com.baidu.live.quick.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && a.this.bgg == 5) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.this.mPageContext.getPageActivity().getResources().getString(a.i.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        a.this.a(a.this.mPos, a.this.mText, a.this.aBP);
                    } else {
                        a.this.a(imForbiddenStateData);
                    }
                }
                a.this.bgg = 0;
            }
        }
    };

    @Override // com.baidu.live.view.input.c
    public void a(c.a aVar) {
        this.bjU = aVar;
    }

    @Override // com.baidu.live.view.input.c
    public void b(u uVar, String str) {
        this.bjZ = uVar;
        if (uVar != null) {
            this.bgj = uVar.mLiveInfo;
        }
        this.mVid = "";
        if (uVar != null && uVar.mLiveInfo != null && uVar.mLiveInfo.feed_id != null) {
            this.mVid = uVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        MU();
        MV();
        MessageManager.getInstance().registerListener(this.bgl);
        HL();
    }

    @Override // com.baidu.live.view.input.c
    public void d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bjV = new b(this.mPageContext);
        this.bjV.a(new b.a() { // from class: com.baidu.live.quick.a.1
            @Override // com.baidu.live.quick.b.a
            public boolean JM() {
                return a.this.bjU != null && a.this.bjU.JM();
            }

            @Override // com.baidu.live.quick.b.a
            public void MZ() {
                if (a.this.bjU != null) {
                    a.this.bjU.Rz();
                }
            }

            @Override // com.baidu.live.quick.b.a
            public void onDismiss() {
                if (a.this.bjU != null) {
                    a.this.bjU.RA();
                }
            }

            @Override // com.baidu.live.quick.b.a
            public void b(int i, String str, bz bzVar) {
                a.this.mPos = i;
                a.this.mText = str;
                a.this.aBP = bzVar;
                if (com.baidu.live.x.a.NN().bhy.aIG == 1 && !LoginManager.getInstance(a.this.mPageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.this.mPageContext.getPageActivity().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.x.a.NN().bhy.aIF == 1) {
                    if (!a.this.bgd) {
                        a.this.a(i, str, bzVar);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    a.this.bgg = 5;
                } else {
                    a.this.a(i, str, bzVar);
                }
            }

            @Override // com.baidu.live.quick.b.a
            public boolean Kn() {
                return a.this.bjU != null && a.this.bjU.Kn();
            }

            @Override // com.baidu.live.quick.b.a
            public int JR() {
                if (a.this.bjU != null) {
                    return a.this.bjU.JR();
                }
                return 0;
            }
        });
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.bjV.a(MR(), Lj());
            w.gx("quick_im");
        }
    }

    private boolean Lj() {
        return (this.bgj == null || this.bgj.mAlaLiveSwitchData == null || !this.bgj.mAlaLiveSwitchData.isPayBarrageUnabled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, bz bzVar) {
        if (this.bjU != null && this.bjU.JM()) {
            ImSendMsgData imSendMsgData = new ImSendMsgData(str);
            if (bzVar != null) {
                imSendMsgData.msgType = (short) 126;
                imSendMsgData.barrageType = bzVar.type;
                imSendMsgData.barrageId = bzVar.id;
                imSendMsgData.price = bzVar.price;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
        }
        gH(str);
        this.bjV.dismiss();
        LogManager.getCommonLogger().doClickQuickImListLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
    }

    @Override // com.baidu.live.view.input.c
    public void b(boolean z, int i, int i2, String str) {
        this.bgd = z;
        this.bge = i;
        this.aVt = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.mPageContext.getPageActivity();
        if (pageActivity != null) {
            if (imForbiddenStateData.globalBan == 1) {
                if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bfk == 1) {
                    format = pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_block);
                } else {
                    format = String.format(pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bfl);
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
    public void dD(int i) {
        if (this.bjV != null && this.bjV.isShowing()) {
            this.bjV.dD(i);
        }
    }

    @Override // com.baidu.live.view.input.c
    public List<String> MQ() {
        ag agVar;
        QuickImInputData quickImInputData;
        List<String> list;
        List<String> list2;
        if (this.bjX == null) {
            this.bjX = new ArrayList();
        } else {
            this.bjX.clear();
        }
        if (this.bjZ != null && this.bjZ.aFt != null && (list2 = this.bjZ.aFt.sortedTexts) != null && !list2.isEmpty()) {
            this.bjX.addAll(list2);
        }
        if (this.bjX.isEmpty() && (agVar = com.baidu.live.x.a.NN().bhy) != null && (quickImInputData = agVar.aIk) != null && (list = quickImInputData.sortedTexts) != null && !list.isEmpty()) {
            this.bjX.addAll(list);
        }
        if (this.bjX.isEmpty()) {
            Collections.addAll(this.bjX, MR());
        }
        return this.bjX;
    }

    @Override // com.baidu.live.view.input.c
    public void gH(String str) {
        List<String> list;
        if (!TextUtils.isEmpty(str) && this.bjX != null && !this.bjX.isEmpty() && this.bjX.indexOf(str) > 1) {
            if (this.bjX.remove(str)) {
                this.bjX.add(1, str);
            }
            if (this.bjZ != null && this.bjZ.aFt != null && (list = this.bjZ.aFt.sortedTexts) != null && !list.isEmpty()) {
                list.clear();
                list.addAll(this.bjX);
                return;
            }
            ag agVar = com.baidu.live.x.a.NN().bhy;
            if (agVar != null) {
                QuickImInputData quickImInputData = agVar.aIk;
                if (quickImInputData == null) {
                    quickImInputData = new QuickImInputData();
                }
                if (quickImInputData.sortedTexts == null) {
                    quickImInputData.sortedTexts = new ArrayList();
                }
                quickImInputData.sortedTexts.clear();
                quickImInputData.sortedTexts.addAll(this.bjX);
            }
        }
    }

    @Override // com.baidu.live.view.input.c
    public void FB() {
        if (this.bjV != null) {
            if (this.bjX != null) {
                this.bjX.clear();
            }
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.bjV.dismiss();
            }
            this.bjV = null;
            MW();
            MX();
            MessageManager.getInstance().unRegisterListener(this.bgl);
            MY();
        }
    }

    @Override // com.baidu.live.view.input.c
    public void release() {
        FB();
    }

    private String[] MR() {
        if (this.bjW == null || this.bjW.length == 0) {
            List<String> MS = MS();
            if (MS != null && !MS.isEmpty()) {
                this.bjW = (String[]) MS.toArray(new String[MS.size()]);
            } else {
                this.bjW = MT();
            }
        }
        return this.bjW;
    }

    private List<String> MS() {
        List<String> list;
        List<String> list2;
        ArrayList arrayList = new ArrayList();
        if (this.bjZ == null || this.bjZ.aFt == null || (list = this.bjZ.aFt.sortedTexts) == null || list.isEmpty()) {
            list = arrayList;
        }
        if (list == null || list.isEmpty()) {
            ag agVar = com.baidu.live.x.a.NN().bhy;
            if (agVar == null) {
                return null;
            }
            QuickImInputData quickImInputData = agVar.aIk;
            if (quickImInputData == null || (list2 = quickImInputData.originTexts) == null || list2.isEmpty()) {
                return null;
            }
            return list2;
        }
        return list;
    }

    private String[] MT() {
        return new String[]{"66666", "牛批牛批", "赤道以北，主播最美", "全民女神", "哈哈哈哈哈哈", "扎心了", "老铁，走一个", "请开始你的表演"};
    }

    private void MU() {
        if (this.bjY == null) {
            this.bjY = new CustomMessageListener(2913122) { // from class: com.baidu.live.quick.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.bjV != null && a.this.bjV.isShowing()) {
                        a.this.bjV.Na();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bjY);
        }
    }

    private void MV() {
        if (this.beU == null) {
            this.beU = new CustomMessageListener(2913095) { // from class: com.baidu.live.quick.a.6
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
            MessageManager.getInstance().registerListener(this.beU);
        }
    }

    private void MW() {
        if (this.bjY != null) {
            MessageManager.getInstance().unRegisterListener(this.bjY);
            this.bjY = null;
        }
    }

    private void MX() {
        if (this.beU != null) {
            MessageManager.getInstance().unRegisterListener(this.beU);
        }
    }

    private void MY() {
        if (this.aYi != null) {
            MessageManager.getInstance().unRegisterListener(this.aYi);
        }
    }

    private void HL() {
        if (this.aYi == null) {
            this.aYi = new CustomMessageListener(2913097) { // from class: com.baidu.live.quick.a.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.mDialog != null && a.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        a.this.mDialog.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.aYi);
        }
    }
}
