package android.support.v7.widget.helper;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.support.v4.animation.AnimatorCompatHelper;
import android.support.v4.animation.AnimatorListenerCompat;
import android.support.v4.animation.AnimatorUpdateListenerCompat;
import android.support.v4.animation.ValueAnimatorCompat;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.recyclerview.R;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.a;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
    public static final int ACTION_STATE_DRAG = 2;
    public static final int ACTION_STATE_IDLE = 0;
    public static final int ACTION_STATE_SWIPE = 1;
    public static final int ANIMATION_TYPE_DRAG = 8;
    public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
    public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
    public static final int DOWN = 2;
    public static final int END = 32;
    public static final int LEFT = 4;
    public static final int RIGHT = 8;
    public static final int START = 16;
    public static final int UP = 1;
    RecyclerView Sz;
    private int Vc;
    float YA;
    Callback YB;
    int YC;
    private List<RecyclerView.ViewHolder> YF;
    private List<Integer> YG;
    GestureDetectorCompat YJ;
    private long YL;
    float Yt;
    float Yu;
    float Yv;
    float Yw;
    float Yx;
    float Yy;
    float Yz;
    private Rect mTmpRect;
    VelocityTracker mVelocityTracker;
    final List<View> Yq = new ArrayList();
    private final float[] Yr = new float[2];
    RecyclerView.ViewHolder Ys = null;
    int mActivePointerId = -1;
    int mActionState = 0;
    List<b> YD = new ArrayList();
    final Runnable YE = new Runnable() { // from class: android.support.v7.widget.helper.ItemTouchHelper.1
        @Override // java.lang.Runnable
        public void run() {
            if (ItemTouchHelper.this.Ys != null && ItemTouchHelper.this.iH()) {
                if (ItemTouchHelper.this.Ys != null) {
                    ItemTouchHelper.this.x(ItemTouchHelper.this.Ys);
                }
                ItemTouchHelper.this.Sz.removeCallbacks(ItemTouchHelper.this.YE);
                ViewCompat.postOnAnimation(ItemTouchHelper.this.Sz, this);
            }
        }
    };
    private RecyclerView.ChildDrawingOrderCallback Si = null;
    View YH = null;
    int YI = -1;
    private final RecyclerView.OnItemTouchListener YK = new RecyclerView.OnItemTouchListener() { // from class: android.support.v7.widget.helper.ItemTouchHelper.2
        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            int findPointerIndex;
            b r;
            ItemTouchHelper.this.YJ.onTouchEvent(motionEvent);
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (actionMasked == 0) {
                ItemTouchHelper.this.mActivePointerId = motionEvent.getPointerId(0);
                ItemTouchHelper.this.Yt = motionEvent.getX();
                ItemTouchHelper.this.Yu = motionEvent.getY();
                ItemTouchHelper.this.iI();
                if (ItemTouchHelper.this.Ys == null && (r = ItemTouchHelper.this.r(motionEvent)) != null) {
                    ItemTouchHelper.this.Yt -= r.Zb;
                    ItemTouchHelper.this.Yu -= r.Zc;
                    ItemTouchHelper.this.a(r.SH, true);
                    if (ItemTouchHelper.this.Yq.remove(r.SH.itemView)) {
                        ItemTouchHelper.this.YB.clearView(ItemTouchHelper.this.Sz, r.SH);
                    }
                    ItemTouchHelper.this.c(r.SH, r.mActionState);
                    ItemTouchHelper.this.a(motionEvent, ItemTouchHelper.this.YC, 0);
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                ItemTouchHelper.this.mActivePointerId = -1;
                ItemTouchHelper.this.c(null, 0);
            } else if (ItemTouchHelper.this.mActivePointerId != -1 && (findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.mActivePointerId)) >= 0) {
                ItemTouchHelper.this.a(actionMasked, motionEvent, findPointerIndex);
            }
            if (ItemTouchHelper.this.mVelocityTracker != null) {
                ItemTouchHelper.this.mVelocityTracker.addMovement(motionEvent);
            }
            return ItemTouchHelper.this.Ys != null;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            ItemTouchHelper.this.YJ.onTouchEvent(motionEvent);
            if (ItemTouchHelper.this.mVelocityTracker != null) {
                ItemTouchHelper.this.mVelocityTracker.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.mActivePointerId != -1) {
                int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
                int findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.mActivePointerId);
                if (findPointerIndex >= 0) {
                    ItemTouchHelper.this.a(actionMasked, motionEvent, findPointerIndex);
                }
                RecyclerView.ViewHolder viewHolder = ItemTouchHelper.this.Ys;
                if (viewHolder != null) {
                    switch (actionMasked) {
                        case 1:
                            break;
                        case 2:
                            if (findPointerIndex >= 0) {
                                ItemTouchHelper.this.a(motionEvent, ItemTouchHelper.this.YC, findPointerIndex);
                                ItemTouchHelper.this.x(viewHolder);
                                ItemTouchHelper.this.Sz.removeCallbacks(ItemTouchHelper.this.YE);
                                ItemTouchHelper.this.YE.run();
                                ItemTouchHelper.this.Sz.invalidate();
                                return;
                            }
                            return;
                        case 3:
                            if (ItemTouchHelper.this.mVelocityTracker != null) {
                                ItemTouchHelper.this.mVelocityTracker.clear();
                                break;
                            }
                            break;
                        case 4:
                        case 5:
                        default:
                            return;
                        case 6:
                            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                            if (motionEvent.getPointerId(actionIndex) == ItemTouchHelper.this.mActivePointerId) {
                                ItemTouchHelper.this.mActivePointerId = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                                ItemTouchHelper.this.a(motionEvent, ItemTouchHelper.this.YC, actionIndex);
                                return;
                            }
                            return;
                    }
                    ItemTouchHelper.this.c(null, 0);
                    ItemTouchHelper.this.mActivePointerId = -1;
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            if (z) {
                ItemTouchHelper.this.c(null, 0);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface ViewDropHandler {
        void prepareForDrop(View view, View view2, int i, int i2);
    }

    public ItemTouchHelper(Callback callback) {
        this.YB = callback;
    }

    private static boolean a(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= ((float) view.getWidth()) + f3 && f2 >= f4 && f2 <= ((float) view.getHeight()) + f4;
    }

    public void attachToRecyclerView(RecyclerView recyclerView) {
        if (this.Sz != recyclerView) {
            if (this.Sz != null) {
                hR();
            }
            this.Sz = recyclerView;
            if (this.Sz != null) {
                Resources resources = recyclerView.getResources();
                this.Yv = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
                this.Yw = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
                hQ();
            }
        }
    }

    private void hQ() {
        this.Vc = ViewConfiguration.get(this.Sz.getContext()).getScaledTouchSlop();
        this.Sz.addItemDecoration(this);
        this.Sz.addOnItemTouchListener(this.YK);
        this.Sz.addOnChildAttachStateChangeListener(this);
        iF();
    }

    private void hR() {
        this.Sz.removeItemDecoration(this);
        this.Sz.removeOnItemTouchListener(this.YK);
        this.Sz.removeOnChildAttachStateChangeListener(this);
        for (int size = this.YD.size() - 1; size >= 0; size--) {
            this.YB.clearView(this.Sz, this.YD.get(0).SH);
        }
        this.YD.clear();
        this.YH = null;
        this.YI = -1;
        iJ();
    }

    private void iF() {
        if (this.YJ == null) {
            this.YJ = new GestureDetectorCompat(this.Sz.getContext(), new a());
        }
    }

    private void d(float[] fArr) {
        if ((this.YC & 12) != 0) {
            fArr[0] = (this.Yz + this.Yx) - this.Ys.itemView.getLeft();
        } else {
            fArr[0] = ViewCompat.getTranslationX(this.Ys.itemView);
        }
        if ((this.YC & 3) != 0) {
            fArr[1] = (this.YA + this.Yy) - this.Ys.itemView.getTop();
        } else {
            fArr[1] = ViewCompat.getTranslationY(this.Ys.itemView);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f;
        float f2 = 0.0f;
        if (this.Ys != null) {
            d(this.Yr);
            f = this.Yr[0];
            f2 = this.Yr[1];
        } else {
            f = 0.0f;
        }
        this.YB.b(canvas, recyclerView, this.Ys, this.YD, this.mActionState, f, f2);
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f;
        float f2 = 0.0f;
        this.YI = -1;
        if (this.Ys != null) {
            d(this.Yr);
            f = this.Yr[0];
            f2 = this.Yr[1];
        } else {
            f = 0.0f;
        }
        this.YB.a(canvas, recyclerView, this.Ys, this.YD, this.mActionState, f, f2);
    }

    void c(RecyclerView.ViewHolder viewHolder, int i) {
        float f;
        float signum;
        int i2;
        if (viewHolder != this.Ys || i != this.mActionState) {
            this.YL = Long.MIN_VALUE;
            int i3 = this.mActionState;
            a(viewHolder, true);
            this.mActionState = i;
            if (i == 2) {
                this.YH = viewHolder.itemView;
                iK();
            }
            int i4 = (1 << ((i * 8) + 8)) - 1;
            boolean z = false;
            if (this.Ys != null) {
                final RecyclerView.ViewHolder viewHolder2 = this.Ys;
                if (viewHolder2.itemView.getParent() != null) {
                    final int y = i3 == 2 ? 0 : y(viewHolder2);
                    iJ();
                    switch (y) {
                        case 1:
                        case 2:
                            f = 0.0f;
                            signum = Math.signum(this.Yy) * this.Sz.getHeight();
                            break;
                        case 4:
                        case 8:
                        case 16:
                        case 32:
                            signum = 0.0f;
                            f = Math.signum(this.Yx) * this.Sz.getWidth();
                            break;
                        default:
                            f = 0.0f;
                            signum = 0.0f;
                            break;
                    }
                    if (i3 == 2) {
                        i2 = 8;
                    } else if (y > 0) {
                        i2 = 2;
                    } else {
                        i2 = 4;
                    }
                    d(this.Yr);
                    float f2 = this.Yr[0];
                    float f3 = this.Yr[1];
                    b bVar = new b(viewHolder2, i2, i3, f2, f3, f, signum) { // from class: android.support.v7.widget.helper.ItemTouchHelper.3
                        @Override // android.support.v7.widget.helper.ItemTouchHelper.b, android.support.v4.animation.AnimatorListenerCompat
                        public void onAnimationEnd(ValueAnimatorCompat valueAnimatorCompat) {
                            super.onAnimationEnd(valueAnimatorCompat);
                            if (!this.Zd) {
                                if (y <= 0) {
                                    ItemTouchHelper.this.YB.clearView(ItemTouchHelper.this.Sz, viewHolder2);
                                } else {
                                    ItemTouchHelper.this.Yq.add(viewHolder2.itemView);
                                    this.Za = true;
                                    if (y > 0) {
                                        ItemTouchHelper.this.a(this, y);
                                    }
                                }
                                if (ItemTouchHelper.this.YH == viewHolder2.itemView) {
                                    ItemTouchHelper.this.aF(viewHolder2.itemView);
                                }
                            }
                        }
                    };
                    bVar.setDuration(this.YB.getAnimationDuration(this.Sz, i2, f - f2, signum - f3));
                    this.YD.add(bVar);
                    bVar.start();
                    z = true;
                } else {
                    aF(viewHolder2.itemView);
                    this.YB.clearView(this.Sz, viewHolder2);
                }
                this.Ys = null;
            }
            boolean z2 = z;
            if (viewHolder != null) {
                this.YC = (this.YB.a(this.Sz, viewHolder) & i4) >> (this.mActionState * 8);
                this.Yz = viewHolder.itemView.getLeft();
                this.YA = viewHolder.itemView.getTop();
                this.Ys = viewHolder;
                if (i == 2) {
                    this.Ys.itemView.performHapticFeedback(0);
                }
            }
            ViewParent parent = this.Sz.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(this.Ys != null);
            }
            if (!z2) {
                this.Sz.getLayoutManager().requestSimpleAnimationsInNextLayout();
            }
            this.YB.onSelectedChanged(this.Ys, this.mActionState);
            this.Sz.invalidate();
        }
    }

    void a(final b bVar, final int i) {
        this.Sz.post(new Runnable() { // from class: android.support.v7.widget.helper.ItemTouchHelper.4
            @Override // java.lang.Runnable
            public void run() {
                if (ItemTouchHelper.this.Sz != null && ItemTouchHelper.this.Sz.isAttachedToWindow() && !bVar.Zd && bVar.SH.getAdapterPosition() != -1) {
                    RecyclerView.ItemAnimator itemAnimator = ItemTouchHelper.this.Sz.getItemAnimator();
                    if ((itemAnimator == null || !itemAnimator.isRunning(null)) && !ItemTouchHelper.this.iG()) {
                        ItemTouchHelper.this.YB.onSwiped(bVar.SH, i);
                    } else {
                        ItemTouchHelper.this.Sz.post(this);
                    }
                }
            }
        });
    }

    boolean iG() {
        int size = this.YD.size();
        for (int i = 0; i < size; i++) {
            if (!this.YD.get(i).vy) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0051, code lost:
        if (r4 < 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0073, code lost:
        if (r8 < 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e4, code lost:
        if (r4 > 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x010c, code lost:
        if (r8 > 0) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean iH() {
        int i;
        int i2;
        if (this.Ys == null) {
            this.YL = Long.MIN_VALUE;
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.YL == Long.MIN_VALUE ? 0L : currentTimeMillis - this.YL;
        RecyclerView.LayoutManager layoutManager = this.Sz.getLayoutManager();
        if (this.mTmpRect == null) {
            this.mTmpRect = new Rect();
        }
        layoutManager.calculateItemDecorationsForChild(this.Ys.itemView, this.mTmpRect);
        if (layoutManager.canScrollHorizontally()) {
            int i3 = (int) (this.Yz + this.Yx);
            i = (i3 - this.mTmpRect.left) - this.Sz.getPaddingLeft();
            if (this.Yx < 0.0f) {
            }
            if (this.Yx > 0.0f) {
                i = ((i3 + this.Ys.itemView.getWidth()) + this.mTmpRect.right) - (this.Sz.getWidth() - this.Sz.getPaddingRight());
            }
        }
        i = 0;
        if (layoutManager.canScrollVertically()) {
            int i4 = (int) (this.YA + this.Yy);
            i2 = (i4 - this.mTmpRect.top) - this.Sz.getPaddingTop();
            if (this.Yy < 0.0f) {
            }
            if (this.Yy > 0.0f) {
                i2 = ((i4 + this.Ys.itemView.getHeight()) + this.mTmpRect.bottom) - (this.Sz.getHeight() - this.Sz.getPaddingBottom());
            }
        }
        i2 = 0;
        int interpolateOutOfBoundsScroll = i != 0 ? this.YB.interpolateOutOfBoundsScroll(this.Sz, this.Ys.itemView.getWidth(), i, this.Sz.getWidth(), j) : i;
        int interpolateOutOfBoundsScroll2 = i2 != 0 ? this.YB.interpolateOutOfBoundsScroll(this.Sz, this.Ys.itemView.getHeight(), i2, this.Sz.getHeight(), j) : i2;
        if (interpolateOutOfBoundsScroll != 0 || interpolateOutOfBoundsScroll2 != 0) {
            if (this.YL == Long.MIN_VALUE) {
                this.YL = currentTimeMillis;
            }
            this.Sz.scrollBy(interpolateOutOfBoundsScroll, interpolateOutOfBoundsScroll2);
            return true;
        }
        this.YL = Long.MIN_VALUE;
        return false;
    }

    private List<RecyclerView.ViewHolder> w(RecyclerView.ViewHolder viewHolder) {
        if (this.YF == null) {
            this.YF = new ArrayList();
            this.YG = new ArrayList();
        } else {
            this.YF.clear();
            this.YG.clear();
        }
        int boundingBoxMargin = this.YB.getBoundingBoxMargin();
        int round = Math.round(this.Yz + this.Yx) - boundingBoxMargin;
        int round2 = Math.round(this.YA + this.Yy) - boundingBoxMargin;
        int width = viewHolder.itemView.getWidth() + round + (boundingBoxMargin * 2);
        int height = viewHolder.itemView.getHeight() + round2 + (boundingBoxMargin * 2);
        int i = (round + width) / 2;
        int i2 = (round2 + height) / 2;
        RecyclerView.LayoutManager layoutManager = this.Sz.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = layoutManager.getChildAt(i3);
            if (childAt != viewHolder.itemView && childAt.getBottom() >= round2 && childAt.getTop() <= height && childAt.getRight() >= round && childAt.getLeft() <= width) {
                RecyclerView.ViewHolder childViewHolder = this.Sz.getChildViewHolder(childAt);
                if (this.YB.canDropOver(this.Sz, this.Ys, childViewHolder)) {
                    int abs = Math.abs(i - ((childAt.getLeft() + childAt.getRight()) / 2));
                    int abs2 = Math.abs(i2 - ((childAt.getBottom() + childAt.getTop()) / 2));
                    int i4 = (abs * abs) + (abs2 * abs2);
                    int size = this.YF.size();
                    int i5 = 0;
                    for (int i6 = 0; i6 < size && i4 > this.YG.get(i6).intValue(); i6++) {
                        i5++;
                    }
                    this.YF.add(i5, childViewHolder);
                    this.YG.add(i5, Integer.valueOf(i4));
                }
            }
        }
        return this.YF;
    }

    void x(RecyclerView.ViewHolder viewHolder) {
        if (!this.Sz.isLayoutRequested() && this.mActionState == 2) {
            float moveThreshold = this.YB.getMoveThreshold(viewHolder);
            int i = (int) (this.Yz + this.Yx);
            int i2 = (int) (this.YA + this.Yy);
            if (Math.abs(i2 - viewHolder.itemView.getTop()) >= viewHolder.itemView.getHeight() * moveThreshold || Math.abs(i - viewHolder.itemView.getLeft()) >= moveThreshold * viewHolder.itemView.getWidth()) {
                List<RecyclerView.ViewHolder> w = w(viewHolder);
                if (w.size() != 0) {
                    RecyclerView.ViewHolder chooseDropTarget = this.YB.chooseDropTarget(viewHolder, w, i, i2);
                    if (chooseDropTarget == null) {
                        this.YF.clear();
                        this.YG.clear();
                        return;
                    }
                    int adapterPosition = chooseDropTarget.getAdapterPosition();
                    int adapterPosition2 = viewHolder.getAdapterPosition();
                    if (this.YB.onMove(this.Sz, viewHolder, chooseDropTarget)) {
                        this.YB.onMoved(this.Sz, viewHolder, adapterPosition2, chooseDropTarget, adapterPosition, i, i2);
                    }
                }
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(View view) {
    }

    @Override // android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(View view) {
        aF(view);
        RecyclerView.ViewHolder childViewHolder = this.Sz.getChildViewHolder(view);
        if (childViewHolder != null) {
            if (this.Ys != null && childViewHolder == this.Ys) {
                c(null, 0);
                return;
            }
            a(childViewHolder, false);
            if (this.Yq.remove(childViewHolder.itemView)) {
                this.YB.clearView(this.Sz, childViewHolder);
            }
        }
    }

    int a(RecyclerView.ViewHolder viewHolder, boolean z) {
        for (int size = this.YD.size() - 1; size >= 0; size--) {
            b bVar = this.YD.get(size);
            if (bVar.SH == viewHolder) {
                bVar.Zd |= z;
                if (!bVar.vy) {
                    bVar.cancel();
                }
                this.YD.remove(size);
                return bVar.YZ;
            }
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.setEmpty();
    }

    void iI() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
        }
        this.mVelocityTracker = VelocityTracker.obtain();
    }

    private void iJ() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private RecyclerView.ViewHolder p(MotionEvent motionEvent) {
        View q;
        RecyclerView.LayoutManager layoutManager = this.Sz.getLayoutManager();
        if (this.mActivePointerId == -1) {
            return null;
        }
        int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
        float abs = Math.abs(motionEvent.getX(findPointerIndex) - this.Yt);
        float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.Yu);
        if (abs >= this.Vc || abs2 >= this.Vc) {
            if (abs <= abs2 || !layoutManager.canScrollHorizontally()) {
                if ((abs2 <= abs || !layoutManager.canScrollVertically()) && (q = q(motionEvent)) != null) {
                    return this.Sz.getChildViewHolder(q);
                }
                return null;
            }
            return null;
        }
        return null;
    }

    boolean a(int i, MotionEvent motionEvent, int i2) {
        RecyclerView.ViewHolder p;
        int a2;
        if (this.Ys != null || i != 2 || this.mActionState == 2 || !this.YB.isItemViewSwipeEnabled() || this.Sz.getScrollState() == 1 || (p = p(motionEvent)) == null || (a2 = (this.YB.a(this.Sz, p) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8) == 0) {
            return false;
        }
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        float f = x - this.Yt;
        float f2 = y - this.Yu;
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if (abs >= this.Vc || abs2 >= this.Vc) {
            if (abs > abs2) {
                if (f < 0.0f && (a2 & 4) == 0) {
                    return false;
                }
                if (f > 0.0f && (a2 & 8) == 0) {
                    return false;
                }
            } else if (f2 < 0.0f && (a2 & 1) == 0) {
                return false;
            } else {
                if (f2 > 0.0f && (a2 & 2) == 0) {
                    return false;
                }
            }
            this.Yy = 0.0f;
            this.Yx = 0.0f;
            this.mActivePointerId = motionEvent.getPointerId(0);
            c(p, 1);
            return true;
        }
        return false;
    }

    View q(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.Ys != null) {
            View view = this.Ys.itemView;
            if (a(view, x, y, this.Yz + this.Yx, this.YA + this.Yy)) {
                return view;
            }
        }
        for (int size = this.YD.size() - 1; size >= 0; size--) {
            b bVar = this.YD.get(size);
            View view2 = bVar.SH.itemView;
            if (a(view2, x, y, bVar.Zb, bVar.Zc)) {
                return view2;
            }
        }
        return this.Sz.findChildViewUnder(x, y);
    }

    public void startDrag(RecyclerView.ViewHolder viewHolder) {
        if (!this.YB.b(this.Sz, viewHolder)) {
            Log.e("ItemTouchHelper", "Start drag has been called but swiping is not enabled");
        } else if (viewHolder.itemView.getParent() != this.Sz) {
            Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
        } else {
            iI();
            this.Yy = 0.0f;
            this.Yx = 0.0f;
            c(viewHolder, 2);
        }
    }

    public void startSwipe(RecyclerView.ViewHolder viewHolder) {
        if (!this.YB.c(this.Sz, viewHolder)) {
            Log.e("ItemTouchHelper", "Start swipe has been called but dragging is not enabled");
        } else if (viewHolder.itemView.getParent() != this.Sz) {
            Log.e("ItemTouchHelper", "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
        } else {
            iI();
            this.Yy = 0.0f;
            this.Yx = 0.0f;
            c(viewHolder, 1);
        }
    }

    b r(MotionEvent motionEvent) {
        if (this.YD.isEmpty()) {
            return null;
        }
        View q = q(motionEvent);
        for (int size = this.YD.size() - 1; size >= 0; size--) {
            b bVar = this.YD.get(size);
            if (bVar.SH.itemView == q) {
                return bVar;
            }
        }
        return null;
    }

    void a(MotionEvent motionEvent, int i, int i2) {
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        this.Yx = x - this.Yt;
        this.Yy = y - this.Yu;
        if ((i & 4) == 0) {
            this.Yx = Math.max(0.0f, this.Yx);
        }
        if ((i & 8) == 0) {
            this.Yx = Math.min(0.0f, this.Yx);
        }
        if ((i & 1) == 0) {
            this.Yy = Math.max(0.0f, this.Yy);
        }
        if ((i & 2) == 0) {
            this.Yy = Math.min(0.0f, this.Yy);
        }
    }

    private int y(RecyclerView.ViewHolder viewHolder) {
        if (this.mActionState == 2) {
            return 0;
        }
        int movementFlags = this.YB.getMovementFlags(this.Sz, viewHolder);
        int convertToAbsoluteDirection = (this.YB.convertToAbsoluteDirection(movementFlags, ViewCompat.getLayoutDirection(this.Sz)) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (convertToAbsoluteDirection != 0) {
            int i = (movementFlags & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
            if (Math.abs(this.Yx) > Math.abs(this.Yy)) {
                int d = d(viewHolder, convertToAbsoluteDirection);
                if (d > 0) {
                    return (i & d) == 0 ? Callback.convertToRelativeDirection(d, ViewCompat.getLayoutDirection(this.Sz)) : d;
                }
                int e = e(viewHolder, convertToAbsoluteDirection);
                if (e > 0) {
                    return e;
                }
                return 0;
            }
            int e2 = e(viewHolder, convertToAbsoluteDirection);
            if (e2 > 0) {
                return e2;
            }
            int d2 = d(viewHolder, convertToAbsoluteDirection);
            if (d2 > 0) {
                return (i & d2) == 0 ? Callback.convertToRelativeDirection(d2, ViewCompat.getLayoutDirection(this.Sz)) : d2;
            }
            return 0;
        }
        return 0;
    }

    private int d(RecyclerView.ViewHolder viewHolder, int i) {
        if ((i & 12) != 0) {
            int i2 = this.Yx > 0.0f ? 8 : 4;
            if (this.mVelocityTracker != null && this.mActivePointerId > -1) {
                this.mVelocityTracker.computeCurrentVelocity(1000, this.YB.getSwipeVelocityThreshold(this.Yw));
                float xVelocity = VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId);
                float yVelocity = VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId);
                int i3 = xVelocity <= 0.0f ? 4 : 8;
                float abs = Math.abs(xVelocity);
                if ((i3 & i) != 0 && i2 == i3 && abs >= this.YB.getSwipeEscapeVelocity(this.Yv) && abs > Math.abs(yVelocity)) {
                    return i3;
                }
            }
            float width = this.Sz.getWidth() * this.YB.getSwipeThreshold(viewHolder);
            if ((i & i2) != 0 && Math.abs(this.Yx) > width) {
                return i2;
            }
        }
        return 0;
    }

    private int e(RecyclerView.ViewHolder viewHolder, int i) {
        if ((i & 3) != 0) {
            int i2 = this.Yy > 0.0f ? 2 : 1;
            if (this.mVelocityTracker != null && this.mActivePointerId > -1) {
                this.mVelocityTracker.computeCurrentVelocity(1000, this.YB.getSwipeVelocityThreshold(this.Yw));
                float xVelocity = VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId);
                float yVelocity = VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId);
                int i3 = yVelocity <= 0.0f ? 1 : 2;
                float abs = Math.abs(yVelocity);
                if ((i3 & i) != 0 && i3 == i2 && abs >= this.YB.getSwipeEscapeVelocity(this.Yv) && abs > Math.abs(xVelocity)) {
                    return i3;
                }
            }
            float height = this.Sz.getHeight() * this.YB.getSwipeThreshold(viewHolder);
            if ((i & i2) != 0 && Math.abs(this.Yy) > height) {
                return i2;
            }
        }
        return 0;
    }

    private void iK() {
        if (Build.VERSION.SDK_INT < 21) {
            if (this.Si == null) {
                this.Si = new RecyclerView.ChildDrawingOrderCallback() { // from class: android.support.v7.widget.helper.ItemTouchHelper.5
                    @Override // android.support.v7.widget.RecyclerView.ChildDrawingOrderCallback
                    public int onGetChildDrawingOrder(int i, int i2) {
                        if (ItemTouchHelper.this.YH != null) {
                            int i3 = ItemTouchHelper.this.YI;
                            if (i3 == -1) {
                                i3 = ItemTouchHelper.this.Sz.indexOfChild(ItemTouchHelper.this.YH);
                                ItemTouchHelper.this.YI = i3;
                            }
                            return i2 == i + (-1) ? i3 : i2 >= i3 ? i2 + 1 : i2;
                        }
                        return i2;
                    }
                };
            }
            this.Sz.setChildDrawingOrderCallback(this.Si);
        }
    }

    void aF(View view) {
        if (view == this.YH) {
            this.YH = null;
            if (this.Si != null) {
                this.Sz.setChildDrawingOrderCallback(null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class Callback {
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
        private static final ItemTouchUIUtil YQ;
        private static final Interpolator YR = new Interpolator() { // from class: android.support.v7.widget.helper.ItemTouchHelper.Callback.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return f * f * f * f * f;
            }
        };
        private static final Interpolator YS = new Interpolator() { // from class: android.support.v7.widget.helper.ItemTouchHelper.Callback.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        };
        private int YT = -1;

        public abstract int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder);

        public abstract boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2);

        public abstract void onSwiped(RecyclerView.ViewHolder viewHolder, int i);

        static {
            if (Build.VERSION.SDK_INT >= 21) {
                YQ = new a.c();
            } else if (Build.VERSION.SDK_INT >= 11) {
                YQ = new a.b();
            } else {
                YQ = new a.C0012a();
            }
        }

        public static ItemTouchUIUtil getDefaultUIUtil() {
            return YQ;
        }

        public static int convertToRelativeDirection(int i, int i2) {
            int i3 = i & 789516;
            if (i3 != 0) {
                int i4 = (i3 ^ (-1)) & i;
                if (i2 == 0) {
                    return i4 | (i3 << 2);
                }
                return i4 | ((i3 << 1) & (-789517)) | (((i3 << 1) & 789516) << 2);
            }
            return i;
        }

        public static int makeMovementFlags(int i, int i2) {
            return makeFlag(0, i2 | i) | makeFlag(1, i2) | makeFlag(2, i);
        }

        public static int makeFlag(int i, int i2) {
            return i2 << (i * 8);
        }

        public int convertToAbsoluteDirection(int i, int i2) {
            int i3 = i & 3158064;
            if (i3 != 0) {
                int i4 = (i3 ^ (-1)) & i;
                if (i2 == 0) {
                    return i4 | (i3 >> 2);
                }
                return i4 | ((i3 >> 1) & (-3158065)) | (((i3 >> 1) & 3158064) >> 2);
            }
            return i;
        }

        final int a(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return convertToAbsoluteDirection(getMovementFlags(recyclerView, viewHolder), ViewCompat.getLayoutDirection(recyclerView));
        }

        boolean b(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return (a(recyclerView, viewHolder) & 16711680) != 0;
        }

        boolean c(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return (a(recyclerView, viewHolder) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) != 0;
        }

        public boolean canDropOver(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            return true;
        }

        public boolean isLongPressDragEnabled() {
            return true;
        }

        public boolean isItemViewSwipeEnabled() {
            return true;
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public float getMoveThreshold(RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public float getSwipeEscapeVelocity(float f) {
            return f;
        }

        public float getSwipeVelocityThreshold(float f) {
            return f;
        }

        public RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder viewHolder, List<RecyclerView.ViewHolder> list, int i, int i2) {
            RecyclerView.ViewHolder viewHolder2;
            int i3;
            int i4;
            int i5;
            int i6;
            RecyclerView.ViewHolder viewHolder3;
            int bottom;
            int abs;
            int top;
            int left;
            int right;
            int abs2;
            int width = i + viewHolder.itemView.getWidth();
            int height = i2 + viewHolder.itemView.getHeight();
            RecyclerView.ViewHolder viewHolder4 = null;
            int i7 = -1;
            int left2 = i - viewHolder.itemView.getLeft();
            int top2 = i2 - viewHolder.itemView.getTop();
            int size = list.size();
            int i8 = 0;
            while (i8 < size) {
                RecyclerView.ViewHolder viewHolder5 = list.get(i8);
                if (left2 <= 0 || (right = viewHolder5.itemView.getRight() - width) >= 0 || viewHolder5.itemView.getRight() <= viewHolder.itemView.getRight() || (abs2 = Math.abs(right)) <= i7) {
                    viewHolder2 = viewHolder4;
                    i3 = i7;
                } else {
                    i3 = abs2;
                    viewHolder2 = viewHolder5;
                }
                if (left2 >= 0 || (left = viewHolder5.itemView.getLeft() - i) <= 0 || viewHolder5.itemView.getLeft() >= viewHolder.itemView.getLeft() || (i4 = Math.abs(left)) <= i3) {
                    i4 = i3;
                } else {
                    viewHolder2 = viewHolder5;
                }
                if (top2 >= 0 || (top = viewHolder5.itemView.getTop() - i2) <= 0 || viewHolder5.itemView.getTop() >= viewHolder.itemView.getTop() || (i5 = Math.abs(top)) <= i4) {
                    i5 = i4;
                } else {
                    viewHolder2 = viewHolder5;
                }
                if (top2 <= 0 || (bottom = viewHolder5.itemView.getBottom() - height) >= 0 || viewHolder5.itemView.getBottom() <= viewHolder.itemView.getBottom() || (abs = Math.abs(bottom)) <= i5) {
                    i6 = i5;
                    viewHolder3 = viewHolder2;
                } else {
                    viewHolder3 = viewHolder5;
                    i6 = abs;
                }
                i8++;
                viewHolder4 = viewHolder3;
                i7 = i6;
            }
            return viewHolder4;
        }

        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder != null) {
                YQ.onSelected(viewHolder.itemView);
            }
        }

        private int f(RecyclerView recyclerView) {
            if (this.YT == -1) {
                this.YT = recyclerView.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.YT;
        }

        public void onMoved(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof ViewDropHandler) {
                ((ViewDropHandler) layoutManager).prepareForDrop(viewHolder.itemView, viewHolder2.itemView, i3, i4);
                return;
            }
            if (layoutManager.canScrollHorizontally()) {
                if (layoutManager.getDecoratedLeft(viewHolder2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedRight(viewHolder2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
            if (layoutManager.canScrollVertically()) {
                if (layoutManager.getDecoratedTop(viewHolder2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedBottom(viewHolder2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
        }

        void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<b> list, int i, float f, float f2) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = list.get(i2);
                bVar.update();
                int save = canvas.save();
                onChildDraw(canvas, recyclerView, bVar.SH, bVar.Zb, bVar.Zc, bVar.mActionState, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, true);
                canvas.restoreToCount(save2);
            }
        }

        void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<b> list, int i, float f, float f2) {
            boolean z;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = list.get(i2);
                int save = canvas.save();
                onChildDrawOver(canvas, recyclerView, bVar.SH, bVar.Zb, bVar.Zc, bVar.mActionState, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                onChildDrawOver(canvas, recyclerView, viewHolder, f, f2, i, true);
                canvas.restoreToCount(save2);
            }
            boolean z2 = false;
            int i3 = size - 1;
            while (i3 >= 0) {
                b bVar2 = list.get(i3);
                if (bVar2.vy && !bVar2.Za) {
                    list.remove(i3);
                    z = z2;
                } else {
                    z = !bVar2.vy ? true : z2;
                }
                i3--;
                z2 = z;
            }
            if (z2) {
                recyclerView.invalidate();
            }
        }

        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            YQ.clearView(viewHolder.itemView);
        }

        public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            YQ.onDraw(canvas, recyclerView, viewHolder.itemView, f, f2, i, z);
        }

        public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            YQ.onDrawOver(canvas, recyclerView, viewHolder.itemView, f, f2, i, z);
        }

        public long getAnimationDuration(RecyclerView recyclerView, int i, float f, float f2) {
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            return itemAnimator == null ? i == 8 ? 200L : 250L : i == 8 ? itemAnimator.getMoveDuration() : itemAnimator.getRemoveDuration();
        }

        public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int i, int i2, int i3, long j) {
            int interpolation = (int) (YR.getInterpolation(j <= 2000 ? ((float) j) / 2000.0f : 1.0f) * ((int) (f(recyclerView) * ((int) Math.signum(i2)) * YS.getInterpolation(Math.min(1.0f, (Math.abs(i2) * 1.0f) / i)))));
            if (interpolation == 0) {
                return i2 > 0 ? 1 : -1;
            }
            return interpolation;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class SimpleCallback extends Callback {
        private int Zg;
        private int Zh;

        public SimpleCallback(int i, int i2) {
            this.Zg = i2;
            this.Zh = i;
        }

        public void setDefaultSwipeDirs(int i) {
            this.Zg = i;
        }

        public void setDefaultDragDirs(int i) {
            this.Zh = i;
        }

        public int getSwipeDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return this.Zg;
        }

        public int getDragDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return this.Zh;
        }

        @Override // android.support.v7.widget.helper.ItemTouchHelper.Callback
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return makeMovementFlags(getDragDirs(recyclerView, viewHolder), getSwipeDirs(recyclerView, viewHolder));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            RecyclerView.ViewHolder childViewHolder;
            View q = ItemTouchHelper.this.q(motionEvent);
            if (q != null && (childViewHolder = ItemTouchHelper.this.Sz.getChildViewHolder(q)) != null && ItemTouchHelper.this.YB.b(ItemTouchHelper.this.Sz, childViewHolder) && motionEvent.getPointerId(0) == ItemTouchHelper.this.mActivePointerId) {
                int findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.mActivePointerId);
                float x = motionEvent.getX(findPointerIndex);
                float y = motionEvent.getY(findPointerIndex);
                ItemTouchHelper.this.Yt = x;
                ItemTouchHelper.this.Yu = y;
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                ItemTouchHelper.this.Yy = 0.0f;
                itemTouchHelper.Yx = 0.0f;
                if (ItemTouchHelper.this.YB.isLongPressDragEnabled()) {
                    ItemTouchHelper.this.c(childViewHolder, 2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements AnimatorListenerCompat {
        final RecyclerView.ViewHolder SH;
        final float YU;
        final float YV;
        final float YW;
        final float YX;
        final int YZ;
        public boolean Za;
        float Zb;
        float Zc;
        final int mActionState;
        private float wd;
        boolean Zd = false;
        boolean vy = false;
        private final ValueAnimatorCompat YY = AnimatorCompatHelper.emptyValueAnimator();

        public b(RecyclerView.ViewHolder viewHolder, int i, int i2, float f, float f2, float f3, float f4) {
            this.mActionState = i2;
            this.YZ = i;
            this.SH = viewHolder;
            this.YU = f;
            this.YV = f2;
            this.YW = f3;
            this.YX = f4;
            this.YY.addUpdateListener(new AnimatorUpdateListenerCompat() { // from class: android.support.v7.widget.helper.ItemTouchHelper.b.1
                @Override // android.support.v4.animation.AnimatorUpdateListenerCompat
                public void onAnimationUpdate(ValueAnimatorCompat valueAnimatorCompat) {
                    b.this.setFraction(valueAnimatorCompat.getAnimatedFraction());
                }
            });
            this.YY.setTarget(viewHolder.itemView);
            this.YY.addListener(this);
            setFraction(0.0f);
        }

        public void setDuration(long j) {
            this.YY.setDuration(j);
        }

        public void start() {
            this.SH.setIsRecyclable(false);
            this.YY.start();
        }

        public void cancel() {
            this.YY.cancel();
        }

        public void setFraction(float f) {
            this.wd = f;
        }

        public void update() {
            if (this.YU == this.YW) {
                this.Zb = ViewCompat.getTranslationX(this.SH.itemView);
            } else {
                this.Zb = this.YU + (this.wd * (this.YW - this.YU));
            }
            if (this.YV == this.YX) {
                this.Zc = ViewCompat.getTranslationY(this.SH.itemView);
            } else {
                this.Zc = this.YV + (this.wd * (this.YX - this.YV));
            }
        }

        @Override // android.support.v4.animation.AnimatorListenerCompat
        public void onAnimationStart(ValueAnimatorCompat valueAnimatorCompat) {
        }

        @Override // android.support.v4.animation.AnimatorListenerCompat
        public void onAnimationEnd(ValueAnimatorCompat valueAnimatorCompat) {
            if (!this.vy) {
                this.SH.setIsRecyclable(true);
            }
            this.vy = true;
        }

        @Override // android.support.v4.animation.AnimatorListenerCompat
        public void onAnimationCancel(ValueAnimatorCompat valueAnimatorCompat) {
            setFraction(1.0f);
        }

        @Override // android.support.v4.animation.AnimatorListenerCompat
        public void onAnimationRepeat(ValueAnimatorCompat valueAnimatorCompat) {
        }
    }
}
