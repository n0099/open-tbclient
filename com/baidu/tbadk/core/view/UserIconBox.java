package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class UserIconBox extends LinearLayout {
    private com.baidu.adp.lib.e.b<TbImageView> afk;
    private a afl;
    private LinearLayout.LayoutParams afm;
    private boolean afn;
    private int afo;
    private boolean afp;
    com.baidu.tbadk.imageManager.b afq;
    private Context mContext;
    private int mIconWidth;

    /* loaded from: classes.dex */
    public interface b {
        ListView getListView();

        int vG();

        com.baidu.adp.lib.e.b<TbImageView> vH();
    }

    public void setAutoChangedStyle(boolean z) {
        this.afn = z;
    }

    public UserIconBox(Context context) {
        super(context);
        this.afk = null;
        this.afl = null;
        this.afn = true;
        this.afq = new ac(this);
        init(context);
    }

    public UserIconBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afk = null;
        this.afl = null;
        this.afn = true;
        this.afq = new ac(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        if (this.mContext instanceof b) {
            b bVar = (b) this.mContext;
            this.afk = bVar.vH();
            if (bVar.getListView() != null && this.afl == null) {
                this.afl = new a(bVar.vG());
                bVar.getListView().setRecyclerListener(this.afl);
            }
        }
        setOnHierarchyChangeListener(new ae(this));
    }

    private LinearLayout.LayoutParams p(int i, int i2, int i3) {
        this.afm = new LinearLayout.LayoutParams(i, i2);
        this.afm.leftMargin = i3;
        return this.afm;
    }

    public void a(List<IconData> list, int i, int i2, int i3, int i4, boolean z) {
        this.mIconWidth = i2;
        this.afo = i4;
        this.afp = z;
        removeAllViews();
        this.mIconWidth = i2;
        if (list == null || list.size() != 1 || !TextUtils.isEmpty(list.get(0).getIcon())) {
            if (list != null && list.size() > 0) {
                LinearLayout.LayoutParams p = p(i2, i3, i4);
                LinearLayout.LayoutParams p2 = p(i2, i3, 0);
                setVisibility(0);
                for (int i5 = 0; i5 < i && i5 < list.size(); i5++) {
                    TbImageView aj = aj(this.mContext);
                    if (aj != null) {
                        aj.setDefaultResource(i.e.icon_moren);
                        if (i5 == 0 && z) {
                            aj.setLayoutParams(p2);
                        } else {
                            aj.setLayoutParams(p);
                        }
                        aj.setTag(list.get(i5).getIcon());
                        aj.setClickable(false);
                        aj.setAutoChangeStyle(this.afn);
                        aj.a(list.get(i5).getIcon(), 21, i2, i3, false);
                        addView(aj);
                        aj.invalidate();
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

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int measuredWidth = getMeasuredWidth();
        boolean z2 = false;
        int i5 = 0;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            if (!z2) {
                if (i6 == 0 && this.afp) {
                    i5 += this.mIconWidth;
                } else {
                    i5 += this.mIconWidth + this.afo;
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

    public void cI(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TbImageView) {
                ((TbImageView) childAt).setIsNight(TbadkCoreApplication.m411getInst().getSkinType() == 1);
            }
        }
    }

    private TbImageView aj(Context context) {
        TbImageView tbImageView = null;
        if (this.afk != null) {
            tbImageView = this.afk.ha();
        }
        if (tbImageView == null || tbImageView.getParent() != null) {
            return new TbImageView(context);
        }
        return tbImageView;
    }

    public static com.baidu.adp.lib.e.b<TbImageView> g(Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new af(context), i, 0);
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
}
