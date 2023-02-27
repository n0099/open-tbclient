package com.baidu.sofire.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.b.i;
import com.baidu.sofire.b.j;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.k.u;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public final class f implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Intent a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ boolean c;

    public f(Intent intent, Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {intent, context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = intent;
        this.b = context;
        this.c = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        ApkInfo b;
        List<ApkInfo> b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if ("r".equals(this.a.getStringExtra("t"))) {
                    String stringExtra = this.a.getStringExtra("c");
                    Intent intent = new Intent();
                    intent.putExtra("t", "r");
                    intent.putExtra("c", stringExtra);
                    a.a(this.b, intent);
                }
                String action = this.a.getAction();
                if (this.c && "android.net.conn.CONNECTIVITY_CHANGE".equals(action) && com.baidu.sofire.k.b.k(this.b) && U.sMonitorNetworkWhenUpgradeNoNet) {
                    u.a(this.b).b(new U(this.b.getApplicationContext(), 3, false));
                    z = true;
                } else {
                    z = false;
                }
                if (this.c && "android.net.conn.CONNECTIVITY_CHANGE".equals(action) && com.baidu.sofire.k.b.a && !z && com.baidu.sofire.k.b.l(this.b)) {
                    u.a(this.b).b(new U(this.b.getApplicationContext(), 3, false));
                }
                if (this.c) {
                    return;
                }
                String stringExtra2 = this.a.getStringExtra("from_plugin_package");
                if (TextUtils.isEmpty(stringExtra2)) {
                    i iVar = i.g;
                    if (iVar != null && (b2 = iVar.b()) != null) {
                        for (int i = 0; i < b2.size(); i++) {
                            ApkInfo apkInfo = b2.get(i);
                            if (apkInfo.intentFilters != null) {
                                for (int i2 = 0; i2 < apkInfo.intentFilters.size(); i2++) {
                                    j jVar = apkInfo.intentFilters.get(i2);
                                    if (jVar.d.match(this.a.getAction(), this.a.getType(), this.a.getScheme(), this.a.getData(), this.a.getCategories(), "PIF") >= 0) {
                                        Class<?> loadClass = apkInfo.classLoader.loadClass(jVar.b);
                                        loadClass.getDeclaredMethod(jVar.c, Context.class, Intent.class).invoke(loadClass.newInstance(), this.b.getApplicationContext(), this.a);
                                    }
                                }
                            }
                        }
                    }
                } else if (this.b.getPackageName().equals(stringExtra2)) {
                    MyReceiver.a(this.b.getClassLoader(), this.a, this.b);
                } else {
                    i iVar2 = i.g;
                    if (iVar2 == null || (b = iVar2.b(stringExtra2)) == null) {
                        return;
                    }
                    MyReceiver.a(b.classLoader, this.a, this.b);
                }
            } catch (Throwable unused) {
                int i3 = b.a;
            }
        }
    }
}
