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
    private BdListView IY;
    private AdapterView.OnItemClickListener Is;
    private TbPageContext<?> MR;
    private g YI;
    private AlertDialog Yd;
    private ViewGroup Ye;
    private TextView Yu;
    private View Yv;
    private ArrayList<h> mItems;
    private String mTitle;
    private int Yx = -1;
    private int XS = -1;
    private boolean Yg = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int YC = t.k.dialog_ani_b2t;
        public static final int YD = t.k.dialog_ani_t2b;
        public static final int YE = t.k.dialog_ani_l2r;
        public static final int YF = t.k.dialog_ani_r2l;
    }

    public f(TbPageContext<?> tbPageContext) {
        this.MR = tbPageContext;
        this.Ye = (ViewGroup) LayoutInflater.from(this.MR.getPageActivity()).inflate(t.h.dialog_rich_layout, (ViewGroup) null);
        this.Yu = (TextView) this.Ye.findViewById(t.g.dialog_title_list);
        this.IY = (BdListView) this.Ye.findViewById(t.g.dialog_content_list);
        this.Yv = this.Ye.findViewById(t.g.line_bg);
        this.YI = new g(this.MR);
    }

    public f cG(String str) {
        this.mTitle = str;
        return this;
    }

    public f ch(int i) {
        return cG(this.MR.getResources().getString(i));
    }

    public f a(ArrayList<h> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.Is = onItemClickListener;
                this.IY.setOnItemClickListener(this.Is);
            }
        }
        return this;
    }

    public f uo() {
        if (!this.Yg) {
            this.Yg = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.Yu.setText(this.mTitle);
                this.Yu.setVisibility(0);
                this.Yv.setVisibility(0);
            } else {
                this.Yu.setVisibility(8);
                this.Yv.setVisibility(8);
            }
            this.IY.setAdapter((ListAdapter) this.YI);
            this.YI.setData(this.mItems);
            c(this.MR);
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
        this.YI.setData(this.mItems);
    }

    public f up() {
        if (!this.Yg) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Yd != null) {
            j.a(this.Yd, this.MR);
        } else {
            this.Yd = new AlertDialog.Builder(this.MR.getPageActivity()).create();
            this.Yd.setCanceledOnTouchOutside(true);
            if (j.a(this.Yd, this.MR.getPageActivity())) {
                Window window = this.Yd.getWindow();
                if (this.Yx == -1) {
                    this.Yx = a.YC;
                }
                if (this.XS == -1) {
                    this.XS = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.XS);
                window.setBackgroundDrawableResource(t.f.transparent_bg);
                window.setContentView(this.Ye);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.h<?> hVar) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ac(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this.Ye);
        }
        this.Ye.setBackgroundResource(t.f.transparent_bg);
    }

    public void dismiss() {
        if (this.Yd != null) {
            j.b(this.Yd, this.MR.getPageActivity());
        }
    }
}
