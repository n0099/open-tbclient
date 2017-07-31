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
    private static final HashMap<Integer, Integer[]> ace = new HashMap<>(2);
    private List<CharSequence> Xs;
    private AlertDialog abJ;
    private final ViewGroup abK;
    private InterfaceC0043b abW;
    private final TextView abX;
    private final View abY;
    private LinearLayout.LayoutParams acd;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.e<?> mContext;
    private String mTitle;
    private int aca = -1;
    private int aby = -1;
    private int acb = -1;
    private boolean abM = false;
    private int acc = -1;
    private int abZ = d.j.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int aci = d.m.dialog_ani_b2t;
        public static final int acj = d.m.dialog_ani_t2b;
        public static final int ack = d.m.dialog_ani_l2r;
        public static final int acl = d.m.dialog_ani_r2l;
    }

    /* renamed from: com.baidu.tbadk.core.dialog.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0043b {
        void a(b bVar, int i, View view);
    }

    static {
        ace.put(0, new Integer[]{Integer.valueOf(d.g.dialg_alert_btn_bg), Integer.valueOf(d.g.dialog_bdalert_button_textcolor_pressed)});
        ace.put(1, new Integer[]{Integer.valueOf(d.g.btn_blue_square), Integer.valueOf(d.e.cp_bg_line_d)});
    }

    public b(Activity activity) {
        this.mActivity = activity;
        this.abK = (ViewGroup) LayoutInflater.from(activity).inflate(d.j.dialog_bdlist, (ViewGroup) null);
        this.abX = (TextView) this.abK.findViewById(d.h.dialog_title_list);
        this.mContentView = (ViewGroup) this.abK.findViewById(d.h.dialog_content);
        this.abY = this.abK.findViewById(d.h.line_bg);
    }

    public View getRootView() {
        return this.abK;
    }

    public b cU(String str) {
        this.mTitle = str;
        return this;
    }

    public b cf(int i) {
        return cU(this.mActivity.getResources().getString(i));
    }

    public b a(CharSequence[] charSequenceArr, InterfaceC0043b interfaceC0043b) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), interfaceC0043b);
        }
        return this;
    }

    public b a(List<CharSequence> list, InterfaceC0043b interfaceC0043b) {
        if (list != null && list.size() > 0) {
            this.Xs = list;
            if (interfaceC0043b != null) {
                this.abW = interfaceC0043b;
            }
        }
        return this;
    }

    public b cg(int i) {
        this.aca = i;
        return this;
    }

    public b ch(int i) {
        this.aby = i;
        return this;
    }

    public b d(com.baidu.adp.base.e<?> eVar) {
        if (!this.abM) {
            this.mContext = eVar;
            this.abM = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.abX.setText(this.mTitle);
                this.abX.setVisibility(0);
                this.abY.setVisibility(0);
            } else {
                this.abX.setVisibility(8);
                this.abY.setVisibility(8);
            }
            if (this.Xs != null && this.Xs.size() > 0) {
                int size = this.Xs.size();
                for (int i = 0; i < size; i++) {
                    ci(i);
                }
            }
            c(eVar);
        }
        return this;
    }

    public void reset() {
        this.abM = false;
        if (this.mContentView != null) {
            this.mContentView.removeAllViews();
        }
    }

    public b tu() {
        if (!this.abM) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.abJ != null) {
            g.a(this.abJ, this.mActivity);
        } else {
            this.abJ = new AlertDialog.Builder(this.mActivity, d.m.NoBackDimEnableDialog).create();
            this.abJ.setCanceledOnTouchOutside(true);
            if (g.a(this.abJ, this.mActivity)) {
                Window window = this.abJ.getWindow();
                if (this.aca == -1) {
                    this.aca = a.aci;
                }
                if (this.aby == -1) {
                    this.aby = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.aby);
                window.setContentView(this.abK);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.e<?> eVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().ah(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().t(this.abK);
        }
        this.abK.setBackgroundResource(d.g.transparent_bg);
    }

    public void hide() {
        if (this.abJ != null) {
            this.abJ.hide();
        }
    }

    public void dismiss() {
        if (this.abJ != null) {
            g.b(this.abJ, this.mActivity);
        }
    }

    private View ci(final int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.abZ, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        final TextView textView = (TextView) inflate.findViewById(d.h.dialog_item_btn);
        if (this.acd != null) {
            textView.setLayoutParams(this.acd);
        }
        if (this.acb != -1) {
            textView.setTextSize(0, this.acb);
        }
        if (this.acc != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.acc);
        }
        View findViewById = inflate.findViewById(d.h.line);
        CharSequence charSequence = this.Xs.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.Xs.size() - 1) {
            findViewById.setVisibility(8);
            ai.j(inflate, d.g.dialog_single_button_bg_selector);
        } else if (this.Xs.size() == 1) {
            findViewById.setVisibility(8);
            ai.j(inflate, d.g.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            ai.j(inflate, d.g.dialog_single_button_first_bg_selector);
        } else {
            ai.j(inflate, d.g.dialg_alert_btn_bg);
        }
        if (this.abW != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.abW.a(b.this, i, textView);
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
