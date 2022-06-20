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
public final class MediaMetadataParcelizer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MediaMetadataParcelizer() {
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

    public static MediaMetadata read(VersionedParcel versionedParcel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, versionedParcel)) == null) {
            MediaMetadata mediaMetadata = new MediaMetadata();
            mediaMetadata.mParcelableWithoutBitmapBundle = versionedParcel.readBundle(mediaMetadata.mParcelableWithoutBitmapBundle, 1);
            mediaMetadata.mBitmapListSlice = (ParcelImplListSlice) versionedParcel.readParcelable(mediaMetadata.mBitmapListSlice, 2);
            mediaMetadata.onPostParceling();
            return mediaMetadata;
        }
        return (MediaMetadata) invokeL.objValue;
    }

    public static void write(MediaMetadata mediaMetadata, VersionedParcel versionedParcel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, mediaMetadata, versionedParcel) == null) {
            versionedParcel.setSerializationFlags(false, false);
            mediaMetadata.onPreParceling(versionedParcel.isStream());
            versionedParcel.writeBundle(mediaMetadata.mParcelableWithoutBitmapBundle, 1);
            versionedParcel.writeParcelable(mediaMetadata.mBitmapListSlice, 2);
        }
    }
}
