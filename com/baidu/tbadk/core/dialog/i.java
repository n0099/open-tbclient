package com.baidu.tbadk.core.dialog;

import android.app.AlertDialog;
import android.text.TextUtils;
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
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i {
    private AdapterView.OnItemClickListener Hv;
    private TbPageContext<?> LH;
    private TextView RS;
    private View RT;
    private k Se;
    private AlertDialog mDialog;
    private ArrayList<m> mItems;
    private BdListView mListView;
    private ViewGroup mRootView;
    private String mTitle;
    private int RV = -1;
    private int Rx = -1;
    private boolean RH = false;

    public i(TbPageContext<?> tbPageContext) {
        this.LH = tbPageContext;
        this.mRootView = (ViewGroup) com.baidu.adp.lib.g.b.hr().inflate(this.LH.getPageActivity(), r.dialog_rich_layout, null);
        this.RS = (TextView) this.mRootView.findViewById(q.dialog_title_list);
        this.mListView = (BdListView) this.mRootView.findViewById(q.dialog_content_list);
        this.RT = this.mRootView.findViewById(q.line_bg);
        this.Se = new k(this.LH);
    }

    public i cp(String str) {
        this.mTitle = str;
        return this;
    }

    public i bC(int i) {
        return cp(this.LH.getResources().getString(i));
    }

    public i a(ArrayList<m> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.Hv = onItemClickListener;
                this.mListView.setOnItemClickListener(this.Hv);
            }
        }
        return this;
    }

    public i rO() {
        if (!this.RH) {
            this.RH = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.RS.setText(this.mTitle);
                this.RS.setVisibility(0);
                this.RT.setVisibility(0);
            } else {
                this.RS.setVisibility(8);
                this.RT.setVisibility(8);
            }
            this.mListView.setAdapter((ListAdapter) this.Se);
            this.Se.setData(this.mItems);
            c(this.LH);
        }
        return this;
    }

    public void bD(int i) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            if (i2 == i) {
                this.mItems.get(i2).setChecked(true);
            } else {
                this.mItems.get(i2).setChecked(false);
            }
        }
        this.Se.setData(this.mItems);
    }

    public i rP() {
        if (!this.RH) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.mDialog != null) {
            com.baidu.adp.lib.g.k.a(this.mDialog, this.LH);
        } else {
            this.mDialog = new AlertDialog.Builder(this.LH.getPageActivity()).create();
            this.mDialog.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.k.a(this.mDialog, this.LH.getPageActivity())) {
                Window window = this.mDialog.getWindow();
                if (this.RV == -1) {
                    this.RV = j.Sa;
                }
                if (this.Rx == -1) {
                    this.Rx = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.Rx);
                window.setBackgroundDrawableResource(p.transparent_bg);
                window.setContentView(this.mRootView);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.j<?> jVar) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (jVar instanceof TbPageContext) {
            ((TbPageContext) jVar).getLayoutMode().ab(skinType == 1);
            ((TbPageContext) jVar).getLayoutMode().j(this.mRootView);
        }
        this.mRootView.setBackgroundResource(p.transparent_bg);
    }
}
