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
    private static final int[] azT = {16842920};
    private static final int[] azU = {16842921};
    private static final int[] azV = {16842920, 16842921};
    private static final int[][] azW = {EMPTY_STATE_SET, azT, azU, azV};
    private static final int[] azX = {16842918};
    private int aAa;
    private int aAb;
    private int aAc;
    private int aAd;
    private d aAe;
    private e aAf;
    private c aAg;
    private b aAh;
    private ExpandableHListConnector azK;
    private ExpandableListAdapter azL;
    private int azM;
    private int azN;
    private int azO;
    private int azP;
    private int azQ;
    private Drawable azR;
    private Drawable azS;
    private Drawable azY;
    private final Rect azZ;
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
        void cB(int i);
    }

    /* loaded from: classes3.dex */
    public interface e {
        void cC(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.c.sdk_hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.azZ = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.azM = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.azN = obtainStyledAttributes.getInt(a.k.sdk_ExpandableHListView_sdk_hlv_indicatorGravity, 0);
        this.azO = obtainStyledAttributes.getInt(a.k.sdk_ExpandableHListView_sdk_hlv_childIndicatorGravity, 0);
        this.azQ = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.azP = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.azY = obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        zS();
        zT();
    }

    private void zS() {
        if (this.azR != null) {
            this.aAa = this.azR.getIntrinsicWidth();
            this.aAb = this.azR.getIntrinsicHeight();
            return;
        }
        this.aAa = 0;
        this.aAb = 0;
    }

    private void zT() {
        if (this.azS != null) {
            this.aAc = this.azS.getIntrinsicWidth();
            this.aAd = this.azS.getIntrinsicHeight();
            return;
        }
        this.aAc = 0;
        this.aAd = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.azS != null || this.azR != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.azZ;
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
                            ExpandableHListConnector.b cu = this.azK.cu(i4);
                            if (cu.azE.type != i2) {
                                if (cu.azE.type == 1) {
                                    rect.top = childAt.getTop() + this.azP;
                                    rect.bottom = childAt.getBottom() + this.azP;
                                } else {
                                    rect.top = childAt.getTop() + this.azM;
                                    rect.bottom = childAt.getBottom() + this.azM;
                                }
                                i2 = cu.azE.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (cu.azE.type == 1) {
                                    rect.left = this.azQ + left;
                                    rect.right = this.azQ + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(cu);
                                if (c2 != null) {
                                    if (cu.azE.type == 1) {
                                        Gravity.apply(this.azO, this.aAc, this.aAd, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.azN, this.aAa, this.aAb, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            cu.recycle();
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
        if (bVar.azE.type == 2) {
            Drawable drawable = this.azR;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(azW[(bVar.zP() ? (char) 1 : (char) 0) | (bVar.azF == null || bVar.azF.azz == bVar.azF.azy ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.azS;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.azE.azJ == bVar.azF.azz ? azX : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.azY = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b cu = this.azK.cu(cy(i2));
            if (cu.azE.type == 1 || (cu.zP() && cu.azF.azz != cu.azF.azy)) {
                Drawable drawable = this.azY;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                cu.recycle();
                return;
            }
            cu.recycle();
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
        this.azL = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.azK = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.azK = null;
        }
        super.setAdapter((ListAdapter) this.azK);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.azL;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int cy(int i) {
        return i - getHeaderViewsCount();
    }

    private int cz(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, com.baidu.live.tieba.horizonallist.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return a(view, cy(i), j);
    }

    boolean a(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b cu = this.azK.cu(i);
        long b2 = b(cu.azE);
        if (cu.azE.type == 2) {
            if (this.aAg != null && this.aAg.a(this, view, cu.azE.azH, b2)) {
                cu.recycle();
                return true;
            }
            if (cu.zP()) {
                this.azK.a(cu);
                playSoundEffect(0);
                if (this.aAe != null) {
                    this.aAe.cB(cu.azE.azH);
                }
            } else {
                this.azK.b(cu);
                playSoundEffect(0);
                if (this.aAf != null) {
                    this.aAf.cC(cu.azE.azH);
                }
                int i2 = cu.azE.azH;
                int headerViewsCount = cu.azE.azJ + getHeaderViewsCount();
                smoothScrollToPosition(this.azL.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.aAh != null) {
            playSoundEffect(0);
            return this.aAh.a(this, view, cu.azE.azH, cu.azE.azI, b2);
        } else {
            z = false;
        }
        cu.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.aAe = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.aAf = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.aAg = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.aAh = bVar;
    }

    public long cA(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b cu = this.azK.cu(cy(i));
        long zQ = cu.azE.zQ();
        cu.recycle();
        return zQ;
    }

    public long getSelectedPosition() {
        return cA(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int K = K(selectedPosition);
        if (J(selectedPosition) == 0) {
            return this.azL.getGroupId(K);
        }
        return this.azL.getChildId(K, L(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.live.tieba.horizonallist.widget.a cx = com.baidu.live.tieba.horizonallist.widget.a.cx(i);
        ExpandableHListConnector.b a2 = this.azK.a(cx);
        cx.recycle();
        super.setSelection(cz(a2.azE.azJ));
        a2.recycle();
    }

    public static int J(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public static int K(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((9223372032559808512L & j) >> 32);
    }

    public static int L(long j) {
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
        ExpandableHListConnector.b cu = this.azK.cu(cy(i));
        com.baidu.live.tieba.horizonallist.widget.a aVar = cu.azE;
        long b2 = b(aVar);
        long zQ = aVar.zQ();
        cu.recycle();
        return new a(view, zQ, b2);
    }

    private long b(com.baidu.live.tieba.horizonallist.widget.a aVar) {
        return aVar.type == 1 ? this.azL.getChildId(aVar.azH, aVar.azI) : this.azL.getGroupId(aVar.azH);
    }

    public void setChildIndicator(Drawable drawable) {
        this.azS = drawable;
        zT();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.azR = drawable;
        zS();
    }

    /* loaded from: classes3.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long aAi;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.aAi = j;
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
            /* renamed from: cD */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> aAj;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.aAj = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aAj = new ArrayList<>();
            parcel.readList(this.aAj, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.aAj);
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.azK != null ? this.azK.zN() : null);
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.azK != null && savedState.aAj != null) {
            this.azK.k(savedState.aAj);
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
