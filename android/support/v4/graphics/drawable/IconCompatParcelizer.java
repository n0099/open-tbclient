package android.support.v4.graphics.drawable;

import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class IconCompatParcelizer extends androidx.core.graphics.drawable.IconCompatParcelizer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public IconCompatParcelizer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static IconCompat read(VersionedParcel versionedParcel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, versionedParcel)) == null) ? androidx.core.graphics.drawable.IconCompatParcelizer.read(versionedParcel) : (IconCompat) invokeL.objValue;
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, iconCompat, versionedParcel) == null) {
            androidx.core.graphics.drawable.IconCompatParcelizer.write(iconCompat, versionedParcel);
        }
    }
}
