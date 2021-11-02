package com.baidu.minivideo.effect.core.vlogedit;

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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class MediaTransition implements Parcelable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<MediaTransition> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public long duration;
    public long end;
    public String name;
    public String shaderConfigKey;
    public long start;
    public List<ShaderParams> tParams;

    /* loaded from: classes7.dex */
    public static class a implements Parcelable.Creator<MediaTransition> {
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
        public MediaTransition createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new MediaTransition(parcel) : (MediaTransition) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public MediaTransition[] newArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new MediaTransition[i2] : (MediaTransition[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-348336146, "Lcom/baidu/minivideo/effect/core/vlogedit/MediaTransition;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-348336146, "Lcom/baidu/minivideo/effect/core/vlogedit/MediaTransition;");
                return;
            }
        }
        CREATOR = new a();
    }

    public MediaTransition() {
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

    public Object clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                MediaTransition mediaTransition = (MediaTransition) super.clone();
                if (this.tParams != null) {
                    ArrayList arrayList = new ArrayList();
                    for (ShaderParams shaderParams : this.tParams) {
                        arrayList.add(shaderParams.m19clone());
                    }
                    mediaTransition.tParams = arrayList;
                }
                return mediaTransition;
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
                return new MediaTransition();
            }
        }
        return invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, parcel, i2) == null) {
            parcel.writeString(this.name);
            parcel.writeLong(this.duration);
            parcel.writeString(this.shaderConfigKey);
            parcel.writeTypedList(this.tParams);
            parcel.writeLong(this.start);
            parcel.writeLong(this.end);
        }
    }

    public MediaTransition(Parcel parcel) {
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
        this.duration = parcel.readLong();
        this.shaderConfigKey = parcel.readString();
        this.tParams = parcel.createTypedArrayList(ShaderParams.CREATOR);
        this.start = parcel.readLong();
        this.end = parcel.readLong();
    }
}
