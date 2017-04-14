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
    private BdListView Ik;
    private TextView aaF;
    private View aaG;
    private g aaW;
    private TbPageContext<?> aaX;
    private AlertDialog aar;
    private ViewGroup aas;
    private ArrayList<h> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private String mTitle;
    private int aaI = -1;
    private int aag = -1;
    private boolean aau = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int aaQ = w.m.dialog_ani_b2t;
        public static final int aaR = w.m.dialog_ani_t2b;
        public static final int aaS = w.m.dialog_ani_l2r;
        public static final int aaT = w.m.dialog_ani_r2l;
    }

    public f(TbPageContext<?> tbPageContext) {
        this.aaX = tbPageContext;
        this.aas = (ViewGroup) LayoutInflater.from(this.aaX.getPageActivity()).inflate(w.j.dialog_rich_layout, (ViewGroup) null);
        this.aaF = (TextView) this.aas.findViewById(w.h.dialog_title_list);
        this.Ik = (BdListView) this.aas.findViewById(w.h.dialog_content_list);
        this.aaG = this.aas.findViewById(w.h.line_bg);
        this.aaW = new g(this.aaX);
    }

    public f cG(String str) {
        this.mTitle = str;
        return this;
    }

    public f ci(int i) {
        return cG(this.aaX.getResources().getString(i));
    }

    public f a(ArrayList<h> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
                this.Ik.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public f tU() {
        if (!this.aau) {
            this.aau = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.aaF.setText(this.mTitle);
                this.aaF.setVisibility(0);
                this.aaG.setVisibility(0);
            } else {
                this.aaF.setVisibility(8);
                this.aaG.setVisibility(8);
            }
            this.Ik.setAdapter((ListAdapter) this.aaW);
            this.aaW.setData(this.mItems);
            c(this.aaX);
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
        this.aaW.setData(this.mItems);
    }

    public f tV() {
        if (!this.aau) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aar != null) {
            j.a(this.aar, this.aaX);
        } else {
            this.aar = new AlertDialog.Builder(this.aaX.getPageActivity()).create();
            this.aar.setCanceledOnTouchOutside(true);
            if (j.a(this.aar, this.aaX.getPageActivity())) {
                Window window = this.aar.getWindow();
                if (this.aaI == -1) {
                    this.aaI = a.aaQ;
                }
                if (this.aag == -1) {
                    this.aag = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.aag);
                window.setBackgroundDrawableResource(w.g.transparent_bg);
                window.setContentView(this.aas);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.g<?> gVar) {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (gVar instanceof TbPageContext) {
            ((TbPageContext) gVar).getLayoutMode().aj(skinType == 1);
            ((TbPageContext) gVar).getLayoutMode().t(this.aas);
        }
        this.aas.setBackgroundResource(w.g.transparent_bg);
    }

    public void dismiss() {
        if (this.aar != null) {
            j.b(this.aar, this.aaX.getPageActivity());
        }
    }
}
