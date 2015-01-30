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
    private com.baidu.adp.lib.e.b<TbImageView> NY;
    private ar NZ;
    private LinearLayout.LayoutParams Oa;
    private boolean Ob;
    com.baidu.tbadk.imageManager.d Oc;
    private Context mContext;

    public void setAutoChangedStyle(boolean z) {
        this.Ob = z;
    }

    public UserIconBox(Context context) {
        super(context);
        this.NY = null;
        this.NZ = null;
        this.Ob = true;
        this.Oc = new an(this);
        init(context);
    }

    public UserIconBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.NY = null;
        this.NZ = null;
        this.Ob = true;
        this.Oc = new an(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        if (this.mContext instanceof as) {
            as asVar = (as) this.mContext;
            this.NY = asVar.qP();
            if (asVar.getListView() != null && this.NZ == null) {
                this.NZ = new ar(asVar.qO());
                asVar.getListView().setRecyclerListener(this.NZ);
            }
        }
        setOnHierarchyChangeListener(new ap(this));
    }

    private LinearLayout.LayoutParams r(int i, int i2, int i3) {
        this.Oa = new LinearLayout.LayoutParams(i, i2);
        this.Oa.leftMargin = i3;
        return this.Oa;
    }

    public void a(List<IconData> list, int i, int i2, int i3, int i4, boolean z) {
        removeAllViews();
        if (list == null || list.size() != 1 || !TextUtils.isEmpty(list.get(0).getIcon())) {
            if (list != null && list.size() > 0) {
                LinearLayout.LayoutParams r = r(i2, i3, i4);
                LinearLayout.LayoutParams r2 = r(i2, i3, 0);
                setVisibility(0);
                for (int i5 = 0; i5 < i && i5 < list.size(); i5++) {
                    TbImageView U = U(this.mContext);
                    if (U != null) {
                        if (i5 == 0 && z) {
                            U.setLayoutParams(r2);
                        } else {
                            U.setLayoutParams(r);
                        }
                        U.setTag(list.get(i5).getIcon());
                        U.setClickable(false);
                        U.setAutoChangeStyle(this.Ob);
                        U.a(list.get(i5).getIcon(), 21, i2, i3, false);
                        addView(U);
                        U.invalidate();
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

    public void ct(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TbImageView) {
                ((TbImageView) childAt).setIsNight(TbadkCoreApplication.m255getInst().getSkinType() == 1);
            }
        }
    }

    private TbImageView U(Context context) {
        TbImageView tbImageView = null;
        if (this.NY != null) {
            tbImageView = this.NY.ea();
        }
        if (tbImageView == null || tbImageView.getParent() != null) {
            return new TbImageView(context);
        }
        return tbImageView;
    }

    public static com.baidu.adp.lib.e.b<TbImageView> g(Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new aq(context), i, 0);
    }
}
