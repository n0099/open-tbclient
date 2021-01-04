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
/* loaded from: classes11.dex */
public class a implements com.baidu.live.view.input.b {
    private int beT;
    private com.baidu.live.im.d.a brB;
    private boolean brN;
    private boolean brO;
    private int brQ;
    private String brT;
    private int brW;
    private FrameLayout bry;
    private c bsf;
    private b.a bsg;
    private TbPageContext mContext;
    private BdAlertDialog mDialog;
    private String mOtherParams;
    private String mUserName;
    private String mVid;
    private View mView;
    public boolean bsh = false;
    private boolean bsi = false;
    private int brS = 0;
    public CustomMessageListener bpW = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (a.this.brS == 3 || a.this.brS == 4) {
                    if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                        ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                        if (imForbiddenStateData.errno != 0) {
                            BdUtilHelper.showToast(a.this.mContext.getPageActivity(), a.this.mContext.getPageActivity().getResources().getString(a.h.ala_im_ban_no_net_tips));
                            return;
                        } else if (imForbiddenStateData.banState == 0) {
                            if (a.this.brS == 4) {
                                a.this.H(a.this.brT, a.this.brW);
                            }
                        } else {
                            a.this.a(imForbiddenStateData);
                        }
                    }
                    a.this.brS = 0;
                }
            }
        }
    };
    public CustomMessageListener bih = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.mDialog != null && a.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                a.this.mDialog.dismiss();
            }
        }
    };
    public CustomMessageListener bsj = new CustomMessageListener(2913288) { // from class: com.baidu.live.im.view.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                a.this.cr(!booleanValue);
                a.this.setClicked(booleanValue);
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        initUI();
        OG();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.ala_liveroom_quick_im_layout, (ViewGroup) null);
        this.mView.setClickable(true);
        this.mView.setVisibility(0);
        this.bry = (FrameLayout) this.mView.findViewById(a.f.quick_input_header);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913218, com.baidu.live.im.d.a.class, this.mContext);
        if (runTask != null) {
            this.brB = (com.baidu.live.im.d.a) runTask.getData();
        }
        if (this.brB != null) {
            this.brB.getView().setClickable(true);
            this.bry.addView(this.brB.getView());
            this.brB.setCallback(new a.InterfaceC0187a() { // from class: com.baidu.live.im.view.a.1
                @Override // com.baidu.live.im.d.a.InterfaceC0187a
                public void G(String str, int i) {
                    if (com.baidu.live.af.a.SE().bwi.aPf == 1 && !LoginManager.getInstance(a.this.mContext.getPageActivity()).isIMLogined()) {
                        BdUtilHelper.showToast(a.this.mContext.getPageActivity(), a.this.mContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.af.a.SE().bwi.aPe == 1) {
                        if (a.this.brO) {
                            a.this.brT = str;
                            a.this.brW = i;
                            a.this.brS = 4;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            return;
                        }
                        a.this.H(str, i);
                    } else {
                        a.this.H(str, i);
                    }
                }

                @Override // com.baidu.live.im.d.a.InterfaceC0187a
                public void Ob() {
                    a.this.brB.setInVisible();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bqL == 1) {
                format = this.mContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(this.mContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bqM);
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
        this.brO = z;
        this.brQ = i;
        this.beT = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(String str, int i) {
        u(str, true);
        setClicked(true);
        cr(false);
        LogManager.getCommonLogger().doClickQuickImPanelLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("msg", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_QUICK_CLICK).setContentExt(null, "popup", "out", jSONObject));
    }

    @Override // com.baidu.live.view.input.b
    public boolean isClicked() {
        return this.bsh;
    }

    @Override // com.baidu.live.view.input.b
    public void setClicked(boolean z) {
        this.bsh = z;
    }

    private void u(String str, boolean z) {
        if (this.bsg != null) {
            this.bsg.t(str, z);
        }
    }

    @Override // com.baidu.live.view.input.b
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.live.view.input.b
    public void h(x xVar) {
        OF();
    }

    private void OF() {
        if (this.bsf == null) {
            this.bsf = new c();
        }
        String str = this.bsf.date;
        if ((!TextUtils.isEmpty(str) || !this.bsf.bsz) && !TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.bsf.bsz = false;
            this.bsf.bsA = 0;
        }
    }

    private void OG() {
        if (this.bsf == null) {
            this.bsf = new c();
        }
        String string = d.Ba().getString("quick_im_entry_show_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b2 = k.b(new Date());
                if (optString.equals(b2)) {
                    this.bsf.bsz = jSONObject.optBoolean("hasInput");
                    this.bsf.date = b2;
                    this.bsf.bsA = jSONObject.optInt("times");
                }
                Log.i("testQuick", "@@ readLocalQuick  spData:" + d.Ba().getString("quick_im_entry_show_times_date", ""));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void OH() {
        if (!this.bsf.bsz) {
            String b2 = k.b(new Date());
            if (b2.equals(this.bsf.date)) {
                this.bsf.bsA++;
            } else {
                this.bsf.date = b2;
                this.bsf.bsA = 1;
            }
            if (com.baidu.live.af.a.SE().bwi != null) {
                if (this.bsf.bsA >= com.baidu.live.af.a.SE().bwi.aOJ) {
                    this.bsf.bsz = true;
                }
                d.Ba().putString("quick_im_entry_show_times_date", this.bsf.toJsonString());
                Log.i("testQuick", "@@ updateQuick saveSpData:" + d.Ba().getString("quick_im_entry_show_times_date", ""));
            }
        }
    }

    public void Y(List<String> list) {
        ArrayList arrayList = new ArrayList(list);
        if (this.brB != null) {
            this.brB.setData(arrayList.subList(0, arrayList.size()));
            this.brB.getListView().setShadowWidth(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds80));
            this.brB.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha100));
            this.brB.getListView().setSelection(0);
            this.brB.setInVisible();
        }
    }

    @Override // com.baidu.live.view.input.b
    public boolean OI() {
        return getView().getVisibility() == 0 && this.bry.getVisibility() == 0;
    }

    @Override // com.baidu.live.view.input.b
    public void cr(boolean z) {
        if (z) {
            this.mView.setVisibility(0);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913272, true));
            return;
        }
        this.mView.setVisibility(8);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913272, false));
    }

    @Override // com.baidu.live.view.input.b
    public boolean OJ() {
        return this.bsf.bsz;
    }

    public void a(b.a aVar) {
        this.bsg = aVar;
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

    public void hU(String str) {
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
    }

    public void setFromMaster(boolean z) {
        this.brN = z;
    }

    @Override // com.baidu.live.view.input.b
    public void Bf() {
        cr(false);
        d.Ba().putString("quick_im_entry_show_times_date", this.bsf.toJsonString());
    }

    @Override // com.baidu.live.view.input.b
    public void cs(boolean z) {
        this.bsi = z;
    }

    @Override // com.baidu.live.view.input.b
    public void el(int i) {
        if (this.bsi) {
            if (i == 1) {
                if (!isClicked()) {
                    cr(true);
                }
            } else if (i == 2) {
                cr(false);
            }
        }
    }
}
