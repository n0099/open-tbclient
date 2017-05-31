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
    private CustomMessageListener ajA;
    private TbPageContext ajh;
    private PopupWindow aji;
    private List<NEGFeedBackReasonCheckBox> ajj;
    private com.baidu.tbadk.core.data.an ajk;
    private SparseArray<String> ajl;
    private int ajm;
    private int ajn;
    private int ajo;
    private boolean ajp;
    private a ajq;
    private PopupWindow ajr;
    private long ajs;
    private String[] ajt;
    private View.OnClickListener aju;
    private CompoundButton.OnCheckedChangeListener ajv;
    private View.OnClickListener ajw;
    private PopupWindow.OnDismissListener ajx;
    private final CustomMessageListener ajy;
    private View.OnTouchListener ajz;
    private Context mContext;
    private int mWindowHeight;
    private int mYOffset;
    private int paddingLeft;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.an anVar);

        void a(com.baidu.tbadk.core.data.an anVar, CompoundButton compoundButton, boolean z);

        void a(ArrayList<Integer> arrayList, com.baidu.tbadk.core.data.an anVar);
    }

    public o(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mContext = null;
        this.aji = null;
        this.ajj = null;
        this.ajk = null;
        this.ajl = null;
        this.ajp = false;
        this.ajq = null;
        this.ajs = 0L;
        this.aju = new p(this);
        this.ajv = new q(this);
        this.ajw = new r(this);
        this.ajx = new s(this);
        this.ajy = new t(this, CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW);
        this.ajz = new u(this);
        this.ajA = new v(this, CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN);
        this.mContext = tbPageContext.getPageActivity();
        this.ajh = tbPageContext;
        this.paddingLeft = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds16);
        init();
    }

    private void init() {
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.ajo = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds40);
        this.mWindowHeight = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds278);
        this.ajm = com.baidu.adp.lib.util.k.af(this.mContext) - (this.ajo * 2);
        this.ajn = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds120);
        setOnClickListener(this.aju);
        com.baidu.tbadk.core.util.aq.c(this, w.g.icon_home_feedback_selector);
        this.ajh.registerListener(this.ajA);
        this.ajh.registerListener(this.ajy);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.ajA != null) {
                this.ajA.setTag(bdUniqueId);
            }
            if (this.ajy != null) {
                this.ajy.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.ajA);
            MessageManager.getInstance().registerListener(this.ajy);
        }
    }

    public void wa() {
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
        button.setOnClickListener(this.ajw);
        com.baidu.tbadk.core.util.aq.c((TextView) inflate.findViewById(w.h.head_text), w.e.cp_cont_c, 1);
        com.baidu.tbadk.core.util.aq.j(findViewById, w.e.cp_bg_line_b);
        com.baidu.tbadk.core.util.aq.j(button, w.g.btn_home_neg_feedback_forbid_selector);
        com.baidu.tbadk.core.util.aq.c(button, w.e.cp_cont_b, 3);
        this.ajj = new ArrayList();
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) inflate.findViewById(w.h.reason_checkbox1);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) inflate.findViewById(w.h.reason_checkbox2);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox3 = (NEGFeedBackReasonCheckBox) inflate.findViewById(w.h.reason_checkbox3);
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.ajv);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.ajv);
        nEGFeedBackReasonCheckBox3.setOnCheckedChangeListener(this.ajv);
        this.ajj.add(nEGFeedBackReasonCheckBox);
        this.ajj.add(nEGFeedBackReasonCheckBox2);
        this.ajj.add(nEGFeedBackReasonCheckBox3);
        if (this.ajt != null && this.ajt.length == 3) {
            for (int i = 0; i < 3; i++) {
                if (!StringUtils.isNull(this.ajt[i])) {
                    this.ajj.get(i).setText(this.ajt[i]);
                }
            }
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wb() {
        if (this.mContext != null) {
            this.aji = new PopupWindow(getContentView(), this.ajm, this.mWindowHeight);
            this.aji.setFocusable(true);
            this.aji.setTouchable(true);
            this.aji.setOnDismissListener(this.ajx);
            this.aji.setTouchInterceptor(this.ajz);
            if (this.ajl != null && this.ajl.size() == 3 && com.baidu.tbadk.core.util.x.q(this.ajj) == 3) {
                for (int i = 0; i < this.ajl.size(); i++) {
                    String valueAt = this.ajl.valueAt(i);
                    if (com.baidu.tbadk.core.util.au.dw(valueAt) > 8) {
                        valueAt = com.baidu.tbadk.core.util.au.d(valueAt, 6, "...吧");
                    }
                    this.ajj.get(i).setText(valueAt);
                }
            }
            View inflate = LayoutInflater.from(this.mContext).inflate(w.j.view_negative_feedback_bottom, (ViewGroup) null);
            this.ajr = new PopupWindow(inflate, -1, -1);
            this.ajr.showAtLocation(this, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a2 = a(this.mContext, this, this.mWindowHeight, this.ajm, this.ajn, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a2) {
                    this.aji.setAnimationStyle(w.m.scale_rb2lt_anim);
                    com.baidu.tbadk.core.util.aq.a(this.aji, w.g.bg_home_feedback_under);
                } else {
                    this.aji.setAnimationStyle(w.m.scale_rt2lb_anim);
                    com.baidu.tbadk.core.util.aq.a(this.aji, w.g.bg_home_feedback_top);
                }
                this.aji.showAtLocation(inflate, 0, iArr[0] - this.ajo, iArr[1]);
                if (this.ajq != null) {
                    this.ajq.a(this.ajk);
                }
            }
        }
    }

    public void wc() {
        if (this.aji != null) {
            this.aji.dismiss();
            this.aji = null;
        }
        if (this.ajr != null) {
            this.ajr.dismiss();
            this.ajr = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.ajy);
        MessageManager.getInstance().unRegisterListener(this.ajA);
        if (this.ajr != null) {
            this.ajr.dismiss();
            this.ajr = null;
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

    public void setData(com.baidu.tbadk.core.data.an anVar) {
        if (anVar != null) {
            this.ajk = anVar;
            this.ajl = anVar.qm();
        }
    }

    public void onChangeSkinType() {
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
        if (this.ajk == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!com.baidu.tbadk.core.util.x.r(this.ajj)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ajj.size()) {
                    NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = this.ajj.get(i2);
                    if (nEGFeedBackReasonCheckBox != null && nEGFeedBackReasonCheckBox.isChecked() && this.ajl != null && this.ajl.size() > i2) {
                        arrayList.add(Integer.valueOf(nEGFeedBackReasonCheckBox.getId()));
                        if (sb.length() != 0) {
                            sb.append(",");
                        }
                        sb.append(String.valueOf(this.ajl.keyAt(i2)));
                    }
                    i = i2 + 1;
                }
            }
            jSONObject.put("tid", this.ajk.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.ajk.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            return jSONObject;
        }
        jSONObject.put("tid", this.ajk.getTid());
        if (sb.length() != 0) {
        }
        jSONObject.put("fid", this.ajk.getFid());
        jSONObject.put("click_time", System.currentTimeMillis());
        return jSONObject;
    }

    public void setEventCallback(a aVar) {
        this.ajq = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.ajt = strArr;
    }
}
