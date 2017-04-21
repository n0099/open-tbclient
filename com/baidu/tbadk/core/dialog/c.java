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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static final HashMap<Integer, Integer[]> aaN = new HashMap<>(2);
    private List<CharSequence> WA;
    private b aaF;
    private final TextView aaG;
    private final View aaH;
    private LinearLayout.LayoutParams aaM;
    private AlertDialog aas;
    private final ViewGroup aat;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.g<?> mContext;
    private String mTitle;
    private int aaJ = -1;
    private int aah = -1;
    private int aaK = -1;
    private boolean aav = false;
    private int aaL = -1;
    private int aaI = w.j.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int aaR = w.m.dialog_ani_b2t;
        public static final int aaS = w.m.dialog_ani_t2b;
        public static final int aaT = w.m.dialog_ani_l2r;
        public static final int aaU = w.m.dialog_ani_r2l;
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(c cVar, int i, View view);
    }

    static {
        aaN.put(0, new Integer[]{Integer.valueOf(w.g.dialg_alert_btn_bg), Integer.valueOf(w.g.dialog_bdalert_button_textcolor_pressed)});
        aaN.put(1, new Integer[]{Integer.valueOf(w.g.btn_blue_square), Integer.valueOf(w.e.cp_bg_line_d)});
    }

    public c(Activity activity) {
        this.mActivity = activity;
        this.aat = (ViewGroup) LayoutInflater.from(activity).inflate(w.j.dialog_bdlist, (ViewGroup) null);
        this.aaG = (TextView) this.aat.findViewById(w.h.dialog_title_list);
        this.mContentView = (ViewGroup) this.aat.findViewById(w.h.dialog_content);
        this.aaH = this.aat.findViewById(w.h.line_bg);
    }

    public View getRootView() {
        return this.aat;
    }

    public c cF(String str) {
        this.mTitle = str;
        return this;
    }

    public c cc(int i) {
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
            this.WA = list;
            if (bVar != null) {
                this.aaF = bVar;
            }
        }
        return this;
    }

    public c cd(int i) {
        this.aaJ = i;
        return this;
    }

    public c ce(int i) {
        this.aah = i;
        return this;
    }

    public c d(com.baidu.adp.base.g<?> gVar) {
        if (!this.aav) {
            this.mContext = gVar;
            this.aav = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.aaG.setText(this.mTitle);
                this.aaG.setVisibility(0);
                this.aaH.setVisibility(0);
            } else {
                this.aaG.setVisibility(8);
                this.aaH.setVisibility(8);
            }
            if (this.WA != null && this.WA.size() > 0) {
                int size = this.WA.size();
                for (int i = 0; i < size; i++) {
                    cf(i);
                }
            }
            c(gVar);
        }
        return this;
    }

    public void reset() {
        this.aav = false;
        if (this.mContentView != null) {
            this.mContentView.removeAllViews();
        }
    }

    public c tT() {
        if (!this.aav) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aas != null) {
            j.a(this.aas, this.mActivity);
        } else {
            this.aas = new AlertDialog.Builder(this.mActivity, w.m.NoBackDimEnableDialog).create();
            this.aas.setCanceledOnTouchOutside(true);
            if (j.a(this.aas, this.mActivity)) {
                Window window = this.aas.getWindow();
                if (this.aaJ == -1) {
                    this.aaJ = a.aaR;
                }
                if (this.aah == -1) {
                    this.aah = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.aah);
                window.setContentView(this.aat);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.g<?> gVar) {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (gVar instanceof TbPageContext) {
            ((TbPageContext) gVar).getLayoutMode().aj(skinType == 1);
            ((TbPageContext) gVar).getLayoutMode().t(this.aat);
        }
        this.aat.setBackgroundResource(w.g.transparent_bg);
    }

    public void hide() {
        if (this.aas != null) {
            this.aas.hide();
        }
    }

    public void dismiss() {
        if (this.aas != null) {
            j.b(this.aas, this.mActivity);
        }
    }

    private View cf(int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.aaI, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        TextView textView = (TextView) inflate.findViewById(w.h.dialog_item_btn);
        if (this.aaM != null) {
            textView.setLayoutParams(this.aaM);
        }
        if (this.aaK != -1) {
            textView.setTextSize(0, this.aaK);
        }
        if (this.aaL != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.aaL);
        }
        View findViewById = inflate.findViewById(w.h.line);
        CharSequence charSequence = this.WA.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.WA.size() - 1) {
            findViewById.setVisibility(8);
            aq.j(inflate, w.g.dialog_single_button_bg_selector);
        } else if (this.WA.size() == 1) {
            findViewById.setVisibility(8);
            aq.j(inflate, w.g.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            aq.j(inflate, w.g.dialog_single_button_first_bg_selector);
        } else {
            aq.j(inflate, w.g.dialg_alert_btn_bg);
        }
        if (this.aaF != null) {
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
