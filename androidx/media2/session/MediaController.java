package androidx.media2.session;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import androidx.media.AudioAttributesCompat;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.Rating;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.SubtitleData;
import androidx.media2.common.VideoSize;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaSession;
import androidx.media2.session.SessionToken;
import androidx.versionedparcelable.VersionedParcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class MediaController implements Closeable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MediaController";
    public transient /* synthetic */ FieldHolder $fh;
    @GuardedBy("mLock")
    public boolean mClosed;
    @GuardedBy("mLock")
    public final List<Pair<ControllerCallback, Executor>> mExtraControllerCallbacks;
    @GuardedBy("mLock")
    public MediaControllerImpl mImpl;
    public final Object mLock;
    public final ControllerCallback mPrimaryCallback;
    public final Executor mPrimaryCallbackExecutor;
    public Long mTimeDiff;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public interface ControllerCallbackRunnable {
        void run(@NonNull ControllerCallback controllerCallback);
    }

    /* loaded from: classes.dex */
    public interface MediaControllerImpl extends Closeable {
        ListenableFuture<SessionResult> addPlaylistItem(int i, @NonNull String str);

        ListenableFuture<SessionResult> adjustVolume(int i, int i2);

        ListenableFuture<SessionResult> deselectTrack(SessionPlayer.TrackInfo trackInfo);

        ListenableFuture<SessionResult> fastForward();

        @Nullable
        SessionCommandGroup getAllowedCommands();

        @Nullable
        MediaBrowserCompat getBrowserCompat();

        long getBufferedPosition();

        int getBufferingState();

        @Nullable
        SessionToken getConnectedToken();

        @NonNull
        Context getContext();

        MediaItem getCurrentMediaItem();

        int getCurrentMediaItemIndex();

        long getCurrentPosition();

        long getDuration();

        int getNextMediaItemIndex();

        @Nullable
        PlaybackInfo getPlaybackInfo();

        float getPlaybackSpeed();

        int getPlayerState();

        @Nullable
        List<MediaItem> getPlaylist();

        @Nullable
        MediaMetadata getPlaylistMetadata();

        int getPreviousMediaItemIndex();

        int getRepeatMode();

        @Nullable
        SessionPlayer.TrackInfo getSelectedTrack(int i);

        @Nullable
        PendingIntent getSessionActivity();

        int getShuffleMode();

        @NonNull
        List<SessionPlayer.TrackInfo> getTracks();

        @NonNull
        VideoSize getVideoSize();

        boolean isConnected();

        ListenableFuture<SessionResult> movePlaylistItem(int i, int i2);

        ListenableFuture<SessionResult> pause();

        ListenableFuture<SessionResult> play();

        ListenableFuture<SessionResult> prepare();

        ListenableFuture<SessionResult> removePlaylistItem(int i);

        ListenableFuture<SessionResult> replacePlaylistItem(int i, @NonNull String str);

        ListenableFuture<SessionResult> rewind();

        ListenableFuture<SessionResult> seekTo(long j);

        ListenableFuture<SessionResult> selectTrack(SessionPlayer.TrackInfo trackInfo);

        ListenableFuture<SessionResult> sendCustomCommand(@NonNull SessionCommand sessionCommand, @Nullable Bundle bundle);

        ListenableFuture<SessionResult> setMediaItem(@NonNull String str);

        ListenableFuture<SessionResult> setMediaUri(@NonNull Uri uri, @Nullable Bundle bundle);

        ListenableFuture<SessionResult> setPlaybackSpeed(float f);

        ListenableFuture<SessionResult> setPlaylist(@NonNull List<String> list, @Nullable MediaMetadata mediaMetadata);

        ListenableFuture<SessionResult> setRating(@NonNull String str, @NonNull Rating rating);

        ListenableFuture<SessionResult> setRepeatMode(int i);

        ListenableFuture<SessionResult> setShuffleMode(int i);

        ListenableFuture<SessionResult> setSurface(@Nullable Surface surface);

        ListenableFuture<SessionResult> setVolumeTo(int i, int i2);

        ListenableFuture<SessionResult> skipBackward();

        ListenableFuture<SessionResult> skipForward();

        ListenableFuture<SessionResult> skipToNextItem();

        ListenableFuture<SessionResult> skipToPlaylistItem(int i);

        ListenableFuture<SessionResult> skipToPreviousItem();

        ListenableFuture<SessionResult> updatePlaylistMetadata(@Nullable MediaMetadata mediaMetadata);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface VolumeDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface VolumeFlags {
    }

    /* loaded from: classes.dex */
    public static final class Builder extends BuilderBase<MediaController, Builder, ControllerCallback> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(@NonNull Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // androidx.media2.session.MediaController.BuilderBase
        @NonNull
        public MediaController build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.mToken == null && this.mCompatToken == null) {
                    throw new IllegalArgumentException("token and compat token shouldn't be both null");
                }
                SessionToken sessionToken = this.mToken;
                if (sessionToken != null) {
                    return new MediaController(this.mContext, sessionToken, this.mConnectionHints, this.mCallbackExecutor, this.mCallback);
                }
                return new MediaController(this.mContext, this.mCompatToken, this.mConnectionHints, this.mCallbackExecutor, this.mCallback);
            }
            return (MediaController) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.media2.session.MediaController.BuilderBase
        @NonNull
        public Builder setConnectionHints(@NonNull Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
                return (Builder) super.setConnectionHints(bundle);
            }
            return (Builder) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.media2.session.MediaController.BuilderBase
        @NonNull
        public Builder setSessionCompatToken(@NonNull MediaSessionCompat.Token token) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, token)) == null) {
                return (Builder) super.setSessionCompatToken(token);
            }
            return (Builder) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.media2.session.MediaController.BuilderBase
        @NonNull
        public Builder setSessionToken(@NonNull SessionToken sessionToken) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, sessionToken)) == null) {
                return (Builder) super.setSessionToken(sessionToken);
            }
            return (Builder) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.media2.session.MediaController.BuilderBase
        @NonNull
        public Builder setControllerCallback(@NonNull Executor executor, @NonNull ControllerCallback controllerCallback) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, executor, controllerCallback)) == null) {
                return (Builder) super.setControllerCallback(executor, (Executor) controllerCallback);
            }
            return (Builder) invokeLL.objValue;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public static abstract class BuilderBase<T extends MediaController, U extends BuilderBase<T, U, C>, C extends ControllerCallback> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ControllerCallback mCallback;
        public Executor mCallbackExecutor;
        public MediaSessionCompat.Token mCompatToken;
        public Bundle mConnectionHints;
        public final Context mContext;
        public SessionToken mToken;

        @NonNull
        public abstract T build();

        public BuilderBase(@NonNull Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (context != null) {
                this.mContext = context;
                return;
            }
            throw new NullPointerException("context shouldn't be null");
        }

        @NonNull
        public U setConnectionHints(@NonNull Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
                if (bundle != null) {
                    if (!MediaUtils.doesBundleHaveCustomParcelable(bundle)) {
                        this.mConnectionHints = new Bundle(bundle);
                        return this;
                    }
                    throw new IllegalArgumentException("connectionHints shouldn't contain any custom parcelables");
                }
                throw new NullPointerException("connectionHints shouldn't be null");
            }
            return (U) invokeL.objValue;
        }

        @NonNull
        public U setControllerCallback(@NonNull Executor executor, @NonNull C c) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, executor, c)) == null) {
                if (executor != null) {
                    if (c != null) {
                        this.mCallbackExecutor = executor;
                        this.mCallback = c;
                        return this;
                    }
                    throw new NullPointerException("callback shouldn't be null");
                }
                throw new NullPointerException("executor shouldn't be null");
            }
            return (U) invokeLL.objValue;
        }

        @NonNull
        public U setSessionCompatToken(@NonNull MediaSessionCompat.Token token) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, token)) == null) {
                if (token != null) {
                    this.mCompatToken = token;
                    this.mToken = null;
                    return this;
                }
                throw new NullPointerException("compatToken shouldn't be null");
            }
            return (U) invokeL.objValue;
        }

        @NonNull
        public U setSessionToken(@NonNull SessionToken sessionToken) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, sessionToken)) == null) {
                if (sessionToken != null) {
                    this.mToken = sessionToken;
                    this.mCompatToken = null;
                    return this;
                }
                throw new NullPointerException("token shouldn't be null");
            }
            return (U) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ControllerCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public void onAllowedCommandsChanged(@NonNull MediaController mediaController, @NonNull SessionCommandGroup sessionCommandGroup) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, mediaController, sessionCommandGroup) == null) {
            }
        }

        public void onBufferingStateChanged(@NonNull MediaController mediaController, @NonNull MediaItem mediaItem, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaController, mediaItem, i) == null) {
            }
        }

        public void onConnected(@NonNull MediaController mediaController, @NonNull SessionCommandGroup sessionCommandGroup) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, mediaController, sessionCommandGroup) == null) {
            }
        }

        public void onCurrentMediaItemChanged(@NonNull MediaController mediaController, @Nullable MediaItem mediaItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, mediaController, mediaItem) == null) {
            }
        }

        public void onDisconnected(@NonNull MediaController mediaController) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, mediaController) == null) {
            }
        }

        public void onPlaybackCompleted(@NonNull MediaController mediaController) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, mediaController) == null) {
            }
        }

        public void onPlaybackInfoChanged(@NonNull MediaController mediaController, @NonNull PlaybackInfo playbackInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, mediaController, playbackInfo) == null) {
            }
        }

        public void onPlaybackSpeedChanged(@NonNull MediaController mediaController, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(InputDeviceCompat.SOURCE_TOUCHPAD, this, mediaController, f) == null) {
            }
        }

        public void onPlayerStateChanged(@NonNull MediaController mediaController, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048585, this, mediaController, i) == null) {
            }
        }

        public void onPlaylistChanged(@NonNull MediaController mediaController, @Nullable List<MediaItem> list, @Nullable MediaMetadata mediaMetadata) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048586, this, mediaController, list, mediaMetadata) == null) {
            }
        }

        public void onPlaylistMetadataChanged(@NonNull MediaController mediaController, @Nullable MediaMetadata mediaMetadata) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, mediaController, mediaMetadata) == null) {
            }
        }

        public void onRepeatModeChanged(@NonNull MediaController mediaController, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048588, this, mediaController, i) == null) {
            }
        }

        public void onSeekCompleted(@NonNull MediaController mediaController, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048589, this, mediaController, j) == null) {
            }
        }

        public int onSetCustomLayout(@NonNull MediaController mediaController, @NonNull List<MediaSession.CommandButton> list) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, mediaController, list)) == null) {
                return -6;
            }
            return invokeLL.intValue;
        }

        public void onShuffleModeChanged(@NonNull MediaController mediaController, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048591, this, mediaController, i) == null) {
            }
        }

        public void onSubtitleData(@NonNull MediaController mediaController, @NonNull MediaItem mediaItem, @NonNull SessionPlayer.TrackInfo trackInfo, @NonNull SubtitleData subtitleData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048592, this, mediaController, mediaItem, trackInfo, subtitleData) == null) {
            }
        }

        public void onTrackDeselected(@NonNull MediaController mediaController, @NonNull SessionPlayer.TrackInfo trackInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048593, this, mediaController, trackInfo) == null) {
            }
        }

        public void onTrackSelected(@NonNull MediaController mediaController, @NonNull SessionPlayer.TrackInfo trackInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048594, this, mediaController, trackInfo) == null) {
            }
        }

        public void onTracksChanged(@NonNull MediaController mediaController, @NonNull List<SessionPlayer.TrackInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048595, this, mediaController, list) == null) {
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        @Deprecated
        public void onVideoSizeChanged(@NonNull MediaController mediaController, @NonNull MediaItem mediaItem, @NonNull VideoSize videoSize) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048596, this, mediaController, mediaItem, videoSize) == null) {
            }
        }

        public void onVideoSizeChanged(@NonNull MediaController mediaController, @NonNull VideoSize videoSize) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048597, this, mediaController, videoSize) == null) {
            }
        }

        public ControllerCallback() {
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

        @NonNull
        public SessionResult onCustomCommand(@NonNull MediaController mediaController, @NonNull SessionCommand sessionCommand, @Nullable Bundle bundle) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, mediaController, sessionCommand, bundle)) == null) {
                return new SessionResult(-6);
            }
            return (SessionResult) invokeLLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class PlaybackInfo implements VersionedParcelable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int PLAYBACK_TYPE_LOCAL = 1;
        public static final int PLAYBACK_TYPE_REMOTE = 2;
        public transient /* synthetic */ FieldHolder $fh;
        public AudioAttributesCompat mAudioAttrsCompat;
        public int mControlType;
        public int mCurrentVolume;
        public int mMaxVolume;
        public int mPlaybackType;

        public PlaybackInfo() {
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

        @Nullable
        public AudioAttributesCompat getAudioAttributes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mAudioAttrsCompat;
            }
            return (AudioAttributesCompat) invokeV.objValue;
        }

        public int getControlType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mControlType;
            }
            return invokeV.intValue;
        }

        public int getCurrentVolume() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.mCurrentVolume;
            }
            return invokeV.intValue;
        }

        public int getMaxVolume() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.mMaxVolume;
            }
            return invokeV.intValue;
        }

        public int getPlaybackType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.mPlaybackType;
            }
            return invokeV.intValue;
        }

        public PlaybackInfo(int i, AudioAttributesCompat audioAttributesCompat, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), audioAttributesCompat, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mPlaybackType = i;
            this.mAudioAttrsCompat = audioAttributesCompat;
            this.mControlType = i2;
            this.mMaxVolume = i3;
            this.mCurrentVolume = i4;
        }

        public static PlaybackInfo createPlaybackInfo(int i, AudioAttributesCompat audioAttributesCompat, int i2, int i3, int i4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), audioAttributesCompat, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
                return new PlaybackInfo(i, audioAttributesCompat, i2, i3, i4);
            }
            return (PlaybackInfo) invokeCommon.objValue;
        }

        public boolean equals(@Nullable Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (!(obj instanceof PlaybackInfo)) {
                    return false;
                }
                PlaybackInfo playbackInfo = (PlaybackInfo) obj;
                if (this.mPlaybackType != playbackInfo.mPlaybackType || this.mControlType != playbackInfo.mControlType || this.mMaxVolume != playbackInfo.mMaxVolume || this.mCurrentVolume != playbackInfo.mCurrentVolume || !ObjectsCompat.equals(this.mAudioAttrsCompat, playbackInfo.mAudioAttrsCompat)) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return ObjectsCompat.hash(Integer.valueOf(this.mPlaybackType), Integer.valueOf(this.mControlType), Integer.valueOf(this.mMaxVolume), Integer.valueOf(this.mCurrentVolume), this.mAudioAttrsCompat);
            }
            return invokeV.intValue;
        }
    }

    public MediaController(@NonNull final Context context, @NonNull MediaSessionCompat.Token token, @Nullable final Bundle bundle, @Nullable Executor executor, @Nullable ControllerCallback controllerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, token, bundle, executor, controllerCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLock = new Object();
        this.mExtraControllerCallbacks = new ArrayList();
        if (context != null) {
            if (token != null) {
                this.mPrimaryCallback = controllerCallback;
                this.mPrimaryCallbackExecutor = executor;
                SessionToken.createSessionToken(context, token, new SessionToken.OnSessionTokenCreatedListener() { // from class: com.baidu.tieba.c0
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // androidx.media2.session.SessionToken.OnSessionTokenCreatedListener
                    public final void onSessionTokenCreated(MediaSessionCompat.Token token2, SessionToken sessionToken) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, token2, sessionToken) == null) {
                            MediaController.this.b(context, bundle, token2, sessionToken);
                        }
                    }
                });
                return;
            }
            throw new NullPointerException("token shouldn't be null");
        }
        throw new NullPointerException("context shouldn't be null");
    }

    public MediaController(@NonNull Context context, @NonNull SessionToken sessionToken, @Nullable Bundle bundle, @Nullable Executor executor, @Nullable ControllerCallback controllerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, sessionToken, bundle, executor, controllerCallback};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLock = new Object();
        this.mExtraControllerCallbacks = new ArrayList();
        if (context != null) {
            if (sessionToken != null) {
                this.mPrimaryCallback = controllerCallback;
                this.mPrimaryCallbackExecutor = executor;
                synchronized (this.mLock) {
                    this.mImpl = createImpl(context, sessionToken, bundle);
                }
                return;
            }
            throw new NullPointerException("token shouldn't be null");
        }
        throw new NullPointerException("context shouldn't be null");
    }

    public static ListenableFuture<SessionResult> createDisconnectedFuture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return SessionResult.createFutureWithResult(-100);
        }
        return (ListenableFuture) invokeV.objValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                synchronized (this.mLock) {
                    if (this.mClosed) {
                        return;
                    }
                    this.mClosed = true;
                    MediaControllerImpl mediaControllerImpl = this.mImpl;
                    if (mediaControllerImpl != null) {
                        mediaControllerImpl.close();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    @NonNull
    public ListenableFuture<SessionResult> fastForward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (isConnected()) {
                return getImpl().fastForward();
            }
            return createDisconnectedFuture();
        }
        return (ListenableFuture) invokeV.objValue;
    }

    @Nullable
    public SessionCommandGroup getAllowedCommands() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!isConnected()) {
                return null;
            }
            return getImpl().getAllowedCommands();
        }
        return (SessionCommandGroup) invokeV.objValue;
    }

    public long getBufferedPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (isConnected()) {
                return getImpl().getBufferedPosition();
            }
            return Long.MIN_VALUE;
        }
        return invokeV.longValue;
    }

    public int getBufferingState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (isConnected()) {
                return getImpl().getBufferingState();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Nullable
    public SessionToken getConnectedToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (isConnected()) {
                return getImpl().getConnectedToken();
            }
            return null;
        }
        return (SessionToken) invokeV.objValue;
    }

    @Nullable
    public MediaItem getCurrentMediaItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (isConnected()) {
                return getImpl().getCurrentMediaItem();
            }
            return null;
        }
        return (MediaItem) invokeV.objValue;
    }

    public int getCurrentMediaItemIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (isConnected()) {
                return getImpl().getCurrentMediaItemIndex();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (isConnected()) {
                return getImpl().getCurrentPosition();
            }
            return Long.MIN_VALUE;
        }
        return invokeV.longValue;
    }

    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (isConnected()) {
                return getImpl().getDuration();
            }
            return Long.MIN_VALUE;
        }
        return invokeV.longValue;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Pair<ControllerCallback, Executor>> getExtraControllerCallbacks() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            synchronized (this.mLock) {
                arrayList = new ArrayList(this.mExtraControllerCallbacks);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public MediaControllerImpl getImpl() {
        InterceptResult invokeV;
        MediaControllerImpl mediaControllerImpl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            synchronized (this.mLock) {
                mediaControllerImpl = this.mImpl;
            }
            return mediaControllerImpl;
        }
        return (MediaControllerImpl) invokeV.objValue;
    }

    public int getNextMediaItemIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (isConnected()) {
                return getImpl().getNextMediaItemIndex();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Nullable
    public PlaybackInfo getPlaybackInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (isConnected()) {
                return getImpl().getPlaybackInfo();
            }
            return null;
        }
        return (PlaybackInfo) invokeV.objValue;
    }

    public float getPlaybackSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (isConnected()) {
                return getImpl().getPlaybackSpeed();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    public int getPlayerState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (isConnected()) {
                return getImpl().getPlayerState();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Nullable
    public List<MediaItem> getPlaylist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (isConnected()) {
                return getImpl().getPlaylist();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Nullable
    public MediaMetadata getPlaylistMetadata() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (isConnected()) {
                return getImpl().getPlaylistMetadata();
            }
            return null;
        }
        return (MediaMetadata) invokeV.objValue;
    }

    public int getPreviousMediaItemIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (isConnected()) {
                return getImpl().getPreviousMediaItemIndex();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public int getRepeatMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (isConnected()) {
                return getImpl().getRepeatMode();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Nullable
    public PendingIntent getSessionActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (isConnected()) {
                return getImpl().getSessionActivity();
            }
            return null;
        }
        return (PendingIntent) invokeV.objValue;
    }

    public int getShuffleMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (isConnected()) {
                return getImpl().getShuffleMode();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @NonNull
    public List<SessionPlayer.TrackInfo> getTracks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (isConnected()) {
                return getImpl().getTracks();
            }
            return Collections.emptyList();
        }
        return (List) invokeV.objValue;
    }

    @NonNull
    public VideoSize getVideoSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (isConnected()) {
                return getImpl().getVideoSize();
            }
            return new VideoSize(0, 0);
        }
        return (VideoSize) invokeV.objValue;
    }

    public boolean isConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            MediaControllerImpl impl = getImpl();
            if (impl != null && impl.isConnected()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public ListenableFuture<SessionResult> pause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (isConnected()) {
                return getImpl().pause();
            }
            return createDisconnectedFuture();
        }
        return (ListenableFuture) invokeV.objValue;
    }

    @NonNull
    public ListenableFuture<SessionResult> play() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (isConnected()) {
                return getImpl().play();
            }
            return createDisconnectedFuture();
        }
        return (ListenableFuture) invokeV.objValue;
    }

    @NonNull
    public ListenableFuture<SessionResult> prepare() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (isConnected()) {
                return getImpl().prepare();
            }
            return createDisconnectedFuture();
        }
        return (ListenableFuture) invokeV.objValue;
    }

    @NonNull
    public ListenableFuture<SessionResult> rewind() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (isConnected()) {
                return getImpl().rewind();
            }
            return createDisconnectedFuture();
        }
        return (ListenableFuture) invokeV.objValue;
    }

    @NonNull
    public ListenableFuture<SessionResult> skipBackward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            if (isConnected()) {
                return getImpl().skipBackward();
            }
            return createDisconnectedFuture();
        }
        return (ListenableFuture) invokeV.objValue;
    }

    @NonNull
    public ListenableFuture<SessionResult> skipForward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            if (isConnected()) {
                return getImpl().skipForward();
            }
            return createDisconnectedFuture();
        }
        return (ListenableFuture) invokeV.objValue;
    }

    @NonNull
    public ListenableFuture<SessionResult> skipToNextPlaylistItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            if (isConnected()) {
                return getImpl().skipToNextItem();
            }
            return createDisconnectedFuture();
        }
        return (ListenableFuture) invokeV.objValue;
    }

    @NonNull
    public ListenableFuture<SessionResult> skipToPreviousPlaylistItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            if (isConnected()) {
                return getImpl().skipToPreviousItem();
            }
            return createDisconnectedFuture();
        }
        return (ListenableFuture) invokeV.objValue;
    }

    public /* synthetic */ void a(ControllerCallback controllerCallback) {
        controllerCallback.onDisconnected(this);
    }

    @NonNull
    public ListenableFuture<SessionResult> deselectTrack(@NonNull SessionPlayer.TrackInfo trackInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, trackInfo)) == null) {
            if (trackInfo != null) {
                if (isConnected()) {
                    return getImpl().deselectTrack(trackInfo);
                }
                return createDisconnectedFuture();
            }
            throw new NullPointerException("TrackInfo shouldn't be null");
        }
        return (ListenableFuture) invokeL.objValue;
    }

    @Nullable
    public SessionPlayer.TrackInfo getSelectedTrack(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i)) == null) {
            if (isConnected()) {
                return getImpl().getSelectedTrack(i);
            }
            return null;
        }
        return (SessionPlayer.TrackInfo) invokeI.objValue;
    }

    public void notifyPrimaryControllerCallback(@NonNull ControllerCallbackRunnable controllerCallbackRunnable) {
        Executor executor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, controllerCallbackRunnable) == null) && this.mPrimaryCallback != null && (executor = this.mPrimaryCallbackExecutor) != null) {
            executor.execute(new Runnable(this, controllerCallbackRunnable) { // from class: androidx.media2.session.MediaController.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaController this$0;
                public final /* synthetic */ ControllerCallbackRunnable val$callbackRunnable;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, controllerCallbackRunnable};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callbackRunnable = controllerCallbackRunnable;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.val$callbackRunnable.run(this.this$0.mPrimaryCallback);
                    }
                }
            });
        }
    }

    @NonNull
    public ListenableFuture<SessionResult> removePlaylistItem(@IntRange(from = 0) int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i)) == null) {
            if (i >= 0) {
                if (isConnected()) {
                    return getImpl().removePlaylistItem(i);
                }
                return createDisconnectedFuture();
            }
            throw new IllegalArgumentException("index shouldn't be negative");
        }
        return (ListenableFuture) invokeI.objValue;
    }

    @NonNull
    public ListenableFuture<SessionResult> seekTo(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048618, this, j)) == null) {
            if (isConnected()) {
                return getImpl().seekTo(j);
            }
            return createDisconnectedFuture();
        }
        return (ListenableFuture) invokeJ.objValue;
    }

    @NonNull
    public ListenableFuture<SessionResult> selectTrack(@NonNull SessionPlayer.TrackInfo trackInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, trackInfo)) == null) {
            if (trackInfo != null) {
                if (isConnected()) {
                    return getImpl().selectTrack(trackInfo);
                }
                return createDisconnectedFuture();
            }
            throw new NullPointerException("TrackInfo shouldn't be null");
        }
        return (ListenableFuture) invokeL.objValue;
    }

    @NonNull
    public ListenableFuture<SessionResult> setRepeatMode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048626, this, i)) == null) {
            if (isConnected()) {
                return getImpl().setRepeatMode(i);
            }
            return createDisconnectedFuture();
        }
        return (ListenableFuture) invokeI.objValue;
    }

    @NonNull
    public ListenableFuture<SessionResult> setShuffleMode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048627, this, i)) == null) {
            if (isConnected()) {
                return getImpl().setShuffleMode(i);
            }
            return createDisconnectedFuture();
        }
        return (ListenableFuture) invokeI.objValue;
    }

    @NonNull
    public ListenableFuture<SessionResult> setSurface(@Nullable Surface surface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, surface)) == null) {
            if (isConnected()) {
                return getImpl().setSurface(surface);
            }
            return createDisconnectedFuture();
        }
        return (ListenableFuture) invokeL.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setTimeDiff(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, l) == null) {
            this.mTimeDiff = l;
        }
    }

    @NonNull
    public ListenableFuture<SessionResult> skipToPlaylistItem(@IntRange(from = 0) int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048634, this, i)) == null) {
            if (i >= 0) {
                if (isConnected()) {
                    return getImpl().skipToPlaylistItem(i);
                }
                return createDisconnectedFuture();
            }
            throw new IllegalArgumentException("index shouldn't be negative");
        }
        return (ListenableFuture) invokeI.objValue;
    }

    @NonNull
    public ListenableFuture<SessionResult> updatePlaylistMetadata(@Nullable MediaMetadata mediaMetadata) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, mediaMetadata)) == null) {
            if (isConnected()) {
                return getImpl().updatePlaylistMetadata(mediaMetadata);
            }
            return createDisconnectedFuture();
        }
        return (ListenableFuture) invokeL.objValue;
    }

    @NonNull
    public ListenableFuture<SessionResult> addPlaylistItem(@IntRange(from = 0) int i, @NonNull String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str)) == null) {
            if (i >= 0) {
                if (!TextUtils.isEmpty(str)) {
                    if (isConnected()) {
                        return getImpl().addPlaylistItem(i, str);
                    }
                    return createDisconnectedFuture();
                }
                throw new IllegalArgumentException("mediaId shouldn't be empty");
            }
            throw new IllegalArgumentException("index shouldn't be negative");
        }
        return (ListenableFuture) invokeIL.objValue;
    }

    @NonNull
    public ListenableFuture<SessionResult> movePlaylistItem(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048608, this, i, i2)) == null) {
            if (i >= 0 && i2 >= 0) {
                if (isConnected()) {
                    return getImpl().movePlaylistItem(i, i2);
                }
                return createDisconnectedFuture();
            }
            throw new IllegalArgumentException("indexes shouldn't be negative");
        }
        return (ListenableFuture) invokeII.objValue;
    }

    @NonNull
    public ListenableFuture<SessionResult> replacePlaylistItem(@IntRange(from = 0) int i, @NonNull String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048616, this, i, str)) == null) {
            if (i >= 0) {
                if (!TextUtils.isEmpty(str)) {
                    if (isConnected()) {
                        return getImpl().replacePlaylistItem(i, str);
                    }
                    return createDisconnectedFuture();
                }
                throw new IllegalArgumentException("mediaId shouldn't be empty");
            }
            throw new IllegalArgumentException("index shouldn't be negative");
        }
        return (ListenableFuture) invokeIL.objValue;
    }

    @NonNull
    public ListenableFuture<SessionResult> sendCustomCommand(@NonNull SessionCommand sessionCommand, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048620, this, sessionCommand, bundle)) == null) {
            if (sessionCommand != null) {
                if (sessionCommand.getCommandCode() == 0) {
                    if (isConnected()) {
                        return getImpl().sendCustomCommand(sessionCommand, bundle);
                    }
                    return createDisconnectedFuture();
                }
                throw new IllegalArgumentException("command should be a custom command");
            }
            throw new NullPointerException("command shouldn't be null");
        }
        return (ListenableFuture) invokeLL.objValue;
    }

    @NonNull
    public ListenableFuture<SessionResult> adjustVolume(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2)) == null) {
            if (isConnected()) {
                return getImpl().adjustVolume(i, i2);
            }
            return createDisconnectedFuture();
        }
        return (ListenableFuture) invokeII.objValue;
    }

    @NonNull
    public ListenableFuture<SessionResult> setMediaUri(@NonNull Uri uri, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048622, this, uri, bundle)) == null) {
            if (uri != null) {
                if (isConnected()) {
                    return getImpl().setMediaUri(uri, bundle);
                }
                return createDisconnectedFuture();
            }
            throw new NullPointerException("mediaUri shouldn't be null");
        }
        return (ListenableFuture) invokeLL.objValue;
    }

    @NonNull
    public ListenableFuture<SessionResult> setVolumeTo(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048630, this, i, i2)) == null) {
            if (isConnected()) {
                return getImpl().setVolumeTo(i, i2);
            }
            return createDisconnectedFuture();
        }
        return (ListenableFuture) invokeII.objValue;
    }

    public /* synthetic */ void b(Context context, Bundle bundle, MediaSessionCompat.Token token, SessionToken sessionToken) {
        synchronized (this.mLock) {
            if (!this.mClosed) {
                this.mImpl = createImpl(context, sessionToken, bundle);
            } else {
                notifyAllControllerCallbacks(new ControllerCallbackRunnable() { // from class: com.baidu.tieba.d0
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                    public final void run(MediaController.ControllerCallback controllerCallback) {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeL(1048576, this, controllerCallback) == null) {
                            MediaController.this.a(controllerCallback);
                        }
                    }
                });
            }
        }
    }

    public MediaControllerImpl createImpl(@NonNull Context context, @NonNull SessionToken sessionToken, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, context, sessionToken, bundle)) == null) {
            if (sessionToken.isLegacySession()) {
                return new MediaControllerImplLegacy(context, this, sessionToken);
            }
            return new MediaControllerImplBase(context, this, sessionToken, bundle);
        }
        return (MediaControllerImpl) invokeLLL.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void notifyAllControllerCallbacks(@NonNull ControllerCallbackRunnable controllerCallbackRunnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, controllerCallbackRunnable) == null) {
            notifyPrimaryControllerCallback(controllerCallbackRunnable);
            for (Pair<ControllerCallback, Executor> pair : getExtraControllerCallbacks()) {
                ControllerCallback controllerCallback = pair.first;
                Executor executor = pair.second;
                if (controllerCallback == null) {
                    Log.e(TAG, "notifyAllControllerCallbacks: mExtraControllerCallbacks contains a null ControllerCallback! Ignoring.");
                } else if (executor == null) {
                    Log.e(TAG, "notifyAllControllerCallbacks: mExtraControllerCallbacks contains a null Executor! Ignoring.");
                } else {
                    executor.execute(new Runnable(this, controllerCallbackRunnable, controllerCallback) { // from class: androidx.media2.session.MediaController.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MediaController this$0;
                        public final /* synthetic */ ControllerCallback val$callback;
                        public final /* synthetic */ ControllerCallbackRunnable val$callbackRunnable;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, controllerCallbackRunnable, controllerCallback};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$callbackRunnable = controllerCallbackRunnable;
                            this.val$callback = controllerCallback;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$callbackRunnable.run(this.val$callback);
                            }
                        }
                    });
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void unregisterExtraCallback(@NonNull ControllerCallback controllerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, controllerCallback) == null) {
            if (controllerCallback != null) {
                boolean z = false;
                synchronized (this.mLock) {
                    int size = this.mExtraControllerCallbacks.size() - 1;
                    while (true) {
                        if (size < 0) {
                            break;
                        } else if (this.mExtraControllerCallbacks.get(size).first == controllerCallback) {
                            this.mExtraControllerCallbacks.remove(size);
                            z = true;
                            break;
                        } else {
                            size--;
                        }
                    }
                }
                if (!z) {
                    Log.w(TAG, "unregisterExtraCallback: no such callback found");
                    return;
                }
                return;
            }
            throw new NullPointerException("callback shouldn't be null");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void registerExtraCallback(@NonNull Executor executor, @NonNull ControllerCallback controllerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, executor, controllerCallback) == null) {
            if (executor != null) {
                if (controllerCallback != null) {
                    boolean z = false;
                    synchronized (this.mLock) {
                        Iterator<Pair<ControllerCallback, Executor>> it = this.mExtraControllerCallbacks.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            } else if (it.next().first == controllerCallback) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            this.mExtraControllerCallbacks.add(new Pair<>(controllerCallback, executor));
                        }
                    }
                    if (z) {
                        Log.w(TAG, "registerExtraCallback: the callback already exists");
                        return;
                    }
                    return;
                }
                throw new NullPointerException("callback shouldn't be null");
            }
            throw new NullPointerException("executor shouldn't be null");
        }
    }

    @NonNull
    public ListenableFuture<SessionResult> setPlaylist(@NonNull List<String> list, @Nullable MediaMetadata mediaMetadata) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048624, this, list, mediaMetadata)) == null) {
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    if (TextUtils.isEmpty(list.get(i))) {
                        throw new IllegalArgumentException("list shouldn't contain empty id, index=" + i);
                    }
                }
                if (isConnected()) {
                    return getImpl().setPlaylist(list, mediaMetadata);
                }
                return createDisconnectedFuture();
            }
            throw new NullPointerException("list shouldn't be null");
        }
        return (ListenableFuture) invokeLL.objValue;
    }

    @NonNull
    public ListenableFuture<SessionResult> setRating(@NonNull String str, @NonNull Rating rating) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048625, this, str, rating)) == null) {
            if (str != null) {
                if (!TextUtils.isEmpty(str)) {
                    if (rating != null) {
                        if (isConnected()) {
                            return getImpl().setRating(str, rating);
                        }
                        return createDisconnectedFuture();
                    }
                    throw new NullPointerException("rating shouldn't be null");
                }
                throw new IllegalArgumentException("mediaId shouldn't be empty");
            }
            throw new NullPointerException("mediaId shouldn't be null");
        }
        return (ListenableFuture) invokeLL.objValue;
    }

    @NonNull
    public ListenableFuture<SessionResult> setMediaItem(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (isConnected()) {
                    return getImpl().setMediaItem(str);
                }
                return createDisconnectedFuture();
            }
            throw new IllegalArgumentException("mediaId shouldn't be empty");
        }
        return (ListenableFuture) invokeL.objValue;
    }

    @NonNull
    public ListenableFuture<SessionResult> setPlaybackSpeed(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048623, this, f)) == null) {
            if (f != 0.0f) {
                if (isConnected()) {
                    return getImpl().setPlaybackSpeed(f);
                }
                return createDisconnectedFuture();
            }
            throw new IllegalArgumentException("speed must not be zero");
        }
        return (ListenableFuture) invokeF.objValue;
    }
}
