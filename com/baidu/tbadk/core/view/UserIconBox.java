package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes.dex */
public class UserIconBox extends LinearLayout {
    private com.baidu.adp.lib.e.b<TbImageView> Iu;
    private ad Iv;
    private LinearLayout.LayoutParams Iw;
    private boolean Ix;
    com.baidu.tbadk.imageManager.d Iy;
    private Context mContext;

    public void setAutoChangedStyle(boolean z) {
        this.Ix = z;
    }

    public UserIconBox(Context context) {
        super(context);
        this.Iu = null;
        this.Iv = null;
        this.Ix = true;
        this.Iy = new z(this);
        init(context);
    }

    public UserIconBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Iu = null;
        this.Iv = null;
        this.Ix = true;
        this.Iy = new z(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        if (this.mContext instanceof ae) {
            ae aeVar = (ae) this.mContext;
            this.Iu = aeVar.nD();
            if (aeVar.getListView() != null && this.Iv == null) {
                this.Iv = new ad(aeVar.nC());
                aeVar.getListView().setRecyclerListener(this.Iv);
            }
        }
        setOnHierarchyChangeListener(new ab(this));
    }

    private LinearLayout.LayoutParams m(int i, int i2, int i3) {
        this.Iw = new LinearLayout.LayoutParams(i, i2);
        this.Iw.leftMargin = i3;
        return this.Iw;
    }

    public void a(List<IconData> list, int i, int i2, int i3, int i4, boolean z) {
        removeAllViews();
        if (list == null || list.size() != 1 || !TextUtils.isEmpty(list.get(0).getIcon())) {
            if (list != null && list.size() > 0) {
                LinearLayout.LayoutParams m = m(i2, i3, i4);
                LinearLayout.LayoutParams m2 = m(i2, i3, 0);
                setVisibility(0);
                for (int i5 = 0; i5 < i && i5 < list.size(); i5++) {
                    TbImageView w = w(this.mContext);
                    if (w != null) {
                        if (i5 == 0 && z) {
                            w.setLayoutParams(m2);
                        } else {
                            w.setLayoutParams(m);
                        }
                        w.setTag(list.get(i5).getIcon());
                        w.setClickable(false);
                        w.setAutoChangeStyle(this.Ix);
                        w.a(list.get(i5).getIcon(), 21, i2, i3, false);
                        addView(w);
                        w.invalidate();
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

    public void bN(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TbImageView) {
                ((TbImageView) childAt).setIsNight(TbadkApplication.m251getInst().getSkinType() == 1);
            }
        }
    }

    private TbImageView w(Context context) {
        TbImageView tbImageView = null;
        if (this.Iu != null) {
            tbImageView = this.Iu.ed();
        }
        if (tbImageView == null || tbImageView.getParent() != null) {
            return new TbImageView(context);
        }
        return tbImageView;
    }

    public static com.baidu.adp.lib.e.b<TbImageView> f(Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new ac(context), i, 0);
    }
}
