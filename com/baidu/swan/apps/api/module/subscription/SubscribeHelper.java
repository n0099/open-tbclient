package com.baidu.swan.apps.api.module.subscription;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.n2.n;
import c.a.r0.a.s0.c;
import c.a.r0.a.z2.q;
import c.a.r0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.swan.apps.database.subscribe.SwanAppSubscribeMsgProvider;
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
/* loaded from: classes11.dex */
public class SubscribeHelper {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f38674e;
    public transient /* synthetic */ FieldHolder $fh;
    public String[] a;

    /* renamed from: b  reason: collision with root package name */
    public l f38675b;

    /* renamed from: c  reason: collision with root package name */
    public Context f38676c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.a.d2.e f38677d;

    /* loaded from: classes11.dex */
    public class a implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SubscribeHelper f38678b;

        public a(SubscribeHelper subscribeHelper, k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscribeHelper, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38678b = subscribeHelper;
            this.a = kVar;
        }

        @Override // com.baidu.swan.apps.api.module.subscription.SubscribeHelper.j
        public void a(@NonNull LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list) {
            Iterator<String> it;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, linkedHashMap, list) == null) {
                if (linkedHashMap != null && linkedHashMap.size() != 0) {
                    if (SubscribeHelper.f38674e) {
                        while (linkedHashMap.keySet().iterator().hasNext()) {
                            String str = "querySubscribeInfo unallowedTemplateId=" + it.next();
                        }
                    }
                    SubscribeHelper subscribeHelper = this.f38678b;
                    subscribeHelper.s(subscribeHelper.f38675b, linkedHashMap, list, this.a);
                    return;
                }
                SubscribeHelper subscribeHelper2 = this.f38678b;
                subscribeHelper2.r(subscribeHelper2.f38675b, Arrays.asList(this.f38678b.a), this.a);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f38679e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String[] f38680f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f38681g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ SubscribeHelper f38682h;

        public b(SubscribeHelper subscribeHelper, String str, String[] strArr, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscribeHelper, str, strArr, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38682h = subscribeHelper;
            this.f38679e = str;
            this.f38680f = strArr;
            this.f38681g = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String[] strArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HashMap hashMap = new HashMap();
                if (SubscribeHelper.l()) {
                    Cursor query = this.f38682h.f38676c.getContentResolver().query(SwanAppSubscribeMsgProvider.CONTENT_URI, new String[]{"templateId", "result"}, "appKey=?", new String[]{this.f38679e}, null);
                    if (query != null && query.getCount() > 0 && query.moveToFirst()) {
                        do {
                            hashMap.put(query.getString(query.getColumnIndex("templateId")), Integer.valueOf(query.getInt(query.getColumnIndex("result"))));
                        } while (query.moveToNext());
                        c.a.r0.w.d.d(query);
                    }
                }
                LinkedHashMap<String, Boolean> linkedHashMap = new LinkedHashMap<>();
                ArrayList arrayList = new ArrayList();
                for (String str : this.f38680f) {
                    Integer num = (Integer) hashMap.get(str);
                    if (num == null) {
                        linkedHashMap.put(str, Boolean.FALSE);
                    } else if (num.intValue() != 1) {
                        linkedHashMap.put(str, Boolean.TRUE);
                    } else {
                        arrayList.add(str);
                    }
                }
                this.f38681g.a(linkedHashMap, arrayList);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedHashMap f38683b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l f38684c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f38685d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SubscribeHelper f38686e;

        /* loaded from: classes11.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ List f38687e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f38688f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ c f38689g;

            public a(c cVar, List list, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, list, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f38689g = cVar;
                this.f38687e = list;
                this.f38688f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ContentResolver contentResolver = this.f38689g.f38686e.f38676c.getContentResolver();
                    for (c.a.r0.a.s0.d dVar : this.f38687e) {
                        String str = dVar.a;
                        Boolean bool = (Boolean) this.f38689g.f38683b.get(str);
                        if (bool != null && !bool.booleanValue()) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("appKey", this.f38689g.f38684c.a);
                            contentValues.put("templateId", str);
                            contentValues.put("result", (Integer) 0);
                            contentValues.put("title", dVar.f8908b);
                            contentValues.put("tips", this.f38688f);
                            contentResolver.insert(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues);
                        }
                    }
                }
            }
        }

        /* loaded from: classes11.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f38690e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f38691f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ c f38692g;

            public b(c cVar, String str, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, str, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f38692g = cVar;
                this.f38690e = str;
                this.f38691f = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c cVar = this.f38692g;
                    cVar.f38686e.u(cVar.f38684c, this.f38690e, this.f38691f, cVar.f38685d, cVar.a);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38686e = subscribeHelper;
            this.a = kVar;
            this.f38683b = linkedHashMap;
            this.f38684c = lVar;
            this.f38685d = list;
        }

        @Override // com.baidu.swan.apps.api.module.subscription.SubscribeHelper.i
        public void a(@Nullable String str, List<c.a.r0.a.s0.d> list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, str, list, z) == null) {
                if (!TextUtils.isEmpty(str) && list != null && list.size() > 0) {
                    q.k(new a(this, list, str), "createFormDataBase");
                    if (z && this.f38684c.f38715e) {
                        this.f38686e.m(this.f38684c, str, list, this.f38685d, this.a);
                        return;
                    } else {
                        q0.a0(new b(this, str, list));
                        return;
                    }
                }
                this.a.a(500104, "请求模板内容失败", null);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d implements c.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f38693b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f38694c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f38695d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f38696e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SubscribeHelper f38697f;

        public d(SubscribeHelper subscribeHelper, l lVar, List list, String str, List list2, k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscribeHelper, lVar, list, str, list2, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38697f = subscribeHelper;
            this.a = lVar;
            this.f38693b = list;
            this.f38694c = str;
            this.f38695d = list2;
            this.f38696e = kVar;
        }

        @Override // c.a.r0.a.s0.c.f
        public boolean a(DialogInterface dialogInterface, int i2, List<c.a.r0.a.s0.d> list) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i2, list)) == null) {
                boolean z = i2 == -1;
                if (SubscribeHelper.f38674e) {
                    String str = "showSubscribeDialog isPositive=" + z;
                }
                if (z && list.size() == 0) {
                    return false;
                }
                this.f38697f.q(z ? "permit_click" : "reject_click", this.a.f38714d, this.f38693b, list);
                if (z) {
                    this.f38697f.m(this.a, this.f38694c, list, this.f38695d, this.f38696e);
                    return true;
                }
                if (SubscribeHelper.l()) {
                    this.f38697f.w(this.a.a, list, this.f38694c, false);
                }
                this.f38697f.t();
                this.f38696e.a(500102, "用户单次拒绝授权", null);
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public class e implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f38698e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SubscribeHelper f38699f;

        public e(SubscribeHelper subscribeHelper, k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscribeHelper, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38699f = subscribeHelper;
            this.f38698e = kVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f38699f.t();
                this.f38698e.a(500103, "用户取消授权", null);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class f implements c.a.r0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f38700e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l f38701f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f38702g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ List f38703h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ List f38704i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ k f38705j;
        public final /* synthetic */ SubscribeHelper k;

        public f(SubscribeHelper subscribeHelper, boolean z, l lVar, String str, List list, List list2, k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscribeHelper, Boolean.valueOf(z), lVar, str, list, list2, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = subscribeHelper;
            this.f38700e = z;
            this.f38701f = lVar;
            this.f38702g = str;
            this.f38703h = list;
            this.f38704i = list2;
            this.f38705j = kVar;
        }

        @Override // c.a.r0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    if (!this.f38700e && SubscribeHelper.l()) {
                        n.S("success", 12, "component");
                    }
                    this.k.v(this.f38701f, this.f38702g, this.f38703h, this.f38704i, this.f38705j);
                    return;
                }
                if (!this.f38700e && !SubscribeHelper.l()) {
                    n.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 12, "component");
                }
                this.k.t();
                this.f38705j.a(500106, "用户未登录", null);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f38706e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f38707f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f38708g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f38709h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ SubscribeHelper f38710i;

        public g(SubscribeHelper subscribeHelper, List list, String str, boolean z, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscribeHelper, list, str, Boolean.valueOf(z), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38710i = subscribeHelper;
            this.f38706e = list;
            this.f38707f = str;
            this.f38708g = z;
            this.f38709h = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ContentResolver contentResolver = this.f38710i.f38676c.getContentResolver();
                for (c.a.r0.a.s0.d dVar : this.f38706e) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("title", dVar.f8908b);
                    contentValues.put("tips", this.f38707f);
                    contentValues.put("result", Integer.valueOf(this.f38708g ? 1 : -1));
                    contentResolver.update(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues, "appKey=? and templateId=?", new String[]{this.f38709h, dVar.a});
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class h implements c.a.r0.a.s0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SubscribeHelper f38711b;

        public h(SubscribeHelper subscribeHelper, k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscribeHelper, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38711b = subscribeHelper;
            this.a = kVar;
        }

        @Override // c.a.r0.a.a2.a
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f38711b.t();
                this.a.a(0, "调用成功", jSONObject);
                if (c.a.r0.a.c1.a.h0().e(this.f38711b.f38676c)) {
                    c.a.r0.a.a2.c.f5322c.e();
                } else {
                    c.a.r0.a.a2.c.f5322c.f();
                }
            }
        }

        @Override // c.a.r0.a.a2.a
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.a(500105, "请求formId失败", null);
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface i {
        void a(@Nullable String str, @Nullable List<c.a.r0.a.s0.d> list, boolean z);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
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

        public invokeSubscribeFrom(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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

    /* loaded from: classes11.dex */
    public interface j {
        void a(@NonNull LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list);
    }

    /* loaded from: classes11.dex */
    public interface k {
        void a(int i2, @NonNull String str, JSONObject jSONObject);
    }

    /* loaded from: classes11.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final String a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public final String f38712b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f38713c;

        /* renamed from: d  reason: collision with root package name */
        public String f38714d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f38715e;

        public l(@NonNull String str, @NonNull String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f38712b = str2;
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
        f38674e = c.a.r0.a.k.a;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? c.a.r0.a.d2.d.J().r().M().e(c.a.r0.a.c1.a.c()) : invokeV.booleanValue;
    }

    public final JSONArray k(List<c.a.r0.a.s0.d> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (list != null && list.size() > 0) {
                for (c.a.r0.a.s0.d dVar : list) {
                    jSONArray.put(dVar.f8908b);
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public final void m(@NonNull l lVar, String str, @NonNull List<c.a.r0.a.s0.d> list, @NonNull List<String> list2, @NonNull k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar, str, list, list2, kVar) == null) {
            boolean l2 = l();
            if (l()) {
                v(lVar, str, list, list2, kVar);
                return;
            }
            if (!l2) {
                n.S("show", 12, "component");
            }
            c.a.r0.a.d2.d.J().r().M().f(c.a.r0.a.g1.f.U().getActivity(), null, new f(this, l2, lVar, str, list, list2, kVar));
        }
    }

    public boolean n(Context context, c.a.r0.a.d2.e eVar, String str, JSONObject jSONObject, invokeSubscribeFrom invokesubscribefrom, k kVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, eVar, str, jSONObject, invokesubscribefrom, kVar})) == null) {
            this.f38676c = context;
            this.f38677d = eVar;
            String optString = jSONObject.optString("subscribeId");
            if (TextUtils.isEmpty(optString)) {
                kVar.a(202, "subscribeId is empty", null);
                return false;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("templateId");
            l lVar = new l(str, optString);
            this.f38675b = lVar;
            lVar.f38713c = optJSONArray == null;
            if (this.f38675b.f38713c) {
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
                this.f38675b.f38714d = jSONObject.optString("invokeFrom", RetrieveTaskManager.KEY);
            } else {
                this.f38675b.f38714d = jSONObject.optString("invokeFrom", "form");
            }
            this.f38675b.f38715e = jSONObject.optBoolean("skipSubscribeAuthorize");
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
            q.k(new b(this, str, strArr, jVar), "querySubscribeInfo");
        }
    }

    public final void q(String str, String str2, List<c.a.r0.a.s0.d> list, List<c.a.r0.a.s0.d> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, str, str2, list, list2) == null) {
            c.a.r0.a.n2.s.e eVar = new c.a.r0.a.n2.s.e();
            eVar.a = "swan";
            eVar.f8119b = str;
            eVar.f8124g = str2;
            if (list2 != null) {
                eVar.f8122e = String.valueOf(list2.size());
            }
            eVar.a("appkey", this.f38677d.getAppId());
            eVar.a("tpl", k(list));
            eVar.a("selected_tpl", k(list2));
            if (f38674e) {
                String str3 = "event: " + eVar.f();
            }
            n.y("1311", "92", eVar);
        }
    }

    public final void r(@NonNull l lVar, @NonNull List<String> list, @NonNull k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, lVar, list, kVar) == null) {
            c.a.r0.a.c1.a.W().d(lVar.a, list, lVar.f38712b, lVar.f38713c, new h(this, kVar));
        }
    }

    @AnyThread
    public final void s(@NonNull l lVar, LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, lVar, linkedHashMap, list, kVar) == null) {
            c.a.r0.a.c1.a.W().b(lVar.a, linkedHashMap.keySet(), new c(this, kVar, linkedHashMap, lVar, list));
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.r0.a.d2.d.J().r().V().X0("0");
        }
    }

    public final void u(@NonNull l lVar, String str, List<c.a.r0.a.s0.d> list, @NonNull List<String> list2, @NonNull k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048585, this, lVar, str, list, list2, kVar) == null) {
            c.a.r0.a.s0.c.a((Activity) this.f38676c, this.f38677d, str, list, new d(this, lVar, list, str, list2, kVar), new e(this, kVar)).show();
            q("show", lVar.f38714d, list, list);
        }
    }

    public final void v(@NonNull l lVar, String str, @NonNull List<c.a.r0.a.s0.d> list, @NonNull List<String> list2, @NonNull k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048586, this, lVar, str, list, list2, kVar) == null) {
            w(lVar.a, list, str, true);
            for (c.a.r0.a.s0.d dVar : list) {
                list2.add(dVar.a);
            }
            r(lVar, list2, kVar);
        }
    }

    public final void w(String str, List<c.a.r0.a.s0.d> list, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, list, str2, Boolean.valueOf(z)}) == null) {
            q.g().execute(new g(this, list, str2, z, str));
        }
    }
}
