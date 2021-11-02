package b.a.p0.a.s0;

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
import b.a.p0.a.c2.f.a0;
import b.a.p0.a.s0.c;
import b.a.p0.a.v2.q;
import b.a.p0.a.v2.q0;
import b.a.p0.a.v2.w;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.database.subscribe.SwanAppSubscribeMsgProvider;
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
/* loaded from: classes.dex */
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Context f7788c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.p0.a.a2.e f7789d;

    /* renamed from: e  reason: collision with root package name */
    public CallbackHandler f7790e;

    /* renamed from: b.a.p0.a.s0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0363a implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f7791a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f7792b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f7793c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f7794d;

        public C0363a(a aVar, l lVar, String[] strArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, lVar, strArr, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7794d = aVar;
            this.f7791a = lVar;
            this.f7792b = strArr;
            this.f7793c = str;
        }

        @Override // b.a.p0.a.s0.a.k
        public void a(@NonNull LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list) {
            Iterator<String> it;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, linkedHashMap, list) == null) {
                if (linkedHashMap == null || linkedHashMap.size() == 0) {
                    this.f7794d.B(this.f7791a, Arrays.asList(this.f7792b), this.f7793c);
                    return;
                }
                this.f7794d.C(this.f7791a, this.f7793c, linkedHashMap, list);
                if (a0.f4160b) {
                    while (linkedHashMap.keySet().iterator().hasNext()) {
                        String str = "querySubscribeInfo unallowedTemplateId=" + it.next();
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7795e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String[] f7796f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f7797g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f7798h;

        public b(a aVar, String str, String[] strArr, k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, strArr, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7798h = aVar;
            this.f7795e = str;
            this.f7796f = strArr;
            this.f7797g = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String[] strArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HashMap hashMap = new HashMap();
                if (this.f7798h.w()) {
                    Cursor query = this.f7798h.f7788c.getContentResolver().query(SwanAppSubscribeMsgProvider.CONTENT_URI, new String[]{"templateId", "result"}, "appKey=?", new String[]{this.f7795e}, null);
                    if (query != null && query.getCount() > 0 && query.moveToFirst()) {
                        do {
                            hashMap.put(query.getString(query.getColumnIndex("templateId")), Integer.valueOf(query.getInt(query.getColumnIndex("result"))));
                        } while (query.moveToNext());
                        b.a.p0.t.d.d(query);
                    }
                }
                LinkedHashMap<String, Boolean> linkedHashMap = new LinkedHashMap<>();
                ArrayList arrayList = new ArrayList();
                for (String str : this.f7796f) {
                    Integer num = (Integer) hashMap.get(str);
                    if (num == null) {
                        linkedHashMap.put(str, Boolean.FALSE);
                    } else if (num.intValue() != 1) {
                        linkedHashMap.put(str, Boolean.TRUE);
                    } else {
                        arrayList.add(str);
                    }
                }
                this.f7797g.a(linkedHashMap, arrayList);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f7799a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedHashMap f7800b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l f7801c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f7802d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7803e;

        /* renamed from: b.a.p0.a.s0.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0364a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ List f7804e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f7805f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ c f7806g;

            public RunnableC0364a(c cVar, List list, String str) {
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
                this.f7806g = cVar;
                this.f7804e = list;
                this.f7805f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ContentResolver contentResolver = this.f7806g.f7803e.f7788c.getContentResolver();
                    for (b.a.p0.a.s0.d dVar : this.f7804e) {
                        String str = dVar.f7852a;
                        Boolean bool = (Boolean) this.f7806g.f7800b.get(str);
                        if (bool != null && !bool.booleanValue()) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("appKey", this.f7806g.f7801c.f7832a);
                            contentValues.put("templateId", str);
                            contentValues.put("result", (Integer) 0);
                            contentValues.put("title", dVar.f7853b);
                            contentValues.put("tips", this.f7805f);
                            contentResolver.insert(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues);
                        }
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f7807e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f7808f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ c f7809g;

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
                this.f7809g = cVar;
                this.f7807e = str;
                this.f7808f = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c cVar = this.f7809g;
                    cVar.f7803e.D(cVar.f7801c, this.f7807e, cVar.f7799a, this.f7808f, cVar.f7802d);
                }
            }
        }

        public c(a aVar, String str, LinkedHashMap linkedHashMap, l lVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, linkedHashMap, lVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7803e = aVar;
            this.f7799a = str;
            this.f7800b = linkedHashMap;
            this.f7801c = lVar;
            this.f7802d = list;
        }

        @Override // b.a.p0.a.s0.a.j
        public void a(@Nullable String str, List<b.a.p0.a.s0.d> list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, str, list, z) == null) {
                if (!TextUtils.isEmpty(str) && list != null && list.size() > 0) {
                    q.j(new RunnableC0364a(this, list, str), "createFormDataBase");
                    if (z && this.f7801c.f7836e) {
                        this.f7803e.x(this.f7801c, this.f7799a, str, list, this.f7802d);
                        return;
                    } else {
                        q0.X(new b(this, str, list));
                        return;
                    }
                }
                this.f7803e.f7790e.handleSchemeDispatchCallback(this.f7799a, UnitedSchemeUtility.wrapCallbackParams(500104, "请求模板内容失败").toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f7810a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f7811b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f7812c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f7813d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f7814e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f7815f;

        public d(a aVar, l lVar, List list, String str, String str2, List list2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, lVar, list, str, str2, list2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7815f = aVar;
            this.f7810a = lVar;
            this.f7811b = list;
            this.f7812c = str;
            this.f7813d = str2;
            this.f7814e = list2;
        }

        @Override // b.a.p0.a.s0.c.f
        public boolean a(DialogInterface dialogInterface, int i2, List<b.a.p0.a.s0.d> list) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i2, list)) == null) {
                boolean z = i2 == -1;
                if (a0.f4160b) {
                    String str = "showSubscribeDialog isPositive=" + z;
                }
                if (z && list.size() == 0) {
                    return false;
                }
                this.f7815f.z(z ? "permit_click" : "reject_click", this.f7810a.f7835d, this.f7811b, list);
                if (z) {
                    this.f7815f.x(this.f7810a, this.f7812c, this.f7813d, list, this.f7814e);
                    return true;
                }
                if (this.f7815f.w()) {
                    this.f7815f.F(this.f7810a.f7832a, list, this.f7813d, false);
                }
                this.f7815f.f7790e.handleSchemeDispatchCallback(this.f7812c, UnitedSchemeUtility.wrapCallbackParams(500102, "用户单次拒绝授权").toString());
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class e implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7816e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f7817f;

        public e(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7817f = aVar;
            this.f7816e = str;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f7817f.f7790e.handleSchemeDispatchCallback(this.f7816e, UnitedSchemeUtility.wrapCallbackParams(500103, "用户取消授权").toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements b.a.p0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f7818e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l f7819f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7820g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f7821h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ List f7822i;
        public final /* synthetic */ List j;
        public final /* synthetic */ a k;

        public f(a aVar, boolean z, l lVar, String str, String str2, List list, List list2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z), lVar, str, str2, list, list2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = aVar;
            this.f7818e = z;
            this.f7819f = lVar;
            this.f7820g = str;
            this.f7821h = str2;
            this.f7822i = list;
            this.j = list2;
        }

        @Override // b.a.p0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    if (!this.f7818e && this.k.w()) {
                        b.a.p0.a.j2.k.M("success", 12, "component");
                    }
                    this.k.E(this.f7819f, this.f7820g, this.f7821h, this.f7822i, this.j);
                    return;
                }
                if (!this.f7818e && !this.k.w()) {
                    b.a.p0.a.j2.k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 12, "component");
                }
                this.k.f7790e.handleSchemeDispatchCallback(this.f7820g, UnitedSchemeUtility.wrapCallbackParams(500106, "用户未登录").toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f7823e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7824f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f7825g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f7826h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f7827i;

        public g(a aVar, List list, String str, boolean z, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, list, str, Boolean.valueOf(z), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7827i = aVar;
            this.f7823e = list;
            this.f7824f = str;
            this.f7825g = z;
            this.f7826h = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ContentResolver contentResolver = this.f7827i.f7788c.getContentResolver();
                for (b.a.p0.a.s0.d dVar : this.f7823e) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("title", dVar.f7853b);
                    contentValues.put("tips", this.f7824f);
                    contentValues.put("result", Integer.valueOf(this.f7825g ? 1 : -1));
                    contentResolver.update(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues, "appKey=? and templateId=?", new String[]{this.f7826h, dVar.f7852a});
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements b.a.p0.a.s0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f7828a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f7829b;

        public h(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7829b = aVar;
            this.f7828a = str;
        }

        @Override // b.a.p0.a.x1.a
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f7829b.f7790e.handleSchemeDispatchCallback(this.f7828a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                if (b.a.p0.a.x1.c.f8949c.c()) {
                    return;
                }
                if (b.a.p0.a.c1.a.a0().e(this.f7829b.f7788c)) {
                    b.a.p0.a.x1.c.f8949c.e();
                } else {
                    b.a.p0.a.x1.c.f8949c.f();
                }
            }
        }

        @Override // b.a.p0.a.x1.a
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f7829b.f7790e.handleSchemeDispatchCallback(this.f7828a, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements b.a.p0.a.s0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f7830a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f7831b;

        public i(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7831b = aVar;
            this.f7830a = str;
        }

        @Override // b.a.p0.a.x1.a
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f7831b.f7790e.handleSchemeDispatchCallback(this.f7830a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                if (b.a.p0.a.c1.a.a0().e(this.f7831b.f7788c)) {
                    b.a.p0.a.x1.c.f8949c.e();
                } else {
                    b.a.p0.a.x1.c.f8949c.f();
                }
            }
        }

        @Override // b.a.p0.a.x1.a
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f7831b.f7790e.handleSchemeDispatchCallback(this.f7830a, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public interface j {
        void a(@Nullable String str, @Nullable List<b.a.p0.a.s0.d> list, boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void a(@NonNull LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list);
    }

    /* loaded from: classes.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public final String f7832a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public final String f7833b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f7834c;

        /* renamed from: d  reason: collision with root package name */
        public String f7835d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f7836e;

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
            this.f7832a = str;
            this.f7833b = str2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getFormId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void A(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            if (!w()) {
                this.f7790e.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(w.f(null, "data", w.f(null, "formid", "")), 0).toString());
                return;
            }
            b.a.p0.a.c1.a.R().c(str, new h(this, str2));
        }
    }

    public final void B(@NonNull l lVar, @NonNull List<String> list, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar, list, str) == null) {
            b.a.p0.a.c1.a.R().d(lVar.f7832a, list, lVar.f7833b, lVar.f7834c, new i(this, str));
        }
    }

    @AnyThread
    public final void C(@NonNull l lVar, String str, LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, lVar, str, linkedHashMap, list) == null) {
            b.a.p0.a.c1.a.R().a(lVar.f7832a, linkedHashMap.keySet(), new c(this, str, linkedHashMap, lVar, list));
        }
    }

    public final void D(@NonNull l lVar, String str, String str2, List<b.a.p0.a.s0.d> list, @NonNull List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, lVar, str, str2, list, list2) == null) {
            b.a.p0.a.s0.c.a((Activity) this.f7788c, this.f7789d, str, list, new d(this, lVar, list, str2, str, list2), new e(this, str2)).show();
            z("show", lVar.f7835d, list, list);
        }
    }

    public final void E(@NonNull l lVar, @NonNull String str, String str2, @NonNull List<b.a.p0.a.s0.d> list, @NonNull List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, lVar, str, str2, list, list2) == null) {
            F(lVar.f7832a, list, str2, true);
            for (b.a.p0.a.s0.d dVar : list) {
                list2.add(dVar.f7852a);
            }
            B(lVar, list2, str);
        }
    }

    public final void F(String str, List<b.a.p0.a.s0.d> list, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, list, str2, Boolean.valueOf(z)}) == null) {
            q.f().execute(new g(this, list, str2, z, str));
        }
    }

    @Override // b.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (unitedSchemeEntity == null) {
                boolean z = a0.f4160b;
                return false;
            } else if (eVar != null && (context instanceof Activity) && callbackHandler != null) {
                this.f7788c = context;
                this.f7789d = eVar;
                this.f7790e = callbackHandler;
                JSONObject a2 = a0.a(unitedSchemeEntity, "params");
                if (a2 != null && a2.length() != 0) {
                    String optString = a2.optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        boolean z2 = a0.f4160b;
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "cb is empty");
                        return false;
                    }
                    String k2 = eVar.k();
                    if (TextUtils.isEmpty(k2)) {
                        boolean z3 = a0.f4160b;
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "appKey is empty");
                        return false;
                    }
                    if (TableDefine.PaSubscribeColumns.COLUMN_SUBSCRIBE.equals(a2.optString("reportType"))) {
                        JSONArray optJSONArray = a2.optJSONArray("templateId");
                        String optString2 = a2.optString("templateId");
                        String optString3 = a2.optString("subscribeId");
                        if (TextUtils.isEmpty(optString3)) {
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "subscribeId is empty");
                            return false;
                        }
                        l lVar = new l(k2, optString3);
                        lVar.f7835d = a2.optString("invokeFrom", "form");
                        lVar.f7836e = a2.optBoolean("skipSubscribeAuthorize");
                        lVar.f7834c = optJSONArray == null;
                        if (lVar.f7834c) {
                            if (TextUtils.isEmpty(optString2)) {
                                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "templateId is empty");
                                return false;
                            }
                            strArr = new String[]{optString2};
                        } else {
                            int length = optJSONArray.length();
                            if (length >= 1 && length <= 3) {
                                String[] strArr2 = new String[length];
                                for (int i2 = 0; i2 < length; i2++) {
                                    strArr2[i2] = optJSONArray.optString(i2);
                                }
                                strArr = strArr2;
                            } else {
                                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                                return false;
                            }
                        }
                        y(k2, strArr, new C0363a(this, lVar, strArr, optString));
                    } else {
                        A(k2, optString);
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    return true;
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
                return false;
            } else {
                boolean z4 = a0.f4160b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "runtime parameter error");
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final JSONArray v(List<b.a.p0.a.s0.d> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, list)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (list != null && list.size() > 0) {
                for (b.a.p0.a.s0.d dVar : list) {
                    jSONArray.put(dVar.f7853b);
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? b.a.p0.a.a2.d.g().r().j().e(b.a.p0.a.c1.a.b()) : invokeV.booleanValue;
    }

    public final void x(@NonNull l lVar, @NonNull String str, String str2, @NonNull List<b.a.p0.a.s0.d> list, @NonNull List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048585, this, lVar, str, str2, list, list2) == null) {
            boolean w = w();
            if (w()) {
                E(lVar, str, str2, list, list2);
                return;
            }
            if (!w) {
                b.a.p0.a.j2.k.M("show", 12, "component");
            }
            b.a.p0.a.a2.d.g().r().j().f(b.a.p0.a.g1.f.T().getActivity(), null, new f(this, w, lVar, str, str2, list, list2));
        }
    }

    @AnyThread
    public final void y(String str, String[] strArr, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, str, strArr, kVar) == null) {
            q.j(new b(this, str, strArr, kVar), "querySubscribeInfo");
        }
    }

    public final void z(String str, String str2, List<b.a.p0.a.s0.d> list, List<b.a.p0.a.s0.d> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, str, str2, list, list2) == null) {
            b.a.p0.a.j2.p.e eVar = new b.a.p0.a.j2.p.e();
            eVar.f6383a = "swan";
            eVar.f6384b = str;
            eVar.f6389g = str2;
            if (list2 != null) {
                eVar.f6387e = String.valueOf(list2.size());
            }
            eVar.a("appkey", this.f7789d.getAppId());
            eVar.a("tpl", v(list));
            eVar.a("selected_tpl", v(list2));
            if (a0.f4160b) {
                String str3 = "event: " + eVar.f();
            }
            b.a.p0.a.j2.k.v("1311", "92", eVar);
        }
    }
}
