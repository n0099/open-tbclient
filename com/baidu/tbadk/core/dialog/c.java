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
    private static final HashMap<Integer, Integer[]> aaM = new HashMap<>(2);
    private List<CharSequence> Wz;
    private b aaE;
    private final TextView aaF;
    private final View aaG;
    private LinearLayout.LayoutParams aaL;
    private AlertDialog aar;
    private final ViewGroup aas;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.g<?> mContext;
    private String mTitle;
    private int aaI = -1;
    private int aag = -1;
    private int aaJ = -1;
    private boolean aau = false;
    private int aaK = -1;
    private int aaH = w.j.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int aaQ = w.m.dialog_ani_b2t;
        public static final int aaR = w.m.dialog_ani_t2b;
        public static final int aaS = w.m.dialog_ani_l2r;
        public static final int aaT = w.m.dialog_ani_r2l;
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(c cVar, int i, View view);
    }

    static {
        aaM.put(0, new Integer[]{Integer.valueOf(w.g.dialg_alert_btn_bg), Integer.valueOf(w.g.dialog_bdalert_button_textcolor_pressed)});
        aaM.put(1, new Integer[]{Integer.valueOf(w.g.btn_blue_square), Integer.valueOf(w.e.cp_bg_line_d)});
    }

    public c(Activity activity) {
        this.mActivity = activity;
        this.aas = (ViewGroup) LayoutInflater.from(activity).inflate(w.j.dialog_bdlist, (ViewGroup) null);
        this.aaF = (TextView) this.aas.findViewById(w.h.dialog_title_list);
        this.mContentView = (ViewGroup) this.aas.findViewById(w.h.dialog_content);
        this.aaG = this.aas.findViewById(w.h.line_bg);
    }

    public View getRootView() {
        return this.aas;
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
            this.Wz = list;
            if (bVar != null) {
                this.aaE = bVar;
            }
        }
        return this;
    }

    public c cd(int i) {
        this.aaI = i;
        return this;
    }

    public c ce(int i) {
        this.aag = i;
        return this;
    }

    public c d(com.baidu.adp.base.g<?> gVar) {
        if (!this.aau) {
            this.mContext = gVar;
            this.aau = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.aaF.setText(this.mTitle);
                this.aaF.setVisibility(0);
                this.aaG.setVisibility(0);
            } else {
                this.aaF.setVisibility(8);
                this.aaG.setVisibility(8);
            }
            if (this.Wz != null && this.Wz.size() > 0) {
                int size = this.Wz.size();
                for (int i = 0; i < size; i++) {
                    cf(i);
                }
            }
            c(gVar);
        }
        return this;
    }

    public void reset() {
        this.aau = false;
        if (this.mContentView != null) {
            this.mContentView.removeAllViews();
        }
    }

    public c tT() {
        if (!this.aau) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aar != null) {
            j.a(this.aar, this.mActivity);
        } else {
            this.aar = new AlertDialog.Builder(this.mActivity, w.m.NoBackDimEnableDialog).create();
            this.aar.setCanceledOnTouchOutside(true);
            if (j.a(this.aar, this.mActivity)) {
                Window window = this.aar.getWindow();
                if (this.aaI == -1) {
                    this.aaI = a.aaQ;
                }
                if (this.aag == -1) {
                    this.aag = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.aag);
                window.setContentView(this.aas);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.g<?> gVar) {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (gVar instanceof TbPageContext) {
            ((TbPageContext) gVar).getLayoutMode().aj(skinType == 1);
            ((TbPageContext) gVar).getLayoutMode().t(this.aas);
        }
        this.aas.setBackgroundResource(w.g.transparent_bg);
    }

    public void hide() {
        if (this.aar != null) {
            this.aar.hide();
        }
    }

    public void dismiss() {
        if (this.aar != null) {
            j.b(this.aar, this.mActivity);
        }
    }

    private View cf(int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.aaH, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        TextView textView = (TextView) inflate.findViewById(w.h.dialog_item_btn);
        if (this.aaL != null) {
            textView.setLayoutParams(this.aaL);
        }
        if (this.aaJ != -1) {
            textView.setTextSize(0, this.aaJ);
        }
        if (this.aaK != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.aaK);
        }
        View findViewById = inflate.findViewById(w.h.line);
        CharSequence charSequence = this.Wz.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.Wz.size() - 1) {
            findViewById.setVisibility(8);
            aq.j(inflate, w.g.dialog_single_button_bg_selector);
        } else if (this.Wz.size() == 1) {
            findViewById.setVisibility(8);
            aq.j(inflate, w.g.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            aq.j(inflate, w.g.dialog_single_button_first_bg_selector);
        } else {
            aq.j(inflate, w.g.dialg_alert_btn_bg);
        }
        if (this.aaE != null) {
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
