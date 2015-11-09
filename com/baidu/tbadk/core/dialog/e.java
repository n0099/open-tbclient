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
    private AdapterView.OnItemClickListener Hy;
    private AlertDialog WB;
    private TextView WR;
    private View WS;
    private f Xc;
    private TbPageContext<?> mContext;
    private ArrayList<g> mItems;
    private BdListView mListView;
    private ViewGroup mRootView;
    private String mTitle;
    private int WU = -1;
    private int Ws = -1;
    private boolean WD = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int WY = i.C0057i.dialog_ani_b2t;
        public static final int WZ = i.C0057i.dialog_ani_t2b;
        public static final int Xa = i.C0057i.dialog_ani_l2r;
        public static final int Xb = i.C0057i.dialog_ani_r2l;
    }

    public e(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.dialog_rich_layout, (ViewGroup) null);
        this.WR = (TextView) this.mRootView.findViewById(i.f.dialog_title_list);
        this.mListView = (BdListView) this.mRootView.findViewById(i.f.dialog_content_list);
        this.WS = this.mRootView.findViewById(i.f.line_bg);
        this.Xc = new f(this.mContext);
    }

    public e cw(String str) {
        this.mTitle = str;
        return this;
    }

    public e bN(int i) {
        return cw(this.mContext.getResources().getString(i));
    }

    public e a(ArrayList<g> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.Hy = onItemClickListener;
                this.mListView.setOnItemClickListener(this.Hy);
            }
        }
        return this;
    }

    public e sV() {
        if (!this.WD) {
            this.WD = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.WR.setText(this.mTitle);
                this.WR.setVisibility(0);
                this.WS.setVisibility(0);
            } else {
                this.WR.setVisibility(8);
                this.WS.setVisibility(8);
            }
            this.mListView.setAdapter((ListAdapter) this.Xc);
            this.Xc.setData(this.mItems);
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
        this.Xc.setData(this.mItems);
    }

    public e sW() {
        if (!this.WD) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.WB != null) {
            j.a(this.WB, this.mContext);
        } else {
            this.WB = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
            this.WB.setCanceledOnTouchOutside(true);
            if (j.a(this.WB, this.mContext.getPageActivity())) {
                Window window = this.WB.getWindow();
                if (this.WU == -1) {
                    this.WU = a.WY;
                }
                if (this.Ws == -1) {
                    this.Ws = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.Ws);
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
        if (this.WB != null) {
            j.b(this.WB, this.mContext.getPageActivity());
        }
    }
}
