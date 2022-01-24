package com.baidu.sofire.core;

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
/* loaded from: classes11.dex */
public class CallArgs implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<CallArgs> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f38396b;

    /* renamed from: c  reason: collision with root package name */
    public String f38397c;

    /* renamed from: d  reason: collision with root package name */
    public Object[] f38398d;

    /* renamed from: e  reason: collision with root package name */
    public Object[] f38399e;

    /* renamed from: f  reason: collision with root package name */
    public Object f38400f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1752405121, "Lcom/baidu/sofire/core/CallArgs;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1752405121, "Lcom/baidu/sofire/core/CallArgs;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<CallArgs>() { // from class: com.baidu.sofire.core.CallArgs.1
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

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ CallArgs createFromParcel(Parcel parcel) {
                return new CallArgs(parcel);
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ CallArgs[] newArray(int i2) {
                return new CallArgs[i2];
            }
        };
    }

    public CallArgs() {
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
            parcel.writeInt(this.a);
            parcel.writeInt(this.f38396b);
            parcel.writeString(this.f38397c);
            parcel.writeArray(this.f38399e);
            parcel.writeArray(this.f38398d);
            parcel.writeValue(this.f38400f);
        }
    }

    public CallArgs(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = parcel.readInt();
        this.f38396b = parcel.readInt();
        this.f38397c = parcel.readString();
        this.f38399e = parcel.readArray(CallArgs.class.getClassLoader());
        this.f38398d = parcel.readArray(CallArgs.class.getClassLoader());
        this.f38400f = parcel.readValue(CallArgs.class.getClassLoader());
    }
}
