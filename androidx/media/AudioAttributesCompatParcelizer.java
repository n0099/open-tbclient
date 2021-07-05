package androidx.media;

import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class AudioAttributesCompatParcelizer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AudioAttributesCompatParcelizer() {
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

    public static AudioAttributesCompat read(VersionedParcel versionedParcel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, versionedParcel)) == null) {
            AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
            audioAttributesCompat.mImpl = (AudioAttributesImpl) versionedParcel.readVersionedParcelable(audioAttributesCompat.mImpl, 1);
            return audioAttributesCompat;
        }
        return (AudioAttributesCompat) invokeL.objValue;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, VersionedParcel versionedParcel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, audioAttributesCompat, versionedParcel) == null) {
            versionedParcel.setSerializationFlags(false, false);
            versionedParcel.writeVersionedParcelable(audioAttributesCompat.mImpl, 1);
        }
    }
}
