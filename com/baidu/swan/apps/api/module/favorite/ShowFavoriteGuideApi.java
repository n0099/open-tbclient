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
import com.baidu.tieba.bi2;
import com.baidu.tieba.d32;
import com.baidu.tieba.d82;
import com.baidu.tieba.db3;
import com.baidu.tieba.ez1;
import com.baidu.tieba.fi3;
import com.baidu.tieba.gz1;
import com.baidu.tieba.ku2;
import com.baidu.tieba.lj3;
import com.baidu.tieba.qz1;
import com.baidu.tieba.rj3;
import com.baidu.tieba.wh3;
import com.baidu.tieba.xn3;
import com.baidu.tieba.xo3;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ShowFavoriteGuideApi extends gz1 implements qz1.j {
    public String f;
    public long g;
    public long h;
    public long i;

    @Override // com.baidu.tieba.gz1
    public String h() {
        return "Favorite";
    }

    @Override // com.baidu.tieba.gz1
    public String j() {
        return "ShowFavoriteGuideApi";
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ db3 c;
        public final /* synthetic */ Activity d;

        /* renamed from: com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0207a implements Runnable {
            public final /* synthetic */ GuideType a;
            public final /* synthetic */ String b;

            public RunnableC0207a(GuideType guideType, String str) {
                this.a = guideType;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                qz1 l = qz1.l();
                a aVar = a.this;
                ShowFavoriteGuideApi showFavoriteGuideApi = ShowFavoriteGuideApi.this;
                Activity activity = aVar.d;
                db3 db3Var = aVar.c;
                l.p(showFavoriteGuideApi, activity, db3Var, this.a, this.b, db3Var.W().Q(), ShowFavoriteGuideApi.this.g);
            }
        }

        public a(String str, JSONObject jSONObject, db3 db3Var, Activity activity) {
            this.a = str;
            this.b = jSONObject;
            this.c = db3Var;
            this.d = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ku2.y0().d()) {
                return;
            }
            lj3 a = rj3.a();
            GuideType parse = GuideType.parse(this.a);
            String string = ShowFavoriteGuideApi.this.getContext().getString(parse.defaultText);
            ShowFavoriteGuideApi.this.f = this.b.optString("cb");
            String str = this.c.b;
            String str2 = "favorite_guide_count_" + str;
            if (bi2.n(str)) {
                d82.i("ShowFavoriteGuideApi", "favorite already");
                rj3.a().putString(str2, "-1");
                return;
            }
            String string2 = rj3.a().getString(str2, "");
            if (TextUtils.equals("-1", string2)) {
                d82.i("ShowFavoriteGuideApi", "favorite at one time");
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
            d82.i("ShowFavoriteGuideApi", "duration=" + ShowFavoriteGuideApi.this.g + ", mIntervalDays=" + ShowFavoriteGuideApi.this.h + ", mMaxTimes=" + ShowFavoriteGuideApi.this.i + " ,storageValue=" + string2);
            if (i2 < ShowFavoriteGuideApi.this.i && currentTimeMillis - j > ShowFavoriteGuideApi.this.h * 86400000) {
                rj3.a().putString(str2, (i2 + 1) + "#" + currentTimeMillis);
                xo3.e0(new RunnableC0207a(parse, string));
                return;
            }
            d82.i("ShowFavoriteGuideApi", "Not satisfying display conditions");
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

    public ShowFavoriteGuideApi(@NonNull ez1 ez1Var) {
        super(ez1Var);
    }

    @Override // com.baidu.tieba.qz1.j
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
            d(this.f, new d32(0, "success", jSONObject));
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
        String g0 = db3.g0();
        fi3 fi3Var = new fi3();
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
        fi3Var.b = str3;
        fi3Var.c = str;
        fi3Var.e = str2;
        fi3Var.a("appkey", g0);
        wh3.x("923", fi3Var);
    }

    public d32 G(String str) {
        q("#showFavoriteGuide", false);
        db3 b0 = db3.b0();
        if (b0 == null) {
            return new d32(1001, "SwanApp is null");
        }
        SwanAppActivity w = b0.w();
        if (w == null) {
            d82.c("ShowFavoriteGuideApi", "null activity");
            return new d32(1001, "null activity");
        } else if (!xo3.G()) {
            d82.i("ShowFavoriteGuideApi", "not support outside baiduboxapp");
            return new d32(1001, "not support outside baiduboxapp");
        } else {
            Pair<d32, JSONObject> s = s(str);
            d32 d32Var = (d32) s.first;
            if (!d32Var.isSuccess()) {
                return d32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("type");
            if (qz1.l().n(optString)) {
                return new d32(202);
            }
            xn3.g().execute(new a(optString, jSONObject, b0, w), "ShowFavoriteGuideApi");
            return d32.f();
        }
    }
}
