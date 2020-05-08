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
    private static final int[] aTT = {16842920};
    private static final int[] aTU = {16842921};
    private static final int[] aTV = {16842920, 16842921};
    private static final int[][] aTW = {EMPTY_STATE_SET, aTT, aTU, aTV};
    private static final int[] aTX = {16842918};
    private ExpandableHListConnector aTK;
    private ExpandableListAdapter aTL;
    private int aTM;
    private int aTN;
    private int aTO;
    private int aTP;
    private int aTQ;
    private Drawable aTR;
    private Drawable aTS;
    private Drawable aTY;
    private final Rect aTZ;
    private int aUa;
    private int aUb;
    private int aUc;
    private int aUd;
    private d aUe;
    private e aUf;
    private c aUg;
    private b aUh;
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
        this.aTZ = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.aTM = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.aTN = obtainStyledAttributes.getInt(a.k.sdk_ExpandableHListView_sdk_hlv_indicatorGravity, 0);
        this.aTO = obtainStyledAttributes.getInt(a.k.sdk_ExpandableHListView_sdk_hlv_childIndicatorGravity, 0);
        this.aTQ = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.aTP = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.aTY = obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        EW();
        EX();
    }

    private void EW() {
        if (this.aTR != null) {
            this.aUa = this.aTR.getIntrinsicWidth();
            this.aUb = this.aTR.getIntrinsicHeight();
            return;
        }
        this.aUa = 0;
        this.aUb = 0;
    }

    private void EX() {
        if (this.aTS != null) {
            this.aUc = this.aTS.getIntrinsicWidth();
            this.aUd = this.aTS.getIntrinsicHeight();
            return;
        }
        this.aUc = 0;
        this.aUd = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.aTS != null || this.aTR != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.aTZ;
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
                            ExpandableHListConnector.b cJ = this.aTK.cJ(i4);
                            if (cJ.aTE.type != i2) {
                                if (cJ.aTE.type == 1) {
                                    rect.top = childAt.getTop() + this.aTP;
                                    rect.bottom = childAt.getBottom() + this.aTP;
                                } else {
                                    rect.top = childAt.getTop() + this.aTM;
                                    rect.bottom = childAt.getBottom() + this.aTM;
                                }
                                i2 = cJ.aTE.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (cJ.aTE.type == 1) {
                                    rect.left = this.aTQ + left;
                                    rect.right = this.aTQ + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(cJ);
                                if (c2 != null) {
                                    if (cJ.aTE.type == 1) {
                                        Gravity.apply(this.aTO, this.aUc, this.aUd, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.aTN, this.aUa, this.aUb, rect, this.mTempRect);
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
        if (bVar.aTE.type == 2) {
            Drawable drawable = this.aTR;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(aTW[(bVar.ET() ? (char) 1 : (char) 0) | (bVar.aTF == null || bVar.aTF.aTz == bVar.aTF.aTy ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.aTS;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.aTE.aTJ == bVar.aTF.aTz ? aTX : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.aTY = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b cJ = this.aTK.cJ(cN(i2));
            if (cJ.aTE.type == 1 || (cJ.ET() && cJ.aTF.aTz != cJ.aTF.aTy)) {
                Drawable drawable = this.aTY;
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
        this.aTL = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.aTK = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.aTK = null;
        }
        super.setAdapter((ListAdapter) this.aTK);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.aTL;
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
        ExpandableHListConnector.b cJ = this.aTK.cJ(i);
        long b2 = b(cJ.aTE);
        if (cJ.aTE.type == 2) {
            if (this.aUg != null && this.aUg.a(this, view, cJ.aTE.aTH, b2)) {
                cJ.recycle();
                return true;
            }
            if (cJ.ET()) {
                this.aTK.a(cJ);
                playSoundEffect(0);
                if (this.aUe != null) {
                    this.aUe.cQ(cJ.aTE.aTH);
                }
            } else {
                this.aTK.b(cJ);
                playSoundEffect(0);
                if (this.aUf != null) {
                    this.aUf.cR(cJ.aTE.aTH);
                }
                int i2 = cJ.aTE.aTH;
                int headerViewsCount = cJ.aTE.aTJ + getHeaderViewsCount();
                smoothScrollToPosition(this.aTL.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.aUh != null) {
            playSoundEffect(0);
            return this.aUh.a(this, view, cJ.aTE.aTH, cJ.aTE.aTI, b2);
        } else {
            z = false;
        }
        cJ.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.aUe = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.aUf = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.aUg = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.aUh = bVar;
    }

    public long cP(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b cJ = this.aTK.cJ(cN(i));
        long EU = cJ.aTE.EU();
        cJ.recycle();
        return EU;
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
            return this.aTL.getGroupId(am);
        }
        return this.aTL.getChildId(am, an(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.live.tieba.horizonallist.widget.a cM = com.baidu.live.tieba.horizonallist.widget.a.cM(i);
        ExpandableHListConnector.b a2 = this.aTK.a(cM);
        cM.recycle();
        super.setSelection(cO(a2.aTE.aTJ));
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
        ExpandableHListConnector.b cJ = this.aTK.cJ(cN(i));
        com.baidu.live.tieba.horizonallist.widget.a aVar = cJ.aTE;
        long b2 = b(aVar);
        long EU = aVar.EU();
        cJ.recycle();
        return new a(view, EU, b2);
    }

    private long b(com.baidu.live.tieba.horizonallist.widget.a aVar) {
        return aVar.type == 1 ? this.aTL.getChildId(aVar.aTH, aVar.aTI) : this.aTL.getGroupId(aVar.aTH);
    }

    public void setChildIndicator(Drawable drawable) {
        this.aTS = drawable;
        EX();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.aTR = drawable;
        EW();
    }

    /* loaded from: classes3.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long aUi;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.aUi = j;
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
        ArrayList<ExpandableHListConnector.GroupMetadata> aUj;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.aUj = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aUj = new ArrayList<>();
            parcel.readList(this.aUj, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.aUj);
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.aTK != null ? this.aTK.ER() : null);
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.aTK != null && savedState.aUj != null) {
            this.aTK.k(savedState.aUj);
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
