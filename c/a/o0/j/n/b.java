package c.a.o0.j.n;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import c.a.o0.a.h1.c.f;
import c.a.o0.a.h1.c.h.d;
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
    public static final Boolean f11719h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f11720a;

    /* renamed from: b  reason: collision with root package name */
    public Marker f11721b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f11722c;

    /* renamed from: d  reason: collision with root package name */
    public View f11723d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f11724e;

    /* renamed from: f  reason: collision with root package name */
    public Marker f11725f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f11726g;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f11727e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f11728f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0612b f11729g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f11730h;

        public a(b bVar, c cVar, InterfaceC0612b interfaceC0612b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar, interfaceC0612b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11730h = bVar;
            this.f11728f = cVar;
            this.f11729g = interfaceC0612b;
            this.f11727e = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                this.f11730h.a(this.f11728f, (LatLng) valueAnimator.getAnimatedValue());
                if (this.f11727e || animatedFraction <= 0.99d) {
                    return;
                }
                this.f11727e = true;
                InterfaceC0612b interfaceC0612b = this.f11729g;
                if (interfaceC0612b != null) {
                    interfaceC0612b.onAnimationEnd();
                }
            }
        }
    }

    /* renamed from: c.a.o0.j.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0612b {
        void onAnimationEnd();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(706242407, "Lc/a/o0/j/n/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(706242407, "Lc/a/o0/j/n/b;");
                return;
            }
        }
        f11719h = Boolean.TRUE;
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
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, cVar, latLng) == null) || (marker = this.f11721b) == null) {
            return;
        }
        marker.setPosition(latLng);
        c.a.o0.a.h1.c.h.c cVar2 = this.f11720a.f6508f;
        cVar2.f6505e = latLng.latitude;
        cVar2.f6506f = latLng.longitude;
        Marker marker2 = this.f11725f;
        if (marker2 != null) {
            marker2.setPosition(latLng);
        }
        if (f11719h.booleanValue()) {
            Marker marker3 = this.f11722c;
            if (marker3 != null) {
                marker3.setPosition(latLng);
            }
            ViewGroup viewGroup = this.f11724e;
            if (viewGroup != null) {
                cVar.l.removeView(viewGroup);
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                cVar.l.addView(this.f11724e, builder.build());
                this.f11724e.setAlpha(0.0f);
            }
        }
    }

    public void b(c cVar) {
        d dVar;
        d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || (dVar = this.f11720a) == null || (bVar = dVar.m) == null || !bVar.isValid()) {
            return;
        }
        d dVar2 = this.f11720a;
        if (dVar2.o == null || this.f11723d != null || TextUtils.equals(dVar2.m.k, "ALWAYS")) {
            return;
        }
        cVar.l.removeView(this.f11724e);
        this.f11724e.removeView(this.f11723d);
        View a2 = c.a.o0.j.k.f.a.a(cVar, this.f11720a);
        this.f11723d = a2;
        this.f11724e.addView(a2, 0);
        this.f11724e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
        builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
        builder.position(this.f11721b.getPosition());
        Bitmap bitmap = this.f11721b.getIcon().getBitmap();
        builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.f11720a.o.f6514f)) + 0.0d));
        cVar.l.addView(this.f11724e, builder.build());
        this.f11724e.setAlpha(0.0f);
        Marker marker = this.f11725f;
        if (marker != null) {
            marker.remove();
        }
        BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.f11724e);
        if (fromView == null) {
            return;
        }
        Bitmap bitmap2 = fromView.getBitmap();
        if (bitmap2.getHeight() <= 0 || bitmap2.getWidth() <= 0) {
            return;
        }
        float width = ((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.f11720a.o.f6513e * bitmap.getWidth()))) / bitmap2.getWidth();
        float height = ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.f11720a.o.f6514f * bitmap.getHeight()))) / fromView.getBitmap().getHeight();
        MarkerOptions markerOptions = new MarkerOptions();
        c.a.o0.a.h1.c.h.c cVar2 = this.f11720a.f6508f;
        this.f11725f = (Marker) cVar.l.getMap().addOverlay(markerOptions.position(new LatLng(cVar2.f6505e, cVar2.f6506f)).icon(fromView).zIndex(66).anchor(width, height));
    }

    public void c(c cVar, LatLng latLng, f fVar, InterfaceC0612b interfaceC0612b) {
        Marker marker;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, cVar, latLng, fVar, interfaceC0612b) == null) {
            ValueAnimator valueAnimator = this.f11726g;
            if ((valueAnimator == null || !valueAnimator.isRunning()) && (marker = this.f11721b) != null) {
                float f2 = 360.0f - ((float) fVar.F);
                if (f2 >= 0.0f && f2 <= 360.0f) {
                    marker.setRotate(f2);
                }
                int i2 = fVar.G;
                if (i2 < 0) {
                    i2 = -i2;
                }
                ValueAnimator ofObject = ValueAnimator.ofObject(new c.a.o0.j.k.e.h.a(), this.f11721b.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
                this.f11726g = ofObject;
                ofObject.setDuration(i2);
                this.f11726g.addUpdateListener(new a(this, cVar, interfaceC0612b));
                this.f11726g.start();
            }
        }
    }
}
