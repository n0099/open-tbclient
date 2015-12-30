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
    private AdapterView.OnItemClickListener If;
    private AlertDialog XR;
    private TextView Yh;
    private View Yi;
    private f Ys;
    private TbPageContext<?> mContext;
    private ArrayList<g> mItems;
    private BdListView mListView;
    private ViewGroup mRootView;
    private String mTitle;
    private int Yk = -1;
    private int XG = -1;
    private boolean XT = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int Yo = n.k.dialog_ani_b2t;
        public static final int Yp = n.k.dialog_ani_t2b;
        public static final int Yq = n.k.dialog_ani_l2r;
        public static final int Yr = n.k.dialog_ani_r2l;
    }

    public e(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.h.dialog_rich_layout, (ViewGroup) null);
        this.Yh = (TextView) this.mRootView.findViewById(n.g.dialog_title_list);
        this.mListView = (BdListView) this.mRootView.findViewById(n.g.dialog_content_list);
        this.Yi = this.mRootView.findViewById(n.g.line_bg);
        this.Ys = new f(this.mContext);
    }

    public e cH(String str) {
        this.mTitle = str;
        return this;
    }

    public e bO(int i) {
        return cH(this.mContext.getResources().getString(i));
    }

    public e a(ArrayList<g> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.If = onItemClickListener;
                this.mListView.setOnItemClickListener(this.If);
            }
        }
        return this;
    }

    public e tk() {
        if (!this.XT) {
            this.XT = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.Yh.setText(this.mTitle);
                this.Yh.setVisibility(0);
                this.Yi.setVisibility(0);
            } else {
                this.Yh.setVisibility(8);
                this.Yi.setVisibility(8);
            }
            this.mListView.setAdapter((ListAdapter) this.Ys);
            this.Ys.setData(this.mItems);
            c(this.mContext);
        }
        return this;
    }

    public void bP(int i) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            if (i2 == i) {
                this.mItems.get(i2).setChecked(true);
            } else {
                this.mItems.get(i2).setChecked(false);
            }
        }
        this.Ys.setData(this.mItems);
    }

    public e tl() {
        if (!this.XT) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.XR != null) {
            j.a(this.XR, this.mContext);
        } else {
            this.XR = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
            this.XR.setCanceledOnTouchOutside(true);
            if (j.a(this.XR, this.mContext.getPageActivity())) {
                Window window = this.XR.getWindow();
                if (this.Yk == -1) {
                    this.Yk = a.Yo;
                }
                if (this.XG == -1) {
                    this.XG = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.XG);
                window.setBackgroundDrawableResource(n.f.transparent_bg);
                window.setContentView(this.mRootView);
            }
        }
        return this;
    }

    private void c(h<?> hVar) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ac(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().k(this.mRootView);
        }
        this.mRootView.setBackgroundResource(n.f.transparent_bg);
    }

    public void dismiss() {
        if (this.XR != null) {
            j.b(this.XR, this.mContext.getPageActivity());
        }
    }
}
