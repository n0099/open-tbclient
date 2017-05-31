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
    private static final HashMap<Integer, Integer[]> aah = new HashMap<>(2);
    private List<CharSequence> VG;
    private AlertDialog ZM;
    private final ViewGroup ZN;
    private b ZZ;
    private final TextView aaa;
    private final View aab;
    private LinearLayout.LayoutParams aag;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.g<?> mContext;
    private String mTitle;
    private int aad = -1;
    private int ZB = -1;
    private int aae = -1;
    private boolean ZP = false;
    private int aaf = -1;
    private int aac = w.j.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int aal = w.m.dialog_ani_b2t;
        public static final int aam = w.m.dialog_ani_t2b;
        public static final int aan = w.m.dialog_ani_l2r;
        public static final int aao = w.m.dialog_ani_r2l;
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(c cVar, int i, View view);
    }

    static {
        aah.put(0, new Integer[]{Integer.valueOf(w.g.dialg_alert_btn_bg), Integer.valueOf(w.g.dialog_bdalert_button_textcolor_pressed)});
        aah.put(1, new Integer[]{Integer.valueOf(w.g.btn_blue_square), Integer.valueOf(w.e.cp_bg_line_d)});
    }

    public c(Activity activity) {
        this.mActivity = activity;
        this.ZN = (ViewGroup) LayoutInflater.from(activity).inflate(w.j.dialog_bdlist, (ViewGroup) null);
        this.aaa = (TextView) this.ZN.findViewById(w.h.dialog_title_list);
        this.mContentView = (ViewGroup) this.ZN.findViewById(w.h.dialog_content);
        this.aab = this.ZN.findViewById(w.h.line_bg);
    }

    public View getRootView() {
        return this.ZN;
    }

    public c cC(String str) {
        this.mTitle = str;
        return this;
    }

    public c cb(int i) {
        return cC(this.mActivity.getResources().getString(i));
    }

    public c a(CharSequence[] charSequenceArr, b bVar) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), bVar);
        }
        return this;
    }

    public c a(List<CharSequence> list, b bVar) {
        if (list != null && list.size() > 0) {
            this.VG = list;
            if (bVar != null) {
                this.ZZ = bVar;
            }
        }
        return this;
    }

    public c cc(int i) {
        this.aad = i;
        return this;
    }

    public c cd(int i) {
        this.ZB = i;
        return this;
    }

    public c d(com.baidu.adp.base.g<?> gVar) {
        if (!this.ZP) {
            this.mContext = gVar;
            this.ZP = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.aaa.setText(this.mTitle);
                this.aaa.setVisibility(0);
                this.aab.setVisibility(0);
            } else {
                this.aaa.setVisibility(8);
                this.aab.setVisibility(8);
            }
            if (this.VG != null && this.VG.size() > 0) {
                int size = this.VG.size();
                for (int i = 0; i < size; i++) {
                    ce(i);
                }
            }
            c(gVar);
        }
        return this;
    }

    public void reset() {
        this.ZP = false;
        if (this.mContentView != null) {
            this.mContentView.removeAllViews();
        }
    }

    public c tf() {
        if (!this.ZP) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.ZM != null) {
            j.a(this.ZM, this.mActivity);
        } else {
            this.ZM = new AlertDialog.Builder(this.mActivity, w.m.NoBackDimEnableDialog).create();
            this.ZM.setCanceledOnTouchOutside(true);
            if (j.a(this.ZM, this.mActivity)) {
                Window window = this.ZM.getWindow();
                if (this.aad == -1) {
                    this.aad = a.aal;
                }
                if (this.ZB == -1) {
                    this.ZB = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.ZB);
                window.setContentView(this.ZN);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.g<?> gVar) {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (gVar instanceof TbPageContext) {
            ((TbPageContext) gVar).getLayoutMode().ah(skinType == 1);
            ((TbPageContext) gVar).getLayoutMode().t(this.ZN);
        }
        this.ZN.setBackgroundResource(w.g.transparent_bg);
    }

    public void hide() {
        if (this.ZM != null) {
            this.ZM.hide();
        }
    }

    public void dismiss() {
        if (this.ZM != null) {
            j.b(this.ZM, this.mActivity);
        }
    }

    private View ce(int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.aac, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        TextView textView = (TextView) inflate.findViewById(w.h.dialog_item_btn);
        if (this.aag != null) {
            textView.setLayoutParams(this.aag);
        }
        if (this.aae != -1) {
            textView.setTextSize(0, this.aae);
        }
        if (this.aaf != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.aaf);
        }
        View findViewById = inflate.findViewById(w.h.line);
        CharSequence charSequence = this.VG.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.VG.size() - 1) {
            findViewById.setVisibility(8);
            aq.j(inflate, w.g.dialog_single_button_bg_selector);
        } else if (this.VG.size() == 1) {
            findViewById.setVisibility(8);
            aq.j(inflate, w.g.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            aq.j(inflate, w.g.dialog_single_button_first_bg_selector);
        } else {
            aq.j(inflate, w.g.dialg_alert_btn_bg);
        }
        if (this.ZZ != null) {
            linearLayout.setOnClickListener(new d(this, i, textView));
        }
        this.mContentView.addView(inflate);
        return inflate;
    }

    public View cf(int i) {
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
