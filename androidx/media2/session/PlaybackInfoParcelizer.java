package androidx.media2.session;

import androidx.media.AudioAttributesCompat;
import androidx.media2.session.MediaController;
import androidx.versionedparcelable.VersionedParcel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class PlaybackInfoParcelizer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PlaybackInfoParcelizer() {
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

    public static MediaController.PlaybackInfo read(VersionedParcel versionedParcel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, versionedParcel)) == null) {
            MediaController.PlaybackInfo playbackInfo = new MediaController.PlaybackInfo();
            playbackInfo.mPlaybackType = versionedParcel.readInt(playbackInfo.mPlaybackType, 1);
            playbackInfo.mControlType = versionedParcel.readInt(playbackInfo.mControlType, 2);
            playbackInfo.mMaxVolume = versionedParcel.readInt(playbackInfo.mMaxVolume, 3);
            playbackInfo.mCurrentVolume = versionedParcel.readInt(playbackInfo.mCurrentVolume, 4);
            playbackInfo.mAudioAttrsCompat = (AudioAttributesCompat) versionedParcel.readVersionedParcelable(playbackInfo.mAudioAttrsCompat, 5);
            return playbackInfo;
        }
        return (MediaController.PlaybackInfo) invokeL.objValue;
    }

    public static void write(MediaController.PlaybackInfo playbackInfo, VersionedParcel versionedParcel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, playbackInfo, versionedParcel) == null) {
            versionedParcel.setSerializationFlags(false, false);
            versionedParcel.writeInt(playbackInfo.mPlaybackType, 1);
            versionedParcel.writeInt(playbackInfo.mControlType, 2);
            versionedParcel.writeInt(playbackInfo.mMaxVolume, 3);
            versionedParcel.writeInt(playbackInfo.mCurrentVolume, 4);
            versionedParcel.writeVersionedParcelable(playbackInfo.mAudioAttrsCompat, 5);
        }
    }
}
