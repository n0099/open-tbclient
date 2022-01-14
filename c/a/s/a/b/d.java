package c.a.s.a.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import c.a.s.a.e.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.BaseContentUploader;
import com.baidu.searchbox.logsystem.basic.upload.identity.NetworkParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public final class d implements b, c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    public d(Context context) {
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
        this.a = context;
    }

    @Override // c.a.s.a.b.b
    public final String a() {
        InterceptResult invokeV;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = c.a.s.a.a.d().c() != c.a.s.a.e.a.a ? "http://bjyz-mco-searchbox201609-m12xi3-044.bjyz.baidu.com:8080/ztbox" : "https://tcbox.baidu.com/ztbox";
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("?");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("action=zubc");
            sb2.append("&appname=imsdk");
            sb2.append("&uid=");
            sb2.append(c.a.s.a.a.d().a());
            sb2.append("&ua=");
            Context context = this.a;
            DisplayMetrics a = f.a(context);
            int i2 = a != null ? a.widthPixels : 0;
            DisplayMetrics a2 = f.a(context);
            int i3 = a2 != null ? a2.heightPixels : 0;
            DisplayMetrics a3 = f.a(context);
            int i4 = a3 != null ? a3.densityDpi : 0;
            sb2.append(i2 + "_" + i3 + "_android_" + f.b(context) + "_" + i4);
            sb2.append("&ut=");
            String str2 = Build.MODEL;
            String replace = TextUtils.isEmpty(str2) ? "NUL" : str2.replace("_", "-");
            String str3 = Build.VERSION.RELEASE;
            String replace2 = TextUtils.isEmpty(str3) ? "0.0" : str3.replace("_", "-");
            int i5 = Build.VERSION.SDK_INT;
            String str4 = Build.MANUFACTURER;
            sb2.append(replace + "_" + replace2 + "_" + i5 + "_" + (TextUtils.isEmpty(str4) ? "NUL" : str4.replace("_", "-")));
            sb2.append("&network=");
            c.a.s.a.e.d dVar = new c.a.s.a.e.d(this.a);
            boolean isEmpty = TextUtils.isEmpty(dVar.a);
            String str5 = NetworkParam.NET_TYPE_ID_DISCONNECT;
            if (!isEmpty && (num = c.a.s.a.e.d.f12046c.get(dVar.a)) != null) {
                str5 = num + "_" + dVar.f12047b;
            }
            if (str5 == null) {
                str5 = "unknown";
            }
            sb2.append(str5);
            sb2.append("&appversion=");
            sb2.append(f.b(this.a));
            if (c.a.s.a.a.d().c() != c.a.s.a.e.a.a) {
                sb2.append("&debug=1");
            }
            sb.append(sb2.toString());
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.s.a.b.c
    public final void a(int i2, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            String str = new String(bArr);
            c.a.s.a.e.c.a("UBCRequest", "ubc upload errorcode:" + i2 + ", resultContent:" + str);
        }
    }

    @Override // c.a.s.a.b.b
    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // c.a.s.a.b.c
    public final void b(int i2, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, bArr) == null) {
            String str = new String(bArr);
            c.a.s.a.e.c.a("UBCRequest", "ubc upload errorcode:" + i2 + ", resultContent:" + str);
        }
    }

    @Override // c.a.s.a.b.b
    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "application/octet-stream" : (String) invokeV.objValue;
    }

    @Override // c.a.s.a.b.b
    public final Map<String, String> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(BaseContentUploader.NB, "1");
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }
}
