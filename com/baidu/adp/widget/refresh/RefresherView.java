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
    private int Np;
    private int Nq;
    private final int Ow;
    private boolean Pa;
    private final int SC;
    private int SD;
    private final int SE;
    private final int SF;
    private final int SG;
    private View SH;
    private View SJ;
    private final int[] SK;
    private int SL;
    private int SM;
    private int SO;
    private final a SQ;
    private final b SR;
    private IRefreshable.a SS;
    private c ST;
    private com.baidu.adp.widget.e SU;
    private IRefreshable.State SV;
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
        this.Pa = true;
        this.SK = new int[2];
        this.mTempLocation = new int[2];
        this.SV = IRefreshable.State.idle;
        this.SQ = new a();
        this.SR = new b();
        float f = getResources().getDisplayMetrics().density;
        this.SC = (int) ((100.0f * f) + 0.5f);
        this.Ow = (int) ((500.0f * f) + 0.5f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RefresherView);
        this.SD = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_threshold_height, -1);
        if (this.SD == -1) {
            this.SD = (int) ((200.0f * f) + 0.5f);
        }
        this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_max_height, -1);
        if (this.mMaxHeight == -1) {
            this.mMaxHeight = (int) ((f * 400.0f) + 0.5f);
        }
        String string = obtainStyledAttributes.getString(R.styleable.RefresherView_direction);
        if (string == null) {
            this.SU = new e();
        } else if (string.equals("side")) {
            this.SU = new d();
        } else if (string.equals("top")) {
            this.SU = new e();
        }
        this.SE = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_content, -1);
        this.SF = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_head, -1);
        this.SG = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_empty_view, -1);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        if (this.SE == -1) {
            throw new RuntimeException("refresher content id is not set in xml, or call setRefresherContent before add it to a view tree.");
        }
        this.SH = findViewById(this.SE);
        if (this.SH == null) {
            throw new RuntimeException("refresher content not found in the view tree by the content id.");
        }
        if (this.SF == -1) {
            throw new RuntimeException("refresher head id is not set in xml, or call setRefresherHeader before add it to a view tree.");
        }
        this.SJ = findViewById(this.SF);
        if (this.SJ == null) {
            throw new RuntimeException("refresher header not found in the view tree by the header id.");
        }
        if (this.SG == -1) {
            throw new RuntimeException("empty view id is not set in xml, or call setEmptyView before add it to a view tree");
        }
        this.mEmptyView = findViewById(this.SG);
        if (this.mEmptyView == null) {
            throw new RuntimeException("empty view not found in the view tree by the empty view's id");
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.SU.measure(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.SU.a(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.SU.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.SU.l(motionEvent);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.SU.m(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.SU.draw(canvas);
    }

    public void setOnRefreshListener(IRefreshable.a aVar) {
        this.SS = aVar;
    }

    public void setEnable(boolean z) {
        this.Pa = (!z || this.SH == null || this.SJ == null) ? false : true;
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.Pa;
    }

    public IRefreshable.State getState() {
        return this.SV;
    }

    public void refresh() {
        if (this.ST == null || this.ST.getStatus() != BdAsyncTask.BdAsyncTaskStatus.RUNNING) {
            this.ST = new c();
            this.ST.execute(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private boolean OB;
        private long Ox;
        private long Oy;
        private int Oz;
        private int SW;
        private int SX;

        private a() {
        }

        void pI() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.SW = (int) (((((float) (uptimeMillis - this.Ox)) / 1000.0f) * this.Oz) + this.SW);
            if (this.SW >= this.SX) {
                RefresherView.this.mYOffset = RefresherView.this.SO;
                this.OB = false;
                RefresherView.this.SV = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.SS;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                }
                if (RefresherView.this.SO == 0 && aVar != null) {
                    aVar.pH();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mYOffset = (int) (RefresherView.this.SO + (this.SX * (1.0f - com.baidu.adp.widget.a.sInterpolator.getInterpolation(this.SW / this.SX))));
                this.Ox = uptimeMillis;
                this.Oy = uptimeMillis + 16;
                RefresherView.this.SR.removeMessages(1000);
                RefresherView.this.SR.sendEmptyMessageAtTime(1000, this.Oy);
            }
            RefresherView.this.invalidate();
        }

        void pJ() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.SW = (int) (((((float) (uptimeMillis - this.Ox)) / 1000.0f) * this.Oz) + this.SW);
            if (this.SW >= this.SX) {
                RefresherView.this.mYOffset = RefresherView.this.SD;
                this.OB = false;
                RefresherView.this.SV = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.SS;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mYOffset = com.baidu.adp.widget.a.a(this.SX, this.SW, false);
                this.Ox = uptimeMillis;
                this.Oy = uptimeMillis + 16;
                RefresherView.this.SR.removeMessages(1001);
                RefresherView.this.SR.sendEmptyMessageAtTime(1001, this.Oy);
            }
            RefresherView.this.invalidate();
        }

        void aQ(int i) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ox = uptimeMillis;
            this.Oy = uptimeMillis + 16;
            this.OB = true;
            switch (i) {
                case 1000:
                    this.SX = RefresherView.this.mYOffset - RefresherView.this.SO;
                    this.SW = 0;
                    this.Oz = Math.max(RefresherView.this.SC, (RefresherView.this.mYOffset - RefresherView.this.SO) * 2);
                    RefresherView.this.SR.removeMessages(1000);
                    RefresherView.this.SR.sendEmptyMessageAtTime(1000, this.Oy);
                    break;
                case 1001:
                    this.SX = RefresherView.this.SD;
                    this.SW = 0;
                    this.Oz = RefresherView.this.Ow;
                    RefresherView.this.SR.removeMessages(1001);
                    RefresherView.this.SR.sendEmptyMessageAtTime(1001, this.Oy);
                    break;
            }
            RefresherView.this.SV = IRefreshable.State.animating;
            IRefreshable.a aVar = RefresherView.this.SS;
            if (aVar != null) {
                aVar.a(IRefreshable.State.animating);
            }
        }
    }

    public View getRefresherContent() {
        return this.SH;
    }

    public View getRefresherHeader() {
        return this.SJ;
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    public void setRefresherContent(ViewGroup viewGroup) {
        boolean z = false;
        removeView(this.SH);
        this.SH = viewGroup;
        if (this.SH == null) {
            this.Pa = false;
            return;
        }
        addView(this.SH);
        if (this.SJ != null && this.SH != null) {
            z = true;
        }
        this.Pa = z;
    }

    public void setRefresherHeader(View view) {
        boolean z = false;
        removeView(this.SJ);
        this.SJ = view;
        if (this.SJ == null) {
            this.Pa = false;
            return;
        }
        addView(this.SJ);
        if (this.SJ != null && this.SH != null) {
            z = true;
        }
        this.Pa = z;
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
                RefresherView.this.SQ.pI();
            } else if (message.what == 1001) {
                RefresherView.this.SQ.pJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {
        private final IRefreshable.a SZ;

        c() {
            this.SZ = RefresherView.this.SS;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (this.SZ != null) {
                RefresherView.this.SO = RefresherView.this.SD;
                this.SZ.pF();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            RefresherView.this.mRefreshing = true;
            if (this.SZ != null) {
                this.SZ.pG();
                return null;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r3) {
            RefresherView.this.SO = 0;
            RefresherView.this.SU.aQ(1000);
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
            if (RefresherView.this.SH != null) {
                RefresherView.this.measureChild(RefresherView.this.SH, i3 + 1073741824, i4 + 1073741824);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.measureChild(RefresherView.this.mEmptyView, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.SJ != null) {
                RefresherView.this.measureChild(RefresherView.this.SJ, i3 + 1073741824, i4 - 2147483648);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // com.baidu.adp.widget.e
        public void a(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.SH != null) {
                RefresherView.this.SH.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.mEmptyView.layout((i5 - RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (i6 - RefresherView.this.mEmptyView.getMeasuredHeight()) / 2, (RefresherView.this.mEmptyView.getMeasuredWidth() + i5) / 2, (i6 + RefresherView.this.mEmptyView.getMeasuredHeight()) / 2);
            }
            if (RefresherView.this.SJ != null) {
                RefresherView.this.SJ.layout(0, -RefresherView.this.SJ.getMeasuredHeight(), i5, 0);
            }
            RefresherView.this.getLocationOnScreen(RefresherView.this.mTempLocation);
            RefresherView.this.SL = RefresherView.this.mTempLocation[1];
        }

        @Override // com.baidu.adp.widget.f
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mEmptyView, drawingTime);
            }
            canvas.save();
            canvas.translate(0.0f, RefresherView.this.mYOffset / 2);
            RefresherView.this.drawChild(canvas, RefresherView.this.SH, drawingTime);
            if (RefresherView.this.mYOffset > 0) {
                RefresherView.this.drawChild(canvas, RefresherView.this.SJ, drawingTime);
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
            if (!RefresherView.this.Pa || RefresherView.this.mRefreshing) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int y = (int) motionEvent.getY();
            switch (action) {
                case 0:
                    RefresherView.this.Nq = y;
                    RefresherView.this.SR.removeMessages(1000);
                    break;
                case 2:
                    if (!(RefresherView.this.SH instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.SH).getChildAt(0)) == null) {
                        RefresherView.this.SH.getLocationOnScreen(RefresherView.this.SK);
                        if (RefresherView.this.SK[1] == RefresherView.this.SL && y > RefresherView.this.Nq) {
                            RefresherView.this.SV = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.SS;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.SK);
                        if (RefresherView.this.SK[1] == RefresherView.this.SL && y > RefresherView.this.Nq) {
                            RefresherView.this.SV = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar2 = RefresherView.this.SS;
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
                    if (RefresherView.this.mYOffset <= RefresherView.this.SD) {
                        RefresherView.this.SO = 0;
                    } else {
                        RefresherView.this.refresh();
                    }
                    aQ(1000);
                    return true;
                case 2:
                    RefresherView.this.mYOffset = Math.max(0, Math.min(y - RefresherView.this.Nq, RefresherView.this.mMaxHeight * 2));
                    if (RefresherView.this.mYOffset <= RefresherView.this.SD || RefresherView.this.SV != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mYOffset < RefresherView.this.SD && RefresherView.this.SV == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.SV = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.SS;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.SV = IRefreshable.State.pulling_refresh;
                        IRefreshable.a aVar2 = RefresherView.this.SS;
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
        public void aQ(int i) {
            RefresherView.this.SQ.aQ(i);
        }
    }

    /* loaded from: classes.dex */
    private class d extends Handler implements com.baidu.adp.widget.e {
        private float OA;
        private boolean OB;
        private long Ox;
        private long Oy;
        private int Oz;
        private final int Ta;
        private float Tb;

        public d() {
            this.Ta = (int) ((RefresherView.this.getResources().getDisplayMetrics().density * 75.0f) + 0.5d);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1000:
                    pI();
                    return;
                case 1001:
                    pJ();
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.adp.widget.f
        public void measure(int i, int i2) {
            int i3 = i & 1073741823;
            int i4 = 1073741823 & i2;
            if (RefresherView.this.SH != null) {
                RefresherView.this.measureChild(RefresherView.this.SH, i3 + 1073741824, i4 + 1073741824);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.measureChild(RefresherView.this.mEmptyView, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.SJ != null) {
                RefresherView.this.measureChild(RefresherView.this.SJ, i3 - 2147483648, i4 + 1073741824);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // com.baidu.adp.widget.e
        public void a(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.SH != null) {
                RefresherView.this.SH.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.mEmptyView.layout((i5 - RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (i6 - RefresherView.this.mEmptyView.getMeasuredHeight()) / 2, (i5 + RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (RefresherView.this.mEmptyView.getMeasuredHeight() + i6) / 2);
            }
            if (RefresherView.this.SJ != null) {
                RefresherView.this.SJ.layout(-RefresherView.this.SJ.getMeasuredWidth(), 0, 0, i6);
            }
            RefresherView.this.getLocationOnScreen(RefresherView.this.mTempLocation);
            RefresherView.this.SM = RefresherView.this.mTempLocation[0];
        }

        @Override // com.baidu.adp.widget.f
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mEmptyView, drawingTime);
            }
            canvas.save();
            canvas.translate(RefresherView.this.mXOffset >> 1, 0.0f);
            RefresherView.this.drawChild(canvas, RefresherView.this.SH, drawingTime);
            if (RefresherView.this.mXOffset > 0) {
                RefresherView.this.drawChild(canvas, RefresherView.this.SJ, drawingTime);
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
            if (!RefresherView.this.Pa || RefresherView.this.mRefreshing) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            switch (action) {
                case 0:
                    RefresherView.this.Np = x;
                    removeMessages(1000);
                    removeMessages(1001);
                    break;
                case 2:
                    if (!(RefresherView.this.SH instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.SH).getChildAt(0)) == null) {
                        RefresherView.this.SH.getLocationOnScreen(RefresherView.this.SK);
                        if (RefresherView.this.SK[0] == RefresherView.this.SM && x > RefresherView.this.Np + this.Ta) {
                            RefresherView.this.SV = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.SS;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.SK);
                        if (RefresherView.this.SK[0] == RefresherView.this.SM && x > RefresherView.this.Np + this.Ta) {
                            RefresherView.this.SV = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar2 = RefresherView.this.SS;
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
                    if (RefresherView.this.mXOffset <= RefresherView.this.SD) {
                        RefresherView.this.SO = 0;
                    } else {
                        RefresherView.this.refresh();
                    }
                    aQ(1000);
                    return true;
                case 2:
                    RefresherView.this.mXOffset = Math.max(0, Math.min((x - RefresherView.this.Np) - this.Ta, RefresherView.this.mMaxHeight * 2));
                    if (RefresherView.this.mXOffset <= RefresherView.this.SD || RefresherView.this.SV != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mXOffset < RefresherView.this.SD && RefresherView.this.SV == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.SV = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.SS;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.SV = IRefreshable.State.pulling_refresh;
                        IRefreshable.a aVar2 = RefresherView.this.SS;
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
        public void aQ(int i) {
            switch (i) {
                case 1000:
                    pL();
                    return;
                case 1001:
                    pK();
                    return;
                default:
                    return;
            }
        }

        private void pK() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ox = uptimeMillis;
            this.Oy = uptimeMillis + 16;
            this.OB = true;
            this.Tb = RefresherView.this.SD;
            this.OA = 0.0f;
            this.Oz = RefresherView.this.Ow;
            removeMessages(1001);
            sendEmptyMessageAtTime(1001, this.Oy);
        }

        private void pL() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ox = uptimeMillis;
            this.Oy = uptimeMillis + 16;
            this.OB = true;
            this.Tb = RefresherView.this.mXOffset - RefresherView.this.SO;
            this.OA = 0.0f;
            this.Oz = Math.max(RefresherView.this.SC, (RefresherView.this.mXOffset - RefresherView.this.SO) * 2);
            removeMessages(1000);
            sendEmptyMessageAtTime(1000, this.Oy);
        }

        private void pJ() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.OA = ((((float) (uptimeMillis - this.Ox)) / 1000.0f) * this.Oz) + this.OA;
            if (this.OA >= this.Tb) {
                RefresherView.this.mXOffset = RefresherView.this.SD;
                this.OB = false;
                RefresherView.this.SV = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.SS;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mXOffset = com.baidu.adp.widget.a.a(this.Tb, this.OA, false);
                this.Ox = uptimeMillis;
                this.Oy = uptimeMillis + 16;
                removeMessages(1001);
                sendEmptyMessageAtTime(1001, this.Oy);
            }
            RefresherView.this.invalidate();
        }

        private void pI() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.OA = ((((float) (uptimeMillis - this.Ox)) / 1000.0f) * this.Oz) + this.OA;
            if (this.OA >= this.Tb) {
                RefresherView.this.mXOffset = RefresherView.this.SO;
                this.OB = false;
                RefresherView.this.SV = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.SS;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                }
                if (RefresherView.this.SO == 0 && aVar != null) {
                    aVar.pH();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mXOffset = (int) (RefresherView.this.SO + (this.Tb * (1.0f - com.baidu.adp.widget.a.sInterpolator.getInterpolation(this.OA / this.Tb))));
                this.Ox = uptimeMillis;
                this.Oy = uptimeMillis + 16;
                removeMessages(1000);
                sendEmptyMessageAtTime(1000, this.Oy);
            }
            RefresherView.this.invalidate();
        }
    }
}
