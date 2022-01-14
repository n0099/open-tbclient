package c.a.c0.e0;

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
    public static final a f1857b = new C0051a();

    /* renamed from: c.a.c0.e0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0051a implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0051a() {
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

        @Override // c.a.c0.e0.a
        public void a(@NonNull Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) {
                Toast.makeText(context, str, 0).show();
            }
        }

        @Override // c.a.c0.e0.a
        public void b(@NonNull Context context, @StringRes int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2) == null) {
                Toast.makeText(context, i2, 0).show();
            }
        }

        @Override // c.a.c0.e0.a
        public void c(@NonNull Context context, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, context, i2, i3) == null) {
                Toast.makeText(context, i2, i3).show();
            }
        }
    }

    void a(@NonNull Context context, String str);

    void b(@NonNull Context context, @StringRes int i2);

    void c(@NonNull Context context, @StringRes int i2, int i3);
}
