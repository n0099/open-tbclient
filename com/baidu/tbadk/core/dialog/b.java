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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static final HashMap<Integer, Integer[]> alz = new HashMap<>(2);
    private AlertDialog alf;
    private InterfaceC0104b als;
    private final View alt;
    private LinearLayout.LayoutParams aly;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.e<?> mContext;
    private List<CharSequence> mItems;
    private final ViewGroup mRootView;
    private String mTitle;
    private final TextView mTitleView;
    private int alv = -1;
    private int akT = -1;
    private int alw = -1;
    private boolean alh = false;
    private int alx = -1;
    private int alu = d.i.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int alC = d.l.dialog_ani_b2t;
        public static final int alD = d.l.dialog_ani_t2b;
        public static final int LEFT_TO_RIGHT = d.l.dialog_ani_l2r;
        public static final int RIGHT_TO_LEFT = d.l.dialog_ani_r2l;
    }

    /* renamed from: com.baidu.tbadk.core.dialog.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0104b {
        void a(b bVar, int i, View view);
    }

    static {
        alz.put(0, new Integer[]{Integer.valueOf(d.f.dialg_alert_btn_bg), Integer.valueOf(d.f.dialog_bdalert_button_textcolor_pressed)});
        alz.put(1, new Integer[]{Integer.valueOf(d.f.btn_blue_square), Integer.valueOf(d.C0142d.cp_bg_line_d)});
    }

    public b(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.i.dialog_bdlist, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.dialog_title_list);
        this.mContentView = (ViewGroup) this.mRootView.findViewById(d.g.dialog_content);
        this.alt = this.mRootView.findViewById(d.g.line_bg);
    }

    public TextView getTitleView() {
        return this.mTitleView;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public b dF(String str) {
        this.mTitle = str;
        return this;
    }

    public b cg(int i) {
        return dF(this.mActivity.getResources().getString(i));
    }

    public b a(CharSequence[] charSequenceArr, InterfaceC0104b interfaceC0104b) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), interfaceC0104b);
        }
        return this;
    }

    public b a(List<CharSequence> list, InterfaceC0104b interfaceC0104b) {
        if (list != null && list.size() > 0) {
            this.mItems = list;
            if (interfaceC0104b != null) {
                this.als = interfaceC0104b;
            }
        }
        return this;
    }

    public b ch(int i) {
        this.alv = i;
        return this;
    }

    public b ci(int i) {
        this.akT = i;
        return this;
    }

    public b d(com.baidu.adp.base.e<?> eVar) {
        if (!this.alh) {
            this.mContext = eVar;
            this.alh = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.alt.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.alt.setVisibility(8);
            }
            if (this.mItems != null && this.mItems.size() > 0) {
                int size = this.mItems.size();
                for (int i = 0; i < size; i++) {
                    ck(i);
                }
            }
            c(eVar);
        }
        return this;
    }

    public void reset() {
        this.alh = false;
        if (this.mContentView != null) {
            this.mContentView.removeAllViews();
        }
    }

    public b xq() {
        if (!this.alh) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.alf != null) {
            com.baidu.adp.lib.g.g.a(this.alf, this.mActivity);
        } else {
            this.alf = new AlertDialog.Builder(this.mActivity, d.l.NoBackDimEnableDialog).create();
            this.alf.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.alf, this.mActivity)) {
                Window window = this.alf.getWindow();
                if (this.alv == -1) {
                    this.alv = a.alC;
                }
                if (this.akT == -1) {
                    this.akT = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.akT);
                window.setContentView(this.mRootView);
            }
        }
        return this;
    }

    public void c(com.baidu.adp.base.e<?> eVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().setNightMode(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().onModeChanged(this.mRootView);
        }
        this.mRootView.setBackgroundResource(d.f.transparent_bg);
    }

    public void dismiss() {
        if (this.alf != null) {
            com.baidu.adp.lib.g.g.b(this.alf, this.mActivity);
        }
    }

    public void cj(int i) {
        this.alx = i;
    }

    private View ck(final int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.alu, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        final TextView textView = (TextView) inflate.findViewById(d.g.dialog_item_btn);
        if (this.aly != null) {
            textView.setLayoutParams(this.aly);
        }
        if (this.alw != -1) {
            textView.setTextSize(0, this.alw);
        }
        if (this.alx != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.alx);
        }
        View findViewById = inflate.findViewById(d.g.line);
        CharSequence charSequence = this.mItems.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.mItems.size() - 1) {
            findViewById.setVisibility(8);
            am.i(inflate, d.f.dialog_single_button_bg_selector);
        } else if (this.mItems.size() == 1) {
            findViewById.setVisibility(8);
            am.i(inflate, d.f.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            am.i(inflate, d.f.dialog_single_button_first_bg_selector);
        } else {
            am.i(inflate, d.f.dialg_alert_btn_bg);
        }
        if (this.als != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.als.a(b.this, i, textView);
                }
            });
        }
        this.mContentView.addView(inflate);
        return inflate;
    }

    public View cl(int i) {
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
