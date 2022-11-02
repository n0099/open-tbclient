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
public final class MediaItemParcelizer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MediaItemParcelizer() {
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

    public static MediaItem read(VersionedParcel versionedParcel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, versionedParcel)) == null) {
            MediaItem mediaItem = new MediaItem();
            mediaItem.mMetadata = (MediaMetadata) versionedParcel.readVersionedParcelable(mediaItem.mMetadata, 1);
            mediaItem.mStartPositionMs = versionedParcel.readLong(mediaItem.mStartPositionMs, 2);
            mediaItem.mEndPositionMs = versionedParcel.readLong(mediaItem.mEndPositionMs, 3);
            mediaItem.onPostParceling();
            return mediaItem;
        }
        return (MediaItem) invokeL.objValue;
    }

    public static void write(MediaItem mediaItem, VersionedParcel versionedParcel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, mediaItem, versionedParcel) == null) {
            versionedParcel.setSerializationFlags(false, false);
            mediaItem.onPreParceling(versionedParcel.isStream());
            versionedParcel.writeVersionedParcelable(mediaItem.mMetadata, 1);
            versionedParcel.writeLong(mediaItem.mStartPositionMs, 2);
            versionedParcel.writeLong(mediaItem.mEndPositionMs, 3);
        }
    }
}
