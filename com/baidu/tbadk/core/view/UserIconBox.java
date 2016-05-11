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
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class UserIconBox extends LinearLayout {
    private boolean adA;
    private boolean adB;
    com.baidu.tbadk.imageManager.b adC;
    private com.baidu.adp.lib.f.b<TbImageView> adv;
    private a adw;
    private LinearLayout.LayoutParams adx;
    private boolean ady;
    private int adz;
    private Context mContext;
    private int mIconWidth;

    /* loaded from: classes.dex */
    public interface b {
        ListView getListView();

        int vx();

        com.baidu.adp.lib.f.b<TbImageView> vy();
    }

    public void setAutoChangedStyle(boolean z) {
        this.ady = z;
    }

    public UserIconBox(Context context) {
        super(context);
        this.adv = null;
        this.adw = null;
        this.ady = true;
        this.adB = false;
        this.adC = new ai(this);
        init(context);
    }

    public UserIconBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adv = null;
        this.adw = null;
        this.ady = true;
        this.adB = false;
        this.adC = new ai(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        if (this.mContext instanceof b) {
            b bVar = (b) this.mContext;
            this.adv = bVar.vy();
            if (bVar.getListView() != null && this.adw == null) {
                this.adw = new a(bVar.vx());
                bVar.getListView().setRecyclerListener(this.adw);
            }
        }
        setOnHierarchyChangeListener(new ak(this));
    }

    private LinearLayout.LayoutParams o(int i, int i2, int i3) {
        this.adx = new LinearLayout.LayoutParams(i, i2);
        this.adx.leftMargin = i3;
        return this.adx;
    }

    public void a(List<IconData> list, int i, int i2, int i3, int i4, boolean z) {
        TbImageView tbImageView;
        if (list == null) {
            setVisibility(8);
            return;
        }
        int min = Math.min(i, com.baidu.tbadk.core.util.y.r(list));
        if (min == 1 && TextUtils.isEmpty(list.get(0).getIcon())) {
            setVisibility(8);
            return;
        }
        this.mIconWidth = i2;
        this.adz = i4;
        this.adA = z;
        this.mIconWidth = i2;
        if (!cV(min)) {
            setVisibility(8);
        } else if (min > 0) {
            setVisibility(0);
            for (int i5 = 0; i5 < min; i5++) {
                View childAt = getChildAt(i5);
                if ((childAt instanceof TbImageView) && (tbImageView = (TbImageView) childAt) != null) {
                    if (this.adB) {
                        tbImageView.setForegroundColor(com.baidu.tbadk.core.util.at.getColor(t.d.impress_cover_alpha50));
                    } else {
                        tbImageView.setForegroundColor(0);
                    }
                    tbImageView.setDefaultResource(t.f.icon_moren);
                    if (i5 == 0 && z) {
                        tbImageView.setLayoutParams(o(i2, i3, 0));
                    } else {
                        tbImageView.setLayoutParams(o(i2, i3, i4));
                    }
                    tbImageView.setTag(list.get(i5).getIcon());
                    if (!StringUtils.isNull(list.get(i5).getIconName())) {
                        tbImageView.setContentDescription(list.get(i5).getIconName());
                    }
                    tbImageView.setClickable(false);
                    tbImageView.setAutoChangeStyle(this.ady);
                    tbImageView.a(list.get(i5).getIcon(), 21, i2, i3, false);
                }
            }
        } else {
            setVisibility(8);
        }
    }

    private boolean cV(int i) {
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
                addView(ae(this.mContext));
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
                if (i6 == 0 && this.adA) {
                    i5 += this.mIconWidth;
                } else {
                    i5 += this.mIconWidth + this.adz;
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

    public void cW(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TbImageView) {
                ((TbImageView) childAt).setIsNight(TbadkCoreApplication.m11getInst().getSkinType() == 1);
            }
        }
    }

    private TbImageView ae(Context context) {
        TbImageView tbImageView = null;
        if (this.adv != null) {
            tbImageView = this.adv.dD();
        }
        if (tbImageView == null || tbImageView.getParent() != null) {
            return new TbImageView(context);
        }
        return tbImageView;
    }

    public static com.baidu.adp.lib.f.b<TbImageView> e(Context context, int i) {
        return new com.baidu.adp.lib.f.b<>(new al(context), i, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements AbsListView.RecyclerListener {
        private int mId;

        public a(int i) {
            this.mId = 0;
            this.mId = i;
        }

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
            View findViewById = view.findViewById(this.mId);
            if (findViewById != null && (findViewById instanceof UserIconBox)) {
                ((UserIconBox) findViewById).a(null, 0, 0, 0, 0);
            }
        }
    }

    public void vv() {
        this.adB = true;
    }
}
