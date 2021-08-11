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
/* loaded from: classes5.dex */
public class MediaTextureData implements Parcelable, Cloneable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<MediaTextureData> CREATOR;
    public static String TEXTURE_IMAGE = "image";
    public static String TEXTURE_INPUT = "input";
    public static String TEXTURE_LUT = "lut";
    public static String TEXTURE_SUBTITLE = "subtitle";
    public static String TEXTURE_VIDEO = "video";
    public transient /* synthetic */ FieldHolder $fh;
    public int frameCount;
    public int frameFps;
    public String frameSuffix;
    public int height;
    public boolean loop;
    public boolean mipmap;
    public String path;
    public int textureId;
    public float[] textureMtx;
    public String type;
    public int width;
    public float x;
    public float y;

    /* loaded from: classes5.dex */
    public static class a implements Parcelable.Creator<MediaTextureData> {
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
        public MediaTextureData createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new MediaTextureData(parcel) : (MediaTextureData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public MediaTextureData[] newArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new MediaTextureData[i2] : (MediaTextureData[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-383388658, "Lcom/baidu/minivideo/effect/core/vlogedit/MediaTextureData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-383388658, "Lcom/baidu/minivideo/effect/core/vlogedit/MediaTextureData;");
                return;
            }
        }
        CREATOR = new a();
    }

    public MediaTextureData() {
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
        this.mipmap = false;
    }

    public Object clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return super.clone();
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
                return new MediaTextureData();
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
            parcel.writeString(this.type);
            parcel.writeString(this.path);
            parcel.writeInt(this.width);
            parcel.writeInt(this.height);
            parcel.writeFloat(this.x);
            parcel.writeFloat(this.y);
            parcel.writeByte(this.mipmap ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.frameFps);
            parcel.writeInt(this.frameCount);
            parcel.writeString(this.frameSuffix);
            parcel.writeByte(this.loop ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.textureId);
            parcel.writeFloatArray(this.textureMtx);
        }
    }

    public MediaTextureData(Parcel parcel) {
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
        this.mipmap = false;
        this.type = parcel.readString();
        this.path = parcel.readString();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
        this.mipmap = parcel.readByte() != 0;
        this.frameFps = parcel.readInt();
        this.frameCount = parcel.readInt();
        this.frameSuffix = parcel.readString();
        this.loop = parcel.readByte() != 0;
        this.textureId = parcel.readInt();
        this.textureMtx = parcel.createFloatArray();
    }
}
