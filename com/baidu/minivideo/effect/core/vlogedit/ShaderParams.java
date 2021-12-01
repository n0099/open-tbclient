package com.baidu.minivideo.effect.core.vlogedit;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ShaderParams implements Parcelable, Cloneable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<ShaderParams> CREATOR;
    public static final String IMAGE_HEIGHT = "imageHeight";
    public static final String IMAGE_WIDTH = "imageWidth";
    public static final String VALUE_TYPE_ANIMATOR = "animator";
    public static final String VALUE_TYPE_ARRAY = "array";
    public static final String VALUE_TYPE_FLOAT = "float";
    public static final String VALUE_TYPE_STEP = "step";
    public static final String VALUE_TYPE_VALUE = "value";
    public transient /* synthetic */ FieldHolder $fh;
    public String interpolator;
    public long lastTimeInterval;
    public String name;
    public long timeInterval;
    public String type;
    public float[] values;
    public int valuesPointer;

    /* loaded from: classes8.dex */
    public static class a implements Parcelable.Creator<ShaderParams> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShaderParams createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new ShaderParams(parcel) : (ShaderParams) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ShaderParams[] newArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new ShaderParams[i2] : (ShaderParams[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2127515036, "Lcom/baidu/minivideo/effect/core/vlogedit/ShaderParams;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2127515036, "Lcom/baidu/minivideo/effect/core/vlogedit/ShaderParams;");
                return;
            }
        }
        CREATOR = new a();
    }

    public ShaderParams() {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, parcel, i2) == null) {
            parcel.writeString(this.name);
            parcel.writeString(this.type);
            parcel.writeFloatArray(this.values);
            parcel.writeLong(this.timeInterval);
            parcel.writeLong(this.lastTimeInterval);
            parcel.writeInt(this.valuesPointer);
            parcel.writeString(this.interpolator);
        }
    }

    public ShaderParams(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.name = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public ShaderParams m39clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                ShaderParams shaderParams = (ShaderParams) super.clone();
                shaderParams.valuesPointer = 0;
                shaderParams.lastTimeInterval = 0L;
                return shaderParams;
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
                return new ShaderParams();
            }
        }
        return (ShaderParams) invokeV.objValue;
    }

    public ShaderParams(String str, String str2, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, fArr};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.name = str;
        this.type = str2;
        this.values = fArr;
    }

    public ShaderParams(Parcel parcel) {
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
        this.name = parcel.readString();
        this.type = parcel.readString();
        this.values = parcel.createFloatArray();
        this.timeInterval = parcel.readLong();
        this.lastTimeInterval = parcel.readLong();
        this.valuesPointer = parcel.readInt();
        this.interpolator = parcel.readString();
    }
}
