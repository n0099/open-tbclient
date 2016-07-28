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
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f {
    private TbPageContext<?> DQ;
    private AlertDialog SI;
    private ViewGroup SJ;
    private TextView SW;
    private View SX;
    private g Tn;
    private ArrayList<h> mItems;
    private String mTitle;
    private BdListView zU;
    private AdapterView.OnItemClickListener zr;
    private int SZ = -1;
    private int Sx = -1;
    private boolean SL = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int Th = u.k.dialog_ani_b2t;
        public static final int Ti = u.k.dialog_ani_t2b;
        public static final int Tj = u.k.dialog_ani_l2r;
        public static final int Tk = u.k.dialog_ani_r2l;
    }

    public f(TbPageContext<?> tbPageContext) {
        this.DQ = tbPageContext;
        this.SJ = (ViewGroup) LayoutInflater.from(this.DQ.getPageActivity()).inflate(u.h.dialog_rich_layout, (ViewGroup) null);
        this.SW = (TextView) this.SJ.findViewById(u.g.dialog_title_list);
        this.zU = (BdListView) this.SJ.findViewById(u.g.dialog_content_list);
        this.SX = this.SJ.findViewById(u.g.line_bg);
        this.Tn = new g(this.DQ);
    }

    public f cB(String str) {
        this.mTitle = str;
        return this;
    }

    public f bU(int i) {
        return cB(this.DQ.getResources().getString(i));
    }

    public f a(ArrayList<h> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.zr = onItemClickListener;
                this.zU.setOnItemClickListener(this.zr);
            }
        }
        return this;
    }

    public f rW() {
        if (!this.SL) {
            this.SL = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.SW.setText(this.mTitle);
                this.SW.setVisibility(0);
                this.SX.setVisibility(0);
            } else {
                this.SW.setVisibility(8);
                this.SX.setVisibility(8);
            }
            this.zU.setAdapter((ListAdapter) this.Tn);
            this.Tn.setData(this.mItems);
            c(this.DQ);
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
        this.Tn.setData(this.mItems);
    }

    public f rX() {
        if (!this.SL) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.SI != null) {
            j.a(this.SI, this.DQ);
        } else {
            this.SI = new AlertDialog.Builder(this.DQ.getPageActivity()).create();
            this.SI.setCanceledOnTouchOutside(true);
            if (j.a(this.SI, this.DQ.getPageActivity())) {
                Window window = this.SI.getWindow();
                if (this.SZ == -1) {
                    this.SZ = a.Th;
                }
                if (this.Sx == -1) {
                    this.Sx = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.Sx);
                window.setBackgroundDrawableResource(u.f.transparent_bg);
                window.setContentView(this.SJ);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.h<?> hVar) {
        int skinType = TbadkCoreApplication.m10getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().af(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().w(this.SJ);
        }
        this.SJ.setBackgroundResource(u.f.transparent_bg);
    }

    public void dismiss() {
        if (this.SI != null) {
            j.b(this.SI, this.DQ.getPageActivity());
        }
    }
}
