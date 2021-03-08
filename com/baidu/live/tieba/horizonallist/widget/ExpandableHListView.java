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
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.tieba.horizonallist.widget.ExpandableHListConnector;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class ExpandableHListView extends HListView {
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] bKd = {16842920};
    private static final int[] bKe = {16842921};
    private static final int[] bKf = {16842920, 16842921};
    private static final int[][] bKg = {EMPTY_STATE_SET, bKd, bKe, bKf};
    private static final int[] bKh = {16842918};
    private int aaM;
    private ExpandableHListConnector bJU;
    private ExpandableListAdapter bJV;
    private int bJW;
    private int bJX;
    private int bJY;
    private int bJZ;
    private int bKa;
    private Drawable bKb;
    private Drawable bKc;
    private Drawable bKi;
    private final Rect bKj;
    private int bKk;
    private int bKl;
    private int bKm;
    private int bKn;
    private d bKo;
    private e bKp;
    private c bKq;
    private b bKr;
    private final Rect mTempRect;

    /* loaded from: classes10.dex */
    public interface b {
        boolean a(ExpandableHListView expandableHListView, View view, int i, int i2, long j);
    }

    /* loaded from: classes10.dex */
    public interface c {
        boolean a(ExpandableHListView expandableHListView, View view, int i, long j);
    }

    /* loaded from: classes10.dex */
    public interface d {
        void eF(int i);
    }

    /* loaded from: classes10.dex */
    public interface e {
        void eG(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.sdk_hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bKj = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(a.j.sdk_ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(a.j.sdk_ExpandableHListView_hlv_childIndicator));
        this.aaM = obtainStyledAttributes.getDimensionPixelSize(a.j.sdk_ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.bJW = obtainStyledAttributes.getDimensionPixelSize(a.j.sdk_ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.bJX = obtainStyledAttributes.getInt(a.j.sdk_ExpandableHListView_sdk_hlv_indicatorGravity, 0);
        this.bJY = obtainStyledAttributes.getInt(a.j.sdk_ExpandableHListView_sdk_hlv_childIndicatorGravity, 0);
        this.bKa = obtainStyledAttributes.getDimensionPixelSize(a.j.sdk_ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.bJZ = obtainStyledAttributes.getDimensionPixelSize(a.j.sdk_ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.bKi = obtainStyledAttributes.getDrawable(a.j.sdk_ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        TW();
        TX();
    }

    private void TW() {
        if (this.bKb != null) {
            this.bKk = this.bKb.getIntrinsicWidth();
            this.bKl = this.bKb.getIntrinsicHeight();
            return;
        }
        this.bKk = 0;
        this.bKl = 0;
    }

    private void TX() {
        if (this.bKc != null) {
            this.bKm = this.bKc.getIntrinsicWidth();
            this.bKn = this.bKc.getIntrinsicHeight();
            return;
        }
        this.bKm = 0;
        this.bKn = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bKc != null || this.bKb != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            int i = -4;
            Rect rect = this.bKj;
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = this.mFirstPosition - headerViewsCount;
            while (i2 < childCount) {
                if (i3 >= 0) {
                    if (i3 <= footerViewsCount) {
                        View childAt = getChildAt(i2);
                        int left = childAt.getLeft();
                        int right2 = childAt.getRight();
                        if (right2 >= 0 && left <= right) {
                            ExpandableHListConnector.b ey = this.bJU.ey(i3);
                            if (ey.bJO.type != i) {
                                if (ey.bJO.type == 1) {
                                    rect.top = childAt.getTop() + this.bJZ;
                                    rect.bottom = childAt.getBottom() + this.bJZ;
                                } else {
                                    rect.top = childAt.getTop() + this.bJW;
                                    rect.bottom = childAt.getBottom() + this.bJW;
                                }
                                i = ey.bJO.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (ey.bJO.type == 1) {
                                    rect.left = this.bKa + left;
                                    rect.right = this.bKa + right2;
                                } else {
                                    rect.left = this.aaM + left;
                                    rect.right = this.aaM + right2;
                                }
                                Drawable c2 = c(ey);
                                if (c2 != null) {
                                    if (ey.bJO.type == 1) {
                                        Gravity.apply(this.bJY, this.bKm, this.bKn, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.bJX, this.bKk, this.bKl, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            ey.recycle();
                        }
                    } else {
                        return;
                    }
                }
                i2++;
                i3++;
            }
        }
    }

    private Drawable c(ExpandableHListConnector.b bVar) {
        if (bVar.bJO.type == 2) {
            Drawable drawable = this.bKb;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(bKg[(bVar.isExpanded() ? (char) 1 : (char) 0) | (bVar.bJP == null || bVar.bJP.bJJ == bVar.bJP.bJI ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.bKc;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.bJO.bJT == bVar.bJP.bJJ ? bKh : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.bKi = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b ey = this.bJU.ey(eC(i2));
            if (ey.bJO.type == 1 || (ey.isExpanded() && ey.bJP.bJJ != ey.bJP.bJI)) {
                Drawable drawable = this.bKi;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                ey.recycle();
                return;
            }
            ey.recycle();
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
        this.bJV = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.bJU = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.bJU = null;
        }
        super.setAdapter((ListAdapter) this.bJU);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.bJV;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int eC(int i) {
        return i - getHeaderViewsCount();
    }

    private int eD(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, com.baidu.live.tieba.horizonallist.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return b(view, eC(i), j);
    }

    boolean b(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b ey = this.bJU.ey(i);
        long b2 = b(ey.bJO);
        if (ey.bJO.type == 2) {
            if (this.bKq != null && this.bKq.a(this, view, ey.bJO.bJR, b2)) {
                ey.recycle();
                return true;
            }
            if (ey.isExpanded()) {
                this.bJU.a(ey);
                playSoundEffect(0);
                if (this.bKo != null) {
                    this.bKo.eF(ey.bJO.bJR);
                }
            } else {
                this.bJU.b(ey);
                playSoundEffect(0);
                if (this.bKp != null) {
                    this.bKp.eG(ey.bJO.bJR);
                }
                int i2 = ey.bJO.bJR;
                int headerViewsCount = ey.bJO.bJT + getHeaderViewsCount();
                smoothScrollToPosition(this.bJV.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.bKr != null) {
            playSoundEffect(0);
            return this.bKr.a(this, view, ey.bJO.bJR, ey.bJO.bJS, b2);
        } else {
            z = false;
        }
        ey.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.bKo = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.bKp = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.bKq = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.bKr = bVar;
    }

    public long eE(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b ey = this.bJU.ey(eC(i));
        long TU = ey.bJO.TU();
        ey.recycle();
        return TU;
    }

    public long getSelectedPosition() {
        return eE(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int bu = bu(selectedPosition);
        if (bt(selectedPosition) == 0) {
            return this.bJV.getGroupId(bu);
        }
        return this.bJV.getChildId(bu, bv(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.live.tieba.horizonallist.widget.a eB = com.baidu.live.tieba.horizonallist.widget.a.eB(i);
        ExpandableHListConnector.b a2 = this.bJU.a(eB);
        eB.recycle();
        super.setSelection(eD(a2.bJO.bJT));
        a2.recycle();
    }

    public static int bt(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public static int bu(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((9223372032559808512L & j) >> 32);
    }

    public static int bv(long j) {
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
        ExpandableHListConnector.b ey = this.bJU.ey(eC(i));
        com.baidu.live.tieba.horizonallist.widget.a aVar = ey.bJO;
        long b2 = b(aVar);
        long TU = aVar.TU();
        ey.recycle();
        return new a(view, TU, b2);
    }

    private long b(com.baidu.live.tieba.horizonallist.widget.a aVar) {
        return aVar.type == 1 ? this.bJV.getChildId(aVar.bJR, aVar.bJS) : this.bJV.getGroupId(aVar.bJR);
    }

    public void setChildIndicator(Drawable drawable) {
        this.bKc = drawable;
        TX();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.bKb = drawable;
        TW();
    }

    /* loaded from: classes10.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long bKs;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.bKs = j;
            this.id = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.live.tieba.horizonallist.widget.ExpandableHListView.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: n */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: eH */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> bKt;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.bKt = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.bKt = new ArrayList<>();
            parcel.readList(this.bKt, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.bKt);
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.bJU != null ? this.bJU.TR() : null);
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.bJU != null && savedState.bKt != null) {
            this.bJU.k(savedState.bKt);
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
