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
/* loaded from: classes.dex */
public class RefresherView extends ViewGroup implements IRefreshable {
    private int Mv;
    private int Mw;
    private final int NB;
    private boolean Og;
    private final int QT;
    private int QU;
    private final int QV;
    private final int QW;
    private final int QX;
    private View QY;
    private View QZ;
    private final int[] Ra;
    private int Rb;
    private int Rc;
    private int Rd;
    private final a Re;
    private final b Rf;
    private IRefreshable.a Rg;
    private c Rh;
    private com.baidu.adp.widget.e Ri;
    private IRefreshable.State Rj;
    private View mEmptyView;
    private int mMaxHeight;
    private boolean mRefreshing;
    private final int[] mTempLocation;
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
        this.Og = true;
        this.Ra = new int[2];
        this.mTempLocation = new int[2];
        this.Rj = IRefreshable.State.idle;
        this.Re = new a();
        this.Rf = new b();
        float f = getResources().getDisplayMetrics().density;
        this.QT = (int) ((100.0f * f) + 0.5f);
        this.NB = (int) ((500.0f * f) + 0.5f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RefresherView);
        this.QU = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_threshold_height, -1);
        if (this.QU == -1) {
            this.QU = (int) ((200.0f * f) + 0.5f);
        }
        this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_max_height, -1);
        if (this.mMaxHeight == -1) {
            this.mMaxHeight = (int) ((f * 400.0f) + 0.5f);
        }
        String string = obtainStyledAttributes.getString(R.styleable.RefresherView_direction);
        if (string == null) {
            this.Ri = new e();
        } else if (string.equals("side")) {
            this.Ri = new d();
        } else if (string.equals("top")) {
            this.Ri = new e();
        }
        this.QV = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_content, -1);
        this.QW = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_head, -1);
        this.QX = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_empty_view, -1);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        if (this.QV == -1) {
            throw new RuntimeException("refresher content id is not set in xml, or call setRefresherContent before add it to a view tree.");
        }
        this.QY = findViewById(this.QV);
        if (this.QY == null) {
            throw new RuntimeException("refresher content not found in the view tree by the content id.");
        }
        if (this.QW == -1) {
            throw new RuntimeException("refresher head id is not set in xml, or call setRefresherHeader before add it to a view tree.");
        }
        this.QZ = findViewById(this.QW);
        if (this.QZ == null) {
            throw new RuntimeException("refresher header not found in the view tree by the header id.");
        }
        if (this.QX == -1) {
            throw new RuntimeException("empty view id is not set in xml, or call setEmptyView before add it to a view tree");
        }
        this.mEmptyView = findViewById(this.QX);
        if (this.mEmptyView == null) {
            throw new RuntimeException("empty view not found in the view tree by the empty view's id");
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.Ri.measure(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.Ri.a(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.Ri.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.Ri.l(motionEvent);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.Ri.m(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.Ri.draw(canvas);
    }

    public void setOnRefreshListener(IRefreshable.a aVar) {
        this.Rg = aVar;
    }

    public void setEnable(boolean z) {
        this.Og = (!z || this.QY == null || this.QZ == null) ? false : true;
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.Og;
    }

    public IRefreshable.State getState() {
        return this.Rj;
    }

    public void refresh() {
        if (this.Rh == null || this.Rh.getStatus() != BdAsyncTask.BdAsyncTaskStatus.RUNNING) {
            this.Rh = new c();
            this.Rh.execute(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private long NC;
        private long ND;
        private int NE;
        private boolean NG;
        private int Rk;
        private int Rl;

        private a() {
        }

        void pg() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Rk = (int) (((((float) (uptimeMillis - this.NC)) / 1000.0f) * this.NE) + this.Rk);
            if (this.Rk >= this.Rl) {
                RefresherView.this.mYOffset = RefresherView.this.Rd;
                this.NG = false;
                RefresherView.this.Rj = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.Rg;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                }
                if (RefresherView.this.Rd == 0 && aVar != null) {
                    aVar.pf();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mYOffset = (int) (RefresherView.this.Rd + (this.Rl * (1.0f - com.baidu.adp.widget.a.sInterpolator.getInterpolation(this.Rk / this.Rl))));
                this.NC = uptimeMillis;
                this.ND = uptimeMillis + 16;
                RefresherView.this.Rf.removeMessages(1000);
                RefresherView.this.Rf.sendEmptyMessageAtTime(1000, this.ND);
            }
            RefresherView.this.invalidate();
        }

        void ph() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Rk = (int) (((((float) (uptimeMillis - this.NC)) / 1000.0f) * this.NE) + this.Rk);
            if (this.Rk >= this.Rl) {
                RefresherView.this.mYOffset = RefresherView.this.QU;
                this.NG = false;
                RefresherView.this.Rj = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.Rg;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mYOffset = com.baidu.adp.widget.a.a(this.Rl, this.Rk, false);
                this.NC = uptimeMillis;
                this.ND = uptimeMillis + 16;
                RefresherView.this.Rf.removeMessages(1001);
                RefresherView.this.Rf.sendEmptyMessageAtTime(1001, this.ND);
            }
            RefresherView.this.invalidate();
        }

        void aS(int i) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.NC = uptimeMillis;
            this.ND = uptimeMillis + 16;
            this.NG = true;
            switch (i) {
                case 1000:
                    this.Rl = RefresherView.this.mYOffset - RefresherView.this.Rd;
                    this.Rk = 0;
                    this.NE = Math.max(RefresherView.this.QT, (RefresherView.this.mYOffset - RefresherView.this.Rd) * 2);
                    RefresherView.this.Rf.removeMessages(1000);
                    RefresherView.this.Rf.sendEmptyMessageAtTime(1000, this.ND);
                    break;
                case 1001:
                    this.Rl = RefresherView.this.QU;
                    this.Rk = 0;
                    this.NE = RefresherView.this.NB;
                    RefresherView.this.Rf.removeMessages(1001);
                    RefresherView.this.Rf.sendEmptyMessageAtTime(1001, this.ND);
                    break;
            }
            RefresherView.this.Rj = IRefreshable.State.animating;
            IRefreshable.a aVar = RefresherView.this.Rg;
            if (aVar != null) {
                aVar.a(IRefreshable.State.animating);
            }
        }
    }

    public View getRefresherContent() {
        return this.QY;
    }

    public View getRefresherHeader() {
        return this.QZ;
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    public void setRefresherContent(ViewGroup viewGroup) {
        boolean z = false;
        removeView(this.QY);
        this.QY = viewGroup;
        if (this.QY == null) {
            this.Og = false;
            return;
        }
        addView(this.QY);
        if (this.QZ != null && this.QY != null) {
            z = true;
        }
        this.Og = z;
    }

    public void setRefresherHeader(View view) {
        boolean z = false;
        removeView(this.QZ);
        this.QZ = view;
        if (this.QZ == null) {
            this.Og = false;
            return;
        }
        addView(this.QZ);
        if (this.QZ != null && this.QY != null) {
            z = true;
        }
        this.Og = z;
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
                RefresherView.this.Re.pg();
            } else if (message.what == 1001) {
                RefresherView.this.Re.ph();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {
        private final IRefreshable.a Rn;

        c() {
            this.Rn = RefresherView.this.Rg;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (this.Rn != null) {
                RefresherView.this.Rd = RefresherView.this.QU;
                this.Rn.pd();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            RefresherView.this.mRefreshing = true;
            if (this.Rn != null) {
                this.Rn.pe();
                return null;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r3) {
            RefresherView.this.Rd = 0;
            RefresherView.this.Ri.aS(1000);
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
            if (RefresherView.this.QY != null) {
                RefresherView.this.measureChild(RefresherView.this.QY, i3 + 1073741824, i4 + 1073741824);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.measureChild(RefresherView.this.mEmptyView, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.QZ != null) {
                RefresherView.this.measureChild(RefresherView.this.QZ, i3 + 1073741824, i4 - 2147483648);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // com.baidu.adp.widget.e
        public void a(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.QY != null) {
                RefresherView.this.QY.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.mEmptyView.layout((i5 - RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (i6 - RefresherView.this.mEmptyView.getMeasuredHeight()) / 2, (RefresherView.this.mEmptyView.getMeasuredWidth() + i5) / 2, (i6 + RefresherView.this.mEmptyView.getMeasuredHeight()) / 2);
            }
            if (RefresherView.this.QZ != null) {
                RefresherView.this.QZ.layout(0, -RefresherView.this.QZ.getMeasuredHeight(), i5, 0);
            }
            RefresherView.this.getLocationOnScreen(RefresherView.this.mTempLocation);
            RefresherView.this.Rb = RefresherView.this.mTempLocation[1];
        }

        @Override // com.baidu.adp.widget.f
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mEmptyView, drawingTime);
            }
            canvas.save();
            canvas.translate(0.0f, RefresherView.this.mYOffset / 2);
            RefresherView.this.drawChild(canvas, RefresherView.this.QY, drawingTime);
            if (RefresherView.this.mYOffset > 0) {
                RefresherView.this.drawChild(canvas, RefresherView.this.QZ, drawingTime);
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
        public boolean l(MotionEvent motionEvent) {
            View childAt;
            if (!RefresherView.this.Og || RefresherView.this.mRefreshing) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int y = (int) motionEvent.getY();
            switch (action) {
                case 0:
                    RefresherView.this.Mw = y;
                    RefresherView.this.Rf.removeMessages(1000);
                    break;
                case 2:
                    if (!(RefresherView.this.QY instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.QY).getChildAt(0)) == null) {
                        RefresherView.this.QY.getLocationOnScreen(RefresherView.this.Ra);
                        if (RefresherView.this.Ra[1] == RefresherView.this.Rb && y > RefresherView.this.Mw) {
                            RefresherView.this.Rj = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.Rg;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.Ra);
                        if (RefresherView.this.Ra[1] == RefresherView.this.Rb && y > RefresherView.this.Mw) {
                            RefresherView.this.Rj = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar2 = RefresherView.this.Rg;
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
        public boolean m(MotionEvent motionEvent) {
            int action = motionEvent.getAction() & 255;
            int y = (int) motionEvent.getY();
            switch (action) {
                case 1:
                case 3:
                    if (RefresherView.this.mYOffset <= RefresherView.this.QU) {
                        RefresherView.this.Rd = 0;
                    } else {
                        RefresherView.this.refresh();
                    }
                    aS(1000);
                    return true;
                case 2:
                    RefresherView.this.mYOffset = Math.max(0, Math.min(y - RefresherView.this.Mw, RefresherView.this.mMaxHeight * 2));
                    if (RefresherView.this.mYOffset <= RefresherView.this.QU || RefresherView.this.Rj != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mYOffset < RefresherView.this.QU && RefresherView.this.Rj == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.Rj = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.Rg;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.Rj = IRefreshable.State.pulling_refresh;
                        IRefreshable.a aVar2 = RefresherView.this.Rg;
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
        public void aS(int i) {
            RefresherView.this.Re.aS(i);
        }
    }

    /* loaded from: classes.dex */
    private class d extends Handler implements com.baidu.adp.widget.e {
        private long NC;
        private long ND;
        private int NE;
        private float NF;
        private boolean NG;
        private final int Ro;
        private float Rp;

        public d() {
            this.Ro = (int) ((RefresherView.this.getResources().getDisplayMetrics().density * 75.0f) + 0.5d);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1000:
                    pg();
                    return;
                case 1001:
                    ph();
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.adp.widget.f
        public void measure(int i, int i2) {
            int i3 = i & 1073741823;
            int i4 = 1073741823 & i2;
            if (RefresherView.this.QY != null) {
                RefresherView.this.measureChild(RefresherView.this.QY, i3 + 1073741824, i4 + 1073741824);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.measureChild(RefresherView.this.mEmptyView, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.QZ != null) {
                RefresherView.this.measureChild(RefresherView.this.QZ, i3 - 2147483648, i4 + 1073741824);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // com.baidu.adp.widget.e
        public void a(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.QY != null) {
                RefresherView.this.QY.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.mEmptyView.layout((i5 - RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (i6 - RefresherView.this.mEmptyView.getMeasuredHeight()) / 2, (i5 + RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (RefresherView.this.mEmptyView.getMeasuredHeight() + i6) / 2);
            }
            if (RefresherView.this.QZ != null) {
                RefresherView.this.QZ.layout(-RefresherView.this.QZ.getMeasuredWidth(), 0, 0, i6);
            }
            RefresherView.this.getLocationOnScreen(RefresherView.this.mTempLocation);
            RefresherView.this.Rc = RefresherView.this.mTempLocation[0];
        }

        @Override // com.baidu.adp.widget.f
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mEmptyView, drawingTime);
            }
            canvas.save();
            canvas.translate(RefresherView.this.mXOffset >> 1, 0.0f);
            RefresherView.this.drawChild(canvas, RefresherView.this.QY, drawingTime);
            if (RefresherView.this.mXOffset > 0) {
                RefresherView.this.drawChild(canvas, RefresherView.this.QZ, drawingTime);
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
        public boolean l(MotionEvent motionEvent) {
            View childAt;
            if (!RefresherView.this.Og || RefresherView.this.mRefreshing) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            switch (action) {
                case 0:
                    RefresherView.this.Mv = x;
                    removeMessages(1000);
                    removeMessages(1001);
                    break;
                case 2:
                    if (!(RefresherView.this.QY instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.QY).getChildAt(0)) == null) {
                        RefresherView.this.QY.getLocationOnScreen(RefresherView.this.Ra);
                        if (RefresherView.this.Ra[0] == RefresherView.this.Rc && x > RefresherView.this.Mv + this.Ro) {
                            RefresherView.this.Rj = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.Rg;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.Ra);
                        if (RefresherView.this.Ra[0] == RefresherView.this.Rc && x > RefresherView.this.Mv + this.Ro) {
                            RefresherView.this.Rj = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar2 = RefresherView.this.Rg;
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
        public boolean m(MotionEvent motionEvent) {
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            switch (action) {
                case 1:
                case 3:
                    if (RefresherView.this.mXOffset <= RefresherView.this.QU) {
                        RefresherView.this.Rd = 0;
                    } else {
                        RefresherView.this.refresh();
                    }
                    aS(1000);
                    return true;
                case 2:
                    RefresherView.this.mXOffset = Math.max(0, Math.min((x - RefresherView.this.Mv) - this.Ro, RefresherView.this.mMaxHeight * 2));
                    if (RefresherView.this.mXOffset <= RefresherView.this.QU || RefresherView.this.Rj != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mXOffset < RefresherView.this.QU && RefresherView.this.Rj == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.Rj = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.Rg;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.Rj = IRefreshable.State.pulling_refresh;
                        IRefreshable.a aVar2 = RefresherView.this.Rg;
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
        public void aS(int i) {
            switch (i) {
                case 1000:
                    pj();
                    return;
                case 1001:
                    pi();
                    return;
                default:
                    return;
            }
        }

        private void pi() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.NC = uptimeMillis;
            this.ND = uptimeMillis + 16;
            this.NG = true;
            this.Rp = RefresherView.this.QU;
            this.NF = 0.0f;
            this.NE = RefresherView.this.NB;
            removeMessages(1001);
            sendEmptyMessageAtTime(1001, this.ND);
        }

        private void pj() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.NC = uptimeMillis;
            this.ND = uptimeMillis + 16;
            this.NG = true;
            this.Rp = RefresherView.this.mXOffset - RefresherView.this.Rd;
            this.NF = 0.0f;
            this.NE = Math.max(RefresherView.this.QT, (RefresherView.this.mXOffset - RefresherView.this.Rd) * 2);
            removeMessages(1000);
            sendEmptyMessageAtTime(1000, this.ND);
        }

        private void ph() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.NF = ((((float) (uptimeMillis - this.NC)) / 1000.0f) * this.NE) + this.NF;
            if (this.NF >= this.Rp) {
                RefresherView.this.mXOffset = RefresherView.this.QU;
                this.NG = false;
                RefresherView.this.Rj = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.Rg;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mXOffset = com.baidu.adp.widget.a.a(this.Rp, this.NF, false);
                this.NC = uptimeMillis;
                this.ND = uptimeMillis + 16;
                removeMessages(1001);
                sendEmptyMessageAtTime(1001, this.ND);
            }
            RefresherView.this.invalidate();
        }

        private void pg() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.NF = ((((float) (uptimeMillis - this.NC)) / 1000.0f) * this.NE) + this.NF;
            if (this.NF >= this.Rp) {
                RefresherView.this.mXOffset = RefresherView.this.Rd;
                this.NG = false;
                RefresherView.this.Rj = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.Rg;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                }
                if (RefresherView.this.Rd == 0 && aVar != null) {
                    aVar.pf();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mXOffset = (int) (RefresherView.this.Rd + (this.Rp * (1.0f - com.baidu.adp.widget.a.sInterpolator.getInterpolation(this.NF / this.Rp))));
                this.NC = uptimeMillis;
                this.ND = uptimeMillis + 16;
                removeMessages(1000);
                sendEmptyMessageAtTime(1000, this.ND);
            }
            RefresherView.this.invalidate();
        }
    }
}
