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
    private TbPageContext<?> LS;
    private TextView WL;
    private View WM;
    private f WW;
    private AlertDialog Ww;
    private ArrayList<g> mItems;
    private BdListView mListView;
    private ViewGroup mRootView;
    private String mTitle;
    private int WO = -1;
    private int Wn = -1;
    private boolean Wy = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int WS = i.j.dialog_ani_b2t;
        public static final int WT = i.j.dialog_ani_t2b;
        public static final int WU = i.j.dialog_ani_l2r;
        public static final int WV = i.j.dialog_ani_r2l;
    }

    public e(TbPageContext<?> tbPageContext) {
        this.LS = tbPageContext;
        this.mRootView = (ViewGroup) LayoutInflater.from(this.LS.getPageActivity()).inflate(i.g.dialog_rich_layout, (ViewGroup) null);
        this.WL = (TextView) this.mRootView.findViewById(i.f.dialog_title_list);
        this.mListView = (BdListView) this.mRootView.findViewById(i.f.dialog_content_list);
        this.WM = this.mRootView.findViewById(i.f.line_bg);
        this.WW = new f(this.LS);
    }

    public e cp(String str) {
        this.mTitle = str;
        return this;
    }

    public e bK(int i) {
        return cp(this.LS.getResources().getString(i));
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

    public e sT() {
        if (!this.Wy) {
            this.Wy = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.WL.setText(this.mTitle);
                this.WL.setVisibility(0);
                this.WM.setVisibility(0);
            } else {
                this.WL.setVisibility(8);
                this.WM.setVisibility(8);
            }
            this.mListView.setAdapter((ListAdapter) this.WW);
            this.WW.setData(this.mItems);
            c(this.LS);
        }
        return this;
    }

    public void bL(int i) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            if (i2 == i) {
                this.mItems.get(i2).setChecked(true);
            } else {
                this.mItems.get(i2).setChecked(false);
            }
        }
        this.WW.setData(this.mItems);
    }

    public e sU() {
        if (!this.Wy) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Ww != null) {
            j.a(this.Ww, this.LS);
        } else {
            this.Ww = new AlertDialog.Builder(this.LS.getPageActivity()).create();
            this.Ww.setCanceledOnTouchOutside(true);
            if (j.a(this.Ww, this.LS.getPageActivity())) {
                Window window = this.Ww.getWindow();
                if (this.WO == -1) {
                    this.WO = a.WS;
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
            j.b(this.Ww, this.LS.getPageActivity());
        }
    }
}
