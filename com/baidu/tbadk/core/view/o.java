package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.w;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o extends ImageView {
    private static final int ajZ = w.f.ds340;
    private static final int aka = w.f.ds286;
    private TbPageContext ajP;
    private PopupWindow ajQ;
    private List<NEGFeedBackReasonCheckBox> ajR;
    private com.baidu.tbadk.core.data.ao ajS;
    private SparseArray<String> ajT;
    private int ajU;
    private int ajV;
    private int ajW;
    private int ajX;
    private boolean ajY;
    private a akb;
    private PopupWindow akc;
    private long akd;
    private String[] ake;
    private TextView akf;
    private TextView akg;
    private View.OnClickListener akh;
    private CompoundButton.OnCheckedChangeListener aki;
    private View.OnClickListener akj;
    private PopupWindow.OnDismissListener akk;
    private final CustomMessageListener akl;
    private View.OnTouchListener akm;
    private CustomMessageListener akn;
    private Context mContext;
    private int mWindowHeight;
    private int paddingLeft;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.ao aoVar);

        void a(com.baidu.tbadk.core.data.ao aoVar, CompoundButton compoundButton, boolean z);

        void a(ArrayList<Integer> arrayList, com.baidu.tbadk.core.data.ao aoVar);
    }

    public o(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mContext = null;
        this.ajQ = null;
        this.ajR = null;
        this.ajS = null;
        this.ajT = null;
        this.ajY = false;
        this.akb = null;
        this.akd = 0L;
        this.akh = new p(this);
        this.aki = new q(this);
        this.akj = new r(this);
        this.akk = new s(this);
        this.akl = new t(this, CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW);
        this.akm = new u(this);
        this.akn = new v(this, CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN);
        this.mContext = tbPageContext.getPageActivity();
        this.ajP = tbPageContext;
        this.paddingLeft = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds16);
        init();
    }

    private void init() {
        this.ajW = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32);
        this.ajX = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
        this.mWindowHeight = com.baidu.adp.lib.util.k.g(this.mContext, ajZ);
        this.ajU = com.baidu.adp.lib.util.k.af(this.mContext) - (this.ajW * 2);
        this.ajV = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds120);
        setOnClickListener(this.akh);
        com.baidu.tbadk.core.util.as.c(this, w.g.icon_home_feedback_selector);
        this.ajP.registerListener(this.akn);
        this.ajP.registerListener(this.akl);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.akn != null) {
                this.akn.setTag(bdUniqueId);
            }
            if (this.akl != null) {
                this.akl.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.akn);
            MessageManager.getInstance().registerListener(this.akl);
        }
    }

    public void wr() {
        int g = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds48);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
        layoutParams.height = g;
        setLayoutParams(layoutParams);
        setPadding(this.paddingLeft, 0, this.paddingLeft / 2, 0);
    }

    public void setLeftPadding(int i) {
        setPadding(i, 0, this.paddingLeft / 2, 0);
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(w.j.neg_feedback_popupwindow, (ViewGroup) null);
        this.akf = (TextView) inflate.findViewById(w.h.head_text);
        View findViewById = inflate.findViewById(w.h.divider_line);
        this.akg = (TextView) inflate.findViewById(w.h.forbid_thread_text);
        this.akg.setOnClickListener(this.akj);
        com.baidu.tbadk.core.util.as.j(findViewById, w.e.cp_bg_line_b);
        com.baidu.tbadk.core.util.as.c(this.akf, w.e.cp_cont_d, 1);
        com.baidu.tbadk.core.util.as.c(this.akg, w.e.cp_link_tip_a, 1);
        this.ajR = new ArrayList();
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) inflate.findViewById(w.h.reason_checkbox1);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) inflate.findViewById(w.h.reason_checkbox2);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox3 = (NEGFeedBackReasonCheckBox) inflate.findViewById(w.h.reason_checkbox3);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox4 = (NEGFeedBackReasonCheckBox) inflate.findViewById(w.h.reason_checkbox4);
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.aki);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.aki);
        nEGFeedBackReasonCheckBox3.setOnCheckedChangeListener(this.aki);
        nEGFeedBackReasonCheckBox4.setOnCheckedChangeListener(this.aki);
        this.ajR.add(nEGFeedBackReasonCheckBox);
        this.ajR.add(nEGFeedBackReasonCheckBox2);
        this.ajR.add(nEGFeedBackReasonCheckBox3);
        this.ajR.add(nEGFeedBackReasonCheckBox4);
        if (this.ake != null && this.ake.length == 2) {
            for (int i = 0; i < 2; i++) {
                if (!StringUtils.isNull(this.ake[i])) {
                    this.ajR.get(i).setText(this.ake[i]);
                }
            }
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ws() {
        if (this.mContext != null) {
            this.ajQ = new PopupWindow(getContentView(), this.ajU, this.mWindowHeight);
            this.ajQ.setFocusable(true);
            this.ajQ.setTouchable(true);
            this.ajQ.setOnDismissListener(this.akk);
            this.ajQ.setTouchInterceptor(this.akm);
            if (this.ajT != null && this.ajT.size() != 0) {
                for (int i = 0; i < this.ajT.size(); i++) {
                    String valueAt = this.ajT.valueAt(i);
                    if (com.baidu.tbadk.core.util.aw.dQ(valueAt) > 12) {
                        valueAt = com.baidu.tbadk.core.util.aw.d(valueAt, 6, "...吧");
                    }
                    this.ajR.get(i).setText(valueAt);
                }
                int size = this.ajT.size();
                while (true) {
                    int i2 = size;
                    if (i2 >= com.baidu.tbadk.core.util.z.s(this.ajR)) {
                        break;
                    }
                    this.ajR.get(i2).setVisibility(4);
                    size = i2 + 1;
                }
            }
            View inflate = LayoutInflater.from(this.mContext).inflate(w.j.view_negative_feedback_bottom, (ViewGroup) null);
            this.akc = new PopupWindow(inflate, -1, -1);
            this.akc.showAtLocation(this, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a2 = a(this.mContext, this, this.mWindowHeight, this.ajU, this.ajV, this.ajX, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a2) {
                    this.ajQ.setAnimationStyle(w.m.scale_rb2lt_anim);
                    com.baidu.tbadk.core.util.as.a(this.ajQ, w.g.bg_home_feedback_under);
                } else {
                    this.ajQ.setAnimationStyle(w.m.scale_rt2lb_anim);
                    com.baidu.tbadk.core.util.as.a(this.ajQ, w.g.bg_home_feedback_top);
                }
                this.ajQ.showAtLocation(inflate, 0, iArr[0] - this.ajW, iArr[1]);
                if (this.ajT.size() == 2) {
                    this.ajQ.setHeight(com.baidu.adp.lib.util.k.g(this.mContext, aka));
                }
                if (this.akb != null) {
                    this.akb.a(this.ajS);
                }
            }
        }
    }

    public void wt() {
        if (this.ajQ != null) {
            this.ajQ.dismiss();
            this.ajQ = null;
        }
        if (this.akc != null) {
            this.akc.dismiss();
            this.akc = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.akl);
        MessageManager.getInstance().unRegisterListener(this.akn);
        if (this.akc != null) {
            this.akc.dismiss();
            this.akc = null;
        }
    }

    private boolean a(Context context, View view, int i, int i2, int i3, int i4, int[] iArr) {
        if (context == null || view == null || iArr == null || iArr.length != 2) {
            return false;
        }
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int ag = com.baidu.adp.lib.util.k.ag(context);
        int af = com.baidu.adp.lib.util.k.af(context);
        boolean z = ((ag - iArr2[1]) - height) - i3 < i;
        iArr[0] = af - i2;
        if (z) {
            iArr[1] = (iArr2[1] - i) - i4;
            return z;
        }
        iArr[1] = iArr2[1] + height + i4;
        return z;
    }

    public void setData(com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar != null) {
            this.ajS = aoVar;
            this.ajT = aoVar.qj();
        }
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.util.as.c(this, w.g.icon_home_feedback_selector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(8:4|(7:6|(2:7|(3:9|(4:17|(1:19)|20|21)|22)(0))|28|(1:30)|31|32|33)(0)|27|28|(0)|31|32|33) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0098, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0099, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036 A[Catch: JSONException -> 0x0098, TryCatch #0 {JSONException -> 0x0098, blocks: (B:12:0x0024, B:14:0x0036, B:15:0x003f), top: B:32:0x0024 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject l(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.ajS == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!com.baidu.tbadk.core.util.z.t(this.ajR)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ajR.size()) {
                    NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = this.ajR.get(i2);
                    if (nEGFeedBackReasonCheckBox != null && nEGFeedBackReasonCheckBox.isChecked() && this.ajT != null && this.ajT.size() > i2) {
                        arrayList.add(Integer.valueOf(nEGFeedBackReasonCheckBox.getId()));
                        if (sb.length() != 0) {
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        sb.append(String.valueOf(this.ajT.keyAt(i2)));
                    }
                    i = i2 + 1;
                }
            }
            jSONObject.put("tid", this.ajS.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.ajS.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            return jSONObject;
        }
        jSONObject.put("tid", this.ajS.getTid());
        if (sb.length() != 0) {
        }
        jSONObject.put("fid", this.ajS.getFid());
        jSONObject.put("click_time", System.currentTimeMillis());
        return jSONObject;
    }

    public void setEventCallback(a aVar) {
        this.akb = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.ake = strArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wu() {
        if (this.ajR != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.ajR.size(); i2++) {
                if (this.ajR.get(i2) != null && this.ajR.get(i2).isChecked()) {
                    i++;
                }
            }
            if (i > 0) {
                String str = String.valueOf(getResources().getString(w.l.feedback_selected)) + i + getResources().getString(w.l.feedback_reason);
                SpannableString spannableString = new SpannableString(str);
                UtilHelper.setSpan(spannableString, str, String.valueOf(i), new ForegroundColorSpan(com.baidu.tbadk.core.util.as.getColor(w.e.cp_link_tip_a)));
                this.akf.setText(spannableString);
                this.akg.setText(getResources().getString(w.l.confirm));
                return;
            }
            this.akf.setText(getResources().getString(w.l.tell_us_reason));
            this.akg.setText(getResources().getString(w.l.not_interested));
        }
    }
}
