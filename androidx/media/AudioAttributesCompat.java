package androidx.media;

import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import androidx.versionedparcelable.VersionedParcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public class AudioAttributesCompat implements VersionedParcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AUDIO_ATTRIBUTES_CONTENT_TYPE = "androidx.media.audio_attrs.CONTENT_TYPE";
    public static final String AUDIO_ATTRIBUTES_FLAGS = "androidx.media.audio_attrs.FLAGS";
    public static final String AUDIO_ATTRIBUTES_FRAMEWORKS = "androidx.media.audio_attrs.FRAMEWORKS";
    public static final String AUDIO_ATTRIBUTES_LEGACY_STREAM_TYPE = "androidx.media.audio_attrs.LEGACY_STREAM_TYPE";
    public static final String AUDIO_ATTRIBUTES_USAGE = "androidx.media.audio_attrs.USAGE";
    public static final int CONTENT_TYPE_MOVIE = 3;
    public static final int CONTENT_TYPE_MUSIC = 2;
    public static final int CONTENT_TYPE_SONIFICATION = 4;
    public static final int CONTENT_TYPE_SPEECH = 1;
    public static final int CONTENT_TYPE_UNKNOWN = 0;
    public static final int FLAG_ALL = 1023;
    public static final int FLAG_ALL_PUBLIC = 273;
    public static final int FLAG_AUDIBILITY_ENFORCED = 1;
    public static final int FLAG_BEACON = 8;
    public static final int FLAG_BYPASS_INTERRUPTION_POLICY = 64;
    public static final int FLAG_BYPASS_MUTE = 128;
    public static final int FLAG_DEEP_BUFFER = 512;
    public static final int FLAG_HW_AV_SYNC = 16;
    public static final int FLAG_HW_HOTWORD = 32;
    public static final int FLAG_LOW_LATENCY = 256;
    public static final int FLAG_SCO = 4;
    public static final int FLAG_SECURE = 2;
    public static final int INVALID_STREAM_TYPE = -1;
    public static final int[] SDK_USAGES;
    public static final int SUPPRESSIBLE_CALL = 2;
    public static final int SUPPRESSIBLE_NOTIFICATION = 1;
    public static final SparseIntArray SUPPRESSIBLE_USAGES;
    public static final String TAG = "AudioAttributesCompat";
    public static final int USAGE_ALARM = 4;
    public static final int USAGE_ASSISTANCE_ACCESSIBILITY = 11;
    public static final int USAGE_ASSISTANCE_NAVIGATION_GUIDANCE = 12;
    public static final int USAGE_ASSISTANCE_SONIFICATION = 13;
    public static final int USAGE_ASSISTANT = 16;
    public static final int USAGE_GAME = 14;
    public static final int USAGE_MEDIA = 1;
    public static final int USAGE_NOTIFICATION = 5;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_DELAYED = 9;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_INSTANT = 8;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_REQUEST = 7;
    public static final int USAGE_NOTIFICATION_EVENT = 10;
    public static final int USAGE_NOTIFICATION_RINGTONE = 6;
    public static final int USAGE_UNKNOWN = 0;
    public static final int USAGE_VIRTUAL_SOURCE = 15;
    public static final int USAGE_VOICE_COMMUNICATION = 2;
    public static final int USAGE_VOICE_COMMUNICATION_SIGNALLING = 3;
    public static boolean sForceLegacyBehavior;
    public transient /* synthetic */ FieldHolder $fh;
    public AudioAttributesImpl mImpl;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public @interface AttributeContentType {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public @interface AttributeUsage {
    }

    /* loaded from: classes.dex */
    public static abstract class AudioManagerHidden {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int STREAM_ACCESSIBILITY = 10;
        public static final int STREAM_BLUETOOTH_SCO = 6;
        public static final int STREAM_SYSTEM_ENFORCED = 7;
        public static final int STREAM_TTS = 9;
        public transient /* synthetic */ FieldHolder $fh;

        public AudioManagerHidden() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1601403727, "Landroidx/media/AudioAttributesCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1601403727, "Landroidx/media/AudioAttributesCompat;");
                return;
            }
        }
        SparseIntArray sparseIntArray = new SparseIntArray();
        SUPPRESSIBLE_USAGES = sparseIntArray;
        sparseIntArray.put(5, 1);
        SUPPRESSIBLE_USAGES.put(6, 2);
        SUPPRESSIBLE_USAGES.put(7, 2);
        SUPPRESSIBLE_USAGES.put(8, 1);
        SUPPRESSIBLE_USAGES.put(9, 1);
        SUPPRESSIBLE_USAGES.put(10, 1);
        SDK_USAGES = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};
    }

    public AudioAttributesCompat() {
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

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static AudioAttributesCompat fromBundle(Bundle bundle) {
        InterceptResult invokeL;
        AudioAttributesImpl fromBundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bundle)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                fromBundle = AudioAttributesImplApi21.fromBundle(bundle);
            } else {
                fromBundle = AudioAttributesImplBase.fromBundle(bundle);
            }
            if (fromBundle == null) {
                return null;
            }
            return new AudioAttributesCompat(fromBundle);
        }
        return (AudioAttributesCompat) invokeL.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void setForceLegacyBehavior(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
            sForceLegacyBehavior = z;
        }
    }

    public static int toVolumeStreamType(boolean z, AudioAttributesCompat audioAttributesCompat) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZL = interceptable.invokeZL(AdIconUtil.BAIDU_LOGO_ID, null, z, audioAttributesCompat)) == null) ? toVolumeStreamType(z, audioAttributesCompat.getFlags(), audioAttributesCompat.getUsage()) : invokeZL.intValue;
    }

    public static int usageForStreamType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) {
            switch (i2) {
                case 0:
                    return 2;
                case 1:
                case 7:
                    return 13;
                case 2:
                    return 6;
                case 3:
                    return 1;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 2;
                case 8:
                    return 3;
                case 9:
                default:
                    return 0;
                case 10:
                    return 11;
            }
        }
        return invokeI.intValue;
    }

    public static String usageToString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) {
            switch (i2) {
                case 0:
                    return "USAGE_UNKNOWN";
                case 1:
                    return "USAGE_MEDIA";
                case 2:
                    return "USAGE_VOICE_COMMUNICATION";
                case 3:
                    return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
                case 4:
                    return "USAGE_ALARM";
                case 5:
                    return "USAGE_NOTIFICATION";
                case 6:
                    return "USAGE_NOTIFICATION_RINGTONE";
                case 7:
                    return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
                case 8:
                    return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
                case 9:
                    return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
                case 10:
                    return "USAGE_NOTIFICATION_EVENT";
                case 11:
                    return "USAGE_ASSISTANCE_ACCESSIBILITY";
                case 12:
                    return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
                case 13:
                    return "USAGE_ASSISTANCE_SONIFICATION";
                case 14:
                    return "USAGE_GAME";
                case 15:
                default:
                    return "unknown usage " + i2;
                case 16:
                    return "USAGE_ASSISTANT";
            }
        }
        return (String) invokeI.objValue;
    }

    @Nullable
    public static AudioAttributesCompat wrap(@NonNull Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, obj)) == null) {
            if (Build.VERSION.SDK_INT < 21 || sForceLegacyBehavior) {
                return null;
            }
            AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21((AudioAttributes) obj);
            AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
            audioAttributesCompat.mImpl = audioAttributesImplApi21;
            return audioAttributesCompat;
        }
        return (AudioAttributesCompat) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj instanceof AudioAttributesCompat) {
                AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
                AudioAttributesImpl audioAttributesImpl = this.mImpl;
                if (audioAttributesImpl == null) {
                    return audioAttributesCompat.mImpl == null;
                }
                return audioAttributesImpl.equals(audioAttributesCompat.mImpl);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mImpl.getContentType() : invokeV.intValue;
    }

    public int getFlags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mImpl.getFlags() : invokeV.intValue;
    }

    public int getLegacyStreamType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mImpl.getLegacyStreamType() : invokeV.intValue;
    }

    public int getRawLegacyStreamType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mImpl.getRawLegacyStreamType() : invokeV.intValue;
    }

    public int getUsage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mImpl.getUsage() : invokeV.intValue;
    }

    public int getVolumeControlStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mImpl.getVolumeControlStream() : invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mImpl.hashCode() : invokeV.intValue;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Bundle toBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mImpl.toBundle() : (Bundle) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mImpl.toString() : (String) invokeV.objValue;
    }

    @Nullable
    public Object unwrap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mImpl.getAudioAttributes() : invokeV.objValue;
    }

    public AudioAttributesCompat(AudioAttributesImpl audioAttributesImpl) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {audioAttributesImpl};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mImpl = audioAttributesImpl;
    }

    public static int toVolumeStreamType(boolean z, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if ((i2 & 1) == 1) {
                return z ? 1 : 7;
            } else if ((i2 & 4) == 4) {
                return z ? 0 : 6;
            } else {
                switch (i3) {
                    case 0:
                        return z ? Integer.MIN_VALUE : 3;
                    case 1:
                    case 12:
                    case 14:
                    case 16:
                        return 3;
                    case 2:
                        return 0;
                    case 3:
                        return z ? 0 : 8;
                    case 4:
                        return 4;
                    case 5:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        return 5;
                    case 6:
                        return 2;
                    case 11:
                        return 10;
                    case 13:
                        return 1;
                    case 15:
                    default:
                        if (z) {
                            throw new IllegalArgumentException("Unknown usage value " + i3 + " in audio attributes");
                        }
                        return 3;
                }
            }
        }
        return invokeCommon.intValue;
    }

    /* loaded from: classes.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mContentType;
        public int mFlags;
        public int mLegacyStream;
        public int mUsage;

        public Builder() {
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
            this.mUsage = 0;
            this.mContentType = 0;
            this.mFlags = 0;
            this.mLegacyStream = -1;
        }

        public AudioAttributesCompat build() {
            InterceptResult invokeV;
            AudioAttributesImpl audioAttributesImplBase;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!AudioAttributesCompat.sForceLegacyBehavior && Build.VERSION.SDK_INT >= 21) {
                    AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(this.mContentType).setFlags(this.mFlags).setUsage(this.mUsage);
                    int i2 = this.mLegacyStream;
                    if (i2 != -1) {
                        usage.setLegacyStreamType(i2);
                    }
                    audioAttributesImplBase = new AudioAttributesImplApi21(usage.build(), this.mLegacyStream);
                } else {
                    audioAttributesImplBase = new AudioAttributesImplBase(this.mContentType, this.mFlags, this.mUsage, this.mLegacyStream);
                }
                return new AudioAttributesCompat(audioAttributesImplBase);
            }
            return (AudioAttributesCompat) invokeV.objValue;
        }

        public Builder setContentType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                if (i2 != 0 && i2 != 1 && i2 != 2 && i2 != 3 && i2 != 4) {
                    this.mUsage = 0;
                } else {
                    this.mContentType = i2;
                }
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setFlags(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.mFlags = (i2 & 1023) | this.mFlags;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public Builder setInternalLegacyStreamType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                switch (i2) {
                    case 0:
                        this.mContentType = 1;
                        break;
                    case 1:
                        this.mContentType = 4;
                        break;
                    case 2:
                        this.mContentType = 4;
                        break;
                    case 3:
                        this.mContentType = 2;
                        break;
                    case 4:
                        this.mContentType = 4;
                        break;
                    case 5:
                        this.mContentType = 4;
                        break;
                    case 6:
                        this.mContentType = 1;
                        this.mFlags |= 4;
                        break;
                    case 7:
                        this.mFlags = 1 | this.mFlags;
                        this.mContentType = 4;
                        break;
                    case 8:
                        this.mContentType = 4;
                        break;
                    case 9:
                        this.mContentType = 4;
                        break;
                    case 10:
                        this.mContentType = 1;
                        break;
                    default:
                        Log.e(AudioAttributesCompat.TAG, "Invalid stream type " + i2 + " for AudioAttributesCompat");
                        break;
                }
                this.mUsage = AudioAttributesCompat.usageForStreamType(i2);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setLegacyStreamType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                if (i2 != 10) {
                    this.mLegacyStream = i2;
                    return Build.VERSION.SDK_INT >= 21 ? setInternalLegacyStreamType(i2) : this;
                }
                throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setUsage(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                switch (i2) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        this.mUsage = i2;
                        break;
                    case 16:
                        if (!AudioAttributesCompat.sForceLegacyBehavior && Build.VERSION.SDK_INT > 25) {
                            this.mUsage = i2;
                            break;
                        } else {
                            this.mUsage = 12;
                            break;
                        }
                    default:
                        this.mUsage = 0;
                        break;
                }
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder(AudioAttributesCompat audioAttributesCompat) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {audioAttributesCompat};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mUsage = 0;
            this.mContentType = 0;
            this.mFlags = 0;
            this.mLegacyStream = -1;
            this.mUsage = audioAttributesCompat.getUsage();
            this.mContentType = audioAttributesCompat.getContentType();
            this.mFlags = audioAttributesCompat.getFlags();
            this.mLegacyStream = audioAttributesCompat.getRawLegacyStreamType();
        }
    }
}
