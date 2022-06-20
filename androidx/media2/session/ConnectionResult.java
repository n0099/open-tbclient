package androidx.media2.session;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.media2.common.MediaItem;
import androidx.media2.common.ParcelImplListSlice;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.VideoSize;
import androidx.media2.session.IMediaSession;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaSession;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class ConnectionResult extends CustomVersionedParcelable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SessionCommandGroup mAllowedCommands;
    public long mBufferedPositionMs;
    public MediaItem mCurrentMediaItem;
    public int mCurrentMediaItemIndex;
    public int mNextMediaItemIndex;
    public MediaItem mParcelableCurrentMediaItem;
    public MediaController.PlaybackInfo mPlaybackInfo;
    public float mPlaybackSpeed;
    public int mPlayerState;
    public ParcelImplListSlice mPlaylistSlice;
    public long mPositionEventTimeMs;
    public long mPositionMs;
    public int mPreviousMediaItemIndex;
    public int mRepeatMode;
    public SessionPlayer.TrackInfo mSelectedAudioTrack;
    public SessionPlayer.TrackInfo mSelectedMetadataTrack;
    public SessionPlayer.TrackInfo mSelectedSubtitleTrack;
    public SessionPlayer.TrackInfo mSelectedVideoTrack;
    public PendingIntent mSessionActivity;
    public IBinder mSessionBinder;
    public IMediaSession mSessionStub;
    public int mShuffleMode;
    public Bundle mTokenExtras;
    public List<SessionPlayer.TrackInfo> mTracks;
    public int mVersion;
    public VideoSize mVideoSize;

    public ConnectionResult() {
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

    public SessionCommandGroup getAllowedCommands() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAllowedCommands : (SessionCommandGroup) invokeV.objValue;
    }

    public long getBufferedPositionMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mBufferedPositionMs : invokeV.longValue;
    }

    public MediaItem getCurrentMediaItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCurrentMediaItem : (MediaItem) invokeV.objValue;
    }

    public int getCurrentMediaItemIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCurrentMediaItemIndex : invokeV.intValue;
    }

    public int getNextMediaItemIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mNextMediaItemIndex : invokeV.intValue;
    }

    public MediaController.PlaybackInfo getPlaybackInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mPlaybackInfo : (MediaController.PlaybackInfo) invokeV.objValue;
    }

    public float getPlaybackSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mPlaybackSpeed : invokeV.floatValue;
    }

    public int getPlayerState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mPlayerState : invokeV.intValue;
    }

    public ParcelImplListSlice getPlaylistSlice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mPlaylistSlice : (ParcelImplListSlice) invokeV.objValue;
    }

    public long getPositionEventTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mPositionEventTimeMs : invokeV.longValue;
    }

    public long getPositionMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mPositionMs : invokeV.longValue;
    }

    public int getPreviousMediaItemIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mPreviousMediaItemIndex : invokeV.intValue;
    }

    public int getRepeatMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mRepeatMode : invokeV.intValue;
    }

    public SessionPlayer.TrackInfo getSelectedAudioTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mSelectedAudioTrack : (SessionPlayer.TrackInfo) invokeV.objValue;
    }

    public SessionPlayer.TrackInfo getSelectedMetadataTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mSelectedMetadataTrack : (SessionPlayer.TrackInfo) invokeV.objValue;
    }

    public SessionPlayer.TrackInfo getSelectedSubtitleTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mSelectedSubtitleTrack : (SessionPlayer.TrackInfo) invokeV.objValue;
    }

    public SessionPlayer.TrackInfo getSelectedVideoTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mSelectedVideoTrack : (SessionPlayer.TrackInfo) invokeV.objValue;
    }

    public PendingIntent getSessionActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mSessionActivity : (PendingIntent) invokeV.objValue;
    }

    public IMediaSession getSessionStub() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mSessionStub : (IMediaSession) invokeV.objValue;
    }

    public int getShuffleMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mShuffleMode : invokeV.intValue;
    }

    public Bundle getTokenExtras() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mTokenExtras : (Bundle) invokeV.objValue;
    }

    @NonNull
    public List<SessionPlayer.TrackInfo> getTracks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            List<SessionPlayer.TrackInfo> list = this.mTracks;
            return list == null ? Collections.emptyList() : list;
        }
        return (List) invokeV.objValue;
    }

    public int getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mVersion : invokeV.intValue;
    }

    public VideoSize getVideoSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mVideoSize : (VideoSize) invokeV.objValue;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPostParceling() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.mSessionStub = IMediaSession.Stub.asInterface(this.mSessionBinder);
            this.mCurrentMediaItem = this.mParcelableCurrentMediaItem;
        }
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPreParceling(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            synchronized (this.mSessionStub) {
                if (this.mSessionBinder == null) {
                    this.mSessionBinder = (IBinder) this.mSessionStub;
                    this.mParcelableCurrentMediaItem = MediaUtils.upcastForPreparceling(this.mCurrentMediaItem);
                }
            }
        }
    }

    public ConnectionResult(MediaSessionStub mediaSessionStub, MediaSession.MediaSessionImpl mediaSessionImpl, SessionCommandGroup sessionCommandGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaSessionStub, mediaSessionImpl, sessionCommandGroup};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSessionStub = mediaSessionStub;
        this.mPlayerState = mediaSessionImpl.getPlayerState();
        this.mCurrentMediaItem = mediaSessionImpl.getCurrentMediaItem();
        this.mPositionEventTimeMs = SystemClock.elapsedRealtime();
        this.mPositionMs = mediaSessionImpl.getCurrentPosition();
        this.mPlaybackSpeed = mediaSessionImpl.getPlaybackSpeed();
        this.mBufferedPositionMs = mediaSessionImpl.getBufferedPosition();
        this.mPlaybackInfo = mediaSessionImpl.getPlaybackInfo();
        this.mRepeatMode = mediaSessionImpl.getRepeatMode();
        this.mShuffleMode = mediaSessionImpl.getShuffleMode();
        this.mSessionActivity = mediaSessionImpl.getSessionActivity();
        this.mCurrentMediaItemIndex = mediaSessionImpl.getCurrentMediaItemIndex();
        this.mPreviousMediaItemIndex = mediaSessionImpl.getPreviousMediaItemIndex();
        this.mNextMediaItemIndex = mediaSessionImpl.getNextMediaItemIndex();
        this.mTokenExtras = mediaSessionImpl.getToken().getExtras();
        this.mVideoSize = mediaSessionImpl.getVideoSize();
        this.mTracks = mediaSessionImpl.getTracks();
        this.mSelectedVideoTrack = mediaSessionImpl.getSelectedTrack(1);
        this.mSelectedAudioTrack = mediaSessionImpl.getSelectedTrack(2);
        this.mSelectedSubtitleTrack = mediaSessionImpl.getSelectedTrack(4);
        this.mSelectedMetadataTrack = mediaSessionImpl.getSelectedTrack(5);
        if (sessionCommandGroup != null && sessionCommandGroup.hasCommand(10005)) {
            this.mPlaylistSlice = MediaUtils.convertMediaItemListToParcelImplListSlice(mediaSessionImpl.getPlaylist());
        } else {
            this.mPlaylistSlice = null;
        }
        this.mAllowedCommands = sessionCommandGroup;
        this.mVersion = 0;
    }
}
