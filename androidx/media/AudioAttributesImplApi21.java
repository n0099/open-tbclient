package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@TargetApi(21)
/* loaded from: classes.dex */
public class AudioAttributesImplApi21 implements AudioAttributesImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AudioAttributesCompat21";
    public static Method sAudioAttributesToLegacyStreamType;
    public transient /* synthetic */ FieldHolder $fh;
    public AudioAttributes mAudioAttributes;
    public int mLegacyStreamType;

    public AudioAttributesImplApi21() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLegacyStreamType = -1;
    }

    public static AudioAttributesImpl fromBundle(Bundle bundle) {
        InterceptResult invokeL;
        AudioAttributes audioAttributes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bundle)) == null) {
            if (bundle == null || (audioAttributes = (AudioAttributes) bundle.getParcelable(AudioAttributesCompat.AUDIO_ATTRIBUTES_FRAMEWORKS)) == null) {
                return null;
            }
            return new AudioAttributesImplApi21(audioAttributes, bundle.getInt(AudioAttributesCompat.AUDIO_ATTRIBUTES_LEGACY_STREAM_TYPE, -1));
        }
        return (AudioAttributesImpl) invokeL.objValue;
    }

    public static Method getAudioAttributesToLegacyStreamTypeMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                if (sAudioAttributesToLegacyStreamType == null) {
                    sAudioAttributesToLegacyStreamType = AudioAttributes.class.getMethod("toLegacyStreamType", AudioAttributes.class);
                }
                return sAudioAttributesToLegacyStreamType;
            } catch (NoSuchMethodException unused) {
                return null;
            }
        }
        return (Method) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj instanceof AudioAttributesImplApi21) {
                return this.mAudioAttributes.equals(((AudioAttributesImplApi21) obj).mAudioAttributes);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.media.AudioAttributesImpl
    public Object getAudioAttributes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAudioAttributes : invokeV.objValue;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mAudioAttributes.getContentType() : invokeV.intValue;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getFlags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAudioAttributes.getFlags() : invokeV.intValue;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getLegacyStreamType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.mLegacyStreamType;
            if (i2 != -1) {
                return i2;
            }
            Method audioAttributesToLegacyStreamTypeMethod = getAudioAttributesToLegacyStreamTypeMethod();
            if (audioAttributesToLegacyStreamTypeMethod == null) {
                String str = "No AudioAttributes#toLegacyStreamType() on API: " + Build.VERSION.SDK_INT;
                return -1;
            }
            try {
                return ((Integer) audioAttributesToLegacyStreamTypeMethod.invoke(null, this.mAudioAttributes)).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused) {
                String str2 = "getLegacyStreamType() failed on API: " + Build.VERSION.SDK_INT;
                return -1;
            }
        }
        return invokeV.intValue;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getRawLegacyStreamType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mLegacyStreamType : invokeV.intValue;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getUsage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mAudioAttributes.getUsage() : invokeV.intValue;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getVolumeControlStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return this.mAudioAttributes.getVolumeControlStream();
            }
            return AudioAttributesCompat.toVolumeStreamType(true, getFlags(), getUsage());
        }
        return invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mAudioAttributes.hashCode() : invokeV.intValue;
    }

    @Override // androidx.media.AudioAttributesImpl
    @NonNull
    public Bundle toBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(AudioAttributesCompat.AUDIO_ATTRIBUTES_FRAMEWORKS, this.mAudioAttributes);
            int i2 = this.mLegacyStreamType;
            if (i2 != -1) {
                bundle.putInt(AudioAttributesCompat.AUDIO_ATTRIBUTES_LEGACY_STREAM_TYPE, i2);
            }
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return "AudioAttributesCompat: audioattributes=" + this.mAudioAttributes;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        this(audioAttributes, -1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {audioAttributes};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((AudioAttributes) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {audioAttributes, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mLegacyStreamType = -1;
        this.mAudioAttributes = audioAttributes;
        this.mLegacyStreamType = i2;
    }
}
