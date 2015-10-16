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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static final HashMap<Integer, Integer[]> WS = new HashMap<>(2);
    private List<CharSequence> WL;
    private b WM;
    private final ViewGroup WN;
    private final TextView WO;
    private final View WP;
    private AlertDialog Wy;
    private final Activity mActivity;
    private h<?> mContext;
    private final ViewGroup mRootView;
    private String mTitle;
    private int WR = -1;
    private int Wp = -1;
    private boolean WA = false;
    private int WQ = i.g.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int WV = i.C0057i.dialog_ani_b2t;
        public static final int WW = i.C0057i.dialog_ani_t2b;
        public static final int WX = i.C0057i.dialog_ani_l2r;
        public static final int WY = i.C0057i.dialog_ani_r2l;
    }

    /* loaded from: classes.dex */
    public interface b {
        void itemClick(c cVar, int i, View view);
    }

    static {
        WS.put(0, new Integer[]{Integer.valueOf(i.e.dialg_alert_btn_bg), Integer.valueOf(i.e.dialog_bdalert_button_textcolor_pressed)});
        WS.put(1, new Integer[]{Integer.valueOf(i.e.btn_blue_square), Integer.valueOf(i.c.cp_bg_line_d)});
    }

    public c(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(i.g.dialog_bdlist, (ViewGroup) null);
        this.WO = (TextView) this.mRootView.findViewById(i.f.dialog_title_list);
        this.WN = (ViewGroup) this.mRootView.findViewById(i.f.dialog_content);
        this.WP = this.mRootView.findViewById(i.f.line_bg);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public c cv(String str) {
        this.mTitle = str;
        return this;
    }

    public c bI(int i) {
        return cv(this.mActivity.getResources().getString(i));
    }

    public c a(CharSequence[] charSequenceArr, b bVar) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), bVar);
        }
        return this;
    }

    public c a(List<CharSequence> list, b bVar) {
        if (list != null && list.size() > 0) {
            this.WL = list;
            if (bVar != null) {
                this.WM = bVar;
            }
        }
        return this;
    }

    public c bJ(int i) {
        this.WR = i;
        return this;
    }

    public c bK(int i) {
        this.Wp = i;
        return this;
    }

    public c d(h<?> hVar) {
        if (!this.WA) {
            this.mContext = hVar;
            this.WA = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.WO.setText(this.mTitle);
                this.WO.setVisibility(0);
                this.WP.setVisibility(0);
            } else {
                this.WO.setVisibility(8);
                this.WP.setVisibility(8);
            }
            if (this.WL != null && this.WL.size() > 0) {
                int size = this.WL.size();
                for (int i = 0; i < size; i++) {
                    bL(i);
                }
            }
            c(hVar);
        }
        return this;
    }

    public c sU() {
        if (!this.WA) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Wy != null) {
            j.a(this.Wy, this.mActivity);
        } else {
            this.Wy = new AlertDialog.Builder(this.mActivity).create();
            this.Wy.setCanceledOnTouchOutside(true);
            if (j.a(this.Wy, this.mActivity)) {
                Window window = this.Wy.getWindow();
                if (this.WR == -1) {
                    this.WR = a.WV;
                }
                if (this.Wp == -1) {
                    this.Wp = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.Wp);
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
        if (this.Wy != null) {
            j.b(this.Wy, this.mActivity);
        }
    }

    private View bL(int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.WQ, this.WN, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        TextView textView = (TextView) inflate.findViewById(i.f.dialog_item_btn);
        View findViewById = inflate.findViewById(i.f.line);
        CharSequence charSequence = this.WL.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.WL.size() - 1) {
            findViewById.setVisibility(8);
            an.i(inflate, i.e.dialog_single_button_bg_selector);
        } else {
            an.i(inflate, i.e.dialg_alert_btn_bg);
        }
        if (this.WM != null) {
            linearLayout.setOnClickListener(new d(this, i, textView));
        }
        this.WN.addView(inflate);
        return inflate;
    }

    public View bM(int i) {
        if (this.WN == null) {
            return null;
        }
        int childCount = this.WN.getChildCount();
        if (i < 0 || i > childCount - 1) {
            return null;
        }
        return this.WN.getChildAt(i);
    }
}
