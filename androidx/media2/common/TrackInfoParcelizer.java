package androidx.media2.common;

import androidx.media2.common.SessionPlayer;
import androidx.versionedparcelable.VersionedParcel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class TrackInfoParcelizer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TrackInfoParcelizer() {
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

    public static SessionPlayer.TrackInfo read(VersionedParcel versionedParcel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, versionedParcel)) == null) {
            SessionPlayer.TrackInfo trackInfo = new SessionPlayer.TrackInfo();
            trackInfo.mId = versionedParcel.readInt(trackInfo.mId, 1);
            trackInfo.mUpCastMediaItem = (MediaItem) versionedParcel.readVersionedParcelable(trackInfo.mUpCastMediaItem, 2);
            trackInfo.mTrackType = versionedParcel.readInt(trackInfo.mTrackType, 3);
            trackInfo.mParcelableExtras = versionedParcel.readBundle(trackInfo.mParcelableExtras, 4);
            trackInfo.onPostParceling();
            return trackInfo;
        }
        return (SessionPlayer.TrackInfo) invokeL.objValue;
    }

    public static void write(SessionPlayer.TrackInfo trackInfo, VersionedParcel versionedParcel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, trackInfo, versionedParcel) == null) {
            versionedParcel.setSerializationFlags(false, false);
            trackInfo.onPreParceling(versionedParcel.isStream());
            versionedParcel.writeInt(trackInfo.mId, 1);
            versionedParcel.writeVersionedParcelable(trackInfo.mUpCastMediaItem, 2);
            versionedParcel.writeInt(trackInfo.mTrackType, 3);
            versionedParcel.writeBundle(trackInfo.mParcelableExtras, 4);
        }
    }
}
