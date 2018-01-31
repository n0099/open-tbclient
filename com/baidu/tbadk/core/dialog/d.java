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
    private AlertDialog aPQ;
    private View aQe;
    private f aQr;
    private TbPageContext<?> aQs;
    private BdListView avm;
    private ArrayList<g> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private ViewGroup mRootView;
    private String mTitle;
    private TextView mTitleView;
    private int aQg = -1;
    private int aPF = -1;
    private boolean aPS = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int aQn = d.k.dialog_ani_b2t;
        public static final int aQo = d.k.dialog_ani_t2b;
        public static final int LEFT_TO_RIGHT = d.k.dialog_ani_l2r;
        public static final int RIGHT_TO_LEFT = d.k.dialog_ani_r2l;
    }

    public d(TbPageContext<?> tbPageContext) {
        this.aQs = tbPageContext;
        this.mRootView = (ViewGroup) LayoutInflater.from(this.aQs.getPageActivity()).inflate(d.h.dialog_rich_layout, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.dialog_title_list);
        this.avm = (BdListView) this.mRootView.findViewById(d.g.dialog_content_list);
        this.aQe = this.mRootView.findViewById(d.g.line_bg);
        this.aQr = new f(this.aQs);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public d db(String str) {
        this.mTitle = str;
        return this;
    }

    public d fk(int i) {
        return db(this.aQs.getResources().getString(i));
    }

    public d a(ArrayList<g> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
                this.avm.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public d AF() {
        if (!this.aPS) {
            this.aPS = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.aQe.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.aQe.setVisibility(8);
            }
            this.avm.setAdapter((ListAdapter) this.aQr);
            this.aQr.setData(this.mItems);
            c(this.aQs);
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
        this.aQr.setData(this.mItems);
    }

    public d AG() {
        if (!this.aPS) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aPQ != null) {
            com.baidu.adp.lib.g.g.a(this.aPQ, this.aQs);
        } else {
            this.aPQ = new AlertDialog.Builder(this.aQs.getPageActivity()).create();
            this.aPQ.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.aPQ, this.aQs.getPageActivity())) {
                Window window = this.aPQ.getWindow();
                if (this.aQg == -1) {
                    this.aQg = a.aQn;
                }
                if (this.aPF == -1) {
                    this.aPF = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.aPF);
                window.setBackgroundDrawableResource(d.f.transparent_bg);
                window.setContentView(this.mRootView);
            }
        }
        return this;
    }

    private void c(com.baidu.adp.base.e<?> eVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().aN(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().aM(this.mRootView);
        }
        this.mRootView.setBackgroundResource(d.f.transparent_bg);
    }

    public void dismiss() {
        if (this.aPQ != null) {
            com.baidu.adp.lib.g.g.b(this.aPQ, this.aQs.getPageActivity());
        }
    }
}
