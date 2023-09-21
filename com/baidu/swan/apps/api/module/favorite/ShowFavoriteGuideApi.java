package com.baidu.swan.apps.api.module.favorite;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.ao3;
import com.baidu.tieba.ap3;
import com.baidu.tieba.ei2;
import com.baidu.tieba.g32;
import com.baidu.tieba.g82;
import com.baidu.tieba.gb3;
import com.baidu.tieba.hz1;
import com.baidu.tieba.ii3;
import com.baidu.tieba.jz1;
import com.baidu.tieba.nu2;
import com.baidu.tieba.oj3;
import com.baidu.tieba.tz1;
import com.baidu.tieba.uj3;
import com.baidu.tieba.zh3;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ShowFavoriteGuideApi extends jz1 implements tz1.j {
    public String f;
    public long g;
    public long h;
    public long i;

    @Override // com.baidu.tieba.jz1
    public String h() {
        return "Favorite";
    }

    @Override // com.baidu.tieba.jz1
    public String j() {
        return "ShowFavoriteGuideApi";
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ gb3 c;
        public final /* synthetic */ Activity d;

        /* renamed from: com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0196a implements Runnable {
            public final /* synthetic */ GuideType a;
            public final /* synthetic */ String b;

            public RunnableC0196a(GuideType guideType, String str) {
                this.a = guideType;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                tz1 l = tz1.l();
                a aVar = a.this;
                ShowFavoriteGuideApi showFavoriteGuideApi = ShowFavoriteGuideApi.this;
                Activity activity = aVar.d;
                gb3 gb3Var = aVar.c;
                l.p(showFavoriteGuideApi, activity, gb3Var, this.a, this.b, gb3Var.W().Q(), ShowFavoriteGuideApi.this.g);
            }
        }

        public a(String str, JSONObject jSONObject, gb3 gb3Var, Activity activity) {
            this.a = str;
            this.b = jSONObject;
            this.c = gb3Var;
            this.d = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (nu2.y0().d()) {
                return;
            }
            oj3 a = uj3.a();
            GuideType parse = GuideType.parse(this.a);
            String string = ShowFavoriteGuideApi.this.getContext().getString(parse.defaultText);
            ShowFavoriteGuideApi.this.f = this.b.optString("cb");
            String str = this.c.b;
            String str2 = "favorite_guide_count_" + str;
            if (ei2.n(str)) {
                g82.i("ShowFavoriteGuideApi", "favorite already");
                uj3.a().putString(str2, "-1");
                return;
            }
            String string2 = uj3.a().getString(str2, "");
            if (TextUtils.equals("-1", string2)) {
                g82.i("ShowFavoriteGuideApi", "favorite at one time");
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
            ShowFavoriteGuideApi.this.g = a.getLong("swan_favorite_guide_duration", 3L);
            ShowFavoriteGuideApi.this.h = a.getLong("swan_favorite_guide_intervalDays", 3L);
            ShowFavoriteGuideApi.this.i = a.getLong("swan_favorite_guide_maxTimes", 3L);
            g82.i("ShowFavoriteGuideApi", "duration=" + ShowFavoriteGuideApi.this.g + ", mIntervalDays=" + ShowFavoriteGuideApi.this.h + ", mMaxTimes=" + ShowFavoriteGuideApi.this.i + " ,storageValue=" + string2);
            if (i2 < ShowFavoriteGuideApi.this.i && currentTimeMillis - j > ShowFavoriteGuideApi.this.h * 86400000) {
                uj3.a().putString(str2, (i2 + 1) + "#" + currentTimeMillis);
                ap3.e0(new RunnableC0196a(parse, string));
                return;
            }
            g82.i("ShowFavoriteGuideApi", "Not satisfying display conditions");
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[GuideType.values().length];
            a = iArr;
            try {
                iArr[GuideType.TIPS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[GuideType.WEAK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public ShowFavoriteGuideApi(@NonNull hz1 hz1Var) {
        super(hz1Var);
    }

    @Override // com.baidu.tieba.tz1.j
    @AnyThread
    public void e(boolean z) {
        int i;
        if (this.f != null) {
            JSONObject jSONObject = new JSONObject();
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            try {
                jSONObject.put("action", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            d(this.f, new g32(0, "success", jSONObject));
        }
    }

    /* loaded from: classes4.dex */
    public enum GuideType {
        NORMAL("bar", -1, 992, R.string.obfuscated_res_0x7f0f018b),
        WEAK("bar-autohide", -1, 865, R.string.obfuscated_res_0x7f0f018b),
        TIPS("tip", 18, -1, R.string.obfuscated_res_0x7f0f018c);
        
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

    public static void F(GuideType guideType, String str, String str2) {
        String str3;
        String g0 = gb3.g0();
        ii3 ii3Var = new ii3();
        if (guideType == null) {
            str3 = ApkCheckUBCManagerKt.VALUE_WINDOW;
        } else {
            int i = b.a[guideType.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    str3 = "flow_close";
                } else {
                    str3 = "flow";
                }
            } else {
                str3 = "TIPS";
            }
        }
        ii3Var.b = str3;
        ii3Var.c = str;
        ii3Var.e = str2;
        ii3Var.a("appkey", g0);
        zh3.x("923", ii3Var);
    }

    public g32 G(String str) {
        q("#showFavoriteGuide", false);
        gb3 b0 = gb3.b0();
        if (b0 == null) {
            return new g32(1001, "SwanApp is null");
        }
        SwanAppActivity w = b0.w();
        if (w == null) {
            g82.c("ShowFavoriteGuideApi", "null activity");
            return new g32(1001, "null activity");
        } else if (!ap3.G()) {
            g82.i("ShowFavoriteGuideApi", "not support outside baiduboxapp");
            return new g32(1001, "not support outside baiduboxapp");
        } else {
            Pair<g32, JSONObject> s = s(str);
            g32 g32Var = (g32) s.first;
            if (!g32Var.isSuccess()) {
                return g32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("type");
            if (tz1.l().n(optString)) {
                return new g32(202);
            }
            ao3.g().execute(new a(optString, jSONObject, b0, w), "ShowFavoriteGuideApi");
            return g32.f();
        }
    }
}
