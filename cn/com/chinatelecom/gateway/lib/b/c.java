package cn.com.chinatelecom.gateway.lib.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Queue;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class c implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public /* synthetic */ Context a;
    public /* synthetic */ List b;
    public /* synthetic */ int c;

    public c(Context context, List list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, Integer.valueOf(i)};
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
        this.b = list;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Queue b;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                b = b.b(this.a, this.b, this.c);
                if (b.isEmpty()) {
                    return;
                }
                b2 = b.b(this.a, b);
                JSONObject jSONObject = null;
                int i = -1;
                try {
                    if (!TextUtils.isEmpty(b2)) {
                        JSONObject jSONObject2 = new JSONObject(b2);
                        try {
                            i = jSONObject2.getInt("code");
                            jSONObject = jSONObject2;
                        } catch (Exception e) {
                            e = e;
                            jSONObject = jSONObject2;
                            e.printStackTrace();
                            if (jSONObject != null) {
                            }
                            b.a(this.a, b, this.c);
                            return;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                if (jSONObject != null || i != 0) {
                    b.a(this.a, b, this.c);
                    return;
                }
                a.a(this.a, "");
                b.clear();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
