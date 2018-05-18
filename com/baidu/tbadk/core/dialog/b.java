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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static final HashMap<Integer, Integer[]> acV = new HashMap<>(2);
    private AlertDialog acC;
    private InterfaceC0086b acO;
    private final View acP;
    private LinearLayout.LayoutParams acU;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.e<?> mContext;
    private List<CharSequence> mItems;
    private final ViewGroup mRootView;
    private String mTitle;
    private final TextView mTitleView;
    private int acR = -1;
    private int acq = -1;
    private int acS = -1;
    private boolean acE = false;
    private int acT = -1;
    private int acQ = d.i.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int acY = d.l.dialog_ani_b2t;
        public static final int acZ = d.l.dialog_ani_t2b;
        public static final int LEFT_TO_RIGHT = d.l.dialog_ani_l2r;
        public static final int RIGHT_TO_LEFT = d.l.dialog_ani_r2l;
    }

    /* renamed from: com.baidu.tbadk.core.dialog.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0086b {
        void a(b bVar, int i, View view2);
    }

    static {
        acV.put(0, new Integer[]{Integer.valueOf(d.f.dialg_alert_btn_bg), Integer.valueOf(d.f.dialog_bdalert_button_textcolor_pressed)});
        acV.put(1, new Integer[]{Integer.valueOf(d.f.btn_blue_square), Integer.valueOf(d.C0126d.cp_bg_line_d)});
    }

    public b(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.i.dialog_bdlist, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.dialog_title_list);
        this.mContentView = (ViewGroup) this.mRootView.findViewById(d.g.dialog_content);
        this.acP = this.mRootView.findViewById(d.g.line_bg);
    }

    public TextView getTitleView() {
        return this.mTitleView;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public b dd(String str) {
        this.mTitle = str;
        return this;
    }

    public b cd(int i) {
        return dd(this.mActivity.getResources().getString(i));
    }

    public b a(CharSequence[] charSequenceArr, InterfaceC0086b interfaceC0086b) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), interfaceC0086b);
        }
        return this;
    }

    public b a(List<CharSequence> list, InterfaceC0086b interfaceC0086b) {
        if (list != null && list.size() > 0) {
            this.mItems = list;
            if (interfaceC0086b != null) {
                this.acO = interfaceC0086b;
            }
        }
        return this;
    }

    public b ce(int i) {
        this.acR = i;
        return this;
    }

    public b cf(int i) {
        this.acq = i;
        return this;
    }

    public b d(com.baidu.adp.base.e<?> eVar) {
        if (!this.acE) {
            this.mContext = eVar;
            this.acE = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.acP.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.acP.setVisibility(8);
            }
            if (this.mItems != null && this.mItems.size() > 0) {
                int size = this.mItems.size();
                for (int i = 0; i < size; i++) {
                    ch(i);
                }
            }
            c(eVar);
        }
        return this;
    }

    public void reset() {
        this.acE = false;
        if (this.mContentView != null) {
            this.mContentView.removeAllViews();
        }
    }

    public b tF() {
        if (!this.acE) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.acC != null) {
            com.baidu.adp.lib.g.g.a(this.acC, this.mActivity);
        } else {
            this.acC = new AlertDialog.Builder(this.mActivity, d.l.NoBackDimEnableDialog).create();
            this.acC.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.acC, this.mActivity)) {
                Window window = this.acC.getWindow();
                if (this.acR == -1) {
                    this.acR = a.acY;
                }
                if (this.acq == -1) {
                    this.acq = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.acq);
                window.setContentView(this.mRootView);
            }
        }
        return this;
    }

    public void c(com.baidu.adp.base.e<?> eVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().setNightMode(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().u(this.mRootView);
        }
        this.mRootView.setBackgroundResource(d.f.transparent_bg);
    }

    public void dismiss() {
        if (this.acC != null) {
            com.baidu.adp.lib.g.g.b(this.acC, this.mActivity);
        }
    }

    public void cg(int i) {
        this.acT = i;
    }

    private View ch(final int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.acQ, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        final TextView textView = (TextView) inflate.findViewById(d.g.dialog_item_btn);
        if (this.acU != null) {
            textView.setLayoutParams(this.acU);
        }
        if (this.acS != -1) {
            textView.setTextSize(0, this.acS);
        }
        if (this.acT != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.acT);
        }
        View findViewById = inflate.findViewById(d.g.line);
        CharSequence charSequence = this.mItems.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.mItems.size() - 1) {
            findViewById.setVisibility(8);
            ak.i(inflate, d.f.dialog_single_button_bg_selector);
        } else if (this.mItems.size() == 1) {
            findViewById.setVisibility(8);
            ak.i(inflate, d.f.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            ak.i(inflate, d.f.dialog_single_button_first_bg_selector);
        } else {
            ak.i(inflate, d.f.dialg_alert_btn_bg);
        }
        if (this.acO != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.acO.a(b.this, i, textView);
                }
            });
        }
        this.mContentView.addView(inflate);
        return inflate;
    }

    public View ci(int i) {
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
