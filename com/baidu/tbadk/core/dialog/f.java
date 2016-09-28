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
    private TbPageContext<?> Gd;
    private AlertDialog VI;
    private ViewGroup VJ;
    private TextView VW;
    private View VX;
    private g Wn;
    private ArrayList<h> mItems;
    private String mTitle;
    private int VZ = -1;
    private int Vx = -1;
    private boolean VL = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int Wh = r.k.dialog_ani_b2t;
        public static final int Wi = r.k.dialog_ani_t2b;
        public static final int Wj = r.k.dialog_ani_l2r;
        public static final int Wk = r.k.dialog_ani_r2l;
    }

    public f(TbPageContext<?> tbPageContext) {
        this.Gd = tbPageContext;
        this.VJ = (ViewGroup) LayoutInflater.from(this.Gd.getPageActivity()).inflate(r.h.dialog_rich_layout, (ViewGroup) null);
        this.VW = (TextView) this.VJ.findViewById(r.g.dialog_title_list);
        this.Cj = (BdListView) this.VJ.findViewById(r.g.dialog_content_list);
        this.VX = this.VJ.findViewById(r.g.line_bg);
        this.Wn = new g(this.Gd);
    }

    public f cF(String str) {
        this.mTitle = str;
        return this;
    }

    public f ch(int i) {
        return cF(this.Gd.getResources().getString(i));
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

    public f tq() {
        if (!this.VL) {
            this.VL = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.VW.setText(this.mTitle);
                this.VW.setVisibility(0);
                this.VX.setVisibility(0);
            } else {
                this.VW.setVisibility(8);
                this.VX.setVisibility(8);
            }
            this.Cj.setAdapter((ListAdapter) this.Wn);
            this.Wn.setData(this.mItems);
            c(this.Gd);
        }
        return this;
    }

    public void ci(int i) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            if (i2 == i) {
                this.mItems.get(i2).setChecked(true);
            } else {
                this.mItems.get(i2).setChecked(false);
            }
        }
        this.Wn.setData(this.mItems);
    }

    public f tr() {
        if (!this.VL) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.VI != null) {
            j.a(this.VI, this.Gd);
        } else {
            this.VI = new AlertDialog.Builder(this.Gd.getPageActivity()).create();
            this.VI.setCanceledOnTouchOutside(true);
            if (j.a(this.VI, this.Gd.getPageActivity())) {
                Window window = this.VI.getWindow();
                if (this.VZ == -1) {
                    this.VZ = a.Wh;
                }
                if (this.Vx == -1) {
                    this.Vx = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.Vx);
                window.setBackgroundDrawableResource(r.f.transparent_bg);
                window.setContentView(this.VJ);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.h<?> hVar) {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ah(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this.VJ);
        }
        this.VJ.setBackgroundResource(r.f.transparent_bg);
    }

    public void dismiss() {
        if (this.VI != null) {
            j.b(this.VI, this.Gd.getPageActivity());
        }
    }
}
