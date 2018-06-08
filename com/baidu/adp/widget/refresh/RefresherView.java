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
    private int Ka;
    private int Kb;
    private boolean LG;
    private final int Lc;
    private int OA;
    private final a OB;
    private final b OC;
    private IRefreshable.a OD;
    private c OE;
    private com.baidu.adp.widget.e OF;
    private IRefreshable.State OG;
    private final int Oq;
    private int Or;
    private final int Os;
    private final int Ot;
    private final int Ou;
    private View Ov;
    private View Ow;
    private final int[] Ox;
    private int Oy;
    private int Oz;
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
        this.LG = true;
        this.Ox = new int[2];
        this.mTempLocation = new int[2];
        this.OG = IRefreshable.State.idle;
        this.OB = new a();
        this.OC = new b();
        float f = getResources().getDisplayMetrics().density;
        this.Oq = (int) ((100.0f * f) + 0.5f);
        this.Lc = (int) ((500.0f * f) + 0.5f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RefresherView);
        this.Or = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_threshold_height, -1);
        if (this.Or == -1) {
            this.Or = (int) ((200.0f * f) + 0.5f);
        }
        this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_max_height, -1);
        if (this.mMaxHeight == -1) {
            this.mMaxHeight = (int) ((f * 400.0f) + 0.5f);
        }
        String string = obtainStyledAttributes.getString(R.styleable.RefresherView_direction);
        if (string == null) {
            this.OF = new e();
        } else if (string.equals("side")) {
            this.OF = new d();
        } else if (string.equals("top")) {
            this.OF = new e();
        }
        this.Os = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_content, -1);
        this.Ot = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_head, -1);
        this.Ou = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_empty_view, -1);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        if (this.Os == -1) {
            throw new RuntimeException("refresher content id is not set in xml, or call setRefresherContent before add it to a view tree.");
        }
        this.Ov = findViewById(this.Os);
        if (this.Ov == null) {
            throw new RuntimeException("refresher content not found in the view tree by the content id.");
        }
        if (this.Ot == -1) {
            throw new RuntimeException("refresher head id is not set in xml, or call setRefresherHeader before add it to a view tree.");
        }
        this.Ow = findViewById(this.Ot);
        if (this.Ow == null) {
            throw new RuntimeException("refresher header not found in the view tree by the header id.");
        }
        if (this.Ou == -1) {
            throw new RuntimeException("empty view id is not set in xml, or call setEmptyView before add it to a view tree");
        }
        this.mEmptyView = findViewById(this.Ou);
        if (this.mEmptyView == null) {
            throw new RuntimeException("empty view not found in the view tree by the empty view's id");
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.OF.measure(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.OF.a(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.OF.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.OF.l(motionEvent);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.OF.m(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.OF.draw(canvas);
    }

    public void setOnRefreshListener(IRefreshable.a aVar) {
        this.OD = aVar;
    }

    public void setEnable(boolean z) {
        this.LG = (!z || this.Ov == null || this.Ow == null) ? false : true;
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.LG;
    }

    public IRefreshable.State getState() {
        return this.OG;
    }

    public void refresh() {
        if (this.OE == null || this.OE.getStatus() != BdAsyncTask.BdAsyncTaskStatus.RUNNING) {
            this.OE = new c();
            this.OE.execute(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private long Ld;
        private long Le;
        private int Lf;
        private boolean Lh;
        private int OH;
        private int OI;

        private a() {
        }

        void ob() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.OH = (int) (((((float) (uptimeMillis - this.Ld)) / 1000.0f) * this.Lf) + this.OH);
            if (this.OH >= this.OI) {
                RefresherView.this.mYOffset = RefresherView.this.OA;
                this.Lh = false;
                RefresherView.this.OG = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.OD;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                }
                if (RefresherView.this.OA == 0 && aVar != null) {
                    aVar.oa();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mYOffset = (int) (RefresherView.this.OA + (this.OI * (1.0f - com.baidu.adp.widget.a.sInterpolator.getInterpolation(this.OH / this.OI))));
                this.Ld = uptimeMillis;
                this.Le = uptimeMillis + 16;
                RefresherView.this.OC.removeMessages(1000);
                RefresherView.this.OC.sendEmptyMessageAtTime(1000, this.Le);
            }
            RefresherView.this.invalidate();
        }

        void oc() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.OH = (int) (((((float) (uptimeMillis - this.Ld)) / 1000.0f) * this.Lf) + this.OH);
            if (this.OH >= this.OI) {
                RefresherView.this.mYOffset = RefresherView.this.Or;
                this.Lh = false;
                RefresherView.this.OG = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.OD;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mYOffset = com.baidu.adp.widget.a.a(this.OI, this.OH, false);
                this.Ld = uptimeMillis;
                this.Le = uptimeMillis + 16;
                RefresherView.this.OC.removeMessages(1001);
                RefresherView.this.OC.sendEmptyMessageAtTime(1001, this.Le);
            }
            RefresherView.this.invalidate();
        }

        void aH(int i) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ld = uptimeMillis;
            this.Le = uptimeMillis + 16;
            this.Lh = true;
            switch (i) {
                case 1000:
                    this.OI = RefresherView.this.mYOffset - RefresherView.this.OA;
                    this.OH = 0;
                    this.Lf = Math.max(RefresherView.this.Oq, (RefresherView.this.mYOffset - RefresherView.this.OA) * 2);
                    RefresherView.this.OC.removeMessages(1000);
                    RefresherView.this.OC.sendEmptyMessageAtTime(1000, this.Le);
                    break;
                case 1001:
                    this.OI = RefresherView.this.Or;
                    this.OH = 0;
                    this.Lf = RefresherView.this.Lc;
                    RefresherView.this.OC.removeMessages(1001);
                    RefresherView.this.OC.sendEmptyMessageAtTime(1001, this.Le);
                    break;
            }
            RefresherView.this.OG = IRefreshable.State.animating;
            IRefreshable.a aVar = RefresherView.this.OD;
            if (aVar != null) {
                aVar.a(IRefreshable.State.animating);
            }
        }
    }

    public View getRefresherContent() {
        return this.Ov;
    }

    public View getRefresherHeader() {
        return this.Ow;
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    public void setRefresherContent(ViewGroup viewGroup) {
        boolean z = false;
        removeView(this.Ov);
        this.Ov = viewGroup;
        if (this.Ov == null) {
            this.LG = false;
            return;
        }
        addView(this.Ov);
        if (this.Ow != null && this.Ov != null) {
            z = true;
        }
        this.LG = z;
    }

    public void setRefresherHeader(View view) {
        boolean z = false;
        removeView(this.Ow);
        this.Ow = view;
        if (this.Ow == null) {
            this.LG = false;
            return;
        }
        addView(this.Ow);
        if (this.Ow != null && this.Ov != null) {
            z = true;
        }
        this.LG = z;
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
                RefresherView.this.OB.ob();
            } else if (message.what == 1001) {
                RefresherView.this.OB.oc();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {
        private final IRefreshable.a OL;

        c() {
            this.OL = RefresherView.this.OD;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (this.OL != null) {
                RefresherView.this.OA = RefresherView.this.Or;
                this.OL.nY();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            RefresherView.this.mRefreshing = true;
            if (this.OL != null) {
                this.OL.nZ();
                return null;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r3) {
            RefresherView.this.OA = 0;
            RefresherView.this.OF.aH(1000);
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
            if (RefresherView.this.Ov != null) {
                RefresherView.this.measureChild(RefresherView.this.Ov, i3 + 1073741824, i4 + 1073741824);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.measureChild(RefresherView.this.mEmptyView, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.Ow != null) {
                RefresherView.this.measureChild(RefresherView.this.Ow, i3 + 1073741824, i4 - 2147483648);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // com.baidu.adp.widget.e
        public void a(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.Ov != null) {
                RefresherView.this.Ov.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.mEmptyView.layout((i5 - RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (i6 - RefresherView.this.mEmptyView.getMeasuredHeight()) / 2, (RefresherView.this.mEmptyView.getMeasuredWidth() + i5) / 2, (i6 + RefresherView.this.mEmptyView.getMeasuredHeight()) / 2);
            }
            if (RefresherView.this.Ow != null) {
                RefresherView.this.Ow.layout(0, -RefresherView.this.Ow.getMeasuredHeight(), i5, 0);
            }
            RefresherView.this.getLocationOnScreen(RefresherView.this.mTempLocation);
            RefresherView.this.Oy = RefresherView.this.mTempLocation[1];
        }

        @Override // com.baidu.adp.widget.f
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mEmptyView, drawingTime);
            }
            canvas.save();
            canvas.translate(0.0f, RefresherView.this.mYOffset / 2);
            RefresherView.this.drawChild(canvas, RefresherView.this.Ov, drawingTime);
            if (RefresherView.this.mYOffset > 0) {
                RefresherView.this.drawChild(canvas, RefresherView.this.Ow, drawingTime);
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
            if (!RefresherView.this.LG || RefresherView.this.mRefreshing) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int y = (int) motionEvent.getY();
            switch (action) {
                case 0:
                    RefresherView.this.Kb = y;
                    RefresherView.this.OC.removeMessages(1000);
                    break;
                case 2:
                    if (!(RefresherView.this.Ov instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.Ov).getChildAt(0)) == null) {
                        RefresherView.this.Ov.getLocationOnScreen(RefresherView.this.Ox);
                        if (RefresherView.this.Ox[1] == RefresherView.this.Oy && y > RefresherView.this.Kb) {
                            RefresherView.this.OG = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.OD;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.Ox);
                        if (RefresherView.this.Ox[1] == RefresherView.this.Oy && y > RefresherView.this.Kb) {
                            RefresherView.this.OG = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar2 = RefresherView.this.OD;
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
                    if (RefresherView.this.mYOffset <= RefresherView.this.Or) {
                        RefresherView.this.OA = 0;
                    } else {
                        RefresherView.this.refresh();
                    }
                    aH(1000);
                    return true;
                case 2:
                    RefresherView.this.mYOffset = Math.max(0, Math.min(y - RefresherView.this.Kb, RefresherView.this.mMaxHeight * 2));
                    if (RefresherView.this.mYOffset <= RefresherView.this.Or || RefresherView.this.OG != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mYOffset < RefresherView.this.Or && RefresherView.this.OG == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.OG = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.OD;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.OG = IRefreshable.State.pulling_refresh;
                        IRefreshable.a aVar2 = RefresherView.this.OD;
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
            RefresherView.this.OB.aH(i);
        }
    }

    /* loaded from: classes.dex */
    private class d extends Handler implements com.baidu.adp.widget.e {
        private long Ld;
        private long Le;
        private int Lf;
        private float Lg;
        private boolean Lh;
        private final int OM;
        private float OO;

        public d() {
            this.OM = (int) ((RefresherView.this.getResources().getDisplayMetrics().density * 75.0f) + 0.5d);
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
            if (RefresherView.this.Ov != null) {
                RefresherView.this.measureChild(RefresherView.this.Ov, i3 + 1073741824, i4 + 1073741824);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.measureChild(RefresherView.this.mEmptyView, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.Ow != null) {
                RefresherView.this.measureChild(RefresherView.this.Ow, i3 - 2147483648, i4 + 1073741824);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // com.baidu.adp.widget.e
        public void a(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.Ov != null) {
                RefresherView.this.Ov.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.mEmptyView.layout((i5 - RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (i6 - RefresherView.this.mEmptyView.getMeasuredHeight()) / 2, (i5 + RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (RefresherView.this.mEmptyView.getMeasuredHeight() + i6) / 2);
            }
            if (RefresherView.this.Ow != null) {
                RefresherView.this.Ow.layout(-RefresherView.this.Ow.getMeasuredWidth(), 0, 0, i6);
            }
            RefresherView.this.getLocationOnScreen(RefresherView.this.mTempLocation);
            RefresherView.this.Oz = RefresherView.this.mTempLocation[0];
        }

        @Override // com.baidu.adp.widget.f
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mEmptyView, drawingTime);
            }
            canvas.save();
            canvas.translate(RefresherView.this.mXOffset >> 1, 0.0f);
            RefresherView.this.drawChild(canvas, RefresherView.this.Ov, drawingTime);
            if (RefresherView.this.mXOffset > 0) {
                RefresherView.this.drawChild(canvas, RefresherView.this.Ow, drawingTime);
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
            if (!RefresherView.this.LG || RefresherView.this.mRefreshing) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            switch (action) {
                case 0:
                    RefresherView.this.Ka = x;
                    removeMessages(1000);
                    removeMessages(1001);
                    break;
                case 2:
                    if (!(RefresherView.this.Ov instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.Ov).getChildAt(0)) == null) {
                        RefresherView.this.Ov.getLocationOnScreen(RefresherView.this.Ox);
                        if (RefresherView.this.Ox[0] == RefresherView.this.Oz && x > RefresherView.this.Ka + this.OM) {
                            RefresherView.this.OG = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.OD;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.Ox);
                        if (RefresherView.this.Ox[0] == RefresherView.this.Oz && x > RefresherView.this.Ka + this.OM) {
                            RefresherView.this.OG = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar2 = RefresherView.this.OD;
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
                    if (RefresherView.this.mXOffset <= RefresherView.this.Or) {
                        RefresherView.this.OA = 0;
                    } else {
                        RefresherView.this.refresh();
                    }
                    aH(1000);
                    return true;
                case 2:
                    RefresherView.this.mXOffset = Math.max(0, Math.min((x - RefresherView.this.Ka) - this.OM, RefresherView.this.mMaxHeight * 2));
                    if (RefresherView.this.mXOffset <= RefresherView.this.Or || RefresherView.this.OG != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mXOffset < RefresherView.this.Or && RefresherView.this.OG == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.OG = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.OD;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.OG = IRefreshable.State.pulling_refresh;
                        IRefreshable.a aVar2 = RefresherView.this.OD;
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
            this.Ld = uptimeMillis;
            this.Le = uptimeMillis + 16;
            this.Lh = true;
            this.OO = RefresherView.this.Or;
            this.Lg = 0.0f;
            this.Lf = RefresherView.this.Lc;
            removeMessages(1001);
            sendEmptyMessageAtTime(1001, this.Le);
        }

        private void oe() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ld = uptimeMillis;
            this.Le = uptimeMillis + 16;
            this.Lh = true;
            this.OO = RefresherView.this.mXOffset - RefresherView.this.OA;
            this.Lg = 0.0f;
            this.Lf = Math.max(RefresherView.this.Oq, (RefresherView.this.mXOffset - RefresherView.this.OA) * 2);
            removeMessages(1000);
            sendEmptyMessageAtTime(1000, this.Le);
        }

        private void oc() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Lg = ((((float) (uptimeMillis - this.Ld)) / 1000.0f) * this.Lf) + this.Lg;
            if (this.Lg >= this.OO) {
                RefresherView.this.mXOffset = RefresherView.this.Or;
                this.Lh = false;
                RefresherView.this.OG = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.OD;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mXOffset = com.baidu.adp.widget.a.a(this.OO, this.Lg, false);
                this.Ld = uptimeMillis;
                this.Le = uptimeMillis + 16;
                removeMessages(1001);
                sendEmptyMessageAtTime(1001, this.Le);
            }
            RefresherView.this.invalidate();
        }

        private void ob() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Lg = ((((float) (uptimeMillis - this.Ld)) / 1000.0f) * this.Lf) + this.Lg;
            if (this.Lg >= this.OO) {
                RefresherView.this.mXOffset = RefresherView.this.OA;
                this.Lh = false;
                RefresherView.this.OG = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.OD;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                }
                if (RefresherView.this.OA == 0 && aVar != null) {
                    aVar.oa();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mXOffset = (int) (RefresherView.this.OA + (this.OO * (1.0f - com.baidu.adp.widget.a.sInterpolator.getInterpolation(this.Lg / this.OO))));
                this.Ld = uptimeMillis;
                this.Le = uptimeMillis + 16;
                removeMessages(1000);
                sendEmptyMessageAtTime(1000, this.Le);
            }
            RefresherView.this.invalidate();
        }
    }
}
