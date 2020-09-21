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
    private static final int[] bpo = {16842920};
    private static final int[] bpp = {16842921};
    private static final int[] bpq = {16842920, 16842921};
    private static final int[][] bpr = {EMPTY_STATE_SET, bpo, bpp, bpq};
    private static final int[] bps = {16842918};
    private e bpA;
    private c bpB;
    private b bpC;
    private ExpandableHListConnector bpf;
    private ExpandableListAdapter bpg;
    private int bph;
    private int bpi;
    private int bpj;
    private int bpk;
    private int bpl;
    private Drawable bpm;
    private Drawable bpn;
    private Drawable bpt;
    private final Rect bpu;
    private int bpv;
    private int bpw;
    private int bpx;
    private int bpy;
    private d bpz;
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
        void fn(int i);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void fo(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.c.sdk_hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bpu = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.bph = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.bpi = obtainStyledAttributes.getInt(a.k.sdk_ExpandableHListView_sdk_hlv_indicatorGravity, 0);
        this.bpj = obtainStyledAttributes.getInt(a.k.sdk_ExpandableHListView_sdk_hlv_childIndicatorGravity, 0);
        this.bpl = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.bpk = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.bpt = obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        OC();
        OD();
    }

    private void OC() {
        if (this.bpm != null) {
            this.bpv = this.bpm.getIntrinsicWidth();
            this.bpw = this.bpm.getIntrinsicHeight();
            return;
        }
        this.bpv = 0;
        this.bpw = 0;
    }

    private void OD() {
        if (this.bpn != null) {
            this.bpx = this.bpn.getIntrinsicWidth();
            this.bpy = this.bpn.getIntrinsicHeight();
            return;
        }
        this.bpx = 0;
        this.bpy = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bpn != null || this.bpm != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.bpu;
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
                            ExpandableHListConnector.b fg = this.bpf.fg(i4);
                            if (fg.boZ.type != i2) {
                                if (fg.boZ.type == 1) {
                                    rect.top = childAt.getTop() + this.bpk;
                                    rect.bottom = childAt.getBottom() + this.bpk;
                                } else {
                                    rect.top = childAt.getTop() + this.bph;
                                    rect.bottom = childAt.getBottom() + this.bph;
                                }
                                i2 = fg.boZ.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (fg.boZ.type == 1) {
                                    rect.left = this.bpl + left;
                                    rect.right = this.bpl + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(fg);
                                if (c2 != null) {
                                    if (fg.boZ.type == 1) {
                                        Gravity.apply(this.bpj, this.bpx, this.bpy, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.bpi, this.bpv, this.bpw, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            fg.recycle();
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
        if (bVar.boZ.type == 2) {
            Drawable drawable = this.bpm;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(bpr[(bVar.Oz() ? (char) 1 : (char) 0) | (bVar.bpa == null || bVar.bpa.boU == bVar.bpa.boT ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.bpn;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.boZ.bpe == bVar.bpa.boU ? bps : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.bpt = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b fg = this.bpf.fg(fk(i2));
            if (fg.boZ.type == 1 || (fg.Oz() && fg.bpa.boU != fg.bpa.boT)) {
                Drawable drawable = this.bpt;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                fg.recycle();
                return;
            }
            fg.recycle();
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
        this.bpg = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.bpf = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.bpf = null;
        }
        super.setAdapter((ListAdapter) this.bpf);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.bpg;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int fk(int i) {
        return i - getHeaderViewsCount();
    }

    private int fl(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, com.baidu.live.tieba.horizonallist.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return a(view, fk(i), j);
    }

    boolean a(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b fg = this.bpf.fg(i);
        long b2 = b(fg.boZ);
        if (fg.boZ.type == 2) {
            if (this.bpB != null && this.bpB.a(this, view, fg.boZ.bpc, b2)) {
                fg.recycle();
                return true;
            }
            if (fg.Oz()) {
                this.bpf.a(fg);
                playSoundEffect(0);
                if (this.bpz != null) {
                    this.bpz.fn(fg.boZ.bpc);
                }
            } else {
                this.bpf.b(fg);
                playSoundEffect(0);
                if (this.bpA != null) {
                    this.bpA.fo(fg.boZ.bpc);
                }
                int i2 = fg.boZ.bpc;
                int headerViewsCount = fg.boZ.bpe + getHeaderViewsCount();
                smoothScrollToPosition(this.bpg.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.bpC != null) {
            playSoundEffect(0);
            return this.bpC.a(this, view, fg.boZ.bpc, fg.boZ.bpd, b2);
        } else {
            z = false;
        }
        fg.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.bpz = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.bpA = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.bpB = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.bpC = bVar;
    }

    public long fm(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b fg = this.bpf.fg(fk(i));
        long OA = fg.boZ.OA();
        fg.recycle();
        return OA;
    }

    public long getSelectedPosition() {
        return fm(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int at = at(selectedPosition);
        if (as(selectedPosition) == 0) {
            return this.bpg.getGroupId(at);
        }
        return this.bpg.getChildId(at, au(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.live.tieba.horizonallist.widget.a fj = com.baidu.live.tieba.horizonallist.widget.a.fj(i);
        ExpandableHListConnector.b a2 = this.bpf.a(fj);
        fj.recycle();
        super.setSelection(fl(a2.boZ.bpe));
        a2.recycle();
    }

    public static int as(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public static int at(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((9223372032559808512L & j) >> 32);
    }

    public static int au(long j) {
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
        ExpandableHListConnector.b fg = this.bpf.fg(fk(i));
        com.baidu.live.tieba.horizonallist.widget.a aVar = fg.boZ;
        long b2 = b(aVar);
        long OA = aVar.OA();
        fg.recycle();
        return new a(view, OA, b2);
    }

    private long b(com.baidu.live.tieba.horizonallist.widget.a aVar) {
        return aVar.type == 1 ? this.bpg.getChildId(aVar.bpc, aVar.bpd) : this.bpg.getGroupId(aVar.bpc);
    }

    public void setChildIndicator(Drawable drawable) {
        this.bpn = drawable;
        OD();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.bpm = drawable;
        OC();
    }

    /* loaded from: classes4.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long bpD;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.bpD = j;
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
            /* renamed from: fp */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> bpE;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.bpE = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.bpE = new ArrayList<>();
            parcel.readList(this.bpE, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.bpE);
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.bpf != null ? this.bpf.Ox() : null);
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.bpf != null && savedState.bpE != null) {
            this.bpf.p(savedState.bpE);
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
