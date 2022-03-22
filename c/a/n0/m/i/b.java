package c.a.n0.m.i;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import c.a.n0.a.y0.c.f;
import c.a.n0.a.y0.c.h.d;
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
    public static final Boolean f9041h;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;

    /* renamed from: b  reason: collision with root package name */
    public Marker f9042b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f9043c;

    /* renamed from: d  reason: collision with root package name */
    public View f9044d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f9045e;

    /* renamed from: f  reason: collision with root package name */
    public Marker f9046f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f9047g;

    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f9048b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0747b f9049c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f9050d;

        public a(b bVar, c cVar, InterfaceC0747b interfaceC0747b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar, interfaceC0747b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9050d = bVar;
            this.f9048b = cVar;
            this.f9049c = interfaceC0747b;
            this.a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                this.f9050d.a(this.f9048b, (LatLng) valueAnimator.getAnimatedValue());
                if (this.a || animatedFraction <= 0.99d) {
                    return;
                }
                this.a = true;
                InterfaceC0747b interfaceC0747b = this.f9049c;
                if (interfaceC0747b != null) {
                    interfaceC0747b.onAnimationEnd();
                }
            }
        }
    }

    /* renamed from: c.a.n0.m.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0747b {
        void onAnimationEnd();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1695531928, "Lc/a/n0/m/i/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1695531928, "Lc/a/n0/m/i/b;");
                return;
            }
        }
        f9041h = Boolean.TRUE;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void a(c cVar, LatLng latLng) {
        Marker marker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, cVar, latLng) == null) || (marker = this.f9042b) == null) {
            return;
        }
        marker.setPosition(latLng);
        c.a.n0.a.y0.c.h.c cVar2 = this.a.f7705b;
        cVar2.a = latLng.latitude;
        cVar2.f7704b = latLng.longitude;
        Marker marker2 = this.f9046f;
        if (marker2 != null) {
            marker2.setPosition(latLng);
        }
        if (f9041h.booleanValue()) {
            Marker marker3 = this.f9043c;
            if (marker3 != null) {
                marker3.setPosition(latLng);
            }
            ViewGroup viewGroup = this.f9045e;
            if (viewGroup != null) {
                cVar.l.removeView(viewGroup);
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                cVar.l.addView(this.f9045e, builder.build());
                this.f9045e.setAlpha(0.0f);
            }
        }
    }

    public void b(c cVar) {
        d dVar;
        d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || (dVar = this.a) == null || (bVar = dVar.i) == null || !bVar.isValid()) {
            return;
        }
        d dVar2 = this.a;
        if (dVar2.k == null || this.f9044d != null || TextUtils.equals(dVar2.i.f7714g, "ALWAYS")) {
            return;
        }
        cVar.l.removeView(this.f9045e);
        this.f9045e.removeView(this.f9044d);
        View a2 = c.a.n0.m.f.f.a.a(cVar, this.a);
        this.f9044d = a2;
        this.f9045e.addView(a2, 0);
        this.f9045e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
        builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
        builder.position(this.f9042b.getPosition());
        Bitmap bitmap = this.f9042b.getIcon().getBitmap();
        builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.a.k.f7712b)) + 0.0d));
        cVar.l.addView(this.f9045e, builder.build());
        this.f9045e.setAlpha(0.0f);
        Marker marker = this.f9046f;
        if (marker != null) {
            marker.remove();
        }
        BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.f9045e);
        if (fromView == null) {
            return;
        }
        Bitmap bitmap2 = fromView.getBitmap();
        if (bitmap2.getHeight() <= 0 || bitmap2.getWidth() <= 0) {
            return;
        }
        float width = ((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.a.k.a * bitmap.getWidth()))) / bitmap2.getWidth();
        float height = ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.a.k.f7712b * bitmap.getHeight()))) / fromView.getBitmap().getHeight();
        MarkerOptions markerOptions = new MarkerOptions();
        c.a.n0.a.y0.c.h.c cVar2 = this.a.f7705b;
        this.f9046f = (Marker) cVar.l.getMap().addOverlay(markerOptions.position(new LatLng(cVar2.a, cVar2.f7704b)).icon(fromView).zIndex(66).anchor(width, height));
    }

    public void c(c cVar, LatLng latLng, f fVar, InterfaceC0747b interfaceC0747b) {
        Marker marker;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, cVar, latLng, fVar, interfaceC0747b) == null) {
            ValueAnimator valueAnimator = this.f9047g;
            if ((valueAnimator == null || !valueAnimator.isRunning()) && (marker = this.f9042b) != null) {
                float f2 = 360.0f - ((float) fVar.B);
                if (f2 >= 0.0f && f2 <= 360.0f) {
                    marker.setRotate(f2);
                }
                int i = fVar.C;
                if (i < 0) {
                    i = -i;
                }
                ValueAnimator ofObject = ValueAnimator.ofObject(new c.a.n0.m.f.e.h.a(), this.f9042b.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
                this.f9047g = ofObject;
                ofObject.setDuration(i);
                this.f9047g.addUpdateListener(new a(this, cVar, interfaceC0747b));
                this.f9047g.start();
            }
        }
    }
}
