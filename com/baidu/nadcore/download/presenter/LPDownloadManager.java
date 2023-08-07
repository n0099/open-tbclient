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
import com.baidu.tieba.b31;
import com.baidu.tieba.c31;
import com.baidu.tieba.el0;
import com.baidu.tieba.gt0;
import com.baidu.tieba.il0;
import com.baidu.tieba.j51;
import com.baidu.tieba.kl0;
import com.baidu.tieba.ll0;
import com.baidu.tieba.om0;
import com.baidu.tieba.q31;
import com.baidu.tieba.ql0;
import com.baidu.tieba.tr0;
import com.baidu.tieba.um0;
import com.baidu.tieba.vk0;
import com.baidu.tieba.xl0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LPDownloadManager {
    public static LruCache<String, ql0> a;
    public static Map<String, Integer> b;
    public static final List<String> c = new ArrayList<String>() { // from class: com.baidu.nadcore.download.presenter.LPDownloadManager.1
        {
            add("https://cover.baidu.com");
            add("http://cover.baidu.com");
        }
    };

    /* loaded from: classes3.dex */
    public class a extends gt0<ll0> {
        public final /* synthetic */ RelativeLayout a;
        public final /* synthetic */ el0 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Context e;

        @Override // com.baidu.tieba.et0
        public void a(Exception exc, int i) {
        }

        public a(RelativeLayout relativeLayout, el0 el0Var, String str, int i, Context context) {
            this.a = relativeLayout;
            this.b = el0Var;
            this.c = str;
            this.d = i;
            this.e = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ft0
        /* renamed from: f */
        public ll0 d(Headers headers, String str, int i) {
            return ll0.a(b31.c(str).optJSONObject("data"));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ft0
        /* renamed from: e */
        public void b(Headers headers, ll0 ll0Var, int i) {
            if (ll0Var == null) {
                return;
            }
            int i2 = ll0Var.a;
            if (i2 == 1) {
                ql0 d = LPDownloadManager.d(this.a, this.b, this.c);
                d.z(ll0Var);
                d.A(true);
                d.l();
            } else if (i2 != 2 && i2 != 3) {
                j51.a().a(this.e, R.string.nad_download_lp_forbid_tip);
            } else {
                tr0 tr0Var = ll0Var.b;
                if (tr0Var != null) {
                    if (this.d == 1) {
                        LPDownloadManager.g(this.b, tr0Var);
                        ql0 d2 = LPDownloadManager.d(this.a, this.b, this.c);
                        d2.z(ll0Var);
                        d2.A(false);
                        d2.C(this.a, ll0Var, this.e);
                    } else if (this.e instanceof Activity) {
                        LPDownloadManager.g(this.b, tr0Var);
                        ql0 d3 = LPDownloadManager.d(this.a, this.b, this.c);
                        d3.z(ll0Var);
                        d3.A(false);
                        d3.B(this.a, ll0Var, (Activity) this.e);
                    }
                }
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).p(this.b.p.a).u(ClogBuilder.Page.DOWNLOAD_RECTIFY).k(String.valueOf(ll0Var.a)).l(this.c);
            q31.e(clogBuilder);
        }
    }

    public static void g(@NonNull el0 el0Var, @NonNull tr0 tr0Var) {
        el0Var.g = tr0Var.j;
        il0 il0Var = el0Var.p;
        il0Var.g = tr0Var.b;
        il0Var.h = tr0Var.c;
    }

    public static el0 c(@NonNull String str) {
        JSONObject c2 = b31.c(str);
        String optString = c2.optString("key", "");
        if (TextUtils.isEmpty(optString)) {
            optString = c2.optString("lp_url", "");
        }
        el0 query = vk0.b().query(optString);
        if (query != null) {
            return query;
        }
        el0 el0Var = new el0();
        el0Var.g = c2.optString("url", "");
        el0Var.h(optString);
        el0Var.q.a = c2.optString(BdVideoAd.AD_VIDEO_DAPAGE, "");
        el0Var.q.j = c2.optString("da_area", "");
        el0Var.q.b = c2.optString("business");
        el0Var.q.d = c2.optString("content_type");
        el0Var.q.e = c2.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
        el0Var.q.g = c2.optInt("close_v_dl");
        el0Var.p.a = c2.optString("log_ext");
        el0Var.p.j = c2.optString(LegoListActivityConfig.AD_ID);
        el0Var.p.g = c2.optString("app_icon");
        el0Var.p.h = c2.optString("app_name");
        return el0Var;
    }

    public static ql0 d(RelativeLayout relativeLayout, el0 el0Var, String str) {
        int i;
        xl0<?> a2 = um0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
        ql0 ql0Var = new ql0(el0Var, a2);
        if (a == null) {
            a = new LruCache<>(32);
        }
        c31.e(a, el0Var.e(), ql0Var);
        return ql0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(@NonNull Context context, @NonNull RelativeLayout relativeLayout, String str, @NonNull el0 el0Var, int i) {
        for (String str2 : c) {
            if (el0Var.g.startsWith(str2) || str.startsWith(str2)) {
                ql0 d = d(relativeLayout, el0Var, str);
                d.A(true);
                d.l();
                return;
            }
            while (r0.hasNext()) {
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ext", el0Var.p.a);
        linkedHashMap.put("charge_url", str);
        linkedHashMap.put("apk_url", el0Var.g);
        new kl0().b(linkedHashMap, new a(relativeLayout, el0Var, str, i, context));
    }

    public static boolean f(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        int i;
        if (context == null || relativeLayout == null || TextUtils.isEmpty(str)) {
            return false;
        }
        el0 c2 = c(str);
        if (c2.f()) {
            return false;
        }
        JSONObject c3 = b31.c(str);
        String optString = c3.optString("lp_url", "");
        int optInt = c3.optInt("lp_check_mode", 0);
        ql0 ql0Var = (ql0) c31.b(a, c2.e());
        if (ql0Var != null) {
            if (z && c2.c != AdDownloadStatus.DOWNLOADING && ql0Var.x()) {
                ql0Var.l();
            }
            if (ql0Var.y()) {
                xl0<?> a2 = um0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
                ql0Var.s(a2);
                if (!ql0Var.x()) {
                    if (optInt == 1) {
                        ql0Var.C(relativeLayout, ql0Var.u(), context);
                    } else if (context instanceof Activity) {
                        ql0Var.B(relativeLayout, ql0Var.u(), (Activity) context);
                    }
                }
            }
            return true;
        } else if (om0.a(str, optString)) {
            ql0 d = d(relativeLayout, c2, optString);
            d.A(true);
            d.l();
            return true;
        } else {
            e(context, relativeLayout, optString, c2, optInt);
            return true;
        }
    }
}
