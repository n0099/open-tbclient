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
import com.baidu.tieba.aj2;
import com.baidu.tieba.aj3;
import com.baidu.tieba.ak3;
import com.baidu.tieba.bj2;
import com.baidu.tieba.cj2;
import com.baidu.tieba.f63;
import com.baidu.tieba.g63;
import com.baidu.tieba.id3;
import com.baidu.tieba.jm4;
import com.baidu.tieba.m43;
import com.baidu.tieba.np2;
import com.baidu.tieba.rm1;
import com.baidu.tieba.tm1;
import com.baidu.tieba.tr2;
import com.baidu.tieba.zc3;
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
    public static final boolean e = rm1.a;
    public String[] a;
    public l b;
    public Context c;
    public g63 d;

    /* loaded from: classes4.dex */
    public interface i {
        void a(@Nullable String str, @Nullable List<cj2> list, boolean z);
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
                for (cj2 cj2Var : this.a) {
                    String str = cj2Var.a;
                    Boolean bool = (Boolean) c.this.b.get(str);
                    if (bool != null && !bool.booleanValue()) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("appKey", c.this.c.a);
                        contentValues.put("templateId", str);
                        contentValues.put("result", (Integer) 0);
                        contentValues.put("title", cj2Var.b);
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
        public void a(@Nullable String str, List<cj2> list, boolean z) {
            if (!TextUtils.isEmpty(str) && list != null && list.size() > 0) {
                aj3.k(new a(list, str), "createFormDataBase");
                if (z && this.c.e) {
                    SubscribeHelper.this.m(this.c, str, list, this.d, this.a);
                    return;
                } else {
                    ak3.a0(new b(str, list));
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
                    jm4.d(query);
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
    public class d implements bj2.f {
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

        @Override // com.baidu.tieba.bj2.f
        public boolean a(DialogInterface dialogInterface, int i, List<cj2> list) {
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
    public class f implements tm1 {
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

        @Override // com.baidu.tieba.tm1
        public void onResult(int i) {
            if (i == 0) {
                if (!this.a && SubscribeHelper.l()) {
                    zc3.S("success", 12, "component");
                }
                SubscribeHelper.this.v(this.b, this.c, this.d, this.e, this.f);
                return;
            }
            if (!this.a && !SubscribeHelper.l()) {
                zc3.S("fail", 12, "component");
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
            for (cj2 cj2Var : this.a) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("title", cj2Var.b);
                contentValues.put("tips", this.b);
                if (this.c) {
                    i = 1;
                } else {
                    i = -1;
                }
                contentValues.put("result", Integer.valueOf(i));
                contentResolver.update(SwanAppSubscribeMsgProvider.c, contentValues, "appKey=? and templateId=?", new String[]{this.d, cj2Var.a});
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements aj2 {
        public final /* synthetic */ k a;

        public h(k kVar) {
            this.a = kVar;
        }

        @Override // com.baidu.tieba.k43
        public void onFail(String str) {
            this.a.a(500105, "请求formId失败", null);
        }

        @Override // com.baidu.tieba.k43
        public void onSuccess(JSONObject jSONObject) {
            SubscribeHelper.this.t();
            this.a.a(0, "调用成功", jSONObject);
            if (np2.h0().e(SubscribeHelper.this.c)) {
                m43.c.e();
            } else {
                m43.c.f();
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
        return f63.K().q().N().e(np2.c());
    }

    public void t() {
        f63.K().q().X().Y0("0");
    }

    public final void u(@NonNull l lVar, String str, List<cj2> list, @NonNull List<String> list2, @NonNull k kVar) {
        bj2.a((Activity) this.c, this.d, str, list, new d(lVar, list, str, list2, kVar), new e(kVar)).show();
        q("show", lVar.d, list, list);
    }

    public final void v(@NonNull l lVar, String str, @NonNull List<cj2> list, @NonNull List<String> list2, @NonNull k kVar) {
        w(lVar.a, list, str, true);
        for (cj2 cj2Var : list) {
            list2.add(cj2Var.a);
        }
        r(lVar, list2, kVar);
    }

    public final JSONArray k(List<cj2> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && list.size() > 0) {
            for (cj2 cj2Var : list) {
                jSONArray.put(cj2Var.b);
            }
        }
        return jSONArray;
    }

    @AnyThread
    public final void s(@NonNull l lVar, LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list, k kVar) {
        np2.W().b(lVar.a, linkedHashMap.keySet(), new c(kVar, linkedHashMap, lVar, list));
    }

    public final void w(String str, List<cj2> list, String str2, boolean z) {
        aj3.g().execute(new g(list, str2, z, str));
    }

    public final void m(@NonNull l lVar, String str, @NonNull List<cj2> list, @NonNull List<String> list2, @NonNull k kVar) {
        boolean l2 = l();
        if (l()) {
            v(lVar, str, list, list2, kVar);
            return;
        }
        if (!l2) {
            zc3.S("show", 12, "component");
        }
        f63.K().q().N().f(tr2.V().getActivity(), null, new f(l2, lVar, str, list, list2, kVar));
    }

    public boolean n(Context context, g63 g63Var, String str, JSONObject jSONObject, invokeSubscribeFrom invokesubscribefrom, k kVar) {
        boolean z;
        this.c = context;
        this.d = g63Var;
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
        aj3.k(new b(str, strArr, jVar), "querySubscribeInfo");
    }

    public final void r(@NonNull l lVar, @NonNull List<String> list, @NonNull k kVar) {
        np2.W().d(lVar.a, list, lVar.b, lVar.c, new h(kVar));
    }

    public final void q(String str, String str2, List<cj2> list, List<cj2> list2) {
        id3 id3Var = new id3();
        id3Var.a = "swan";
        id3Var.b = str;
        id3Var.g = str2;
        if (list2 != null) {
            id3Var.e = String.valueOf(list2.size());
        }
        id3Var.a("appkey", this.d.getAppId());
        id3Var.a("tpl", k(list));
        id3Var.a("selected_tpl", k(list2));
        if (e) {
            Log.d("SubscribeHelper", "event: " + id3Var.f());
        }
        zc3.y("1311", "92", id3Var);
    }
}
