package androidx.core.app;

import android.app.Dialog;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class DialogCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DialogCompat() {
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

    @NonNull
    public static View requireViewById(@NonNull Dialog dialog, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, dialog, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return dialog.requireViewById(i2);
            }
            View findViewById = dialog.findViewById(i2);
            if (findViewById != null) {
                return findViewById;
            }
            throw new IllegalArgumentException("ID does not reference a View inside this Dialog");
        }
        return (View) invokeLI.objValue;
    }
}
