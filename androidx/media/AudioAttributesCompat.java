package androidx.media;

import android.media.AudioAttributes;
import android.os.Build;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import androidx.media.AudioAttributesImpl;
import androidx.media.AudioAttributesImplApi21;
import androidx.media.AudioAttributesImplApi26;
import androidx.media.AudioAttributesImplBase;
import androidx.versionedparcelable.VersionedParcelable;
import com.baidu.android.imsdk.internal.Constants;
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
    /* loaded from: classes.dex */
    public @interface AttributeContentType {
    }

    @Retention(RetentionPolicy.SOURCE)
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AudioAttributesImpl.Builder mBuilderImpl;

        public Builder() {
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
            if (AudioAttributesCompat.sForceLegacyBehavior) {
                this.mBuilderImpl = new AudioAttributesImplBase.Builder();
                return;
            }
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 26) {
                this.mBuilderImpl = new AudioAttributesImplApi26.Builder();
            } else if (i3 >= 21) {
                this.mBuilderImpl = new AudioAttributesImplApi21.Builder();
            } else {
                this.mBuilderImpl = new AudioAttributesImplBase.Builder();
            }
        }

        public Builder(AudioAttributesCompat audioAttributesCompat) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {audioAttributesCompat};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (AudioAttributesCompat.sForceLegacyBehavior) {
                this.mBuilderImpl = new AudioAttributesImplBase.Builder(audioAttributesCompat);
                return;
            }
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 26) {
                this.mBuilderImpl = new AudioAttributesImplApi26.Builder(audioAttributesCompat.unwrap());
            } else if (i3 >= 21) {
                this.mBuilderImpl = new AudioAttributesImplApi21.Builder(audioAttributesCompat.unwrap());
            } else {
                this.mBuilderImpl = new AudioAttributesImplBase.Builder(audioAttributesCompat);
            }
        }

        public AudioAttributesCompat build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new AudioAttributesCompat(this.mBuilderImpl.build());
            }
            return (AudioAttributesCompat) invokeV.objValue;
        }

        public Builder setContentType(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                this.mBuilderImpl.setContentType(i);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setFlags(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.mBuilderImpl.setFlags(i);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setLegacyStreamType(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                this.mBuilderImpl.setLegacyStreamType(i);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setUsage(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                this.mBuilderImpl.setUsage(i);
                return this;
            }
            return (Builder) invokeI.objValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public int getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mImpl.getContentType();
        }
        return invokeV.intValue;
    }

    public int getFlags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mImpl.getFlags();
        }
        return invokeV.intValue;
    }

    public int getLegacyStreamType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mImpl.getLegacyStreamType();
        }
        return invokeV.intValue;
    }

    public int getRawLegacyStreamType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mImpl.getRawLegacyStreamType();
        }
        return invokeV.intValue;
    }

    public int getUsage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mImpl.getUsage();
        }
        return invokeV.intValue;
    }

    public int getVolumeControlStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mImpl.getVolumeControlStream();
        }
        return invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mImpl.hashCode();
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mImpl.toString();
        }
        return (String) invokeV.objValue;
    }

    public Object unwrap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mImpl.getAudioAttributes();
        }
        return invokeV.objValue;
    }

    public AudioAttributesCompat(AudioAttributesImpl audioAttributesImpl) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {audioAttributesImpl};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mImpl = audioAttributesImpl;
    }

    public static void setForceLegacyBehavior(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            sForceLegacyBehavior = z;
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (!(obj instanceof AudioAttributesCompat)) {
                return false;
            }
            AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
            AudioAttributesImpl audioAttributesImpl = this.mImpl;
            if (audioAttributesImpl == null) {
                if (audioAttributesCompat.mImpl != null) {
                    return false;
                }
                return true;
            }
            return audioAttributesImpl.equals(audioAttributesCompat.mImpl);
        }
        return invokeL.booleanValue;
    }

    public static int toVolumeStreamType(boolean z, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if ((i & 1) == 1) {
                if (z) {
                    return 1;
                }
                return 7;
            } else if ((i & 4) == 4) {
                if (z) {
                    return 0;
                }
                return 6;
            } else {
                switch (i2) {
                    case 0:
                    case 1:
                    case 12:
                    case 14:
                    case 16:
                        return 3;
                    case 2:
                        return 0;
                    case 3:
                        if (z) {
                            return 0;
                        }
                        return 8;
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
                        if (!z) {
                            return 3;
                        }
                        throw new IllegalArgumentException("Unknown usage value " + i2 + " in audio attributes");
                }
            }
        }
        return invokeCommon.intValue;
    }

    public static String usageToString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            switch (i) {
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
                    return "unknown usage " + i;
                case 16:
                    return "USAGE_ASSISTANT";
            }
        }
        return (String) invokeI.objValue;
    }

    public static AudioAttributesCompat wrap(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, obj)) == null) {
            if (sForceLegacyBehavior) {
                return null;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                return new AudioAttributesCompat(new AudioAttributesImplApi26((AudioAttributes) obj));
            }
            if (i < 21) {
                return null;
            }
            return new AudioAttributesCompat(new AudioAttributesImplApi21((AudioAttributes) obj));
        }
        return (AudioAttributesCompat) invokeL.objValue;
    }
}
