package androidx.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class MediaBrowserCompatUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MediaBrowserCompatUtils() {
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

    public static boolean areSameOptions(Bundle bundle, Bundle bundle2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bundle, bundle2)) == null) {
            if (bundle == bundle2) {
                return true;
            }
            if (bundle == null) {
                if (bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == -1 && bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == -1) {
                    return true;
                }
                return false;
            } else if (bundle2 == null) {
                if (bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == -1 && bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == -1) {
                    return true;
                }
                return false;
            } else if (bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) && bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1)) {
                return true;
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean hasDuplicatedItems(Bundle bundle, Bundle bundle2) {
        InterceptResult invokeLL;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bundle, bundle2)) == null) {
            if (bundle == null) {
                i = -1;
            } else {
                i = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
            }
            if (bundle2 == null) {
                i2 = -1;
            } else {
                i2 = bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
            }
            if (bundle == null) {
                i3 = -1;
            } else {
                i3 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
            }
            if (bundle2 == null) {
                i4 = -1;
            } else {
                i4 = bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
            }
            int i8 = Integer.MAX_VALUE;
            if (i != -1 && i3 != -1) {
                i6 = i * i3;
                i5 = (i3 + i6) - 1;
            } else {
                i5 = Integer.MAX_VALUE;
                i6 = 0;
            }
            if (i2 != -1 && i4 != -1) {
                i7 = i2 * i4;
                i8 = (i4 + i7) - 1;
            } else {
                i7 = 0;
            }
            if (i5 >= i7 && i8 >= i6) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
