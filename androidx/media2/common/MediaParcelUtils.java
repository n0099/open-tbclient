package androidx.media2.common;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import androidx.versionedparcelable.ParcelImpl;
import androidx.versionedparcelable.ParcelUtils;
import androidx.versionedparcelable.VersionedParcelable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class MediaParcelUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MediaParcelUtils";
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"RestrictedApi"})
    /* loaded from: classes.dex */
    public static class MediaItemParcelImpl extends ParcelImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MediaItem mItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MediaItemParcelImpl(MediaItem mediaItem) {
            super(new MediaItem(mediaItem));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((VersionedParcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mItem = mediaItem;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.versionedparcelable.ParcelImpl
        public MediaItem getVersionedParcel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mItem;
            }
            return (MediaItem) invokeV.objValue;
        }
    }

    public MediaParcelUtils() {
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

    @Nullable
    public static <T extends VersionedParcelable> T fromParcelable(@NonNull ParcelImpl parcelImpl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, parcelImpl)) == null) {
            return (T) ParcelUtils.fromParcelable(parcelImpl);
        }
        return (T) invokeL.objValue;
    }

    @NonNull
    public static <T extends VersionedParcelable> List<T> fromParcelableList(@NonNull List<ParcelImpl> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(fromParcelable(list.get(i)));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @NonNull
    public static ParcelImpl toParcelable(@Nullable VersionedParcelable versionedParcelable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, versionedParcelable)) == null) {
            if (versionedParcelable instanceof MediaItem) {
                return new MediaItemParcelImpl((MediaItem) versionedParcelable);
            }
            return (ParcelImpl) ParcelUtils.toParcelable(versionedParcelable);
        }
        return (ParcelImpl) invokeL.objValue;
    }

    @NonNull
    public static List<ParcelImpl> toParcelableList(@NonNull List<? extends VersionedParcelable> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(toParcelable(list.get(i)));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
