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
    private BdListView IK;
    private g aaH;
    private TbPageContext<?> aaI;
    private AlertDialog aab;
    private ViewGroup aac;
    private TextView aap;
    private View aaq;
    private ArrayList<h> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private String mTitle;
    private int aas = -1;
    private int ZQ = -1;
    private boolean aae = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int aaA = w.m.dialog_ani_b2t;
        public static final int aaB = w.m.dialog_ani_t2b;
        public static final int aaC = w.m.dialog_ani_l2r;
        public static final int aaD = w.m.dialog_ani_r2l;
    }

    public f(TbPageContext<?> tbPageContext) {
        this.aaI = tbPageContext;
        this.aac = (ViewGroup) LayoutInflater.from(this.aaI.getPageActivity()).inflate(w.j.dialog_rich_layout, (ViewGroup) null);
        this.aap = (TextView) this.aac.findViewById(w.h.dialog_title_list);
        this.IK = (BdListView) this.aac.findViewById(w.h.dialog_content_list);
        this.aaq = this.aac.findViewById(w.h.line_bg);
        this.aaH = new g(this.aaI);
    }

    public f cz(String str) {
        this.mTitle = str;
        return this;
    }

    public f cf(int i) {
        return cz(this.aaI.getResources().getString(i));
    }

    public f a(ArrayList<h> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
                this.IK.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public f tw() {
        if (!this.aae) {
            this.aae = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.aap.setText(this.mTitle);
                this.aap.setVisibility(0);
                this.aaq.setVisibility(0);
            } else {
                this.aap.setVisibility(8);
                this.aaq.setVisibility(8);
            }
            this.IK.setAdapter((ListAdapter) this.aaH);
            this.aaH.setData(this.mItems);
            c(this.aaI);
        }
        return this;
    }

    public void cg(int i) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            if (i2 == i) {
                this.mItems.get(i2).setChecked(true);
            } else {
                this.mItems.get(i2).setChecked(false);
            }
        }
        this.aaH.setData(this.mItems);
    }

    public f tx() {
        if (!this.aae) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aab != null) {
            j.a(this.aab, this.aaI);
        } else {
            this.aab = new AlertDialog.Builder(this.aaI.getPageActivity()).create();
            this.aab.setCanceledOnTouchOutside(true);
            if (j.a(this.aab, this.aaI.getPageActivity())) {
                Window window = this.aab.getWindow();
                if (this.aas == -1) {
                    this.aas = a.aaA;
                }
                if (this.ZQ == -1) {
                    this.ZQ = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.ZQ);
                window.setBackgroundDrawableResource(w.g.transparent_bg);
                window.setContentView(this.aac);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.g<?> gVar) {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (gVar instanceof TbPageContext) {
            ((TbPageContext) gVar).getLayoutMode().ah(skinType == 1);
            ((TbPageContext) gVar).getLayoutMode().t(this.aac);
        }
        this.aac.setBackgroundResource(w.g.transparent_bg);
    }

    public void dismiss() {
        if (this.aab != null) {
            j.b(this.aab, this.aaI.getPageActivity());
        }
    }
}
