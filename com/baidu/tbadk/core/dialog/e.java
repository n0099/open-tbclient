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
    private static final HashMap<Integer, Integer[]> Rx = new HashMap<>(2);
    private List<CharSequence> Rr;
    private h Rs;
    private final TextView Rt;
    private final View Ru;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private j<?> mContext;
    private AlertDialog mDialog;
    private final ViewGroup mRootView;
    private String mTitle;
    private int Rw = -1;
    private int Rc = -1;
    private boolean Rl = false;
    private int Rv = w.dialog_bdlist_item;

    static {
        Rx.put(0, new Integer[]{Integer.valueOf(u.dialg_alert_btn_bg), Integer.valueOf(u.dialog_bdalert_button_textcolor_pressed)});
        Rx.put(1, new Integer[]{Integer.valueOf(u.btn_blue_square), Integer.valueOf(s.cp_bg_line_d)});
    }

    public e(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) com.baidu.adp.lib.g.b.hH().inflate(activity, w.dialog_bdlist, null);
        this.Rt = (TextView) this.mRootView.findViewById(v.dialog_title_list);
        this.mContentView = (ViewGroup) this.mRootView.findViewById(v.dialog_content);
        this.Ru = this.mRootView.findViewById(v.line_bg);
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
            this.Rr = list;
            if (hVar != null) {
                this.Rs = hVar;
            }
        }
        return this;
    }

    public e bz(int i) {
        this.Rw = i;
        return this;
    }

    public e bA(int i) {
        this.Rc = i;
        return this;
    }

    public e d(j<?> jVar) {
        if (!this.Rl) {
            this.mContext = jVar;
            this.Rl = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.Rt.setText(this.mTitle);
                this.Rt.setVisibility(0);
                this.Ru.setVisibility(0);
            } else {
                this.Rt.setVisibility(8);
                this.Ru.setVisibility(8);
            }
            if (this.Rr != null && this.Rr.size() > 0) {
                int size = this.Rr.size();
                for (int i = 0; i < size; i++) {
                    bB(i);
                }
            }
            c(jVar);
        }
        return this;
    }

    public e rg() {
        if (!this.Rl) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.mDialog != null) {
            k.a(this.mDialog, this.mActivity);
        } else {
            this.mDialog = new AlertDialog.Builder(this.mActivity).create();
            this.mDialog.setCanceledOnTouchOutside(true);
            if (k.a(this.mDialog, this.mActivity)) {
                Window window = this.mDialog.getWindow();
                if (this.Rw == -1) {
                    this.Rw = g.RB;
                }
                if (this.Rc == -1) {
                    this.Rc = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.Rc);
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
        View a = com.baidu.adp.lib.g.b.hH().a(this.mActivity, this.Rv, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) a;
        TextView textView = (TextView) a.findViewById(v.dialog_item_btn);
        View findViewById = a.findViewById(v.line);
        ba.i(a, u.dialg_alert_btn_bg);
        CharSequence charSequence = this.Rr.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.Rr.size() - 1) {
            findViewById.setVisibility(8);
        }
        if (this.Rs != null) {
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
