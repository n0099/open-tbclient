package androidx.core.app;

import android.app.Dialog;
import android.os.Build;
import android.view.View;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static View requireViewById(Dialog dialog, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, dialog, i)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return dialog.requireViewById(i);
            }
            View findViewById = dialog.findViewById(i);
            if (findViewById != null) {
                return findViewById;
            }
            throw new IllegalArgumentException("ID does not reference a View inside this Dialog");
        }
        return (View) invokeLI.objValue;
    }
}
