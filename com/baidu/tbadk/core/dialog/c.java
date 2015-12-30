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
    private static final HashMap<Integer, Integer[]> Yl = new HashMap<>(2);
    private AlertDialog XR;
    private List<CharSequence> Ye;
    private b Yf;
    private final ViewGroup Yg;
    private final TextView Yh;
    private final View Yi;
    private final Activity mActivity;
    private h<?> mContext;
    private final ViewGroup mRootView;
    private String mTitle;
    private int Yk = -1;
    private int XG = -1;
    private boolean XT = false;
    private int Yj = n.h.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int Yo = n.k.dialog_ani_b2t;
        public static final int Yp = n.k.dialog_ani_t2b;
        public static final int Yq = n.k.dialog_ani_l2r;
        public static final int Yr = n.k.dialog_ani_r2l;
    }

    /* loaded from: classes.dex */
    public interface b {
        void itemClick(c cVar, int i, View view);
    }

    static {
        Yl.put(0, new Integer[]{Integer.valueOf(n.f.dialg_alert_btn_bg), Integer.valueOf(n.f.dialog_bdalert_button_textcolor_pressed)});
        Yl.put(1, new Integer[]{Integer.valueOf(n.f.btn_blue_square), Integer.valueOf(n.d.cp_bg_line_d)});
    }

    public c(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(n.h.dialog_bdlist, (ViewGroup) null);
        this.Yh = (TextView) this.mRootView.findViewById(n.g.dialog_title_list);
        this.Yg = (ViewGroup) this.mRootView.findViewById(n.g.dialog_content);
        this.Yi = this.mRootView.findViewById(n.g.line_bg);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public c cG(String str) {
        this.mTitle = str;
        return this;
    }

    public c bJ(int i) {
        return cG(this.mActivity.getResources().getString(i));
    }

    public c a(CharSequence[] charSequenceArr, b bVar) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), bVar);
        }
        return this;
    }

    public c a(List<CharSequence> list, b bVar) {
        if (list != null && list.size() > 0) {
            this.Ye = list;
            if (bVar != null) {
                this.Yf = bVar;
            }
        }
        return this;
    }

    public c bK(int i) {
        this.Yk = i;
        return this;
    }

    public c bL(int i) {
        this.XG = i;
        return this;
    }

    public c d(h<?> hVar) {
        if (!this.XT) {
            this.mContext = hVar;
            this.XT = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.Yh.setText(this.mTitle);
                this.Yh.setVisibility(0);
                this.Yi.setVisibility(0);
            } else {
                this.Yh.setVisibility(8);
                this.Yi.setVisibility(8);
            }
            if (this.Ye != null && this.Ye.size() > 0) {
                int size = this.Ye.size();
                for (int i = 0; i < size; i++) {
                    bM(i);
                }
            }
            c(hVar);
        }
        return this;
    }

    public c tj() {
        if (!this.XT) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.XR != null) {
            j.a(this.XR, this.mActivity);
        } else {
            this.XR = new AlertDialog.Builder(this.mActivity).create();
            this.XR.setCanceledOnTouchOutside(true);
            if (j.a(this.XR, this.mActivity)) {
                Window window = this.XR.getWindow();
                if (this.Yk == -1) {
                    this.Yk = a.Yo;
                }
                if (this.XG == -1) {
                    this.XG = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.XG);
                window.setBackgroundDrawableResource(n.f.transparent_bg);
                window.setContentView(this.mRootView);
            }
        }
        return this;
    }

    private void c(h<?> hVar) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ac(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().k(this.mRootView);
        }
        this.mRootView.setBackgroundResource(n.f.transparent_bg);
    }

    public void dismiss() {
        if (this.XR != null) {
            j.b(this.XR, this.mActivity);
        }
    }

    private View bM(int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.Yj, this.Yg, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        TextView textView = (TextView) inflate.findViewById(n.g.dialog_item_btn);
        View findViewById = inflate.findViewById(n.g.line);
        CharSequence charSequence = this.Ye.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.Ye.size() - 1) {
            findViewById.setVisibility(8);
            as.i(inflate, n.f.dialog_single_button_bg_selector);
        } else {
            as.i(inflate, n.f.dialg_alert_btn_bg);
        }
        if (this.Yf != null) {
            linearLayout.setOnClickListener(new d(this, i, textView));
        }
        this.Yg.addView(inflate);
        return inflate;
    }

    public View bN(int i) {
        if (this.Yg == null) {
            return null;
        }
        int childCount = this.Yg.getChildCount();
        if (i < 0 || i > childCount - 1) {
            return null;
        }
        return this.Yg.getChildAt(i);
    }

    public int getItemCount() {
        int childCount;
        if (this.Yg != null && (childCount = this.Yg.getChildCount()) >= 0) {
            return childCount;
        }
        return 0;
    }
}
