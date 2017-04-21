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
import com.baidu.adp.lib.g.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f {
    private BdListView Im;
    private TextView aaG;
    private View aaH;
    private g aaX;
    private TbPageContext<?> aaY;
    private AlertDialog aas;
    private ViewGroup aat;
    private ArrayList<h> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private String mTitle;
    private int aaJ = -1;
    private int aah = -1;
    private boolean aav = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int aaR = w.m.dialog_ani_b2t;
        public static final int aaS = w.m.dialog_ani_t2b;
        public static final int aaT = w.m.dialog_ani_l2r;
        public static final int aaU = w.m.dialog_ani_r2l;
    }

    public f(TbPageContext<?> tbPageContext) {
        this.aaY = tbPageContext;
        this.aat = (ViewGroup) LayoutInflater.from(this.aaY.getPageActivity()).inflate(w.j.dialog_rich_layout, (ViewGroup) null);
        this.aaG = (TextView) this.aat.findViewById(w.h.dialog_title_list);
        this.Im = (BdListView) this.aat.findViewById(w.h.dialog_content_list);
        this.aaH = this.aat.findViewById(w.h.line_bg);
        this.aaX = new g(this.aaY);
    }

    public f cG(String str) {
        this.mTitle = str;
        return this;
    }

    public f ci(int i) {
        return cG(this.aaY.getResources().getString(i));
    }

    public f a(ArrayList<h> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
                this.Im.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public f tU() {
        if (!this.aav) {
            this.aav = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.aaG.setText(this.mTitle);
                this.aaG.setVisibility(0);
                this.aaH.setVisibility(0);
            } else {
                this.aaG.setVisibility(8);
                this.aaH.setVisibility(8);
            }
            this.Im.setAdapter((ListAdapter) this.aaX);
            this.aaX.setData(this.mItems);
            c(this.aaY);
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
        this.aaX.setData(this.mItems);
    }

    public f tV() {
        if (!this.aav) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aas != null) {
            j.a(this.aas, this.aaY);
        } else {
            this.aas = new AlertDialog.Builder(this.aaY.getPageActivity()).create();
            this.aas.setCanceledOnTouchOutside(true);
            if (j.a(this.aas, this.aaY.getPageActivity())) {
                Window window = this.aas.getWindow();
                if (this.aaJ == -1) {
                    this.aaJ = a.aaR;
                }
                if (this.aah == -1) {
                    this.aah = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.aah);
                window.setBackgroundDrawableResource(w.g.transparent_bg);
                window.setContentView(this.aat);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.g<?> gVar) {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (gVar instanceof TbPageContext) {
            ((TbPageContext) gVar).getLayoutMode().aj(skinType == 1);
            ((TbPageContext) gVar).getLayoutMode().t(this.aat);
        }
        this.aat.setBackgroundResource(w.g.transparent_bg);
    }

    public void dismiss() {
        if (this.aas != null) {
            j.b(this.aas, this.aaY.getPageActivity());
        }
    }
}
