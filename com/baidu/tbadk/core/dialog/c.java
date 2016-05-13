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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static final HashMap<Integer, Integer[]> Se = new HashMap<>(2);
    private List<CharSequence> Ot;
    private AlertDialog RH;
    private final ViewGroup RI;
    private b RV;
    private final ViewGroup RW;
    private final TextView RX;
    private final View RY;
    private LinearLayout.LayoutParams Sd;
    private final Activity mActivity;
    private com.baidu.adp.base.h<?> mContext;
    private String mTitle;
    private int Sa = -1;
    private int Rw = -1;
    private int Sb = -1;
    private boolean RK = false;
    private int Sc = -1;
    private int RZ = t.h.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int Si = t.k.dialog_ani_b2t;
        public static final int Sj = t.k.dialog_ani_t2b;
        public static final int Sk = t.k.dialog_ani_l2r;
        public static final int Sl = t.k.dialog_ani_r2l;
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(c cVar, int i, View view);
    }

    static {
        Se.put(0, new Integer[]{Integer.valueOf(t.f.dialg_alert_btn_bg), Integer.valueOf(t.f.dialog_bdalert_button_textcolor_pressed)});
        Se.put(1, new Integer[]{Integer.valueOf(t.f.btn_blue_square), Integer.valueOf(t.d.cp_bg_line_d)});
    }

    public c(Activity activity) {
        this.mActivity = activity;
        this.RI = (ViewGroup) LayoutInflater.from(activity).inflate(t.h.dialog_bdlist, (ViewGroup) null);
        this.RX = (TextView) this.RI.findViewById(t.g.dialog_title_list);
        this.RW = (ViewGroup) this.RI.findViewById(t.g.dialog_content);
        this.RY = this.RI.findViewById(t.g.line_bg);
    }

    public View getRootView() {
        return this.RI;
    }

    public c cB(String str) {
        this.mTitle = str;
        return this;
    }

    public c bO(int i) {
        return cB(this.mActivity.getResources().getString(i));
    }

    public c a(CharSequence[] charSequenceArr, b bVar) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), bVar);
        }
        return this;
    }

    public c a(List<CharSequence> list, b bVar) {
        if (list != null && list.size() > 0) {
            this.Ot = list;
            if (bVar != null) {
                this.RV = bVar;
            }
        }
        return this;
    }

    public c bP(int i) {
        this.Sa = i;
        return this;
    }

    public c bQ(int i) {
        this.Rw = i;
        return this;
    }

    public c d(com.baidu.adp.base.h<?> hVar) {
        if (!this.RK) {
            this.mContext = hVar;
            this.RK = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.RX.setText(this.mTitle);
                this.RX.setVisibility(0);
                this.RY.setVisibility(0);
            } else {
                this.RX.setVisibility(8);
                this.RY.setVisibility(8);
            }
            if (this.Ot != null && this.Ot.size() > 0) {
                int size = this.Ot.size();
                for (int i = 0; i < size; i++) {
                    bR(i);
                }
            }
            c(hVar);
        }
        return this;
    }

    public void reset() {
        this.RK = false;
        if (this.RW != null) {
            this.RW.removeAllViews();
        }
    }

    public c rY() {
        if (!this.RK) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.RH != null) {
            j.a(this.RH, this.mActivity);
        } else {
            this.RH = new AlertDialog.Builder(this.mActivity, t.k.NoBackDimEnableDialog).create();
            this.RH.setCanceledOnTouchOutside(true);
            if (j.a(this.RH, this.mActivity)) {
                Window window = this.RH.getWindow();
                if (this.Sa == -1) {
                    this.Sa = a.Si;
                }
                if (this.Rw == -1) {
                    this.Rw = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.Rw);
                window.setContentView(this.RI);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.h<?> hVar) {
        int skinType = TbadkCoreApplication.m11getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ae(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this.RI);
        }
        this.RI.setBackgroundResource(t.f.transparent_bg);
    }

    public void dismiss() {
        if (this.RH != null) {
            j.b(this.RH, this.mActivity);
        }
    }

    private View bR(int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.RZ, this.RW, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        TextView textView = (TextView) inflate.findViewById(t.g.dialog_item_btn);
        if (this.Sd != null) {
            textView.setLayoutParams(this.Sd);
        }
        if (this.Sb != -1) {
            textView.setTextSize(0, this.Sb);
        }
        if (this.Sc != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.Sc);
        }
        View findViewById = inflate.findViewById(t.g.line);
        CharSequence charSequence = this.Ot.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.Ot.size() - 1) {
            findViewById.setVisibility(8);
            at.k(inflate, t.f.dialog_single_button_bg_selector);
        } else if (this.Ot.size() == 1) {
            findViewById.setVisibility(8);
            at.k(inflate, t.f.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            at.k(inflate, t.f.dialog_single_button_first_bg_selector);
        } else {
            at.k(inflate, t.f.dialg_alert_btn_bg);
        }
        if (this.RV != null) {
            linearLayout.setOnClickListener(new d(this, i, textView));
        }
        this.RW.addView(inflate);
        return inflate;
    }

    public View bS(int i) {
        if (this.RW == null) {
            return null;
        }
        int childCount = this.RW.getChildCount();
        if (i < 0 || i > childCount - 1) {
            return null;
        }
        return this.RW.getChildAt(i);
    }

    public int getItemCount() {
        int childCount;
        if (this.RW != null && (childCount = this.RW.getChildCount()) >= 0) {
            return childCount;
        }
        return 0;
    }
}
