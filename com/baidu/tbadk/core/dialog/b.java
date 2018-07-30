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
    private static final HashMap<Integer, Integer[]> akY = new HashMap<>(2);
    private AlertDialog akE;
    private List<CharSequence> akQ;
    private InterfaceC0101b akR;
    private final View akS;
    private LinearLayout.LayoutParams akX;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.e<?> mContext;
    private final ViewGroup mRootView;
    private String mTitle;
    private final TextView mTitleView;
    private int akU = -1;
    private int aks = -1;
    private int akV = -1;
    private boolean akG = false;
    private int akW = -1;
    private int akT = d.h.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int alb = d.k.dialog_ani_b2t;
        public static final int alc = d.k.dialog_ani_t2b;
        public static final int LEFT_TO_RIGHT = d.k.dialog_ani_l2r;
        public static final int RIGHT_TO_LEFT = d.k.dialog_ani_r2l;
    }

    /* renamed from: com.baidu.tbadk.core.dialog.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0101b {
        void a(b bVar, int i, View view);
    }

    static {
        akY.put(0, new Integer[]{Integer.valueOf(d.f.dialg_alert_btn_bg), Integer.valueOf(d.f.dialog_bdalert_button_textcolor_pressed)});
        akY.put(1, new Integer[]{Integer.valueOf(d.f.btn_blue_square), Integer.valueOf(d.C0140d.cp_bg_line_d)});
    }

    public b(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.h.dialog_bdlist, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.dialog_title_list);
        this.mContentView = (ViewGroup) this.mRootView.findViewById(d.g.dialog_content);
        this.akS = this.mRootView.findViewById(d.g.line_bg);
    }

    public TextView getTitleView() {
        return this.mTitleView;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public b dC(String str) {
        this.mTitle = str;
        return this;
    }

    public b ci(int i) {
        return dC(this.mActivity.getResources().getString(i));
    }

    public b a(CharSequence[] charSequenceArr, InterfaceC0101b interfaceC0101b) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), interfaceC0101b);
        }
        return this;
    }

    public b a(List<CharSequence> list, InterfaceC0101b interfaceC0101b) {
        if (list != null && list.size() > 0) {
            this.akQ = list;
            if (interfaceC0101b != null) {
                this.akR = interfaceC0101b;
            }
        }
        return this;
    }

    public b cj(int i) {
        this.akU = i;
        return this;
    }

    public b ck(int i) {
        this.aks = i;
        return this;
    }

    public b d(com.baidu.adp.base.e<?> eVar) {
        if (!this.akG) {
            this.mContext = eVar;
            this.akG = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.akS.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.akS.setVisibility(8);
            }
            if (this.akQ != null && this.akQ.size() > 0) {
                int size = this.akQ.size();
                for (int i = 0; i < size; i++) {
                    cm(i);
                }
            }
            c(eVar);
        }
        return this;
    }

    public void reset() {
        this.akG = false;
        if (this.mContentView != null) {
            this.mContentView.removeAllViews();
        }
    }

    public b xi() {
        if (!this.akG) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.akE != null) {
            com.baidu.adp.lib.g.g.a(this.akE, this.mActivity);
        } else {
            this.akE = new AlertDialog.Builder(this.mActivity, d.k.NoBackDimEnableDialog).create();
            this.akE.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.akE, this.mActivity)) {
                Window window = this.akE.getWindow();
                if (this.akU == -1) {
                    this.akU = a.alb;
                }
                if (this.aks == -1) {
                    this.aks = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.aks);
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
        if (this.akE != null) {
            com.baidu.adp.lib.g.g.b(this.akE, this.mActivity);
        }
    }

    public void cl(int i) {
        this.akW = i;
    }

    private View cm(final int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.akT, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        final TextView textView = (TextView) inflate.findViewById(d.g.dialog_item_btn);
        if (this.akX != null) {
            textView.setLayoutParams(this.akX);
        }
        if (this.akV != -1) {
            textView.setTextSize(0, this.akV);
        }
        if (this.akW != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.akW);
        }
        View findViewById = inflate.findViewById(d.g.line);
        CharSequence charSequence = this.akQ.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.akQ.size() - 1) {
            findViewById.setVisibility(8);
            am.i(inflate, d.f.dialog_single_button_bg_selector);
        } else if (this.akQ.size() == 1) {
            findViewById.setVisibility(8);
            am.i(inflate, d.f.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            am.i(inflate, d.f.dialog_single_button_first_bg_selector);
        } else {
            am.i(inflate, d.f.dialg_alert_btn_bg);
        }
        if (this.akR != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.akR.a(b.this, i, textView);
                }
            });
        }
        this.mContentView.addView(inflate);
        return inflate;
    }

    public View cn(int i) {
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
