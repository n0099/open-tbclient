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
import com.baidu.adp.lib.h.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static final HashMap<Integer, Integer[]> Yy = new HashMap<>(2);
    private AlertDialog Yd;
    private final ViewGroup Ye;
    private List<CharSequence> Yr;
    private b Ys;
    private final ViewGroup Yt;
    private final TextView Yu;
    private final View Yv;
    private final Activity mActivity;
    private com.baidu.adp.base.h<?> mContext;
    private String mTitle;
    private int Yx = -1;
    private int XS = -1;
    private boolean Yg = false;
    private int Yw = t.h.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int YC = t.k.dialog_ani_b2t;
        public static final int YD = t.k.dialog_ani_t2b;
        public static final int YE = t.k.dialog_ani_l2r;
        public static final int YF = t.k.dialog_ani_r2l;
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(c cVar, int i, View view);
    }

    static {
        Yy.put(0, new Integer[]{Integer.valueOf(t.f.dialg_alert_btn_bg), Integer.valueOf(t.f.dialog_bdalert_button_textcolor_pressed)});
        Yy.put(1, new Integer[]{Integer.valueOf(t.f.btn_blue_square), Integer.valueOf(t.d.cp_bg_line_d)});
    }

    public c(Activity activity) {
        this.mActivity = activity;
        this.Ye = (ViewGroup) LayoutInflater.from(activity).inflate(t.h.dialog_bdlist, (ViewGroup) null);
        this.Yu = (TextView) this.Ye.findViewById(t.g.dialog_title_list);
        this.Yt = (ViewGroup) this.Ye.findViewById(t.g.dialog_content);
        this.Yv = this.Ye.findViewById(t.g.line_bg);
    }

    public View getRootView() {
        return this.Ye;
    }

    public c cF(String str) {
        this.mTitle = str;
        return this;
    }

    public c cb(int i) {
        return cF(this.mActivity.getResources().getString(i));
    }

    public c a(CharSequence[] charSequenceArr, b bVar) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), bVar);
        }
        return this;
    }

    public c a(List<CharSequence> list, b bVar) {
        if (list != null && list.size() > 0) {
            this.Yr = list;
            if (bVar != null) {
                this.Ys = bVar;
            }
        }
        return this;
    }

    public c cc(int i) {
        this.Yx = i;
        return this;
    }

    public c cd(int i) {
        this.XS = i;
        return this;
    }

    public c d(com.baidu.adp.base.h<?> hVar) {
        if (!this.Yg) {
            this.mContext = hVar;
            this.Yg = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.Yu.setText(this.mTitle);
                this.Yu.setVisibility(0);
                this.Yv.setVisibility(0);
            } else {
                this.Yu.setVisibility(8);
                this.Yv.setVisibility(8);
            }
            if (this.Yr != null && this.Yr.size() > 0) {
                int size = this.Yr.size();
                for (int i = 0; i < size; i++) {
                    ce(i);
                }
            }
            c(hVar);
        }
        return this;
    }

    public c un() {
        if (!this.Yg) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Yd != null) {
            j.a(this.Yd, this.mActivity);
        } else {
            this.Yd = new AlertDialog.Builder(this.mActivity).create();
            this.Yd.setCanceledOnTouchOutside(true);
            if (j.a(this.Yd, this.mActivity)) {
                Window window = this.Yd.getWindow();
                if (this.Yx == -1) {
                    this.Yx = a.YC;
                }
                if (this.XS == -1) {
                    this.XS = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.XS);
                window.setBackgroundDrawableResource(t.f.transparent_bg);
                window.setContentView(this.Ye);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.h<?> hVar) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ac(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this.Ye);
        }
        this.Ye.setBackgroundResource(t.f.transparent_bg);
    }

    public void dismiss() {
        if (this.Yd != null) {
            j.b(this.Yd, this.mActivity);
        }
    }

    private View ce(int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.Yw, this.Yt, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        TextView textView = (TextView) inflate.findViewById(t.g.dialog_item_btn);
        View findViewById = inflate.findViewById(t.g.line);
        CharSequence charSequence = this.Yr.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.Yr.size() - 1) {
            findViewById.setVisibility(8);
            ar.k(inflate, t.f.dialog_single_button_bg_selector);
        } else {
            ar.k(inflate, t.f.dialg_alert_btn_bg);
        }
        if (this.Ys != null) {
            linearLayout.setOnClickListener(new d(this, i, textView));
        }
        this.Yt.addView(inflate);
        return inflate;
    }

    public View cf(int i) {
        if (this.Yt == null) {
            return null;
        }
        int childCount = this.Yt.getChildCount();
        if (i < 0 || i > childCount - 1) {
            return null;
        }
        return this.Yt.getChildAt(i);
    }

    public int getItemCount() {
        int childCount;
        if (this.Yt != null && (childCount = this.Yt.getChildCount()) >= 0) {
            return childCount;
        }
        return 0;
    }
}
