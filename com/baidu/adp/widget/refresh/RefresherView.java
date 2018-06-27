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
    private int Kc;
    private int Kd;
    private boolean LI;
    private final int Le;
    private int OA;
    private int OB;
    private int OC;
    private final a OD;
    private final b OE;
    private IRefreshable.a OF;
    private c OG;
    private com.baidu.adp.widget.e OH;
    private IRefreshable.State OI;
    private final int Os;
    private int Ot;
    private final int Ou;
    private final int Ov;
    private final int Ow;
    private View Ox;
    private View Oy;
    private final int[] Oz;
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
        this.LI = true;
        this.Oz = new int[2];
        this.mTempLocation = new int[2];
        this.OI = IRefreshable.State.idle;
        this.OD = new a();
        this.OE = new b();
        float f = getResources().getDisplayMetrics().density;
        this.Os = (int) ((100.0f * f) + 0.5f);
        this.Le = (int) ((500.0f * f) + 0.5f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RefresherView);
        this.Ot = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_threshold_height, -1);
        if (this.Ot == -1) {
            this.Ot = (int) ((200.0f * f) + 0.5f);
        }
        this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_max_height, -1);
        if (this.mMaxHeight == -1) {
            this.mMaxHeight = (int) ((f * 400.0f) + 0.5f);
        }
        String string = obtainStyledAttributes.getString(R.styleable.RefresherView_direction);
        if (string == null) {
            this.OH = new e();
        } else if (string.equals("side")) {
            this.OH = new d();
        } else if (string.equals("top")) {
            this.OH = new e();
        }
        this.Ou = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_content, -1);
        this.Ov = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_head, -1);
        this.Ow = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_empty_view, -1);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        if (this.Ou == -1) {
            throw new RuntimeException("refresher content id is not set in xml, or call setRefresherContent before add it to a view tree.");
        }
        this.Ox = findViewById(this.Ou);
        if (this.Ox == null) {
            throw new RuntimeException("refresher content not found in the view tree by the content id.");
        }
        if (this.Ov == -1) {
            throw new RuntimeException("refresher head id is not set in xml, or call setRefresherHeader before add it to a view tree.");
        }
        this.Oy = findViewById(this.Ov);
        if (this.Oy == null) {
            throw new RuntimeException("refresher header not found in the view tree by the header id.");
        }
        if (this.Ow == -1) {
            throw new RuntimeException("empty view id is not set in xml, or call setEmptyView before add it to a view tree");
        }
        this.mEmptyView = findViewById(this.Ow);
        if (this.mEmptyView == null) {
            throw new RuntimeException("empty view not found in the view tree by the empty view's id");
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.OH.measure(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.OH.a(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.OH.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.OH.l(motionEvent);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.OH.m(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.OH.draw(canvas);
    }

    public void setOnRefreshListener(IRefreshable.a aVar) {
        this.OF = aVar;
    }

    public void setEnable(boolean z) {
        this.LI = (!z || this.Ox == null || this.Oy == null) ? false : true;
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.LI;
    }

    public IRefreshable.State getState() {
        return this.OI;
    }

    public void refresh() {
        if (this.OG == null || this.OG.getStatus() != BdAsyncTask.BdAsyncTaskStatus.RUNNING) {
            this.OG = new c();
            this.OG.execute(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private long Lf;
        private long Lg;
        private int Lh;
        private boolean Lj;
        private int OJ;
        private int OL;

        private a() {
        }

        void ob() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.OJ = (int) (((((float) (uptimeMillis - this.Lf)) / 1000.0f) * this.Lh) + this.OJ);
            if (this.OJ >= this.OL) {
                RefresherView.this.mYOffset = RefresherView.this.OC;
                this.Lj = false;
                RefresherView.this.OI = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.OF;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                }
                if (RefresherView.this.OC == 0 && aVar != null) {
                    aVar.oa();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mYOffset = (int) (RefresherView.this.OC + (this.OL * (1.0f - com.baidu.adp.widget.a.sInterpolator.getInterpolation(this.OJ / this.OL))));
                this.Lf = uptimeMillis;
                this.Lg = uptimeMillis + 16;
                RefresherView.this.OE.removeMessages(1000);
                RefresherView.this.OE.sendEmptyMessageAtTime(1000, this.Lg);
            }
            RefresherView.this.invalidate();
        }

        void oc() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.OJ = (int) (((((float) (uptimeMillis - this.Lf)) / 1000.0f) * this.Lh) + this.OJ);
            if (this.OJ >= this.OL) {
                RefresherView.this.mYOffset = RefresherView.this.Ot;
                this.Lj = false;
                RefresherView.this.OI = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.OF;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mYOffset = com.baidu.adp.widget.a.a(this.OL, this.OJ, false);
                this.Lf = uptimeMillis;
                this.Lg = uptimeMillis + 16;
                RefresherView.this.OE.removeMessages(1001);
                RefresherView.this.OE.sendEmptyMessageAtTime(1001, this.Lg);
            }
            RefresherView.this.invalidate();
        }

        void aH(int i) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Lf = uptimeMillis;
            this.Lg = uptimeMillis + 16;
            this.Lj = true;
            switch (i) {
                case 1000:
                    this.OL = RefresherView.this.mYOffset - RefresherView.this.OC;
                    this.OJ = 0;
                    this.Lh = Math.max(RefresherView.this.Os, (RefresherView.this.mYOffset - RefresherView.this.OC) * 2);
                    RefresherView.this.OE.removeMessages(1000);
                    RefresherView.this.OE.sendEmptyMessageAtTime(1000, this.Lg);
                    break;
                case 1001:
                    this.OL = RefresherView.this.Ot;
                    this.OJ = 0;
                    this.Lh = RefresherView.this.Le;
                    RefresherView.this.OE.removeMessages(1001);
                    RefresherView.this.OE.sendEmptyMessageAtTime(1001, this.Lg);
                    break;
            }
            RefresherView.this.OI = IRefreshable.State.animating;
            IRefreshable.a aVar = RefresherView.this.OF;
            if (aVar != null) {
                aVar.a(IRefreshable.State.animating);
            }
        }
    }

    public View getRefresherContent() {
        return this.Ox;
    }

    public View getRefresherHeader() {
        return this.Oy;
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    public void setRefresherContent(ViewGroup viewGroup) {
        boolean z = false;
        removeView(this.Ox);
        this.Ox = viewGroup;
        if (this.Ox == null) {
            this.LI = false;
            return;
        }
        addView(this.Ox);
        if (this.Oy != null && this.Ox != null) {
            z = true;
        }
        this.LI = z;
    }

    public void setRefresherHeader(View view) {
        boolean z = false;
        removeView(this.Oy);
        this.Oy = view;
        if (this.Oy == null) {
            this.LI = false;
            return;
        }
        addView(this.Oy);
        if (this.Oy != null && this.Ox != null) {
            z = true;
        }
        this.LI = z;
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
                RefresherView.this.OD.ob();
            } else if (message.what == 1001) {
                RefresherView.this.OD.oc();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {
        private final IRefreshable.a OO;

        c() {
            this.OO = RefresherView.this.OF;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (this.OO != null) {
                RefresherView.this.OC = RefresherView.this.Ot;
                this.OO.nY();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            RefresherView.this.mRefreshing = true;
            if (this.OO != null) {
                this.OO.nZ();
                return null;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r3) {
            RefresherView.this.OC = 0;
            RefresherView.this.OH.aH(1000);
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
            if (RefresherView.this.Ox != null) {
                RefresherView.this.measureChild(RefresherView.this.Ox, i3 + 1073741824, i4 + 1073741824);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.measureChild(RefresherView.this.mEmptyView, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.Oy != null) {
                RefresherView.this.measureChild(RefresherView.this.Oy, i3 + 1073741824, i4 - 2147483648);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // com.baidu.adp.widget.e
        public void a(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.Ox != null) {
                RefresherView.this.Ox.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.mEmptyView.layout((i5 - RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (i6 - RefresherView.this.mEmptyView.getMeasuredHeight()) / 2, (RefresherView.this.mEmptyView.getMeasuredWidth() + i5) / 2, (i6 + RefresherView.this.mEmptyView.getMeasuredHeight()) / 2);
            }
            if (RefresherView.this.Oy != null) {
                RefresherView.this.Oy.layout(0, -RefresherView.this.Oy.getMeasuredHeight(), i5, 0);
            }
            RefresherView.this.getLocationOnScreen(RefresherView.this.mTempLocation);
            RefresherView.this.OA = RefresherView.this.mTempLocation[1];
        }

        @Override // com.baidu.adp.widget.f
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mEmptyView, drawingTime);
            }
            canvas.save();
            canvas.translate(0.0f, RefresherView.this.mYOffset / 2);
            RefresherView.this.drawChild(canvas, RefresherView.this.Ox, drawingTime);
            if (RefresherView.this.mYOffset > 0) {
                RefresherView.this.drawChild(canvas, RefresherView.this.Oy, drawingTime);
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
            if (!RefresherView.this.LI || RefresherView.this.mRefreshing) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int y = (int) motionEvent.getY();
            switch (action) {
                case 0:
                    RefresherView.this.Kd = y;
                    RefresherView.this.OE.removeMessages(1000);
                    break;
                case 2:
                    if (!(RefresherView.this.Ox instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.Ox).getChildAt(0)) == null) {
                        RefresherView.this.Ox.getLocationOnScreen(RefresherView.this.Oz);
                        if (RefresherView.this.Oz[1] == RefresherView.this.OA && y > RefresherView.this.Kd) {
                            RefresherView.this.OI = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.OF;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.Oz);
                        if (RefresherView.this.Oz[1] == RefresherView.this.OA && y > RefresherView.this.Kd) {
                            RefresherView.this.OI = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar2 = RefresherView.this.OF;
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
                    if (RefresherView.this.mYOffset <= RefresherView.this.Ot) {
                        RefresherView.this.OC = 0;
                    } else {
                        RefresherView.this.refresh();
                    }
                    aH(1000);
                    return true;
                case 2:
                    RefresherView.this.mYOffset = Math.max(0, Math.min(y - RefresherView.this.Kd, RefresherView.this.mMaxHeight * 2));
                    if (RefresherView.this.mYOffset <= RefresherView.this.Ot || RefresherView.this.OI != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mYOffset < RefresherView.this.Ot && RefresherView.this.OI == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.OI = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.OF;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.OI = IRefreshable.State.pulling_refresh;
                        IRefreshable.a aVar2 = RefresherView.this.OF;
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
        public void aH(int i) {
            RefresherView.this.OD.aH(i);
        }
    }

    /* loaded from: classes.dex */
    private class d extends Handler implements com.baidu.adp.widget.e {
        private long Lf;
        private long Lg;
        private int Lh;
        private float Li;
        private boolean Lj;
        private final int OP;
        private float OQ;

        public d() {
            this.OP = (int) ((RefresherView.this.getResources().getDisplayMetrics().density * 75.0f) + 0.5d);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1000:
                    ob();
                    return;
                case 1001:
                    oc();
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.adp.widget.f
        public void measure(int i, int i2) {
            int i3 = i & 1073741823;
            int i4 = 1073741823 & i2;
            if (RefresherView.this.Ox != null) {
                RefresherView.this.measureChild(RefresherView.this.Ox, i3 + 1073741824, i4 + 1073741824);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.measureChild(RefresherView.this.mEmptyView, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.Oy != null) {
                RefresherView.this.measureChild(RefresherView.this.Oy, i3 - 2147483648, i4 + 1073741824);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // com.baidu.adp.widget.e
        public void a(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.Ox != null) {
                RefresherView.this.Ox.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.mEmptyView.layout((i5 - RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (i6 - RefresherView.this.mEmptyView.getMeasuredHeight()) / 2, (i5 + RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (RefresherView.this.mEmptyView.getMeasuredHeight() + i6) / 2);
            }
            if (RefresherView.this.Oy != null) {
                RefresherView.this.Oy.layout(-RefresherView.this.Oy.getMeasuredWidth(), 0, 0, i6);
            }
            RefresherView.this.getLocationOnScreen(RefresherView.this.mTempLocation);
            RefresherView.this.OB = RefresherView.this.mTempLocation[0];
        }

        @Override // com.baidu.adp.widget.f
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mEmptyView, drawingTime);
            }
            canvas.save();
            canvas.translate(RefresherView.this.mXOffset >> 1, 0.0f);
            RefresherView.this.drawChild(canvas, RefresherView.this.Ox, drawingTime);
            if (RefresherView.this.mXOffset > 0) {
                RefresherView.this.drawChild(canvas, RefresherView.this.Oy, drawingTime);
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
            if (!RefresherView.this.LI || RefresherView.this.mRefreshing) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            switch (action) {
                case 0:
                    RefresherView.this.Kc = x;
                    removeMessages(1000);
                    removeMessages(1001);
                    break;
                case 2:
                    if (!(RefresherView.this.Ox instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.Ox).getChildAt(0)) == null) {
                        RefresherView.this.Ox.getLocationOnScreen(RefresherView.this.Oz);
                        if (RefresherView.this.Oz[0] == RefresherView.this.OB && x > RefresherView.this.Kc + this.OP) {
                            RefresherView.this.OI = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.OF;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.Oz);
                        if (RefresherView.this.Oz[0] == RefresherView.this.OB && x > RefresherView.this.Kc + this.OP) {
                            RefresherView.this.OI = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar2 = RefresherView.this.OF;
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
                    if (RefresherView.this.mXOffset <= RefresherView.this.Ot) {
                        RefresherView.this.OC = 0;
                    } else {
                        RefresherView.this.refresh();
                    }
                    aH(1000);
                    return true;
                case 2:
                    RefresherView.this.mXOffset = Math.max(0, Math.min((x - RefresherView.this.Kc) - this.OP, RefresherView.this.mMaxHeight * 2));
                    if (RefresherView.this.mXOffset <= RefresherView.this.Ot || RefresherView.this.OI != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mXOffset < RefresherView.this.Ot && RefresherView.this.OI == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.OI = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.OF;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.OI = IRefreshable.State.pulling_refresh;
                        IRefreshable.a aVar2 = RefresherView.this.OF;
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
        public void aH(int i) {
            switch (i) {
                case 1000:
                    oe();
                    return;
                case 1001:
                    od();
                    return;
                default:
                    return;
            }
        }

        private void od() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Lf = uptimeMillis;
            this.Lg = uptimeMillis + 16;
            this.Lj = true;
            this.OQ = RefresherView.this.Ot;
            this.Li = 0.0f;
            this.Lh = RefresherView.this.Le;
            removeMessages(1001);
            sendEmptyMessageAtTime(1001, this.Lg);
        }

        private void oe() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Lf = uptimeMillis;
            this.Lg = uptimeMillis + 16;
            this.Lj = true;
            this.OQ = RefresherView.this.mXOffset - RefresherView.this.OC;
            this.Li = 0.0f;
            this.Lh = Math.max(RefresherView.this.Os, (RefresherView.this.mXOffset - RefresherView.this.OC) * 2);
            removeMessages(1000);
            sendEmptyMessageAtTime(1000, this.Lg);
        }

        private void oc() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Li = ((((float) (uptimeMillis - this.Lf)) / 1000.0f) * this.Lh) + this.Li;
            if (this.Li >= this.OQ) {
                RefresherView.this.mXOffset = RefresherView.this.Ot;
                this.Lj = false;
                RefresherView.this.OI = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.OF;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mXOffset = com.baidu.adp.widget.a.a(this.OQ, this.Li, false);
                this.Lf = uptimeMillis;
                this.Lg = uptimeMillis + 16;
                removeMessages(1001);
                sendEmptyMessageAtTime(1001, this.Lg);
            }
            RefresherView.this.invalidate();
        }

        private void ob() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Li = ((((float) (uptimeMillis - this.Lf)) / 1000.0f) * this.Lh) + this.Li;
            if (this.Li >= this.OQ) {
                RefresherView.this.mXOffset = RefresherView.this.OC;
                this.Lj = false;
                RefresherView.this.OI = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.OF;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                }
                if (RefresherView.this.OC == 0 && aVar != null) {
                    aVar.oa();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mXOffset = (int) (RefresherView.this.OC + (this.OQ * (1.0f - com.baidu.adp.widget.a.sInterpolator.getInterpolation(this.Li / this.OQ))));
                this.Lf = uptimeMillis;
                this.Lg = uptimeMillis + 16;
                removeMessages(1000);
                sendEmptyMessageAtTime(1000, this.Lg);
            }
            RefresherView.this.invalidate();
        }
    }
}
