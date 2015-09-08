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
    private static final HashMap<Integer, Integer[]> WY = new HashMap<>(2);
    private AlertDialog WE;
    private List<CharSequence> WR;
    private b WS;
    private final ViewGroup WT;
    private final TextView WU;
    private final View WV;
    private final Activity mActivity;
    private h<?> mContext;
    private final ViewGroup mRootView;
    private String mTitle;
    private int WX = -1;
    private int Wv = -1;
    private boolean WG = false;
    private int WW = i.g.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int Xb = i.C0057i.dialog_ani_b2t;
        public static final int Xc = i.C0057i.dialog_ani_t2b;
        public static final int Xd = i.C0057i.dialog_ani_l2r;
        public static final int Xe = i.C0057i.dialog_ani_r2l;
    }

    /* loaded from: classes.dex */
    public interface b {
        void itemClick(c cVar, int i, View view);
    }

    static {
        WY.put(0, new Integer[]{Integer.valueOf(i.e.dialg_alert_btn_bg), Integer.valueOf(i.e.dialog_bdalert_button_textcolor_pressed)});
        WY.put(1, new Integer[]{Integer.valueOf(i.e.btn_blue_square), Integer.valueOf(i.c.cp_bg_line_d)});
    }

    public c(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(i.g.dialog_bdlist, (ViewGroup) null);
        this.WU = (TextView) this.mRootView.findViewById(i.f.dialog_title_list);
        this.WT = (ViewGroup) this.mRootView.findViewById(i.f.dialog_content);
        this.WV = this.mRootView.findViewById(i.f.line_bg);
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
            this.WR = list;
            if (bVar != null) {
                this.WS = bVar;
            }
        }
        return this;
    }

    public c bJ(int i) {
        this.WX = i;
        return this;
    }

    public c bK(int i) {
        this.Wv = i;
        return this;
    }

    public c d(h<?> hVar) {
        if (!this.WG) {
            this.mContext = hVar;
            this.WG = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.WU.setText(this.mTitle);
                this.WU.setVisibility(0);
                this.WV.setVisibility(0);
            } else {
                this.WU.setVisibility(8);
                this.WV.setVisibility(8);
            }
            if (this.WR != null && this.WR.size() > 0) {
                int size = this.WR.size();
                for (int i = 0; i < size; i++) {
                    bL(i);
                }
            }
            c(hVar);
        }
        return this;
    }

    public c sX() {
        if (!this.WG) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.WE != null) {
            j.a(this.WE, this.mActivity);
        } else {
            this.WE = new AlertDialog.Builder(this.mActivity).create();
            this.WE.setCanceledOnTouchOutside(true);
            if (j.a(this.WE, this.mActivity)) {
                Window window = this.WE.getWindow();
                if (this.WX == -1) {
                    this.WX = a.Xb;
                }
                if (this.Wv == -1) {
                    this.Wv = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.Wv);
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
        if (this.WE != null) {
            j.b(this.WE, this.mActivity);
        }
    }

    private View bL(int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.WW, this.WT, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        TextView textView = (TextView) inflate.findViewById(i.f.dialog_item_btn);
        View findViewById = inflate.findViewById(i.f.line);
        CharSequence charSequence = this.WR.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.WR.size() - 1) {
            findViewById.setVisibility(8);
            al.h(inflate, i.e.dialog_single_button_bg_selector);
        } else {
            al.h(inflate, i.e.dialg_alert_btn_bg);
        }
        if (this.WS != null) {
            linearLayout.setOnClickListener(new d(this, i, textView));
        }
        this.WT.addView(inflate);
        return inflate;
    }

    public View bM(int i) {
        if (this.WT == null) {
            return null;
        }
        int childCount = this.WT.getChildCount();
        if (i < 0 || i > childCount - 1) {
            return null;
        }
        return this.WT.getChildAt(i);
    }
}
