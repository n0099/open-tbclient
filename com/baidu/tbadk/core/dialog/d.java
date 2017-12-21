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
    private BdListView Hi;
    private View abI;
    private f abZ;
    private AlertDialog abu;
    private TbPageContext<?> aca;
    private ArrayList<g> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private ViewGroup mRootView;
    private String mTitle;
    private TextView mTitleView;
    private int abK = -1;
    private int abi = -1;
    private boolean abw = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int abS = d.k.dialog_ani_b2t;
        public static final int abT = d.k.dialog_ani_t2b;
        public static final int abU = d.k.dialog_ani_l2r;
        public static final int abV = d.k.dialog_ani_r2l;
    }

    public d(TbPageContext<?> tbPageContext) {
        this.aca = tbPageContext;
        this.mRootView = (ViewGroup) LayoutInflater.from(this.aca.getPageActivity()).inflate(d.h.dialog_rich_layout, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.dialog_title_list);
        this.Hi = (BdListView) this.mRootView.findViewById(d.g.dialog_content_list);
        this.abI = this.mRootView.findViewById(d.g.line_bg);
        this.abZ = new f(this.aca);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public d cU(String str) {
        this.mTitle = str;
        return this;
    }

    public d cm(int i) {
        return cU(this.aca.getResources().getString(i));
    }

    public d a(ArrayList<g> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
                this.Hi.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public d tm() {
        if (!this.abw) {
            this.abw = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.abI.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.abI.setVisibility(8);
            }
            this.Hi.setAdapter((ListAdapter) this.abZ);
            this.abZ.setData(this.mItems);
            c(this.aca);
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
        this.abZ.setData(this.mItems);
    }

    public d tn() {
        if (!this.abw) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.abu != null) {
            com.baidu.adp.lib.g.g.a(this.abu, this.aca);
        } else {
            this.abu = new AlertDialog.Builder(this.aca.getPageActivity()).create();
            this.abu.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.abu, this.aca.getPageActivity())) {
                Window window = this.abu.getWindow();
                if (this.abK == -1) {
                    this.abK = a.abS;
                }
                if (this.abi == -1) {
                    this.abi = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.abi);
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
        if (this.abu != null) {
            com.baidu.adp.lib.g.g.b(this.abu, this.aca.getPageActivity());
        }
    }
}
