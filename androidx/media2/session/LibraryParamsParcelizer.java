package androidx.media2.session;

import androidx.annotation.RestrictTo;
import androidx.media2.session.MediaLibraryService;
import androidx.versionedparcelable.VersionedParcel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class LibraryParamsParcelizer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public LibraryParamsParcelizer() {
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

    public static MediaLibraryService.LibraryParams read(VersionedParcel versionedParcel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, versionedParcel)) == null) {
            MediaLibraryService.LibraryParams libraryParams = new MediaLibraryService.LibraryParams();
            libraryParams.mBundle = versionedParcel.readBundle(libraryParams.mBundle, 1);
            libraryParams.mRecent = versionedParcel.readInt(libraryParams.mRecent, 2);
            libraryParams.mOffline = versionedParcel.readInt(libraryParams.mOffline, 3);
            libraryParams.mSuggested = versionedParcel.readInt(libraryParams.mSuggested, 4);
            return libraryParams;
        }
        return (MediaLibraryService.LibraryParams) invokeL.objValue;
    }

    public static void write(MediaLibraryService.LibraryParams libraryParams, VersionedParcel versionedParcel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, libraryParams, versionedParcel) == null) {
            versionedParcel.setSerializationFlags(false, false);
            versionedParcel.writeBundle(libraryParams.mBundle, 1);
            versionedParcel.writeInt(libraryParams.mRecent, 2);
            versionedParcel.writeInt(libraryParams.mOffline, 3);
            versionedParcel.writeInt(libraryParams.mSuggested, 4);
        }
    }
}
