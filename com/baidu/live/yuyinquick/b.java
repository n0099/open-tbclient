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
import com.baidu.live.data.aj;
import com.baidu.live.data.ce;
import com.baidu.live.data.w;
import com.baidu.live.gift.ai;
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
    private ce aFc;
    private d.a bOT;
    private a bOU;
    private int bab;
    public CustomMessageListener bcQ;
    private CustomMessageListener bkc;
    private boolean blo;
    private int blp;
    private AlaLiveInfoData blu;
    private String[] bpw;
    private List<String> bpx;
    private CustomMessageListener bpy;
    private BdAlertDialog mDialog;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private int mPos;
    private String mText;
    private String mUserName;
    private String mVid;
    private int blr = 0;
    public CustomMessageListener blw = new CustomMessageListener(2913193) { // from class: com.baidu.live.yuyinquick.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.blr == 5) {
                if (customResponsedMessage.getData() instanceof YuyinImForbiddenStateData) {
                    YuyinImForbiddenStateData yuyinImForbiddenStateData = (YuyinImForbiddenStateData) customResponsedMessage.getData();
                    if (yuyinImForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getResources().getString(a.i.ala_im_ban_no_net_tips));
                        return;
                    } else if (yuyinImForbiddenStateData.banState == 0) {
                        b.this.a(b.this.mPos, b.this.mText, b.this.aFc);
                    } else {
                        b.this.a(yuyinImForbiddenStateData);
                    }
                }
                b.this.blr = 0;
            }
        }
    };

    @Override // com.baidu.live.view.input.d
    public void a(d.a aVar) {
        this.bOT = aVar;
    }

    @Override // com.baidu.live.view.input.d
    public void b(w wVar, String str) {
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

    @Override // com.baidu.live.view.input.d
    public void d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bOU = new a(this.mPageContext);
        this.bOU.a(new a.InterfaceC0231a() { // from class: com.baidu.live.yuyinquick.b.1
            @Override // com.baidu.live.yuyinquick.a.InterfaceC0231a
            public boolean Lm() {
                return b.this.bOT != null && b.this.bOT.Lm();
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0231a
            public void OC() {
                if (b.this.bOT != null) {
                    b.this.bOT.Us();
                }
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0231a
            public void onDismiss() {
                if (b.this.bOT != null) {
                    b.this.bOT.Ut();
                }
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0231a
            public void b(int i, String str, ce ceVar) {
                b.this.mPos = i;
                b.this.mText = str;
                b.this.aFc = ceVar;
                if (com.baidu.live.z.a.Pq().bmJ.aMo == 1 && !LoginManager.getInstance(b.this.mPageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.z.a.Pq().bmJ.aMn == 1) {
                    if (!b.this.blo) {
                        b.this.a(i, str, ceVar);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    b.this.blr = 5;
                } else {
                    b.this.a(i, str, ceVar);
                }
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0231a
            public boolean LN() {
                return b.this.bOT != null && b.this.bOT.LN();
            }

            @Override // com.baidu.live.yuyinquick.a.InterfaceC0231a
            public int Lr() {
                if (b.this.bOT != null) {
                    return b.this.bOT.Lr();
                }
                return 0;
            }
        });
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.bOU.a(Ou(), MI());
            ai.gV("quick_im");
        }
    }

    private boolean MI() {
        return (this.blu == null || this.blu.mAlaLiveSwitchData == null || !this.blu.mAlaLiveSwitchData.isYuyinPayBarrageUnabled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, ce ceVar) {
        if (this.bOT != null && this.bOT.Lm()) {
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
        this.bOU.dismiss();
        LogManager.getCommonLogger().doClickQuickImListLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
    }

    @Override // com.baidu.live.view.input.d
    public void b(boolean z, int i, int i2, String str) {
        this.blo = z;
        this.blp = i;
        this.bab = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YuyinImForbiddenStateData yuyinImForbiddenStateData) {
        String format;
        final Activity pageActivity = this.mPageContext.getPageActivity();
        if (pageActivity != null) {
            if (yuyinImForbiddenStateData.globalBan == 1) {
                if (yuyinImForbiddenStateData.foreverInfo != null && yuyinImForbiddenStateData.foreverInfo.bkr == 1) {
                    format = pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_block);
                } else {
                    format = String.format(pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_forever), yuyinImForbiddenStateData.foreverInfo.bks);
                }
                this.mDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.mDialog.setMessage(format);
                this.mDialog.setPositiveButton(pageActivity.getResources().getString(a.i.ala_forbidden_words_btn_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.yuyinquick.b.3
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
                this.mDialog.setNegativeButton(pageActivity.getResources().getString(a.i.ala_forbidden_words_btn_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.yuyinquick.b.4
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
            } else if (yuyinImForbiddenStateData.anchorBan == 1) {
                BdUtilHelper.showToast(pageActivity, pageActivity.getResources().getString(a.i.ala_forbidden_words_is_block_2));
            } else if (yuyinImForbiddenStateData.liveBan == 1) {
                BdUtilHelper.showToast(pageActivity, pageActivity.getResources().getString(a.i.ala_forbidden_words_is_block_1));
            }
        }
    }

    @Override // com.baidu.live.view.input.d
    public List<String> Ot() {
        QuickImInputData quickImInputData;
        List<String> list;
        if (this.bpx == null) {
            this.bpx = new ArrayList();
        }
        this.bpx.clear();
        aj ajVar = com.baidu.live.z.a.Pq().bmJ;
        if (ajVar != null && (quickImInputData = ajVar.aLT) != null && (list = quickImInputData.sortedTexts) != null && !list.isEmpty()) {
            this.bpx.addAll(list);
        }
        if (this.bpx.isEmpty()) {
            Collections.addAll(this.bpx, Ou());
        }
        return this.bpx;
    }

    @Override // com.baidu.live.view.input.d
    public void hg(String str) {
        if (!TextUtils.isEmpty(str) && this.bpx != null && !this.bpx.isEmpty() && this.bpx.indexOf(str) > 1) {
            if (this.bpx.remove(str)) {
                this.bpx.add(1, str);
            }
            aj ajVar = com.baidu.live.z.a.Pq().bmJ;
            if (ajVar != null) {
                QuickImInputData quickImInputData = ajVar.aLT;
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

    @Override // com.baidu.live.view.input.d
    public void GS() {
        if (this.bOU != null) {
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.bOU.dismiss();
            }
            this.bOU = null;
            Oz();
            OA();
            MessageManager.getInstance().unRegisterListener(this.blw);
            OB();
        }
    }

    @Override // com.baidu.live.view.input.d
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
        QuickImInputData quickImInputData;
        List<String> list;
        aj ajVar = com.baidu.live.z.a.Pq().bmJ;
        if (ajVar == null || (quickImInputData = ajVar.aLT) == null || (list = quickImInputData.originTexts) == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    private String[] Ow() {
        return new String[]{"终于等到你", "这个声音我爱了", "活捉一只小可爱", "我耳朵都要怀孕了", "求交往", "小姐姐声音真好听"};
    }

    private void Ox() {
        if (this.bpy == null) {
            this.bpy = new CustomMessageListener(2913122) { // from class: com.baidu.live.yuyinquick.b.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (b.this.bOU != null && b.this.bOU.isShowing()) {
                        b.this.bOU.OD();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bpy);
        }
    }

    private void Oy() {
        if (this.bkc == null) {
            this.bkc = new CustomMessageListener(2913095) { // from class: com.baidu.live.yuyinquick.b.6
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
            this.bcQ = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyinquick.b.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (b.this.mDialog != null && b.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        b.this.mDialog.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bcQ);
        }
    }
}
