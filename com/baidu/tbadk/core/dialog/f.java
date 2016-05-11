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
    private TbPageContext<?> Do;
    private AlertDialog RH;
    private ViewGroup RI;
    private TextView RX;
    private View RY;
    private g So;
    private ArrayList<h> mItems;
    private String mTitle;
    private AdapterView.OnItemClickListener yR;
    private BdListView zu;
    private int Sa = -1;
    private int Rw = -1;
    private boolean RK = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int Si = t.k.dialog_ani_b2t;
        public static final int Sj = t.k.dialog_ani_t2b;
        public static final int Sk = t.k.dialog_ani_l2r;
        public static final int Sl = t.k.dialog_ani_r2l;
    }

    public f(TbPageContext<?> tbPageContext) {
        this.Do = tbPageContext;
        this.RI = (ViewGroup) LayoutInflater.from(this.Do.getPageActivity()).inflate(t.h.dialog_rich_layout, (ViewGroup) null);
        this.RX = (TextView) this.RI.findViewById(t.g.dialog_title_list);
        this.zu = (BdListView) this.RI.findViewById(t.g.dialog_content_list);
        this.RY = this.RI.findViewById(t.g.line_bg);
        this.So = new g(this.Do);
    }

    public f cC(String str) {
        this.mTitle = str;
        return this;
    }

    public f bU(int i) {
        return cC(this.Do.getResources().getString(i));
    }

    public f a(ArrayList<h> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.yR = onItemClickListener;
                this.zu.setOnItemClickListener(this.yR);
            }
        }
        return this;
    }

    public f rY() {
        if (!this.RK) {
            this.RK = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.RX.setText(this.mTitle);
                this.RX.setVisibility(0);
                this.RY.setVisibility(0);
            } else {
                this.RX.setVisibility(8);
                this.RY.setVisibility(8);
            }
            this.zu.setAdapter((ListAdapter) this.So);
            this.So.setData(this.mItems);
            c(this.Do);
        }
        return this;
    }

    public void bV(int i) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            if (i2 == i) {
                this.mItems.get(i2).setChecked(true);
            } else {
                this.mItems.get(i2).setChecked(false);
            }
        }
        this.So.setData(this.mItems);
    }

    public f rZ() {
        if (!this.RK) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.RH != null) {
            j.a(this.RH, this.Do);
        } else {
            this.RH = new AlertDialog.Builder(this.Do.getPageActivity()).create();
            this.RH.setCanceledOnTouchOutside(true);
            if (j.a(this.RH, this.Do.getPageActivity())) {
                Window window = this.RH.getWindow();
                if (this.Sa == -1) {
                    this.Sa = a.Si;
                }
                if (this.Rw == -1) {
                    this.Rw = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.Rw);
                window.setBackgroundDrawableResource(t.f.transparent_bg);
                window.setContentView(this.RI);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.h<?> hVar) {
        int skinType = TbadkCoreApplication.m11getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ae(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this.RI);
        }
        this.RI.setBackgroundResource(t.f.transparent_bg);
    }

    public void dismiss() {
        if (this.RH != null) {
            j.b(this.RH, this.Do.getPageActivity());
        }
    }
}
