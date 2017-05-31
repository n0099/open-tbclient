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
    private BdListView Ic;
    private AlertDialog ZM;
    private ViewGroup ZN;
    private TextView aaa;
    private View aab;
    private g aar;
    private TbPageContext<?> aas;
    private ArrayList<h> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private String mTitle;
    private int aad = -1;
    private int ZB = -1;
    private boolean ZP = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int aal = w.m.dialog_ani_b2t;
        public static final int aam = w.m.dialog_ani_t2b;
        public static final int aan = w.m.dialog_ani_l2r;
        public static final int aao = w.m.dialog_ani_r2l;
    }

    public f(TbPageContext<?> tbPageContext) {
        this.aas = tbPageContext;
        this.ZN = (ViewGroup) LayoutInflater.from(this.aas.getPageActivity()).inflate(w.j.dialog_rich_layout, (ViewGroup) null);
        this.aaa = (TextView) this.ZN.findViewById(w.h.dialog_title_list);
        this.Ic = (BdListView) this.ZN.findViewById(w.h.dialog_content_list);
        this.aab = this.ZN.findViewById(w.h.line_bg);
        this.aar = new g(this.aas);
    }

    public f cD(String str) {
        this.mTitle = str;
        return this;
    }

    public f ch(int i) {
        return cD(this.aas.getResources().getString(i));
    }

    public f a(ArrayList<h> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
                this.Ic.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public f tg() {
        if (!this.ZP) {
            this.ZP = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.aaa.setText(this.mTitle);
                this.aaa.setVisibility(0);
                this.aab.setVisibility(0);
            } else {
                this.aaa.setVisibility(8);
                this.aab.setVisibility(8);
            }
            this.Ic.setAdapter((ListAdapter) this.aar);
            this.aar.setData(this.mItems);
            c(this.aas);
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
        this.aar.setData(this.mItems);
    }

    public f th() {
        if (!this.ZP) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.ZM != null) {
            j.a(this.ZM, this.aas);
        } else {
            this.ZM = new AlertDialog.Builder(this.aas.getPageActivity()).create();
            this.ZM.setCanceledOnTouchOutside(true);
            if (j.a(this.ZM, this.aas.getPageActivity())) {
                Window window = this.ZM.getWindow();
                if (this.aad == -1) {
                    this.aad = a.aal;
                }
                if (this.ZB == -1) {
                    this.ZB = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.ZB);
                window.setBackgroundDrawableResource(w.g.transparent_bg);
                window.setContentView(this.ZN);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.g<?> gVar) {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (gVar instanceof TbPageContext) {
            ((TbPageContext) gVar).getLayoutMode().ah(skinType == 1);
            ((TbPageContext) gVar).getLayoutMode().t(this.ZN);
        }
        this.ZN.setBackgroundResource(w.g.transparent_bg);
    }

    public void dismiss() {
        if (this.ZM != null) {
            j.b(this.ZM, this.aas.getPageActivity());
        }
    }
}
