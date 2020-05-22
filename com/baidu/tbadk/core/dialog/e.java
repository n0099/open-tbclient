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
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e {
    private BdListView Um;
    private l dIE;
    private TbPageContext<?> dIF;
    private AlertDialog mDialog;
    private ArrayList<m> mItems;
    private View mLineView;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private ViewGroup mRootView;
    private String mTitle;
    private TextView mTitleView;
    private int mAnimationStyleId = -1;
    private int mDialogGravity = -1;
    private boolean mDialogCreated = false;

    public e(TbPageContext<?> tbPageContext) {
        this.dIF = tbPageContext;
        this.mRootView = (ViewGroup) LayoutInflater.from(this.dIF.getPageActivity()).inflate(R.layout.dialog_rich_layout, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.dialog_title_list);
        this.Um = (BdListView) this.mRootView.findViewById(R.id.dialog_content_list);
        this.mLineView = this.mRootView.findViewById(R.id.line_bg);
        this.dIE = new l(this.dIF);
    }

    public e vQ(String str) {
        this.mTitle = str;
        return this;
    }

    public e kK(int i) {
        return vQ(this.dIF.getResources().getString(i));
    }

    public e a(ArrayList<m> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mItems = arrayList;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
                this.Um.setOnItemClickListener(this.mOnItemClickListener);
            }
        }
        return this;
    }

    public e aSV() {
        if (!this.mDialogCreated) {
            this.mDialogCreated = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.mLineView.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.mLineView.setVisibility(8);
            }
            this.Um.setAdapter((ListAdapter) this.dIE);
            this.dIE.setData(this.mItems);
            c(this.dIF);
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
        this.dIE.setData(this.mItems);
    }

    public e aSW() {
        if (!this.mDialogCreated) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.mDialog != null) {
            com.baidu.adp.lib.f.g.a(this.mDialog, this.dIF);
        } else {
            this.mDialog = new AlertDialog.Builder(this.dIF.getPageActivity()).create();
            this.mDialog.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.f.g.showDialog(this.mDialog, this.dIF.getPageActivity())) {
                Window window = this.mDialog.getWindow();
                if (this.mAnimationStyleId == -1) {
                    this.mAnimationStyleId = R.style.dialog_ani_b2t;
                }
                if (this.mDialogGravity == -1) {
                    this.mDialogGravity = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.mDialogGravity);
                window.setBackgroundDrawableResource(R.drawable.transparent_bg);
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
        this.mRootView.setBackgroundResource(R.drawable.transparent_bg);
    }

    public void onChangeSkinType() {
        c(this.dIF);
        if (this.dIE != null) {
            this.dIE.notifyDataSetChanged();
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.mDialog, this.dIF.getPageActivity());
        }
    }
}
