package androidx.media2.common;

import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
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
    public final List<Pair<PlayerCallback, Executor>> mCallbacks;
    public final Object mLock;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface BuffState {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface PlayerState {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface RepeatMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ShuffleMode {
    }

    public abstract ListenableFuture<PlayerResult> addPlaylistItem(int i, MediaItem mediaItem);

    public abstract AudioAttributesCompat getAudioAttributes();

    public abstract long getBufferedPosition();

    public abstract int getBufferingState();

    public abstract MediaItem getCurrentMediaItem();

    public abstract int getCurrentMediaItemIndex();

    public abstract long getCurrentPosition();

    public abstract long getDuration();

    public abstract int getNextMediaItemIndex();

    public abstract float getPlaybackSpeed();

    public abstract int getPlayerState();

    public abstract List<MediaItem> getPlaylist();

    public abstract MediaMetadata getPlaylistMetadata();

    public abstract int getPreviousMediaItemIndex();

    public abstract int getRepeatMode();

    public abstract int getShuffleMode();

    public abstract ListenableFuture<PlayerResult> pause();

    public abstract ListenableFuture<PlayerResult> play();

    public abstract ListenableFuture<PlayerResult> prepare();

    public abstract ListenableFuture<PlayerResult> removePlaylistItem(int i);

    public abstract ListenableFuture<PlayerResult> replacePlaylistItem(int i, MediaItem mediaItem);

    public abstract ListenableFuture<PlayerResult> seekTo(long j);

    public abstract ListenableFuture<PlayerResult> setAudioAttributes(AudioAttributesCompat audioAttributesCompat);

    public abstract ListenableFuture<PlayerResult> setMediaItem(MediaItem mediaItem);

    public abstract ListenableFuture<PlayerResult> setPlaybackSpeed(float f);

    public abstract ListenableFuture<PlayerResult> setPlaylist(List<MediaItem> list, MediaMetadata mediaMetadata);

    public abstract ListenableFuture<PlayerResult> setRepeatMode(int i);

    public abstract ListenableFuture<PlayerResult> setShuffleMode(int i);

    public abstract ListenableFuture<PlayerResult> skipToNextPlaylistItem();

    public abstract ListenableFuture<PlayerResult> skipToPlaylistItem(int i);

    public abstract ListenableFuture<PlayerResult> skipToPreviousPlaylistItem();

    public abstract ListenableFuture<PlayerResult> updatePlaylistMetadata(MediaMetadata mediaMetadata);

    /* loaded from: classes.dex */
    public static abstract class PlayerCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public void onAudioAttributesChanged(SessionPlayer sessionPlayer, AudioAttributesCompat audioAttributesCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, sessionPlayer, audioAttributesCompat) == null) {
            }
        }

        public void onBufferingStateChanged(SessionPlayer sessionPlayer, MediaItem mediaItem, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sessionPlayer, mediaItem, i) == null) {
            }
        }

        public void onCurrentMediaItemChanged(SessionPlayer sessionPlayer, MediaItem mediaItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, sessionPlayer, mediaItem) == null) {
            }
        }

        public void onPlaybackCompleted(SessionPlayer sessionPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, sessionPlayer) == null) {
            }
        }

        public void onPlaybackSpeedChanged(SessionPlayer sessionPlayer, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048580, this, sessionPlayer, f) == null) {
            }
        }

        public void onPlayerStateChanged(SessionPlayer sessionPlayer, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048581, this, sessionPlayer, i) == null) {
            }
        }

        public void onPlaylistChanged(SessionPlayer sessionPlayer, List<MediaItem> list, MediaMetadata mediaMetadata) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048582, this, sessionPlayer, list, mediaMetadata) == null) {
            }
        }

        public void onPlaylistMetadataChanged(SessionPlayer sessionPlayer, MediaMetadata mediaMetadata) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, sessionPlayer, mediaMetadata) == null) {
            }
        }

        public void onRepeatModeChanged(SessionPlayer sessionPlayer, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, sessionPlayer, i) == null) {
            }
        }

        public void onSeekCompleted(SessionPlayer sessionPlayer, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048585, this, sessionPlayer, j) == null) {
            }
        }

        public void onShuffleModeChanged(SessionPlayer sessionPlayer, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048586, this, sessionPlayer, i) == null) {
            }
        }

        public void onSubtitleData(SessionPlayer sessionPlayer, MediaItem mediaItem, TrackInfo trackInfo, SubtitleData subtitleData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048587, this, sessionPlayer, mediaItem, trackInfo, subtitleData) == null) {
            }
        }

        public void onTrackDeselected(SessionPlayer sessionPlayer, TrackInfo trackInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048588, this, sessionPlayer, trackInfo) == null) {
            }
        }

        public void onTrackSelected(SessionPlayer sessionPlayer, TrackInfo trackInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048589, this, sessionPlayer, trackInfo) == null) {
            }
        }

        public void onTracksChanged(SessionPlayer sessionPlayer, List<TrackInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048590, this, sessionPlayer, list) == null) {
            }
        }

        public void onVideoSizeChanged(SessionPlayer sessionPlayer, VideoSize videoSize) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048591, this, sessionPlayer, videoSize) == null) {
            }
        }

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
    }

    /* loaded from: classes.dex */
    public static class PlayerResult implements BaseResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long mCompletionTime;
        public final MediaItem mItem;
        public final int mResultCode;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface ResultCode {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public PlayerResult(int i, MediaItem mediaItem) {
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

        public PlayerResult(int i, MediaItem mediaItem, long j) {
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mCompletionTime;
            }
            return invokeV.longValue;
        }

        @Override // androidx.media2.common.BaseResult
        public MediaItem getMediaItem() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mItem;
            }
            return (MediaItem) invokeV.objValue;
        }

        @Override // androidx.media2.common.BaseResult
        public int getResultCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mResultCode;
            }
            return invokeV.intValue;
        }
    }

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
        public MediaFormat mFormat;
        public int mId;
        public boolean mIsSelectable;
        public final Object mLock;
        public Bundle mParcelableExtras;
        public int mTrackType;
        @Deprecated
        public MediaItem mUpCastMediaItem;

        @Retention(RetentionPolicy.SOURCE)
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

        public MediaFormat getFormat() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mFormat;
            }
            return (MediaFormat) invokeV.objValue;
        }

        public int getId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mId;
            }
            return invokeV.intValue;
        }

        public Locale getLanguage() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                MediaFormat mediaFormat = this.mFormat;
                if (mediaFormat != null) {
                    str = mediaFormat.getString("language");
                } else {
                    str = null;
                }
                if (str == null) {
                    str = MetadataUtil.LANGUAGE_UNDEFINED;
                }
                return new Locale(str);
            }
            return (Locale) invokeV.objValue;
        }

        public int getTrackType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.mTrackType;
            }
            return invokeV.intValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.mId;
            }
            return invokeV.intValue;
        }

        public boolean isSelectable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.mIsSelectable;
            }
            return invokeV.booleanValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public TrackInfo(int i, int i2, MediaFormat mediaFormat) {
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

        public TrackInfo(int i, int i2, MediaFormat mediaFormat, boolean z) {
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

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof TrackInfo) && this.mId == ((TrackInfo) obj).mId) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // androidx.versionedparcelable.CustomVersionedParcelable
        public void onPostParceling() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.mParcelableExtras != null) {
                MediaFormat mediaFormat = new MediaFormat();
                this.mFormat = mediaFormat;
                setStringValueToMediaFormat("language", mediaFormat, this.mParcelableExtras);
                setStringValueToMediaFormat("mime", this.mFormat, this.mParcelableExtras);
                setIntValueToMediaFormat("is-forced-subtitle", this.mFormat, this.mParcelableExtras);
                setIntValueToMediaFormat("is-autoselect", this.mFormat, this.mParcelableExtras);
                setIntValueToMediaFormat("is-default", this.mFormat, this.mParcelableExtras);
                if (this.mParcelableExtras.containsKey(KEY_IS_SELECTABLE)) {
                    this.mIsSelectable = this.mParcelableExtras.getBoolean(KEY_IS_SELECTABLE);
                    return;
                }
                boolean z = true;
                if (this.mTrackType == 1) {
                    z = false;
                }
                this.mIsSelectable = z;
            }
        }

        @Override // androidx.versionedparcelable.CustomVersionedParcelable
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
                if (i != 1) {
                    if (i != 2) {
                        if (i != 4) {
                            if (i != 5) {
                                sb.append(RomUtils.UNKNOWN);
                            } else {
                                sb.append("METADATA");
                            }
                        } else {
                            sb.append("SUBTITLE");
                        }
                    } else {
                        sb.append(HlsPlaylistParser.TYPE_AUDIO);
                    }
                } else {
                    sb.append(HlsPlaylistParser.TYPE_VIDEO);
                }
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(this.mFormat);
                sb.append("}");
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
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

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this.mLock) {
                this.mCallbacks.clear();
            }
        }
    }

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

    public List<TrackInfo> getTracks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            throw new UnsupportedOperationException("getTracks is not implemented");
        }
        return (List) invokeV.objValue;
    }

    public VideoSize getVideoSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            throw new UnsupportedOperationException("getVideoSize is not implemented");
        }
        return (VideoSize) invokeV.objValue;
    }

    public ListenableFuture<PlayerResult> deselectTrack(TrackInfo trackInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, trackInfo)) == null) {
            throw new UnsupportedOperationException("deselectTrack is not implemented");
        }
        return (ListenableFuture) invokeL.objValue;
    }

    public TrackInfo getSelectedTrack(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            throw new UnsupportedOperationException("getSelectedTrack is not implemented");
        }
        return (TrackInfo) invokeI.objValue;
    }

    public ListenableFuture<PlayerResult> selectTrack(TrackInfo trackInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, trackInfo)) == null) {
            throw new UnsupportedOperationException("selectTrack is not implemented");
        }
        return (ListenableFuture) invokeL.objValue;
    }

    public ListenableFuture<PlayerResult> setSurface(Surface surface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, surface)) == null) {
            throw new UnsupportedOperationException("setSurface is not implemented");
        }
        return (ListenableFuture) invokeL.objValue;
    }

    public ListenableFuture<PlayerResult> movePlaylistItem(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048598, this, i, i2)) == null) {
            throw new UnsupportedOperationException("movePlaylistItem is not implemented");
        }
        return (ListenableFuture) invokeII.objValue;
    }

    public final void registerPlayerCallback(Executor executor, PlayerCallback playerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, executor, playerCallback) == null) {
            if (executor != null) {
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
            throw new NullPointerException("executor shouldn't be null");
        }
    }

    public final void unregisterPlayerCallback(PlayerCallback playerCallback) {
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
}
