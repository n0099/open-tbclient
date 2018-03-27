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
    private g aRH;
    private TbPageContext<?> aRI;
    private AlertDialog aRe;
    private View aRs;
    private BdListView auZ;
    private ArrayList<h> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private ViewGroup mRootView;
    private String mTitle;
    private TextView mTitleView;
    private int aRu = -1;
    private int aQT = -1;
    private boolean aRg = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int aRB = d.k.dialog_ani_b2t;
        public static final int aRC = d.k.dialog_ani_t2b;
        public static final int LEFT_TO_RIGHT = d.k.dialog_ani_l2r;
        public static final int RIGHT_TO_LEFT = d.k.dialog_ani_r2l;
    }

    public e(TbPageContext<?> tbPageContext) {
        this.aRI = tbPageContext;
        this.mRootView = (ViewGroup) LayoutInflater.from(this.aRI.getPageActivity()).inflate(d.h.dialog_rich_layout, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.dialog_title_list);
        this.auZ = (BdListView) this.mRootView.findViewById(d.g.dialog_content_list);
        this.aRs = this.mRootView.findViewById(d.g.line_bg);
        this.aRH = new g(this.aRI);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public e dm(String str) {
        this.mTitle = str;
        return this;
    }

    public e fk(int i) {
        return dm(this.aRI.getResources().getString(i));
    }

    public e a(ArrayList<h> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
                this.auZ.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public e AZ() {
        if (!this.aRg) {
            this.aRg = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.aRs.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.aRs.setVisibility(8);
            }
            this.auZ.setAdapter((ListAdapter) this.aRH);
            this.aRH.setData(this.mItems);
            c(this.aRI);
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
        this.aRH.setData(this.mItems);
    }

    public e Ba() {
        if (!this.aRg) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aRe != null) {
            com.baidu.adp.lib.g.g.a(this.aRe, this.aRI);
        } else {
            this.aRe = new AlertDialog.Builder(this.aRI.getPageActivity()).create();
            this.aRe.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.aRe, this.aRI.getPageActivity())) {
                Window window = this.aRe.getWindow();
                if (this.aRu == -1) {
                    this.aRu = a.aRB;
                }
                if (this.aQT == -1) {
                    this.aQT = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.aQT);
                window.setBackgroundDrawableResource(d.f.transparent_bg);
                window.setContentView(this.mRootView);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.e<?> eVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().aQ(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().aM(this.mRootView);
        }
        this.mRootView.setBackgroundResource(d.f.transparent_bg);
    }

    public void dismiss() {
        if (this.aRe != null) {
            com.baidu.adp.lib.g.g.b(this.aRe, this.aRI.getPageActivity());
        }
    }
}
