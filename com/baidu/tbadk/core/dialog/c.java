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
import com.baidu.adp.lib.h.j;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static final HashMap<Integer, Integer[]> VT = new HashMap<>(2);
    private List<CharSequence> Rr;
    private b VL;
    private final TextView VM;
    private final View VN;
    private LinearLayout.LayoutParams VS;
    private AlertDialog Vy;
    private final ViewGroup Vz;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.h<?> mContext;
    private String mTitle;
    private int VP = -1;
    private int Vn = -1;
    private int VQ = -1;
    private boolean VB = false;
    private int VR = -1;
    private int VO = t.h.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int VX = t.k.dialog_ani_b2t;
        public static final int VY = t.k.dialog_ani_t2b;
        public static final int VZ = t.k.dialog_ani_l2r;
        public static final int Wa = t.k.dialog_ani_r2l;
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(c cVar, int i, View view);
    }

    static {
        VT.put(0, new Integer[]{Integer.valueOf(t.f.dialg_alert_btn_bg), Integer.valueOf(t.f.dialog_bdalert_button_textcolor_pressed)});
        VT.put(1, new Integer[]{Integer.valueOf(t.f.btn_blue_square), Integer.valueOf(t.d.cp_bg_line_d)});
    }

    public c(Activity activity) {
        this.mActivity = activity;
        this.Vz = (ViewGroup) LayoutInflater.from(activity).inflate(t.h.dialog_bdlist, (ViewGroup) null);
        this.VM = (TextView) this.Vz.findViewById(t.g.dialog_title_list);
        this.mContentView = (ViewGroup) this.Vz.findViewById(t.g.dialog_content);
        this.VN = this.Vz.findViewById(t.g.line_bg);
    }

    public View getRootView() {
        return this.Vz;
    }

    public c cC(String str) {
        this.mTitle = str;
        return this;
    }

    public c cc(int i) {
        return cC(this.mActivity.getResources().getString(i));
    }

    public c a(CharSequence[] charSequenceArr, b bVar) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), bVar);
        }
        return this;
    }

    public c a(List<CharSequence> list, b bVar) {
        if (list != null && list.size() > 0) {
            this.Rr = list;
            if (bVar != null) {
                this.VL = bVar;
            }
        }
        return this;
    }

    public c cd(int i) {
        this.VP = i;
        return this;
    }

    public c ce(int i) {
        this.Vn = i;
        return this;
    }

    public c d(com.baidu.adp.base.h<?> hVar) {
        if (!this.VB) {
            this.mContext = hVar;
            this.VB = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.VM.setText(this.mTitle);
                this.VM.setVisibility(0);
                this.VN.setVisibility(0);
            } else {
                this.VM.setVisibility(8);
                this.VN.setVisibility(8);
            }
            if (this.Rr != null && this.Rr.size() > 0) {
                int size = this.Rr.size();
                for (int i = 0; i < size; i++) {
                    cf(i);
                }
            }
            c(hVar);
        }
        return this;
    }

    public void reset() {
        this.VB = false;
        if (this.mContentView != null) {
            this.mContentView.removeAllViews();
        }
    }

    public c ta() {
        if (!this.VB) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Vy != null) {
            j.a(this.Vy, this.mActivity);
        } else {
            this.Vy = new AlertDialog.Builder(this.mActivity, t.k.NoBackDimEnableDialog).create();
            this.Vy.setCanceledOnTouchOutside(true);
            if (j.a(this.Vy, this.mActivity)) {
                Window window = this.Vy.getWindow();
                if (this.VP == -1) {
                    this.VP = a.VX;
                }
                if (this.Vn == -1) {
                    this.Vn = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.Vn);
                window.setContentView(this.Vz);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.h<?> hVar) {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ah(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this.Vz);
        }
        this.Vz.setBackgroundResource(t.f.transparent_bg);
    }

    public void hide() {
        if (this.Vy != null) {
            this.Vy.hide();
        }
    }

    public void dismiss() {
        if (this.Vy != null) {
            j.b(this.Vy, this.mActivity);
        }
    }

    private View cf(int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.VO, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        TextView textView = (TextView) inflate.findViewById(t.g.dialog_item_btn);
        if (this.VS != null) {
            textView.setLayoutParams(this.VS);
        }
        if (this.VQ != -1) {
            textView.setTextSize(0, this.VQ);
        }
        if (this.VR != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.VR);
        }
        View findViewById = inflate.findViewById(t.g.line);
        CharSequence charSequence = this.Rr.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.Rr.size() - 1) {
            findViewById.setVisibility(8);
            av.k(inflate, t.f.dialog_single_button_bg_selector);
        } else if (this.Rr.size() == 1) {
            findViewById.setVisibility(8);
            av.k(inflate, t.f.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            av.k(inflate, t.f.dialog_single_button_first_bg_selector);
        } else {
            av.k(inflate, t.f.dialg_alert_btn_bg);
        }
        if (this.VL != null) {
            linearLayout.setOnClickListener(new d(this, i, textView));
        }
        this.mContentView.addView(inflate);
        return inflate;
    }

    public View cg(int i) {
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
