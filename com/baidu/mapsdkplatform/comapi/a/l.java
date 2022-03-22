package com.baidu.mapsdkplatform.comapi.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.graphics.Point;
import android.view.animation.Interpolator;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class l extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Animator a;

    /* renamed from: b  reason: collision with root package name */
    public long f26622b;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f26623c;

    /* renamed from: d  reason: collision with root package name */
    public Animation.AnimationListener f26624d;

    /* renamed from: e  reason: collision with root package name */
    public int f26625e;

    /* renamed from: f  reason: collision with root package name */
    public int f26626f;

    /* renamed from: g  reason: collision with root package name */
    public Object[] f26627g;

    @TargetApi(11)
    /* loaded from: classes4.dex */
    public class a implements TypeEvaluator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lVar;
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f2, Object obj, Object obj2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), obj, obj2})) == null) {
                LatLng latLng = (LatLng) obj;
                LatLng latLng2 = (LatLng) obj2;
                double d2 = latLng.longitude;
                double d3 = f2;
                double d4 = d2 + ((latLng2.longitude - d2) * d3);
                double d5 = latLng.latitude;
                return new LatLng(d5 + (d3 * (latLng2.latitude - d5)), d4);
            }
            return invokeCommon.objValue;
        }
    }

    @TargetApi(11)
    /* loaded from: classes4.dex */
    public class b implements TypeEvaluator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        public b(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lVar;
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f2, Object obj, Object obj2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), obj, obj2})) == null) {
                Point point = (Point) obj;
                Point point2 = (Point) obj2;
                int i = point.x;
                float f3 = i + ((point2.x - i) * f2);
                int i2 = point.y;
                return new Point((int) f3, (int) (i2 + (f2 * (point2.y - i2))));
            }
            return invokeCommon.objValue;
        }
    }

    public l(Point... pointArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pointArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f26622b = 0L;
        this.f26623c = null;
        this.f26624d = null;
        this.f26625e = 1;
        this.f26626f = 0;
        this.f26627g = pointArr;
    }

    public l(LatLng... latLngArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {latLngArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f26622b = 0L;
        this.f26623c = null;
        this.f26624d = null;
        this.f26625e = 1;
        this.f26626f = 0;
        this.f26627g = latLngArr;
    }

    @TargetApi(11)
    public ObjectAnimator a(Marker marker) {
        InterceptResult invokeL;
        ObjectAnimator ofObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, marker)) == null) {
            if (marker.isFixed()) {
                if (!(this.f26627g[0] instanceof Point)) {
                    throw new ClassCastException("BDMapSDKException: if the marker is fixed on screen, the parameters of Transformation must be android.graphics.Point");
                }
                ofObject = ObjectAnimator.ofObject(marker, "fixedScreenPosition", new b(this), this.f26627g);
            } else if (!(this.f26627g[0] instanceof LatLng)) {
                throw new ClassCastException("BDMapSDKException: if the marker isn't fixed on screen, the parameters of Transformation must be Latlng");
            } else {
                ofObject = ObjectAnimator.ofObject(marker, "position", new a(this), this.f26627g);
            }
            if (ofObject != null) {
                ofObject.setRepeatCount(this.f26626f);
                ofObject.setRepeatMode(c());
                ofObject.setDuration(this.f26622b);
                Interpolator interpolator = this.f26623c;
                if (interpolator != null) {
                    ofObject.setInterpolator(interpolator);
                }
            }
            return ofObject;
        }
        return (ObjectAnimator) invokeL.objValue;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a() {
        Animator animator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (animator = this.a) == null) {
            return;
        }
        animator.start();
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.f26625e = i;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            if (j < 0) {
                j = 0;
            }
            this.f26622b = j;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Animator animator) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, animator) == null) || animator == null) {
            return;
        }
        animator.addListener(new m(this));
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Interpolator interpolator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, interpolator) == null) {
            this.f26623c = interpolator;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, animationListener) == null) {
            this.f26624d = animationListener;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Marker marker, Animation animation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, marker, animation) == null) {
            ObjectAnimator a2 = a(marker);
            this.a = a2;
            a(a2);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void b() {
        Animator animator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (animator = this.a) == null) {
            return;
        }
        animator.cancel();
        this.a = null;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            if (i > 0 || i == -1) {
                this.f26626f = i;
            }
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f26625e : invokeV.intValue;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
        }
    }
}
