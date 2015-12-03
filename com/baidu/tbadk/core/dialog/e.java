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
import com.baidu.adp.base.h;
import com.baidu.adp.lib.h.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e {
    private AdapterView.OnItemClickListener HP;
    private TextView XE;
    private View XF;
    private f XP;
    private AlertDialog Xo;
    private TbPageContext<?> mContext;
    private ArrayList<g> mItems;
    private BdListView mListView;
    private ViewGroup mRootView;
    private String mTitle;
    private int XH = -1;
    private int Xe = -1;
    private boolean Xq = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int XL = n.j.dialog_ani_b2t;
        public static final int XM = n.j.dialog_ani_t2b;
        public static final int XN = n.j.dialog_ani_l2r;
        public static final int XO = n.j.dialog_ani_r2l;
    }

    public e(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.g.dialog_rich_layout, (ViewGroup) null);
        this.XE = (TextView) this.mRootView.findViewById(n.f.dialog_title_list);
        this.mListView = (BdListView) this.mRootView.findViewById(n.f.dialog_content_list);
        this.XF = this.mRootView.findViewById(n.f.line_bg);
        this.XP = new f(this.mContext);
    }

    public e cE(String str) {
        this.mTitle = str;
        return this;
    }

    public e bV(int i) {
        return cE(this.mContext.getResources().getString(i));
    }

    public e a(ArrayList<g> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.HP = onItemClickListener;
                this.mListView.setOnItemClickListener(this.HP);
            }
        }
        return this;
    }

    public e tA() {
        if (!this.Xq) {
            this.Xq = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.XE.setText(this.mTitle);
                this.XE.setVisibility(0);
                this.XF.setVisibility(0);
            } else {
                this.XE.setVisibility(8);
                this.XF.setVisibility(8);
            }
            this.mListView.setAdapter((ListAdapter) this.XP);
            this.XP.setData(this.mItems);
            c(this.mContext);
        }
        return this;
    }

    public void bW(int i) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            if (i2 == i) {
                this.mItems.get(i2).setChecked(true);
            } else {
                this.mItems.get(i2).setChecked(false);
            }
        }
        this.XP.setData(this.mItems);
    }

    public e tB() {
        if (!this.Xq) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Xo != null) {
            j.a(this.Xo, this.mContext);
        } else {
            this.Xo = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
            this.Xo.setCanceledOnTouchOutside(true);
            if (j.a(this.Xo, this.mContext.getPageActivity())) {
                Window window = this.Xo.getWindow();
                if (this.XH == -1) {
                    this.XH = a.XL;
                }
                if (this.Xe == -1) {
                    this.Xe = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.Xe);
                window.setBackgroundDrawableResource(n.e.transparent_bg);
                window.setContentView(this.mRootView);
            }
        }
        return this;
    }

    private void c(h<?> hVar) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().af(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().k(this.mRootView);
        }
        this.mRootView.setBackgroundResource(n.e.transparent_bg);
    }

    public void dismiss() {
        if (this.Xo != null) {
            j.b(this.Xo, this.mContext.getPageActivity());
        }
    }
}
