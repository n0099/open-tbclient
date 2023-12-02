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
import com.baidu.android.imsdk.IMConstants;
import com.baidu.swan.apps.database.subscribe.SwanAppSubscribeMsgProvider;
import com.baidu.tieba.dd3;
import com.baidu.tieba.ej2;
import com.baidu.tieba.ej3;
import com.baidu.tieba.ek3;
import com.baidu.tieba.fj2;
import com.baidu.tieba.gj2;
import com.baidu.tieba.j63;
import com.baidu.tieba.k63;
import com.baidu.tieba.md3;
import com.baidu.tieba.nm4;
import com.baidu.tieba.q43;
import com.baidu.tieba.rp2;
import com.baidu.tieba.vm1;
import com.baidu.tieba.xm1;
import com.baidu.tieba.xr2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SubscribeHelper {
    public static final boolean e = vm1.a;
    public String[] a;
    public l b;
    public Context c;
    public k63 d;

    /* loaded from: classes4.dex */
    public interface i {
        void a(@Nullable String str, @Nullable List<gj2> list, boolean z);
    }

    /* loaded from: classes4.dex */
    public enum invokeSubscribeFrom {
        GET_FORM_ID_BUTTON,
        REQUEST_SUBSCRIBE_FORM_ID_API
    }

    /* loaded from: classes4.dex */
    public interface j {
        void a(@NonNull LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list);
    }

    /* loaded from: classes4.dex */
    public interface k {
        void a(int i, @NonNull String str, JSONObject jSONObject);
    }

    /* loaded from: classes4.dex */
    public class c implements i {
        public final /* synthetic */ k a;
        public final /* synthetic */ LinkedHashMap b;
        public final /* synthetic */ l c;
        public final /* synthetic */ List d;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public final /* synthetic */ List a;
            public final /* synthetic */ String b;

            public a(List list, String str) {
                this.a = list;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                ContentResolver contentResolver = SubscribeHelper.this.c.getContentResolver();
                for (gj2 gj2Var : this.a) {
                    String str = gj2Var.a;
                    Boolean bool = (Boolean) c.this.b.get(str);
                    if (bool != null && !bool.booleanValue()) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("appKey", c.this.c.a);
                        contentValues.put("templateId", str);
                        contentValues.put("result", (Integer) 0);
                        contentValues.put("title", gj2Var.b);
                        contentValues.put("tips", this.b);
                        contentResolver.insert(SwanAppSubscribeMsgProvider.c, contentValues);
                    }
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public final /* synthetic */ String a;
            public final /* synthetic */ List b;

            public b(String str, List list) {
                this.a = str;
                this.b = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                SubscribeHelper.this.u(cVar.c, this.a, this.b, cVar.d, cVar.a);
            }
        }

        public c(k kVar, LinkedHashMap linkedHashMap, l lVar, List list) {
            this.a = kVar;
            this.b = linkedHashMap;
            this.c = lVar;
            this.d = list;
        }

        @Override // com.baidu.swan.apps.api.module.subscription.SubscribeHelper.i
        public void a(@Nullable String str, List<gj2> list, boolean z) {
            if (!TextUtils.isEmpty(str) && list != null && list.size() > 0) {
                ej3.k(new a(list, str), "createFormDataBase");
                if (z && this.c.e) {
                    SubscribeHelper.this.m(this.c, str, list, this.d, this.a);
                    return;
                } else {
                    ek3.a0(new b(str, list));
                    return;
                }
            }
            this.a.a(500104, "请求模板内容失败", null);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements j {
        public final /* synthetic */ k a;

        public a(k kVar) {
            this.a = kVar;
        }

        @Override // com.baidu.swan.apps.api.module.subscription.SubscribeHelper.j
        public void a(@NonNull LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list) {
            if (linkedHashMap != null && linkedHashMap.size() != 0) {
                if (SubscribeHelper.e) {
                    Iterator<String> it = linkedHashMap.keySet().iterator();
                    while (it.hasNext()) {
                        Log.i("SubscribeHelper", "querySubscribeInfo unallowedTemplateId=" + it.next());
                    }
                }
                SubscribeHelper subscribeHelper = SubscribeHelper.this;
                subscribeHelper.s(subscribeHelper.b, linkedHashMap, list, this.a);
                return;
            }
            SubscribeHelper subscribeHelper2 = SubscribeHelper.this;
            subscribeHelper2.r(subscribeHelper2.b, Arrays.asList(SubscribeHelper.this.a), this.a);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ String[] b;
        public final /* synthetic */ j c;

        public b(String str, String[] strArr, j jVar) {
            this.a = str;
            this.b = strArr;
            this.c = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String[] strArr;
            HashMap hashMap = new HashMap();
            if (SubscribeHelper.l()) {
                Cursor query = SubscribeHelper.this.c.getContentResolver().query(SwanAppSubscribeMsgProvider.c, new String[]{"templateId", "result"}, "appKey=?", new String[]{this.a}, null);
                if (query != null && query.getCount() > 0 && query.moveToFirst()) {
                    do {
                        hashMap.put(query.getString(query.getColumnIndex("templateId")), Integer.valueOf(query.getInt(query.getColumnIndex("result"))));
                    } while (query.moveToNext());
                    nm4.d(query);
                }
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

    /* loaded from: classes4.dex */
    public class d implements fj2.f {
        public final /* synthetic */ l a;
        public final /* synthetic */ List b;
        public final /* synthetic */ String c;
        public final /* synthetic */ List d;
        public final /* synthetic */ k e;

        public d(l lVar, List list, String str, List list2, k kVar) {
            this.a = lVar;
            this.b = list;
            this.c = str;
            this.d = list2;
            this.e = kVar;
        }

        @Override // com.baidu.tieba.fj2.f
        public boolean a(DialogInterface dialogInterface, int i, List<gj2> list) {
            boolean z;
            String str;
            if (i == -1) {
                z = true;
            } else {
                z = false;
            }
            if (SubscribeHelper.e) {
                Log.i("SubscribeHelper", "showSubscribeDialog isPositive=" + z);
            }
            if (z && list.size() == 0) {
                return false;
            }
            if (z) {
                str = "permit_click";
            } else {
                str = "reject_click";
            }
            SubscribeHelper.this.q(str, this.a.d, this.b, list);
            if (z) {
                SubscribeHelper.this.m(this.a, this.c, list, this.d, this.e);
                return true;
            }
            if (SubscribeHelper.l()) {
                SubscribeHelper.this.w(this.a.a, list, this.c, false);
            }
            SubscribeHelper.this.t();
            this.e.a(500102, "用户单次拒绝授权", null);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements DialogInterface.OnCancelListener {
        public final /* synthetic */ k a;

        public e(k kVar) {
            this.a = kVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            SubscribeHelper.this.t();
            this.a.a(500103, "用户取消授权", null);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements xm1 {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ l b;
        public final /* synthetic */ String c;
        public final /* synthetic */ List d;
        public final /* synthetic */ List e;
        public final /* synthetic */ k f;

        public f(boolean z, l lVar, String str, List list, List list2, k kVar) {
            this.a = z;
            this.b = lVar;
            this.c = str;
            this.d = list;
            this.e = list2;
            this.f = kVar;
        }

        @Override // com.baidu.tieba.xm1
        public void onResult(int i) {
            if (i == 0) {
                if (!this.a && SubscribeHelper.l()) {
                    dd3.S("success", 12, "component");
                }
                SubscribeHelper.this.v(this.b, this.c, this.d, this.e, this.f);
                return;
            }
            if (!this.a && !SubscribeHelper.l()) {
                dd3.S("fail", 12, "component");
            }
            SubscribeHelper.this.t();
            this.f.a(500106, "用户未登录", null);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public final /* synthetic */ List a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ String d;

        public g(List list, String str, boolean z, String str2) {
            this.a = list;
            this.b = str;
            this.c = z;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            ContentResolver contentResolver = SubscribeHelper.this.c.getContentResolver();
            for (gj2 gj2Var : this.a) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("title", gj2Var.b);
                contentValues.put("tips", this.b);
                if (this.c) {
                    i = 1;
                } else {
                    i = -1;
                }
                contentValues.put("result", Integer.valueOf(i));
                contentResolver.update(SwanAppSubscribeMsgProvider.c, contentValues, "appKey=? and templateId=?", new String[]{this.d, gj2Var.a});
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements ej2 {
        public final /* synthetic */ k a;

        public h(k kVar) {
            this.a = kVar;
        }

        @Override // com.baidu.tieba.o43
        public void onFail(String str) {
            this.a.a(500105, "请求formId失败", null);
        }

        @Override // com.baidu.tieba.o43
        public void onSuccess(JSONObject jSONObject) {
            SubscribeHelper.this.t();
            this.a.a(0, "调用成功", jSONObject);
            if (rp2.h0().e(SubscribeHelper.this.c)) {
                q43.c.e();
            } else {
                q43.c.f();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class l {
        @NonNull
        public final String a;
        @NonNull
        public final String b;
        public boolean c;
        public String d;
        public boolean e;

        public l(@NonNull String str, @NonNull String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    public static boolean l() {
        return j63.K().q().N().e(rp2.c());
    }

    public void t() {
        j63.K().q().X().Y0("0");
    }

    public final void u(@NonNull l lVar, String str, List<gj2> list, @NonNull List<String> list2, @NonNull k kVar) {
        fj2.a((Activity) this.c, this.d, str, list, new d(lVar, list, str, list2, kVar), new e(kVar)).show();
        q("show", lVar.d, list, list);
    }

    public final void v(@NonNull l lVar, String str, @NonNull List<gj2> list, @NonNull List<String> list2, @NonNull k kVar) {
        w(lVar.a, list, str, true);
        for (gj2 gj2Var : list) {
            list2.add(gj2Var.a);
        }
        r(lVar, list2, kVar);
    }

    public final JSONArray k(List<gj2> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && list.size() > 0) {
            for (gj2 gj2Var : list) {
                jSONArray.put(gj2Var.b);
            }
        }
        return jSONArray;
    }

    @AnyThread
    public final void s(@NonNull l lVar, LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list, k kVar) {
        rp2.W().b(lVar.a, linkedHashMap.keySet(), new c(kVar, linkedHashMap, lVar, list));
    }

    public final void w(String str, List<gj2> list, String str2, boolean z) {
        ej3.g().execute(new g(list, str2, z, str));
    }

    public final void m(@NonNull l lVar, String str, @NonNull List<gj2> list, @NonNull List<String> list2, @NonNull k kVar) {
        boolean l2 = l();
        if (l()) {
            v(lVar, str, list, list2, kVar);
            return;
        }
        if (!l2) {
            dd3.S("show", 12, "component");
        }
        j63.K().q().N().f(xr2.V().getActivity(), null, new f(l2, lVar, str, list, list2, kVar));
    }

    public boolean n(Context context, k63 k63Var, String str, JSONObject jSONObject, invokeSubscribeFrom invokesubscribefrom, k kVar) {
        boolean z;
        this.c = context;
        this.d = k63Var;
        String optString = jSONObject.optString("subscribeId");
        if (TextUtils.isEmpty(optString)) {
            kVar.a(202, "subscribeId is empty", null);
            return false;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("templateId");
        l lVar = new l(str, optString);
        this.b = lVar;
        if (optJSONArray == null) {
            z = true;
        } else {
            z = false;
        }
        lVar.c = z;
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

    public void o(String str, k kVar) {
        p(str, this.a, new a(kVar));
    }

    @AnyThread
    public final void p(String str, String[] strArr, j jVar) {
        ej3.k(new b(str, strArr, jVar), "querySubscribeInfo");
    }

    public final void r(@NonNull l lVar, @NonNull List<String> list, @NonNull k kVar) {
        rp2.W().d(lVar.a, list, lVar.b, lVar.c, new h(kVar));
    }

    public final void q(String str, String str2, List<gj2> list, List<gj2> list2) {
        md3 md3Var = new md3();
        md3Var.a = "swan";
        md3Var.b = str;
        md3Var.g = str2;
        if (list2 != null) {
            md3Var.e = String.valueOf(list2.size());
        }
        md3Var.a("appkey", this.d.getAppId());
        md3Var.a("tpl", k(list));
        md3Var.a("selected_tpl", k(list2));
        if (e) {
            Log.d("SubscribeHelper", "event: " + md3Var.f());
        }
        dd3.y("1311", "92", md3Var);
    }
}
