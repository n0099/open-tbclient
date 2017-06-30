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
    private BdListView Ib;
    private AlertDialog ZN;
    private ViewGroup ZO;
    private TextView aab;
    private View aac;
    private g aas;
    private TbPageContext<?> aat;
    private ArrayList<h> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private String mTitle;
    private int aae = -1;
    private int ZC = -1;
    private boolean ZQ = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int aam = w.m.dialog_ani_b2t;
        public static final int aan = w.m.dialog_ani_t2b;
        public static final int aao = w.m.dialog_ani_l2r;
        public static final int aap = w.m.dialog_ani_r2l;
    }

    public f(TbPageContext<?> tbPageContext) {
        this.aat = tbPageContext;
        this.ZO = (ViewGroup) LayoutInflater.from(this.aat.getPageActivity()).inflate(w.j.dialog_rich_layout, (ViewGroup) null);
        this.aab = (TextView) this.ZO.findViewById(w.h.dialog_title_list);
        this.Ib = (BdListView) this.ZO.findViewById(w.h.dialog_content_list);
        this.aac = this.ZO.findViewById(w.h.line_bg);
        this.aas = new g(this.aat);
    }

    public f cK(String str) {
        this.mTitle = str;
        return this;
    }

    public f ch(int i) {
        return cK(this.aat.getResources().getString(i));
    }

    public f a(ArrayList<h> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
                this.Ib.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public f te() {
        if (!this.ZQ) {
            this.ZQ = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.aab.setText(this.mTitle);
                this.aab.setVisibility(0);
                this.aac.setVisibility(0);
            } else {
                this.aab.setVisibility(8);
                this.aac.setVisibility(8);
            }
            this.Ib.setAdapter((ListAdapter) this.aas);
            this.aas.setData(this.mItems);
            c(this.aat);
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
        this.aas.setData(this.mItems);
    }

    public f tf() {
        if (!this.ZQ) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.ZN != null) {
            j.a(this.ZN, this.aat);
        } else {
            this.ZN = new AlertDialog.Builder(this.aat.getPageActivity()).create();
            this.ZN.setCanceledOnTouchOutside(true);
            if (j.a(this.ZN, this.aat.getPageActivity())) {
                Window window = this.ZN.getWindow();
                if (this.aae == -1) {
                    this.aae = a.aam;
                }
                if (this.ZC == -1) {
                    this.ZC = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.ZC);
                window.setBackgroundDrawableResource(w.g.transparent_bg);
                window.setContentView(this.ZO);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.g<?> gVar) {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (gVar instanceof TbPageContext) {
            ((TbPageContext) gVar).getLayoutMode().ah(skinType == 1);
            ((TbPageContext) gVar).getLayoutMode().t(this.ZO);
        }
        this.ZO.setBackgroundResource(w.g.transparent_bg);
    }

    public void dismiss() {
        if (this.ZN != null) {
            j.b(this.ZN, this.aat.getPageActivity());
        }
    }
}
