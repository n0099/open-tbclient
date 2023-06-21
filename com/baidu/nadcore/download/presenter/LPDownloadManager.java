package com.baidu.nadcore.download.presenter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.download.view.DefaultDownloadViewLP;
import com.baidu.nadcore.download.view.IDownloadViewCreator;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.utils.LruCache;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.a31;
import com.baidu.tieba.am0;
import com.baidu.tieba.cs0;
import com.baidu.tieba.em0;
import com.baidu.tieba.en0;
import com.baidu.tieba.gm0;
import com.baidu.tieba.h51;
import com.baidu.tieba.hm0;
import com.baidu.tieba.kn0;
import com.baidu.tieba.mm0;
import com.baidu.tieba.mt0;
import com.baidu.tieba.o31;
import com.baidu.tieba.rl0;
import com.baidu.tieba.tm0;
import com.baidu.tieba.z21;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LPDownloadManager {
    public static LruCache<String, mm0> a;
    public static Map<String, Integer> b;
    public static final List<String> c = new ArrayList<String>() { // from class: com.baidu.nadcore.download.presenter.LPDownloadManager.1
        {
            add("https://cover.baidu.com");
            add("http://cover.baidu.com");
        }
    };

    /* loaded from: classes3.dex */
    public static class a extends mt0<hm0> {
        public final /* synthetic */ RelativeLayout a;
        public final /* synthetic */ am0 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Context e;

        @Override // com.baidu.tieba.kt0
        public void a(Exception exc, int i) {
        }

        public a(RelativeLayout relativeLayout, am0 am0Var, String str, int i, Context context) {
            this.a = relativeLayout;
            this.b = am0Var;
            this.c = str;
            this.d = i;
            this.e = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lt0
        /* renamed from: f */
        public hm0 d(Headers headers, String str, int i) {
            return hm0.a(z21.c(str).optJSONObject("data"));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lt0
        /* renamed from: e */
        public void b(Headers headers, hm0 hm0Var, int i) {
            if (hm0Var == null) {
                return;
            }
            int i2 = hm0Var.a;
            if (i2 == 1) {
                mm0 d = LPDownloadManager.d(this.a, this.b, this.c);
                d.A(hm0Var);
                d.B(true);
                d.m();
            } else if (i2 != 2 && i2 != 3) {
                h51.a().a(this.e, R.string.nad_download_lp_forbid_tip);
            } else {
                cs0 cs0Var = hm0Var.b;
                if (cs0Var != null) {
                    if (this.d == 1) {
                        LPDownloadManager.g(this.b, cs0Var);
                        mm0 d2 = LPDownloadManager.d(this.a, this.b, this.c);
                        d2.A(hm0Var);
                        d2.B(false);
                        d2.D(this.a, hm0Var, this.e);
                    } else if (this.e instanceof Activity) {
                        LPDownloadManager.g(this.b, cs0Var);
                        mm0 d3 = LPDownloadManager.d(this.a, this.b, this.c);
                        d3.A(hm0Var);
                        d3.B(false);
                        d3.C(this.a, hm0Var, (Activity) this.e);
                    }
                }
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).p(this.b.p.a).u(ClogBuilder.Page.DOWNLOAD_RECTIFY).k(String.valueOf(hm0Var.a)).l(this.c);
            o31.b(clogBuilder);
        }
    }

    public static void g(@NonNull am0 am0Var, @NonNull cs0 cs0Var) {
        am0Var.g = cs0Var.j;
        em0 em0Var = am0Var.p;
        em0Var.g = cs0Var.b;
        em0Var.h = cs0Var.c;
    }

    public static am0 c(@NonNull String str) {
        JSONObject c2 = z21.c(str);
        String optString = c2.optString("key", "");
        if (TextUtils.isEmpty(optString)) {
            optString = c2.optString("lp_url", "");
        }
        am0 query = rl0.b().query(optString);
        if (query != null) {
            return query;
        }
        am0 am0Var = new am0();
        am0Var.g = c2.optString("url", "");
        am0Var.h(optString);
        am0Var.q.a = c2.optString(BdVideoAd.AD_VIDEO_DAPAGE, "");
        am0Var.q.j = c2.optString("da_area", "");
        am0Var.q.b = c2.optString("business");
        am0Var.q.d = c2.optString("content_type");
        am0Var.q.e = c2.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
        am0Var.q.g = c2.optInt("close_v_dl");
        am0Var.p.a = c2.optString("log_ext");
        am0Var.p.j = c2.optString(LegoListActivityConfig.AD_ID);
        am0Var.p.g = c2.optString("app_icon");
        am0Var.p.h = c2.optString("app_name");
        return am0Var;
    }

    public static mm0 d(RelativeLayout relativeLayout, am0 am0Var, String str) {
        int i;
        tm0<?> a2 = kn0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
        Map<String, Integer> map = b;
        if (map != null && (a2 instanceof DefaultDownloadViewLP)) {
            Integer num = map.get(str);
            DefaultDownloadViewLP defaultDownloadViewLP = (DefaultDownloadViewLP) a2;
            if (num != null) {
                i = num.intValue();
            } else {
                i = -1;
            }
            defaultDownloadViewLP.setAbsorbColor(i);
        }
        mm0 mm0Var = new mm0(am0Var, a2);
        if (a == null) {
            a = new LruCache<>(32);
        }
        a31.e(a, am0Var.e(), mm0Var);
        return mm0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(@NonNull Context context, @NonNull RelativeLayout relativeLayout, String str, @NonNull am0 am0Var, int i) {
        for (String str2 : c) {
            if (am0Var.g.startsWith(str2) || str.startsWith(str2)) {
                mm0 d = d(relativeLayout, am0Var, str);
                d.B(true);
                d.m();
                return;
            }
            while (r0.hasNext()) {
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ext", am0Var.p.a);
        linkedHashMap.put("charge_url", str);
        linkedHashMap.put("apk_url", am0Var.g);
        new gm0().b(linkedHashMap, new a(relativeLayout, am0Var, str, i, context));
    }

    public static boolean f(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        int i;
        if (context == null || relativeLayout == null || TextUtils.isEmpty(str)) {
            return false;
        }
        am0 c2 = c(str);
        if (c2.f()) {
            return false;
        }
        JSONObject c3 = z21.c(str);
        String optString = c3.optString("lp_url", "");
        int optInt = c3.optInt("lp_check_mode", 0);
        mm0 mm0Var = (mm0) a31.b(a, c2.e());
        if (mm0Var != null) {
            if (z && c2.c != AdDownloadStatus.DOWNLOADING && mm0Var.y()) {
                mm0Var.m();
            }
            if (mm0Var.z()) {
                tm0<?> a2 = kn0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
                Map<String, Integer> map = b;
                if (map != null && (a2 instanceof DefaultDownloadViewLP)) {
                    Integer num = map.get(optString);
                    DefaultDownloadViewLP defaultDownloadViewLP = (DefaultDownloadViewLP) a2;
                    if (num != null) {
                        i = num.intValue();
                    } else {
                        i = -1;
                    }
                    defaultDownloadViewLP.setAbsorbColor(i);
                }
                mm0Var.t(a2);
                if (!mm0Var.y()) {
                    if (optInt == 1) {
                        mm0Var.D(relativeLayout, mm0Var.x(), context);
                    } else if (context instanceof Activity) {
                        mm0Var.C(relativeLayout, mm0Var.x(), (Activity) context);
                    }
                }
            }
            return true;
        } else if (en0.a(str, optString)) {
            mm0 d = d(relativeLayout, c2, optString);
            d.B(true);
            d.m();
            return true;
        } else {
            e(context, relativeLayout, optString, c2, optInt);
            return true;
        }
    }
}
