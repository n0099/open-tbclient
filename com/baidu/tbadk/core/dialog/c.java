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
import com.baidu.adp.lib.g.j;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static final HashMap<Integer, Integer[]> Vl = new HashMap<>(2);
    private List<CharSequence> QY;
    private AlertDialog UQ;
    private final ViewGroup UR;
    private b Vd;
    private final TextView Ve;
    private final View Vf;
    private LinearLayout.LayoutParams Vk;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.g<?> mContext;
    private String mTitle;
    private int Vh = -1;
    private int UE = -1;
    private int Vi = -1;
    private boolean UT = false;
    private int Vj = -1;
    private int Vg = r.j.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int Vp = r.m.dialog_ani_b2t;
        public static final int Vq = r.m.dialog_ani_t2b;
        public static final int Vr = r.m.dialog_ani_l2r;
        public static final int Vs = r.m.dialog_ani_r2l;
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(c cVar, int i, View view);
    }

    static {
        Vl.put(0, new Integer[]{Integer.valueOf(r.g.dialg_alert_btn_bg), Integer.valueOf(r.g.dialog_bdalert_button_textcolor_pressed)});
        Vl.put(1, new Integer[]{Integer.valueOf(r.g.btn_blue_square), Integer.valueOf(r.e.cp_bg_line_d)});
    }

    public c(Activity activity) {
        this.mActivity = activity;
        this.UR = (ViewGroup) LayoutInflater.from(activity).inflate(r.j.dialog_bdlist, (ViewGroup) null);
        this.Ve = (TextView) this.UR.findViewById(r.h.dialog_title_list);
        this.mContentView = (ViewGroup) this.UR.findViewById(r.h.dialog_content);
        this.Vf = this.UR.findViewById(r.h.line_bg);
    }

    public View getRootView() {
        return this.UR;
    }

    public c cF(String str) {
        this.mTitle = str;
        return this;
    }

    public c cd(int i) {
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
            this.QY = list;
            if (bVar != null) {
                this.Vd = bVar;
            }
        }
        return this;
    }

    public c ce(int i) {
        this.Vh = i;
        return this;
    }

    public c cf(int i) {
        this.UE = i;
        return this;
    }

    public c d(com.baidu.adp.base.g<?> gVar) {
        if (!this.UT) {
            this.mContext = gVar;
            this.UT = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.Ve.setText(this.mTitle);
                this.Ve.setVisibility(0);
                this.Vf.setVisibility(0);
            } else {
                this.Ve.setVisibility(8);
                this.Vf.setVisibility(8);
            }
            if (this.QY != null && this.QY.size() > 0) {
                int size = this.QY.size();
                for (int i = 0; i < size; i++) {
                    cg(i);
                }
            }
            c(gVar);
        }
        return this;
    }

    public void reset() {
        this.UT = false;
        if (this.mContentView != null) {
            this.mContentView.removeAllViews();
        }
    }

    public c sY() {
        if (!this.UT) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.UQ != null) {
            j.a(this.UQ, this.mActivity);
        } else {
            this.UQ = new AlertDialog.Builder(this.mActivity, r.m.NoBackDimEnableDialog).create();
            this.UQ.setCanceledOnTouchOutside(true);
            if (j.a(this.UQ, this.mActivity)) {
                Window window = this.UQ.getWindow();
                if (this.Vh == -1) {
                    this.Vh = a.Vp;
                }
                if (this.UE == -1) {
                    this.UE = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.UE);
                window.setContentView(this.UR);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.g<?> gVar) {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (gVar instanceof TbPageContext) {
            ((TbPageContext) gVar).getLayoutMode().ai(skinType == 1);
            ((TbPageContext) gVar).getLayoutMode().v(this.UR);
        }
        this.UR.setBackgroundResource(r.g.transparent_bg);
    }

    public void hide() {
        if (this.UQ != null) {
            this.UQ.hide();
        }
    }

    public void dismiss() {
        if (this.UQ != null) {
            j.b(this.UQ, this.mActivity);
        }
    }

    private View cg(int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.Vg, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        TextView textView = (TextView) inflate.findViewById(r.h.dialog_item_btn);
        if (this.Vk != null) {
            textView.setLayoutParams(this.Vk);
        }
        if (this.Vi != -1) {
            textView.setTextSize(0, this.Vi);
        }
        if (this.Vj != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.Vj);
        }
        View findViewById = inflate.findViewById(r.h.line);
        CharSequence charSequence = this.QY.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.QY.size() - 1) {
            findViewById.setVisibility(8);
            ap.j(inflate, r.g.dialog_single_button_bg_selector);
        } else if (this.QY.size() == 1) {
            findViewById.setVisibility(8);
            ap.j(inflate, r.g.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            ap.j(inflate, r.g.dialog_single_button_first_bg_selector);
        } else {
            ap.j(inflate, r.g.dialg_alert_btn_bg);
        }
        if (this.Vd != null) {
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
