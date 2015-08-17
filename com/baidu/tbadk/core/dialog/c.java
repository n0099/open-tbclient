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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static final HashMap<Integer, Integer[]> WP = new HashMap<>(2);
    private List<CharSequence> WI;
    private b WJ;
    private final ViewGroup WK;
    private final TextView WL;
    private final View WM;
    private AlertDialog Ww;
    private final Activity mActivity;
    private h<?> mContext;
    private final ViewGroup mRootView;
    private String mTitle;
    private int WO = -1;
    private int Wn = -1;
    private boolean Wy = false;
    private int WN = i.g.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int WS = i.j.dialog_ani_b2t;
        public static final int WT = i.j.dialog_ani_t2b;
        public static final int WU = i.j.dialog_ani_l2r;
        public static final int WV = i.j.dialog_ani_r2l;
    }

    /* loaded from: classes.dex */
    public interface b {
        void itemClick(c cVar, int i, View view);
    }

    static {
        WP.put(0, new Integer[]{Integer.valueOf(i.e.dialg_alert_btn_bg), Integer.valueOf(i.e.dialog_bdalert_button_textcolor_pressed)});
        WP.put(1, new Integer[]{Integer.valueOf(i.e.btn_blue_square), Integer.valueOf(i.c.cp_bg_line_d)});
    }

    public c(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(i.g.dialog_bdlist, (ViewGroup) null);
        this.WL = (TextView) this.mRootView.findViewById(i.f.dialog_title_list);
        this.WK = (ViewGroup) this.mRootView.findViewById(i.f.dialog_content);
        this.WM = this.mRootView.findViewById(i.f.line_bg);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public c co(String str) {
        this.mTitle = str;
        return this;
    }

    public c bF(int i) {
        return co(this.mActivity.getResources().getString(i));
    }

    public c a(CharSequence[] charSequenceArr, b bVar) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), bVar);
        }
        return this;
    }

    public c a(List<CharSequence> list, b bVar) {
        if (list != null && list.size() > 0) {
            this.WI = list;
            if (bVar != null) {
                this.WJ = bVar;
            }
        }
        return this;
    }

    public c bG(int i) {
        this.WO = i;
        return this;
    }

    public c bH(int i) {
        this.Wn = i;
        return this;
    }

    public c d(h<?> hVar) {
        if (!this.Wy) {
            this.mContext = hVar;
            this.Wy = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.WL.setText(this.mTitle);
                this.WL.setVisibility(0);
                this.WM.setVisibility(0);
            } else {
                this.WL.setVisibility(8);
                this.WM.setVisibility(8);
            }
            if (this.WI != null && this.WI.size() > 0) {
                int size = this.WI.size();
                for (int i = 0; i < size; i++) {
                    bI(i);
                }
            }
            c(hVar);
        }
        return this;
    }

    public c sS() {
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
                if (this.WO == -1) {
                    this.WO = a.WS;
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

    private View bI(int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.WN, this.WK, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        TextView textView = (TextView) inflate.findViewById(i.f.dialog_item_btn);
        View findViewById = inflate.findViewById(i.f.line);
        CharSequence charSequence = this.WI.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.WI.size() - 1) {
            findViewById.setVisibility(8);
            al.i(inflate, i.e.dialog_single_button_bg_selector);
        } else {
            al.i(inflate, i.e.dialg_alert_btn_bg);
        }
        if (this.WJ != null) {
            linearLayout.setOnClickListener(new d(this, i, textView));
        }
        this.WK.addView(inflate);
        return inflate;
    }

    public View bJ(int i) {
        if (this.WK == null) {
            return null;
        }
        int childCount = this.WK.getChildCount();
        if (i < 0 || i > childCount - 1) {
            return null;
        }
        return this.WK.getChildAt(i);
    }
}
