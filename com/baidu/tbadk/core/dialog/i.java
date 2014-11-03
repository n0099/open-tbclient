package com.baidu.tbadk.core.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private static final HashMap<Integer, Integer[]> BE = new HashMap<>(2);
    private final TextView BA;
    private final View BB;
    private AlertDialog Bf;
    private List<Object> Bx;
    private l By;
    private final ViewGroup Bz;
    private final Activity mActivity;
    private final ViewGroup mRootView;
    private String mTitle;
    private int BD = -1;
    private int AW = -1;
    private boolean Bh = false;
    private int BC = w.dialog_bdlist_item;

    static {
        BE.put(0, new Integer[]{Integer.valueOf(u.dialg_alert_btn_bg), Integer.valueOf(u.dialog_bdalert_button_textcolor_pressed)});
        BE.put(1, new Integer[]{Integer.valueOf(u.btn_blue_square), Integer.valueOf(s.share_copy_pb_url)});
    }

    public i(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) com.baidu.adp.lib.g.b.ek().inflate(activity, w.dialog_bdlist, null);
        this.BA = (TextView) this.mRootView.findViewById(v.dialog_title_list);
        this.Bz = (ViewGroup) this.mRootView.findViewById(v.dialog_content);
        this.BB = this.mRootView.findViewById(v.line_bg);
    }

    public i bh(String str) {
        this.mTitle = str;
        return this;
    }

    public i bc(int i) {
        return bh(this.mActivity.getResources().getString(i));
    }

    public i a(Object[] objArr, l lVar) {
        if (objArr != null && objArr.length > 0) {
            return a(Arrays.asList(objArr), lVar);
        }
        return this;
    }

    public i a(List<Object> list, l lVar) {
        if (list != null && list.size() > 0) {
            this.Bx = list;
            if (lVar != null) {
                this.By = lVar;
            }
        }
        return this;
    }

    public i bd(int i) {
        this.BD = i;
        return this;
    }

    public i be(int i) {
        this.AW = i;
        return this;
    }

    public i kZ() {
        if (!this.Bh) {
            this.Bh = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.BA.setText(this.mTitle);
                this.BA.setVisibility(0);
                this.BB.setVisibility(0);
            } else {
                this.BA.setVisibility(8);
                this.BB.setVisibility(8);
            }
            if (this.Bx != null && this.Bx.size() > 0) {
                int size = this.Bx.size();
                for (int i = 0; i < size; i++) {
                    bf(i);
                }
            }
            kU();
        }
        return this;
    }

    public i la() {
        if (!this.Bh) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Bf != null) {
            com.baidu.adp.lib.g.j.a(this.Bf, this.mActivity);
        } else {
            this.Bf = new AlertDialog.Builder(this.mActivity).create();
            this.Bf.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.j.a(this.Bf, this.mActivity)) {
                Window window = this.Bf.getWindow();
                if (this.BD == -1) {
                    this.BD = k.BI;
                }
                if (this.AW == -1) {
                    this.AW = 17;
                }
                window.setGravity(this.AW);
                window.setContentView(this.mRootView);
            }
        }
        return this;
    }

    private void kU() {
        int skinType = TbadkApplication.m251getInst().getSkinType();
        if (this.mActivity instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) this.mActivity;
            baseActivity.getLayoutMode().L(skinType == 1);
            baseActivity.getLayoutMode().h(this.mRootView);
        } else if (this.mActivity instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) this.mActivity;
            baseFragmentActivity.getLayoutMode().L(skinType == 1);
            baseFragmentActivity.getLayoutMode().h(this.mRootView);
        }
    }

    public void dismiss() {
        if (this.Bf != null) {
            com.baidu.adp.lib.g.j.b(this.Bf, this.mActivity);
        }
    }

    private View bf(int i) {
        String valueOf;
        View a = com.baidu.adp.lib.g.b.ek().a(this.mActivity, this.BC, this.Bz, false);
        LinearLayout linearLayout = (LinearLayout) a;
        TextView textView = (TextView) a.findViewById(v.dialog_item_btn);
        aw.h(a, u.dialg_alert_btn_bg);
        Object obj = this.Bx.get(i);
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
        if (this.By != null) {
            linearLayout.setOnClickListener(new j(this, i, textView));
        }
        this.Bz.addView(a);
        return a;
    }

    public View bg(int i) {
        if (this.Bz == null) {
            return null;
        }
        int childCount = this.Bz.getChildCount();
        if (i < 0 || i > childCount - 1) {
            return null;
        }
        return this.Bz.getChildAt(i);
    }
}
