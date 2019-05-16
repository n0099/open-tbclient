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
    private int KZ;
    private int La;
    private boolean MH;
    private final int Mg;
    private IRefreshable.a QB;
    private c QC;
    private com.baidu.adp.widget.e QD;
    private IRefreshable.State QE;
    private final int Qn;
    private int Qo;
    private final int Qp;
    private final int Qq;
    private final int Qr;
    private View Qs;
    private View Qt;
    private final int[] Qu;
    private int Qv;
    private int Qw;
    private int Qx;
    private final a Qy;
    private final b Qz;
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
        this.MH = true;
        this.Qu = new int[2];
        this.mTempLocation = new int[2];
        this.QE = IRefreshable.State.idle;
        this.Qy = new a();
        this.Qz = new b();
        float f = getResources().getDisplayMetrics().density;
        this.Qn = (int) ((100.0f * f) + 0.5f);
        this.Mg = (int) ((500.0f * f) + 0.5f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RefresherView);
        this.Qo = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_threshold_height, -1);
        if (this.Qo == -1) {
            this.Qo = (int) ((200.0f * f) + 0.5f);
        }
        this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_max_height, -1);
        if (this.mMaxHeight == -1) {
            this.mMaxHeight = (int) ((f * 400.0f) + 0.5f);
        }
        String string = obtainStyledAttributes.getString(R.styleable.RefresherView_direction);
        if (string == null) {
            this.QD = new e();
        } else if (string.equals("side")) {
            this.QD = new d();
        } else if (string.equals("top")) {
            this.QD = new e();
        }
        this.Qp = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_content, -1);
        this.Qq = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_head, -1);
        this.Qr = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_empty_view, -1);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        if (this.Qp == -1) {
            throw new RuntimeException("refresher content id is not set in xml, or call setRefresherContent before add it to a view tree.");
        }
        this.Qs = findViewById(this.Qp);
        if (this.Qs == null) {
            throw new RuntimeException("refresher content not found in the view tree by the content id.");
        }
        if (this.Qq == -1) {
            throw new RuntimeException("refresher head id is not set in xml, or call setRefresherHeader before add it to a view tree.");
        }
        this.Qt = findViewById(this.Qq);
        if (this.Qt == null) {
            throw new RuntimeException("refresher header not found in the view tree by the header id.");
        }
        if (this.Qr == -1) {
            throw new RuntimeException("empty view id is not set in xml, or call setEmptyView before add it to a view tree");
        }
        this.mEmptyView = findViewById(this.Qr);
        if (this.mEmptyView == null) {
            throw new RuntimeException("empty view not found in the view tree by the empty view's id");
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.QD.measure(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.QD.a(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.QD.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.QD.l(motionEvent);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.QD.m(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.QD.draw(canvas);
    }

    public void setOnRefreshListener(IRefreshable.a aVar) {
        this.QB = aVar;
    }

    public void setEnable(boolean z) {
        this.MH = (!z || this.Qs == null || this.Qt == null) ? false : true;
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.MH;
    }

    public IRefreshable.State getState() {
        return this.QE;
    }

    public void refresh() {
        if (this.QC == null || this.QC.getStatus() != BdAsyncTask.BdAsyncTaskStatus.RUNNING) {
            this.QC = new c();
            this.QC.execute(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private long Mh;
        private long Mi;
        private int Mj;
        private boolean Ml;
        private int QF;
        private int QG;

        private a() {
        }

        void oD() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.QF = (int) (((((float) (uptimeMillis - this.Mh)) / 1000.0f) * this.Mj) + this.QF);
            if (this.QF >= this.QG) {
                RefresherView.this.mYOffset = RefresherView.this.Qx;
                this.Ml = false;
                RefresherView.this.QE = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.QB;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                }
                if (RefresherView.this.Qx == 0 && aVar != null) {
                    aVar.oC();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mYOffset = (int) (RefresherView.this.Qx + (this.QG * (1.0f - com.baidu.adp.widget.a.sInterpolator.getInterpolation(this.QF / this.QG))));
                this.Mh = uptimeMillis;
                this.Mi = uptimeMillis + 16;
                RefresherView.this.Qz.removeMessages(1000);
                RefresherView.this.Qz.sendEmptyMessageAtTime(1000, this.Mi);
            }
            RefresherView.this.invalidate();
        }

        void oE() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.QF = (int) (((((float) (uptimeMillis - this.Mh)) / 1000.0f) * this.Mj) + this.QF);
            if (this.QF >= this.QG) {
                RefresherView.this.mYOffset = RefresherView.this.Qo;
                this.Ml = false;
                RefresherView.this.QE = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.QB;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mYOffset = com.baidu.adp.widget.a.a(this.QG, this.QF, false);
                this.Mh = uptimeMillis;
                this.Mi = uptimeMillis + 16;
                RefresherView.this.Qz.removeMessages(1001);
                RefresherView.this.Qz.sendEmptyMessageAtTime(1001, this.Mi);
            }
            RefresherView.this.invalidate();
        }

        void aJ(int i) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Mh = uptimeMillis;
            this.Mi = uptimeMillis + 16;
            this.Ml = true;
            switch (i) {
                case 1000:
                    this.QG = RefresherView.this.mYOffset - RefresherView.this.Qx;
                    this.QF = 0;
                    this.Mj = Math.max(RefresherView.this.Qn, (RefresherView.this.mYOffset - RefresherView.this.Qx) * 2);
                    RefresherView.this.Qz.removeMessages(1000);
                    RefresherView.this.Qz.sendEmptyMessageAtTime(1000, this.Mi);
                    break;
                case 1001:
                    this.QG = RefresherView.this.Qo;
                    this.QF = 0;
                    this.Mj = RefresherView.this.Mg;
                    RefresherView.this.Qz.removeMessages(1001);
                    RefresherView.this.Qz.sendEmptyMessageAtTime(1001, this.Mi);
                    break;
            }
            RefresherView.this.QE = IRefreshable.State.animating;
            IRefreshable.a aVar = RefresherView.this.QB;
            if (aVar != null) {
                aVar.a(IRefreshable.State.animating);
            }
        }
    }

    public View getRefresherContent() {
        return this.Qs;
    }

    public View getRefresherHeader() {
        return this.Qt;
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    public void setRefresherContent(ViewGroup viewGroup) {
        boolean z = false;
        removeView(this.Qs);
        this.Qs = viewGroup;
        if (this.Qs == null) {
            this.MH = false;
            return;
        }
        addView(this.Qs);
        if (this.Qt != null && this.Qs != null) {
            z = true;
        }
        this.MH = z;
    }

    public void setRefresherHeader(View view) {
        boolean z = false;
        removeView(this.Qt);
        this.Qt = view;
        if (this.Qt == null) {
            this.MH = false;
            return;
        }
        addView(this.Qt);
        if (this.Qt != null && this.Qs != null) {
            z = true;
        }
        this.MH = z;
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
                RefresherView.this.Qy.oD();
            } else if (message.what == 1001) {
                RefresherView.this.Qy.oE();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {
        private final IRefreshable.a QI;

        c() {
            this.QI = RefresherView.this.QB;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (this.QI != null) {
                RefresherView.this.Qx = RefresherView.this.Qo;
                this.QI.oA();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            RefresherView.this.mRefreshing = true;
            if (this.QI != null) {
                this.QI.oB();
                return null;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r3) {
            RefresherView.this.Qx = 0;
            RefresherView.this.QD.aJ(1000);
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
            if (RefresherView.this.Qs != null) {
                RefresherView.this.measureChild(RefresherView.this.Qs, i3 + 1073741824, i4 + 1073741824);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.measureChild(RefresherView.this.mEmptyView, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.Qt != null) {
                RefresherView.this.measureChild(RefresherView.this.Qt, i3 + 1073741824, i4 - 2147483648);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // com.baidu.adp.widget.e
        public void a(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.Qs != null) {
                RefresherView.this.Qs.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.mEmptyView.layout((i5 - RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (i6 - RefresherView.this.mEmptyView.getMeasuredHeight()) / 2, (RefresherView.this.mEmptyView.getMeasuredWidth() + i5) / 2, (i6 + RefresherView.this.mEmptyView.getMeasuredHeight()) / 2);
            }
            if (RefresherView.this.Qt != null) {
                RefresherView.this.Qt.layout(0, -RefresherView.this.Qt.getMeasuredHeight(), i5, 0);
            }
            RefresherView.this.getLocationOnScreen(RefresherView.this.mTempLocation);
            RefresherView.this.Qv = RefresherView.this.mTempLocation[1];
        }

        @Override // com.baidu.adp.widget.f
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mEmptyView, drawingTime);
            }
            canvas.save();
            canvas.translate(0.0f, RefresherView.this.mYOffset / 2);
            RefresherView.this.drawChild(canvas, RefresherView.this.Qs, drawingTime);
            if (RefresherView.this.mYOffset > 0) {
                RefresherView.this.drawChild(canvas, RefresherView.this.Qt, drawingTime);
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
            if (!RefresherView.this.MH || RefresherView.this.mRefreshing) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int y = (int) motionEvent.getY();
            switch (action) {
                case 0:
                    RefresherView.this.La = y;
                    RefresherView.this.Qz.removeMessages(1000);
                    break;
                case 2:
                    if (!(RefresherView.this.Qs instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.Qs).getChildAt(0)) == null) {
                        RefresherView.this.Qs.getLocationOnScreen(RefresherView.this.Qu);
                        if (RefresherView.this.Qu[1] == RefresherView.this.Qv && y > RefresherView.this.La) {
                            RefresherView.this.QE = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.QB;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.Qu);
                        if (RefresherView.this.Qu[1] == RefresherView.this.Qv && y > RefresherView.this.La) {
                            RefresherView.this.QE = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar2 = RefresherView.this.QB;
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
                    if (RefresherView.this.mYOffset <= RefresherView.this.Qo) {
                        RefresherView.this.Qx = 0;
                    } else {
                        RefresherView.this.refresh();
                    }
                    aJ(1000);
                    return true;
                case 2:
                    RefresherView.this.mYOffset = Math.max(0, Math.min(y - RefresherView.this.La, RefresherView.this.mMaxHeight * 2));
                    if (RefresherView.this.mYOffset <= RefresherView.this.Qo || RefresherView.this.QE != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mYOffset < RefresherView.this.Qo && RefresherView.this.QE == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.QE = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.QB;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.QE = IRefreshable.State.pulling_refresh;
                        IRefreshable.a aVar2 = RefresherView.this.QB;
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
        public void aJ(int i) {
            RefresherView.this.Qy.aJ(i);
        }
    }

    /* loaded from: classes.dex */
    private class d extends Handler implements com.baidu.adp.widget.e {
        private long Mh;
        private long Mi;
        private int Mj;
        private float Mk;
        private boolean Ml;
        private final int QJ;
        private float QK;

        public d() {
            this.QJ = (int) ((RefresherView.this.getResources().getDisplayMetrics().density * 75.0f) + 0.5d);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1000:
                    oD();
                    return;
                case 1001:
                    oE();
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.adp.widget.f
        public void measure(int i, int i2) {
            int i3 = i & 1073741823;
            int i4 = 1073741823 & i2;
            if (RefresherView.this.Qs != null) {
                RefresherView.this.measureChild(RefresherView.this.Qs, i3 + 1073741824, i4 + 1073741824);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.measureChild(RefresherView.this.mEmptyView, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.Qt != null) {
                RefresherView.this.measureChild(RefresherView.this.Qt, i3 - 2147483648, i4 + 1073741824);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // com.baidu.adp.widget.e
        public void a(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.Qs != null) {
                RefresherView.this.Qs.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.mEmptyView.layout((i5 - RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (i6 - RefresherView.this.mEmptyView.getMeasuredHeight()) / 2, (i5 + RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (RefresherView.this.mEmptyView.getMeasuredHeight() + i6) / 2);
            }
            if (RefresherView.this.Qt != null) {
                RefresherView.this.Qt.layout(-RefresherView.this.Qt.getMeasuredWidth(), 0, 0, i6);
            }
            RefresherView.this.getLocationOnScreen(RefresherView.this.mTempLocation);
            RefresherView.this.Qw = RefresherView.this.mTempLocation[0];
        }

        @Override // com.baidu.adp.widget.f
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mEmptyView, drawingTime);
            }
            canvas.save();
            canvas.translate(RefresherView.this.mXOffset >> 1, 0.0f);
            RefresherView.this.drawChild(canvas, RefresherView.this.Qs, drawingTime);
            if (RefresherView.this.mXOffset > 0) {
                RefresherView.this.drawChild(canvas, RefresherView.this.Qt, drawingTime);
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
            if (!RefresherView.this.MH || RefresherView.this.mRefreshing) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            switch (action) {
                case 0:
                    RefresherView.this.KZ = x;
                    removeMessages(1000);
                    removeMessages(1001);
                    break;
                case 2:
                    if (!(RefresherView.this.Qs instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.Qs).getChildAt(0)) == null) {
                        RefresherView.this.Qs.getLocationOnScreen(RefresherView.this.Qu);
                        if (RefresherView.this.Qu[0] == RefresherView.this.Qw && x > RefresherView.this.KZ + this.QJ) {
                            RefresherView.this.QE = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.QB;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.Qu);
                        if (RefresherView.this.Qu[0] == RefresherView.this.Qw && x > RefresherView.this.KZ + this.QJ) {
                            RefresherView.this.QE = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar2 = RefresherView.this.QB;
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
                    if (RefresherView.this.mXOffset <= RefresherView.this.Qo) {
                        RefresherView.this.Qx = 0;
                    } else {
                        RefresherView.this.refresh();
                    }
                    aJ(1000);
                    return true;
                case 2:
                    RefresherView.this.mXOffset = Math.max(0, Math.min((x - RefresherView.this.KZ) - this.QJ, RefresherView.this.mMaxHeight * 2));
                    if (RefresherView.this.mXOffset <= RefresherView.this.Qo || RefresherView.this.QE != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mXOffset < RefresherView.this.Qo && RefresherView.this.QE == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.QE = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.QB;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.QE = IRefreshable.State.pulling_refresh;
                        IRefreshable.a aVar2 = RefresherView.this.QB;
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
        public void aJ(int i) {
            switch (i) {
                case 1000:
                    oG();
                    return;
                case 1001:
                    oF();
                    return;
                default:
                    return;
            }
        }

        private void oF() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Mh = uptimeMillis;
            this.Mi = uptimeMillis + 16;
            this.Ml = true;
            this.QK = RefresherView.this.Qo;
            this.Mk = 0.0f;
            this.Mj = RefresherView.this.Mg;
            removeMessages(1001);
            sendEmptyMessageAtTime(1001, this.Mi);
        }

        private void oG() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Mh = uptimeMillis;
            this.Mi = uptimeMillis + 16;
            this.Ml = true;
            this.QK = RefresherView.this.mXOffset - RefresherView.this.Qx;
            this.Mk = 0.0f;
            this.Mj = Math.max(RefresherView.this.Qn, (RefresherView.this.mXOffset - RefresherView.this.Qx) * 2);
            removeMessages(1000);
            sendEmptyMessageAtTime(1000, this.Mi);
        }

        private void oE() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Mk = ((((float) (uptimeMillis - this.Mh)) / 1000.0f) * this.Mj) + this.Mk;
            if (this.Mk >= this.QK) {
                RefresherView.this.mXOffset = RefresherView.this.Qo;
                this.Ml = false;
                RefresherView.this.QE = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.QB;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mXOffset = com.baidu.adp.widget.a.a(this.QK, this.Mk, false);
                this.Mh = uptimeMillis;
                this.Mi = uptimeMillis + 16;
                removeMessages(1001);
                sendEmptyMessageAtTime(1001, this.Mi);
            }
            RefresherView.this.invalidate();
        }

        private void oD() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Mk = ((((float) (uptimeMillis - this.Mh)) / 1000.0f) * this.Mj) + this.Mk;
            if (this.Mk >= this.QK) {
                RefresherView.this.mXOffset = RefresherView.this.Qx;
                this.Ml = false;
                RefresherView.this.QE = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.QB;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                }
                if (RefresherView.this.Qx == 0 && aVar != null) {
                    aVar.oC();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mXOffset = (int) (RefresherView.this.Qx + (this.QK * (1.0f - com.baidu.adp.widget.a.sInterpolator.getInterpolation(this.Mk / this.QK))));
                this.Mh = uptimeMillis;
                this.Mi = uptimeMillis + 16;
                removeMessages(1000);
                sendEmptyMessageAtTime(1000, this.Mi);
            }
            RefresherView.this.invalidate();
        }
    }
}
