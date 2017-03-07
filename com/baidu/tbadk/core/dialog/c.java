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
    private static final HashMap<Integer, Integer[]> aaw = new HashMap<>(2);
    private List<CharSequence> Wk;
    private AlertDialog aab;
    private final ViewGroup aac;
    private b aao;
    private final TextView aap;
    private final View aaq;
    private LinearLayout.LayoutParams aav;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.g<?> mContext;
    private String mTitle;
    private int aas = -1;
    private int ZQ = -1;
    private int aat = -1;
    private boolean aae = false;
    private int aau = -1;
    private int aar = w.j.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int aaA = w.m.dialog_ani_b2t;
        public static final int aaB = w.m.dialog_ani_t2b;
        public static final int aaC = w.m.dialog_ani_l2r;
        public static final int aaD = w.m.dialog_ani_r2l;
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(c cVar, int i, View view);
    }

    static {
        aaw.put(0, new Integer[]{Integer.valueOf(w.g.dialg_alert_btn_bg), Integer.valueOf(w.g.dialog_bdalert_button_textcolor_pressed)});
        aaw.put(1, new Integer[]{Integer.valueOf(w.g.btn_blue_square), Integer.valueOf(w.e.cp_bg_line_d)});
    }

    public c(Activity activity) {
        this.mActivity = activity;
        this.aac = (ViewGroup) LayoutInflater.from(activity).inflate(w.j.dialog_bdlist, (ViewGroup) null);
        this.aap = (TextView) this.aac.findViewById(w.h.dialog_title_list);
        this.mContentView = (ViewGroup) this.aac.findViewById(w.h.dialog_content);
        this.aaq = this.aac.findViewById(w.h.line_bg);
    }

    public View getRootView() {
        return this.aac;
    }

    public c cy(String str) {
        this.mTitle = str;
        return this;
    }

    public c bZ(int i) {
        return cy(this.mActivity.getResources().getString(i));
    }

    public c a(CharSequence[] charSequenceArr, b bVar) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), bVar);
        }
        return this;
    }

    public c a(List<CharSequence> list, b bVar) {
        if (list != null && list.size() > 0) {
            this.Wk = list;
            if (bVar != null) {
                this.aao = bVar;
            }
        }
        return this;
    }

    public c ca(int i) {
        this.aas = i;
        return this;
    }

    public c cb(int i) {
        this.ZQ = i;
        return this;
    }

    public c d(com.baidu.adp.base.g<?> gVar) {
        if (!this.aae) {
            this.mContext = gVar;
            this.aae = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.aap.setText(this.mTitle);
                this.aap.setVisibility(0);
                this.aaq.setVisibility(0);
            } else {
                this.aap.setVisibility(8);
                this.aaq.setVisibility(8);
            }
            if (this.Wk != null && this.Wk.size() > 0) {
                int size = this.Wk.size();
                for (int i = 0; i < size; i++) {
                    cc(i);
                }
            }
            c(gVar);
        }
        return this;
    }

    public void reset() {
        this.aae = false;
        if (this.mContentView != null) {
            this.mContentView.removeAllViews();
        }
    }

    public c tv() {
        if (!this.aae) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aab != null) {
            j.a(this.aab, this.mActivity);
        } else {
            this.aab = new AlertDialog.Builder(this.mActivity, w.m.NoBackDimEnableDialog).create();
            this.aab.setCanceledOnTouchOutside(true);
            if (j.a(this.aab, this.mActivity)) {
                Window window = this.aab.getWindow();
                if (this.aas == -1) {
                    this.aas = a.aaA;
                }
                if (this.ZQ == -1) {
                    this.ZQ = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.ZQ);
                window.setContentView(this.aac);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.g<?> gVar) {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (gVar instanceof TbPageContext) {
            ((TbPageContext) gVar).getLayoutMode().ah(skinType == 1);
            ((TbPageContext) gVar).getLayoutMode().t(this.aac);
        }
        this.aac.setBackgroundResource(w.g.transparent_bg);
    }

    public void hide() {
        if (this.aab != null) {
            this.aab.hide();
        }
    }

    public void dismiss() {
        if (this.aab != null) {
            j.b(this.aab, this.mActivity);
        }
    }

    private View cc(int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.aar, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        TextView textView = (TextView) inflate.findViewById(w.h.dialog_item_btn);
        if (this.aav != null) {
            textView.setLayoutParams(this.aav);
        }
        if (this.aat != -1) {
            textView.setTextSize(0, this.aat);
        }
        if (this.aau != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.aau);
        }
        View findViewById = inflate.findViewById(w.h.line);
        CharSequence charSequence = this.Wk.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.Wk.size() - 1) {
            findViewById.setVisibility(8);
            aq.j(inflate, w.g.dialog_single_button_bg_selector);
        } else if (this.Wk.size() == 1) {
            findViewById.setVisibility(8);
            aq.j(inflate, w.g.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            aq.j(inflate, w.g.dialog_single_button_first_bg_selector);
        } else {
            aq.j(inflate, w.g.dialg_alert_btn_bg);
        }
        if (this.aao != null) {
            linearLayout.setOnClickListener(new d(this, i, textView));
        }
        this.mContentView.addView(inflate);
        return inflate;
    }

    public View cd(int i) {
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
