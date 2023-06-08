package com.baidu.minivideo.effect.core.vlogedit;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ksa;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MediaSegment implements Parcelable, Cloneable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<MediaSegment> CREATOR;
    public static final String SEG_TYPE_CAMERA = "camera";
    public static final String SEG_TYPE_IMAGE = "image";
    public static final String SEG_TYPE_INPUT_FOOTER = "input_footer";
    public static final String SEG_TYPE_INPUT_HEADER = "input_header";
    public static final String SEG_TYPE_INPUT_SUPERPOSITION_FOOTER = "input_superposition_footer";
    public static final String SEG_TYPE_INPUT_SUPERPOSITION_HEADER = "input_superposition_header";
    public static final String SEG_TYPE_VIDEO = "video";
    public transient /* synthetic */ FieldHolder $fh;
    public String effectConfigKey;
    public long effectEnd;
    public long effectStart;
    public long end;
    public String lutConfigKey;
    public MediaAEffect mediaAEffect;
    public String scaleType;
    public String shaderConfigKey;
    public long start;
    public String superpositionType;
    public transient int textureId;
    public float[] textureMtx;
    public String type;
    public float[] vertexMtx;

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<MediaSegment> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MediaSegment createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                return new MediaSegment(parcel);
            }
            return (MediaSegment) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public MediaSegment[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return new MediaSegment[i];
            }
            return (MediaSegment[]) invokeI.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends TypeToken<List<MediaSegment>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-760476160, "Lcom/baidu/minivideo/effect/core/vlogedit/MediaSegment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-760476160, "Lcom/baidu/minivideo/effect/core/vlogedit/MediaSegment;");
                return;
            }
        }
        CREATOR = new a();
    }

    public MediaSegment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public MediaSegment m49clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                MediaSegment mediaSegment = (MediaSegment) super.clone();
                if (this.mediaAEffect != null) {
                    mediaSegment.mediaAEffect = this.mediaAEffect.m47clone();
                }
                return mediaSegment;
            } catch (Exception e) {
                e.printStackTrace();
                return new MediaSegment();
            }
        }
        return (MediaSegment) invokeV.objValue;
    }

    public MediaSegment(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.superpositionType = parcel.readString();
        this.scaleType = parcel.readString();
        this.type = parcel.readString();
        this.start = parcel.readLong();
        this.end = parcel.readLong();
        this.shaderConfigKey = parcel.readString();
        this.effectConfigKey = parcel.readString();
        this.lutConfigKey = parcel.readString();
        this.mediaAEffect = (MediaAEffect) parcel.readParcelable(MediaAEffect.class.getClassLoader());
        this.effectStart = parcel.readLong();
        this.effectEnd = parcel.readLong();
        this.textureMtx = parcel.createFloatArray();
        this.vertexMtx = parcel.createFloatArray();
    }

    public static List<MediaSegment> parseArrayList(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            new ArrayList();
            try {
                return (List) new ksa().c(str, new b().getType());
            } catch (Exception unused) {
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, parcel, i) == null) {
            parcel.writeString(this.superpositionType);
            parcel.writeString(this.scaleType);
            parcel.writeString(this.type);
            parcel.writeLong(this.start);
            parcel.writeLong(this.end);
            parcel.writeString(this.shaderConfigKey);
            parcel.writeString(this.effectConfigKey);
            parcel.writeString(this.lutConfigKey);
            parcel.writeParcelable(this.mediaAEffect, i);
            parcel.writeLong(this.effectStart);
            parcel.writeLong(this.effectEnd);
            parcel.writeFloatArray(this.textureMtx);
            parcel.writeFloatArray(this.vertexMtx);
        }
    }
}
