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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class BdExpandListView extends BdListView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context G;
    public final Scroller H;
    public View I;
    public int J;
    public float K;
    public float L;
    public c M;
    public boolean N;
    public float O;
    public float P;
    public final int Q;
    public final int R;
    public b S;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdExpandListView a;

        public a(BdExpandListView bdExpandListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdExpandListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdExpandListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.I.setLayoutParams(new AbsListView.LayoutParams(this.a.I.getWidth(), this.a.J));
                this.a.invalidate();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(float f2);

        void b();

        void onRefresh();
    }

    /* loaded from: classes3.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f23950b;

        public c(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i2;
            this.f23950b = i4;
        }

        public int a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) ? (int) (this.a + (f2 / 2.5f)) : invokeF.intValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.N = false;
        this.G = context;
        this.H = new Scroller(this.G);
        this.Q = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0400c5, R.attr.obfuscated_res_0x7f0401ee});
        this.R = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
    }

    public final void I(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            this.S.a(360.0f - ((f2 * 360.0f) / this.R));
        }
    }

    public void J() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.S) == null) {
            return;
        }
        bVar.onRefresh();
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.M == null) {
            return;
        }
        if (this.I.getHeight() >= this.M.f23950b - (this.R / 2)) {
            J();
        } else {
            this.S.b();
        }
        this.H.startScroll(0, this.I.getHeight(), 0, this.M.a - this.I.getHeight(), 200);
        invalidate();
        this.N = false;
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.H.computeScrollOffset()) {
                this.I.setLayoutParams(new AbsListView.LayoutParams(this.I.getWidth(), this.H.getCurrY()));
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (this.H.isFinished()) {
                float y = motionEvent.getY();
                this.L = y;
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float f2 = this.P;
                            float f3 = f2 - this.O;
                            float f4 = y - this.K;
                            this.O = f2;
                            if (this.I.getParent() == this && this.M != null && this.I.isShown() && this.I.getTop() >= 0 && Math.abs(f4) >= this.Q && Math.abs(f3) < this.Q) {
                                int a2 = this.M.a(this.L - this.K);
                                c cVar = this.M;
                                if (a2 > cVar.a && a2 <= cVar.f23950b) {
                                    this.N = true;
                                    this.I.setLayoutParams(new AbsListView.LayoutParams(this.I.getWidth(), a2));
                                    I(a2 - this.M.a);
                                } else {
                                    c cVar2 = this.M;
                                    if (a2 <= cVar2.a) {
                                        this.N = false;
                                    } else if (a2 > cVar2.f23950b) {
                                        this.N = true;
                                    } else {
                                        this.N = false;
                                    }
                                }
                            } else {
                                this.N = false;
                            }
                        }
                    }
                    if (this.N) {
                        K();
                    } else {
                        this.S.b();
                    }
                    new Handler().postDelayed(new a(this), 200L);
                } else {
                    int height = this.I.getHeight();
                    this.K = this.L;
                    this.O = this.P;
                    this.M = new c(0, height, 0, this.R + height);
                }
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            if (this.N) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            if (this.N) {
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setExpandListRefreshListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.S = bVar;
        }
    }

    public void setExpandView(View view, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, i) == null) {
            this.I = view;
            this.J = i;
        }
    }
}
