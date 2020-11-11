package com.baidu.live.yuyinquick;

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
import com.baidu.live.gift.ah;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.data.YuyinImForbiddenStateData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.view.input.d;
import com.baidu.live.yuyinquick.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements d {
    private cg aFS;
    private d.a bUD;
    private a bUE;
    private int bbu;
    public CustomMessageListener bek;
    private CustomMessageListener blw;
    private boolean bmI;
    private int bmJ;
    private AlaLiveInfoData bmO;
    private String[] bqP;
    private List<String> bqQ;
    private CustomMessageListener bqR;
    private BdAlertDialog mDialog;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private int mPos;
    private String mText;
    private String mUserName;
    private String mVid;
    private int bmL = 0;
    public CustomMessageListener bmQ = new CustomMessageListener(2913193) { // from class: com.baidu.live.yuyinquick.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.bmL == 5) {
                if (customResponsedMessage.getData() instanceof YuyinImForbiddenStateData) {
                    YuyinImForbiddenStateData yuyinImForbiddenStateData = (YuyinImForbiddenStateData) customResponsedMessage.getData();
                    if (yuyinImForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_im_ban_no_net_tips));
                        return;
                    } else if (yuyinImForbiddenStateData.banState == 0) {
                        b.this.a(b.this.mPos, b.this.mText, b.this.aFS);
                    } else {
                        b.this.a(yuyinImForbiddenStateData);
                    }
                }
                b.this.bmL = 0;
            }
        }
    };

    @Override // com.baidu.live.view.input.d
    public void a(d.a aVar) {
        this.bUD = aVar;
    }

    @Override // com.baidu.live.view.input.d
    public void b(w wVar, String str) {
        if (wVar != null) {
            this.bmO = wVar.mLiveInfo;
        }
        this.mVid = "";
        if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.feed_id != null) {
            this.mVid = wVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        OX();
        OY();
        MessageManager.getInstance().registerListener(this.bmQ);
        JC();
    }

    @Override // com.baidu.live.view.input.d
    public void d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bUE = new a(this.mPageContext);
        this.bUE.a(new a.InterfaceC0243a() { // from class: com.baidu.live.yuyinquick.b.1
            @Override // com.baidu.live.yuyinquick.a.InterfaceC0243a
            public boolean LM() {
                return b.this.bUD != null && b.this.bUD.LM();
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0243a
            public void Pc() {
                if (b.this.bUD != null) {
                    b.this.bUD.WS();
                }
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0243a
            public void onDismiss() {
                if (b.this.bUD != null) {
                    b.this.bUD.WT();
                }
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0243a
            public void b(int i, String str, cg cgVar) {
                b.this.mPos = i;
                b.this.mText = str;
                b.this.aFS = cgVar;
                if (com.baidu.live.aa.a.PQ().bod.aNo == 1 && !LoginManager.getInstance(b.this.mPageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.aa.a.PQ().bod.aNn == 1) {
                    if (!b.this.bmI) {
                        b.this.a(i, str, cgVar);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    b.this.bmL = 5;
                } else {
                    b.this.a(i, str, cgVar);
                }
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0243a
            public boolean Mn() {
                return b.this.bUD != null && b.this.bUD.Mn();
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0243a
            public int LR() {
                if (b.this.bUD != null) {
                    return b.this.bUD.LR();
                }
                return 0;
            }
        });
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.bUE.a(OU(), Ni());
            ah.hb("quick_im");
        }
    }

    private boolean Ni() {
        return (this.bmO == null || this.bmO.mAlaLiveSwitchData == null || !this.bmO.mAlaLiveSwitchData.isYuyinPayBarrageUnabled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, cg cgVar) {
        if (this.bUD != null && this.bUD.LM()) {
            ImSendMsgData imSendMsgData = new ImSendMsgData(str);
            if (cgVar != null) {
                imSendMsgData.msgType = (short) 126;
                imSendMsgData.barrageType = cgVar.type;
                imSendMsgData.barrageId = cgVar.id;
                imSendMsgData.price = cgVar.price;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
        }
        hn(str);
        this.bUE.dismiss();
        LogManager.getCommonLogger().doClickQuickImListLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
    }

    @Override // com.baidu.live.view.input.d
    public void b(boolean z, int i, int i2, String str) {
        this.bmI = z;
        this.bmJ = i;
        this.bbu = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YuyinImForbiddenStateData yuyinImForbiddenStateData) {
        String format;
        final Activity pageActivity = this.mPageContext.getPageActivity();
        if (pageActivity != null) {
            if (yuyinImForbiddenStateData.globalBan == 1) {
                if (yuyinImForbiddenStateData.foreverInfo != null && yuyinImForbiddenStateData.foreverInfo.blL == 1) {
                    format = pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_block);
                } else {
                    format = String.format(pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_forever), yuyinImForbiddenStateData.foreverInfo.blM);
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

    @Override // com.baidu.live.view.input.d
    public List<String> OT() {
        QuickImInputData quickImInputData;
        List<String> list;
        if (this.bqQ == null) {
            this.bqQ = new ArrayList();
        }
        this.bqQ.clear();
        ak akVar = com.baidu.live.aa.a.PQ().bod;
        if (akVar != null && (quickImInputData = akVar.aMT) != null && (list = quickImInputData.sortedTexts) != null && !list.isEmpty()) {
            this.bqQ.addAll(list);
        }
        if (this.bqQ.isEmpty()) {
            Collections.addAll(this.bqQ, OU());
        }
        return this.bqQ;
    }

    @Override // com.baidu.live.view.input.d
    public void hn(String str) {
        if (!TextUtils.isEmpty(str) && this.bqQ != null && !this.bqQ.isEmpty() && this.bqQ.indexOf(str) > 1) {
            if (this.bqQ.remove(str)) {
                this.bqQ.add(1, str);
            }
            ak akVar = com.baidu.live.aa.a.PQ().bod;
            if (akVar != null) {
                QuickImInputData quickImInputData = akVar.aMT;
                if (quickImInputData == null) {
                    quickImInputData = new QuickImInputData();
                }
                if (quickImInputData.sortedTexts == null) {
                    quickImInputData.sortedTexts = new ArrayList();
                }
                quickImInputData.sortedTexts.clear();
                quickImInputData.sortedTexts.addAll(this.bqQ);
            }
        }
    }

    @Override // com.baidu.live.view.input.d
    public void Ht() {
        if (this.bUE != null) {
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.bUE.dismiss();
            }
            this.bUE = null;
            OZ();
            Pa();
            MessageManager.getInstance().unRegisterListener(this.bmQ);
            Pb();
        }
    }

    @Override // com.baidu.live.view.input.d
    public void release() {
        Ht();
    }

    private String[] OU() {
        if (this.bqP == null || this.bqP.length == 0) {
            List<String> OV = OV();
            if (OV != null && !OV.isEmpty()) {
                this.bqP = (String[]) OV.toArray(new String[OV.size()]);
            } else {
                this.bqP = OW();
            }
        }
        return this.bqP;
    }

    private List<String> OV() {
        QuickImInputData quickImInputData;
        List<String> list;
        ak akVar = com.baidu.live.aa.a.PQ().bod;
        if (akVar == null || (quickImInputData = akVar.aMT) == null || (list = quickImInputData.originTexts) == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    private String[] OW() {
        return new String[]{"终于等到你", "这个声音我爱了", "活捉一只小可爱", "我耳朵都要怀孕了", "求交往", "小姐姐声音真好听"};
    }

    private void OX() {
        if (this.bqR == null) {
            this.bqR = new CustomMessageListener(2913122) { // from class: com.baidu.live.yuyinquick.b.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (b.this.bUE != null && b.this.bUE.isShowing()) {
                        b.this.bUE.Pd();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bqR);
        }
    }

    private void OY() {
        if (this.blw == null) {
            this.blw = new CustomMessageListener(2913095) { // from class: com.baidu.live.yuyinquick.b.6
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
            MessageManager.getInstance().registerListener(this.blw);
        }
    }

    private void OZ() {
        if (this.bqR != null) {
            MessageManager.getInstance().unRegisterListener(this.bqR);
            this.bqR = null;
        }
    }

    private void Pa() {
        if (this.blw != null) {
            MessageManager.getInstance().unRegisterListener(this.blw);
        }
    }

    private void Pb() {
        if (this.bek != null) {
            MessageManager.getInstance().unRegisterListener(this.bek);
        }
    }

    private void JC() {
        if (this.bek == null) {
            this.bek = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyinquick.b.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (b.this.mDialog != null && b.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        b.this.mDialog.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bek);
        }
    }
}
