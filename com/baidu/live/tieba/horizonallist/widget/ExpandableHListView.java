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
    private static final int[] bmv = {16842920};
    private static final int[] bmw = {16842921};
    private static final int[] bmx = {16842920, 16842921};
    private static final int[][] bmy = {EMPTY_STATE_SET, bmv, bmw, bmx};
    private static final int[] bmz = {16842918};
    private Drawable bmA;
    private final Rect bmB;
    private int bmC;
    private int bmD;
    private int bmE;
    private int bmF;
    private d bmG;
    private e bmH;
    private c bmI;
    private b bmJ;
    private ExpandableHListConnector bmm;
    private ExpandableListAdapter bmn;
    private int bmo;
    private int bmp;
    private int bmq;
    private int bmr;
    private int bms;
    private Drawable bmt;
    private Drawable bmu;
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
        this.bmB = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.bmo = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.bmp = obtainStyledAttributes.getInt(a.k.sdk_ExpandableHListView_sdk_hlv_indicatorGravity, 0);
        this.bmq = obtainStyledAttributes.getInt(a.k.sdk_ExpandableHListView_sdk_hlv_childIndicatorGravity, 0);
        this.bms = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.bmr = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.bmA = obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        NZ();
        Oa();
    }

    private void NZ() {
        if (this.bmt != null) {
            this.bmC = this.bmt.getIntrinsicWidth();
            this.bmD = this.bmt.getIntrinsicHeight();
            return;
        }
        this.bmC = 0;
        this.bmD = 0;
    }

    private void Oa() {
        if (this.bmu != null) {
            this.bmE = this.bmu.getIntrinsicWidth();
            this.bmF = this.bmu.getIntrinsicHeight();
            return;
        }
        this.bmE = 0;
        this.bmF = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bmu != null || this.bmt != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.bmB;
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
                            ExpandableHListConnector.b eV = this.bmm.eV(i4);
                            if (eV.bmg.type != i2) {
                                if (eV.bmg.type == 1) {
                                    rect.top = childAt.getTop() + this.bmr;
                                    rect.bottom = childAt.getBottom() + this.bmr;
                                } else {
                                    rect.top = childAt.getTop() + this.bmo;
                                    rect.bottom = childAt.getBottom() + this.bmo;
                                }
                                i2 = eV.bmg.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (eV.bmg.type == 1) {
                                    rect.left = this.bms + left;
                                    rect.right = this.bms + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(eV);
                                if (c2 != null) {
                                    if (eV.bmg.type == 1) {
                                        Gravity.apply(this.bmq, this.bmE, this.bmF, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.bmp, this.bmC, this.bmD, rect, this.mTempRect);
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
        if (bVar.bmg.type == 2) {
            Drawable drawable = this.bmt;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(bmy[(bVar.NW() ? (char) 1 : (char) 0) | (bVar.bmh == null || bVar.bmh.bmb == bVar.bmh.bma ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.bmu;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.bmg.bml == bVar.bmh.bmb ? bmz : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.bmA = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b eV = this.bmm.eV(eZ(i2));
            if (eV.bmg.type == 1 || (eV.NW() && eV.bmh.bmb != eV.bmh.bma)) {
                Drawable drawable = this.bmA;
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
        this.bmn = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.bmm = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.bmm = null;
        }
        super.setAdapter((ListAdapter) this.bmm);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.bmn;
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
        ExpandableHListConnector.b eV = this.bmm.eV(i);
        long b2 = b(eV.bmg);
        if (eV.bmg.type == 2) {
            if (this.bmI != null && this.bmI.a(this, view, eV.bmg.bmj, b2)) {
                eV.recycle();
                return true;
            }
            if (eV.NW()) {
                this.bmm.a(eV);
                playSoundEffect(0);
                if (this.bmG != null) {
                    this.bmG.fc(eV.bmg.bmj);
                }
            } else {
                this.bmm.b(eV);
                playSoundEffect(0);
                if (this.bmH != null) {
                    this.bmH.fd(eV.bmg.bmj);
                }
                int i2 = eV.bmg.bmj;
                int headerViewsCount = eV.bmg.bml + getHeaderViewsCount();
                smoothScrollToPosition(this.bmn.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.bmJ != null) {
            playSoundEffect(0);
            return this.bmJ.a(this, view, eV.bmg.bmj, eV.bmg.bmk, b2);
        } else {
            z = false;
        }
        eV.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.bmG = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.bmH = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.bmI = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.bmJ = bVar;
    }

    public long fb(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b eV = this.bmm.eV(eZ(i));
        long NX = eV.bmg.NX();
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
            return this.bmn.getGroupId(as);
        }
        return this.bmn.getChildId(as, at(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.live.tieba.horizonallist.widget.a eY = com.baidu.live.tieba.horizonallist.widget.a.eY(i);
        ExpandableHListConnector.b a2 = this.bmm.a(eY);
        eY.recycle();
        super.setSelection(fa(a2.bmg.bml));
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
        ExpandableHListConnector.b eV = this.bmm.eV(eZ(i));
        com.baidu.live.tieba.horizonallist.widget.a aVar = eV.bmg;
        long b2 = b(aVar);
        long NX = aVar.NX();
        eV.recycle();
        return new a(view, NX, b2);
    }

    private long b(com.baidu.live.tieba.horizonallist.widget.a aVar) {
        return aVar.type == 1 ? this.bmn.getChildId(aVar.bmj, aVar.bmk) : this.bmn.getGroupId(aVar.bmj);
    }

    public void setChildIndicator(Drawable drawable) {
        this.bmu = drawable;
        Oa();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.bmt = drawable;
        NZ();
    }

    /* loaded from: classes7.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long bmK;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.bmK = j;
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
        ArrayList<ExpandableHListConnector.GroupMetadata> bmL;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.bmL = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.bmL = new ArrayList<>();
            parcel.readList(this.bmL, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.bmL);
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.bmm != null ? this.bmm.NU() : null);
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.bmm != null && savedState.bmL != null) {
            this.bmm.p(savedState.bmL);
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
