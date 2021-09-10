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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class BdExpandListView extends BdListView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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
    public b mRefreshListener;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdExpandListView f36443e;

        public a(BdExpandListView bdExpandListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdExpandListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36443e = bdExpandListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f36443e.M.setLayoutParams(new AbsListView.LayoutParams(this.f36443e.M.getWidth(), this.f36443e.N));
                this.f36443e.invalidate();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(float f2);

        void b();

        void onRefresh();
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f36444a;

        /* renamed from: b  reason: collision with root package name */
        public int f36445b;

        public c(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36444a = i3;
            this.f36445b = i5;
        }

        public int a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) ? (int) (this.f36444a + (f2 / 2.5f)) : invokeF.intValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.R = false;
        this.K = context;
        this.L = new Scroller(this.K);
        this.U = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.V = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.L.computeScrollOffset()) {
                this.M.setLayoutParams(new AbsListView.LayoutParams(this.M.getWidth(), this.L.getCurrY()));
                return;
            }
            super.computeScroll();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
        if (r0 != 3) goto L14;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
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
                                if (a2 > cVar.f36444a && a2 <= cVar.f36445b) {
                                    this.R = true;
                                    this.M.setLayoutParams(new AbsListView.LayoutParams(this.M.getWidth(), a2));
                                    z(a2 - this.Q.f36444a);
                                } else {
                                    c cVar2 = this.Q;
                                    if (a2 <= cVar2.f36444a) {
                                        this.R = false;
                                    } else if (a2 > cVar2.f36445b) {
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
                        scrollCallback();
                    } else {
                        this.mRefreshListener.b();
                    }
                    new Handler().postDelayed(new a(this), 200L);
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
        return invokeL.booleanValue;
    }

    public void doRefresh() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bVar = this.mRefreshListener) == null) {
            return;
        }
        bVar.onRefresh();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            if (this.R) {
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            if (this.R) {
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void scrollCallback() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.Q == null) {
            return;
        }
        if (this.M.getHeight() >= this.Q.f36445b - (this.V / 2)) {
            doRefresh();
        } else {
            this.mRefreshListener.b();
        }
        this.L.startScroll(0, this.M.getHeight(), 0, this.Q.f36444a - this.M.getHeight(), 200);
        invalidate();
        this.R = false;
    }

    public void setExpandListRefreshListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.mRefreshListener = bVar;
        }
    }

    public void setExpandView(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, view, i2) == null) {
            this.M = view;
            this.N = i2;
        }
    }

    public final void z(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) {
            this.mRefreshListener.a(360.0f - ((f2 * 360.0f) / this.V));
        }
    }
}
