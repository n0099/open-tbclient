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
    private int Ll;
    private int Lm;
    private boolean MX;
    private final int Mu;
    private final int QE;
    private int QF;
    private final int QG;
    private final int QH;
    private final int QI;
    private View QJ;
    private View QK;
    private final int[] QL;
    private int QM;
    private int QN;
    private int QO;
    private final a QP;
    private final b QR;
    private IRefreshable.a QS;
    private c QT;
    private com.baidu.adp.widget.e QU;
    private IRefreshable.State QV;
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
        this.MX = true;
        this.QL = new int[2];
        this.mTempLocation = new int[2];
        this.QV = IRefreshable.State.idle;
        this.QP = new a();
        this.QR = new b();
        float f = getResources().getDisplayMetrics().density;
        this.QE = (int) ((100.0f * f) + 0.5f);
        this.Mu = (int) ((500.0f * f) + 0.5f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RefresherView);
        this.QF = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_threshold_height, -1);
        if (this.QF == -1) {
            this.QF = (int) ((200.0f * f) + 0.5f);
        }
        this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_max_height, -1);
        if (this.mMaxHeight == -1) {
            this.mMaxHeight = (int) ((f * 400.0f) + 0.5f);
        }
        String string = obtainStyledAttributes.getString(R.styleable.RefresherView_direction);
        if (string == null) {
            this.QU = new e();
        } else if (string.equals("side")) {
            this.QU = new d();
        } else if (string.equals("top")) {
            this.QU = new e();
        }
        this.QG = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_content, -1);
        this.QH = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_head, -1);
        this.QI = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_empty_view, -1);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        if (this.QG == -1) {
            throw new RuntimeException("refresher content id is not set in xml, or call setRefresherContent before add it to a view tree.");
        }
        this.QJ = findViewById(this.QG);
        if (this.QJ == null) {
            throw new RuntimeException("refresher content not found in the view tree by the content id.");
        }
        if (this.QH == -1) {
            throw new RuntimeException("refresher head id is not set in xml, or call setRefresherHeader before add it to a view tree.");
        }
        this.QK = findViewById(this.QH);
        if (this.QK == null) {
            throw new RuntimeException("refresher header not found in the view tree by the header id.");
        }
        if (this.QI == -1) {
            throw new RuntimeException("empty view id is not set in xml, or call setEmptyView before add it to a view tree");
        }
        this.mEmptyView = findViewById(this.QI);
        if (this.mEmptyView == null) {
            throw new RuntimeException("empty view not found in the view tree by the empty view's id");
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.QU.r(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.QU.a(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.QU.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.QU.l(motionEvent);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.QU.m(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.QU.draw(canvas);
    }

    public void setOnRefreshListener(IRefreshable.a aVar) {
        this.QS = aVar;
    }

    public void setEnable(boolean z) {
        this.MX = (!z || this.QJ == null || this.QK == null) ? false : true;
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.MX;
    }

    public IRefreshable.State getState() {
        return this.QV;
    }

    public void refresh() {
        if (this.QT == null || this.QT.getStatus() != BdAsyncTask.BdAsyncTaskStatus.RUNNING) {
            this.QT = new c();
            this.QT.execute(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private long Mv;
        private long Mw;
        private int Mx;
        private boolean Mz;
        private int QW;
        private int QX;

        private a() {
        }

        void oZ() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.QW = (int) (((((float) (uptimeMillis - this.Mv)) / 1000.0f) * this.Mx) + this.QW);
            if (this.QW >= this.QX) {
                RefresherView.this.mYOffset = RefresherView.this.QO;
                this.Mz = false;
                RefresherView.this.QV = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.QS;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                }
                if (RefresherView.this.QO == 0 && aVar != null) {
                    aVar.oY();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mYOffset = (int) (RefresherView.this.QO + (this.QX * (1.0f - com.baidu.adp.widget.a.sInterpolator.getInterpolation(this.QW / this.QX))));
                this.Mv = uptimeMillis;
                this.Mw = uptimeMillis + 16;
                RefresherView.this.QR.removeMessages(1000);
                RefresherView.this.QR.sendEmptyMessageAtTime(1000, this.Mw);
            }
            RefresherView.this.invalidate();
        }

        void pa() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.QW = (int) (((((float) (uptimeMillis - this.Mv)) / 1000.0f) * this.Mx) + this.QW);
            if (this.QW >= this.QX) {
                RefresherView.this.mYOffset = RefresherView.this.QF;
                this.Mz = false;
                RefresherView.this.QV = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.QS;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mYOffset = com.baidu.adp.widget.a.a(this.QX, this.QW, false);
                this.Mv = uptimeMillis;
                this.Mw = uptimeMillis + 16;
                RefresherView.this.QR.removeMessages(1001);
                RefresherView.this.QR.sendEmptyMessageAtTime(1001, this.Mw);
            }
            RefresherView.this.invalidate();
        }

        void aJ(int i) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Mv = uptimeMillis;
            this.Mw = uptimeMillis + 16;
            this.Mz = true;
            switch (i) {
                case 1000:
                    this.QX = RefresherView.this.mYOffset - RefresherView.this.QO;
                    this.QW = 0;
                    this.Mx = Math.max(RefresherView.this.QE, (RefresherView.this.mYOffset - RefresherView.this.QO) * 2);
                    RefresherView.this.QR.removeMessages(1000);
                    RefresherView.this.QR.sendEmptyMessageAtTime(1000, this.Mw);
                    break;
                case 1001:
                    this.QX = RefresherView.this.QF;
                    this.QW = 0;
                    this.Mx = RefresherView.this.Mu;
                    RefresherView.this.QR.removeMessages(1001);
                    RefresherView.this.QR.sendEmptyMessageAtTime(1001, this.Mw);
                    break;
            }
            RefresherView.this.QV = IRefreshable.State.animating;
            IRefreshable.a aVar = RefresherView.this.QS;
            if (aVar != null) {
                aVar.a(IRefreshable.State.animating);
            }
        }
    }

    public View getRefresherContent() {
        return this.QJ;
    }

    public View getRefresherHeader() {
        return this.QK;
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    public void setRefresherContent(ViewGroup viewGroup) {
        boolean z = false;
        removeView(this.QJ);
        this.QJ = viewGroup;
        if (this.QJ == null) {
            this.MX = false;
            return;
        }
        addView(this.QJ);
        if (this.QK != null && this.QJ != null) {
            z = true;
        }
        this.MX = z;
    }

    public void setRefresherHeader(View view) {
        boolean z = false;
        removeView(this.QK);
        this.QK = view;
        if (this.QK == null) {
            this.MX = false;
            return;
        }
        addView(this.QK);
        if (this.QK != null && this.QJ != null) {
            z = true;
        }
        this.MX = z;
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
                RefresherView.this.QP.oZ();
            } else if (message.what == 1001) {
                RefresherView.this.QP.pa();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {
        private final IRefreshable.a QZ;

        c() {
            this.QZ = RefresherView.this.QS;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (this.QZ != null) {
                RefresherView.this.QO = RefresherView.this.QF;
                this.QZ.oW();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            RefresherView.this.mRefreshing = true;
            if (this.QZ != null) {
                this.QZ.oX();
                return null;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r3) {
            RefresherView.this.QO = 0;
            RefresherView.this.QU.aJ(1000);
        }
    }

    /* loaded from: classes.dex */
    private class e implements com.baidu.adp.widget.e {
        private e() {
        }

        @Override // com.baidu.adp.widget.f
        public void r(int i, int i2) {
            int i3 = i & 1073741823;
            int i4 = 1073741823 & i2;
            if (RefresherView.this.QJ != null) {
                RefresherView.this.measureChild(RefresherView.this.QJ, i3 + 1073741824, i4 + 1073741824);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.measureChild(RefresherView.this.mEmptyView, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.QK != null) {
                RefresherView.this.measureChild(RefresherView.this.QK, i3 + 1073741824, i4 - 2147483648);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // com.baidu.adp.widget.e
        public void a(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.QJ != null) {
                RefresherView.this.QJ.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.mEmptyView.layout((i5 - RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (i6 - RefresherView.this.mEmptyView.getMeasuredHeight()) / 2, (RefresherView.this.mEmptyView.getMeasuredWidth() + i5) / 2, (i6 + RefresherView.this.mEmptyView.getMeasuredHeight()) / 2);
            }
            if (RefresherView.this.QK != null) {
                RefresherView.this.QK.layout(0, -RefresherView.this.QK.getMeasuredHeight(), i5, 0);
            }
            RefresherView.this.getLocationOnScreen(RefresherView.this.mTempLocation);
            RefresherView.this.QM = RefresherView.this.mTempLocation[1];
        }

        @Override // com.baidu.adp.widget.f
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mEmptyView, drawingTime);
            }
            canvas.save();
            canvas.translate(0.0f, RefresherView.this.mYOffset / 2);
            RefresherView.this.drawChild(canvas, RefresherView.this.QJ, drawingTime);
            if (RefresherView.this.mYOffset > 0) {
                RefresherView.this.drawChild(canvas, RefresherView.this.QK, drawingTime);
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
            if (!RefresherView.this.MX || RefresherView.this.mRefreshing) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int y = (int) motionEvent.getY();
            switch (action) {
                case 0:
                    RefresherView.this.Lm = y;
                    RefresherView.this.QR.removeMessages(1000);
                    break;
                case 2:
                    if (!(RefresherView.this.QJ instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.QJ).getChildAt(0)) == null) {
                        RefresherView.this.QJ.getLocationOnScreen(RefresherView.this.QL);
                        if (RefresherView.this.QL[1] == RefresherView.this.QM && y > RefresherView.this.Lm) {
                            RefresherView.this.QV = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.QS;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.QL);
                        if (RefresherView.this.QL[1] == RefresherView.this.QM && y > RefresherView.this.Lm) {
                            RefresherView.this.QV = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar2 = RefresherView.this.QS;
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
                    if (RefresherView.this.mYOffset <= RefresherView.this.QF) {
                        RefresherView.this.QO = 0;
                    } else {
                        RefresherView.this.refresh();
                    }
                    aJ(1000);
                    return true;
                case 2:
                    RefresherView.this.mYOffset = Math.max(0, Math.min(y - RefresherView.this.Lm, RefresherView.this.mMaxHeight * 2));
                    if (RefresherView.this.mYOffset <= RefresherView.this.QF || RefresherView.this.QV != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mYOffset < RefresherView.this.QF && RefresherView.this.QV == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.QV = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.QS;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.QV = IRefreshable.State.pulling_refresh;
                        IRefreshable.a aVar2 = RefresherView.this.QS;
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
            RefresherView.this.QP.aJ(i);
        }
    }

    /* loaded from: classes.dex */
    private class d extends Handler implements com.baidu.adp.widget.e {
        private long Mv;
        private long Mw;
        private int Mx;
        private float My;
        private boolean Mz;
        private final int Ra;
        private float Rb;

        public d() {
            this.Ra = (int) ((RefresherView.this.getResources().getDisplayMetrics().density * 75.0f) + 0.5d);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1000:
                    oZ();
                    return;
                case 1001:
                    pa();
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.adp.widget.f
        public void r(int i, int i2) {
            int i3 = i & 1073741823;
            int i4 = 1073741823 & i2;
            if (RefresherView.this.QJ != null) {
                RefresherView.this.measureChild(RefresherView.this.QJ, i3 + 1073741824, i4 + 1073741824);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.measureChild(RefresherView.this.mEmptyView, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.QK != null) {
                RefresherView.this.measureChild(RefresherView.this.QK, i3 - 2147483648, i4 + 1073741824);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // com.baidu.adp.widget.e
        public void a(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.QJ != null) {
                RefresherView.this.QJ.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.mEmptyView.layout((i5 - RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (i6 - RefresherView.this.mEmptyView.getMeasuredHeight()) / 2, (i5 + RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (RefresherView.this.mEmptyView.getMeasuredHeight() + i6) / 2);
            }
            if (RefresherView.this.QK != null) {
                RefresherView.this.QK.layout(-RefresherView.this.QK.getMeasuredWidth(), 0, 0, i6);
            }
            RefresherView.this.getLocationOnScreen(RefresherView.this.mTempLocation);
            RefresherView.this.QN = RefresherView.this.mTempLocation[0];
        }

        @Override // com.baidu.adp.widget.f
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mEmptyView, drawingTime);
            }
            canvas.save();
            canvas.translate(RefresherView.this.mXOffset >> 1, 0.0f);
            RefresherView.this.drawChild(canvas, RefresherView.this.QJ, drawingTime);
            if (RefresherView.this.mXOffset > 0) {
                RefresherView.this.drawChild(canvas, RefresherView.this.QK, drawingTime);
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
            if (!RefresherView.this.MX || RefresherView.this.mRefreshing) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            switch (action) {
                case 0:
                    RefresherView.this.Ll = x;
                    removeMessages(1000);
                    removeMessages(1001);
                    break;
                case 2:
                    if (!(RefresherView.this.QJ instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.QJ).getChildAt(0)) == null) {
                        RefresherView.this.QJ.getLocationOnScreen(RefresherView.this.QL);
                        if (RefresherView.this.QL[0] == RefresherView.this.QN && x > RefresherView.this.Ll + this.Ra) {
                            RefresherView.this.QV = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.QS;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.QL);
                        if (RefresherView.this.QL[0] == RefresherView.this.QN && x > RefresherView.this.Ll + this.Ra) {
                            RefresherView.this.QV = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar2 = RefresherView.this.QS;
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
                    if (RefresherView.this.mXOffset <= RefresherView.this.QF) {
                        RefresherView.this.QO = 0;
                    } else {
                        RefresherView.this.refresh();
                    }
                    aJ(1000);
                    return true;
                case 2:
                    RefresherView.this.mXOffset = Math.max(0, Math.min((x - RefresherView.this.Ll) - this.Ra, RefresherView.this.mMaxHeight * 2));
                    if (RefresherView.this.mXOffset <= RefresherView.this.QF || RefresherView.this.QV != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mXOffset < RefresherView.this.QF && RefresherView.this.QV == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.QV = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.QS;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.QV = IRefreshable.State.pulling_refresh;
                        IRefreshable.a aVar2 = RefresherView.this.QS;
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
                    pc();
                    return;
                case 1001:
                    pb();
                    return;
                default:
                    return;
            }
        }

        private void pb() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Mv = uptimeMillis;
            this.Mw = uptimeMillis + 16;
            this.Mz = true;
            this.Rb = RefresherView.this.QF;
            this.My = 0.0f;
            this.Mx = RefresherView.this.Mu;
            removeMessages(1001);
            sendEmptyMessageAtTime(1001, this.Mw);
        }

        private void pc() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Mv = uptimeMillis;
            this.Mw = uptimeMillis + 16;
            this.Mz = true;
            this.Rb = RefresherView.this.mXOffset - RefresherView.this.QO;
            this.My = 0.0f;
            this.Mx = Math.max(RefresherView.this.QE, (RefresherView.this.mXOffset - RefresherView.this.QO) * 2);
            removeMessages(1000);
            sendEmptyMessageAtTime(1000, this.Mw);
        }

        private void pa() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.My = ((((float) (uptimeMillis - this.Mv)) / 1000.0f) * this.Mx) + this.My;
            if (this.My >= this.Rb) {
                RefresherView.this.mXOffset = RefresherView.this.QF;
                this.Mz = false;
                RefresherView.this.QV = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.QS;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mXOffset = com.baidu.adp.widget.a.a(this.Rb, this.My, false);
                this.Mv = uptimeMillis;
                this.Mw = uptimeMillis + 16;
                removeMessages(1001);
                sendEmptyMessageAtTime(1001, this.Mw);
            }
            RefresherView.this.invalidate();
        }

        private void oZ() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.My = ((((float) (uptimeMillis - this.Mv)) / 1000.0f) * this.Mx) + this.My;
            if (this.My >= this.Rb) {
                RefresherView.this.mXOffset = RefresherView.this.QO;
                this.Mz = false;
                RefresherView.this.QV = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.QS;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                }
                if (RefresherView.this.QO == 0 && aVar != null) {
                    aVar.oY();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mXOffset = (int) (RefresherView.this.QO + (this.Rb * (1.0f - com.baidu.adp.widget.a.sInterpolator.getInterpolation(this.My / this.Rb))));
                this.Mv = uptimeMillis;
                this.Mw = uptimeMillis + 16;
                removeMessages(1000);
                sendEmptyMessageAtTime(1000, this.Mw);
            }
            RefresherView.this.invalidate();
        }
    }
}
