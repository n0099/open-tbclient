package c.a.n0.j.n;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import c.a.n0.a.h1.c.f;
import c.a.n0.a.h1.c.h.d;
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
    public static final Boolean f11473h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f11474a;

    /* renamed from: b  reason: collision with root package name */
    public Marker f11475b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f11476c;

    /* renamed from: d  reason: collision with root package name */
    public View f11477d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f11478e;

    /* renamed from: f  reason: collision with root package name */
    public Marker f11479f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f11480g;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f11481e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f11482f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0604b f11483g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f11484h;

        public a(b bVar, c cVar, InterfaceC0604b interfaceC0604b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar, interfaceC0604b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11484h = bVar;
            this.f11482f = cVar;
            this.f11483g = interfaceC0604b;
            this.f11481e = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                this.f11484h.a(this.f11482f, (LatLng) valueAnimator.getAnimatedValue());
                if (this.f11481e || animatedFraction <= 0.99d) {
                    return;
                }
                this.f11481e = true;
                InterfaceC0604b interfaceC0604b = this.f11483g;
                if (interfaceC0604b != null) {
                    interfaceC0604b.onAnimationEnd();
                }
            }
        }
    }

    /* renamed from: c.a.n0.j.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0604b {
        void onAnimationEnd();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1781270426, "Lc/a/n0/j/n/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1781270426, "Lc/a/n0/j/n/b;");
                return;
            }
        }
        f11473h = Boolean.TRUE;
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
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, cVar, latLng) == null) || (marker = this.f11475b) == null) {
            return;
        }
        marker.setPosition(latLng);
        c.a.n0.a.h1.c.h.c cVar2 = this.f11474a.f6262f;
        cVar2.f6259e = latLng.latitude;
        cVar2.f6260f = latLng.longitude;
        Marker marker2 = this.f11479f;
        if (marker2 != null) {
            marker2.setPosition(latLng);
        }
        if (f11473h.booleanValue()) {
            Marker marker3 = this.f11476c;
            if (marker3 != null) {
                marker3.setPosition(latLng);
            }
            ViewGroup viewGroup = this.f11478e;
            if (viewGroup != null) {
                cVar.l.removeView(viewGroup);
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                cVar.l.addView(this.f11478e, builder.build());
                this.f11478e.setAlpha(0.0f);
            }
        }
    }

    public void b(c cVar) {
        d dVar;
        d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || (dVar = this.f11474a) == null || (bVar = dVar.m) == null || !bVar.isValid()) {
            return;
        }
        d dVar2 = this.f11474a;
        if (dVar2.o == null || this.f11477d != null || TextUtils.equals(dVar2.m.k, "ALWAYS")) {
            return;
        }
        cVar.l.removeView(this.f11478e);
        this.f11478e.removeView(this.f11477d);
        View a2 = c.a.n0.j.k.f.a.a(cVar, this.f11474a);
        this.f11477d = a2;
        this.f11478e.addView(a2, 0);
        this.f11478e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
        builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
        builder.position(this.f11475b.getPosition());
        Bitmap bitmap = this.f11475b.getIcon().getBitmap();
        builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.f11474a.o.f6268f)) + 0.0d));
        cVar.l.addView(this.f11478e, builder.build());
        this.f11478e.setAlpha(0.0f);
        Marker marker = this.f11479f;
        if (marker != null) {
            marker.remove();
        }
        BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.f11478e);
        if (fromView == null) {
            return;
        }
        Bitmap bitmap2 = fromView.getBitmap();
        if (bitmap2.getHeight() <= 0 || bitmap2.getWidth() <= 0) {
            return;
        }
        float width = ((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.f11474a.o.f6267e * bitmap.getWidth()))) / bitmap2.getWidth();
        float height = ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.f11474a.o.f6268f * bitmap.getHeight()))) / fromView.getBitmap().getHeight();
        MarkerOptions markerOptions = new MarkerOptions();
        c.a.n0.a.h1.c.h.c cVar2 = this.f11474a.f6262f;
        this.f11479f = (Marker) cVar.l.getMap().addOverlay(markerOptions.position(new LatLng(cVar2.f6259e, cVar2.f6260f)).icon(fromView).zIndex(66).anchor(width, height));
    }

    public void c(c cVar, LatLng latLng, f fVar, InterfaceC0604b interfaceC0604b) {
        Marker marker;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, cVar, latLng, fVar, interfaceC0604b) == null) {
            ValueAnimator valueAnimator = this.f11480g;
            if ((valueAnimator == null || !valueAnimator.isRunning()) && (marker = this.f11475b) != null) {
                float f2 = 360.0f - ((float) fVar.F);
                if (f2 >= 0.0f && f2 <= 360.0f) {
                    marker.setRotate(f2);
                }
                int i2 = fVar.G;
                if (i2 < 0) {
                    i2 = -i2;
                }
                ValueAnimator ofObject = ValueAnimator.ofObject(new c.a.n0.j.k.e.h.a(), this.f11475b.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
                this.f11480g = ofObject;
                ofObject.setDuration(i2);
                this.f11480g.addUpdateListener(new a(this, cVar, interfaceC0604b));
                this.f11480g.start();
            }
        }
    }
}
