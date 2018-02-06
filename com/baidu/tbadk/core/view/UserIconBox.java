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
    private com.baidu.adp.lib.e.b<TbImageView> beZ;
    private a bfa;
    private boolean bfc;
    private int bfd;
    private boolean bfe;
    private Context mContext;
    private int mIconWidth;

    /* loaded from: classes.dex */
    public interface b<T extends View> {
        com.baidu.adp.lib.e.b<TbImageView> EA();

        T Ez();
    }

    public void setAutoChangedStyle(boolean z) {
        this.bfc = z;
    }

    public UserIconBox(Context context) {
        super(context);
        this.beZ = null;
        this.bfa = null;
        this.bfc = true;
        init(context);
    }

    public UserIconBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.beZ = null;
        this.bfa = null;
        this.bfc = true;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        if (this.mContext instanceof b) {
            b bVar = (b) this.mContext;
            this.beZ = bVar.EA();
            if (bVar.Ez() == null || this.bfa == null) {
            }
        }
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.core.view.UserIconBox.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && UserIconBox.this.beZ != null) {
                    UserIconBox.this.beZ.ar((TbImageView) view2);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }
        });
    }

    private LinearLayout.LayoutParams w(int i, int i2, int i3) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i2);
        layoutParams.leftMargin = i3;
        return layoutParams;
    }

    public void a(List<IconData> list, int i, int i2, int i3, int i4, boolean z) {
        if (list == null) {
            setVisibility(8);
            return;
        }
        int min = Math.min(i, v.D(list));
        if (min == 1 && TextUtils.isEmpty(list.get(0).getIcon())) {
            setVisibility(8);
            return;
        }
        this.mIconWidth = i2;
        this.bfd = i4;
        this.bfe = z;
        this.mIconWidth = i2;
        if (!gA(min)) {
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
                            tbImageView.setLayoutParams(w(i2, i3, 0));
                        } else {
                            tbImageView.setLayoutParams(w(i2, i3, i4));
                        }
                        tbImageView.setTag(list.get(i5).getIcon());
                        if (!StringUtils.isNull(list.get(i5).getIconName())) {
                            tbImageView.setContentDescription(list.get(i5).getIconName());
                        }
                        tbImageView.setClickable(false);
                        tbImageView.setAutoChangeStyle(this.bfc);
                        tbImageView.setImageDrawable(null);
                        tbImageView.startLoad(list.get(i5).getIcon(), 21, i2, i3, false);
                    }
                }
            }
        } else {
            setVisibility(8);
        }
    }

    private boolean gA(int i) {
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
                addView(bb(this.mContext));
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
                if (i6 == 0 && this.bfe) {
                    i5 += this.mIconWidth;
                } else {
                    i5 += this.mIconWidth + this.bfd;
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

    public void gB(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TbImageView) {
                ((TbImageView) childAt).setIsNight(TbadkCoreApplication.getInst().getSkinType() == 1);
            }
        }
    }

    private TbImageView bb(Context context) {
        TbImageView tbImageView = null;
        if (this.beZ != null) {
            tbImageView = this.beZ.nk();
        }
        if (tbImageView == null || tbImageView.getParent() != null) {
            return new TbImageView(context);
        }
        return tbImageView;
    }

    public static com.baidu.adp.lib.e.b<TbImageView> w(final Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tbadk.core.view.UserIconBox.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ey */
            public TbImageView nl() {
                return new TbImageView(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void as(TbImageView tbImageView) {
                tbImageView.setBackgroundResource(0);
                tbImageView.setImageDrawable(null);
                tbImageView.setTag(null);
                tbImageView.setOnClickListener(null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView at(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView au(TbImageView tbImageView) {
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
