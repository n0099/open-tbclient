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
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o extends ImageView {
    private final CustomMessageListener afA;
    private PopupWindow afo;
    private List<NEGFeedBackReasonCheckBox> afp;
    private com.baidu.tieba.card.data.c afq;
    private SparseArray<String> afr;
    private int afs;
    private int aft;
    private int afu;
    private int afv;
    private boolean afw;
    private View.OnClickListener afx;
    private View.OnClickListener afy;
    private PopupWindow.OnDismissListener afz;
    private Context mContext;
    private int mWindowHeight;

    public o(Context context) {
        super(context);
        this.mContext = null;
        this.afo = null;
        this.afp = null;
        this.afq = null;
        this.afr = null;
        this.afw = false;
        this.afx = new p(this);
        this.afy = new q(this);
        this.afz = new r(this);
        this.afA = new s(this, CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW);
        this.mContext = context;
        init();
    }

    private void init() {
        this.afu = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds32);
        this.afv = -com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds15);
        this.mWindowHeight = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds278);
        this.afs = com.baidu.adp.lib.util.k.K(this.mContext) - (this.afu * 2);
        this.aft = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds120);
        setOnClickListener(this.afx);
    }

    public void wp() {
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
        button.setOnClickListener(this.afy);
        av.c((TextView) inflate.findViewById(r.g.head_text), r.d.cp_cont_c, 1);
        av.k(findViewById, r.d.cp_bg_line_b);
        av.k(button, r.f.btn_home_neg_feedback_forbid_selector);
        av.c(button, r.d.cp_cont_b, 3);
        this.afp = new ArrayList();
        this.afp.add((NEGFeedBackReasonCheckBox) inflate.findViewById(r.g.reason_checkbox1));
        this.afp.add((NEGFeedBackReasonCheckBox) inflate.findViewById(r.g.reason_checkbox2));
        this.afp.add((NEGFeedBackReasonCheckBox) inflate.findViewById(r.g.reason_checkbox3));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wq() {
        if (this.mContext != null) {
            this.afo = new PopupWindow(getContentView(), this.afs, this.mWindowHeight);
            this.afo.setFocusable(true);
            this.afo.setTouchable(true);
            this.afo.setOnDismissListener(this.afz);
            if (!this.afw) {
                MessageManager.getInstance().registerListener(this.afA);
                this.afw = true;
            }
            if (this.afr != null && this.afr.size() == 3 && com.baidu.tbadk.core.util.y.s(this.afp) == 3) {
                for (int i = 0; i < this.afr.size(); i++) {
                    String valueAt = this.afr.valueAt(i);
                    if (az.dE(valueAt) > 8) {
                        valueAt = az.d(valueAt, 6, "...吧");
                    }
                    this.afp.get(i).setText(valueAt);
                }
            }
            b(this.mContext, 0.5f);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this, this.mWindowHeight, this.afs, this.aft, this.afv, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.afo.setAnimationStyle(r.k.scale_rb2lt_anim);
                    av.a(this.afo, r.f.bg_home_feedback_under);
                } else {
                    this.afo.setAnimationStyle(r.k.scale_rt2lb_anim);
                    av.a(this.afo, r.f.bg_home_feedback_top);
                }
                this.afo.showAtLocation(getRootView(), 0, iArr[0] - this.afu, iArr[1]);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.afw) {
            MessageManager.getInstance().unRegisterListener(this.afA);
            this.afw = false;
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
            this.afq = cVar;
            this.afr = cVar.bbR;
        }
    }

    public void tx() {
        av.c(this, r.f.icon_home_feedback_selector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(8:5|(7:7|(2:8|(3:10|(4:18|(1:20)|21|22)|23)(0))|29|(1:31)|32|33|34)(0)|28|29|(0)|32|33|34) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009b, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x009c, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0040 A[Catch: JSONException -> 0x009b, TryCatch #0 {JSONException -> 0x009b, blocks: (B:13:0x002a, B:15:0x0040, B:16:0x0049), top: B:33:0x002a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject getSelectedResultJsonObj() {
        JSONObject jSONObject = new JSONObject();
        if (this.afq == null || this.afq.Jv() == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!com.baidu.tbadk.core.util.y.t(this.afp)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.afp.size()) {
                    NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = this.afp.get(i2);
                    if (nEGFeedBackReasonCheckBox != null && nEGFeedBackReasonCheckBox.isChecked() && this.afr != null && this.afr.size() > i2) {
                        if (sb.length() != 0) {
                            sb.append(",");
                        }
                        sb.append(String.valueOf(this.afr.keyAt(i2)));
                    }
                    i = i2 + 1;
                }
            }
            jSONObject.put("tid", this.afq.Jv().getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.afq.Jv().getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            return jSONObject;
        }
        jSONObject.put("tid", this.afq.Jv().getTid());
        if (sb.length() != 0) {
        }
        jSONObject.put("fid", this.afq.Jv().getFid());
        jSONObject.put("click_time", System.currentTimeMillis());
        return jSONObject;
    }
}
