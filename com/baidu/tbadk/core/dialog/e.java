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
    private BdListView Pj;
    private AlertDialog bED;
    private View bER;
    private j bFg;
    private TbPageContext<?> mContext;
    private ArrayList<k> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private ViewGroup mRootView;
    private String mTitle;
    private TextView mTitleView;
    private int bET = -1;
    private int bEq = -1;
    private boolean bEF = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int bFa = d.k.dialog_ani_b2t;
        public static final int bFb = d.k.dialog_ani_t2b;
        public static final int LEFT_TO_RIGHT = d.k.dialog_ani_l2r;
        public static final int RIGHT_TO_LEFT = d.k.dialog_ani_r2l;
    }

    public e(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.dialog_rich_layout, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.dialog_title_list);
        this.Pj = (BdListView) this.mRootView.findViewById(d.g.dialog_content_list);
        this.bER = this.mRootView.findViewById(d.g.line_bg);
        this.bFg = new j(this.mContext);
    }

    public e lA(String str) {
        this.mTitle = str;
        return this;
    }

    public e gL(int i) {
        return lA(this.mContext.getResources().getString(i));
    }

    public e a(ArrayList<k> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
                this.Pj.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public e abd() {
        if (!this.bEF) {
            this.bEF = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.bER.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.bER.setVisibility(8);
            }
            this.Pj.setAdapter((ListAdapter) this.bFg);
            this.bFg.setData(this.mItems);
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
        this.bFg.setData(this.mItems);
    }

    public e abe() {
        if (!this.bEF) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.bED != null) {
            com.baidu.adp.lib.g.g.a(this.bED, this.mContext);
        } else {
            this.bED = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
            this.bED.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.bED, this.mContext.getPageActivity())) {
                Window window = this.bED.getWindow();
                if (this.bET == -1) {
                    this.bET = a.bFa;
                }
                if (this.bEq == -1) {
                    this.bEq = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.bEq);
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
        if (this.bED != null) {
            com.baidu.adp.lib.g.g.b(this.bED, this.mContext.getPageActivity());
        }
    }
}
