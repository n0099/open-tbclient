package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.Scroller;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class BdExpandListView extends BdListView {
    public final Context K;
    public final Scroller L;
    public View M;
    public int N;
    public float O;
    public float P;
    public c Q;
    public boolean R;
    public float S;
    public float T;
    public final int U;
    public final int V;
    public b W;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BdExpandListView.this.M.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.M.getWidth(), BdExpandListView.this.N));
            BdExpandListView.this.invalidate();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        void b(float f2);

        void onRefresh();
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f2295a;

        /* renamed from: b  reason: collision with root package name */
        public int f2296b;

        public c(int i, int i2, int i3, int i4) {
            this.f2295a = i2;
            this.f2296b = i4;
        }

        public int a(float f2) {
            return (int) (this.f2295a + (f2 / 2.5f));
        }
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.R = false;
        this.K = context;
        this.L = new Scroller(this.K);
        this.U = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.V = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public final void I(float f2) {
        this.W.b(360.0f - ((f2 * 360.0f) / this.V));
    }

    public void J() {
        b bVar = this.W;
        if (bVar != null) {
            bVar.onRefresh();
        }
    }

    public void K() {
        if (this.Q == null) {
            return;
        }
        if (this.M.getHeight() >= this.Q.f2296b - (this.V / 2)) {
            J();
        } else {
            this.W.a();
        }
        this.L.startScroll(0, this.M.getHeight(), 0, this.Q.f2295a - this.M.getHeight(), 200);
        invalidate();
        this.R = false;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.L.computeScrollOffset()) {
            this.M.setLayoutParams(new AbsListView.LayoutParams(this.M.getWidth(), this.L.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r0 != 3) goto L12;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.L.isFinished()) {
            float y = motionEvent.getY();
            this.P = y;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float f2 = this.T;
                        float f3 = f2 - this.S;
                        float f4 = y - this.O;
                        this.S = f2;
                        if (this.M.getParent() == this && this.Q != null && this.M.isShown() && this.M.getTop() >= 0 && Math.abs(f4) >= this.U && Math.abs(f3) < this.U) {
                            int a2 = this.Q.a(this.P - this.O);
                            c cVar = this.Q;
                            if (a2 > cVar.f2295a && a2 <= cVar.f2296b) {
                                this.R = true;
                                this.M.setLayoutParams(new AbsListView.LayoutParams(this.M.getWidth(), a2));
                                I(a2 - this.Q.f2295a);
                            } else {
                                c cVar2 = this.Q;
                                if (a2 <= cVar2.f2295a) {
                                    this.R = false;
                                } else if (a2 > cVar2.f2296b) {
                                    this.R = true;
                                } else {
                                    this.R = false;
                                }
                            }
                        } else {
                            this.R = false;
                        }
                    }
                }
                if (this.R) {
                    K();
                } else {
                    this.W.a();
                }
                new Handler().postDelayed(new a(), 200L);
            } else {
                int height = this.M.getHeight();
                this.O = this.P;
                this.S = this.T;
                this.Q = new c(0, height, 0, this.V + height);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.R) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.R) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setExpandListRefreshListener(b bVar) {
        this.W = bVar;
    }

    public void setExpandView(View view, int i) {
        this.M = view;
        this.N = i;
    }
}
