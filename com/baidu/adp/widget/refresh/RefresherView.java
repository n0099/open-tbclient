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
    private int Nd;
    private int Ne;
    private final int Of;
    private final int[] RA;
    private int RB;
    private int RC;
    private int RD;
    private final a RE;
    private final b RF;
    private IRefreshable.a RG;
    private c RH;
    private com.baidu.adp.widget.e RI;
    private IRefreshable.State RJ;
    private final int Rt;
    private int Ru;
    private final int Rv;
    private final int Rw;
    private final int Rx;
    private View Ry;
    private View Rz;
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
        this.RA = new int[2];
        this.mTempLocation = new int[2];
        this.RJ = IRefreshable.State.idle;
        this.RE = new a();
        this.RF = new b();
        float f = getResources().getDisplayMetrics().density;
        this.Rt = (int) ((100.0f * f) + 0.5f);
        this.Of = (int) ((500.0f * f) + 0.5f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RefresherView);
        this.Ru = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_threshold_height, -1);
        if (this.Ru == -1) {
            this.Ru = (int) ((200.0f * f) + 0.5f);
        }
        this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_max_height, -1);
        if (this.mMaxHeight == -1) {
            this.mMaxHeight = (int) ((f * 400.0f) + 0.5f);
        }
        String string = obtainStyledAttributes.getString(R.styleable.RefresherView_direction);
        if (string == null) {
            this.RI = new e();
        } else if (string.equals("side")) {
            this.RI = new d();
        } else if (string.equals(AiAppsNaViewModel.POSITION_KEY_TOP)) {
            this.RI = new e();
        }
        this.Rv = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_content, -1);
        this.Rw = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_head, -1);
        this.Rx = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_empty_view, -1);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        if (this.Rv == -1) {
            throw new RuntimeException("refresher content id is not set in xml, or call setRefresherContent before add it to a view tree.");
        }
        this.Ry = findViewById(this.Rv);
        if (this.Ry == null) {
            throw new RuntimeException("refresher content not found in the view tree by the content id.");
        }
        if (this.Rw == -1) {
            throw new RuntimeException("refresher head id is not set in xml, or call setRefresherHeader before add it to a view tree.");
        }
        this.Rz = findViewById(this.Rw);
        if (this.Rz == null) {
            throw new RuntimeException("refresher header not found in the view tree by the header id.");
        }
        if (this.Rx == -1) {
            throw new RuntimeException("empty view id is not set in xml, or call setEmptyView before add it to a view tree");
        }
        this.mEmptyView = findViewById(this.Rx);
        if (this.mEmptyView == null) {
            throw new RuntimeException("empty view not found in the view tree by the empty view's id");
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.RI.measure(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.RI.a(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.RI.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.RI.l(motionEvent);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.RI.m(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.RI.draw(canvas);
    }

    public void setOnRefreshListener(IRefreshable.a aVar) {
        this.RG = aVar;
    }

    public void setEnable(boolean z) {
        this.mEnable = (!z || this.Ry == null || this.Rz == null) ? false : true;
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.mEnable;
    }

    public IRefreshable.State getState() {
        return this.RJ;
    }

    public void refresh() {
        if (this.RH == null || this.RH.getStatus() != BdAsyncTask.BdAsyncTaskStatus.RUNNING) {
            this.RH = new c();
            this.RH.execute(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private long Og;
        private long Oh;
        private int Oi;
        private boolean Ok;
        private int RK;
        private int RL;

        private a() {
        }

        void pp() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.RK = (int) (((((float) (uptimeMillis - this.Og)) / 1000.0f) * this.Oi) + this.RK);
            if (this.RK >= this.RL) {
                RefresherView.this.mYOffset = RefresherView.this.RD;
                this.Ok = false;
                RefresherView.this.RJ = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.RG;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                }
                if (RefresherView.this.RD == 0 && aVar != null) {
                    aVar.po();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mYOffset = (int) (RefresherView.this.RD + (this.RL * (1.0f - com.baidu.adp.widget.a.sInterpolator.getInterpolation(this.RK / this.RL))));
                this.Og = uptimeMillis;
                this.Oh = uptimeMillis + 16;
                RefresherView.this.RF.removeMessages(1000);
                RefresherView.this.RF.sendEmptyMessageAtTime(1000, this.Oh);
            }
            RefresherView.this.invalidate();
        }

        void pq() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.RK = (int) (((((float) (uptimeMillis - this.Og)) / 1000.0f) * this.Oi) + this.RK);
            if (this.RK >= this.RL) {
                RefresherView.this.mYOffset = RefresherView.this.Ru;
                this.Ok = false;
                RefresherView.this.RJ = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.RG;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mYOffset = com.baidu.adp.widget.a.a(this.RL, this.RK, false);
                this.Og = uptimeMillis;
                this.Oh = uptimeMillis + 16;
                RefresherView.this.RF.removeMessages(1001);
                RefresherView.this.RF.sendEmptyMessageAtTime(1001, this.Oh);
            }
            RefresherView.this.invalidate();
        }

        void bh(int i) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Og = uptimeMillis;
            this.Oh = uptimeMillis + 16;
            this.Ok = true;
            switch (i) {
                case 1000:
                    this.RL = RefresherView.this.mYOffset - RefresherView.this.RD;
                    this.RK = 0;
                    this.Oi = Math.max(RefresherView.this.Rt, (RefresherView.this.mYOffset - RefresherView.this.RD) * 2);
                    RefresherView.this.RF.removeMessages(1000);
                    RefresherView.this.RF.sendEmptyMessageAtTime(1000, this.Oh);
                    break;
                case 1001:
                    this.RL = RefresherView.this.Ru;
                    this.RK = 0;
                    this.Oi = RefresherView.this.Of;
                    RefresherView.this.RF.removeMessages(1001);
                    RefresherView.this.RF.sendEmptyMessageAtTime(1001, this.Oh);
                    break;
            }
            RefresherView.this.RJ = IRefreshable.State.animating;
            IRefreshable.a aVar = RefresherView.this.RG;
            if (aVar != null) {
                aVar.a(IRefreshable.State.animating);
            }
        }
    }

    public View getRefresherContent() {
        return this.Ry;
    }

    public View getRefresherHeader() {
        return this.Rz;
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    public void setRefresherContent(ViewGroup viewGroup) {
        boolean z = false;
        removeView(this.Ry);
        this.Ry = viewGroup;
        if (this.Ry == null) {
            this.mEnable = false;
            return;
        }
        addView(this.Ry);
        if (this.Rz != null && this.Ry != null) {
            z = true;
        }
        this.mEnable = z;
    }

    public void setRefresherHeader(View view) {
        boolean z = false;
        removeView(this.Rz);
        this.Rz = view;
        if (this.Rz == null) {
            this.mEnable = false;
            return;
        }
        addView(this.Rz);
        if (this.Rz != null && this.Ry != null) {
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
                RefresherView.this.RE.pp();
            } else if (message.what == 1001) {
                RefresherView.this.RE.pq();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {
        private final IRefreshable.a RP;

        c() {
            this.RP = RefresherView.this.RG;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (this.RP != null) {
                RefresherView.this.RD = RefresherView.this.Ru;
                this.RP.pm();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            RefresherView.this.mRefreshing = true;
            if (this.RP != null) {
                this.RP.pn();
                return null;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r3) {
            RefresherView.this.RD = 0;
            RefresherView.this.RI.bh(1000);
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
            if (RefresherView.this.Ry != null) {
                RefresherView.this.measureChild(RefresherView.this.Ry, i3 + AiAppsFileUtils.GB, i4 + AiAppsFileUtils.GB);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.measureChild(RefresherView.this.mEmptyView, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.Rz != null) {
                RefresherView.this.measureChild(RefresherView.this.Rz, i3 + AiAppsFileUtils.GB, i4 - 2147483648);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // com.baidu.adp.widget.e
        public void a(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.Ry != null) {
                RefresherView.this.Ry.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.mEmptyView.layout((i5 - RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (i6 - RefresherView.this.mEmptyView.getMeasuredHeight()) / 2, (RefresherView.this.mEmptyView.getMeasuredWidth() + i5) / 2, (i6 + RefresherView.this.mEmptyView.getMeasuredHeight()) / 2);
            }
            if (RefresherView.this.Rz != null) {
                RefresherView.this.Rz.layout(0, -RefresherView.this.Rz.getMeasuredHeight(), i5, 0);
            }
            RefresherView.this.getLocationOnScreen(RefresherView.this.mTempLocation);
            RefresherView.this.RB = RefresherView.this.mTempLocation[1];
        }

        @Override // com.baidu.adp.widget.f
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mEmptyView, drawingTime);
            }
            canvas.save();
            canvas.translate(0.0f, RefresherView.this.mYOffset / 2);
            RefresherView.this.drawChild(canvas, RefresherView.this.Ry, drawingTime);
            if (RefresherView.this.mYOffset > 0) {
                RefresherView.this.drawChild(canvas, RefresherView.this.Rz, drawingTime);
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
                    RefresherView.this.Ne = y;
                    RefresherView.this.RF.removeMessages(1000);
                    break;
                case 2:
                    if (!(RefresherView.this.Ry instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.Ry).getChildAt(0)) == null) {
                        RefresherView.this.Ry.getLocationOnScreen(RefresherView.this.RA);
                        if (RefresherView.this.RA[1] == RefresherView.this.RB && y > RefresherView.this.Ne) {
                            RefresherView.this.RJ = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.RG;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.RA);
                        if (RefresherView.this.RA[1] == RefresherView.this.RB && y > RefresherView.this.Ne) {
                            RefresherView.this.RJ = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar2 = RefresherView.this.RG;
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
                    if (RefresherView.this.mYOffset <= RefresherView.this.Ru) {
                        RefresherView.this.RD = 0;
                    } else {
                        RefresherView.this.refresh();
                    }
                    bh(1000);
                    return true;
                case 2:
                    RefresherView.this.mYOffset = Math.max(0, Math.min(y - RefresherView.this.Ne, RefresherView.this.mMaxHeight * 2));
                    if (RefresherView.this.mYOffset <= RefresherView.this.Ru || RefresherView.this.RJ != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mYOffset < RefresherView.this.Ru && RefresherView.this.RJ == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.RJ = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.RG;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.RJ = IRefreshable.State.pulling_refresh;
                        IRefreshable.a aVar2 = RefresherView.this.RG;
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
            RefresherView.this.RE.bh(i);
        }
    }

    /* loaded from: classes.dex */
    private class d extends Handler implements com.baidu.adp.widget.e {
        private long Og;
        private long Oh;
        private int Oi;
        private float Oj;
        private boolean Ok;
        private final int RQ;
        private float RR;

        public d() {
            this.RQ = (int) ((RefresherView.this.getResources().getDisplayMetrics().density * 75.0f) + 0.5d);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1000:
                    pp();
                    return;
                case 1001:
                    pq();
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.adp.widget.f
        public void measure(int i, int i2) {
            int i3 = i & 1073741823;
            int i4 = 1073741823 & i2;
            if (RefresherView.this.Ry != null) {
                RefresherView.this.measureChild(RefresherView.this.Ry, i3 + AiAppsFileUtils.GB, i4 + AiAppsFileUtils.GB);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.measureChild(RefresherView.this.mEmptyView, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.Rz != null) {
                RefresherView.this.measureChild(RefresherView.this.Rz, i3 - 2147483648, i4 + AiAppsFileUtils.GB);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // com.baidu.adp.widget.e
        public void a(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.Ry != null) {
                RefresherView.this.Ry.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.mEmptyView.layout((i5 - RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (i6 - RefresherView.this.mEmptyView.getMeasuredHeight()) / 2, (i5 + RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (RefresherView.this.mEmptyView.getMeasuredHeight() + i6) / 2);
            }
            if (RefresherView.this.Rz != null) {
                RefresherView.this.Rz.layout(-RefresherView.this.Rz.getMeasuredWidth(), 0, 0, i6);
            }
            RefresherView.this.getLocationOnScreen(RefresherView.this.mTempLocation);
            RefresherView.this.RC = RefresherView.this.mTempLocation[0];
        }

        @Override // com.baidu.adp.widget.f
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mEmptyView, drawingTime);
            }
            canvas.save();
            canvas.translate(RefresherView.this.mXOffset >> 1, 0.0f);
            RefresherView.this.drawChild(canvas, RefresherView.this.Ry, drawingTime);
            if (RefresherView.this.mXOffset > 0) {
                RefresherView.this.drawChild(canvas, RefresherView.this.Rz, drawingTime);
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
                    RefresherView.this.Nd = x;
                    removeMessages(1000);
                    removeMessages(1001);
                    break;
                case 2:
                    if (!(RefresherView.this.Ry instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.Ry).getChildAt(0)) == null) {
                        RefresherView.this.Ry.getLocationOnScreen(RefresherView.this.RA);
                        if (RefresherView.this.RA[0] == RefresherView.this.RC && x > RefresherView.this.Nd + this.RQ) {
                            RefresherView.this.RJ = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.RG;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.RA);
                        if (RefresherView.this.RA[0] == RefresherView.this.RC && x > RefresherView.this.Nd + this.RQ) {
                            RefresherView.this.RJ = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar2 = RefresherView.this.RG;
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
                    if (RefresherView.this.mXOffset <= RefresherView.this.Ru) {
                        RefresherView.this.RD = 0;
                    } else {
                        RefresherView.this.refresh();
                    }
                    bh(1000);
                    return true;
                case 2:
                    RefresherView.this.mXOffset = Math.max(0, Math.min((x - RefresherView.this.Nd) - this.RQ, RefresherView.this.mMaxHeight * 2));
                    if (RefresherView.this.mXOffset <= RefresherView.this.Ru || RefresherView.this.RJ != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mXOffset < RefresherView.this.Ru && RefresherView.this.RJ == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.RJ = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.RG;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.RJ = IRefreshable.State.pulling_refresh;
                        IRefreshable.a aVar2 = RefresherView.this.RG;
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
                    ps();
                    return;
                case 1001:
                    pr();
                    return;
                default:
                    return;
            }
        }

        private void pr() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Og = uptimeMillis;
            this.Oh = uptimeMillis + 16;
            this.Ok = true;
            this.RR = RefresherView.this.Ru;
            this.Oj = 0.0f;
            this.Oi = RefresherView.this.Of;
            removeMessages(1001);
            sendEmptyMessageAtTime(1001, this.Oh);
        }

        private void ps() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Og = uptimeMillis;
            this.Oh = uptimeMillis + 16;
            this.Ok = true;
            this.RR = RefresherView.this.mXOffset - RefresherView.this.RD;
            this.Oj = 0.0f;
            this.Oi = Math.max(RefresherView.this.Rt, (RefresherView.this.mXOffset - RefresherView.this.RD) * 2);
            removeMessages(1000);
            sendEmptyMessageAtTime(1000, this.Oh);
        }

        private void pq() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Oj = ((((float) (uptimeMillis - this.Og)) / 1000.0f) * this.Oi) + this.Oj;
            if (this.Oj >= this.RR) {
                RefresherView.this.mXOffset = RefresherView.this.Ru;
                this.Ok = false;
                RefresherView.this.RJ = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.RG;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mXOffset = com.baidu.adp.widget.a.a(this.RR, this.Oj, false);
                this.Og = uptimeMillis;
                this.Oh = uptimeMillis + 16;
                removeMessages(1001);
                sendEmptyMessageAtTime(1001, this.Oh);
            }
            RefresherView.this.invalidate();
        }

        private void pp() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Oj = ((((float) (uptimeMillis - this.Og)) / 1000.0f) * this.Oi) + this.Oj;
            if (this.Oj >= this.RR) {
                RefresherView.this.mXOffset = RefresherView.this.RD;
                this.Ok = false;
                RefresherView.this.RJ = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.RG;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                }
                if (RefresherView.this.RD == 0 && aVar != null) {
                    aVar.po();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mXOffset = (int) (RefresherView.this.RD + (this.RR * (1.0f - com.baidu.adp.widget.a.sInterpolator.getInterpolation(this.Oj / this.RR))));
                this.Og = uptimeMillis;
                this.Oh = uptimeMillis + 16;
                removeMessages(1000);
                sendEmptyMessageAtTime(1000, this.Oh);
            }
            RefresherView.this.invalidate();
        }
    }
}
