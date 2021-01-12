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
/* loaded from: classes10.dex */
public class ExpandableHListView extends HListView {
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] bET = {16842920};
    private static final int[] bEU = {16842921};
    private static final int[] bEV = {16842920, 16842921};
    private static final int[][] bEW = {EMPTY_STATE_SET, bET, bEU, bEV};
    private static final int[] bEX = {16842918};
    private int Zy;
    private ExpandableHListConnector bEK;
    private ExpandableListAdapter bEL;
    private int bEM;
    private int bEN;
    private int bEO;
    private int bEP;
    private int bEQ;
    private Drawable bER;
    private Drawable bES;
    private Drawable bEY;
    private final Rect bEZ;
    private int bFa;
    private int bFb;
    private int bFc;
    private int bFd;
    private d bFe;
    private e bFf;
    private c bFg;
    private b bFh;
    private final Rect mTempRect;

    /* loaded from: classes10.dex */
    public interface b {
        boolean a(ExpandableHListView expandableHListView, View view, int i, int i2, long j);
    }

    /* loaded from: classes10.dex */
    public interface c {
        boolean a(ExpandableHListView expandableHListView, View view, int i, long j);
    }

    /* loaded from: classes10.dex */
    public interface d {
        void eA(int i);
    }

    /* loaded from: classes10.dex */
    public interface e {
        void eB(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.sdk_hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bEZ = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(a.j.sdk_ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(a.j.sdk_ExpandableHListView_hlv_childIndicator));
        this.Zy = obtainStyledAttributes.getDimensionPixelSize(a.j.sdk_ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.bEM = obtainStyledAttributes.getDimensionPixelSize(a.j.sdk_ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.bEN = obtainStyledAttributes.getInt(a.j.sdk_ExpandableHListView_sdk_hlv_indicatorGravity, 0);
        this.bEO = obtainStyledAttributes.getInt(a.j.sdk_ExpandableHListView_sdk_hlv_childIndicatorGravity, 0);
        this.bEQ = obtainStyledAttributes.getDimensionPixelSize(a.j.sdk_ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.bEP = obtainStyledAttributes.getDimensionPixelSize(a.j.sdk_ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.bEY = obtainStyledAttributes.getDrawable(a.j.sdk_ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        Sm();
        Sn();
    }

    private void Sm() {
        if (this.bER != null) {
            this.bFa = this.bER.getIntrinsicWidth();
            this.bFb = this.bER.getIntrinsicHeight();
            return;
        }
        this.bFa = 0;
        this.bFb = 0;
    }

    private void Sn() {
        if (this.bES != null) {
            this.bFc = this.bES.getIntrinsicWidth();
            this.bFd = this.bES.getIntrinsicHeight();
            return;
        }
        this.bFc = 0;
        this.bFd = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bES != null || this.bER != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            int i = -4;
            Rect rect = this.bEZ;
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
                            ExpandableHListConnector.b et = this.bEK.et(i3);
                            if (et.bEE.type != i) {
                                if (et.bEE.type == 1) {
                                    rect.top = childAt.getTop() + this.bEP;
                                    rect.bottom = childAt.getBottom() + this.bEP;
                                } else {
                                    rect.top = childAt.getTop() + this.bEM;
                                    rect.bottom = childAt.getBottom() + this.bEM;
                                }
                                i = et.bEE.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (et.bEE.type == 1) {
                                    rect.left = this.bEQ + left;
                                    rect.right = this.bEQ + right2;
                                } else {
                                    rect.left = this.Zy + left;
                                    rect.right = this.Zy + right2;
                                }
                                Drawable c2 = c(et);
                                if (c2 != null) {
                                    if (et.bEE.type == 1) {
                                        Gravity.apply(this.bEO, this.bFc, this.bFd, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.bEN, this.bFa, this.bFb, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            et.recycle();
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
        if (bVar.bEE.type == 2) {
            Drawable drawable = this.bER;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(bEW[(bVar.isExpanded() ? (char) 1 : (char) 0) | (bVar.bEF == null || bVar.bEF.bEz == bVar.bEF.bEy ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.bES;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.bEE.bEJ == bVar.bEF.bEz ? bEX : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.bEY = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b et = this.bEK.et(ex(i2));
            if (et.bEE.type == 1 || (et.isExpanded() && et.bEF.bEz != et.bEF.bEy)) {
                Drawable drawable = this.bEY;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                et.recycle();
                return;
            }
            et.recycle();
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
        this.bEL = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.bEK = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.bEK = null;
        }
        super.setAdapter((ListAdapter) this.bEK);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.bEL;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int ex(int i) {
        return i - getHeaderViewsCount();
    }

    private int ey(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, com.baidu.live.tieba.horizonallist.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return b(view, ex(i), j);
    }

    boolean b(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b et = this.bEK.et(i);
        long b2 = b(et.bEE);
        if (et.bEE.type == 2) {
            if (this.bFg != null && this.bFg.a(this, view, et.bEE.bEH, b2)) {
                et.recycle();
                return true;
            }
            if (et.isExpanded()) {
                this.bEK.a(et);
                playSoundEffect(0);
                if (this.bFe != null) {
                    this.bFe.eA(et.bEE.bEH);
                }
            } else {
                this.bEK.b(et);
                playSoundEffect(0);
                if (this.bFf != null) {
                    this.bFf.eB(et.bEE.bEH);
                }
                int i2 = et.bEE.bEH;
                int headerViewsCount = et.bEE.bEJ + getHeaderViewsCount();
                smoothScrollToPosition(this.bEL.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.bFh != null) {
            playSoundEffect(0);
            return this.bFh.a(this, view, et.bEE.bEH, et.bEE.bEI, b2);
        } else {
            z = false;
        }
        et.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.bFe = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.bFf = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.bFg = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.bFh = bVar;
    }

    public long ez(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b et = this.bEK.et(ex(i));
        long Sk = et.bEE.Sk();
        et.recycle();
        return Sk;
    }

    public long getSelectedPosition() {
        return ez(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int bq = bq(selectedPosition);
        if (bp(selectedPosition) == 0) {
            return this.bEL.getGroupId(bq);
        }
        return this.bEL.getChildId(bq, br(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.live.tieba.horizonallist.widget.a ew = com.baidu.live.tieba.horizonallist.widget.a.ew(i);
        ExpandableHListConnector.b a2 = this.bEK.a(ew);
        ew.recycle();
        super.setSelection(ey(a2.bEE.bEJ));
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
        ExpandableHListConnector.b et = this.bEK.et(ex(i));
        com.baidu.live.tieba.horizonallist.widget.a aVar = et.bEE;
        long b2 = b(aVar);
        long Sk = aVar.Sk();
        et.recycle();
        return new a(view, Sk, b2);
    }

    private long b(com.baidu.live.tieba.horizonallist.widget.a aVar) {
        return aVar.type == 1 ? this.bEL.getChildId(aVar.bEH, aVar.bEI) : this.bEL.getGroupId(aVar.bEH);
    }

    public void setChildIndicator(Drawable drawable) {
        this.bES = drawable;
        Sn();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.bER = drawable;
        Sm();
    }

    /* loaded from: classes10.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long bFi;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.bFi = j;
            this.id = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
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
            /* renamed from: eC */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> bFj;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.bFj = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.bFj = new ArrayList<>();
            parcel.readList(this.bFj, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.bFj);
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.bEK != null ? this.bEK.Sh() : null);
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.bEK != null && savedState.bFj != null) {
            this.bEK.k(savedState.bFj);
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
