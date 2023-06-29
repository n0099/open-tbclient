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
import com.baidu.tieba.c31;
import com.baidu.tieba.d31;
import com.baidu.tieba.dm0;
import com.baidu.tieba.fs0;
import com.baidu.tieba.hm0;
import com.baidu.tieba.hn0;
import com.baidu.tieba.jm0;
import com.baidu.tieba.k51;
import com.baidu.tieba.km0;
import com.baidu.tieba.nn0;
import com.baidu.tieba.pm0;
import com.baidu.tieba.pt0;
import com.baidu.tieba.r31;
import com.baidu.tieba.ul0;
import com.baidu.tieba.wm0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LPDownloadManager {
    public static LruCache<String, pm0> a;
    public static Map<String, Integer> b;
    public static final List<String> c = new ArrayList<String>() { // from class: com.baidu.nadcore.download.presenter.LPDownloadManager.1
        {
            add("https://cover.baidu.com");
            add("http://cover.baidu.com");
        }
    };

    /* loaded from: classes3.dex */
    public static class a extends pt0<km0> {
        public final /* synthetic */ RelativeLayout a;
        public final /* synthetic */ dm0 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Context e;

        @Override // com.baidu.tieba.nt0
        public void a(Exception exc, int i) {
        }

        public a(RelativeLayout relativeLayout, dm0 dm0Var, String str, int i, Context context) {
            this.a = relativeLayout;
            this.b = dm0Var;
            this.c = str;
            this.d = i;
            this.e = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ot0
        /* renamed from: f */
        public km0 d(Headers headers, String str, int i) {
            return km0.a(c31.c(str).optJSONObject("data"));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ot0
        /* renamed from: e */
        public void b(Headers headers, km0 km0Var, int i) {
            if (km0Var == null) {
                return;
            }
            int i2 = km0Var.a;
            if (i2 == 1) {
                pm0 d = LPDownloadManager.d(this.a, this.b, this.c);
                d.A(km0Var);
                d.B(true);
                d.m();
            } else if (i2 != 2 && i2 != 3) {
                k51.a().a(this.e, R.string.nad_download_lp_forbid_tip);
            } else {
                fs0 fs0Var = km0Var.b;
                if (fs0Var != null) {
                    if (this.d == 1) {
                        LPDownloadManager.g(this.b, fs0Var);
                        pm0 d2 = LPDownloadManager.d(this.a, this.b, this.c);
                        d2.A(km0Var);
                        d2.B(false);
                        d2.D(this.a, km0Var, this.e);
                    } else if (this.e instanceof Activity) {
                        LPDownloadManager.g(this.b, fs0Var);
                        pm0 d3 = LPDownloadManager.d(this.a, this.b, this.c);
                        d3.A(km0Var);
                        d3.B(false);
                        d3.C(this.a, km0Var, (Activity) this.e);
                    }
                }
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).p(this.b.p.a).u(ClogBuilder.Page.DOWNLOAD_RECTIFY).k(String.valueOf(km0Var.a)).l(this.c);
            r31.b(clogBuilder);
        }
    }

    public static void g(@NonNull dm0 dm0Var, @NonNull fs0 fs0Var) {
        dm0Var.g = fs0Var.j;
        hm0 hm0Var = dm0Var.p;
        hm0Var.g = fs0Var.b;
        hm0Var.h = fs0Var.c;
    }

    public static dm0 c(@NonNull String str) {
        JSONObject c2 = c31.c(str);
        String optString = c2.optString("key", "");
        if (TextUtils.isEmpty(optString)) {
            optString = c2.optString("lp_url", "");
        }
        dm0 query = ul0.b().query(optString);
        if (query != null) {
            return query;
        }
        dm0 dm0Var = new dm0();
        dm0Var.g = c2.optString("url", "");
        dm0Var.h(optString);
        dm0Var.q.a = c2.optString(BdVideoAd.AD_VIDEO_DAPAGE, "");
        dm0Var.q.j = c2.optString("da_area", "");
        dm0Var.q.b = c2.optString("business");
        dm0Var.q.d = c2.optString("content_type");
        dm0Var.q.e = c2.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
        dm0Var.q.g = c2.optInt("close_v_dl");
        dm0Var.p.a = c2.optString("log_ext");
        dm0Var.p.j = c2.optString(LegoListActivityConfig.AD_ID);
        dm0Var.p.g = c2.optString("app_icon");
        dm0Var.p.h = c2.optString("app_name");
        return dm0Var;
    }

    public static pm0 d(RelativeLayout relativeLayout, dm0 dm0Var, String str) {
        int i;
        wm0<?> a2 = nn0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
        pm0 pm0Var = new pm0(dm0Var, a2);
        if (a == null) {
            a = new LruCache<>(32);
        }
        d31.e(a, dm0Var.e(), pm0Var);
        return pm0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(@NonNull Context context, @NonNull RelativeLayout relativeLayout, String str, @NonNull dm0 dm0Var, int i) {
        for (String str2 : c) {
            if (dm0Var.g.startsWith(str2) || str.startsWith(str2)) {
                pm0 d = d(relativeLayout, dm0Var, str);
                d.B(true);
                d.m();
                return;
            }
            while (r0.hasNext()) {
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ext", dm0Var.p.a);
        linkedHashMap.put("charge_url", str);
        linkedHashMap.put("apk_url", dm0Var.g);
        new jm0().b(linkedHashMap, new a(relativeLayout, dm0Var, str, i, context));
    }

    public static boolean f(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        int i;
        if (context == null || relativeLayout == null || TextUtils.isEmpty(str)) {
            return false;
        }
        dm0 c2 = c(str);
        if (c2.f()) {
            return false;
        }
        JSONObject c3 = c31.c(str);
        String optString = c3.optString("lp_url", "");
        int optInt = c3.optInt("lp_check_mode", 0);
        pm0 pm0Var = (pm0) d31.b(a, c2.e());
        if (pm0Var != null) {
            if (z && c2.c != AdDownloadStatus.DOWNLOADING && pm0Var.y()) {
                pm0Var.m();
            }
            if (pm0Var.z()) {
                wm0<?> a2 = nn0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
                pm0Var.t(a2);
                if (!pm0Var.y()) {
                    if (optInt == 1) {
                        pm0Var.D(relativeLayout, pm0Var.x(), context);
                    } else if (context instanceof Activity) {
                        pm0Var.C(relativeLayout, pm0Var.x(), (Activity) context);
                    }
                }
            }
            return true;
        } else if (hn0.a(str, optString)) {
            pm0 d = d(relativeLayout, c2, optString);
            d.B(true);
            d.m();
            return true;
        } else {
            e(context, relativeLayout, optString, c2, optInt);
            return true;
        }
    }
}
