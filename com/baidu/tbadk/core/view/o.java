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
    private TbPageContext ajT;
    private PopupWindow ajU;
    private List<NEGFeedBackReasonCheckBox> ajV;
    private com.baidu.tbadk.core.data.al ajW;
    private SparseArray<String> ajX;
    private int ajY;
    private int ajZ;
    private int aka;
    private boolean akb;
    private a akc;
    private PopupWindow akd;
    private long ake;
    private String[] akf;
    private View.OnClickListener akg;
    private CompoundButton.OnCheckedChangeListener akh;
    private View.OnClickListener aki;
    private PopupWindow.OnDismissListener akj;
    private final CustomMessageListener akk;
    private View.OnTouchListener akl;
    private CustomMessageListener akm;
    private Context mContext;
    private int mWindowHeight;
    private int mYOffset;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.al alVar);

        void a(com.baidu.tbadk.core.data.al alVar, CompoundButton compoundButton, boolean z);

        void a(ArrayList<Integer> arrayList, com.baidu.tbadk.core.data.al alVar);
    }

    public o(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mContext = null;
        this.ajU = null;
        this.ajV = null;
        this.ajW = null;
        this.ajX = null;
        this.akb = false;
        this.akc = null;
        this.ake = 0L;
        this.akg = new p(this);
        this.akh = new q(this);
        this.aki = new r(this);
        this.akj = new s(this);
        this.akk = new t(this, CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW);
        this.akl = new u(this);
        this.akm = new v(this, CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN);
        this.mContext = tbPageContext.getPageActivity();
        this.ajT = tbPageContext;
        init();
    }

    private void init() {
        this.aka = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32);
        this.mWindowHeight = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds278);
        this.ajY = com.baidu.adp.lib.util.k.af(this.mContext) - (this.aka * 2);
        this.ajZ = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds120);
        setOnClickListener(this.akg);
        com.baidu.tbadk.core.util.aq.c(this, w.g.icon_home_feedback_selector);
        this.ajT.registerListener(this.akm);
    }

    public void wQ() {
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
        button.setOnClickListener(this.aki);
        com.baidu.tbadk.core.util.aq.c((TextView) inflate.findViewById(w.h.head_text), w.e.cp_cont_c, 1);
        com.baidu.tbadk.core.util.aq.j(findViewById, w.e.cp_bg_line_b);
        com.baidu.tbadk.core.util.aq.j(button, w.g.btn_home_neg_feedback_forbid_selector);
        com.baidu.tbadk.core.util.aq.c(button, w.e.cp_cont_b, 3);
        this.ajV = new ArrayList();
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) inflate.findViewById(w.h.reason_checkbox1);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) inflate.findViewById(w.h.reason_checkbox2);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox3 = (NEGFeedBackReasonCheckBox) inflate.findViewById(w.h.reason_checkbox3);
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.akh);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.akh);
        nEGFeedBackReasonCheckBox3.setOnCheckedChangeListener(this.akh);
        this.ajV.add(nEGFeedBackReasonCheckBox);
        this.ajV.add(nEGFeedBackReasonCheckBox2);
        this.ajV.add(nEGFeedBackReasonCheckBox3);
        if (this.akf != null && this.akf.length == 3) {
            for (int i = 0; i < 3; i++) {
                if (!StringUtils.isNull(this.akf[i])) {
                    this.ajV.get(i).setText(this.akf[i]);
                }
            }
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wR() {
        if (this.mContext != null) {
            this.ajU = new PopupWindow(getContentView(), this.ajY, this.mWindowHeight);
            this.ajU.setFocusable(true);
            this.ajU.setTouchable(true);
            this.ajU.setOnDismissListener(this.akj);
            this.ajU.setTouchInterceptor(this.akl);
            if (!this.akb) {
                MessageManager.getInstance().registerListener(this.akk);
                this.akb = true;
            }
            if (this.ajX != null && this.ajX.size() == 3 && com.baidu.tbadk.core.util.x.p(this.ajV) == 3) {
                for (int i = 0; i < this.ajX.size(); i++) {
                    String valueAt = this.ajX.valueAt(i);
                    if (com.baidu.tbadk.core.util.au.dB(valueAt) > 8) {
                        valueAt = com.baidu.tbadk.core.util.au.d(valueAt, 6, "...吧");
                    }
                    this.ajV.get(i).setText(valueAt);
                }
            }
            View inflate = LayoutInflater.from(this.mContext).inflate(w.j.view_negative_feedback_bottom, (ViewGroup) null);
            this.akd = new PopupWindow(inflate, -1, -1);
            this.akd.showAtLocation(this, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a2 = a(this.mContext, this, this.mWindowHeight, this.ajY, this.ajZ, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a2) {
                    this.ajU.setAnimationStyle(w.m.scale_rb2lt_anim);
                    com.baidu.tbadk.core.util.aq.a(this.ajU, w.g.bg_home_feedback_under);
                } else {
                    this.ajU.setAnimationStyle(w.m.scale_rt2lb_anim);
                    com.baidu.tbadk.core.util.aq.a(this.ajU, w.g.bg_home_feedback_top);
                }
                this.ajU.showAtLocation(inflate, 0, iArr[0] - this.aka, iArr[1]);
                if (this.akc != null) {
                    this.akc.a(this.ajW);
                }
            }
        }
    }

    public void wS() {
        if (this.ajU != null) {
            this.ajU.dismiss();
            this.ajU = null;
        }
        if (this.akd != null) {
            this.akd.dismiss();
            this.akd = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.akb) {
            MessageManager.getInstance().unRegisterListener(this.akk);
            this.akb = false;
        }
        if (this.akd != null) {
            this.akd.dismiss();
            this.akd = null;
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

    public void setData(com.baidu.tbadk.core.data.al alVar) {
        if (alVar != null) {
            this.ajW = alVar;
            this.ajX = alVar.rg();
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
        if (this.ajW == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!com.baidu.tbadk.core.util.x.q(this.ajV)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ajV.size()) {
                    NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = this.ajV.get(i2);
                    if (nEGFeedBackReasonCheckBox != null && nEGFeedBackReasonCheckBox.isChecked() && this.ajX != null && this.ajX.size() > i2) {
                        arrayList.add(Integer.valueOf(nEGFeedBackReasonCheckBox.getId()));
                        if (sb.length() != 0) {
                            sb.append(",");
                        }
                        sb.append(String.valueOf(this.ajX.keyAt(i2)));
                    }
                    i = i2 + 1;
                }
            }
            jSONObject.put("tid", this.ajW.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.ajW.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            return jSONObject;
        }
        jSONObject.put("tid", this.ajW.getTid());
        if (sb.length() != 0) {
        }
        jSONObject.put("fid", this.ajW.getFid());
        jSONObject.put("click_time", System.currentTimeMillis());
        return jSONObject;
    }

    public void setEventCallback(a aVar) {
        this.akc = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.akf = strArr;
    }
}
