package c.a.d.f.a;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public String f1846b;

    /* renamed from: c  reason: collision with root package name */
    public String f1847c;

    /* renamed from: d  reason: collision with root package name */
    public String f1848d;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = Environment.getExternalStorageDirectory().getAbsolutePath();
        this.f1846b = this.a + "/baidu/";
        this.f1847c = null;
        this.f1848d = null;
        try {
            this.f1847c = BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath() + "/";
            this.f1848d = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public String a(String str, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (z2) {
                if (!b()) {
                    return null;
                }
                if (str != null) {
                    str3 = this.f1846b + str + "/";
                } else {
                    str3 = this.f1846b;
                }
            } else if (z3) {
                str2 = this.f1848d;
                if (str2 == null) {
                    return null;
                }
                if (str != null) {
                    str3 = this.f1848d + str + "/";
                }
                str3 = str2;
            } else {
                str2 = this.f1847c;
                if (str2 == null) {
                    return null;
                }
                if (str != null) {
                    str3 = this.f1847c + str + "/";
                }
                str3 = str2;
            }
            File file = new File(str3);
            if (file.exists()) {
                return str3;
            }
            if (z && file.mkdirs()) {
                return str3;
            }
            return null;
        }
        return (String) invokeCommon.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Environment.getExternalStorageState().equals("mounted") : invokeV.booleanValue;
    }

    public File c(String str, String str2, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (str2 == null || (a = a(str, z, z2, z3)) == null) {
                return null;
            }
            return new File(a + str2);
        }
        return (File) invokeCommon.objValue;
    }

    public File d(String str, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            String a = a(str, z, z2, z3);
            if (a == null) {
                return null;
            }
            return new File(a);
        }
        return (File) invokeCommon.objValue;
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || str == null) {
            return;
        }
        this.f1846b = this.a + "/" + str + "/";
    }
}
