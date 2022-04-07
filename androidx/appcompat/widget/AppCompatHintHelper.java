package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class AppCompatHintHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AppCompatHintHelper() {
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

    public static InputConnection onCreateInputConnection(InputConnection inputConnection, EditorInfo editorInfo, View view2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, inputConnection, editorInfo, view2)) == null) {
            if (inputConnection != null && editorInfo.hintText == null) {
                ViewParent parent = view2.getParent();
                while (true) {
                    if (!(parent instanceof View)) {
                        break;
                    } else if (parent instanceof WithHint) {
                        editorInfo.hintText = ((WithHint) parent).getHint();
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
            }
            return inputConnection;
        }
        return (InputConnection) invokeLLL.objValue;
    }
}
