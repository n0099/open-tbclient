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
    private static final HashMap<Integer, Integer[]> anE = new HashMap<>(2);
    private LinearLayout.LayoutParams anD;
    private AlertDialog ank;
    private List<CharSequence> anw;
    private InterfaceC0100b anx;
    private final View any;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.e<?> mContext;
    private final ViewGroup mRootView;
    private String mTitle;
    private final TextView mTitleView;
    private int anA = -1;
    private int amY = -1;
    private int anB = -1;
    private boolean anm = false;
    private int anC = -1;
    private int anz = e.h.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int anH = e.k.dialog_ani_b2t;
        public static final int anI = e.k.dialog_ani_t2b;
        public static final int LEFT_TO_RIGHT = e.k.dialog_ani_l2r;
        public static final int RIGHT_TO_LEFT = e.k.dialog_ani_r2l;
    }

    /* renamed from: com.baidu.tbadk.core.dialog.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0100b {
        void a(b bVar, int i, View view);
    }

    static {
        anE.put(0, new Integer[]{Integer.valueOf(e.f.dialg_alert_btn_bg), Integer.valueOf(e.f.dialog_bdalert_button_textcolor_pressed)});
        anE.put(1, new Integer[]{Integer.valueOf(e.f.btn_blue_square), Integer.valueOf(e.d.cp_bg_line_d)});
    }

    public b(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(e.h.dialog_bdlist, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(e.g.dialog_title_list);
        this.mContentView = (ViewGroup) this.mRootView.findViewById(e.g.dialog_content);
        this.any = this.mRootView.findViewById(e.g.line_bg);
    }

    public TextView getTitleView() {
        return this.mTitleView;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public b dU(String str) {
        this.mTitle = str;
        return this;
    }

    public b cs(int i) {
        return dU(this.mActivity.getResources().getString(i));
    }

    public b a(CharSequence[] charSequenceArr, InterfaceC0100b interfaceC0100b) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), interfaceC0100b);
        }
        return this;
    }

    public b a(List<CharSequence> list, InterfaceC0100b interfaceC0100b) {
        if (list != null && list.size() > 0) {
            this.anw = list;
            if (interfaceC0100b != null) {
                this.anx = interfaceC0100b;
            }
        }
        return this;
    }

    public b ct(int i) {
        this.anA = i;
        return this;
    }

    public b cu(int i) {
        this.amY = i;
        return this;
    }

    public b d(com.baidu.adp.base.e<?> eVar) {
        if (!this.anm) {
            this.mContext = eVar;
            this.anm = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.any.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.any.setVisibility(8);
            }
            if (this.anw != null && this.anw.size() > 0) {
                int size = this.anw.size();
                for (int i = 0; i < size; i++) {
                    cw(i);
                }
            }
            c(eVar);
        }
        return this;
    }

    public void reset() {
        this.anm = false;
        if (this.mContentView != null) {
            this.mContentView.removeAllViews();
        }
    }

    public b yo() {
        if (!this.anm) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.ank != null) {
            com.baidu.adp.lib.g.g.a(this.ank, this.mActivity);
        } else {
            this.ank = new AlertDialog.Builder(this.mActivity, e.k.NoBackDimEnableDialog).create();
            this.ank.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.ank, this.mActivity)) {
                Window window = this.ank.getWindow();
                if (this.anA == -1) {
                    this.anA = a.anH;
                }
                if (this.amY == -1) {
                    this.amY = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.amY);
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
        if (this.ank != null) {
            com.baidu.adp.lib.g.g.b(this.ank, this.mActivity);
        }
    }

    public void cv(int i) {
        this.anC = i;
    }

    private View cw(final int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.anz, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        final TextView textView = (TextView) inflate.findViewById(e.g.dialog_item_btn);
        if (this.anD != null) {
            textView.setLayoutParams(this.anD);
        }
        if (this.anB != -1) {
            textView.setTextSize(0, this.anB);
        }
        if (this.anC != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.anC);
        }
        View findViewById = inflate.findViewById(e.g.line);
        CharSequence charSequence = this.anw.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.anw.size() - 1) {
            findViewById.setVisibility(8);
            al.i(inflate, e.f.dialog_single_button_bg_selector);
        } else if (this.anw.size() == 1) {
            findViewById.setVisibility(8);
            al.i(inflate, e.f.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            al.i(inflate, e.f.dialog_single_button_first_bg_selector);
        } else {
            al.i(inflate, e.f.dialg_alert_btn_bg);
        }
        if (this.anx != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.anx.a(b.this, i, textView);
                }
            });
        }
        this.mContentView.addView(inflate);
        return inflate;
    }

    public View cx(int i) {
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
