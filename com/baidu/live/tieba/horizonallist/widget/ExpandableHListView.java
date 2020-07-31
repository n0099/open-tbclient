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
/* loaded from: classes4.dex */
public class ExpandableHListView extends HListView {
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] bgK = {16842920};
    private static final int[] bgL = {16842921};
    private static final int[] bgM = {16842920, 16842921};
    private static final int[][] bgN = {EMPTY_STATE_SET, bgK, bgL, bgM};
    private static final int[] bgO = {16842918};
    private ExpandableHListConnector bgB;
    private ExpandableListAdapter bgC;
    private int bgD;
    private int bgE;
    private int bgF;
    private int bgG;
    private int bgH;
    private Drawable bgI;
    private Drawable bgJ;
    private Drawable bgP;
    private final Rect bgQ;
    private int bgR;
    private int bgS;
    private int bgT;
    private int bgU;
    private d bgV;
    private e bgW;
    private c bgX;
    private b bgY;
    private int mIndicatorLeft;
    private final Rect mTempRect;

    /* loaded from: classes4.dex */
    public interface b {
        boolean a(ExpandableHListView expandableHListView, View view, int i, int i2, long j);
    }

    /* loaded from: classes4.dex */
    public interface c {
        boolean a(ExpandableHListView expandableHListView, View view, int i, long j);
    }

    /* loaded from: classes4.dex */
    public interface d {
        void dj(int i);
    }

    /* loaded from: classes4.dex */
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
        this.bgQ = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.bgD = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.bgE = obtainStyledAttributes.getInt(a.k.sdk_ExpandableHListView_sdk_hlv_indicatorGravity, 0);
        this.bgF = obtainStyledAttributes.getInt(a.k.sdk_ExpandableHListView_sdk_hlv_childIndicatorGravity, 0);
        this.bgH = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.bgG = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.bgP = obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        Ig();
        Ih();
    }

    private void Ig() {
        if (this.bgI != null) {
            this.bgR = this.bgI.getIntrinsicWidth();
            this.bgS = this.bgI.getIntrinsicHeight();
            return;
        }
        this.bgR = 0;
        this.bgS = 0;
    }

    private void Ih() {
        if (this.bgJ != null) {
            this.bgT = this.bgJ.getIntrinsicWidth();
            this.bgU = this.bgJ.getIntrinsicHeight();
            return;
        }
        this.bgT = 0;
        this.bgU = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bgJ != null || this.bgI != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.bgQ;
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
                            ExpandableHListConnector.b dc = this.bgB.dc(i4);
                            if (dc.bgv.type != i2) {
                                if (dc.bgv.type == 1) {
                                    rect.top = childAt.getTop() + this.bgG;
                                    rect.bottom = childAt.getBottom() + this.bgG;
                                } else {
                                    rect.top = childAt.getTop() + this.bgD;
                                    rect.bottom = childAt.getBottom() + this.bgD;
                                }
                                i2 = dc.bgv.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (dc.bgv.type == 1) {
                                    rect.left = this.bgH + left;
                                    rect.right = this.bgH + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(dc);
                                if (c2 != null) {
                                    if (dc.bgv.type == 1) {
                                        Gravity.apply(this.bgF, this.bgT, this.bgU, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.bgE, this.bgR, this.bgS, rect, this.mTempRect);
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
        if (bVar.bgv.type == 2) {
            Drawable drawable = this.bgI;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(bgN[(bVar.Id() ? (char) 1 : (char) 0) | (bVar.bgw == null || bVar.bgw.bgp == bVar.bgw.bgo ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.bgJ;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.bgv.bgA == bVar.bgw.bgp ? bgO : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.bgP = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b dc = this.bgB.dc(dg(i2));
            if (dc.bgv.type == 1 || (dc.Id() && dc.bgw.bgp != dc.bgw.bgo)) {
                Drawable drawable = this.bgP;
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
        this.bgC = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.bgB = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.bgB = null;
        }
        super.setAdapter((ListAdapter) this.bgB);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.bgC;
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
        ExpandableHListConnector.b dc = this.bgB.dc(i);
        long b2 = b(dc.bgv);
        if (dc.bgv.type == 2) {
            if (this.bgX != null && this.bgX.a(this, view, dc.bgv.bgy, b2)) {
                dc.recycle();
                return true;
            }
            if (dc.Id()) {
                this.bgB.a(dc);
                playSoundEffect(0);
                if (this.bgV != null) {
                    this.bgV.dj(dc.bgv.bgy);
                }
            } else {
                this.bgB.b(dc);
                playSoundEffect(0);
                if (this.bgW != null) {
                    this.bgW.dk(dc.bgv.bgy);
                }
                int i2 = dc.bgv.bgy;
                int headerViewsCount = dc.bgv.bgA + getHeaderViewsCount();
                smoothScrollToPosition(this.bgC.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.bgY != null) {
            playSoundEffect(0);
            return this.bgY.a(this, view, dc.bgv.bgy, dc.bgv.bgz, b2);
        } else {
            z = false;
        }
        dc.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.bgV = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.bgW = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.bgX = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.bgY = bVar;
    }

    public long di(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b dc = this.bgB.dc(dg(i));
        long Ie = dc.bgv.Ie();
        dc.recycle();
        return Ie;
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
            return this.bgC.getGroupId(ar);
        }
        return this.bgC.getChildId(ar, as(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.live.tieba.horizonallist.widget.a df = com.baidu.live.tieba.horizonallist.widget.a.df(i);
        ExpandableHListConnector.b a2 = this.bgB.a(df);
        df.recycle();
        super.setSelection(dh(a2.bgv.bgA));
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
        ExpandableHListConnector.b dc = this.bgB.dc(dg(i));
        com.baidu.live.tieba.horizonallist.widget.a aVar = dc.bgv;
        long b2 = b(aVar);
        long Ie = aVar.Ie();
        dc.recycle();
        return new a(view, Ie, b2);
    }

    private long b(com.baidu.live.tieba.horizonallist.widget.a aVar) {
        return aVar.type == 1 ? this.bgC.getChildId(aVar.bgy, aVar.bgz) : this.bgC.getGroupId(aVar.bgy);
    }

    public void setChildIndicator(Drawable drawable) {
        this.bgJ = drawable;
        Ih();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.bgI = drawable;
        Ig();
    }

    /* loaded from: classes4.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long bgZ;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.bgZ = j;
            this.id = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
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
        ArrayList<ExpandableHListConnector.GroupMetadata> bha;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.bha = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.bha = new ArrayList<>();
            parcel.readList(this.bha, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.bha);
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.bgB != null ? this.bgB.Ib() : null);
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.bgB != null && savedState.bha != null) {
            this.bgB.k(savedState.bha);
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
