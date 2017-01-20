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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f {
    private BdListView Bw;
    private TbPageContext<?> Fp;
    private AlertDialog UQ;
    private ViewGroup UR;
    private TextView Ve;
    private View Vf;
    private g Vv;
    private ArrayList<h> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private String mTitle;
    private int Vh = -1;
    private int UE = -1;
    private boolean UT = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int Vp = r.m.dialog_ani_b2t;
        public static final int Vq = r.m.dialog_ani_t2b;
        public static final int Vr = r.m.dialog_ani_l2r;
        public static final int Vs = r.m.dialog_ani_r2l;
    }

    public f(TbPageContext<?> tbPageContext) {
        this.Fp = tbPageContext;
        this.UR = (ViewGroup) LayoutInflater.from(this.Fp.getPageActivity()).inflate(r.j.dialog_rich_layout, (ViewGroup) null);
        this.Ve = (TextView) this.UR.findViewById(r.h.dialog_title_list);
        this.Bw = (BdListView) this.UR.findViewById(r.h.dialog_content_list);
        this.Vf = this.UR.findViewById(r.h.line_bg);
        this.Vv = new g(this.Fp);
    }

    public f cG(String str) {
        this.mTitle = str;
        return this;
    }

    public f cj(int i) {
        return cG(this.Fp.getResources().getString(i));
    }

    public f a(ArrayList<h> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
                this.Bw.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public f sZ() {
        if (!this.UT) {
            this.UT = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.Ve.setText(this.mTitle);
                this.Ve.setVisibility(0);
                this.Vf.setVisibility(0);
            } else {
                this.Ve.setVisibility(8);
                this.Vf.setVisibility(8);
            }
            this.Bw.setAdapter((ListAdapter) this.Vv);
            this.Vv.setData(this.mItems);
            c(this.Fp);
        }
        return this;
    }

    public void ck(int i) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            if (i2 == i) {
                this.mItems.get(i2).setChecked(true);
            } else {
                this.mItems.get(i2).setChecked(false);
            }
        }
        this.Vv.setData(this.mItems);
    }

    public f ta() {
        if (!this.UT) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.UQ != null) {
            j.a(this.UQ, this.Fp);
        } else {
            this.UQ = new AlertDialog.Builder(this.Fp.getPageActivity()).create();
            this.UQ.setCanceledOnTouchOutside(true);
            if (j.a(this.UQ, this.Fp.getPageActivity())) {
                Window window = this.UQ.getWindow();
                if (this.Vh == -1) {
                    this.Vh = a.Vp;
                }
                if (this.UE == -1) {
                    this.UE = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.UE);
                window.setBackgroundDrawableResource(r.g.transparent_bg);
                window.setContentView(this.UR);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.g<?> gVar) {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (gVar instanceof TbPageContext) {
            ((TbPageContext) gVar).getLayoutMode().ai(skinType == 1);
            ((TbPageContext) gVar).getLayoutMode().v(this.UR);
        }
        this.UR.setBackgroundResource(r.g.transparent_bg);
    }

    public void dismiss() {
        if (this.UQ != null) {
            j.b(this.UQ, this.Fp.getPageActivity());
        }
    }
}
