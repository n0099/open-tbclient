package c.a.o0.a.s0;

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
import c.a.o0.a.c2.f.a0;
import c.a.o0.a.s0.c;
import c.a.o0.a.v2.q;
import c.a.o0.a.v2.q0;
import c.a.o0.a.v2.w;
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
    public Context f8482c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.o0.a.a2.e f8483d;

    /* renamed from: e  reason: collision with root package name */
    public CallbackHandler f8484e;

    /* renamed from: c.a.o0.a.s0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0366a implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f8485a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f8486b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f8487c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f8488d;

        public C0366a(a aVar, l lVar, String[] strArr, String str) {
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
            this.f8488d = aVar;
            this.f8485a = lVar;
            this.f8486b = strArr;
            this.f8487c = str;
        }

        @Override // c.a.o0.a.s0.a.k
        public void a(@NonNull LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list) {
            Iterator<String> it;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, linkedHashMap, list) == null) {
                if (linkedHashMap == null || linkedHashMap.size() == 0) {
                    this.f8488d.B(this.f8485a, Arrays.asList(this.f8486b), this.f8487c);
                    return;
                }
                this.f8488d.C(this.f8485a, this.f8487c, linkedHashMap, list);
                if (a0.f4738b) {
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
        public final /* synthetic */ String f8489e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String[] f8490f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f8491g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f8492h;

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
            this.f8492h = aVar;
            this.f8489e = str;
            this.f8490f = strArr;
            this.f8491g = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String[] strArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HashMap hashMap = new HashMap();
                if (this.f8492h.w()) {
                    Cursor query = this.f8492h.f8482c.getContentResolver().query(SwanAppSubscribeMsgProvider.CONTENT_URI, new String[]{"templateId", "result"}, "appKey=?", new String[]{this.f8489e}, null);
                    if (query != null && query.getCount() > 0 && query.moveToFirst()) {
                        do {
                            hashMap.put(query.getString(query.getColumnIndex("templateId")), Integer.valueOf(query.getInt(query.getColumnIndex("result"))));
                        } while (query.moveToNext());
                        c.a.o0.t.d.d(query);
                    }
                }
                LinkedHashMap<String, Boolean> linkedHashMap = new LinkedHashMap<>();
                ArrayList arrayList = new ArrayList();
                for (String str : this.f8490f) {
                    Integer num = (Integer) hashMap.get(str);
                    if (num == null) {
                        linkedHashMap.put(str, Boolean.FALSE);
                    } else if (num.intValue() != 1) {
                        linkedHashMap.put(str, Boolean.TRUE);
                    } else {
                        arrayList.add(str);
                    }
                }
                this.f8491g.a(linkedHashMap, arrayList);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f8493a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedHashMap f8494b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l f8495c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f8496d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f8497e;

        /* renamed from: c.a.o0.a.s0.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0367a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ List f8498e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f8499f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ c f8500g;

            public RunnableC0367a(c cVar, List list, String str) {
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
                this.f8500g = cVar;
                this.f8498e = list;
                this.f8499f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ContentResolver contentResolver = this.f8500g.f8497e.f8482c.getContentResolver();
                    for (c.a.o0.a.s0.d dVar : this.f8498e) {
                        String str = dVar.f8548a;
                        Boolean bool = (Boolean) this.f8500g.f8494b.get(str);
                        if (bool != null && !bool.booleanValue()) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("appKey", this.f8500g.f8495c.f8527a);
                            contentValues.put("templateId", str);
                            contentValues.put("result", (Integer) 0);
                            contentValues.put("title", dVar.f8549b);
                            contentValues.put("tips", this.f8499f);
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
            public final /* synthetic */ String f8501e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f8502f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ c f8503g;

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
                this.f8503g = cVar;
                this.f8501e = str;
                this.f8502f = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c cVar = this.f8503g;
                    cVar.f8497e.D(cVar.f8495c, this.f8501e, cVar.f8493a, this.f8502f, cVar.f8496d);
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
            this.f8497e = aVar;
            this.f8493a = str;
            this.f8494b = linkedHashMap;
            this.f8495c = lVar;
            this.f8496d = list;
        }

        @Override // c.a.o0.a.s0.a.j
        public void a(@Nullable String str, List<c.a.o0.a.s0.d> list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, str, list, z) == null) {
                if (!TextUtils.isEmpty(str) && list != null && list.size() > 0) {
                    q.j(new RunnableC0367a(this, list, str), "createFormDataBase");
                    if (z && this.f8495c.f8531e) {
                        this.f8497e.x(this.f8495c, this.f8493a, str, list, this.f8496d);
                        return;
                    } else {
                        q0.X(new b(this, str, list));
                        return;
                    }
                }
                this.f8497e.f8484e.handleSchemeDispatchCallback(this.f8493a, UnitedSchemeUtility.wrapCallbackParams(500104, "请求模板内容失败").toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f8504a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f8505b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f8506c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f8507d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f8508e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f8509f;

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
            this.f8509f = aVar;
            this.f8504a = lVar;
            this.f8505b = list;
            this.f8506c = str;
            this.f8507d = str2;
            this.f8508e = list2;
        }

        @Override // c.a.o0.a.s0.c.f
        public boolean a(DialogInterface dialogInterface, int i2, List<c.a.o0.a.s0.d> list) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i2, list)) == null) {
                boolean z = i2 == -1;
                if (a0.f4738b) {
                    String str = "showSubscribeDialog isPositive=" + z;
                }
                if (z && list.size() == 0) {
                    return false;
                }
                this.f8509f.z(z ? "permit_click" : "reject_click", this.f8504a.f8530d, this.f8505b, list);
                if (z) {
                    this.f8509f.x(this.f8504a, this.f8506c, this.f8507d, list, this.f8508e);
                    return true;
                }
                if (this.f8509f.w()) {
                    this.f8509f.F(this.f8504a.f8527a, list, this.f8507d, false);
                }
                this.f8509f.f8484e.handleSchemeDispatchCallback(this.f8506c, UnitedSchemeUtility.wrapCallbackParams(500102, "用户单次拒绝授权").toString());
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
        public final /* synthetic */ String f8510e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f8511f;

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
            this.f8511f = aVar;
            this.f8510e = str;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f8511f.f8484e.handleSchemeDispatchCallback(this.f8510e, UnitedSchemeUtility.wrapCallbackParams(500103, "用户取消授权").toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.o0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f8512e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l f8513f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8514g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8515h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ List f8516i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ List f8517j;
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
            this.f8512e = z;
            this.f8513f = lVar;
            this.f8514g = str;
            this.f8515h = str2;
            this.f8516i = list;
            this.f8517j = list2;
        }

        @Override // c.a.o0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    if (!this.f8512e && this.k.w()) {
                        c.a.o0.a.j2.k.M("success", 12, "component");
                    }
                    this.k.E(this.f8513f, this.f8514g, this.f8515h, this.f8516i, this.f8517j);
                    return;
                }
                if (!this.f8512e && !this.k.w()) {
                    c.a.o0.a.j2.k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 12, "component");
                }
                this.k.f8484e.handleSchemeDispatchCallback(this.f8514g, UnitedSchemeUtility.wrapCallbackParams(500106, "用户未登录").toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f8518e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8519f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f8520g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8521h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f8522i;

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
            this.f8522i = aVar;
            this.f8518e = list;
            this.f8519f = str;
            this.f8520g = z;
            this.f8521h = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ContentResolver contentResolver = this.f8522i.f8482c.getContentResolver();
                for (c.a.o0.a.s0.d dVar : this.f8518e) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("title", dVar.f8549b);
                    contentValues.put("tips", this.f8519f);
                    contentValues.put("result", Integer.valueOf(this.f8520g ? 1 : -1));
                    contentResolver.update(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues, "appKey=? and templateId=?", new String[]{this.f8521h, dVar.f8548a});
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.a.o0.a.s0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f8523a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f8524b;

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
            this.f8524b = aVar;
            this.f8523a = str;
        }

        @Override // c.a.o0.a.x1.a
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f8524b.f8484e.handleSchemeDispatchCallback(this.f8523a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                if (c.a.o0.a.x1.c.f9677c.c()) {
                    return;
                }
                if (c.a.o0.a.c1.a.a0().e(this.f8524b.f8482c)) {
                    c.a.o0.a.x1.c.f9677c.e();
                } else {
                    c.a.o0.a.x1.c.f9677c.f();
                }
            }
        }

        @Override // c.a.o0.a.x1.a
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f8524b.f8484e.handleSchemeDispatchCallback(this.f8523a, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements c.a.o0.a.s0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f8525a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f8526b;

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
            this.f8526b = aVar;
            this.f8525a = str;
        }

        @Override // c.a.o0.a.x1.a
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f8526b.f8484e.handleSchemeDispatchCallback(this.f8525a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                if (c.a.o0.a.c1.a.a0().e(this.f8526b.f8482c)) {
                    c.a.o0.a.x1.c.f9677c.e();
                } else {
                    c.a.o0.a.x1.c.f9677c.f();
                }
            }
        }

        @Override // c.a.o0.a.x1.a
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f8526b.f8484e.handleSchemeDispatchCallback(this.f8525a, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public interface j {
        void a(@Nullable String str, @Nullable List<c.a.o0.a.s0.d> list, boolean z);
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
        public final String f8527a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public final String f8528b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f8529c;

        /* renamed from: d  reason: collision with root package name */
        public String f8530d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f8531e;

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
            this.f8527a = str;
            this.f8528b = str2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.o0.a.c2.e eVar) {
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
                this.f8484e.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(w.f(null, "data", w.f(null, "formid", "")), 0).toString());
                return;
            }
            c.a.o0.a.c1.a.R().c(str, new h(this, str2));
        }
    }

    public final void B(@NonNull l lVar, @NonNull List<String> list, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar, list, str) == null) {
            c.a.o0.a.c1.a.R().d(lVar.f8527a, list, lVar.f8528b, lVar.f8529c, new i(this, str));
        }
    }

    @AnyThread
    public final void C(@NonNull l lVar, String str, LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, lVar, str, linkedHashMap, list) == null) {
            c.a.o0.a.c1.a.R().a(lVar.f8527a, linkedHashMap.keySet(), new c(this, str, linkedHashMap, lVar, list));
        }
    }

    public final void D(@NonNull l lVar, String str, String str2, List<c.a.o0.a.s0.d> list, @NonNull List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, lVar, str, str2, list, list2) == null) {
            c.a.o0.a.s0.c.a((Activity) this.f8482c, this.f8483d, str, list, new d(this, lVar, list, str2, str, list2), new e(this, str2)).show();
            z("show", lVar.f8530d, list, list);
        }
    }

    public final void E(@NonNull l lVar, @NonNull String str, String str2, @NonNull List<c.a.o0.a.s0.d> list, @NonNull List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, lVar, str, str2, list, list2) == null) {
            F(lVar.f8527a, list, str2, true);
            for (c.a.o0.a.s0.d dVar : list) {
                list2.add(dVar.f8548a);
            }
            B(lVar, list2, str);
        }
    }

    public final void F(String str, List<c.a.o0.a.s0.d> list, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, list, str2, Boolean.valueOf(z)}) == null) {
            q.f().execute(new g(this, list, str2, z, str));
        }
    }

    @Override // c.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (unitedSchemeEntity == null) {
                boolean z = a0.f4738b;
                return false;
            } else if (eVar != null && (context instanceof Activity) && callbackHandler != null) {
                this.f8482c = context;
                this.f8483d = eVar;
                this.f8484e = callbackHandler;
                JSONObject a2 = a0.a(unitedSchemeEntity, "params");
                if (a2 != null && a2.length() != 0) {
                    String optString = a2.optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        boolean z2 = a0.f4738b;
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "cb is empty");
                        return false;
                    }
                    String D = eVar.D();
                    if (TextUtils.isEmpty(D)) {
                        boolean z3 = a0.f4738b;
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
                        l lVar = new l(D, optString3);
                        lVar.f8530d = a2.optString("invokeFrom", "form");
                        lVar.f8531e = a2.optBoolean("skipSubscribeAuthorize");
                        lVar.f8529c = optJSONArray == null;
                        if (lVar.f8529c) {
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
                        y(D, strArr, new C0366a(this, lVar, strArr, optString));
                    } else {
                        A(D, optString);
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    return true;
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
                return false;
            } else {
                boolean z4 = a0.f4738b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "runtime parameter error");
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final JSONArray v(List<c.a.o0.a.s0.d> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, list)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (list != null && list.size() > 0) {
                for (c.a.o0.a.s0.d dVar : list) {
                    jSONArray.put(dVar.f8549b);
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? c.a.o0.a.a2.d.g().r().j().e(c.a.o0.a.c1.a.b()) : invokeV.booleanValue;
    }

    public final void x(@NonNull l lVar, @NonNull String str, String str2, @NonNull List<c.a.o0.a.s0.d> list, @NonNull List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048585, this, lVar, str, str2, list, list2) == null) {
            boolean w = w();
            if (w()) {
                E(lVar, str, str2, list, list2);
                return;
            }
            if (!w) {
                c.a.o0.a.j2.k.M("show", 12, "component");
            }
            c.a.o0.a.a2.d.g().r().j().f(c.a.o0.a.g1.f.V().getActivity(), null, new f(this, w, lVar, str, str2, list, list2));
        }
    }

    @AnyThread
    public final void y(String str, String[] strArr, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, str, strArr, kVar) == null) {
            q.j(new b(this, str, strArr, kVar), "querySubscribeInfo");
        }
    }

    public final void z(String str, String str2, List<c.a.o0.a.s0.d> list, List<c.a.o0.a.s0.d> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, str, str2, list, list2) == null) {
            c.a.o0.a.j2.p.e eVar = new c.a.o0.a.j2.p.e();
            eVar.f7035a = "swan";
            eVar.f7036b = str;
            eVar.f7041g = str2;
            if (list2 != null) {
                eVar.f7039e = String.valueOf(list2.size());
            }
            eVar.a("appkey", this.f8483d.getAppId());
            eVar.a("tpl", v(list));
            eVar.a("selected_tpl", v(list2));
            if (a0.f4738b) {
                String str3 = "event: " + eVar.f();
            }
            c.a.o0.a.j2.k.v("1311", "92", eVar);
        }
    }
}
