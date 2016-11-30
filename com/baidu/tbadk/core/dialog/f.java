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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f {
    private AdapterView.OnItemClickListener BG;
    private BdListView Cj;
    private TbPageContext<?> Gf;
    private g WL;
    private AlertDialog Wg;
    private ViewGroup Wh;
    private TextView Wu;
    private View Wv;
    private ArrayList<h> mItems;
    private String mTitle;
    private int Wx = -1;
    private int VV = -1;
    private boolean Wj = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int WF = r.k.dialog_ani_b2t;
        public static final int WG = r.k.dialog_ani_t2b;
        public static final int WH = r.k.dialog_ani_l2r;
        public static final int WI = r.k.dialog_ani_r2l;
    }

    public f(TbPageContext<?> tbPageContext) {
        this.Gf = tbPageContext;
        this.Wh = (ViewGroup) LayoutInflater.from(this.Gf.getPageActivity()).inflate(r.h.dialog_rich_layout, (ViewGroup) null);
        this.Wu = (TextView) this.Wh.findViewById(r.g.dialog_title_list);
        this.Cj = (BdListView) this.Wh.findViewById(r.g.dialog_content_list);
        this.Wv = this.Wh.findViewById(r.g.line_bg);
        this.WL = new g(this.Gf);
    }

    public f cH(String str) {
        this.mTitle = str;
        return this;
    }

    public f ci(int i) {
        return cH(this.Gf.getResources().getString(i));
    }

    public f a(ArrayList<h> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.BG = onItemClickListener;
                this.Cj.setOnItemClickListener(this.BG);
            }
        }
        return this;
    }

    public f tu() {
        if (!this.Wj) {
            this.Wj = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.Wu.setText(this.mTitle);
                this.Wu.setVisibility(0);
                this.Wv.setVisibility(0);
            } else {
                this.Wu.setVisibility(8);
                this.Wv.setVisibility(8);
            }
            this.Cj.setAdapter((ListAdapter) this.WL);
            this.WL.setData(this.mItems);
            c(this.Gf);
        }
        return this;
    }

    public void cj(int i) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            if (i2 == i) {
                this.mItems.get(i2).setChecked(true);
            } else {
                this.mItems.get(i2).setChecked(false);
            }
        }
        this.WL.setData(this.mItems);
    }

    public f tv() {
        if (!this.Wj) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Wg != null) {
            j.a(this.Wg, this.Gf);
        } else {
            this.Wg = new AlertDialog.Builder(this.Gf.getPageActivity()).create();
            this.Wg.setCanceledOnTouchOutside(true);
            if (j.a(this.Wg, this.Gf.getPageActivity())) {
                Window window = this.Wg.getWindow();
                if (this.Wx == -1) {
                    this.Wx = a.WF;
                }
                if (this.VV == -1) {
                    this.VV = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.VV);
                window.setBackgroundDrawableResource(r.f.transparent_bg);
                window.setContentView(this.Wh);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.h<?> hVar) {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ai(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this.Wh);
        }
        this.Wh.setBackgroundResource(r.f.transparent_bg);
    }

    public void dismiss() {
        if (this.Wg != null) {
            j.b(this.Wg, this.Gf.getPageActivity());
        }
    }
}
