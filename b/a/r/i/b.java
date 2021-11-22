package b.a.r.i;

import android.content.Context;
import android.content.pm.PackageInfo;
import b.a.r.h.c.a.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes4.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f15376a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f15377b;

    /* renamed from: c  reason: collision with root package name */
    public int f15378c;

    /* renamed from: d  reason: collision with root package name */
    public String f15379d;

    /* renamed from: e  reason: collision with root package name */
    public long f15380e;

    /* renamed from: f  reason: collision with root package name */
    public long f15381f;

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
        this.f15376a = str;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            this.f15379d = packageInfo.versionName;
            this.f15378c = packageInfo.versionCode;
            this.f15380e = packageInfo.firstInstallTime;
            this.f15381f = packageInfo.lastUpdateTime;
            this.f15377b = new String[packageInfo.signatures.length];
            for (int i4 = 0; i4 < this.f15377b.length; i4++) {
                this.f15377b[i4] = f.c(packageInfo.signatures[i4].toByteArray());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "SappInfo{pkg='" + this.f15376a + ExtendedMessageFormat.QUOTE + ", sigs=" + Arrays.toString(this.f15377b) + ", vc=" + this.f15378c + ", va=" + this.f15379d + ", installts=" + this.f15380e + ", lstupdatets=" + this.f15381f + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
