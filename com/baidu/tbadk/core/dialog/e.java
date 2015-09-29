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
import com.baidu.adp.lib.g.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e {
    private AdapterView.OnItemClickListener Hw;
    private TextView WM;
    private View WN;
    private f WX;
    private AlertDialog Ww;
    private TbPageContext<?> mContext;
    private ArrayList<g> mItems;
    private BdListView mListView;
    private ViewGroup mRootView;
    private String mTitle;
    private int WP = -1;
    private int Wn = -1;
    private boolean Wy = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int WT = i.C0057i.dialog_ani_b2t;
        public static final int WU = i.C0057i.dialog_ani_t2b;
        public static final int WV = i.C0057i.dialog_ani_l2r;
        public static final int WW = i.C0057i.dialog_ani_r2l;
    }

    public e(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.dialog_rich_layout, (ViewGroup) null);
        this.WM = (TextView) this.mRootView.findViewById(i.f.dialog_title_list);
        this.mListView = (BdListView) this.mRootView.findViewById(i.f.dialog_content_list);
        this.WN = this.mRootView.findViewById(i.f.line_bg);
        this.WX = new f(this.mContext);
    }

    public e cv(String str) {
        this.mTitle = str;
        return this;
    }

    public e bN(int i) {
        return cv(this.mContext.getResources().getString(i));
    }

    public e a(ArrayList<g> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.Hw = onItemClickListener;
                this.mListView.setOnItemClickListener(this.Hw);
            }
        }
        return this;
    }

    public e sV() {
        if (!this.Wy) {
            this.Wy = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.WM.setText(this.mTitle);
                this.WM.setVisibility(0);
                this.WN.setVisibility(0);
            } else {
                this.WM.setVisibility(8);
                this.WN.setVisibility(8);
            }
            this.mListView.setAdapter((ListAdapter) this.WX);
            this.WX.setData(this.mItems);
            c(this.mContext);
        }
        return this;
    }

    public void bO(int i) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            if (i2 == i) {
                this.mItems.get(i2).setChecked(true);
            } else {
                this.mItems.get(i2).setChecked(false);
            }
        }
        this.WX.setData(this.mItems);
    }

    public e sW() {
        if (!this.Wy) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Ww != null) {
            j.a(this.Ww, this.mContext);
        } else {
            this.Ww = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
            this.Ww.setCanceledOnTouchOutside(true);
            if (j.a(this.Ww, this.mContext.getPageActivity())) {
                Window window = this.Ww.getWindow();
                if (this.WP == -1) {
                    this.WP = a.WT;
                }
                if (this.Wn == -1) {
                    this.Wn = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.Wn);
                window.setBackgroundDrawableResource(i.e.transparent_bg);
                window.setContentView(this.mRootView);
            }
        }
        return this;
    }

    private void c(h<?> hVar) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ad(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().k(this.mRootView);
        }
        this.mRootView.setBackgroundResource(i.e.transparent_bg);
    }

    public void dismiss() {
        if (this.Ww != null) {
            j.b(this.Ww, this.mContext.getPageActivity());
        }
    }
}
