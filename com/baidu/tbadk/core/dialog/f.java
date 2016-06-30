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
    private TbPageContext<?> Dp;
    private g SF;
    private AlertDialog Sa;
    private ViewGroup Sb;
    private TextView So;
    private View Sp;
    private ArrayList<h> mItems;
    private String mTitle;
    private AdapterView.OnItemClickListener yQ;
    private BdListView zt;
    private int Sr = -1;
    private int RO = -1;
    private boolean Sd = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int Sz = u.k.dialog_ani_b2t;
        public static final int SA = u.k.dialog_ani_t2b;
        public static final int SB = u.k.dialog_ani_l2r;
        public static final int SC = u.k.dialog_ani_r2l;
    }

    public f(TbPageContext<?> tbPageContext) {
        this.Dp = tbPageContext;
        this.Sb = (ViewGroup) LayoutInflater.from(this.Dp.getPageActivity()).inflate(u.h.dialog_rich_layout, (ViewGroup) null);
        this.So = (TextView) this.Sb.findViewById(u.g.dialog_title_list);
        this.zt = (BdListView) this.Sb.findViewById(u.g.dialog_content_list);
        this.Sp = this.Sb.findViewById(u.g.line_bg);
        this.SF = new g(this.Dp);
    }

    public f cB(String str) {
        this.mTitle = str;
        return this;
    }

    public f bU(int i) {
        return cB(this.Dp.getResources().getString(i));
    }

    public f a(ArrayList<h> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.yQ = onItemClickListener;
                this.zt.setOnItemClickListener(this.yQ);
            }
        }
        return this;
    }

    public f rX() {
        if (!this.Sd) {
            this.Sd = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.So.setText(this.mTitle);
                this.So.setVisibility(0);
                this.Sp.setVisibility(0);
            } else {
                this.So.setVisibility(8);
                this.Sp.setVisibility(8);
            }
            this.zt.setAdapter((ListAdapter) this.SF);
            this.SF.setData(this.mItems);
            c(this.Dp);
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
        this.SF.setData(this.mItems);
    }

    public f rY() {
        if (!this.Sd) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Sa != null) {
            j.a(this.Sa, this.Dp);
        } else {
            this.Sa = new AlertDialog.Builder(this.Dp.getPageActivity()).create();
            this.Sa.setCanceledOnTouchOutside(true);
            if (j.a(this.Sa, this.Dp.getPageActivity())) {
                Window window = this.Sa.getWindow();
                if (this.Sr == -1) {
                    this.Sr = a.Sz;
                }
                if (this.RO == -1) {
                    this.RO = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.RO);
                window.setBackgroundDrawableResource(u.f.transparent_bg);
                window.setContentView(this.Sb);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.h<?> hVar) {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ad(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().w(this.Sb);
        }
        this.Sb.setBackgroundResource(u.f.transparent_bg);
    }

    public void dismiss() {
        if (this.Sa != null) {
            j.b(this.Sa, this.Dp.getPageActivity());
        }
    }
}
