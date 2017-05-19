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
    private static final HashMap<Integer, Integer[]> aai = new HashMap<>(2);
    private List<CharSequence> VT;
    private AlertDialog ZN;
    private final ViewGroup ZO;
    private b aaa;
    private final TextView aab;
    private final View aac;
    private LinearLayout.LayoutParams aah;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.g<?> mContext;
    private String mTitle;
    private int aae = -1;
    private int ZC = -1;
    private int aaf = -1;
    private boolean ZQ = false;
    private int aag = -1;
    private int aad = w.j.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int aam = w.m.dialog_ani_b2t;
        public static final int aan = w.m.dialog_ani_t2b;
        public static final int aao = w.m.dialog_ani_l2r;
        public static final int aap = w.m.dialog_ani_r2l;
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(c cVar, int i, View view);
    }

    static {
        aai.put(0, new Integer[]{Integer.valueOf(w.g.dialg_alert_btn_bg), Integer.valueOf(w.g.dialog_bdalert_button_textcolor_pressed)});
        aai.put(1, new Integer[]{Integer.valueOf(w.g.btn_blue_square), Integer.valueOf(w.e.cp_bg_line_d)});
    }

    public c(Activity activity) {
        this.mActivity = activity;
        this.ZO = (ViewGroup) LayoutInflater.from(activity).inflate(w.j.dialog_bdlist, (ViewGroup) null);
        this.aab = (TextView) this.ZO.findViewById(w.h.dialog_title_list);
        this.mContentView = (ViewGroup) this.ZO.findViewById(w.h.dialog_content);
        this.aac = this.ZO.findViewById(w.h.line_bg);
    }

    public View getRootView() {
        return this.ZO;
    }

    public c cD(String str) {
        this.mTitle = str;
        return this;
    }

    public c ca(int i) {
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
            this.VT = list;
            if (bVar != null) {
                this.aaa = bVar;
            }
        }
        return this;
    }

    public c cb(int i) {
        this.aae = i;
        return this;
    }

    public c cc(int i) {
        this.ZC = i;
        return this;
    }

    public c d(com.baidu.adp.base.g<?> gVar) {
        if (!this.ZQ) {
            this.mContext = gVar;
            this.ZQ = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.aab.setText(this.mTitle);
                this.aab.setVisibility(0);
                this.aac.setVisibility(0);
            } else {
                this.aab.setVisibility(8);
                this.aac.setVisibility(8);
            }
            if (this.VT != null && this.VT.size() > 0) {
                int size = this.VT.size();
                for (int i = 0; i < size; i++) {
                    cd(i);
                }
            }
            c(gVar);
        }
        return this;
    }

    public void reset() {
        this.ZQ = false;
        if (this.mContentView != null) {
            this.mContentView.removeAllViews();
        }
    }

    public c tg() {
        if (!this.ZQ) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.ZN != null) {
            j.a(this.ZN, this.mActivity);
        } else {
            this.ZN = new AlertDialog.Builder(this.mActivity, w.m.NoBackDimEnableDialog).create();
            this.ZN.setCanceledOnTouchOutside(true);
            if (j.a(this.ZN, this.mActivity)) {
                Window window = this.ZN.getWindow();
                if (this.aae == -1) {
                    this.aae = a.aam;
                }
                if (this.ZC == -1) {
                    this.ZC = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.ZC);
                window.setContentView(this.ZO);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.g<?> gVar) {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (gVar instanceof TbPageContext) {
            ((TbPageContext) gVar).getLayoutMode().ai(skinType == 1);
            ((TbPageContext) gVar).getLayoutMode().t(this.ZO);
        }
        this.ZO.setBackgroundResource(w.g.transparent_bg);
    }

    public void hide() {
        if (this.ZN != null) {
            this.ZN.hide();
        }
    }

    public void dismiss() {
        if (this.ZN != null) {
            j.b(this.ZN, this.mActivity);
        }
    }

    private View cd(int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.aad, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        TextView textView = (TextView) inflate.findViewById(w.h.dialog_item_btn);
        if (this.aah != null) {
            textView.setLayoutParams(this.aah);
        }
        if (this.aaf != -1) {
            textView.setTextSize(0, this.aaf);
        }
        if (this.aag != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.aag);
        }
        View findViewById = inflate.findViewById(w.h.line);
        CharSequence charSequence = this.VT.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.VT.size() - 1) {
            findViewById.setVisibility(8);
            aq.j(inflate, w.g.dialog_single_button_bg_selector);
        } else if (this.VT.size() == 1) {
            findViewById.setVisibility(8);
            aq.j(inflate, w.g.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            aq.j(inflate, w.g.dialog_single_button_first_bg_selector);
        } else {
            aq.j(inflate, w.g.dialg_alert_btn_bg);
        }
        if (this.aaa != null) {
            linearLayout.setOnClickListener(new d(this, i, textView));
        }
        this.mContentView.addView(inflate);
        return inflate;
    }

    public View ce(int i) {
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
