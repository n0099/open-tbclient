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
import com.baidu.tieba.aj2;
import com.baidu.tieba.c42;
import com.baidu.tieba.c92;
import com.baidu.tieba.cc3;
import com.baidu.tieba.d02;
import com.baidu.tieba.ej3;
import com.baidu.tieba.f02;
import com.baidu.tieba.jv2;
import com.baidu.tieba.kk3;
import com.baidu.tieba.p02;
import com.baidu.tieba.qk3;
import com.baidu.tieba.vi3;
import com.baidu.tieba.wo3;
import com.baidu.tieba.wp3;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ShowFavoriteGuideApi extends f02 implements p02.j {
    public String f;
    public long g;
    public long h;
    public long i;

    @Override // com.baidu.tieba.f02
    public String h() {
        return "Favorite";
    }

    @Override // com.baidu.tieba.f02
    public String j() {
        return "ShowFavoriteGuideApi";
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ cc3 c;
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
                p02 l = p02.l();
                a aVar = a.this;
                ShowFavoriteGuideApi showFavoriteGuideApi = ShowFavoriteGuideApi.this;
                Activity activity = aVar.d;
                cc3 cc3Var = aVar.c;
                l.p(showFavoriteGuideApi, activity, cc3Var, this.a, this.b, cc3Var.W().Q(), ShowFavoriteGuideApi.this.g);
            }
        }

        public a(String str, JSONObject jSONObject, cc3 cc3Var, Activity activity) {
            this.a = str;
            this.b = jSONObject;
            this.c = cc3Var;
            this.d = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (jv2.y0().d()) {
                return;
            }
            kk3 a = qk3.a();
            GuideType parse = GuideType.parse(this.a);
            String string = ShowFavoriteGuideApi.this.getContext().getString(parse.defaultText);
            ShowFavoriteGuideApi.this.f = this.b.optString("cb");
            String str = this.c.b;
            String str2 = "favorite_guide_count_" + str;
            if (aj2.n(str)) {
                c92.i("ShowFavoriteGuideApi", "favorite already");
                qk3.a().putString(str2, "-1");
                return;
            }
            String string2 = qk3.a().getString(str2, "");
            if (TextUtils.equals("-1", string2)) {
                c92.i("ShowFavoriteGuideApi", "favorite at one time");
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
            c92.i("ShowFavoriteGuideApi", "duration=" + ShowFavoriteGuideApi.this.g + ", mIntervalDays=" + ShowFavoriteGuideApi.this.h + ", mMaxTimes=" + ShowFavoriteGuideApi.this.i + " ,storageValue=" + string2);
            if (i2 < ShowFavoriteGuideApi.this.i && currentTimeMillis - j > ShowFavoriteGuideApi.this.h * 86400000) {
                qk3.a().putString(str2, (i2 + 1) + "#" + currentTimeMillis);
                wp3.e0(new RunnableC0207a(parse, string));
                return;
            }
            c92.i("ShowFavoriteGuideApi", "Not satisfying display conditions");
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

    public ShowFavoriteGuideApi(@NonNull d02 d02Var) {
        super(d02Var);
    }

    @Override // com.baidu.tieba.p02.j
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
            d(this.f, new c42(0, "success", jSONObject));
        }
    }

    /* loaded from: classes4.dex */
    public enum GuideType {
        NORMAL("bar", -1, 992, R.string.obfuscated_res_0x7f0f018a),
        WEAK("bar-autohide", -1, 865, R.string.obfuscated_res_0x7f0f018a),
        TIPS("tip", 18, -1, R.string.obfuscated_res_0x7f0f018b);
        
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
        String g0 = cc3.g0();
        ej3 ej3Var = new ej3();
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
        ej3Var.b = str3;
        ej3Var.c = str;
        ej3Var.e = str2;
        ej3Var.a("appkey", g0);
        vi3.x("923", ej3Var);
    }

    public c42 G(String str) {
        q("#showFavoriteGuide", false);
        cc3 b0 = cc3.b0();
        if (b0 == null) {
            return new c42(1001, "SwanApp is null");
        }
        SwanAppActivity w = b0.w();
        if (w == null) {
            c92.c("ShowFavoriteGuideApi", "null activity");
            return new c42(1001, "null activity");
        } else if (!wp3.G()) {
            c92.i("ShowFavoriteGuideApi", "not support outside baiduboxapp");
            return new c42(1001, "not support outside baiduboxapp");
        } else {
            Pair<c42, JSONObject> s = s(str);
            c42 c42Var = (c42) s.first;
            if (!c42Var.isSuccess()) {
                return c42Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("type");
            if (p02.l().n(optString)) {
                return new c42(202);
            }
            wo3.g().execute(new a(optString, jSONObject, b0, w), "ShowFavoriteGuideApi");
            return c42.f();
        }
    }
}
