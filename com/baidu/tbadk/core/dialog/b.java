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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static final HashMap<Integer, Integer[]> aaH = new HashMap<>(2);
    private List<CharSequence> VW;
    private final TextView aaA;
    private final View aaB;
    private LinearLayout.LayoutParams aaG;
    private AlertDialog aam;
    private final ViewGroup aan;
    private InterfaceC0043b aaz;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.e<?> mContext;
    private String mTitle;
    private int aaD = -1;
    private int aab = -1;
    private int aaE = -1;
    private boolean aap = false;
    private int aaF = -1;
    private int aaC = d.j.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int aaL = d.m.dialog_ani_b2t;
        public static final int aaM = d.m.dialog_ani_t2b;
        public static final int aaN = d.m.dialog_ani_l2r;
        public static final int aaO = d.m.dialog_ani_r2l;
    }

    /* renamed from: com.baidu.tbadk.core.dialog.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0043b {
        void a(b bVar, int i, View view);
    }

    static {
        aaH.put(0, new Integer[]{Integer.valueOf(d.g.dialg_alert_btn_bg), Integer.valueOf(d.g.dialog_bdalert_button_textcolor_pressed)});
        aaH.put(1, new Integer[]{Integer.valueOf(d.g.btn_blue_square), Integer.valueOf(d.e.cp_bg_line_d)});
    }

    public b(Activity activity) {
        this.mActivity = activity;
        this.aan = (ViewGroup) LayoutInflater.from(activity).inflate(d.j.dialog_bdlist, (ViewGroup) null);
        this.aaA = (TextView) this.aan.findViewById(d.h.dialog_title_list);
        this.mContentView = (ViewGroup) this.aan.findViewById(d.h.dialog_content);
        this.aaB = this.aan.findViewById(d.h.line_bg);
    }

    public View getRootView() {
        return this.aan;
    }

    public b cO(String str) {
        this.mTitle = str;
        return this;
    }

    public b cd(int i) {
        return cO(this.mActivity.getResources().getString(i));
    }

    public b a(CharSequence[] charSequenceArr, InterfaceC0043b interfaceC0043b) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), interfaceC0043b);
        }
        return this;
    }

    public b a(List<CharSequence> list, InterfaceC0043b interfaceC0043b) {
        if (list != null && list.size() > 0) {
            this.VW = list;
            if (interfaceC0043b != null) {
                this.aaz = interfaceC0043b;
            }
        }
        return this;
    }

    public b ce(int i) {
        this.aaD = i;
        return this;
    }

    public b cf(int i) {
        this.aab = i;
        return this;
    }

    public b d(com.baidu.adp.base.e<?> eVar) {
        if (!this.aap) {
            this.mContext = eVar;
            this.aap = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.aaA.setText(this.mTitle);
                this.aaA.setVisibility(0);
                this.aaB.setVisibility(0);
            } else {
                this.aaA.setVisibility(8);
                this.aaB.setVisibility(8);
            }
            if (this.VW != null && this.VW.size() > 0) {
                int size = this.VW.size();
                for (int i = 0; i < size; i++) {
                    cg(i);
                }
            }
            c(eVar);
        }
        return this;
    }

    public void reset() {
        this.aap = false;
        if (this.mContentView != null) {
            this.mContentView.removeAllViews();
        }
    }

    public b tk() {
        if (!this.aap) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aam != null) {
            g.a(this.aam, this.mActivity);
        } else {
            this.aam = new AlertDialog.Builder(this.mActivity, d.m.NoBackDimEnableDialog).create();
            this.aam.setCanceledOnTouchOutside(true);
            if (g.a(this.aam, this.mActivity)) {
                Window window = this.aam.getWindow();
                if (this.aaD == -1) {
                    this.aaD = a.aaL;
                }
                if (this.aab == -1) {
                    this.aab = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.aab);
                window.setContentView(this.aan);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.e<?> eVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().ah(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().t(this.aan);
        }
        this.aan.setBackgroundResource(d.g.transparent_bg);
    }

    public void hide() {
        if (this.aam != null) {
            this.aam.hide();
        }
    }

    public void dismiss() {
        if (this.aam != null) {
            g.b(this.aam, this.mActivity);
        }
    }

    private View cg(final int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.aaC, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        final TextView textView = (TextView) inflate.findViewById(d.h.dialog_item_btn);
        if (this.aaG != null) {
            textView.setLayoutParams(this.aaG);
        }
        if (this.aaE != -1) {
            textView.setTextSize(0, this.aaE);
        }
        if (this.aaF != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.aaF);
        }
        View findViewById = inflate.findViewById(d.h.line);
        CharSequence charSequence = this.VW.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.VW.size() - 1) {
            findViewById.setVisibility(8);
            ai.j(inflate, d.g.dialog_single_button_bg_selector);
        } else if (this.VW.size() == 1) {
            findViewById.setVisibility(8);
            ai.j(inflate, d.g.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            ai.j(inflate, d.g.dialog_single_button_first_bg_selector);
        } else {
            ai.j(inflate, d.g.dialg_alert_btn_bg);
        }
        if (this.aaz != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.aaz.a(b.this, i, textView);
                }
            });
        }
        this.mContentView.addView(inflate);
        return inflate;
    }

    public View ch(int i) {
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
