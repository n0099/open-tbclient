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
/* loaded from: classes11.dex */
public class ExpandableHListView extends HListView {
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] bID = {16842920};
    private static final int[] bIE = {16842921};
    private static final int[] bIF = {16842920, 16842921};
    private static final int[][] bIG = {EMPTY_STATE_SET, bID, bIE, bIF};
    private static final int[] bIH = {16842918};
    private int Zu;
    private int bIA;
    private Drawable bIB;
    private Drawable bIC;
    private Drawable bII;
    private final Rect bIJ;
    private int bIK;
    private int bIL;
    private int bIM;
    private int bIN;
    private d bIO;
    private e bIP;
    private c bIQ;
    private b bIR;
    private ExpandableHListConnector bIu;
    private ExpandableListAdapter bIv;
    private int bIw;
    private int bIx;
    private int bIy;
    private int bIz;
    private final Rect mTempRect;

    /* loaded from: classes11.dex */
    public interface b {
        boolean a(ExpandableHListView expandableHListView, View view, int i, int i2, long j);
    }

    /* loaded from: classes11.dex */
    public interface c {
        boolean a(ExpandableHListView expandableHListView, View view, int i, long j);
    }

    /* loaded from: classes11.dex */
    public interface d {
        void eE(int i);
    }

    /* loaded from: classes11.dex */
    public interface e {
        void eF(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.sdk_hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bIJ = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(a.j.sdk_ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(a.j.sdk_ExpandableHListView_hlv_childIndicator));
        this.Zu = obtainStyledAttributes.getDimensionPixelSize(a.j.sdk_ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.bIw = obtainStyledAttributes.getDimensionPixelSize(a.j.sdk_ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.bIx = obtainStyledAttributes.getInt(a.j.sdk_ExpandableHListView_sdk_hlv_indicatorGravity, 0);
        this.bIy = obtainStyledAttributes.getInt(a.j.sdk_ExpandableHListView_sdk_hlv_childIndicatorGravity, 0);
        this.bIA = obtainStyledAttributes.getDimensionPixelSize(a.j.sdk_ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.bIz = obtainStyledAttributes.getDimensionPixelSize(a.j.sdk_ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.bII = obtainStyledAttributes.getDrawable(a.j.sdk_ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        TT();
        TU();
    }

    private void TT() {
        if (this.bIB != null) {
            this.bIK = this.bIB.getIntrinsicWidth();
            this.bIL = this.bIB.getIntrinsicHeight();
            return;
        }
        this.bIK = 0;
        this.bIL = 0;
    }

    private void TU() {
        if (this.bIC != null) {
            this.bIM = this.bIC.getIntrinsicWidth();
            this.bIN = this.bIC.getIntrinsicHeight();
            return;
        }
        this.bIM = 0;
        this.bIN = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bIC != null || this.bIB != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            int i = -4;
            Rect rect = this.bIJ;
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
                            ExpandableHListConnector.b ex = this.bIu.ex(i3);
                            if (ex.bIo.type != i) {
                                if (ex.bIo.type == 1) {
                                    rect.top = childAt.getTop() + this.bIz;
                                    rect.bottom = childAt.getBottom() + this.bIz;
                                } else {
                                    rect.top = childAt.getTop() + this.bIw;
                                    rect.bottom = childAt.getBottom() + this.bIw;
                                }
                                i = ex.bIo.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (ex.bIo.type == 1) {
                                    rect.left = this.bIA + left;
                                    rect.right = this.bIA + right2;
                                } else {
                                    rect.left = this.Zu + left;
                                    rect.right = this.Zu + right2;
                                }
                                Drawable c2 = c(ex);
                                if (c2 != null) {
                                    if (ex.bIo.type == 1) {
                                        Gravity.apply(this.bIy, this.bIM, this.bIN, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.bIx, this.bIK, this.bIL, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            ex.recycle();
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
        if (bVar.bIo.type == 2) {
            Drawable drawable = this.bIB;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(bIG[(bVar.isExpanded() ? (char) 1 : (char) 0) | (bVar.bIp == null || bVar.bIp.bIj == bVar.bIp.bIi ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.bIC;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.bIo.bIt == bVar.bIp.bIj ? bIH : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.bII = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b ex = this.bIu.ex(eB(i2));
            if (ex.bIo.type == 1 || (ex.isExpanded() && ex.bIp.bIj != ex.bIp.bIi)) {
                Drawable drawable = this.bII;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                ex.recycle();
                return;
            }
            ex.recycle();
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
        this.bIv = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.bIu = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.bIu = null;
        }
        super.setAdapter((ListAdapter) this.bIu);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.bIv;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int eB(int i) {
        return i - getHeaderViewsCount();
    }

    private int eC(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, com.baidu.live.tieba.horizonallist.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return b(view, eB(i), j);
    }

    boolean b(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b ex = this.bIu.ex(i);
        long b2 = b(ex.bIo);
        if (ex.bIo.type == 2) {
            if (this.bIQ != null && this.bIQ.a(this, view, ex.bIo.bIr, b2)) {
                ex.recycle();
                return true;
            }
            if (ex.isExpanded()) {
                this.bIu.a(ex);
                playSoundEffect(0);
                if (this.bIO != null) {
                    this.bIO.eE(ex.bIo.bIr);
                }
            } else {
                this.bIu.b(ex);
                playSoundEffect(0);
                if (this.bIP != null) {
                    this.bIP.eF(ex.bIo.bIr);
                }
                int i2 = ex.bIo.bIr;
                int headerViewsCount = ex.bIo.bIt + getHeaderViewsCount();
                smoothScrollToPosition(this.bIv.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.bIR != null) {
            playSoundEffect(0);
            return this.bIR.a(this, view, ex.bIo.bIr, ex.bIo.bIs, b2);
        } else {
            z = false;
        }
        ex.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.bIO = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.bIP = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.bIQ = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.bIR = bVar;
    }

    public long eD(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b ex = this.bIu.ex(eB(i));
        long TR = ex.bIo.TR();
        ex.recycle();
        return TR;
    }

    public long getSelectedPosition() {
        return eD(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int bu = bu(selectedPosition);
        if (bt(selectedPosition) == 0) {
            return this.bIv.getGroupId(bu);
        }
        return this.bIv.getChildId(bu, bv(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.live.tieba.horizonallist.widget.a eA = com.baidu.live.tieba.horizonallist.widget.a.eA(i);
        ExpandableHListConnector.b a2 = this.bIu.a(eA);
        eA.recycle();
        super.setSelection(eC(a2.bIo.bIt));
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
        ExpandableHListConnector.b ex = this.bIu.ex(eB(i));
        com.baidu.live.tieba.horizonallist.widget.a aVar = ex.bIo;
        long b2 = b(aVar);
        long TR = aVar.TR();
        ex.recycle();
        return new a(view, TR, b2);
    }

    private long b(com.baidu.live.tieba.horizonallist.widget.a aVar) {
        return aVar.type == 1 ? this.bIv.getChildId(aVar.bIr, aVar.bIs) : this.bIv.getGroupId(aVar.bIr);
    }

    public void setChildIndicator(Drawable drawable) {
        this.bIC = drawable;
        TU();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.bIB = drawable;
        TT();
    }

    /* loaded from: classes11.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long bIS;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.bIS = j;
            this.id = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
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
            /* renamed from: eG */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> bIT;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.bIT = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.bIT = new ArrayList<>();
            parcel.readList(this.bIT, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.bIT);
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.bIu != null ? this.bIu.TO() : null);
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.bIu != null && savedState.bIT != null) {
            this.bIu.k(savedState.bIT);
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
