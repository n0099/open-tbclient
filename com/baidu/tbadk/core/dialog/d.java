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
    private BdListView Hh;
    private View abF;
    private f abW;
    private TbPageContext<?> abX;
    private AlertDialog abq;
    private ArrayList<g> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private ViewGroup mRootView;
    private String mTitle;
    private TextView mTitleView;
    private int abH = -1;
    private int abf = -1;
    private boolean abt = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int abP = d.k.dialog_ani_b2t;
        public static final int abQ = d.k.dialog_ani_t2b;
        public static final int abR = d.k.dialog_ani_l2r;
        public static final int abS = d.k.dialog_ani_r2l;
    }

    public d(TbPageContext<?> tbPageContext) {
        this.abX = tbPageContext;
        this.mRootView = (ViewGroup) LayoutInflater.from(this.abX.getPageActivity()).inflate(d.h.dialog_rich_layout, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.dialog_title_list);
        this.Hh = (BdListView) this.mRootView.findViewById(d.g.dialog_content_list);
        this.abF = this.mRootView.findViewById(d.g.line_bg);
        this.abW = new f(this.abX);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public d cU(String str) {
        this.mTitle = str;
        return this;
    }

    public d cm(int i) {
        return cU(this.abX.getResources().getString(i));
    }

    public d a(ArrayList<g> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
                this.Hh.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public d tm() {
        if (!this.abt) {
            this.abt = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.abF.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.abF.setVisibility(8);
            }
            this.Hh.setAdapter((ListAdapter) this.abW);
            this.abW.setData(this.mItems);
            c(this.abX);
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
        this.abW.setData(this.mItems);
    }

    public d tn() {
        if (!this.abt) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.abq != null) {
            com.baidu.adp.lib.g.g.a(this.abq, this.abX);
        } else {
            this.abq = new AlertDialog.Builder(this.abX.getPageActivity()).create();
            this.abq.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.abq, this.abX.getPageActivity())) {
                Window window = this.abq.getWindow();
                if (this.abH == -1) {
                    this.abH = a.abP;
                }
                if (this.abf == -1) {
                    this.abf = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.abf);
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
        if (this.abq != null) {
            com.baidu.adp.lib.g.g.b(this.abq, this.abX.getPageActivity());
        }
    }
}
