package c.q.a;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes9.dex */
public final class p5 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ t5 f30435e;

    public p5(t5 t5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30435e = t5Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str = "";
            HashMap b2 = h5.b(this.f30435e.a);
            b2.put("pid", this.f30435e.f30493b);
            x5.c(this.f30435e, b2);
            t5 t5Var = this.f30435e;
            char c2 = 0;
            try {
                String[] split = m2.J(t5Var.a).split(",");
                ArrayList<n3> arrayList = new ArrayList();
                arrayList.clear();
                int length = split.length;
                int i2 = 0;
                while (i2 < length) {
                    String[] split2 = split[i2].split(":");
                    String str2 = split2[c2];
                    String str3 = split2[1];
                    if (System.currentTimeMillis() - Long.parseLong(str3) < m2.H(t5Var.a)) {
                        n3 n3Var = new n3();
                        n3Var.a = str2;
                        n3Var.f30413b = Long.parseLong(str3);
                        arrayList.add(n3Var);
                    }
                    i2++;
                    c2 = 0;
                }
                if (!arrayList.isEmpty()) {
                    String str4 = "";
                    String str5 = str4;
                    for (n3 n3Var2 : arrayList) {
                        str4 = str4 + n3Var2.a + ",";
                        str5 = str5 + n3Var2.a + ":" + n3Var2.f30413b + ",";
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        b2.put("a605", str4.substring(0, str4.length() - 1));
                    }
                    if (!TextUtils.isEmpty(str5)) {
                        m2.m(t5Var.a, str5.substring(0, str5.length() - 1), true);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            t5 t5Var2 = this.f30435e;
            try {
                String[] split3 = m2.I(t5Var2.a).split(",");
                ArrayList<n3> arrayList2 = new ArrayList();
                arrayList2.clear();
                for (String str6 : split3) {
                    String[] split4 = str6.split(":");
                    String str7 = split4[0];
                    String str8 = split4[1];
                    if (System.currentTimeMillis() - Long.parseLong(str8) <= m2.H(t5Var2.a)) {
                        n3 n3Var3 = new n3();
                        n3Var3.a = str7;
                        n3Var3.f30413b = Long.parseLong(str8);
                        arrayList2.add(n3Var3);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    String str9 = "";
                    String str10 = str9;
                    for (n3 n3Var4 : arrayList2) {
                        str9 = str9 + n3Var4.a + ",";
                        str10 = str10 + n3Var4.a + ":" + n3Var4.f30413b + ",";
                    }
                    if (!TextUtils.isEmpty(str9)) {
                        b2.put("a601", str9.substring(0, str9.length() - 1));
                    }
                    if (!TextUtils.isEmpty(str10)) {
                        m2.g(t5Var2.a, str10.substring(0, str10.length() - 1), true);
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                str = this.f30435e.f30494c + h5.a(b2);
            } catch (UnsupportedEncodingException unused) {
            }
            r0.s(str, null, new l5(this));
        }
    }
}
