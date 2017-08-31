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
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static final HashMap<Integer, Integer[]> abl = new HashMap<>(2);
    private List<CharSequence> WE;
    private AlertDialog aaP;
    private final ViewGroup aaQ;
    private InterfaceC0047b abd;
    private final TextView abe;
    private final View abf;
    private LinearLayout.LayoutParams abk;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.e<?> mContext;
    private String mTitle;
    private int abh = -1;
    private int aaE = -1;
    private int abi = -1;
    private boolean aaS = false;
    private int abj = -1;
    private int abg = d.j.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int abp = d.m.dialog_ani_b2t;
        public static final int abq = d.m.dialog_ani_t2b;
        public static final int abr = d.m.dialog_ani_l2r;
        public static final int abt = d.m.dialog_ani_r2l;
    }

    /* renamed from: com.baidu.tbadk.core.dialog.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0047b {
        void a(b bVar, int i, View view);
    }

    static {
        abl.put(0, new Integer[]{Integer.valueOf(d.g.dialg_alert_btn_bg), Integer.valueOf(d.g.dialog_bdalert_button_textcolor_pressed)});
        abl.put(1, new Integer[]{Integer.valueOf(d.g.btn_blue_square), Integer.valueOf(d.e.cp_bg_line_d)});
    }

    public b(Activity activity) {
        this.mActivity = activity;
        this.aaQ = (ViewGroup) LayoutInflater.from(activity).inflate(d.j.dialog_bdlist, (ViewGroup) null);
        this.abe = (TextView) this.aaQ.findViewById(d.h.dialog_title_list);
        this.mContentView = (ViewGroup) this.aaQ.findViewById(d.h.dialog_content);
        this.abf = this.aaQ.findViewById(d.h.line_bg);
    }

    public View getRootView() {
        return this.aaQ;
    }

    public b cN(String str) {
        this.mTitle = str;
        return this;
    }

    public b cf(int i) {
        return cN(this.mActivity.getResources().getString(i));
    }

    public b a(CharSequence[] charSequenceArr, InterfaceC0047b interfaceC0047b) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), interfaceC0047b);
        }
        return this;
    }

    public b a(List<CharSequence> list, InterfaceC0047b interfaceC0047b) {
        if (list != null && list.size() > 0) {
            this.WE = list;
            if (interfaceC0047b != null) {
                this.abd = interfaceC0047b;
            }
        }
        return this;
    }

    public b cg(int i) {
        this.abh = i;
        return this;
    }

    public b ch(int i) {
        this.aaE = i;
        return this;
    }

    public b d(com.baidu.adp.base.e<?> eVar) {
        if (!this.aaS) {
            this.mContext = eVar;
            this.aaS = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.abe.setText(this.mTitle);
                this.abe.setVisibility(0);
                this.abf.setVisibility(0);
            } else {
                this.abe.setVisibility(8);
                this.abf.setVisibility(8);
            }
            if (this.WE != null && this.WE.size() > 0) {
                int size = this.WE.size();
                for (int i = 0; i < size; i++) {
                    ci(i);
                }
            }
            c(eVar);
        }
        return this;
    }

    public void reset() {
        this.aaS = false;
        if (this.mContentView != null) {
            this.mContentView.removeAllViews();
        }
    }

    public b tr() {
        if (!this.aaS) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aaP != null) {
            g.a(this.aaP, this.mActivity);
        } else {
            this.aaP = new AlertDialog.Builder(this.mActivity, d.m.NoBackDimEnableDialog).create();
            this.aaP.setCanceledOnTouchOutside(true);
            if (g.a(this.aaP, this.mActivity)) {
                Window window = this.aaP.getWindow();
                if (this.abh == -1) {
                    this.abh = a.abp;
                }
                if (this.aaE == -1) {
                    this.aaE = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.aaE);
                window.setContentView(this.aaQ);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.e<?> eVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().ah(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().t(this.aaQ);
        }
        this.aaQ.setBackgroundResource(d.g.transparent_bg);
    }

    public void hide() {
        if (this.aaP != null) {
            this.aaP.hide();
        }
    }

    public void dismiss() {
        if (this.aaP != null) {
            g.b(this.aaP, this.mActivity);
        }
    }

    private View ci(final int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.abg, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        final TextView textView = (TextView) inflate.findViewById(d.h.dialog_item_btn);
        if (this.abk != null) {
            textView.setLayoutParams(this.abk);
        }
        if (this.abi != -1) {
            textView.setTextSize(0, this.abi);
        }
        if (this.abj != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.abj);
        }
        View findViewById = inflate.findViewById(d.h.line);
        CharSequence charSequence = this.WE.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.WE.size() - 1) {
            findViewById.setVisibility(8);
            aj.j(inflate, d.g.dialog_single_button_bg_selector);
        } else if (this.WE.size() == 1) {
            findViewById.setVisibility(8);
            aj.j(inflate, d.g.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            aj.j(inflate, d.g.dialog_single_button_first_bg_selector);
        } else {
            aj.j(inflate, d.g.dialg_alert_btn_bg);
        }
        if (this.abd != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.abd.a(b.this, i, textView);
                }
            });
        }
        this.mContentView.addView(inflate);
        return inflate;
    }

    public View cj(int i) {
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
