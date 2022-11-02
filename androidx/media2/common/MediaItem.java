package androidx.media2.common;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class MediaItem extends CustomVersionedParcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long LONG_MAX = 576460752303423487L;
    public static final long POSITION_UNKNOWN = 576460752303423487L;
    public static final String TAG = "MediaItem";
    public transient /* synthetic */ FieldHolder $fh;
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
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long mEndPositionMs;
        public MediaMetadata mMetadata;
        public long mStartPositionMs;

        public Builder() {
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
            this.mStartPositionMs = 0L;
            this.mEndPositionMs = 576460752303423487L;
        }

        @NonNull
        public MediaItem build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new MediaItem(this);
            }
            return (MediaItem) invokeV.objValue;
        }

        @NonNull
        public Builder setEndPosition(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                if (j < 0) {
                    j = 576460752303423487L;
                }
                this.mEndPositionMs = j;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        @NonNull
        public Builder setMetadata(@Nullable MediaMetadata mediaMetadata) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mediaMetadata)) == null) {
                this.mMetadata = mediaMetadata;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setStartPosition(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
                if (j < 0) {
                    j = 0;
                }
                this.mStartPositionMs = j;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }
    }

    public MediaItem() {
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
        this.mStartPositionMs = 0L;
        this.mEndPositionMs = 576460752303423487L;
        this.mListeners = new ArrayList();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MediaItem(Builder builder) {
        this(builder.mMetadata, builder.mStartPositionMs, builder.mEndPositionMs);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r8;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((MediaMetadata) objArr2[0], ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MediaItem(MediaItem mediaItem) {
        this(mediaItem.mMetadata, mediaItem.mStartPositionMs, mediaItem.mEndPositionMs);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r8;
            Object[] objArr = {mediaItem};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((MediaMetadata) objArr2[0], ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public MediaItem(@Nullable MediaMetadata mediaMetadata, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaMetadata, Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, executor, onMetadataChangedListener) == null) {
            synchronized (this.mLock) {
                for (Pair<OnMetadataChangedListener, Executor> pair : this.mListeners) {
                    if (pair.first == onMetadataChangedListener) {
                        return;
                    }
                }
                this.mListeners.add(new Pair<>(onMetadataChangedListener, executor));
            }
        }
    }

    public long getEndPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mEndPositionMs;
        }
        return invokeV.longValue;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getMediaId() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this.mLock) {
                if (this.mMetadata != null) {
                    str = this.mMetadata.getString("android.media.metadata.MEDIA_ID");
                } else {
                    str = null;
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public MediaMetadata getMetadata() {
        InterceptResult invokeV;
        MediaMetadata mediaMetadata;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this.mLock) {
                mediaMetadata = this.mMetadata;
            }
            return mediaMetadata;
        }
        return (MediaMetadata) invokeV.objValue;
    }

    public long getStartPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mStartPositionMs;
        }
        return invokeV.longValue;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onPreParceling(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (getClass() == MediaItem.class) {
                super.onPreParceling(z);
                return;
            }
            throw new RuntimeException("MediaItem's subclasses shouldn't be parcelized.");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void removeOnMetadataChangedListener(OnMetadataChangedListener onMetadataChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onMetadataChangedListener) == null) {
            synchronized (this.mLock) {
                for (int size = this.mListeners.size() - 1; size >= 0; size--) {
                    if (this.mListeners.get(size).first == onMetadataChangedListener) {
                        this.mListeners.remove(size);
                        return;
                    }
                }
            }
        }
    }

    public void setMetadata(@Nullable MediaMetadata mediaMetadata) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, mediaMetadata) == null) {
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
                    ((Executor) pair.second).execute(new Runnable(this, (OnMetadataChangedListener) pair.first, mediaMetadata) { // from class: androidx.media2.common.MediaItem.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MediaItem this$0;
                        public final /* synthetic */ OnMetadataChangedListener val$listener;
                        public final /* synthetic */ MediaMetadata val$metadata;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r7, mediaMetadata};
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
                            this.val$listener = r7;
                            this.val$metadata = mediaMetadata;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$listener.onMetadataChanged(this.this$0, this.val$metadata);
                            }
                        }
                    });
                }
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
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
        return (String) invokeV.objValue;
    }
}
