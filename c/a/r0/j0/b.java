package c.a.r0.j0;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b extends c.a.r0.j0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public ScaleGestureDetector f19461h;

    /* renamed from: i  reason: collision with root package name */
    public InterfaceC0938b f19462i;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.r0.j0.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0938b {
        void a(boolean z);
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19461h = new ScaleGestureDetector(context, new c(this, null));
    }

    @Override // c.a.r0.j0.a
    public boolean c(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            try {
                this.f19461h.onTouchEvent(motionEvent);
                return super.c(motionEvent);
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void i(InterfaceC0938b interfaceC0938b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0938b) == null) {
            this.f19462i = interfaceC0938b;
        }
    }

    /* loaded from: classes3.dex */
    public final class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f19463e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f19464f;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19464f = bVar;
            this.f19463e = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, scaleGestureDetector)) == null) {
                if (scaleGestureDetector != null && this.f19464f.f19462i != null) {
                    float scaleFactor = scaleGestureDetector.getScaleFactor();
                    if (!this.f19463e && scaleFactor > 1.0f) {
                        this.f19463e = true;
                        this.f19464f.f19462i.a(true);
                    } else if (!this.f19463e && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                        this.f19463e = true;
                        this.f19464f.f19462i.a(false);
                    }
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, scaleGestureDetector)) == null) {
                this.f19463e = false;
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, scaleGestureDetector) == null) {
                this.f19463e = true;
            }
        }

        public /* synthetic */ c(b bVar, a aVar) {
            this(bVar);
        }
    }
}
