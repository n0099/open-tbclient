package com.baidu.tbadk.core.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.n;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<Integer, Integer[]> RW = new HashMap<>(2);
    private List<CharSequence> RQ;
    private h RR;
    private final TextView RS;
    private final View RT;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.j<?> mContext;
    private AlertDialog mDialog;
    private final ViewGroup mRootView;
    private String mTitle;
    private int RV = -1;
    private int Rx = -1;
    private boolean RH = false;
    private int RU = r.dialog_bdlist_item;

    static {
        RW.put(0, new Integer[]{Integer.valueOf(p.dialg_alert_btn_bg), Integer.valueOf(p.dialog_bdalert_button_textcolor_pressed)});
        RW.put(1, new Integer[]{Integer.valueOf(p.btn_blue_square), Integer.valueOf(n.cp_bg_line_d)});
    }

    public e(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) com.baidu.adp.lib.g.b.hr().inflate(activity, r.dialog_bdlist, null);
        this.RS = (TextView) this.mRootView.findViewById(q.dialog_title_list);
        this.mContentView = (ViewGroup) this.mRootView.findViewById(q.dialog_content);
        this.RT = this.mRootView.findViewById(q.line_bg);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public e co(String str) {
        this.mTitle = str;
        return this;
    }

    public e bx(int i) {
        return co(this.mActivity.getResources().getString(i));
    }

    public e a(CharSequence[] charSequenceArr, h hVar) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), hVar);
        }
        return this;
    }

    public e a(List<CharSequence> list, h hVar) {
        if (list != null && list.size() > 0) {
            this.RQ = list;
            if (hVar != null) {
                this.RR = hVar;
            }
        }
        return this;
    }

    public e by(int i) {
        this.RV = i;
        return this;
    }

    public e bz(int i) {
        this.Rx = i;
        return this;
    }

    public e d(com.baidu.adp.base.j<?> jVar) {
        if (!this.RH) {
            this.mContext = jVar;
            this.RH = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.RS.setText(this.mTitle);
                this.RS.setVisibility(0);
                this.RT.setVisibility(0);
            } else {
                this.RS.setVisibility(8);
                this.RT.setVisibility(8);
            }
            if (this.RQ != null && this.RQ.size() > 0) {
                int size = this.RQ.size();
                for (int i = 0; i < size; i++) {
                    bA(i);
                }
            }
            c(jVar);
        }
        return this;
    }

    public e rN() {
        if (!this.RH) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.mDialog != null) {
            com.baidu.adp.lib.g.k.a(this.mDialog, this.mActivity);
        } else {
            this.mDialog = new AlertDialog.Builder(this.mActivity).create();
            this.mDialog.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.k.a(this.mDialog, this.mActivity)) {
                Window window = this.mDialog.getWindow();
                if (this.RV == -1) {
                    this.RV = g.Sa;
                }
                if (this.Rx == -1) {
                    this.Rx = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.Rx);
                window.setBackgroundDrawableResource(p.transparent_bg);
                window.setContentView(this.mRootView);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.j<?> jVar) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (jVar instanceof TbPageContext) {
            ((TbPageContext) jVar).getLayoutMode().ab(skinType == 1);
            ((TbPageContext) jVar).getLayoutMode().j(this.mRootView);
        }
        this.mRootView.setBackgroundResource(p.transparent_bg);
    }

    public void dismiss() {
        if (this.mDialog != null) {
            com.baidu.adp.lib.g.k.b(this.mDialog, this.mActivity);
        }
    }

    private View bA(int i) {
        View a = com.baidu.adp.lib.g.b.hr().a(this.mActivity, this.RU, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) a;
        TextView textView = (TextView) a.findViewById(q.dialog_item_btn);
        View findViewById = a.findViewById(q.line);
        CharSequence charSequence = this.RQ.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.RQ.size() - 1) {
            findViewById.setVisibility(8);
            ay.i(a, p.dialog_single_button_bg_selector);
        } else {
            ay.i(a, p.dialg_alert_btn_bg);
        }
        if (this.RR != null) {
            linearLayout.setOnClickListener(new f(this, i, textView));
        }
        this.mContentView.addView(a);
        return a;
    }

    public View bB(int i) {
        if (this.mContentView == null) {
            return null;
        }
        int childCount = this.mContentView.getChildCount();
        if (i < 0 || i > childCount - 1) {
            return null;
        }
        return this.mContentView.getChildAt(i);
    }
}
