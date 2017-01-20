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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o extends ImageView {
    private TbPageContext FY;
    private com.baidu.tieba.d.a aeA;
    private View.OnClickListener aeB;
    private CompoundButton.OnCheckedChangeListener aeC;
    private View.OnClickListener aeD;
    private PopupWindow.OnDismissListener aeE;
    private final CustomMessageListener aeF;
    private CustomMessageListener aeG;
    private PopupWindow aeq;
    private List<NEGFeedBackReasonCheckBox> aer;
    private com.baidu.tieba.card.data.c aes;
    private SparseArray<String> aet;
    private int aeu;
    private int aev;
    private int aew;
    private int aex;
    private boolean aey;
    private a aez;
    private Context mContext;
    private int mWindowHeight;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.card.data.c cVar);

        void a(com.baidu.tieba.card.data.c cVar, CompoundButton compoundButton, boolean z);

        void a(ArrayList<Integer> arrayList, com.baidu.tieba.card.data.c cVar);
    }

    public o(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mContext = null;
        this.aeq = null;
        this.aer = null;
        this.aes = null;
        this.aet = null;
        this.aey = false;
        this.aez = null;
        this.aeB = new p(this);
        this.aeC = new q(this);
        this.aeD = new r(this);
        this.aeE = new s(this);
        this.aeF = new t(this, CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW);
        this.aeG = new u(this, CmdConfigCustom.CMD_NEG_FEED_BACK_TIP);
        this.mContext = tbPageContext.getPageActivity();
        this.FY = tbPageContext;
        init();
    }

    private void init() {
        this.aew = com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds32);
        this.mWindowHeight = com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds278);
        this.aeu = com.baidu.adp.lib.util.k.I(this.mContext) - (this.aew * 2);
        this.aev = com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds120);
        setOnClickListener(this.aeB);
    }

    public void vX() {
        setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds64), -1));
        setPadding(com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds28), 0, 0, 0);
    }

    public void vY() {
        if (this.aeA == null) {
            this.aeA = new com.baidu.tieba.d.a(this.FY, this);
        }
        if (this.aeA.Ti()) {
            this.FY.registerListener(this.aeG);
        } else {
            this.aeA.Tg();
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(r.j.neg_feedback_popupwindow, (ViewGroup) null);
        View findViewById = inflate.findViewById(r.h.divider_line);
        Button button = (Button) inflate.findViewById(r.h.forbid_thread_btn);
        button.setOnClickListener(this.aeD);
        com.baidu.tbadk.core.util.ap.c((TextView) inflate.findViewById(r.h.head_text), r.e.cp_cont_c, 1);
        com.baidu.tbadk.core.util.ap.j(findViewById, r.e.cp_bg_line_b);
        com.baidu.tbadk.core.util.ap.j((View) button, r.g.btn_home_neg_feedback_forbid_selector);
        com.baidu.tbadk.core.util.ap.c(button, r.e.cp_cont_b, 3);
        this.aer = new ArrayList();
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) inflate.findViewById(r.h.reason_checkbox1);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) inflate.findViewById(r.h.reason_checkbox2);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox3 = (NEGFeedBackReasonCheckBox) inflate.findViewById(r.h.reason_checkbox3);
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.aeC);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.aeC);
        nEGFeedBackReasonCheckBox3.setOnCheckedChangeListener(this.aeC);
        this.aer.add(nEGFeedBackReasonCheckBox);
        this.aer.add(nEGFeedBackReasonCheckBox2);
        this.aer.add(nEGFeedBackReasonCheckBox3);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vZ() {
        if (this.mContext != null) {
            this.aeq = new PopupWindow(getContentView(), this.aeu, this.mWindowHeight);
            this.aeq.setFocusable(true);
            this.aeq.setTouchable(true);
            this.aeq.setOnDismissListener(this.aeE);
            if (!this.aey) {
                MessageManager.getInstance().registerListener(this.aeF);
                this.aey = true;
            }
            if (this.aet != null && this.aet.size() == 3 && com.baidu.tbadk.core.util.w.r(this.aer) == 3) {
                for (int i = 0; i < this.aet.size(); i++) {
                    String valueAt = this.aet.valueAt(i);
                    if (com.baidu.tbadk.core.util.at.dB(valueAt) > 8) {
                        valueAt = com.baidu.tbadk.core.util.at.d(valueAt, 6, "...吧");
                    }
                    this.aer.get(i).setText(valueAt);
                }
            }
            b(this.mContext, 0.5f);
            int[] iArr = new int[2];
            boolean a2 = a(this.mContext, this, this.mWindowHeight, this.aeu, this.aev, this.aex, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a2) {
                    this.aeq.setAnimationStyle(r.m.scale_rb2lt_anim);
                    com.baidu.tbadk.core.util.ap.a(this.aeq, r.g.bg_home_feedback_under);
                } else {
                    this.aeq.setAnimationStyle(r.m.scale_rt2lb_anim);
                    com.baidu.tbadk.core.util.ap.a(this.aeq, r.g.bg_home_feedback_top);
                }
                this.aeq.showAtLocation(getRootView(), 0, iArr[0] - this.aew, iArr[1]);
                if (this.aez != null) {
                    this.aez.a(this.aes);
                }
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.aey) {
            MessageManager.getInstance().unRegisterListener(this.aeF);
            this.aey = false;
        }
        if (this.aeA != null) {
            this.aeA.Tg();
        }
        MessageManager.getInstance().unRegisterListener(this.aeG);
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
            this.aes = cVar;
            this.aet = cVar.bob;
        }
    }

    public void tg() {
        com.baidu.tbadk.core.util.ap.c(this, r.g.icon_home_feedback_selector);
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
        if (this.aes == null || this.aes.Ji() == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!com.baidu.tbadk.core.util.w.s(this.aer)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aer.size()) {
                    NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = this.aer.get(i2);
                    if (nEGFeedBackReasonCheckBox != null && nEGFeedBackReasonCheckBox.isChecked() && this.aet != null && this.aet.size() > i2) {
                        arrayList.add(Integer.valueOf(nEGFeedBackReasonCheckBox.getId()));
                        if (sb.length() != 0) {
                            sb.append(",");
                        }
                        sb.append(String.valueOf(this.aet.keyAt(i2)));
                    }
                    i = i2 + 1;
                }
            }
            jSONObject.put("tid", this.aes.Ji().getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.aes.Ji().getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            return jSONObject;
        }
        jSONObject.put("tid", this.aes.Ji().getTid());
        if (sb.length() != 0) {
        }
        jSONObject.put("fid", this.aes.Ji().getFid());
        jSONObject.put("click_time", System.currentTimeMillis());
        return jSONObject;
    }

    public void setEventCallback(a aVar) {
        this.aez = aVar;
    }
}
