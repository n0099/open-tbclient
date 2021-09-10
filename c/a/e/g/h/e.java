package c.a.e.g.h;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.AbstractMap;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f2745a;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2745a = false;
    }

    public abstract String a();

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f2745a) {
            return;
        }
        this.f2745a = true;
        if (TextUtils.isEmpty(a())) {
            return;
        }
        try {
            new JSONObject().put("version", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void c(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            String a2 = a();
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new AbstractMap.SimpleEntry("version", String.valueOf(j2)));
            String str = a2 + "_download";
            if (i2 == 0) {
                d.c(str, arrayList);
            } else {
                d.b(str, arrayList);
            }
        }
    }

    public void d(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            String a2 = a();
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new AbstractMap.SimpleEntry("version", String.valueOf(i3)));
            String str = a2 + "_install";
            if (i2 == 13) {
                d.c(str, arrayList);
            } else {
                d.b(str, arrayList);
            }
        }
    }

    public void e(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            String a2 = a();
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new AbstractMap.SimpleEntry("version", String.valueOf(i3)));
            String str = a2 + "_launch";
            if (i2 == 14) {
                d.c(str, arrayList);
            } else {
                d.b(str, arrayList);
            }
        }
    }
}
