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
import com.baidu.adp.BdUniqueId;
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
    private a ajA;
    private PopupWindow ajB;
    private long ajC;
    private String[] ajD;
    private View.OnClickListener ajE;
    private CompoundButton.OnCheckedChangeListener ajF;
    private View.OnClickListener ajG;
    private PopupWindow.OnDismissListener ajH;
    private final CustomMessageListener ajI;
    private View.OnTouchListener ajJ;
    private CustomMessageListener ajK;
    private TbPageContext ajr;
    private PopupWindow ajs;
    private List<NEGFeedBackReasonCheckBox> ajt;
    private com.baidu.tbadk.core.data.am aju;
    private SparseArray<String> ajv;
    private int ajw;
    private int ajx;
    private int ajy;
    private boolean ajz;
    private Context mContext;
    private int mWindowHeight;
    private int mYOffset;
    private int paddingLeft;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.am amVar);

        void a(com.baidu.tbadk.core.data.am amVar, CompoundButton compoundButton, boolean z);

        void a(ArrayList<Integer> arrayList, com.baidu.tbadk.core.data.am amVar);
    }

    public o(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mContext = null;
        this.ajs = null;
        this.ajt = null;
        this.aju = null;
        this.ajv = null;
        this.ajz = false;
        this.ajA = null;
        this.ajC = 0L;
        this.ajE = new p(this);
        this.ajF = new q(this);
        this.ajG = new r(this);
        this.ajH = new s(this);
        this.ajI = new t(this, CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW);
        this.ajJ = new u(this);
        this.ajK = new v(this, CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN);
        this.mContext = tbPageContext.getPageActivity();
        this.ajr = tbPageContext;
        this.paddingLeft = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds16);
        init();
    }

    private void init() {
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.ajy = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds40);
        this.mWindowHeight = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds278);
        this.ajw = com.baidu.adp.lib.util.k.af(this.mContext) - (this.ajy * 2);
        this.ajx = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds120);
        setOnClickListener(this.ajE);
        com.baidu.tbadk.core.util.aq.c(this, w.g.icon_home_feedback_selector);
        this.ajr.registerListener(this.ajK);
        this.ajr.registerListener(this.ajI);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.ajK != null) {
                this.ajK.setTag(bdUniqueId);
            }
            if (this.ajI != null) {
                this.ajI.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.ajK);
            MessageManager.getInstance().registerListener(this.ajI);
        }
    }

    public void wd() {
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
        View findViewById = inflate.findViewById(w.h.divider_line);
        Button button = (Button) inflate.findViewById(w.h.forbid_thread_btn);
        button.setOnClickListener(this.ajG);
        com.baidu.tbadk.core.util.aq.c((TextView) inflate.findViewById(w.h.head_text), w.e.cp_cont_c, 1);
        com.baidu.tbadk.core.util.aq.j(findViewById, w.e.cp_bg_line_b);
        com.baidu.tbadk.core.util.aq.j(button, w.g.btn_home_neg_feedback_forbid_selector);
        com.baidu.tbadk.core.util.aq.c(button, w.e.cp_cont_b, 3);
        this.ajt = new ArrayList();
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) inflate.findViewById(w.h.reason_checkbox1);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) inflate.findViewById(w.h.reason_checkbox2);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox3 = (NEGFeedBackReasonCheckBox) inflate.findViewById(w.h.reason_checkbox3);
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.ajF);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.ajF);
        nEGFeedBackReasonCheckBox3.setOnCheckedChangeListener(this.ajF);
        this.ajt.add(nEGFeedBackReasonCheckBox);
        this.ajt.add(nEGFeedBackReasonCheckBox2);
        this.ajt.add(nEGFeedBackReasonCheckBox3);
        if (this.ajD != null && this.ajD.length == 3) {
            for (int i = 0; i < 3; i++) {
                if (!StringUtils.isNull(this.ajD[i])) {
                    this.ajt.get(i).setText(this.ajD[i]);
                }
            }
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void we() {
        if (this.mContext != null) {
            this.ajs = new PopupWindow(getContentView(), this.ajw, this.mWindowHeight);
            this.ajs.setFocusable(true);
            this.ajs.setTouchable(true);
            this.ajs.setOnDismissListener(this.ajH);
            this.ajs.setTouchInterceptor(this.ajJ);
            if (this.ajv != null && this.ajv.size() == 3 && com.baidu.tbadk.core.util.x.q(this.ajt) == 3) {
                for (int i = 0; i < this.ajv.size(); i++) {
                    String valueAt = this.ajv.valueAt(i);
                    if (com.baidu.tbadk.core.util.au.dz(valueAt) > 8) {
                        valueAt = com.baidu.tbadk.core.util.au.d(valueAt, 6, "...吧");
                    }
                    this.ajt.get(i).setText(valueAt);
                }
            }
            View inflate = LayoutInflater.from(this.mContext).inflate(w.j.view_negative_feedback_bottom, (ViewGroup) null);
            this.ajB = new PopupWindow(inflate, -1, -1);
            this.ajB.showAtLocation(this, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a2 = a(this.mContext, this, this.mWindowHeight, this.ajw, this.ajx, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a2) {
                    this.ajs.setAnimationStyle(w.m.scale_rb2lt_anim);
                    com.baidu.tbadk.core.util.aq.a(this.ajs, w.g.bg_home_feedback_under);
                } else {
                    this.ajs.setAnimationStyle(w.m.scale_rt2lb_anim);
                    com.baidu.tbadk.core.util.aq.a(this.ajs, w.g.bg_home_feedback_top);
                }
                this.ajs.showAtLocation(inflate, 0, iArr[0] - this.ajy, iArr[1]);
                if (this.ajA != null) {
                    this.ajA.a(this.aju);
                }
            }
        }
    }

    public void wf() {
        if (this.ajs != null) {
            this.ajs.dismiss();
            this.ajs = null;
        }
        if (this.ajB != null) {
            this.ajB.dismiss();
            this.ajB = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.ajI);
        MessageManager.getInstance().unRegisterListener(this.ajK);
        if (this.ajB != null) {
            this.ajB.dismiss();
            this.ajB = null;
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

    public void setData(com.baidu.tbadk.core.data.am amVar) {
        if (amVar != null) {
            this.aju = amVar;
            this.ajv = amVar.qq();
        }
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.util.aq.c(this, w.g.icon_home_feedback_selector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(8:4|(7:6|(2:7|(3:9|(4:17|(1:19)|20|21)|22)(0))|28|(1:30)|31|32|33)(0)|27|28|(0)|31|32|33) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0097, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0098, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035 A[Catch: JSONException -> 0x0097, TryCatch #0 {JSONException -> 0x0097, blocks: (B:12:0x0024, B:14:0x0035, B:15:0x003e), top: B:32:0x0024 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject l(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.aju == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!com.baidu.tbadk.core.util.x.r(this.ajt)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ajt.size()) {
                    NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = this.ajt.get(i2);
                    if (nEGFeedBackReasonCheckBox != null && nEGFeedBackReasonCheckBox.isChecked() && this.ajv != null && this.ajv.size() > i2) {
                        arrayList.add(Integer.valueOf(nEGFeedBackReasonCheckBox.getId()));
                        if (sb.length() != 0) {
                            sb.append(",");
                        }
                        sb.append(String.valueOf(this.ajv.keyAt(i2)));
                    }
                    i = i2 + 1;
                }
            }
            jSONObject.put("tid", this.aju.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.aju.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            return jSONObject;
        }
        jSONObject.put("tid", this.aju.getTid());
        if (sb.length() != 0) {
        }
        jSONObject.put("fid", this.aju.getFid());
        jSONObject.put("click_time", System.currentTimeMillis());
        return jSONObject;
    }

    public void setEventCallback(a aVar) {
        this.ajA = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.ajD = strArr;
    }
}
