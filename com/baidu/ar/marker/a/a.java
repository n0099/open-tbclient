package com.baidu.ar.marker.a;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<a> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public int position;
    public String tm;
    public String tn;
    public String to;
    public double[] tp;
    public String tq;
    public float tr;
    public float ts;
    public int tt;
    public String tu;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(134897357, "Lcom/baidu/ar/marker/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(134897357, "Lcom/baidu/ar/marker/a/a;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<a>() { // from class: com.baidu.ar.marker.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: O */
            public a[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i2)) == null) ? new a[i2] : (a[]) invokeI.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public a createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel)) == null) ? new a(parcel) : (a) invokeL.objValue;
            }
        };
    }

    public a(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.tm = parcel.readString();
        this.tn = parcel.readString();
        this.to = parcel.readString();
        this.tp = parcel.createDoubleArray();
        this.tq = parcel.readString();
        this.tr = parcel.readFloat();
        this.ts = parcel.readFloat();
        this.tt = parcel.readInt();
        this.position = parcel.readInt();
        this.tu = parcel.readString();
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

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i2) == null) {
            parcel.writeString(this.tm);
            parcel.writeString(this.tn);
            parcel.writeString(this.to);
            parcel.writeDoubleArray(this.tp);
            parcel.writeString(this.tq);
            parcel.writeFloat(this.tr);
            parcel.writeFloat(this.ts);
            parcel.writeInt(this.tt);
            parcel.writeInt(this.position);
            parcel.writeString(this.tu);
        }
    }
}
