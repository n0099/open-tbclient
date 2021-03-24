package com.baidu.mobstat;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class bi {

    /* renamed from: a  reason: collision with root package name */
    public boolean f9092a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f9093b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public String f9094c;

    /* renamed from: d  reason: collision with root package name */
    public bk f9095d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9096e;

    /* loaded from: classes2.dex */
    public interface a {
        void a(View view, boolean z);
    }

    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public String f9097a;

        /* renamed from: b  reason: collision with root package name */
        public String f9098b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f9099c;

        /* renamed from: d  reason: collision with root package name */
        public int f9100d;

        public b(String str, String str2, boolean z, int i) {
            this.f9097a = str;
            this.f9098b = str2;
            this.f9099c = z;
            this.f9100d = i;
        }
    }

    public bi(Activity activity, bk bkVar, boolean z) {
        this.f9094c = activity.getClass().getName();
        this.f9095d = bkVar;
        this.f9096e = z;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f9092a = ((JSONObject) jSONObject.get("meta")).getInt("matchAll") != 0;
        } catch (Exception unused) {
        }
        if (this.f9092a) {
            return;
        }
        try {
            JSONArray jSONArray = (JSONArray) jSONObject.get("data");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                String optString = jSONObject2.optString("page");
                String optString2 = jSONObject2.optString("layout");
                int optInt = jSONObject2.optInt("contentAsLabel");
                boolean z = jSONObject2.optInt("ignoreCellIndex") != 0;
                if (this.f9094c.equals(optString)) {
                    this.f9093b.add(new b(optString, optString2, z, optInt));
                }
            }
        } catch (Exception unused2) {
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f9102a;

        /* renamed from: b  reason: collision with root package name */
        public String f9103b;

        /* renamed from: c  reason: collision with root package name */
        public String f9104c;

        /* renamed from: d  reason: collision with root package name */
        public c f9105d;

        public c(View view, c cVar, View view2) {
            this.f9105d = cVar;
            this.f9102a = bj.l(view);
            this.f9103b = bj.b(view);
            String c2 = bj.c(view);
            if (TextUtils.isEmpty(c2)) {
                c2 = bj.a(view, c());
                if (TextUtils.isEmpty(c2)) {
                    c2 = bj.a(view, view2);
                }
            }
            this.f9104c = c2;
        }

        public String a() {
            StringBuilder sb = new StringBuilder();
            for (c cVar = this; cVar != null; cVar = cVar.f9105d) {
                sb.insert(0, cVar.a(false));
            }
            return sb.toString();
        }

        public String b() {
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            for (c cVar = this; cVar != null; cVar = cVar.f9105d) {
                boolean z2 = true;
                if (!z) {
                    String c2 = cVar.c();
                    if ("ListView".equals(c2) || RecyclerView.TAG.equals(c2) || "GridView".equals(c2)) {
                        z = true;
                        sb.insert(0, cVar.a(z2));
                    }
                }
                z2 = false;
                sb.insert(0, cVar.a(z2));
            }
            return sb.toString();
        }

        public String c() {
            c cVar = this.f9105d;
            return cVar == null ? "" : cVar.f9103b;
        }

        public String a(boolean z) {
            StringBuilder sb = new StringBuilder();
            sb.append("/");
            sb.append(this.f9102a);
            if (!z) {
                sb.append("[");
                sb.append(this.f9104c);
                sb.append("]");
            }
            return sb.toString();
        }
    }

    public void a(Activity activity) {
        List<b> list;
        if (this.f9096e || this.f9092a || !((list = this.f9093b) == null || list.size() == 0)) {
            View a2 = bj.a(activity);
            a(activity, a2, null, a2);
        }
    }

    private void a(Activity activity, View view, c cVar, View view2) {
        if (view == null || ai.a(view) || bj.c(activity, view)) {
            return;
        }
        c cVar2 = new c(view, cVar, view2);
        if (cVar != null) {
            boolean b2 = this.f9092a ? bj.b(view, cVar2.c()) : a(this.f9093b, cVar2.a(), cVar2.b());
            if (b2 || this.f9096e) {
                if (bd.c().b() && b2) {
                    bd c2 = bd.c();
                    c2.a("accumulate view:" + view.getClass().getName() + "; content:" + bj.h(view));
                }
                if (bh.c().b()) {
                    bh c3 = bh.c();
                    c3.a("accumulate view:" + view.getClass().getName() + "; content:" + bj.h(view));
                }
                this.f9095d.a(view, b2);
            }
        }
        if (!(view instanceof WebView) && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(activity, viewGroup.getChildAt(i), cVar2, view2);
            }
        }
    }

    private boolean a(List<b> list, String str, String str2) {
        for (b bVar : list) {
            String str3 = bVar.f9099c ? str2 : str;
            if (!TextUtils.isEmpty(str3) && str3.equals(bVar.f9098b)) {
                return true;
            }
        }
        return false;
    }
}
