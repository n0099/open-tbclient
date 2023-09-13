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
import com.baidu.tieba.ai3;
import com.baidu.tieba.bo3;
import com.baidu.tieba.bp3;
import com.baidu.tieba.fi2;
import com.baidu.tieba.h32;
import com.baidu.tieba.h82;
import com.baidu.tieba.hb3;
import com.baidu.tieba.iz1;
import com.baidu.tieba.ji3;
import com.baidu.tieba.kz1;
import com.baidu.tieba.ou2;
import com.baidu.tieba.pj3;
import com.baidu.tieba.uz1;
import com.baidu.tieba.vj3;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ShowFavoriteGuideApi extends kz1 implements uz1.j {
    public String f;
    public long g;
    public long h;
    public long i;

    @Override // com.baidu.tieba.kz1
    public String h() {
        return "Favorite";
    }

    @Override // com.baidu.tieba.kz1
    public String j() {
        return "ShowFavoriteGuideApi";
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ hb3 c;
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
                uz1 l = uz1.l();
                a aVar = a.this;
                ShowFavoriteGuideApi showFavoriteGuideApi = ShowFavoriteGuideApi.this;
                Activity activity = aVar.d;
                hb3 hb3Var = aVar.c;
                l.p(showFavoriteGuideApi, activity, hb3Var, this.a, this.b, hb3Var.W().Q(), ShowFavoriteGuideApi.this.g);
            }
        }

        public a(String str, JSONObject jSONObject, hb3 hb3Var, Activity activity) {
            this.a = str;
            this.b = jSONObject;
            this.c = hb3Var;
            this.d = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ou2.y0().d()) {
                return;
            }
            pj3 a = vj3.a();
            GuideType parse = GuideType.parse(this.a);
            String string = ShowFavoriteGuideApi.this.getContext().getString(parse.defaultText);
            ShowFavoriteGuideApi.this.f = this.b.optString("cb");
            String str = this.c.b;
            String str2 = "favorite_guide_count_" + str;
            if (fi2.n(str)) {
                h82.i("ShowFavoriteGuideApi", "favorite already");
                vj3.a().putString(str2, "-1");
                return;
            }
            String string2 = vj3.a().getString(str2, "");
            if (TextUtils.equals("-1", string2)) {
                h82.i("ShowFavoriteGuideApi", "favorite at one time");
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
            h82.i("ShowFavoriteGuideApi", "duration=" + ShowFavoriteGuideApi.this.g + ", mIntervalDays=" + ShowFavoriteGuideApi.this.h + ", mMaxTimes=" + ShowFavoriteGuideApi.this.i + " ,storageValue=" + string2);
            if (i2 < ShowFavoriteGuideApi.this.i && currentTimeMillis - j > ShowFavoriteGuideApi.this.h * 86400000) {
                vj3.a().putString(str2, (i2 + 1) + "#" + currentTimeMillis);
                bp3.e0(new RunnableC0196a(parse, string));
                return;
            }
            h82.i("ShowFavoriteGuideApi", "Not satisfying display conditions");
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

    public ShowFavoriteGuideApi(@NonNull iz1 iz1Var) {
        super(iz1Var);
    }

    @Override // com.baidu.tieba.uz1.j
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
            d(this.f, new h32(0, "success", jSONObject));
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
        String g0 = hb3.g0();
        ji3 ji3Var = new ji3();
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
        ji3Var.b = str3;
        ji3Var.c = str;
        ji3Var.e = str2;
        ji3Var.a("appkey", g0);
        ai3.x("923", ji3Var);
    }

    public h32 G(String str) {
        q("#showFavoriteGuide", false);
        hb3 b0 = hb3.b0();
        if (b0 == null) {
            return new h32(1001, "SwanApp is null");
        }
        SwanAppActivity w = b0.w();
        if (w == null) {
            h82.c("ShowFavoriteGuideApi", "null activity");
            return new h32(1001, "null activity");
        } else if (!bp3.G()) {
            h82.i("ShowFavoriteGuideApi", "not support outside baiduboxapp");
            return new h32(1001, "not support outside baiduboxapp");
        } else {
            Pair<h32, JSONObject> s = s(str);
            h32 h32Var = (h32) s.first;
            if (!h32Var.isSuccess()) {
                return h32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("type");
            if (uz1.l().n(optString)) {
                return new h32(202);
            }
            bo3.g().execute(new a(optString, jSONObject, b0, w), "ShowFavoriteGuideApi");
            return h32.f();
        }
    }
}
