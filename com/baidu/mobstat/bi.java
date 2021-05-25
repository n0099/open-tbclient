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
    public boolean f8690a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f8691b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public String f8692c;

    /* renamed from: d  reason: collision with root package name */
    public bk f8693d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8694e;

    /* loaded from: classes2.dex */
    public interface a {
        void a(View view, boolean z);
    }

    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public String f8695a;

        /* renamed from: b  reason: collision with root package name */
        public String f8696b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f8697c;

        /* renamed from: d  reason: collision with root package name */
        public int f8698d;

        public b(String str, String str2, boolean z, int i2) {
            this.f8695a = str;
            this.f8696b = str2;
            this.f8697c = z;
            this.f8698d = i2;
        }
    }

    public bi(Activity activity, bk bkVar, boolean z) {
        this.f8692c = activity.getClass().getName();
        this.f8693d = bkVar;
        this.f8694e = z;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f8690a = ((JSONObject) jSONObject.get("meta")).getInt("matchAll") != 0;
        } catch (Exception unused) {
        }
        if (this.f8690a) {
            return;
        }
        try {
            JSONArray jSONArray = (JSONArray) jSONObject.get("data");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                String optString = jSONObject2.optString("page");
                String optString2 = jSONObject2.optString("layout");
                int optInt = jSONObject2.optInt("contentAsLabel");
                boolean z = jSONObject2.optInt("ignoreCellIndex") != 0;
                if (this.f8692c.equals(optString)) {
                    this.f8691b.add(new b(optString, optString2, z, optInt));
                }
            }
        } catch (Exception unused2) {
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f8700a;

        /* renamed from: b  reason: collision with root package name */
        public String f8701b;

        /* renamed from: c  reason: collision with root package name */
        public String f8702c;

        /* renamed from: d  reason: collision with root package name */
        public c f8703d;

        public c(View view, c cVar, View view2) {
            this.f8703d = cVar;
            this.f8700a = bj.l(view);
            this.f8701b = bj.b(view);
            String c2 = bj.c(view);
            if (TextUtils.isEmpty(c2)) {
                c2 = bj.a(view, c());
                if (TextUtils.isEmpty(c2)) {
                    c2 = bj.a(view, view2);
                }
            }
            this.f8702c = c2;
        }

        public String a() {
            StringBuilder sb = new StringBuilder();
            for (c cVar = this; cVar != null; cVar = cVar.f8703d) {
                sb.insert(0, cVar.a(false));
            }
            return sb.toString();
        }

        public String b() {
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            for (c cVar = this; cVar != null; cVar = cVar.f8703d) {
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
            c cVar = this.f8703d;
            return cVar == null ? "" : cVar.f8701b;
        }

        public String a(boolean z) {
            StringBuilder sb = new StringBuilder();
            sb.append("/");
            sb.append(this.f8700a);
            if (!z) {
                sb.append("[");
                sb.append(this.f8702c);
                sb.append("]");
            }
            return sb.toString();
        }
    }

    public void a(Activity activity) {
        List<b> list;
        if (this.f8694e || this.f8690a || !((list = this.f8691b) == null || list.size() == 0)) {
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
            boolean b2 = this.f8690a ? bj.b(view, cVar2.c()) : a(this.f8691b, cVar2.a(), cVar2.b());
            if (b2 || this.f8694e) {
                if (bd.c().b() && b2) {
                    bd c2 = bd.c();
                    c2.a("accumulate view:" + view.getClass().getName() + "; content:" + bj.h(view));
                }
                if (bh.c().b()) {
                    bh c3 = bh.c();
                    c3.a("accumulate view:" + view.getClass().getName() + "; content:" + bj.h(view));
                }
                this.f8693d.a(view, b2);
            }
        }
        if (!(view instanceof WebView) && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                a(activity, viewGroup.getChildAt(i2), cVar2, view2);
            }
        }
    }

    private boolean a(List<b> list, String str, String str2) {
        for (b bVar : list) {
            String str3 = bVar.f8697c ? str2 : str;
            if (!TextUtils.isEmpty(str3) && str3.equals(bVar.f8696b)) {
                return true;
            }
        }
        return false;
    }
}
