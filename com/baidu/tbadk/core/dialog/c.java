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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static final HashMap<Integer, Integer[]> Wd = new HashMap<>(2);
    private List<CharSequence> Rx;
    private AlertDialog VI;
    private final ViewGroup VJ;
    private b VV;
    private final TextView VW;
    private final View VX;
    private LinearLayout.LayoutParams Wc;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.h<?> mContext;
    private String mTitle;
    private int VZ = -1;
    private int Vx = -1;
    private int Wa = -1;
    private boolean VL = false;
    private int Wb = -1;
    private int VY = r.h.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int Wh = r.k.dialog_ani_b2t;
        public static final int Wi = r.k.dialog_ani_t2b;
        public static final int Wj = r.k.dialog_ani_l2r;
        public static final int Wk = r.k.dialog_ani_r2l;
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(c cVar, int i, View view);
    }

    static {
        Wd.put(0, new Integer[]{Integer.valueOf(r.f.dialg_alert_btn_bg), Integer.valueOf(r.f.dialog_bdalert_button_textcolor_pressed)});
        Wd.put(1, new Integer[]{Integer.valueOf(r.f.btn_blue_square), Integer.valueOf(r.d.cp_bg_line_d)});
    }

    public c(Activity activity) {
        this.mActivity = activity;
        this.VJ = (ViewGroup) LayoutInflater.from(activity).inflate(r.h.dialog_bdlist, (ViewGroup) null);
        this.VW = (TextView) this.VJ.findViewById(r.g.dialog_title_list);
        this.mContentView = (ViewGroup) this.VJ.findViewById(r.g.dialog_content);
        this.VX = this.VJ.findViewById(r.g.line_bg);
    }

    public View getRootView() {
        return this.VJ;
    }

    public c cE(String str) {
        this.mTitle = str;
        return this;
    }

    public c cc(int i) {
        return cE(this.mActivity.getResources().getString(i));
    }

    public c a(CharSequence[] charSequenceArr, b bVar) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), bVar);
        }
        return this;
    }

    public c a(List<CharSequence> list, b bVar) {
        if (list != null && list.size() > 0) {
            this.Rx = list;
            if (bVar != null) {
                this.VV = bVar;
            }
        }
        return this;
    }

    public c cd(int i) {
        this.VZ = i;
        return this;
    }

    public c ce(int i) {
        this.Vx = i;
        return this;
    }

    public c d(com.baidu.adp.base.h<?> hVar) {
        if (!this.VL) {
            this.mContext = hVar;
            this.VL = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.VW.setText(this.mTitle);
                this.VW.setVisibility(0);
                this.VX.setVisibility(0);
            } else {
                this.VW.setVisibility(8);
                this.VX.setVisibility(8);
            }
            if (this.Rx != null && this.Rx.size() > 0) {
                int size = this.Rx.size();
                for (int i = 0; i < size; i++) {
                    cf(i);
                }
            }
            c(hVar);
        }
        return this;
    }

    public void reset() {
        this.VL = false;
        if (this.mContentView != null) {
            this.mContentView.removeAllViews();
        }
    }

    public c tp() {
        if (!this.VL) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.VI != null) {
            j.a(this.VI, this.mActivity);
        } else {
            this.VI = new AlertDialog.Builder(this.mActivity, r.k.NoBackDimEnableDialog).create();
            this.VI.setCanceledOnTouchOutside(true);
            if (j.a(this.VI, this.mActivity)) {
                Window window = this.VI.getWindow();
                if (this.VZ == -1) {
                    this.VZ = a.Wh;
                }
                if (this.Vx == -1) {
                    this.Vx = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.Vx);
                window.setContentView(this.VJ);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.h<?> hVar) {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ah(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this.VJ);
        }
        this.VJ.setBackgroundResource(r.f.transparent_bg);
    }

    public void hide() {
        if (this.VI != null) {
            this.VI.hide();
        }
    }

    public void dismiss() {
        if (this.VI != null) {
            j.b(this.VI, this.mActivity);
        }
    }

    private View cf(int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.VY, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        TextView textView = (TextView) inflate.findViewById(r.g.dialog_item_btn);
        if (this.Wc != null) {
            textView.setLayoutParams(this.Wc);
        }
        if (this.Wa != -1) {
            textView.setTextSize(0, this.Wa);
        }
        if (this.Wb != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.Wb);
        }
        View findViewById = inflate.findViewById(r.g.line);
        CharSequence charSequence = this.Rx.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.Rx.size() - 1) {
            findViewById.setVisibility(8);
            av.k(inflate, r.f.dialog_single_button_bg_selector);
        } else if (this.Rx.size() == 1) {
            findViewById.setVisibility(8);
            av.k(inflate, r.f.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            av.k(inflate, r.f.dialog_single_button_first_bg_selector);
        } else {
            av.k(inflate, r.f.dialg_alert_btn_bg);
        }
        if (this.VV != null) {
            linearLayout.setOnClickListener(new d(this, i, textView));
        }
        this.mContentView.addView(inflate);
        return inflate;
    }

    public View cg(int i) {
        if (this.mContentView == null) {
            return null;
        }
        int childCount = this.mContentView.getChildCount();
        if (i < 0 || i > childCount - 1) {
            return null;
        }
        return this.mContentView.getChildAt(i);
    }

    public int getItemCount() {
        int childCount;
        if (this.mContentView != null && (childCount = this.mContentView.getChildCount()) >= 0) {
            return childCount;
        }
        return 0;
    }
}
