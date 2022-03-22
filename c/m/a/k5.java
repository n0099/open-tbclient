package c.m.a;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class k5 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ o5 a;

    public k5(o5 o5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {o5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = o5Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str = "";
            HashMap b2 = c5.b(this.a.a);
            b2.put("pid", this.a.f23523b);
            s5.c(this.a, b2);
            o5 o5Var = this.a;
            char c2 = 0;
            try {
                String[] split = h2.J(o5Var.a).split(",");
                ArrayList<i3> arrayList = new ArrayList();
                arrayList.clear();
                int length = split.length;
                int i = 0;
                while (i < length) {
                    String[] split2 = split[i].split(":");
                    String str2 = split2[c2];
                    String str3 = split2[1];
                    if (System.currentTimeMillis() - Long.parseLong(str3) < h2.H(o5Var.a)) {
                        i3 i3Var = new i3();
                        i3Var.a = str2;
                        i3Var.f23458b = Long.parseLong(str3);
                        arrayList.add(i3Var);
                    }
                    i++;
                    c2 = 0;
                }
                if (!arrayList.isEmpty()) {
                    String str4 = "";
                    String str5 = str4;
                    for (i3 i3Var2 : arrayList) {
                        str4 = str4 + i3Var2.a + ",";
                        str5 = str5 + i3Var2.a + ":" + i3Var2.f23458b + ",";
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        b2.put("a605", str4.substring(0, str4.length() - 1));
                    }
                    if (!TextUtils.isEmpty(str5)) {
                        h2.m(o5Var.a, str5.substring(0, str5.length() - 1), true);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            o5 o5Var2 = this.a;
            try {
                String[] split3 = h2.I(o5Var2.a).split(",");
                ArrayList<i3> arrayList2 = new ArrayList();
                arrayList2.clear();
                for (String str6 : split3) {
                    String[] split4 = str6.split(":");
                    String str7 = split4[0];
                    String str8 = split4[1];
                    if (System.currentTimeMillis() - Long.parseLong(str8) <= h2.H(o5Var2.a)) {
                        i3 i3Var3 = new i3();
                        i3Var3.a = str7;
                        i3Var3.f23458b = Long.parseLong(str8);
                        arrayList2.add(i3Var3);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    String str9 = "";
                    String str10 = str9;
                    for (i3 i3Var4 : arrayList2) {
                        str9 = str9 + i3Var4.a + ",";
                        str10 = str10 + i3Var4.a + ":" + i3Var4.f23458b + ",";
                    }
                    if (!TextUtils.isEmpty(str9)) {
                        b2.put("a601", str9.substring(0, str9.length() - 1));
                    }
                    if (!TextUtils.isEmpty(str10)) {
                        h2.g(o5Var2.a, str10.substring(0, str10.length() - 1), true);
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                str = this.a.f23524c + c5.a(b2);
            } catch (UnsupportedEncodingException unused) {
            }
            r0.s(str, null, new g5(this));
        }
    }
}
