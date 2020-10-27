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
    private static final int[] bvj = {16842920};
    private static final int[] bvk = {16842921};
    private static final int[] bvl = {16842920, 16842921};
    private static final int[][] bvm = {EMPTY_STATE_SET, bvj, bvk, bvl};
    private static final int[] bvn = {16842918};
    private ExpandableHListConnector bva;
    private ExpandableListAdapter bvb;
    private int bvc;
    private int bvd;
    private int bve;
    private int bvf;
    private int bvg;
    private Drawable bvh;
    private Drawable bvi;
    private Drawable bvo;
    private final Rect bvp;
    private int bvq;
    private int bvr;
    private int bvs;
    private int bvt;
    private d bvu;
    private e bvv;
    private c bvw;
    private b bvx;
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
        void fy(int i);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void fz(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.c.sdk_hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bvp = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.bvc = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.bvd = obtainStyledAttributes.getInt(a.k.sdk_ExpandableHListView_sdk_hlv_indicatorGravity, 0);
        this.bve = obtainStyledAttributes.getInt(a.k.sdk_ExpandableHListView_sdk_hlv_childIndicatorGravity, 0);
        this.bvg = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.bvf = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.bvo = obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        QA();
        QB();
    }

    private void QA() {
        if (this.bvh != null) {
            this.bvq = this.bvh.getIntrinsicWidth();
            this.bvr = this.bvh.getIntrinsicHeight();
            return;
        }
        this.bvq = 0;
        this.bvr = 0;
    }

    private void QB() {
        if (this.bvi != null) {
            this.bvs = this.bvi.getIntrinsicWidth();
            this.bvt = this.bvi.getIntrinsicHeight();
            return;
        }
        this.bvs = 0;
        this.bvt = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bvi != null || this.bvh != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.bvp;
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
                            ExpandableHListConnector.b fr = this.bva.fr(i4);
                            if (fr.buU.type != i2) {
                                if (fr.buU.type == 1) {
                                    rect.top = childAt.getTop() + this.bvf;
                                    rect.bottom = childAt.getBottom() + this.bvf;
                                } else {
                                    rect.top = childAt.getTop() + this.bvc;
                                    rect.bottom = childAt.getBottom() + this.bvc;
                                }
                                i2 = fr.buU.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (fr.buU.type == 1) {
                                    rect.left = this.bvg + left;
                                    rect.right = this.bvg + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(fr);
                                if (c2 != null) {
                                    if (fr.buU.type == 1) {
                                        Gravity.apply(this.bve, this.bvs, this.bvt, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.bvd, this.bvq, this.bvr, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            fr.recycle();
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
        if (bVar.buU.type == 2) {
            Drawable drawable = this.bvh;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(bvm[(bVar.Qx() ? (char) 1 : (char) 0) | (bVar.buV == null || bVar.buV.buP == bVar.buV.buO ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.bvi;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.buU.buZ == bVar.buV.buP ? bvn : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.bvo = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b fr = this.bva.fr(fv(i2));
            if (fr.buU.type == 1 || (fr.Qx() && fr.buV.buP != fr.buV.buO)) {
                Drawable drawable = this.bvo;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                fr.recycle();
                return;
            }
            fr.recycle();
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
        this.bvb = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.bva = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.bva = null;
        }
        super.setAdapter((ListAdapter) this.bva);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.bvb;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int fv(int i) {
        return i - getHeaderViewsCount();
    }

    private int fw(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, com.baidu.live.tieba.horizonallist.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return a(view, fv(i), j);
    }

    boolean a(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b fr = this.bva.fr(i);
        long b2 = b(fr.buU);
        if (fr.buU.type == 2) {
            if (this.bvw != null && this.bvw.a(this, view, fr.buU.buX, b2)) {
                fr.recycle();
                return true;
            }
            if (fr.Qx()) {
                this.bva.a(fr);
                playSoundEffect(0);
                if (this.bvu != null) {
                    this.bvu.fy(fr.buU.buX);
                }
            } else {
                this.bva.b(fr);
                playSoundEffect(0);
                if (this.bvv != null) {
                    this.bvv.fz(fr.buU.buX);
                }
                int i2 = fr.buU.buX;
                int headerViewsCount = fr.buU.buZ + getHeaderViewsCount();
                smoothScrollToPosition(this.bvb.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.bvx != null) {
            playSoundEffect(0);
            return this.bvx.a(this, view, fr.buU.buX, fr.buU.buY, b2);
        } else {
            z = false;
        }
        fr.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.bvu = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.bvv = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.bvw = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.bvx = bVar;
    }

    public long fx(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b fr = this.bva.fr(fv(i));
        long Qy = fr.buU.Qy();
        fr.recycle();
        return Qy;
    }

    public long getSelectedPosition() {
        return fx(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int aw = aw(selectedPosition);
        if (av(selectedPosition) == 0) {
            return this.bvb.getGroupId(aw);
        }
        return this.bvb.getChildId(aw, ax(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.live.tieba.horizonallist.widget.a fu = com.baidu.live.tieba.horizonallist.widget.a.fu(i);
        ExpandableHListConnector.b a2 = this.bva.a(fu);
        fu.recycle();
        super.setSelection(fw(a2.buU.buZ));
        a2.recycle();
    }

    public static int av(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public static int aw(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((9223372032559808512L & j) >> 32);
    }

    public static int ax(long j) {
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
        ExpandableHListConnector.b fr = this.bva.fr(fv(i));
        com.baidu.live.tieba.horizonallist.widget.a aVar = fr.buU;
        long b2 = b(aVar);
        long Qy = aVar.Qy();
        fr.recycle();
        return new a(view, Qy, b2);
    }

    private long b(com.baidu.live.tieba.horizonallist.widget.a aVar) {
        return aVar.type == 1 ? this.bvb.getChildId(aVar.buX, aVar.buY) : this.bvb.getGroupId(aVar.buX);
    }

    public void setChildIndicator(Drawable drawable) {
        this.bvi = drawable;
        QB();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.bvh = drawable;
        QA();
    }

    /* loaded from: classes4.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long bvy;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.bvy = j;
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
            /* renamed from: fA */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> bvz;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.bvz = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.bvz = new ArrayList<>();
            parcel.readList(this.bvz, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.bvz);
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.bva != null ? this.bva.Qv() : null);
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.bva != null && savedState.bvz != null) {
            this.bva.p(savedState.bvz);
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
