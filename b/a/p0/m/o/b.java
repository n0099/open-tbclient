package b.a.p0.m.o;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import b.a.p0.a.i1.c.f;
import b.a.p0.a.i1.c.h.d;
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
    public static final Boolean f11632h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f11633a;

    /* renamed from: b  reason: collision with root package name */
    public Marker f11634b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f11635c;

    /* renamed from: d  reason: collision with root package name */
    public View f11636d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f11637e;

    /* renamed from: f  reason: collision with root package name */
    public Marker f11638f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f11639g;

    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f11640e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f11641f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0638b f11642g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f11643h;

        public a(b bVar, c cVar, InterfaceC0638b interfaceC0638b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar, interfaceC0638b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11643h = bVar;
            this.f11641f = cVar;
            this.f11642g = interfaceC0638b;
            this.f11640e = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                this.f11643h.a(this.f11641f, (LatLng) valueAnimator.getAnimatedValue());
                if (this.f11640e || animatedFraction <= 0.99d) {
                    return;
                }
                this.f11640e = true;
                InterfaceC0638b interfaceC0638b = this.f11642g;
                if (interfaceC0638b != null) {
                    interfaceC0638b.onAnimationEnd();
                }
            }
        }
    }

    /* renamed from: b.a.p0.m.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0638b {
        void onAnimationEnd();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-721891805, "Lb/a/p0/m/o/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-721891805, "Lb/a/p0/m/o/b;");
                return;
            }
        }
        f11632h = Boolean.TRUE;
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
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, cVar, latLng) == null) || (marker = this.f11634b) == null) {
            return;
        }
        marker.setPosition(latLng);
        b.a.p0.a.i1.c.h.c cVar2 = this.f11633a.f6489f;
        cVar2.f6486e = latLng.latitude;
        cVar2.f6487f = latLng.longitude;
        Marker marker2 = this.f11638f;
        if (marker2 != null) {
            marker2.setPosition(latLng);
        }
        if (f11632h.booleanValue()) {
            Marker marker3 = this.f11635c;
            if (marker3 != null) {
                marker3.setPosition(latLng);
            }
            ViewGroup viewGroup = this.f11637e;
            if (viewGroup != null) {
                cVar.l.removeView(viewGroup);
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                cVar.l.addView(this.f11637e, builder.build());
                this.f11637e.setAlpha(0.0f);
            }
        }
    }

    public void b(c cVar) {
        d dVar;
        d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || (dVar = this.f11633a) == null || (bVar = dVar.m) == null || !bVar.isValid()) {
            return;
        }
        d dVar2 = this.f11633a;
        if (dVar2.o == null || this.f11636d != null || TextUtils.equals(dVar2.m.k, "ALWAYS")) {
            return;
        }
        cVar.l.removeView(this.f11637e);
        this.f11637e.removeView(this.f11636d);
        View a2 = b.a.p0.m.l.f.a.a(cVar, this.f11633a);
        this.f11636d = a2;
        this.f11637e.addView(a2, 0);
        this.f11637e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
        builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
        builder.position(this.f11634b.getPosition());
        Bitmap bitmap = this.f11634b.getIcon().getBitmap();
        builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.f11633a.o.f6494f)) + 0.0d));
        cVar.l.addView(this.f11637e, builder.build());
        this.f11637e.setAlpha(0.0f);
        Marker marker = this.f11638f;
        if (marker != null) {
            marker.remove();
        }
        BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.f11637e);
        if (fromView == null) {
            return;
        }
        Bitmap bitmap2 = fromView.getBitmap();
        if (bitmap2.getHeight() <= 0 || bitmap2.getWidth() <= 0) {
            return;
        }
        float width = ((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.f11633a.o.f6493e * bitmap.getWidth()))) / bitmap2.getWidth();
        float height = ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.f11633a.o.f6494f * bitmap.getHeight()))) / fromView.getBitmap().getHeight();
        MarkerOptions markerOptions = new MarkerOptions();
        b.a.p0.a.i1.c.h.c cVar2 = this.f11633a.f6489f;
        this.f11638f = (Marker) cVar.l.getMap().addOverlay(markerOptions.position(new LatLng(cVar2.f6486e, cVar2.f6487f)).icon(fromView).zIndex(66).anchor(width, height));
    }

    public void c(c cVar, LatLng latLng, f fVar, InterfaceC0638b interfaceC0638b) {
        Marker marker;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, cVar, latLng, fVar, interfaceC0638b) == null) {
            ValueAnimator valueAnimator = this.f11639g;
            if ((valueAnimator == null || !valueAnimator.isRunning()) && (marker = this.f11634b) != null) {
                float f2 = 360.0f - ((float) fVar.F);
                if (f2 >= 0.0f && f2 <= 360.0f) {
                    marker.setRotate(f2);
                }
                int i2 = fVar.G;
                if (i2 < 0) {
                    i2 = -i2;
                }
                ValueAnimator ofObject = ValueAnimator.ofObject(new b.a.p0.m.l.e.h.a(), this.f11634b.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
                this.f11639g = ofObject;
                ofObject.setDuration(i2);
                this.f11639g.addUpdateListener(new a(this, cVar, interfaceC0638b));
                this.f11639g.start();
            }
        }
    }
}
