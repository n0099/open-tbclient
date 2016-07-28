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
    private static final HashMap<Integer, Integer[]> Td = new HashMap<>(2);
    private List<CharSequence> OE;
    private AlertDialog SI;
    private final ViewGroup SJ;
    private b SV;
    private final TextView SW;
    private final View SX;
    private LinearLayout.LayoutParams Tc;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.h<?> mContext;
    private String mTitle;
    private int SZ = -1;
    private int Sx = -1;
    private int Ta = -1;
    private boolean SL = false;
    private int Tb = -1;
    private int SY = u.h.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int Th = u.k.dialog_ani_b2t;
        public static final int Ti = u.k.dialog_ani_t2b;
        public static final int Tj = u.k.dialog_ani_l2r;
        public static final int Tk = u.k.dialog_ani_r2l;
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(c cVar, int i, View view);
    }

    static {
        Td.put(0, new Integer[]{Integer.valueOf(u.f.dialg_alert_btn_bg), Integer.valueOf(u.f.dialog_bdalert_button_textcolor_pressed)});
        Td.put(1, new Integer[]{Integer.valueOf(u.f.btn_blue_square), Integer.valueOf(u.d.cp_bg_line_d)});
    }

    public c(Activity activity) {
        this.mActivity = activity;
        this.SJ = (ViewGroup) LayoutInflater.from(activity).inflate(u.h.dialog_bdlist, (ViewGroup) null);
        this.SW = (TextView) this.SJ.findViewById(u.g.dialog_title_list);
        this.mContentView = (ViewGroup) this.SJ.findViewById(u.g.dialog_content);
        this.SX = this.SJ.findViewById(u.g.line_bg);
    }

    public View getRootView() {
        return this.SJ;
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
            this.OE = list;
            if (bVar != null) {
                this.SV = bVar;
            }
        }
        return this;
    }

    public c bQ(int i) {
        this.SZ = i;
        return this;
    }

    public c bR(int i) {
        this.Sx = i;
        return this;
    }

    public c d(com.baidu.adp.base.h<?> hVar) {
        if (!this.SL) {
            this.mContext = hVar;
            this.SL = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.SW.setText(this.mTitle);
                this.SW.setVisibility(0);
                this.SX.setVisibility(0);
            } else {
                this.SW.setVisibility(8);
                this.SX.setVisibility(8);
            }
            if (this.OE != null && this.OE.size() > 0) {
                int size = this.OE.size();
                for (int i = 0; i < size; i++) {
                    bS(i);
                }
            }
            c(hVar);
        }
        return this;
    }

    public void reset() {
        this.SL = false;
        if (this.mContentView != null) {
            this.mContentView.removeAllViews();
        }
    }

    public c rV() {
        if (!this.SL) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.SI != null) {
            j.a(this.SI, this.mActivity);
        } else {
            this.SI = new AlertDialog.Builder(this.mActivity, u.k.NoBackDimEnableDialog).create();
            this.SI.setCanceledOnTouchOutside(true);
            if (j.a(this.SI, this.mActivity)) {
                Window window = this.SI.getWindow();
                if (this.SZ == -1) {
                    this.SZ = a.Th;
                }
                if (this.Sx == -1) {
                    this.Sx = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.Sx);
                window.setContentView(this.SJ);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.h<?> hVar) {
        int skinType = TbadkCoreApplication.m10getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().af(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().w(this.SJ);
        }
        this.SJ.setBackgroundResource(u.f.transparent_bg);
    }

    public void hide() {
        if (this.SI != null) {
            this.SI.hide();
        }
    }

    public void dismiss() {
        if (this.SI != null) {
            j.b(this.SI, this.mActivity);
        }
    }

    private View bS(int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.SY, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        TextView textView = (TextView) inflate.findViewById(u.g.dialog_item_btn);
        if (this.Tc != null) {
            textView.setLayoutParams(this.Tc);
        }
        if (this.Ta != -1) {
            textView.setTextSize(0, this.Ta);
        }
        if (this.Tb != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.Tb);
        }
        View findViewById = inflate.findViewById(u.g.line);
        CharSequence charSequence = this.OE.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.OE.size() - 1) {
            findViewById.setVisibility(8);
            av.k(inflate, u.f.dialog_single_button_bg_selector);
        } else if (this.OE.size() == 1) {
            findViewById.setVisibility(8);
            av.k(inflate, u.f.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            av.k(inflate, u.f.dialog_single_button_first_bg_selector);
        } else {
            av.k(inflate, u.f.dialg_alert_btn_bg);
        }
        if (this.SV != null) {
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
