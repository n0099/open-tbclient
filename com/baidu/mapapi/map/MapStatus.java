package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.ab;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes5.dex */
public final class MapStatus implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<MapStatus> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ab f41536a;

    /* renamed from: b  reason: collision with root package name */
    public double f41537b;
    public final LatLngBounds bound;

    /* renamed from: c  reason: collision with root package name */
    public double f41538c;
    public final float overlook;
    public final float rotate;
    public final LatLng target;
    public final Point targetScreen;
    public WinRound winRound;
    public final float zoom;

    /* loaded from: classes5.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public float f41539a;

        /* renamed from: b  reason: collision with root package name */
        public LatLng f41540b;

        /* renamed from: c  reason: collision with root package name */
        public float f41541c;

        /* renamed from: d  reason: collision with root package name */
        public float f41542d;

        /* renamed from: e  reason: collision with root package name */
        public Point f41543e;

        /* renamed from: f  reason: collision with root package name */
        public LatLngBounds f41544f;

        /* renamed from: g  reason: collision with root package name */
        public double f41545g;

        /* renamed from: h  reason: collision with root package name */
        public double f41546h;

        /* renamed from: i  reason: collision with root package name */
        public final float f41547i;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41539a = -2.1474836E9f;
            this.f41540b = null;
            this.f41541c = -2.1474836E9f;
            this.f41542d = -2.1474836E9f;
            this.f41543e = null;
            this.f41544f = null;
            this.f41545g = 0.0d;
            this.f41546h = 0.0d;
            this.f41547i = 15.0f;
        }

        public Builder(MapStatus mapStatus) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapStatus};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f41539a = -2.1474836E9f;
            this.f41540b = null;
            this.f41541c = -2.1474836E9f;
            this.f41542d = -2.1474836E9f;
            this.f41543e = null;
            this.f41544f = null;
            this.f41545g = 0.0d;
            this.f41546h = 0.0d;
            this.f41547i = 15.0f;
            this.f41539a = mapStatus.rotate;
            this.f41540b = mapStatus.target;
            this.f41541c = mapStatus.overlook;
            this.f41542d = mapStatus.zoom;
            this.f41543e = mapStatus.targetScreen;
            this.f41545g = mapStatus.a();
            this.f41546h = mapStatus.b();
        }

        private float a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(65538, this, f2)) == null) {
                if (15.0f == f2) {
                    return 15.5f;
                }
                return f2;
            }
            return invokeF.floatValue;
        }

        public MapStatus build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new MapStatus(this.f41539a, this.f41540b, this.f41541c, this.f41542d, this.f41543e, this.f41544f) : (MapStatus) invokeV.objValue;
        }

        public Builder overlook(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) {
                this.f41541c = f2;
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        public Builder rotate(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2)) == null) {
                this.f41539a = f2;
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        public Builder target(LatLng latLng) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, latLng)) == null) {
                this.f41540b = latLng;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder targetScreen(Point point) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, point)) == null) {
                this.f41543e = point;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder zoom(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
                this.f41542d = a(f2);
                return this;
            }
            return (Builder) invokeF.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1245126429, "Lcom/baidu/mapapi/map/MapStatus;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1245126429, "Lcom/baidu/mapapi/map/MapStatus;");
                return;
            }
        }
        CREATOR = new k();
    }

    public MapStatus(float f2, LatLng latLng, float f3, float f4, Point point, double d2, double d3, LatLngBounds latLngBounds) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f2), latLng, Float.valueOf(f3), Float.valueOf(f4), point, Double.valueOf(d2), Double.valueOf(d3), latLngBounds};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.rotate = f2;
        this.target = latLng;
        this.overlook = f3;
        this.zoom = f4;
        this.targetScreen = point;
        this.f41537b = d2;
        this.f41538c = d3;
        this.bound = latLngBounds;
    }

    public MapStatus(float f2, LatLng latLng, float f3, float f4, Point point, LatLngBounds latLngBounds) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f2), latLng, Float.valueOf(f3), Float.valueOf(f4), point, latLngBounds};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.rotate = f2;
        this.target = latLng;
        this.overlook = f3;
        this.zoom = f4;
        this.targetScreen = point;
        if (latLng != null) {
            this.f41537b = CoordUtil.ll2mc(latLng).getLongitudeE6();
            this.f41538c = CoordUtil.ll2mc(this.target).getLatitudeE6();
        }
        this.bound = latLngBounds;
    }

    public MapStatus(float f2, LatLng latLng, float f3, float f4, Point point, ab abVar, double d2, double d3, LatLngBounds latLngBounds, WinRound winRound) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Float.valueOf(f2), latLng, Float.valueOf(f3), Float.valueOf(f4), point, abVar, Double.valueOf(d2), Double.valueOf(d3), latLngBounds, winRound};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.rotate = f2;
        this.target = latLng;
        this.overlook = f3;
        this.zoom = f4;
        this.targetScreen = point;
        this.f41536a = abVar;
        this.f41537b = d2;
        this.f41538c = d3;
        this.bound = latLngBounds;
        this.winRound = winRound;
    }

    public MapStatus(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.rotate = parcel.readFloat();
        this.target = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.overlook = parcel.readFloat();
        this.zoom = parcel.readFloat();
        this.targetScreen = (Point) parcel.readParcelable(Point.class.getClassLoader());
        this.bound = (LatLngBounds) parcel.readParcelable(LatLngBounds.class.getClassLoader());
        this.f41537b = parcel.readDouble();
        this.f41538c = parcel.readDouble();
    }

    public static MapStatus a(ab abVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, abVar)) == null) {
            if (abVar == null) {
                return null;
            }
            float f2 = abVar.f42237b;
            double d2 = abVar.f42240e;
            double d3 = abVar.f42239d;
            LatLng mc2ll = CoordUtil.mc2ll(new GeoPoint(d2, d3));
            float f3 = abVar.f42238c;
            float f4 = abVar.f42236a;
            Point point = new Point(abVar.f42241f, abVar.f42242g);
            com.baidu.mapapi.model.inner.Point point2 = abVar.k.f42250e;
            LatLng mc2ll2 = CoordUtil.mc2ll(new GeoPoint(point2.y, point2.x));
            com.baidu.mapapi.model.inner.Point point3 = abVar.k.f42251f;
            LatLng mc2ll3 = CoordUtil.mc2ll(new GeoPoint(point3.y, point3.x));
            com.baidu.mapapi.model.inner.Point point4 = abVar.k.f42253h;
            LatLng mc2ll4 = CoordUtil.mc2ll(new GeoPoint(point4.y, point4.x));
            com.baidu.mapapi.model.inner.Point point5 = abVar.k.f42252g;
            LatLng mc2ll5 = CoordUtil.mc2ll(new GeoPoint(point5.y, point5.x));
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            builder.include(mc2ll2);
            builder.include(mc2ll3);
            builder.include(mc2ll4);
            builder.include(mc2ll5);
            return new MapStatus(f2, mc2ll, f3, f4, point, abVar, d3, d2, builder.build(), abVar.f42245j);
        }
        return (MapStatus) invokeL.objValue;
    }

    public double a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f41537b : invokeV.doubleValue;
    }

    public double b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f41538c : invokeV.doubleValue;
    }

    public ab b(ab abVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, abVar)) == null) {
            if (abVar == null) {
                return null;
            }
            float f2 = this.rotate;
            if (f2 != -2.1474836E9f) {
                abVar.f42237b = (int) f2;
            }
            float f3 = this.zoom;
            if (f3 != -2.1474836E9f) {
                abVar.f42236a = f3;
            }
            float f4 = this.overlook;
            if (f4 != -2.1474836E9f) {
                abVar.f42238c = (int) f4;
            }
            if (this.target != null) {
                abVar.f42239d = this.f41537b;
                abVar.f42240e = this.f41538c;
            }
            Point point = this.targetScreen;
            if (point != null) {
                abVar.f42241f = point.x;
                abVar.f42242g = point.y;
            }
            return abVar;
        }
        return (ab) invokeL.objValue;
    }

    public ab c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? b(new ab()) : (ab) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (this.target != null) {
                sb.append("target lat: " + this.target.latitude + StringUtils.LF);
                sb.append("target lng: " + this.target.longitude + StringUtils.LF);
            }
            if (this.targetScreen != null) {
                sb.append("target screen x: " + this.targetScreen.x + StringUtils.LF);
                sb.append("target screen y: " + this.targetScreen.y + StringUtils.LF);
            }
            sb.append("zoom: " + this.zoom + StringUtils.LF);
            sb.append("rotate: " + this.rotate + StringUtils.LF);
            sb.append("overlook: " + this.overlook + StringUtils.LF);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, parcel, i2) == null) {
            parcel.writeFloat(this.rotate);
            parcel.writeParcelable(this.target, i2);
            parcel.writeFloat(this.overlook);
            parcel.writeFloat(this.zoom);
            parcel.writeParcelable(this.targetScreen, i2);
            parcel.writeParcelable(this.bound, i2);
            parcel.writeDouble(this.f41537b);
            parcel.writeDouble(this.f41538c);
        }
    }
}
