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
    private int DR;
    private int DS;
    private final int ET;
    private boolean Fy;
    private final int Ie;
    private int If;
    private final int Ig;
    private final int Ih;
    private final int Ii;
    private View Ij;
    private View Ik;
    private final int[] Il;
    private final int[] Im;
    private int In;
    private int Io;
    private int Ip;
    private final a Iq;
    private final b Ir;
    private IRefreshable.a Is;
    private c It;
    private com.baidu.adp.widget.e Iu;
    private IRefreshable.State Iv;
    private View mEmptyView;
    private int mMaxHeight;
    private boolean mRefreshing;
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
        this.Fy = true;
        this.Il = new int[2];
        this.Im = new int[2];
        this.Iv = IRefreshable.State.idle;
        this.Iq = new a();
        this.Ir = new b();
        float f = getResources().getDisplayMetrics().density;
        this.Ie = (int) ((100.0f * f) + 0.5f);
        this.ET = (int) ((500.0f * f) + 0.5f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RefresherView);
        this.If = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_threshold_height, -1);
        if (this.If == -1) {
            this.If = (int) ((200.0f * f) + 0.5f);
        }
        this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_max_height, -1);
        if (this.mMaxHeight == -1) {
            this.mMaxHeight = (int) ((f * 400.0f) + 0.5f);
        }
        String string = obtainStyledAttributes.getString(R.styleable.RefresherView_direction);
        if (string == null) {
            this.Iu = new e();
        } else if (string.equals("side")) {
            this.Iu = new d();
        } else if (string.equals("top")) {
            this.Iu = new e();
        }
        this.Ig = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_content, -1);
        this.Ih = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_head, -1);
        this.Ii = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_empty_view, -1);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        if (this.Ig == -1) {
            throw new RuntimeException("refresher content id is not set in xml, or call setRefresherContent before add it to a view tree.");
        }
        this.Ij = findViewById(this.Ig);
        if (this.Ij == null) {
            throw new RuntimeException("refresher content not found in the view tree by the content id.");
        }
        if (this.Ih == -1) {
            throw new RuntimeException("refresher head id is not set in xml, or call setRefresherHeader before add it to a view tree.");
        }
        this.Ik = findViewById(this.Ih);
        if (this.Ik == null) {
            throw new RuntimeException("refresher header not found in the view tree by the header id.");
        }
        if (this.Ii == -1) {
            throw new RuntimeException("empty view id is not set in xml, or call setEmptyView before add it to a view tree");
        }
        this.mEmptyView = findViewById(this.Ii);
        if (this.mEmptyView == null) {
            throw new RuntimeException("empty view not found in the view tree by the empty view's id");
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.Iu.measure(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.Iu.a(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.Iu.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.Iu.k(motionEvent);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.Iu.l(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.Iu.draw(canvas);
    }

    public void setOnRefreshListener(IRefreshable.a aVar) {
        this.Is = aVar;
    }

    public void setEnable(boolean z) {
        this.Fy = (!z || this.Ij == null || this.Ik == null) ? false : true;
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.Fy;
    }

    public IRefreshable.State getState() {
        return this.Iv;
    }

    public void refresh() {
        if (this.It == null || this.It.getStatus() != BdAsyncTask.BdAsyncTaskStatus.RUNNING) {
            this.It = new c();
            this.It.execute(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private long EU;
        private long EV;
        private int EW;
        private boolean EY;
        private int Iw;
        private int Ix;

        private a() {
        }

        void ll() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Iw = (int) (((((float) (uptimeMillis - this.EU)) / 1000.0f) * this.EW) + this.Iw);
            if (this.Iw >= this.Ix) {
                RefresherView.this.mYOffset = RefresherView.this.Ip;
                this.EY = false;
                RefresherView.this.Iv = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.Is;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                }
                if (RefresherView.this.Ip == 0 && aVar != null) {
                    aVar.lk();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mYOffset = (int) (RefresherView.this.Ip + (this.Ix * (1.0f - com.baidu.adp.widget.a.sInterpolator.getInterpolation(this.Iw / this.Ix))));
                this.EU = uptimeMillis;
                this.EV = uptimeMillis + 16;
                RefresherView.this.Ir.removeMessages(1000);
                RefresherView.this.Ir.sendEmptyMessageAtTime(1000, this.EV);
            }
            RefresherView.this.invalidate();
        }

        void lm() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Iw = (int) (((((float) (uptimeMillis - this.EU)) / 1000.0f) * this.EW) + this.Iw);
            if (this.Iw >= this.Ix) {
                RefresherView.this.mYOffset = RefresherView.this.If;
                this.EY = false;
                RefresherView.this.Iv = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.Is;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mYOffset = com.baidu.adp.widget.a.a(this.Ix, this.Iw, false);
                this.EU = uptimeMillis;
                this.EV = uptimeMillis + 16;
                RefresherView.this.Ir.removeMessages(1001);
                RefresherView.this.Ir.sendEmptyMessageAtTime(1001, this.EV);
            }
            RefresherView.this.invalidate();
        }

        void aG(int i) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.EU = uptimeMillis;
            this.EV = uptimeMillis + 16;
            this.EY = true;
            switch (i) {
                case 1000:
                    this.Ix = RefresherView.this.mYOffset - RefresherView.this.Ip;
                    this.Iw = 0;
                    this.EW = Math.max(RefresherView.this.Ie, (RefresherView.this.mYOffset - RefresherView.this.Ip) * 2);
                    RefresherView.this.Ir.removeMessages(1000);
                    RefresherView.this.Ir.sendEmptyMessageAtTime(1000, this.EV);
                    break;
                case 1001:
                    this.Ix = RefresherView.this.If;
                    this.Iw = 0;
                    this.EW = RefresherView.this.ET;
                    RefresherView.this.Ir.removeMessages(1001);
                    RefresherView.this.Ir.sendEmptyMessageAtTime(1001, this.EV);
                    break;
            }
            RefresherView.this.Iv = IRefreshable.State.animating;
            IRefreshable.a aVar = RefresherView.this.Is;
            if (aVar != null) {
                aVar.a(IRefreshable.State.animating);
            }
        }
    }

    public View getRefresherContent() {
        return this.Ij;
    }

    public View getRefresherHeader() {
        return this.Ik;
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    public void setRefresherContent(ViewGroup viewGroup) {
        boolean z = false;
        removeView(this.Ij);
        this.Ij = viewGroup;
        if (this.Ij == null) {
            this.Fy = false;
            return;
        }
        addView(this.Ij);
        if (this.Ik != null && this.Ij != null) {
            z = true;
        }
        this.Fy = z;
    }

    public void setRefresherHeader(View view2) {
        boolean z = false;
        removeView(this.Ik);
        this.Ik = view2;
        if (this.Ik == null) {
            this.Fy = false;
            return;
        }
        addView(this.Ik);
        if (this.Ik != null && this.Ij != null) {
            z = true;
        }
        this.Fy = z;
    }

    public void setEmptyView(View view2) {
        removeView(this.mEmptyView);
        this.mEmptyView = view2;
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
                RefresherView.this.Iq.ll();
            } else if (message.what == 1001) {
                RefresherView.this.Iq.lm();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {
        private final IRefreshable.a Iz;

        c() {
            this.Iz = RefresherView.this.Is;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (this.Iz != null) {
                RefresherView.this.Ip = RefresherView.this.If;
                this.Iz.li();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            RefresherView.this.mRefreshing = true;
            if (this.Iz != null) {
                this.Iz.lj();
                return null;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(Void r3) {
            RefresherView.this.Ip = 0;
            RefresherView.this.Iu.aG(1000);
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
            if (RefresherView.this.Ij != null) {
                RefresherView.this.measureChild(RefresherView.this.Ij, i3 + 1073741824, i4 + 1073741824);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.measureChild(RefresherView.this.mEmptyView, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.Ik != null) {
                RefresherView.this.measureChild(RefresherView.this.Ik, i3 + 1073741824, i4 - 2147483648);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // com.baidu.adp.widget.e
        public void a(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.Ij != null) {
                RefresherView.this.Ij.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.mEmptyView.layout((i5 - RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (i6 - RefresherView.this.mEmptyView.getMeasuredHeight()) / 2, (RefresherView.this.mEmptyView.getMeasuredWidth() + i5) / 2, (i6 + RefresherView.this.mEmptyView.getMeasuredHeight()) / 2);
            }
            if (RefresherView.this.Ik != null) {
                RefresherView.this.Ik.layout(0, -RefresherView.this.Ik.getMeasuredHeight(), i5, 0);
            }
            RefresherView.this.getLocationOnScreen(RefresherView.this.Im);
            RefresherView.this.In = RefresherView.this.Im[1];
        }

        @Override // com.baidu.adp.widget.f
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mEmptyView, drawingTime);
            }
            canvas.save();
            canvas.translate(0.0f, RefresherView.this.mYOffset / 2);
            RefresherView.this.drawChild(canvas, RefresherView.this.Ij, drawingTime);
            if (RefresherView.this.mYOffset > 0) {
                RefresherView.this.drawChild(canvas, RefresherView.this.Ik, drawingTime);
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
        public boolean k(MotionEvent motionEvent) {
            View childAt;
            if (!RefresherView.this.Fy || RefresherView.this.mRefreshing) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int y = (int) motionEvent.getY();
            switch (action) {
                case 0:
                    RefresherView.this.DS = y;
                    RefresherView.this.Ir.removeMessages(1000);
                    break;
                case 2:
                    if (!(RefresherView.this.Ij instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.Ij).getChildAt(0)) == null) {
                        RefresherView.this.Ij.getLocationOnScreen(RefresherView.this.Il);
                        if (RefresherView.this.Il[1] == RefresherView.this.In && y > RefresherView.this.DS) {
                            RefresherView.this.Iv = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.Is;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.Il);
                        if (RefresherView.this.Il[1] == RefresherView.this.In && y > RefresherView.this.DS) {
                            RefresherView.this.Iv = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar2 = RefresherView.this.Is;
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
        public boolean l(MotionEvent motionEvent) {
            int action = motionEvent.getAction() & 255;
            int y = (int) motionEvent.getY();
            switch (action) {
                case 1:
                case 3:
                    if (RefresherView.this.mYOffset <= RefresherView.this.If) {
                        RefresherView.this.Ip = 0;
                    } else {
                        RefresherView.this.refresh();
                    }
                    aG(1000);
                    return true;
                case 2:
                    RefresherView.this.mYOffset = Math.max(0, Math.min(y - RefresherView.this.DS, RefresherView.this.mMaxHeight * 2));
                    if (RefresherView.this.mYOffset <= RefresherView.this.If || RefresherView.this.Iv != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mYOffset < RefresherView.this.If && RefresherView.this.Iv == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.Iv = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.Is;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.Iv = IRefreshable.State.pulling_refresh;
                        IRefreshable.a aVar2 = RefresherView.this.Is;
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
        public void aG(int i) {
            RefresherView.this.Iq.aG(i);
        }
    }

    /* loaded from: classes.dex */
    private class d extends Handler implements com.baidu.adp.widget.e {
        private long EU;
        private long EV;
        private int EW;
        private float EX;
        private boolean EY;
        private final int IA;
        private float IB;

        public d() {
            this.IA = (int) ((RefresherView.this.getResources().getDisplayMetrics().density * 75.0f) + 0.5d);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1000:
                    ll();
                    return;
                case 1001:
                    lm();
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.adp.widget.f
        public void measure(int i, int i2) {
            int i3 = i & 1073741823;
            int i4 = 1073741823 & i2;
            if (RefresherView.this.Ij != null) {
                RefresherView.this.measureChild(RefresherView.this.Ij, i3 + 1073741824, i4 + 1073741824);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.measureChild(RefresherView.this.mEmptyView, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.Ik != null) {
                RefresherView.this.measureChild(RefresherView.this.Ik, i3 - 2147483648, i4 + 1073741824);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // com.baidu.adp.widget.e
        public void a(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.Ij != null) {
                RefresherView.this.Ij.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.mEmptyView.layout((i5 - RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (i6 - RefresherView.this.mEmptyView.getMeasuredHeight()) / 2, (i5 + RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (RefresherView.this.mEmptyView.getMeasuredHeight() + i6) / 2);
            }
            if (RefresherView.this.Ik != null) {
                RefresherView.this.Ik.layout(-RefresherView.this.Ik.getMeasuredWidth(), 0, 0, i6);
            }
            RefresherView.this.getLocationOnScreen(RefresherView.this.Im);
            RefresherView.this.Io = RefresherView.this.Im[0];
        }

        @Override // com.baidu.adp.widget.f
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mEmptyView, drawingTime);
            }
            canvas.save();
            canvas.translate(RefresherView.this.mXOffset >> 1, 0.0f);
            RefresherView.this.drawChild(canvas, RefresherView.this.Ij, drawingTime);
            if (RefresherView.this.mXOffset > 0) {
                RefresherView.this.drawChild(canvas, RefresherView.this.Ik, drawingTime);
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
        public boolean k(MotionEvent motionEvent) {
            View childAt;
            if (!RefresherView.this.Fy || RefresherView.this.mRefreshing) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            switch (action) {
                case 0:
                    RefresherView.this.DR = x;
                    removeMessages(1000);
                    removeMessages(1001);
                    break;
                case 2:
                    if (!(RefresherView.this.Ij instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.Ij).getChildAt(0)) == null) {
                        RefresherView.this.Ij.getLocationOnScreen(RefresherView.this.Il);
                        if (RefresherView.this.Il[0] == RefresherView.this.Io && x > RefresherView.this.DR + this.IA) {
                            RefresherView.this.Iv = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.Is;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.Il);
                        if (RefresherView.this.Il[0] == RefresherView.this.Io && x > RefresherView.this.DR + this.IA) {
                            RefresherView.this.Iv = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar2 = RefresherView.this.Is;
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
        public boolean l(MotionEvent motionEvent) {
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            switch (action) {
                case 1:
                case 3:
                    if (RefresherView.this.mXOffset <= RefresherView.this.If) {
                        RefresherView.this.Ip = 0;
                    } else {
                        RefresherView.this.refresh();
                    }
                    aG(1000);
                    return true;
                case 2:
                    RefresherView.this.mXOffset = Math.max(0, Math.min((x - RefresherView.this.DR) - this.IA, RefresherView.this.mMaxHeight * 2));
                    if (RefresherView.this.mXOffset <= RefresherView.this.If || RefresherView.this.Iv != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mXOffset < RefresherView.this.If && RefresherView.this.Iv == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.Iv = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.Is;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.Iv = IRefreshable.State.pulling_refresh;
                        IRefreshable.a aVar2 = RefresherView.this.Is;
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
        public void aG(int i) {
            switch (i) {
                case 1000:
                    lo();
                    return;
                case 1001:
                    ln();
                    return;
                default:
                    return;
            }
        }

        private void ln() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.EU = uptimeMillis;
            this.EV = uptimeMillis + 16;
            this.EY = true;
            this.IB = RefresherView.this.If;
            this.EX = 0.0f;
            this.EW = RefresherView.this.ET;
            removeMessages(1001);
            sendEmptyMessageAtTime(1001, this.EV);
        }

        private void lo() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.EU = uptimeMillis;
            this.EV = uptimeMillis + 16;
            this.EY = true;
            this.IB = RefresherView.this.mXOffset - RefresherView.this.Ip;
            this.EX = 0.0f;
            this.EW = Math.max(RefresherView.this.Ie, (RefresherView.this.mXOffset - RefresherView.this.Ip) * 2);
            removeMessages(1000);
            sendEmptyMessageAtTime(1000, this.EV);
        }

        private void lm() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.EX = ((((float) (uptimeMillis - this.EU)) / 1000.0f) * this.EW) + this.EX;
            if (this.EX >= this.IB) {
                RefresherView.this.mXOffset = RefresherView.this.If;
                this.EY = false;
                RefresherView.this.Iv = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.Is;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mXOffset = com.baidu.adp.widget.a.a(this.IB, this.EX, false);
                this.EU = uptimeMillis;
                this.EV = uptimeMillis + 16;
                removeMessages(1001);
                sendEmptyMessageAtTime(1001, this.EV);
            }
            RefresherView.this.invalidate();
        }

        private void ll() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.EX = ((((float) (uptimeMillis - this.EU)) / 1000.0f) * this.EW) + this.EX;
            if (this.EX >= this.IB) {
                RefresherView.this.mXOffset = RefresherView.this.Ip;
                this.EY = false;
                RefresherView.this.Iv = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.Is;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                }
                if (RefresherView.this.Ip == 0 && aVar != null) {
                    aVar.lk();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mXOffset = (int) (RefresherView.this.Ip + (this.IB * (1.0f - com.baidu.adp.widget.a.sInterpolator.getInterpolation(this.EX / this.IB))));
                this.EU = uptimeMillis;
                this.EV = uptimeMillis + 16;
                removeMessages(1000);
                sendEmptyMessageAtTime(1000, this.EV);
            }
            RefresherView.this.invalidate();
        }
    }
}
