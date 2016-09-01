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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f {
    private AdapterView.OnItemClickListener BG;
    private BdListView Cj;
    private TbPageContext<?> Gd;
    private TextView VM;
    private View VN;
    private AlertDialog Vy;
    private ViewGroup Vz;
    private g Wd;
    private ArrayList<h> mItems;
    private String mTitle;
    private int VP = -1;
    private int Vn = -1;
    private boolean VB = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int VX = t.k.dialog_ani_b2t;
        public static final int VY = t.k.dialog_ani_t2b;
        public static final int VZ = t.k.dialog_ani_l2r;
        public static final int Wa = t.k.dialog_ani_r2l;
    }

    public f(TbPageContext<?> tbPageContext) {
        this.Gd = tbPageContext;
        this.Vz = (ViewGroup) LayoutInflater.from(this.Gd.getPageActivity()).inflate(t.h.dialog_rich_layout, (ViewGroup) null);
        this.VM = (TextView) this.Vz.findViewById(t.g.dialog_title_list);
        this.Cj = (BdListView) this.Vz.findViewById(t.g.dialog_content_list);
        this.VN = this.Vz.findViewById(t.g.line_bg);
        this.Wd = new g(this.Gd);
    }

    public f cD(String str) {
        this.mTitle = str;
        return this;
    }

    public f ch(int i) {
        return cD(this.Gd.getResources().getString(i));
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

    public f tb() {
        if (!this.VB) {
            this.VB = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.VM.setText(this.mTitle);
                this.VM.setVisibility(0);
                this.VN.setVisibility(0);
            } else {
                this.VM.setVisibility(8);
                this.VN.setVisibility(8);
            }
            this.Cj.setAdapter((ListAdapter) this.Wd);
            this.Wd.setData(this.mItems);
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
        this.Wd.setData(this.mItems);
    }

    public f tc() {
        if (!this.VB) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Vy != null) {
            j.a(this.Vy, this.Gd);
        } else {
            this.Vy = new AlertDialog.Builder(this.Gd.getPageActivity()).create();
            this.Vy.setCanceledOnTouchOutside(true);
            if (j.a(this.Vy, this.Gd.getPageActivity())) {
                Window window = this.Vy.getWindow();
                if (this.VP == -1) {
                    this.VP = a.VX;
                }
                if (this.Vn == -1) {
                    this.Vn = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.Vn);
                window.setBackgroundDrawableResource(t.f.transparent_bg);
                window.setContentView(this.Vz);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.h<?> hVar) {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ah(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this.Vz);
        }
        this.Vz.setBackgroundResource(t.f.transparent_bg);
    }

    public void dismiss() {
        if (this.Vy != null) {
            j.b(this.Vy, this.Gd.getPageActivity());
        }
    }
}
