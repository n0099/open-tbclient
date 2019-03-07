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
    private BdListView Pi;
    private AlertDialog bEB;
    private View bEP;
    private j bFe;
    private TbPageContext<?> mContext;
    private ArrayList<k> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private ViewGroup mRootView;
    private String mTitle;
    private TextView mTitleView;
    private int bER = -1;
    private int bEo = -1;
    private boolean bED = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int bEY = d.k.dialog_ani_b2t;
        public static final int bEZ = d.k.dialog_ani_t2b;
        public static final int LEFT_TO_RIGHT = d.k.dialog_ani_l2r;
        public static final int RIGHT_TO_LEFT = d.k.dialog_ani_r2l;
    }

    public e(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.dialog_rich_layout, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.dialog_title_list);
        this.Pi = (BdListView) this.mRootView.findViewById(d.g.dialog_content_list);
        this.bEP = this.mRootView.findViewById(d.g.line_bg);
        this.bFe = new j(this.mContext);
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
                this.Pi.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public e abd() {
        if (!this.bED) {
            this.bED = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.bEP.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.bEP.setVisibility(8);
            }
            this.Pi.setAdapter((ListAdapter) this.bFe);
            this.bFe.setData(this.mItems);
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
        this.bFe.setData(this.mItems);
    }

    public e abe() {
        if (!this.bED) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.bEB != null) {
            com.baidu.adp.lib.g.g.a(this.bEB, this.mContext);
        } else {
            this.bEB = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
            this.bEB.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.bEB, this.mContext.getPageActivity())) {
                Window window = this.bEB.getWindow();
                if (this.bER == -1) {
                    this.bER = a.bEY;
                }
                if (this.bEo == -1) {
                    this.bEo = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.bEo);
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
        if (this.bEB != null) {
            com.baidu.adp.lib.g.g.b(this.bEB, this.mContext.getPageActivity());
        }
    }
}
