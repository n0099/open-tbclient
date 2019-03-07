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
    private int No;
    private int Np;
    private boolean OZ;
    private final int Ov;
    private final int SA;
    private int SB;
    private final int SC;
    private final int SD;
    private final int SE;
    private View SF;
    private View SG;
    private final int[] SH;
    private int SJ;
    private int SK;
    private int SL;
    private final a SM;
    private final b SO;
    private IRefreshable.a SQ;
    private c SR;
    private com.baidu.adp.widget.e SS;
    private IRefreshable.State ST;
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
        this.OZ = true;
        this.SH = new int[2];
        this.mTempLocation = new int[2];
        this.ST = IRefreshable.State.idle;
        this.SM = new a();
        this.SO = new b();
        float f = getResources().getDisplayMetrics().density;
        this.SA = (int) ((100.0f * f) + 0.5f);
        this.Ov = (int) ((500.0f * f) + 0.5f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RefresherView);
        this.SB = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_threshold_height, -1);
        if (this.SB == -1) {
            this.SB = (int) ((200.0f * f) + 0.5f);
        }
        this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_max_height, -1);
        if (this.mMaxHeight == -1) {
            this.mMaxHeight = (int) ((f * 400.0f) + 0.5f);
        }
        String string = obtainStyledAttributes.getString(R.styleable.RefresherView_direction);
        if (string == null) {
            this.SS = new e();
        } else if (string.equals("side")) {
            this.SS = new d();
        } else if (string.equals("top")) {
            this.SS = new e();
        }
        this.SC = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_content, -1);
        this.SD = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_head, -1);
        this.SE = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_empty_view, -1);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        if (this.SC == -1) {
            throw new RuntimeException("refresher content id is not set in xml, or call setRefresherContent before add it to a view tree.");
        }
        this.SF = findViewById(this.SC);
        if (this.SF == null) {
            throw new RuntimeException("refresher content not found in the view tree by the content id.");
        }
        if (this.SD == -1) {
            throw new RuntimeException("refresher head id is not set in xml, or call setRefresherHeader before add it to a view tree.");
        }
        this.SG = findViewById(this.SD);
        if (this.SG == null) {
            throw new RuntimeException("refresher header not found in the view tree by the header id.");
        }
        if (this.SE == -1) {
            throw new RuntimeException("empty view id is not set in xml, or call setEmptyView before add it to a view tree");
        }
        this.mEmptyView = findViewById(this.SE);
        if (this.mEmptyView == null) {
            throw new RuntimeException("empty view not found in the view tree by the empty view's id");
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.SS.measure(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.SS.a(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.SS.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.SS.l(motionEvent);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.SS.m(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.SS.draw(canvas);
    }

    public void setOnRefreshListener(IRefreshable.a aVar) {
        this.SQ = aVar;
    }

    public void setEnable(boolean z) {
        this.OZ = (!z || this.SF == null || this.SG == null) ? false : true;
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.OZ;
    }

    public IRefreshable.State getState() {
        return this.ST;
    }

    public void refresh() {
        if (this.SR == null || this.SR.getStatus() != BdAsyncTask.BdAsyncTaskStatus.RUNNING) {
            this.SR = new c();
            this.SR.execute(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private boolean OA;
        private long Ow;
        private long Ox;
        private int Oy;
        private int SU;
        private int SV;

        private a() {
        }

        void pI() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.SU = (int) (((((float) (uptimeMillis - this.Ow)) / 1000.0f) * this.Oy) + this.SU);
            if (this.SU >= this.SV) {
                RefresherView.this.mYOffset = RefresherView.this.SL;
                this.OA = false;
                RefresherView.this.ST = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.SQ;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                }
                if (RefresherView.this.SL == 0 && aVar != null) {
                    aVar.pH();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mYOffset = (int) (RefresherView.this.SL + (this.SV * (1.0f - com.baidu.adp.widget.a.sInterpolator.getInterpolation(this.SU / this.SV))));
                this.Ow = uptimeMillis;
                this.Ox = uptimeMillis + 16;
                RefresherView.this.SO.removeMessages(1000);
                RefresherView.this.SO.sendEmptyMessageAtTime(1000, this.Ox);
            }
            RefresherView.this.invalidate();
        }

        void pJ() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.SU = (int) (((((float) (uptimeMillis - this.Ow)) / 1000.0f) * this.Oy) + this.SU);
            if (this.SU >= this.SV) {
                RefresherView.this.mYOffset = RefresherView.this.SB;
                this.OA = false;
                RefresherView.this.ST = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.SQ;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mYOffset = com.baidu.adp.widget.a.a(this.SV, this.SU, false);
                this.Ow = uptimeMillis;
                this.Ox = uptimeMillis + 16;
                RefresherView.this.SO.removeMessages(1001);
                RefresherView.this.SO.sendEmptyMessageAtTime(1001, this.Ox);
            }
            RefresherView.this.invalidate();
        }

        void aR(int i) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ow = uptimeMillis;
            this.Ox = uptimeMillis + 16;
            this.OA = true;
            switch (i) {
                case 1000:
                    this.SV = RefresherView.this.mYOffset - RefresherView.this.SL;
                    this.SU = 0;
                    this.Oy = Math.max(RefresherView.this.SA, (RefresherView.this.mYOffset - RefresherView.this.SL) * 2);
                    RefresherView.this.SO.removeMessages(1000);
                    RefresherView.this.SO.sendEmptyMessageAtTime(1000, this.Ox);
                    break;
                case 1001:
                    this.SV = RefresherView.this.SB;
                    this.SU = 0;
                    this.Oy = RefresherView.this.Ov;
                    RefresherView.this.SO.removeMessages(1001);
                    RefresherView.this.SO.sendEmptyMessageAtTime(1001, this.Ox);
                    break;
            }
            RefresherView.this.ST = IRefreshable.State.animating;
            IRefreshable.a aVar = RefresherView.this.SQ;
            if (aVar != null) {
                aVar.a(IRefreshable.State.animating);
            }
        }
    }

    public View getRefresherContent() {
        return this.SF;
    }

    public View getRefresherHeader() {
        return this.SG;
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    public void setRefresherContent(ViewGroup viewGroup) {
        boolean z = false;
        removeView(this.SF);
        this.SF = viewGroup;
        if (this.SF == null) {
            this.OZ = false;
            return;
        }
        addView(this.SF);
        if (this.SG != null && this.SF != null) {
            z = true;
        }
        this.OZ = z;
    }

    public void setRefresherHeader(View view) {
        boolean z = false;
        removeView(this.SG);
        this.SG = view;
        if (this.SG == null) {
            this.OZ = false;
            return;
        }
        addView(this.SG);
        if (this.SG != null && this.SF != null) {
            z = true;
        }
        this.OZ = z;
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
                RefresherView.this.SM.pI();
            } else if (message.what == 1001) {
                RefresherView.this.SM.pJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {
        private final IRefreshable.a SX;

        c() {
            this.SX = RefresherView.this.SQ;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (this.SX != null) {
                RefresherView.this.SL = RefresherView.this.SB;
                this.SX.pF();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            RefresherView.this.mRefreshing = true;
            if (this.SX != null) {
                this.SX.pG();
                return null;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r3) {
            RefresherView.this.SL = 0;
            RefresherView.this.SS.aR(1000);
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
            if (RefresherView.this.SF != null) {
                RefresherView.this.measureChild(RefresherView.this.SF, i3 + 1073741824, i4 + 1073741824);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.measureChild(RefresherView.this.mEmptyView, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.SG != null) {
                RefresherView.this.measureChild(RefresherView.this.SG, i3 + 1073741824, i4 - 2147483648);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // com.baidu.adp.widget.e
        public void a(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.SF != null) {
                RefresherView.this.SF.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.mEmptyView.layout((i5 - RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (i6 - RefresherView.this.mEmptyView.getMeasuredHeight()) / 2, (RefresherView.this.mEmptyView.getMeasuredWidth() + i5) / 2, (i6 + RefresherView.this.mEmptyView.getMeasuredHeight()) / 2);
            }
            if (RefresherView.this.SG != null) {
                RefresherView.this.SG.layout(0, -RefresherView.this.SG.getMeasuredHeight(), i5, 0);
            }
            RefresherView.this.getLocationOnScreen(RefresherView.this.mTempLocation);
            RefresherView.this.SJ = RefresherView.this.mTempLocation[1];
        }

        @Override // com.baidu.adp.widget.f
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mEmptyView, drawingTime);
            }
            canvas.save();
            canvas.translate(0.0f, RefresherView.this.mYOffset / 2);
            RefresherView.this.drawChild(canvas, RefresherView.this.SF, drawingTime);
            if (RefresherView.this.mYOffset > 0) {
                RefresherView.this.drawChild(canvas, RefresherView.this.SG, drawingTime);
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
            if (!RefresherView.this.OZ || RefresherView.this.mRefreshing) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int y = (int) motionEvent.getY();
            switch (action) {
                case 0:
                    RefresherView.this.Np = y;
                    RefresherView.this.SO.removeMessages(1000);
                    break;
                case 2:
                    if (!(RefresherView.this.SF instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.SF).getChildAt(0)) == null) {
                        RefresherView.this.SF.getLocationOnScreen(RefresherView.this.SH);
                        if (RefresherView.this.SH[1] == RefresherView.this.SJ && y > RefresherView.this.Np) {
                            RefresherView.this.ST = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.SQ;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.SH);
                        if (RefresherView.this.SH[1] == RefresherView.this.SJ && y > RefresherView.this.Np) {
                            RefresherView.this.ST = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar2 = RefresherView.this.SQ;
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
                    if (RefresherView.this.mYOffset <= RefresherView.this.SB) {
                        RefresherView.this.SL = 0;
                    } else {
                        RefresherView.this.refresh();
                    }
                    aR(1000);
                    return true;
                case 2:
                    RefresherView.this.mYOffset = Math.max(0, Math.min(y - RefresherView.this.Np, RefresherView.this.mMaxHeight * 2));
                    if (RefresherView.this.mYOffset <= RefresherView.this.SB || RefresherView.this.ST != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mYOffset < RefresherView.this.SB && RefresherView.this.ST == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.ST = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.SQ;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.ST = IRefreshable.State.pulling_refresh;
                        IRefreshable.a aVar2 = RefresherView.this.SQ;
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
            RefresherView.this.SM.aR(i);
        }
    }

    /* loaded from: classes.dex */
    private class d extends Handler implements com.baidu.adp.widget.e {
        private boolean OA;
        private long Ow;
        private long Ox;
        private int Oy;
        private float Oz;
        private final int SY;
        private float SZ;

        public d() {
            this.SY = (int) ((RefresherView.this.getResources().getDisplayMetrics().density * 75.0f) + 0.5d);
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
            if (RefresherView.this.SF != null) {
                RefresherView.this.measureChild(RefresherView.this.SF, i3 + 1073741824, i4 + 1073741824);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.measureChild(RefresherView.this.mEmptyView, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.SG != null) {
                RefresherView.this.measureChild(RefresherView.this.SG, i3 - 2147483648, i4 + 1073741824);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // com.baidu.adp.widget.e
        public void a(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.SF != null) {
                RefresherView.this.SF.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.mEmptyView.layout((i5 - RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (i6 - RefresherView.this.mEmptyView.getMeasuredHeight()) / 2, (i5 + RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (RefresherView.this.mEmptyView.getMeasuredHeight() + i6) / 2);
            }
            if (RefresherView.this.SG != null) {
                RefresherView.this.SG.layout(-RefresherView.this.SG.getMeasuredWidth(), 0, 0, i6);
            }
            RefresherView.this.getLocationOnScreen(RefresherView.this.mTempLocation);
            RefresherView.this.SK = RefresherView.this.mTempLocation[0];
        }

        @Override // com.baidu.adp.widget.f
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mEmptyView, drawingTime);
            }
            canvas.save();
            canvas.translate(RefresherView.this.mXOffset >> 1, 0.0f);
            RefresherView.this.drawChild(canvas, RefresherView.this.SF, drawingTime);
            if (RefresherView.this.mXOffset > 0) {
                RefresherView.this.drawChild(canvas, RefresherView.this.SG, drawingTime);
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
            if (!RefresherView.this.OZ || RefresherView.this.mRefreshing) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            switch (action) {
                case 0:
                    RefresherView.this.No = x;
                    removeMessages(1000);
                    removeMessages(1001);
                    break;
                case 2:
                    if (!(RefresherView.this.SF instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.SF).getChildAt(0)) == null) {
                        RefresherView.this.SF.getLocationOnScreen(RefresherView.this.SH);
                        if (RefresherView.this.SH[0] == RefresherView.this.SK && x > RefresherView.this.No + this.SY) {
                            RefresherView.this.ST = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.SQ;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.SH);
                        if (RefresherView.this.SH[0] == RefresherView.this.SK && x > RefresherView.this.No + this.SY) {
                            RefresherView.this.ST = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar2 = RefresherView.this.SQ;
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
                    if (RefresherView.this.mXOffset <= RefresherView.this.SB) {
                        RefresherView.this.SL = 0;
                    } else {
                        RefresherView.this.refresh();
                    }
                    aR(1000);
                    return true;
                case 2:
                    RefresherView.this.mXOffset = Math.max(0, Math.min((x - RefresherView.this.No) - this.SY, RefresherView.this.mMaxHeight * 2));
                    if (RefresherView.this.mXOffset <= RefresherView.this.SB || RefresherView.this.ST != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mXOffset < RefresherView.this.SB && RefresherView.this.ST == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.ST = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.SQ;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.ST = IRefreshable.State.pulling_refresh;
                        IRefreshable.a aVar2 = RefresherView.this.SQ;
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
            this.Ow = uptimeMillis;
            this.Ox = uptimeMillis + 16;
            this.OA = true;
            this.SZ = RefresherView.this.SB;
            this.Oz = 0.0f;
            this.Oy = RefresherView.this.Ov;
            removeMessages(1001);
            sendEmptyMessageAtTime(1001, this.Ox);
        }

        private void pL() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ow = uptimeMillis;
            this.Ox = uptimeMillis + 16;
            this.OA = true;
            this.SZ = RefresherView.this.mXOffset - RefresherView.this.SL;
            this.Oz = 0.0f;
            this.Oy = Math.max(RefresherView.this.SA, (RefresherView.this.mXOffset - RefresherView.this.SL) * 2);
            removeMessages(1000);
            sendEmptyMessageAtTime(1000, this.Ox);
        }

        private void pJ() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Oz = ((((float) (uptimeMillis - this.Ow)) / 1000.0f) * this.Oy) + this.Oz;
            if (this.Oz >= this.SZ) {
                RefresherView.this.mXOffset = RefresherView.this.SB;
                this.OA = false;
                RefresherView.this.ST = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.SQ;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mXOffset = com.baidu.adp.widget.a.a(this.SZ, this.Oz, false);
                this.Ow = uptimeMillis;
                this.Ox = uptimeMillis + 16;
                removeMessages(1001);
                sendEmptyMessageAtTime(1001, this.Ox);
            }
            RefresherView.this.invalidate();
        }

        private void pI() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Oz = ((((float) (uptimeMillis - this.Ow)) / 1000.0f) * this.Oy) + this.Oz;
            if (this.Oz >= this.SZ) {
                RefresherView.this.mXOffset = RefresherView.this.SL;
                this.OA = false;
                RefresherView.this.ST = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.SQ;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                }
                if (RefresherView.this.SL == 0 && aVar != null) {
                    aVar.pH();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mXOffset = (int) (RefresherView.this.SL + (this.SZ * (1.0f - com.baidu.adp.widget.a.sInterpolator.getInterpolation(this.Oz / this.SZ))));
                this.Ow = uptimeMillis;
                this.Ox = uptimeMillis + 16;
                removeMessages(1000);
                sendEmptyMessageAtTime(1000, this.Ox);
            }
            RefresherView.this.invalidate();
        }
    }
}
