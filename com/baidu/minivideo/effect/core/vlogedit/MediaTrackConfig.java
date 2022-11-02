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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class MediaTrackConfig implements Parcelable, Cloneable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AE_IMPORT_DRAFT = "draft";
    public static final String AE_IMPORT_INPUT = "input";
    public static final String AE_IMPORT_ONE_INPUT = "oneInput";
    public static final String AE_IMPORT_TEMPLATE = "template";
    public static final String AE_TEMPLATE_TYPE_MUSIC = "music";
    public static final String AE_TEMPLATE_TYPE_NORMAL = "normal";
    public static final Parcelable.Creator<MediaTrackConfig> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    @Deprecated
    public String bgRes;
    public Map<String, MediaAEffect> effectConfigMap;
    public Map<String, String> effectResourceMap;
    public String id;
    public String importType;
    public long maxVideoDuration;
    public List<MediaTrack> mediaTracks;
    public String name;
    public Map<String, ShaderConfig> shaderConfigMapDebug;
    public Map<String, String> shaderResourceMap;
    public String templateType;
    public List<MediaTransition> transitionConfigs;
    public List<String> transitionResourceList;
    public float videoRatio;

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<MediaTrackConfig> {
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
        public MediaTrackConfig createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                return new MediaTrackConfig(parcel);
            }
            return (MediaTrackConfig) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public MediaTrackConfig[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return new MediaTrackConfig[i];
            }
            return (MediaTrackConfig[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-68137978, "Lcom/baidu/minivideo/effect/core/vlogedit/MediaTrackConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-68137978, "Lcom/baidu/minivideo/effect/core/vlogedit/MediaTrackConfig;");
                return;
            }
        }
        CREATOR = new a();
    }

    public MediaTrackConfig() {
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
        this.importType = "input";
        this.templateType = "normal";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @NonNull
    /* renamed from: clone */
    public MediaTrackConfig m34clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                MediaTrackConfig mediaTrackConfig = (MediaTrackConfig) super.clone();
                mediaTrackConfig.templateType = "normal";
                return mediaTrackConfig;
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return new MediaTrackConfig();
            }
        }
        return (MediaTrackConfig) invokeV.objValue;
    }

    public MediaTrackConfig(Parcel parcel) {
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
        this.importType = "input";
        this.templateType = "normal";
        this.id = parcel.readString();
        this.name = parcel.readString();
        this.maxVideoDuration = parcel.readLong();
        this.importType = parcel.readString();
        this.templateType = parcel.readString();
        this.mediaTracks = parcel.createTypedArrayList(MediaTrack.CREATOR);
        int readInt = parcel.readInt();
        this.effectConfigMap = new LinkedHashMap(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            this.effectConfigMap.put(parcel.readString(), (MediaAEffect) parcel.readParcelable(MediaAEffect.class.getClassLoader()));
        }
        int readInt2 = parcel.readInt();
        this.effectResourceMap = new HashMap(readInt2);
        for (int i4 = 0; i4 < readInt2; i4++) {
            this.effectResourceMap.put(parcel.readString(), parcel.readString());
        }
        this.transitionConfigs = parcel.createTypedArrayList(MediaTransition.CREATOR);
        this.transitionResourceList = parcel.createStringArrayList();
        int readInt3 = parcel.readInt();
        this.shaderResourceMap = new HashMap(readInt3);
        for (int i5 = 0; i5 < readInt3; i5++) {
            this.shaderResourceMap.put(parcel.readString(), parcel.readString());
        }
        int readInt4 = parcel.readInt();
        this.shaderConfigMapDebug = new HashMap(readInt4);
        for (int i6 = 0; i6 < readInt4; i6++) {
            this.shaderConfigMapDebug.put(parcel.readString(), (ShaderConfig) parcel.readParcelable(ShaderConfig.class.getClassLoader()));
        }
        this.bgRes = parcel.readString();
        this.videoRatio = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, parcel, i) == null) {
            parcel.writeString(this.id);
            parcel.writeString(this.name);
            parcel.writeLong(this.maxVideoDuration);
            parcel.writeString(this.importType);
            parcel.writeString(this.templateType);
            parcel.writeTypedList(this.mediaTracks);
            parcel.writeInt(this.effectConfigMap.size());
            for (Map.Entry<String, MediaAEffect> entry : this.effectConfigMap.entrySet()) {
                parcel.writeString(entry.getKey());
                parcel.writeParcelable(entry.getValue(), i);
            }
            parcel.writeInt(this.effectResourceMap.size());
            for (Map.Entry<String, String> entry2 : this.effectResourceMap.entrySet()) {
                parcel.writeString(entry2.getKey());
                parcel.writeString(entry2.getValue());
            }
            parcel.writeTypedList(this.transitionConfigs);
            parcel.writeStringList(this.transitionResourceList);
            parcel.writeInt(this.shaderResourceMap.size());
            for (Map.Entry<String, String> entry3 : this.shaderResourceMap.entrySet()) {
                parcel.writeString(entry3.getKey());
                parcel.writeString(entry3.getValue());
            }
            parcel.writeInt(this.shaderConfigMapDebug.size());
            for (Map.Entry<String, ShaderConfig> entry4 : this.shaderConfigMapDebug.entrySet()) {
                parcel.writeString(entry4.getKey());
                parcel.writeParcelable(entry4.getValue(), i);
            }
            parcel.writeString(this.bgRes);
            parcel.writeFloat(this.videoRatio);
        }
    }
}
