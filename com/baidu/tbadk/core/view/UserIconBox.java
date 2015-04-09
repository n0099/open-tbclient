package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes.dex */
public class UserIconBox extends LinearLayout {
    private com.baidu.adp.lib.e.b<TbImageView> Zi;
    private an Zj;
    private LinearLayout.LayoutParams Zk;
    private boolean Zl;
    com.baidu.tbadk.imageManager.d Zm;
    private Context mContext;

    public void setAutoChangedStyle(boolean z) {
        this.Zl = z;
    }

    public UserIconBox(Context context) {
        super(context);
        this.Zi = null;
        this.Zj = null;
        this.Zl = true;
        this.Zm = new aj(this);
        init(context);
    }

    public UserIconBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Zi = null;
        this.Zj = null;
        this.Zl = true;
        this.Zm = new aj(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        if (this.mContext instanceof ao) {
            ao aoVar = (ao) this.mContext;
            this.Zi = aoVar.tT();
            if (aoVar.getListView() != null && this.Zj == null) {
                this.Zj = new an(aoVar.tS());
                aoVar.getListView().setRecyclerListener(this.Zj);
            }
        }
        setOnHierarchyChangeListener(new al(this));
    }

    private LinearLayout.LayoutParams r(int i, int i2, int i3) {
        this.Zk = new LinearLayout.LayoutParams(i, i2);
        this.Zk.leftMargin = i3;
        return this.Zk;
    }

    public void a(List<IconData> list, int i, int i2, int i3, int i4, boolean z) {
        removeAllViews();
        if (list == null || list.size() != 1 || !TextUtils.isEmpty(list.get(0).getIcon())) {
            if (list != null && list.size() > 0) {
                LinearLayout.LayoutParams r = r(i2, i3, i4);
                LinearLayout.LayoutParams r2 = r(i2, i3, 0);
                setVisibility(0);
                for (int i5 = 0; i5 < i && i5 < list.size(); i5++) {
                    TbImageView ad = ad(this.mContext);
                    if (ad != null) {
                        if (i5 == 0 && z) {
                            ad.setLayoutParams(r2);
                        } else {
                            ad.setLayoutParams(r);
                        }
                        ad.setTag(list.get(i5).getIcon());
                        ad.setClickable(false);
                        ad.setAutoChangeStyle(this.Zl);
                        ad.a(list.get(i5).getIcon(), 21, i2, i3, false);
                        addView(ad);
                        ad.invalidate();
                    }
                }
                return;
            }
            setVisibility(8);
        }
    }

    public void a(List<IconData> list, int i, int i2, int i3, int i4) {
        a(list, i, i2, i3, i4, false);
    }

    public void cu(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TbImageView) {
                ((TbImageView) childAt).setIsNight(TbadkCoreApplication.m411getInst().getSkinType() == 1);
            }
        }
    }

    private TbImageView ad(Context context) {
        TbImageView tbImageView = null;
        if (this.Zi != null) {
            tbImageView = this.Zi.hz();
        }
        if (tbImageView == null || tbImageView.getParent() != null) {
            return new TbImageView(context);
        }
        return tbImageView;
    }

    public static com.baidu.adp.lib.e.b<TbImageView> g(Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new am(context), i, 0);
    }
}
