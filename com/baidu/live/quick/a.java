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
import com.baidu.live.data.aj;
import com.baidu.live.data.ce;
import com.baidu.live.data.w;
import com.baidu.live.gift.ab;
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
    private ce aFc;
    private int bab;
    public CustomMessageListener bcQ;
    private CustomMessageListener bkc;
    private boolean blo;
    private int blp;
    private AlaLiveInfoData blu;
    private c.a bpu;
    private b bpv;
    private String[] bpw;
    private List<String> bpx;
    private CustomMessageListener bpy;
    private w bpz;
    private BdAlertDialog mDialog;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private int mPos;
    private String mText;
    private String mUserName;
    private String mVid;
    private int blr = 0;
    public CustomMessageListener blw = new CustomMessageListener(2913193) { // from class: com.baidu.live.quick.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && a.this.blr == 5) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.this.mPageContext.getPageActivity().getResources().getString(a.i.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        a.this.a(a.this.mPos, a.this.mText, a.this.aFc);
                    } else {
                        a.this.a(imForbiddenStateData);
                    }
                }
                a.this.blr = 0;
            }
        }
    };

    @Override // com.baidu.live.view.input.c
    public void a(c.a aVar) {
        this.bpu = aVar;
    }

    @Override // com.baidu.live.view.input.c
    public void b(w wVar, String str) {
        this.bpz = wVar;
        if (wVar != null) {
            this.blu = wVar.mLiveInfo;
        }
        this.mVid = "";
        if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.feed_id != null) {
            this.mVid = wVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        Ox();
        Oy();
        MessageManager.getInstance().registerListener(this.blw);
        Jb();
    }

    @Override // com.baidu.live.view.input.c
    public void d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bpv = new b(this.mPageContext);
        this.bpv.a(new b.a() { // from class: com.baidu.live.quick.a.1
            @Override // com.baidu.live.quick.b.a
            public boolean Lm() {
                return a.this.bpu != null && a.this.bpu.Lm();
            }

            @Override // com.baidu.live.quick.b.a
            public void OC() {
                if (a.this.bpu != null) {
                    a.this.bpu.Us();
                }
            }

            @Override // com.baidu.live.quick.b.a
            public void onDismiss() {
                if (a.this.bpu != null) {
                    a.this.bpu.Ut();
                }
            }

            @Override // com.baidu.live.quick.b.a
            public void b(int i, String str, ce ceVar) {
                a.this.mPos = i;
                a.this.mText = str;
                a.this.aFc = ceVar;
                if (com.baidu.live.z.a.Pq().bmJ.aMo == 1 && !LoginManager.getInstance(a.this.mPageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.this.mPageContext.getPageActivity().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.z.a.Pq().bmJ.aMn == 1) {
                    if (!a.this.blo) {
                        a.this.a(i, str, ceVar);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    a.this.blr = 5;
                } else {
                    a.this.a(i, str, ceVar);
                }
            }

            @Override // com.baidu.live.quick.b.a
            public boolean LN() {
                return a.this.bpu != null && a.this.bpu.LN();
            }

            @Override // com.baidu.live.quick.b.a
            public int Lr() {
                if (a.this.bpu != null) {
                    return a.this.bpu.Lr();
                }
                return 0;
            }
        });
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.bpv.a(Ou(), MI());
            ab.gV("quick_im");
        }
    }

    private boolean MI() {
        return (this.blu == null || this.blu.mAlaLiveSwitchData == null || !this.blu.mAlaLiveSwitchData.isPayBarrageUnabled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, ce ceVar) {
        if (this.bpu != null && this.bpu.Lm()) {
            ImSendMsgData imSendMsgData = new ImSendMsgData(str);
            if (ceVar != null) {
                imSendMsgData.msgType = (short) 126;
                imSendMsgData.barrageType = ceVar.type;
                imSendMsgData.barrageId = ceVar.id;
                imSendMsgData.price = ceVar.price;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
        }
        hg(str);
        this.bpv.dismiss();
        LogManager.getCommonLogger().doClickQuickImListLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
    }

    @Override // com.baidu.live.view.input.c
    public void b(boolean z, int i, int i2, String str) {
        this.blo = z;
        this.blp = i;
        this.bab = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.mPageContext.getPageActivity();
        if (pageActivity != null) {
            if (imForbiddenStateData.globalBan == 1) {
                if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bkr == 1) {
                    format = pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_block);
                } else {
                    format = String.format(pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bks);
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
        if (this.bpv != null && this.bpv.isShowing()) {
            this.bpv.dI(i);
        }
    }

    @Override // com.baidu.live.view.input.c
    public List<String> Ot() {
        aj ajVar;
        QuickImInputData quickImInputData;
        List<String> list;
        List<String> list2;
        if (this.bpx == null) {
            this.bpx = new ArrayList();
        } else {
            this.bpx.clear();
        }
        if (this.bpz != null && this.bpz.aIU != null && (list2 = this.bpz.aIU.sortedTexts) != null && !list2.isEmpty()) {
            this.bpx.addAll(list2);
        }
        if (this.bpx.isEmpty() && (ajVar = com.baidu.live.z.a.Pq().bmJ) != null && (quickImInputData = ajVar.aLS) != null && (list = quickImInputData.sortedTexts) != null && !list.isEmpty()) {
            this.bpx.addAll(list);
        }
        if (this.bpx.isEmpty()) {
            Collections.addAll(this.bpx, Ou());
        }
        return this.bpx;
    }

    @Override // com.baidu.live.view.input.c
    public void hg(String str) {
        List<String> list;
        if (!TextUtils.isEmpty(str) && this.bpx != null && !this.bpx.isEmpty() && this.bpx.indexOf(str) > 1) {
            if (this.bpx.remove(str)) {
                this.bpx.add(1, str);
            }
            if (this.bpz != null && this.bpz.aIU != null && (list = this.bpz.aIU.sortedTexts) != null && !list.isEmpty()) {
                list.clear();
                list.addAll(this.bpx);
                return;
            }
            aj ajVar = com.baidu.live.z.a.Pq().bmJ;
            if (ajVar != null) {
                QuickImInputData quickImInputData = ajVar.aLS;
                if (quickImInputData == null) {
                    quickImInputData = new QuickImInputData();
                }
                if (quickImInputData.sortedTexts == null) {
                    quickImInputData.sortedTexts = new ArrayList();
                }
                quickImInputData.sortedTexts.clear();
                quickImInputData.sortedTexts.addAll(this.bpx);
            }
        }
    }

    @Override // com.baidu.live.view.input.c
    public void GS() {
        if (this.bpv != null) {
            if (this.bpx != null) {
                this.bpx.clear();
            }
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.bpv.dismiss();
            }
            this.bpv = null;
            Oz();
            OA();
            MessageManager.getInstance().unRegisterListener(this.blw);
            OB();
        }
    }

    @Override // com.baidu.live.view.input.c
    public void release() {
        GS();
    }

    private String[] Ou() {
        if (this.bpw == null || this.bpw.length == 0) {
            List<String> Ov = Ov();
            if (Ov != null && !Ov.isEmpty()) {
                this.bpw = (String[]) Ov.toArray(new String[Ov.size()]);
            } else {
                this.bpw = Ow();
            }
        }
        return this.bpw;
    }

    private List<String> Ov() {
        List<String> list;
        List<String> list2;
        ArrayList arrayList = new ArrayList();
        if (this.bpz == null || this.bpz.aIU == null || (list = this.bpz.aIU.sortedTexts) == null || list.isEmpty()) {
            list = arrayList;
        }
        if (list == null || list.isEmpty()) {
            aj ajVar = com.baidu.live.z.a.Pq().bmJ;
            if (ajVar == null) {
                return null;
            }
            QuickImInputData quickImInputData = ajVar.aLS;
            if (quickImInputData == null || (list2 = quickImInputData.originTexts) == null || list2.isEmpty()) {
                return null;
            }
            return list2;
        }
        return list;
    }

    private String[] Ow() {
        return new String[]{"66666", "牛批牛批", "赤道以北，主播最美", "全民女神", "哈哈哈哈哈哈", "扎心了", "老铁，走一个", "请开始你的表演"};
    }

    private void Ox() {
        if (this.bpy == null) {
            this.bpy = new CustomMessageListener(2913122) { // from class: com.baidu.live.quick.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.bpv != null && a.this.bpv.isShowing()) {
                        a.this.bpv.OD();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bpy);
        }
    }

    private void Oy() {
        if (this.bkc == null) {
            this.bkc = new CustomMessageListener(2913095) { // from class: com.baidu.live.quick.a.6
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
            MessageManager.getInstance().registerListener(this.bkc);
        }
    }

    private void Oz() {
        if (this.bpy != null) {
            MessageManager.getInstance().unRegisterListener(this.bpy);
            this.bpy = null;
        }
    }

    private void OA() {
        if (this.bkc != null) {
            MessageManager.getInstance().unRegisterListener(this.bkc);
        }
    }

    private void OB() {
        if (this.bcQ != null) {
            MessageManager.getInstance().unRegisterListener(this.bcQ);
        }
    }

    private void Jb() {
        if (this.bcQ == null) {
            this.bcQ = new CustomMessageListener(2913097) { // from class: com.baidu.live.quick.a.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.mDialog != null && a.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        a.this.mDialog.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bcQ);
        }
    }
}
