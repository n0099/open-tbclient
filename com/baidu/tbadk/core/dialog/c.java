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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static final HashMap<Integer, Integer[]> WQ = new HashMap<>(2);
    private List<CharSequence> TF;
    private b WK;
    private final ViewGroup WL;
    private final TextView WM;
    private final View WN;
    private AlertDialog Wx;
    private final ViewGroup Wy;
    private final Activity mActivity;
    private com.baidu.adp.base.h<?> mContext;
    private String mTitle;
    private int WP = -1;
    private int Wm = -1;
    private boolean WA = false;
    private int WO = t.h.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int WU = t.k.dialog_ani_b2t;
        public static final int WV = t.k.dialog_ani_t2b;
        public static final int WW = t.k.dialog_ani_l2r;
        public static final int WX = t.k.dialog_ani_r2l;
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(c cVar, int i, View view);
    }

    static {
        WQ.put(0, new Integer[]{Integer.valueOf(t.f.dialg_alert_btn_bg), Integer.valueOf(t.f.dialog_bdalert_button_textcolor_pressed)});
        WQ.put(1, new Integer[]{Integer.valueOf(t.f.btn_blue_square), Integer.valueOf(t.d.cp_bg_line_d)});
    }

    public c(Activity activity) {
        this.mActivity = activity;
        this.Wy = (ViewGroup) LayoutInflater.from(activity).inflate(t.h.dialog_bdlist, (ViewGroup) null);
        this.WM = (TextView) this.Wy.findViewById(t.g.dialog_title_list);
        this.WL = (ViewGroup) this.Wy.findViewById(t.g.dialog_content);
        this.WN = this.Wy.findViewById(t.g.line_bg);
    }

    public View getRootView() {
        return this.Wy;
    }

    public c cD(String str) {
        this.mTitle = str;
        return this;
    }

    public c cd(int i) {
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
            this.TF = list;
            if (bVar != null) {
                this.WK = bVar;
            }
        }
        return this;
    }

    public c ce(int i) {
        this.WP = i;
        return this;
    }

    public c cf(int i) {
        this.Wm = i;
        return this;
    }

    public c d(com.baidu.adp.base.h<?> hVar) {
        if (!this.WA) {
            this.mContext = hVar;
            this.WA = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.WM.setText(this.mTitle);
                this.WM.setVisibility(0);
                this.WN.setVisibility(0);
            } else {
                this.WM.setVisibility(8);
                this.WN.setVisibility(8);
            }
            if (this.TF != null && this.TF.size() > 0) {
                int size = this.TF.size();
                for (int i = 0; i < size; i++) {
                    cg(i);
                }
            }
            c(hVar);
        }
        return this;
    }

    public c us() {
        if (!this.WA) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Wx != null) {
            j.a(this.Wx, this.mActivity);
        } else {
            this.Wx = new AlertDialog.Builder(this.mActivity).create();
            this.Wx.setCanceledOnTouchOutside(true);
            if (j.a(this.Wx, this.mActivity)) {
                Window window = this.Wx.getWindow();
                if (this.WP == -1) {
                    this.WP = a.WU;
                }
                if (this.Wm == -1) {
                    this.Wm = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.Wm);
                window.setBackgroundDrawableResource(t.f.transparent_bg);
                window.setContentView(this.Wy);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.h<?> hVar) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ab(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this.Wy);
        }
        this.Wy.setBackgroundResource(t.f.transparent_bg);
    }

    public void dismiss() {
        if (this.Wx != null) {
            j.b(this.Wx, this.mActivity);
        }
    }

    private View cg(int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.WO, this.WL, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        TextView textView = (TextView) inflate.findViewById(t.g.dialog_item_btn);
        View findViewById = inflate.findViewById(t.g.line);
        CharSequence charSequence = this.TF.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.TF.size() - 1) {
            findViewById.setVisibility(8);
            at.k(inflate, t.f.dialog_single_button_bg_selector);
        } else {
            at.k(inflate, t.f.dialg_alert_btn_bg);
        }
        if (this.WK != null) {
            linearLayout.setOnClickListener(new d(this, i, textView));
        }
        this.WL.addView(inflate);
        return inflate;
    }

    public View ch(int i) {
        if (this.WL == null) {
            return null;
        }
        int childCount = this.WL.getChildCount();
        if (i < 0 || i > childCount - 1) {
            return null;
        }
        return this.WL.getChildAt(i);
    }

    public int getItemCount() {
        int childCount;
        if (this.WL != null && (childCount = this.WL.getChildCount()) >= 0) {
            return childCount;
        }
        return 0;
    }
}
