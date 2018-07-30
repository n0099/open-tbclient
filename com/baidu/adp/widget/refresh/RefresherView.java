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
    private int JZ;
    private int Ka;
    private boolean LD;
    private final int La;
    private final a OA;
    private final b OB;
    private IRefreshable.a OC;
    private c OD;
    private com.baidu.adp.widget.e OE;
    private IRefreshable.State OF;
    private final int Op;
    private int Oq;
    private final int Or;
    private final int Os;
    private final int Ot;
    private View Ou;
    private View Ov;
    private final int[] Ow;
    private int Ox;
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
        this.LD = true;
        this.Ow = new int[2];
        this.mTempLocation = new int[2];
        this.OF = IRefreshable.State.idle;
        this.OA = new a();
        this.OB = new b();
        float f = getResources().getDisplayMetrics().density;
        this.Op = (int) ((100.0f * f) + 0.5f);
        this.La = (int) ((500.0f * f) + 0.5f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RefresherView);
        this.Oq = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_threshold_height, -1);
        if (this.Oq == -1) {
            this.Oq = (int) ((200.0f * f) + 0.5f);
        }
        this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_max_height, -1);
        if (this.mMaxHeight == -1) {
            this.mMaxHeight = (int) ((f * 400.0f) + 0.5f);
        }
        String string = obtainStyledAttributes.getString(R.styleable.RefresherView_direction);
        if (string == null) {
            this.OE = new e();
        } else if (string.equals("side")) {
            this.OE = new d();
        } else if (string.equals("top")) {
            this.OE = new e();
        }
        this.Or = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_content, -1);
        this.Os = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_head, -1);
        this.Ot = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_empty_view, -1);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        if (this.Or == -1) {
            throw new RuntimeException("refresher content id is not set in xml, or call setRefresherContent before add it to a view tree.");
        }
        this.Ou = findViewById(this.Or);
        if (this.Ou == null) {
            throw new RuntimeException("refresher content not found in the view tree by the content id.");
        }
        if (this.Os == -1) {
            throw new RuntimeException("refresher head id is not set in xml, or call setRefresherHeader before add it to a view tree.");
        }
        this.Ov = findViewById(this.Os);
        if (this.Ov == null) {
            throw new RuntimeException("refresher header not found in the view tree by the header id.");
        }
        if (this.Ot == -1) {
            throw new RuntimeException("empty view id is not set in xml, or call setEmptyView before add it to a view tree");
        }
        this.mEmptyView = findViewById(this.Ot);
        if (this.mEmptyView == null) {
            throw new RuntimeException("empty view not found in the view tree by the empty view's id");
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.OE.measure(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.OE.a(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.OE.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.OE.l(motionEvent);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.OE.m(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.OE.draw(canvas);
    }

    public void setOnRefreshListener(IRefreshable.a aVar) {
        this.OC = aVar;
    }

    public void setEnable(boolean z) {
        this.LD = (!z || this.Ou == null || this.Ov == null) ? false : true;
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.LD;
    }

    public IRefreshable.State getState() {
        return this.OF;
    }

    public void refresh() {
        if (this.OD == null || this.OD.getStatus() != BdAsyncTask.BdAsyncTaskStatus.RUNNING) {
            this.OD = new c();
            this.OD.execute(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private long Lb;
        private long Lc;
        private int Ld;
        private boolean Lf;
        private int OG;
        private int OH;

        private a() {
        }

        void od() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.OG = (int) (((((float) (uptimeMillis - this.Lb)) / 1000.0f) * this.Ld) + this.OG);
            if (this.OG >= this.OH) {
                RefresherView.this.mYOffset = RefresherView.this.Oz;
                this.Lf = false;
                RefresherView.this.OF = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.OC;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                }
                if (RefresherView.this.Oz == 0 && aVar != null) {
                    aVar.oc();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mYOffset = (int) (RefresherView.this.Oz + (this.OH * (1.0f - com.baidu.adp.widget.a.sInterpolator.getInterpolation(this.OG / this.OH))));
                this.Lb = uptimeMillis;
                this.Lc = uptimeMillis + 16;
                RefresherView.this.OB.removeMessages(1000);
                RefresherView.this.OB.sendEmptyMessageAtTime(1000, this.Lc);
            }
            RefresherView.this.invalidate();
        }

        void oe() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.OG = (int) (((((float) (uptimeMillis - this.Lb)) / 1000.0f) * this.Ld) + this.OG);
            if (this.OG >= this.OH) {
                RefresherView.this.mYOffset = RefresherView.this.Oq;
                this.Lf = false;
                RefresherView.this.OF = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.OC;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mYOffset = com.baidu.adp.widget.a.a(this.OH, this.OG, false);
                this.Lb = uptimeMillis;
                this.Lc = uptimeMillis + 16;
                RefresherView.this.OB.removeMessages(1001);
                RefresherView.this.OB.sendEmptyMessageAtTime(1001, this.Lc);
            }
            RefresherView.this.invalidate();
        }

        void aI(int i) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Lb = uptimeMillis;
            this.Lc = uptimeMillis + 16;
            this.Lf = true;
            switch (i) {
                case 1000:
                    this.OH = RefresherView.this.mYOffset - RefresherView.this.Oz;
                    this.OG = 0;
                    this.Ld = Math.max(RefresherView.this.Op, (RefresherView.this.mYOffset - RefresherView.this.Oz) * 2);
                    RefresherView.this.OB.removeMessages(1000);
                    RefresherView.this.OB.sendEmptyMessageAtTime(1000, this.Lc);
                    break;
                case 1001:
                    this.OH = RefresherView.this.Oq;
                    this.OG = 0;
                    this.Ld = RefresherView.this.La;
                    RefresherView.this.OB.removeMessages(1001);
                    RefresherView.this.OB.sendEmptyMessageAtTime(1001, this.Lc);
                    break;
            }
            RefresherView.this.OF = IRefreshable.State.animating;
            IRefreshable.a aVar = RefresherView.this.OC;
            if (aVar != null) {
                aVar.a(IRefreshable.State.animating);
            }
        }
    }

    public View getRefresherContent() {
        return this.Ou;
    }

    public View getRefresherHeader() {
        return this.Ov;
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    public void setRefresherContent(ViewGroup viewGroup) {
        boolean z = false;
        removeView(this.Ou);
        this.Ou = viewGroup;
        if (this.Ou == null) {
            this.LD = false;
            return;
        }
        addView(this.Ou);
        if (this.Ov != null && this.Ou != null) {
            z = true;
        }
        this.LD = z;
    }

    public void setRefresherHeader(View view) {
        boolean z = false;
        removeView(this.Ov);
        this.Ov = view;
        if (this.Ov == null) {
            this.LD = false;
            return;
        }
        addView(this.Ov);
        if (this.Ov != null && this.Ou != null) {
            z = true;
        }
        this.LD = z;
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
                RefresherView.this.OA.od();
            } else if (message.what == 1001) {
                RefresherView.this.OA.oe();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {
        private final IRefreshable.a OJ;

        c() {
            this.OJ = RefresherView.this.OC;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (this.OJ != null) {
                RefresherView.this.Oz = RefresherView.this.Oq;
                this.OJ.oa();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            RefresherView.this.mRefreshing = true;
            if (this.OJ != null) {
                this.OJ.ob();
                return null;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r3) {
            RefresherView.this.Oz = 0;
            RefresherView.this.OE.aI(1000);
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
            if (RefresherView.this.Ou != null) {
                RefresherView.this.measureChild(RefresherView.this.Ou, i3 + 1073741824, i4 + 1073741824);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.measureChild(RefresherView.this.mEmptyView, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.Ov != null) {
                RefresherView.this.measureChild(RefresherView.this.Ov, i3 + 1073741824, i4 - 2147483648);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // com.baidu.adp.widget.e
        public void a(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.Ou != null) {
                RefresherView.this.Ou.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.mEmptyView.layout((i5 - RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (i6 - RefresherView.this.mEmptyView.getMeasuredHeight()) / 2, (RefresherView.this.mEmptyView.getMeasuredWidth() + i5) / 2, (i6 + RefresherView.this.mEmptyView.getMeasuredHeight()) / 2);
            }
            if (RefresherView.this.Ov != null) {
                RefresherView.this.Ov.layout(0, -RefresherView.this.Ov.getMeasuredHeight(), i5, 0);
            }
            RefresherView.this.getLocationOnScreen(RefresherView.this.mTempLocation);
            RefresherView.this.Ox = RefresherView.this.mTempLocation[1];
        }

        @Override // com.baidu.adp.widget.f
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mEmptyView, drawingTime);
            }
            canvas.save();
            canvas.translate(0.0f, RefresherView.this.mYOffset / 2);
            RefresherView.this.drawChild(canvas, RefresherView.this.Ou, drawingTime);
            if (RefresherView.this.mYOffset > 0) {
                RefresherView.this.drawChild(canvas, RefresherView.this.Ov, drawingTime);
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
            if (!RefresherView.this.LD || RefresherView.this.mRefreshing) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int y = (int) motionEvent.getY();
            switch (action) {
                case 0:
                    RefresherView.this.Ka = y;
                    RefresherView.this.OB.removeMessages(1000);
                    break;
                case 2:
                    if (!(RefresherView.this.Ou instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.Ou).getChildAt(0)) == null) {
                        RefresherView.this.Ou.getLocationOnScreen(RefresherView.this.Ow);
                        if (RefresherView.this.Ow[1] == RefresherView.this.Ox && y > RefresherView.this.Ka) {
                            RefresherView.this.OF = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.OC;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.Ow);
                        if (RefresherView.this.Ow[1] == RefresherView.this.Ox && y > RefresherView.this.Ka) {
                            RefresherView.this.OF = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar2 = RefresherView.this.OC;
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
                    if (RefresherView.this.mYOffset <= RefresherView.this.Oq) {
                        RefresherView.this.Oz = 0;
                    } else {
                        RefresherView.this.refresh();
                    }
                    aI(1000);
                    return true;
                case 2:
                    RefresherView.this.mYOffset = Math.max(0, Math.min(y - RefresherView.this.Ka, RefresherView.this.mMaxHeight * 2));
                    if (RefresherView.this.mYOffset <= RefresherView.this.Oq || RefresherView.this.OF != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mYOffset < RefresherView.this.Oq && RefresherView.this.OF == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.OF = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.OC;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.OF = IRefreshable.State.pulling_refresh;
                        IRefreshable.a aVar2 = RefresherView.this.OC;
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
        public void aI(int i) {
            RefresherView.this.OA.aI(i);
        }
    }

    /* loaded from: classes.dex */
    private class d extends Handler implements com.baidu.adp.widget.e {
        private long Lb;
        private long Lc;
        private int Ld;
        private float Le;
        private boolean Lf;
        private final int OL;
        private float OM;

        public d() {
            this.OL = (int) ((RefresherView.this.getResources().getDisplayMetrics().density * 75.0f) + 0.5d);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1000:
                    od();
                    return;
                case 1001:
                    oe();
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.adp.widget.f
        public void measure(int i, int i2) {
            int i3 = i & 1073741823;
            int i4 = 1073741823 & i2;
            if (RefresherView.this.Ou != null) {
                RefresherView.this.measureChild(RefresherView.this.Ou, i3 + 1073741824, i4 + 1073741824);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.measureChild(RefresherView.this.mEmptyView, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.Ov != null) {
                RefresherView.this.measureChild(RefresherView.this.Ov, i3 - 2147483648, i4 + 1073741824);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // com.baidu.adp.widget.e
        public void a(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.Ou != null) {
                RefresherView.this.Ou.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.mEmptyView.layout((i5 - RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (i6 - RefresherView.this.mEmptyView.getMeasuredHeight()) / 2, (i5 + RefresherView.this.mEmptyView.getMeasuredWidth()) / 2, (RefresherView.this.mEmptyView.getMeasuredHeight() + i6) / 2);
            }
            if (RefresherView.this.Ov != null) {
                RefresherView.this.Ov.layout(-RefresherView.this.Ov.getMeasuredWidth(), 0, 0, i6);
            }
            RefresherView.this.getLocationOnScreen(RefresherView.this.mTempLocation);
            RefresherView.this.Oy = RefresherView.this.mTempLocation[0];
        }

        @Override // com.baidu.adp.widget.f
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.mEmptyView != null) {
                RefresherView.this.drawChild(canvas, RefresherView.this.mEmptyView, drawingTime);
            }
            canvas.save();
            canvas.translate(RefresherView.this.mXOffset >> 1, 0.0f);
            RefresherView.this.drawChild(canvas, RefresherView.this.Ou, drawingTime);
            if (RefresherView.this.mXOffset > 0) {
                RefresherView.this.drawChild(canvas, RefresherView.this.Ov, drawingTime);
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
            if (!RefresherView.this.LD || RefresherView.this.mRefreshing) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            switch (action) {
                case 0:
                    RefresherView.this.JZ = x;
                    removeMessages(1000);
                    removeMessages(1001);
                    break;
                case 2:
                    if (!(RefresherView.this.Ou instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.Ou).getChildAt(0)) == null) {
                        RefresherView.this.Ou.getLocationOnScreen(RefresherView.this.Ow);
                        if (RefresherView.this.Ow[0] == RefresherView.this.Oy && x > RefresherView.this.JZ + this.OL) {
                            RefresherView.this.OF = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.OC;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.Ow);
                        if (RefresherView.this.Ow[0] == RefresherView.this.Oy && x > RefresherView.this.JZ + this.OL) {
                            RefresherView.this.OF = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar2 = RefresherView.this.OC;
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
                    if (RefresherView.this.mXOffset <= RefresherView.this.Oq) {
                        RefresherView.this.Oz = 0;
                    } else {
                        RefresherView.this.refresh();
                    }
                    aI(1000);
                    return true;
                case 2:
                    RefresherView.this.mXOffset = Math.max(0, Math.min((x - RefresherView.this.JZ) - this.OL, RefresherView.this.mMaxHeight * 2));
                    if (RefresherView.this.mXOffset <= RefresherView.this.Oq || RefresherView.this.OF != IRefreshable.State.pulling_no_refresh) {
                        if (RefresherView.this.mXOffset < RefresherView.this.Oq && RefresherView.this.OF == IRefreshable.State.pulling_refresh) {
                            RefresherView.this.OF = IRefreshable.State.pulling_no_refresh;
                            IRefreshable.a aVar = RefresherView.this.OC;
                            if (aVar != null) {
                                aVar.a(IRefreshable.State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.OF = IRefreshable.State.pulling_refresh;
                        IRefreshable.a aVar2 = RefresherView.this.OC;
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
        public void aI(int i) {
            switch (i) {
                case 1000:
                    og();
                    return;
                case 1001:
                    of();
                    return;
                default:
                    return;
            }
        }

        private void of() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Lb = uptimeMillis;
            this.Lc = uptimeMillis + 16;
            this.Lf = true;
            this.OM = RefresherView.this.Oq;
            this.Le = 0.0f;
            this.Ld = RefresherView.this.La;
            removeMessages(1001);
            sendEmptyMessageAtTime(1001, this.Lc);
        }

        private void og() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Lb = uptimeMillis;
            this.Lc = uptimeMillis + 16;
            this.Lf = true;
            this.OM = RefresherView.this.mXOffset - RefresherView.this.Oz;
            this.Le = 0.0f;
            this.Ld = Math.max(RefresherView.this.Op, (RefresherView.this.mXOffset - RefresherView.this.Oz) * 2);
            removeMessages(1000);
            sendEmptyMessageAtTime(1000, this.Lc);
        }

        private void oe() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Le = ((((float) (uptimeMillis - this.Lb)) / 1000.0f) * this.Ld) + this.Le;
            if (this.Le >= this.OM) {
                RefresherView.this.mXOffset = RefresherView.this.Oq;
                this.Lf = false;
                RefresherView.this.OF = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.OC;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                    RefresherView.this.refresh();
                }
            } else {
                RefresherView.this.mXOffset = com.baidu.adp.widget.a.a(this.OM, this.Le, false);
                this.Lb = uptimeMillis;
                this.Lc = uptimeMillis + 16;
                removeMessages(1001);
                sendEmptyMessageAtTime(1001, this.Lc);
            }
            RefresherView.this.invalidate();
        }

        private void od() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Le = ((((float) (uptimeMillis - this.Lb)) / 1000.0f) * this.Ld) + this.Le;
            if (this.Le >= this.OM) {
                RefresherView.this.mXOffset = RefresherView.this.Oz;
                this.Lf = false;
                RefresherView.this.OF = IRefreshable.State.idle;
                IRefreshable.a aVar = RefresherView.this.OC;
                if (aVar != null) {
                    aVar.a(IRefreshable.State.idle);
                }
                if (RefresherView.this.Oz == 0 && aVar != null) {
                    aVar.oc();
                    RefresherView.this.mRefreshing = false;
                }
            } else {
                RefresherView.this.mXOffset = (int) (RefresherView.this.Oz + (this.OM * (1.0f - com.baidu.adp.widget.a.sInterpolator.getInterpolation(this.Le / this.OM))));
                this.Lb = uptimeMillis;
                this.Lc = uptimeMillis + 16;
                removeMessages(1000);
                sendEmptyMessageAtTime(1000, this.Lc);
            }
            RefresherView.this.invalidate();
        }
    }
}
