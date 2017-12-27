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
    private static final HashMap<Integer, Integer[]> aQi = new HashMap<>(2);
    private AlertDialog aPO;
    private List<CharSequence> aQa;
    private InterfaceC0074b aQb;
    private final View aQc;
    private LinearLayout.LayoutParams aQh;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.e<?> mContext;
    private final ViewGroup mRootView;
    private String mTitle;
    private final TextView mTitleView;
    private int aQe = -1;
    private int aPD = -1;
    private int aQf = -1;
    private boolean aPQ = false;
    private int aQg = -1;
    private int aQd = d.h.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int aQl = d.k.dialog_ani_b2t;
        public static final int aQm = d.k.dialog_ani_t2b;
        public static final int LEFT_TO_RIGHT = d.k.dialog_ani_l2r;
        public static final int RIGHT_TO_LEFT = d.k.dialog_ani_r2l;
    }

    /* renamed from: com.baidu.tbadk.core.dialog.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0074b {
        void a(b bVar, int i, View view);
    }

    static {
        aQi.put(0, new Integer[]{Integer.valueOf(d.f.dialg_alert_btn_bg), Integer.valueOf(d.f.dialog_bdalert_button_textcolor_pressed)});
        aQi.put(1, new Integer[]{Integer.valueOf(d.f.btn_blue_square), Integer.valueOf(d.C0108d.cp_bg_line_d)});
    }

    public b(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.h.dialog_bdlist, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.dialog_title_list);
        this.mContentView = (ViewGroup) this.mRootView.findViewById(d.g.dialog_content);
        this.aQc = this.mRootView.findViewById(d.g.line_bg);
    }

    public TextView getTitleView() {
        return this.mTitleView;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public b da(String str) {
        this.mTitle = str;
        return this;
    }

    public b fg(int i) {
        return da(this.mActivity.getResources().getString(i));
    }

    public b a(CharSequence[] charSequenceArr, InterfaceC0074b interfaceC0074b) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), interfaceC0074b);
        }
        return this;
    }

    public b a(List<CharSequence> list, InterfaceC0074b interfaceC0074b) {
        if (list != null && list.size() > 0) {
            this.aQa = list;
            if (interfaceC0074b != null) {
                this.aQb = interfaceC0074b;
            }
        }
        return this;
    }

    public b fh(int i) {
        this.aQe = i;
        return this;
    }

    public b fi(int i) {
        this.aPD = i;
        return this;
    }

    public b d(com.baidu.adp.base.e<?> eVar) {
        if (!this.aPQ) {
            this.mContext = eVar;
            this.aPQ = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.aQc.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.aQc.setVisibility(8);
            }
            if (this.aQa != null && this.aQa.size() > 0) {
                int size = this.aQa.size();
                for (int i = 0; i < size; i++) {
                    fk(i);
                }
            }
            c(eVar);
        }
        return this;
    }

    public void reset() {
        this.aPQ = false;
        if (this.mContentView != null) {
            this.mContentView.removeAllViews();
        }
    }

    public b AL() {
        if (!this.aPQ) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aPO != null) {
            com.baidu.adp.lib.g.g.a(this.aPO, this.mActivity);
        } else {
            this.aPO = new AlertDialog.Builder(this.mActivity, d.k.NoBackDimEnableDialog).create();
            this.aPO.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.aPO, this.mActivity)) {
                Window window = this.aPO.getWindow();
                if (this.aQe == -1) {
                    this.aQe = a.aQl;
                }
                if (this.aPD == -1) {
                    this.aPD = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.aPD);
                window.setContentView(this.mRootView);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.e<?> eVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().aM(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().aM(this.mRootView);
        }
        this.mRootView.setBackgroundResource(d.f.transparent_bg);
    }

    public void hide() {
        if (this.aPO != null) {
            this.aPO.hide();
        }
    }

    public void dismiss() {
        if (this.aPO != null) {
            com.baidu.adp.lib.g.g.b(this.aPO, this.mActivity);
        }
    }

    public void fj(int i) {
        this.aQg = i;
    }

    private View fk(final int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.aQd, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        final TextView textView = (TextView) inflate.findViewById(d.g.dialog_item_btn);
        if (this.aQh != null) {
            textView.setLayoutParams(this.aQh);
        }
        if (this.aQf != -1) {
            textView.setTextSize(0, this.aQf);
        }
        if (this.aQg != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.aQg);
        }
        View findViewById = inflate.findViewById(d.g.line);
        CharSequence charSequence = this.aQa.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.aQa.size() - 1) {
            findViewById.setVisibility(8);
            aj.s(inflate, d.f.dialog_single_button_bg_selector);
        } else if (this.aQa.size() == 1) {
            findViewById.setVisibility(8);
            aj.s(inflate, d.f.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            aj.s(inflate, d.f.dialog_single_button_first_bg_selector);
        } else {
            aj.s(inflate, d.f.dialg_alert_btn_bg);
        }
        if (this.aQb != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.aQb.a(b.this, i, textView);
                }
            });
        }
        this.mContentView.addView(inflate);
        return inflate;
    }

    public View fl(int i) {
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
