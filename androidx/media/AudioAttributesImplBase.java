package androidx.media;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes.dex */
public class AudioAttributesImplBase implements AudioAttributesImpl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mContentType;
    public int mFlags;
    public int mLegacyStream;
    public int mUsage;

    public AudioAttributesImplBase() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mUsage = 0;
        this.mContentType = 0;
        this.mFlags = 0;
        this.mLegacyStream = -1;
    }

    public static AudioAttributesImpl fromBundle(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bundle)) == null) {
            if (bundle == null) {
                return null;
            }
            return new AudioAttributesImplBase(bundle.getInt(AudioAttributesCompat.AUDIO_ATTRIBUTES_CONTENT_TYPE, 0), bundle.getInt(AudioAttributesCompat.AUDIO_ATTRIBUTES_FLAGS, 0), bundle.getInt(AudioAttributesCompat.AUDIO_ATTRIBUTES_USAGE, 0), bundle.getInt(AudioAttributesCompat.AUDIO_ATTRIBUTES_LEGACY_STREAM_TYPE, -1));
        }
        return (AudioAttributesImpl) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj instanceof AudioAttributesImplBase) {
                AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
                return this.mContentType == audioAttributesImplBase.getContentType() && this.mFlags == audioAttributesImplBase.getFlags() && this.mUsage == audioAttributesImplBase.getUsage() && this.mLegacyStream == audioAttributesImplBase.mLegacyStream;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.media.AudioAttributesImpl
    public Object getAudioAttributes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return invokeV.objValue;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mContentType : invokeV.intValue;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getFlags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i = this.mFlags;
            int legacyStreamType = getLegacyStreamType();
            if (legacyStreamType == 6) {
                i |= 4;
            } else if (legacyStreamType == 7) {
                i |= 1;
            }
            return i & 273;
        }
        return invokeV.intValue;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getLegacyStreamType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i = this.mLegacyStream;
            return i != -1 ? i : AudioAttributesCompat.toVolumeStreamType(false, this.mFlags, this.mUsage);
        }
        return invokeV.intValue;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getRawLegacyStreamType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mLegacyStream : invokeV.intValue;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getUsage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mUsage : invokeV.intValue;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getVolumeControlStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? AudioAttributesCompat.toVolumeStreamType(true, this.mFlags, this.mUsage) : invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? Arrays.hashCode(new Object[]{Integer.valueOf(this.mContentType), Integer.valueOf(this.mFlags), Integer.valueOf(this.mUsage), Integer.valueOf(this.mLegacyStream)}) : invokeV.intValue;
    }

    @Override // androidx.media.AudioAttributesImpl
    @NonNull
    public Bundle toBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt(AudioAttributesCompat.AUDIO_ATTRIBUTES_USAGE, this.mUsage);
            bundle.putInt(AudioAttributesCompat.AUDIO_ATTRIBUTES_CONTENT_TYPE, this.mContentType);
            bundle.putInt(AudioAttributesCompat.AUDIO_ATTRIBUTES_FLAGS, this.mFlags);
            int i = this.mLegacyStream;
            if (i != -1) {
                bundle.putInt(AudioAttributesCompat.AUDIO_ATTRIBUTES_LEGACY_STREAM_TYPE, i);
            }
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
            if (this.mLegacyStream != -1) {
                sb.append(" stream=");
                sb.append(this.mLegacyStream);
                sb.append(" derived");
            }
            sb.append(" usage=");
            sb.append(AudioAttributesCompat.usageToString(this.mUsage));
            sb.append(" content=");
            sb.append(this.mContentType);
            sb.append(" flags=0x");
            sb.append(Integer.toHexString(this.mFlags).toUpperCase());
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public AudioAttributesImplBase(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mUsage = 0;
        this.mContentType = 0;
        this.mFlags = 0;
        this.mLegacyStream = -1;
        this.mContentType = i;
        this.mFlags = i2;
        this.mUsage = i3;
        this.mLegacyStream = i4;
    }
}
