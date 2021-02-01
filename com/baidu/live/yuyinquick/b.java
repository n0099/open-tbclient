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
/* loaded from: classes11.dex */
public class b implements e {
    private cr aEe;
    private int bdk;
    public CustomMessageListener bgy;
    private CustomMessageListener boT;
    private boolean bqD;
    private int bqF;
    private AlaLiveInfoData bqM;
    private String[] bxK;
    private List<String> bxL;
    private CustomMessageListener bxM;
    private e.a cej;
    private a cek;
    private BdAlertDialog mDialog;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private int mPos;
    private String mText;
    private String mUserName;
    private String mVid;
    private int bqH = 0;
    public CustomMessageListener boE = new CustomMessageListener(2913193) { // from class: com.baidu.live.yuyinquick.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.bqH == 5) {
                if (customResponsedMessage.getData() instanceof YuyinImForbiddenStateData) {
                    YuyinImForbiddenStateData yuyinImForbiddenStateData = (YuyinImForbiddenStateData) customResponsedMessage.getData();
                    if (yuyinImForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_im_ban_no_net_tips));
                        return;
                    } else if (yuyinImForbiddenStateData.banState == 0) {
                        b.this.a(b.this.mPos, b.this.mText, b.this.aEe);
                    } else {
                        b.this.a(yuyinImForbiddenStateData);
                    }
                }
                b.this.bqH = 0;
            }
        }
    };

    @Override // com.baidu.live.view.input.e
    public void a(e.a aVar) {
        this.cej = aVar;
    }

    @Override // com.baidu.live.view.input.e
    public void b(ab abVar, String str) {
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

    @Override // com.baidu.live.view.input.e
    public void d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.cek = new a(this.mPageContext);
        this.cek.a(new a.InterfaceC0242a() { // from class: com.baidu.live.yuyinquick.b.1
            @Override // com.baidu.live.yuyinquick.a.InterfaceC0242a
            public boolean Kh() {
                return b.this.cej != null && b.this.cej.Kh();
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0242a
            public void onShow() {
                if (b.this.cej != null) {
                    b.this.cej.XS();
                }
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0242a
            public void onDismiss() {
                if (b.this.cej != null) {
                    b.this.cej.XT();
                }
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0242a
            public void b(int i, String str, cr crVar) {
                b.this.mPos = i;
                b.this.mText = str;
                b.this.aEe = crVar;
                if (com.baidu.live.ae.a.Qj().buX.aNf == 1 && !LoginManager.getInstance(b.this.mPageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.ae.a.Qj().buX.aNe == 1) {
                    if (!b.this.bqD) {
                        b.this.a(i, str, crVar);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    b.this.bqH = 5;
                } else {
                    b.this.a(i, str, crVar);
                }
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0242a
            public boolean KW() {
                return b.this.cej != null && b.this.cej.KW();
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0242a
            public int Kn() {
                if (b.this.cej != null) {
                    return b.this.cej.Kn();
                }
                return 0;
            }
        });
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.cek.a(Pm(), Mc());
            aj.gl("quick_im");
        }
    }

    private boolean Mc() {
        return (this.bqM == null || this.bqM.mAlaLiveSwitchData == null || !this.bqM.mAlaLiveSwitchData.isYuyinPayBarrageUnabled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, cr crVar) {
        if (this.cej != null && this.cej.Kh()) {
            ImSendMsgData imSendMsgData = new ImSendMsgData(str);
            if (crVar != null) {
                imSendMsgData.msgType = (short) 126;
                imSendMsgData.barrageType = crVar.type;
                imSendMsgData.barrageId = crVar.id;
                imSendMsgData.price = crVar.price;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
        }
        gz(str);
        this.cek.dismiss();
        LogManager.getCommonLogger().doClickQuickImListLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
    }

    @Override // com.baidu.live.view.input.e
    public void b(boolean z, int i, int i2, String str) {
        this.bqD = z;
        this.bqF = i;
        this.bdk = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YuyinImForbiddenStateData yuyinImForbiddenStateData) {
        String format;
        final Activity pageActivity = this.mPageContext.getPageActivity();
        if (pageActivity != null) {
            if (yuyinImForbiddenStateData.globalBan == 1) {
                if (yuyinImForbiddenStateData.foreverInfo != null && yuyinImForbiddenStateData.foreverInfo.bpt == 1) {
                    format = pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_block);
                } else {
                    format = String.format(pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_forever), yuyinImForbiddenStateData.foreverInfo.bpu);
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
    public List<String> Pl() {
        QuickImInputData quickImInputData;
        List<String> list;
        if (this.bxL == null) {
            this.bxL = new ArrayList();
        }
        this.bxL.clear();
        ar arVar = com.baidu.live.ae.a.Qj().buX;
        if (arVar != null && (quickImInputData = arVar.aMF) != null && (list = quickImInputData.sortedTexts) != null && !list.isEmpty()) {
            this.bxL.addAll(list);
        }
        if (this.bxL.isEmpty()) {
            Collections.addAll(this.bxL, Pm());
        }
        return this.bxL;
    }

    @Override // com.baidu.live.view.input.e
    public void gz(String str) {
        if (!TextUtils.isEmpty(str) && this.bxL != null && !this.bxL.isEmpty() && this.bxL.indexOf(str) > 1) {
            if (this.bxL.remove(str)) {
                this.bxL.add(1, str);
            }
            ar arVar = com.baidu.live.ae.a.Qj().buX;
            if (arVar != null) {
                QuickImInputData quickImInputData = arVar.aMF;
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

    @Override // com.baidu.live.view.input.e
    public void Fy() {
        if (this.cek != null) {
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.cek.dismiss();
            }
            this.cek = null;
            Pr();
            Ps();
            MessageManager.getInstance().unRegisterListener(this.boE);
            Pt();
        }
    }

    @Override // com.baidu.live.view.input.e
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
        QuickImInputData quickImInputData;
        List<String> list;
        ar arVar = com.baidu.live.ae.a.Qj().buX;
        if (arVar == null || (quickImInputData = arVar.aMF) == null || (list = quickImInputData.originTexts) == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    private String[] Po() {
        return new String[]{"终于等到你", "这个声音我爱了", "活捉一只小可爱", "我耳朵都要怀孕了", "求交往", "小姐姐声音真好听"};
    }

    private void Pp() {
        if (this.bxM == null) {
            this.bxM = new CustomMessageListener(2913122) { // from class: com.baidu.live.yuyinquick.b.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (b.this.cek != null && b.this.cek.isShowing()) {
                        b.this.cek.Pu();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bxM);
        }
    }

    private void Pq() {
        if (this.boT == null) {
            this.boT = new CustomMessageListener(2913095) { // from class: com.baidu.live.yuyinquick.b.6
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
            this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyinquick.b.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (b.this.mDialog != null && b.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        b.this.mDialog.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bgy);
        }
    }
}
