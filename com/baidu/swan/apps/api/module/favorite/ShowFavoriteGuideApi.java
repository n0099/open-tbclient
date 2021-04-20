package com.baidu.swan.apps.api.module.favorite;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import com.baidu.swan.apps.SwanAppActivity;
import d.b.g0.a.c0.c;
import d.b.g0.a.h;
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.p;
import d.b.g0.a.r1.e;
import d.b.g0.a.t.b.d;
import d.b.g0.a.t.c.c.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ShowFavoriteGuideApi extends d implements a.j {

    /* renamed from: d  reason: collision with root package name */
    public String f11757d;

    /* renamed from: e  reason: collision with root package name */
    public long f11758e;

    /* renamed from: f  reason: collision with root package name */
    public long f11759f;

    /* renamed from: g  reason: collision with root package name */
    public long f11760g;

    /* loaded from: classes2.dex */
    public enum GuideType {
        NORMAL("bar", -1, 992, h.aiapps_favorite_guide_default_hint),
        WEAK("bar-autohide", -1, 865, h.aiapps_favorite_guide_default_hint),
        TIPS("tip", 18, -1, h.aiapps_favorite_guide_default_tips);
        
        @StringRes
        public int defaultText;
        public int limit;
        public int showWidth4px;
        public String typeName;

        GuideType(String str, int i, int i2, @StringRes int i3) {
            this.typeName = str;
            this.limit = i;
            this.showWidth4px = i2;
            this.defaultText = i3;
        }

        public static GuideType parse(String str) {
            GuideType[] values;
            if (!TextUtils.isEmpty(str)) {
                for (GuideType guideType : values()) {
                    if (TextUtils.equals(guideType.typeName, str)) {
                        return guideType;
                    }
                }
            }
            return NORMAL;
        }
    }

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11761e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f11762f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f11763g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Activity f11764h;

        /* renamed from: com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0168a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ GuideType f11765e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f11766f;

            public RunnableC0168a(GuideType guideType, String str) {
                this.f11765e = guideType;
                this.f11766f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.g0.a.t.c.c.a l = d.b.g0.a.t.c.c.a.l();
                a aVar = a.this;
                ShowFavoriteGuideApi showFavoriteGuideApi = ShowFavoriteGuideApi.this;
                Activity activity = aVar.f11764h;
                e eVar = aVar.f11763g;
                l.p(showFavoriteGuideApi, activity, eVar, this.f11765e, this.f11766f, eVar.J().P(), ShowFavoriteGuideApi.this.f11758e);
            }
        }

        public a(String str, JSONObject jSONObject, e eVar, Activity activity) {
            this.f11761e = str;
            this.f11762f = jSONObject;
            this.f11763g = eVar;
            this.f11764h = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.a2.g.b a2 = d.b.g0.a.a2.g.h.a();
            GuideType parse = GuideType.parse(this.f11761e);
            String string = ShowFavoriteGuideApi.this.h().getString(parse.defaultText);
            ShowFavoriteGuideApi.this.f11757d = this.f11762f.optString("cb");
            String str = this.f11763g.f46132f;
            String str2 = "favorite_guide_count_" + str;
            if (d.b.g0.a.g0.c.a.n(str)) {
                c.g("Api-showFavoriteGuide", "favorite already");
                d.b.g0.a.a2.g.h.a().putString(str2, "-1");
                return;
            }
            String string2 = d.b.g0.a.a2.g.h.a().getString(str2, "");
            if (TextUtils.equals("-1", string2)) {
                c.g("Api-showFavoriteGuide", "favorite at one time");
                return;
            }
            String[] split = string2.split("#");
            long j = 0;
            int i = 0;
            if (split.length == 2 && TextUtils.isDigitsOnly(split[0]) && TextUtils.isDigitsOnly(split[1])) {
                i = Integer.parseInt(split[0]);
                j = Long.parseLong(split[1]);
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = i;
            ShowFavoriteGuideApi.this.f11758e = a2.getLong("swan_favorite_guide_duration", 3L);
            ShowFavoriteGuideApi.this.f11759f = a2.getLong("swan_favorite_guide_intervalDays", 3L);
            ShowFavoriteGuideApi.this.f11760g = a2.getLong("swan_favorite_guide_maxTimes", 3L);
            c.g("Api-showFavoriteGuide", "duration=" + ShowFavoriteGuideApi.this.f11758e + ", mIntervalDays=" + ShowFavoriteGuideApi.this.f11759f + ", mMaxTimes=" + ShowFavoriteGuideApi.this.f11760g + " ,storageValue=" + string2);
            if (i2 < ShowFavoriteGuideApi.this.f11760g && currentTimeMillis - j > ShowFavoriteGuideApi.this.f11759f * 86400000) {
                d.b.g0.a.a2.g.h.a().putString(str2, (i2 + 1) + "#" + currentTimeMillis);
                k0.X(new RunnableC0168a(parse, string));
                return;
            }
            c.g("Api-showFavoriteGuide", "Not satisfying display conditions");
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11768a;

        static {
            int[] iArr = new int[GuideType.values().length];
            f11768a = iArr;
            try {
                iArr[GuideType.TIPS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11768a[GuideType.WEAK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public ShowFavoriteGuideApi(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public static void y(GuideType guideType, String str, String str2) {
        String str3;
        String T = e.T();
        d.b.g0.a.z1.k.e eVar = new d.b.g0.a.z1.k.e();
        if (guideType == null) {
            str3 = "window";
        } else {
            int i = b.f11768a[guideType.ordinal()];
            str3 = i != 1 ? i != 2 ? "flow_close" : "flow" : "TIPS";
        }
        eVar.f47644b = str3;
        eVar.f47645c = str;
        eVar.f47646d = str2;
        eVar.a("appkey", T);
        d.b.g0.a.z1.h.u("923", eVar);
    }

    @Override // d.b.g0.a.t.c.c.a.j
    @AnyThread
    public void e(boolean z) {
        if (this.f11757d != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("action", z ? 1 : 0);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            c(this.f11757d, new d.b.g0.a.t.e.b(0, "success", jSONObject));
        }
    }

    public d.b.g0.a.t.e.b z(String str) {
        if (d.f46321c) {
            Log.d("Api-showFavoriteGuide", "handle: " + str);
        }
        e O = e.O();
        if (O == null) {
            return new d.b.g0.a.t.e.b(1001, "SwanApp is null");
        }
        SwanAppActivity n = O.n();
        if (n == null) {
            c.b("Api-showFavoriteGuide", "null activity");
            return new d.b.g0.a.t.e.b(1001, "null activity");
        } else if (!k0.D()) {
            c.g("Api-showFavoriteGuide", "not support outside baiduboxapp");
            return new d.b.g0.a.t.e.b(1001, "not support outside baiduboxapp");
        } else {
            Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-showFavoriteGuide", str);
            d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
            if (!bVar.b()) {
                if (d.f46321c) {
                    c.b("Api-showFavoriteGuide", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) a2.second;
            String optString = jSONObject.optString("type");
            if (d.b.g0.a.t.c.c.a.l().n(optString)) {
                return new d.b.g0.a.t.e.b(202);
            }
            p.g().execute(new a(optString, jSONObject, O, n), "Api-showFavoriteGuide");
            return new d.b.g0.a.t.e.b(0);
        }
    }
}
