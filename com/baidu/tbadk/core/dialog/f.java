package com.baidu.tbadk.core.dialog;

import android.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.h.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f {
    private AdapterView.OnItemClickListener Iy;
    private BdListView Je;
    private TbPageContext<?> MX;
    private TextView WM;
    private View WN;
    private AlertDialog Wx;
    private ViewGroup Wy;
    private g Xa;
    private ArrayList<h> mItems;
    private String mTitle;
    private int WP = -1;
    private int Wm = -1;
    private boolean WA = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int WU = t.k.dialog_ani_b2t;
        public static final int WV = t.k.dialog_ani_t2b;
        public static final int WW = t.k.dialog_ani_l2r;
        public static final int WX = t.k.dialog_ani_r2l;
    }

    public f(TbPageContext<?> tbPageContext) {
        this.MX = tbPageContext;
        this.Wy = (ViewGroup) LayoutInflater.from(this.MX.getPageActivity()).inflate(t.h.dialog_rich_layout, (ViewGroup) null);
        this.WM = (TextView) this.Wy.findViewById(t.g.dialog_title_list);
        this.Je = (BdListView) this.Wy.findViewById(t.g.dialog_content_list);
        this.WN = this.Wy.findViewById(t.g.line_bg);
        this.Xa = new g(this.MX);
    }

    public f cE(String str) {
        this.mTitle = str;
        return this;
    }

    public f cj(int i) {
        return cE(this.MX.getResources().getString(i));
    }

    public f a(ArrayList<h> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.Iy = onItemClickListener;
                this.Je.setOnItemClickListener(this.Iy);
            }
        }
        return this;
    }

    public f ut() {
        if (!this.WA) {
            this.WA = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.WM.setText(this.mTitle);
                this.WM.setVisibility(0);
                this.WN.setVisibility(0);
            } else {
                this.WM.setVisibility(8);
                this.WN.setVisibility(8);
            }
            this.Je.setAdapter((ListAdapter) this.Xa);
            this.Xa.setData(this.mItems);
            c(this.MX);
        }
        return this;
    }

    public void ck(int i) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            if (i2 == i) {
                this.mItems.get(i2).setChecked(true);
            } else {
                this.mItems.get(i2).setChecked(false);
            }
        }
        this.Xa.setData(this.mItems);
    }

    public f uu() {
        if (!this.WA) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Wx != null) {
            j.a(this.Wx, this.MX);
        } else {
            this.Wx = new AlertDialog.Builder(this.MX.getPageActivity()).create();
            this.Wx.setCanceledOnTouchOutside(true);
            if (j.a(this.Wx, this.MX.getPageActivity())) {
                Window window = this.Wx.getWindow();
                if (this.WP == -1) {
                    this.WP = a.WU;
                }
                if (this.Wm == -1) {
                    this.Wm = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.Wm);
                window.setBackgroundDrawableResource(t.f.transparent_bg);
                window.setContentView(this.Wy);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.h<?> hVar) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ab(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this.Wy);
        }
        this.Wy.setBackgroundResource(t.f.transparent_bg);
    }

    public void dismiss() {
        if (this.Wx != null) {
            j.b(this.Wx, this.MX.getPageActivity());
        }
    }
}
