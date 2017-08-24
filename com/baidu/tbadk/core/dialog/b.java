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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static final HashMap<Integer, Integer[]> acg = new HashMap<>(2);
    private List<CharSequence> Xv;
    private AlertDialog abL;
    private final ViewGroup abM;
    private InterfaceC0043b abY;
    private final TextView abZ;
    private final View aca;
    private LinearLayout.LayoutParams acf;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.e<?> mContext;
    private String mTitle;
    private int acc = -1;
    private int abA = -1;
    private int acd = -1;
    private boolean abO = false;
    private int ace = -1;
    private int acb = d.j.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int ack = d.m.dialog_ani_b2t;
        public static final int acl = d.m.dialog_ani_t2b;
        public static final int acm = d.m.dialog_ani_l2r;
        public static final int acn = d.m.dialog_ani_r2l;
    }

    /* renamed from: com.baidu.tbadk.core.dialog.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0043b {
        void a(b bVar, int i, View view);
    }

    static {
        acg.put(0, new Integer[]{Integer.valueOf(d.g.dialg_alert_btn_bg), Integer.valueOf(d.g.dialog_bdalert_button_textcolor_pressed)});
        acg.put(1, new Integer[]{Integer.valueOf(d.g.btn_blue_square), Integer.valueOf(d.e.cp_bg_line_d)});
    }

    public b(Activity activity) {
        this.mActivity = activity;
        this.abM = (ViewGroup) LayoutInflater.from(activity).inflate(d.j.dialog_bdlist, (ViewGroup) null);
        this.abZ = (TextView) this.abM.findViewById(d.h.dialog_title_list);
        this.mContentView = (ViewGroup) this.abM.findViewById(d.h.dialog_content);
        this.aca = this.abM.findViewById(d.h.line_bg);
    }

    public View getRootView() {
        return this.abM;
    }

    public b cX(String str) {
        this.mTitle = str;
        return this;
    }

    public b cf(int i) {
        return cX(this.mActivity.getResources().getString(i));
    }

    public b a(CharSequence[] charSequenceArr, InterfaceC0043b interfaceC0043b) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), interfaceC0043b);
        }
        return this;
    }

    public b a(List<CharSequence> list, InterfaceC0043b interfaceC0043b) {
        if (list != null && list.size() > 0) {
            this.Xv = list;
            if (interfaceC0043b != null) {
                this.abY = interfaceC0043b;
            }
        }
        return this;
    }

    public b cg(int i) {
        this.acc = i;
        return this;
    }

    public b ch(int i) {
        this.abA = i;
        return this;
    }

    public b d(com.baidu.adp.base.e<?> eVar) {
        if (!this.abO) {
            this.mContext = eVar;
            this.abO = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.abZ.setText(this.mTitle);
                this.abZ.setVisibility(0);
                this.aca.setVisibility(0);
            } else {
                this.abZ.setVisibility(8);
                this.aca.setVisibility(8);
            }
            if (this.Xv != null && this.Xv.size() > 0) {
                int size = this.Xv.size();
                for (int i = 0; i < size; i++) {
                    ci(i);
                }
            }
            c(eVar);
        }
        return this;
    }

    public void reset() {
        this.abO = false;
        if (this.mContentView != null) {
            this.mContentView.removeAllViews();
        }
    }

    public b tv() {
        if (!this.abO) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.abL != null) {
            g.a(this.abL, this.mActivity);
        } else {
            this.abL = new AlertDialog.Builder(this.mActivity, d.m.NoBackDimEnableDialog).create();
            this.abL.setCanceledOnTouchOutside(true);
            if (g.a(this.abL, this.mActivity)) {
                Window window = this.abL.getWindow();
                if (this.acc == -1) {
                    this.acc = a.ack;
                }
                if (this.abA == -1) {
                    this.abA = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.abA);
                window.setContentView(this.abM);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.e<?> eVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().ah(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().t(this.abM);
        }
        this.abM.setBackgroundResource(d.g.transparent_bg);
    }

    public void hide() {
        if (this.abL != null) {
            this.abL.hide();
        }
    }

    public void dismiss() {
        if (this.abL != null) {
            g.b(this.abL, this.mActivity);
        }
    }

    private View ci(final int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.acb, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        final TextView textView = (TextView) inflate.findViewById(d.h.dialog_item_btn);
        if (this.acf != null) {
            textView.setLayoutParams(this.acf);
        }
        if (this.acd != -1) {
            textView.setTextSize(0, this.acd);
        }
        if (this.ace != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.ace);
        }
        View findViewById = inflate.findViewById(d.h.line);
        CharSequence charSequence = this.Xv.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.Xv.size() - 1) {
            findViewById.setVisibility(8);
            ai.j(inflate, d.g.dialog_single_button_bg_selector);
        } else if (this.Xv.size() == 1) {
            findViewById.setVisibility(8);
            ai.j(inflate, d.g.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            ai.j(inflate, d.g.dialog_single_button_first_bg_selector);
        } else {
            ai.j(inflate, d.g.dialg_alert_btn_bg);
        }
        if (this.abY != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.abY.a(b.this, i, textView);
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
