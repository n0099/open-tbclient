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
    private static final int[] btb = {16842920};
    private static final int[] btc = {16842921};
    private static final int[] btd = {16842920, 16842921};
    private static final int[][] bte = {EMPTY_STATE_SET, btb, btc, btd};
    private static final int[] btf = {16842918};
    private ExpandableHListConnector bsS;
    private ExpandableListAdapter bsT;
    private int bsU;
    private int bsV;
    private int bsW;
    private int bsX;
    private int bsY;
    private Drawable bsZ;
    private Drawable bta;
    private Drawable btg;
    private final Rect bth;
    private int bti;
    private int btj;
    private int btk;
    private int btl;
    private d btm;
    private e bto;
    private c btp;
    private b btq;
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
        void fw(int i);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void fx(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.c.sdk_hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bth = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.bsU = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.bsV = obtainStyledAttributes.getInt(a.k.sdk_ExpandableHListView_sdk_hlv_indicatorGravity, 0);
        this.bsW = obtainStyledAttributes.getInt(a.k.sdk_ExpandableHListView_sdk_hlv_childIndicatorGravity, 0);
        this.bsY = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.bsX = obtainStyledAttributes.getDimensionPixelSize(a.k.sdk_ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.btg = obtainStyledAttributes.getDrawable(a.k.sdk_ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        PH();
        PI();
    }

    private void PH() {
        if (this.bsZ != null) {
            this.bti = this.bsZ.getIntrinsicWidth();
            this.btj = this.bsZ.getIntrinsicHeight();
            return;
        }
        this.bti = 0;
        this.btj = 0;
    }

    private void PI() {
        if (this.bta != null) {
            this.btk = this.bta.getIntrinsicWidth();
            this.btl = this.bta.getIntrinsicHeight();
            return;
        }
        this.btk = 0;
        this.btl = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bta != null || this.bsZ != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.bth;
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
                            ExpandableHListConnector.b fp = this.bsS.fp(i4);
                            if (fp.bsM.type != i2) {
                                if (fp.bsM.type == 1) {
                                    rect.top = childAt.getTop() + this.bsX;
                                    rect.bottom = childAt.getBottom() + this.bsX;
                                } else {
                                    rect.top = childAt.getTop() + this.bsU;
                                    rect.bottom = childAt.getBottom() + this.bsU;
                                }
                                i2 = fp.bsM.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (fp.bsM.type == 1) {
                                    rect.left = this.bsY + left;
                                    rect.right = this.bsY + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(fp);
                                if (c2 != null) {
                                    if (fp.bsM.type == 1) {
                                        Gravity.apply(this.bsW, this.btk, this.btl, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.bsV, this.bti, this.btj, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            fp.recycle();
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
        if (bVar.bsM.type == 2) {
            Drawable drawable = this.bsZ;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(bte[(bVar.PE() ? (char) 1 : (char) 0) | (bVar.bsN == null || bVar.bsN.bsH == bVar.bsN.bsG ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.bta;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.bsM.bsR == bVar.bsN.bsH ? btf : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.btg = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b fp = this.bsS.fp(ft(i2));
            if (fp.bsM.type == 1 || (fp.PE() && fp.bsN.bsH != fp.bsN.bsG)) {
                Drawable drawable = this.btg;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                fp.recycle();
                return;
            }
            fp.recycle();
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
        this.bsT = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.bsS = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.bsS = null;
        }
        super.setAdapter((ListAdapter) this.bsS);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.bsT;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int ft(int i) {
        return i - getHeaderViewsCount();
    }

    private int fu(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, com.baidu.live.tieba.horizonallist.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return a(view, ft(i), j);
    }

    boolean a(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b fp = this.bsS.fp(i);
        long b2 = b(fp.bsM);
        if (fp.bsM.type == 2) {
            if (this.btp != null && this.btp.a(this, view, fp.bsM.bsP, b2)) {
                fp.recycle();
                return true;
            }
            if (fp.PE()) {
                this.bsS.a(fp);
                playSoundEffect(0);
                if (this.btm != null) {
                    this.btm.fw(fp.bsM.bsP);
                }
            } else {
                this.bsS.b(fp);
                playSoundEffect(0);
                if (this.bto != null) {
                    this.bto.fx(fp.bsM.bsP);
                }
                int i2 = fp.bsM.bsP;
                int headerViewsCount = fp.bsM.bsR + getHeaderViewsCount();
                smoothScrollToPosition(this.bsT.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.btq != null) {
            playSoundEffect(0);
            return this.btq.a(this, view, fp.bsM.bsP, fp.bsM.bsQ, b2);
        } else {
            z = false;
        }
        fp.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.btm = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.bto = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.btp = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.btq = bVar;
    }

    public long fv(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b fp = this.bsS.fp(ft(i));
        long PF = fp.bsM.PF();
        fp.recycle();
        return PF;
    }

    public long getSelectedPosition() {
        return fv(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int au = au(selectedPosition);
        if (at(selectedPosition) == 0) {
            return this.bsT.getGroupId(au);
        }
        return this.bsT.getChildId(au, av(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.live.tieba.horizonallist.widget.a fs = com.baidu.live.tieba.horizonallist.widget.a.fs(i);
        ExpandableHListConnector.b a2 = this.bsS.a(fs);
        fs.recycle();
        super.setSelection(fu(a2.bsM.bsR));
        a2.recycle();
    }

    public static int at(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public static int au(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((9223372032559808512L & j) >> 32);
    }

    public static int av(long j) {
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
        ExpandableHListConnector.b fp = this.bsS.fp(ft(i));
        com.baidu.live.tieba.horizonallist.widget.a aVar = fp.bsM;
        long b2 = b(aVar);
        long PF = aVar.PF();
        fp.recycle();
        return new a(view, PF, b2);
    }

    private long b(com.baidu.live.tieba.horizonallist.widget.a aVar) {
        return aVar.type == 1 ? this.bsT.getChildId(aVar.bsP, aVar.bsQ) : this.bsT.getGroupId(aVar.bsP);
    }

    public void setChildIndicator(Drawable drawable) {
        this.bta = drawable;
        PI();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.bsZ = drawable;
        PH();
    }

    /* loaded from: classes4.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long btr;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.btr = j;
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
            /* renamed from: fy */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> bts;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.bts = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.bts = new ArrayList<>();
            parcel.readList(this.bts, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.bts);
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.bsS != null ? this.bsS.PC() : null);
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.bsS != null && savedState.bts != null) {
            this.bsS.p(savedState.bts);
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
