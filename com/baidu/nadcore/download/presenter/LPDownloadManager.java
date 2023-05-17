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
import com.baidu.tieba.am0;
import com.baidu.tieba.cl0;
import com.baidu.tieba.cs0;
import com.baidu.tieba.e21;
import com.baidu.tieba.hk0;
import com.baidu.tieba.jl0;
import com.baidu.tieba.p11;
import com.baidu.tieba.q11;
import com.baidu.tieba.qk0;
import com.baidu.tieba.sq0;
import com.baidu.tieba.uk0;
import com.baidu.tieba.ul0;
import com.baidu.tieba.wk0;
import com.baidu.tieba.x31;
import com.baidu.tieba.xk0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LPDownloadManager {
    public static LruCache<String, cl0> a;
    public static Map<String, Integer> b;
    public static final List<String> c = new ArrayList<String>() { // from class: com.baidu.nadcore.download.presenter.LPDownloadManager.1
        {
            add("https://cover.baidu.com");
            add("http://cover.baidu.com");
        }
    };

    /* loaded from: classes3.dex */
    public static class a extends cs0<xk0> {
        public final /* synthetic */ RelativeLayout a;
        public final /* synthetic */ qk0 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Context e;

        @Override // com.baidu.tieba.as0
        public void a(Exception exc, int i) {
        }

        public a(RelativeLayout relativeLayout, qk0 qk0Var, String str, int i, Context context) {
            this.a = relativeLayout;
            this.b = qk0Var;
            this.c = str;
            this.d = i;
            this.e = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bs0
        /* renamed from: f */
        public xk0 d(Headers headers, String str, int i) {
            return xk0.a(p11.c(str).optJSONObject("data"));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bs0
        /* renamed from: e */
        public void b(Headers headers, xk0 xk0Var, int i) {
            if (xk0Var == null) {
                return;
            }
            int i2 = xk0Var.a;
            if (i2 == 1) {
                cl0 d = LPDownloadManager.d(this.a, this.b, this.c);
                d.A(xk0Var);
                d.B(true);
                d.m();
            } else if (i2 != 2 && i2 != 3) {
                x31.a().a(this.e, R.string.nad_download_lp_forbid_tip);
            } else {
                sq0 sq0Var = xk0Var.b;
                if (sq0Var != null) {
                    if (this.d == 1) {
                        LPDownloadManager.g(this.b, sq0Var);
                        cl0 d2 = LPDownloadManager.d(this.a, this.b, this.c);
                        d2.A(xk0Var);
                        d2.B(false);
                        d2.D(this.a, xk0Var, this.e);
                    } else if (this.e instanceof Activity) {
                        LPDownloadManager.g(this.b, sq0Var);
                        cl0 d3 = LPDownloadManager.d(this.a, this.b, this.c);
                        d3.A(xk0Var);
                        d3.B(false);
                        d3.C(this.a, xk0Var, (Activity) this.e);
                    }
                }
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).p(this.b.p.a).u(ClogBuilder.Page.DOWNLOAD_RECTIFY).k(String.valueOf(xk0Var.a)).l(this.c);
            e21.b(clogBuilder);
        }
    }

    public static void g(@NonNull qk0 qk0Var, @NonNull sq0 sq0Var) {
        qk0Var.g = sq0Var.j;
        uk0 uk0Var = qk0Var.p;
        uk0Var.g = sq0Var.b;
        uk0Var.h = sq0Var.c;
    }

    public static qk0 c(@NonNull String str) {
        JSONObject c2 = p11.c(str);
        String optString = c2.optString("key", "");
        if (TextUtils.isEmpty(optString)) {
            optString = c2.optString("lp_url", "");
        }
        qk0 query = hk0.b().query(optString);
        if (query != null) {
            return query;
        }
        qk0 qk0Var = new qk0();
        qk0Var.g = c2.optString("url", "");
        qk0Var.h(optString);
        qk0Var.q.a = c2.optString(BdVideoAd.AD_VIDEO_DAPAGE, "");
        qk0Var.q.j = c2.optString("da_area", "");
        qk0Var.q.b = c2.optString("business");
        qk0Var.q.d = c2.optString("content_type");
        qk0Var.q.e = c2.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
        qk0Var.q.g = c2.optInt("close_v_dl");
        qk0Var.p.a = c2.optString("log_ext");
        qk0Var.p.j = c2.optString(LegoListActivityConfig.AD_ID);
        qk0Var.p.g = c2.optString("app_icon");
        qk0Var.p.h = c2.optString("app_name");
        return qk0Var;
    }

    public static cl0 d(RelativeLayout relativeLayout, qk0 qk0Var, String str) {
        int i;
        jl0<?> a2 = am0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
        cl0 cl0Var = new cl0(qk0Var, a2);
        if (a == null) {
            a = new LruCache<>(32);
        }
        q11.e(a, qk0Var.e(), cl0Var);
        return cl0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(@NonNull Context context, @NonNull RelativeLayout relativeLayout, String str, @NonNull qk0 qk0Var, int i) {
        for (String str2 : c) {
            if (qk0Var.g.startsWith(str2) || str.startsWith(str2)) {
                cl0 d = d(relativeLayout, qk0Var, str);
                d.B(true);
                d.m();
                return;
            }
            while (r0.hasNext()) {
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ext", qk0Var.p.a);
        linkedHashMap.put("charge_url", str);
        linkedHashMap.put("apk_url", qk0Var.g);
        new wk0().b(linkedHashMap, new a(relativeLayout, qk0Var, str, i, context));
    }

    public static boolean f(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        int i;
        if (context == null || relativeLayout == null || TextUtils.isEmpty(str)) {
            return false;
        }
        qk0 c2 = c(str);
        if (c2.f()) {
            return false;
        }
        JSONObject c3 = p11.c(str);
        String optString = c3.optString("lp_url", "");
        int optInt = c3.optInt("lp_check_mode", 0);
        cl0 cl0Var = (cl0) q11.b(a, c2.e());
        if (cl0Var != null) {
            if (z && c2.c != AdDownloadStatus.DOWNLOADING && cl0Var.y()) {
                cl0Var.m();
            }
            if (cl0Var.z()) {
                jl0<?> a2 = am0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
                cl0Var.t(a2);
                if (!cl0Var.y()) {
                    if (optInt == 1) {
                        cl0Var.D(relativeLayout, cl0Var.x(), context);
                    } else if (context instanceof Activity) {
                        cl0Var.C(relativeLayout, cl0Var.x(), (Activity) context);
                    }
                }
            }
            return true;
        } else if (ul0.a(str, optString)) {
            cl0 d = d(relativeLayout, c2, optString);
            d.B(true);
            d.m();
            return true;
        } else {
            e(context, relativeLayout, optString, c2, optInt);
            return true;
        }
    }
}
