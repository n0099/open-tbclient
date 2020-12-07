package com.baidu.live.im.view;

import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.im.d.a;
import com.baidu.live.im.data.ImForbiddenStateData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.view.input.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.view.input.b {
    private int bdi;
    private FrameLayout bpQ;
    private com.baidu.live.im.d.a bpT;
    private boolean bqf;
    private boolean bqg;
    private int bqh;
    private String bqk;
    private int bql;
    private b.a bqs;
    private TbPageContext mContext;
    private BdAlertDialog mDialog;
    private String mOtherParams;
    private String mUserName;
    private String mVid;
    private View mView;
    public boolean bqt = false;
    private int bqj = 0;
    public CustomMessageListener bon = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (a.this.bqj == 3 || a.this.bqj == 4) {
                    if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                        ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                        if (imForbiddenStateData.errno != 0) {
                            BdUtilHelper.showToast(a.this.mContext.getPageActivity(), a.this.mContext.getPageActivity().getResources().getString(a.h.ala_im_ban_no_net_tips));
                            return;
                        } else if (imForbiddenStateData.banState == 0) {
                            if (a.this.bqj == 4) {
                                a.this.F(a.this.bqk, a.this.bql);
                            }
                        } else {
                            a.this.a(imForbiddenStateData);
                        }
                    }
                    a.this.bqj = 0;
                }
            }
        }
    };
    public CustomMessageListener bgy = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.mDialog != null && a.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                a.this.mDialog.dismiss();
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.ala_liveroom_quick_im_layout, (ViewGroup) null);
        this.mView.setClickable(true);
        this.mView.setVisibility(0);
        this.bpQ = (FrameLayout) this.mView.findViewById(a.f.quick_input_header);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913218, com.baidu.live.im.d.a.class, this.mContext);
        if (runTask != null) {
            this.bpT = (com.baidu.live.im.d.a) runTask.getData();
        }
        if (this.bpT != null) {
            this.bpQ.addView(this.bpT.getView());
            this.bpT.setCallback(new a.InterfaceC0194a() { // from class: com.baidu.live.im.view.a.1
                @Override // com.baidu.live.im.d.a.InterfaceC0194a
                public void E(String str, int i) {
                    if (com.baidu.live.ae.a.RB().brA.aOy == 1 && !LoginManager.getInstance(a.this.mContext.getPageActivity()).isIMLogined()) {
                        BdUtilHelper.showToast(a.this.mContext.getPageActivity(), a.this.mContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.ae.a.RB().brA.aOx == 1) {
                        if (a.this.bqg) {
                            a.this.bqk = str;
                            a.this.bql = i;
                            a.this.bqj = 4;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            return;
                        }
                        a.this.F(str, i);
                    } else {
                        a.this.F(str, i);
                    }
                }

                @Override // com.baidu.live.im.d.a.InterfaceC0194a
                public void Ov() {
                    a.this.bpT.setInVisible();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bpe == 1) {
                format = this.mContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(this.mContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bpf);
            }
            this.mDialog = new BdAlertDialog(this.mContext.getPageActivity());
            this.mDialog.setMessage(format);
            this.mDialog.setPositiveButton(this.mContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_btn_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.im.view.a.4
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                        BrowserHelper.startInternalWebActivity(a.this.mContext.getPageActivity(), "https%3A%2F%2Fufosdk.baidu.com%2F%3Fm%3DClient%26a%3DpostViewNew%26appid%3D238780%26needFbtype%3Dtrue%26hasRt%3Dfalse%26hasTitleBar%3Dfalse%26fbtnPlace%3Dbr%26channelId%3D90953");
                    } else {
                        BrowserHelper.startInternalWebActivity(a.this.mContext.getPageActivity(), "https://ufosdk.baidu.com/?m=Client&a=postViewNew&appid=238780&needFbtype=true&hasRt=false&hasTitleBar=false&fbtnPlace=br&channelId=90953");
                    }
                    bdAlertDialog.dismiss();
                }
            });
            this.mDialog.setNegativeButton(this.mContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_btn_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.im.view.a.5
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    bdAlertDialog.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.mDialog.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.e.sdk_dialog_blue_button_txt_selector));
                this.mDialog.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
            } else {
                this.mDialog.setPositiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
                this.mDialog.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.mDialog.create(this.mContext);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(this.mContext.getPageActivity(), this.mContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(this.mContext.getPageActivity(), this.mContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_is_block_1));
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        this.bqg = z;
        this.bqh = i;
        this.bdi = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(String str, int i) {
        u(str, true);
        setClicked(true);
        cp(false);
        LogManager.getCommonLogger().doClickQuickImPanelLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("msg", str);
            jSONObject.put("status", "out");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_QUICK_CLICK).setContentExt(null, "popup", jSONObject));
    }

    @Override // com.baidu.live.view.input.b
    public boolean isClicked() {
        return this.bqt;
    }

    @Override // com.baidu.live.view.input.b
    public void setClicked(boolean z) {
        this.bqt = z;
    }

    private void u(String str, boolean z) {
        if (this.bqs != null) {
            this.bqs.t(str, z);
        }
    }

    @Override // com.baidu.live.view.input.b
    public View getView() {
        return this.mView;
    }

    public void Y(List<String> list) {
        ArrayList arrayList = new ArrayList(list);
        if (this.bpT != null) {
            this.bpT.setData(arrayList.subList(1, arrayList.size()));
            this.bpT.getListView().setShadowWidth(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds80));
            this.bpT.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha100));
            this.bpT.getListView().setSelection(0);
            this.bpT.setInVisible();
        }
    }

    @Override // com.baidu.live.view.input.b
    public boolean OY() {
        return getView().getVisibility() == 0 && this.bpQ.getVisibility() == 0;
    }

    @Override // com.baidu.live.view.input.b
    public void cp(boolean z) {
        if (z) {
            this.mView.setVisibility(0);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913272, true));
            return;
        }
        this.mView.setVisibility(8);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913272, false));
    }

    public void a(b.a aVar) {
        this.bqs = aVar;
    }

    public void setLogData(String str, String str2) {
        if (str == null) {
            str = "";
        }
        this.mVid = str;
        if (str2 == null) {
            str2 = "";
        }
        this.mOtherParams = str2;
    }

    public void ij(String str) {
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
    }

    public void setFromMaster(boolean z) {
        this.bqf = z;
    }

    @Override // com.baidu.live.view.input.b
    public void Do() {
        cp(false);
    }

    @Override // com.baidu.live.view.input.b
    public void en(int i) {
        if (i == 1) {
            if (!isClicked()) {
                cp(true);
            }
        } else if (i == 2) {
            cp(false);
        }
    }
}
