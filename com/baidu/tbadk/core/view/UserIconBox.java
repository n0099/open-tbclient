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
    private com.baidu.adp.lib.e.b<TbImageView> aaj;
    private as aak;
    private LinearLayout.LayoutParams aal;
    private boolean aam;
    com.baidu.tbadk.imageManager.d aan;
    private Context mContext;

    public void setAutoChangedStyle(boolean z) {
        this.aam = z;
    }

    public UserIconBox(Context context) {
        super(context);
        this.aaj = null;
        this.aak = null;
        this.aam = true;
        this.aan = new ao(this);
        init(context);
    }

    public UserIconBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aaj = null;
        this.aak = null;
        this.aam = true;
        this.aan = new ao(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        if (this.mContext instanceof at) {
            at atVar = (at) this.mContext;
            this.aaj = atVar.uC();
            if (atVar.getListView() != null && this.aak == null) {
                this.aak = new as(atVar.uB());
                atVar.getListView().setRecyclerListener(this.aak);
            }
        }
        setOnHierarchyChangeListener(new aq(this));
    }

    private LinearLayout.LayoutParams r(int i, int i2, int i3) {
        this.aal = new LinearLayout.LayoutParams(i, i2);
        this.aal.leftMargin = i3;
        return this.aal;
    }

    public void a(List<IconData> list, int i, int i2, int i3, int i4, boolean z) {
        removeAllViews();
        if (list == null || list.size() != 1 || !TextUtils.isEmpty(list.get(0).getIcon())) {
            if (list != null && list.size() > 0) {
                LinearLayout.LayoutParams r = r(i2, i3, i4);
                LinearLayout.LayoutParams r2 = r(i2, i3, 0);
                setVisibility(0);
                for (int i5 = 0; i5 < i && i5 < list.size(); i5++) {
                    TbImageView ah = ah(this.mContext);
                    if (ah != null) {
                        if (i5 == 0 && z) {
                            ah.setLayoutParams(r2);
                        } else {
                            ah.setLayoutParams(r);
                        }
                        ah.setTag(list.get(i5).getIcon());
                        ah.setClickable(false);
                        ah.setAutoChangeStyle(this.aam);
                        ah.a(list.get(i5).getIcon(), 21, i2, i3, false);
                        addView(ah);
                        ah.invalidate();
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

    public void cz(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TbImageView) {
                ((TbImageView) childAt).setIsNight(TbadkCoreApplication.m411getInst().getSkinType() == 1);
            }
        }
    }

    private TbImageView ah(Context context) {
        TbImageView tbImageView = null;
        if (this.aaj != null) {
            tbImageView = this.aaj.hj();
        }
        if (tbImageView == null || tbImageView.getParent() != null) {
            return new TbImageView(context);
        }
        return tbImageView;
    }

    public static com.baidu.adp.lib.e.b<TbImageView> g(Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new ar(context), i, 0);
    }
}
