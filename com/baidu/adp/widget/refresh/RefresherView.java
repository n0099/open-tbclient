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
    private final int SB;
    private int SC;
    private final int SD;
    private final int SE;
    private final int SF;
    private View SG;
    private View SH;
    private final int[] SJ;
    private int SK;
    private int SL;
    private int SM;
    private final a SO;
    private final b SQ;
    private IRefreshable.a SR;
    private c SS;
    private com.baidu.adp.widget.e ST;
    private IRefreshable.State SU;
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
        this.SJ = new int[2];
        this.mTempLocation = new int[2];
        this.SU = IRefreshable.State.idle;
        this.SO = new a();
        this.SQ = new b();
        float f = getResources().getDisplayMetrics().density;
        this.SB = (int) ((100.0f * f) + 0.5f);
        this.Ow = (int) ((500.0f * f) + 0.5f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RefresherView);
        this.SC = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_threshold_height, -1);
        if (this.SC == -1) {
            this.SC = (int) ((200.0f * f) + 0.5f);
        }
        this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_max_height, -1);
        if (this.mMaxHeight == -1) {
            this.mMaxHeight = (int) ((f * 400.0f) + 0.5f);
        }
        String string = obtainStyledAttributes.getString(R.styleable.RefresherView_direction);
        if (string == null) {
            this.ST = new e();
        } else if (string.equals("side")) {
            this.ST = new d();
        } else if (string.equals("top")) {
            this.ST = new e();
        }
        this.SD = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_content, -1);
        this.SE = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_head, -1);
        this.SF = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_empty_view, -1);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        if (this.SD == -1) {
            throw new RuntimeException("refresher content id is not set in xml, or call setRefresherContent before add it to a view tree.");
        }
        this.SG = findViewById(this.SD);
        if (this.SG == null) {
            throw new RuntimeException("refresher content not found in the view tree by the content id.");
        }
        if (this.SE == -1) {
            throw new RuntimeException("refresher head id is not set in xml, or call setRefresherHeader before add it to a view tree.");
        }
        this.SH = findViewById(this.SE);
        if (this.SH == null) {
            throw new RuntimeException("refresher header not found in the view tree by the header id.");
        }
        if (this.SF == -1) {
            throw new RuntimeException("empty view id is not set in xml, or call setEmptyView before add it to a view tree");
        }
        this.mEmptyView = findViewById(this.SF);
        if (this.mEmptyView == null) {
            throw new RuntimeException("empty view not found in the view tree by the empty view's id");
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.ST.measure(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.ST.a(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.ST.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.ST.l(motionEvent);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.ST.m(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.ST.draw(canvas);
    }

    public void setOnRefreshListener(IRefreshable.a aVar) {
        this.SR = aVar;
    }

    public void setEnable(boolean z) {
        this.Pa = (!z || this.SG == null || this.SH == null) ? false : true;
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.Pa;
    }

    public IRefreshable.State getState() {
        return this.SU;
    }

    public void refresh() {
        if (this.SS == null || this.SS.getStatus() != BdAsyncTask.BdAsyncTaskStatus.RUNNING) {
            this.SS = new c();
            this.SS.execute(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private boolean OB;
        private long Ox;
        private long Oy;
        private int Oz;
        private int SV;
        private int SW;

        private a() {
        }

        void pI() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.SV = (int) (((((float) (uptimeMillis - this.Ox)) / 1000.0f) * this.Oz) + this.SV);
            if (this.SV >= this.SW) {
                RefresherView.this.mYOffset = RefresherView.this.SM;
                this.OB = false;
                RefresherView.this.SU = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.SR;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                }
                if (RefresherView.this.SM == 0 && aVar != null) {
                    aVar.pH();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mYOffset = (int) (RefresherView.this.SM + (this.SW * (1.0f - com.baidu.adp.widget.a.sInterpolator.getInterpolation(this.SV / this.SW))));
                this.Ox = uptimeMillis;
                this.Oy = uptimeMillis + 16;
                RefresherView.this.SQ.removeMessages(1000);
                RefresherView.this.SQ.sendEmptyMessageAtTime(1000, this.Oy);
            }
            RefresherView.this.invalidate();
        }

        void pJ() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.SV = (int) (((((float) (uptimeMillis - this.Ox)) / 1000.0f) * this.Oz) + this.SV);
            if (this.SV >= this.SW) {
                RefresherView.this.mYOffset = RefresherView.this.SC;
                this.OB = false;
                RefresherView.this.SU = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.SR;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mYOffset = com.baidu.adp.widget.a.a(this.SW, this.SV, false);
                this.Ox = uptimeMillis;
                this.Oy = uptimeMillis + 16;
                RefresherView.this.SQ.removeMessages(1001);
                RefresherView.this.SQ.sendEmptyMessageAtTime(1001, this.Oy);
            }
            RefresherView.this.invalidate();
        }

        void aR(int i) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ox = uptimeMillis;
            this.Oy = uptimeMillis + 16;
            this.OB = true;
            switch (i) {
                case 1000:
                    this.SW = RefresherView.this.mYOffset - RefresherView.this.SM;
                    this.SV = 0;
                    this.Oz = Math.max(RefresherView.this.SB, (RefresherView.this.mYOffset - RefresherView.this.SM) * 2);
                    RefresherView.this.SQ.removeMessages(1000);
                    RefresherView.this.SQ.sendEmptyMessageAtTime(1000, this.Oy);
                    break;
                case 1001:
                    this.SW = RefresherView.this.SC;
                    this.SV = 0;
                    this.Oz = RefresherView.this.Ow;
                    RefresherView.this.SQ.removeMessages(1001);
                    RefresherView.this.SQ.sendEmptyMessageAtTime(1001, this.Oy);
                    break;
            }
            RefresherView.this.SU = IRefreshable.State.animating;
            IRefreshable.a aVar = RefresherView.this.SR;
            if (aVar != null) {
                aVar.a(IRefreshable.State.animating);
            }
        }
    }

    public View getRefresherContent() {
        return this.SG;
    }

    public View getRefresherHeader() {
        return this.SH;
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    public void setRefresherContent(ViewGroup viewGroup) {
        boolean z = false;
        removeView(this.SG);
        this.SG = viewGroup;
        if (this.SG == null) {
            this.Pa = false;
            return;
        }
        addView(this.SG);
        if (this.SH != null && this.SG != null) {
            z = true;
        }
        this.Pa = z;
    }

    public void setRefresherHeader(View view) {
        boolean z = false;
        removeView(this.SH);
        this.SH = view;
        if (this.SH == null) {
            this.Pa = false;
            return;
        }
        addView(this.SH);
        if (this.SH != null && this.SG != null) {
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
                RefresherView.this.SO.pI();
            } else if (message.what == 1001) {
                RefresherView.this.SO.pJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {
        private final IRefreshable.a SY;

        c() {
            this.SY = RefresherView.this.SR;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (this.SY != null) {
                RefresherView.this.SM = RefresherView.this.SC;
                this.SY.pF();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            RefresherView.this.mRefreshing = true;
            if (this.SY != null) {
                this.SY.pG();
                return null;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r3) {
            RefresherView.this.SM = 0;
            RefresherView.this.ST.aR(1000);
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
            if (RefresherView.this.SG != null) {
                RefresherView.this.measureChild(RefresherView.this.SG, i3 + 1073741824, i4 + 1073741824);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.measureChild(RefresherView.this.mEmptyView, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.SH != null) {
                RefresherView.this.measureChild(RefresherView.this.SH, i3 + 1073741824, i4 - 2147483648);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // com.baidu.adp.widget.e
        public void a(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.SG != null) {
                RefresherView.this.SG.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.mEmptyView.layout((i5 - RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (i6 - RefresherView.this.mEmptyView.getMeasuredHeight()) / 2, (RefresherView.this.mEmptyView.getMeasuredWidth() + i5) / 2, (i6 + RefresherView.this.mEmptyView.getMeasuredHeight()) / 2);
            }
            if (RefresherView.this.SH != null) {
                RefresherView.this.SH.layout(0, -RefresherView.this.SH.getMeasuredHeight(), i5, 0);
            }
            RefresherView.this.getLocationOnScreen(RefresherView.this.mTempLocation);
            RefresherView.this.SK = RefresherView.this.mTempLocation[1];
        }

        @Override // com.baidu.adp.widget.f
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mEmptyView, drawingTime);
            }
            canvas.save();
            canvas.translate(0.0f, RefresherView.this.mYOffset / 2);
            RefresherView.this.drawChild(canvas, RefresherView.this.SG, drawingTime);
            if (RefresherView.this.mYOffset > 0) {
                RefresherView.this.drawChild(canvas, RefresherView.this.SH, drawingTime);
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
                    RefresherView.this.SQ.removeMessages(1000);
                    break;
                case 2:
                    if (!(RefresherView.this.SG instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.SG).getChildAt(0)) == null) {
                        RefresherView.this.SG.getLocationOnScreen(RefresherView.this.SJ);
                        if (RefresherView.this.SJ[1] == RefresherView.this.SK && y > RefresherView.this.Nq) {
                            RefresherView.this.SU = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.SR;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.SJ);
                        if (RefresherView.this.SJ[1] == RefresherView.this.SK && y > RefresherView.this.Nq) {
                            RefresherView.this.SU = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar2 = RefresherView.this.SR;
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
                    if (RefresherView.this.mYOffset <= RefresherView.this.SC) {
                        RefresherView.this.SM = 0;
                    } else {
                        RefresherView.this.refresh();
                    }
                    aR(1000);
                    return true;
                case 2:
                    RefresherView.this.mYOffset = Math.max(0, Math.min(y - RefresherView.this.Nq, RefresherView.this.mMaxHeight * 2));
                    if (RefresherView.this.mYOffset <= RefresherView.this.SC || RefresherView.this.SU != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mYOffset < RefresherView.this.SC && RefresherView.this.SU == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.SU = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.SR;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.SU = IRefreshable.State.pulling_refresh;
                        IRefreshable.a aVar2 = RefresherView.this.SR;
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
        public void aR(int i) {
            RefresherView.this.SO.aR(i);
        }
    }

    /* loaded from: classes.dex */
    private class d extends Handler implements com.baidu.adp.widget.e {
        private float OA;
        private boolean OB;
        private long Ox;
        private long Oy;
        private int Oz;
        private final int SZ;
        private float Ta;

        public d() {
            this.SZ = (int) ((RefresherView.this.getResources().getDisplayMetrics().density * 75.0f) + 0.5d);
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
            if (RefresherView.this.SG != null) {
                RefresherView.this.measureChild(RefresherView.this.SG, i3 + 1073741824, i4 + 1073741824);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.measureChild(RefresherView.this.mEmptyView, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.SH != null) {
                RefresherView.this.measureChild(RefresherView.this.SH, i3 - 2147483648, i4 + 1073741824);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // com.baidu.adp.widget.e
        public void a(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.SG != null) {
                RefresherView.this.SG.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.mEmptyView.layout((i5 - RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (i6 - RefresherView.this.mEmptyView.getMeasuredHeight()) / 2, (i5 + RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (RefresherView.this.mEmptyView.getMeasuredHeight() + i6) / 2);
            }
            if (RefresherView.this.SH != null) {
                RefresherView.this.SH.layout(-RefresherView.this.SH.getMeasuredWidth(), 0, 0, i6);
            }
            RefresherView.this.getLocationOnScreen(RefresherView.this.mTempLocation);
            RefresherView.this.SL = RefresherView.this.mTempLocation[0];
        }

        @Override // com.baidu.adp.widget.f
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mEmptyView, drawingTime);
            }
            canvas.save();
            canvas.translate(RefresherView.this.mXOffset >> 1, 0.0f);
            RefresherView.this.drawChild(canvas, RefresherView.this.SG, drawingTime);
            if (RefresherView.this.mXOffset > 0) {
                RefresherView.this.drawChild(canvas, RefresherView.this.SH, drawingTime);
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
                    if (!(RefresherView.this.SG instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.SG).getChildAt(0)) == null) {
                        RefresherView.this.SG.getLocationOnScreen(RefresherView.this.SJ);
                        if (RefresherView.this.SJ[0] == RefresherView.this.SL && x > RefresherView.this.Np + this.SZ) {
                            RefresherView.this.SU = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.SR;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.SJ);
                        if (RefresherView.this.SJ[0] == RefresherView.this.SL && x > RefresherView.this.Np + this.SZ) {
                            RefresherView.this.SU = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar2 = RefresherView.this.SR;
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
                    if (RefresherView.this.mXOffset <= RefresherView.this.SC) {
                        RefresherView.this.SM = 0;
                    } else {
                        RefresherView.this.refresh();
                    }
                    aR(1000);
                    return true;
                case 2:
                    RefresherView.this.mXOffset = Math.max(0, Math.min((x - RefresherView.this.Np) - this.SZ, RefresherView.this.mMaxHeight * 2));
                    if (RefresherView.this.mXOffset <= RefresherView.this.SC || RefresherView.this.SU != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mXOffset < RefresherView.this.SC && RefresherView.this.SU == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.SU = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.SR;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.SU = IRefreshable.State.pulling_refresh;
                        IRefreshable.a aVar2 = RefresherView.this.SR;
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
        public void aR(int i) {
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
            this.Ta = RefresherView.this.SC;
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
            this.Ta = RefresherView.this.mXOffset - RefresherView.this.SM;
            this.OA = 0.0f;
            this.Oz = Math.max(RefresherView.this.SB, (RefresherView.this.mXOffset - RefresherView.this.SM) * 2);
            removeMessages(1000);
            sendEmptyMessageAtTime(1000, this.Oy);
        }

        private void pJ() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.OA = ((((float) (uptimeMillis - this.Ox)) / 1000.0f) * this.Oz) + this.OA;
            if (this.OA >= this.Ta) {
                RefresherView.this.mXOffset = RefresherView.this.SC;
                this.OB = false;
                RefresherView.this.SU = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.SR;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mXOffset = com.baidu.adp.widget.a.a(this.Ta, this.OA, false);
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
            if (this.OA >= this.Ta) {
                RefresherView.this.mXOffset = RefresherView.this.SM;
                this.OB = false;
                RefresherView.this.SU = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.SR;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                }
                if (RefresherView.this.SM == 0 && aVar != null) {
                    aVar.pH();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mXOffset = (int) (RefresherView.this.SM + (this.Ta * (1.0f - com.baidu.adp.widget.a.sInterpolator.getInterpolation(this.OA / this.Ta))));
                this.Ox = uptimeMillis;
                this.Oy = uptimeMillis + 16;
                removeMessages(1000);
                sendEmptyMessageAtTime(1000, this.Oy);
            }
            RefresherView.this.invalidate();
        }
    }
}
