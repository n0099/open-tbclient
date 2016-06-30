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
import com.baidu.tieba.u;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static final HashMap<Integer, Integer[]> Sv = new HashMap<>(2);
    private List<CharSequence> Os;
    private AlertDialog Sa;
    private final ViewGroup Sb;
    private b Sn;
    private final TextView So;
    private final View Sp;
    private LinearLayout.LayoutParams Su;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.h<?> mContext;
    private String mTitle;
    private int Sr = -1;
    private int RO = -1;
    private int Ss = -1;
    private boolean Sd = false;
    private int St = -1;
    private int Sq = u.h.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int Sz = u.k.dialog_ani_b2t;
        public static final int SA = u.k.dialog_ani_t2b;
        public static final int SB = u.k.dialog_ani_l2r;
        public static final int SC = u.k.dialog_ani_r2l;
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(c cVar, int i, View view);
    }

    static {
        Sv.put(0, new Integer[]{Integer.valueOf(u.f.dialg_alert_btn_bg), Integer.valueOf(u.f.dialog_bdalert_button_textcolor_pressed)});
        Sv.put(1, new Integer[]{Integer.valueOf(u.f.btn_blue_square), Integer.valueOf(u.d.cp_bg_line_d)});
    }

    public c(Activity activity) {
        this.mActivity = activity;
        this.Sb = (ViewGroup) LayoutInflater.from(activity).inflate(u.h.dialog_bdlist, (ViewGroup) null);
        this.So = (TextView) this.Sb.findViewById(u.g.dialog_title_list);
        this.mContentView = (ViewGroup) this.Sb.findViewById(u.g.dialog_content);
        this.Sp = this.Sb.findViewById(u.g.line_bg);
    }

    public View getRootView() {
        return this.Sb;
    }

    public c cA(String str) {
        this.mTitle = str;
        return this;
    }

    public c bP(int i) {
        return cA(this.mActivity.getResources().getString(i));
    }

    public c a(CharSequence[] charSequenceArr, b bVar) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), bVar);
        }
        return this;
    }

    public c a(List<CharSequence> list, b bVar) {
        if (list != null && list.size() > 0) {
            this.Os = list;
            if (bVar != null) {
                this.Sn = bVar;
            }
        }
        return this;
    }

    public c bQ(int i) {
        this.Sr = i;
        return this;
    }

    public c bR(int i) {
        this.RO = i;
        return this;
    }

    public c d(com.baidu.adp.base.h<?> hVar) {
        if (!this.Sd) {
            this.mContext = hVar;
            this.Sd = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.So.setText(this.mTitle);
                this.So.setVisibility(0);
                this.Sp.setVisibility(0);
            } else {
                this.So.setVisibility(8);
                this.Sp.setVisibility(8);
            }
            if (this.Os != null && this.Os.size() > 0) {
                int size = this.Os.size();
                for (int i = 0; i < size; i++) {
                    bS(i);
                }
            }
            c(hVar);
        }
        return this;
    }

    public void reset() {
        this.Sd = false;
        if (this.mContentView != null) {
            this.mContentView.removeAllViews();
        }
    }

    public c rW() {
        if (!this.Sd) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Sa != null) {
            j.a(this.Sa, this.mActivity);
        } else {
            this.Sa = new AlertDialog.Builder(this.mActivity, u.k.NoBackDimEnableDialog).create();
            this.Sa.setCanceledOnTouchOutside(true);
            if (j.a(this.Sa, this.mActivity)) {
                Window window = this.Sa.getWindow();
                if (this.Sr == -1) {
                    this.Sr = a.Sz;
                }
                if (this.RO == -1) {
                    this.RO = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.RO);
                window.setContentView(this.Sb);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.h<?> hVar) {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ad(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().w(this.Sb);
        }
        this.Sb.setBackgroundResource(u.f.transparent_bg);
    }

    public void dismiss() {
        if (this.Sa != null) {
            j.b(this.Sa, this.mActivity);
        }
    }

    private View bS(int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.Sq, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        TextView textView = (TextView) inflate.findViewById(u.g.dialog_item_btn);
        if (this.Su != null) {
            textView.setLayoutParams(this.Su);
        }
        if (this.Ss != -1) {
            textView.setTextSize(0, this.Ss);
        }
        if (this.St != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.St);
        }
        View findViewById = inflate.findViewById(u.g.line);
        CharSequence charSequence = this.Os.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.Os.size() - 1) {
            findViewById.setVisibility(8);
            av.k(inflate, u.f.dialog_single_button_bg_selector);
        } else if (this.Os.size() == 1) {
            findViewById.setVisibility(8);
            av.k(inflate, u.f.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            av.k(inflate, u.f.dialog_single_button_first_bg_selector);
        } else {
            av.k(inflate, u.f.dialg_alert_btn_bg);
        }
        if (this.Sn != null) {
            linearLayout.setOnClickListener(new d(this, i, textView));
        }
        this.mContentView.addView(inflate);
        return inflate;
    }

    public View bT(int i) {
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
