package com.baidu.minivideo.effect.core.vlogedit;

import android.opengl.GLES20;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes2.dex */
public class ShaderConfig implements Parcelable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<ShaderConfig> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ShaderParams> fParams;
    public String fragmentShader;
    public String resourcePath;
    public List<MediaTextureData> textures;
    public List<ShaderParams> vParams;
    public String vertexShader;

    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<ShaderConfig> {
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
        public ShaderConfig createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new ShaderConfig(parcel) : (ShaderConfig) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ShaderConfig[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new ShaderConfig[i] : (ShaderConfig[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-382902232, "Lcom/baidu/minivideo/effect/core/vlogedit/ShaderConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-382902232, "Lcom/baidu/minivideo/effect/core/vlogedit/ShaderConfig;");
                return;
            }
        }
        CREATOR = new a();
    }

    public ShaderConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.resourcePath = "";
    }

    public static ShaderConfig getAnimatorShaderConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            ShaderConfig shaderConfig = new ShaderConfig();
            shaderConfig.resourcePath = "";
            shaderConfig.fragmentShader = "defaultAnimator";
            return shaderConfig;
        }
        return (ShaderConfig) invokeV.objValue;
    }

    public static ShaderConfig getDefaultShaderConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            ShaderConfig shaderConfig = new ShaderConfig();
            shaderConfig.vertexShader = "default";
            shaderConfig.fragmentShader = "default";
            return shaderConfig;
        }
        return (ShaderConfig) invokeV.objValue;
    }

    public static ShaderConfig getGaussianBlurHShaderConfig(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65541, null, f)) == null) {
            ShaderConfig shaderConfig = new ShaderConfig();
            shaderConfig.vertexShader = "defaultGaussianBlur";
            ArrayList arrayList = new ArrayList();
            shaderConfig.vParams = arrayList;
            arrayList.add(new ShaderParams(ShaderParams.IMAGE_WIDTH));
            shaderConfig.vParams.add(new ShaderParams(ShaderParams.IMAGE_HEIGHT));
            shaderConfig.vParams.add(new ShaderParams("wRatio", ShaderParams.VALUE_TYPE_FLOAT, new float[]{f}));
            shaderConfig.vParams.add(new ShaderParams("hRatio", ShaderParams.VALUE_TYPE_FLOAT, new float[]{0.0f}));
            shaderConfig.fragmentShader = "defaultGaussianBlur";
            return shaderConfig;
        }
        return (ShaderConfig) invokeF.objValue;
    }

    public static ShaderConfig getGaussianBlurVShaderConfig(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65542, null, f)) == null) {
            ShaderConfig shaderConfig = new ShaderConfig();
            shaderConfig.vertexShader = "defaultGaussianBlur";
            ArrayList arrayList = new ArrayList();
            shaderConfig.vParams = arrayList;
            arrayList.add(new ShaderParams(ShaderParams.IMAGE_WIDTH));
            shaderConfig.vParams.add(new ShaderParams(ShaderParams.IMAGE_HEIGHT));
            shaderConfig.vParams.add(new ShaderParams("wRatio", ShaderParams.VALUE_TYPE_FLOAT, new float[]{0.0f}));
            shaderConfig.vParams.add(new ShaderParams("hRatio", ShaderParams.VALUE_TYPE_FLOAT, new float[]{f}));
            shaderConfig.fragmentShader = "defaultGaussianBlur";
            return shaderConfig;
        }
        return (ShaderConfig) invokeF.objValue;
    }

    public static ShaderConfig getLutShaderConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            ShaderConfig shaderConfig = new ShaderConfig();
            shaderConfig.resourcePath = "";
            shaderConfig.fragmentShader = "defaultLut";
            return shaderConfig;
        }
        return (ShaderConfig) invokeV.objValue;
    }

    public static ShaderConfig getStickerShaderConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            ShaderConfig shaderConfig = new ShaderConfig();
            shaderConfig.resourcePath = "";
            shaderConfig.fragmentShader = "defaultSticker";
            return shaderConfig;
        }
        return (ShaderConfig) invokeV.objValue;
    }

    public Object clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                ShaderConfig shaderConfig = (ShaderConfig) super.clone();
                if (this.fParams != null) {
                    ArrayList arrayList = new ArrayList();
                    for (ShaderParams shaderParams : this.fParams) {
                        arrayList.add(shaderParams.m35clone());
                    }
                    shaderConfig.fParams = arrayList;
                }
                if (this.vParams != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (ShaderParams shaderParams2 : this.vParams) {
                        arrayList2.add(shaderParams2.m35clone());
                    }
                    shaderConfig.vParams = arrayList2;
                }
                if (this.textures != null) {
                    ArrayList arrayList3 = new ArrayList();
                    for (MediaTextureData mediaTextureData : this.textures) {
                        arrayList3.add((MediaTextureData) mediaTextureData.clone());
                    }
                    shaderConfig.textures = arrayList3;
                }
                return shaderConfig;
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return getDefaultShaderConfig();
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

    public void destroy() {
        List<MediaTextureData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (list = this.textures) == null) {
            return;
        }
        for (MediaTextureData mediaTextureData : list) {
            if (mediaTextureData.textureId != 0 && !TextUtils.equals(MediaTextureData.TEXTURE_INPUT, mediaTextureData.type) && !TextUtils.equals(MediaTextureData.TEXTURE_SUBTITLE, mediaTextureData.type)) {
                GLES20.glDeleteTextures(1, new int[]{mediaTextureData.textureId}, 0);
                mediaTextureData.textureId = 0;
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, parcel, i) == null) {
            parcel.writeString(this.resourcePath);
            parcel.writeString(this.fragmentShader);
            parcel.writeString(this.vertexShader);
            parcel.writeTypedList(this.fParams);
            parcel.writeTypedList(this.vParams);
            parcel.writeTypedList(this.textures);
        }
    }

    public ShaderConfig(Parcel parcel) {
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
        this.resourcePath = "";
        this.resourcePath = parcel.readString();
        this.fragmentShader = parcel.readString();
        this.vertexShader = parcel.readString();
        this.fParams = parcel.createTypedArrayList(ShaderParams.CREATOR);
        this.vParams = parcel.createTypedArrayList(ShaderParams.CREATOR);
        this.textures = parcel.createTypedArrayList(MediaTextureData.CREATOR);
    }
}
