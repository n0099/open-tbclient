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
import com.baidu.tieba.bs0;
import com.baidu.tieba.dm0;
import com.baidu.tieba.dn0;
import com.baidu.tieba.fm0;
import com.baidu.tieba.g51;
import com.baidu.tieba.gm0;
import com.baidu.tieba.jn0;
import com.baidu.tieba.lm0;
import com.baidu.tieba.lt0;
import com.baidu.tieba.n31;
import com.baidu.tieba.ql0;
import com.baidu.tieba.sm0;
import com.baidu.tieba.y21;
import com.baidu.tieba.z21;
import com.baidu.tieba.zl0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LPDownloadManager {
    public static LruCache<String, lm0> a;
    public static Map<String, Integer> b;
    public static final List<String> c = new ArrayList<String>() { // from class: com.baidu.nadcore.download.presenter.LPDownloadManager.1
        {
            add("https://cover.baidu.com");
            add("http://cover.baidu.com");
        }
    };

    /* loaded from: classes3.dex */
    public static class a extends lt0<gm0> {
        public final /* synthetic */ RelativeLayout a;
        public final /* synthetic */ zl0 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Context e;

        @Override // com.baidu.tieba.jt0
        public void a(Exception exc, int i) {
        }

        public a(RelativeLayout relativeLayout, zl0 zl0Var, String str, int i, Context context) {
            this.a = relativeLayout;
            this.b = zl0Var;
            this.c = str;
            this.d = i;
            this.e = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kt0
        /* renamed from: f */
        public gm0 d(Headers headers, String str, int i) {
            return gm0.a(y21.c(str).optJSONObject("data"));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kt0
        /* renamed from: e */
        public void b(Headers headers, gm0 gm0Var, int i) {
            if (gm0Var == null) {
                return;
            }
            int i2 = gm0Var.a;
            if (i2 == 1) {
                lm0 d = LPDownloadManager.d(this.a, this.b, this.c);
                d.A(gm0Var);
                d.B(true);
                d.m();
            } else if (i2 != 2 && i2 != 3) {
                g51.a().a(this.e, R.string.nad_download_lp_forbid_tip);
            } else {
                bs0 bs0Var = gm0Var.b;
                if (bs0Var != null) {
                    if (this.d == 1) {
                        LPDownloadManager.g(this.b, bs0Var);
                        lm0 d2 = LPDownloadManager.d(this.a, this.b, this.c);
                        d2.A(gm0Var);
                        d2.B(false);
                        d2.D(this.a, gm0Var, this.e);
                    } else if (this.e instanceof Activity) {
                        LPDownloadManager.g(this.b, bs0Var);
                        lm0 d3 = LPDownloadManager.d(this.a, this.b, this.c);
                        d3.A(gm0Var);
                        d3.B(false);
                        d3.C(this.a, gm0Var, (Activity) this.e);
                    }
                }
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).p(this.b.p.a).u(ClogBuilder.Page.DOWNLOAD_RECTIFY).k(String.valueOf(gm0Var.a)).l(this.c);
            n31.b(clogBuilder);
        }
    }

    public static void g(@NonNull zl0 zl0Var, @NonNull bs0 bs0Var) {
        zl0Var.g = bs0Var.j;
        dm0 dm0Var = zl0Var.p;
        dm0Var.g = bs0Var.b;
        dm0Var.h = bs0Var.c;
    }

    public static zl0 c(@NonNull String str) {
        JSONObject c2 = y21.c(str);
        String optString = c2.optString("key", "");
        if (TextUtils.isEmpty(optString)) {
            optString = c2.optString("lp_url", "");
        }
        zl0 query = ql0.b().query(optString);
        if (query != null) {
            return query;
        }
        zl0 zl0Var = new zl0();
        zl0Var.g = c2.optString("url", "");
        zl0Var.h(optString);
        zl0Var.q.a = c2.optString(BdVideoAd.AD_VIDEO_DAPAGE, "");
        zl0Var.q.j = c2.optString("da_area", "");
        zl0Var.q.b = c2.optString("business");
        zl0Var.q.d = c2.optString("content_type");
        zl0Var.q.e = c2.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
        zl0Var.q.g = c2.optInt("close_v_dl");
        zl0Var.p.a = c2.optString("log_ext");
        zl0Var.p.j = c2.optString(LegoListActivityConfig.AD_ID);
        zl0Var.p.g = c2.optString("app_icon");
        zl0Var.p.h = c2.optString("app_name");
        return zl0Var;
    }

    public static lm0 d(RelativeLayout relativeLayout, zl0 zl0Var, String str) {
        int i;
        sm0<?> a2 = jn0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
        lm0 lm0Var = new lm0(zl0Var, a2);
        if (a == null) {
            a = new LruCache<>(32);
        }
        z21.e(a, zl0Var.e(), lm0Var);
        return lm0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(@NonNull Context context, @NonNull RelativeLayout relativeLayout, String str, @NonNull zl0 zl0Var, int i) {
        for (String str2 : c) {
            if (zl0Var.g.startsWith(str2) || str.startsWith(str2)) {
                lm0 d = d(relativeLayout, zl0Var, str);
                d.B(true);
                d.m();
                return;
            }
            while (r0.hasNext()) {
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ext", zl0Var.p.a);
        linkedHashMap.put("charge_url", str);
        linkedHashMap.put("apk_url", zl0Var.g);
        new fm0().b(linkedHashMap, new a(relativeLayout, zl0Var, str, i, context));
    }

    public static boolean f(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        int i;
        if (context == null || relativeLayout == null || TextUtils.isEmpty(str)) {
            return false;
        }
        zl0 c2 = c(str);
        if (c2.f()) {
            return false;
        }
        JSONObject c3 = y21.c(str);
        String optString = c3.optString("lp_url", "");
        int optInt = c3.optInt("lp_check_mode", 0);
        lm0 lm0Var = (lm0) z21.b(a, c2.e());
        if (lm0Var != null) {
            if (z && c2.c != AdDownloadStatus.DOWNLOADING && lm0Var.y()) {
                lm0Var.m();
            }
            if (lm0Var.z()) {
                sm0<?> a2 = jn0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
                lm0Var.t(a2);
                if (!lm0Var.y()) {
                    if (optInt == 1) {
                        lm0Var.D(relativeLayout, lm0Var.x(), context);
                    } else if (context instanceof Activity) {
                        lm0Var.C(relativeLayout, lm0Var.x(), (Activity) context);
                    }
                }
            }
            return true;
        } else if (dn0.a(str, optString)) {
            lm0 d = d(relativeLayout, c2, optString);
            d.B(true);
            d.m();
            return true;
        } else {
            e(context, relativeLayout, optString, c2, optInt);
            return true;
        }
    }
}
