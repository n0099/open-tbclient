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
import com.baidu.adp.lib.g.g;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d {
    private BdListView HO;
    private AlertDialog aaD;
    private ViewGroup aaE;
    private TextView aaS;
    private View aaT;
    private e abl;
    private TbPageContext<?> abm;
    private ArrayList<f> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private String mTitle;
    private int aaV = -1;
    private int aas = -1;
    private boolean aaG = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int abe = d.m.dialog_ani_b2t;
        public static final int abf = d.m.dialog_ani_t2b;
        public static final int abg = d.m.dialog_ani_l2r;
        public static final int abh = d.m.dialog_ani_r2l;
    }

    public d(TbPageContext<?> tbPageContext) {
        this.abm = tbPageContext;
        this.aaE = (ViewGroup) LayoutInflater.from(this.abm.getPageActivity()).inflate(d.j.dialog_rich_layout, (ViewGroup) null);
        this.aaS = (TextView) this.aaE.findViewById(d.h.dialog_title_list);
        this.HO = (BdListView) this.aaE.findViewById(d.h.dialog_content_list);
        this.aaT = this.aaE.findViewById(d.h.line_bg);
        this.abl = new e(this.abm);
    }

    public d cN(String str) {
        this.mTitle = str;
        return this;
    }

    public d ck(int i) {
        return cN(this.abm.getResources().getString(i));
    }

    public d a(ArrayList<f> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
                this.HO.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public d tf() {
        if (!this.aaG) {
            this.aaG = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.aaS.setText(this.mTitle);
                this.aaS.setVisibility(0);
                this.aaT.setVisibility(0);
            } else {
                this.aaS.setVisibility(8);
                this.aaT.setVisibility(8);
            }
            this.HO.setAdapter((ListAdapter) this.abl);
            this.abl.setData(this.mItems);
            c(this.abm);
        }
        return this;
    }

    public void cl(int i) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            if (i2 == i) {
                this.mItems.get(i2).setChecked(true);
            } else {
                this.mItems.get(i2).setChecked(false);
            }
        }
        this.abl.setData(this.mItems);
    }

    public d tg() {
        if (!this.aaG) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aaD != null) {
            g.a(this.aaD, this.abm);
        } else {
            this.aaD = new AlertDialog.Builder(this.abm.getPageActivity()).create();
            this.aaD.setCanceledOnTouchOutside(true);
            if (g.a(this.aaD, this.abm.getPageActivity())) {
                Window window = this.aaD.getWindow();
                if (this.aaV == -1) {
                    this.aaV = a.abe;
                }
                if (this.aas == -1) {
                    this.aas = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.aas);
                window.setBackgroundDrawableResource(d.g.transparent_bg);
                window.setContentView(this.aaE);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.e<?> eVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().ah(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().t(this.aaE);
        }
        this.aaE.setBackgroundResource(d.g.transparent_bg);
    }

    public void dismiss() {
        if (this.aaD != null) {
            g.b(this.aaD, this.abm.getPageActivity());
        }
    }
}
