package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o extends ImageView {
    private PopupWindow afM;
    private List<NEGFeedBackReasonCheckBox> afN;
    private com.baidu.tieba.card.data.c afO;
    private SparseArray<String> afP;
    private int afQ;
    private int afR;
    private int afS;
    private int afT;
    private boolean afU;
    private a afV;
    private View.OnClickListener afW;
    private CompoundButton.OnCheckedChangeListener afX;
    private View.OnClickListener afY;
    private PopupWindow.OnDismissListener afZ;
    private final CustomMessageListener aga;
    private Context mContext;
    private int mWindowHeight;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.card.data.c cVar);

        void a(com.baidu.tieba.card.data.c cVar, CompoundButton compoundButton, boolean z);

        void a(ArrayList<Integer> arrayList, com.baidu.tieba.card.data.c cVar);
    }

    public o(Context context) {
        super(context);
        this.mContext = null;
        this.afM = null;
        this.afN = null;
        this.afO = null;
        this.afP = null;
        this.afU = false;
        this.afV = null;
        this.afW = new p(this);
        this.afX = new q(this);
        this.afY = new r(this);
        this.afZ = new s(this);
        this.aga = new t(this, CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW);
        this.mContext = context;
        init();
    }

    private void init() {
        this.afS = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds32);
        this.afT = -com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds15);
        this.mWindowHeight = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds278);
        this.afQ = com.baidu.adp.lib.util.k.K(this.mContext) - (this.afS * 2);
        this.afR = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds120);
        setOnClickListener(this.afW);
    }

    public void wt() {
        setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds56), -1));
        setPadding(com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds20), 0, 0, 0);
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(r.h.neg_feedback_popupwindow, (ViewGroup) null);
        View findViewById = inflate.findViewById(r.g.divider_line);
        Button button = (Button) inflate.findViewById(r.g.forbid_thread_btn);
        button.setOnClickListener(this.afY);
        at.c((TextView) inflate.findViewById(r.g.head_text), r.d.cp_cont_c, 1);
        at.k(findViewById, r.d.cp_bg_line_b);
        at.k(button, r.f.btn_home_neg_feedback_forbid_selector);
        at.c(button, r.d.cp_cont_b, 3);
        this.afN = new ArrayList();
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) inflate.findViewById(r.g.reason_checkbox1);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) inflate.findViewById(r.g.reason_checkbox2);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox3 = (NEGFeedBackReasonCheckBox) inflate.findViewById(r.g.reason_checkbox3);
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.afX);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.afX);
        nEGFeedBackReasonCheckBox3.setOnCheckedChangeListener(this.afX);
        this.afN.add(nEGFeedBackReasonCheckBox);
        this.afN.add(nEGFeedBackReasonCheckBox2);
        this.afN.add(nEGFeedBackReasonCheckBox3);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wu() {
        if (this.mContext != null) {
            this.afM = new PopupWindow(getContentView(), this.afQ, this.mWindowHeight);
            this.afM.setFocusable(true);
            this.afM.setTouchable(true);
            this.afM.setOnDismissListener(this.afZ);
            if (!this.afU) {
                MessageManager.getInstance().registerListener(this.aga);
                this.afU = true;
            }
            if (this.afP != null && this.afP.size() == 3 && com.baidu.tbadk.core.util.x.s(this.afN) == 3) {
                for (int i = 0; i < this.afP.size(); i++) {
                    String valueAt = this.afP.valueAt(i);
                    if (ax.dG(valueAt) > 8) {
                        valueAt = ax.d(valueAt, 6, "...吧");
                    }
                    this.afN.get(i).setText(valueAt);
                }
            }
            b(this.mContext, 0.5f);
            int[] iArr = new int[2];
            boolean a2 = a(this.mContext, this, this.mWindowHeight, this.afQ, this.afR, this.afT, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a2) {
                    this.afM.setAnimationStyle(r.k.scale_rb2lt_anim);
                    at.a(this.afM, r.f.bg_home_feedback_under);
                } else {
                    this.afM.setAnimationStyle(r.k.scale_rt2lb_anim);
                    at.a(this.afM, r.f.bg_home_feedback_top);
                }
                this.afM.showAtLocation(getRootView(), 0, iArr[0] - this.afS, iArr[1]);
                if (this.afV != null) {
                    this.afV.a(this.afO);
                }
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.afU) {
            MessageManager.getInstance().unRegisterListener(this.aga);
            this.afU = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, float f) {
        Window window;
        WindowManager.LayoutParams attributes;
        if (context != null && (context instanceof Activity) && (window = ((Activity) context).getWindow()) != null && (attributes = window.getAttributes()) != null) {
            attributes.alpha = f;
            if (f == 1.0f) {
                window.clearFlags(2);
            } else {
                window.addFlags(2);
            }
            window.setAttributes(attributes);
        }
    }

    private boolean a(Context context, View view, int i, int i2, int i3, int i4, int[] iArr) {
        if (context == null || view == null || iArr == null || iArr.length != 2) {
            return false;
        }
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int L = com.baidu.adp.lib.util.k.L(context);
        int K = com.baidu.adp.lib.util.k.K(context);
        boolean z = ((L - iArr2[1]) - height) - i3 < i;
        iArr[0] = K - i2;
        if (z) {
            iArr[1] = (iArr2[1] - i) - i4;
            return z;
        }
        iArr[1] = iArr2[1] + height + i4;
        return z;
    }

    public void setData(com.baidu.tieba.card.data.c cVar) {
        if (cVar != null) {
            this.afO = cVar;
            this.afP = cVar.beP;
        }
    }

    public void tB() {
        at.c(this, r.f.icon_home_feedback_selector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(8:6|(7:8|(2:9|(3:11|(4:19|(1:21)|22|23)|24)(0))|30|(1:32)|33|34|35)(0)|29|30|(0)|33|34|35) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a8, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a9, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041 A[Catch: JSONException -> 0x00a8, TryCatch #0 {JSONException -> 0x00a8, blocks: (B:14:0x002c, B:16:0x0041, B:17:0x004a), top: B:34:0x002c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject m(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.afO == null || this.afO.Jz() == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!com.baidu.tbadk.core.util.x.t(this.afN)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.afN.size()) {
                    NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = this.afN.get(i2);
                    if (nEGFeedBackReasonCheckBox != null && nEGFeedBackReasonCheckBox.isChecked() && this.afP != null && this.afP.size() > i2) {
                        arrayList.add(Integer.valueOf(nEGFeedBackReasonCheckBox.getId()));
                        if (sb.length() != 0) {
                            sb.append(",");
                        }
                        sb.append(String.valueOf(this.afP.keyAt(i2)));
                    }
                    i = i2 + 1;
                }
            }
            jSONObject.put("tid", this.afO.Jz().getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.afO.Jz().getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            return jSONObject;
        }
        jSONObject.put("tid", this.afO.Jz().getTid());
        if (sb.length() != 0) {
        }
        jSONObject.put("fid", this.afO.Jz().getFid());
        jSONObject.put("click_time", System.currentTimeMillis());
        return jSONObject;
    }

    public void setEventCallback(a aVar) {
        this.afV = aVar;
    }
}
