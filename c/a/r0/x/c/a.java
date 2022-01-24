package c.a.r0.x.c;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.s;
import java.io.File;
/* loaded from: classes6.dex */
public class a implements b<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context.getApplicationContext();
    }

    @Override // c.a.r0.x.c.b
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.equals("mounted", Environment.getExternalStorageState()) && c.a.r0.x.d.c.a(this.a, s.f55293i)) {
                return !new File(new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig"), ".uuid").exists();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.x.c.b
    /* renamed from: b */
    public String get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c() : (String) invokeV.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (TextUtils.equals("mounted", Environment.getExternalStorageState()) && c.a.r0.x.d.c.a(this.a, s.f55293i)) {
                File file = new File(new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig"), ".uuid");
                if (file.exists()) {
                    return c.a.r0.x.d.a.c(file);
                }
                return null;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.x.c.b
    /* renamed from: d */
    public void put(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            e(str);
        }
    }

    public final void e(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && TextUtils.equals("mounted", Environment.getExternalStorageState()) && c.a.r0.x.d.c.a(this.a, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            c.a.r0.x.d.a.d(str, new File(new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig"), ".uuid"));
        }
    }
}
