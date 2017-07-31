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
    private BdListView JC;
    private AlertDialog abJ;
    private ViewGroup abK;
    private TextView abX;
    private View abY;
    private e aco;
    private TbPageContext<?> acp;
    private ArrayList<f> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private String mTitle;
    private int aca = -1;
    private int aby = -1;
    private boolean abM = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int aci = d.m.dialog_ani_b2t;
        public static final int acj = d.m.dialog_ani_t2b;
        public static final int ack = d.m.dialog_ani_l2r;
        public static final int acl = d.m.dialog_ani_r2l;
    }

    public d(TbPageContext<?> tbPageContext) {
        this.acp = tbPageContext;
        this.abK = (ViewGroup) LayoutInflater.from(this.acp.getPageActivity()).inflate(d.j.dialog_rich_layout, (ViewGroup) null);
        this.abX = (TextView) this.abK.findViewById(d.h.dialog_title_list);
        this.JC = (BdListView) this.abK.findViewById(d.h.dialog_content_list);
        this.abY = this.abK.findViewById(d.h.line_bg);
        this.aco = new e(this.acp);
    }

    public d cV(String str) {
        this.mTitle = str;
        return this;
    }

    public d cl(int i) {
        return cV(this.acp.getResources().getString(i));
    }

    public d a(ArrayList<f> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
                this.JC.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public d tv() {
        if (!this.abM) {
            this.abM = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.abX.setText(this.mTitle);
                this.abX.setVisibility(0);
                this.abY.setVisibility(0);
            } else {
                this.abX.setVisibility(8);
                this.abY.setVisibility(8);
            }
            this.JC.setAdapter((ListAdapter) this.aco);
            this.aco.setData(this.mItems);
            c(this.acp);
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
        this.aco.setData(this.mItems);
    }

    public d tw() {
        if (!this.abM) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.abJ != null) {
            g.a(this.abJ, this.acp);
        } else {
            this.abJ = new AlertDialog.Builder(this.acp.getPageActivity()).create();
            this.abJ.setCanceledOnTouchOutside(true);
            if (g.a(this.abJ, this.acp.getPageActivity())) {
                Window window = this.abJ.getWindow();
                if (this.aca == -1) {
                    this.aca = a.aci;
                }
                if (this.aby == -1) {
                    this.aby = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.aby);
                window.setBackgroundDrawableResource(d.g.transparent_bg);
                window.setContentView(this.abK);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.e<?> eVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().ah(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().t(this.abK);
        }
        this.abK.setBackgroundResource(d.g.transparent_bg);
    }

    public void dismiss() {
        if (this.abJ != null) {
            g.b(this.abJ, this.acp.getPageActivity());
        }
    }
}
