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
    private AlertDialog WE;
    private TextView WU;
    private View WV;
    private f Xf;
    private TbPageContext<?> mContext;
    private ArrayList<g> mItems;
    private BdListView mListView;
    private ViewGroup mRootView;
    private String mTitle;
    private int WX = -1;
    private int Wv = -1;
    private boolean WG = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int Xb = i.C0057i.dialog_ani_b2t;
        public static final int Xc = i.C0057i.dialog_ani_t2b;
        public static final int Xd = i.C0057i.dialog_ani_l2r;
        public static final int Xe = i.C0057i.dialog_ani_r2l;
    }

    public e(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.dialog_rich_layout, (ViewGroup) null);
        this.WU = (TextView) this.mRootView.findViewById(i.f.dialog_title_list);
        this.mListView = (BdListView) this.mRootView.findViewById(i.f.dialog_content_list);
        this.WV = this.mRootView.findViewById(i.f.line_bg);
        this.Xf = new f(this.mContext);
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

    public e sY() {
        if (!this.WG) {
            this.WG = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.WU.setText(this.mTitle);
                this.WU.setVisibility(0);
                this.WV.setVisibility(0);
            } else {
                this.WU.setVisibility(8);
                this.WV.setVisibility(8);
            }
            this.mListView.setAdapter((ListAdapter) this.Xf);
            this.Xf.setData(this.mItems);
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
        this.Xf.setData(this.mItems);
    }

    public e sZ() {
        if (!this.WG) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.WE != null) {
            j.a(this.WE, this.mContext);
        } else {
            this.WE = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
            this.WE.setCanceledOnTouchOutside(true);
            if (j.a(this.WE, this.mContext.getPageActivity())) {
                Window window = this.WE.getWindow();
                if (this.WX == -1) {
                    this.WX = a.Xb;
                }
                if (this.Wv == -1) {
                    this.Wv = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.Wv);
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
        if (this.WE != null) {
            j.b(this.WE, this.mContext.getPageActivity());
        }
    }
}
