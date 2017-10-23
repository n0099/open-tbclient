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
import com.baidu.adp.lib.g.g;
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
    private static final HashMap<Integer, Integer[]> aaZ = new HashMap<>(2);
    private AlertDialog aaD;
    private final ViewGroup aaE;
    private List<CharSequence> aaQ;
    private InterfaceC0047b aaR;
    private final TextView aaS;
    private final View aaT;
    private LinearLayout.LayoutParams aaY;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.e<?> mContext;
    private String mTitle;
    private int aaV = -1;
    private int aas = -1;
    private int aaW = -1;
    private boolean aaG = false;
    private int aaX = -1;
    private int aaU = d.j.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int abe = d.m.dialog_ani_b2t;
        public static final int abf = d.m.dialog_ani_t2b;
        public static final int abg = d.m.dialog_ani_l2r;
        public static final int abh = d.m.dialog_ani_r2l;
    }

    /* renamed from: com.baidu.tbadk.core.dialog.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0047b {
        void a(b bVar, int i, View view);
    }

    static {
        aaZ.put(0, new Integer[]{Integer.valueOf(d.g.dialg_alert_btn_bg), Integer.valueOf(d.g.dialog_bdalert_button_textcolor_pressed)});
        aaZ.put(1, new Integer[]{Integer.valueOf(d.g.btn_blue_square), Integer.valueOf(d.e.cp_bg_line_d)});
    }

    public b(Activity activity) {
        this.mActivity = activity;
        this.aaE = (ViewGroup) LayoutInflater.from(activity).inflate(d.j.dialog_bdlist, (ViewGroup) null);
        this.aaS = (TextView) this.aaE.findViewById(d.h.dialog_title_list);
        this.mContentView = (ViewGroup) this.aaE.findViewById(d.h.dialog_content);
        this.aaT = this.aaE.findViewById(d.h.line_bg);
    }

    public View getRootView() {
        return this.aaE;
    }

    public b cM(String str) {
        this.mTitle = str;
        return this;
    }

    public b cf(int i) {
        return cM(this.mActivity.getResources().getString(i));
    }

    public b a(CharSequence[] charSequenceArr, InterfaceC0047b interfaceC0047b) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), interfaceC0047b);
        }
        return this;
    }

    public b a(List<CharSequence> list, InterfaceC0047b interfaceC0047b) {
        if (list != null && list.size() > 0) {
            this.aaQ = list;
            if (interfaceC0047b != null) {
                this.aaR = interfaceC0047b;
            }
        }
        return this;
    }

    public b cg(int i) {
        this.aaV = i;
        return this;
    }

    public b ch(int i) {
        this.aas = i;
        return this;
    }

    public b d(com.baidu.adp.base.e<?> eVar) {
        if (!this.aaG) {
            this.mContext = eVar;
            this.aaG = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.aaS.setText(this.mTitle);
                this.aaS.setVisibility(0);
                this.aaT.setVisibility(0);
            } else {
                this.aaS.setVisibility(8);
                this.aaT.setVisibility(8);
            }
            if (this.aaQ != null && this.aaQ.size() > 0) {
                int size = this.aaQ.size();
                for (int i = 0; i < size; i++) {
                    ci(i);
                }
            }
            c(eVar);
        }
        return this;
    }

    public void reset() {
        this.aaG = false;
        if (this.mContentView != null) {
            this.mContentView.removeAllViews();
        }
    }

    public b te() {
        if (!this.aaG) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aaD != null) {
            g.a(this.aaD, this.mActivity);
        } else {
            this.aaD = new AlertDialog.Builder(this.mActivity, d.m.NoBackDimEnableDialog).create();
            this.aaD.setCanceledOnTouchOutside(true);
            if (g.a(this.aaD, this.mActivity)) {
                Window window = this.aaD.getWindow();
                if (this.aaV == -1) {
                    this.aaV = a.abe;
                }
                if (this.aas == -1) {
                    this.aas = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.aas);
                window.setContentView(this.aaE);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.e<?> eVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().ah(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().t(this.aaE);
        }
        this.aaE.setBackgroundResource(d.g.transparent_bg);
    }

    public void hide() {
        if (this.aaD != null) {
            this.aaD.hide();
        }
    }

    public void dismiss() {
        if (this.aaD != null) {
            g.b(this.aaD, this.mActivity);
        }
    }

    private View ci(final int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.aaU, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        final TextView textView = (TextView) inflate.findViewById(d.h.dialog_item_btn);
        if (this.aaY != null) {
            textView.setLayoutParams(this.aaY);
        }
        if (this.aaW != -1) {
            textView.setTextSize(0, this.aaW);
        }
        if (this.aaX != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.aaX);
        }
        View findViewById = inflate.findViewById(d.h.line);
        CharSequence charSequence = this.aaQ.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.aaQ.size() - 1) {
            findViewById.setVisibility(8);
            aj.j(inflate, d.g.dialog_single_button_bg_selector);
        } else if (this.aaQ.size() == 1) {
            findViewById.setVisibility(8);
            aj.j(inflate, d.g.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            aj.j(inflate, d.g.dialog_single_button_first_bg_selector);
        } else {
            aj.j(inflate, d.g.dialg_alert_btn_bg);
        }
        if (this.aaR != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.aaR.a(b.this, i, textView);
                }
            });
        }
        this.mContentView.addView(inflate);
        return inflate;
    }

    public View cj(int i) {
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
