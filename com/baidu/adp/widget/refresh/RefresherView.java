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
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
/* loaded from: classes.dex */
public class RefresherView extends ViewGroup implements IRefreshable {
    private int MU;
    private int MV;
    private final int NW;
    private IRefreshable.State RA;
    private final int Rk;
    private int Rl;
    private final int Rm;
    private final int Rn;
    private final int Ro;
    private View Rp;
    private View Rq;
    private final int[] Rr;
    private int Rs;
    private int Rt;
    private int Ru;
    private final a Rv;
    private final b Rw;
    private IRefreshable.a Rx;
    private c Ry;
    private com.baidu.adp.widget.e Rz;
    private View mEmptyView;
    private boolean mEnable;
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
        this.mEnable = true;
        this.Rr = new int[2];
        this.mTempLocation = new int[2];
        this.RA = IRefreshable.State.idle;
        this.Rv = new a();
        this.Rw = new b();
        float f = getResources().getDisplayMetrics().density;
        this.Rk = (int) ((100.0f * f) + 0.5f);
        this.NW = (int) ((500.0f * f) + 0.5f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RefresherView);
        this.Rl = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_threshold_height, -1);
        if (this.Rl == -1) {
            this.Rl = (int) ((200.0f * f) + 0.5f);
        }
        this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_max_height, -1);
        if (this.mMaxHeight == -1) {
            this.mMaxHeight = (int) ((f * 400.0f) + 0.5f);
        }
        String string = obtainStyledAttributes.getString(R.styleable.RefresherView_direction);
        if (string == null) {
            this.Rz = new e();
        } else if (string.equals("side")) {
            this.Rz = new d();
        } else if (string.equals(AiAppsNaViewModel.POSITION_KEY_TOP)) {
            this.Rz = new e();
        }
        this.Rm = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_content, -1);
        this.Rn = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_head, -1);
        this.Ro = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_empty_view, -1);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        if (this.Rm == -1) {
            throw new RuntimeException("refresher content id is not set in xml, or call setRefresherContent before add it to a view tree.");
        }
        this.Rp = findViewById(this.Rm);
        if (this.Rp == null) {
            throw new RuntimeException("refresher content not found in the view tree by the content id.");
        }
        if (this.Rn == -1) {
            throw new RuntimeException("refresher head id is not set in xml, or call setRefresherHeader before add it to a view tree.");
        }
        this.Rq = findViewById(this.Rn);
        if (this.Rq == null) {
            throw new RuntimeException("refresher header not found in the view tree by the header id.");
        }
        if (this.Ro == -1) {
            throw new RuntimeException("empty view id is not set in xml, or call setEmptyView before add it to a view tree");
        }
        this.mEmptyView = findViewById(this.Ro);
        if (this.mEmptyView == null) {
            throw new RuntimeException("empty view not found in the view tree by the empty view's id");
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.Rz.measure(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.Rz.a(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.Rz.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.Rz.l(motionEvent);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.Rz.m(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.Rz.draw(canvas);
    }

    public void setOnRefreshListener(IRefreshable.a aVar) {
        this.Rx = aVar;
    }

    public void setEnable(boolean z) {
        this.mEnable = (!z || this.Rp == null || this.Rq == null) ? false : true;
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.mEnable;
    }

    public IRefreshable.State getState() {
        return this.RA;
    }

    public void refresh() {
        if (this.Ry == null || this.Ry.getStatus() != BdAsyncTask.BdAsyncTaskStatus.RUNNING) {
            this.Ry = new c();
            this.Ry.execute(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private long NX;
        private long NY;
        private int NZ;
        private boolean Ob;
        private int RB;
        private int RC;

        private a() {
        }

        void pl() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.RB = (int) (((((float) (uptimeMillis - this.NX)) / 1000.0f) * this.NZ) + this.RB);
            if (this.RB >= this.RC) {
                RefresherView.this.mYOffset = RefresherView.this.Ru;
                this.Ob = false;
                RefresherView.this.RA = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.Rx;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                }
                if (RefresherView.this.Ru == 0 && aVar != null) {
                    aVar.pk();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mYOffset = (int) (RefresherView.this.Ru + (this.RC * (1.0f - com.baidu.adp.widget.a.sInterpolator.getInterpolation(this.RB / this.RC))));
                this.NX = uptimeMillis;
                this.NY = uptimeMillis + 16;
                RefresherView.this.Rw.removeMessages(1000);
                RefresherView.this.Rw.sendEmptyMessageAtTime(1000, this.NY);
            }
            RefresherView.this.invalidate();
        }

        void pm() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.RB = (int) (((((float) (uptimeMillis - this.NX)) / 1000.0f) * this.NZ) + this.RB);
            if (this.RB >= this.RC) {
                RefresherView.this.mYOffset = RefresherView.this.Rl;
                this.Ob = false;
                RefresherView.this.RA = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.Rx;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mYOffset = com.baidu.adp.widget.a.a(this.RC, this.RB, false);
                this.NX = uptimeMillis;
                this.NY = uptimeMillis + 16;
                RefresherView.this.Rw.removeMessages(1001);
                RefresherView.this.Rw.sendEmptyMessageAtTime(1001, this.NY);
            }
            RefresherView.this.invalidate();
        }

        void bh(int i) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.NX = uptimeMillis;
            this.NY = uptimeMillis + 16;
            this.Ob = true;
            switch (i) {
                case 1000:
                    this.RC = RefresherView.this.mYOffset - RefresherView.this.Ru;
                    this.RB = 0;
                    this.NZ = Math.max(RefresherView.this.Rk, (RefresherView.this.mYOffset - RefresherView.this.Ru) * 2);
                    RefresherView.this.Rw.removeMessages(1000);
                    RefresherView.this.Rw.sendEmptyMessageAtTime(1000, this.NY);
                    break;
                case 1001:
                    this.RC = RefresherView.this.Rl;
                    this.RB = 0;
                    this.NZ = RefresherView.this.NW;
                    RefresherView.this.Rw.removeMessages(1001);
                    RefresherView.this.Rw.sendEmptyMessageAtTime(1001, this.NY);
                    break;
            }
            RefresherView.this.RA = IRefreshable.State.animating;
            IRefreshable.a aVar = RefresherView.this.Rx;
            if (aVar != null) {
                aVar.a(IRefreshable.State.animating);
            }
        }
    }

    public View getRefresherContent() {
        return this.Rp;
    }

    public View getRefresherHeader() {
        return this.Rq;
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    public void setRefresherContent(ViewGroup viewGroup) {
        boolean z = false;
        removeView(this.Rp);
        this.Rp = viewGroup;
        if (this.Rp == null) {
            this.mEnable = false;
            return;
        }
        addView(this.Rp);
        if (this.Rq != null && this.Rp != null) {
            z = true;
        }
        this.mEnable = z;
    }

    public void setRefresherHeader(View view) {
        boolean z = false;
        removeView(this.Rq);
        this.Rq = view;
        if (this.Rq == null) {
            this.mEnable = false;
            return;
        }
        addView(this.Rq);
        if (this.Rq != null && this.Rp != null) {
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
                RefresherView.this.Rv.pl();
            } else if (message.what == 1001) {
                RefresherView.this.Rv.pm();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {
        private final IRefreshable.a RE;

        c() {
            this.RE = RefresherView.this.Rx;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (this.RE != null) {
                RefresherView.this.Ru = RefresherView.this.Rl;
                this.RE.pi();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            RefresherView.this.mRefreshing = true;
            if (this.RE != null) {
                this.RE.pj();
                return null;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r3) {
            RefresherView.this.Ru = 0;
            RefresherView.this.Rz.bh(1000);
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
            if (RefresherView.this.Rp != null) {
                RefresherView.this.measureChild(RefresherView.this.Rp, i3 + AiAppsFileUtils.GB, i4 + AiAppsFileUtils.GB);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.measureChild(RefresherView.this.mEmptyView, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.Rq != null) {
                RefresherView.this.measureChild(RefresherView.this.Rq, i3 + AiAppsFileUtils.GB, i4 - 2147483648);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // com.baidu.adp.widget.e
        public void a(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.Rp != null) {
                RefresherView.this.Rp.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.mEmptyView.layout((i5 - RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (i6 - RefresherView.this.mEmptyView.getMeasuredHeight()) / 2, (RefresherView.this.mEmptyView.getMeasuredWidth() + i5) / 2, (i6 + RefresherView.this.mEmptyView.getMeasuredHeight()) / 2);
            }
            if (RefresherView.this.Rq != null) {
                RefresherView.this.Rq.layout(0, -RefresherView.this.Rq.getMeasuredHeight(), i5, 0);
            }
            RefresherView.this.getLocationOnScreen(RefresherView.this.mTempLocation);
            RefresherView.this.Rs = RefresherView.this.mTempLocation[1];
        }

        @Override // com.baidu.adp.widget.f
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mEmptyView, drawingTime);
            }
            canvas.save();
            canvas.translate(0.0f, RefresherView.this.mYOffset / 2);
            RefresherView.this.drawChild(canvas, RefresherView.this.Rp, drawingTime);
            if (RefresherView.this.mYOffset > 0) {
                RefresherView.this.drawChild(canvas, RefresherView.this.Rq, drawingTime);
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
            if (!RefresherView.this.mEnable || RefresherView.this.mRefreshing) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int y = (int) motionEvent.getY();
            switch (action) {
                case 0:
                    RefresherView.this.MV = y;
                    RefresherView.this.Rw.removeMessages(1000);
                    break;
                case 2:
                    if (!(RefresherView.this.Rp instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.Rp).getChildAt(0)) == null) {
                        RefresherView.this.Rp.getLocationOnScreen(RefresherView.this.Rr);
                        if (RefresherView.this.Rr[1] == RefresherView.this.Rs && y > RefresherView.this.MV) {
                            RefresherView.this.RA = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.Rx;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.Rr);
                        if (RefresherView.this.Rr[1] == RefresherView.this.Rs && y > RefresherView.this.MV) {
                            RefresherView.this.RA = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar2 = RefresherView.this.Rx;
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
                    if (RefresherView.this.mYOffset <= RefresherView.this.Rl) {
                        RefresherView.this.Ru = 0;
                    } else {
                        RefresherView.this.refresh();
                    }
                    bh(1000);
                    return true;
                case 2:
                    RefresherView.this.mYOffset = Math.max(0, Math.min(y - RefresherView.this.MV, RefresherView.this.mMaxHeight * 2));
                    if (RefresherView.this.mYOffset <= RefresherView.this.Rl || RefresherView.this.RA != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mYOffset < RefresherView.this.Rl && RefresherView.this.RA == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.RA = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.Rx;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.RA = IRefreshable.State.pulling_refresh;
                        IRefreshable.a aVar2 = RefresherView.this.Rx;
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
        public void bh(int i) {
            RefresherView.this.Rv.bh(i);
        }
    }

    /* loaded from: classes.dex */
    private class d extends Handler implements com.baidu.adp.widget.e {
        private long NX;
        private long NY;
        private int NZ;
        private float Oa;
        private boolean Ob;
        private final int RF;
        private float RG;

        public d() {
            this.RF = (int) ((RefresherView.this.getResources().getDisplayMetrics().density * 75.0f) + 0.5d);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1000:
                    pl();
                    return;
                case 1001:
                    pm();
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.adp.widget.f
        public void measure(int i, int i2) {
            int i3 = i & 1073741823;
            int i4 = 1073741823 & i2;
            if (RefresherView.this.Rp != null) {
                RefresherView.this.measureChild(RefresherView.this.Rp, i3 + AiAppsFileUtils.GB, i4 + AiAppsFileUtils.GB);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.measureChild(RefresherView.this.mEmptyView, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.Rq != null) {
                RefresherView.this.measureChild(RefresherView.this.Rq, i3 - 2147483648, i4 + AiAppsFileUtils.GB);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // com.baidu.adp.widget.e
        public void a(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.Rp != null) {
                RefresherView.this.Rp.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.mEmptyView.layout((i5 - RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (i6 - RefresherView.this.mEmptyView.getMeasuredHeight()) / 2, (i5 + RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (RefresherView.this.mEmptyView.getMeasuredHeight() + i6) / 2);
            }
            if (RefresherView.this.Rq != null) {
                RefresherView.this.Rq.layout(-RefresherView.this.Rq.getMeasuredWidth(), 0, 0, i6);
            }
            RefresherView.this.getLocationOnScreen(RefresherView.this.mTempLocation);
            RefresherView.this.Rt = RefresherView.this.mTempLocation[0];
        }

        @Override // com.baidu.adp.widget.f
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mEmptyView, drawingTime);
            }
            canvas.save();
            canvas.translate(RefresherView.this.mXOffset >> 1, 0.0f);
            RefresherView.this.drawChild(canvas, RefresherView.this.Rp, drawingTime);
            if (RefresherView.this.mXOffset > 0) {
                RefresherView.this.drawChild(canvas, RefresherView.this.Rq, drawingTime);
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
            if (!RefresherView.this.mEnable || RefresherView.this.mRefreshing) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            switch (action) {
                case 0:
                    RefresherView.this.MU = x;
                    removeMessages(1000);
                    removeMessages(1001);
                    break;
                case 2:
                    if (!(RefresherView.this.Rp instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.Rp).getChildAt(0)) == null) {
                        RefresherView.this.Rp.getLocationOnScreen(RefresherView.this.Rr);
                        if (RefresherView.this.Rr[0] == RefresherView.this.Rt && x > RefresherView.this.MU + this.RF) {
                            RefresherView.this.RA = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.Rx;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.Rr);
                        if (RefresherView.this.Rr[0] == RefresherView.this.Rt && x > RefresherView.this.MU + this.RF) {
                            RefresherView.this.RA = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar2 = RefresherView.this.Rx;
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
                    if (RefresherView.this.mXOffset <= RefresherView.this.Rl) {
                        RefresherView.this.Ru = 0;
                    } else {
                        RefresherView.this.refresh();
                    }
                    bh(1000);
                    return true;
                case 2:
                    RefresherView.this.mXOffset = Math.max(0, Math.min((x - RefresherView.this.MU) - this.RF, RefresherView.this.mMaxHeight * 2));
                    if (RefresherView.this.mXOffset <= RefresherView.this.Rl || RefresherView.this.RA != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mXOffset < RefresherView.this.Rl && RefresherView.this.RA == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.RA = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.Rx;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.RA = IRefreshable.State.pulling_refresh;
                        IRefreshable.a aVar2 = RefresherView.this.Rx;
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
        public void bh(int i) {
            switch (i) {
                case 1000:
                    po();
                    return;
                case 1001:
                    pn();
                    return;
                default:
                    return;
            }
        }

        private void pn() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.NX = uptimeMillis;
            this.NY = uptimeMillis + 16;
            this.Ob = true;
            this.RG = RefresherView.this.Rl;
            this.Oa = 0.0f;
            this.NZ = RefresherView.this.NW;
            removeMessages(1001);
            sendEmptyMessageAtTime(1001, this.NY);
        }

        private void po() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.NX = uptimeMillis;
            this.NY = uptimeMillis + 16;
            this.Ob = true;
            this.RG = RefresherView.this.mXOffset - RefresherView.this.Ru;
            this.Oa = 0.0f;
            this.NZ = Math.max(RefresherView.this.Rk, (RefresherView.this.mXOffset - RefresherView.this.Ru) * 2);
            removeMessages(1000);
            sendEmptyMessageAtTime(1000, this.NY);
        }

        private void pm() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Oa = ((((float) (uptimeMillis - this.NX)) / 1000.0f) * this.NZ) + this.Oa;
            if (this.Oa >= this.RG) {
                RefresherView.this.mXOffset = RefresherView.this.Rl;
                this.Ob = false;
                RefresherView.this.RA = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.Rx;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mXOffset = com.baidu.adp.widget.a.a(this.RG, this.Oa, false);
                this.NX = uptimeMillis;
                this.NY = uptimeMillis + 16;
                removeMessages(1001);
                sendEmptyMessageAtTime(1001, this.NY);
            }
            RefresherView.this.invalidate();
        }

        private void pl() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Oa = ((((float) (uptimeMillis - this.NX)) / 1000.0f) * this.NZ) + this.Oa;
            if (this.Oa >= this.RG) {
                RefresherView.this.mXOffset = RefresherView.this.Ru;
                this.Ob = false;
                RefresherView.this.RA = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.Rx;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                }
                if (RefresherView.this.Ru == 0 && aVar != null) {
                    aVar.pk();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mXOffset = (int) (RefresherView.this.Ru + (this.RG * (1.0f - com.baidu.adp.widget.a.sInterpolator.getInterpolation(this.Oa / this.RG))));
                this.NX = uptimeMillis;
                this.NY = uptimeMillis + 16;
                removeMessages(1000);
                sendEmptyMessageAtTime(1000, this.NY);
            }
            RefresherView.this.invalidate();
        }
    }
}
