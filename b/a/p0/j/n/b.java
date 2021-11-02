package b.a.p0.j.n;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import b.a.p0.a.h1.c.f;
import b.a.p0.a.h1.c.h.d;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final Boolean f10944h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f10945a;

    /* renamed from: b  reason: collision with root package name */
    public Marker f10946b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f10947c;

    /* renamed from: d  reason: collision with root package name */
    public View f10948d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f10949e;

    /* renamed from: f  reason: collision with root package name */
    public Marker f10950f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f10951g;

    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f10952e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f10953f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0609b f10954g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f10955h;

        public a(b bVar, c cVar, InterfaceC0609b interfaceC0609b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar, interfaceC0609b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10955h = bVar;
            this.f10953f = cVar;
            this.f10954g = interfaceC0609b;
            this.f10952e = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                this.f10955h.a(this.f10953f, (LatLng) valueAnimator.getAnimatedValue());
                if (this.f10952e || animatedFraction <= 0.99d) {
                    return;
                }
                this.f10952e = true;
                InterfaceC0609b interfaceC0609b = this.f10954g;
                if (interfaceC0609b != null) {
                    interfaceC0609b.onAnimationEnd();
                }
            }
        }
    }

    /* renamed from: b.a.p0.j.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0609b {
        void onAnimationEnd();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-807809049, "Lb/a/p0/j/n/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-807809049, "Lb/a/p0/j/n/b;");
                return;
            }
        }
        f10944h = Boolean.TRUE;
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
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, cVar, latLng) == null) || (marker = this.f10946b) == null) {
            return;
        }
        marker.setPosition(latLng);
        b.a.p0.a.h1.c.h.c cVar2 = this.f10945a.f5874f;
        cVar2.f5871e = latLng.latitude;
        cVar2.f5872f = latLng.longitude;
        Marker marker2 = this.f10950f;
        if (marker2 != null) {
            marker2.setPosition(latLng);
        }
        if (f10944h.booleanValue()) {
            Marker marker3 = this.f10947c;
            if (marker3 != null) {
                marker3.setPosition(latLng);
            }
            ViewGroup viewGroup = this.f10949e;
            if (viewGroup != null) {
                cVar.l.removeView(viewGroup);
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                cVar.l.addView(this.f10949e, builder.build());
                this.f10949e.setAlpha(0.0f);
            }
        }
    }

    public void b(c cVar) {
        d dVar;
        d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || (dVar = this.f10945a) == null || (bVar = dVar.m) == null || !bVar.isValid()) {
            return;
        }
        d dVar2 = this.f10945a;
        if (dVar2.o == null || this.f10948d != null || TextUtils.equals(dVar2.m.k, "ALWAYS")) {
            return;
        }
        cVar.l.removeView(this.f10949e);
        this.f10949e.removeView(this.f10948d);
        View a2 = b.a.p0.j.k.f.a.a(cVar, this.f10945a);
        this.f10948d = a2;
        this.f10949e.addView(a2, 0);
        this.f10949e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
        builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
        builder.position(this.f10946b.getPosition());
        Bitmap bitmap = this.f10946b.getIcon().getBitmap();
        builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.f10945a.o.f5879f)) + 0.0d));
        cVar.l.addView(this.f10949e, builder.build());
        this.f10949e.setAlpha(0.0f);
        Marker marker = this.f10950f;
        if (marker != null) {
            marker.remove();
        }
        BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.f10949e);
        if (fromView == null) {
            return;
        }
        Bitmap bitmap2 = fromView.getBitmap();
        if (bitmap2.getHeight() <= 0 || bitmap2.getWidth() <= 0) {
            return;
        }
        float width = ((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.f10945a.o.f5878e * bitmap.getWidth()))) / bitmap2.getWidth();
        float height = ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.f10945a.o.f5879f * bitmap.getHeight()))) / fromView.getBitmap().getHeight();
        MarkerOptions markerOptions = new MarkerOptions();
        b.a.p0.a.h1.c.h.c cVar2 = this.f10945a.f5874f;
        this.f10950f = (Marker) cVar.l.getMap().addOverlay(markerOptions.position(new LatLng(cVar2.f5871e, cVar2.f5872f)).icon(fromView).zIndex(66).anchor(width, height));
    }

    public void c(c cVar, LatLng latLng, f fVar, InterfaceC0609b interfaceC0609b) {
        Marker marker;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, cVar, latLng, fVar, interfaceC0609b) == null) {
            ValueAnimator valueAnimator = this.f10951g;
            if ((valueAnimator == null || !valueAnimator.isRunning()) && (marker = this.f10946b) != null) {
                float f2 = 360.0f - ((float) fVar.F);
                if (f2 >= 0.0f && f2 <= 360.0f) {
                    marker.setRotate(f2);
                }
                int i2 = fVar.G;
                if (i2 < 0) {
                    i2 = -i2;
                }
                ValueAnimator ofObject = ValueAnimator.ofObject(new b.a.p0.j.k.e.h.a(), this.f10946b.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
                this.f10951g = ofObject;
                ofObject.setDuration(i2);
                this.f10951g.addUpdateListener(new a(this, cVar, interfaceC0609b));
                this.f10951g.start();
            }
        }
    }
}
