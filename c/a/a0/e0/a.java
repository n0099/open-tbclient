package c.a.a0.e0;

import android.content.Context;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public interface a {
    public static final ServiceReference a = new ServiceReference("nad.core", "toast");

    /* renamed from: b  reason: collision with root package name */
    public static final a f1152b = new C0021a();

    /* renamed from: c.a.a0.e0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0021a implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0021a() {
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

        @Override // c.a.a0.e0.a
        public void a(@NonNull Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) {
                Toast.makeText(context, str, 0).show();
            }
        }

        @Override // c.a.a0.e0.a
        public void b(@NonNull Context context, @StringRes int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i) == null) {
                Toast.makeText(context, i, 0).show();
            }
        }

        @Override // c.a.a0.e0.a
        public void c(@NonNull Context context, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, context, i, i2) == null) {
                Toast.makeText(context, i, i2).show();
            }
        }
    }

    void a(@NonNull Context context, String str);

    void b(@NonNull Context context, @StringRes int i);

    void c(@NonNull Context context, @StringRes int i, int i2);
}
