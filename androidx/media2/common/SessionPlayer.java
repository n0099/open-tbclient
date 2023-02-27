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
import androidx.media.AudioAttributesCompat;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.baidu.android.common.others.lang.StringUtil;
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
    public final Object mLock = new Object();
    @GuardedBy("mLock")
    public final List<Pair<PlayerCallback, Executor>> mCallbacks = new ArrayList();

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public @interface BuffState {
    }

    /* loaded from: classes.dex */
    public static abstract class PlayerCallback {
        public void onAudioAttributesChanged(@NonNull SessionPlayer sessionPlayer, @Nullable AudioAttributesCompat audioAttributesCompat) {
        }

        public void onBufferingStateChanged(@NonNull SessionPlayer sessionPlayer, @Nullable MediaItem mediaItem, int i) {
        }

        public void onCurrentMediaItemChanged(@NonNull SessionPlayer sessionPlayer, @NonNull MediaItem mediaItem) {
        }

        public void onPlaybackCompleted(@NonNull SessionPlayer sessionPlayer) {
        }

        public void onPlaybackSpeedChanged(@NonNull SessionPlayer sessionPlayer, float f) {
        }

        public void onPlayerStateChanged(@NonNull SessionPlayer sessionPlayer, int i) {
        }

        public void onPlaylistChanged(@NonNull SessionPlayer sessionPlayer, @Nullable List<MediaItem> list, @Nullable MediaMetadata mediaMetadata) {
        }

        public void onPlaylistMetadataChanged(@NonNull SessionPlayer sessionPlayer, @Nullable MediaMetadata mediaMetadata) {
        }

        public void onRepeatModeChanged(@NonNull SessionPlayer sessionPlayer, int i) {
        }

        public void onSeekCompleted(@NonNull SessionPlayer sessionPlayer, long j) {
        }

        public void onShuffleModeChanged(@NonNull SessionPlayer sessionPlayer, int i) {
        }

        public void onSubtitleData(@NonNull SessionPlayer sessionPlayer, @NonNull MediaItem mediaItem, @NonNull TrackInfo trackInfo, @NonNull SubtitleData subtitleData) {
        }

        public void onTrackDeselected(@NonNull SessionPlayer sessionPlayer, @NonNull TrackInfo trackInfo) {
        }

        public void onTrackSelected(@NonNull SessionPlayer sessionPlayer, @NonNull TrackInfo trackInfo) {
        }

        public void onTracksChanged(@NonNull SessionPlayer sessionPlayer, @NonNull List<TrackInfo> list) {
        }

        public void onVideoSizeChanged(@NonNull SessionPlayer sessionPlayer, @NonNull VideoSize videoSize) {
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

    @NonNull
    public abstract ListenableFuture<PlayerResult> addPlaylistItem(int i, @NonNull MediaItem mediaItem);

    @Nullable
    public abstract AudioAttributesCompat getAudioAttributes();

    public abstract long getBufferedPosition();

    public abstract int getBufferingState();

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

    public abstract int getShuffleMode();

    @NonNull
    public abstract ListenableFuture<PlayerResult> pause();

    @NonNull
    public abstract ListenableFuture<PlayerResult> play();

    @NonNull
    public abstract ListenableFuture<PlayerResult> prepare();

    @NonNull
    public abstract ListenableFuture<PlayerResult> removePlaylistItem(@IntRange(from = 0) int i);

    @NonNull
    public abstract ListenableFuture<PlayerResult> replacePlaylistItem(int i, @NonNull MediaItem mediaItem);

    @NonNull
    public abstract ListenableFuture<PlayerResult> seekTo(long j);

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
    public abstract ListenableFuture<PlayerResult> skipToNextPlaylistItem();

    @NonNull
    public abstract ListenableFuture<PlayerResult> skipToPlaylistItem(@IntRange(from = 0) int i);

    @NonNull
    public abstract ListenableFuture<PlayerResult> skipToPreviousPlaylistItem();

    @NonNull
    public abstract ListenableFuture<PlayerResult> updatePlaylistMetadata(@Nullable MediaMetadata mediaMetadata);

    /* loaded from: classes.dex */
    public static class PlayerResult implements BaseResult {
        public final long mCompletionTime;
        public final MediaItem mItem;
        public final int mResultCode;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        /* loaded from: classes.dex */
        public @interface ResultCode {
        }

        public PlayerResult(int i, @Nullable MediaItem mediaItem) {
            this(i, mediaItem, SystemClock.elapsedRealtime());
        }

        public PlayerResult(int i, @Nullable MediaItem mediaItem, long j) {
            this.mResultCode = i;
            this.mItem = mediaItem;
            this.mCompletionTime = j;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static ListenableFuture<PlayerResult> createFuture(int i) {
            ResolvableFuture create = ResolvableFuture.create();
            create.set(new PlayerResult(i, null));
            return create;
        }

        @Override // androidx.media2.common.BaseResult
        public long getCompletionTime() {
            return this.mCompletionTime;
        }

        @Override // androidx.media2.common.BaseResult
        @Nullable
        public MediaItem getMediaItem() {
            return this.mItem;
        }

        @Override // androidx.media2.common.BaseResult
        public int getResultCode() {
            return this.mResultCode;
        }
    }

    /* loaded from: classes.dex */
    public static class TrackInfo extends CustomVersionedParcelable {
        public static final String KEY_IS_SELECTABLE = "isSelectable";
        public static final int MEDIA_TRACK_TYPE_AUDIO = 2;
        public static final int MEDIA_TRACK_TYPE_METADATA = 5;
        public static final int MEDIA_TRACK_TYPE_SUBTITLE = 4;
        public static final int MEDIA_TRACK_TYPE_UNKNOWN = 0;
        public static final int MEDIA_TRACK_TYPE_VIDEO = 1;
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
            this.mLock = new Object();
        }

        @Nullable
        public MediaFormat getFormat() {
            return this.mFormat;
        }

        public int getId() {
            return this.mId;
        }

        @NonNull
        public Locale getLanguage() {
            String str;
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

        public int getTrackType() {
            return this.mTrackType;
        }

        public int hashCode() {
            return this.mId;
        }

        public boolean isSelectable() {
            return this.mIsSelectable;
        }

        public TrackInfo(int i, int i2, @Nullable MediaFormat mediaFormat) {
            this(i, i2, mediaFormat, false);
        }

        public static void putIntValueToBundle(String str, MediaFormat mediaFormat, Bundle bundle) {
            if (mediaFormat.containsKey(str)) {
                bundle.putInt(str, mediaFormat.getInteger(str));
            }
        }

        public static void putStringValueToBundle(String str, MediaFormat mediaFormat, Bundle bundle) {
            if (mediaFormat.containsKey(str)) {
                bundle.putString(str, mediaFormat.getString(str));
            }
        }

        public static void setIntValueToMediaFormat(String str, MediaFormat mediaFormat, Bundle bundle) {
            if (bundle.containsKey(str)) {
                mediaFormat.setInteger(str, bundle.getInt(str));
            }
        }

        public static void setStringValueToMediaFormat(String str, MediaFormat mediaFormat, Bundle bundle) {
            if (bundle.containsKey(str)) {
                mediaFormat.setString(str, bundle.getString(str));
            }
        }

        public TrackInfo(int i, int i2, @Nullable MediaFormat mediaFormat, boolean z) {
            this.mLock = new Object();
            this.mId = i;
            this.mTrackType = i2;
            this.mFormat = mediaFormat;
            this.mIsSelectable = z;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof TrackInfo) && this.mId == ((TrackInfo) obj).mId) {
                return true;
            }
            return false;
        }

        @Override // androidx.versionedparcelable.CustomVersionedParcelable
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void onPostParceling() {
            if (this.mParcelableExtras != null) {
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

        @NonNull
        public String toString() {
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
                            sb.append("UNKNOWN");
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

        @Override // androidx.versionedparcelable.CustomVersionedParcelable
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void onPreParceling(boolean z) {
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

    @Override // java.io.Closeable, java.lang.AutoCloseable
    @CallSuper
    public void close() {
        synchronized (this.mLock) {
            this.mCallbacks.clear();
        }
    }

    @NonNull
    public final List<Pair<PlayerCallback, Executor>> getCallbacks() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            arrayList.addAll(this.mCallbacks);
        }
        return arrayList;
    }

    @NonNull
    public List<TrackInfo> getTracks() {
        throw new UnsupportedOperationException("getTracks is not implemented");
    }

    @NonNull
    public VideoSize getVideoSize() {
        throw new UnsupportedOperationException("getVideoSize is not implemented");
    }

    @NonNull
    public ListenableFuture<PlayerResult> deselectTrack(@NonNull TrackInfo trackInfo) {
        throw new UnsupportedOperationException("deselectTrack is not implemented");
    }

    @Nullable
    public TrackInfo getSelectedTrack(int i) {
        throw new UnsupportedOperationException("getSelectedTrack is not implemented");
    }

    @NonNull
    public ListenableFuture<PlayerResult> selectTrack(@NonNull TrackInfo trackInfo) {
        throw new UnsupportedOperationException("selectTrack is not implemented");
    }

    @NonNull
    public ListenableFuture<PlayerResult> setSurface(@Nullable Surface surface) {
        throw new UnsupportedOperationException("setSurface is not implemented");
    }

    public final void unregisterPlayerCallback(@NonNull PlayerCallback playerCallback) {
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

    @NonNull
    public ListenableFuture<PlayerResult> movePlaylistItem(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        throw new UnsupportedOperationException("movePlaylistItem is not implemented");
    }

    public final void registerPlayerCallback(@NonNull Executor executor, @NonNull PlayerCallback playerCallback) {
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
