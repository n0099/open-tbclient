package com.baidu.adp.widget.refresh;

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
import com.baidu.adp.R;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.refresh.IRefreshable;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
/* loaded from: classes.dex */
public class RefresherView extends ViewGroup implements IRefreshable {
    private final a Ar;
    private final b As;
    private IRefreshable.a At;
    private c Au;
    private com.baidu.adp.widget.e Av;
    private IRefreshable.State Aw;
    private final int kMinVelocity;
    private final int kVelocity;
    private int mAbsX;
    private int mAbsY;
    private int mBackPosition;
    private final int[] mContentLocation;
    private View mEmptyView;
    private final int mEmptyViewId;
    private boolean mEnable;
    private int mLastDownX;
    private int mLastDownY;
    private int mMaxHeight;
    private View mRefresherContent;
    private final int mRefresherContentId;
    private View mRefresherHeader;
    private final int mRefresherHeaderId;
    private boolean mRefreshing;
    private final int[] mTempLocation;
    private int mThresholdHeight;
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
        this.Aw = IRefreshable.State.idle;
        this.Ar = new a();
        this.As = new b();
        float f = getResources().getDisplayMetrics().density;
        this.kMinVelocity = (int) ((100.0f * f) + 0.5f);
        this.kVelocity = (int) ((500.0f * f) + 0.5f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RefresherView);
        this.mThresholdHeight = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_threshold_height, -1);
        if (this.mThresholdHeight == -1) {
            this.mThresholdHeight = (int) ((200.0f * f) + 0.5f);
        }
        this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_max_height, -1);
        if (this.mMaxHeight == -1) {
            this.mMaxHeight = (int) ((f * 400.0f) + 0.5f);
        }
        String string = obtainStyledAttributes.getString(R.styleable.RefresherView_direction);
        if (string == null) {
            this.Av = new e();
        } else if (string.equals("side")) {
            this.Av = new d();
        } else if (string.equals(VerticalTranslateLayout.TOP)) {
            this.Av = new e();
        }
        this.mRefresherContentId = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_content, -1);
        this.mRefresherHeaderId = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_head, -1);
        this.mEmptyViewId = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_empty_view, -1);
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
        this.Av.measure(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.Av.layout(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.Av.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.Av.interceptionTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.Av.touchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.Av.draw(canvas);
    }

    public void setOnRefreshListener(IRefreshable.a aVar) {
        this.At = aVar;
    }

    public void setEnable(boolean z) {
        this.mEnable = (!z || this.mRefresherContent == null || this.mRefresherHeader == null) ? false : true;
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.mEnable;
    }

    public IRefreshable.State getState() {
        return this.Aw;
    }

    public void refresh() {
        if (this.Au == null || this.Au.getStatus() != BdAsyncTask.BdAsyncTaskStatus.RUNNING) {
            this.Au = new c();
            this.Au.execute(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private boolean animating;
        private int animatingPosition;
        private int animatingVelocity;
        private int animationDistance;
        private long currentAnimatingTime;
        private long lastAnimationTime;

        private a() {
        }

        void computeBack() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.animatingPosition = (int) (((((float) (uptimeMillis - this.lastAnimationTime)) / 1000.0f) * this.animatingVelocity) + this.animatingPosition);
            if (this.animatingPosition >= this.animationDistance) {
                RefresherView.this.mYOffset = RefresherView.this.mBackPosition;
                this.animating = false;
                RefresherView.this.Aw = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.At;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                }
                if (RefresherView.this.mBackPosition == 0 && aVar != null) {
                    aVar.onRefreshUI();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mYOffset = (int) (RefresherView.this.mBackPosition + (this.animationDistance * (1.0f - com.baidu.adp.widget.a.sInterpolator.getInterpolation(this.animatingPosition / this.animationDistance))));
                this.lastAnimationTime = uptimeMillis;
                this.currentAnimatingTime = uptimeMillis + 16;
                RefresherView.this.As.removeMessages(1000);
                RefresherView.this.As.sendEmptyMessageAtTime(1000, this.currentAnimatingTime);
            }
            RefresherView.this.invalidate();
        }

        void computeDown() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.animatingPosition = (int) (((((float) (uptimeMillis - this.lastAnimationTime)) / 1000.0f) * this.animatingVelocity) + this.animatingPosition);
            if (this.animatingPosition >= this.animationDistance) {
                RefresherView.this.mYOffset = RefresherView.this.mThresholdHeight;
                this.animating = false;
                RefresherView.this.Aw = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.At;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mYOffset = com.baidu.adp.widget.a.computeInterpolator(this.animationDistance, this.animatingPosition, false);
                this.lastAnimationTime = uptimeMillis;
                this.currentAnimatingTime = uptimeMillis + 16;
                RefresherView.this.As.removeMessages(1001);
                RefresherView.this.As.sendEmptyMessageAtTime(1001, this.currentAnimatingTime);
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
                    RefresherView.this.As.removeMessages(1000);
                    RefresherView.this.As.sendEmptyMessageAtTime(1000, this.currentAnimatingTime);
                    break;
                case 1001:
                    this.animationDistance = RefresherView.this.mThresholdHeight;
                    this.animatingPosition = 0;
                    this.animatingVelocity = RefresherView.this.kVelocity;
                    RefresherView.this.As.removeMessages(1001);
                    RefresherView.this.As.sendEmptyMessageAtTime(1001, this.currentAnimatingTime);
                    break;
            }
            RefresherView.this.Aw = IRefreshable.State.animating;
            IRefreshable.a aVar = RefresherView.this.At;
            if (aVar != null) {
                aVar.a(IRefreshable.State.animating);
            }
        }
    }

    public View getRefresherContent() {
        return this.mRefresherContent;
    }

    public View getRefresherHeader() {
        return this.mRefresherHeader;
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

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

    public void setEmptyView(View view) {
        removeView(this.mEmptyView);
        this.mEmptyView = view;
        if (this.mEmptyView != null) {
            addView(this.mEmptyView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1000) {
                RefresherView.this.Ar.computeBack();
            } else if (message.what == 1001) {
                RefresherView.this.Ar.computeDown();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {
        private final IRefreshable.a Ay;

        c() {
            this.Ay = RefresherView.this.At;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (this.Ay != null) {
                RefresherView.this.mBackPosition = RefresherView.this.mThresholdHeight;
                this.Ay.onPreRefresh();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            RefresherView.this.mRefreshing = true;
            if (this.Ay != null) {
                this.Ay.onRefreshData();
                return null;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r3) {
            RefresherView.this.mBackPosition = 0;
            RefresherView.this.Av.animate(1000);
        }
    }

    /* loaded from: classes.dex */
    private class e implements com.baidu.adp.widget.e {
        private e() {
        }

        @Override // com.baidu.adp.widget.f
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

        @Override // com.baidu.adp.widget.e
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

        @Override // com.baidu.adp.widget.f
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

        @Override // com.baidu.adp.widget.f
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (!RefresherView.super.dispatchTouchEvent(motionEvent)) {
            }
            return true;
        }

        @Override // com.baidu.adp.widget.f
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
                    RefresherView.this.As.removeMessages(1000);
                    break;
                case 2:
                    if (!(RefresherView.this.mRefresherContent instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.mRefresherContent).getChildAt(0)) == null) {
                        RefresherView.this.mRefresherContent.getLocationOnScreen(RefresherView.this.mContentLocation);
                        if (RefresherView.this.mContentLocation[1] == RefresherView.this.mAbsY && y > RefresherView.this.mLastDownY) {
                            RefresherView.this.Aw = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.At;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.mContentLocation);
                        if (RefresherView.this.mContentLocation[1] == RefresherView.this.mAbsY && y > RefresherView.this.mLastDownY) {
                            RefresherView.this.Aw = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar2 = RefresherView.this.At;
                            if (aVar2 != null) {
                                aVar2.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    }
                    break;
            }
            return false;
        }

        @Override // com.baidu.adp.widget.f
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
                    if (RefresherView.this.mYOffset <= RefresherView.this.mThresholdHeight || RefresherView.this.Aw != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mYOffset < RefresherView.this.mThresholdHeight && RefresherView.this.Aw == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.Aw = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.At;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.Aw = IRefreshable.State.pulling_refresh;
                        IRefreshable.a aVar2 = RefresherView.this.At;
                        if (aVar2 != null) {
                            aVar2.a(IRefreshable.State.pulling_refresh);
                        }
                    }
                    RefresherView.this.invalidate();
                    return true;
                default:
                    return true;
            }
        }

        @Override // com.baidu.adp.widget.f
        public void animate(int i) {
            RefresherView.this.Ar.animate(i);
        }
    }

    /* loaded from: classes.dex */
    private class d extends Handler implements com.baidu.adp.widget.e {
        private boolean animating;
        private float animatingPosition;
        private int animatingVelocity;
        private float animationDistance;
        private long currentAnimatingTime;
        private long lastAnimationTime;
        private final int moveThreshold;

        public d() {
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

        @Override // com.baidu.adp.widget.f
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

        @Override // com.baidu.adp.widget.e
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

        @Override // com.baidu.adp.widget.f
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

        @Override // com.baidu.adp.widget.f
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (!RefresherView.super.dispatchTouchEvent(motionEvent)) {
            }
            return true;
        }

        @Override // com.baidu.adp.widget.f
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
                            RefresherView.this.Aw = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.At;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.mContentLocation);
                        if (RefresherView.this.mContentLocation[0] == RefresherView.this.mAbsX && x > RefresherView.this.mLastDownX + this.moveThreshold) {
                            RefresherView.this.Aw = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar2 = RefresherView.this.At;
                            if (aVar2 != null) {
                                aVar2.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    }
                    break;
            }
            return false;
        }

        @Override // com.baidu.adp.widget.f
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
                    if (RefresherView.this.mXOffset <= RefresherView.this.mThresholdHeight || RefresherView.this.Aw != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mXOffset < RefresherView.this.mThresholdHeight && RefresherView.this.Aw == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.Aw = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.At;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.Aw = IRefreshable.State.pulling_refresh;
                        IRefreshable.a aVar2 = RefresherView.this.At;
                        if (aVar2 != null) {
                            aVar2.a(IRefreshable.State.pulling_refresh);
                        }
                    }
                    RefresherView.this.invalidate();
                    return true;
                default:
                    return true;
            }
        }

        @Override // com.baidu.adp.widget.f
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
                RefresherView.this.Aw = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.At;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mXOffset = com.baidu.adp.widget.a.computeInterpolator(this.animationDistance, this.animatingPosition, false);
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
                RefresherView.this.Aw = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.At;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                }
                if (RefresherView.this.mBackPosition == 0 && aVar != null) {
                    aVar.onRefreshUI();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mXOffset = (int) (RefresherView.this.mBackPosition + (this.animationDistance * (1.0f - com.baidu.adp.widget.a.sInterpolator.getInterpolation(this.animatingPosition / this.animationDistance))));
                this.lastAnimationTime = uptimeMillis;
                this.currentAnimatingTime = uptimeMillis + 16;
                removeMessages(1000);
                sendEmptyMessageAtTime(1000, this.currentAnimatingTime);
            }
            RefresherView.this.invalidate();
        }
    }
}
