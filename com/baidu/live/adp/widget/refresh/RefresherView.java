package com.baidu.live.adp.widget.refresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.R;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.widget.AnimationConfig;
import com.baidu.live.adp.widget.ViewGroupInjector;
import com.baidu.live.adp.widget.refresh.IRefreshable;
/* loaded from: classes2.dex */
public class RefresherView extends ViewGroup implements IRefreshable {
    private static final int DEFAULT_MAX_HEIGHT = 400;
    private static final int DEFAULT_THRESHOLD_HEIGHT = 200;
    private static final String DIRECTION_SIDE = "side";
    private static final String DIRECTION_TOP = "top";
    private static final int MIN_VELOCITY = 100;
    private static final int MSG_ANIMATE_BACK = 1000;
    private static final int MSG_ANIMATE_DOWN = 1001;
    private final int kMinVelocity;
    private final int kVelocity;
    private int mAbsX;
    private int mAbsY;
    private final Animator mAnimator;
    private int mBackPosition;
    private final int[] mContentLocation;
    private View mEmptyView;
    private final int mEmptyViewId;
    private boolean mEnable;
    private final AnimatorHandler mHandler;
    private int mLastDownX;
    private int mLastDownY;
    private int mMaxHeight;
    private IRefreshable.OnRefreshListener mOnRefreshListener;
    private RefreshAsyncTask mRefreshAsyncTask;
    private View mRefresherContent;
    private final int mRefresherContentId;
    private View mRefresherHeader;
    private final int mRefresherHeaderId;
    private boolean mRefreshing;
    private IRefreshable.State mState;
    private final int[] mTempLocation;
    private int mThresholdHeight;
    private ViewGroupInjector mViewGroupInjector;
    private int mXOffset;
    private int mYOffset;

    public RefresherView(Context context) {
        this(context, null, 0);
    }

