package com.baidu.swan.apps.api.module.subscription;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.swan.apps.database.subscribe.SwanAppSubscribeMsgProvider;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ea3;
import com.baidu.tieba.fg2;
import com.baidu.tieba.fg3;
import com.baidu.tieba.fh3;
import com.baidu.tieba.gg2;
import com.baidu.tieba.hg2;
import com.baidu.tieba.k33;
import com.baidu.tieba.l33;
import com.baidu.tieba.na3;
import com.baidu.tieba.pj4;
import com.baidu.tieba.r13;
import com.baidu.tieba.sm2;
import com.baidu.tieba.vj1;
import com.baidu.tieba.xj1;
import com.baidu.tieba.yo2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SubscribeHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public String[] a;
    public l b;
    public Context c;
    public l33 d;

    /* loaded from: classes2.dex */
    public class a implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;
        public final /* synthetic */ SubscribeHelper b;

        public a(SubscribeHelper subscribeHelper, k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscribeHelper, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = subscribeHelper;
            this.a = kVar;
        }

        @Override // com.baidu.swan.apps.api.module.subscription.SubscribeHelper.j
        public void a(@NonNull LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, linkedHashMap, list) == null) {
                if (linkedHashMap != null && linkedHashMap.size() != 0) {
                    if (SubscribeHelper.e) {
                        Iterator<String> it = linkedHashMap.keySet().iterator();
                        while (it.hasNext()) {
                            Log.i("SubscribeHelper", "querySubscribeInfo unallowedTemplateId=" + it.next());
                        }
                    }
                    SubscribeHelper subscribeHelper = this.b;
                    subscribeHelper.s(subscribeHelper.b, linkedHashMap, list, this.a);
                    return;
                }
                SubscribeHelper subscribeHelper2 = this.b;
                subscribeHelper2.r(subscribeHelper2.b, Arrays.asList(this.b.a), this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String[] b;
        public final /* synthetic */ j c;
        public final /* synthetic */ SubscribeHelper d;

        public b(SubscribeHelper subscribeHelper, String str, String[] strArr, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscribeHelper, str, strArr, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = subscribeHelper;
            this.a = str;
            this.b = strArr;
            this.c = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String[] strArr;
            Cursor query;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HashMap hashMap = new HashMap();
                if (SubscribeHelper.l() && (query = this.d.c.getContentResolver().query(SwanAppSubscribeMsgProvider.c, new String[]{"templateId", TiebaStatic.LogFields.RESULT}, "appKey=?", new String[]{this.a}, null)) != null && query.getCount() > 0 && query.moveToFirst()) {
                    do {
                        hashMap.put(query.getString(query.getColumnIndex("templateId")), Integer.valueOf(query.getInt(query.getColumnIndex(TiebaStatic.LogFields.RESULT))));
                    } while (query.moveToNext());
                    pj4.d(query);
                }
                LinkedHashMap<String, Boolean> linkedHashMap = new LinkedHashMap<>();
                ArrayList arrayList = new ArrayList();
                for (String str : this.b) {
                    Integer num = (Integer) hashMap.get(str);
                    if (num == null) {
                        linkedHashMap.put(str, Boolean.FALSE);
                    } else if (num.intValue() != 1) {
                        linkedHashMap.put(str, Boolean.TRUE);
                    } else {
                        arrayList.add(str);
                    }
                }
                this.c.a(linkedHashMap, arrayList);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;
        public final /* synthetic */ LinkedHashMap b;
        public final /* synthetic */ l c;
        public final /* synthetic */ List d;
        public final /* synthetic */ SubscribeHelper e;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ List a;
            public final /* synthetic */ String b;
            public final /* synthetic */ c c;

            public a(c cVar, List list, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, list, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = cVar;
                this.a = list;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ContentResolver contentResolver = this.c.e.c.getContentResolver();
                    for (hg2 hg2Var : this.a) {
                        String str = hg2Var.a;
                        Boolean bool = (Boolean) this.c.b.get(str);
                        if (bool != null && !bool.booleanValue()) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("appKey", this.c.c.a);
                            contentValues.put("templateId", str);
                            contentValues.put(TiebaStatic.LogFields.RESULT, (Integer) 0);
                            contentValues.put("title", hg2Var.b);
                            contentValues.put("tips", this.b);
                            contentResolver.insert(SwanAppSubscribeMsgProvider.c, contentValues);
                        }
                    }
                }
            }
        }

        /* loaded from: classes2.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ List b;
            public final /* synthetic */ c c;

            public b(c cVar, String str, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, str, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = cVar;
                this.a = str;
                this.b = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c cVar = this.c;
                    cVar.e.u(cVar.c, this.a, this.b, cVar.d, cVar.a);
                }
            }
        }

        public c(SubscribeHelper subscribeHelper, k kVar, LinkedHashMap linkedHashMap, l lVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscribeHelper, kVar, linkedHashMap, lVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = subscribeHelper;
            this.a = kVar;
            this.b = linkedHashMap;
            this.c = lVar;
            this.d = list;
        }

        @Override // com.baidu.swan.apps.api.module.subscription.SubscribeHelper.i
        public void a(@Nullable String str, List<hg2> list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, str, list, z) == null) {
                if (!TextUtils.isEmpty(str) && list != null && list.size() > 0) {
                    fg3.k(new a(this, list, str), "createFormDataBase");
                    if (z && this.c.e) {
                        this.e.m(this.c, str, list, this.d, this.a);
                        return;
                    } else {
                        fh3.a0(new b(this, str, list));
                        return;
                    }
                }
                this.a.a(500104, "请求模板内容失败", null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements gg2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;
        public final /* synthetic */ List b;
        public final /* synthetic */ String c;
        public final /* synthetic */ List d;
        public final /* synthetic */ k e;
        public final /* synthetic */ SubscribeHelper f;

        public d(SubscribeHelper subscribeHelper, l lVar, List list, String str, List list2, k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscribeHelper, lVar, list, str, list2, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = subscribeHelper;
            this.a = lVar;
            this.b = list;
            this.c = str;
            this.d = list2;
            this.e = kVar;
        }

        @Override // com.baidu.tieba.gg2.f
        public boolean a(DialogInterface dialogInterface, int i, List<hg2> list) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i, list)) == null) {
                boolean z = i == -1;
                if (SubscribeHelper.e) {
                    Log.i("SubscribeHelper", "showSubscribeDialog isPositive=" + z);
                }
                if (z && list.size() == 0) {
                    return false;
                }
                this.f.q(z ? "permit_click" : "reject_click", this.a.d, this.b, list);
                if (z) {
                    this.f.m(this.a, this.c, list, this.d, this.e);
                    return true;
                }
                if (SubscribeHelper.l()) {
                    this.f.w(this.a.a, list, this.c, false);
                }
                this.f.t();
                this.e.a(500102, "用户单次拒绝授权", null);
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class e implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;
        public final /* synthetic */ SubscribeHelper b;

        public e(SubscribeHelper subscribeHelper, k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscribeHelper, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = subscribeHelper;
            this.a = kVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.b.t();
                this.a.a(500103, "用户取消授权", null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements xj1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ l b;
        public final /* synthetic */ String c;
        public final /* synthetic */ List d;
        public final /* synthetic */ List e;
        public final /* synthetic */ k f;
        public final /* synthetic */ SubscribeHelper g;

        public f(SubscribeHelper subscribeHelper, boolean z, l lVar, String str, List list, List list2, k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscribeHelper, Boolean.valueOf(z), lVar, str, list, list2, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = subscribeHelper;
            this.a = z;
            this.b = lVar;
            this.c = str;
            this.d = list;
            this.e = list2;
            this.f = kVar;
        }

        @Override // com.baidu.tieba.xj1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    if (!this.a && SubscribeHelper.l()) {
                        ea3.S("success", 12, NativeConstants.COMPONENT);
                    }
                    this.g.v(this.b, this.c, this.d, this.e, this.f);
                    return;
                }
                if (!this.a && !SubscribeHelper.l()) {
                    ea3.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 12, NativeConstants.COMPONENT);
                }
                this.g.t();
                this.f.a(500106, "用户未登录", null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ String d;
        public final /* synthetic */ SubscribeHelper e;

        public g(SubscribeHelper subscribeHelper, List list, String str, boolean z, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscribeHelper, list, str, Boolean.valueOf(z), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = subscribeHelper;
            this.a = list;
            this.b = str;
            this.c = z;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ContentResolver contentResolver = this.e.c.getContentResolver();
                for (hg2 hg2Var : this.a) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("title", hg2Var.b);
                    contentValues.put("tips", this.b);
                    contentValues.put(TiebaStatic.LogFields.RESULT, Integer.valueOf(this.c ? 1 : -1));
                    contentResolver.update(SwanAppSubscribeMsgProvider.c, contentValues, "appKey=? and templateId=?", new String[]{this.d, hg2Var.a});
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements fg2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;
        public final /* synthetic */ SubscribeHelper b;

        public h(SubscribeHelper subscribeHelper, k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscribeHelper, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = subscribeHelper;
            this.a = kVar;
        }

        @Override // com.baidu.tieba.p13
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.b.t();
                this.a.a(0, "调用成功", jSONObject);
                if (sm2.h0().e(this.b.c)) {
                    r13.c.e();
                } else {
                    r13.c.f();
                }
            }
        }

        @Override // com.baidu.tieba.p13
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.a(500105, "请求formId失败", null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface i {
        void a(@Nullable String str, @Nullable List<hg2> list, boolean z);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class invokeSubscribeFrom {
        public static final /* synthetic */ invokeSubscribeFrom[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final invokeSubscribeFrom GET_FORM_ID_BUTTON;
        public static final invokeSubscribeFrom REQUEST_SUBSCRIBE_FORM_ID_API;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1283044836, "Lcom/baidu/swan/apps/api/module/subscription/SubscribeHelper$invokeSubscribeFrom;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1283044836, "Lcom/baidu/swan/apps/api/module/subscription/SubscribeHelper$invokeSubscribeFrom;");
                    return;
                }
            }
            GET_FORM_ID_BUTTON = new invokeSubscribeFrom("GET_FORM_ID_BUTTON", 0);
            invokeSubscribeFrom invokesubscribefrom = new invokeSubscribeFrom("REQUEST_SUBSCRIBE_FORM_ID_API", 1);
            REQUEST_SUBSCRIBE_FORM_ID_API = invokesubscribefrom;
            $VALUES = new invokeSubscribeFrom[]{GET_FORM_ID_BUTTON, invokesubscribefrom};
        }

        public invokeSubscribeFrom(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static invokeSubscribeFrom valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (invokeSubscribeFrom) Enum.valueOf(invokeSubscribeFrom.class, str) : (invokeSubscribeFrom) invokeL.objValue;
        }

        public static invokeSubscribeFrom[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (invokeSubscribeFrom[]) $VALUES.clone() : (invokeSubscribeFrom[]) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public interface j {
        void a(@NonNull LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list);
    }

    /* loaded from: classes2.dex */
    public interface k {
        void a(int i, @NonNull String str, JSONObject jSONObject);
    }

    /* loaded from: classes2.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final String a;
        @NonNull
        public final String b;
        public boolean c;
        public String d;
        public boolean e;

        public l(@NonNull String str, @NonNull String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-749146764, "Lcom/baidu/swan/apps/api/module/subscription/SubscribeHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-749146764, "Lcom/baidu/swan/apps/api/module/subscription/SubscribeHelper;");
                return;
            }
        }
        e = vj1.a;
    }

    public SubscribeHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? k33.K().q().N().e(sm2.c()) : invokeV.booleanValue;
    }

    public final JSONArray k(List<hg2> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (list != null && list.size() > 0) {
                for (hg2 hg2Var : list) {
                    jSONArray.put(hg2Var.b);
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public final void m(@NonNull l lVar, String str, @NonNull List<hg2> list, @NonNull List<String> list2, @NonNull k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar, str, list, list2, kVar) == null) {
            boolean l2 = l();
            if (l()) {
                v(lVar, str, list, list2, kVar);
                return;
            }
            if (!l2) {
                ea3.S("show", 12, NativeConstants.COMPONENT);
            }
            k33.K().q().N().f(yo2.U().getActivity(), null, new f(this, l2, lVar, str, list, list2, kVar));
        }
    }

    public boolean n(Context context, l33 l33Var, String str, JSONObject jSONObject, invokeSubscribeFrom invokesubscribefrom, k kVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, l33Var, str, jSONObject, invokesubscribefrom, kVar})) == null) {
            this.c = context;
            this.d = l33Var;
            String optString = jSONObject.optString("subscribeId");
            if (TextUtils.isEmpty(optString)) {
                kVar.a(202, "subscribeId is empty", null);
                return false;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("templateId");
            l lVar = new l(str, optString);
            this.b = lVar;
            lVar.c = optJSONArray == null;
            if (this.b.c) {
                String optString2 = jSONObject.optString("templateId");
                if (!TextUtils.isEmpty(optString2) && invokesubscribefrom != invokeSubscribeFrom.REQUEST_SUBSCRIBE_FORM_ID_API) {
                    this.a = new String[]{optString2};
                } else {
                    kVar.a(202, "templateId is empty", null);
                    return false;
                }
            } else {
                int length = optJSONArray.length();
                if (length >= 1 && length <= 3) {
                    this.a = new String[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        this.a[i2] = optJSONArray.optString(i2);
                    }
                } else {
                    kVar.a(202, "length is invalid", null);
                    return false;
                }
            }
            if (invokesubscribefrom == invokeSubscribeFrom.REQUEST_SUBSCRIBE_FORM_ID_API) {
                this.b.d = jSONObject.optString("invokeFrom", "api");
            } else {
                this.b.d = jSONObject.optString("invokeFrom", IMConstants.SERVICE_TYPE_FORM);
            }
            this.b.e = jSONObject.optBoolean("skipSubscribeAuthorize");
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void o(String str, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, kVar) == null) {
            p(str, this.a, new a(this, kVar));
        }
    }

    @AnyThread
    public final void p(String str, String[] strArr, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, strArr, jVar) == null) {
            fg3.k(new b(this, str, strArr, jVar), "querySubscribeInfo");
        }
    }

    public final void q(String str, String str2, List<hg2> list, List<hg2> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, str, str2, list, list2) == null) {
            na3 na3Var = new na3();
            na3Var.a = "swan";
            na3Var.b = str;
            na3Var.g = str2;
            if (list2 != null) {
                na3Var.e = String.valueOf(list2.size());
            }
            na3Var.a("appkey", this.d.getAppId());
            na3Var.a("tpl", k(list));
            na3Var.a("selected_tpl", k(list2));
            if (e) {
                Log.d("SubscribeHelper", "event: " + na3Var.f());
            }
            ea3.y("1311", "92", na3Var);
        }
    }

    public final void r(@NonNull l lVar, @NonNull List<String> list, @NonNull k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, lVar, list, kVar) == null) {
            sm2.W().d(lVar.a, list, lVar.b, lVar.c, new h(this, kVar));
        }
    }

    @AnyThread
    public final void s(@NonNull l lVar, LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, lVar, linkedHashMap, list, kVar) == null) {
            sm2.W().b(lVar.a, linkedHashMap.keySet(), new c(this, kVar, linkedHashMap, lVar, list));
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            k33.K().q().W().X0("0");
        }
    }

    public final void u(@NonNull l lVar, String str, List<hg2> list, @NonNull List<String> list2, @NonNull k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048585, this, lVar, str, list, list2, kVar) == null) {
            gg2.a((Activity) this.c, this.d, str, list, new d(this, lVar, list, str, list2, kVar), new e(this, kVar)).show();
            q("show", lVar.d, list, list);
        }
    }

    public final void v(@NonNull l lVar, String str, @NonNull List<hg2> list, @NonNull List<String> list2, @NonNull k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048586, this, lVar, str, list, list2, kVar) == null) {
            w(lVar.a, list, str, true);
            for (hg2 hg2Var : list) {
                list2.add(hg2Var.a);
            }
            r(lVar, list2, kVar);
        }
    }

    public final void w(String str, List<hg2> list, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, list, str2, Boolean.valueOf(z)}) == null) {
            fg3.g().execute(new g(this, list, str2, z, str));
        }
    }
}
