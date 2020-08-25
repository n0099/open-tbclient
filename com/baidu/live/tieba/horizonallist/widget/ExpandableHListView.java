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
/* loaded from: classes7.dex */
public class ExpandableHListView extends HListView {
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] bms = {16842920};
    private static final int[] bmt = {16842921};
    private static final int[] bmu = {16842920, 16842921};
    private static final int[][] bmv = {EMPTY_STATE_SET, bms, bmt, bmu};
    private static final int[] bmw = {16842918};
    private int bmA;
    private int bmB;
    private int bmC;
    private d bmD;
    private e bmE;
    private c bmF;
    private b bmG;
    private ExpandableHListConnector bmj;
    private ExpandableListAdapter bmk;
    private int bml;
    private int bmm;
    private int bmn;
    private int bmo;
    private int bmp;
    private Drawable bmq;
    private Drawable bmr;
    private Drawable bmx;
    private final Rect bmy;
    private int bmz;
    private int mIndicatorLeft;
    private final Rect mTempRect;

    /* loaded from: classes7.dex */
    public interface b {
        boolean a(ExpandableHListView expandableHListView, View view, int i, int i2, long j);
    }

    /* loaded from: classes7.dex */
    public interface c {
        boolean a(ExpandableHListView expandableHListView, View view, int i, long j);
    }

    /* loaded from: classes7.dex */
    public interface d {
        void fc(int i);
    }

    /* loaded from: classes7.dex */
    public interface e {
        void fd(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.c.sdk_hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bmy = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.bml = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.bmm = obtainStyledAttributes.getInt(a.k.sdk_ExpandableHListView_sdk_hlv_indicatorGravity, 0);
        this.bmn = obtainStyledAttributes.getInt(a.k.sdk_ExpandableHListView_sdk_hlv_childIndicatorGravity, 0);
        this.bmp = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.bmo = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.bmx = obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        NZ();
        Oa();
    }

    private void NZ() {
        if (this.bmq != null) {
            this.bmz = this.bmq.getIntrinsicWidth();
            this.bmA = this.bmq.getIntrinsicHeight();
            return;
        }
        this.bmz = 0;
        this.bmA = 0;
    }

    private void Oa() {
        if (this.bmr != null) {
            this.bmB = this.bmr.getIntrinsicWidth();
            this.bmC = this.bmr.getIntrinsicHeight();
            return;
        }
        this.bmB = 0;
        this.bmC = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bmr != null || this.bmq != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.bmy;
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
                            ExpandableHListConnector.b eV = this.bmj.eV(i4);
                            if (eV.bmd.type != i2) {
                                if (eV.bmd.type == 1) {
                                    rect.top = childAt.getTop() + this.bmo;
                                    rect.bottom = childAt.getBottom() + this.bmo;
                                } else {
                                    rect.top = childAt.getTop() + this.bml;
                                    rect.bottom = childAt.getBottom() + this.bml;
                                }
                                i2 = eV.bmd.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (eV.bmd.type == 1) {
                                    rect.left = this.bmp + left;
                                    rect.right = this.bmp + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(eV);
                                if (c2 != null) {
                                    if (eV.bmd.type == 1) {
                                        Gravity.apply(this.bmn, this.bmB, this.bmC, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.bmm, this.bmz, this.bmA, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            eV.recycle();
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
        if (bVar.bmd.type == 2) {
            Drawable drawable = this.bmq;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(bmv[(bVar.NW() ? (char) 1 : (char) 0) | (bVar.bme == null || bVar.bme.blY == bVar.bme.blX ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.bmr;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.bmd.bmi == bVar.bme.blY ? bmw : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.bmx = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b eV = this.bmj.eV(eZ(i2));
            if (eV.bmd.type == 1 || (eV.NW() && eV.bme.blY != eV.bme.blX)) {
                Drawable drawable = this.bmx;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                eV.recycle();
                return;
            }
            eV.recycle();
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
        this.bmk = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.bmj = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.bmj = null;
        }
        super.setAdapter((ListAdapter) this.bmj);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.bmk;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int eZ(int i) {
        return i - getHeaderViewsCount();
    }

    private int fa(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, com.baidu.live.tieba.horizonallist.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return a(view, eZ(i), j);
    }

    boolean a(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b eV = this.bmj.eV(i);
        long b2 = b(eV.bmd);
        if (eV.bmd.type == 2) {
            if (this.bmF != null && this.bmF.a(this, view, eV.bmd.bmg, b2)) {
                eV.recycle();
                return true;
            }
            if (eV.NW()) {
                this.bmj.a(eV);
                playSoundEffect(0);
                if (this.bmD != null) {
                    this.bmD.fc(eV.bmd.bmg);
                }
            } else {
                this.bmj.b(eV);
                playSoundEffect(0);
                if (this.bmE != null) {
                    this.bmE.fd(eV.bmd.bmg);
                }
                int i2 = eV.bmd.bmg;
                int headerViewsCount = eV.bmd.bmi + getHeaderViewsCount();
                smoothScrollToPosition(this.bmk.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.bmG != null) {
            playSoundEffect(0);
            return this.bmG.a(this, view, eV.bmd.bmg, eV.bmd.bmh, b2);
        } else {
            z = false;
        }
        eV.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.bmD = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.bmE = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.bmF = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.bmG = bVar;
    }

    public long fb(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b eV = this.bmj.eV(eZ(i));
        long NX = eV.bmd.NX();
        eV.recycle();
        return NX;
    }

    public long getSelectedPosition() {
        return fb(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int as = as(selectedPosition);
        if (ar(selectedPosition) == 0) {
            return this.bmk.getGroupId(as);
        }
        return this.bmk.getChildId(as, at(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.live.tieba.horizonallist.widget.a eY = com.baidu.live.tieba.horizonallist.widget.a.eY(i);
        ExpandableHListConnector.b a2 = this.bmj.a(eY);
        eY.recycle();
        super.setSelection(fa(a2.bmd.bmi));
        a2.recycle();
    }

    public static int ar(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public static int as(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((9223372032559808512L & j) >> 32);
    }

    public static int at(long j) {
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
        ExpandableHListConnector.b eV = this.bmj.eV(eZ(i));
        com.baidu.live.tieba.horizonallist.widget.a aVar = eV.bmd;
        long b2 = b(aVar);
        long NX = aVar.NX();
        eV.recycle();
        return new a(view, NX, b2);
    }

    private long b(com.baidu.live.tieba.horizonallist.widget.a aVar) {
        return aVar.type == 1 ? this.bmk.getChildId(aVar.bmg, aVar.bmh) : this.bmk.getGroupId(aVar.bmg);
    }

    public void setChildIndicator(Drawable drawable) {
        this.bmr = drawable;
        Oa();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.bmq = drawable;
        NZ();
    }

    /* loaded from: classes7.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long bmH;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.bmH = j;
            this.id = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.live.tieba.horizonallist.widget.ExpandableHListView.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: m */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: fe */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> bmI;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.bmI = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.bmI = new ArrayList<>();
            parcel.readList(this.bmI, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.bmI);
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.bmj != null ? this.bmj.NU() : null);
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.bmj != null && savedState.bmI != null) {
            this.bmj.p(savedState.bmI);
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
