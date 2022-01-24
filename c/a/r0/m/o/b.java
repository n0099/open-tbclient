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
    public static final Boolean f11518h;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;

    /* renamed from: b  reason: collision with root package name */
    public Marker f11519b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f11520c;

    /* renamed from: d  reason: collision with root package name */
    public View f11521d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f11522e;

    /* renamed from: f  reason: collision with root package name */
    public Marker f11523f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f11524g;

    /* loaded from: classes6.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f11525e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f11526f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0796b f11527g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f11528h;

        public a(b bVar, c cVar, InterfaceC0796b interfaceC0796b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar, interfaceC0796b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11528h = bVar;
            this.f11526f = cVar;
            this.f11527g = interfaceC0796b;
            this.f11525e = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                this.f11528h.a(this.f11526f, (LatLng) valueAnimator.getAnimatedValue());
                if (this.f11525e || animatedFraction <= 0.99d) {
                    return;
                }
                this.f11525e = true;
                InterfaceC0796b interfaceC0796b = this.f11527g;
                if (interfaceC0796b != null) {
                    interfaceC0796b.onAnimationEnd();
                }
            }
        }
    }

    /* renamed from: c.a.r0.m.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0796b {
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
        f11518h = Boolean.TRUE;
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
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, cVar, latLng) == null) || (marker = this.f11519b) == null) {
            return;
        }
        marker.setPosition(latLng);
        c.a.r0.a.i1.c.h.c cVar2 = this.a.f7359f;
        cVar2.f7356e = latLng.latitude;
        cVar2.f7357f = latLng.longitude;
        Marker marker2 = this.f11523f;
        if (marker2 != null) {
            marker2.setPosition(latLng);
        }
        if (f11518h.booleanValue()) {
            Marker marker3 = this.f11520c;
            if (marker3 != null) {
                marker3.setPosition(latLng);
            }
            ViewGroup viewGroup = this.f11522e;
            if (viewGroup != null) {
                cVar.l.removeView(viewGroup);
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                cVar.l.addView(this.f11522e, builder.build());
                this.f11522e.setAlpha(0.0f);
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
        if (dVar2.o == null || this.f11521d != null || TextUtils.equals(dVar2.m.k, "ALWAYS")) {
            return;
        }
        cVar.l.removeView(this.f11522e);
        this.f11522e.removeView(this.f11521d);
        View a2 = c.a.r0.m.l.f.a.a(cVar, this.a);
        this.f11521d = a2;
        this.f11522e.addView(a2, 0);
        this.f11522e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
        builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
        builder.position(this.f11519b.getPosition());
        Bitmap bitmap = this.f11519b.getIcon().getBitmap();
        builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.a.o.f7365f)) + 0.0d));
        cVar.l.addView(this.f11522e, builder.build());
        this.f11522e.setAlpha(0.0f);
        Marker marker = this.f11523f;
        if (marker != null) {
            marker.remove();
        }
        BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.f11522e);
        if (fromView == null) {
            return;
        }
        Bitmap bitmap2 = fromView.getBitmap();
        if (bitmap2.getHeight() <= 0 || bitmap2.getWidth() <= 0) {
            return;
        }
        float width = ((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.a.o.f7364e * bitmap.getWidth()))) / bitmap2.getWidth();
        float height = ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.a.o.f7365f * bitmap.getHeight()))) / fromView.getBitmap().getHeight();
        MarkerOptions markerOptions = new MarkerOptions();
        c.a.r0.a.i1.c.h.c cVar2 = this.a.f7359f;
        this.f11523f = (Marker) cVar.l.getMap().addOverlay(markerOptions.position(new LatLng(cVar2.f7356e, cVar2.f7357f)).icon(fromView).zIndex(66).anchor(width, height));
    }

    public void c(c cVar, LatLng latLng, f fVar, InterfaceC0796b interfaceC0796b) {
        Marker marker;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, cVar, latLng, fVar, interfaceC0796b) == null) {
            ValueAnimator valueAnimator = this.f11524g;
            if ((valueAnimator == null || !valueAnimator.isRunning()) && (marker = this.f11519b) != null) {
                float f2 = 360.0f - ((float) fVar.F);
                if (f2 >= 0.0f && f2 <= 360.0f) {
                    marker.setRotate(f2);
                }
                int i2 = fVar.G;
                if (i2 < 0) {
                    i2 = -i2;
                }
                ValueAnimator ofObject = ValueAnimator.ofObject(new c.a.r0.m.l.e.h.a(), this.f11519b.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
                this.f11524g = ofObject;
                ofObject.setDuration(i2);
                this.f11524g.addUpdateListener(new a(this, cVar, interfaceC0796b));
                this.f11524g.start();
            }
        }
    }
}
