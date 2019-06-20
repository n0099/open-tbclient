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
    private int KY;
    private int KZ;
    private boolean MG;
    private final int Mf;
    private c QB;
    private com.baidu.adp.widget.e QC;
    private IRefreshable.State QD;
    private final int Qm;
    private int Qn;
    private final int Qo;
    private final int Qp;
    private final int Qq;
    private View Qr;
    private View Qs;
    private final int[] Qt;
    private int Qu;
    private int Qv;
    private int Qw;
    private final a Qx;
    private final b Qy;
    private IRefreshable.a Qz;
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
        this.MG = true;
        this.Qt = new int[2];
        this.mTempLocation = new int[2];
        this.QD = IRefreshable.State.idle;
        this.Qx = new a();
        this.Qy = new b();
        float f = getResources().getDisplayMetrics().density;
        this.Qm = (int) ((100.0f * f) + 0.5f);
        this.Mf = (int) ((500.0f * f) + 0.5f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RefresherView);
        this.Qn = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_threshold_height, -1);
        if (this.Qn == -1) {
            this.Qn = (int) ((200.0f * f) + 0.5f);
        }
        this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_max_height, -1);
        if (this.mMaxHeight == -1) {
            this.mMaxHeight = (int) ((f * 400.0f) + 0.5f);
        }
        String string = obtainStyledAttributes.getString(R.styleable.RefresherView_direction);
        if (string == null) {
            this.QC = new e();
        } else if (string.equals("side")) {
            this.QC = new d();
        } else if (string.equals("top")) {
            this.QC = new e();
        }
        this.Qo = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_content, -1);
        this.Qp = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_head, -1);
        this.Qq = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_empty_view, -1);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        if (this.Qo == -1) {
            throw new RuntimeException("refresher content id is not set in xml, or call setRefresherContent before add it to a view tree.");
        }
        this.Qr = findViewById(this.Qo);
        if (this.Qr == null) {
            throw new RuntimeException("refresher content not found in the view tree by the content id.");
        }
        if (this.Qp == -1) {
            throw new RuntimeException("refresher head id is not set in xml, or call setRefresherHeader before add it to a view tree.");
        }
        this.Qs = findViewById(this.Qp);
        if (this.Qs == null) {
            throw new RuntimeException("refresher header not found in the view tree by the header id.");
        }
        if (this.Qq == -1) {
            throw new RuntimeException("empty view id is not set in xml, or call setEmptyView before add it to a view tree");
        }
        this.mEmptyView = findViewById(this.Qq);
        if (this.mEmptyView == null) {
            throw new RuntimeException("empty view not found in the view tree by the empty view's id");
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.QC.measure(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.QC.a(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.QC.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.QC.l(motionEvent);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.QC.m(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.QC.draw(canvas);
    }

    public void setOnRefreshListener(IRefreshable.a aVar) {
        this.Qz = aVar;
    }

    public void setEnable(boolean z) {
        this.MG = (!z || this.Qr == null || this.Qs == null) ? false : true;
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.MG;
    }

    public IRefreshable.State getState() {
        return this.QD;
    }

    public void refresh() {
        if (this.QB == null || this.QB.getStatus() != BdAsyncTask.BdAsyncTaskStatus.RUNNING) {
            this.QB = new c();
            this.QB.execute(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private long Mg;
        private long Mh;
        private int Mi;
        private boolean Mk;
        private int QE;
        private int QF;

        private a() {
        }

        void oD() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.QE = (int) (((((float) (uptimeMillis - this.Mg)) / 1000.0f) * this.Mi) + this.QE);
            if (this.QE >= this.QF) {
                RefresherView.this.mYOffset = RefresherView.this.Qw;
                this.Mk = false;
                RefresherView.this.QD = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.Qz;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                }
                if (RefresherView.this.Qw == 0 && aVar != null) {
                    aVar.oC();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mYOffset = (int) (RefresherView.this.Qw + (this.QF * (1.0f - com.baidu.adp.widget.a.sInterpolator.getInterpolation(this.QE / this.QF))));
                this.Mg = uptimeMillis;
                this.Mh = uptimeMillis + 16;
                RefresherView.this.Qy.removeMessages(1000);
                RefresherView.this.Qy.sendEmptyMessageAtTime(1000, this.Mh);
            }
            RefresherView.this.invalidate();
        }

        void oE() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.QE = (int) (((((float) (uptimeMillis - this.Mg)) / 1000.0f) * this.Mi) + this.QE);
            if (this.QE >= this.QF) {
                RefresherView.this.mYOffset = RefresherView.this.Qn;
                this.Mk = false;
                RefresherView.this.QD = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.Qz;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mYOffset = com.baidu.adp.widget.a.a(this.QF, this.QE, false);
                this.Mg = uptimeMillis;
                this.Mh = uptimeMillis + 16;
                RefresherView.this.Qy.removeMessages(1001);
                RefresherView.this.Qy.sendEmptyMessageAtTime(1001, this.Mh);
            }
            RefresherView.this.invalidate();
        }

        void aJ(int i) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Mg = uptimeMillis;
            this.Mh = uptimeMillis + 16;
            this.Mk = true;
            switch (i) {
                case 1000:
                    this.QF = RefresherView.this.mYOffset - RefresherView.this.Qw;
                    this.QE = 0;
                    this.Mi = Math.max(RefresherView.this.Qm, (RefresherView.this.mYOffset - RefresherView.this.Qw) * 2);
                    RefresherView.this.Qy.removeMessages(1000);
                    RefresherView.this.Qy.sendEmptyMessageAtTime(1000, this.Mh);
                    break;
                case 1001:
                    this.QF = RefresherView.this.Qn;
                    this.QE = 0;
                    this.Mi = RefresherView.this.Mf;
                    RefresherView.this.Qy.removeMessages(1001);
                    RefresherView.this.Qy.sendEmptyMessageAtTime(1001, this.Mh);
                    break;
            }
            RefresherView.this.QD = IRefreshable.State.animating;
            IRefreshable.a aVar = RefresherView.this.Qz;
            if (aVar != null) {
                aVar.a(IRefreshable.State.animating);
            }
        }
    }

    public View getRefresherContent() {
        return this.Qr;
    }

    public View getRefresherHeader() {
        return this.Qs;
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    public void setRefresherContent(ViewGroup viewGroup) {
        boolean z = false;
        removeView(this.Qr);
        this.Qr = viewGroup;
        if (this.Qr == null) {
            this.MG = false;
            return;
        }
        addView(this.Qr);
        if (this.Qs != null && this.Qr != null) {
            z = true;
        }
        this.MG = z;
    }

    public void setRefresherHeader(View view) {
        boolean z = false;
        removeView(this.Qs);
        this.Qs = view;
        if (this.Qs == null) {
            this.MG = false;
            return;
        }
        addView(this.Qs);
        if (this.Qs != null && this.Qr != null) {
            z = true;
        }
        this.MG = z;
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
                RefresherView.this.Qx.oD();
            } else if (message.what == 1001) {
                RefresherView.this.Qx.oE();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {
        private final IRefreshable.a QH;

        c() {
            this.QH = RefresherView.this.Qz;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (this.QH != null) {
                RefresherView.this.Qw = RefresherView.this.Qn;
                this.QH.oA();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            RefresherView.this.mRefreshing = true;
            if (this.QH != null) {
                this.QH.oB();
                return null;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r3) {
            RefresherView.this.Qw = 0;
            RefresherView.this.QC.aJ(1000);
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
            if (RefresherView.this.Qr != null) {
                RefresherView.this.measureChild(RefresherView.this.Qr, i3 + 1073741824, i4 + 1073741824);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.measureChild(RefresherView.this.mEmptyView, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.Qs != null) {
                RefresherView.this.measureChild(RefresherView.this.Qs, i3 + 1073741824, i4 - 2147483648);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // com.baidu.adp.widget.e
        public void a(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.Qr != null) {
                RefresherView.this.Qr.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.mEmptyView.layout((i5 - RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (i6 - RefresherView.this.mEmptyView.getMeasuredHeight()) / 2, (RefresherView.this.mEmptyView.getMeasuredWidth() + i5) / 2, (i6 + RefresherView.this.mEmptyView.getMeasuredHeight()) / 2);
            }
            if (RefresherView.this.Qs != null) {
                RefresherView.this.Qs.layout(0, -RefresherView.this.Qs.getMeasuredHeight(), i5, 0);
            }
            RefresherView.this.getLocationOnScreen(RefresherView.this.mTempLocation);
            RefresherView.this.Qu = RefresherView.this.mTempLocation[1];
        }

        @Override // com.baidu.adp.widget.f
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mEmptyView, drawingTime);
            }
            canvas.save();
            canvas.translate(0.0f, RefresherView.this.mYOffset / 2);
            RefresherView.this.drawChild(canvas, RefresherView.this.Qr, drawingTime);
            if (RefresherView.this.mYOffset > 0) {
                RefresherView.this.drawChild(canvas, RefresherView.this.Qs, drawingTime);
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
            if (!RefresherView.this.MG || RefresherView.this.mRefreshing) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int y = (int) motionEvent.getY();
            switch (action) {
                case 0:
                    RefresherView.this.KZ = y;
                    RefresherView.this.Qy.removeMessages(1000);
                    break;
                case 2:
                    if (!(RefresherView.this.Qr instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.Qr).getChildAt(0)) == null) {
                        RefresherView.this.Qr.getLocationOnScreen(RefresherView.this.Qt);
                        if (RefresherView.this.Qt[1] == RefresherView.this.Qu && y > RefresherView.this.KZ) {
                            RefresherView.this.QD = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.Qz;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.Qt);
                        if (RefresherView.this.Qt[1] == RefresherView.this.Qu && y > RefresherView.this.KZ) {
                            RefresherView.this.QD = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar2 = RefresherView.this.Qz;
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
                    if (RefresherView.this.mYOffset <= RefresherView.this.Qn) {
                        RefresherView.this.Qw = 0;
                    } else {
                        RefresherView.this.refresh();
                    }
                    aJ(1000);
                    return true;
                case 2:
                    RefresherView.this.mYOffset = Math.max(0, Math.min(y - RefresherView.this.KZ, RefresherView.this.mMaxHeight * 2));
                    if (RefresherView.this.mYOffset <= RefresherView.this.Qn || RefresherView.this.QD != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mYOffset < RefresherView.this.Qn && RefresherView.this.QD == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.QD = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.Qz;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.QD = IRefreshable.State.pulling_refresh;
                        IRefreshable.a aVar2 = RefresherView.this.Qz;
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
            RefresherView.this.Qx.aJ(i);
        }
    }

    /* loaded from: classes.dex */
    private class d extends Handler implements com.baidu.adp.widget.e {
        private long Mg;
        private long Mh;
        private int Mi;
        private float Mj;
        private boolean Mk;
        private final int QI;
        private float QJ;

        public d() {
            this.QI = (int) ((RefresherView.this.getResources().getDisplayMetrics().density * 75.0f) + 0.5d);
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
            if (RefresherView.this.Qr != null) {
                RefresherView.this.measureChild(RefresherView.this.Qr, i3 + 1073741824, i4 + 1073741824);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.measureChild(RefresherView.this.mEmptyView, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.Qs != null) {
                RefresherView.this.measureChild(RefresherView.this.Qs, i3 - 2147483648, i4 + 1073741824);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // com.baidu.adp.widget.e
        public void a(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.Qr != null) {
                RefresherView.this.Qr.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.mEmptyView.layout((i5 - RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (i6 - RefresherView.this.mEmptyView.getMeasuredHeight()) / 2, (i5 + RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (RefresherView.this.mEmptyView.getMeasuredHeight() + i6) / 2);
            }
            if (RefresherView.this.Qs != null) {
                RefresherView.this.Qs.layout(-RefresherView.this.Qs.getMeasuredWidth(), 0, 0, i6);
            }
            RefresherView.this.getLocationOnScreen(RefresherView.this.mTempLocation);
            RefresherView.this.Qv = RefresherView.this.mTempLocation[0];
        }

        @Override // com.baidu.adp.widget.f
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mEmptyView, drawingTime);
            }
            canvas.save();
            canvas.translate(RefresherView.this.mXOffset >> 1, 0.0f);
            RefresherView.this.drawChild(canvas, RefresherView.this.Qr, drawingTime);
            if (RefresherView.this.mXOffset > 0) {
                RefresherView.this.drawChild(canvas, RefresherView.this.Qs, drawingTime);
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
            if (!RefresherView.this.MG || RefresherView.this.mRefreshing) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            switch (action) {
                case 0:
                    RefresherView.this.KY = x;
                    removeMessages(1000);
                    removeMessages(1001);
                    break;
                case 2:
                    if (!(RefresherView.this.Qr instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.Qr).getChildAt(0)) == null) {
                        RefresherView.this.Qr.getLocationOnScreen(RefresherView.this.Qt);
                        if (RefresherView.this.Qt[0] == RefresherView.this.Qv && x > RefresherView.this.KY + this.QI) {
                            RefresherView.this.QD = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.Qz;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.Qt);
                        if (RefresherView.this.Qt[0] == RefresherView.this.Qv && x > RefresherView.this.KY + this.QI) {
                            RefresherView.this.QD = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar2 = RefresherView.this.Qz;
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
                    if (RefresherView.this.mXOffset <= RefresherView.this.Qn) {
                        RefresherView.this.Qw = 0;
                    } else {
                        RefresherView.this.refresh();
                    }
                    aJ(1000);
                    return true;
                case 2:
                    RefresherView.this.mXOffset = Math.max(0, Math.min((x - RefresherView.this.KY) - this.QI, RefresherView.this.mMaxHeight * 2));
                    if (RefresherView.this.mXOffset <= RefresherView.this.Qn || RefresherView.this.QD != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mXOffset < RefresherView.this.Qn && RefresherView.this.QD == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.QD = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.Qz;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.QD = IRefreshable.State.pulling_refresh;
                        IRefreshable.a aVar2 = RefresherView.this.Qz;
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
            this.Mg = uptimeMillis;
            this.Mh = uptimeMillis + 16;
            this.Mk = true;
            this.QJ = RefresherView.this.Qn;
            this.Mj = 0.0f;
            this.Mi = RefresherView.this.Mf;
            removeMessages(1001);
            sendEmptyMessageAtTime(1001, this.Mh);
        }

        private void oG() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Mg = uptimeMillis;
            this.Mh = uptimeMillis + 16;
            this.Mk = true;
            this.QJ = RefresherView.this.mXOffset - RefresherView.this.Qw;
            this.Mj = 0.0f;
            this.Mi = Math.max(RefresherView.this.Qm, (RefresherView.this.mXOffset - RefresherView.this.Qw) * 2);
            removeMessages(1000);
            sendEmptyMessageAtTime(1000, this.Mh);
        }

        private void oE() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Mj = ((((float) (uptimeMillis - this.Mg)) / 1000.0f) * this.Mi) + this.Mj;
            if (this.Mj >= this.QJ) {
                RefresherView.this.mXOffset = RefresherView.this.Qn;
                this.Mk = false;
                RefresherView.this.QD = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.Qz;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mXOffset = com.baidu.adp.widget.a.a(this.QJ, this.Mj, false);
                this.Mg = uptimeMillis;
                this.Mh = uptimeMillis + 16;
                removeMessages(1001);
                sendEmptyMessageAtTime(1001, this.Mh);
            }
            RefresherView.this.invalidate();
        }

        private void oD() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Mj = ((((float) (uptimeMillis - this.Mg)) / 1000.0f) * this.Mi) + this.Mj;
            if (this.Mj >= this.QJ) {
                RefresherView.this.mXOffset = RefresherView.this.Qw;
                this.Mk = false;
                RefresherView.this.QD = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.Qz;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                }
                if (RefresherView.this.Qw == 0 && aVar != null) {
                    aVar.oC();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mXOffset = (int) (RefresherView.this.Qw + (this.QJ * (1.0f - com.baidu.adp.widget.a.sInterpolator.getInterpolation(this.Mj / this.QJ))));
                this.Mg = uptimeMillis;
                this.Mh = uptimeMillis + 16;
                removeMessages(1000);
                sendEmptyMessageAtTime(1000, this.Mh);
            }
            RefresherView.this.invalidate();
        }
    }
}
