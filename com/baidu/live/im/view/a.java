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
import com.baidu.live.data.x;
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
    private int bad;
    private FrameLayout bmM;
    private com.baidu.live.im.d.a bmP;
    private boolean bnb;
    private boolean bnc;
    private int bne;
    private String bnh;
    private int bnk;
    private c bnt;
    private b.a bnu;
    private TbPageContext mContext;
    private BdAlertDialog mDialog;
    private String mOtherParams;
    private String mUserName;
    private String mVid;
    private View mView;
    public boolean bnv = false;
    private boolean bnw = false;
    private int bng = 0;
    public CustomMessageListener blj = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (a.this.bng == 3 || a.this.bng == 4) {
                    if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                        ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                        if (imForbiddenStateData.errno != 0) {
                            BdUtilHelper.showToast(a.this.mContext.getPageActivity(), a.this.mContext.getPageActivity().getResources().getString(a.h.ala_im_ban_no_net_tips));
                            return;
                        } else if (imForbiddenStateData.banState == 0) {
                            if (a.this.bng == 4) {
                                a.this.H(a.this.bnh, a.this.bnk);
                            }
                        } else {
                            a.this.a(imForbiddenStateData);
                        }
                    }
                    a.this.bng = 0;
                }
            }
        }
    };
    public CustomMessageListener bdo = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.mDialog != null && a.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                a.this.mDialog.dismiss();
            }
        }
    };
    public CustomMessageListener bnx = new CustomMessageListener(2913288) { // from class: com.baidu.live.im.view.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                a.this.cn(!booleanValue);
                a.this.setClicked(booleanValue);
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        initUI();
        KL();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.ala_liveroom_quick_im_layout, (ViewGroup) null);
        this.mView.setClickable(true);
        this.mView.setVisibility(0);
        this.bmM = (FrameLayout) this.mView.findViewById(a.f.quick_input_header);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913218, com.baidu.live.im.d.a.class, this.mContext);
        if (runTask != null) {
            this.bmP = (com.baidu.live.im.d.a) runTask.getData();
        }
        if (this.bmP != null) {
            this.bmP.getView().setClickable(true);
            this.bmM.addView(this.bmP.getView());
            this.bmP.setCallback(new a.InterfaceC0178a() { // from class: com.baidu.live.im.view.a.1
                @Override // com.baidu.live.im.d.a.InterfaceC0178a
                public void G(String str, int i) {
                    if (com.baidu.live.af.a.OJ().bru.aKs == 1 && !LoginManager.getInstance(a.this.mContext.getPageActivity()).isIMLogined()) {
                        BdUtilHelper.showToast(a.this.mContext.getPageActivity(), a.this.mContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.af.a.OJ().bru.aKr == 1) {
                        if (a.this.bnc) {
                            a.this.bnh = str;
                            a.this.bnk = i;
                            a.this.bng = 4;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            return;
                        }
                        a.this.H(str, i);
                    } else {
                        a.this.H(str, i);
                    }
                }

                @Override // com.baidu.live.im.d.a.InterfaceC0178a
                public void Kg() {
                    a.this.bmP.setInVisible();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.blY == 1) {
                format = this.mContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(this.mContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.blZ);
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
        this.bnc = z;
        this.bne = i;
        this.bad = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(String str, int i) {
        u(str, true);
        setClicked(true);
        cn(false);
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
        return this.bnv;
    }

    @Override // com.baidu.live.view.input.b
    public void setClicked(boolean z) {
        this.bnv = z;
    }

    private void u(String str, boolean z) {
        if (this.bnu != null) {
            this.bnu.t(str, z);
        }
    }

    @Override // com.baidu.live.view.input.b
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.live.view.input.b
    public void h(x xVar) {
        KK();
    }

    private void KK() {
        if (this.bnt == null) {
            this.bnt = new c();
        }
        String str = this.bnt.date;
        if ((!TextUtils.isEmpty(str) || !this.bnt.bnN) && !TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.bnt.bnN = false;
            this.bnt.bnO = 0;
        }
    }

    private void KL() {
        if (this.bnt == null) {
            this.bnt = new c();
        }
        String string = d.xf().getString("quick_im_entry_show_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b2 = k.b(new Date());
                if (optString.equals(b2)) {
                    this.bnt.bnN = jSONObject.optBoolean("hasInput");
                    this.bnt.date = b2;
                    this.bnt.bnO = jSONObject.optInt("times");
                }
                Log.i("testQuick", "@@ readLocalQuick  spData:" + d.xf().getString("quick_im_entry_show_times_date", ""));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void KM() {
        if (!this.bnt.bnN) {
            String b2 = k.b(new Date());
            if (b2.equals(this.bnt.date)) {
                this.bnt.bnO++;
            } else {
                this.bnt.date = b2;
                this.bnt.bnO = 1;
            }
            if (com.baidu.live.af.a.OJ().bru != null) {
                if (this.bnt.bnO >= com.baidu.live.af.a.OJ().bru.aJW) {
                    this.bnt.bnN = true;
                }
                d.xf().putString("quick_im_entry_show_times_date", this.bnt.toJsonString());
                Log.i("testQuick", "@@ updateQuick saveSpData:" + d.xf().getString("quick_im_entry_show_times_date", ""));
            }
        }
    }

    public void Y(List<String> list) {
        ArrayList arrayList = new ArrayList(list);
        if (this.bmP != null) {
            this.bmP.setData(arrayList.subList(0, arrayList.size()));
            this.bmP.getListView().setShadowWidth(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds80));
            this.bmP.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha100));
            this.bmP.getListView().setSelection(0);
            this.bmP.setInVisible();
        }
    }

    @Override // com.baidu.live.view.input.b
    public boolean KN() {
        return getView().getVisibility() == 0 && this.bmM.getVisibility() == 0;
    }

    @Override // com.baidu.live.view.input.b
    public void cn(boolean z) {
        if (z) {
            this.mView.setVisibility(0);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913272, true));
            return;
        }
        this.mView.setVisibility(8);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913272, false));
    }

    @Override // com.baidu.live.view.input.b
    public boolean KO() {
        return this.bnt.bnN;
    }

    public void a(b.a aVar) {
        this.bnu = aVar;
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

    public void gJ(String str) {
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
    }

    public void setFromMaster(boolean z) {
        this.bnb = z;
    }

    @Override // com.baidu.live.view.input.b
    public void xk() {
        cn(false);
        d.xf().putString("quick_im_entry_show_times_date", this.bnt.toJsonString());
    }

    @Override // com.baidu.live.view.input.b
    public void co(boolean z) {
        this.bnw = z;
    }

    @Override // com.baidu.live.view.input.b
    public void cF(int i) {
        if (this.bnw) {
            if (i == 1) {
                if (!isClicked()) {
                    cn(true);
                }
            } else if (i == 2) {
                cn(false);
            }
        }
    }
}
