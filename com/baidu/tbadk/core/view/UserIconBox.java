package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class UserIconBox extends LinearLayout {
    private com.baidu.adp.lib.d.b<TbImageView> fjw;
    private boolean fjx;
    private int fjy;
    private boolean fjz;
    private Context mContext;
    private int mIconWidth;

    /* loaded from: classes.dex */
    public interface a<T extends View> {
        com.baidu.adp.lib.d.b<TbImageView> bus();
    }

    public void setAutoChangedStyle(boolean z) {
        this.fjx = z;
    }

    public UserIconBox(Context context) {
        super(context);
        this.fjw = null;
        this.fjx = true;
        init(context);
    }

    public UserIconBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fjw = null;
        this.fjx = true;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        if (this.mContext instanceof a) {
            this.fjw = ((a) this.mContext).bus();
        }
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.core.view.UserIconBox.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && UserIconBox.this.fjw != null) {
                    UserIconBox.this.fjw.returnObject((TbImageView) view2);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }
        });
    }

    private LinearLayout.LayoutParams B(int i, int i2, int i3) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i2);
        layoutParams.leftMargin = i3;
        return layoutParams;
    }

    public void a(List<IconData> list, int i, int i2, int i3, int i4, boolean z) {
        if (list == null) {
            setVisibility(8);
            return;
        }
        int min = Math.min(i, x.getCount(list));
        if (min == 1 && TextUtils.isEmpty(list.get(0).getIcon())) {
            setVisibility(8);
            return;
        }
        this.mIconWidth = i2;
        this.fjy = i4;
        this.fjz = z;
        this.mIconWidth = i2;
        if (!pE(min)) {
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
                        tbImageView.setDefaultResource(R.drawable.icon_moren);
                        if (i5 == 0 && z) {
                            tbImageView.setLayoutParams(B(i2, i3, 0));
                        } else {
                            tbImageView.setLayoutParams(B(i2, i3, i4));
                        }
                        tbImageView.setTag(list.get(i5).getIcon());
                        if (!StringUtils.isNull(list.get(i5).getIconName())) {
                            tbImageView.setContentDescription(list.get(i5).getIconName());
                        }
                        tbImageView.setClickable(false);
                        tbImageView.setAutoChangeStyle(this.fjx);
                        tbImageView.setImageDrawable(null);
                        tbImageView.a(list.get(i5).getIcon(), 21, i2, i3, false);
                    }
                }
            }
        } else {
            setVisibility(8);
        }
    }

    private boolean pE(int i) {
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
                addView(ff(this.mContext));
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
                if (i6 == 0 && this.fjz) {
                    i5 += this.mIconWidth;
                } else {
                    i5 += this.mIconWidth + this.fjy;
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

    public void onChangeSkin(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TbImageView) {
                ((TbImageView) childAt).setIsNight(TbadkCoreApplication.getInst().getSkinType() == 1);
            }
        }
    }

    private TbImageView ff(Context context) {
        TbImageView tbImageView = null;
        if (this.fjw != null) {
            tbImageView = this.fjw.borrowObject();
        }
        if (tbImageView == null || tbImageView.getParent() != null) {
            return new TbImageView(context);
        }
        return tbImageView;
    }

    public static com.baidu.adp.lib.d.b<TbImageView> E(final Context context, int i) {
        return new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tbadk.core.view.UserIconBox.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bur */
            public TbImageView makeObject() {
                return new TbImageView(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: a */
            public void destroyObject(TbImageView tbImageView) {
                tbImageView.setBackgroundResource(0);
                tbImageView.setImageDrawable(null);
                tbImageView.setTag(null);
                tbImageView.setOnClickListener(null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: b */
            public TbImageView activateObject(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
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
}
