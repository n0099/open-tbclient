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
    private BdListView Ib;
    private TextView aaA;
    private View aaB;
    private e aaR;
    private TbPageContext<?> aaS;
    private AlertDialog aam;
    private ViewGroup aan;
    private ArrayList<f> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private String mTitle;
    private int aaD = -1;
    private int aab = -1;
    private boolean aap = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int aaL = d.m.dialog_ani_b2t;
        public static final int aaM = d.m.dialog_ani_t2b;
        public static final int aaN = d.m.dialog_ani_l2r;
        public static final int aaO = d.m.dialog_ani_r2l;
    }

    public d(TbPageContext<?> tbPageContext) {
        this.aaS = tbPageContext;
        this.aan = (ViewGroup) LayoutInflater.from(this.aaS.getPageActivity()).inflate(d.j.dialog_rich_layout, (ViewGroup) null);
        this.aaA = (TextView) this.aan.findViewById(d.h.dialog_title_list);
        this.Ib = (BdListView) this.aan.findViewById(d.h.dialog_content_list);
        this.aaB = this.aan.findViewById(d.h.line_bg);
        this.aaR = new e(this.aaS);
    }

    public d cP(String str) {
        this.mTitle = str;
        return this;
    }

    public d cj(int i) {
        return cP(this.aaS.getResources().getString(i));
    }

    public d a(ArrayList<f> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
                this.Ib.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public d tl() {
        if (!this.aap) {
            this.aap = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.aaA.setText(this.mTitle);
                this.aaA.setVisibility(0);
                this.aaB.setVisibility(0);
            } else {
                this.aaA.setVisibility(8);
                this.aaB.setVisibility(8);
            }
            this.Ib.setAdapter((ListAdapter) this.aaR);
            this.aaR.setData(this.mItems);
            c(this.aaS);
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
        this.aaR.setData(this.mItems);
    }

    public d tm() {
        if (!this.aap) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aam != null) {
            g.a(this.aam, this.aaS);
        } else {
            this.aam = new AlertDialog.Builder(this.aaS.getPageActivity()).create();
            this.aam.setCanceledOnTouchOutside(true);
            if (g.a(this.aam, this.aaS.getPageActivity())) {
                Window window = this.aam.getWindow();
                if (this.aaD == -1) {
                    this.aaD = a.aaL;
                }
                if (this.aab == -1) {
                    this.aab = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.aab);
                window.setBackgroundDrawableResource(d.g.transparent_bg);
                window.setContentView(this.aan);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.e<?> eVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().ah(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().t(this.aan);
        }
        this.aan.setBackgroundResource(d.g.transparent_bg);
    }

    public void dismiss() {
        if (this.aam != null) {
            g.b(this.aam, this.aaS.getPageActivity());
        }
    }
}
