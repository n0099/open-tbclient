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
import com.baidu.tieba.f21;
import com.baidu.tieba.g21;
import com.baidu.tieba.gl0;
import com.baidu.tieba.ir0;
import com.baidu.tieba.kl0;
import com.baidu.tieba.km0;
import com.baidu.tieba.ml0;
import com.baidu.tieba.n41;
import com.baidu.tieba.nl0;
import com.baidu.tieba.qm0;
import com.baidu.tieba.sl0;
import com.baidu.tieba.ss0;
import com.baidu.tieba.u21;
import com.baidu.tieba.xk0;
import com.baidu.tieba.zl0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LPDownloadManager {
    public static LruCache<String, sl0> a;
    public static Map<String, Integer> b;
    public static final List<String> c = new ArrayList<String>() { // from class: com.baidu.nadcore.download.presenter.LPDownloadManager.1
        {
            add("https://cover.baidu.com");
            add("http://cover.baidu.com");
        }
    };

    /* loaded from: classes2.dex */
    public static class a extends ss0<nl0> {
        public final /* synthetic */ RelativeLayout a;
        public final /* synthetic */ gl0 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Context e;

        @Override // com.baidu.tieba.qs0
        public void a(Exception exc, int i) {
        }

        public a(RelativeLayout relativeLayout, gl0 gl0Var, String str, int i, Context context) {
            this.a = relativeLayout;
            this.b = gl0Var;
            this.c = str;
            this.d = i;
            this.e = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rs0
        /* renamed from: f */
        public nl0 d(Headers headers, String str, int i) {
            return nl0.a(f21.c(str).optJSONObject("data"));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rs0
        /* renamed from: e */
        public void b(Headers headers, nl0 nl0Var, int i) {
            if (nl0Var == null) {
                return;
            }
            int i2 = nl0Var.a;
            if (i2 == 1) {
                sl0 d = LPDownloadManager.d(this.a, this.b, this.c);
                d.y(nl0Var);
                d.z(true);
                d.m();
            } else if (i2 != 2 && i2 != 3) {
                n41.a().a(this.e, R.string.nad_download_lp_forbid_tip);
            } else {
                ir0 ir0Var = nl0Var.b;
                if (ir0Var != null) {
                    if (this.d == 1) {
                        LPDownloadManager.g(this.b, ir0Var);
                        sl0 d2 = LPDownloadManager.d(this.a, this.b, this.c);
                        d2.y(nl0Var);
                        d2.z(false);
                        d2.B(this.a, nl0Var, this.e);
                    } else if (this.e instanceof Activity) {
                        LPDownloadManager.g(this.b, ir0Var);
                        sl0 d3 = LPDownloadManager.d(this.a, this.b, this.c);
                        d3.y(nl0Var);
                        d3.z(false);
                        d3.A(this.a, nl0Var, (Activity) this.e);
                    }
                }
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).p(this.b.p.a).u(ClogBuilder.Page.DOWNLOAD_RECTIFY).k(String.valueOf(nl0Var.a)).l(this.c);
            u21.b(clogBuilder);
        }
    }

    public static void g(@NonNull gl0 gl0Var, @NonNull ir0 ir0Var) {
        gl0Var.g = ir0Var.j;
        kl0 kl0Var = gl0Var.p;
        kl0Var.g = ir0Var.b;
        kl0Var.h = ir0Var.c;
    }

    public static gl0 c(@NonNull String str) {
        JSONObject c2 = f21.c(str);
        String optString = c2.optString("key", "");
        if (TextUtils.isEmpty(optString)) {
            optString = c2.optString("lp_url", "");
        }
        gl0 query = xk0.b().query(optString);
        if (query != null) {
            return query;
        }
        gl0 gl0Var = new gl0();
        gl0Var.g = c2.optString("url", "");
        gl0Var.h(optString);
        gl0Var.q.a = c2.optString(BdVideoAd.AD_VIDEO_DAPAGE, "");
        gl0Var.q.j = c2.optString("da_area", "");
        gl0Var.q.b = c2.optString("business");
        gl0Var.q.d = c2.optString("content_type");
        gl0Var.q.e = c2.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
        gl0Var.q.g = c2.optInt("close_v_dl");
        gl0Var.p.a = c2.optString("log_ext");
        gl0Var.p.j = c2.optString(LegoListActivityConfig.AD_ID);
        gl0Var.p.g = c2.optString("app_icon");
        gl0Var.p.h = c2.optString("app_name");
        return gl0Var;
    }

    public static sl0 d(RelativeLayout relativeLayout, gl0 gl0Var, String str) {
        int i;
        zl0<?> a2 = qm0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
        sl0 sl0Var = new sl0(gl0Var, a2);
        if (a == null) {
            a = new LruCache<>(32);
        }
        g21.e(a, gl0Var.e(), sl0Var);
        return sl0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(@NonNull Context context, @NonNull RelativeLayout relativeLayout, String str, @NonNull gl0 gl0Var, int i) {
        for (String str2 : c) {
            if (gl0Var.g.startsWith(str2) || str.startsWith(str2)) {
                sl0 d = d(relativeLayout, gl0Var, str);
                d.z(true);
                d.m();
                return;
            }
            while (r0.hasNext()) {
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ext", gl0Var.p.a);
        linkedHashMap.put("charge_url", str);
        linkedHashMap.put("apk_url", gl0Var.g);
        new ml0().b(linkedHashMap, new a(relativeLayout, gl0Var, str, i, context));
    }

    public static boolean f(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        int i;
        if (context == null || relativeLayout == null || TextUtils.isEmpty(str)) {
            return false;
        }
        gl0 c2 = c(str);
        if (c2.f()) {
            return false;
        }
        JSONObject c3 = f21.c(str);
        String optString = c3.optString("lp_url", "");
        int optInt = c3.optInt("lp_check_mode", 0);
        sl0 sl0Var = (sl0) g21.b(a, c2.e());
        if (sl0Var != null) {
            if (z && c2.c != AdDownloadStatus.DOWNLOADING && sl0Var.w()) {
                sl0Var.m();
            }
            if (sl0Var.x()) {
                zl0<?> a2 = qm0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
                sl0Var.t(a2);
                if (!sl0Var.w()) {
                    if (optInt == 1) {
                        sl0Var.B(relativeLayout, sl0Var.v(), context);
                    } else if (context instanceof Activity) {
                        sl0Var.A(relativeLayout, sl0Var.v(), (Activity) context);
                    }
                }
            }
            return true;
        } else if (km0.a(str, optString)) {
            sl0 d = d(relativeLayout, c2, optString);
            d.z(true);
            d.m();
            return true;
        } else {
            e(context, relativeLayout, optString, c2, optInt);
            return true;
        }
    }
}
