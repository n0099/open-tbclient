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
    private BdListView FH;
    private AlertDialog acC;
    private View acP;
    private g adf;
    private TbPageContext<?> mContext;
    private ArrayList<h> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private ViewGroup mRootView;
    private String mTitle;
    private TextView mTitleView;
    private int acR = -1;
    private int acq = -1;
    private boolean acE = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int acY = d.l.dialog_ani_b2t;
        public static final int acZ = d.l.dialog_ani_t2b;
        public static final int LEFT_TO_RIGHT = d.l.dialog_ani_l2r;
        public static final int RIGHT_TO_LEFT = d.l.dialog_ani_r2l;
    }

    public e(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.dialog_rich_layout, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.dialog_title_list);
        this.FH = (BdListView) this.mRootView.findViewById(d.g.dialog_content_list);
        this.acP = this.mRootView.findViewById(d.g.line_bg);
        this.adf = new g(this.mContext);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public e de(String str) {
        this.mTitle = str;
        return this;
    }

    public e cj(int i) {
        return de(this.mContext.getResources().getString(i));
    }

    public e a(ArrayList<h> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
                this.FH.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public e tG() {
        if (!this.acE) {
            this.acE = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.acP.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.acP.setVisibility(8);
            }
            this.FH.setAdapter((ListAdapter) this.adf);
            this.adf.setData(this.mItems);
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
        this.adf.setData(this.mItems);
    }

    public e tH() {
        if (!this.acE) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.acC != null) {
            com.baidu.adp.lib.g.g.a(this.acC, this.mContext);
        } else {
            this.acC = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
            this.acC.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.acC, this.mContext.getPageActivity())) {
                Window window = this.acC.getWindow();
                if (this.acR == -1) {
                    this.acR = a.acY;
                }
                if (this.acq == -1) {
                    this.acq = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.acq);
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
            ((TbPageContext) eVar).getLayoutMode().u(this.mRootView);
        }
        this.mRootView.setBackgroundResource(d.f.transparent_bg);
    }

    public void dismiss() {
        if (this.acC != null) {
            com.baidu.adp.lib.g.g.b(this.acC, this.mContext.getPageActivity());
        }
    }
}
