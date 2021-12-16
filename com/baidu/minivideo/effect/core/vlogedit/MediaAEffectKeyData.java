package com.baidu.minivideo.effect.core.vlogedit;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes10.dex */
public class MediaAEffectKeyData implements Parcelable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<MediaAEffectKeyData> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> calculateEffectKeys;
    public List<String> effectConfigKeys;
    public String footerEffectKey;
    public String headerEffectKey;
    public String keyMode;
    public String type;

    /* loaded from: classes10.dex */
    public static class a implements Parcelable.Creator<MediaAEffectKeyData> {
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
        public MediaAEffectKeyData createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new MediaAEffectKeyData(parcel) : (MediaAEffectKeyData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public MediaAEffectKeyData[] newArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new MediaAEffectKeyData[i2] : (MediaAEffectKeyData[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1659487372, "Lcom/baidu/minivideo/effect/core/vlogedit/MediaAEffectKeyData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1659487372, "Lcom/baidu/minivideo/effect/core/vlogedit/MediaAEffectKeyData;");
                return;
            }
        }
        CREATOR = new a();
    }

    public MediaAEffectKeyData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.keyMode = "fixed";
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
            parcel.writeString(this.type);
            parcel.writeString(this.keyMode);
            parcel.writeStringList(this.effectConfigKeys);
            parcel.writeString(this.headerEffectKey);
            parcel.writeString(this.footerEffectKey);
            parcel.writeStringList(this.calculateEffectKeys);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @NonNull
    /* renamed from: clone */
    public MediaAEffectKeyData m36clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return (MediaAEffectKeyData) super.clone();
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
                return new MediaAEffectKeyData();
            }
        }
        return (MediaAEffectKeyData) invokeV.objValue;
    }

    public MediaAEffectKeyData(Parcel parcel) {
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
        this.keyMode = "fixed";
        this.type = parcel.readString();
        this.keyMode = parcel.readString();
        this.effectConfigKeys = parcel.createStringArrayList();
        this.headerEffectKey = parcel.readString();
        this.footerEffectKey = parcel.readString();
        this.calculateEffectKeys = parcel.createStringArrayList();
    }
}
