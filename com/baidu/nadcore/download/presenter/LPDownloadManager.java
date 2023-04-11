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
import com.baidu.tieba.bk0;
import com.baidu.tieba.bl0;
import com.baidu.tieba.dk0;
import com.baidu.tieba.e31;
import com.baidu.tieba.ek0;
import com.baidu.tieba.hl0;
import com.baidu.tieba.jk0;
import com.baidu.tieba.jr0;
import com.baidu.tieba.l11;
import com.baidu.tieba.oj0;
import com.baidu.tieba.qk0;
import com.baidu.tieba.w01;
import com.baidu.tieba.x01;
import com.baidu.tieba.xj0;
import com.baidu.tieba.zp0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LPDownloadManager {
    public static LruCache<String, jk0> a;
    public static Map<String, Integer> b;
    public static final List<String> c = new ArrayList<String>() { // from class: com.baidu.nadcore.download.presenter.LPDownloadManager.1
        {
            add("https://cover.baidu.com");
            add("http://cover.baidu.com");
        }
    };

    /* loaded from: classes2.dex */
    public static class a extends jr0<ek0> {
        public final /* synthetic */ RelativeLayout a;
        public final /* synthetic */ xj0 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Context e;

        @Override // com.baidu.tieba.hr0
        public void a(Exception exc, int i) {
        }

        public a(RelativeLayout relativeLayout, xj0 xj0Var, String str, int i, Context context) {
            this.a = relativeLayout;
            this.b = xj0Var;
            this.c = str;
            this.d = i;
            this.e = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ir0
        /* renamed from: f */
        public ek0 d(Headers headers, String str, int i) {
            return ek0.a(w01.c(str).optJSONObject("data"));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ir0
        /* renamed from: e */
        public void b(Headers headers, ek0 ek0Var, int i) {
            if (ek0Var == null) {
                return;
            }
            int i2 = ek0Var.a;
            if (i2 == 1) {
                jk0 d = LPDownloadManager.d(this.a, this.b, this.c);
                d.A(ek0Var);
                d.B(true);
                d.m();
            } else if (i2 != 2 && i2 != 3) {
                e31.a().a(this.e, R.string.nad_download_lp_forbid_tip);
            } else {
                zp0 zp0Var = ek0Var.b;
                if (zp0Var != null) {
                    if (this.d == 1) {
                        LPDownloadManager.g(this.b, zp0Var);
                        jk0 d2 = LPDownloadManager.d(this.a, this.b, this.c);
                        d2.A(ek0Var);
                        d2.B(false);
                        d2.D(this.a, ek0Var, this.e);
                    } else if (this.e instanceof Activity) {
                        LPDownloadManager.g(this.b, zp0Var);
                        jk0 d3 = LPDownloadManager.d(this.a, this.b, this.c);
                        d3.A(ek0Var);
                        d3.B(false);
                        d3.C(this.a, ek0Var, (Activity) this.e);
                    }
                }
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).p(this.b.p.a).u(ClogBuilder.Page.DOWNLOAD_RECTIFY).k(String.valueOf(ek0Var.a)).l(this.c);
            l11.b(clogBuilder);
        }
    }

    public static void g(@NonNull xj0 xj0Var, @NonNull zp0 zp0Var) {
        xj0Var.g = zp0Var.j;
        bk0 bk0Var = xj0Var.p;
        bk0Var.g = zp0Var.b;
        bk0Var.h = zp0Var.c;
    }

    public static xj0 c(@NonNull String str) {
        JSONObject c2 = w01.c(str);
        String optString = c2.optString("key", "");
        if (TextUtils.isEmpty(optString)) {
            optString = c2.optString("lp_url", "");
        }
        xj0 query = oj0.b().query(optString);
        if (query != null) {
            return query;
        }
        xj0 xj0Var = new xj0();
        xj0Var.g = c2.optString("url", "");
        xj0Var.h(optString);
        xj0Var.q.a = c2.optString(BdVideoAd.AD_VIDEO_DAPAGE, "");
        xj0Var.q.j = c2.optString("da_area", "");
        xj0Var.q.b = c2.optString("business");
        xj0Var.q.d = c2.optString("content_type");
        xj0Var.q.e = c2.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
        xj0Var.q.g = c2.optInt("close_v_dl");
        xj0Var.p.a = c2.optString("log_ext");
        xj0Var.p.j = c2.optString(LegoListActivityConfig.AD_ID);
        xj0Var.p.g = c2.optString("app_icon");
        xj0Var.p.h = c2.optString("app_name");
        return xj0Var;
    }

    public static jk0 d(RelativeLayout relativeLayout, xj0 xj0Var, String str) {
        int i;
        qk0<?> a2 = hl0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
        jk0 jk0Var = new jk0(xj0Var, a2);
        if (a == null) {
            a = new LruCache<>(32);
        }
        x01.e(a, xj0Var.e(), jk0Var);
        return jk0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(@NonNull Context context, @NonNull RelativeLayout relativeLayout, String str, @NonNull xj0 xj0Var, int i) {
        for (String str2 : c) {
            if (xj0Var.g.startsWith(str2) || str.startsWith(str2)) {
                jk0 d = d(relativeLayout, xj0Var, str);
                d.B(true);
                d.m();
                return;
            }
            while (r0.hasNext()) {
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ext", xj0Var.p.a);
        linkedHashMap.put("charge_url", str);
        linkedHashMap.put("apk_url", xj0Var.g);
        new dk0().b(linkedHashMap, new a(relativeLayout, xj0Var, str, i, context));
    }

    public static boolean f(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        int i;
        if (context == null || relativeLayout == null || TextUtils.isEmpty(str)) {
            return false;
        }
        xj0 c2 = c(str);
        if (c2.f()) {
            return false;
        }
        JSONObject c3 = w01.c(str);
        String optString = c3.optString("lp_url", "");
        int optInt = c3.optInt("lp_check_mode", 0);
        jk0 jk0Var = (jk0) x01.b(a, c2.e());
        if (jk0Var != null) {
            if (z && c2.c != AdDownloadStatus.DOWNLOADING && jk0Var.y()) {
                jk0Var.m();
            }
            if (jk0Var.z()) {
                qk0<?> a2 = hl0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
                jk0Var.t(a2);
                if (!jk0Var.y()) {
                    if (optInt == 1) {
                        jk0Var.D(relativeLayout, jk0Var.x(), context);
                    } else if (context instanceof Activity) {
                        jk0Var.C(relativeLayout, jk0Var.x(), (Activity) context);
                    }
                }
            }
            return true;
        } else if (bl0.a(str, optString)) {
            jk0 d = d(relativeLayout, c2, optString);
            d.B(true);
            d.m();
            return true;
        } else {
            e(context, relativeLayout, optString, c2, optInt);
            return true;
        }
    }
}
