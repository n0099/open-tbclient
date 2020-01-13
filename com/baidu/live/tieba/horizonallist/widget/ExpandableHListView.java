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
import com.baidu.live.r.a;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.tieba.horizonallist.widget.ExpandableHListConnector;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ExpandableHListView extends HListView {
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] avB = {16842920};
    private static final int[] avC = {16842921};
    private static final int[] avD = {16842920, 16842921};
    private static final int[][] avE = {EMPTY_STATE_SET, avB, avC, avD};
    private static final int[] avF = {16842918};
    private Drawable avA;
    private Drawable avG;
    private final Rect avH;
    private int avI;
    private int avJ;
    private int avK;
    private int avL;
    private d avM;
    private e avN;
    private c avO;
    private b avP;
    private ExpandableHListConnector avs;
    private ExpandableListAdapter avt;
    private int avu;
    private int avv;
    private int avw;
    private int avx;
    private int avy;
    private Drawable avz;
    private int mIndicatorLeft;
    private final Rect mTempRect;

    /* loaded from: classes2.dex */
    public interface b {
        boolean a(ExpandableHListView expandableHListView, View view, int i, int i2, long j);
    }

    /* loaded from: classes2.dex */
    public interface c {
        boolean a(ExpandableHListView expandableHListView, View view, int i, long j);
    }

    /* loaded from: classes2.dex */
    public interface d {
        void cl(int i);
    }

    /* loaded from: classes2.dex */
    public interface e {
        void cm(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.c.sdk_hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.avH = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.avu = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.avv = obtainStyledAttributes.getInt(a.k.sdk_ExpandableHListView_sdk_hlv_indicatorGravity, 0);
        this.avw = obtainStyledAttributes.getInt(a.k.sdk_ExpandableHListView_sdk_hlv_childIndicatorGravity, 0);
        this.avy = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.avx = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.avG = obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        xz();
        xA();
    }

    private void xz() {
        if (this.avz != null) {
            this.avI = this.avz.getIntrinsicWidth();
            this.avJ = this.avz.getIntrinsicHeight();
            return;
        }
        this.avI = 0;
        this.avJ = 0;
    }

    private void xA() {
        if (this.avA != null) {
            this.avK = this.avA.getIntrinsicWidth();
            this.avL = this.avA.getIntrinsicHeight();
            return;
        }
        this.avK = 0;
        this.avL = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.avA != null || this.avz != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.avH;
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
                            ExpandableHListConnector.b ce = this.avs.ce(i4);
                            if (ce.avm.type != i2) {
                                if (ce.avm.type == 1) {
                                    rect.top = childAt.getTop() + this.avx;
                                    rect.bottom = childAt.getBottom() + this.avx;
                                } else {
                                    rect.top = childAt.getTop() + this.avu;
                                    rect.bottom = childAt.getBottom() + this.avu;
                                }
                                i2 = ce.avm.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (ce.avm.type == 1) {
                                    rect.left = this.avy + left;
                                    rect.right = this.avy + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(ce);
                                if (c2 != null) {
                                    if (ce.avm.type == 1) {
                                        Gravity.apply(this.avw, this.avK, this.avL, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.avv, this.avI, this.avJ, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            ce.recycle();
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
        if (bVar.avm.type == 2) {
            Drawable drawable = this.avz;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(avE[(bVar.xw() ? (char) 1 : (char) 0) | (bVar.avn == null || bVar.avn.avh == bVar.avn.avg ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.avA;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.avm.avr == bVar.avn.avh ? avF : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.avG = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b ce = this.avs.ce(ci(i2));
            if (ce.avm.type == 1 || (ce.xw() && ce.avn.avh != ce.avn.avg)) {
                Drawable drawable = this.avG;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                ce.recycle();
                return;
            }
            ce.recycle();
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
        this.avt = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.avs = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.avs = null;
        }
        super.setAdapter((ListAdapter) this.avs);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.avt;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int ci(int i) {
        return i - getHeaderViewsCount();
    }

    private int cj(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, com.baidu.live.tieba.horizonallist.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return a(view, ci(i), j);
    }

    boolean a(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b ce = this.avs.ce(i);
        long b2 = b(ce.avm);
        if (ce.avm.type == 2) {
            if (this.avO != null && this.avO.a(this, view, ce.avm.avp, b2)) {
                ce.recycle();
                return true;
            }
            if (ce.xw()) {
                this.avs.a(ce);
                playSoundEffect(0);
                if (this.avM != null) {
                    this.avM.cl(ce.avm.avp);
                }
            } else {
                this.avs.b(ce);
                playSoundEffect(0);
                if (this.avN != null) {
                    this.avN.cm(ce.avm.avp);
                }
                int i2 = ce.avm.avp;
                int headerViewsCount = ce.avm.avr + getHeaderViewsCount();
                smoothScrollToPosition(this.avt.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.avP != null) {
            playSoundEffect(0);
            return this.avP.a(this, view, ce.avm.avp, ce.avm.avq, b2);
        } else {
            z = false;
        }
        ce.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.avM = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.avN = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.avO = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.avP = bVar;
    }

    public long ck(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b ce = this.avs.ce(ci(i));
        long xx = ce.avm.xx();
        ce.recycle();
        return xx;
    }

    public long getSelectedPosition() {
        return ck(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int G = G(selectedPosition);
        if (F(selectedPosition) == 0) {
            return this.avt.getGroupId(G);
        }
        return this.avt.getChildId(G, H(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.live.tieba.horizonallist.widget.a ch = com.baidu.live.tieba.horizonallist.widget.a.ch(i);
        ExpandableHListConnector.b a2 = this.avs.a(ch);
        ch.recycle();
        super.setSelection(cj(a2.avm.avr));
        a2.recycle();
    }

    public static int F(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public static int G(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((9223372032559808512L & j) >> 32);
    }

    public static int H(long j) {
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
        ExpandableHListConnector.b ce = this.avs.ce(ci(i));
        com.baidu.live.tieba.horizonallist.widget.a aVar = ce.avm;
        long b2 = b(aVar);
        long xx = aVar.xx();
        ce.recycle();
        return new a(view, xx, b2);
    }

    private long b(com.baidu.live.tieba.horizonallist.widget.a aVar) {
        return aVar.type == 1 ? this.avt.getChildId(aVar.avp, aVar.avq) : this.avt.getGroupId(aVar.avp);
    }

    public void setChildIndicator(Drawable drawable) {
        this.avA = drawable;
        xA();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.avz = drawable;
        xz();
    }

    /* loaded from: classes2.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long avQ;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.avQ = j;
            this.id = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
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
            /* renamed from: cn */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> avR;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.avR = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.avR = new ArrayList<>();
            parcel.readList(this.avR, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.avR);
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.avs != null ? this.avs.xu() : null);
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.avs != null && savedState.avR != null) {
            this.avs.i(savedState.avR);
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
