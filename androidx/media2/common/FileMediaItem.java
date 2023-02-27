package androidx.media2.common;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.media2.common.MediaItem;
import java.io.IOException;
/* loaded from: classes.dex */
public class FileMediaItem extends MediaItem {
    public static final long FD_LENGTH_UNKNOWN = 576460752303423487L;
    public static final String TAG = "FileMediaItem";
    @GuardedBy("mLock")
    public boolean mClosed;
    public final long mFDLength;
    public final long mFDOffset;
    public final Object mLock;
    public final ParcelFileDescriptor mPFD;
    @GuardedBy("mLock")
    public int mRefCount;

    /* loaded from: classes.dex */
    public static final class Builder extends MediaItem.Builder {
        public long mFDLength;
        public long mFDOffset;
        public ParcelFileDescriptor mPFD;

        public Builder(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
            this.mFDOffset = 0L;
            this.mFDLength = 576460752303423487L;
            Preconditions.checkNotNull(parcelFileDescriptor);
            this.mPFD = parcelFileDescriptor;
            this.mFDOffset = 0L;
            this.mFDLength = 576460752303423487L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.media2.common.MediaItem.Builder
        @NonNull
        public Builder setEndPosition(long j) {
            return (Builder) super.setEndPosition(j);
        }

        @NonNull
        public Builder setFileDescriptorLength(long j) {
            if (j < 0) {
                j = 576460752303423487L;
            }
            this.mFDLength = j;
            return this;
        }

        @NonNull
        public Builder setFileDescriptorOffset(long j) {
            if (j < 0) {
                j = 0;
            }
            this.mFDOffset = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.media2.common.MediaItem.Builder
        @NonNull
        public Builder setMetadata(@Nullable MediaMetadata mediaMetadata) {
            return (Builder) super.setMetadata(mediaMetadata);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.media2.common.MediaItem.Builder
        @NonNull
        public Builder setStartPosition(long j) {
            return (Builder) super.setStartPosition(j);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.media2.common.MediaItem.Builder
        @NonNull
        public FileMediaItem build() {
            return new FileMediaItem(this);
        }
    }

    public FileMediaItem(Builder builder) {
        super(builder);
        this.mLock = new Object();
        this.mPFD = builder.mPFD;
        this.mFDOffset = builder.mFDOffset;
        this.mFDLength = builder.mFDLength;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void close() throws IOException {
        synchronized (this.mLock) {
            if (this.mPFD != null) {
                this.mPFD.close();
            }
            this.mClosed = true;
        }
    }

    public long getFileDescriptorLength() {
        return this.mFDLength;
    }

    public long getFileDescriptorOffset() {
        return this.mFDOffset;
    }

    @NonNull
    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.mPFD;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void increaseRefCount() {
        synchronized (this.mLock) {
            if (this.mClosed) {
                Log.w(TAG, "ParcelFileDescriptorClient is already closed.");
            } else {
                this.mRefCount++;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isClosed() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mClosed;
        }
        return z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void decreaseRefCount() {
        synchronized (this.mLock) {
            if (this.mClosed) {
                Log.w(TAG, "ParcelFileDescriptorClient is already closed.");
                return;
            }
            int i = this.mRefCount - 1;
            this.mRefCount = i;
            if (i <= 0) {
                try {
                    if (this.mPFD != null) {
                        this.mPFD.close();
                    }
                } catch (IOException e) {
                    Log.e(TAG, "Failed to close the ParcelFileDescriptor " + this.mPFD, e);
                }
                this.mClosed = true;
            }
        }
    }
}
