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
    private com.baidu.adp.lib.e.b<TbImageView> aeI;
    private a aeJ;
    private LinearLayout.LayoutParams aeK;
    private boolean aeL;
    private int aeM;
    private boolean aeN;
    com.baidu.tbadk.imageManager.b aeO;
    private Context mContext;
    private int mIconWidth;

    /* loaded from: classes.dex */
    public interface b {
        ListView getListView();

        int vD();

        com.baidu.adp.lib.e.b<TbImageView> vE();
    }

    public void setAutoChangedStyle(boolean z) {
        this.aeL = z;
    }

    public UserIconBox(Context context) {
        super(context);
        this.aeI = null;
        this.aeJ = null;
        this.aeL = true;
        this.aeO = new u(this);
        init(context);
    }

    public UserIconBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeI = null;
        this.aeJ = null;
        this.aeL = true;
        this.aeO = new u(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        if (this.mContext instanceof b) {
            b bVar = (b) this.mContext;
            this.aeI = bVar.vE();
            if (bVar.getListView() != null && this.aeJ == null) {
                this.aeJ = new a(bVar.vD());
                bVar.getListView().setRecyclerListener(this.aeJ);
            }
        }
        setOnHierarchyChangeListener(new w(this));
    }

    private LinearLayout.LayoutParams q(int i, int i2, int i3) {
        this.aeK = new LinearLayout.LayoutParams(i, i2);
        this.aeK.leftMargin = i3;
        return this.aeK;
    }

    public void a(List<IconData> list, int i, int i2, int i3, int i4, boolean z) {
        this.mIconWidth = i2;
        this.aeM = i4;
        this.aeN = z;
        removeAllViews();
        this.mIconWidth = i2;
        if (list == null || list.size() != 1 || !TextUtils.isEmpty(list.get(0).getIcon())) {
            if (list != null && list.size() > 0) {
                LinearLayout.LayoutParams q = q(i2, i3, i4);
                LinearLayout.LayoutParams q2 = q(i2, i3, 0);
                setVisibility(0);
                for (int i5 = 0; i5 < i && i5 < list.size(); i5++) {
                    TbImageView ai = ai(this.mContext);
                    if (ai != null) {
                        ai.setDefaultResource(i.e.icon_moren);
                        if (i5 == 0 && z) {
                            ai.setLayoutParams(q2);
                        } else {
                            ai.setLayoutParams(q);
                        }
                        ai.setTag(list.get(i5).getIcon());
                        ai.setClickable(false);
                        ai.setAutoChangeStyle(this.aeL);
                        ai.a(list.get(i5).getIcon(), 21, i2, i3, false);
                        addView(ai);
                        ai.invalidate();
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
                if (i6 == 0 && this.aeN) {
                    i5 += this.mIconWidth;
                } else {
                    i5 += this.mIconWidth + this.aeM;
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

    public void cP(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TbImageView) {
                ((TbImageView) childAt).setIsNight(TbadkCoreApplication.m411getInst().getSkinType() == 1);
            }
        }
    }

    private TbImageView ai(Context context) {
        TbImageView tbImageView = null;
        if (this.aeI != null) {
            tbImageView = this.aeI.gY();
        }
        if (tbImageView == null || tbImageView.getParent() != null) {
            return new TbImageView(context);
        }
        return tbImageView;
    }

    public static com.baidu.adp.lib.e.b<TbImageView> g(Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new x(context), i, 0);
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
