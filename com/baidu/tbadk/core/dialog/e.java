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
public class e {
    private BdListView LO;
    private AlertDialog akE;
    private View akS;
    private f ali;
    private TbPageContext<?> mContext;
    private ArrayList<g> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private ViewGroup mRootView;
    private String mTitle;
    private TextView mTitleView;
    private int akU = -1;
    private int aks = -1;
    private boolean akG = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int alb = d.k.dialog_ani_b2t;
        public static final int alc = d.k.dialog_ani_t2b;
        public static final int LEFT_TO_RIGHT = d.k.dialog_ani_l2r;
        public static final int RIGHT_TO_LEFT = d.k.dialog_ani_r2l;
    }

    public e(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.dialog_rich_layout, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.dialog_title_list);
        this.LO = (BdListView) this.mRootView.findViewById(d.g.dialog_content_list);
        this.akS = this.mRootView.findViewById(d.g.line_bg);
        this.ali = new f(this.mContext);
    }

    public e dD(String str) {
        this.mTitle = str;
        return this;
    }

    public e co(int i) {
        return dD(this.mContext.getResources().getString(i));
    }

    public e a(ArrayList<g> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
                this.LO.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public e xj() {
        if (!this.akG) {
            this.akG = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.akS.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.akS.setVisibility(8);
            }
            this.LO.setAdapter((ListAdapter) this.ali);
            this.ali.setData(this.mItems);
            c(this.mContext);
        }
        return this;
    }

    public void refresh(int i) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            if (i2 == i) {
                this.mItems.get(i2).setChecked(true);
            } else {
                this.mItems.get(i2).setChecked(false);
            }
        }
        this.ali.setData(this.mItems);
    }

    public e xk() {
        if (!this.akG) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.akE != null) {
            com.baidu.adp.lib.g.g.a(this.akE, this.mContext);
        } else {
            this.akE = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
            this.akE.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.akE, this.mContext.getPageActivity())) {
                Window window = this.akE.getWindow();
                if (this.akU == -1) {
                    this.akU = a.alb;
                }
                if (this.aks == -1) {
                    this.aks = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.aks);
                window.setBackgroundDrawableResource(d.f.transparent_bg);
                window.setContentView(this.mRootView);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.e<?> eVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().setNightMode(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().onModeChanged(this.mRootView);
        }
        this.mRootView.setBackgroundResource(d.f.transparent_bg);
    }

    public void dismiss() {
        if (this.akE != null) {
            com.baidu.adp.lib.g.g.b(this.akE, this.mContext.getPageActivity());
        }
    }
}
