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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o extends ImageView {
    private PopupWindow aff;
    private List<NEGFeedBackReasonCheckBox> afg;
    private com.baidu.tieba.card.data.c afh;
    private SparseArray<String> afi;
    private int afj;
    private int afk;
    private int afl;
    private int afm;
    private boolean afn;
    private a afo;
    private View.OnClickListener afp;
    private CompoundButton.OnCheckedChangeListener afq;
    private View.OnClickListener afr;
    private PopupWindow.OnDismissListener afs;
    private final CustomMessageListener aft;
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
        this.aff = null;
        this.afg = null;
        this.afh = null;
        this.afi = null;
        this.afn = false;
        this.afo = null;
        this.afp = new p(this);
        this.afq = new q(this);
        this.afr = new r(this);
        this.afs = new s(this);
        this.aft = new t(this, CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW);
        this.mContext = context;
        init();
    }

    private void init() {
        this.afl = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds32);
        this.mWindowHeight = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds278);
        this.afj = com.baidu.adp.lib.util.k.I(this.mContext) - (this.afl * 2);
        this.afk = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds120);
        setOnClickListener(this.afp);
    }

    public void wd() {
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
        button.setOnClickListener(this.afr);
        com.baidu.tbadk.core.util.ar.c((TextView) inflate.findViewById(r.g.head_text), r.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.ar.k(findViewById, r.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.ar.k(button, r.f.btn_home_neg_feedback_forbid_selector);
        com.baidu.tbadk.core.util.ar.c(button, r.d.cp_cont_b, 3);
        this.afg = new ArrayList();
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) inflate.findViewById(r.g.reason_checkbox1);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) inflate.findViewById(r.g.reason_checkbox2);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox3 = (NEGFeedBackReasonCheckBox) inflate.findViewById(r.g.reason_checkbox3);
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.afq);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.afq);
        nEGFeedBackReasonCheckBox3.setOnCheckedChangeListener(this.afq);
        this.afg.add(nEGFeedBackReasonCheckBox);
        this.afg.add(nEGFeedBackReasonCheckBox2);
        this.afg.add(nEGFeedBackReasonCheckBox3);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void we() {
        if (this.mContext != null) {
            this.aff = new PopupWindow(getContentView(), this.afj, this.mWindowHeight);
            this.aff.setFocusable(true);
            this.aff.setTouchable(true);
            this.aff.setOnDismissListener(this.afs);
            if (!this.afn) {
                MessageManager.getInstance().registerListener(this.aft);
                this.afn = true;
            }
            if (this.afi != null && this.afi.size() == 3 && com.baidu.tbadk.core.util.x.s(this.afg) == 3) {
                for (int i = 0; i < this.afi.size(); i++) {
                    String valueAt = this.afi.valueAt(i);
                    if (av.dD(valueAt) > 8) {
                        valueAt = av.d(valueAt, 6, "...吧");
                    }
                    this.afg.get(i).setText(valueAt);
                }
            }
            b(this.mContext, 0.5f);
            int[] iArr = new int[2];
            boolean a2 = a(this.mContext, this, this.mWindowHeight, this.afj, this.afk, this.afm, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a2) {
                    this.aff.setAnimationStyle(r.k.scale_rb2lt_anim);
                    com.baidu.tbadk.core.util.ar.a(this.aff, r.f.bg_home_feedback_under);
                } else {
                    this.aff.setAnimationStyle(r.k.scale_rt2lb_anim);
                    com.baidu.tbadk.core.util.ar.a(this.aff, r.f.bg_home_feedback_top);
                }
                this.aff.showAtLocation(getRootView(), 0, iArr[0] - this.afl, iArr[1]);
                if (this.afo != null) {
                    this.afo.a(this.afh);
                }
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.afn) {
            MessageManager.getInstance().unRegisterListener(this.aft);
            this.afn = false;
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
        int J = com.baidu.adp.lib.util.k.J(context);
        int I = com.baidu.adp.lib.util.k.I(context);
        boolean z = ((J - iArr2[1]) - height) - i3 < i;
        iArr[0] = I - i2;
        if (z) {
            iArr[1] = (iArr2[1] - i) - i4;
            return z;
        }
        iArr[1] = iArr2[1] + height + i4;
        return z;
    }

    public void setData(com.baidu.tieba.card.data.c cVar) {
        if (cVar != null) {
            this.afh = cVar;
            this.afi = cVar.beg;
        }
    }

    public void tm() {
        com.baidu.tbadk.core.util.ar.c(this, r.f.icon_home_feedback_selector);
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
        if (this.afh == null || this.afh.IU() == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!com.baidu.tbadk.core.util.x.t(this.afg)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.afg.size()) {
                    NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = this.afg.get(i2);
                    if (nEGFeedBackReasonCheckBox != null && nEGFeedBackReasonCheckBox.isChecked() && this.afi != null && this.afi.size() > i2) {
                        arrayList.add(Integer.valueOf(nEGFeedBackReasonCheckBox.getId()));
                        if (sb.length() != 0) {
                            sb.append(",");
                        }
                        sb.append(String.valueOf(this.afi.keyAt(i2)));
                    }
                    i = i2 + 1;
                }
            }
            jSONObject.put("tid", this.afh.IU().getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.afh.IU().getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            return jSONObject;
        }
        jSONObject.put("tid", this.afh.IU().getTid());
        if (sb.length() != 0) {
        }
        jSONObject.put("fid", this.afh.IU().getFid());
        jSONObject.put("click_time", System.currentTimeMillis());
        return jSONObject;
    }

    public void setEventCallback(a aVar) {
        this.afo = aVar;
    }
}
