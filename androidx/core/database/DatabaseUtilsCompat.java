package androidx.core.database;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Deprecated
/* loaded from: classes.dex */
public final class DatabaseUtilsCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DatabaseUtilsCompat() {
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

    @Deprecated
    public static String[] appendSelectionArgs(String[] strArr, String[] strArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, strArr, strArr2)) == null) {
            if (strArr == null || strArr.length == 0) {
                return strArr2;
            }
            String[] strArr3 = new String[strArr.length + strArr2.length];
            System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
            System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
            return strArr3;
        }
        return (String[]) invokeLL.objValue;
    }

    @Deprecated
    public static String concatenateWhere(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str2;
            }
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            return "(" + str + ") AND (" + str2 + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeLL.objValue;
    }
}
