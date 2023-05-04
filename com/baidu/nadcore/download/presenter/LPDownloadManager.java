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
import com.baidu.tieba.a11;
import com.baidu.tieba.ak0;
import com.baidu.tieba.cq0;
import com.baidu.tieba.ek0;
import com.baidu.tieba.el0;
import com.baidu.tieba.gk0;
import com.baidu.tieba.h31;
import com.baidu.tieba.hk0;
import com.baidu.tieba.kl0;
import com.baidu.tieba.mk0;
import com.baidu.tieba.mr0;
import com.baidu.tieba.o11;
import com.baidu.tieba.rj0;
import com.baidu.tieba.tk0;
import com.baidu.tieba.z01;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LPDownloadManager {
    public static LruCache<String, mk0> a;
    public static Map<String, Integer> b;
    public static final List<String> c = new ArrayList<String>() { // from class: com.baidu.nadcore.download.presenter.LPDownloadManager.1
        {
            add("https://cover.baidu.com");
            add("http://cover.baidu.com");
        }
    };

    /* loaded from: classes2.dex */
    public static class a extends mr0<hk0> {
        public final /* synthetic */ RelativeLayout a;
        public final /* synthetic */ ak0 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Context e;

        @Override // com.baidu.tieba.kr0
        public void a(Exception exc, int i) {
        }

        public a(RelativeLayout relativeLayout, ak0 ak0Var, String str, int i, Context context) {
            this.a = relativeLayout;
            this.b = ak0Var;
            this.c = str;
            this.d = i;
            this.e = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lr0
        /* renamed from: f */
        public hk0 d(Headers headers, String str, int i) {
            return hk0.a(z01.c(str).optJSONObject("data"));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lr0
        /* renamed from: e */
        public void b(Headers headers, hk0 hk0Var, int i) {
            if (hk0Var == null) {
                return;
            }
            int i2 = hk0Var.a;
            if (i2 == 1) {
                mk0 d = LPDownloadManager.d(this.a, this.b, this.c);
                d.A(hk0Var);
                d.B(true);
                d.m();
            } else if (i2 != 2 && i2 != 3) {
                h31.a().a(this.e, R.string.nad_download_lp_forbid_tip);
            } else {
                cq0 cq0Var = hk0Var.b;
                if (cq0Var != null) {
                    if (this.d == 1) {
                        LPDownloadManager.g(this.b, cq0Var);
                        mk0 d2 = LPDownloadManager.d(this.a, this.b, this.c);
                        d2.A(hk0Var);
                        d2.B(false);
                        d2.D(this.a, hk0Var, this.e);
                    } else if (this.e instanceof Activity) {
                        LPDownloadManager.g(this.b, cq0Var);
                        mk0 d3 = LPDownloadManager.d(this.a, this.b, this.c);
                        d3.A(hk0Var);
                        d3.B(false);
                        d3.C(this.a, hk0Var, (Activity) this.e);
                    }
                }
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).p(this.b.p.a).u(ClogBuilder.Page.DOWNLOAD_RECTIFY).k(String.valueOf(hk0Var.a)).l(this.c);
            o11.b(clogBuilder);
        }
    }

    public static void g(@NonNull ak0 ak0Var, @NonNull cq0 cq0Var) {
        ak0Var.g = cq0Var.j;
        ek0 ek0Var = ak0Var.p;
        ek0Var.g = cq0Var.b;
        ek0Var.h = cq0Var.c;
    }

    public static ak0 c(@NonNull String str) {
        JSONObject c2 = z01.c(str);
        String optString = c2.optString("key", "");
        if (TextUtils.isEmpty(optString)) {
            optString = c2.optString("lp_url", "");
        }
        ak0 query = rj0.b().query(optString);
        if (query != null) {
            return query;
        }
        ak0 ak0Var = new ak0();
        ak0Var.g = c2.optString("url", "");
        ak0Var.h(optString);
        ak0Var.q.a = c2.optString(BdVideoAd.AD_VIDEO_DAPAGE, "");
        ak0Var.q.j = c2.optString("da_area", "");
        ak0Var.q.b = c2.optString("business");
        ak0Var.q.d = c2.optString("content_type");
        ak0Var.q.e = c2.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
        ak0Var.q.g = c2.optInt("close_v_dl");
        ak0Var.p.a = c2.optString("log_ext");
        ak0Var.p.j = c2.optString(LegoListActivityConfig.AD_ID);
        ak0Var.p.g = c2.optString("app_icon");
        ak0Var.p.h = c2.optString("app_name");
        return ak0Var;
    }

    public static mk0 d(RelativeLayout relativeLayout, ak0 ak0Var, String str) {
        int i;
        tk0<?> a2 = kl0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
        mk0 mk0Var = new mk0(ak0Var, a2);
        if (a == null) {
            a = new LruCache<>(32);
        }
        a11.e(a, ak0Var.e(), mk0Var);
        return mk0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(@NonNull Context context, @NonNull RelativeLayout relativeLayout, String str, @NonNull ak0 ak0Var, int i) {
        for (String str2 : c) {
            if (ak0Var.g.startsWith(str2) || str.startsWith(str2)) {
                mk0 d = d(relativeLayout, ak0Var, str);
                d.B(true);
                d.m();
                return;
            }
            while (r0.hasNext()) {
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ext", ak0Var.p.a);
        linkedHashMap.put("charge_url", str);
        linkedHashMap.put("apk_url", ak0Var.g);
        new gk0().b(linkedHashMap, new a(relativeLayout, ak0Var, str, i, context));
    }

    public static boolean f(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        int i;
        if (context == null || relativeLayout == null || TextUtils.isEmpty(str)) {
            return false;
        }
        ak0 c2 = c(str);
        if (c2.f()) {
            return false;
        }
        JSONObject c3 = z01.c(str);
        String optString = c3.optString("lp_url", "");
        int optInt = c3.optInt("lp_check_mode", 0);
        mk0 mk0Var = (mk0) a11.b(a, c2.e());
        if (mk0Var != null) {
            if (z && c2.c != AdDownloadStatus.DOWNLOADING && mk0Var.y()) {
                mk0Var.m();
            }
            if (mk0Var.z()) {
                tk0<?> a2 = kl0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
                mk0Var.t(a2);
                if (!mk0Var.y()) {
                    if (optInt == 1) {
                        mk0Var.D(relativeLayout, mk0Var.x(), context);
                    } else if (context instanceof Activity) {
                        mk0Var.C(relativeLayout, mk0Var.x(), (Activity) context);
                    }
                }
            }
            return true;
        } else if (el0.a(str, optString)) {
            mk0 d = d(relativeLayout, c2, optString);
            d.B(true);
            d.m();
            return true;
        } else {
            e(context, relativeLayout, optString, c2, optInt);
            return true;
        }
    }
}
