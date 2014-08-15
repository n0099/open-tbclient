package com.baidu.tbadk.core.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
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
    private static final HashMap<Integer, Integer[]> o = new HashMap<>(2);
    private String a;
    private List<Object> b;
    private h c;
    private final LayoutInflater d;
    private final Activity e;
    private final ViewGroup f;
    private final ViewGroup g;
    private final TextView h;
    private final View i;
    private AlertDialog n;
    private int k = -1;
    private int l = -1;
    private boolean m = false;
    private int j = v.dialog_bdlist_item;

    static {
        o.put(0, new Integer[]{Integer.valueOf(t.dialg_alert_btn_bg), Integer.valueOf(t.dialog_bdalert_button_textcolor_pressed)});
        o.put(1, new Integer[]{Integer.valueOf(t.btn_blue_square), Integer.valueOf(r.share_copy_pb_url)});
    }

    public e(Activity activity) {
        this.e = activity;
        this.d = (LayoutInflater) activity.getSystemService("layout_inflater");
        this.f = (ViewGroup) this.d.inflate(v.dialog_bdlist, (ViewGroup) null);
        this.h = (TextView) this.f.findViewById(u.dialog_title_list);
        this.g = (ViewGroup) this.f.findViewById(u.dialog_content);
        this.i = this.f.findViewById(u.line_bg);
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
        this.k = i;
        return this;
    }

    public e b(int i) {
        this.l = i;
        return this;
    }

    public e a() {
        if (!this.m) {
            this.m = true;
            if (!TextUtils.isEmpty(this.a)) {
                this.h.setText(this.a);
                this.h.setVisibility(0);
                this.i.setVisibility(0);
            } else {
                this.h.setVisibility(8);
                this.i.setVisibility(8);
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
        if (!this.m) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.n != null) {
            com.baidu.adp.lib.e.d.a(this.n, this.e);
        } else {
            this.n = new AlertDialog.Builder(this.e).create();
            this.n.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.e.d.a(this.n, this.e)) {
                Window window = this.n.getWindow();
                if (this.k == -1) {
                    this.k = g.a;
                }
                if (this.l == -1) {
                    this.l = 17;
                }
                window.setGravity(this.l);
                window.setContentView(this.f);
            }
        }
        return this;
    }

    private void d() {
        int skinType = TbadkApplication.m252getInst().getSkinType();
        if (this.e instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) this.e;
            baseActivity.getLayoutMode().a(skinType == 1);
            baseActivity.getLayoutMode().a((View) this.f);
        } else if (this.e instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) this.e;
            baseFragmentActivity.c().a(skinType == 1);
            baseFragmentActivity.c().a((View) this.f);
        }
    }

    public void c() {
        if (this.n != null) {
            com.baidu.adp.lib.e.d.b(this.n, this.e);
        }
    }

    private View d(int i) {
        String valueOf;
        View inflate = LayoutInflater.from(this.e).inflate(this.j, this.g, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        TextView textView = (TextView) inflate.findViewById(u.dialog_item_btn);
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
        this.g.addView(inflate);
        return inflate;
    }

    public View c(int i) {
        if (this.g == null) {
            return null;
        }
        int childCount = this.g.getChildCount();
        if (i < 0 || i > childCount - 1) {
            return null;
        }
        return this.g.getChildAt(i);
    }
}
