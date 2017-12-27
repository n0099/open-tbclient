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
public class d {
    private AlertDialog aPO;
    private View aQc;
    private f aQp;
    private TbPageContext<?> aQq;
    private BdListView avk;
    private ArrayList<g> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private ViewGroup mRootView;
    private String mTitle;
    private TextView mTitleView;
    private int aQe = -1;
    private int aPD = -1;
    private boolean aPQ = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int aQl = d.k.dialog_ani_b2t;
        public static final int aQm = d.k.dialog_ani_t2b;
        public static final int LEFT_TO_RIGHT = d.k.dialog_ani_l2r;
        public static final int RIGHT_TO_LEFT = d.k.dialog_ani_r2l;
    }

    public d(TbPageContext<?> tbPageContext) {
        this.aQq = tbPageContext;
        this.mRootView = (ViewGroup) LayoutInflater.from(this.aQq.getPageActivity()).inflate(d.h.dialog_rich_layout, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.dialog_title_list);
        this.avk = (BdListView) this.mRootView.findViewById(d.g.dialog_content_list);
        this.aQc = this.mRootView.findViewById(d.g.line_bg);
        this.aQp = new f(this.aQq);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public d db(String str) {
        this.mTitle = str;
        return this;
    }

    public d fm(int i) {
        return db(this.aQq.getResources().getString(i));
    }

    public d a(ArrayList<g> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
                this.avk.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public d AM() {
        if (!this.aPQ) {
            this.aPQ = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.aQc.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.aQc.setVisibility(8);
            }
            this.avk.setAdapter((ListAdapter) this.aQp);
            this.aQp.setData(this.mItems);
            c(this.aQq);
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
        this.aQp.setData(this.mItems);
    }

    public d AN() {
        if (!this.aPQ) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aPO != null) {
            com.baidu.adp.lib.g.g.a(this.aPO, this.aQq);
        } else {
            this.aPO = new AlertDialog.Builder(this.aQq.getPageActivity()).create();
            this.aPO.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.aPO, this.aQq.getPageActivity())) {
                Window window = this.aPO.getWindow();
                if (this.aQe == -1) {
                    this.aQe = a.aQl;
                }
                if (this.aPD == -1) {
                    this.aPD = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.aPD);
                window.setBackgroundDrawableResource(d.f.transparent_bg);
                window.setContentView(this.mRootView);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.e<?> eVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().aM(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().aM(this.mRootView);
        }
        this.mRootView.setBackgroundResource(d.f.transparent_bg);
    }

    public void dismiss() {
        if (this.aPO != null) {
            com.baidu.adp.lib.g.g.b(this.aPO, this.aQq.getPageActivity());
        }
    }
}
