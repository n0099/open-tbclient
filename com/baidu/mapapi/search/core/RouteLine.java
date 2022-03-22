package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.route.BikingRouteLine;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.mapapi.search.route.TransitRouteLine;
import com.baidu.mapapi.search.route.WalkingRouteLine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class RouteLine<T extends RouteStep> implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TYPE a;

    /* renamed from: b  reason: collision with root package name */
    public RouteNode f26378b;

    /* renamed from: c  reason: collision with root package name */
    public RouteNode f26379c;

    /* renamed from: d  reason: collision with root package name */
    public String f26380d;

    /* renamed from: e  reason: collision with root package name */
    public List<T> f26381e;

    /* renamed from: f  reason: collision with root package name */
    public int f26382f;

    /* renamed from: g  reason: collision with root package name */
    public int f26383g;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class TYPE {
        public static /* synthetic */ Interceptable $ic;
        public static final TYPE BIKINGSTEP;
        public static final TYPE DRIVESTEP;
        public static final TYPE TRANSITSTEP;
        public static final TYPE WALKSTEP;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ TYPE[] f26384b;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1961986670, "Lcom/baidu/mapapi/search/core/RouteLine$TYPE;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1961986670, "Lcom/baidu/mapapi/search/core/RouteLine$TYPE;");
                    return;
                }
            }
            DRIVESTEP = new TYPE("DRIVESTEP", 0, 0);
            TRANSITSTEP = new TYPE("TRANSITSTEP", 1, 1);
            WALKSTEP = new TYPE("WALKSTEP", 2, 2);
            TYPE type = new TYPE("BIKINGSTEP", 3, 3);
            BIKINGSTEP = type;
            f26384b = new TYPE[]{DRIVESTEP, TRANSITSTEP, WALKSTEP, type};
        }

        public TYPE(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.a : invokeV.intValue;
        }

        public static TYPE valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (TYPE) Enum.valueOf(TYPE.class, str) : (TYPE) invokeL.objValue;
        }

        public static TYPE[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (TYPE[]) f26384b.clone() : (TYPE[]) invokeV.objValue;
        }
    }

    public RouteLine() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public RouteLine(Parcel parcel) {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        int readInt = parcel.readInt();
        this.f26378b = (RouteNode) parcel.readValue(RouteNode.class.getClassLoader());
        this.f26379c = (RouteNode) parcel.readValue(RouteNode.class.getClassLoader());
        this.f26380d = parcel.readString();
        if (readInt == 0) {
            obj = DrivingRouteLine.DrivingStep.CREATOR;
        } else if (readInt == 1) {
            obj = TransitRouteLine.TransitStep.CREATOR;
        } else if (readInt != 2) {
            if (readInt == 3) {
                obj = BikingRouteLine.BikingStep.CREATOR;
            }
            this.f26382f = parcel.readInt();
            this.f26383g = parcel.readInt();
        } else {
            obj = WalkingRouteLine.WalkingStep.CREATOR;
        }
        this.f26381e = parcel.createTypedArrayList(obj);
        this.f26382f = parcel.readInt();
        this.f26383g = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public List<T> getAllStep() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26381e : (List) invokeV.objValue;
    }

    public int getDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f26382f : invokeV.intValue;
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f26383g : invokeV.intValue;
    }

    public RouteNode getStarting() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f26378b : (RouteNode) invokeV.objValue;
    }

    public RouteNode getTerminal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f26379c : (RouteNode) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f26380d : (String) invokeV.objValue;
    }

    public TYPE getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (TYPE) invokeV.objValue;
    }

    public void setDistance(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.f26382f = i;
        }
    }

    public void setDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.f26383g = i;
        }
    }

    public void setStarting(RouteNode routeNode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, routeNode) == null) {
            this.f26378b = routeNode;
        }
    }

    public void setSteps(List<T> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.f26381e = list;
        }
    }

    public void setTerminal(RouteNode routeNode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, routeNode) == null) {
            this.f26379c = routeNode;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f26380d = str;
        }
    }

    public void setType(TYPE type) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, type) == null) {
            this.a = type;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, parcel, i) == null) {
            TYPE type = this.a;
            parcel.writeInt(type != null ? type.a() : 10);
            parcel.writeValue(this.f26378b);
            parcel.writeValue(this.f26379c);
            parcel.writeString(this.f26380d);
            if (this.a != null) {
                parcel.writeTypedList(this.f26381e);
            }
            parcel.writeInt(this.f26382f);
            parcel.writeInt(this.f26383g);
        }
    }
}
