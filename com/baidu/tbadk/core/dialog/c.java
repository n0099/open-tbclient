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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static final HashMap<Integer, Integer[]> VV = new HashMap<>(2);
    private List<CharSequence> RP;
    private AlertDialog VA;
    private final ViewGroup VB;
    private b VN;
    private final TextView VO;
    private final View VP;
    private LinearLayout.LayoutParams VU;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.h<?> mContext;
    private String mTitle;
    private int VR = -1;
    private int Vp = -1;
    private int VS = -1;
    private boolean VD = false;
    private int VT = -1;
    private int VQ = r.h.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int VZ = r.k.dialog_ani_b2t;
        public static final int Wa = r.k.dialog_ani_t2b;
        public static final int Wb = r.k.dialog_ani_l2r;
        public static final int Wc = r.k.dialog_ani_r2l;
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(c cVar, int i, View view);
    }

    static {
        VV.put(0, new Integer[]{Integer.valueOf(r.f.dialg_alert_btn_bg), Integer.valueOf(r.f.dialog_bdalert_button_textcolor_pressed)});
        VV.put(1, new Integer[]{Integer.valueOf(r.f.btn_blue_square), Integer.valueOf(r.d.cp_bg_line_d)});
    }

    public c(Activity activity) {
        this.mActivity = activity;
        this.VB = (ViewGroup) LayoutInflater.from(activity).inflate(r.h.dialog_bdlist, (ViewGroup) null);
        this.VO = (TextView) this.VB.findViewById(r.g.dialog_title_list);
        this.mContentView = (ViewGroup) this.VB.findViewById(r.g.dialog_content);
        this.VP = this.VB.findViewById(r.g.line_bg);
    }

    public View getRootView() {
        return this.VB;
    }

    public c cH(String str) {
        this.mTitle = str;
        return this;
    }

    public c ce(int i) {
        return cH(this.mActivity.getResources().getString(i));
    }

    public c a(CharSequence[] charSequenceArr, b bVar) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), bVar);
        }
        return this;
    }

    public c a(List<CharSequence> list, b bVar) {
        if (list != null && list.size() > 0) {
            this.RP = list;
            if (bVar != null) {
                this.VN = bVar;
            }
        }
        return this;
    }

    public c cf(int i) {
        this.VR = i;
        return this;
    }

    public c cg(int i) {
        this.Vp = i;
        return this;
    }

    public c d(com.baidu.adp.base.h<?> hVar) {
        if (!this.VD) {
            this.mContext = hVar;
            this.VD = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.VO.setText(this.mTitle);
                this.VO.setVisibility(0);
                this.VP.setVisibility(0);
            } else {
                this.VO.setVisibility(8);
                this.VP.setVisibility(8);
            }
            if (this.RP != null && this.RP.size() > 0) {
                int size = this.RP.size();
                for (int i = 0; i < size; i++) {
                    ch(i);
                }
            }
            c(hVar);
        }
        return this;
    }

    public void reset() {
        this.VD = false;
        if (this.mContentView != null) {
            this.mContentView.removeAllViews();
        }
    }

    public c te() {
        if (!this.VD) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.VA != null) {
            j.a(this.VA, this.mActivity);
        } else {
            this.VA = new AlertDialog.Builder(this.mActivity, r.k.NoBackDimEnableDialog).create();
            this.VA.setCanceledOnTouchOutside(true);
            if (j.a(this.VA, this.mActivity)) {
                Window window = this.VA.getWindow();
                if (this.VR == -1) {
                    this.VR = a.VZ;
                }
                if (this.Vp == -1) {
                    this.Vp = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.Vp);
                window.setContentView(this.VB);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.h<?> hVar) {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ai(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this.VB);
        }
        this.VB.setBackgroundResource(r.f.transparent_bg);
    }

    public void hide() {
        if (this.VA != null) {
            this.VA.hide();
        }
    }

    public void dismiss() {
        if (this.VA != null) {
            j.b(this.VA, this.mActivity);
        }
    }

    private View ch(int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.VQ, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        TextView textView = (TextView) inflate.findViewById(r.g.dialog_item_btn);
        if (this.VU != null) {
            textView.setLayoutParams(this.VU);
        }
        if (this.VS != -1) {
            textView.setTextSize(0, this.VS);
        }
        if (this.VT != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.VT);
        }
        View findViewById = inflate.findViewById(r.g.line);
        CharSequence charSequence = this.RP.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.RP.size() - 1) {
            findViewById.setVisibility(8);
            ar.k(inflate, r.f.dialog_single_button_bg_selector);
        } else if (this.RP.size() == 1) {
            findViewById.setVisibility(8);
            ar.k(inflate, r.f.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            ar.k(inflate, r.f.dialog_single_button_first_bg_selector);
        } else {
            ar.k(inflate, r.f.dialg_alert_btn_bg);
        }
        if (this.VN != null) {
            linearLayout.setOnClickListener(new d(this, i, textView));
        }
        this.mContentView.addView(inflate);
        return inflate;
    }

    public View ci(int i) {
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
