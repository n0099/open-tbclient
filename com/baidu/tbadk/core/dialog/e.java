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
    private BdListView FL;
    private AlertDialog acB;
    private View acO;
    private g ade;
    private TbPageContext<?> adf;
    private ArrayList<h> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private ViewGroup mRootView;
    private String mTitle;
    private TextView mTitleView;
    private int acQ = -1;
    private int acp = -1;
    private boolean acD = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int acX = d.l.dialog_ani_b2t;
        public static final int acY = d.l.dialog_ani_t2b;
        public static final int LEFT_TO_RIGHT = d.l.dialog_ani_l2r;
        public static final int RIGHT_TO_LEFT = d.l.dialog_ani_r2l;
    }

    public e(TbPageContext<?> tbPageContext) {
        this.adf = tbPageContext;
        this.mRootView = (ViewGroup) LayoutInflater.from(this.adf.getPageActivity()).inflate(d.i.dialog_rich_layout, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.dialog_title_list);
        this.FL = (BdListView) this.mRootView.findViewById(d.g.dialog_content_list);
        this.acO = this.mRootView.findViewById(d.g.line_bg);
        this.ade = new g(this.adf);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public e de(String str) {
        this.mTitle = str;
        return this;
    }

    public e ci(int i) {
        return de(this.adf.getResources().getString(i));
    }

    public e a(ArrayList<h> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
                this.FL.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public e tH() {
        if (!this.acD) {
            this.acD = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.acO.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.acO.setVisibility(8);
            }
            this.FL.setAdapter((ListAdapter) this.ade);
            this.ade.setData(this.mItems);
            c(this.adf);
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
        this.ade.setData(this.mItems);
    }

    public e tI() {
        if (!this.acD) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.acB != null) {
            com.baidu.adp.lib.g.g.a(this.acB, this.adf);
        } else {
            this.acB = new AlertDialog.Builder(this.adf.getPageActivity()).create();
            this.acB.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.acB, this.adf.getPageActivity())) {
                Window window = this.acB.getWindow();
                if (this.acQ == -1) {
                    this.acQ = a.acX;
                }
                if (this.acp == -1) {
                    this.acp = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.acp);
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
        if (this.acB != null) {
            com.baidu.adp.lib.g.g.b(this.acB, this.adf.getPageActivity());
        }
    }
}
