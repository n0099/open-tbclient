package androidx.media2.session;

import androidx.annotation.RestrictTo;
import androidx.media2.common.MediaItem;
import androidx.media2.common.ParcelImplListSlice;
import androidx.media2.session.MediaLibraryService;
import androidx.versionedparcelable.VersionedParcel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class LibraryResultParcelizer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public LibraryResultParcelizer() {
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

    public static LibraryResult read(VersionedParcel versionedParcel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, versionedParcel)) == null) {
            LibraryResult libraryResult = new LibraryResult();
            libraryResult.mResultCode = versionedParcel.readInt(libraryResult.mResultCode, 1);
            libraryResult.mCompletionTime = versionedParcel.readLong(libraryResult.mCompletionTime, 2);
            libraryResult.mParcelableItem = (MediaItem) versionedParcel.readVersionedParcelable(libraryResult.mParcelableItem, 3);
            libraryResult.mParams = (MediaLibraryService.LibraryParams) versionedParcel.readVersionedParcelable(libraryResult.mParams, 4);
            libraryResult.mItemListSlice = (ParcelImplListSlice) versionedParcel.readParcelable(libraryResult.mItemListSlice, 5);
            libraryResult.onPostParceling();
            return libraryResult;
        }
        return (LibraryResult) invokeL.objValue;
    }

    public static void write(LibraryResult libraryResult, VersionedParcel versionedParcel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, libraryResult, versionedParcel) == null) {
            versionedParcel.setSerializationFlags(false, false);
            libraryResult.onPreParceling(versionedParcel.isStream());
            versionedParcel.writeInt(libraryResult.mResultCode, 1);
            versionedParcel.writeLong(libraryResult.mCompletionTime, 2);
            versionedParcel.writeVersionedParcelable(libraryResult.mParcelableItem, 3);
            versionedParcel.writeVersionedParcelable(libraryResult.mParams, 4);
            versionedParcel.writeParcelable(libraryResult.mItemListSlice, 5);
        }
    }
}
