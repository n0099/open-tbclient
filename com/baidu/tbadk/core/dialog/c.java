package com.baidu.tbadk.core.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.h;
import com.baidu.adp.lib.g.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static final HashMap<Integer, Integer[]> WQ = new HashMap<>(2);
    private List<CharSequence> WJ;
    private b WK;
    private final ViewGroup WL;
    private final TextView WM;
    private final View WN;
    private AlertDialog Ww;
    private final Activity mActivity;
    private h<?> mContext;
    private final ViewGroup mRootView;
    private String mTitle;
    private int WP = -1;
    private int Wn = -1;
    private boolean Wy = false;
    private int WO = i.g.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int WT = i.C0057i.dialog_ani_b2t;
        public static final int WU = i.C0057i.dialog_ani_t2b;
        public static final int WV = i.C0057i.dialog_ani_l2r;
        public static final int WW = i.C0057i.dialog_ani_r2l;
    }

    /* loaded from: classes.dex */
    public interface b {
        void itemClick(c cVar, int i, View view);
    }

    static {
        WQ.put(0, new Integer[]{Integer.valueOf(i.e.dialg_alert_btn_bg), Integer.valueOf(i.e.dialog_bdalert_button_textcolor_pressed)});
        WQ.put(1, new Integer[]{Integer.valueOf(i.e.btn_blue_square), Integer.valueOf(i.c.cp_bg_line_d)});
    }

    public c(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(i.g.dialog_bdlist, (ViewGroup) null);
        this.WM = (TextView) this.mRootView.findViewById(i.f.dialog_title_list);
        this.WL = (ViewGroup) this.mRootView.findViewById(i.f.dialog_content);
        this.WN = this.mRootView.findViewById(i.f.line_bg);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public c cu(String str) {
        this.mTitle = str;
        return this;
    }

    public c bI(int i) {
        return cu(this.mActivity.getResources().getString(i));
    }

    public c a(CharSequence[] charSequenceArr, b bVar) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), bVar);
        }
        return this;
    }

    public c a(List<CharSequence> list, b bVar) {
        if (list != null && list.size() > 0) {
            this.WJ = list;
            if (bVar != null) {
                this.WK = bVar;
            }
        }
        return this;
    }

    public c bJ(int i) {
        this.WP = i;
        return this;
    }

    public c bK(int i) {
        this.Wn = i;
        return this;
    }

    public c d(h<?> hVar) {
        if (!this.Wy) {
            this.mContext = hVar;
            this.Wy = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.WM.setText(this.mTitle);
                this.WM.setVisibility(0);
                this.WN.setVisibility(0);
            } else {
                this.WM.setVisibility(8);
                this.WN.setVisibility(8);
            }
            if (this.WJ != null && this.WJ.size() > 0) {
                int size = this.WJ.size();
                for (int i = 0; i < size; i++) {
                    bL(i);
                }
            }
            c(hVar);
        }
        return this;
    }

    public c sU() {
        if (!this.Wy) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Ww != null) {
            j.a(this.Ww, this.mActivity);
        } else {
            this.Ww = new AlertDialog.Builder(this.mActivity).create();
            this.Ww.setCanceledOnTouchOutside(true);
            if (j.a(this.Ww, this.mActivity)) {
                Window window = this.Ww.getWindow();
                if (this.WP == -1) {
                    this.WP = a.WT;
                }
                if (this.Wn == -1) {
                    this.Wn = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.Wn);
                window.setBackgroundDrawableResource(i.e.transparent_bg);
                window.setContentView(this.mRootView);
            }
        }
        return this;
    }

    private void c(h<?> hVar) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ad(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().k(this.mRootView);
        }
        this.mRootView.setBackgroundResource(i.e.transparent_bg);
    }

    public void dismiss() {
        if (this.Ww != null) {
            j.b(this.Ww, this.mActivity);
        }
    }

    private View bL(int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.WO, this.WL, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        TextView textView = (TextView) inflate.findViewById(i.f.dialog_item_btn);
        View findViewById = inflate.findViewById(i.f.line);
        CharSequence charSequence = this.WJ.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.WJ.size() - 1) {
            findViewById.setVisibility(8);
            am.i(inflate, i.e.dialog_single_button_bg_selector);
        } else {
            am.i(inflate, i.e.dialg_alert_btn_bg);
        }
        if (this.WK != null) {
            linearLayout.setOnClickListener(new d(this, i, textView));
        }
        this.WL.addView(inflate);
        return inflate;
    }

    public View bM(int i) {
        if (this.WL == null) {
            return null;
        }
        int childCount = this.WL.getChildCount();
        if (i < 0 || i > childCount - 1) {
            return null;
        }
        return this.WL.getChildAt(i);
    }
}
