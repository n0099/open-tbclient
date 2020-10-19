package com.baidu.mobstat;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.coremedia.iso.boxes.MetaBox;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes17.dex */
public class bi {

    /* renamed from: a  reason: collision with root package name */
    private boolean f2581a;
    private List<b> b = new ArrayList();
    private String c;
    private bk d;
    private boolean e;

    /* loaded from: classes17.dex */
    public interface a {
        void a(View view, boolean z);
    }

    public bi(Activity activity, bk bkVar, boolean z) {
        this.c = activity.getClass().getName();
        this.d = bkVar;
        this.e = z;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f2581a = ((JSONObject) jSONObject.get(MetaBox.TYPE)).getInt("matchAll") != 0;
            } catch (Exception e) {
            }
            if (!this.f2581a) {
                try {
                    JSONArray jSONArray = (JSONArray) jSONObject.get("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                        String optString = jSONObject2.optString("page");
                        String optString2 = jSONObject2.optString("layout");
                        int optInt = jSONObject2.optInt("contentAsLabel");
                        boolean z = jSONObject2.optInt("ignoreCellIndex") != 0;
                        if (this.c.equals(optString)) {
                            this.b.add(new b(optString, optString2, z, optInt));
                        }
                    }
                } catch (Exception e2) {
                }
            }
        }
    }

    public void a(Activity activity) {
        if (this.e || this.f2581a || (this.b != null && this.b.size() != 0)) {
            View a2 = bj.a(activity);
            a(activity, a2, null, a2);
        }
    }

    private void a(Activity activity, View view, c cVar, View view2) {
        if (view != null && !ai.a(view) && !bj.c(activity, view)) {
            c cVar2 = new c(view, cVar, view2);
            if (cVar != null) {
                boolean b2 = this.f2581a ? bj.b(view, cVar2.c()) : a(this.b, cVar2.a(), cVar2.b());
                if (b2 || this.e) {
                    if (bd.c().b() && b2) {
                        bd.c().a("accumulate view:" + view.getClass().getName() + "; content:" + bj.h(view));
                    }
                    if (bh.c().b()) {
                        bh.c().a("accumulate view:" + view.getClass().getName() + "; content:" + bj.h(view));
                    }
                    this.d.a(view, b2);
                }
            }
            if (!(view instanceof WebView) && (view instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    a(activity, viewGroup.getChildAt(i), cVar2, view2);
                }
            }
        }
    }

    private boolean a(List<b> list, String str, String str2) {
        for (b bVar : list) {
            String str3 = bVar.c ? str2 : str;
            if (!TextUtils.isEmpty(str3) && str3.equals(bVar.b)) {
                return true;
            }
        }
        return false;
    }

    /* loaded from: classes17.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public String f2582a;
        public String b;
        public boolean c;
        public int d;

        public b(String str, String str2, boolean z, int i) {
            this.f2582a = str;
            this.b = str2;
            this.c = z;
            this.d = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f2583a;
        public String b;
        public String c;
        public c d;

        public c(View view, c cVar, View view2) {
            this.d = cVar;
            this.f2583a = bj.l(view);
            this.b = bj.b(view);
            String c = bj.c(view);
            if (TextUtils.isEmpty(c)) {
                c = bj.a(view, c());
                if (TextUtils.isEmpty(c)) {
                    c = bj.a(view, view2);
                }
            }
            this.c = c;
        }

        public String a() {
            StringBuilder sb = new StringBuilder();
            while (this != null) {
                sb.insert(0, this.a(false));
                this = this.d;
            }
            return sb.toString();
        }

        public String b() {
            boolean z;
            boolean z2;
            StringBuilder sb = new StringBuilder();
            boolean z3 = false;
            while (this != null) {
                if (!z3) {
                    String c = this.c();
                    if ("ListView".equals(c) || "RecyclerView".equals(c) || "GridView".equals(c)) {
                        z2 = true;
                        z = true;
                        sb.insert(0, this.a(z2));
                        this = this.d;
                        z3 = z;
                    }
                }
                z = z3;
                z2 = false;
                sb.insert(0, this.a(z2));
                this = this.d;
                z3 = z;
            }
            return sb.toString();
        }

        public String a(boolean z) {
            StringBuilder sb = new StringBuilder();
            sb.append("/");
            sb.append(this.f2583a);
            if (!z) {
                sb.append("[");
                sb.append(this.c);
                sb.append("]");
            }
            return sb.toString();
        }

        public String c() {
            return this.d == null ? "" : this.d.b;
        }
    }
}
