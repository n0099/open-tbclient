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
import com.baidu.tieba.aj3;
import com.baidu.tieba.ak3;
import com.baidu.tieba.ed2;
import com.baidu.tieba.g32;
import com.baidu.tieba.g63;
import com.baidu.tieba.hy1;
import com.baidu.tieba.id3;
import com.baidu.tieba.iu1;
import com.baidu.tieba.ku1;
import com.baidu.tieba.np2;
import com.baidu.tieba.oe3;
import com.baidu.tieba.ue3;
import com.baidu.tieba.uu1;
import com.baidu.tieba.zc3;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ShowFavoriteGuideApi extends ku1 implements uu1.j {
    public String f;
    public long g;
    public long h;
    public long i;

    @Override // com.baidu.tieba.ku1
    public String h() {
        return "Favorite";
    }

    @Override // com.baidu.tieba.ku1
    public String k() {
        return "ShowFavoriteGuideApi";
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ g63 c;
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
                uu1 l = uu1.l();
                a aVar = a.this;
                ShowFavoriteGuideApi showFavoriteGuideApi = ShowFavoriteGuideApi.this;
                Activity activity = aVar.d;
                g63 g63Var = aVar.c;
                l.p(showFavoriteGuideApi, activity, g63Var, this.a, this.b, g63Var.X().R(), ShowFavoriteGuideApi.this.g);
            }
        }

        public a(String str, JSONObject jSONObject, g63 g63Var, Activity activity) {
            this.a = str;
            this.b = jSONObject;
            this.c = g63Var;
            this.d = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (np2.y0().d()) {
                return;
            }
            oe3 a = ue3.a();
            GuideType parse = GuideType.parse(this.a);
            String string = ShowFavoriteGuideApi.this.i().getString(parse.defaultText);
            ShowFavoriteGuideApi.this.f = this.b.optString("cb");
            String str = this.c.b;
            String str2 = "favorite_guide_count_" + str;
            if (ed2.n(str)) {
                g32.i("ShowFavoriteGuideApi", "favorite already");
                ue3.a().putString(str2, "-1");
                return;
            }
            String string2 = ue3.a().getString(str2, "");
            if (TextUtils.equals("-1", string2)) {
                g32.i("ShowFavoriteGuideApi", "favorite at one time");
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
            g32.i("ShowFavoriteGuideApi", "duration=" + ShowFavoriteGuideApi.this.g + ", mIntervalDays=" + ShowFavoriteGuideApi.this.h + ", mMaxTimes=" + ShowFavoriteGuideApi.this.i + " ,storageValue=" + string2);
            if (i2 < ShowFavoriteGuideApi.this.i && currentTimeMillis - j > ShowFavoriteGuideApi.this.h * 86400000) {
                ue3.a().putString(str2, (i2 + 1) + "#" + currentTimeMillis);
                ak3.e0(new RunnableC0199a(parse, string));
                return;
            }
            g32.i("ShowFavoriteGuideApi", "Not satisfying display conditions");
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

    public ShowFavoriteGuideApi(@NonNull iu1 iu1Var) {
        super(iu1Var);
    }

    @Override // com.baidu.tieba.uu1.j
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
            d(this.f, new hy1(0, "success", jSONObject));
        }
    }

    /* loaded from: classes4.dex */
    public enum GuideType {
        NORMAL("bar", -1, 992, R.string.obfuscated_res_0x7f0f018d),
        WEAK("bar-autohide", -1, 865, R.string.obfuscated_res_0x7f0f018d),
        TIPS("tip", 18, -1, R.string.obfuscated_res_0x7f0f018e);
        
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
        String h0 = g63.h0();
        id3 id3Var = new id3();
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
        id3Var.b = str3;
        id3Var.c = str;
        id3Var.e = str2;
        id3Var.a("appkey", h0);
        zc3.x("923", id3Var);
    }

    public hy1 H(String str) {
        r("#showFavoriteGuide", false);
        g63 c0 = g63.c0();
        if (c0 == null) {
            return new hy1(1001, "SwanApp is null");
        }
        SwanAppActivity w = c0.w();
        if (w == null) {
            g32.c("ShowFavoriteGuideApi", "null activity");
            return new hy1(1001, "null activity");
        } else if (!ak3.G()) {
            g32.i("ShowFavoriteGuideApi", "not support outside baiduboxapp");
            return new hy1(1001, "not support outside baiduboxapp");
        } else {
            Pair<hy1, JSONObject> t = t(str);
            hy1 hy1Var = (hy1) t.first;
            if (!hy1Var.isSuccess()) {
                return hy1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            String optString = jSONObject.optString("type");
            if (uu1.l().n(optString)) {
                return new hy1(202);
            }
            aj3.g().execute(new a(optString, jSONObject, c0, w), "ShowFavoriteGuideApi");
            return hy1.f();
        }
    }
}
