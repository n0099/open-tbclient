package b.a.r0.x0.i2;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import b.a.r0.k0.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f27416a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f27417b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f27418c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.k0.b f27419d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f27420e;

    /* renamed from: f  reason: collision with root package name */
    public VelocityTracker f27421f;

    /* renamed from: g  reason: collision with root package name */
    public a.b f27422g;

    /* loaded from: classes6.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f27423a;

        public a(b bVar) {
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
            this.f27423a = bVar;
        }

        @Override // b.a.r0.k0.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) && e(i3)) {
                this.f27423a.e(true);
            }
        }

        @Override // b.a.r0.k0.a.b
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) && e(i3)) {
                this.f27423a.e(false);
            }
        }

        @Override // b.a.r0.k0.a.b
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            }
        }

        @Override // b.a.r0.k0.a.b
        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            }
        }

        public final boolean e(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f2)) == null) ? Math.abs(f2) >= 10.0f : invokeF.booleanValue;
        }
    }

    public b(Context context, BdUniqueId bdUniqueId, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27418c = false;
        this.f27422g = new a(this);
        this.f27416a = context;
        this.f27417b = bdUniqueId;
        this.f27420e = z;
        if (z) {
            b.a.r0.k0.b bVar = new b.a.r0.k0.b(context);
            this.f27419d = bVar;
            bVar.d(this.f27422g);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
        if (r5 != 3) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(View view, MotionEvent motionEvent) {
        b.a.r0.k0.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view, motionEvent) == null) {
            if (this.f27421f == null) {
                this.f27421f = VelocityTracker.obtain();
            }
            this.f27421f.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action == 2) {
                    this.f27421f.computeCurrentVelocity(1000);
                    if (Math.abs(this.f27421f.getXVelocity()) > Math.abs(this.f27421f.getYVelocity())) {
                        this.f27420e = false;
                    } else {
                        this.f27420e = true;
                    }
                }
                if (this.f27420e || (bVar = this.f27419d) == null) {
                }
                bVar.c(motionEvent);
                return;
            }
            c();
            if (this.f27420e) {
            }
        }
    }

    public final void c() {
        VelocityTracker velocityTracker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (velocityTracker = this.f27421f) == null) {
            return;
        }
        velocityTracker.clear();
        this.f27421f.recycle();
        this.f27421f = null;
    }

    public final void d(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                CustomMessage customMessage = new CustomMessage(2001617);
                customMessage.setTag(this.f27417b);
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001617, Boolean.valueOf(z2));
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            CustomMessage customMessage2 = new CustomMessage(2001618);
            customMessage2.setTag(this.f27417b);
            CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2001618, Boolean.valueOf(z2));
            customResponsedMessage2.setOrginalMessage(customMessage2);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
        }
    }

    public final void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f27418c = z;
            if (this.f27420e) {
                d(!z, true);
            }
        }
    }
}
