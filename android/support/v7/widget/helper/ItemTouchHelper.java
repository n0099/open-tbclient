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
    RecyclerView SF;
    private int Vi;
    float YA;
    float YB;
    float YC;
    float YD;
    float YE;
    float YF;
    float YG;
    Callback YH;
    int YI;
    private List<RecyclerView.ViewHolder> YL;
    private List<Integer> YM;
    GestureDetectorCompat YP;
    private long YR;
    float Yz;
    private Rect mTmpRect;
    VelocityTracker mVelocityTracker;
    final List<View> Yw = new ArrayList();
    private final float[] Yx = new float[2];
    RecyclerView.ViewHolder Yy = null;
    int mActivePointerId = -1;
    int mActionState = 0;
    List<b> YJ = new ArrayList();
    final Runnable YK = new Runnable() { // from class: android.support.v7.widget.helper.ItemTouchHelper.1
        @Override // java.lang.Runnable
        public void run() {
            if (ItemTouchHelper.this.Yy != null && ItemTouchHelper.this.iH()) {
                if (ItemTouchHelper.this.Yy != null) {
                    ItemTouchHelper.this.x(ItemTouchHelper.this.Yy);
                }
                ItemTouchHelper.this.SF.removeCallbacks(ItemTouchHelper.this.YK);
                ViewCompat.postOnAnimation(ItemTouchHelper.this.SF, this);
            }
        }
    };
    private RecyclerView.ChildDrawingOrderCallback So = null;
    View YN = null;
    int YO = -1;
    private final RecyclerView.OnItemTouchListener YQ = new RecyclerView.OnItemTouchListener() { // from class: android.support.v7.widget.helper.ItemTouchHelper.2
        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            int findPointerIndex;
            b r;
            ItemTouchHelper.this.YP.onTouchEvent(motionEvent);
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (actionMasked == 0) {
                ItemTouchHelper.this.mActivePointerId = motionEvent.getPointerId(0);
                ItemTouchHelper.this.Yz = motionEvent.getX();
                ItemTouchHelper.this.YA = motionEvent.getY();
                ItemTouchHelper.this.iI();
                if (ItemTouchHelper.this.Yy == null && (r = ItemTouchHelper.this.r(motionEvent)) != null) {
                    ItemTouchHelper.this.Yz -= r.Zh;
                    ItemTouchHelper.this.YA -= r.Zi;
                    ItemTouchHelper.this.a(r.SQ, true);
                    if (ItemTouchHelper.this.Yw.remove(r.SQ.itemView)) {
                        ItemTouchHelper.this.YH.clearView(ItemTouchHelper.this.SF, r.SQ);
                    }
                    ItemTouchHelper.this.c(r.SQ, r.mActionState);
                    ItemTouchHelper.this.a(motionEvent, ItemTouchHelper.this.YI, 0);
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
            return ItemTouchHelper.this.Yy != null;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            ItemTouchHelper.this.YP.onTouchEvent(motionEvent);
            if (ItemTouchHelper.this.mVelocityTracker != null) {
                ItemTouchHelper.this.mVelocityTracker.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.mActivePointerId != -1) {
                int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
                int findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.mActivePointerId);
                if (findPointerIndex >= 0) {
                    ItemTouchHelper.this.a(actionMasked, motionEvent, findPointerIndex);
                }
                RecyclerView.ViewHolder viewHolder = ItemTouchHelper.this.Yy;
                if (viewHolder != null) {
                    switch (actionMasked) {
                        case 1:
                            break;
                        case 2:
                            if (findPointerIndex >= 0) {
                                ItemTouchHelper.this.a(motionEvent, ItemTouchHelper.this.YI, findPointerIndex);
                                ItemTouchHelper.this.x(viewHolder);
                                ItemTouchHelper.this.SF.removeCallbacks(ItemTouchHelper.this.YK);
                                ItemTouchHelper.this.YK.run();
                                ItemTouchHelper.this.SF.invalidate();
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
                                ItemTouchHelper.this.a(motionEvent, ItemTouchHelper.this.YI, actionIndex);
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
        this.YH = callback;
    }

    private static boolean a(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= ((float) view.getWidth()) + f3 && f2 >= f4 && f2 <= ((float) view.getHeight()) + f4;
    }

    public void attachToRecyclerView(RecyclerView recyclerView) {
        if (this.SF != recyclerView) {
            if (this.SF != null) {
                hR();
            }
            this.SF = recyclerView;
            if (this.SF != null) {
                Resources resources = recyclerView.getResources();
                this.YB = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
                this.YC = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
                hQ();
            }
        }
    }

    private void hQ() {
        this.Vi = ViewConfiguration.get(this.SF.getContext()).getScaledTouchSlop();
        this.SF.addItemDecoration(this);
        this.SF.addOnItemTouchListener(this.YQ);
        this.SF.addOnChildAttachStateChangeListener(this);
        iF();
    }

    private void hR() {
        this.SF.removeItemDecoration(this);
        this.SF.removeOnItemTouchListener(this.YQ);
        this.SF.removeOnChildAttachStateChangeListener(this);
        for (int size = this.YJ.size() - 1; size >= 0; size--) {
            this.YH.clearView(this.SF, this.YJ.get(0).SQ);
        }
        this.YJ.clear();
        this.YN = null;
        this.YO = -1;
        iJ();
    }

    private void iF() {
        if (this.YP == null) {
            this.YP = new GestureDetectorCompat(this.SF.getContext(), new a());
        }
    }

    private void d(float[] fArr) {
        if ((this.YI & 12) != 0) {
            fArr[0] = (this.YF + this.YD) - this.Yy.itemView.getLeft();
        } else {
            fArr[0] = ViewCompat.getTranslationX(this.Yy.itemView);
        }
        if ((this.YI & 3) != 0) {
            fArr[1] = (this.YG + this.YE) - this.Yy.itemView.getTop();
        } else {
            fArr[1] = ViewCompat.getTranslationY(this.Yy.itemView);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f;
        float f2 = 0.0f;
        if (this.Yy != null) {
            d(this.Yx);
            f = this.Yx[0];
            f2 = this.Yx[1];
        } else {
            f = 0.0f;
        }
        this.YH.b(canvas, recyclerView, this.Yy, this.YJ, this.mActionState, f, f2);
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f;
        float f2 = 0.0f;
        this.YO = -1;
        if (this.Yy != null) {
            d(this.Yx);
            f = this.Yx[0];
            f2 = this.Yx[1];
        } else {
            f = 0.0f;
        }
        this.YH.a(canvas, recyclerView, this.Yy, this.YJ, this.mActionState, f, f2);
    }

    void c(RecyclerView.ViewHolder viewHolder, int i) {
        float f;
        float signum;
        int i2;
        if (viewHolder != this.Yy || i != this.mActionState) {
            this.YR = Long.MIN_VALUE;
            int i3 = this.mActionState;
            a(viewHolder, true);
            this.mActionState = i;
            if (i == 2) {
                this.YN = viewHolder.itemView;
                iK();
            }
            int i4 = (1 << ((i * 8) + 8)) - 1;
            boolean z = false;
            if (this.Yy != null) {
                final RecyclerView.ViewHolder viewHolder2 = this.Yy;
                if (viewHolder2.itemView.getParent() != null) {
                    final int y = i3 == 2 ? 0 : y(viewHolder2);
                    iJ();
                    switch (y) {
                        case 1:
                        case 2:
                            f = 0.0f;
                            signum = Math.signum(this.YE) * this.SF.getHeight();
                            break;
                        case 4:
                        case 8:
                        case 16:
                        case 32:
                            signum = 0.0f;
                            f = Math.signum(this.YD) * this.SF.getWidth();
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
                    d(this.Yx);
                    float f2 = this.Yx[0];
                    float f3 = this.Yx[1];
                    b bVar = new b(viewHolder2, i2, i3, f2, f3, f, signum) { // from class: android.support.v7.widget.helper.ItemTouchHelper.3
                        @Override // android.support.v7.widget.helper.ItemTouchHelper.b, android.support.v4.animation.AnimatorListenerCompat
                        public void onAnimationEnd(ValueAnimatorCompat valueAnimatorCompat) {
                            super.onAnimationEnd(valueAnimatorCompat);
                            if (!this.Zj) {
                                if (y <= 0) {
                                    ItemTouchHelper.this.YH.clearView(ItemTouchHelper.this.SF, viewHolder2);
                                } else {
                                    ItemTouchHelper.this.Yw.add(viewHolder2.itemView);
                                    this.Zg = true;
                                    if (y > 0) {
                                        ItemTouchHelper.this.a(this, y);
                                    }
                                }
                                if (ItemTouchHelper.this.YN == viewHolder2.itemView) {
                                    ItemTouchHelper.this.aF(viewHolder2.itemView);
                                }
                            }
                        }
                    };
                    bVar.setDuration(this.YH.getAnimationDuration(this.SF, i2, f - f2, signum - f3));
                    this.YJ.add(bVar);
                    bVar.start();
                    z = true;
                } else {
                    aF(viewHolder2.itemView);
                    this.YH.clearView(this.SF, viewHolder2);
                }
                this.Yy = null;
            }
            boolean z2 = z;
            if (viewHolder != null) {
                this.YI = (this.YH.a(this.SF, viewHolder) & i4) >> (this.mActionState * 8);
                this.YF = viewHolder.itemView.getLeft();
                this.YG = viewHolder.itemView.getTop();
                this.Yy = viewHolder;
                if (i == 2) {
                    this.Yy.itemView.performHapticFeedback(0);
                }
            }
            ViewParent parent = this.SF.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(this.Yy != null);
            }
            if (!z2) {
                this.SF.getLayoutManager().requestSimpleAnimationsInNextLayout();
            }
            this.YH.onSelectedChanged(this.Yy, this.mActionState);
            this.SF.invalidate();
        }
    }

    void a(final b bVar, final int i) {
        this.SF.post(new Runnable() { // from class: android.support.v7.widget.helper.ItemTouchHelper.4
            @Override // java.lang.Runnable
            public void run() {
                if (ItemTouchHelper.this.SF != null && ItemTouchHelper.this.SF.isAttachedToWindow() && !bVar.Zj && bVar.SQ.getAdapterPosition() != -1) {
                    RecyclerView.ItemAnimator itemAnimator = ItemTouchHelper.this.SF.getItemAnimator();
                    if ((itemAnimator == null || !itemAnimator.isRunning(null)) && !ItemTouchHelper.this.iG()) {
                        ItemTouchHelper.this.YH.onSwiped(bVar.SQ, i);
                    } else {
                        ItemTouchHelper.this.SF.post(this);
                    }
                }
            }
        });
    }

    boolean iG() {
        int size = this.YJ.size();
        for (int i = 0; i < size; i++) {
            if (!this.YJ.get(i).vz) {
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
        if (this.Yy == null) {
            this.YR = Long.MIN_VALUE;
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.YR == Long.MIN_VALUE ? 0L : currentTimeMillis - this.YR;
        RecyclerView.LayoutManager layoutManager = this.SF.getLayoutManager();
        if (this.mTmpRect == null) {
            this.mTmpRect = new Rect();
        }
        layoutManager.calculateItemDecorationsForChild(this.Yy.itemView, this.mTmpRect);
        if (layoutManager.canScrollHorizontally()) {
            int i3 = (int) (this.YF + this.YD);
            i = (i3 - this.mTmpRect.left) - this.SF.getPaddingLeft();
            if (this.YD < 0.0f) {
            }
            if (this.YD > 0.0f) {
                i = ((i3 + this.Yy.itemView.getWidth()) + this.mTmpRect.right) - (this.SF.getWidth() - this.SF.getPaddingRight());
            }
        }
        i = 0;
        if (layoutManager.canScrollVertically()) {
            int i4 = (int) (this.YG + this.YE);
            i2 = (i4 - this.mTmpRect.top) - this.SF.getPaddingTop();
            if (this.YE < 0.0f) {
            }
            if (this.YE > 0.0f) {
                i2 = ((i4 + this.Yy.itemView.getHeight()) + this.mTmpRect.bottom) - (this.SF.getHeight() - this.SF.getPaddingBottom());
            }
        }
        i2 = 0;
        int interpolateOutOfBoundsScroll = i != 0 ? this.YH.interpolateOutOfBoundsScroll(this.SF, this.Yy.itemView.getWidth(), i, this.SF.getWidth(), j) : i;
        int interpolateOutOfBoundsScroll2 = i2 != 0 ? this.YH.interpolateOutOfBoundsScroll(this.SF, this.Yy.itemView.getHeight(), i2, this.SF.getHeight(), j) : i2;
        if (interpolateOutOfBoundsScroll != 0 || interpolateOutOfBoundsScroll2 != 0) {
            if (this.YR == Long.MIN_VALUE) {
                this.YR = currentTimeMillis;
            }
            this.SF.scrollBy(interpolateOutOfBoundsScroll, interpolateOutOfBoundsScroll2);
            return true;
        }
        this.YR = Long.MIN_VALUE;
        return false;
    }

    private List<RecyclerView.ViewHolder> w(RecyclerView.ViewHolder viewHolder) {
        if (this.YL == null) {
            this.YL = new ArrayList();
            this.YM = new ArrayList();
        } else {
            this.YL.clear();
            this.YM.clear();
        }
        int boundingBoxMargin = this.YH.getBoundingBoxMargin();
        int round = Math.round(this.YF + this.YD) - boundingBoxMargin;
        int round2 = Math.round(this.YG + this.YE) - boundingBoxMargin;
        int width = viewHolder.itemView.getWidth() + round + (boundingBoxMargin * 2);
        int height = viewHolder.itemView.getHeight() + round2 + (boundingBoxMargin * 2);
        int i = (round + width) / 2;
        int i2 = (round2 + height) / 2;
        RecyclerView.LayoutManager layoutManager = this.SF.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = layoutManager.getChildAt(i3);
            if (childAt != viewHolder.itemView && childAt.getBottom() >= round2 && childAt.getTop() <= height && childAt.getRight() >= round && childAt.getLeft() <= width) {
                RecyclerView.ViewHolder childViewHolder = this.SF.getChildViewHolder(childAt);
                if (this.YH.canDropOver(this.SF, this.Yy, childViewHolder)) {
                    int abs = Math.abs(i - ((childAt.getLeft() + childAt.getRight()) / 2));
                    int abs2 = Math.abs(i2 - ((childAt.getBottom() + childAt.getTop()) / 2));
                    int i4 = (abs * abs) + (abs2 * abs2);
                    int size = this.YL.size();
                    int i5 = 0;
                    for (int i6 = 0; i6 < size && i4 > this.YM.get(i6).intValue(); i6++) {
                        i5++;
                    }
                    this.YL.add(i5, childViewHolder);
                    this.YM.add(i5, Integer.valueOf(i4));
                }
            }
        }
        return this.YL;
    }

    void x(RecyclerView.ViewHolder viewHolder) {
        if (!this.SF.isLayoutRequested() && this.mActionState == 2) {
            float moveThreshold = this.YH.getMoveThreshold(viewHolder);
            int i = (int) (this.YF + this.YD);
            int i2 = (int) (this.YG + this.YE);
            if (Math.abs(i2 - viewHolder.itemView.getTop()) >= viewHolder.itemView.getHeight() * moveThreshold || Math.abs(i - viewHolder.itemView.getLeft()) >= moveThreshold * viewHolder.itemView.getWidth()) {
                List<RecyclerView.ViewHolder> w = w(viewHolder);
                if (w.size() != 0) {
                    RecyclerView.ViewHolder chooseDropTarget = this.YH.chooseDropTarget(viewHolder, w, i, i2);
                    if (chooseDropTarget == null) {
                        this.YL.clear();
                        this.YM.clear();
                        return;
                    }
                    int adapterPosition = chooseDropTarget.getAdapterPosition();
                    int adapterPosition2 = viewHolder.getAdapterPosition();
                    if (this.YH.onMove(this.SF, viewHolder, chooseDropTarget)) {
                        this.YH.onMoved(this.SF, viewHolder, adapterPosition2, chooseDropTarget, adapterPosition, i, i2);
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
        RecyclerView.ViewHolder childViewHolder = this.SF.getChildViewHolder(view);
        if (childViewHolder != null) {
            if (this.Yy != null && childViewHolder == this.Yy) {
                c(null, 0);
                return;
            }
            a(childViewHolder, false);
            if (this.Yw.remove(childViewHolder.itemView)) {
                this.YH.clearView(this.SF, childViewHolder);
            }
        }
    }

    int a(RecyclerView.ViewHolder viewHolder, boolean z) {
        for (int size = this.YJ.size() - 1; size >= 0; size--) {
            b bVar = this.YJ.get(size);
            if (bVar.SQ == viewHolder) {
                bVar.Zj |= z;
                if (!bVar.vz) {
                    bVar.cancel();
                }
                this.YJ.remove(size);
                return bVar.Zf;
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
        RecyclerView.LayoutManager layoutManager = this.SF.getLayoutManager();
        if (this.mActivePointerId == -1) {
            return null;
        }
        int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
        float abs = Math.abs(motionEvent.getX(findPointerIndex) - this.Yz);
        float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.YA);
        if (abs >= this.Vi || abs2 >= this.Vi) {
            if (abs <= abs2 || !layoutManager.canScrollHorizontally()) {
                if ((abs2 <= abs || !layoutManager.canScrollVertically()) && (q = q(motionEvent)) != null) {
                    return this.SF.getChildViewHolder(q);
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
        if (this.Yy != null || i != 2 || this.mActionState == 2 || !this.YH.isItemViewSwipeEnabled() || this.SF.getScrollState() == 1 || (p = p(motionEvent)) == null || (a2 = (this.YH.a(this.SF, p) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8) == 0) {
            return false;
        }
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        float f = x - this.Yz;
        float f2 = y - this.YA;
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if (abs >= this.Vi || abs2 >= this.Vi) {
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
            this.YE = 0.0f;
            this.YD = 0.0f;
            this.mActivePointerId = motionEvent.getPointerId(0);
            c(p, 1);
            return true;
        }
        return false;
    }

    View q(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.Yy != null) {
            View view = this.Yy.itemView;
            if (a(view, x, y, this.YF + this.YD, this.YG + this.YE)) {
                return view;
            }
        }
        for (int size = this.YJ.size() - 1; size >= 0; size--) {
            b bVar = this.YJ.get(size);
            View view2 = bVar.SQ.itemView;
            if (a(view2, x, y, bVar.Zh, bVar.Zi)) {
                return view2;
            }
        }
        return this.SF.findChildViewUnder(x, y);
    }

    public void startDrag(RecyclerView.ViewHolder viewHolder) {
        if (!this.YH.b(this.SF, viewHolder)) {
            Log.e("ItemTouchHelper", "Start drag has been called but swiping is not enabled");
        } else if (viewHolder.itemView.getParent() != this.SF) {
            Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
        } else {
            iI();
            this.YE = 0.0f;
            this.YD = 0.0f;
            c(viewHolder, 2);
        }
    }

    public void startSwipe(RecyclerView.ViewHolder viewHolder) {
        if (!this.YH.c(this.SF, viewHolder)) {
            Log.e("ItemTouchHelper", "Start swipe has been called but dragging is not enabled");
        } else if (viewHolder.itemView.getParent() != this.SF) {
            Log.e("ItemTouchHelper", "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
        } else {
            iI();
            this.YE = 0.0f;
            this.YD = 0.0f;
            c(viewHolder, 1);
        }
    }

    b r(MotionEvent motionEvent) {
        if (this.YJ.isEmpty()) {
            return null;
        }
        View q = q(motionEvent);
        for (int size = this.YJ.size() - 1; size >= 0; size--) {
            b bVar = this.YJ.get(size);
            if (bVar.SQ.itemView == q) {
                return bVar;
            }
        }
        return null;
    }

    void a(MotionEvent motionEvent, int i, int i2) {
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        this.YD = x - this.Yz;
        this.YE = y - this.YA;
        if ((i & 4) == 0) {
            this.YD = Math.max(0.0f, this.YD);
        }
        if ((i & 8) == 0) {
            this.YD = Math.min(0.0f, this.YD);
        }
        if ((i & 1) == 0) {
            this.YE = Math.max(0.0f, this.YE);
        }
        if ((i & 2) == 0) {
            this.YE = Math.min(0.0f, this.YE);
        }
    }

    private int y(RecyclerView.ViewHolder viewHolder) {
        if (this.mActionState == 2) {
            return 0;
        }
        int movementFlags = this.YH.getMovementFlags(this.SF, viewHolder);
        int convertToAbsoluteDirection = (this.YH.convertToAbsoluteDirection(movementFlags, ViewCompat.getLayoutDirection(this.SF)) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (convertToAbsoluteDirection != 0) {
            int i = (movementFlags & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
            if (Math.abs(this.YD) > Math.abs(this.YE)) {
                int d = d(viewHolder, convertToAbsoluteDirection);
                if (d > 0) {
                    return (i & d) == 0 ? Callback.convertToRelativeDirection(d, ViewCompat.getLayoutDirection(this.SF)) : d;
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
                return (i & d2) == 0 ? Callback.convertToRelativeDirection(d2, ViewCompat.getLayoutDirection(this.SF)) : d2;
            }
            return 0;
        }
        return 0;
    }

    private int d(RecyclerView.ViewHolder viewHolder, int i) {
        if ((i & 12) != 0) {
            int i2 = this.YD > 0.0f ? 8 : 4;
            if (this.mVelocityTracker != null && this.mActivePointerId > -1) {
                this.mVelocityTracker.computeCurrentVelocity(1000, this.YH.getSwipeVelocityThreshold(this.YC));
                float xVelocity = VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId);
                float yVelocity = VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId);
                int i3 = xVelocity <= 0.0f ? 4 : 8;
                float abs = Math.abs(xVelocity);
                if ((i3 & i) != 0 && i2 == i3 && abs >= this.YH.getSwipeEscapeVelocity(this.YB) && abs > Math.abs(yVelocity)) {
                    return i3;
                }
            }
            float width = this.SF.getWidth() * this.YH.getSwipeThreshold(viewHolder);
            if ((i & i2) != 0 && Math.abs(this.YD) > width) {
                return i2;
            }
        }
        return 0;
    }

    private int e(RecyclerView.ViewHolder viewHolder, int i) {
        if ((i & 3) != 0) {
            int i2 = this.YE > 0.0f ? 2 : 1;
            if (this.mVelocityTracker != null && this.mActivePointerId > -1) {
                this.mVelocityTracker.computeCurrentVelocity(1000, this.YH.getSwipeVelocityThreshold(this.YC));
                float xVelocity = VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId);
                float yVelocity = VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId);
                int i3 = yVelocity <= 0.0f ? 1 : 2;
                float abs = Math.abs(yVelocity);
                if ((i3 & i) != 0 && i3 == i2 && abs >= this.YH.getSwipeEscapeVelocity(this.YB) && abs > Math.abs(xVelocity)) {
                    return i3;
                }
            }
            float height = this.SF.getHeight() * this.YH.getSwipeThreshold(viewHolder);
            if ((i & i2) != 0 && Math.abs(this.YE) > height) {
                return i2;
            }
        }
        return 0;
    }

    private void iK() {
        if (Build.VERSION.SDK_INT < 21) {
            if (this.So == null) {
                this.So = new RecyclerView.ChildDrawingOrderCallback() { // from class: android.support.v7.widget.helper.ItemTouchHelper.5
                    @Override // android.support.v7.widget.RecyclerView.ChildDrawingOrderCallback
                    public int onGetChildDrawingOrder(int i, int i2) {
                        if (ItemTouchHelper.this.YN != null) {
                            int i3 = ItemTouchHelper.this.YO;
                            if (i3 == -1) {
                                i3 = ItemTouchHelper.this.SF.indexOfChild(ItemTouchHelper.this.YN);
                                ItemTouchHelper.this.YO = i3;
                            }
                            return i2 == i + (-1) ? i3 : i2 >= i3 ? i2 + 1 : i2;
                        }
                        return i2;
                    }
                };
            }
            this.SF.setChildDrawingOrderCallback(this.So);
        }
    }

    void aF(View view) {
        if (view == this.YN) {
            this.YN = null;
            if (this.So != null) {
                this.SF.setChildDrawingOrderCallback(null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class Callback {
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
        private static final ItemTouchUIUtil YW;
        private static final Interpolator YX = new Interpolator() { // from class: android.support.v7.widget.helper.ItemTouchHelper.Callback.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return f * f * f * f * f;
            }
        };
        private static final Interpolator YY = new Interpolator() { // from class: android.support.v7.widget.helper.ItemTouchHelper.Callback.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        };
        private int YZ = -1;

        public abstract int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder);

        public abstract boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2);

        public abstract void onSwiped(RecyclerView.ViewHolder viewHolder, int i);

        static {
            if (Build.VERSION.SDK_INT >= 21) {
                YW = new a.c();
            } else if (Build.VERSION.SDK_INT >= 11) {
                YW = new a.b();
            } else {
                YW = new a.C0012a();
            }
        }

        public static ItemTouchUIUtil getDefaultUIUtil() {
            return YW;
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
                YW.onSelected(viewHolder.itemView);
            }
        }

        private int f(RecyclerView recyclerView) {
            if (this.YZ == -1) {
                this.YZ = recyclerView.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.YZ;
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
                onChildDraw(canvas, recyclerView, bVar.SQ, bVar.Zh, bVar.Zi, bVar.mActionState, false);
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
                onChildDrawOver(canvas, recyclerView, bVar.SQ, bVar.Zh, bVar.Zi, bVar.mActionState, false);
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
                if (bVar2.vz && !bVar2.Zg) {
                    list.remove(i3);
                    z = z2;
                } else {
                    z = !bVar2.vz ? true : z2;
                }
                i3--;
                z2 = z;
            }
            if (z2) {
                recyclerView.invalidate();
            }
        }

        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            YW.clearView(viewHolder.itemView);
        }

        public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            YW.onDraw(canvas, recyclerView, viewHolder.itemView, f, f2, i, z);
        }

        public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            YW.onDrawOver(canvas, recyclerView, viewHolder.itemView, f, f2, i, z);
        }

        public long getAnimationDuration(RecyclerView recyclerView, int i, float f, float f2) {
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            return itemAnimator == null ? i == 8 ? 200L : 250L : i == 8 ? itemAnimator.getMoveDuration() : itemAnimator.getRemoveDuration();
        }

        public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int i, int i2, int i3, long j) {
            int interpolation = (int) (YX.getInterpolation(j <= 2000 ? ((float) j) / 2000.0f : 1.0f) * ((int) (f(recyclerView) * ((int) Math.signum(i2)) * YY.getInterpolation(Math.min(1.0f, (Math.abs(i2) * 1.0f) / i)))));
            if (interpolation == 0) {
                return i2 > 0 ? 1 : -1;
            }
            return interpolation;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class SimpleCallback extends Callback {
        private int Zm;
        private int Zn;

        public SimpleCallback(int i, int i2) {
            this.Zm = i2;
            this.Zn = i;
        }

        public void setDefaultSwipeDirs(int i) {
            this.Zm = i;
        }

        public void setDefaultDragDirs(int i) {
            this.Zn = i;
        }

        public int getSwipeDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return this.Zm;
        }

        public int getDragDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return this.Zn;
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
            if (q != null && (childViewHolder = ItemTouchHelper.this.SF.getChildViewHolder(q)) != null && ItemTouchHelper.this.YH.b(ItemTouchHelper.this.SF, childViewHolder) && motionEvent.getPointerId(0) == ItemTouchHelper.this.mActivePointerId) {
                int findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.mActivePointerId);
                float x = motionEvent.getX(findPointerIndex);
                float y = motionEvent.getY(findPointerIndex);
                ItemTouchHelper.this.Yz = x;
                ItemTouchHelper.this.YA = y;
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                ItemTouchHelper.this.YE = 0.0f;
                itemTouchHelper.YD = 0.0f;
                if (ItemTouchHelper.this.YH.isLongPressDragEnabled()) {
                    ItemTouchHelper.this.c(childViewHolder, 2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements AnimatorListenerCompat {
        final RecyclerView.ViewHolder SQ;
        final float Za;
        final float Zb;
        final float Zc;
        final float Zd;
        final int Zf;
        public boolean Zg;
        float Zh;
        float Zi;
        final int mActionState;
        private float we;
        boolean Zj = false;
        boolean vz = false;
        private final ValueAnimatorCompat Ze = AnimatorCompatHelper.emptyValueAnimator();

        public b(RecyclerView.ViewHolder viewHolder, int i, int i2, float f, float f2, float f3, float f4) {
            this.mActionState = i2;
            this.Zf = i;
            this.SQ = viewHolder;
            this.Za = f;
            this.Zb = f2;
            this.Zc = f3;
            this.Zd = f4;
            this.Ze.addUpdateListener(new AnimatorUpdateListenerCompat() { // from class: android.support.v7.widget.helper.ItemTouchHelper.b.1
                @Override // android.support.v4.animation.AnimatorUpdateListenerCompat
                public void onAnimationUpdate(ValueAnimatorCompat valueAnimatorCompat) {
                    b.this.setFraction(valueAnimatorCompat.getAnimatedFraction());
                }
            });
            this.Ze.setTarget(viewHolder.itemView);
            this.Ze.addListener(this);
            setFraction(0.0f);
        }

        public void setDuration(long j) {
            this.Ze.setDuration(j);
        }

        public void start() {
            this.SQ.setIsRecyclable(false);
            this.Ze.start();
        }

        public void cancel() {
            this.Ze.cancel();
        }

        public void setFraction(float f) {
            this.we = f;
        }

        public void update() {
            if (this.Za == this.Zc) {
                this.Zh = ViewCompat.getTranslationX(this.SQ.itemView);
            } else {
                this.Zh = this.Za + (this.we * (this.Zc - this.Za));
            }
            if (this.Zb == this.Zd) {
                this.Zi = ViewCompat.getTranslationY(this.SQ.itemView);
            } else {
                this.Zi = this.Zb + (this.we * (this.Zd - this.Zb));
            }
        }

        @Override // android.support.v4.animation.AnimatorListenerCompat
        public void onAnimationStart(ValueAnimatorCompat valueAnimatorCompat) {
        }

        @Override // android.support.v4.animation.AnimatorListenerCompat
        public void onAnimationEnd(ValueAnimatorCompat valueAnimatorCompat) {
            if (!this.vz) {
                this.SQ.setIsRecyclable(true);
            }
            this.vz = true;
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
