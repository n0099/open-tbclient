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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f {
    private AdapterView.OnItemClickListener BH;
    private BdListView Ck;
    private TbPageContext<?> Gf;
    private AlertDialog VA;
    private ViewGroup VB;
    private TextView VO;
    private View VP;
    private g Wf;
    private ArrayList<h> mItems;
    private String mTitle;
    private int VR = -1;
    private int Vp = -1;
    private boolean VD = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int VZ = r.k.dialog_ani_b2t;
        public static final int Wa = r.k.dialog_ani_t2b;
        public static final int Wb = r.k.dialog_ani_l2r;
        public static final int Wc = r.k.dialog_ani_r2l;
    }

    public f(TbPageContext<?> tbPageContext) {
        this.Gf = tbPageContext;
        this.VB = (ViewGroup) LayoutInflater.from(this.Gf.getPageActivity()).inflate(r.h.dialog_rich_layout, (ViewGroup) null);
        this.VO = (TextView) this.VB.findViewById(r.g.dialog_title_list);
        this.Ck = (BdListView) this.VB.findViewById(r.g.dialog_content_list);
        this.VP = this.VB.findViewById(r.g.line_bg);
        this.Wf = new g(this.Gf);
    }

    public f cI(String str) {
        this.mTitle = str;
        return this;
    }

    public f ck(int i) {
        return cI(this.Gf.getResources().getString(i));
    }

    public f a(ArrayList<h> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.BH = onItemClickListener;
                this.Ck.setOnItemClickListener(this.BH);
            }
        }
        return this;
    }

    public f tf() {
        if (!this.VD) {
            this.VD = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.VO.setText(this.mTitle);
                this.VO.setVisibility(0);
                this.VP.setVisibility(0);
            } else {
                this.VO.setVisibility(8);
                this.VP.setVisibility(8);
            }
            this.Ck.setAdapter((ListAdapter) this.Wf);
            this.Wf.setData(this.mItems);
            c(this.Gf);
        }
        return this;
    }

    public void cl(int i) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            if (i2 == i) {
                this.mItems.get(i2).setChecked(true);
            } else {
                this.mItems.get(i2).setChecked(false);
            }
        }
        this.Wf.setData(this.mItems);
    }

    public f tg() {
        if (!this.VD) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.VA != null) {
            j.a(this.VA, this.Gf);
        } else {
            this.VA = new AlertDialog.Builder(this.Gf.getPageActivity()).create();
            this.VA.setCanceledOnTouchOutside(true);
            if (j.a(this.VA, this.Gf.getPageActivity())) {
                Window window = this.VA.getWindow();
                if (this.VR == -1) {
                    this.VR = a.VZ;
                }
                if (this.Vp == -1) {
                    this.Vp = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.Vp);
                window.setBackgroundDrawableResource(r.f.transparent_bg);
                window.setContentView(this.VB);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.h<?> hVar) {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ai(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this.VB);
        }
        this.VB.setBackgroundResource(r.f.transparent_bg);
    }

    public void dismiss() {
        if (this.VA != null) {
            j.b(this.VA, this.Gf.getPageActivity());
        }
    }
}
