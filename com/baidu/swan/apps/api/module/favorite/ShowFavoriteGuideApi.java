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
import com.baidu.tieba.dd3;
import com.baidu.tieba.ej3;
import com.baidu.tieba.ek3;
import com.baidu.tieba.id2;
import com.baidu.tieba.k32;
import com.baidu.tieba.k63;
import com.baidu.tieba.ly1;
import com.baidu.tieba.md3;
import com.baidu.tieba.mu1;
import com.baidu.tieba.ou1;
import com.baidu.tieba.rp2;
import com.baidu.tieba.se3;
import com.baidu.tieba.ye3;
import com.baidu.tieba.yu1;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ShowFavoriteGuideApi extends ou1 implements yu1.j {
    public String f;
    public long g;
    public long h;
    public long i;

    @Override // com.baidu.tieba.ou1
    public String h() {
        return "Favorite";
    }

    @Override // com.baidu.tieba.ou1
    public String k() {
        return "ShowFavoriteGuideApi";
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ k63 c;
        public final /* synthetic */ Activity d;

        /* renamed from: com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0199a implements Runnable {
            public final /* synthetic */ GuideType a;
            public final /* synthetic */ String b;

            public RunnableC0199a(GuideType guideType, String str) {
                this.a = guideType;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                yu1 l = yu1.l();
                a aVar = a.this;
                ShowFavoriteGuideApi showFavoriteGuideApi = ShowFavoriteGuideApi.this;
                Activity activity = aVar.d;
                k63 k63Var = aVar.c;
                l.p(showFavoriteGuideApi, activity, k63Var, this.a, this.b, k63Var.X().R(), ShowFavoriteGuideApi.this.g);
            }
        }

        public a(String str, JSONObject jSONObject, k63 k63Var, Activity activity) {
            this.a = str;
            this.b = jSONObject;
            this.c = k63Var;
            this.d = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (rp2.y0().d()) {
                return;
            }
            se3 a = ye3.a();
            GuideType parse = GuideType.parse(this.a);
            String string = ShowFavoriteGuideApi.this.i().getString(parse.defaultText);
            ShowFavoriteGuideApi.this.f = this.b.optString("cb");
            String str = this.c.b;
            String str2 = "favorite_guide_count_" + str;
            if (id2.n(str)) {
                k32.i("ShowFavoriteGuideApi", "favorite already");
                ye3.a().putString(str2, "-1");
                return;
            }
            String string2 = ye3.a().getString(str2, "");
            if (TextUtils.equals("-1", string2)) {
                k32.i("ShowFavoriteGuideApi", "favorite at one time");
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
            k32.i("ShowFavoriteGuideApi", "duration=" + ShowFavoriteGuideApi.this.g + ", mIntervalDays=" + ShowFavoriteGuideApi.this.h + ", mMaxTimes=" + ShowFavoriteGuideApi.this.i + " ,storageValue=" + string2);
            if (i2 < ShowFavoriteGuideApi.this.i && currentTimeMillis - j > ShowFavoriteGuideApi.this.h * 86400000) {
                ye3.a().putString(str2, (i2 + 1) + "#" + currentTimeMillis);
                ek3.e0(new RunnableC0199a(parse, string));
                return;
            }
            k32.i("ShowFavoriteGuideApi", "Not satisfying display conditions");
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

    public ShowFavoriteGuideApi(@NonNull mu1 mu1Var) {
        super(mu1Var);
    }

    @Override // com.baidu.tieba.yu1.j
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
            d(this.f, new ly1(0, "success", jSONObject));
        }
    }

    /* loaded from: classes4.dex */
    public enum GuideType {
        NORMAL("bar", -1, 992, R.string.obfuscated_res_0x7f0f0195),
        WEAK("bar-autohide", -1, 865, R.string.obfuscated_res_0x7f0f0195),
        TIPS("tip", 18, -1, R.string.obfuscated_res_0x7f0f0196);
        
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

    public static void G(GuideType guideType, String str, String str2) {
        String str3;
        String h0 = k63.h0();
        md3 md3Var = new md3();
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
        md3Var.b = str3;
        md3Var.c = str;
        md3Var.e = str2;
        md3Var.a("appkey", h0);
        dd3.x("923", md3Var);
    }

    public ly1 H(String str) {
        r("#showFavoriteGuide", false);
        k63 c0 = k63.c0();
        if (c0 == null) {
            return new ly1(1001, "SwanApp is null");
        }
        SwanAppActivity w = c0.w();
        if (w == null) {
            k32.c("ShowFavoriteGuideApi", "null activity");
            return new ly1(1001, "null activity");
        } else if (!ek3.G()) {
            k32.i("ShowFavoriteGuideApi", "not support outside baiduboxapp");
            return new ly1(1001, "not support outside baiduboxapp");
        } else {
            Pair<ly1, JSONObject> t = t(str);
            ly1 ly1Var = (ly1) t.first;
            if (!ly1Var.isSuccess()) {
                return ly1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            String optString = jSONObject.optString("type");
            if (yu1.l().n(optString)) {
                return new ly1(202);
            }
            ej3.g().execute(new a(optString, jSONObject, c0, w), "ShowFavoriteGuideApi");
            return ly1.f();
        }
    }
}
