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
    private static final int[] bBu = {16842920};
    private static final int[] bBv = {16842921};
    private static final int[] bBw = {16842920, 16842921};
    private static final int[][] bBx = {EMPTY_STATE_SET, bBu, bBv, bBw};
    private static final int[] bBy = {16842918};
    private final Rect bBA;
    private int bBB;
    private int bBC;
    private int bBD;
    private int bBE;
    private d bBF;
    private e bBG;
    private c bBH;
    private b bBI;
    private ExpandableHListConnector bBl;
    private ExpandableListAdapter bBm;
    private int bBn;
    private int bBo;
    private int bBp;
    private int bBq;
    private int bBr;
    private Drawable bBs;
    private Drawable bBt;
    private Drawable bBz;
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
        void fL(int i);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void fM(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.sdk_hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bBA = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(a.j.sdk_ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(a.j.sdk_ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(a.j.sdk_ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.bBn = obtainStyledAttributes.getDimensionPixelSize(a.j.sdk_ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.bBo = obtainStyledAttributes.getInt(a.j.sdk_ExpandableHListView_sdk_hlv_indicatorGravity, 0);
        this.bBp = obtainStyledAttributes.getInt(a.j.sdk_ExpandableHListView_sdk_hlv_childIndicatorGravity, 0);
        this.bBr = obtainStyledAttributes.getDimensionPixelSize(a.j.sdk_ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.bBq = obtainStyledAttributes.getDimensionPixelSize(a.j.sdk_ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.bBz = obtainStyledAttributes.getDrawable(a.j.sdk_ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        Tk();
        Tl();
    }

    private void Tk() {
        if (this.bBs != null) {
            this.bBB = this.bBs.getIntrinsicWidth();
            this.bBC = this.bBs.getIntrinsicHeight();
            return;
        }
        this.bBB = 0;
        this.bBC = 0;
    }

    private void Tl() {
        if (this.bBt != null) {
            this.bBD = this.bBt.getIntrinsicWidth();
            this.bBE = this.bBt.getIntrinsicHeight();
            return;
        }
        this.bBD = 0;
        this.bBE = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bBt != null || this.bBs != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.bBA;
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
                            ExpandableHListConnector.b fE = this.bBl.fE(i4);
                            if (fE.bBf.type != i2) {
                                if (fE.bBf.type == 1) {
                                    rect.top = childAt.getTop() + this.bBq;
                                    rect.bottom = childAt.getBottom() + this.bBq;
                                } else {
                                    rect.top = childAt.getTop() + this.bBn;
                                    rect.bottom = childAt.getBottom() + this.bBn;
                                }
                                i2 = fE.bBf.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (fE.bBf.type == 1) {
                                    rect.left = this.bBr + left;
                                    rect.right = this.bBr + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(fE);
                                if (c2 != null) {
                                    if (fE.bBf.type == 1) {
                                        Gravity.apply(this.bBp, this.bBD, this.bBE, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.bBo, this.bBB, this.bBC, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            fE.recycle();
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
        if (bVar.bBf.type == 2) {
            Drawable drawable = this.bBs;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(bBx[(bVar.Th() ? (char) 1 : (char) 0) | (bVar.bBg == null || bVar.bBg.bBa == bVar.bBg.bAZ ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.bBt;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.bBf.bBk == bVar.bBg.bBa ? bBy : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.bBz = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b fE = this.bBl.fE(fI(i2));
            if (fE.bBf.type == 1 || (fE.Th() && fE.bBg.bBa != fE.bBg.bAZ)) {
                Drawable drawable = this.bBz;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                fE.recycle();
                return;
            }
            fE.recycle();
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
        this.bBm = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.bBl = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.bBl = null;
        }
        super.setAdapter((ListAdapter) this.bBl);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.bBm;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int fI(int i) {
        return i - getHeaderViewsCount();
    }

    private int fJ(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, com.baidu.live.tieba.horizonallist.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return b(view, fI(i), j);
    }

    boolean b(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b fE = this.bBl.fE(i);
        long b2 = b(fE.bBf);
        if (fE.bBf.type == 2) {
            if (this.bBH != null && this.bBH.a(this, view, fE.bBf.bBi, b2)) {
                fE.recycle();
                return true;
            }
            if (fE.Th()) {
                this.bBl.a(fE);
                playSoundEffect(0);
                if (this.bBF != null) {
                    this.bBF.fL(fE.bBf.bBi);
                }
            } else {
                this.bBl.b(fE);
                playSoundEffect(0);
                if (this.bBG != null) {
                    this.bBG.fM(fE.bBf.bBi);
                }
                int i2 = fE.bBf.bBi;
                int headerViewsCount = fE.bBf.bBk + getHeaderViewsCount();
                smoothScrollToPosition(this.bBm.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.bBI != null) {
            playSoundEffect(0);
            return this.bBI.a(this, view, fE.bBf.bBi, fE.bBf.bBj, b2);
        } else {
            z = false;
        }
        fE.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.bBF = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.bBG = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.bBH = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.bBI = bVar;
    }

    public long fK(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b fE = this.bBl.fE(fI(i));
        long Ti = fE.bBf.Ti();
        fE.recycle();
        return Ti;
    }

    public long getSelectedPosition() {
        return fK(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int aS = aS(selectedPosition);
        if (aR(selectedPosition) == 0) {
            return this.bBm.getGroupId(aS);
        }
        return this.bBm.getChildId(aS, aT(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.live.tieba.horizonallist.widget.a fH = com.baidu.live.tieba.horizonallist.widget.a.fH(i);
        ExpandableHListConnector.b a2 = this.bBl.a(fH);
        fH.recycle();
        super.setSelection(fJ(a2.bBf.bBk));
        a2.recycle();
    }

    public static int aR(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public static int aS(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((9223372032559808512L & j) >> 32);
    }

    public static int aT(long j) {
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
        ExpandableHListConnector.b fE = this.bBl.fE(fI(i));
        com.baidu.live.tieba.horizonallist.widget.a aVar = fE.bBf;
        long b2 = b(aVar);
        long Ti = aVar.Ti();
        fE.recycle();
        return new a(view, Ti, b2);
    }

    private long b(com.baidu.live.tieba.horizonallist.widget.a aVar) {
        return aVar.type == 1 ? this.bBm.getChildId(aVar.bBi, aVar.bBj) : this.bBm.getGroupId(aVar.bBi);
    }

    public void setChildIndicator(Drawable drawable) {
        this.bBt = drawable;
        Tl();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.bBs = drawable;
        Tk();
    }

    /* loaded from: classes4.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long bBJ;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.bBJ = j;
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
            /* renamed from: fN */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> bBK;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.bBK = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.bBK = new ArrayList<>();
            parcel.readList(this.bBK, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.bBK);
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.bBl != null ? this.bBl.Tf() : null);
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.bBl != null && savedState.bBK != null) {
            this.bBl.p(savedState.bBK);
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
