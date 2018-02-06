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
    private View aRB;
    private g aRQ;
    private TbPageContext<?> aRR;
    private AlertDialog aRn;
    private BdListView avh;
    private ArrayList<h> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private ViewGroup mRootView;
    private String mTitle;
    private TextView mTitleView;
    private int aRD = -1;
    private int aRc = -1;
    private boolean aRp = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int aRK = d.k.dialog_ani_b2t;
        public static final int aRL = d.k.dialog_ani_t2b;
        public static final int LEFT_TO_RIGHT = d.k.dialog_ani_l2r;
        public static final int RIGHT_TO_LEFT = d.k.dialog_ani_r2l;
    }

    public e(TbPageContext<?> tbPageContext) {
        this.aRR = tbPageContext;
        this.mRootView = (ViewGroup) LayoutInflater.from(this.aRR.getPageActivity()).inflate(d.h.dialog_rich_layout, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.dialog_title_list);
        this.avh = (BdListView) this.mRootView.findViewById(d.g.dialog_content_list);
        this.aRB = this.mRootView.findViewById(d.g.line_bg);
        this.aRQ = new g(this.aRR);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public e dm(String str) {
        this.mTitle = str;
        return this;
    }

    public e fk(int i) {
        return dm(this.aRR.getResources().getString(i));
    }

    public e a(ArrayList<h> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
                this.avh.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public e AY() {
        if (!this.aRp) {
            this.aRp = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.aRB.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.aRB.setVisibility(8);
            }
            this.avh.setAdapter((ListAdapter) this.aRQ);
            this.aRQ.setData(this.mItems);
            c(this.aRR);
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
        this.aRQ.setData(this.mItems);
    }

    public e AZ() {
        if (!this.aRp) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aRn != null) {
            com.baidu.adp.lib.g.g.a(this.aRn, this.aRR);
        } else {
            this.aRn = new AlertDialog.Builder(this.aRR.getPageActivity()).create();
            this.aRn.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.aRn, this.aRR.getPageActivity())) {
                Window window = this.aRn.getWindow();
                if (this.aRD == -1) {
                    this.aRD = a.aRK;
                }
                if (this.aRc == -1) {
                    this.aRc = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.aRc);
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
        if (this.aRn != null) {
            com.baidu.adp.lib.g.g.b(this.aRn, this.aRR.getPageActivity());
        }
    }
}
