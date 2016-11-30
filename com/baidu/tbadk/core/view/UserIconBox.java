package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class UserIconBox extends LinearLayout {
    private com.baidu.adp.lib.f.b<TbImageView> ahK;
    private a ahL;
    private LinearLayout.LayoutParams ahM;
    private boolean ahN;
    private int ahO;
    private boolean ahP;
    private boolean ahQ;
    com.baidu.tbadk.imageManager.b ahR;
    private Context mContext;
    private int mIconWidth;

    /* loaded from: classes.dex */
    public interface b {
        ListView getListView();

        com.baidu.adp.lib.f.b<TbImageView> wS();
    }

    public void setAutoChangedStyle(boolean z) {
        this.ahN = z;
    }

    public UserIconBox(Context context) {
        super(context);
        this.ahK = null;
        this.ahL = null;
        this.ahN = true;
        this.ahQ = false;
        this.ahR = new ai(this);
        init(context);
    }

    public UserIconBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahK = null;
        this.ahL = null;
        this.ahN = true;
        this.ahQ = false;
        this.ahR = new ai(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        if (this.mContext instanceof b) {
            b bVar = (b) this.mContext;
            this.ahK = bVar.wS();
            if (bVar.getListView() != null) {
            }
        }
        setOnHierarchyChangeListener(new ak(this));
    }

    private LinearLayout.LayoutParams p(int i, int i2, int i3) {
        this.ahM = new LinearLayout.LayoutParams(i, i2);
        this.ahM.leftMargin = i3;
        return this.ahM;
    }

    public void a(List<IconData> list, int i, int i2, int i3, int i4, boolean z) {
        TbImageView tbImageView;
        if (list == null) {
            setVisibility(8);
            return;
        }
        int min = Math.min(i, com.baidu.tbadk.core.util.x.s(list));
        if (min == 1 && TextUtils.isEmpty(list.get(0).getIcon())) {
            setVisibility(8);
            return;
        }
        this.mIconWidth = i2;
        this.ahO = i4;
        this.ahP = z;
        this.mIconWidth = i2;
        if (!dl(min)) {
            setVisibility(8);
        } else if (min > 0) {
            setVisibility(0);
            for (int i5 = 0; i5 < min; i5++) {
                View childAt = getChildAt(i5);
                if ((childAt instanceof TbImageView) && (tbImageView = (TbImageView) childAt) != null) {
                    if (this.ahQ) {
                        tbImageView.setForegroundColor(at.getColor(r.d.white_alpha30));
                    } else {
                        tbImageView.setForegroundColor(0);
                    }
                    tbImageView.setDefaultResource(r.f.icon_moren);
                    if (i5 == 0 && z) {
                        tbImageView.setLayoutParams(p(i2, i3, 0));
                    } else {
                        tbImageView.setLayoutParams(p(i2, i3, i4));
                    }
                    tbImageView.setTag(list.get(i5).getIcon());
                    if (!StringUtils.isNull(list.get(i5).getIconName())) {
                        tbImageView.setContentDescription(list.get(i5).getIconName());
                    }
                    tbImageView.setClickable(false);
                    tbImageView.setAutoChangeStyle(this.ahN);
                    tbImageView.a(list.get(i5).getIcon(), 21, i2, i3, false);
                }
            }
        } else {
            setVisibility(8);
        }
    }

    private boolean dl(int i) {
        if (i <= 0) {
            return false;
        }
        int childCount = getChildCount();
        if (i == childCount) {
            return true;
        }
        int i2 = i - childCount;
        if (i2 > 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                addView(al(this.mContext));
            }
        } else {
            removeViews(i, Math.abs(i2));
        }
        return true;
    }

    public void a(List<IconData> list, int i, int i2, int i3, int i4) {
        a(list, i, i2, i3, i4, false);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int measuredWidth = getMeasuredWidth();
        int childCount = getChildCount();
        boolean z2 = false;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (!z2) {
                if (i6 == 0 && this.ahP) {
                    i5 += this.mIconWidth;
                } else {
                    i5 += this.mIconWidth + this.ahO;
                }
                if (i5 > measuredWidth) {
                    z2 = true;
                }
            }
            if (z2) {
                childAt.layout(0, 0, 0, 0);
            }
        }
    }

    public void dm(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TbImageView) {
                ((TbImageView) childAt).setIsNight(TbadkCoreApplication.m9getInst().getSkinType() == 1);
            }
        }
    }

    private TbImageView al(Context context) {
        TbImageView tbImageView = null;
        if (this.ahK != null) {
            tbImageView = this.ahK.ey();
        }
        if (tbImageView == null || tbImageView.getParent() != null) {
            return new TbImageView(context);
        }
        return tbImageView;
    }

    public static com.baidu.adp.lib.f.b<TbImageView> g(Context context, int i) {
        return new com.baidu.adp.lib.f.b<>(new al(context), i, 0);
    }

    /* loaded from: classes.dex */
    private static class a implements AbsListView.RecyclerListener {
        private int mId;

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
            View findViewById = view.findViewById(this.mId);
            if (findViewById != null && (findViewById instanceof UserIconBox)) {
                ((UserIconBox) findViewById).a(null, 0, 0, 0, 0);
            }
        }
    }

    public void wQ() {
        this.ahQ = true;
    }
}
