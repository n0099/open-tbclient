package androidx.media2.session;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mAllowedCommands;
        }
        return (SessionCommandGroup) invokeV.objValue;
    }

    public long getBufferedPositionMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mBufferedPositionMs;
        }
        return invokeV.longValue;
    }

    public MediaItem getCurrentMediaItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mCurrentMediaItem;
        }
        return (MediaItem) invokeV.objValue;
    }

    public int getCurrentMediaItemIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mCurrentMediaItemIndex;
        }
        return invokeV.intValue;
    }

    public int getNextMediaItemIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mNextMediaItemIndex;
        }
        return invokeV.intValue;
    }

    public MediaController.PlaybackInfo getPlaybackInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mPlaybackInfo;
        }
        return (MediaController.PlaybackInfo) invokeV.objValue;
    }

    public float getPlaybackSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mPlaybackSpeed;
        }
        return invokeV.floatValue;
    }

    public int getPlayerState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mPlayerState;
        }
        return invokeV.intValue;
    }

    public ParcelImplListSlice getPlaylistSlice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mPlaylistSlice;
        }
        return (ParcelImplListSlice) invokeV.objValue;
    }

    public long getPositionEventTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mPositionEventTimeMs;
        }
        return invokeV.longValue;
    }

    public long getPositionMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mPositionMs;
        }
        return invokeV.longValue;
    }

    public int getPreviousMediaItemIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mPreviousMediaItemIndex;
        }
        return invokeV.intValue;
    }

    public int getRepeatMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mRepeatMode;
        }
        return invokeV.intValue;
    }

    public SessionPlayer.TrackInfo getSelectedAudioTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mSelectedAudioTrack;
        }
        return (SessionPlayer.TrackInfo) invokeV.objValue;
    }

    public SessionPlayer.TrackInfo getSelectedMetadataTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mSelectedMetadataTrack;
        }
        return (SessionPlayer.TrackInfo) invokeV.objValue;
    }

    public SessionPlayer.TrackInfo getSelectedSubtitleTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mSelectedSubtitleTrack;
        }
        return (SessionPlayer.TrackInfo) invokeV.objValue;
    }

    public SessionPlayer.TrackInfo getSelectedVideoTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mSelectedVideoTrack;
        }
        return (SessionPlayer.TrackInfo) invokeV.objValue;
    }

    public PendingIntent getSessionActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mSessionActivity;
        }
        return (PendingIntent) invokeV.objValue;
    }

    public IMediaSession getSessionStub() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mSessionStub;
        }
        return (IMediaSession) invokeV.objValue;
    }

    public int getShuffleMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mShuffleMode;
        }
        return invokeV.intValue;
    }

    public Bundle getTokenExtras() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mTokenExtras;
        }
        return (Bundle) invokeV.objValue;
    }

    public List<SessionPlayer.TrackInfo> getTracks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            List<SessionPlayer.TrackInfo> list = this.mTracks;
            if (list == null) {
                return Collections.emptyList();
            }
            return list;
        }
        return (List) invokeV.objValue;
    }

    public int getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mVersion;
        }
        return invokeV.intValue;
    }

    public VideoSize getVideoSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.mVideoSize;
        }
        return (VideoSize) invokeV.objValue;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPostParceling() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.mSessionStub = IMediaSession.Stub.asInterface(this.mSessionBinder);
            this.mCurrentMediaItem = this.mParcelableCurrentMediaItem;
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
}
