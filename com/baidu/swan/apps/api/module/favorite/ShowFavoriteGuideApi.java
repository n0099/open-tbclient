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
import com.baidu.tieba.cv2;
import com.baidu.tieba.dk3;
import com.baidu.tieba.i02;
import com.baidu.tieba.jk3;
import com.baidu.tieba.oi3;
import com.baidu.tieba.po3;
import com.baidu.tieba.pp3;
import com.baidu.tieba.ti2;
import com.baidu.tieba.v32;
import com.baidu.tieba.v82;
import com.baidu.tieba.vb3;
import com.baidu.tieba.wz1;
import com.baidu.tieba.xi3;
import com.baidu.tieba.yz1;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ShowFavoriteGuideApi extends yz1 implements i02.j {
    public String f;
    public long g;
    public long h;
    public long i;

    @Override // com.baidu.tieba.yz1
    public String h() {
        return "Favorite";
    }

    @Override // com.baidu.tieba.yz1
    public String j() {
        return "ShowFavoriteGuideApi";
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ vb3 c;
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
                i02 l = i02.l();
                a aVar = a.this;
                ShowFavoriteGuideApi showFavoriteGuideApi = ShowFavoriteGuideApi.this;
                Activity activity = aVar.d;
                vb3 vb3Var = aVar.c;
                l.p(showFavoriteGuideApi, activity, vb3Var, this.a, this.b, vb3Var.W().Q(), ShowFavoriteGuideApi.this.g);
            }
        }

        public a(String str, JSONObject jSONObject, vb3 vb3Var, Activity activity) {
            this.a = str;
            this.b = jSONObject;
            this.c = vb3Var;
            this.d = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (cv2.y0().d()) {
                return;
            }
            dk3 a = jk3.a();
            GuideType parse = GuideType.parse(this.a);
            String string = ShowFavoriteGuideApi.this.getContext().getString(parse.defaultText);
            ShowFavoriteGuideApi.this.f = this.b.optString("cb");
            String str = this.c.b;
            String str2 = "favorite_guide_count_" + str;
            if (ti2.n(str)) {
                v82.i("ShowFavoriteGuideApi", "favorite already");
                jk3.a().putString(str2, "-1");
                return;
            }
            String string2 = jk3.a().getString(str2, "");
            if (TextUtils.equals("-1", string2)) {
                v82.i("ShowFavoriteGuideApi", "favorite at one time");
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
            v82.i("ShowFavoriteGuideApi", "duration=" + ShowFavoriteGuideApi.this.g + ", mIntervalDays=" + ShowFavoriteGuideApi.this.h + ", mMaxTimes=" + ShowFavoriteGuideApi.this.i + " ,storageValue=" + string2);
            if (i2 < ShowFavoriteGuideApi.this.i && currentTimeMillis - j > ShowFavoriteGuideApi.this.h * 86400000) {
                jk3.a().putString(str2, (i2 + 1) + "#" + currentTimeMillis);
                pp3.e0(new RunnableC0207a(parse, string));
                return;
            }
            v82.i("ShowFavoriteGuideApi", "Not satisfying display conditions");
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

    public ShowFavoriteGuideApi(@NonNull wz1 wz1Var) {
        super(wz1Var);
    }

    @Override // com.baidu.tieba.i02.j
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
            d(this.f, new v32(0, "success", jSONObject));
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
        String g0 = vb3.g0();
        xi3 xi3Var = new xi3();
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
        xi3Var.b = str3;
        xi3Var.c = str;
        xi3Var.e = str2;
        xi3Var.a("appkey", g0);
        oi3.x("923", xi3Var);
    }

    public v32 G(String str) {
        q("#showFavoriteGuide", false);
        vb3 b0 = vb3.b0();
        if (b0 == null) {
            return new v32(1001, "SwanApp is null");
        }
        SwanAppActivity w = b0.w();
        if (w == null) {
            v82.c("ShowFavoriteGuideApi", "null activity");
            return new v32(1001, "null activity");
        } else if (!pp3.G()) {
            v82.i("ShowFavoriteGuideApi", "not support outside baiduboxapp");
            return new v32(1001, "not support outside baiduboxapp");
        } else {
            Pair<v32, JSONObject> s = s(str);
            v32 v32Var = (v32) s.first;
            if (!v32Var.isSuccess()) {
                return v32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("type");
            if (i02.l().n(optString)) {
                return new v32(202);
            }
            po3.g().execute(new a(optString, jSONObject, b0, w), "ShowFavoriteGuideApi");
            return v32.f();
        }
    }
}
