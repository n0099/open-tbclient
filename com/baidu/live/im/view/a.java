package com.baidu.live.im.view;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.d;
import com.baidu.live.data.ab;
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
import com.baidu.live.utils.k;
import com.baidu.live.view.input.b;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a implements com.baidu.live.view.input.b {
    private int beM;
    private FrameLayout brN;
    private com.baidu.live.im.d.a brQ;
    private boolean bsc;
    private boolean bsd;
    private int bsf;
    private String bsi;
    private int bsl;
    private c bsu;
    private b.a bsv;
    private TbPageContext mContext;
    private BdAlertDialog mDialog;
    private String mOtherParams;
    private String mUserName;
    private String mVid;
    private View mView;
    public boolean bsw = false;
    private boolean bsx = false;
    private int bsh = 0;
    public CustomMessageListener bqe = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (a.this.bsh == 3 || a.this.bsh == 4) {
                    if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                        ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                        if (imForbiddenStateData.errno != 0) {
                            BdUtilHelper.showToast(a.this.mContext.getPageActivity(), a.this.mContext.getPageActivity().getResources().getString(a.h.ala_im_ban_no_net_tips));
                            return;
                        } else if (imForbiddenStateData.banState == 0) {
                            if (a.this.bsh == 4) {
                                a.this.I(a.this.bsi, a.this.bsl);
                            }
                        } else if (!imForbiddenStateData.hasShowForbiddenToast) {
                            a.this.a(imForbiddenStateData);
                            imForbiddenStateData.hasShowForbiddenToast = true;
                        }
                    }
                    a.this.bsh = 0;
                }
            }
        }
    };
    public CustomMessageListener bhY = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.mDialog != null && a.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                a.this.mDialog.dismiss();
            }
        }
    };
    public CustomMessageListener bsy = new CustomMessageListener(2913288) { // from class: com.baidu.live.im.view.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                a.this.cw(!booleanValue);
                a.this.setClicked(booleanValue);
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        initUI();
        Mm();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.ala_liveroom_quick_im_layout, (ViewGroup) null);
        this.mView.setClickable(true);
        this.mView.setVisibility(0);
        this.brN = (FrameLayout) this.mView.findViewById(a.f.quick_input_header);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913218, com.baidu.live.im.d.a.class, this.mContext);
        if (runTask != null) {
            this.brQ = (com.baidu.live.im.d.a) runTask.getData();
        }
        if (this.brQ != null) {
            this.brQ.getView().setClickable(true);
            this.brN.addView(this.brQ.getView());
            this.brQ.setCallback(new a.InterfaceC0186a() { // from class: com.baidu.live.im.view.a.1
                @Override // com.baidu.live.im.d.a.InterfaceC0186a
                public void H(String str, int i) {
                    if (com.baidu.live.ae.a.Qm().bwx.aOF == 1 && !LoginManager.getInstance(a.this.mContext.getPageActivity()).isIMLogined()) {
                        BdUtilHelper.showToast(a.this.mContext.getPageActivity(), a.this.mContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.ae.a.Qm().bwx.aOE == 1) {
                        if (a.this.bsd) {
                            a.this.bsi = str;
                            a.this.bsl = i;
                            a.this.bsh = 4;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            return;
                        }
                        a.this.I(str, i);
                    } else {
                        a.this.I(str, i);
                    }
                }

                @Override // com.baidu.live.im.d.a.InterfaceC0186a
                public void LI() {
                    a.this.brQ.setInVisible();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bqT == 1) {
                format = this.mContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(this.mContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bqU);
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
        this.bsd = z;
        this.bsf = i;
        this.beM = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(String str, int i) {
        u(str, true);
        setClicked(true);
        cw(false);
        LogManager.getCommonLogger().doClickQuickImPanelLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("msg", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_QUICK_CLICK).setContentExt(null, UbcStatConstant.SubPage.POPUP, "out", jSONObject));
    }

    @Override // com.baidu.live.view.input.b
    public boolean isClicked() {
        return this.bsw;
    }

    @Override // com.baidu.live.view.input.b
    public void setClicked(boolean z) {
        this.bsw = z;
    }

    private void u(String str, boolean z) {
        if (this.bsv != null) {
            this.bsv.t(str, z);
        }
    }

    @Override // com.baidu.live.view.input.b
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.live.view.input.b
    public void g(ab abVar) {
        Ml();
    }

    private void Ml() {
        if (this.bsu == null) {
            this.bsu = new c();
        }
        String str = this.bsu.date;
        if ((!TextUtils.isEmpty(str) || !this.bsu.bsO) && !TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.bsu.bsO = false;
            this.bsu.bsP = 0;
        }
    }

    private void Mm() {
        if (this.bsu == null) {
            this.bsu = new c();
        }
        String string = d.xf().getString("quick_im_entry_show_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = k.b(new Date());
                if (optString.equals(b)) {
                    this.bsu.bsO = jSONObject.optBoolean("hasInput");
                    this.bsu.date = b;
                    this.bsu.bsP = jSONObject.optInt("times");
                }
                Log.i("testQuick", "@@ readLocalQuick  spData:" + d.xf().getString("quick_im_entry_show_times_date", ""));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void Mn() {
        if (!this.bsu.bsO) {
            String b = k.b(new Date());
            if (b.equals(this.bsu.date)) {
                this.bsu.bsP++;
            } else {
                this.bsu.date = b;
                this.bsu.bsP = 1;
            }
            if (com.baidu.live.ae.a.Qm().bwx != null) {
                if (this.bsu.bsP >= com.baidu.live.ae.a.Qm().bwx.aOh) {
                    this.bsu.bsO = true;
                }
                d.xf().putString("quick_im_entry_show_times_date", this.bsu.toJsonString());
                Log.i("testQuick", "@@ updateQuick saveSpData:" + d.xf().getString("quick_im_entry_show_times_date", ""));
            }
        }
    }

    public void Z(List<String> list) {
        ArrayList arrayList = new ArrayList(list);
        if (this.brQ != null) {
            this.brQ.setData(arrayList.subList(0, arrayList.size()));
            this.brQ.getListView().setShadowWidth(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds80));
            this.brQ.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha100));
            this.brQ.getListView().setSelection(0);
            this.brQ.setInVisible();
        }
    }

    @Override // com.baidu.live.view.input.b
    public boolean Mo() {
        return getView().getVisibility() == 0 && this.brN.getVisibility() == 0;
    }

    @Override // com.baidu.live.view.input.b
    public void cw(boolean z) {
        if (z) {
            this.mView.setVisibility(0);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913272, true));
            return;
        }
        this.mView.setVisibility(8);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913272, false));
    }

    @Override // com.baidu.live.view.input.b
    public boolean Mp() {
        return this.bsu.bsO;
    }

    public void a(b.a aVar) {
        this.bsv = aVar;
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

    public void ho(String str) {
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
    }

    public void setFromMaster(boolean z) {
        this.bsc = z;
    }

    @Override // com.baidu.live.view.input.b
    public void xk() {
        cw(false);
        d.xf().putString("quick_im_entry_show_times_date", this.bsu.toJsonString());
    }

    @Override // com.baidu.live.view.input.b
    public void cx(boolean z) {
        this.bsx = z;
    }

    @Override // com.baidu.live.view.input.b
    public void cL(int i) {
        if (this.bsx) {
            if (i == 1) {
                if (!isClicked()) {
                    cw(true);
                }
            } else if (i == 2) {
                cw(false);
            }
        }
    }
}
