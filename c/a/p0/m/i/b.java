package c.a.p0.m.i;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import c.a.p0.a.y0.c.f;
import c.a.p0.a.y0.c.h.d;
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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final Boolean f10843h;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;

    /* renamed from: b  reason: collision with root package name */
    public Marker f10844b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f10845c;

    /* renamed from: d  reason: collision with root package name */
    public View f10846d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f10847e;

    /* renamed from: f  reason: collision with root package name */
    public Marker f10848f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f10849g;

    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f10850e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f10851f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0752b f10852g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f10853h;

        public a(b bVar, c cVar, InterfaceC0752b interfaceC0752b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar, interfaceC0752b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10853h = bVar;
            this.f10851f = cVar;
            this.f10852g = interfaceC0752b;
            this.f10850e = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                this.f10853h.a(this.f10851f, (LatLng) valueAnimator.getAnimatedValue());
                if (this.f10850e || animatedFraction <= 0.99d) {
                    return;
                }
                this.f10850e = true;
                InterfaceC0752b interfaceC0752b = this.f10852g;
                if (interfaceC0752b != null) {
                    interfaceC0752b.onAnimationEnd();
                }
            }
        }
    }

    /* renamed from: c.a.p0.m.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0752b {
        void onAnimationEnd();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1015473558, "Lc/a/p0/m/i/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1015473558, "Lc/a/p0/m/i/b;");
                return;
            }
        }
        f10843h = Boolean.TRUE;
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
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, cVar, latLng) == null) || (marker = this.f10844b) == null) {
            return;
        }
        marker.setPosition(latLng);
        c.a.p0.a.y0.c.h.c cVar2 = this.a.f9192f;
        cVar2.f9189e = latLng.latitude;
        cVar2.f9190f = latLng.longitude;
        Marker marker2 = this.f10848f;
        if (marker2 != null) {
            marker2.setPosition(latLng);
        }
        if (f10843h.booleanValue()) {
            Marker marker3 = this.f10845c;
            if (marker3 != null) {
                marker3.setPosition(latLng);
            }
            ViewGroup viewGroup = this.f10847e;
            if (viewGroup != null) {
                cVar.l.removeView(viewGroup);
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                cVar.l.addView(this.f10847e, builder.build());
                this.f10847e.setAlpha(0.0f);
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
        if (dVar2.o == null || this.f10846d != null || TextUtils.equals(dVar2.m.k, "ALWAYS")) {
            return;
        }
        cVar.l.removeView(this.f10847e);
        this.f10847e.removeView(this.f10846d);
        View a2 = c.a.p0.m.f.f.a.a(cVar, this.a);
        this.f10846d = a2;
        this.f10847e.addView(a2, 0);
        this.f10847e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
        builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
        builder.position(this.f10844b.getPosition());
        Bitmap bitmap = this.f10844b.getIcon().getBitmap();
        builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.a.o.f9198f)) + 0.0d));
        cVar.l.addView(this.f10847e, builder.build());
        this.f10847e.setAlpha(0.0f);
        Marker marker = this.f10848f;
        if (marker != null) {
            marker.remove();
        }
        BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.f10847e);
        if (fromView == null) {
            return;
        }
        Bitmap bitmap2 = fromView.getBitmap();
        if (bitmap2.getHeight() <= 0 || bitmap2.getWidth() <= 0) {
            return;
        }
        float width = ((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.a.o.f9197e * bitmap.getWidth()))) / bitmap2.getWidth();
        float height = ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.a.o.f9198f * bitmap.getHeight()))) / fromView.getBitmap().getHeight();
        MarkerOptions markerOptions = new MarkerOptions();
        c.a.p0.a.y0.c.h.c cVar2 = this.a.f9192f;
        this.f10848f = (Marker) cVar.l.getMap().addOverlay(markerOptions.position(new LatLng(cVar2.f9189e, cVar2.f9190f)).icon(fromView).zIndex(66).anchor(width, height));
    }

    public void c(c cVar, LatLng latLng, f fVar, InterfaceC0752b interfaceC0752b) {
        Marker marker;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, cVar, latLng, fVar, interfaceC0752b) == null) {
            ValueAnimator valueAnimator = this.f10849g;
            if ((valueAnimator == null || !valueAnimator.isRunning()) && (marker = this.f10844b) != null) {
                float f2 = 360.0f - ((float) fVar.F);
                if (f2 >= 0.0f && f2 <= 360.0f) {
                    marker.setRotate(f2);
                }
                int i2 = fVar.G;
                if (i2 < 0) {
                    i2 = -i2;
                }
                ValueAnimator ofObject = ValueAnimator.ofObject(new c.a.p0.m.f.e.h.a(), this.f10844b.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
                this.f10849g = ofObject;
                ofObject.setDuration(i2);
                this.f10849g.addUpdateListener(new a(this, cVar, interfaceC0752b));
                this.f10849g.start();
            }
        }
    }
}
