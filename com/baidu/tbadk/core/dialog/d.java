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
    private f abH;
    private TbPageContext<?> abI;
    private AlertDialog aba;
    private View abp;
    private ArrayList<g> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private ViewGroup mRootView;
    private String mTitle;
    private TextView mTitleView;
    private int abr = -1;
    private int aaP = -1;
    private boolean abd = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int abA = d.k.dialog_ani_b2t;
        public static final int abB = d.k.dialog_ani_t2b;
        public static final int abC = d.k.dialog_ani_l2r;
        public static final int abD = d.k.dialog_ani_r2l;
    }

    public d(TbPageContext<?> tbPageContext) {
        this.abI = tbPageContext;
        this.mRootView = (ViewGroup) LayoutInflater.from(this.abI.getPageActivity()).inflate(d.h.dialog_rich_layout, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.dialog_title_list);
        this.Hj = (BdListView) this.mRootView.findViewById(d.g.dialog_content_list);
        this.abp = this.mRootView.findViewById(d.g.line_bg);
        this.abH = new f(this.abI);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public d cU(String str) {
        this.mTitle = str;
        return this;
    }

    public d cl(int i) {
        return cU(this.abI.getResources().getString(i));
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

    public d tm() {
        if (!this.abd) {
            this.abd = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.abp.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.abp.setVisibility(8);
            }
            this.Hj.setAdapter((ListAdapter) this.abH);
            this.abH.setData(this.mItems);
            c(this.abI);
        }
        return this;
    }

    public void cm(int i) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            if (i2 == i) {
                this.mItems.get(i2).setChecked(true);
            } else {
                this.mItems.get(i2).setChecked(false);
            }
        }
        this.abH.setData(this.mItems);
    }

    public d tn() {
        if (!this.abd) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aba != null) {
            com.baidu.adp.lib.g.g.a(this.aba, this.abI);
        } else {
            this.aba = new AlertDialog.Builder(this.abI.getPageActivity()).create();
            this.aba.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.aba, this.abI.getPageActivity())) {
                Window window = this.aba.getWindow();
                if (this.abr == -1) {
                    this.abr = a.abA;
                }
                if (this.aaP == -1) {
                    this.aaP = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.aaP);
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
        if (this.aba != null) {
            com.baidu.adp.lib.g.g.b(this.aba, this.abI.getPageActivity());
        }
    }
}
