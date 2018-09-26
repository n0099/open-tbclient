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
    private BdListView Op;
    private f anN;
    private AlertDialog ank;
    private View any;
    private TbPageContext<?> mContext;
    private ArrayList<g> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private ViewGroup mRootView;
    private String mTitle;
    private TextView mTitleView;
    private int anA = -1;
    private int amY = -1;
    private boolean anm = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int anH = e.k.dialog_ani_b2t;
        public static final int anI = e.k.dialog_ani_t2b;
        public static final int LEFT_TO_RIGHT = e.k.dialog_ani_l2r;
        public static final int RIGHT_TO_LEFT = e.k.dialog_ani_r2l;
    }

    public e(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.dialog_rich_layout, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(e.g.dialog_title_list);
        this.Op = (BdListView) this.mRootView.findViewById(e.g.dialog_content_list);
        this.any = this.mRootView.findViewById(e.g.line_bg);
        this.anN = new f(this.mContext);
    }

    public e dV(String str) {
        this.mTitle = str;
        return this;
    }

    public e cy(int i) {
        return dV(this.mContext.getResources().getString(i));
    }

    public e a(ArrayList<g> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
                this.Op.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public e yp() {
        if (!this.anm) {
            this.anm = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.any.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.any.setVisibility(8);
            }
            this.Op.setAdapter((ListAdapter) this.anN);
            this.anN.setData(this.mItems);
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
        this.anN.setData(this.mItems);
    }

    public e yq() {
        if (!this.anm) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.ank != null) {
            com.baidu.adp.lib.g.g.a(this.ank, this.mContext);
        } else {
            this.ank = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
            this.ank.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.ank, this.mContext.getPageActivity())) {
                Window window = this.ank.getWindow();
                if (this.anA == -1) {
                    this.anA = a.anH;
                }
                if (this.amY == -1) {
                    this.amY = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.amY);
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
        if (this.ank != null) {
            com.baidu.adp.lib.g.g.b(this.ank, this.mContext.getPageActivity());
        }
    }
}
