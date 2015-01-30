package com.baidu.tbadk.core.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private static final HashMap<Integer, Integer[]> FT = new HashMap<>(2);
    private List<Object> FN;
    private l FO;
    private final TextView FP;
    private final View FQ;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private AlertDialog mDialog;
    private final ViewGroup mRootView;
    private String mTitle;
    private int FS = -1;
    private int Fo = -1;
    private boolean Fx = false;
    private int FR = x.dialog_bdlist_item;

    static {
        FT.put(0, new Integer[]{Integer.valueOf(v.dialg_alert_btn_bg), Integer.valueOf(v.dialog_bdalert_button_textcolor_pressed)});
        FT.put(1, new Integer[]{Integer.valueOf(v.btn_blue_square), Integer.valueOf(t.cp_bg_line_d)});
    }

    public i(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) com.baidu.adp.lib.g.b.ei().inflate(activity, x.dialog_bdlist, null);
        this.FP = (TextView) this.mRootView.findViewById(w.dialog_title_list);
        this.mContentView = (ViewGroup) this.mRootView.findViewById(w.dialog_content);
        this.FQ = this.mRootView.findViewById(w.line_bg);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public i bX(String str) {
        this.mTitle = str;
        return this;
    }

    public i bD(int i) {
        return bX(this.mActivity.getResources().getString(i));
    }

    public i a(Object[] objArr, l lVar) {
        if (objArr != null && objArr.length > 0) {
            return a(Arrays.asList(objArr), lVar);
        }
        return this;
    }

    public i a(List<Object> list, l lVar) {
        if (list != null && list.size() > 0) {
            this.FN = list;
            if (lVar != null) {
                this.FO = lVar;
            }
        }
        return this;
    }

    public i bE(int i) {
        this.FS = i;
        return this;
    }

    public i bF(int i) {
        this.Fo = i;
        return this;
    }

    public i e(com.baidu.adp.base.j<?> jVar) {
        if (!this.Fx) {
            this.Fx = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.FP.setText(this.mTitle);
                this.FP.setVisibility(0);
                this.FQ.setVisibility(0);
            } else {
                this.FP.setVisibility(8);
                this.FQ.setVisibility(8);
            }
            if (this.FN != null && this.FN.size() > 0) {
                int size = this.FN.size();
                for (int i = 0; i < size; i++) {
                    bG(i);
                }
            }
            c(jVar);
        }
        return this;
    }

    public i nZ() {
        if (!this.Fx) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.mDialog != null) {
            com.baidu.adp.lib.g.k.a(this.mDialog, this.mActivity);
        } else {
            this.mDialog = new AlertDialog.Builder(this.mActivity).create();
            this.mDialog.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.k.a(this.mDialog, this.mActivity)) {
                Window window = this.mDialog.getWindow();
                if (this.FS == -1) {
                    this.FS = k.FX;
                }
                if (this.Fo == -1) {
                    this.Fo = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.Fo);
                window.setContentView(this.mRootView);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.j<?> jVar) {
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        if (jVar instanceof TbPageContext) {
            ((TbPageContext) jVar).getLayoutMode().ab(skinType == 1);
            ((TbPageContext) jVar).getLayoutMode().h(this.mRootView);
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            com.baidu.adp.lib.g.k.b(this.mDialog, this.mActivity);
        }
    }

    private View bG(int i) {
        String valueOf;
        View a = com.baidu.adp.lib.g.b.ei().a(this.mActivity, this.FR, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) a;
        TextView textView = (TextView) a.findViewById(w.dialog_item_btn);
        bc.i(a, v.dialg_alert_btn_bg);
        Object obj = this.FN.get(i);
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length <= 0) {
                valueOf = "";
            } else {
                valueOf = String.valueOf(objArr[0]);
            }
        } else {
            valueOf = String.valueOf(obj);
        }
        textView.setText(valueOf);
        if (this.FO != null) {
            linearLayout.setOnClickListener(new j(this, i, textView));
        }
        this.mContentView.addView(a);
        return a;
    }

    public View bH(int i) {
        if (this.mContentView == null) {
            return null;
        }
        int childCount = this.mContentView.getChildCount();
        if (i < 0 || i > childCount - 1) {
            return null;
        }
        return this.mContentView.getChildAt(i);
    }
}
