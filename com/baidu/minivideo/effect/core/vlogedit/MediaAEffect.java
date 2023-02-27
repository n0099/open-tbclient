package com.baidu.minivideo.effect.core.vlogedit;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.bh0;
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
public class MediaAEffect implements Parcelable, Cloneable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AE_ANIM_ONCE = "once";
    public static final String AE_ANIM_REPEAT = "repeat";
    public static final String AE_ANIM_REVERSE = "reverse";
    public static final String AE_TYPE_END = "end";
    public static final String AE_TYPE_EQUALITY = "equality";
    public static final String AE_TYPE_SCENE = "scene";
    public static final String AE_TYPE_START = "start";
    public static final String AE_TYPE_START_END = "startEnd";
    public static final Parcelable.Creator<MediaAEffect> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public long duration;
    public String effectType;
    public List<MediaOneAEffect> mediaOneAEffects;
    public String name;
    public int randomMode;
    public String repeatMode;
    public String sceneTransitionName;
    public String shaderConfigKey;

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
    public static class a implements Parcelable.Creator<MediaAEffect> {
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
        public MediaAEffect createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                return new MediaAEffect(parcel);
            }
            return (MediaAEffect) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public MediaAEffect[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return new MediaAEffect[i];
            }
            return (MediaAEffect[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-436742207, "Lcom/baidu/minivideo/effect/core/vlogedit/MediaAEffect;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-436742207, "Lcom/baidu/minivideo/effect/core/vlogedit/MediaAEffect;");
                return;
            }
        }
        CREATOR = new a();
    }

    public MediaAEffect() {
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
        this.repeatMode = "repeat";
        this.effectType = "start";
        this.randomMode = 0;
    }

    public boolean isEqualityEffect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return AE_TYPE_EQUALITY.equals(this.effectType);
        }
        return invokeV.booleanValue;
    }

    public boolean isRandomModeOnce() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.randomMode == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isSceneEffect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return "scene".equals(this.effectType);
        }
        return invokeV.booleanValue;
    }

    public boolean isStartEndEffect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return AE_TYPE_START_END.equals(this.effectType);
        }
        return invokeV.booleanValue;
    }

    public MediaAEffect(Parcel parcel) {
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
        this.repeatMode = "repeat";
        this.effectType = "start";
        this.randomMode = 0;
        this.duration = parcel.readLong();
        this.repeatMode = parcel.readString();
        this.mediaOneAEffects = parcel.createTypedArrayList(MediaOneAEffect.CREATOR);
        this.shaderConfigKey = parcel.readString();
        this.effectType = parcel.readString();
        this.sceneTransitionName = parcel.readString();
        this.randomMode = parcel.readInt();
        this.name = parcel.readString();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public MediaAEffect m33clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                MediaAEffect mediaAEffect = (MediaAEffect) super.clone();
                if (TextUtils.isEmpty(mediaAEffect.shaderConfigKey)) {
                    mediaAEffect.shaderConfigKey = bh0.b;
                }
                if (mediaAEffect.mediaOneAEffects != null) {
                    ArrayList arrayList = new ArrayList();
                    for (MediaOneAEffect mediaOneAEffect : mediaAEffect.mediaOneAEffects) {
                        arrayList.add((MediaOneAEffect) mediaOneAEffect.clone());
                    }
                    mediaAEffect.mediaOneAEffects = arrayList;
                }
                return mediaAEffect;
            } catch (Exception e) {
                e.printStackTrace();
                return new MediaAEffect();
            }
        }
        return (MediaAEffect) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, parcel, i) == null) {
            parcel.writeLong(this.duration);
            parcel.writeString(this.repeatMode);
            parcel.writeTypedList(this.mediaOneAEffects);
            parcel.writeString(this.shaderConfigKey);
            parcel.writeString(this.effectType);
            parcel.writeString(this.sceneTransitionName);
            parcel.writeInt(this.randomMode);
            parcel.writeString(this.name);
        }
    }
}
