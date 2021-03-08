package com.baidu.live.yuyinquick;

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
import com.baidu.live.gift.aj;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.data.YuyinImForbiddenStateData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.view.input.e;
import com.baidu.live.yuyinquick.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes10.dex */
public class b implements e {
    private cr aFE;
    private int beM;
    public CustomMessageListener bhY;
    private CustomMessageListener bqt;
    private boolean bsd;
    private int bsf;
    private AlaLiveInfoData bsm;
    private String[] bzk;
    private List<String> bzl;
    private CustomMessageListener bzm;
    private e.a cfJ;
    private a cfK;
    private BdAlertDialog mDialog;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private int mPos;
    private String mText;
    private String mUserName;
    private String mVid;
    private int bsh = 0;
    public CustomMessageListener bqe = new CustomMessageListener(2913193) { // from class: com.baidu.live.yuyinquick.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.bsh == 5) {
                if (customResponsedMessage.getData() instanceof YuyinImForbiddenStateData) {
                    YuyinImForbiddenStateData yuyinImForbiddenStateData = (YuyinImForbiddenStateData) customResponsedMessage.getData();
                    if (yuyinImForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_im_ban_no_net_tips));
                        return;
                    } else if (yuyinImForbiddenStateData.banState == 0) {
                        b.this.a(b.this.mPos, b.this.mText, b.this.aFE);
                    } else {
                        b.this.a(yuyinImForbiddenStateData);
                    }
                }
                b.this.bsh = 0;
            }
        }
    };

    @Override // com.baidu.live.view.input.e
    public void a(e.a aVar) {
        this.cfJ = aVar;
    }

    @Override // com.baidu.live.view.input.e
    public void b(ab abVar, String str) {
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

    @Override // com.baidu.live.view.input.e
    public void d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.cfK = new a(this.mPageContext);
        this.cfK.a(new a.InterfaceC0248a() { // from class: com.baidu.live.yuyinquick.b.1
            @Override // com.baidu.live.yuyinquick.a.InterfaceC0248a
            public boolean Kk() {
                return b.this.cfJ != null && b.this.cfJ.Kk();
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0248a
            public void onShow() {
                if (b.this.cfJ != null) {
                    b.this.cfJ.XV();
                }
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0248a
            public void onDismiss() {
                if (b.this.cfJ != null) {
                    b.this.cfJ.XW();
                }
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0248a
            public void b(int i, String str, cr crVar) {
                b.this.mPos = i;
                b.this.mText = str;
                b.this.aFE = crVar;
                if (com.baidu.live.ae.a.Qm().bwx.aOF == 1 && !LoginManager.getInstance(b.this.mPageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.ae.a.Qm().bwx.aOE == 1) {
                    if (!b.this.bsd) {
                        b.this.a(i, str, crVar);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    b.this.bsh = 5;
                } else {
                    b.this.a(i, str, crVar);
                }
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0248a
            public boolean KZ() {
                return b.this.cfJ != null && b.this.cfJ.KZ();
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0248a
            public int Kq() {
                if (b.this.cfJ != null) {
                    return b.this.cfJ.Kq();
                }
                return 0;
            }
        });
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.cfK.a(Pp(), Mf());
            aj.gr("quick_im");
        }
    }

    private boolean Mf() {
        return (this.bsm == null || this.bsm.mAlaLiveSwitchData == null || !this.bsm.mAlaLiveSwitchData.isYuyinPayBarrageUnabled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, cr crVar) {
        if (this.cfJ != null && this.cfJ.Kk()) {
            ImSendMsgData imSendMsgData = new ImSendMsgData(str);
            if (crVar != null) {
                imSendMsgData.msgType = (short) 126;
                imSendMsgData.barrageType = crVar.type;
                imSendMsgData.barrageId = crVar.id;
                imSendMsgData.price = crVar.price;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
        }
        gF(str);
        this.cfK.dismiss();
        LogManager.getCommonLogger().doClickQuickImListLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
    }

    @Override // com.baidu.live.view.input.e
    public void b(boolean z, int i, int i2, String str) {
        this.bsd = z;
        this.bsf = i;
        this.beM = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YuyinImForbiddenStateData yuyinImForbiddenStateData) {
        String format;
        final Activity pageActivity = this.mPageContext.getPageActivity();
        if (pageActivity != null) {
            if (yuyinImForbiddenStateData.globalBan == 1) {
                if (yuyinImForbiddenStateData.foreverInfo != null && yuyinImForbiddenStateData.foreverInfo.bqT == 1) {
                    format = pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_block);
                } else {
                    format = String.format(pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_forever), yuyinImForbiddenStateData.foreverInfo.bqU);
                }
                this.mDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.mDialog.setMessage(format);
                this.mDialog.setPositiveButton(pageActivity.getResources().getString(a.h.ala_forbidden_words_btn_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.yuyinquick.b.3
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
                this.mDialog.setNegativeButton(pageActivity.getResources().getString(a.h.ala_forbidden_words_btn_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.yuyinquick.b.4
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
            } else if (yuyinImForbiddenStateData.anchorBan == 1) {
                BdUtilHelper.showToast(pageActivity, pageActivity.getResources().getString(a.h.ala_forbidden_words_is_block_2));
            } else if (yuyinImForbiddenStateData.liveBan == 1) {
                BdUtilHelper.showToast(pageActivity, pageActivity.getResources().getString(a.h.ala_forbidden_words_is_block_1));
            }
        }
    }

    @Override // com.baidu.live.view.input.e
    public List<String> Po() {
        QuickImInputData quickImInputData;
        List<String> list;
        if (this.bzl == null) {
            this.bzl = new ArrayList();
        }
        this.bzl.clear();
        ar arVar = com.baidu.live.ae.a.Qm().bwx;
        if (arVar != null && (quickImInputData = arVar.aOf) != null && (list = quickImInputData.sortedTexts) != null && !list.isEmpty()) {
            this.bzl.addAll(list);
        }
        if (this.bzl.isEmpty()) {
            Collections.addAll(this.bzl, Pp());
        }
        return this.bzl;
    }

    @Override // com.baidu.live.view.input.e
    public void gF(String str) {
        if (!TextUtils.isEmpty(str) && this.bzl != null && !this.bzl.isEmpty() && this.bzl.indexOf(str) > 1) {
            if (this.bzl.remove(str)) {
                this.bzl.add(1, str);
            }
            ar arVar = com.baidu.live.ae.a.Qm().bwx;
            if (arVar != null) {
                QuickImInputData quickImInputData = arVar.aOf;
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

    @Override // com.baidu.live.view.input.e
    public void FB() {
        if (this.cfK != null) {
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.cfK.dismiss();
            }
            this.cfK = null;
            Pu();
            Pv();
            MessageManager.getInstance().unRegisterListener(this.bqe);
            Pw();
        }
    }

    @Override // com.baidu.live.view.input.e
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
        QuickImInputData quickImInputData;
        List<String> list;
        ar arVar = com.baidu.live.ae.a.Qm().bwx;
        if (arVar == null || (quickImInputData = arVar.aOf) == null || (list = quickImInputData.originTexts) == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    private String[] Pr() {
        return new String[]{"终于等到你", "这个声音我爱了", "活捉一只小可爱", "我耳朵都要怀孕了", "求交往", "小姐姐声音真好听"};
    }

    private void Ps() {
        if (this.bzm == null) {
            this.bzm = new CustomMessageListener(2913122) { // from class: com.baidu.live.yuyinquick.b.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (b.this.cfK != null && b.this.cfK.isShowing()) {
                        b.this.cfK.Px();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bzm);
        }
    }

    private void Pt() {
        if (this.bqt == null) {
            this.bqt = new CustomMessageListener(2913095) { // from class: com.baidu.live.yuyinquick.b.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                        String str = (String) customResponsedMessage.getData();
                        if (str == null) {
                            str = "";
                        }
                        b.this.mOtherParams = str;
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
            this.bhY = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyinquick.b.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (b.this.mDialog != null && b.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        b.this.mDialog.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bhY);
        }
    }
}
