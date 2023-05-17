package com.baidu.swan.apps.api.module.favorite;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.am3;
import com.baidu.tieba.an3;
import com.baidu.tieba.eg2;
import com.baidu.tieba.g12;
import com.baidu.tieba.g62;
import com.baidu.tieba.g93;
import com.baidu.tieba.hx1;
import com.baidu.tieba.ig3;
import com.baidu.tieba.jx1;
import com.baidu.tieba.ns2;
import com.baidu.tieba.oh3;
import com.baidu.tieba.tx1;
import com.baidu.tieba.uh3;
import com.baidu.tieba.zf3;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ShowFavoriteGuideApi extends jx1 implements tx1.j {
    public String f;
    public long g;
    public long h;
    public long i;

    @Override // com.baidu.tieba.jx1
    public String h() {
        return "Favorite";
    }

    @Override // com.baidu.tieba.jx1
    public String j() {
        return "ShowFavoriteGuideApi";
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ g93 c;
        public final /* synthetic */ Activity d;

        /* renamed from: com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0193a implements Runnable {
            public final /* synthetic */ GuideType a;
            public final /* synthetic */ String b;

            public RunnableC0193a(GuideType guideType, String str) {
                this.a = guideType;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                tx1 l = tx1.l();
                a aVar = a.this;
                ShowFavoriteGuideApi showFavoriteGuideApi = ShowFavoriteGuideApi.this;
                Activity activity = aVar.d;
                g93 g93Var = aVar.c;
                l.p(showFavoriteGuideApi, activity, g93Var, this.a, this.b, g93Var.W().Q(), ShowFavoriteGuideApi.this.g);
            }
        }

        public a(String str, JSONObject jSONObject, g93 g93Var, Activity activity) {
            this.a = str;
            this.b = jSONObject;
            this.c = g93Var;
            this.d = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ns2.y0().d()) {
                return;
            }
            oh3 a = uh3.a();
            GuideType parse = GuideType.parse(this.a);
            String string = ShowFavoriteGuideApi.this.getContext().getString(parse.defaultText);
            ShowFavoriteGuideApi.this.f = this.b.optString("cb");
            String str = this.c.b;
            String str2 = "favorite_guide_count_" + str;
            if (eg2.n(str)) {
                g62.i("ShowFavoriteGuideApi", "favorite already");
                uh3.a().putString(str2, "-1");
                return;
            }
            String string2 = uh3.a().getString(str2, "");
            if (TextUtils.equals("-1", string2)) {
                g62.i("ShowFavoriteGuideApi", "favorite at one time");
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
            g62.i("ShowFavoriteGuideApi", "duration=" + ShowFavoriteGuideApi.this.g + ", mIntervalDays=" + ShowFavoriteGuideApi.this.h + ", mMaxTimes=" + ShowFavoriteGuideApi.this.i + " ,storageValue=" + string2);
            if (i2 < ShowFavoriteGuideApi.this.i && currentTimeMillis - j > ShowFavoriteGuideApi.this.h * 86400000) {
                uh3.a().putString(str2, (i2 + 1) + "#" + currentTimeMillis);
                an3.e0(new RunnableC0193a(parse, string));
                return;
            }
            g62.i("ShowFavoriteGuideApi", "Not satisfying display conditions");
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

    public ShowFavoriteGuideApi(@NonNull hx1 hx1Var) {
        super(hx1Var);
    }

    @Override // com.baidu.tieba.tx1.j
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
            d(this.f, new g12(0, "success", jSONObject));
        }
    }

    /* loaded from: classes4.dex */
    public enum GuideType {
        NORMAL("bar", -1, 992, R.string.obfuscated_res_0x7f0f0188),
        WEAK("bar-autohide", -1, 865, R.string.obfuscated_res_0x7f0f0188),
        TIPS("tip", 18, -1, R.string.obfuscated_res_0x7f0f0189);
        
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
        String g0 = g93.g0();
        ig3 ig3Var = new ig3();
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
        ig3Var.b = str3;
        ig3Var.c = str;
        ig3Var.e = str2;
        ig3Var.a("appkey", g0);
        zf3.x("923", ig3Var);
    }

    public g12 G(String str) {
        q("#showFavoriteGuide", false);
        g93 b0 = g93.b0();
        if (b0 == null) {
            return new g12(1001, "SwanApp is null");
        }
        SwanAppActivity w = b0.w();
        if (w == null) {
            g62.c("ShowFavoriteGuideApi", "null activity");
            return new g12(1001, "null activity");
        } else if (!an3.G()) {
            g62.i("ShowFavoriteGuideApi", "not support outside baiduboxapp");
            return new g12(1001, "not support outside baiduboxapp");
        } else {
            Pair<g12, JSONObject> s = s(str);
            g12 g12Var = (g12) s.first;
            if (!g12Var.isSuccess()) {
                return g12Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("type");
            if (tx1.l().n(optString)) {
                return new g12(202);
            }
            am3.g().execute(new a(optString, jSONObject, b0, w), "ShowFavoriteGuideApi");
            return g12.f();
        }
    }
}
