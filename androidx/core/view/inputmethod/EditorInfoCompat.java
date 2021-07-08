package androidx.core.view.inputmethod;

import android.os.Build;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class EditorInfoCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CONTENT_MIME_TYPES_INTEROP_KEY = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    public static final String CONTENT_MIME_TYPES_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    public static final String[] EMPTY_STRING_ARRAY;
    public static final int IME_FLAG_FORCE_ASCII = Integer.MIN_VALUE;
    public static final int IME_FLAG_NO_PERSONALIZED_LEARNING = 16777216;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2064546662, "Landroidx/core/view/inputmethod/EditorInfoCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2064546662, "Landroidx/core/view/inputmethod/EditorInfoCompat;");
                return;
            }
        }
        EMPTY_STRING_ARRAY = new String[0];
    }

    @Deprecated
    public EditorInfoCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @NonNull
    public static String[] getContentMimeTypes(EditorInfo editorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, editorInfo)) == null) {
            if (Build.VERSION.SDK_INT >= 25) {
                String[] strArr = editorInfo.contentMimeTypes;
                return strArr != null ? strArr : EMPTY_STRING_ARRAY;
            }
            Bundle bundle = editorInfo.extras;
            if (bundle == null) {
                return EMPTY_STRING_ARRAY;
            }
            String[] stringArray = bundle.getStringArray(CONTENT_MIME_TYPES_KEY);
            if (stringArray == null) {
                stringArray = editorInfo.extras.getStringArray(CONTENT_MIME_TYPES_INTEROP_KEY);
            }
            return stringArray != null ? stringArray : EMPTY_STRING_ARRAY;
        }
        return (String[]) invokeL.objValue;
    }

    public static int getProtocol(EditorInfo editorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, editorInfo)) == null) {
            if (Build.VERSION.SDK_INT >= 25) {
                return 1;
            }
            Bundle bundle = editorInfo.extras;
            if (bundle == null) {
                return 0;
            }
            boolean containsKey = bundle.containsKey(CONTENT_MIME_TYPES_KEY);
            boolean containsKey2 = editorInfo.extras.containsKey(CONTENT_MIME_TYPES_INTEROP_KEY);
            if (containsKey && containsKey2) {
                return 4;
            }
            if (containsKey) {
                return 3;
            }
            return containsKey2 ? 2 : 0;
        }
        return invokeL.intValue;
    }

    public static void setContentMimeTypes(@NonNull EditorInfo editorInfo, @Nullable String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, editorInfo, strArr) == null) {
            if (Build.VERSION.SDK_INT >= 25) {
                editorInfo.contentMimeTypes = strArr;
                return;
            }
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            editorInfo.extras.putStringArray(CONTENT_MIME_TYPES_KEY, strArr);
            editorInfo.extras.putStringArray(CONTENT_MIME_TYPES_INTEROP_KEY, strArr);
        }
    }
}
