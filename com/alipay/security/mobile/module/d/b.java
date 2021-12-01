package com.alipay.security.mobile.module.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public File a;

    /* renamed from: b  reason: collision with root package name */
    public com.alipay.security.mobile.module.http.v2.a f31497b;

    public b(String str, com.alipay.security.mobile.module.http.v2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f31497b = null;
        this.a = new File(str);
        this.f31497b = aVar;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "id");
                jSONObject.put("error", str);
                return jSONObject.toString();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            synchronized (this) {
                File file = this.a;
                if (file == null) {
                    return;
                }
                if (file.exists() && this.a.isDirectory() && this.a.list().length != 0) {
                    ArrayList arrayList = new ArrayList();
                    for (String str : this.a.list()) {
                        arrayList.add(str);
                    }
                    Collections.sort(arrayList);
                    String str2 = (String) arrayList.get(arrayList.size() - 1);
                    int size = arrayList.size();
                    if (str2.equals(new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + ".log")) {
                        if (arrayList.size() < 2) {
                            return;
                        }
                        str2 = (String) arrayList.get(arrayList.size() - 2);
                        size--;
                    }
                    if (!this.f31497b.logCollect(a(com.alipay.security.mobile.module.a.b.a(this.a.getAbsolutePath(), str2)))) {
                        size--;
                    }
                    for (int i2 = 0; i2 < size; i2++) {
                        new File(this.a, (String) arrayList.get(i2)).delete();
                    }
                }
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            new Thread(new c(this)).start();
        }
    }
}
