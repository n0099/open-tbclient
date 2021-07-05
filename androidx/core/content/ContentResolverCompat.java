package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.OperationCanceledException;
import androidx.core.os.CancellationSignal;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class ContentResolverCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ContentResolverCompat() {
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

    public static Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        InterceptResult invokeCommon;
        Object cancellationSignalObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{contentResolver, uri, strArr, str, strArr2, str2, cancellationSignal})) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                if (cancellationSignal != null) {
                    try {
                        cancellationSignalObject = cancellationSignal.getCancellationSignalObject();
                    } catch (Exception e2) {
                        if (e2 instanceof OperationCanceledException) {
                            throw new androidx.core.os.OperationCanceledException();
                        }
                        throw e2;
                    }
                } else {
                    cancellationSignalObject = null;
                }
                return contentResolver.query(uri, strArr, str, strArr2, str2, (android.os.CancellationSignal) cancellationSignalObject);
            }
            if (cancellationSignal != null) {
                cancellationSignal.throwIfCanceled();
            }
            return contentResolver.query(uri, strArr, str, strArr2, str2);
        }
        return (Cursor) invokeCommon.objValue;
    }
}
