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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d {
    private BdListView Hj;
    private View abL;
    private AlertDialog abx;
    private f acc;
    private TbPageContext<?> acd;
    private ArrayList<g> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private ViewGroup mRootView;
    private String mTitle;
    private TextView mTitleView;
    private int abN = -1;
    private int abl = -1;
    private boolean abz = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int abV = d.k.dialog_ani_b2t;
        public static final int abW = d.k.dialog_ani_t2b;
        public static final int abX = d.k.dialog_ani_l2r;
        public static final int abY = d.k.dialog_ani_r2l;
    }

    public d(TbPageContext<?> tbPageContext) {
        this.acd = tbPageContext;
        this.mRootView = (ViewGroup) LayoutInflater.from(this.acd.getPageActivity()).inflate(d.h.dialog_rich_layout, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.dialog_title_list);
        this.Hj = (BdListView) this.mRootView.findViewById(d.g.dialog_content_list);
        this.abL = this.mRootView.findViewById(d.g.line_bg);
        this.acc = new f(this.acd);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public d cU(String str) {
        this.mTitle = str;
        return this;
    }

    public d cm(int i) {
        return cU(this.acd.getResources().getString(i));
    }

    public d a(ArrayList<g> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
                this.Hj.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public d tp() {
        if (!this.abz) {
            this.abz = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.abL.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.abL.setVisibility(8);
            }
            this.Hj.setAdapter((ListAdapter) this.acc);
            this.acc.setData(this.mItems);
            c(this.acd);
        }
        return this;
    }

    public void cn(int i) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            if (i2 == i) {
                this.mItems.get(i2).setChecked(true);
            } else {
                this.mItems.get(i2).setChecked(false);
            }
        }
        this.acc.setData(this.mItems);
    }

    public d tq() {
        if (!this.abz) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.abx != null) {
            com.baidu.adp.lib.g.g.a(this.abx, this.acd);
        } else {
            this.abx = new AlertDialog.Builder(this.acd.getPageActivity()).create();
            this.abx.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.abx, this.acd.getPageActivity())) {
                Window window = this.abx.getWindow();
                if (this.abN == -1) {
                    this.abN = a.abV;
                }
                if (this.abl == -1) {
                    this.abl = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.abl);
                window.setBackgroundDrawableResource(d.f.transparent_bg);
                window.setContentView(this.mRootView);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.e<?> eVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().ag(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().t(this.mRootView);
        }
        this.mRootView.setBackgroundResource(d.f.transparent_bg);
    }

    public void dismiss() {
        if (this.abx != null) {
            com.baidu.adp.lib.g.g.b(this.abx, this.acd.getPageActivity());
        }
    }
}
