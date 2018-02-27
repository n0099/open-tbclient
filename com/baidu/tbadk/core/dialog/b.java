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
    private static final HashMap<Integer, Integer[]> aRw = new HashMap<>(2);
    private AlertDialog aRc;
    private List<CharSequence> aRo;
    private InterfaceC0097b aRp;
    private final View aRq;
    private LinearLayout.LayoutParams aRv;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.e<?> mContext;
    private final ViewGroup mRootView;
    private String mTitle;
    private final TextView mTitleView;
    private int aRs = -1;
    private int aQR = -1;
    private int aRt = -1;
    private boolean aRe = false;
    private int aRu = -1;
    private int aRr = d.h.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int aRz = d.k.dialog_ani_b2t;
        public static final int aRA = d.k.dialog_ani_t2b;
        public static final int LEFT_TO_RIGHT = d.k.dialog_ani_l2r;
        public static final int RIGHT_TO_LEFT = d.k.dialog_ani_r2l;
    }

    /* renamed from: com.baidu.tbadk.core.dialog.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0097b {
        void a(b bVar, int i, View view);
    }

    static {
        aRw.put(0, new Integer[]{Integer.valueOf(d.f.dialg_alert_btn_bg), Integer.valueOf(d.f.dialog_bdalert_button_textcolor_pressed)});
        aRw.put(1, new Integer[]{Integer.valueOf(d.f.btn_blue_square), Integer.valueOf(d.C0141d.cp_bg_line_d)});
    }

    public b(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.h.dialog_bdlist, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.dialog_title_list);
        this.mContentView = (ViewGroup) this.mRootView.findViewById(d.g.dialog_content);
        this.aRq = this.mRootView.findViewById(d.g.line_bg);
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

    public b a(CharSequence[] charSequenceArr, InterfaceC0097b interfaceC0097b) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), interfaceC0097b);
        }
        return this;
    }

    public b a(List<CharSequence> list, InterfaceC0097b interfaceC0097b) {
        if (list != null && list.size() > 0) {
            this.aRo = list;
            if (interfaceC0097b != null) {
                this.aRp = interfaceC0097b;
            }
        }
        return this;
    }

    public b ff(int i) {
        this.aRs = i;
        return this;
    }

    public b fg(int i) {
        this.aQR = i;
        return this;
    }

    public b d(com.baidu.adp.base.e<?> eVar) {
        if (!this.aRe) {
            this.mContext = eVar;
            this.aRe = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.aRq.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.aRq.setVisibility(8);
            }
            if (this.aRo != null && this.aRo.size() > 0) {
                int size = this.aRo.size();
                for (int i = 0; i < size; i++) {
                    fi(i);
                }
            }
            c(eVar);
        }
        return this;
    }

    public void reset() {
        this.aRe = false;
        if (this.mContentView != null) {
            this.mContentView.removeAllViews();
        }
    }

    public b AX() {
        if (!this.aRe) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aRc != null) {
            com.baidu.adp.lib.g.g.a(this.aRc, this.mActivity);
        } else {
            this.aRc = new AlertDialog.Builder(this.mActivity, d.k.NoBackDimEnableDialog).create();
            this.aRc.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.aRc, this.mActivity)) {
                Window window = this.aRc.getWindow();
                if (this.aRs == -1) {
                    this.aRs = a.aRz;
                }
                if (this.aQR == -1) {
                    this.aQR = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.aQR);
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
        if (this.aRc != null) {
            com.baidu.adp.lib.g.g.b(this.aRc, this.mActivity);
        }
    }

    public void fh(int i) {
        this.aRu = i;
    }

    private View fi(final int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.aRr, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        final TextView textView = (TextView) inflate.findViewById(d.g.dialog_item_btn);
        if (this.aRv != null) {
            textView.setLayoutParams(this.aRv);
        }
        if (this.aRt != -1) {
            textView.setTextSize(0, this.aRt);
        }
        if (this.aRu != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.aRu);
        }
        View findViewById = inflate.findViewById(d.g.line);
        CharSequence charSequence = this.aRo.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.aRo.size() - 1) {
            findViewById.setVisibility(8);
            aj.s(inflate, d.f.dialog_single_button_bg_selector);
        } else if (this.aRo.size() == 1) {
            findViewById.setVisibility(8);
            aj.s(inflate, d.f.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            aj.s(inflate, d.f.dialog_single_button_first_bg_selector);
        } else {
            aj.s(inflate, d.f.dialg_alert_btn_bg);
        }
        if (this.aRp != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.aRp.a(b.this, i, textView);
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
