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
    private TbPageContext ajU;
    private PopupWindow ajV;
    private List<NEGFeedBackReasonCheckBox> ajW;
    private com.baidu.tbadk.core.data.al ajX;
    private SparseArray<String> ajY;
    private int ajZ;
    private int aka;
    private int akb;
    private boolean akc;
    private a akd;
    private PopupWindow ake;
    private long akf;
    private String[] akg;
    private View.OnClickListener akh;
    private CompoundButton.OnCheckedChangeListener aki;
    private View.OnClickListener akj;
    private PopupWindow.OnDismissListener akk;
    private final CustomMessageListener akl;
    private View.OnTouchListener akm;
    private CustomMessageListener akn;
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
        this.ajV = null;
        this.ajW = null;
        this.ajX = null;
        this.ajY = null;
        this.akc = false;
        this.akd = null;
        this.akf = 0L;
        this.akh = new p(this);
        this.aki = new q(this);
        this.akj = new r(this);
        this.akk = new s(this);
        this.akl = new t(this, CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW);
        this.akm = new u(this);
        this.akn = new v(this, CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN);
        this.mContext = tbPageContext.getPageActivity();
        this.ajU = tbPageContext;
        init();
    }

    private void init() {
        this.akb = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32);
        this.mWindowHeight = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds278);
        this.ajZ = com.baidu.adp.lib.util.k.af(this.mContext) - (this.akb * 2);
        this.aka = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds120);
        setOnClickListener(this.akh);
        com.baidu.tbadk.core.util.aq.c(this, w.g.icon_home_feedback_selector);
        this.ajU.registerListener(this.akn);
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
        button.setOnClickListener(this.akj);
        com.baidu.tbadk.core.util.aq.c((TextView) inflate.findViewById(w.h.head_text), w.e.cp_cont_c, 1);
        com.baidu.tbadk.core.util.aq.j(findViewById, w.e.cp_bg_line_b);
        com.baidu.tbadk.core.util.aq.j(button, w.g.btn_home_neg_feedback_forbid_selector);
        com.baidu.tbadk.core.util.aq.c(button, w.e.cp_cont_b, 3);
        this.ajW = new ArrayList();
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) inflate.findViewById(w.h.reason_checkbox1);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) inflate.findViewById(w.h.reason_checkbox2);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox3 = (NEGFeedBackReasonCheckBox) inflate.findViewById(w.h.reason_checkbox3);
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.aki);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.aki);
        nEGFeedBackReasonCheckBox3.setOnCheckedChangeListener(this.aki);
        this.ajW.add(nEGFeedBackReasonCheckBox);
        this.ajW.add(nEGFeedBackReasonCheckBox2);
        this.ajW.add(nEGFeedBackReasonCheckBox3);
        if (this.akg != null && this.akg.length == 3) {
            for (int i = 0; i < 3; i++) {
                if (!StringUtils.isNull(this.akg[i])) {
                    this.ajW.get(i).setText(this.akg[i]);
                }
            }
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wR() {
        if (this.mContext != null) {
            this.ajV = new PopupWindow(getContentView(), this.ajZ, this.mWindowHeight);
            this.ajV.setFocusable(true);
            this.ajV.setTouchable(true);
            this.ajV.setOnDismissListener(this.akk);
            this.ajV.setTouchInterceptor(this.akm);
            if (!this.akc) {
                MessageManager.getInstance().registerListener(this.akl);
                this.akc = true;
            }
            if (this.ajY != null && this.ajY.size() == 3 && com.baidu.tbadk.core.util.x.p(this.ajW) == 3) {
                for (int i = 0; i < this.ajY.size(); i++) {
                    String valueAt = this.ajY.valueAt(i);
                    if (com.baidu.tbadk.core.util.au.dB(valueAt) > 8) {
                        valueAt = com.baidu.tbadk.core.util.au.d(valueAt, 6, "...吧");
                    }
                    this.ajW.get(i).setText(valueAt);
                }
            }
            View inflate = LayoutInflater.from(this.mContext).inflate(w.j.view_negative_feedback_bottom, (ViewGroup) null);
            this.ake = new PopupWindow(inflate, -1, -1);
            this.ake.showAtLocation(this, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a2 = a(this.mContext, this, this.mWindowHeight, this.ajZ, this.aka, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a2) {
                    this.ajV.setAnimationStyle(w.m.scale_rb2lt_anim);
                    com.baidu.tbadk.core.util.aq.a(this.ajV, w.g.bg_home_feedback_under);
                } else {
                    this.ajV.setAnimationStyle(w.m.scale_rt2lb_anim);
                    com.baidu.tbadk.core.util.aq.a(this.ajV, w.g.bg_home_feedback_top);
                }
                this.ajV.showAtLocation(inflate, 0, iArr[0] - this.akb, iArr[1]);
                if (this.akd != null) {
                    this.akd.a(this.ajX);
                }
            }
        }
    }

    public void wS() {
        if (this.ajV != null) {
            this.ajV.dismiss();
            this.ajV = null;
        }
        if (this.ake != null) {
            this.ake.dismiss();
            this.ake = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.akc) {
            MessageManager.getInstance().unRegisterListener(this.akl);
            this.akc = false;
        }
        if (this.ake != null) {
            this.ake.dismiss();
            this.ake = null;
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
            this.ajX = alVar;
            this.ajY = alVar.rg();
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
        if (this.ajX == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!com.baidu.tbadk.core.util.x.q(this.ajW)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ajW.size()) {
                    NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = this.ajW.get(i2);
                    if (nEGFeedBackReasonCheckBox != null && nEGFeedBackReasonCheckBox.isChecked() && this.ajY != null && this.ajY.size() > i2) {
                        arrayList.add(Integer.valueOf(nEGFeedBackReasonCheckBox.getId()));
                        if (sb.length() != 0) {
                            sb.append(",");
                        }
                        sb.append(String.valueOf(this.ajY.keyAt(i2)));
                    }
                    i = i2 + 1;
                }
            }
            jSONObject.put("tid", this.ajX.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.ajX.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            return jSONObject;
        }
        jSONObject.put("tid", this.ajX.getTid());
        if (sb.length() != 0) {
        }
        jSONObject.put("fid", this.ajX.getFid());
        jSONObject.put("click_time", System.currentTimeMillis());
        return jSONObject;
    }

    public void setEventCallback(a aVar) {
        this.akd = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.akg = strArr;
    }
}
