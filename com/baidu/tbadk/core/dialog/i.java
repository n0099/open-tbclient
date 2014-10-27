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
    private static final HashMap<Integer, Integer[]> BD = new HashMap<>(2);
    private final View BA;
    private AlertDialog Bf;
    private List<Object> Bw;
    private l Bx;
    private final ViewGroup By;
    private final TextView Bz;
    private final Activity mActivity;
    private final ViewGroup mRootView;
    private String mTitle;
    private int BC = -1;
    private int AW = -1;
    private boolean Bh = false;
    private int BB = w.dialog_bdlist_item;

    static {
        BD.put(0, new Integer[]{Integer.valueOf(u.dialg_alert_btn_bg), Integer.valueOf(u.dialog_bdalert_button_textcolor_pressed)});
        BD.put(1, new Integer[]{Integer.valueOf(u.btn_blue_square), Integer.valueOf(s.share_copy_pb_url)});
    }

    public i(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) com.baidu.adp.lib.g.b.ek().inflate(activity, w.dialog_bdlist, null);
        this.Bz = (TextView) this.mRootView.findViewById(v.dialog_title_list);
        this.By = (ViewGroup) this.mRootView.findViewById(v.dialog_content);
        this.BA = this.mRootView.findViewById(v.line_bg);
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
            this.Bw = list;
            if (lVar != null) {
                this.Bx = lVar;
            }
        }
        return this;
    }

    public i bd(int i) {
        this.BC = i;
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
                this.Bz.setText(this.mTitle);
                this.Bz.setVisibility(0);
                this.BA.setVisibility(0);
            } else {
                this.Bz.setVisibility(8);
                this.BA.setVisibility(8);
            }
            if (this.Bw != null && this.Bw.size() > 0) {
                int size = this.Bw.size();
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
                if (this.BC == -1) {
                    this.BC = k.BH;
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
        View a = com.baidu.adp.lib.g.b.ek().a(this.mActivity, this.BB, this.By, false);
        LinearLayout linearLayout = (LinearLayout) a;
        TextView textView = (TextView) a.findViewById(v.dialog_item_btn);
        aw.h(a, u.dialg_alert_btn_bg);
        Object obj = this.Bw.get(i);
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
        if (this.Bx != null) {
            linearLayout.setOnClickListener(new j(this, i, textView));
        }
        this.By.addView(a);
        return a;
    }

    public View bg(int i) {
        if (this.By == null) {
            return null;
        }
        int childCount = this.By.getChildCount();
        if (i < 0 || i > childCount - 1) {
            return null;
        }
        return this.By.getChildAt(i);
    }
}
