package c.a.a0.g.h;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final Boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements c.a.a0.g.h.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WeakReference a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Intent f1179b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.a0.g.h.a f1180c;

        public a(WeakReference weakReference, Intent intent, c.a.a0.g.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {weakReference, intent, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = weakReference;
            this.f1179b = intent;
            this.f1180c = aVar;
        }

        @Override // c.a.a0.g.h.a
        public void onResult(boolean z) {
            Context context;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z && (context = (Context) this.a.get()) != null) {
                    c.a.a0.h0.a.c(context, this.f1179b);
                }
                c.a.a0.g.h.a aVar = this.f1180c;
                if (aVar != null) {
                    aVar.onResult(z);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(154734945, "Lc/a/a0/g/h/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(154734945, "Lc/a/a0/g/h/c;");
                return;
            }
        }
        a = Boolean.FALSE;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, String str, String str2, c.a.a0.g.h.a aVar, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65537, null, new Object[]{context, str, str2, aVar, Boolean.valueOf(z)}) != null) {
            return;
        }
        WeakReference weakReference = new WeakReference(context);
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            if (z && !b.a(context, str)) {
                z2 = false;
                if (z2) {
                    if (aVar != null) {
                        aVar.onResult(false);
                        return;
                    }
                    return;
                } else if (z) {
                    c.a.a0.g.g.a.a().b(str, str2, new a(weakReference, intent, aVar));
                    return;
                } else {
                    c.a.a0.h0.a.c(context, intent);
                    if (aVar != null) {
                        aVar.onResult(true);
                        return;
                    }
                    return;
                }
            }
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            int i = 0;
            z2 = false;
            while (true) {
                if (i >= queryIntentActivities.size()) {
                    break;
                }
                ResolveInfo resolveInfo = (ResolveInfo) c.a.a0.x.a.d(queryIntentActivities, i);
                if (resolveInfo != null) {
                    String str3 = resolveInfo.activityInfo.packageName;
                    if (TextUtils.equals(str3, str2)) {
                        intent.setPackage(str3);
                        z2 = true;
                        break;
                    }
                    z2 = true;
                }
                i++;
            }
            if (z2) {
            }
        } catch (Exception unused) {
            if (aVar != null) {
                aVar.onResult(false);
            }
        }
    }

    public static boolean b(@NonNull Context context, @NonNull String str) {
        InterceptResult invokeLL;
        ResolveInfo next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            boolean z = false;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(str);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities.size() > 0 && (next = queryIntentActivities.iterator().next()) != null) {
                String str2 = next.activityInfo.name;
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.addCategory("android.intent.category.LAUNCHER");
                intent2.setComponent(new ComponentName(str, str2));
                intent2.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                try {
                    context.startActivity(intent2);
                    z = true;
                } catch (Exception unused) {
                }
            }
            if (a.booleanValue() && !z) {
                Log.e("OpenAppUtils", "openAppByPkgName: " + str + "  failed");
            }
            return z;
        }
        return invokeLL.booleanValue;
    }
}
