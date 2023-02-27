package androidx.media2.common;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class MediaItem extends CustomVersionedParcelable {
    public static final long LONG_MAX = 576460752303423487L;
    public static final long POSITION_UNKNOWN = 576460752303423487L;
    public static final String TAG = "MediaItem";
    public long mEndPositionMs;
    @GuardedBy("mLock")
    public final List<Pair<OnMetadataChangedListener, Executor>> mListeners;
    public final Object mLock;
    @GuardedBy("mLock")
    public MediaMetadata mMetadata;
    public long mStartPositionMs;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public interface OnMetadataChangedListener {
        void onMetadataChanged(@NonNull MediaItem mediaItem, @Nullable MediaMetadata mediaMetadata);
    }

    /* loaded from: classes.dex */
    public static class Builder {
        public MediaMetadata mMetadata;
        public long mStartPositionMs = 0;
        public long mEndPositionMs = 576460752303423487L;

        @NonNull
        public MediaItem build() {
            return new MediaItem(this);
        }

        @NonNull
        public Builder setEndPosition(long j) {
            if (j < 0) {
                j = 576460752303423487L;
            }
            this.mEndPositionMs = j;
            return this;
        }

        @NonNull
        public Builder setMetadata(@Nullable MediaMetadata mediaMetadata) {
            this.mMetadata = mediaMetadata;
            return this;
        }

        @NonNull
        public Builder setStartPosition(long j) {
            if (j < 0) {
                j = 0;
            }
            this.mStartPositionMs = j;
            return this;
        }
    }

    public MediaItem() {
        this.mLock = new Object();
        this.mStartPositionMs = 0L;
        this.mEndPositionMs = 576460752303423487L;
        this.mListeners = new ArrayList();
    }

    public long getEndPosition() {
        return this.mEndPositionMs;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getMediaId() {
        String str;
        synchronized (this.mLock) {
            if (this.mMetadata != null) {
                str = this.mMetadata.getString("android.media.metadata.MEDIA_ID");
            } else {
                str = null;
            }
        }
        return str;
    }

    @Nullable
    public MediaMetadata getMetadata() {
        MediaMetadata mediaMetadata;
        synchronized (this.mLock) {
            mediaMetadata = this.mMetadata;
        }
        return mediaMetadata;
    }

    public long getStartPosition() {
        return this.mStartPositionMs;
    }

    public MediaItem(Builder builder) {
        this(builder.mMetadata, builder.mStartPositionMs, builder.mEndPositionMs);
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onPreParceling(boolean z) {
        if (getClass() == MediaItem.class) {
            super.onPreParceling(z);
            return;
        }
        throw new RuntimeException("MediaItem's subclasses shouldn't be parcelized.");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void removeOnMetadataChangedListener(OnMetadataChangedListener onMetadataChangedListener) {
        synchronized (this.mLock) {
            for (int size = this.mListeners.size() - 1; size >= 0; size--) {
                if (this.mListeners.get(size).first == onMetadataChangedListener) {
                    this.mListeners.remove(size);
                    return;
                }
            }
        }
    }

    public MediaItem(MediaItem mediaItem) {
        this(mediaItem.mMetadata, mediaItem.mStartPositionMs, mediaItem.mEndPositionMs);
    }

    public MediaItem(@Nullable MediaMetadata mediaMetadata, long j, long j2) {
        this.mLock = new Object();
        this.mStartPositionMs = 0L;
        this.mEndPositionMs = 576460752303423487L;
        this.mListeners = new ArrayList();
        if (j <= j2) {
            if (mediaMetadata != null && mediaMetadata.containsKey("android.media.metadata.DURATION")) {
                long j3 = mediaMetadata.getLong("android.media.metadata.DURATION");
                if (j3 != Long.MIN_VALUE && j2 != 576460752303423487L && j2 > j3) {
                    throw new IllegalStateException("endPositionMs shouldn't be greater than duration in the metdata, endPositionMs=" + j2 + ", durationMs=" + j3);
                }
            }
            this.mMetadata = mediaMetadata;
            this.mStartPositionMs = j;
            this.mEndPositionMs = j2;
            return;
        }
        throw new IllegalStateException("Illegal start/end position: " + j + ZeusCrashHandler.NAME_SEPERATOR + j2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void addOnMetadataChangedListener(Executor executor, OnMetadataChangedListener onMetadataChangedListener) {
        synchronized (this.mLock) {
            for (Pair<OnMetadataChangedListener, Executor> pair : this.mListeners) {
                if (pair.first == onMetadataChangedListener) {
                    return;
                }
            }
            this.mListeners.add(new Pair<>(onMetadataChangedListener, executor));
        }
    }

    public void setMetadata(@Nullable final MediaMetadata mediaMetadata) {
        ArrayList<Pair> arrayList = new ArrayList();
        synchronized (this.mLock) {
            if (this.mMetadata == mediaMetadata) {
                return;
            }
            if (this.mMetadata != null && mediaMetadata != null && !TextUtils.equals(getMediaId(), mediaMetadata.getMediaId())) {
                Log.w(TAG, "MediaItem's media ID shouldn't be changed");
                return;
            }
            this.mMetadata = mediaMetadata;
            arrayList.addAll(this.mListeners);
            for (Pair pair : arrayList) {
                final OnMetadataChangedListener onMetadataChangedListener = (OnMetadataChangedListener) pair.first;
                ((Executor) pair.second).execute(new Runnable() { // from class: androidx.media2.common.MediaItem.1
                    @Override // java.lang.Runnable
                    public void run() {
                        onMetadataChangedListener.onMetadataChanged(MediaItem.this, mediaMetadata);
                    }
                });
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        synchronized (this.mLock) {
            sb.append("{Media Id=");
            sb.append(getMediaId());
            sb.append(", mMetadata=");
            sb.append(this.mMetadata);
            sb.append(", mStartPositionMs=");
            sb.append(this.mStartPositionMs);
            sb.append(", mEndPositionMs=");
            sb.append(this.mEndPositionMs);
            sb.append('}');
        }
        return sb.toString();
    }
}
