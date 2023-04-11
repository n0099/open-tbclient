package com.baidu.swan.apps.api.module.favorite;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.br2;
import com.baidu.tieba.cg3;
import com.baidu.tieba.hw1;
import com.baidu.tieba.ig3;
import com.baidu.tieba.ne3;
import com.baidu.tieba.ok3;
import com.baidu.tieba.ol3;
import com.baidu.tieba.se2;
import com.baidu.tieba.u42;
import com.baidu.tieba.u73;
import com.baidu.tieba.uz1;
import com.baidu.tieba.vv1;
import com.baidu.tieba.we3;
import com.baidu.tieba.xv1;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ShowFavoriteGuideApi extends xv1 implements hw1.j {
    public String f;
    public long g;
    public long h;
    public long i;

    @Override // com.baidu.tieba.xv1
    public String h() {
        return "Favorite";
    }

    @Override // com.baidu.tieba.xv1
    public String j() {
        return "ShowFavoriteGuideApi";
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ u73 c;
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
                hw1 l = hw1.l();
                a aVar = a.this;
                ShowFavoriteGuideApi showFavoriteGuideApi = ShowFavoriteGuideApi.this;
                Activity activity = aVar.d;
                u73 u73Var = aVar.c;
                l.p(showFavoriteGuideApi, activity, u73Var, this.a, this.b, u73Var.W().Q(), ShowFavoriteGuideApi.this.g);
            }
        }

        public a(String str, JSONObject jSONObject, u73 u73Var, Activity activity) {
            this.a = str;
            this.b = jSONObject;
            this.c = u73Var;
            this.d = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (br2.y0().d()) {
                return;
            }
            cg3 a = ig3.a();
            GuideType parse = GuideType.parse(this.a);
            String string = ShowFavoriteGuideApi.this.getContext().getString(parse.defaultText);
            ShowFavoriteGuideApi.this.f = this.b.optString("cb");
            String str = this.c.b;
            String str2 = "favorite_guide_count_" + str;
            if (se2.n(str)) {
                u42.i("ShowFavoriteGuideApi", "favorite already");
                ig3.a().putString(str2, "-1");
                return;
            }
            String string2 = ig3.a().getString(str2, "");
            if (TextUtils.equals("-1", string2)) {
                u42.i("ShowFavoriteGuideApi", "favorite at one time");
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
            u42.i("ShowFavoriteGuideApi", "duration=" + ShowFavoriteGuideApi.this.g + ", mIntervalDays=" + ShowFavoriteGuideApi.this.h + ", mMaxTimes=" + ShowFavoriteGuideApi.this.i + " ,storageValue=" + string2);
            if (i2 < ShowFavoriteGuideApi.this.i && currentTimeMillis - j > ShowFavoriteGuideApi.this.h * 86400000) {
                ig3.a().putString(str2, (i2 + 1) + "#" + currentTimeMillis);
                ol3.e0(new RunnableC0181a(parse, string));
                return;
            }
            u42.i("ShowFavoriteGuideApi", "Not satisfying display conditions");
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

    public ShowFavoriteGuideApi(@NonNull vv1 vv1Var) {
        super(vv1Var);
    }

    @Override // com.baidu.tieba.hw1.j
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
            d(this.f, new uz1(0, "success", jSONObject));
        }
    }

    /* loaded from: classes3.dex */
    public enum GuideType {
        NORMAL("bar", -1, 992, R.string.obfuscated_res_0x7f0f0160),
        WEAK("bar-autohide", -1, 865, R.string.obfuscated_res_0x7f0f0160),
        TIPS("tip", 18, -1, R.string.obfuscated_res_0x7f0f0161);
        
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
        String g0 = u73.g0();
        we3 we3Var = new we3();
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
        we3Var.b = str3;
        we3Var.c = str;
        we3Var.e = str2;
        we3Var.a("appkey", g0);
        ne3.x("923", we3Var);
    }

    public uz1 G(String str) {
        q("#showFavoriteGuide", false);
        u73 b0 = u73.b0();
        if (b0 == null) {
            return new uz1(1001, "SwanApp is null");
        }
        SwanAppActivity w = b0.w();
        if (w == null) {
            u42.c("ShowFavoriteGuideApi", "null activity");
            return new uz1(1001, "null activity");
        } else if (!ol3.G()) {
            u42.i("ShowFavoriteGuideApi", "not support outside baiduboxapp");
            return new uz1(1001, "not support outside baiduboxapp");
        } else {
            Pair<uz1, JSONObject> s = s(str);
            uz1 uz1Var = (uz1) s.first;
            if (!uz1Var.isSuccess()) {
                return uz1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("type");
            if (hw1.l().n(optString)) {
                return new uz1(202);
            }
            ok3.g().execute(new a(optString, jSONObject, b0, w), "ShowFavoriteGuideApi");
            return uz1.f();
        }
    }
}
