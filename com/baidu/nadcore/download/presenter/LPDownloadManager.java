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
import com.baidu.tieba.as0;
import com.baidu.tieba.bm0;
import com.baidu.tieba.i31;
import com.baidu.tieba.il0;
import com.baidu.tieba.j31;
import com.baidu.tieba.ml0;
import com.baidu.tieba.nt0;
import com.baidu.tieba.ol0;
import com.baidu.tieba.pl0;
import com.baidu.tieba.s51;
import com.baidu.tieba.sm0;
import com.baidu.tieba.ul0;
import com.baidu.tieba.x31;
import com.baidu.tieba.ym0;
import com.baidu.tieba.zk0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LPDownloadManager {
    public static LruCache<String, ul0> a;
    public static Map<String, Integer> b;
    public static final List<String> c = new ArrayList<String>() { // from class: com.baidu.nadcore.download.presenter.LPDownloadManager.1
        {
            add("https://cover.baidu.com");
            add("http://cover.baidu.com");
        }
    };

    /* loaded from: classes3.dex */
    public class a extends nt0<pl0> {
        public final /* synthetic */ RelativeLayout a;
        public final /* synthetic */ il0 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Context e;

        @Override // com.baidu.tieba.lt0
        public void a(Exception exc, int i) {
        }

        public a(RelativeLayout relativeLayout, il0 il0Var, String str, int i, Context context) {
            this.a = relativeLayout;
            this.b = il0Var;
            this.c = str;
            this.d = i;
            this.e = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mt0
        /* renamed from: f */
        public pl0 d(Headers headers, String str, int i) {
            return pl0.a(i31.c(str).optJSONObject("data"));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mt0
        /* renamed from: e */
        public void b(Headers headers, pl0 pl0Var, int i) {
            if (pl0Var == null) {
                return;
            }
            int i2 = pl0Var.a;
            if (i2 == 1) {
                ul0 d = LPDownloadManager.d(this.a, this.b, this.c);
                d.z(pl0Var);
                d.A(true);
                d.l();
            } else if (i2 != 2 && i2 != 3) {
                s51.a().a(this.e, R.string.nad_download_lp_forbid_tip);
            } else {
                as0 as0Var = pl0Var.b;
                if (as0Var != null) {
                    if (this.d == 1) {
                        LPDownloadManager.g(this.b, as0Var);
                        ul0 d2 = LPDownloadManager.d(this.a, this.b, this.c);
                        d2.z(pl0Var);
                        d2.A(false);
                        d2.C(this.a, pl0Var, this.e);
                    } else if (this.e instanceof Activity) {
                        LPDownloadManager.g(this.b, as0Var);
                        ul0 d3 = LPDownloadManager.d(this.a, this.b, this.c);
                        d3.z(pl0Var);
                        d3.A(false);
                        d3.B(this.a, pl0Var, (Activity) this.e);
                    }
                }
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).p(this.b.p.a).u(ClogBuilder.Page.DOWNLOAD_RECTIFY).k(String.valueOf(pl0Var.a)).l(this.c);
            x31.e(clogBuilder);
        }
    }

    public static void g(@NonNull il0 il0Var, @NonNull as0 as0Var) {
        il0Var.g = as0Var.k;
        ml0 ml0Var = il0Var.p;
        ml0Var.g = as0Var.b;
        ml0Var.h = as0Var.c;
    }

    public static il0 c(@NonNull String str) {
        JSONObject c2 = i31.c(str);
        String optString = c2.optString("key", "");
        if (TextUtils.isEmpty(optString)) {
            optString = c2.optString("lp_url", "");
        }
        il0 query = zk0.b().query(optString);
        if (query != null) {
            return query;
        }
        il0 il0Var = new il0();
        il0Var.g = c2.optString("url", "");
        il0Var.h(optString);
        il0Var.q.a = c2.optString(BdVideoAd.AD_VIDEO_DAPAGE, "");
        il0Var.q.j = c2.optString("da_area", "");
        il0Var.q.b = c2.optString("business");
        il0Var.q.d = c2.optString("content_type");
        il0Var.q.e = c2.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
        il0Var.q.g = c2.optInt("close_v_dl");
        il0Var.p.a = c2.optString("log_ext");
        il0Var.p.j = c2.optString(LegoListActivityConfig.AD_ID);
        il0Var.p.g = c2.optString("app_icon");
        il0Var.p.h = c2.optString("app_name");
        return il0Var;
    }

    public static ul0 d(RelativeLayout relativeLayout, il0 il0Var, String str) {
        int i;
        bm0<?> a2 = ym0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
        ul0 ul0Var = new ul0(il0Var, a2);
        if (a == null) {
            a = new LruCache<>(32);
        }
        j31.e(a, il0Var.e(), ul0Var);
        return ul0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(@NonNull Context context, @NonNull RelativeLayout relativeLayout, String str, @NonNull il0 il0Var, int i) {
        for (String str2 : c) {
            if (il0Var.g.startsWith(str2) || str.startsWith(str2)) {
                ul0 d = d(relativeLayout, il0Var, str);
                d.A(true);
                d.l();
                return;
            }
            while (r0.hasNext()) {
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ext", il0Var.p.a);
        linkedHashMap.put("charge_url", str);
        linkedHashMap.put("apk_url", il0Var.g);
        new ol0().b(linkedHashMap, new a(relativeLayout, il0Var, str, i, context));
    }

    public static boolean f(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        int i;
        if (context == null || relativeLayout == null || TextUtils.isEmpty(str)) {
            return false;
        }
        il0 c2 = c(str);
        if (c2.f()) {
            return false;
        }
        JSONObject c3 = i31.c(str);
        String optString = c3.optString("lp_url", "");
        int optInt = c3.optInt("lp_check_mode", 0);
        ul0 ul0Var = (ul0) j31.b(a, c2.e());
        if (ul0Var != null) {
            if (z && c2.c != AdDownloadStatus.DOWNLOADING && ul0Var.x()) {
                ul0Var.l();
            }
            if (ul0Var.y()) {
                bm0<?> a2 = ym0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
                ul0Var.s(a2);
                if (!ul0Var.x()) {
                    if (optInt == 1) {
                        ul0Var.C(relativeLayout, ul0Var.u(), context);
                    } else if (context instanceof Activity) {
                        ul0Var.B(relativeLayout, ul0Var.u(), (Activity) context);
                    }
                }
            }
            return true;
        } else if (sm0.a(str, optString)) {
            ul0 d = d(relativeLayout, c2, optString);
            d.A(true);
            d.l();
            return true;
        } else {
            e(context, relativeLayout, optString, c2, optInt);
            return true;
        }
    }
}
