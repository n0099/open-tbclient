package c.a.q.i;

import android.content.Context;
import android.content.pm.PackageInfo;
import c.a.q.h.c.a.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes5.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f11480b;

    /* renamed from: c  reason: collision with root package name */
    public int f11481c;

    /* renamed from: d  reason: collision with root package name */
    public String f11482d;

    /* renamed from: e  reason: collision with root package name */
    public long f11483e;

    /* renamed from: f  reason: collision with root package name */
    public long f11484f;

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
            this.f11482d = packageInfo.versionName;
            this.f11481c = packageInfo.versionCode;
            this.f11483e = packageInfo.firstInstallTime;
            this.f11484f = packageInfo.lastUpdateTime;
            this.f11480b = new String[packageInfo.signatures.length];
            for (int i4 = 0; i4 < this.f11480b.length; i4++) {
                this.f11480b[i4] = f.c(packageInfo.signatures[i4].toByteArray());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "SappInfo{pkg='" + this.a + ExtendedMessageFormat.QUOTE + ", sigs=" + Arrays.toString(this.f11480b) + ", vc=" + this.f11481c + ", va=" + this.f11482d + ", installts=" + this.f11483e + ", lstupdatets=" + this.f11484f + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
