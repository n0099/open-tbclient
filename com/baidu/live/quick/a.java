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
    private cg aEh;
    private int aZI;
    public CustomMessageListener bcy;
    private CustomMessageListener bjL;
    private boolean bkX;
    private int bkY;
    private AlaLiveInfoData bld;
    private c.a bpc;
    private b bpd;
    private String[] bpe;
    private List<String> bpf;
    private CustomMessageListener bpg;
    private w bph;
    private BdAlertDialog mDialog;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private int mPos;
    private String mText;
    private String mUserName;
    private String mVid;
    private int bla = 0;
    public CustomMessageListener blf = new CustomMessageListener(2913193) { // from class: com.baidu.live.quick.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && a.this.bla == 5) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        a.this.a(a.this.mPos, a.this.mText, a.this.aEh);
                    } else {
                        a.this.a(imForbiddenStateData);
                    }
                }
                a.this.bla = 0;
            }
        }
    };

    @Override // com.baidu.live.view.input.c
    public void a(c.a aVar) {
        this.bpc = aVar;
    }

    @Override // com.baidu.live.view.input.c
    public void b(w wVar, String str) {
        this.bph = wVar;
        if (wVar != null) {
            this.bld = wVar.mLiveInfo;
        }
        this.mVid = "";
        if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.feed_id != null) {
            this.mVid = wVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        Oo();
        Op();
        MessageManager.getInstance().registerListener(this.blf);
        IT();
    }

    @Override // com.baidu.live.view.input.c
    public void d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bpd = new b(this.mPageContext);
        this.bpd.a(new b.a() { // from class: com.baidu.live.quick.a.1
            @Override // com.baidu.live.quick.b.a
            public boolean Ld() {
                return a.this.bpc != null && a.this.bpc.Ld();
            }

            @Override // com.baidu.live.quick.b.a
            public void Ot() {
                if (a.this.bpc != null) {
                    a.this.bpc.Wj();
                }
            }

            @Override // com.baidu.live.quick.b.a
            public void onDismiss() {
                if (a.this.bpc != null) {
                    a.this.bpc.Wk();
                }
            }

            @Override // com.baidu.live.quick.b.a
            public void b(int i, String str, cg cgVar) {
                a.this.mPos = i;
                a.this.mText = str;
                a.this.aEh = cgVar;
                if (com.baidu.live.aa.a.Ph().bms.aLD == 1 && !LoginManager.getInstance(a.this.mPageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.aa.a.Ph().bms.aLC == 1) {
                    if (!a.this.bkX) {
                        a.this.a(i, str, cgVar);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    a.this.bla = 5;
                } else {
                    a.this.a(i, str, cgVar);
                }
            }

            @Override // com.baidu.live.quick.b.a
            public boolean LE() {
                return a.this.bpc != null && a.this.bpc.LE();
            }

            @Override // com.baidu.live.quick.b.a
            public int Li() {
                if (a.this.bpc != null) {
                    return a.this.bpc.Li();
                }
                return 0;
            }
        });
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.bpd.a(Ol(), Mz());
            aa.gV("quick_im");
        }
    }

    private boolean Mz() {
        return (this.bld == null || this.bld.mAlaLiveSwitchData == null || !this.bld.mAlaLiveSwitchData.isPayBarrageUnabled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, cg cgVar) {
        if (this.bpc != null && this.bpc.Ld()) {
            ImSendMsgData imSendMsgData = new ImSendMsgData(str);
            if (cgVar != null) {
                imSendMsgData.msgType = (short) 126;
                imSendMsgData.barrageType = cgVar.type;
                imSendMsgData.barrageId = cgVar.id;
                imSendMsgData.price = cgVar.price;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
        }
        hh(str);
        this.bpd.dismiss();
        LogManager.getCommonLogger().doClickQuickImListLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
    }

    @Override // com.baidu.live.view.input.c
    public void b(boolean z, int i, int i2, String str) {
        this.bkX = z;
        this.bkY = i;
        this.aZI = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.mPageContext.getPageActivity();
        if (pageActivity != null) {
            if (imForbiddenStateData.globalBan == 1) {
                if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bka == 1) {
                    format = pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_block);
                } else {
                    format = String.format(pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bkb);
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
    public void dE(int i) {
        if (this.bpd != null && this.bpd.isShowing()) {
            this.bpd.dE(i);
        }
    }

    @Override // com.baidu.live.view.input.c
    public List<String> Ok() {
        ak akVar;
        QuickImInputData quickImInputData;
        List<String> list;
        List<String> list2;
        if (this.bpf == null) {
            this.bpf = new ArrayList();
        } else {
            this.bpf.clear();
        }
        if (this.bph != null && this.bph.aIc != null && (list2 = this.bph.aIc.sortedTexts) != null && !list2.isEmpty()) {
            this.bpf.addAll(list2);
        }
        if (this.bpf.isEmpty() && (akVar = com.baidu.live.aa.a.Ph().bms) != null && (quickImInputData = akVar.aLh) != null && (list = quickImInputData.sortedTexts) != null && !list.isEmpty()) {
            this.bpf.addAll(list);
        }
        if (this.bpf.isEmpty()) {
            Collections.addAll(this.bpf, Ol());
        }
        return this.bpf;
    }

    @Override // com.baidu.live.view.input.c
    public void hh(String str) {
        List<String> list;
        if (!TextUtils.isEmpty(str) && this.bpf != null && !this.bpf.isEmpty() && this.bpf.indexOf(str) > 1) {
            if (this.bpf.remove(str)) {
                this.bpf.add(1, str);
            }
            if (this.bph != null && this.bph.aIc != null && (list = this.bph.aIc.sortedTexts) != null && !list.isEmpty()) {
                list.clear();
                list.addAll(this.bpf);
                return;
            }
            ak akVar = com.baidu.live.aa.a.Ph().bms;
            if (akVar != null) {
                QuickImInputData quickImInputData = akVar.aLh;
                if (quickImInputData == null) {
                    quickImInputData = new QuickImInputData();
                }
                if (quickImInputData.sortedTexts == null) {
                    quickImInputData.sortedTexts = new ArrayList();
                }
                quickImInputData.sortedTexts.clear();
                quickImInputData.sortedTexts.addAll(this.bpf);
            }
        }
    }

    @Override // com.baidu.live.view.input.c
    public void GK() {
        if (this.bpd != null) {
            if (this.bpf != null) {
                this.bpf.clear();
            }
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.bpd.dismiss();
            }
            this.bpd = null;
            Oq();
            Or();
            MessageManager.getInstance().unRegisterListener(this.blf);
            Os();
        }
    }

    @Override // com.baidu.live.view.input.c
    public void release() {
        GK();
    }

    private String[] Ol() {
        if (this.bpe == null || this.bpe.length == 0) {
            List<String> Om = Om();
            if (Om != null && !Om.isEmpty()) {
                this.bpe = (String[]) Om.toArray(new String[Om.size()]);
            } else {
                this.bpe = On();
            }
        }
        return this.bpe;
    }

    private List<String> Om() {
        List<String> list;
        List<String> list2;
        ArrayList arrayList = new ArrayList();
        if (this.bph == null || this.bph.aIc == null || (list = this.bph.aIc.sortedTexts) == null || list.isEmpty()) {
            list = arrayList;
        }
        if (list == null || list.isEmpty()) {
            ak akVar = com.baidu.live.aa.a.Ph().bms;
            if (akVar == null) {
                return null;
            }
            QuickImInputData quickImInputData = akVar.aLh;
            if (quickImInputData == null || (list2 = quickImInputData.originTexts) == null || list2.isEmpty()) {
                return null;
            }
            return list2;
        }
        return list;
    }

    private String[] On() {
        return new String[]{"66666", "牛批牛批", "赤道以北，主播最美", "全民女神", "哈哈哈哈哈哈", "扎心了", "老铁，走一个", "请开始你的表演"};
    }

    private void Oo() {
        if (this.bpg == null) {
            this.bpg = new CustomMessageListener(2913122) { // from class: com.baidu.live.quick.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.bpd != null && a.this.bpd.isShowing()) {
                        a.this.bpd.Ou();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bpg);
        }
    }

    private void Op() {
        if (this.bjL == null) {
            this.bjL = new CustomMessageListener(2913095) { // from class: com.baidu.live.quick.a.6
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
            MessageManager.getInstance().registerListener(this.bjL);
        }
    }

    private void Oq() {
        if (this.bpg != null) {
            MessageManager.getInstance().unRegisterListener(this.bpg);
            this.bpg = null;
        }
    }

    private void Or() {
        if (this.bjL != null) {
            MessageManager.getInstance().unRegisterListener(this.bjL);
        }
    }

    private void Os() {
        if (this.bcy != null) {
            MessageManager.getInstance().unRegisterListener(this.bcy);
        }
    }

    private void IT() {
        if (this.bcy == null) {
            this.bcy = new CustomMessageListener(2913097) { // from class: com.baidu.live.quick.a.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.mDialog != null && a.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        a.this.mDialog.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bcy);
        }
    }
}
