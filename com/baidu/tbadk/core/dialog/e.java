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
    private g aRF;
    private TbPageContext<?> aRG;
    private AlertDialog aRc;
    private View aRq;
    private BdListView auY;
    private ArrayList<h> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private ViewGroup mRootView;
    private String mTitle;
    private TextView mTitleView;
    private int aRs = -1;
    private int aQR = -1;
    private boolean aRe = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int aRz = d.k.dialog_ani_b2t;
        public static final int aRA = d.k.dialog_ani_t2b;
        public static final int LEFT_TO_RIGHT = d.k.dialog_ani_l2r;
        public static final int RIGHT_TO_LEFT = d.k.dialog_ani_r2l;
    }

    public e(TbPageContext<?> tbPageContext) {
        this.aRG = tbPageContext;
        this.mRootView = (ViewGroup) LayoutInflater.from(this.aRG.getPageActivity()).inflate(d.h.dialog_rich_layout, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.dialog_title_list);
        this.auY = (BdListView) this.mRootView.findViewById(d.g.dialog_content_list);
        this.aRq = this.mRootView.findViewById(d.g.line_bg);
        this.aRF = new g(this.aRG);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public e dm(String str) {
        this.mTitle = str;
        return this;
    }

    public e fk(int i) {
        return dm(this.aRG.getResources().getString(i));
    }

    public e a(ArrayList<h> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
                this.auY.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public e AY() {
        if (!this.aRe) {
            this.aRe = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.aRq.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.aRq.setVisibility(8);
            }
            this.auY.setAdapter((ListAdapter) this.aRF);
            this.aRF.setData(this.mItems);
            c(this.aRG);
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
        this.aRF.setData(this.mItems);
    }

    public e AZ() {
        if (!this.aRe) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aRc != null) {
            com.baidu.adp.lib.g.g.a(this.aRc, this.aRG);
        } else {
            this.aRc = new AlertDialog.Builder(this.aRG.getPageActivity()).create();
            this.aRc.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.aRc, this.aRG.getPageActivity())) {
                Window window = this.aRc.getWindow();
                if (this.aRs == -1) {
                    this.aRs = a.aRz;
                }
                if (this.aQR == -1) {
                    this.aQR = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.aQR);
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
        if (this.aRc != null) {
            com.baidu.adp.lib.g.g.b(this.aRc, this.aRG.getPageActivity());
        }
    }
}
