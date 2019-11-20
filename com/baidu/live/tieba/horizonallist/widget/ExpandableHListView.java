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
import com.baidu.live.k.a;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.tieba.horizonallist.widget.ExpandableHListConnector;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ExpandableHListView extends HListView {
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] amR = {16842920};
    private static final int[] amS = {16842921};
    private static final int[] amT = {16842920, 16842921};
    private static final int[][] amU = {EMPTY_STATE_SET, amR, amS, amT};
    private static final int[] amV = {16842918};
    private ExpandableHListConnector amI;
    private ExpandableListAdapter amJ;
    private int amK;
    private int amL;
    private int amM;
    private int amN;
    private int amO;
    private Drawable amP;
    private Drawable amQ;
    private Drawable amW;
    private final Rect amX;
    private int amY;
    private int amZ;
    private int ana;
    private int anb;
    private d anc;
    private e and;
    private c ane;
    private b anf;
    private int mIndicatorLeft;
    private final Rect mTempRect;

    /* loaded from: classes6.dex */
    public interface b {
        boolean a(ExpandableHListView expandableHListView, View view, int i, int i2, long j);
    }

    /* loaded from: classes6.dex */
    public interface c {
        boolean a(ExpandableHListView expandableHListView, View view, int i, long j);
    }

    /* loaded from: classes6.dex */
    public interface d {
        void bS(int i);
    }

    /* loaded from: classes6.dex */
    public interface e {
        void bT(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.c.sdk_hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amX = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.amK = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.amL = obtainStyledAttributes.getInt(a.k.sdk_ExpandableHListView_sdk_hlv_indicatorGravity, 0);
        this.amM = obtainStyledAttributes.getInt(a.k.sdk_ExpandableHListView_sdk_hlv_childIndicatorGravity, 0);
        this.amO = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.amN = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.amW = obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        vl();
        vm();
    }

    private void vl() {
        if (this.amP != null) {
            this.amY = this.amP.getIntrinsicWidth();
            this.amZ = this.amP.getIntrinsicHeight();
            return;
        }
        this.amY = 0;
        this.amZ = 0;
    }

    private void vm() {
        if (this.amQ != null) {
            this.ana = this.amQ.getIntrinsicWidth();
            this.anb = this.amQ.getIntrinsicHeight();
            return;
        }
        this.ana = 0;
        this.anb = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.amQ != null || this.amP != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.amX;
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
                            ExpandableHListConnector.b bL = this.amI.bL(i4);
                            if (bL.amC.type != i2) {
                                if (bL.amC.type == 1) {
                                    rect.top = childAt.getTop() + this.amN;
                                    rect.bottom = childAt.getBottom() + this.amN;
                                } else {
                                    rect.top = childAt.getTop() + this.amK;
                                    rect.bottom = childAt.getBottom() + this.amK;
                                }
                                i2 = bL.amC.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (bL.amC.type == 1) {
                                    rect.left = this.amO + left;
                                    rect.right = this.amO + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(bL);
                                if (c2 != null) {
                                    if (bL.amC.type == 1) {
                                        Gravity.apply(this.amM, this.ana, this.anb, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.amL, this.amY, this.amZ, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            bL.recycle();
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
        if (bVar.amC.type == 2) {
            Drawable drawable = this.amP;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(amU[(bVar.vi() ? (char) 1 : (char) 0) | (bVar.amD == null || bVar.amD.amx == bVar.amD.amw ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.amQ;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.amC.amH == bVar.amD.amx ? amV : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.amW = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b bL = this.amI.bL(bP(i2));
            if (bL.amC.type == 1 || (bL.vi() && bL.amD.amx != bL.amD.amw)) {
                Drawable drawable = this.amW;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                bL.recycle();
                return;
            }
            bL.recycle();
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
        this.amJ = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.amI = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.amI = null;
        }
        super.setAdapter((ListAdapter) this.amI);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.amJ;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int bP(int i) {
        return i - getHeaderViewsCount();
    }

    private int bQ(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, com.baidu.live.tieba.horizonallist.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return a(view, bP(i), j);
    }

    boolean a(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b bL = this.amI.bL(i);
        long b2 = b(bL.amC);
        if (bL.amC.type == 2) {
            if (this.ane != null && this.ane.a(this, view, bL.amC.amF, b2)) {
                bL.recycle();
                return true;
            }
            if (bL.vi()) {
                this.amI.a(bL);
                playSoundEffect(0);
                if (this.anc != null) {
                    this.anc.bS(bL.amC.amF);
                }
            } else {
                this.amI.b(bL);
                playSoundEffect(0);
                if (this.and != null) {
                    this.and.bT(bL.amC.amF);
                }
                int i2 = bL.amC.amF;
                int headerViewsCount = bL.amC.amH + getHeaderViewsCount();
                smoothScrollToPosition(this.amJ.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.anf != null) {
            playSoundEffect(0);
            return this.anf.a(this, view, bL.amC.amF, bL.amC.amG, b2);
        } else {
            z = false;
        }
        bL.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.anc = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.and = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.ane = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.anf = bVar;
    }

    public long bR(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b bL = this.amI.bL(bP(i));
        long vj = bL.amC.vj();
        bL.recycle();
        return vj;
    }

    public long getSelectedPosition() {
        return bR(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int E = E(selectedPosition);
        if (D(selectedPosition) == 0) {
            return this.amJ.getGroupId(E);
        }
        return this.amJ.getChildId(E, F(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.live.tieba.horizonallist.widget.a bO = com.baidu.live.tieba.horizonallist.widget.a.bO(i);
        ExpandableHListConnector.b a2 = this.amI.a(bO);
        bO.recycle();
        super.setSelection(bQ(a2.amC.amH));
        a2.recycle();
    }

    public static int D(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public static int E(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((9223372032559808512L & j) >> 32);
    }

    public static int F(long j) {
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
        ExpandableHListConnector.b bL = this.amI.bL(bP(i));
        com.baidu.live.tieba.horizonallist.widget.a aVar = bL.amC;
        long b2 = b(aVar);
        long vj = aVar.vj();
        bL.recycle();
        return new a(view, vj, b2);
    }

    private long b(com.baidu.live.tieba.horizonallist.widget.a aVar) {
        return aVar.type == 1 ? this.amJ.getChildId(aVar.amF, aVar.amG) : this.amJ.getGroupId(aVar.amF);
    }

    public void setChildIndicator(Drawable drawable) {
        this.amQ = drawable;
        vm();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.amP = drawable;
        vl();
    }

    /* loaded from: classes6.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public View amp;
        public long ang;
        public long id;

        public a(View view, long j, long j2) {
            this.amp = view;
            this.ang = j;
            this.id = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
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
            /* renamed from: bU */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> anh;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.anh = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.anh = new ArrayList<>();
            parcel.readList(this.anh, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.anh);
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.amI != null ? this.amI.vf() : null);
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.amI != null && savedState.anh != null) {
            this.amI.i(savedState.anh);
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
