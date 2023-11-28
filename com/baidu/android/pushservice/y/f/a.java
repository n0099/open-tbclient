package com.baidu.android.pushservice.y.f;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.a0.i;
import com.baidu.android.pushservice.j;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.l.d;
import com.baidu.android.pushservice.pull.ClientEventInfo;
import com.baidu.android.pushservice.pull.reportdata.EventData;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.android.pushservice.y.e.f;
import com.baidu.android.pushservice.y.e.g;
import com.baidu.android.pushservice.y.e.h;
import com.baidu.android.pushservice.z.c;
import com.baidu.android.pushservice.z.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.pushservice.y.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0044a extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context c;
        public final /* synthetic */ List d;

        /* renamed from: com.baidu.android.pushservice.y.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0045a implements Callback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0045a(C0044a c0044a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0044a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                    String str = "Request error :" + iOException.getMessage();
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                }
            }
        }

        public C0044a(Context context, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = context;
            this.d = list;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (d.d(this.c)) {
                        com.baidu.android.pushservice.y.a.a(this.c).a(a.c(this.c, this.d), a.e(this.c), new C0045a(this));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public static long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? (System.currentTimeMillis() & 2147483647L) | (-2147483648L) : invokeV.longValue;
    }

    public static void a(Context context, ClientEventInfo clientEventInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, context, clientEventInfo) == null) || context == null || clientEventInfo == null || clientEventInfo.getSource() != 3) {
            return;
        }
        a(context, new EventData("widget_start", clientEventInfo.getAction()));
    }

    public static void a(Context context, EventData eventData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, context, eventData) == null) || context == null || eventData == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(eventData);
        d(context, arrayList);
    }

    public static ByteString b(Context context, List<EventData> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, list)) == null) {
            g.b i = g.Z().d(b(context)).b(3).e(Utility.a(context, false)).g(context.getPackageName()).a(c(context)).c(d(context)).b(Utility.A(context)).c(Utility.p(context)).f(Build.VERSION.RELEASE).i(Utility.y(context));
            for (EventData eventData : list) {
                i.a(h.h().a(eventData.a()).b(eventData.b()).build());
            }
            return ByteString.copyFrom(i.build().toByteArray());
        }
        return (ByteString) invokeLL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            String a = j.a(context).a();
            return TextUtils.isEmpty(a) ? i.c(context, "cid") : a;
        }
        return (String) invokeL.objValue;
    }

    public static ByteString c(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cuid", DeviceId.getCUID(context));
                str = Base64.encodeToString(BaiduAppSSOJni.encryptAES(jSONObject.toString(), 1), 2);
            } catch (Exception unused) {
                str = "";
            }
            return ByteString.copyFromUtf8(str);
        }
        return (ByteString) invokeL.objValue;
    }

    public static byte[] c(Context context, List<EventData> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, list)) == null) {
            return f.x().b(com.baidu.android.pushservice.w.h.j.a()).d(com.baidu.android.pushservice.a.a()).a(a()).a(Utility.n(context, context.getPackageName()) ? "BaiduApp" : "DevApp").a(-76508268).c(3).a(b(context, list)).build().toByteArray();
        }
        return (byte[]) invokeLL.objValue;
    }

    public static int d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cuid", DeviceId.getCUID(context));
                return jSONObject.toString().length();
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static void d(Context context, List<EventData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, context, list) == null) || context == null || list == null || list.isEmpty()) {
            return;
        }
        e.a().a(new C0044a(context, list));
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            com.baidu.android.pushservice.g.d(context);
            return com.baidu.android.pushservice.g.d() + "/datareport";
        }
        return (String) invokeL.objValue;
    }
}
