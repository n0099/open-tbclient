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
    private static final int[] aTO = {16842920};
    private static final int[] aTP = {16842921};
    private static final int[] aTQ = {16842920, 16842921};
    private static final int[][] aTR = {EMPTY_STATE_SET, aTO, aTP, aTQ};
    private static final int[] aTS = {16842918};
    private ExpandableHListConnector aTF;
    private ExpandableListAdapter aTG;
    private int aTH;
    private int aTI;
    private int aTJ;
    private int aTK;
    private int aTL;
    private Drawable aTM;
    private Drawable aTN;
    private Drawable aTT;
    private final Rect aTU;
    private int aTV;
    private int aTW;
    private int aTX;
    private int aTY;
    private d aTZ;
    private e aUa;
    private c aUb;
    private b aUc;
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
        void cQ(int i);
    }

    /* loaded from: classes3.dex */
    public interface e {
        void cR(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.c.sdk_hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aTU = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.aTH = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.aTI = obtainStyledAttributes.getInt(a.k.sdk_ExpandableHListView_sdk_hlv_indicatorGravity, 0);
        this.aTJ = obtainStyledAttributes.getInt(a.k.sdk_ExpandableHListView_sdk_hlv_childIndicatorGravity, 0);
        this.aTL = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.aTK = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.aTT = obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        EX();
        EY();
    }

    private void EX() {
        if (this.aTM != null) {
            this.aTV = this.aTM.getIntrinsicWidth();
            this.aTW = this.aTM.getIntrinsicHeight();
            return;
        }
        this.aTV = 0;
        this.aTW = 0;
    }

    private void EY() {
        if (this.aTN != null) {
            this.aTX = this.aTN.getIntrinsicWidth();
            this.aTY = this.aTN.getIntrinsicHeight();
            return;
        }
        this.aTX = 0;
        this.aTY = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.aTN != null || this.aTM != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.aTU;
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
                            ExpandableHListConnector.b cJ = this.aTF.cJ(i4);
                            if (cJ.aTz.type != i2) {
                                if (cJ.aTz.type == 1) {
                                    rect.top = childAt.getTop() + this.aTK;
                                    rect.bottom = childAt.getBottom() + this.aTK;
                                } else {
                                    rect.top = childAt.getTop() + this.aTH;
                                    rect.bottom = childAt.getBottom() + this.aTH;
                                }
                                i2 = cJ.aTz.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (cJ.aTz.type == 1) {
                                    rect.left = this.aTL + left;
                                    rect.right = this.aTL + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(cJ);
                                if (c2 != null) {
                                    if (cJ.aTz.type == 1) {
                                        Gravity.apply(this.aTJ, this.aTX, this.aTY, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.aTI, this.aTV, this.aTW, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            cJ.recycle();
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
        if (bVar.aTz.type == 2) {
            Drawable drawable = this.aTM;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(aTR[(bVar.EU() ? (char) 1 : (char) 0) | (bVar.aTA == null || bVar.aTA.aTu == bVar.aTA.aTt ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.aTN;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.aTz.aTE == bVar.aTA.aTu ? aTS : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.aTT = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b cJ = this.aTF.cJ(cN(i2));
            if (cJ.aTz.type == 1 || (cJ.EU() && cJ.aTA.aTu != cJ.aTA.aTt)) {
                Drawable drawable = this.aTT;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                cJ.recycle();
                return;
            }
            cJ.recycle();
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
        this.aTG = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.aTF = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.aTF = null;
        }
        super.setAdapter((ListAdapter) this.aTF);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.aTG;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int cN(int i) {
        return i - getHeaderViewsCount();
    }

    private int cO(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, com.baidu.live.tieba.horizonallist.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return a(view, cN(i), j);
    }

    boolean a(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b cJ = this.aTF.cJ(i);
        long b2 = b(cJ.aTz);
        if (cJ.aTz.type == 2) {
            if (this.aUb != null && this.aUb.a(this, view, cJ.aTz.aTC, b2)) {
                cJ.recycle();
                return true;
            }
            if (cJ.EU()) {
                this.aTF.a(cJ);
                playSoundEffect(0);
                if (this.aTZ != null) {
                    this.aTZ.cQ(cJ.aTz.aTC);
                }
            } else {
                this.aTF.b(cJ);
                playSoundEffect(0);
                if (this.aUa != null) {
                    this.aUa.cR(cJ.aTz.aTC);
                }
                int i2 = cJ.aTz.aTC;
                int headerViewsCount = cJ.aTz.aTE + getHeaderViewsCount();
                smoothScrollToPosition(this.aTG.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.aUc != null) {
            playSoundEffect(0);
            return this.aUc.a(this, view, cJ.aTz.aTC, cJ.aTz.aTD, b2);
        } else {
            z = false;
        }
        cJ.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.aTZ = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.aUa = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.aUb = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.aUc = bVar;
    }

    public long cP(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b cJ = this.aTF.cJ(cN(i));
        long EV = cJ.aTz.EV();
        cJ.recycle();
        return EV;
    }

    public long getSelectedPosition() {
        return cP(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int am = am(selectedPosition);
        if (al(selectedPosition) == 0) {
            return this.aTG.getGroupId(am);
        }
        return this.aTG.getChildId(am, an(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.live.tieba.horizonallist.widget.a cM = com.baidu.live.tieba.horizonallist.widget.a.cM(i);
        ExpandableHListConnector.b a2 = this.aTF.a(cM);
        cM.recycle();
        super.setSelection(cO(a2.aTz.aTE));
        a2.recycle();
    }

    public static int al(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public static int am(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((9223372032559808512L & j) >> 32);
    }

    public static int an(long j) {
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
        ExpandableHListConnector.b cJ = this.aTF.cJ(cN(i));
        com.baidu.live.tieba.horizonallist.widget.a aVar = cJ.aTz;
        long b2 = b(aVar);
        long EV = aVar.EV();
        cJ.recycle();
        return new a(view, EV, b2);
    }

    private long b(com.baidu.live.tieba.horizonallist.widget.a aVar) {
        return aVar.type == 1 ? this.aTG.getChildId(aVar.aTC, aVar.aTD) : this.aTG.getGroupId(aVar.aTC);
    }

    public void setChildIndicator(Drawable drawable) {
        this.aTN = drawable;
        EY();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.aTM = drawable;
        EX();
    }

    /* loaded from: classes3.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long aUd;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.aUd = j;
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
            /* renamed from: cS */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> aUe;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.aUe = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aUe = new ArrayList<>();
            parcel.readList(this.aUe, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.aUe);
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.aTF != null ? this.aTF.ES() : null);
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.aTF != null && savedState.aUe != null) {
            this.aTF.k(savedState.aUe);
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
