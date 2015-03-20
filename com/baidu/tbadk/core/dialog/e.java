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
import com.baidu.adp.base.j;
import com.baidu.adp.lib.g.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<Integer, Integer[]> Rv = new HashMap<>(2);
    private List<CharSequence> Rp;
    private h Rq;
    private final TextView Rr;
    private final View Rs;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private j<?> mContext;
    private AlertDialog mDialog;
    private final ViewGroup mRootView;
    private String mTitle;
    private int Ru = -1;
    private int Ra = -1;
    private boolean Rj = false;
    private int Rt = w.dialog_bdlist_item;

    static {
        Rv.put(0, new Integer[]{Integer.valueOf(u.dialg_alert_btn_bg), Integer.valueOf(u.dialog_bdalert_button_textcolor_pressed)});
        Rv.put(1, new Integer[]{Integer.valueOf(u.btn_blue_square), Integer.valueOf(s.cp_bg_line_d)});
    }

    public e(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) com.baidu.adp.lib.g.b.hH().inflate(activity, w.dialog_bdlist, null);
        this.Rr = (TextView) this.mRootView.findViewById(v.dialog_title_list);
        this.mContentView = (ViewGroup) this.mRootView.findViewById(v.dialog_content);
        this.Rs = this.mRootView.findViewById(v.line_bg);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public e cb(String str) {
        this.mTitle = str;
        return this;
    }

    public e by(int i) {
        return cb(this.mActivity.getResources().getString(i));
    }

    public e a(CharSequence[] charSequenceArr, h hVar) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), hVar);
        }
        return this;
    }

    public e a(List<CharSequence> list, h hVar) {
        if (list != null && list.size() > 0) {
            this.Rp = list;
            if (hVar != null) {
                this.Rq = hVar;
            }
        }
        return this;
    }

    public e bz(int i) {
        this.Ru = i;
        return this;
    }

    public e bA(int i) {
        this.Ra = i;
        return this;
    }

    public e d(j<?> jVar) {
        if (!this.Rj) {
            this.mContext = jVar;
            this.Rj = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.Rr.setText(this.mTitle);
                this.Rr.setVisibility(0);
                this.Rs.setVisibility(0);
            } else {
                this.Rr.setVisibility(8);
                this.Rs.setVisibility(8);
            }
            if (this.Rp != null && this.Rp.size() > 0) {
                int size = this.Rp.size();
                for (int i = 0; i < size; i++) {
                    bB(i);
                }
            }
            c(jVar);
        }
        return this;
    }

    public e rg() {
        if (!this.Rj) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.mDialog != null) {
            k.a(this.mDialog, this.mActivity);
        } else {
            this.mDialog = new AlertDialog.Builder(this.mActivity).create();
            this.mDialog.setCanceledOnTouchOutside(true);
            if (k.a(this.mDialog, this.mActivity)) {
                Window window = this.mDialog.getWindow();
                if (this.Ru == -1) {
                    this.Ru = g.Rz;
                }
                if (this.Ra == -1) {
                    this.Ra = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.Ra);
                window.setContentView(this.mRootView);
            }
        }
        return this;
    }

    private void c(j<?> jVar) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (jVar instanceof TbPageContext) {
            ((TbPageContext) jVar).getLayoutMode().X(skinType == 1);
            ((TbPageContext) jVar).getLayoutMode().h(this.mRootView);
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            k.b(this.mDialog, this.mActivity);
        }
    }

    private View bB(int i) {
        View a = com.baidu.adp.lib.g.b.hH().a(this.mActivity, this.Rt, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) a;
        TextView textView = (TextView) a.findViewById(v.dialog_item_btn);
        View findViewById = a.findViewById(v.line);
        ba.i(a, u.dialg_alert_btn_bg);
        CharSequence charSequence = this.Rp.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.Rp.size() - 1) {
            findViewById.setVisibility(8);
        }
        if (this.Rq != null) {
            linearLayout.setOnClickListener(new f(this, i, textView));
        }
        this.mContentView.addView(a);
        return a;
    }

    public View bC(int i) {
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
