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
    private AlertDialog aPN;
    private View aQb;
    private f aQo;
    private TbPageContext<?> aQp;
    private BdListView avj;
    private ArrayList<g> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private ViewGroup mRootView;
    private String mTitle;
    private TextView mTitleView;
    private int aQd = -1;
    private int aPC = -1;
    private boolean aPP = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int aQk = d.k.dialog_ani_b2t;
        public static final int aQl = d.k.dialog_ani_t2b;
        public static final int LEFT_TO_RIGHT = d.k.dialog_ani_l2r;
        public static final int RIGHT_TO_LEFT = d.k.dialog_ani_r2l;
    }

    public d(TbPageContext<?> tbPageContext) {
        this.aQp = tbPageContext;
        this.mRootView = (ViewGroup) LayoutInflater.from(this.aQp.getPageActivity()).inflate(d.h.dialog_rich_layout, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.dialog_title_list);
        this.avj = (BdListView) this.mRootView.findViewById(d.g.dialog_content_list);
        this.aQb = this.mRootView.findViewById(d.g.line_bg);
        this.aQo = new f(this.aQp);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public d db(String str) {
        this.mTitle = str;
        return this;
    }

    public d fk(int i) {
        return db(this.aQp.getResources().getString(i));
    }

    public d a(ArrayList<g> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
                this.avj.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public d AE() {
        if (!this.aPP) {
            this.aPP = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.aQb.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.aQb.setVisibility(8);
            }
            this.avj.setAdapter((ListAdapter) this.aQo);
            this.aQo.setData(this.mItems);
            c(this.aQp);
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
        this.aQo.setData(this.mItems);
    }

    public d AF() {
        if (!this.aPP) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aPN != null) {
            com.baidu.adp.lib.g.g.a(this.aPN, this.aQp);
        } else {
            this.aPN = new AlertDialog.Builder(this.aQp.getPageActivity()).create();
            this.aPN.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.aPN, this.aQp.getPageActivity())) {
                Window window = this.aPN.getWindow();
                if (this.aQd == -1) {
                    this.aQd = a.aQk;
                }
                if (this.aPC == -1) {
                    this.aPC = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.aPC);
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
        if (this.aPN != null) {
            com.baidu.adp.lib.g.g.b(this.aPN, this.aQp.getPageActivity());
        }
    }
}
