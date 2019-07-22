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
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e {
    private BdListView Ni;
    private l bNC;
    private View bNp;
    private TbPageContext<?> mContext;
    private AlertDialog mDialog;
    private ArrayList<m> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private ViewGroup mRootView;
    private String mTitle;
    private TextView mTitleView;
    private int bNr = -1;
    private int bMO = -1;
    private boolean bNd = false;

    public e(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.dialog_rich_layout, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.dialog_title_list);
        this.Ni = (BdListView) this.mRootView.findViewById(R.id.dialog_content_list);
        this.bNp = this.mRootView.findViewById(R.id.line_bg);
        this.bNC = new l(this.mContext);
    }

    public e mQ(String str) {
        this.mTitle = str;
        return this;
    }

    public e hD(int i) {
        return mQ(this.mContext.getResources().getString(i));
    }

    public e a(ArrayList<m> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
                this.Ni.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public e agM() {
        if (!this.bNd) {
            this.bNd = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.bNp.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.bNp.setVisibility(8);
            }
            this.Ni.setAdapter((ListAdapter) this.bNC);
            this.bNC.setData(this.mItems);
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
        this.bNC.setData(this.mItems);
    }

    public e agN() {
        if (!this.bNd) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.mDialog != null) {
            com.baidu.adp.lib.g.g.a(this.mDialog, this.mContext);
        } else {
            this.mDialog = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
            this.mDialog.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.mDialog, this.mContext.getPageActivity())) {
                Window window = this.mDialog.getWindow();
                if (this.bNr == -1) {
                    this.bNr = R.style.dialog_ani_b2t;
                }
                if (this.bMO == -1) {
                    this.bMO = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.bMO);
                window.setBackgroundDrawableResource(R.drawable.transparent_bg);
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
        this.mRootView.setBackgroundResource(R.drawable.transparent_bg);
    }

    public void dismiss() {
        if (this.mDialog != null) {
            com.baidu.adp.lib.g.g.b(this.mDialog, this.mContext.getPageActivity());
        }
    }
}
