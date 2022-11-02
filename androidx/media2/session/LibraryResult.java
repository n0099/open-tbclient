package androidx.media2.session;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.view.InputDeviceCompat;
import androidx.media2.common.MediaItem;
import androidx.media2.common.ParcelImplListSlice;
import androidx.media2.session.MediaLibraryService;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
/* loaded from: classes.dex */
public class LibraryResult extends CustomVersionedParcelable implements RemoteResult {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long mCompletionTime;
    public MediaItem mItem;
    public List<MediaItem> mItemList;
    public ParcelImplListSlice mItemListSlice;
    public MediaLibraryService.LibraryParams mParams;
    public MediaItem mParcelableItem;
    public int mResultCode;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface ResultCode {
    }

    public LibraryResult() {
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

    @Override // androidx.media2.common.BaseResult
    public long getCompletionTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mCompletionTime;
        }
        return invokeV.longValue;
    }

    @Nullable
    public MediaLibraryService.LibraryParams getLibraryParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mParams;
        }
        return (MediaLibraryService.LibraryParams) invokeV.objValue;
    }

    @Override // androidx.media2.common.BaseResult
    @Nullable
    public MediaItem getMediaItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mItem;
        }
        return (MediaItem) invokeV.objValue;
    }

    @Nullable
    public List<MediaItem> getMediaItems() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mItemList;
        }
        return (List) invokeV.objValue;
    }

    @Override // androidx.media2.common.BaseResult
    public int getResultCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mResultCode;
        }
        return invokeV.intValue;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onPostParceling() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mItem = this.mParcelableItem;
            this.mItemList = MediaUtils.convertParcelImplListSliceToMediaItemList(this.mItemListSlice);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LibraryResult(int i) {
        this(i, null, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (MediaItem) objArr2[1], (List) objArr2[2], (MediaLibraryService.LibraryParams) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LibraryResult(int i, @Nullable MediaItem mediaItem, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        this(i, mediaItem, null, libraryParams);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), mediaItem, libraryParams};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (MediaItem) objArr2[1], (List) objArr2[2], (MediaLibraryService.LibraryParams) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public LibraryResult(int i, @Nullable MediaItem mediaItem, @Nullable List<MediaItem> list, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), mediaItem, list, libraryParams};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mResultCode = i;
        this.mCompletionTime = SystemClock.elapsedRealtime();
        this.mItem = mediaItem;
        this.mItemList = list;
        this.mParams = libraryParams;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LibraryResult(int i, @Nullable List<MediaItem> list, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        this(i, null, list, libraryParams);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), list, libraryParams};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (MediaItem) objArr2[1], (List) objArr2[2], (MediaLibraryService.LibraryParams) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    public static ListenableFuture<LibraryResult> createFutureWithResult(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            ResolvableFuture create = ResolvableFuture.create();
            create.set(new LibraryResult(i));
            return create;
        }
        return (ListenableFuture) invokeI.objValue;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onPreParceling(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            MediaItem mediaItem = this.mItem;
            if (mediaItem != null) {
                synchronized (mediaItem) {
                    if (this.mParcelableItem == null) {
                        this.mParcelableItem = MediaUtils.upcastForPreparceling(this.mItem);
                    }
                }
            }
            List<MediaItem> list = this.mItemList;
            if (list != null) {
                synchronized (list) {
                    if (this.mItemListSlice == null) {
                        this.mItemListSlice = MediaUtils.convertMediaItemListToParcelImplListSlice(this.mItemList);
                    }
                }
            }
        }
    }
}
