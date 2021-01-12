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
import com.baidu.live.data.an;
import com.baidu.live.data.ck;
import com.baidu.live.data.x;
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
    private ck aCr;
    private int bad;
    public CustomMessageListener bdo;
    private CustomMessageListener bly;
    private boolean bnc;
    private int bne;
    private AlaLiveInfoData bnl;
    private String[] bun;
    private List<String> buo;
    private CustomMessageListener bup;
    private e.a cad;
    private a cae;
    private BdAlertDialog mDialog;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private int mPos;
    private String mText;
    private String mUserName;
    private String mVid;
    private int bng = 0;
    public CustomMessageListener blj = new CustomMessageListener(2913193) { // from class: com.baidu.live.yuyinquick.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.bng == 5) {
                if (customResponsedMessage.getData() instanceof YuyinImForbiddenStateData) {
                    YuyinImForbiddenStateData yuyinImForbiddenStateData = (YuyinImForbiddenStateData) customResponsedMessage.getData();
                    if (yuyinImForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_im_ban_no_net_tips));
                        return;
                    } else if (yuyinImForbiddenStateData.banState == 0) {
                        b.this.a(b.this.mPos, b.this.mText, b.this.aCr);
                    } else {
                        b.this.a(yuyinImForbiddenStateData);
                    }
                }
                b.this.bng = 0;
            }
        }
    };

    @Override // com.baidu.live.view.input.e
    public void a(e.a aVar) {
        this.cad = aVar;
    }

    @Override // com.baidu.live.view.input.e
    public void b(x xVar, String str) {
        if (xVar != null) {
            this.bnl = xVar.mLiveInfo;
        }
        this.mVid = "";
        if (xVar != null && xVar.mLiveInfo != null && xVar.mLiveInfo.feed_id != null) {
            this.mVid = xVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        NQ();
        NR();
        MessageManager.getInstance().registerListener(this.blj);
        Gz();
    }

    @Override // com.baidu.live.view.input.e
    public void d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.cae = new a(this.mPageContext);
        this.cae.a(new a.InterfaceC0241a() { // from class: com.baidu.live.yuyinquick.b.1
            @Override // com.baidu.live.yuyinquick.a.InterfaceC0241a
            public boolean IJ() {
                return b.this.cad != null && b.this.cad.IJ();
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0241a
            public void onShow() {
                if (b.this.cad != null) {
                    b.this.cad.Wh();
                }
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0241a
            public void onDismiss() {
                if (b.this.cad != null) {
                    b.this.cad.Wi();
                }
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0241a
            public void b(int i, String str, ck ckVar) {
                b.this.mPos = i;
                b.this.mText = str;
                b.this.aCr = ckVar;
                if (com.baidu.live.af.a.OJ().bru.aKs == 1 && !LoginManager.getInstance(b.this.mPageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.af.a.OJ().bru.aKr == 1) {
                    if (!b.this.bnc) {
                        b.this.a(i, str, ckVar);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    b.this.bng = 5;
                } else {
                    b.this.a(i, str, ckVar);
                }
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0241a
            public boolean Jy() {
                return b.this.cad != null && b.this.cad.Jy();
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0241a
            public int IP() {
                if (b.this.cad != null) {
                    return b.this.cad.IP();
                }
                return 0;
            }
        });
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.cae.a(NN(), KE());
            aj.fP("quick_im");
        }
    }

    private boolean KE() {
        return (this.bnl == null || this.bnl.mAlaLiveSwitchData == null || !this.bnl.mAlaLiveSwitchData.isYuyinPayBarrageUnabled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, ck ckVar) {
        if (this.cad != null && this.cad.IJ()) {
            ImSendMsgData imSendMsgData = new ImSendMsgData(str);
            if (ckVar != null) {
                imSendMsgData.msgType = (short) 126;
                imSendMsgData.barrageType = ckVar.type;
                imSendMsgData.barrageId = ckVar.id;
                imSendMsgData.price = ckVar.price;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
        }
        gb(str);
        this.cae.dismiss();
        LogManager.getCommonLogger().doClickQuickImListLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
    }

    @Override // com.baidu.live.view.input.e
    public void b(boolean z, int i, int i2, String str) {
        this.bnc = z;
        this.bne = i;
        this.bad = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YuyinImForbiddenStateData yuyinImForbiddenStateData) {
        String format;
        final Activity pageActivity = this.mPageContext.getPageActivity();
        if (pageActivity != null) {
            if (yuyinImForbiddenStateData.globalBan == 1) {
                if (yuyinImForbiddenStateData.foreverInfo != null && yuyinImForbiddenStateData.foreverInfo.blY == 1) {
                    format = pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_block);
                } else {
                    format = String.format(pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_forever), yuyinImForbiddenStateData.foreverInfo.blZ);
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
    public List<String> NM() {
        QuickImInputData quickImInputData;
        List<String> list;
        if (this.buo == null) {
            this.buo = new ArrayList();
        }
        this.buo.clear();
        an anVar = com.baidu.live.af.a.OJ().bru;
        if (anVar != null && (quickImInputData = anVar.aJU) != null && (list = quickImInputData.sortedTexts) != null && !list.isEmpty()) {
            this.buo.addAll(list);
        }
        if (this.buo.isEmpty()) {
            Collections.addAll(this.buo, NN());
        }
        return this.buo;
    }

    @Override // com.baidu.live.view.input.e
    public void gb(String str) {
        if (!TextUtils.isEmpty(str) && this.buo != null && !this.buo.isEmpty() && this.buo.indexOf(str) > 1) {
            if (this.buo.remove(str)) {
                this.buo.add(1, str);
            }
            an anVar = com.baidu.live.af.a.OJ().bru;
            if (anVar != null) {
                QuickImInputData quickImInputData = anVar.aJU;
                if (quickImInputData == null) {
                    quickImInputData = new QuickImInputData();
                }
                if (quickImInputData.sortedTexts == null) {
                    quickImInputData.sortedTexts = new ArrayList();
                }
                quickImInputData.sortedTexts.clear();
                quickImInputData.sortedTexts.addAll(this.buo);
            }
        }
    }

    @Override // com.baidu.live.view.input.e
    public void Ei() {
        if (this.cae != null) {
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.cae.dismiss();
            }
            this.cae = null;
            NS();
            NT();
            MessageManager.getInstance().unRegisterListener(this.blj);
            NU();
        }
    }

    @Override // com.baidu.live.view.input.e
    public void release() {
        Ei();
    }

    private String[] NN() {
        if (this.bun == null || this.bun.length == 0) {
            List<String> NO = NO();
            if (NO != null && !NO.isEmpty()) {
                this.bun = (String[]) NO.toArray(new String[NO.size()]);
            } else {
                this.bun = NP();
            }
        }
        return this.bun;
    }

    private List<String> NO() {
        QuickImInputData quickImInputData;
        List<String> list;
        an anVar = com.baidu.live.af.a.OJ().bru;
        if (anVar == null || (quickImInputData = anVar.aJU) == null || (list = quickImInputData.originTexts) == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    private String[] NP() {
        return new String[]{"终于等到你", "这个声音我爱了", "活捉一只小可爱", "我耳朵都要怀孕了", "求交往", "小姐姐声音真好听"};
    }

    private void NQ() {
        if (this.bup == null) {
            this.bup = new CustomMessageListener(2913122) { // from class: com.baidu.live.yuyinquick.b.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (b.this.cae != null && b.this.cae.isShowing()) {
                        b.this.cae.NV();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bup);
        }
    }

    private void NR() {
        if (this.bly == null) {
            this.bly = new CustomMessageListener(2913095) { // from class: com.baidu.live.yuyinquick.b.6
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
            MessageManager.getInstance().registerListener(this.bly);
        }
    }

    private void NS() {
        if (this.bup != null) {
            MessageManager.getInstance().unRegisterListener(this.bup);
            this.bup = null;
        }
    }

    private void NT() {
        if (this.bly != null) {
            MessageManager.getInstance().unRegisterListener(this.bly);
        }
    }

    private void NU() {
        if (this.bdo != null) {
            MessageManager.getInstance().unRegisterListener(this.bdo);
        }
    }

    private void Gz() {
        if (this.bdo == null) {
            this.bdo = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyinquick.b.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (b.this.mDialog != null && b.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        b.this.mDialog.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bdo);
        }
    }
}
