package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o extends ImageView {
    private TbPageContext ajF;
    private PopupWindow ajG;
    private List<NEGFeedBackReasonCheckBox> ajH;
    private com.baidu.tbadk.core.data.am ajI;
    private SparseArray<String> ajJ;
    private int ajK;
    private int ajL;
    private int ajM;
    private boolean ajN;
    private a ajO;
    private PopupWindow ajP;
    private long ajQ;
    private String[] ajR;
    private View.OnClickListener ajS;
    private CompoundButton.OnCheckedChangeListener ajT;
    private View.OnClickListener ajU;
    private PopupWindow.OnDismissListener ajV;
    private final CustomMessageListener ajW;
    private View.OnTouchListener ajX;
    private CustomMessageListener ajY;
    private Context mContext;
    private int mWindowHeight;
    private int mYOffset;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.am amVar);

        void a(com.baidu.tbadk.core.data.am amVar, CompoundButton compoundButton, boolean z);

        void a(ArrayList<Integer> arrayList, com.baidu.tbadk.core.data.am amVar);
    }

    public o(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mContext = null;
        this.ajG = null;
        this.ajH = null;
        this.ajI = null;
        this.ajJ = null;
        this.ajN = false;
        this.ajO = null;
        this.ajQ = 0L;
        this.ajS = new p(this);
        this.ajT = new q(this);
        this.ajU = new r(this);
        this.ajV = new s(this);
        this.ajW = new t(this, CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW);
        this.ajX = new u(this);
        this.ajY = new v(this, CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN);
        this.mContext = tbPageContext.getPageActivity();
        this.ajF = tbPageContext;
        init();
    }

    private void init() {
        this.ajM = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32);
        this.mWindowHeight = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds278);
        this.ajK = com.baidu.adp.lib.util.k.ag(this.mContext) - (this.ajM * 2);
        this.ajL = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds120);
        setOnClickListener(this.ajS);
        com.baidu.tbadk.core.util.aq.c(this, w.g.icon_home_feedback_selector);
        this.ajF.registerListener(this.ajY);
    }

    public void wu() {
        setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds96), -1));
        setPadding(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds28), 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32), 0);
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(w.j.neg_feedback_popupwindow, (ViewGroup) null);
        View findViewById = inflate.findViewById(w.h.divider_line);
        Button button = (Button) inflate.findViewById(w.h.forbid_thread_btn);
        button.setOnClickListener(this.ajU);
        com.baidu.tbadk.core.util.aq.c((TextView) inflate.findViewById(w.h.head_text), w.e.cp_cont_c, 1);
        com.baidu.tbadk.core.util.aq.j(findViewById, w.e.cp_bg_line_b);
        com.baidu.tbadk.core.util.aq.j(button, w.g.btn_home_neg_feedback_forbid_selector);
        com.baidu.tbadk.core.util.aq.c(button, w.e.cp_cont_b, 3);
        this.ajH = new ArrayList();
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) inflate.findViewById(w.h.reason_checkbox1);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) inflate.findViewById(w.h.reason_checkbox2);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox3 = (NEGFeedBackReasonCheckBox) inflate.findViewById(w.h.reason_checkbox3);
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.ajT);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.ajT);
        nEGFeedBackReasonCheckBox3.setOnCheckedChangeListener(this.ajT);
        this.ajH.add(nEGFeedBackReasonCheckBox);
        this.ajH.add(nEGFeedBackReasonCheckBox2);
        this.ajH.add(nEGFeedBackReasonCheckBox3);
        if (this.ajR != null && this.ajR.length == 3) {
            for (int i = 0; i < 3; i++) {
                if (!StringUtils.isNull(this.ajR[i])) {
                    this.ajH.get(i).setText(this.ajR[i]);
                }
            }
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wv() {
        if (this.mContext != null) {
            this.ajG = new PopupWindow(getContentView(), this.ajK, this.mWindowHeight);
            this.ajG.setFocusable(true);
            this.ajG.setTouchable(true);
            this.ajG.setOnDismissListener(this.ajV);
            this.ajG.setTouchInterceptor(this.ajX);
            if (!this.ajN) {
                MessageManager.getInstance().registerListener(this.ajW);
                this.ajN = true;
            }
            if (this.ajJ != null && this.ajJ.size() == 3 && com.baidu.tbadk.core.util.x.p(this.ajH) == 3) {
                for (int i = 0; i < this.ajJ.size(); i++) {
                    String valueAt = this.ajJ.valueAt(i);
                    if (com.baidu.tbadk.core.util.au.dv(valueAt) > 8) {
                        valueAt = com.baidu.tbadk.core.util.au.d(valueAt, 6, "...吧");
                    }
                    this.ajH.get(i).setText(valueAt);
                }
            }
            View inflate = LayoutInflater.from(this.mContext).inflate(w.j.view_negative_feedback_bottom, (ViewGroup) null);
            this.ajP = new PopupWindow(inflate, -1, -1);
            this.ajP.showAtLocation(this, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a2 = a(this.mContext, this, this.mWindowHeight, this.ajK, this.ajL, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a2) {
                    this.ajG.setAnimationStyle(w.m.scale_rb2lt_anim);
                    com.baidu.tbadk.core.util.aq.a(this.ajG, w.g.bg_home_feedback_under);
                } else {
                    this.ajG.setAnimationStyle(w.m.scale_rt2lb_anim);
                    com.baidu.tbadk.core.util.aq.a(this.ajG, w.g.bg_home_feedback_top);
                }
                this.ajG.showAtLocation(inflate, 0, iArr[0] - this.ajM, iArr[1]);
                if (this.ajO != null) {
                    this.ajO.a(this.ajI);
                }
            }
        }
    }

    public void ww() {
        if (this.ajG != null) {
            this.ajG.dismiss();
            this.ajG = null;
        }
        if (this.ajP != null) {
            this.ajP.dismiss();
            this.ajP = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ajN) {
            MessageManager.getInstance().unRegisterListener(this.ajW);
            this.ajN = false;
        }
        if (this.ajP != null) {
            this.ajP.dismiss();
            this.ajP = null;
        }
    }

    private boolean a(Context context, View view, int i, int i2, int i3, int i4, int[] iArr) {
        if (context == null || view == null || iArr == null || iArr.length != 2) {
            return false;
        }
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int ah = com.baidu.adp.lib.util.k.ah(context);
        int ag = com.baidu.adp.lib.util.k.ag(context);
        boolean z = ((ah - iArr2[1]) - height) - i3 < i;
        iArr[0] = ag - i2;
        if (z) {
            iArr[1] = (iArr2[1] - i) - i4;
            return z;
        }
        iArr[1] = iArr2[1] + height + i4;
        return z;
    }

    public void setData(com.baidu.tbadk.core.data.am amVar) {
        if (amVar != null) {
            this.ajI = amVar;
            this.ajJ = amVar.qJ();
        }
    }

    public void tD() {
        com.baidu.tbadk.core.util.aq.c(this, w.g.icon_home_feedback_selector);
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
        if (this.ajI == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!com.baidu.tbadk.core.util.x.q(this.ajH)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ajH.size()) {
                    NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = this.ajH.get(i2);
                    if (nEGFeedBackReasonCheckBox != null && nEGFeedBackReasonCheckBox.isChecked() && this.ajJ != null && this.ajJ.size() > i2) {
                        arrayList.add(Integer.valueOf(nEGFeedBackReasonCheckBox.getId()));
                        if (sb.length() != 0) {
                            sb.append(",");
                        }
                        sb.append(String.valueOf(this.ajJ.keyAt(i2)));
                    }
                    i = i2 + 1;
                }
            }
            jSONObject.put("tid", this.ajI.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.ajI.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            return jSONObject;
        }
        jSONObject.put("tid", this.ajI.getTid());
        if (sb.length() != 0) {
        }
        jSONObject.put("fid", this.ajI.getFid());
        jSONObject.put("click_time", System.currentTimeMillis());
        return jSONObject;
    }

    public void setEventCallback(a aVar) {
        this.ajO = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.ajR = strArr;
    }
}
