package c.a.p.i;

import android.content.Context;
import android.content.pm.PackageInfo;
import c.a.p.h.c.a.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes2.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f11794b;

    /* renamed from: c  reason: collision with root package name */
    public int f11795c;

    /* renamed from: d  reason: collision with root package name */
    public String f11796d;

    /* renamed from: e  reason: collision with root package name */
    public long f11797e;

    /* renamed from: f  reason: collision with root package name */
    public long f11798f;

    public b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            this.f11796d = packageInfo.versionName;
            this.f11795c = packageInfo.versionCode;
            this.f11797e = packageInfo.firstInstallTime;
            this.f11798f = packageInfo.lastUpdateTime;
            this.f11794b = new String[packageInfo.signatures.length];
            for (int i3 = 0; i3 < this.f11794b.length; i3++) {
                this.f11794b[i3] = f.c(packageInfo.signatures[i3].toByteArray());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "SappInfo{pkg='" + this.a + "', sigs=" + Arrays.toString(this.f11794b) + ", vc=" + this.f11795c + ", va=" + this.f11796d + ", installts=" + this.f11797e + ", lstupdatets=" + this.f11798f + '}';
        }
        return (String) invokeV.objValue;
    }
}
