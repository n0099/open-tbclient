package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class UserIconBox extends LinearLayout {
    private int bPj;
    private com.baidu.adp.lib.e.b<TbImageView> bTR;
    private a bTS;
    private boolean bTT;
    private int bTU;
    private boolean bTV;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface b<T extends View> {
        T afc();

        com.baidu.adp.lib.e.b<TbImageView> afd();
    }

    public void setAutoChangedStyle(boolean z) {
        this.bTT = z;
    }

    public UserIconBox(Context context) {
        super(context);
        this.bTR = null;
        this.bTS = null;
        this.bTT = true;
        init(context);
    }

    public UserIconBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bTR = null;
        this.bTS = null;
        this.bTT = true;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        if (this.mContext instanceof b) {
            b bVar = (b) this.mContext;
            this.bTR = bVar.afd();
            if (bVar.afc() == null || this.bTS == null) {
            }
        }
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.core.view.UserIconBox.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && UserIconBox.this.bTR != null) {
                    UserIconBox.this.bTR.t((TbImageView) view2);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }
        });
    }

    private LinearLayout.LayoutParams q(int i, int i2, int i3) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i2);
        layoutParams.leftMargin = i3;
        return layoutParams;
    }

    public void a(List<IconData> list, int i, int i2, int i3, int i4, boolean z) {
        if (list == null) {
            setVisibility(8);
            return;
        }
        int min = Math.min(i, v.S(list));
        if (min == 1 && TextUtils.isEmpty(list.get(0).getIcon())) {
            setVisibility(8);
            return;
        }
        this.bPj = i2;
        this.bTU = i4;
        this.bTV = z;
        this.bPj = i2;
        if (!ii(min)) {
            setVisibility(8);
        } else if (min > 0) {
            setVisibility(0);
            for (int i5 = 0; i5 < min; i5++) {
                View childAt = getChildAt(i5);
                if (childAt instanceof TbImageView) {
                    if (StringUtils.isNull(list.get(i5).getIcon())) {
                        childAt.setVisibility(8);
                    } else {
                        childAt.setVisibility(0);
                        TbImageView tbImageView = (TbImageView) childAt;
                        tbImageView.setDefaultResource(d.f.icon_moren);
                        if (i5 == 0 && z) {
                            tbImageView.setLayoutParams(q(i2, i3, 0));
                        } else {
                            tbImageView.setLayoutParams(q(i2, i3, i4));
                        }
                        tbImageView.setTag(list.get(i5).getIcon());
                        if (!StringUtils.isNull(list.get(i5).getIconName())) {
                            tbImageView.setContentDescription(list.get(i5).getIconName());
                        }
                        tbImageView.setClickable(false);
                        tbImageView.setAutoChangeStyle(this.bTT);
                        tbImageView.setImageDrawable(null);
                        tbImageView.startLoad(list.get(i5).getIcon(), 21, i2, i3, false);
                    }
                }
            }
        } else {
            setVisibility(8);
        }
    }

    private boolean ii(int i) {
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
                addView(db(this.mContext));
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
                if (i6 == 0 && this.bTV) {
                    i5 += this.bPj;
                } else {
                    i5 += this.bPj + this.bTU;
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

    public void ij(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TbImageView) {
                ((TbImageView) childAt).setIsNight(TbadkCoreApplication.getInst().getSkinType() == 1);
            }
        }
    }

    private TbImageView db(Context context) {
        TbImageView tbImageView = null;
        if (this.bTR != null) {
            tbImageView = this.bTR.jA();
        }
        if (tbImageView == null || tbImageView.getParent() != null) {
            return new TbImageView(context);
        }
        return tbImageView;
    }

    public static com.baidu.adp.lib.e.b<TbImageView> q(final Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tbadk.core.view.UserIconBox.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: afb */
            public TbImageView makeObject() {
                return new TbImageView(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void destroyObject(TbImageView tbImageView) {
                tbImageView.setBackgroundResource(0);
                tbImageView.setImageDrawable(null);
                tbImageView.setTag(null);
                tbImageView.setOnClickListener(null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView activateObject(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView passivateObject(TbImageView tbImageView) {
                tbImageView.setBackgroundResource(0);
                tbImageView.setImageDrawable(null);
                tbImageView.setTag(null);
                tbImageView.setOnClickListener(null);
                return tbImageView;
            }
        }, i, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements AbsListView.RecyclerListener {
        private int mId;

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
            View findViewById = view.findViewById(this.mId);
            if (findViewById != null && (findViewById instanceof UserIconBox)) {
                ((UserIconBox) findViewById).a(null, 0, 0, 0, 0);
            }
        }
    }
}
