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
    private AlertDialog awW;
    private View axj;
    private f axy;
    private TbPageContext<?> mContext;
    private ArrayList<g> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private ViewGroup mRootView;
    private String mTitle;
    private TextView mTitleView;
    private int axl = -1;
    private int awK = -1;
    private boolean awY = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int axs = e.k.dialog_ani_b2t;
        public static final int axt = e.k.dialog_ani_t2b;
        public static final int LEFT_TO_RIGHT = e.k.dialog_ani_l2r;
        public static final int RIGHT_TO_LEFT = e.k.dialog_ani_r2l;
    }

    public e(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.dialog_rich_layout, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(e.g.dialog_title_list);
        this.OQ = (BdListView) this.mRootView.findViewById(e.g.dialog_content_list);
        this.axj = this.mRootView.findViewById(e.g.line_bg);
        this.axy = new f(this.mContext);
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
        if (!this.awY) {
            this.awY = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.axj.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.axj.setVisibility(8);
            }
            this.OQ.setAdapter((ListAdapter) this.axy);
            this.axy.setData(this.mItems);
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
        this.axy.setData(this.mItems);
    }

    public e BX() {
        if (!this.awY) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.awW != null) {
            com.baidu.adp.lib.g.g.a(this.awW, this.mContext);
        } else {
            this.awW = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
            this.awW.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.awW, this.mContext.getPageActivity())) {
                Window window = this.awW.getWindow();
                if (this.axl == -1) {
                    this.axl = a.axs;
                }
                if (this.awK == -1) {
                    this.awK = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.awK);
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
        if (this.awW != null) {
            com.baidu.adp.lib.g.g.b(this.awW, this.mContext.getPageActivity());
        }
    }
}
