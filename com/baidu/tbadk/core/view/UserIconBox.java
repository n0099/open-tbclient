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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class UserIconBox extends LinearLayout {
    private com.baidu.adp.lib.f.b<TbImageView> aeH;
    private a aeI;
    private LinearLayout.LayoutParams aeJ;
    private boolean aeK;
    private int aeL;
    private boolean aeM;
    private boolean aeN;
    com.baidu.tbadk.imageManager.b aeO;
    private Context mContext;
    private int mIconWidth;

    /* loaded from: classes.dex */
    public interface b {
        ListView getListView();

        int vA();

        com.baidu.adp.lib.f.b<TbImageView> vB();
    }

    public void setAutoChangedStyle(boolean z) {
        this.aeK = z;
    }

    public UserIconBox(Context context) {
        super(context);
        this.aeH = null;
        this.aeI = null;
        this.aeK = true;
        this.aeN = false;
        this.aeO = new ai(this);
        init(context);
    }

    public UserIconBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeH = null;
        this.aeI = null;
        this.aeK = true;
        this.aeN = false;
        this.aeO = new ai(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        if (this.mContext instanceof b) {
            b bVar = (b) this.mContext;
            this.aeH = bVar.vB();
            if (bVar.getListView() != null && this.aeI == null) {
                this.aeI = new a(bVar.vA());
                bVar.getListView().setRecyclerListener(this.aeI);
            }
        }
        setOnHierarchyChangeListener(new ak(this));
    }

    private LinearLayout.LayoutParams p(int i, int i2, int i3) {
        this.aeJ = new LinearLayout.LayoutParams(i, i2);
        this.aeJ.leftMargin = i3;
        return this.aeJ;
    }

    public void a(List<IconData> list, int i, int i2, int i3, int i4, boolean z) {
        TbImageView tbImageView;
        if (list == null) {
            setVisibility(8);
            return;
        }
        int min = Math.min(i, com.baidu.tbadk.core.util.y.s(list));
        if (min == 1 && TextUtils.isEmpty(list.get(0).getIcon())) {
            setVisibility(8);
            return;
        }
        this.mIconWidth = i2;
        this.aeL = i4;
        this.aeM = z;
        this.mIconWidth = i2;
        if (!cW(min)) {
            setVisibility(8);
        } else if (min > 0) {
            setVisibility(0);
            for (int i5 = 0; i5 < min; i5++) {
                View childAt = getChildAt(i5);
                if ((childAt instanceof TbImageView) && (tbImageView = (TbImageView) childAt) != null) {
                    if (this.aeN) {
                        tbImageView.setForegroundColor(av.getColor(u.d.common_color_10294));
                    } else {
                        tbImageView.setForegroundColor(0);
                    }
                    tbImageView.setDefaultResource(u.f.icon_moren);
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
                    tbImageView.setAutoChangeStyle(this.aeK);
                    tbImageView.a(list.get(i5).getIcon(), 21, i2, i3, false);
                }
            }
        } else {
            setVisibility(8);
        }
    }

    private boolean cW(int i) {
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
                addView(ad(this.mContext));
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
                if (i6 == 0 && this.aeM) {
                    i5 += this.mIconWidth;
                } else {
                    i5 += this.mIconWidth + this.aeL;
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

    public void cX(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TbImageView) {
                ((TbImageView) childAt).setIsNight(TbadkCoreApplication.m10getInst().getSkinType() == 1);
            }
        }
    }

    private TbImageView ad(Context context) {
        TbImageView tbImageView = null;
        if (this.aeH != null) {
            tbImageView = this.aeH.dD();
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

    public void vy() {
        this.aeN = true;
    }
}
