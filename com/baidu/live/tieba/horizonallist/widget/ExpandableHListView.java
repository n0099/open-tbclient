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
    private static final int[] bJF = {16842920};
    private static final int[] bJG = {16842921};
    private static final int[] bJH = {16842920, 16842921};
    private static final int[][] bJI = {EMPTY_STATE_SET, bJF, bJG, bJH};
    private static final int[] bJJ = {16842918};
    private int ZA;
    private int bJA;
    private int bJB;
    private int bJC;
    private Drawable bJD;
    private Drawable bJE;
    private Drawable bJK;
    private final Rect bJL;
    private int bJM;
    private int bJN;
    private int bJO;
    private int bJP;
    private d bJQ;
    private e bJR;
    private c bJS;
    private b bJT;
    private ExpandableHListConnector bJw;
    private ExpandableListAdapter bJx;
    private int bJy;
    private int bJz;
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
        void gg(int i);
    }

    /* loaded from: classes11.dex */
    public interface e {
        void gh(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.sdk_hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bJL = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(a.j.sdk_ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(a.j.sdk_ExpandableHListView_hlv_childIndicator));
        this.ZA = obtainStyledAttributes.getDimensionPixelSize(a.j.sdk_ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.bJy = obtainStyledAttributes.getDimensionPixelSize(a.j.sdk_ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.bJz = obtainStyledAttributes.getInt(a.j.sdk_ExpandableHListView_sdk_hlv_indicatorGravity, 0);
        this.bJA = obtainStyledAttributes.getInt(a.j.sdk_ExpandableHListView_sdk_hlv_childIndicatorGravity, 0);
        this.bJC = obtainStyledAttributes.getDimensionPixelSize(a.j.sdk_ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.bJB = obtainStyledAttributes.getDimensionPixelSize(a.j.sdk_ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.bJK = obtainStyledAttributes.getDrawable(a.j.sdk_ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        Wf();
        Wg();
    }

    private void Wf() {
        if (this.bJD != null) {
            this.bJM = this.bJD.getIntrinsicWidth();
            this.bJN = this.bJD.getIntrinsicHeight();
            return;
        }
        this.bJM = 0;
        this.bJN = 0;
    }

    private void Wg() {
        if (this.bJE != null) {
            this.bJO = this.bJE.getIntrinsicWidth();
            this.bJP = this.bJE.getIntrinsicHeight();
            return;
        }
        this.bJO = 0;
        this.bJP = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bJE != null || this.bJD != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            int i = -4;
            Rect rect = this.bJL;
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
                            ExpandableHListConnector.b fZ = this.bJw.fZ(i3);
                            if (fZ.bJq.type != i) {
                                if (fZ.bJq.type == 1) {
                                    rect.top = childAt.getTop() + this.bJB;
                                    rect.bottom = childAt.getBottom() + this.bJB;
                                } else {
                                    rect.top = childAt.getTop() + this.bJy;
                                    rect.bottom = childAt.getBottom() + this.bJy;
                                }
                                i = fZ.bJq.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (fZ.bJq.type == 1) {
                                    rect.left = this.bJC + left;
                                    rect.right = this.bJC + right2;
                                } else {
                                    rect.left = this.ZA + left;
                                    rect.right = this.ZA + right2;
                                }
                                Drawable c2 = c(fZ);
                                if (c2 != null) {
                                    if (fZ.bJq.type == 1) {
                                        Gravity.apply(this.bJA, this.bJO, this.bJP, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.bJz, this.bJM, this.bJN, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            fZ.recycle();
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
        if (bVar.bJq.type == 2) {
            Drawable drawable = this.bJD;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(bJI[(bVar.isExpanded() ? (char) 1 : (char) 0) | (bVar.bJr == null || bVar.bJr.bJl == bVar.bJr.bJk ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.bJE;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.bJq.bJv == bVar.bJr.bJl ? bJJ : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.bJK = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b fZ = this.bJw.fZ(gd(i2));
            if (fZ.bJq.type == 1 || (fZ.isExpanded() && fZ.bJr.bJl != fZ.bJr.bJk)) {
                Drawable drawable = this.bJK;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                fZ.recycle();
                return;
            }
            fZ.recycle();
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
        this.bJx = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.bJw = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.bJw = null;
        }
        super.setAdapter((ListAdapter) this.bJw);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.bJx;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int gd(int i) {
        return i - getHeaderViewsCount();
    }

    private int ge(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, com.baidu.live.tieba.horizonallist.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return b(view, gd(i), j);
    }

    boolean b(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b fZ = this.bJw.fZ(i);
        long b2 = b(fZ.bJq);
        if (fZ.bJq.type == 2) {
            if (this.bJS != null && this.bJS.a(this, view, fZ.bJq.bJt, b2)) {
                fZ.recycle();
                return true;
            }
            if (fZ.isExpanded()) {
                this.bJw.a(fZ);
                playSoundEffect(0);
                if (this.bJQ != null) {
                    this.bJQ.gg(fZ.bJq.bJt);
                }
            } else {
                this.bJw.b(fZ);
                playSoundEffect(0);
                if (this.bJR != null) {
                    this.bJR.gh(fZ.bJq.bJt);
                }
                int i2 = fZ.bJq.bJt;
                int headerViewsCount = fZ.bJq.bJv + getHeaderViewsCount();
                smoothScrollToPosition(this.bJx.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.bJT != null) {
            playSoundEffect(0);
            return this.bJT.a(this, view, fZ.bJq.bJt, fZ.bJq.bJu, b2);
        } else {
            z = false;
        }
        fZ.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.bJQ = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.bJR = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.bJS = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.bJT = bVar;
    }

    public long gf(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b fZ = this.bJw.fZ(gd(i));
        long Wd = fZ.bJq.Wd();
        fZ.recycle();
        return Wd;
    }

    public long getSelectedPosition() {
        return gf(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int bq = bq(selectedPosition);
        if (bp(selectedPosition) == 0) {
            return this.bJx.getGroupId(bq);
        }
        return this.bJx.getChildId(bq, br(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.live.tieba.horizonallist.widget.a gc = com.baidu.live.tieba.horizonallist.widget.a.gc(i);
        ExpandableHListConnector.b a2 = this.bJw.a(gc);
        gc.recycle();
        super.setSelection(ge(a2.bJq.bJv));
        a2.recycle();
    }

    public static int bp(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public static int bq(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((9223372032559808512L & j) >> 32);
    }

    public static int br(long j) {
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
        ExpandableHListConnector.b fZ = this.bJw.fZ(gd(i));
        com.baidu.live.tieba.horizonallist.widget.a aVar = fZ.bJq;
        long b2 = b(aVar);
        long Wd = aVar.Wd();
        fZ.recycle();
        return new a(view, Wd, b2);
    }

    private long b(com.baidu.live.tieba.horizonallist.widget.a aVar) {
        return aVar.type == 1 ? this.bJx.getChildId(aVar.bJt, aVar.bJu) : this.bJx.getGroupId(aVar.bJt);
    }

    public void setChildIndicator(Drawable drawable) {
        this.bJE = drawable;
        Wg();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.bJD = drawable;
        Wf();
    }

    /* loaded from: classes11.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long bJU;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.bJU = j;
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
            /* renamed from: gi */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> bJV;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.bJV = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.bJV = new ArrayList<>();
            parcel.readList(this.bJV, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.bJV);
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.bJw != null ? this.bJw.Wa() : null);
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.bJw != null && savedState.bJV != null) {
            this.bJw.p(savedState.bJV);
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
