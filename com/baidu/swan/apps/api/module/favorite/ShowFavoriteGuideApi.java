package com.baidu.swan.apps.api.module.favorite;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.aw1;
import com.baidu.tieba.er2;
import com.baidu.tieba.fg3;
import com.baidu.tieba.kw1;
import com.baidu.tieba.lg3;
import com.baidu.tieba.qe3;
import com.baidu.tieba.rk3;
import com.baidu.tieba.rl3;
import com.baidu.tieba.ve2;
import com.baidu.tieba.x42;
import com.baidu.tieba.x73;
import com.baidu.tieba.xz1;
import com.baidu.tieba.yv1;
import com.baidu.tieba.ze3;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ShowFavoriteGuideApi extends aw1 implements kw1.j {
    public String f;
    public long g;
    public long h;
    public long i;

    @Override // com.baidu.tieba.aw1
    public String h() {
        return "Favorite";
    }

    @Override // com.baidu.tieba.aw1
    public String j() {
        return "ShowFavoriteGuideApi";
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ x73 c;
        public final /* synthetic */ Activity d;

        /* renamed from: com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0181a implements Runnable {
            public final /* synthetic */ GuideType a;
            public final /* synthetic */ String b;

            public RunnableC0181a(GuideType guideType, String str) {
                this.a = guideType;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                kw1 l = kw1.l();
                a aVar = a.this;
                ShowFavoriteGuideApi showFavoriteGuideApi = ShowFavoriteGuideApi.this;
                Activity activity = aVar.d;
                x73 x73Var = aVar.c;
                l.p(showFavoriteGuideApi, activity, x73Var, this.a, this.b, x73Var.W().Q(), ShowFavoriteGuideApi.this.g);
            }
        }

        public a(String str, JSONObject jSONObject, x73 x73Var, Activity activity) {
            this.a = str;
            this.b = jSONObject;
            this.c = x73Var;
            this.d = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (er2.y0().d()) {
                return;
            }
            fg3 a = lg3.a();
            GuideType parse = GuideType.parse(this.a);
            String string = ShowFavoriteGuideApi.this.getContext().getString(parse.defaultText);
            ShowFavoriteGuideApi.this.f = this.b.optString("cb");
            String str = this.c.b;
            String str2 = "favorite_guide_count_" + str;
            if (ve2.n(str)) {
                x42.i("ShowFavoriteGuideApi", "favorite already");
                lg3.a().putString(str2, "-1");
                return;
            }
            String string2 = lg3.a().getString(str2, "");
            if (TextUtils.equals("-1", string2)) {
                x42.i("ShowFavoriteGuideApi", "favorite at one time");
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
            x42.i("ShowFavoriteGuideApi", "duration=" + ShowFavoriteGuideApi.this.g + ", mIntervalDays=" + ShowFavoriteGuideApi.this.h + ", mMaxTimes=" + ShowFavoriteGuideApi.this.i + " ,storageValue=" + string2);
            if (i2 < ShowFavoriteGuideApi.this.i && currentTimeMillis - j > ShowFavoriteGuideApi.this.h * 86400000) {
                lg3.a().putString(str2, (i2 + 1) + "#" + currentTimeMillis);
                rl3.e0(new RunnableC0181a(parse, string));
                return;
            }
            x42.i("ShowFavoriteGuideApi", "Not satisfying display conditions");
        }
    }

    /* loaded from: classes3.dex */
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

    public ShowFavoriteGuideApi(@NonNull yv1 yv1Var) {
        super(yv1Var);
    }

    @Override // com.baidu.tieba.kw1.j
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
            d(this.f, new xz1(0, "success", jSONObject));
        }
    }

    /* loaded from: classes3.dex */
    public enum GuideType {
        NORMAL("bar", -1, 992, R.string.obfuscated_res_0x7f0f015e),
        WEAK("bar-autohide", -1, 865, R.string.obfuscated_res_0x7f0f015e),
        TIPS("tip", 18, -1, R.string.obfuscated_res_0x7f0f015f);
        
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
        String g0 = x73.g0();
        ze3 ze3Var = new ze3();
        if (guideType == null) {
            str3 = "window";
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
        ze3Var.b = str3;
        ze3Var.c = str;
        ze3Var.e = str2;
        ze3Var.a("appkey", g0);
        qe3.x("923", ze3Var);
    }

    public xz1 G(String str) {
        q("#showFavoriteGuide", false);
        x73 b0 = x73.b0();
        if (b0 == null) {
            return new xz1(1001, "SwanApp is null");
        }
        SwanAppActivity w = b0.w();
        if (w == null) {
            x42.c("ShowFavoriteGuideApi", "null activity");
            return new xz1(1001, "null activity");
        } else if (!rl3.G()) {
            x42.i("ShowFavoriteGuideApi", "not support outside baiduboxapp");
            return new xz1(1001, "not support outside baiduboxapp");
        } else {
            Pair<xz1, JSONObject> s = s(str);
            xz1 xz1Var = (xz1) s.first;
            if (!xz1Var.isSuccess()) {
                return xz1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("type");
            if (kw1.l().n(optString)) {
                return new xz1(202);
            }
            rk3.g().execute(new a(optString, jSONObject, b0, w), "ShowFavoriteGuideApi");
            return xz1.f();
        }
    }
}
