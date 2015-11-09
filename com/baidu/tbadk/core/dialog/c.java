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
import com.baidu.adp.base.h;
import com.baidu.adp.lib.g.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static final HashMap<Integer, Integer[]> WV = new HashMap<>(2);
    private AlertDialog WB;
    private List<CharSequence> WO;
    private b WP;
    private final ViewGroup WQ;
    private final TextView WR;
    private final View WS;
    private final Activity mActivity;
    private h<?> mContext;
    private final ViewGroup mRootView;
    private String mTitle;
    private int WU = -1;
    private int Ws = -1;
    private boolean WD = false;
    private int WT = i.g.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int WY = i.C0057i.dialog_ani_b2t;
        public static final int WZ = i.C0057i.dialog_ani_t2b;
        public static final int Xa = i.C0057i.dialog_ani_l2r;
        public static final int Xb = i.C0057i.dialog_ani_r2l;
    }

    /* loaded from: classes.dex */
    public interface b {
        void itemClick(c cVar, int i, View view);
    }

    static {
        WV.put(0, new Integer[]{Integer.valueOf(i.e.dialg_alert_btn_bg), Integer.valueOf(i.e.dialog_bdalert_button_textcolor_pressed)});
        WV.put(1, new Integer[]{Integer.valueOf(i.e.btn_blue_square), Integer.valueOf(i.c.cp_bg_line_d)});
    }

    public c(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(i.g.dialog_bdlist, (ViewGroup) null);
        this.WR = (TextView) this.mRootView.findViewById(i.f.dialog_title_list);
        this.WQ = (ViewGroup) this.mRootView.findViewById(i.f.dialog_content);
        this.WS = this.mRootView.findViewById(i.f.line_bg);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public c cv(String str) {
        this.mTitle = str;
        return this;
    }

    public c bI(int i) {
        return cv(this.mActivity.getResources().getString(i));
    }

    public c a(CharSequence[] charSequenceArr, b bVar) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), bVar);
        }
        return this;
    }

    public c a(List<CharSequence> list, b bVar) {
        if (list != null && list.size() > 0) {
            this.WO = list;
            if (bVar != null) {
                this.WP = bVar;
            }
        }
        return this;
    }

    public c bJ(int i) {
        this.WU = i;
        return this;
    }

    public c bK(int i) {
        this.Ws = i;
        return this;
    }

    public c d(h<?> hVar) {
        if (!this.WD) {
            this.mContext = hVar;
            this.WD = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.WR.setText(this.mTitle);
                this.WR.setVisibility(0);
                this.WS.setVisibility(0);
            } else {
                this.WR.setVisibility(8);
                this.WS.setVisibility(8);
            }
            if (this.WO != null && this.WO.size() > 0) {
                int size = this.WO.size();
                for (int i = 0; i < size; i++) {
                    bL(i);
                }
            }
            c(hVar);
        }
        return this;
    }

    public c sU() {
        if (!this.WD) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.WB != null) {
            j.a(this.WB, this.mActivity);
        } else {
            this.WB = new AlertDialog.Builder(this.mActivity).create();
            this.WB.setCanceledOnTouchOutside(true);
            if (j.a(this.WB, this.mActivity)) {
                Window window = this.WB.getWindow();
                if (this.WU == -1) {
                    this.WU = a.WY;
                }
                if (this.Ws == -1) {
                    this.Ws = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.Ws);
                window.setBackgroundDrawableResource(i.e.transparent_bg);
                window.setContentView(this.mRootView);
            }
        }
        return this;
    }

    private void c(h<?> hVar) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ad(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().k(this.mRootView);
        }
        this.mRootView.setBackgroundResource(i.e.transparent_bg);
    }

    public void dismiss() {
        if (this.WB != null) {
            j.b(this.WB, this.mActivity);
        }
    }

    private View bL(int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.WT, this.WQ, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        TextView textView = (TextView) inflate.findViewById(i.f.dialog_item_btn);
        View findViewById = inflate.findViewById(i.f.line);
        CharSequence charSequence = this.WO.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.WO.size() - 1) {
            findViewById.setVisibility(8);
            an.i(inflate, i.e.dialog_single_button_bg_selector);
        } else {
            an.i(inflate, i.e.dialg_alert_btn_bg);
        }
        if (this.WP != null) {
            linearLayout.setOnClickListener(new d(this, i, textView));
        }
        this.WQ.addView(inflate);
        return inflate;
    }

    public View bM(int i) {
        if (this.WQ == null) {
            return null;
        }
        int childCount = this.WQ.getChildCount();
        if (i < 0 || i > childCount - 1) {
            return null;
        }
        return this.WQ.getChildAt(i);
    }
}
