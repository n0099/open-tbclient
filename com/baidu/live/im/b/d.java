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
import com.baidu.live.data.QuickImInputData;
import com.baidu.live.data.be;
import com.baidu.live.data.n;
import com.baidu.live.data.v;
import com.baidu.live.gift.u;
import com.baidu.live.im.data.ImForbiddenStateData;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.view.quick.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.u.a;
import com.baidu.live.view.input.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public class d implements com.baidu.live.view.input.c {
    private int aEi;
    public CustomMessageListener aGM;
    private CustomMessageListener aML;
    private c.a aNa;
    private com.baidu.live.im.view.quick.a aNb;
    private String[] aNc;
    private List<String> aNd;
    private CustomMessageListener aNe;
    private be aNf;
    private boolean aNg;
    private int aNh;
    private int aNi = 0;
    public CustomMessageListener aNj = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.b.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.aNi == 5) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(d.this.mPageContext.getPageActivity(), d.this.mPageContext.getPageActivity().getResources().getString(a.i.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        d.this.a(d.this.mPos, d.this.mText, d.this.aNf);
                    } else {
                        d.this.a(imForbiddenStateData);
                    }
                }
                d.this.aNi = 0;
            }
        }
    };
    private BdAlertDialog mDialog;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private int mPos;
    private String mText;
    private String mUserName;
    private String mVid;

    @Override // com.baidu.live.view.input.c
    public void a(c.a aVar) {
        this.aNa = aVar;
    }

    @Override // com.baidu.live.view.input.c
    public void a(n nVar, String str) {
        this.mVid = "";
        if (nVar != null && nVar.mLiveInfo != null && nVar.mLiveInfo.feed_id != null) {
            this.mVid = nVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        BY();
        BZ();
        MessageManager.getInstance().registerListener(this.aNj);
        zr();
    }

    @Override // com.baidu.live.view.input.c
    public void c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aNb = new com.baidu.live.im.view.quick.a(this.mPageContext.getPageActivity());
        this.aNb.a(new a.InterfaceC0115a() { // from class: com.baidu.live.im.b.d.1
            @Override // com.baidu.live.im.view.quick.a.InterfaceC0115a
            public boolean Bh() {
                return d.this.aNa != null && d.this.aNa.Bh();
            }

            @Override // com.baidu.live.im.view.quick.a.InterfaceC0115a
            public void Cd() {
                if (d.this.aNa != null) {
                    d.this.aNa.HI();
                }
            }

            @Override // com.baidu.live.im.view.quick.a.InterfaceC0115a
            public void onDismiss() {
                if (d.this.aNa != null) {
                    d.this.aNa.HJ();
                }
            }

            @Override // com.baidu.live.im.view.quick.a.InterfaceC0115a
            public void b(int i, String str, be beVar) {
                d.this.mPos = i;
                d.this.mText = str;
                d.this.aNf = beVar;
                if (com.baidu.live.v.a.Eo().aQp.atx == 1 && !LoginManager.getInstance(d.this.mPageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(d.this.mPageContext.getPageActivity(), d.this.mPageContext.getPageActivity().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.v.a.Eo().aQp.atw == 1) {
                    if (!d.this.aNg) {
                        d.this.a(i, str, beVar);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    d.this.aNi = 5;
                } else {
                    d.this.a(i, str, beVar);
                }
            }

            @Override // com.baidu.live.im.view.quick.a.InterfaceC0115a
            public boolean Ce() {
                return d.this.aNa != null && d.this.aNa.Ce();
            }
        });
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.aNb.m(BV());
            u.xe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, be beVar) {
        if (this.aNa != null && this.aNa.Bh()) {
            ImSendMsgData imSendMsgData = new ImSendMsgData(str);
            if (beVar != null) {
                imSendMsgData.msgType = (short) 126;
                imSendMsgData.barrageType = beVar.type;
                imSendMsgData.barrageId = beVar.id;
                imSendMsgData.price = beVar.price;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
        }
        em(str);
        this.aNb.dismiss();
        LogManager.getCommonLogger().doClickQuickImListLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
    }

    @Override // com.baidu.live.view.input.c
    public void b(boolean z, int i, int i2, String str) {
        this.aNg = z;
        this.aNh = i;
        this.aEi = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.mPageContext.getPageActivity();
        if (pageActivity != null) {
            if (imForbiddenStateData.globalBan == 1) {
                if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.aNt == 1) {
                    format = pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_block);
                } else {
                    format = String.format(pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.aNu);
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
    public void cl(int i) {
        if (this.aNb != null && this.aNb.isShowing()) {
            this.aNb.cl(i);
        }
    }

    @Override // com.baidu.live.view.input.c
    public List<String> BU() {
        QuickImInputData quickImInputData;
        List<String> list;
        if (this.aNd == null) {
            this.aNd = new ArrayList();
        }
        this.aNd.clear();
        v vVar = com.baidu.live.v.a.Eo().aQp;
        if (vVar != null && (quickImInputData = vVar.atb) != null && (list = quickImInputData.sortedTexts) != null && !list.isEmpty()) {
            this.aNd.addAll(list);
        }
        if (this.aNd.isEmpty()) {
            Collections.addAll(this.aNd, BV());
        }
        return this.aNd;
    }

    @Override // com.baidu.live.view.input.c
    public void em(String str) {
        if (!TextUtils.isEmpty(str) && this.aNd != null && !this.aNd.isEmpty() && this.aNd.indexOf(str) > 1) {
            if (this.aNd.remove(str)) {
                this.aNd.add(1, str);
            }
            v vVar = com.baidu.live.v.a.Eo().aQp;
            if (vVar != null) {
                QuickImInputData quickImInputData = vVar.atb;
                if (quickImInputData == null) {
                    quickImInputData = new QuickImInputData();
                }
                if (quickImInputData.sortedTexts == null) {
                    quickImInputData.sortedTexts = new ArrayList();
                }
                quickImInputData.sortedTexts.clear();
                quickImInputData.sortedTexts.addAll(this.aNd);
            }
        }
    }

    @Override // com.baidu.live.view.input.c
    public void xj() {
        if (this.aNb != null) {
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.aNb.dismiss();
            }
            this.aNb = null;
            Ca();
            Cb();
            MessageManager.getInstance().unRegisterListener(this.aNj);
            Cc();
        }
    }

    @Override // com.baidu.live.view.input.c
    public void release() {
        xj();
    }

    private String[] BV() {
        if (this.aNc == null || this.aNc.length == 0) {
            List<String> BW = BW();
            if (BW != null && !BW.isEmpty()) {
                this.aNc = (String[]) BW.toArray(new String[BW.size()]);
            } else {
                this.aNc = BX();
            }
        }
        return this.aNc;
    }

    private List<String> BW() {
        QuickImInputData quickImInputData;
        List<String> list;
        v vVar = com.baidu.live.v.a.Eo().aQp;
        if (vVar == null || (quickImInputData = vVar.atb) == null || (list = quickImInputData.originTexts) == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    private String[] BX() {
        return new String[]{"66666", "牛批牛批", "赤道以北，主播最美", "全民女神", "哈哈哈哈哈哈", "扎心了", "老铁，走一个", "请开始你的表演"};
    }

    private void BY() {
        if (this.aNe == null) {
            this.aNe = new CustomMessageListener(2913122) { // from class: com.baidu.live.im.b.d.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (d.this.aNb != null && d.this.aNb.isShowing()) {
                        d.this.aNb.Dh();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.aNe);
        }
    }

    private void BZ() {
        if (this.aML == null) {
            this.aML = new CustomMessageListener(2913095) { // from class: com.baidu.live.im.b.d.6
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
            MessageManager.getInstance().registerListener(this.aML);
        }
    }

    private void Ca() {
        if (this.aNe != null) {
            MessageManager.getInstance().unRegisterListener(this.aNe);
            this.aNe = null;
        }
    }

    private void Cb() {
        if (this.aML != null) {
            MessageManager.getInstance().unRegisterListener(this.aML);
        }
    }

    private void Cc() {
        if (this.aGM != null) {
            MessageManager.getInstance().unRegisterListener(this.aGM);
        }
    }

    private void zr() {
        if (this.aGM == null) {
            this.aGM = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.b.d.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (d.this.mDialog != null && d.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        d.this.mDialog.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.aGM);
        }
    }
}
