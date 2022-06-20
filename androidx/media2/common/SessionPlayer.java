package androidx.media2.common;

import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import androidx.media.AudioAttributesCompat;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.mp4.MetadataUtil;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public abstract class SessionPlayer implements Closeable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUFFERING_STATE_BUFFERING_AND_PLAYABLE = 1;
    public static final int BUFFERING_STATE_BUFFERING_AND_STARVED = 2;
    public static final int BUFFERING_STATE_COMPLETE = 3;
    public static final int BUFFERING_STATE_UNKNOWN = 0;
    public static final int INVALID_ITEM_INDEX = -1;
    public static final int PLAYER_STATE_ERROR = 3;
    public static final int PLAYER_STATE_IDLE = 0;
    public static final int PLAYER_STATE_PAUSED = 1;
    public static final int PLAYER_STATE_PLAYING = 2;
    public static final int REPEAT_MODE_ALL = 2;
    public static final int REPEAT_MODE_GROUP = 3;
    public static final int REPEAT_MODE_NONE = 0;
    public static final int REPEAT_MODE_ONE = 1;
    public static final int SHUFFLE_MODE_ALL = 1;
    public static final int SHUFFLE_MODE_GROUP = 2;
    public static final int SHUFFLE_MODE_NONE = 0;
    public static final String TAG = "SessionPlayer";
    public static final long UNKNOWN_TIME = Long.MIN_VALUE;
    public transient /* synthetic */ FieldHolder $fh;
    @GuardedBy("mLock")
    public final List<Pair<PlayerCallback, Executor>> mCallbacks;
    public final Object mLock;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public @interface BuffState {
    }

    /* loaded from: classes.dex */
    public static abstract class PlayerCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public PlayerCallback() {
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

        public void onAudioAttributesChanged(@NonNull SessionPlayer sessionPlayer, @Nullable AudioAttributesCompat audioAttributesCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, sessionPlayer, audioAttributesCompat) == null) {
            }
        }

        public void onBufferingStateChanged(@NonNull SessionPlayer sessionPlayer, @Nullable MediaItem mediaItem, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sessionPlayer, mediaItem, i) == null) {
            }
        }

        public void onCurrentMediaItemChanged(@NonNull SessionPlayer sessionPlayer, @NonNull MediaItem mediaItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, sessionPlayer, mediaItem) == null) {
            }
        }

        public void onPlaybackCompleted(@NonNull SessionPlayer sessionPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, sessionPlayer) == null) {
            }
        }

        public void onPlaybackSpeedChanged(@NonNull SessionPlayer sessionPlayer, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048580, this, sessionPlayer, f) == null) {
            }
        }

        public void onPlayerStateChanged(@NonNull SessionPlayer sessionPlayer, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048581, this, sessionPlayer, i) == null) {
            }
        }

        public void onPlaylistChanged(@NonNull SessionPlayer sessionPlayer, @Nullable List<MediaItem> list, @Nullable MediaMetadata mediaMetadata) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048582, this, sessionPlayer, list, mediaMetadata) == null) {
            }
        }

        public void onPlaylistMetadataChanged(@NonNull SessionPlayer sessionPlayer, @Nullable MediaMetadata mediaMetadata) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, sessionPlayer, mediaMetadata) == null) {
            }
        }

        public void onRepeatModeChanged(@NonNull SessionPlayer sessionPlayer, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, sessionPlayer, i) == null) {
            }
        }

        public void onSeekCompleted(@NonNull SessionPlayer sessionPlayer, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048585, this, sessionPlayer, j) == null) {
            }
        }

        public void onShuffleModeChanged(@NonNull SessionPlayer sessionPlayer, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048586, this, sessionPlayer, i) == null) {
            }
        }

        public void onSubtitleData(@NonNull SessionPlayer sessionPlayer, @NonNull MediaItem mediaItem, @NonNull TrackInfo trackInfo, @NonNull SubtitleData subtitleData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048587, this, sessionPlayer, mediaItem, trackInfo, subtitleData) == null) {
            }
        }

        public void onTrackDeselected(@NonNull SessionPlayer sessionPlayer, @NonNull TrackInfo trackInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048588, this, sessionPlayer, trackInfo) == null) {
            }
        }

        public void onTrackSelected(@NonNull SessionPlayer sessionPlayer, @NonNull TrackInfo trackInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048589, this, sessionPlayer, trackInfo) == null) {
            }
        }

        public void onTracksChanged(@NonNull SessionPlayer sessionPlayer, @NonNull List<TrackInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048590, this, sessionPlayer, list) == null) {
            }
        }

        public void onVideoSizeChanged(@NonNull SessionPlayer sessionPlayer, @NonNull VideoSize videoSize) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048591, this, sessionPlayer, videoSize) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class PlayerResult implements BaseResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long mCompletionTime;
        public final MediaItem mItem;
        public final int mResultCode;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        /* loaded from: classes.dex */
        public @interface ResultCode {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public PlayerResult(int i, @Nullable MediaItem mediaItem) {
            this(i, mediaItem, SystemClock.elapsedRealtime());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), mediaItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), (MediaItem) objArr2[1], ((Long) objArr2[2]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static ListenableFuture<PlayerResult> createFuture(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
                ResolvableFuture create = ResolvableFuture.create();
                create.set(new PlayerResult(i, null));
                return create;
            }
            return (ListenableFuture) invokeI.objValue;
        }

        @Override // androidx.media2.common.BaseResult
        public long getCompletionTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCompletionTime : invokeV.longValue;
        }

        @Override // androidx.media2.common.BaseResult
        @Nullable
        public MediaItem getMediaItem() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mItem : (MediaItem) invokeV.objValue;
        }

        @Override // androidx.media2.common.BaseResult
        public int getResultCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mResultCode : invokeV.intValue;
        }

        public PlayerResult(int i, @Nullable MediaItem mediaItem, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), mediaItem, Long.valueOf(j)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mResultCode = i;
            this.mItem = mediaItem;
            this.mCompletionTime = j;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public @interface PlayerState {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public @interface RepeatMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public @interface ShuffleMode {
    }

    public SessionPlayer() {
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
        this.mLock = new Object();
        this.mCallbacks = new ArrayList();
    }

    @NonNull
    public abstract ListenableFuture<PlayerResult> addPlaylistItem(int i, @NonNull MediaItem mediaItem);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    @CallSuper
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this.mLock) {
                this.mCallbacks.clear();
            }
        }
    }

    @NonNull
    public ListenableFuture<PlayerResult> deselectTrack(@NonNull TrackInfo trackInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, trackInfo)) == null) {
            throw new UnsupportedOperationException("deselectTrack is not implemented");
        }
        return (ListenableFuture) invokeL.objValue;
    }

    @Nullable
    public abstract AudioAttributesCompat getAudioAttributes();

    public abstract long getBufferedPosition();

    public abstract int getBufferingState();

    @NonNull
    public final List<Pair<PlayerCallback, Executor>> getCallbacks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList arrayList = new ArrayList();
            synchronized (this.mLock) {
                arrayList.addAll(this.mCallbacks);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Nullable
    public abstract MediaItem getCurrentMediaItem();

    @IntRange(from = -1)
    public abstract int getCurrentMediaItemIndex();

    public abstract long getCurrentPosition();

    public abstract long getDuration();

    @IntRange(from = -1)
    public abstract int getNextMediaItemIndex();

    public abstract float getPlaybackSpeed();

    public abstract int getPlayerState();

    @Nullable
    public abstract List<MediaItem> getPlaylist();

    @Nullable
    public abstract MediaMetadata getPlaylistMetadata();

    @IntRange(from = -1)
    public abstract int getPreviousMediaItemIndex();

    public abstract int getRepeatMode();

    @Nullable
    public TrackInfo getSelectedTrack(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            throw new UnsupportedOperationException("getSelectedTrack is not implemented");
        }
        return (TrackInfo) invokeI.objValue;
    }

    public abstract int getShuffleMode();

    @NonNull
    public List<TrackInfo> getTracks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            throw new UnsupportedOperationException("getTracks is not implemented");
        }
        return (List) invokeV.objValue;
    }

    @NonNull
    public VideoSize getVideoSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            throw new UnsupportedOperationException("getVideoSize is not implemented");
        }
        return (VideoSize) invokeV.objValue;
    }

    @NonNull
    public ListenableFuture<PlayerResult> movePlaylistItem(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048598, this, i, i2)) == null) {
            throw new UnsupportedOperationException("movePlaylistItem is not implemented");
        }
        return (ListenableFuture) invokeII.objValue;
    }

    @NonNull
    public abstract ListenableFuture<PlayerResult> pause();

    @NonNull
    public abstract ListenableFuture<PlayerResult> play();

    @NonNull
    public abstract ListenableFuture<PlayerResult> prepare();

    public final void registerPlayerCallback(@NonNull Executor executor, @NonNull PlayerCallback playerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, executor, playerCallback) == null) {
            if (executor == null) {
                throw new NullPointerException("executor shouldn't be null");
            }
            if (playerCallback != null) {
                synchronized (this.mLock) {
                    for (Pair<PlayerCallback, Executor> pair : this.mCallbacks) {
                        if (pair.first == playerCallback && pair.second != null) {
                            Log.w(TAG, "callback is already added. Ignoring.");
                            return;
                        }
                    }
                    this.mCallbacks.add(new Pair<>(playerCallback, executor));
                    return;
                }
            }
            throw new NullPointerException("callback shouldn't be null");
        }
    }

    @NonNull
    public abstract ListenableFuture<PlayerResult> removePlaylistItem(@IntRange(from = 0) int i);

    @NonNull
    public abstract ListenableFuture<PlayerResult> replacePlaylistItem(int i, @NonNull MediaItem mediaItem);

    @NonNull
    public abstract ListenableFuture<PlayerResult> seekTo(long j);

    @NonNull
    public ListenableFuture<PlayerResult> selectTrack(@NonNull TrackInfo trackInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, trackInfo)) == null) {
            throw new UnsupportedOperationException("selectTrack is not implemented");
        }
        return (ListenableFuture) invokeL.objValue;
    }

    @NonNull
    public abstract ListenableFuture<PlayerResult> setAudioAttributes(@NonNull AudioAttributesCompat audioAttributesCompat);

    @NonNull
    public abstract ListenableFuture<PlayerResult> setMediaItem(@NonNull MediaItem mediaItem);

    @NonNull
    public abstract ListenableFuture<PlayerResult> setPlaybackSpeed(float f);

    @NonNull
    public abstract ListenableFuture<PlayerResult> setPlaylist(@NonNull List<MediaItem> list, @Nullable MediaMetadata mediaMetadata);

    @NonNull
    public abstract ListenableFuture<PlayerResult> setRepeatMode(int i);

    @NonNull
    public abstract ListenableFuture<PlayerResult> setShuffleMode(int i);

    @NonNull
    public ListenableFuture<PlayerResult> setSurface(@Nullable Surface surface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, surface)) == null) {
            throw new UnsupportedOperationException("setSurface is not implemented");
        }
        return (ListenableFuture) invokeL.objValue;
    }

    @NonNull
    public abstract ListenableFuture<PlayerResult> skipToNextPlaylistItem();

    @NonNull
    public abstract ListenableFuture<PlayerResult> skipToPlaylistItem(@IntRange(from = 0) int i);

    @NonNull
    public abstract ListenableFuture<PlayerResult> skipToPreviousPlaylistItem();

    public final void unregisterPlayerCallback(@NonNull PlayerCallback playerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, playerCallback) == null) {
            if (playerCallback != null) {
                synchronized (this.mLock) {
                    for (int size = this.mCallbacks.size() - 1; size >= 0; size--) {
                        if (this.mCallbacks.get(size).first == playerCallback) {
                            this.mCallbacks.remove(size);
                        }
                    }
                }
                return;
            }
            throw new NullPointerException("callback shouldn't be null");
        }
    }

    @NonNull
    public abstract ListenableFuture<PlayerResult> updatePlaylistMetadata(@Nullable MediaMetadata mediaMetadata);

    /* loaded from: classes.dex */
    public static class TrackInfo extends CustomVersionedParcelable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String KEY_IS_SELECTABLE = "isSelectable";
        public static final int MEDIA_TRACK_TYPE_AUDIO = 2;
        public static final int MEDIA_TRACK_TYPE_METADATA = 5;
        public static final int MEDIA_TRACK_TYPE_SUBTITLE = 4;
        public static final int MEDIA_TRACK_TYPE_UNKNOWN = 0;
        public static final int MEDIA_TRACK_TYPE_VIDEO = 1;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public MediaFormat mFormat;
        public int mId;
        public boolean mIsSelectable;
        public final Object mLock;
        public Bundle mParcelableExtras;
        public int mTrackType;
        @Deprecated
        public MediaItem mUpCastMediaItem;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        /* loaded from: classes.dex */
        public @interface MediaTrackType {
        }

        public TrackInfo() {
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
            this.mLock = new Object();
        }

        public static void putIntValueToBundle(String str, MediaFormat mediaFormat, Bundle bundle) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(65539, null, str, mediaFormat, bundle) == null) && mediaFormat.containsKey(str)) {
                bundle.putInt(str, mediaFormat.getInteger(str));
            }
        }

        public static void putStringValueToBundle(String str, MediaFormat mediaFormat, Bundle bundle) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, mediaFormat, bundle) == null) && mediaFormat.containsKey(str)) {
                bundle.putString(str, mediaFormat.getString(str));
            }
        }

        public static void setIntValueToMediaFormat(String str, MediaFormat mediaFormat, Bundle bundle) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(65541, null, str, mediaFormat, bundle) == null) && bundle.containsKey(str)) {
                mediaFormat.setInteger(str, bundle.getInt(str));
            }
        }

        public static void setStringValueToMediaFormat(String str, MediaFormat mediaFormat, Bundle bundle) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(65542, null, str, mediaFormat, bundle) == null) && bundle.containsKey(str)) {
                mediaFormat.setString(str, bundle.getString(str));
            }
        }

        public boolean equals(@Nullable Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof TrackInfo) && this.mId == ((TrackInfo) obj).mId;
            }
            return invokeL.booleanValue;
        }

        @Nullable
        public MediaFormat getFormat() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mFormat : (MediaFormat) invokeV.objValue;
        }

        public int getId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mId : invokeV.intValue;
        }

        @NonNull
        public Locale getLanguage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                MediaFormat mediaFormat = this.mFormat;
                String string = mediaFormat != null ? mediaFormat.getString("language") : null;
                if (string == null) {
                    string = MetadataUtil.LANGUAGE_UNDEFINED;
                }
                return new Locale(string);
            }
            return (Locale) invokeV.objValue;
        }

        public int getTrackType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mTrackType : invokeV.intValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mId : invokeV.intValue;
        }

        public boolean isSelectable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mIsSelectable : invokeV.booleanValue;
        }

        @Override // androidx.versionedparcelable.CustomVersionedParcelable
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void onPostParceling() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.mParcelableExtras == null) {
                return;
            }
            MediaFormat mediaFormat = new MediaFormat();
            this.mFormat = mediaFormat;
            setStringValueToMediaFormat("language", mediaFormat, this.mParcelableExtras);
            setStringValueToMediaFormat("mime", this.mFormat, this.mParcelableExtras);
            setIntValueToMediaFormat("is-forced-subtitle", this.mFormat, this.mParcelableExtras);
            setIntValueToMediaFormat("is-autoselect", this.mFormat, this.mParcelableExtras);
            setIntValueToMediaFormat("is-default", this.mFormat, this.mParcelableExtras);
            if (this.mParcelableExtras.containsKey(KEY_IS_SELECTABLE)) {
                this.mIsSelectable = this.mParcelableExtras.getBoolean(KEY_IS_SELECTABLE);
            } else {
                this.mIsSelectable = this.mTrackType != 1;
            }
        }

        @Override // androidx.versionedparcelable.CustomVersionedParcelable
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void onPreParceling(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
                synchronized (this.mLock) {
                    Bundle bundle = new Bundle();
                    this.mParcelableExtras = bundle;
                    bundle.putBoolean(KEY_IS_SELECTABLE, this.mIsSelectable);
                    if (this.mFormat != null) {
                        putStringValueToBundle("language", this.mFormat, this.mParcelableExtras);
                        putStringValueToBundle("mime", this.mFormat, this.mParcelableExtras);
                        putIntValueToBundle("is-forced-subtitle", this.mFormat, this.mParcelableExtras);
                        putIntValueToBundle("is-autoselect", this.mFormat, this.mParcelableExtras);
                        putIntValueToBundle("is-default", this.mFormat, this.mParcelableExtras);
                    }
                }
            }
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                StringBuilder sb = new StringBuilder(128);
                sb.append(TrackInfo.class.getName());
                sb.append('#');
                sb.append(this.mId);
                sb.append('{');
                int i = this.mTrackType;
                if (i == 1) {
                    sb.append(HlsPlaylistParser.TYPE_VIDEO);
                } else if (i == 2) {
                    sb.append(HlsPlaylistParser.TYPE_AUDIO);
                } else if (i == 4) {
                    sb.append("SUBTITLE");
                } else if (i != 5) {
                    sb.append(RomUtils.UNKNOWN);
                } else {
                    sb.append("METADATA");
                }
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(this.mFormat);
                sb.append("}");
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public TrackInfo(int i, int i2, @Nullable MediaFormat mediaFormat) {
            this(i, i2, mediaFormat, false);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), mediaFormat};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), (MediaFormat) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public TrackInfo(int i, int i2, @Nullable MediaFormat mediaFormat, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), mediaFormat, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.mLock = new Object();
            this.mId = i;
            this.mTrackType = i2;
            this.mFormat = mediaFormat;
            this.mIsSelectable = z;
        }
    }
}
