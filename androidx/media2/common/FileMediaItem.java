package androidx.media2.common;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import androidx.media2.common.MediaItem;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes.dex */
public class FileMediaItem extends MediaItem {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long FD_LENGTH_UNKNOWN = 576460752303423487L;
    public static final String TAG = "FileMediaItem";
    public transient /* synthetic */ FieldHolder $fh;
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
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long mFDLength;
        public long mFDOffset;
        public ParcelFileDescriptor mPFD;

        public Builder(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcelFileDescriptor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
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
        public FileMediaItem build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new FileMediaItem(this);
            }
            return (FileMediaItem) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.media2.common.MediaItem.Builder
        @NonNull
        public Builder setEndPosition(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
                return (Builder) super.setEndPosition(j);
            }
            return (Builder) invokeJ.objValue;
        }

        @NonNull
        public Builder setFileDescriptorLength(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
                if (j < 0) {
                    j = 576460752303423487L;
                }
                this.mFDLength = j;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        @NonNull
        public Builder setFileDescriptorOffset(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
                if (j < 0) {
                    j = 0;
                }
                this.mFDOffset = j;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.media2.common.MediaItem.Builder
        @NonNull
        public Builder setMetadata(@Nullable MediaMetadata mediaMetadata) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, mediaMetadata)) == null) {
                return (Builder) super.setMetadata(mediaMetadata);
            }
            return (Builder) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.media2.common.MediaItem.Builder
        @NonNull
        public Builder setStartPosition(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) == null) {
                return (Builder) super.setStartPosition(j);
            }
            return (Builder) invokeJ.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileMediaItem(Builder builder) {
        super(builder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((MediaItem.Builder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLock = new Object();
        this.mPFD = builder.mPFD;
        this.mFDOffset = builder.mFDOffset;
        this.mFDLength = builder.mFDLength;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this.mLock) {
                if (this.mPFD != null) {
                    this.mPFD.close();
                }
                this.mClosed = true;
            }
        }
    }

    public long getFileDescriptorLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mFDLength;
        }
        return invokeV.longValue;
    }

    public long getFileDescriptorOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mFDOffset;
        }
        return invokeV.longValue;
    }

    @NonNull
    public ParcelFileDescriptor getParcelFileDescriptor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mPFD;
        }
        return (ParcelFileDescriptor) invokeV.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void increaseRefCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this.mLock) {
                if (this.mClosed) {
                    Log.w(TAG, "ParcelFileDescriptorClient is already closed.");
                } else {
                    this.mRefCount++;
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isClosed() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this.mLock) {
                z = this.mClosed;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void decreaseRefCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
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
}
