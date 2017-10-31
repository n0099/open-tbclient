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
    private static final HashMap<Integer, Integer[]> abw = new HashMap<>(2);
    private AlertDialog aba;
    private List<CharSequence> abn;
    private InterfaceC0047b abo;
    private final View abp;
    private LinearLayout.LayoutParams abv;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.e<?> mContext;
    private final ViewGroup mRootView;
    private String mTitle;
    private final TextView mTitleView;
    private int abr = -1;
    private int aaP = -1;
    private int abt = -1;
    private boolean abd = false;
    private int abu = -1;
    private int abq = d.h.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int abA = d.k.dialog_ani_b2t;
        public static final int abB = d.k.dialog_ani_t2b;
        public static final int abC = d.k.dialog_ani_l2r;
        public static final int abD = d.k.dialog_ani_r2l;
    }

    /* renamed from: com.baidu.tbadk.core.dialog.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0047b {
        void a(b bVar, int i, View view);
    }

    static {
        abw.put(0, new Integer[]{Integer.valueOf(d.f.dialg_alert_btn_bg), Integer.valueOf(d.f.dialog_bdalert_button_textcolor_pressed)});
        abw.put(1, new Integer[]{Integer.valueOf(d.f.btn_blue_square), Integer.valueOf(d.C0080d.cp_bg_line_d)});
    }

    public b(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.h.dialog_bdlist, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.dialog_title_list);
        this.mContentView = (ViewGroup) this.mRootView.findViewById(d.g.dialog_content);
        this.abp = this.mRootView.findViewById(d.g.line_bg);
    }

    public TextView tk() {
        return this.mTitleView;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public b cT(String str) {
        this.mTitle = str;
        return this;
    }

    public b cf(int i) {
        return cT(this.mActivity.getResources().getString(i));
    }

    public b a(CharSequence[] charSequenceArr, InterfaceC0047b interfaceC0047b) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), interfaceC0047b);
        }
        return this;
    }

    public b a(List<CharSequence> list, InterfaceC0047b interfaceC0047b) {
        if (list != null && list.size() > 0) {
            this.abn = list;
            if (interfaceC0047b != null) {
                this.abo = interfaceC0047b;
            }
        }
        return this;
    }

    public b cg(int i) {
        this.abr = i;
        return this;
    }

    public b ch(int i) {
        this.aaP = i;
        return this;
    }

    public b d(com.baidu.adp.base.e<?> eVar) {
        if (!this.abd) {
            this.mContext = eVar;
            this.abd = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.abp.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.abp.setVisibility(8);
            }
            if (this.abn != null && this.abn.size() > 0) {
                int size = this.abn.size();
                for (int i = 0; i < size; i++) {
                    cj(i);
                }
            }
            c(eVar);
        }
        return this;
    }

    public void reset() {
        this.abd = false;
        if (this.mContentView != null) {
            this.mContentView.removeAllViews();
        }
    }

    public b tl() {
        if (!this.abd) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aba != null) {
            com.baidu.adp.lib.g.g.a(this.aba, this.mActivity);
        } else {
            this.aba = new AlertDialog.Builder(this.mActivity, d.k.NoBackDimEnableDialog).create();
            this.aba.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.aba, this.mActivity)) {
                Window window = this.aba.getWindow();
                if (this.abr == -1) {
                    this.abr = a.abA;
                }
                if (this.aaP == -1) {
                    this.aaP = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.aaP);
                window.setContentView(this.mRootView);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.e<?> eVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().ag(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().t(this.mRootView);
        }
        this.mRootView.setBackgroundResource(d.f.transparent_bg);
    }

    public void hide() {
        if (this.aba != null) {
            this.aba.hide();
        }
    }

    public void dismiss() {
        if (this.aba != null) {
            com.baidu.adp.lib.g.g.b(this.aba, this.mActivity);
        }
    }

    public void ci(int i) {
        this.abu = i;
    }

    private View cj(final int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.abq, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        final TextView textView = (TextView) inflate.findViewById(d.g.dialog_item_btn);
        if (this.abv != null) {
            textView.setLayoutParams(this.abv);
        }
        if (this.abt != -1) {
            textView.setTextSize(0, this.abt);
        }
        if (this.abu != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.abu);
        }
        View findViewById = inflate.findViewById(d.g.line);
        CharSequence charSequence = this.abn.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.abn.size() - 1) {
            findViewById.setVisibility(8);
            aj.j(inflate, d.f.dialog_single_button_bg_selector);
        } else if (this.abn.size() == 1) {
            findViewById.setVisibility(8);
            aj.j(inflate, d.f.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            aj.j(inflate, d.f.dialog_single_button_first_bg_selector);
        } else {
            aj.j(inflate, d.f.dialg_alert_btn_bg);
        }
        if (this.abo != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.abo.a(b.this, i, textView);
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
