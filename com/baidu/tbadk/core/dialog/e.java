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
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e {
    private BdListView OQ;
    private AlertDialog awV;
    private View axi;
    private f axx;
    private TbPageContext<?> mContext;
    private ArrayList<g> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private ViewGroup mRootView;
    private String mTitle;
    private TextView mTitleView;
    private int axk = -1;
    private int awJ = -1;
    private boolean awX = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int axr = e.k.dialog_ani_b2t;
        public static final int axs = e.k.dialog_ani_t2b;
        public static final int LEFT_TO_RIGHT = e.k.dialog_ani_l2r;
        public static final int RIGHT_TO_LEFT = e.k.dialog_ani_r2l;
    }

    public e(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.dialog_rich_layout, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(e.g.dialog_title_list);
        this.OQ = (BdListView) this.mRootView.findViewById(e.g.dialog_content_list);
        this.axi = this.mRootView.findViewById(e.g.line_bg);
        this.axx = new f(this.mContext);
    }

    public e eM(String str) {
        this.mTitle = str;
        return this;
    }

    public e dk(int i) {
        return eM(this.mContext.getResources().getString(i));
    }

    public e a(ArrayList<g> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
                this.OQ.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public e BW() {
        if (!this.awX) {
            this.awX = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.axi.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.axi.setVisibility(8);
            }
            this.OQ.setAdapter((ListAdapter) this.axx);
            this.axx.setData(this.mItems);
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
        this.axx.setData(this.mItems);
    }

    public e BX() {
        if (!this.awX) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.awV != null) {
            com.baidu.adp.lib.g.g.a(this.awV, this.mContext);
        } else {
            this.awV = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
            this.awV.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.awV, this.mContext.getPageActivity())) {
                Window window = this.awV.getWindow();
                if (this.axk == -1) {
                    this.axk = a.axr;
                }
                if (this.awJ == -1) {
                    this.awJ = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.awJ);
                window.setBackgroundDrawableResource(e.f.transparent_bg);
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
        this.mRootView.setBackgroundResource(e.f.transparent_bg);
    }

    public void dismiss() {
        if (this.awV != null) {
            com.baidu.adp.lib.g.g.b(this.awV, this.mContext.getPageActivity());
        }
    }
}
