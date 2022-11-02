package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class MapStatus implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<MapStatus> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.mapsdkplatform.comapi.map.x a;
    public double b;
    public final LatLngBounds bound;
    public double c;
    public final float overlook;
    public final float rotate;
    public final LatLng target;
    public final Point targetScreen;
    public WinRound winRound;
    public final float zoom;

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public LatLng b;
        public float c;
        public float d;
        public Point e;
        public LatLngBounds f;
        public double g;
        public double h;
        public final float i;

        private float a(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(65538, this, f)) == null) {
                if (15.0f == f) {
                    return 15.5f;
                }
                return f;
            }
            return invokeF.floatValue;
        }

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = -2.1474836E9f;
            this.b = null;
            this.c = -2.1474836E9f;
            this.d = -2.1474836E9f;
            this.e = null;
            this.f = null;
            this.g = 0.0d;
            this.h = 0.0d;
            this.i = 15.0f;
        }

        public Builder(MapStatus mapStatus) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapStatus};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = -2.1474836E9f;
            this.b = null;
            this.c = -2.1474836E9f;
            this.d = -2.1474836E9f;
            this.e = null;
            this.f = null;
            this.g = 0.0d;
            this.h = 0.0d;
            this.i = 15.0f;
            this.a = mapStatus.rotate;
            this.b = mapStatus.target;
            this.c = mapStatus.overlook;
            this.d = mapStatus.zoom;
            this.e = mapStatus.targetScreen;
            this.g = mapStatus.a();
            this.h = mapStatus.b();
        }

        public MapStatus build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new MapStatus(this.a, this.b, this.c, this.d, this.e, this.f);
            }
            return (MapStatus) invokeV.objValue;
        }

        public Builder overlook(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f)) == null) {
                this.c = f;
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        public Builder rotate(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f)) == null) {
                this.a = f;
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        public Builder target(LatLng latLng) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, latLng)) == null) {
                this.b = latLng;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder targetScreen(Point point) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, point)) == null) {
                this.e = point;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder zoom(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f)) == null) {
                this.d = a(f);
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
        CREATOR = new p();
    }

    public double a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return invokeV.doubleValue;
    }

    public double b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return invokeV.doubleValue;
    }

    public com.baidu.mapsdkplatform.comapi.map.x c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return b(new com.baidu.mapsdkplatform.comapi.map.x());
        }
        return (com.baidu.mapsdkplatform.comapi.map.x) invokeV.objValue;
    }

    public MapStatus(float f, LatLng latLng, float f2, float f3, Point point, double d, double d2, LatLngBounds latLngBounds) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f), latLng, Float.valueOf(f2), Float.valueOf(f3), point, Double.valueOf(d), Double.valueOf(d2), latLngBounds};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.rotate = f;
        this.target = latLng;
        this.overlook = f2;
        this.zoom = f3;
        this.targetScreen = point;
        this.b = d;
        this.c = d2;
        this.bound = latLngBounds;
    }

    public MapStatus(float f, LatLng latLng, float f2, float f3, Point point, LatLngBounds latLngBounds) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f), latLng, Float.valueOf(f2), Float.valueOf(f3), point, latLngBounds};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.rotate = f;
        this.target = latLng;
        this.overlook = f2;
        this.zoom = f3;
        this.targetScreen = point;
        if (latLng != null) {
            this.b = CoordUtil.ll2mc(latLng).getLongitudeE6();
            this.c = CoordUtil.ll2mc(this.target).getLatitudeE6();
        }
        this.bound = latLngBounds;
    }

    public MapStatus(float f, LatLng latLng, float f2, float f3, Point point, com.baidu.mapsdkplatform.comapi.map.x xVar, double d, double d2, LatLngBounds latLngBounds, WinRound winRound) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Float.valueOf(f), latLng, Float.valueOf(f2), Float.valueOf(f3), point, xVar, Double.valueOf(d), Double.valueOf(d2), latLngBounds, winRound};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.rotate = f;
        this.target = latLng;
        this.overlook = f2;
        this.zoom = f3;
        this.targetScreen = point;
        this.a = xVar;
        this.b = d;
        this.c = d2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.b = parcel.readDouble();
        this.c = parcel.readDouble();
    }

    public static MapStatus a(com.baidu.mapsdkplatform.comapi.map.x xVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, xVar)) == null) {
            if (xVar == null) {
                return null;
            }
            float f = xVar.b;
            double d = xVar.e;
            double d2 = xVar.d;
            LatLng mc2ll = CoordUtil.mc2ll(new GeoPoint(d, d2));
            float f2 = xVar.c;
            float f3 = xVar.a;
            Point point = new Point(xVar.f, xVar.g);
            LatLng mc2ll2 = CoordUtil.mc2ll(new GeoPoint(xVar.k.e.getDoubleY(), xVar.k.e.getDoubleX()));
            LatLng mc2ll3 = CoordUtil.mc2ll(new GeoPoint(xVar.k.f.getDoubleY(), xVar.k.f.getDoubleX()));
            LatLng mc2ll4 = CoordUtil.mc2ll(new GeoPoint(xVar.k.h.getDoubleY(), xVar.k.h.getDoubleX()));
            LatLng mc2ll5 = CoordUtil.mc2ll(new GeoPoint(xVar.k.g.getDoubleY(), xVar.k.g.getDoubleX()));
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            builder.include(mc2ll2);
            builder.include(mc2ll3);
            builder.include(mc2ll4);
            builder.include(mc2ll5);
            return new MapStatus(f, mc2ll, f2, f3, point, xVar, d2, d, builder.build(), xVar.j);
        }
        return (MapStatus) invokeL.objValue;
    }

    public com.baidu.mapsdkplatform.comapi.map.x b(com.baidu.mapsdkplatform.comapi.map.x xVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xVar)) == null) {
            if (xVar == null) {
                return null;
            }
            float f = this.rotate;
            if (f != -2.1474836E9f) {
                xVar.b = (int) f;
            }
            float f2 = this.zoom;
            if (f2 != -2.1474836E9f) {
                xVar.a = f2;
            }
            float f3 = this.overlook;
            if (f3 != -2.1474836E9f) {
                xVar.c = (int) f3;
            }
            if (this.target != null) {
                xVar.d = this.b;
                xVar.e = this.c;
            }
            Point point = this.targetScreen;
            if (point != null) {
                xVar.f = point.x;
                xVar.g = point.y;
            }
            return xVar;
        }
        return (com.baidu.mapsdkplatform.comapi.map.x) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (this.target != null) {
                sb.append("target lat: " + this.target.latitude + "\n");
                sb.append("target lng: " + this.target.longitude + "\n");
            }
            if (this.targetScreen != null) {
                sb.append("target screen x: " + this.targetScreen.x + "\n");
                sb.append("target screen y: " + this.targetScreen.y + "\n");
            }
            sb.append("zoom: " + this.zoom + "\n");
            sb.append("rotate: " + this.rotate + "\n");
            sb.append("overlook: " + this.overlook + "\n");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, parcel, i) == null) {
            parcel.writeFloat(this.rotate);
            parcel.writeParcelable(this.target, i);
            parcel.writeFloat(this.overlook);
            parcel.writeFloat(this.zoom);
            parcel.writeParcelable(this.targetScreen, i);
            parcel.writeParcelable(this.bound, i);
            parcel.writeDouble(this.b);
            parcel.writeDouble(this.c);
        }
    }
}
