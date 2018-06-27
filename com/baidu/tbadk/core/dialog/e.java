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
    private BdListView LS;
    private f alJ;
    private AlertDialog alf;
    private View alt;
    private TbPageContext<?> mContext;
    private ArrayList<g> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private ViewGroup mRootView;
    private String mTitle;
    private TextView mTitleView;
    private int alv = -1;
    private int akT = -1;
    private boolean alh = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int alC = d.l.dialog_ani_b2t;
        public static final int alD = d.l.dialog_ani_t2b;
        public static final int LEFT_TO_RIGHT = d.l.dialog_ani_l2r;
        public static final int RIGHT_TO_LEFT = d.l.dialog_ani_r2l;
    }

    public e(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.dialog_rich_layout, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.dialog_title_list);
        this.LS = (BdListView) this.mRootView.findViewById(d.g.dialog_content_list);
        this.alt = this.mRootView.findViewById(d.g.line_bg);
        this.alJ = new f(this.mContext);
    }

    public e dG(String str) {
        this.mTitle = str;
        return this;
    }

    public e cm(int i) {
        return dG(this.mContext.getResources().getString(i));
    }

    public e a(ArrayList<g> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
                this.LS.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public e xr() {
        if (!this.alh) {
            this.alh = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.alt.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.alt.setVisibility(8);
            }
            this.LS.setAdapter((ListAdapter) this.alJ);
            this.alJ.setData(this.mItems);
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
        this.alJ.setData(this.mItems);
    }

    public e xs() {
        if (!this.alh) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.alf != null) {
            com.baidu.adp.lib.g.g.a(this.alf, this.mContext);
        } else {
            this.alf = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
            this.alf.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.alf, this.mContext.getPageActivity())) {
                Window window = this.alf.getWindow();
                if (this.alv == -1) {
                    this.alv = a.alC;
                }
                if (this.akT == -1) {
                    this.akT = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.akT);
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
        if (this.alf != null) {
            com.baidu.adp.lib.g.g.b(this.alf, this.mContext.getPageActivity());
        }
    }
}
