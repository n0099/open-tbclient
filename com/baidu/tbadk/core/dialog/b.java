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
    private static final HashMap<Integer, Integer[]> aRH = new HashMap<>(2);
    private InterfaceC0096b aRA;
    private final View aRB;
    private LinearLayout.LayoutParams aRG;
    private AlertDialog aRn;
    private List<CharSequence> aRz;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.e<?> mContext;
    private final ViewGroup mRootView;
    private String mTitle;
    private final TextView mTitleView;
    private int aRD = -1;
    private int aRc = -1;
    private int aRE = -1;
    private boolean aRp = false;
    private int aRF = -1;
    private int aRC = d.h.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int aRK = d.k.dialog_ani_b2t;
        public static final int aRL = d.k.dialog_ani_t2b;
        public static final int LEFT_TO_RIGHT = d.k.dialog_ani_l2r;
        public static final int RIGHT_TO_LEFT = d.k.dialog_ani_r2l;
    }

    /* renamed from: com.baidu.tbadk.core.dialog.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0096b {
        void a(b bVar, int i, View view);
    }

    static {
        aRH.put(0, new Integer[]{Integer.valueOf(d.f.dialg_alert_btn_bg), Integer.valueOf(d.f.dialog_bdalert_button_textcolor_pressed)});
        aRH.put(1, new Integer[]{Integer.valueOf(d.f.btn_blue_square), Integer.valueOf(d.C0140d.cp_bg_line_d)});
    }

    public b(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.h.dialog_bdlist, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.dialog_title_list);
        this.mContentView = (ViewGroup) this.mRootView.findViewById(d.g.dialog_content);
        this.aRB = this.mRootView.findViewById(d.g.line_bg);
    }

    public TextView getTitleView() {
        return this.mTitleView;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public b dl(String str) {
        this.mTitle = str;
        return this;
    }

    public b fe(int i) {
        return dl(this.mActivity.getResources().getString(i));
    }

    public b a(CharSequence[] charSequenceArr, InterfaceC0096b interfaceC0096b) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), interfaceC0096b);
        }
        return this;
    }

    public b a(List<CharSequence> list, InterfaceC0096b interfaceC0096b) {
        if (list != null && list.size() > 0) {
            this.aRz = list;
            if (interfaceC0096b != null) {
                this.aRA = interfaceC0096b;
            }
        }
        return this;
    }

    public b ff(int i) {
        this.aRD = i;
        return this;
    }

    public b fg(int i) {
        this.aRc = i;
        return this;
    }

    public b d(com.baidu.adp.base.e<?> eVar) {
        if (!this.aRp) {
            this.mContext = eVar;
            this.aRp = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.aRB.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.aRB.setVisibility(8);
            }
            if (this.aRz != null && this.aRz.size() > 0) {
                int size = this.aRz.size();
                for (int i = 0; i < size; i++) {
                    fi(i);
                }
            }
            c(eVar);
        }
        return this;
    }

    public void reset() {
        this.aRp = false;
        if (this.mContentView != null) {
            this.mContentView.removeAllViews();
        }
    }

    public b AX() {
        if (!this.aRp) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aRn != null) {
            com.baidu.adp.lib.g.g.a(this.aRn, this.mActivity);
        } else {
            this.aRn = new AlertDialog.Builder(this.mActivity, d.k.NoBackDimEnableDialog).create();
            this.aRn.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.aRn, this.mActivity)) {
                Window window = this.aRn.getWindow();
                if (this.aRD == -1) {
                    this.aRD = a.aRK;
                }
                if (this.aRc == -1) {
                    this.aRc = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.aRc);
                window.setContentView(this.mRootView);
            }
        }
        return this;
    }

    public void c(com.baidu.adp.base.e<?> eVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().aQ(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().aM(this.mRootView);
        }
        this.mRootView.setBackgroundResource(d.f.transparent_bg);
    }

    public void dismiss() {
        if (this.aRn != null) {
            com.baidu.adp.lib.g.g.b(this.aRn, this.mActivity);
        }
    }

    public void fh(int i) {
        this.aRF = i;
    }

    private View fi(final int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.aRC, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        final TextView textView = (TextView) inflate.findViewById(d.g.dialog_item_btn);
        if (this.aRG != null) {
            textView.setLayoutParams(this.aRG);
        }
        if (this.aRE != -1) {
            textView.setTextSize(0, this.aRE);
        }
        if (this.aRF != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.aRF);
        }
        View findViewById = inflate.findViewById(d.g.line);
        CharSequence charSequence = this.aRz.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.aRz.size() - 1) {
            findViewById.setVisibility(8);
            aj.s(inflate, d.f.dialog_single_button_bg_selector);
        } else if (this.aRz.size() == 1) {
            findViewById.setVisibility(8);
            aj.s(inflate, d.f.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            aj.s(inflate, d.f.dialog_single_button_first_bg_selector);
        } else {
            aj.s(inflate, d.f.dialg_alert_btn_bg);
        }
        if (this.aRA != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.aRA.a(b.this, i, textView);
                }
            });
        }
        this.mContentView.addView(inflate);
        return inflate;
    }

    public View fj(int i) {
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
