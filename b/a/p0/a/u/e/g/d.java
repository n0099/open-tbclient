package b.a.p0.a.u.e.g;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.p0.a.u.c.d;
import b.a.p0.a.v2.n0;
import b.a.p0.a.v2.q0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f8127a;

        /* renamed from: b.a.p0.a.u.e.g.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0392a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f8128e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f8129f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f8130g;

            /* renamed from: b.a.p0.a.u.e.g.d$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0393a implements ValueAnimator.AnimatorUpdateListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ b.a.p0.a.p.e.c f8131e;

                public C0393a(RunnableC0392a runnableC0392a, b.a.p0.a.p.e.c cVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0392a, cVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f8131e = cVar;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                        this.f8131e.webViewScrollTo(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                }
            }

            public RunnableC0392a(a aVar, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8130g = aVar;
                this.f8128e = i2;
                this.f8129f = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.a.p0.a.p.e.c h2;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (h2 = b.a.p0.a.g1.f.T().h()) == null) {
                    return;
                }
                ValueAnimator ofInt = ValueAnimator.ofInt(h2.getWebViewScrollY(), d.r(h2, n0.f(this.f8130g.f8127a.getContext(), this.f8128e)));
                ofInt.setDuration(this.f8129f);
                ofInt.addUpdateListener(new C0393a(this, h2));
                ofInt.start();
            }
        }

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8127a = dVar;
        }

        @Override // b.a.p0.a.u.c.d.b
        public b.a.p0.a.u.h.b a(b.a.p0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                int optInt = jSONObject.optInt("scrollTop", -1);
                int optInt2 = jSONObject.optInt("duration", -1);
                if (optInt > -1 && optInt2 > -1) {
                    q0.b0(new RunnableC0392a(this, optInt, optInt2));
                    return new b.a.p0.a.u.h.b(0);
                }
                b.a.p0.a.e0.d.b("Api-PageScrollTo", "illegal scrollTop or duration");
                return new b.a.p0.a.u.h.b(1001, "illegal params");
            }
            return (b.a.p0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull b.a.p0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static int r(@NonNull b.a.p0.a.p.e.c cVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, cVar, i2)) == null) {
            int contentHeight = ((int) (cVar.getContentHeight() * cVar.getScale())) - ((Integer) b.a.p0.a.g1.f.T().q().second).intValue();
            if (contentHeight <= 0) {
                return 0;
            }
            return i2 > contentHeight ? contentHeight : i2;
        }
        return invokeLI.intValue;
    }

    public b.a.p0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            boolean z = b.a.p0.a.u.c.d.f8000c;
            return i(str, false, new a(this));
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}
