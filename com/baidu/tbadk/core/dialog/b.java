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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static final HashMap<Integer, Integer[]> axp = new HashMap<>(2);
    private AlertDialog awW;
    private InterfaceC0158b axi;
    private final View axj;
    private LinearLayout.LayoutParams axo;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.e<?> mContext;
    private List<CharSequence> mItems;
    private final ViewGroup mRootView;
    private String mTitle;
    private final TextView mTitleView;
    private int axl = -1;
    private int awK = -1;
    private int axm = -1;
    private boolean awY = false;
    private int axn = -1;
    private int axk = e.h.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int axs = e.k.dialog_ani_b2t;
        public static final int axt = e.k.dialog_ani_t2b;
        public static final int LEFT_TO_RIGHT = e.k.dialog_ani_l2r;
        public static final int RIGHT_TO_LEFT = e.k.dialog_ani_r2l;
    }

    /* renamed from: com.baidu.tbadk.core.dialog.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0158b {
        void a(b bVar, int i, View view);
    }

    static {
        axp.put(0, new Integer[]{Integer.valueOf(e.f.dialg_alert_btn_bg), Integer.valueOf(e.f.dialog_bdalert_button_textcolor_pressed)});
        axp.put(1, new Integer[]{Integer.valueOf(e.f.btn_blue_square), Integer.valueOf(e.d.cp_bg_line_d)});
    }

    public b(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(e.h.dialog_bdlist, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(e.g.dialog_title_list);
        this.mContentView = (ViewGroup) this.mRootView.findViewById(e.g.dialog_content);
        this.axj = this.mRootView.findViewById(e.g.line_bg);
    }

    public TextView getTitleView() {
        return this.mTitleView;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public b eL(String str) {
        this.mTitle = str;
        return this;
    }

    public b de(int i) {
        return eL(this.mActivity.getResources().getString(i));
    }

    public b a(CharSequence[] charSequenceArr, InterfaceC0158b interfaceC0158b) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), interfaceC0158b);
        }
        return this;
    }

    public b a(List<CharSequence> list, InterfaceC0158b interfaceC0158b) {
        if (list != null && list.size() > 0) {
            this.mItems = list;
            if (interfaceC0158b != null) {
                this.axi = interfaceC0158b;
            }
        }
        return this;
    }

    public b df(int i) {
        this.axl = i;
        return this;
    }

    public b dg(int i) {
        this.awK = i;
        return this;
    }

    public b d(com.baidu.adp.base.e<?> eVar) {
        if (!this.awY) {
            this.mContext = eVar;
            this.awY = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.axj.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.axj.setVisibility(8);
            }
            if (this.mItems != null && this.mItems.size() > 0) {
                int size = this.mItems.size();
                for (int i = 0; i < size; i++) {
                    di(i);
                }
            }
            c(eVar);
        }
        return this;
    }

    public void reset() {
        this.awY = false;
        if (this.mContentView != null) {
            this.mContentView.removeAllViews();
        }
    }

    public b BV() {
        if (!this.awY) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.awW != null) {
            com.baidu.adp.lib.g.g.a(this.awW, this.mActivity);
        } else {
            this.awW = new AlertDialog.Builder(this.mActivity, e.k.NoBackDimEnableDialog).create();
            this.awW.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.awW, this.mActivity)) {
                Window window = this.awW.getWindow();
                if (this.axl == -1) {
                    this.axl = a.axs;
                }
                if (this.awK == -1) {
                    this.awK = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.awK);
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
        this.mRootView.setBackgroundResource(e.f.transparent_bg);
    }

    public void dismiss() {
        if (this.awW != null) {
            com.baidu.adp.lib.g.g.b(this.awW, this.mActivity);
        }
    }

    public void dh(int i) {
        this.axn = i;
    }

    private View di(final int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.axk, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        final TextView textView = (TextView) inflate.findViewById(e.g.dialog_item_btn);
        if (this.axo != null) {
            textView.setLayoutParams(this.axo);
        }
        if (this.axm != -1) {
            textView.setTextSize(0, this.axm);
        }
        if (this.axn != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.axn);
        }
        View findViewById = inflate.findViewById(e.g.line);
        CharSequence charSequence = this.mItems.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.mItems.size() - 1) {
            findViewById.setVisibility(8);
            al.i(inflate, e.f.dialog_single_button_bg_selector);
        } else if (this.mItems.size() == 1) {
            findViewById.setVisibility(8);
            al.i(inflate, e.f.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            al.i(inflate, e.f.dialog_single_button_first_bg_selector);
        } else {
            al.i(inflate, e.f.dialg_alert_btn_bg);
        }
        if (this.axi != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.axi.a(b.this, i, textView);
                }
            });
        }
        this.mContentView.addView(inflate);
        return inflate;
    }

    public View dj(int i) {
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
