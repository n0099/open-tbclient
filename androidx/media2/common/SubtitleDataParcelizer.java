package androidx.media2.common;

import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class SubtitleDataParcelizer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SubtitleDataParcelizer() {
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

    public static SubtitleData read(VersionedParcel versionedParcel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, versionedParcel)) == null) {
            SubtitleData subtitleData = new SubtitleData();
            subtitleData.mStartTimeUs = versionedParcel.readLong(subtitleData.mStartTimeUs, 1);
            subtitleData.mDurationUs = versionedParcel.readLong(subtitleData.mDurationUs, 2);
            subtitleData.mData = versionedParcel.readByteArray(subtitleData.mData, 3);
            return subtitleData;
        }
        return (SubtitleData) invokeL.objValue;
    }

    public static void write(SubtitleData subtitleData, VersionedParcel versionedParcel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, subtitleData, versionedParcel) == null) {
            versionedParcel.setSerializationFlags(false, false);
            versionedParcel.writeLong(subtitleData.mStartTimeUs, 1);
            versionedParcel.writeLong(subtitleData.mDurationUs, 2);
            versionedParcel.writeByteArray(subtitleData.mData, 3);
        }
    }
}
