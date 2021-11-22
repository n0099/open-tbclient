package b.a.p0.x.c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.List;
/* loaded from: classes4.dex */
public class d implements b<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f12300a;

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
        this.f12300a = context.getApplicationContext();
    }

    @Override // b.a.p0.x.c.b
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.x.c.b
    /* renamed from: b */
    public String get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d() : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.x.c.b
    /* renamed from: c */
    public void put(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<ResolveInfo> queryBroadcastReceivers = this.f12300a.getPackageManager().queryBroadcastReceivers(new Intent("com.baidu.intent.action.UUID"), 0);
            String str = null;
            if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    if (activityInfo != null && activityInfo.applicationInfo != null && !this.f12300a.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                        File file = new File(new File(resolveInfo.activityInfo.applicationInfo.dataDir, com.baidu.fsg.face.base.b.c.f38604g), "libuuid.so");
                        if (file.exists()) {
                            str = b.a.p0.x.d.a.c(file);
                        }
                        if (!TextUtils.isEmpty(str)) {
                            break;
                        }
                    }
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
