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
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<Integer, Integer[]> n = new HashMap<>(2);
    private String a;
    private List<Object> b;
    private h c;
    private final Activity d;
    private final ViewGroup e;
    private final ViewGroup f;
    private final TextView g;
    private final View h;
    private AlertDialog m;
    private int j = -1;
    private int k = -1;
    private boolean l = false;
    private int i = v.dialog_bdlist_item;

    static {
        n.put(0, new Integer[]{Integer.valueOf(t.dialg_alert_btn_bg), Integer.valueOf(t.dialog_bdalert_button_textcolor_pressed)});
        n.put(1, new Integer[]{Integer.valueOf(t.btn_blue_square), Integer.valueOf(r.share_copy_pb_url)});
    }

    public e(Activity activity) {
        this.d = activity;
        this.e = (ViewGroup) com.baidu.adp.lib.e.b.a().a(activity, v.dialog_bdlist, null);
        this.g = (TextView) this.e.findViewById(u.dialog_title_list);
        this.f = (ViewGroup) this.e.findViewById(u.dialog_content);
        this.h = this.e.findViewById(u.line_bg);
    }

    public e a(Object[] objArr, h hVar) {
        if (objArr != null && objArr.length > 0) {
            return a(Arrays.asList(objArr), hVar);
        }
        return this;
    }

    public e a(List<Object> list, h hVar) {
        if (list != null && list.size() > 0) {
            this.b = list;
            if (hVar != null) {
                this.c = hVar;
            }
        }
        return this;
    }

    public e a(int i) {
        this.j = i;
        return this;
    }

    public e b(int i) {
        this.k = i;
        return this;
    }

    public e a() {
        if (!this.l) {
            this.l = true;
            if (!TextUtils.isEmpty(this.a)) {
                this.g.setText(this.a);
                this.g.setVisibility(0);
                this.h.setVisibility(0);
            } else {
                this.g.setVisibility(8);
                this.h.setVisibility(8);
            }
            if (this.b != null && this.b.size() > 0) {
                int size = this.b.size();
                for (int i = 0; i < size; i++) {
                    d(i);
                }
            }
            d();
        }
        return this;
    }

    public e b() {
        if (!this.l) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.m != null) {
            com.baidu.adp.lib.e.e.a(this.m, this.d);
        } else {
            this.m = new AlertDialog.Builder(this.d).create();
            this.m.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.e.e.a(this.m, this.d)) {
                Window window = this.m.getWindow();
                if (this.j == -1) {
                    this.j = g.a;
                }
                if (this.k == -1) {
                    this.k = 17;
                }
                window.setGravity(this.k);
                window.setContentView(this.e);
            }
        }
        return this;
    }

    private void d() {
        int skinType = TbadkApplication.m252getInst().getSkinType();
        if (this.d instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) this.d;
            baseActivity.getLayoutMode().a(skinType == 1);
            baseActivity.getLayoutMode().a((View) this.e);
        } else if (this.d instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) this.d;
            baseFragmentActivity.c().a(skinType == 1);
            baseFragmentActivity.c().a((View) this.e);
        }
    }

    public void c() {
        if (this.m != null) {
            com.baidu.adp.lib.e.e.b(this.m, this.d);
        }
    }

    private View d(int i) {
        String valueOf;
        View a = com.baidu.adp.lib.e.b.a().a(this.d, this.i, this.f, false);
        LinearLayout linearLayout = (LinearLayout) a;
        TextView textView = (TextView) a.findViewById(u.dialog_item_btn);
        Object obj = this.b.get(i);
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
        if (this.c != null) {
            linearLayout.setOnClickListener(new f(this, i, textView));
        }
        this.f.addView(a);
        return a;
    }

    public View c(int i) {
        if (this.f == null) {
            return null;
        }
        int childCount = this.f.getChildCount();
        if (i < 0 || i > childCount - 1) {
            return null;
        }
        return this.f.getChildAt(i);
    }
}
