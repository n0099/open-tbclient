package c.a.r0.m.o;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import c.a.r0.a.i1.c.f;
import c.a.r0.a.i1.c.h.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final Boolean f11376h;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;

    /* renamed from: b  reason: collision with root package name */
    public Marker f11377b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f11378c;

    /* renamed from: d  reason: collision with root package name */
    public View f11379d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f11380e;

    /* renamed from: f  reason: collision with root package name */
    public Marker f11381f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f11382g;

    /* loaded from: classes6.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f11383e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f11384f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0787b f11385g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f11386h;

        public a(b bVar, c cVar, InterfaceC0787b interfaceC0787b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar, interfaceC0787b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11386h = bVar;
            this.f11384f = cVar;
            this.f11385g = interfaceC0787b;
            this.f11383e = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                this.f11386h.a(this.f11384f, (LatLng) valueAnimator.getAnimatedValue());
                if (this.f11383e || animatedFraction <= 0.99d) {
                    return;
                }
                this.f11383e = true;
                InterfaceC0787b interfaceC0787b = this.f11385g;
                if (interfaceC0787b != null) {
                    interfaceC0787b.onAnimationEnd();
                }
            }
        }
    }

    /* renamed from: c.a.r0.m.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0787b {
        void onAnimationEnd();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-335236442, "Lc/a/r0/m/o/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-335236442, "Lc/a/r0/m/o/b;");
                return;
            }
        }
        f11376h = Boolean.TRUE;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void a(c cVar, LatLng latLng) {
        Marker marker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, cVar, latLng) == null) || (marker = this.f11377b) == null) {
            return;
        }
        marker.setPosition(latLng);
        c.a.r0.a.i1.c.h.c cVar2 = this.a.f7217f;
        cVar2.f7214e = latLng.latitude;
        cVar2.f7215f = latLng.longitude;
        Marker marker2 = this.f11381f;
        if (marker2 != null) {
            marker2.setPosition(latLng);
        }
        if (f11376h.booleanValue()) {
            Marker marker3 = this.f11378c;
            if (marker3 != null) {
                marker3.setPosition(latLng);
            }
            ViewGroup viewGroup = this.f11380e;
            if (viewGroup != null) {
                cVar.l.removeView(viewGroup);
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                cVar.l.addView(this.f11380e, builder.build());
                this.f11380e.setAlpha(0.0f);
            }
        }
    }

    public void b(c cVar) {
        d dVar;
        d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || (dVar = this.a) == null || (bVar = dVar.m) == null || !bVar.isValid()) {
            return;
        }
        d dVar2 = this.a;
        if (dVar2.o == null || this.f11379d != null || TextUtils.equals(dVar2.m.k, "ALWAYS")) {
            return;
        }
        cVar.l.removeView(this.f11380e);
        this.f11380e.removeView(this.f11379d);
        View a2 = c.a.r0.m.l.f.a.a(cVar, this.a);
        this.f11379d = a2;
        this.f11380e.addView(a2, 0);
        this.f11380e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
        builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
        builder.position(this.f11377b.getPosition());
        Bitmap bitmap = this.f11377b.getIcon().getBitmap();
        builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.a.o.f7223f)) + 0.0d));
        cVar.l.addView(this.f11380e, builder.build());
        this.f11380e.setAlpha(0.0f);
        Marker marker = this.f11381f;
        if (marker != null) {
            marker.remove();
        }
        BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.f11380e);
        if (fromView == null) {
            return;
        }
        Bitmap bitmap2 = fromView.getBitmap();
        if (bitmap2.getHeight() <= 0 || bitmap2.getWidth() <= 0) {
            return;
        }
        float width = ((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.a.o.f7222e * bitmap.getWidth()))) / bitmap2.getWidth();
        float height = ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.a.o.f7223f * bitmap.getHeight()))) / fromView.getBitmap().getHeight();
        MarkerOptions markerOptions = new MarkerOptions();
        c.a.r0.a.i1.c.h.c cVar2 = this.a.f7217f;
        this.f11381f = (Marker) cVar.l.getMap().addOverlay(markerOptions.position(new LatLng(cVar2.f7214e, cVar2.f7215f)).icon(fromView).zIndex(66).anchor(width, height));
    }

    public void c(c cVar, LatLng latLng, f fVar, InterfaceC0787b interfaceC0787b) {
        Marker marker;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, cVar, latLng, fVar, interfaceC0787b) == null) {
            ValueAnimator valueAnimator = this.f11382g;
            if ((valueAnimator == null || !valueAnimator.isRunning()) && (marker = this.f11377b) != null) {
                float f2 = 360.0f - ((float) fVar.F);
                if (f2 >= 0.0f && f2 <= 360.0f) {
                    marker.setRotate(f2);
                }
                int i2 = fVar.G;
                if (i2 < 0) {
                    i2 = -i2;
                }
                ValueAnimator ofObject = ValueAnimator.ofObject(new c.a.r0.m.l.e.h.a(), this.f11377b.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
                this.f11382g = ofObject;
                ofObject.setDuration(i2);
                this.f11382g.addUpdateListener(new a(this, cVar, interfaceC0787b));
                this.f11382g.start();
            }
        }
    }
}
