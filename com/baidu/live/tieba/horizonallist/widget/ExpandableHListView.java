package com.baidu.live.tieba.horizonallist.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ExpandableListAdapter;
import android.widget.ListAdapter;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.tieba.horizonallist.widget.ExpandableHListConnector;
import com.baidu.live.u.a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ExpandableHListView extends HListView {
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] aAh = {16842920};
    private static final int[] aAi = {16842921};
    private static final int[] aAj = {16842920, 16842921};
    private static final int[][] aAk = {EMPTY_STATE_SET, aAh, aAi, aAj};
    private static final int[] aAl = {16842918};
    private int aAa;
    private int aAb;
    private int aAc;
    private int aAd;
    private int aAe;
    private Drawable aAf;
    private Drawable aAg;
    private Drawable aAm;
    private final Rect aAn;
    private int aAo;
    private int aAp;
    private int aAq;
    private int aAr;
    private d aAs;
    private e aAt;
    private c aAu;
    private b aAv;
    private ExpandableHListConnector azY;
    private ExpandableListAdapter azZ;
    private int mIndicatorLeft;
    private final Rect mTempRect;

    /* loaded from: classes3.dex */
    public interface b {
        boolean a(ExpandableHListView expandableHListView, View view, int i, int i2, long j);
    }

    /* loaded from: classes3.dex */
    public interface c {
        boolean a(ExpandableHListView expandableHListView, View view, int i, long j);
    }

    /* loaded from: classes3.dex */
    public interface d {
        void cB(int i);
    }

    /* loaded from: classes3.dex */
    public interface e {
        void cC(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.c.sdk_hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aAn = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.aAa = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.aAb = obtainStyledAttributes.getInt(a.k.sdk_ExpandableHListView_sdk_hlv_indicatorGravity, 0);
        this.aAc = obtainStyledAttributes.getInt(a.k.sdk_ExpandableHListView_sdk_hlv_childIndicatorGravity, 0);
        this.aAe = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.aAd = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.aAm = obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        zZ();
        Aa();
    }

    private void zZ() {
        if (this.aAf != null) {
            this.aAo = this.aAf.getIntrinsicWidth();
            this.aAp = this.aAf.getIntrinsicHeight();
            return;
        }
        this.aAo = 0;
        this.aAp = 0;
    }

    private void Aa() {
        if (this.aAg != null) {
            this.aAq = this.aAg.getIntrinsicWidth();
            this.aAr = this.aAg.getIntrinsicHeight();
            return;
        }
        this.aAq = 0;
        this.aAr = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.aAg != null || this.aAf != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.aAn;
            int childCount = getChildCount();
            int i = this.mFirstPosition - headerViewsCount;
            int i2 = -4;
            int i3 = 0;
            int i4 = i;
            while (i3 < childCount) {
                if (i4 >= 0) {
                    if (i4 <= footerViewsCount) {
                        View childAt = getChildAt(i3);
                        int left = childAt.getLeft();
                        int right2 = childAt.getRight();
                        if (right2 >= 0 && left <= right) {
                            ExpandableHListConnector.b cu = this.azY.cu(i4);
                            if (cu.azS.type != i2) {
                                if (cu.azS.type == 1) {
                                    rect.top = childAt.getTop() + this.aAd;
                                    rect.bottom = childAt.getBottom() + this.aAd;
                                } else {
                                    rect.top = childAt.getTop() + this.aAa;
                                    rect.bottom = childAt.getBottom() + this.aAa;
                                }
                                i2 = cu.azS.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (cu.azS.type == 1) {
                                    rect.left = this.aAe + left;
                                    rect.right = this.aAe + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(cu);
                                if (c2 != null) {
                                    if (cu.azS.type == 1) {
                                        Gravity.apply(this.aAc, this.aAq, this.aAr, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.aAb, this.aAo, this.aAp, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            cu.recycle();
                        }
                    } else {
                        return;
                    }
                }
                i3++;
                i4++;
            }
        }
    }

    private Drawable c(ExpandableHListConnector.b bVar) {
        if (bVar.azS.type == 2) {
            Drawable drawable = this.aAf;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(aAk[(bVar.zW() ? (char) 1 : (char) 0) | (bVar.azT == null || bVar.azT.azN == bVar.azT.azM ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.aAg;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.azS.azX == bVar.azT.azN ? aAl : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.aAm = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b cu = this.azY.cu(cy(i2));
            if (cu.azS.type == 1 || (cu.zW() && cu.azT.azN != cu.azT.azM)) {
                Drawable drawable = this.aAm;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                cu.recycle();
                return;
            }
            cu.recycle();
        }
        super.drawDivider(canvas, rect, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, com.baidu.live.tieba.horizonallist.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        throw new RuntimeException("For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of setAdapter(ListAdapter)");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AdapterView
    public ListAdapter getAdapter() {
        return super.getAdapter();
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView
    public void setOnItemClickListener(AdapterView.c cVar) {
        super.setOnItemClickListener(cVar);
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        this.azZ = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.azY = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.azY = null;
        }
        super.setAdapter((ListAdapter) this.azY);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.azZ;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int cy(int i) {
        return i - getHeaderViewsCount();
    }

    private int cz(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, com.baidu.live.tieba.horizonallist.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return a(view, cy(i), j);
    }

    boolean a(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b cu = this.azY.cu(i);
        long b2 = b(cu.azS);
        if (cu.azS.type == 2) {
            if (this.aAu != null && this.aAu.a(this, view, cu.azS.azV, b2)) {
                cu.recycle();
                return true;
            }
            if (cu.zW()) {
                this.azY.a(cu);
                playSoundEffect(0);
                if (this.aAs != null) {
                    this.aAs.cB(cu.azS.azV);
                }
            } else {
                this.azY.b(cu);
                playSoundEffect(0);
                if (this.aAt != null) {
                    this.aAt.cC(cu.azS.azV);
                }
                int i2 = cu.azS.azV;
                int headerViewsCount = cu.azS.azX + getHeaderViewsCount();
                smoothScrollToPosition(this.azZ.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.aAv != null) {
            playSoundEffect(0);
            return this.aAv.a(this, view, cu.azS.azV, cu.azS.azW, b2);
        } else {
            z = false;
        }
        cu.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.aAs = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.aAt = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.aAu = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.aAv = bVar;
    }

    public long cA(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b cu = this.azY.cu(cy(i));
        long zX = cu.azS.zX();
        cu.recycle();
        return zX;
    }

    public long getSelectedPosition() {
        return cA(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int K = K(selectedPosition);
        if (J(selectedPosition) == 0) {
            return this.azZ.getGroupId(K);
        }
        return this.azZ.getChildId(K, L(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.live.tieba.horizonallist.widget.a cx = com.baidu.live.tieba.horizonallist.widget.a.cx(i);
        ExpandableHListConnector.b a2 = this.azY.a(cx);
        cx.recycle();
        super.setSelection(cz(a2.azS.azX));
        a2.recycle();
    }

    public static int J(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public static int K(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((9223372032559808512L & j) >> 32);
    }

    public static int L(long j) {
        if (j != 4294967295L && (j & Long.MIN_VALUE) == Long.MIN_VALUE) {
            return (int) (j & 4294967295L);
        }
        return -1;
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView
    ContextMenu.ContextMenuInfo createContextMenuInfo(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return new AdapterView.a(view, i, j);
        }
        ExpandableHListConnector.b cu = this.azY.cu(cy(i));
        com.baidu.live.tieba.horizonallist.widget.a aVar = cu.azS;
        long b2 = b(aVar);
        long zX = aVar.zX();
        cu.recycle();
        return new a(view, zX, b2);
    }

    private long b(com.baidu.live.tieba.horizonallist.widget.a aVar) {
        return aVar.type == 1 ? this.azZ.getChildId(aVar.azV, aVar.azW) : this.azZ.getGroupId(aVar.azV);
    }

    public void setChildIndicator(Drawable drawable) {
        this.aAg = drawable;
        Aa();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.aAf = drawable;
        zZ();
    }

    /* loaded from: classes3.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long aAw;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.aAw = j;
            this.id = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.live.tieba.horizonallist.widget.ExpandableHListView.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: l */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: cD */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> aAx;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.aAx = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aAx = new ArrayList<>();
            parcel.readList(this.aAx, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.aAx);
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.azY != null ? this.azY.zU() : null);
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.azY != null && savedState.aAx != null) {
            this.azY.k(savedState.aAx);
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, com.baidu.live.tieba.horizonallist.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ExpandableHListView.class.getName());
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, com.baidu.live.tieba.horizonallist.widget.AdapterView, android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ExpandableHListView.class.getName());
    }
}
