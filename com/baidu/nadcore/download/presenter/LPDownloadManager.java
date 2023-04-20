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
import com.baidu.tieba.aq0;
import com.baidu.tieba.ck0;
import com.baidu.tieba.cl0;
import com.baidu.tieba.ek0;
import com.baidu.tieba.f31;
import com.baidu.tieba.fk0;
import com.baidu.tieba.il0;
import com.baidu.tieba.kk0;
import com.baidu.tieba.kr0;
import com.baidu.tieba.m11;
import com.baidu.tieba.pj0;
import com.baidu.tieba.rk0;
import com.baidu.tieba.x01;
import com.baidu.tieba.y01;
import com.baidu.tieba.yj0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LPDownloadManager {
    public static LruCache<String, kk0> a;
    public static Map<String, Integer> b;
    public static final List<String> c = new ArrayList<String>() { // from class: com.baidu.nadcore.download.presenter.LPDownloadManager.1
        {
            add("https://cover.baidu.com");
            add("http://cover.baidu.com");
        }
    };

    /* loaded from: classes2.dex */
    public static class a extends kr0<fk0> {
        public final /* synthetic */ RelativeLayout a;
        public final /* synthetic */ yj0 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Context e;

        @Override // com.baidu.tieba.ir0
        public void a(Exception exc, int i) {
        }

        public a(RelativeLayout relativeLayout, yj0 yj0Var, String str, int i, Context context) {
            this.a = relativeLayout;
            this.b = yj0Var;
            this.c = str;
            this.d = i;
            this.e = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jr0
        /* renamed from: f */
        public fk0 d(Headers headers, String str, int i) {
            return fk0.a(x01.c(str).optJSONObject("data"));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jr0
        /* renamed from: e */
        public void b(Headers headers, fk0 fk0Var, int i) {
            if (fk0Var == null) {
                return;
            }
            int i2 = fk0Var.a;
            if (i2 == 1) {
                kk0 d = LPDownloadManager.d(this.a, this.b, this.c);
                d.A(fk0Var);
                d.B(true);
                d.m();
            } else if (i2 != 2 && i2 != 3) {
                f31.a().a(this.e, R.string.nad_download_lp_forbid_tip);
            } else {
                aq0 aq0Var = fk0Var.b;
                if (aq0Var != null) {
                    if (this.d == 1) {
                        LPDownloadManager.g(this.b, aq0Var);
                        kk0 d2 = LPDownloadManager.d(this.a, this.b, this.c);
                        d2.A(fk0Var);
                        d2.B(false);
                        d2.D(this.a, fk0Var, this.e);
                    } else if (this.e instanceof Activity) {
                        LPDownloadManager.g(this.b, aq0Var);
                        kk0 d3 = LPDownloadManager.d(this.a, this.b, this.c);
                        d3.A(fk0Var);
                        d3.B(false);
                        d3.C(this.a, fk0Var, (Activity) this.e);
                    }
                }
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).p(this.b.p.a).u(ClogBuilder.Page.DOWNLOAD_RECTIFY).k(String.valueOf(fk0Var.a)).l(this.c);
            m11.b(clogBuilder);
        }
    }

    public static void g(@NonNull yj0 yj0Var, @NonNull aq0 aq0Var) {
        yj0Var.g = aq0Var.j;
        ck0 ck0Var = yj0Var.p;
        ck0Var.g = aq0Var.b;
        ck0Var.h = aq0Var.c;
    }

    public static yj0 c(@NonNull String str) {
        JSONObject c2 = x01.c(str);
        String optString = c2.optString("key", "");
        if (TextUtils.isEmpty(optString)) {
            optString = c2.optString("lp_url", "");
        }
        yj0 query = pj0.b().query(optString);
        if (query != null) {
            return query;
        }
        yj0 yj0Var = new yj0();
        yj0Var.g = c2.optString("url", "");
        yj0Var.h(optString);
        yj0Var.q.a = c2.optString(BdVideoAd.AD_VIDEO_DAPAGE, "");
        yj0Var.q.j = c2.optString("da_area", "");
        yj0Var.q.b = c2.optString("business");
        yj0Var.q.d = c2.optString("content_type");
        yj0Var.q.e = c2.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
        yj0Var.q.g = c2.optInt("close_v_dl");
        yj0Var.p.a = c2.optString("log_ext");
        yj0Var.p.j = c2.optString(LegoListActivityConfig.AD_ID);
        yj0Var.p.g = c2.optString("app_icon");
        yj0Var.p.h = c2.optString("app_name");
        return yj0Var;
    }

    public static kk0 d(RelativeLayout relativeLayout, yj0 yj0Var, String str) {
        int i;
        rk0<?> a2 = il0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
        kk0 kk0Var = new kk0(yj0Var, a2);
        if (a == null) {
            a = new LruCache<>(32);
        }
        y01.e(a, yj0Var.e(), kk0Var);
        return kk0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(@NonNull Context context, @NonNull RelativeLayout relativeLayout, String str, @NonNull yj0 yj0Var, int i) {
        for (String str2 : c) {
            if (yj0Var.g.startsWith(str2) || str.startsWith(str2)) {
                kk0 d = d(relativeLayout, yj0Var, str);
                d.B(true);
                d.m();
                return;
            }
            while (r0.hasNext()) {
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ext", yj0Var.p.a);
        linkedHashMap.put("charge_url", str);
        linkedHashMap.put("apk_url", yj0Var.g);
        new ek0().b(linkedHashMap, new a(relativeLayout, yj0Var, str, i, context));
    }

    public static boolean f(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        int i;
        if (context == null || relativeLayout == null || TextUtils.isEmpty(str)) {
            return false;
        }
        yj0 c2 = c(str);
        if (c2.f()) {
            return false;
        }
        JSONObject c3 = x01.c(str);
        String optString = c3.optString("lp_url", "");
        int optInt = c3.optInt("lp_check_mode", 0);
        kk0 kk0Var = (kk0) y01.b(a, c2.e());
        if (kk0Var != null) {
            if (z && c2.c != AdDownloadStatus.DOWNLOADING && kk0Var.y()) {
                kk0Var.m();
            }
            if (kk0Var.z()) {
                rk0<?> a2 = il0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
                kk0Var.t(a2);
                if (!kk0Var.y()) {
                    if (optInt == 1) {
                        kk0Var.D(relativeLayout, kk0Var.x(), context);
                    } else if (context instanceof Activity) {
                        kk0Var.C(relativeLayout, kk0Var.x(), (Activity) context);
                    }
                }
            }
            return true;
        } else if (cl0.a(str, optString)) {
            kk0 d = d(relativeLayout, c2, optString);
            d.B(true);
            d.m();
            return true;
        } else {
            e(context, relativeLayout, optString, c2, optInt);
            return true;
        }
    }
}
