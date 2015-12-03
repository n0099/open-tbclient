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
import com.baidu.adp.lib.h.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static final HashMap<Integer, Integer[]> XI = new HashMap<>(2);
    private List<CharSequence> XB;
    private b XC;
    private final ViewGroup XD;
    private final TextView XE;
    private final View XF;
    private AlertDialog Xo;
    private final Activity mActivity;
    private h<?> mContext;
    private final ViewGroup mRootView;
    private String mTitle;
    private int XH = -1;
    private int Xe = -1;
    private boolean Xq = false;
    private int XG = n.g.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int XL = n.j.dialog_ani_b2t;
        public static final int XM = n.j.dialog_ani_t2b;
        public static final int XN = n.j.dialog_ani_l2r;
        public static final int XO = n.j.dialog_ani_r2l;
    }

    /* loaded from: classes.dex */
    public interface b {
        void itemClick(c cVar, int i, View view);
    }

    static {
        XI.put(0, new Integer[]{Integer.valueOf(n.e.dialg_alert_btn_bg), Integer.valueOf(n.e.dialog_bdalert_button_textcolor_pressed)});
        XI.put(1, new Integer[]{Integer.valueOf(n.e.btn_blue_square), Integer.valueOf(n.c.cp_bg_line_d)});
    }

    public c(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(n.g.dialog_bdlist, (ViewGroup) null);
        this.XE = (TextView) this.mRootView.findViewById(n.f.dialog_title_list);
        this.XD = (ViewGroup) this.mRootView.findViewById(n.f.dialog_content);
        this.XF = this.mRootView.findViewById(n.f.line_bg);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public c cD(String str) {
        this.mTitle = str;
        return this;
    }

    public c bQ(int i) {
        return cD(this.mActivity.getResources().getString(i));
    }

    public c a(CharSequence[] charSequenceArr, b bVar) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), bVar);
        }
        return this;
    }

    public c a(List<CharSequence> list, b bVar) {
        if (list != null && list.size() > 0) {
            this.XB = list;
            if (bVar != null) {
                this.XC = bVar;
            }
        }
        return this;
    }

    public c bR(int i) {
        this.XH = i;
        return this;
    }

    public c bS(int i) {
        this.Xe = i;
        return this;
    }

    public c d(h<?> hVar) {
        if (!this.Xq) {
            this.mContext = hVar;
            this.Xq = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.XE.setText(this.mTitle);
                this.XE.setVisibility(0);
                this.XF.setVisibility(0);
            } else {
                this.XE.setVisibility(8);
                this.XF.setVisibility(8);
            }
            if (this.XB != null && this.XB.size() > 0) {
                int size = this.XB.size();
                for (int i = 0; i < size; i++) {
                    bT(i);
                }
            }
            c(hVar);
        }
        return this;
    }

    public c tz() {
        if (!this.Xq) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Xo != null) {
            j.a(this.Xo, this.mActivity);
        } else {
            this.Xo = new AlertDialog.Builder(this.mActivity).create();
            this.Xo.setCanceledOnTouchOutside(true);
            if (j.a(this.Xo, this.mActivity)) {
                Window window = this.Xo.getWindow();
                if (this.XH == -1) {
                    this.XH = a.XL;
                }
                if (this.Xe == -1) {
                    this.Xe = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.Xe);
                window.setBackgroundDrawableResource(n.e.transparent_bg);
                window.setContentView(this.mRootView);
            }
        }
        return this;
    }

    private void c(h<?> hVar) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().af(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().k(this.mRootView);
        }
        this.mRootView.setBackgroundResource(n.e.transparent_bg);
    }

    public void dismiss() {
        if (this.Xo != null) {
            j.b(this.Xo, this.mActivity);
        }
    }

    private View bT(int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.XG, this.XD, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        TextView textView = (TextView) inflate.findViewById(n.f.dialog_item_btn);
        View findViewById = inflate.findViewById(n.f.line);
        CharSequence charSequence = this.XB.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.XB.size() - 1) {
            findViewById.setVisibility(8);
            as.i(inflate, n.e.dialog_single_button_bg_selector);
        } else {
            as.i(inflate, n.e.dialg_alert_btn_bg);
        }
        if (this.XC != null) {
            linearLayout.setOnClickListener(new d(this, i, textView));
        }
        this.XD.addView(inflate);
        return inflate;
    }

    public View bU(int i) {
        if (this.XD == null) {
            return null;
        }
        int childCount = this.XD.getChildCount();
        if (i < 0 || i > childCount - 1) {
            return null;
        }
        return this.XD.getChildAt(i);
    }

    public int getItemCount() {
        int childCount;
        if (this.XD != null && (childCount = this.XD.getChildCount()) >= 0) {
            return childCount;
        }
        return 0;
    }
}
