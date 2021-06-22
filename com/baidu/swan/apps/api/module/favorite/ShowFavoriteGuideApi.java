package com.baidu.swan.apps.api.module.favorite;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.m0.a.a2.e;
import d.a.m0.a.h;
import d.a.m0.a.j2.k;
import d.a.m0.a.u.c.d;
import d.a.m0.a.u.e.d.b;
import d.a.m0.a.v2.q;
import d.a.m0.a.v2.q0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ShowFavoriteGuideApi extends d implements b.j {

    /* renamed from: d  reason: collision with root package name */
    public String f10784d;

    /* renamed from: e  reason: collision with root package name */
    public long f10785e;

    /* renamed from: f  reason: collision with root package name */
    public long f10786f;

    /* renamed from: g  reason: collision with root package name */
    public long f10787g;

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

        GuideType(String str, int i2, int i3, @StringRes int i4) {
            this.typeName = str;
            this.limit = i2;
            this.showWidth4px = i3;
            this.defaultText = i4;
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
        public final /* synthetic */ String f10788e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f10789f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f10790g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Activity f10791h;

        /* renamed from: com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0154a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ GuideType f10793e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f10794f;

            public RunnableC0154a(GuideType guideType, String str) {
                this.f10793e = guideType;
                this.f10794f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.m0.a.u.e.d.b l = d.a.m0.a.u.e.d.b.l();
                a aVar = a.this;
                ShowFavoriteGuideApi showFavoriteGuideApi = ShowFavoriteGuideApi.this;
                Activity activity = aVar.f10791h;
                e eVar = aVar.f10790g;
                l.p(showFavoriteGuideApi, activity, eVar, this.f10793e, this.f10794f, eVar.L().Q(), ShowFavoriteGuideApi.this.f10785e);
            }
        }

        public a(String str, JSONObject jSONObject, e eVar, Activity activity) {
            this.f10788e = str;
            this.f10789f = jSONObject;
            this.f10790g = eVar;
            this.f10791h = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.k2.g.b a2 = d.a.m0.a.k2.g.h.a();
            GuideType parse = GuideType.parse(this.f10788e);
            String string = ShowFavoriteGuideApi.this.i().getString(parse.defaultText);
            ShowFavoriteGuideApi.this.f10784d = this.f10789f.optString("cb");
            String str = this.f10790g.f44533f;
            String str2 = "favorite_guide_count_" + str;
            if (d.a.m0.a.j0.b.a.n(str)) {
                d.a.m0.a.e0.d.g("Api-showFavoriteGuide", "favorite already");
                d.a.m0.a.k2.g.h.a().putString(str2, "-1");
                return;
            }
            String string2 = d.a.m0.a.k2.g.h.a().getString(str2, "");
            if (TextUtils.equals("-1", string2)) {
                d.a.m0.a.e0.d.g("Api-showFavoriteGuide", "favorite at one time");
                return;
            }
            String[] split = string2.split("#");
            long j = 0;
            int i2 = 0;
            if (split.length == 2 && TextUtils.isDigitsOnly(split[0]) && TextUtils.isDigitsOnly(split[1])) {
                i2 = Integer.parseInt(split[0]);
                j = Long.parseLong(split[1]);
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i3 = i2;
            ShowFavoriteGuideApi.this.f10785e = a2.getLong("swan_favorite_guide_duration", 3L);
            ShowFavoriteGuideApi.this.f10786f = a2.getLong("swan_favorite_guide_intervalDays", 3L);
            ShowFavoriteGuideApi.this.f10787g = a2.getLong("swan_favorite_guide_maxTimes", 3L);
            d.a.m0.a.e0.d.g("Api-showFavoriteGuide", "duration=" + ShowFavoriteGuideApi.this.f10785e + ", mIntervalDays=" + ShowFavoriteGuideApi.this.f10786f + ", mMaxTimes=" + ShowFavoriteGuideApi.this.f10787g + " ,storageValue=" + string2);
            if (i3 < ShowFavoriteGuideApi.this.f10787g && currentTimeMillis - j > ShowFavoriteGuideApi.this.f10786f * 86400000) {
                d.a.m0.a.k2.g.h.a().putString(str2, (i3 + 1) + "#" + currentTimeMillis);
                q0.b0(new RunnableC0154a(parse, string));
                return;
            }
            d.a.m0.a.e0.d.g("Api-showFavoriteGuide", "Not satisfying display conditions");
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10796a;

        static {
            int[] iArr = new int[GuideType.values().length];
            f10796a = iArr;
            try {
                iArr[GuideType.TIPS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10796a[GuideType.WEAK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public ShowFavoriteGuideApi(@NonNull d.a.m0.a.u.c.b bVar) {
        super(bVar);
    }

    public static void z(GuideType guideType, String str, String str2) {
        String str3;
        String V = e.V();
        d.a.m0.a.j2.p.e eVar = new d.a.m0.a.j2.p.e();
        if (guideType == null) {
            str3 = "window";
        } else {
            int i2 = b.f10796a[guideType.ordinal()];
            str3 = i2 != 1 ? i2 != 2 ? "flow_close" : "flow" : "TIPS";
        }
        eVar.f46970b = str3;
        eVar.f46971c = str;
        eVar.f46973e = str2;
        eVar.a("appkey", V);
        k.u("923", eVar);
    }

    public d.a.m0.a.u.h.b A(String str) {
        if (d.f48594c) {
            Log.d("Api-showFavoriteGuide", "handle: " + str);
        }
        e Q = e.Q();
        if (Q == null) {
            return new d.a.m0.a.u.h.b(1001, "SwanApp is null");
        }
        SwanAppActivity x = Q.x();
        if (x == null) {
            d.a.m0.a.e0.d.b("Api-showFavoriteGuide", "null activity");
            return new d.a.m0.a.u.h.b(1001, "null activity");
        } else if (!q0.G()) {
            d.a.m0.a.e0.d.g("Api-showFavoriteGuide", "not support outside baiduboxapp");
            return new d.a.m0.a.u.h.b(1001, "not support outside baiduboxapp");
        } else {
            Pair<d.a.m0.a.u.h.b, JSONObject> b2 = d.a.m0.a.u.i.b.b("Api-showFavoriteGuide", str);
            d.a.m0.a.u.h.b bVar = (d.a.m0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.f48594c) {
                    d.a.m0.a.e0.d.b("Api-showFavoriteGuide", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String optString = jSONObject.optString("type");
            if (d.a.m0.a.u.e.d.b.l().n(optString)) {
                return new d.a.m0.a.u.h.b(202);
            }
            q.f().execute(new a(optString, jSONObject, Q, x), "Api-showFavoriteGuide");
            return new d.a.m0.a.u.h.b(0);
        }
    }

    @Override // d.a.m0.a.u.e.d.b.j
    @AnyThread
    public void e(boolean z) {
        if (this.f10784d != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("action", z ? 1 : 0);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            d(this.f10784d, new d.a.m0.a.u.h.b(0, "success", jSONObject));
        }
    }
}
