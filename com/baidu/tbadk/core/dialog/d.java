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
    private BdListView Hw;
    private AlertDialog aaP;
    private ViewGroup aaQ;
    private TextView abe;
    private View abf;
    private e abx;
    private TbPageContext<?> aby;
    private ArrayList<f> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private String mTitle;
    private int abh = -1;
    private int aaE = -1;
    private boolean aaS = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int abp = d.m.dialog_ani_b2t;
        public static final int abq = d.m.dialog_ani_t2b;
        public static final int abr = d.m.dialog_ani_l2r;
        public static final int abt = d.m.dialog_ani_r2l;
    }

    public d(TbPageContext<?> tbPageContext) {
        this.aby = tbPageContext;
        this.aaQ = (ViewGroup) LayoutInflater.from(this.aby.getPageActivity()).inflate(d.j.dialog_rich_layout, (ViewGroup) null);
        this.abe = (TextView) this.aaQ.findViewById(d.h.dialog_title_list);
        this.Hw = (BdListView) this.aaQ.findViewById(d.h.dialog_content_list);
        this.abf = this.aaQ.findViewById(d.h.line_bg);
        this.abx = new e(this.aby);
    }

    public d cO(String str) {
        this.mTitle = str;
        return this;
    }

    public d cl(int i) {
        return cO(this.aby.getResources().getString(i));
    }

    public d a(ArrayList<f> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
                this.Hw.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public d ts() {
        if (!this.aaS) {
            this.aaS = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.abe.setText(this.mTitle);
                this.abe.setVisibility(0);
                this.abf.setVisibility(0);
            } else {
                this.abe.setVisibility(8);
                this.abf.setVisibility(8);
            }
            this.Hw.setAdapter((ListAdapter) this.abx);
            this.abx.setData(this.mItems);
            c(this.aby);
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
        this.abx.setData(this.mItems);
    }

    public d tt() {
        if (!this.aaS) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aaP != null) {
            g.a(this.aaP, this.aby);
        } else {
            this.aaP = new AlertDialog.Builder(this.aby.getPageActivity()).create();
            this.aaP.setCanceledOnTouchOutside(true);
            if (g.a(this.aaP, this.aby.getPageActivity())) {
                Window window = this.aaP.getWindow();
                if (this.abh == -1) {
                    this.abh = a.abp;
                }
                if (this.aaE == -1) {
                    this.aaE = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.aaE);
                window.setBackgroundDrawableResource(d.g.transparent_bg);
                window.setContentView(this.aaQ);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.e<?> eVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().ah(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().t(this.aaQ);
        }
        this.aaQ.setBackgroundResource(d.g.transparent_bg);
    }

    public void dismiss() {
        if (this.aaP != null) {
            g.b(this.aaP, this.aby.getPageActivity());
        }
    }
}
