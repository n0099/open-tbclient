package c.a.r.i;

import android.content.Context;
import android.content.pm.PackageInfo;
import c.a.r.h.c.a.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes6.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f11789b;

    /* renamed from: c  reason: collision with root package name */
    public int f11790c;

    /* renamed from: d  reason: collision with root package name */
    public String f11791d;

    /* renamed from: e  reason: collision with root package name */
    public long f11792e;

    /* renamed from: f  reason: collision with root package name */
    public long f11793f;

    public b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            this.f11791d = packageInfo.versionName;
            this.f11790c = packageInfo.versionCode;
            this.f11792e = packageInfo.firstInstallTime;
            this.f11793f = packageInfo.lastUpdateTime;
            this.f11789b = new String[packageInfo.signatures.length];
            for (int i4 = 0; i4 < this.f11789b.length; i4++) {
                this.f11789b[i4] = f.c(packageInfo.signatures[i4].toByteArray());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "SappInfo{pkg='" + this.a + ExtendedMessageFormat.QUOTE + ", sigs=" + Arrays.toString(this.f11789b) + ", vc=" + this.f11790c + ", va=" + this.f11791d + ", installts=" + this.f11792e + ", lstupdatets=" + this.f11793f + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
