package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class ParcelUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String INNER_BUNDLE_KEY = "a";
    public transient /* synthetic */ FieldHolder $fh;

    public ParcelUtils() {
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

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T extends VersionedParcelable> T fromInputStream(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, inputStream)) == null) ? (T) new VersionedParcelStream(inputStream, null).readVersionedParcelable() : (T) invokeL.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T extends VersionedParcelable> T fromParcelable(Parcelable parcelable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, parcelable)) == null) {
            if (parcelable instanceof ParcelImpl) {
                return (T) ((ParcelImpl) parcelable).getVersionedParcel();
            }
            throw new IllegalArgumentException("Invalid parcel");
        }
        return (T) invokeL.objValue;
    }

    @Nullable
    public static <T extends VersionedParcelable> T getVersionedParcelable(@NonNull Bundle bundle, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, bundle, str)) == null) {
            try {
                Bundle bundle2 = (Bundle) bundle.getParcelable(str);
                if (bundle2 == null) {
                    return null;
                }
                bundle2.setClassLoader(ParcelUtils.class.getClassLoader());
                return (T) fromParcelable(bundle2.getParcelable("a"));
            } catch (RuntimeException unused) {
                return null;
            }
        }
        return (T) invokeLL.objValue;
    }

    @Nullable
    public static <T extends VersionedParcelable> List<T> getVersionedParcelableList(Bundle bundle, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, bundle, str)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                Bundle bundle2 = (Bundle) bundle.getParcelable(str);
                bundle2.setClassLoader(ParcelUtils.class.getClassLoader());
                Iterator it = bundle2.getParcelableArrayList("a").iterator();
                while (it.hasNext()) {
                    arrayList.add(fromParcelable((Parcelable) it.next()));
                }
                return arrayList;
            } catch (RuntimeException unused) {
                return null;
            }
        }
        return (List) invokeLL.objValue;
    }

    public static void putVersionedParcelable(@NonNull Bundle bundle, @NonNull String str, @Nullable VersionedParcelable versionedParcelable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, bundle, str, versionedParcelable) == null) || versionedParcelable == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("a", toParcelable(versionedParcelable));
        bundle.putParcelable(str, bundle2);
    }

    public static void putVersionedParcelableList(@NonNull Bundle bundle, @NonNull String str, @NonNull List<? extends VersionedParcelable> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, bundle, str, list) == null) {
            Bundle bundle2 = new Bundle();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            for (VersionedParcelable versionedParcelable : list) {
                arrayList.add(toParcelable(versionedParcelable));
            }
            bundle2.putParcelableArrayList("a", arrayList);
            bundle.putParcelable(str, bundle2);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void toOutputStream(VersionedParcelable versionedParcelable, OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, versionedParcelable, outputStream) == null) {
            VersionedParcelStream versionedParcelStream = new VersionedParcelStream(null, outputStream);
            versionedParcelStream.writeVersionedParcelable(versionedParcelable);
            versionedParcelStream.closeField();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Parcelable toParcelable(VersionedParcelable versionedParcelable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, versionedParcelable)) == null) ? new ParcelImpl(versionedParcelable) : (Parcelable) invokeL.objValue;
    }
}
