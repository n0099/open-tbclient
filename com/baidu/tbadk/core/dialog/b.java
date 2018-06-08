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
import com.baidu.tieba.d;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static final HashMap<Integer, Integer[]> akZ = new HashMap<>(2);
    private AlertDialog akG;
    private InterfaceC0103b akS;
    private final View akT;
    private LinearLayout.LayoutParams akY;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.e<?> mContext;
    private List<CharSequence> mItems;
    private final ViewGroup mRootView;
    private String mTitle;
    private final TextView mTitleView;
    private int akV = -1;
    private int aku = -1;
    private int akW = -1;
    private boolean akI = false;
    private int akX = -1;
    private int akU = d.i.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int alc = d.l.dialog_ani_b2t;
        public static final int ald = d.l.dialog_ani_t2b;
        public static final int LEFT_TO_RIGHT = d.l.dialog_ani_l2r;
        public static final int RIGHT_TO_LEFT = d.l.dialog_ani_r2l;
    }

    /* renamed from: com.baidu.tbadk.core.dialog.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0103b {
        void a(b bVar, int i, View view);
    }

    static {
        akZ.put(0, new Integer[]{Integer.valueOf(d.f.dialg_alert_btn_bg), Integer.valueOf(d.f.dialog_bdalert_button_textcolor_pressed)});
        akZ.put(1, new Integer[]{Integer.valueOf(d.f.btn_blue_square), Integer.valueOf(d.C0141d.cp_bg_line_d)});
    }

    public b(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.i.dialog_bdlist, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.dialog_title_list);
        this.mContentView = (ViewGroup) this.mRootView.findViewById(d.g.dialog_content);
        this.akT = this.mRootView.findViewById(d.g.line_bg);
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

    public b cf(int i) {
        return dC(this.mActivity.getResources().getString(i));
    }

    public b a(CharSequence[] charSequenceArr, InterfaceC0103b interfaceC0103b) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), interfaceC0103b);
        }
        return this;
    }

    public b a(List<CharSequence> list, InterfaceC0103b interfaceC0103b) {
        if (list != null && list.size() > 0) {
            this.mItems = list;
            if (interfaceC0103b != null) {
                this.akS = interfaceC0103b;
            }
        }
        return this;
    }

    public b cg(int i) {
        this.akV = i;
        return this;
    }

    public b ch(int i) {
        this.aku = i;
        return this;
    }

    public b d(com.baidu.adp.base.e<?> eVar) {
        if (!this.akI) {
            this.mContext = eVar;
            this.akI = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.akT.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.akT.setVisibility(8);
            }
            if (this.mItems != null && this.mItems.size() > 0) {
                int size = this.mItems.size();
                for (int i = 0; i < size; i++) {
                    cj(i);
                }
            }
            c(eVar);
        }
        return this;
    }

    public void reset() {
        this.akI = false;
        if (this.mContentView != null) {
            this.mContentView.removeAllViews();
        }
    }

    public b xd() {
        if (!this.akI) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.akG != null) {
            com.baidu.adp.lib.g.g.a(this.akG, this.mActivity);
        } else {
            this.akG = new AlertDialog.Builder(this.mActivity, d.l.NoBackDimEnableDialog).create();
            this.akG.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.akG, this.mActivity)) {
                Window window = this.akG.getWindow();
                if (this.akV == -1) {
                    this.akV = a.alc;
                }
                if (this.aku == -1) {
                    this.aku = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.aku);
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
        if (this.akG != null) {
            com.baidu.adp.lib.g.g.b(this.akG, this.mActivity);
        }
    }

    public void ci(int i) {
        this.akX = i;
    }

    private View cj(final int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.akU, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        final TextView textView = (TextView) inflate.findViewById(d.g.dialog_item_btn);
        if (this.akY != null) {
            textView.setLayoutParams(this.akY);
        }
        if (this.akW != -1) {
            textView.setTextSize(0, this.akW);
        }
        if (this.akX != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.akX);
        }
        View findViewById = inflate.findViewById(d.g.line);
        CharSequence charSequence = this.mItems.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.mItems.size() - 1) {
            findViewById.setVisibility(8);
            al.i(inflate, d.f.dialog_single_button_bg_selector);
        } else if (this.mItems.size() == 1) {
            findViewById.setVisibility(8);
            al.i(inflate, d.f.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            al.i(inflate, d.f.dialog_single_button_first_bg_selector);
        } else {
            al.i(inflate, d.f.dialg_alert_btn_bg);
        }
        if (this.akS != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.akS.a(b.this, i, textView);
                }
            });
        }
        this.mContentView.addView(inflate);
        return inflate;
    }

    public View ck(int i) {
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