    public RefresherView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RefresherView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mEnable = true;
        this.mContentLocation = new int[2];
        this.mTempLocation = new int[2];
        this.mState = IRefreshable.State.idle;
        this.mAnimator = new Animator();
        this.mHandler = new AnimatorHandler();
        float f = getResources().getDisplayMetrics().density;
        this.kMinVelocity = (int) ((100.0f * f) + 0.5f);
        this.kVelocity = (int) ((500.0f * f) + 0.5f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.sdk_RefresherView);
        this.mThresholdHeight = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.sdk_RefresherView_threshold_height, -1);
        if (this.mThresholdHeight == -1) {
            this.mThresholdHeight = (int) ((200.0f * f) + 0.5f);
        }
        this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.sdk_RefresherView_max_height, -1);
        if (this.mMaxHeight == -1) {
            this.mMaxHeight = (int) ((f * 400.0f) + 0.5f);
        }
        String string = obtainStyledAttributes.getString(R.styleable.sdk_RefresherView_direction);
        if (string == null) {
            this.mViewGroupInjector = new TopRefreshViewGroupInjector();
        } else if (string.equals(DIRECTION_SIDE)) {
            this.mViewGroupInjector = new SideRefreshViewGroupInjector();
        } else if (string.equals("top")) {
            this.mViewGroupInjector = new TopRefreshViewGroupInjector();
        }
        this.mRefresherContentId = obtainStyledAttributes.getResourceId(R.styleable.sdk_RefresherView_refresher_content, -1);
        this.mRefresherHeaderId = obtainStyledAttributes.getResourceId(R.styleable.sdk_RefresherView_refresher_head, -1);
        this.mEmptyViewId = obtainStyledAttributes.getResourceId(R.styleable.sdk_RefresherView_empty_view, -1);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        if (this.mRefresherContentId == -1) {
            throw new RuntimeException("refresher content id is not set in xml, or call setRefresherContent before add it to a view tree.");
        }
        this.mRefresherContent = findViewById(this.mRefresherContentId);
        if (this.mRefresherContent == null) {
            throw new RuntimeException("refresher content not found in the view tree by the content id.");
        }
        if (this.mRefresherHeaderId == -1) {
            throw new RuntimeException("refresher head id is not set in xml, or call setRefresherHeader before add it to a view tree.");
        }
        this.mRefresherHeader = findViewById(this.mRefresherHeaderId);
        if (this.mRefresherHeader == null) {
            throw new RuntimeException("refresher header not found in the view tree by the header id.");
        }
        if (this.mEmptyViewId == -1) {
            throw new RuntimeException("empty view id is not set in xml, or call setEmptyView before add it to a view tree");
        }
        this.mEmptyView = findViewById(this.mEmptyViewId);
        if (this.mEmptyView == null) {
            throw new RuntimeException("empty view not found in the view tree by the empty view's id");
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.mViewGroupInjector.measure(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mViewGroupInjector.layout(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.mViewGroupInjector.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.mViewGroupInjector.interceptionTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mViewGroupInjector.touchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.mViewGroupInjector.draw(canvas);
    }

    @Override // com.baidu.live.adp.widget.refresh.IRefreshable
    public void setOnRefreshListener(IRefreshable.OnRefreshListener onRefreshListener) {
        this.mOnRefreshListener = onRefreshListener;
    }

    @Override // com.baidu.live.adp.widget.refresh.IRefreshable
    public void setEnable(boolean z) {
        this.mEnable = (!z || this.mRefresherContent == null || this.mRefresherHeader == null) ? false : true;
    }

    @Override // android.view.View, com.baidu.live.adp.widget.refresh.IRefreshable
    public boolean isEnabled() {
        return this.mEnable;
    }

    @Override // com.baidu.live.adp.widget.refresh.IRefreshable
    public IRefreshable.State getState() {
        return this.mState;
    }

    @Override // com.baidu.live.adp.widget.refresh.IRefreshable
    public void refresh() {
        if (this.mRefreshAsyncTask == null || this.mRefreshAsyncTask.getStatus() != BdAsyncTask.BdAsyncTaskStatus.RUNNING) {
            this.mRefreshAsyncTask = new RefreshAsyncTask();
            this.mRefreshAsyncTask.execute(null);
        }
    }

    @Override // com.baidu.live.adp.widget.refresh.IRefreshable
    public void refreshShowingHeader() {
        if (!this.mRefreshing) {
            this.mViewGroupInjector.animate(1001);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class Animator {
        private boolean animating;
        private int animatingPosition;
        private int animatingVelocity;
        private int animationDistance;
        private long currentAnimatingTime;
        private long lastAnimationTime;

        private Animator() {
        }

        void computeBack() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.animatingPosition = (int) (((((float) (uptimeMillis - this.lastAnimationTime)) / 1000.0f) * this.animatingVelocity) + this.animatingPosition);
            if (this.animatingPosition >= this.animationDistance) {
                RefresherView.this.mYOffset = RefresherView.this.mBackPosition;
                this.animating = false;
                RefresherView.this.mState = IRefreshable.State.idle;
                IRefreshable.OnRefreshListener onRefreshListener = RefresherView.this.mOnRefreshListener;
                if (onRefreshListener != null) {
                    onRefreshListener.onStateChanged(IRefreshable.State.idle);
                }
                if (RefresherView.this.mBackPosition == 0 && onRefreshListener != null) {
                    onRefreshListener.onRefreshUI();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mYOffset = (int) (RefresherView.this.mBackPosition + (this.animationDistance * (1.0f - AnimationConfig.sInterpolator.getInterpolation(this.animatingPosition / this.animationDistance))));
                this.lastAnimationTime = uptimeMillis;
                this.currentAnimatingTime = uptimeMillis + 16;
                RefresherView.this.mHandler.removeMessages(1000);
                RefresherView.this.mHandler.sendEmptyMessageAtTime(1000, this.currentAnimatingTime);
            }
            RefresherView.this.invalidate();
        }

        void computeDown() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.animatingPosition = (int) (((((float) (uptimeMillis - this.lastAnimationTime)) / 1000.0f) * this.animatingVelocity) + this.animatingPosition);
            if (this.animatingPosition >= this.animationDistance) {
                RefresherView.this.mYOffset = RefresherView.this.mThresholdHeight;
                this.animating = false;
                RefresherView.this.mState = IRefreshable.State.idle;
                IRefreshable.OnRefreshListener onRefreshListener = RefresherView.this.mOnRefreshListener;
                if (onRefreshListener != null) {
                    onRefreshListener.onStateChanged(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mYOffset = AnimationConfig.computeInterpolator(this.animationDistance, this.animatingPosition, false);
                this.lastAnimationTime = uptimeMillis;
                this.currentAnimatingTime = uptimeMillis + 16;
                RefresherView.this.mHandler.removeMessages(1001);
                RefresherView.this.mHandler.sendEmptyMessageAtTime(1001, this.currentAnimatingTime);
            }
            RefresherView.this.invalidate();
        }

        void animate(int i) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.lastAnimationTime = uptimeMillis;
            this.currentAnimatingTime = uptimeMillis + 16;
            this.animating = true;
            switch (i) {
                case 1000:
                    this.animationDistance = RefresherView.this.mYOffset - RefresherView.this.mBackPosition;
                    this.animatingPosition = 0;
                    this.animatingVelocity = Math.max(RefresherView.this.kMinVelocity, (RefresherView.this.mYOffset - RefresherView.this.mBackPosition) * 2);
                    RefresherView.this.mHandler.removeMessages(1000);
                    RefresherView.this.mHandler.sendEmptyMessageAtTime(1000, this.currentAnimatingTime);
                    break;
                case 1001:
                    this.animationDistance = RefresherView.this.mThresholdHeight;
                    this.animatingPosition = 0;
                    this.animatingVelocity = RefresherView.this.kVelocity;
                    RefresherView.this.mHandler.removeMessages(1001);
                    RefresherView.this.mHandler.sendEmptyMessageAtTime(1001, this.currentAnimatingTime);
                    break;
            }
            RefresherView.this.mState = IRefreshable.State.animating;
            IRefreshable.OnRefreshListener onRefreshListener = RefresherView.this.mOnRefreshListener;
            if (onRefreshListener != null) {
                onRefreshListener.onStateChanged(IRefreshable.State.animating);
            }
        }
    }

    @Override // com.baidu.live.adp.widget.refresh.IRefreshable
    public View getRefresherContent() {
        return this.mRefresherContent;
    }

    @Override // com.baidu.live.adp.widget.refresh.IRefreshable
    public View getRefresherHeader() {
        return this.mRefresherHeader;
    }

    @Override // com.baidu.live.adp.widget.refresh.IRefreshable
    public View getEmptyView() {
        return this.mEmptyView;
    }

    @Override // com.baidu.live.adp.widget.refresh.IRefreshable
    public void setRefresherContent(ViewGroup viewGroup) {
        boolean z = false;
        removeView(this.mRefresherContent);
        this.mRefresherContent = viewGroup;
        if (this.mRefresherContent == null) {
            this.mEnable = false;
            return;
        }
        addView(this.mRefresherContent);
        if (this.mRefresherHeader != null && this.mRefresherContent != null) {
            z = true;
        }
        this.mEnable = z;
    }

    @Override // com.baidu.live.adp.widget.refresh.IRefreshable
    public void setRefresherHeader(View view) {
        boolean z = false;
        removeView(this.mRefresherHeader);
        this.mRefresherHeader = view;
        if (this.mRefresherHeader == null) {
            this.mEnable = false;
            return;
        }
        addView(this.mRefresherHeader);
        if (this.mRefresherHeader != null && this.mRefresherContent != null) {
            z = true;
        }
        this.mEnable = z;
    }

    @Override // com.baidu.live.adp.widget.refresh.IRefreshable
    public void setEmptyView(View view) {
        removeView(this.mEmptyView);
        this.mEmptyView = view;
        if (this.mEmptyView != null) {
            addView(this.mEmptyView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class AnimatorHandler extends Handler {
        private AnimatorHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1000) {
                RefresherView.this.mAnimator.computeBack();
            } else if (message.what == 1001) {
                RefresherView.this.mAnimator.computeDown();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class RefreshAsyncTask extends BdAsyncTask<Void, Void, Void> {
        private final IRefreshable.OnRefreshListener mListener;

        RefreshAsyncTask() {
            this.mListener = RefresherView.this.mOnRefreshListener;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPreExecute() {
            if (this.mListener != null) {
                RefresherView.this.mBackPosition = RefresherView.this.mThresholdHeight;
                this.mListener.onPreRefresh();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            RefresherView.this.mRefreshing = true;
            if (this.mListener != null) {
                this.mListener.onRefreshData();
                return null;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPostExecute(Void r3) {
            RefresherView.this.mBackPosition = 0;
            RefresherView.this.mViewGroupInjector.animate(1000);
        }
    }

    /* loaded from: classes2.dex */
    private class TopRefreshViewGroupInjector implements ViewGroupInjector {
        private TopRefreshViewGroupInjector() {
        }

        @Override // com.baidu.live.adp.widget.ViewInjector
        public void measure(int i, int i2) {
            int i3 = i & 1073741823;
            int i4 = 1073741823 & i2;
            if (RefresherView.this.mRefresherContent != null) {
                RefresherView.this.measureChild(RefresherView.this.mRefresherContent, i3 + 1073741824, i4 + 1073741824);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.measureChild(RefresherView.this.mEmptyView, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.mRefresherHeader != null) {
                RefresherView.this.measureChild(RefresherView.this.mRefresherHeader, i3 + 1073741824, i4 - 2147483648);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // com.baidu.live.adp.widget.ViewGroupInjector
        public void layout(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.mRefresherContent != null) {
                RefresherView.this.mRefresherContent.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.mEmptyView.layout((i5 - RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (i6 - RefresherView.this.mEmptyView.getMeasuredHeight()) / 2, (RefresherView.this.mEmptyView.getMeasuredWidth() + i5) / 2, (i6 + RefresherView.this.mEmptyView.getMeasuredHeight()) / 2);
            }
            if (RefresherView.this.mRefresherHeader != null) {
                RefresherView.this.mRefresherHeader.layout(0, -RefresherView.this.mRefresherHeader.getMeasuredHeight(), i5, 0);
            }
            RefresherView.this.getLocationOnScreen(RefresherView.this.mTempLocation);
            RefresherView.this.mAbsY = RefresherView.this.mTempLocation[1];
        }

        @Override // com.baidu.live.adp.widget.ViewInjector
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mEmptyView, drawingTime);
            }
            canvas.save();
            canvas.translate(0.0f, RefresherView.this.mYOffset / 2);
            RefresherView.this.drawChild(canvas, RefresherView.this.mRefresherContent, drawingTime);
            if (RefresherView.this.mYOffset > 0) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mRefresherHeader, drawingTime);
            }
            canvas.restore();
        }

        @Override // com.baidu.live.adp.widget.ViewInjector
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (!RefresherView.super.dispatchTouchEvent(motionEvent)) {
            }
            return true;
        }

        @Override // com.baidu.live.adp.widget.ViewInjector
        public boolean interceptionTouchEvent(MotionEvent motionEvent) {
            View childAt;
            if (!RefresherView.this.mEnable || RefresherView.this.mRefreshing) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int y = (int) motionEvent.getY();
            switch (action) {
                case 0:
                    RefresherView.this.mLastDownY = y;
                    RefresherView.this.mHandler.removeMessages(1000);
                    break;
                case 2:
                    if (!(RefresherView.this.mRefresherContent instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.mRefresherContent).getChildAt(0)) == null) {
                        RefresherView.this.mRefresherContent.getLocationOnScreen(RefresherView.this.mContentLocation);
                        if (RefresherView.this.mContentLocation[1] == RefresherView.this.mAbsY && y > RefresherView.this.mLastDownY) {
                            RefresherView.this.mState = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.OnRefreshListener onRefreshListener = RefresherView.this.mOnRefreshListener;
                            if (onRefreshListener != null) {
                                onRefreshListener.onStateChanged(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.mContentLocation);
                        if (RefresherView.this.mContentLocation[1] == RefresherView.this.mAbsY && y > RefresherView.this.mLastDownY) {
                            RefresherView.this.mState = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.OnRefreshListener onRefreshListener2 = RefresherView.this.mOnRefreshListener;
                            if (onRefreshListener2 != null) {
                                onRefreshListener2.onStateChanged(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    }
                    break;
            }
            return false;
        }

        @Override // com.baidu.live.adp.widget.ViewInjector
        public boolean touchEvent(MotionEvent motionEvent) {
            int action = motionEvent.getAction() & 255;
            int y = (int) motionEvent.getY();
            switch (action) {
                case 1:
                case 3:
                    if (RefresherView.this.mYOffset <= RefresherView.this.mThresholdHeight) {
                        RefresherView.this.mBackPosition = 0;
                    } else {
                        RefresherView.this.refresh();
                    }
                    animate(1000);
                    return true;
                case 2:
                    RefresherView.this.mYOffset = Math.max(0, Math.min(y - RefresherView.this.mLastDownY, RefresherView.this.mMaxHeight * 2));
                    if (RefresherView.this.mYOffset <= RefresherView.this.mThresholdHeight || RefresherView.this.mState != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mYOffset < RefresherView.this.mThresholdHeight && RefresherView.this.mState == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.mState = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.OnRefreshListener onRefreshListener = RefresherView.this.mOnRefreshListener;
                            if (onRefreshListener != null) {
                                onRefreshListener.onStateChanged(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.mState = IRefreshable.State.pulling_refresh;
                        IRefreshable.OnRefreshListener onRefreshListener2 = RefresherView.this.mOnRefreshListener;
                        if (onRefreshListener2 != null) {
                            onRefreshListener2.onStateChanged(IRefreshable.State.pulling_refresh);
                        }
                    }
                    RefresherView.this.invalidate();
                    return true;
                default:
                    return true;
            }
        }

        @Override // com.baidu.live.adp.widget.ViewInjector
        public void animate(int i) {
            RefresherView.this.mAnimator.animate(i);
        }

        @Override // com.baidu.live.adp.widget.ViewInjector
        public boolean isAnimating() {
            return RefresherView.this.mAnimator.animating;
        }
    }

    /* loaded from: classes2.dex */
    private class SideRefreshViewGroupInjector extends Handler implements ViewGroupInjector {
        private boolean animating;
        private float animatingPosition;
        private int animatingVelocity;
        private float animationDistance;
        private long currentAnimatingTime;
        private long lastAnimationTime;
        private final int moveThreshold;

        public SideRefreshViewGroupInjector() {
            this.moveThreshold = (int) ((RefresherView.this.getResources().getDisplayMetrics().density * 75.0f) + 0.5d);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1000:
                    computeBack();
                    return;
                case 1001:
                    computeDown();
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.live.adp.widget.ViewInjector
        public void measure(int i, int i2) {
            int i3 = i & 1073741823;
            int i4 = 1073741823 & i2;
            if (RefresherView.this.mRefresherContent != null) {
                RefresherView.this.measureChild(RefresherView.this.mRefresherContent, i3 + 1073741824, i4 + 1073741824);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.measureChild(RefresherView.this.mEmptyView, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.mRefresherHeader != null) {
                RefresherView.this.measureChild(RefresherView.this.mRefresherHeader, i3 - 2147483648, i4 + 1073741824);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // com.baidu.live.adp.widget.ViewGroupInjector
        public void layout(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.mRefresherContent != null) {
                RefresherView.this.mRefresherContent.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.mEmptyView.layout((i5 - RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (i6 - RefresherView.this.mEmptyView.getMeasuredHeight()) / 2, (i5 + RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (RefresherView.this.mEmptyView.getMeasuredHeight() + i6) / 2);
            }
            if (RefresherView.this.mRefresherHeader != null) {
                RefresherView.this.mRefresherHeader.layout(-RefresherView.this.mRefresherHeader.getMeasuredWidth(), 0, 0, i6);
            }
            RefresherView.this.getLocationOnScreen(RefresherView.this.mTempLocation);
            RefresherView.this.mAbsX = RefresherView.this.mTempLocation[0];
        }

        @Override // com.baidu.live.adp.widget.ViewInjector
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mEmptyView, drawingTime);
            }
            canvas.save();
            canvas.translate(RefresherView.this.mXOffset >> 1, 0.0f);
            RefresherView.this.drawChild(canvas, RefresherView.this.mRefresherContent, drawingTime);
            if (RefresherView.this.mXOffset > 0) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mRefresherHeader, drawingTime);
            }
            canvas.restore();
        }

        @Override // com.baidu.live.adp.widget.ViewInjector
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (!RefresherView.super.dispatchTouchEvent(motionEvent)) {
            }
            return true;
        }

        @Override // com.baidu.live.adp.widget.ViewInjector
        public boolean interceptionTouchEvent(MotionEvent motionEvent) {
            View childAt;
            if (!RefresherView.this.mEnable || RefresherView.this.mRefreshing) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            switch (action) {
                case 0:
                    RefresherView.this.mLastDownX = x;
                    removeMessages(1000);
                    removeMessages(1001);
                    break;
                case 2:
                    if (!(RefresherView.this.mRefresherContent instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.mRefresherContent).getChildAt(0)) == null) {
                        RefresherView.this.mRefresherContent.getLocationOnScreen(RefresherView.this.mContentLocation);
                        if (RefresherView.this.mContentLocation[0] == RefresherView.this.mAbsX && x > RefresherView.this.mLastDownX + this.moveThreshold) {
                            RefresherView.this.mState = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.OnRefreshListener onRefreshListener = RefresherView.this.mOnRefreshListener;
                            if (onRefreshListener != null) {
                                onRefreshListener.onStateChanged(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.mContentLocation);
                        if (RefresherView.this.mContentLocation[0] == RefresherView.this.mAbsX && x > RefresherView.this.mLastDownX + this.moveThreshold) {
                            RefresherView.this.mState = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.OnRefreshListener onRefreshListener2 = RefresherView.this.mOnRefreshListener;
                            if (onRefreshListener2 != null) {
                                onRefreshListener2.onStateChanged(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    }
                    break;
            }
            return false;
        }

        @Override // com.baidu.live.adp.widget.ViewInjector
        public boolean touchEvent(MotionEvent motionEvent) {
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            switch (action) {
                case 1:
                case 3:
                    if (RefresherView.this.mXOffset <= RefresherView.this.mThresholdHeight) {
                        RefresherView.this.mBackPosition = 0;
                    } else {
                        RefresherView.this.refresh();
                    }
                    animate(1000);
                    return true;
                case 2:
                    RefresherView.this.mXOffset = Math.max(0, Math.min((x - RefresherView.this.mLastDownX) - this.moveThreshold, RefresherView.this.mMaxHeight * 2));
                    if (RefresherView.this.mXOffset <= RefresherView.this.mThresholdHeight || RefresherView.this.mState != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mXOffset < RefresherView.this.mThresholdHeight && RefresherView.this.mState == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.mState = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.OnRefreshListener onRefreshListener = RefresherView.this.mOnRefreshListener;
                            if (onRefreshListener != null) {
                                onRefreshListener.onStateChanged(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.mState = IRefreshable.State.pulling_refresh;
                        IRefreshable.OnRefreshListener onRefreshListener2 = RefresherView.this.mOnRefreshListener;
                        if (onRefreshListener2 != null) {
                            onRefreshListener2.onStateChanged(IRefreshable.State.pulling_refresh);
                        }
                    }
                    RefresherView.this.invalidate();
                    return true;
                default:
                    return true;
            }
        }

        @Override // com.baidu.live.adp.widget.ViewInjector
        public void animate(int i) {
            switch (i) {
                case 1000:
                    animateBack();
                    return;
                case 1001:
                    animateDown();
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.live.adp.widget.ViewInjector
        public boolean isAnimating() {
            return this.animating;
        }

        private void animateDown() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.lastAnimationTime = uptimeMillis;
            this.currentAnimatingTime = uptimeMillis + 16;
            this.animating = true;
            this.animationDistance = RefresherView.this.mThresholdHeight;
            this.animatingPosition = 0.0f;
            this.animatingVelocity = RefresherView.this.kVelocity;
            removeMessages(1001);
            sendEmptyMessageAtTime(1001, this.currentAnimatingTime);
        }

        private void animateBack() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.lastAnimationTime = uptimeMillis;
            this.currentAnimatingTime = uptimeMillis + 16;
            this.animating = true;
            this.animationDistance = RefresherView.this.mXOffset - RefresherView.this.mBackPosition;
            this.animatingPosition = 0.0f;
            this.animatingVelocity = Math.max(RefresherView.this.kMinVelocity, (RefresherView.this.mXOffset - RefresherView.this.mBackPosition) * 2);
            removeMessages(1000);
            sendEmptyMessageAtTime(1000, this.currentAnimatingTime);
        }

        private void computeDown() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.animatingPosition = ((((float) (uptimeMillis - this.lastAnimationTime)) / 1000.0f) * this.animatingVelocity) + this.animatingPosition;
            if (this.animatingPosition >= this.animationDistance) {
                RefresherView.this.mXOffset = RefresherView.this.mThresholdHeight;
                this.animating = false;
                RefresherView.this.mState = IRefreshable.State.idle;
                IRefreshable.OnRefreshListener onRefreshListener = RefresherView.this.mOnRefreshListener;
                if (onRefreshListener != null) {
                    onRefreshListener.onStateChanged(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mXOffset = AnimationConfig.computeInterpolator(this.animationDistance, this.animatingPosition, false);
                this.lastAnimationTime = uptimeMillis;
                this.currentAnimatingTime = uptimeMillis + 16;
                removeMessages(1001);
                sendEmptyMessageAtTime(1001, this.currentAnimatingTime);
            }
            RefresherView.this.invalidate();
        }

        private void computeBack() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.animatingPosition = ((((float) (uptimeMillis - this.lastAnimationTime)) / 1000.0f) * this.animatingVelocity) + this.animatingPosition;
            if (this.animatingPosition >= this.animationDistance) {
                RefresherView.this.mXOffset = RefresherView.this.mBackPosition;
                this.animating = false;
                RefresherView.this.mState = IRefreshable.State.idle;
                IRefreshable.OnRefreshListener onRefreshListener = RefresherView.this.mOnRefreshListener;
                if (onRefreshListener != null) {
                    onRefreshListener.onStateChanged(IRefreshable.State.idle);
                }
                if (RefresherView.this.mBackPosition == 0 && onRefreshListener != null) {
                    onRefreshListener.onRefreshUI();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mXOffset = (int) (RefresherView.this.mBackPosition + (this.animationDistance * (1.0f - AnimationConfig.sInterpolator.getInterpolation(this.animatingPosition / this.animationDistance))));
                this.lastAnimationTime = uptimeMillis;
                this.currentAnimatingTime = uptimeMillis + 16;
                removeMessages(1000);
                sendEmptyMessageAtTime(1000, this.currentAnimatingTime);
            }
            RefresherView.this.invalidate();
        }
    }
}
