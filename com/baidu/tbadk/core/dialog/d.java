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
    private BdListView JE;
    private AlertDialog abL;
    private ViewGroup abM;
    private TextView abZ;
    private View aca;
    private e acq;
    private TbPageContext<?> acr;
    private ArrayList<f> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private String mTitle;
    private int acc = -1;
    private int abA = -1;
    private boolean abO = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int ack = d.m.dialog_ani_b2t;
        public static final int acl = d.m.dialog_ani_t2b;
        public static final int acm = d.m.dialog_ani_l2r;
        public static final int acn = d.m.dialog_ani_r2l;
    }

    public d(TbPageContext<?> tbPageContext) {
        this.acr = tbPageContext;
        this.abM = (ViewGroup) LayoutInflater.from(this.acr.getPageActivity()).inflate(d.j.dialog_rich_layout, (ViewGroup) null);
        this.abZ = (TextView) this.abM.findViewById(d.h.dialog_title_list);
        this.JE = (BdListView) this.abM.findViewById(d.h.dialog_content_list);
        this.aca = this.abM.findViewById(d.h.line_bg);
        this.acq = new e(this.acr);
    }

    public d cY(String str) {
        this.mTitle = str;
        return this;
    }

    public d cl(int i) {
        return cY(this.acr.getResources().getString(i));
    }

    public d a(ArrayList<f> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
                this.JE.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public d tw() {
        if (!this.abO) {
            this.abO = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.abZ.setText(this.mTitle);
                this.abZ.setVisibility(0);
                this.aca.setVisibility(0);
            } else {
                this.abZ.setVisibility(8);
                this.aca.setVisibility(8);
            }
            this.JE.setAdapter((ListAdapter) this.acq);
            this.acq.setData(this.mItems);
            c(this.acr);
        }
        return this;
    }

    public void cm(int i) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            if (i2 == i) {
                this.mItems.get(i2).setChecked(true);
            } else {
                this.mItems.get(i2).setChecked(false);
            }
        }
        this.acq.setData(this.mItems);
    }

    public d tx() {
        if (!this.abO) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.abL != null) {
            g.a(this.abL, this.acr);
        } else {
            this.abL = new AlertDialog.Builder(this.acr.getPageActivity()).create();
            this.abL.setCanceledOnTouchOutside(true);
            if (g.a(this.abL, this.acr.getPageActivity())) {
                Window window = this.abL.getWindow();
                if (this.acc == -1) {
                    this.acc = a.ack;
                }
                if (this.abA == -1) {
                    this.abA = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.abA);
                window.setBackgroundDrawableResource(d.g.transparent_bg);
                window.setContentView(this.abM);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.e<?> eVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().ah(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().t(this.abM);
        }
        this.abM.setBackgroundResource(d.g.transparent_bg);
    }

    public void dismiss() {
        if (this.abL != null) {
            g.b(this.abL, this.acr.getPageActivity());
        }
    }
}
