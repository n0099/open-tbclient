package c.a.p0.j.n;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import c.a.p0.a.h1.c.f;
import c.a.p0.a.h1.c.h.d;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final Boolean f11747h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f11748a;

    /* renamed from: b  reason: collision with root package name */
    public Marker f11749b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f11750c;

    /* renamed from: d  reason: collision with root package name */
    public View f11751d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f11752e;

    /* renamed from: f  reason: collision with root package name */
    public Marker f11753f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f11754g;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f11755e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f11756f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0614b f11757g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f11758h;

        public a(b bVar, c cVar, InterfaceC0614b interfaceC0614b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar, interfaceC0614b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11758h = bVar;
            this.f11756f = cVar;
            this.f11757g = interfaceC0614b;
            this.f11755e = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                this.f11758h.a(this.f11756f, (LatLng) valueAnimator.getAnimatedValue());
                if (this.f11755e || animatedFraction <= 0.99d) {
                    return;
                }
                this.f11755e = true;
                InterfaceC0614b interfaceC0614b = this.f11757g;
                if (interfaceC0614b != null) {
                    interfaceC0614b.onAnimationEnd();
                }
            }
        }
    }

    /* renamed from: c.a.p0.j.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0614b {
        void onAnimationEnd();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1101212056, "Lc/a/p0/j/n/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1101212056, "Lc/a/p0/j/n/b;");
                return;
            }
        }
        f11747h = Boolean.TRUE;
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
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, cVar, latLng) == null) || (marker = this.f11749b) == null) {
            return;
        }
        marker.setPosition(latLng);
        c.a.p0.a.h1.c.h.c cVar2 = this.f11748a.f6536f;
        cVar2.f6533e = latLng.latitude;
        cVar2.f6534f = latLng.longitude;
        Marker marker2 = this.f11753f;
        if (marker2 != null) {
            marker2.setPosition(latLng);
        }
        if (f11747h.booleanValue()) {
            Marker marker3 = this.f11750c;
            if (marker3 != null) {
                marker3.setPosition(latLng);
            }
            ViewGroup viewGroup = this.f11752e;
            if (viewGroup != null) {
                cVar.l.removeView(viewGroup);
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                cVar.l.addView(this.f11752e, builder.build());
                this.f11752e.setAlpha(0.0f);
            }
        }
    }

    public void b(c cVar) {
        d dVar;
        d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || (dVar = this.f11748a) == null || (bVar = dVar.m) == null || !bVar.isValid()) {
            return;
        }
        d dVar2 = this.f11748a;
        if (dVar2.o == null || this.f11751d != null || TextUtils.equals(dVar2.m.k, "ALWAYS")) {
            return;
        }
        cVar.l.removeView(this.f11752e);
        this.f11752e.removeView(this.f11751d);
        View a2 = c.a.p0.j.k.f.a.a(cVar, this.f11748a);
        this.f11751d = a2;
        this.f11752e.addView(a2, 0);
        this.f11752e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
        builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
        builder.position(this.f11749b.getPosition());
        Bitmap bitmap = this.f11749b.getIcon().getBitmap();
        builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.f11748a.o.f6542f)) + 0.0d));
        cVar.l.addView(this.f11752e, builder.build());
        this.f11752e.setAlpha(0.0f);
        Marker marker = this.f11753f;
        if (marker != null) {
            marker.remove();
        }
        BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.f11752e);
        if (fromView == null) {
            return;
        }
        Bitmap bitmap2 = fromView.getBitmap();
        if (bitmap2.getHeight() <= 0 || bitmap2.getWidth() <= 0) {
            return;
        }
        float width = ((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.f11748a.o.f6541e * bitmap.getWidth()))) / bitmap2.getWidth();
        float height = ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.f11748a.o.f6542f * bitmap.getHeight()))) / fromView.getBitmap().getHeight();
        MarkerOptions markerOptions = new MarkerOptions();
        c.a.p0.a.h1.c.h.c cVar2 = this.f11748a.f6536f;
        this.f11753f = (Marker) cVar.l.getMap().addOverlay(markerOptions.position(new LatLng(cVar2.f6533e, cVar2.f6534f)).icon(fromView).zIndex(66).anchor(width, height));
    }

    public void c(c cVar, LatLng latLng, f fVar, InterfaceC0614b interfaceC0614b) {
        Marker marker;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, cVar, latLng, fVar, interfaceC0614b) == null) {
            ValueAnimator valueAnimator = this.f11754g;
            if ((valueAnimator == null || !valueAnimator.isRunning()) && (marker = this.f11749b) != null) {
                float f2 = 360.0f - ((float) fVar.F);
                if (f2 >= 0.0f && f2 <= 360.0f) {
                    marker.setRotate(f2);
                }
                int i2 = fVar.G;
                if (i2 < 0) {
                    i2 = -i2;
                }
                ValueAnimator ofObject = ValueAnimator.ofObject(new c.a.p0.j.k.e.h.a(), this.f11749b.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
                this.f11754g = ofObject;
                ofObject.setDuration(i2);
                this.f11754g.addUpdateListener(new a(this, cVar, interfaceC0614b));
                this.f11754g.start();
            }
        }
    }
}
