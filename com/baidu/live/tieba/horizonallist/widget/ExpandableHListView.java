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
/* loaded from: classes3.dex */
public class ExpandableHListView extends HListView {
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] bgq = {16842920};
    private static final int[] bgr = {16842921};
    private static final int[] bgt = {16842920, 16842921};
    private static final int[][] bgu = {EMPTY_STATE_SET, bgq, bgr, bgt};
    private static final int[] bgv = {16842918};
    private int bgA;
    private int bgB;
    private d bgC;
    private e bgD;
    private c bgE;
    private b bgF;
    private ExpandableHListConnector bgh;
    private ExpandableListAdapter bgi;
    private int bgj;
    private int bgk;
    private int bgl;
    private int bgm;
    private int bgn;
    private Drawable bgo;
    private Drawable bgp;
    private Drawable bgw;
    private final Rect bgx;
    private int bgy;
    private int bgz;
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
        void dj(int i);
    }

    /* loaded from: classes3.dex */
    public interface e {
        void dk(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.c.sdk_hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bgx = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.bgj = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.bgk = obtainStyledAttributes.getInt(a.k.sdk_ExpandableHListView_sdk_hlv_indicatorGravity, 0);
        this.bgl = obtainStyledAttributes.getInt(a.k.sdk_ExpandableHListView_sdk_hlv_childIndicatorGravity, 0);
        this.bgn = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.bgm = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.bgw = obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        Ia();
        Ib();
    }

    private void Ia() {
        if (this.bgo != null) {
            this.bgy = this.bgo.getIntrinsicWidth();
            this.bgz = this.bgo.getIntrinsicHeight();
            return;
        }
        this.bgy = 0;
        this.bgz = 0;
    }

    private void Ib() {
        if (this.bgp != null) {
            this.bgA = this.bgp.getIntrinsicWidth();
            this.bgB = this.bgp.getIntrinsicHeight();
            return;
        }
        this.bgA = 0;
        this.bgB = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bgp != null || this.bgo != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.bgx;
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
                            ExpandableHListConnector.b dc = this.bgh.dc(i4);
                            if (dc.bgb.type != i2) {
                                if (dc.bgb.type == 1) {
                                    rect.top = childAt.getTop() + this.bgm;
                                    rect.bottom = childAt.getBottom() + this.bgm;
                                } else {
                                    rect.top = childAt.getTop() + this.bgj;
                                    rect.bottom = childAt.getBottom() + this.bgj;
                                }
                                i2 = dc.bgb.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (dc.bgb.type == 1) {
                                    rect.left = this.bgn + left;
                                    rect.right = this.bgn + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(dc);
                                if (c2 != null) {
                                    if (dc.bgb.type == 1) {
                                        Gravity.apply(this.bgl, this.bgA, this.bgB, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.bgk, this.bgy, this.bgz, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            dc.recycle();
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
        if (bVar.bgb.type == 2) {
            Drawable drawable = this.bgo;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(bgu[(bVar.HX() ? (char) 1 : (char) 0) | (bVar.bgc == null || bVar.bgc.bfW == bVar.bgc.bfV ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.bgp;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.bgb.bgg == bVar.bgc.bfW ? bgv : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.bgw = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b dc = this.bgh.dc(dg(i2));
            if (dc.bgb.type == 1 || (dc.HX() && dc.bgc.bfW != dc.bgc.bfV)) {
                Drawable drawable = this.bgw;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                dc.recycle();
                return;
            }
            dc.recycle();
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
        this.bgi = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.bgh = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.bgh = null;
        }
        super.setAdapter((ListAdapter) this.bgh);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.bgi;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int dg(int i) {
        return i - getHeaderViewsCount();
    }

    private int dh(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, com.baidu.live.tieba.horizonallist.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return a(view, dg(i), j);
    }

    boolean a(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b dc = this.bgh.dc(i);
        long b2 = b(dc.bgb);
        if (dc.bgb.type == 2) {
            if (this.bgE != null && this.bgE.a(this, view, dc.bgb.bge, b2)) {
                dc.recycle();
                return true;
            }
            if (dc.HX()) {
                this.bgh.a(dc);
                playSoundEffect(0);
                if (this.bgC != null) {
                    this.bgC.dj(dc.bgb.bge);
                }
            } else {
                this.bgh.b(dc);
                playSoundEffect(0);
                if (this.bgD != null) {
                    this.bgD.dk(dc.bgb.bge);
                }
                int i2 = dc.bgb.bge;
                int headerViewsCount = dc.bgb.bgg + getHeaderViewsCount();
                smoothScrollToPosition(this.bgi.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.bgF != null) {
            playSoundEffect(0);
            return this.bgF.a(this, view, dc.bgb.bge, dc.bgb.bgf, b2);
        } else {
            z = false;
        }
        dc.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.bgC = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.bgD = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.bgE = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.bgF = bVar;
    }

    public long di(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b dc = this.bgh.dc(dg(i));
        long HY = dc.bgb.HY();
        dc.recycle();
        return HY;
    }

    public long getSelectedPosition() {
        return di(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int ar = ar(selectedPosition);
        if (aq(selectedPosition) == 0) {
            return this.bgi.getGroupId(ar);
        }
        return this.bgi.getChildId(ar, as(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.live.tieba.horizonallist.widget.a df = com.baidu.live.tieba.horizonallist.widget.a.df(i);
        ExpandableHListConnector.b a2 = this.bgh.a(df);
        df.recycle();
        super.setSelection(dh(a2.bgb.bgg));
        a2.recycle();
    }

    public static int aq(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public static int ar(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((9223372032559808512L & j) >> 32);
    }

    public static int as(long j) {
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
        ExpandableHListConnector.b dc = this.bgh.dc(dg(i));
        com.baidu.live.tieba.horizonallist.widget.a aVar = dc.bgb;
        long b2 = b(aVar);
        long HY = aVar.HY();
        dc.recycle();
        return new a(view, HY, b2);
    }

    private long b(com.baidu.live.tieba.horizonallist.widget.a aVar) {
        return aVar.type == 1 ? this.bgi.getChildId(aVar.bge, aVar.bgf) : this.bgi.getGroupId(aVar.bge);
    }

    public void setChildIndicator(Drawable drawable) {
        this.bgp = drawable;
        Ib();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.bgo = drawable;
        Ia();
    }

    /* loaded from: classes3.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long bgG;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.bgG = j;
            this.id = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
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
            /* renamed from: dl */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> bgH;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.bgH = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.bgH = new ArrayList<>();
            parcel.readList(this.bgH, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.bgH);
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.bgh != null ? this.bgh.HV() : null);
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.bgh != null && savedState.bgH != null) {
            this.bgh.k(savedState.bgH);
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
