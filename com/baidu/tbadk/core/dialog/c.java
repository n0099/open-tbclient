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
import com.baidu.tieba.r;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static final HashMap<Integer, Integer[]> WB = new HashMap<>(2);
    private List<CharSequence> RU;
    private LinearLayout.LayoutParams WA;
    private AlertDialog Wg;
    private final ViewGroup Wh;
    private b Wt;
    private final TextView Wu;
    private final View Wv;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.h<?> mContext;
    private String mTitle;
    private int Wx = -1;
    private int VV = -1;
    private int Wy = -1;
    private boolean Wj = false;
    private int Wz = -1;
    private int Ww = r.h.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int WF = r.k.dialog_ani_b2t;
        public static final int WG = r.k.dialog_ani_t2b;
        public static final int WH = r.k.dialog_ani_l2r;
        public static final int WI = r.k.dialog_ani_r2l;
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(c cVar, int i, View view);
    }

    static {
        WB.put(0, new Integer[]{Integer.valueOf(r.f.dialg_alert_btn_bg), Integer.valueOf(r.f.dialog_bdalert_button_textcolor_pressed)});
        WB.put(1, new Integer[]{Integer.valueOf(r.f.btn_blue_square), Integer.valueOf(r.d.cp_bg_line_d)});
    }

    public c(Activity activity) {
        this.mActivity = activity;
        this.Wh = (ViewGroup) LayoutInflater.from(activity).inflate(r.h.dialog_bdlist, (ViewGroup) null);
        this.Wu = (TextView) this.Wh.findViewById(r.g.dialog_title_list);
        this.mContentView = (ViewGroup) this.Wh.findViewById(r.g.dialog_content);
        this.Wv = this.Wh.findViewById(r.g.line_bg);
    }

    public View getRootView() {
        return this.Wh;
    }

    public c cG(String str) {
        this.mTitle = str;
        return this;
    }

    public c cd(int i) {
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
            this.RU = list;
            if (bVar != null) {
                this.Wt = bVar;
            }
        }
        return this;
    }

    public c ce(int i) {
        this.Wx = i;
        return this;
    }

    public c cf(int i) {
        this.VV = i;
        return this;
    }

    public c d(com.baidu.adp.base.h<?> hVar) {
        if (!this.Wj) {
            this.mContext = hVar;
            this.Wj = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.Wu.setText(this.mTitle);
                this.Wu.setVisibility(0);
                this.Wv.setVisibility(0);
            } else {
                this.Wu.setVisibility(8);
                this.Wv.setVisibility(8);
            }
            if (this.RU != null && this.RU.size() > 0) {
                int size = this.RU.size();
                for (int i = 0; i < size; i++) {
                    cg(i);
                }
            }
            c(hVar);
        }
        return this;
    }

    public void reset() {
        this.Wj = false;
        if (this.mContentView != null) {
            this.mContentView.removeAllViews();
        }
    }

    public c tt() {
        if (!this.Wj) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Wg != null) {
            j.a(this.Wg, this.mActivity);
        } else {
            this.Wg = new AlertDialog.Builder(this.mActivity, r.k.NoBackDimEnableDialog).create();
            this.Wg.setCanceledOnTouchOutside(true);
            if (j.a(this.Wg, this.mActivity)) {
                Window window = this.Wg.getWindow();
                if (this.Wx == -1) {
                    this.Wx = a.WF;
                }
                if (this.VV == -1) {
                    this.VV = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.VV);
                window.setContentView(this.Wh);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.h<?> hVar) {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ai(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this.Wh);
        }
        this.Wh.setBackgroundResource(r.f.transparent_bg);
    }

    public void hide() {
        if (this.Wg != null) {
            this.Wg.hide();
        }
    }

    public void dismiss() {
        if (this.Wg != null) {
            j.b(this.Wg, this.mActivity);
        }
    }

    private View cg(int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.Ww, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        TextView textView = (TextView) inflate.findViewById(r.g.dialog_item_btn);
        if (this.WA != null) {
            textView.setLayoutParams(this.WA);
        }
        if (this.Wy != -1) {
            textView.setTextSize(0, this.Wy);
        }
        if (this.Wz != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.Wz);
        }
        View findViewById = inflate.findViewById(r.g.line);
        CharSequence charSequence = this.RU.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.RU.size() - 1) {
            findViewById.setVisibility(8);
            at.k(inflate, r.f.dialog_single_button_bg_selector);
        } else if (this.RU.size() == 1) {
            findViewById.setVisibility(8);
            at.k(inflate, r.f.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            at.k(inflate, r.f.dialog_single_button_first_bg_selector);
        } else {
            at.k(inflate, r.f.dialg_alert_btn_bg);
        }
        if (this.Wt != null) {
            linearLayout.setOnClickListener(new d(this, i, textView));
        }
        this.mContentView.addView(inflate);
        return inflate;
    }

    public View ch(int i) {
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
