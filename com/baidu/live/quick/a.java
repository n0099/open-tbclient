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
import com.baidu.live.data.bp;
import com.baidu.live.data.q;
import com.baidu.live.data.z;
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
/* loaded from: classes4.dex */
public class a implements c {
    private int aNQ;
    public CustomMessageListener aQz;
    private CustomMessageListener aWT;
    private boolean aXW;
    private int aXX;
    private AlaLiveInfoData aYc;
    private bp awf;
    private c.a bbv;
    private b bbw;
    private String[] bbx;
    private List<String> bby;
    private CustomMessageListener bbz;
    private BdAlertDialog mDialog;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private int mPos;
    private String mText;
    private String mUserName;
    private String mVid;
    private int aXZ = 0;
    public CustomMessageListener aYd = new CustomMessageListener(2913193) { // from class: com.baidu.live.quick.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && a.this.aXZ == 5) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.this.mPageContext.getPageActivity().getResources().getString(a.i.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        a.this.a(a.this.mPos, a.this.mText, a.this.awf);
                    } else {
                        a.this.a(imForbiddenStateData);
                    }
                }
                a.this.aXZ = 0;
            }
        }
    };

    @Override // com.baidu.live.view.input.c
    public void a(c.a aVar) {
        this.bbv = aVar;
    }

    @Override // com.baidu.live.view.input.c
    public void b(q qVar, String str) {
        if (qVar != null) {
            this.aYc = qVar.mLiveInfo;
        }
        this.mVid = "";
        if (qVar != null && qVar.mLiveInfo != null && qVar.mLiveInfo.feed_id != null) {
            this.mVid = qVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        GA();
        GB();
        MessageManager.getInstance().registerListener(this.aYd);
        BH();
    }

    @Override // com.baidu.live.view.input.c
    public void d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bbw = new b(this.mPageContext);
        this.bbw.a(new b.a() { // from class: com.baidu.live.quick.a.1
            @Override // com.baidu.live.quick.b.a
            public boolean DF() {
                return a.this.bbv != null && a.this.bbv.DF();
            }

            @Override // com.baidu.live.quick.b.a
            public void GF() {
                if (a.this.bbv != null) {
                    a.this.bbv.KR();
                }
            }

            @Override // com.baidu.live.quick.b.a
            public void onDismiss() {
                if (a.this.bbv != null) {
                    a.this.bbv.KS();
                }
            }

            @Override // com.baidu.live.quick.b.a
            public void b(int i, String str, bp bpVar) {
                a.this.mPos = i;
                a.this.mText = str;
                a.this.awf = bpVar;
                if (com.baidu.live.v.a.Hs().aZn.aCd == 1 && !LoginManager.getInstance(a.this.mPageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.this.mPageContext.getPageActivity().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.v.a.Hs().aZn.aCc == 1) {
                    if (!a.this.aXW) {
                        a.this.a(i, str, bpVar);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    a.this.aXZ = 5;
                } else {
                    a.this.a(i, str, bpVar);
                }
            }

            @Override // com.baidu.live.quick.b.a
            public boolean Eg() {
                return a.this.bbv != null && a.this.bbv.Eg();
            }

            @Override // com.baidu.live.quick.b.a
            public int DK() {
                if (a.this.bbv != null) {
                    return a.this.bbv.DK();
                }
                return 0;
            }
        });
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.bbw.a(Gx(), EX());
            v.eS("quick_im");
        }
    }

    private boolean EX() {
        return (this.aYc == null || this.aYc.mAlaLiveSwitchData == null || !this.aYc.mAlaLiveSwitchData.mPayBarrageInvalid) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, bp bpVar) {
        if (this.bbv != null && this.bbv.DF()) {
            ImSendMsgData imSendMsgData = new ImSendMsgData(str);
            if (bpVar != null) {
                imSendMsgData.msgType = (short) 126;
                imSendMsgData.barrageType = bpVar.type;
                imSendMsgData.barrageId = bpVar.id;
                imSendMsgData.price = bpVar.price;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
        }
        fb(str);
        this.bbw.dismiss();
        LogManager.getCommonLogger().doClickQuickImListLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
    }

    @Override // com.baidu.live.view.input.c
    public void b(boolean z, int i, int i2, String str) {
        this.aXW = z;
        this.aXX = i;
        this.aNQ = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.mPageContext.getPageActivity();
        if (pageActivity != null) {
            if (imForbiddenStateData.globalBan == 1) {
                if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.aXg == 1) {
                    format = pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_block);
                } else {
                    format = String.format(pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.aXh);
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
    public void bN(int i) {
        if (this.bbw != null && this.bbw.isShowing()) {
            this.bbw.bN(i);
        }
    }

    @Override // com.baidu.live.view.input.c
    public List<String> Gw() {
        QuickImInputData quickImInputData;
        List<String> list;
        if (this.bby == null) {
            this.bby = new ArrayList();
        }
        this.bby.clear();
        z zVar = com.baidu.live.v.a.Hs().aZn;
        if (zVar != null && (quickImInputData = zVar.aBJ) != null && (list = quickImInputData.sortedTexts) != null && !list.isEmpty()) {
            this.bby.addAll(list);
        }
        if (this.bby.isEmpty()) {
            Collections.addAll(this.bby, Gx());
        }
        return this.bby;
    }

    @Override // com.baidu.live.view.input.c
    public void fb(String str) {
        if (!TextUtils.isEmpty(str) && this.bby != null && !this.bby.isEmpty() && this.bby.indexOf(str) > 1) {
            if (this.bby.remove(str)) {
                this.bby.add(1, str);
            }
            z zVar = com.baidu.live.v.a.Hs().aZn;
            if (zVar != null) {
                QuickImInputData quickImInputData = zVar.aBJ;
                if (quickImInputData == null) {
                    quickImInputData = new QuickImInputData();
                }
                if (quickImInputData.sortedTexts == null) {
                    quickImInputData.sortedTexts = new ArrayList();
                }
                quickImInputData.sortedTexts.clear();
                quickImInputData.sortedTexts.addAll(this.bby);
            }
        }
    }

    @Override // com.baidu.live.view.input.c
    public void zy() {
        if (this.bbw != null) {
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.bbw.dismiss();
            }
            this.bbw = null;
            GC();
            GD();
            MessageManager.getInstance().unRegisterListener(this.aYd);
            GE();
        }
    }

    @Override // com.baidu.live.view.input.c
    public void release() {
        zy();
    }

    private String[] Gx() {
        if (this.bbx == null || this.bbx.length == 0) {
            List<String> Gy = Gy();
            if (Gy != null && !Gy.isEmpty()) {
                this.bbx = (String[]) Gy.toArray(new String[Gy.size()]);
            } else {
                this.bbx = Gz();
            }
        }
        return this.bbx;
    }

    private List<String> Gy() {
        QuickImInputData quickImInputData;
        List<String> list;
        z zVar = com.baidu.live.v.a.Hs().aZn;
        if (zVar == null || (quickImInputData = zVar.aBJ) == null || (list = quickImInputData.originTexts) == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    private String[] Gz() {
        return new String[]{"66666", "牛批牛批", "赤道以北，主播最美", "全民女神", "哈哈哈哈哈哈", "扎心了", "老铁，走一个", "请开始你的表演"};
    }

    private void GA() {
        if (this.bbz == null) {
            this.bbz = new CustomMessageListener(2913122) { // from class: com.baidu.live.quick.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.bbw != null && a.this.bbw.isShowing()) {
                        a.this.bbw.GG();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bbz);
        }
    }

    private void GB() {
        if (this.aWT == null) {
            this.aWT = new CustomMessageListener(2913095) { // from class: com.baidu.live.quick.a.6
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
            MessageManager.getInstance().registerListener(this.aWT);
        }
    }

    private void GC() {
        if (this.bbz != null) {
            MessageManager.getInstance().unRegisterListener(this.bbz);
            this.bbz = null;
        }
    }

    private void GD() {
        if (this.aWT != null) {
            MessageManager.getInstance().unRegisterListener(this.aWT);
        }
    }

    private void GE() {
        if (this.aQz != null) {
            MessageManager.getInstance().unRegisterListener(this.aQz);
        }
    }

    private void BH() {
        if (this.aQz == null) {
            this.aQz = new CustomMessageListener(2913097) { // from class: com.baidu.live.quick.a.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.mDialog != null && a.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        a.this.mDialog.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.aQz);
        }
    }
}
