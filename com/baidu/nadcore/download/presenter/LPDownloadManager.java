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
import com.baidu.tieba.ak0;
import com.baidu.tieba.al0;
import com.baidu.tieba.ck0;
import com.baidu.tieba.d31;
import com.baidu.tieba.dk0;
import com.baidu.tieba.gl0;
import com.baidu.tieba.ik0;
import com.baidu.tieba.ir0;
import com.baidu.tieba.k11;
import com.baidu.tieba.nj0;
import com.baidu.tieba.pk0;
import com.baidu.tieba.v01;
import com.baidu.tieba.w01;
import com.baidu.tieba.wj0;
import com.baidu.tieba.yp0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LPDownloadManager {
    public static LruCache<String, ik0> a;
    public static Map<String, Integer> b;
    public static final List<String> c = new ArrayList<String>() { // from class: com.baidu.nadcore.download.presenter.LPDownloadManager.1
        {
            add("https://cover.baidu.com");
            add("http://cover.baidu.com");
        }
    };

    /* loaded from: classes2.dex */
    public static class a extends ir0<dk0> {
        public final /* synthetic */ RelativeLayout a;
        public final /* synthetic */ wj0 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Context e;

        @Override // com.baidu.tieba.gr0
        public void a(Exception exc, int i) {
        }

        public a(RelativeLayout relativeLayout, wj0 wj0Var, String str, int i, Context context) {
            this.a = relativeLayout;
            this.b = wj0Var;
            this.c = str;
            this.d = i;
            this.e = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hr0
        /* renamed from: f */
        public dk0 d(Headers headers, String str, int i) {
            return dk0.a(v01.c(str).optJSONObject("data"));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hr0
        /* renamed from: e */
        public void b(Headers headers, dk0 dk0Var, int i) {
            if (dk0Var == null) {
                return;
            }
            int i2 = dk0Var.a;
            if (i2 == 1) {
                ik0 d = LPDownloadManager.d(this.a, this.b, this.c);
                d.A(dk0Var);
                d.B(true);
                d.m();
            } else if (i2 != 2 && i2 != 3) {
                d31.a().a(this.e, R.string.nad_download_lp_forbid_tip);
            } else {
                yp0 yp0Var = dk0Var.b;
                if (yp0Var != null) {
                    if (this.d == 1) {
                        LPDownloadManager.g(this.b, yp0Var);
                        ik0 d2 = LPDownloadManager.d(this.a, this.b, this.c);
                        d2.A(dk0Var);
                        d2.B(false);
                        d2.D(this.a, dk0Var, this.e);
                    } else if (this.e instanceof Activity) {
                        LPDownloadManager.g(this.b, yp0Var);
                        ik0 d3 = LPDownloadManager.d(this.a, this.b, this.c);
                        d3.A(dk0Var);
                        d3.B(false);
                        d3.C(this.a, dk0Var, (Activity) this.e);
                    }
                }
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).p(this.b.p.a).u(ClogBuilder.Page.DOWNLOAD_RECTIFY).k(String.valueOf(dk0Var.a)).l(this.c);
            k11.b(clogBuilder);
        }
    }

    public static void g(@NonNull wj0 wj0Var, @NonNull yp0 yp0Var) {
        wj0Var.g = yp0Var.j;
        ak0 ak0Var = wj0Var.p;
        ak0Var.g = yp0Var.b;
        ak0Var.h = yp0Var.c;
    }

    public static wj0 c(@NonNull String str) {
        JSONObject c2 = v01.c(str);
        String optString = c2.optString("key", "");
        if (TextUtils.isEmpty(optString)) {
            optString = c2.optString("lp_url", "");
        }
        wj0 query = nj0.b().query(optString);
        if (query != null) {
            return query;
        }
        wj0 wj0Var = new wj0();
        wj0Var.g = c2.optString("url", "");
        wj0Var.h(optString);
        wj0Var.q.a = c2.optString(BdVideoAd.AD_VIDEO_DAPAGE, "");
        wj0Var.q.j = c2.optString("da_area", "");
        wj0Var.q.b = c2.optString("business");
        wj0Var.q.d = c2.optString("content_type");
        wj0Var.q.e = c2.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
        wj0Var.q.g = c2.optInt("close_v_dl");
        wj0Var.p.a = c2.optString("log_ext");
        wj0Var.p.j = c2.optString(LegoListActivityConfig.AD_ID);
        wj0Var.p.g = c2.optString("app_icon");
        wj0Var.p.h = c2.optString("app_name");
        return wj0Var;
    }

    public static ik0 d(RelativeLayout relativeLayout, wj0 wj0Var, String str) {
        int i;
        pk0<?> a2 = gl0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
        ik0 ik0Var = new ik0(wj0Var, a2);
        if (a == null) {
            a = new LruCache<>(32);
        }
        w01.e(a, wj0Var.e(), ik0Var);
        return ik0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(@NonNull Context context, @NonNull RelativeLayout relativeLayout, String str, @NonNull wj0 wj0Var, int i) {
        for (String str2 : c) {
            if (wj0Var.g.startsWith(str2) || str.startsWith(str2)) {
                ik0 d = d(relativeLayout, wj0Var, str);
                d.B(true);
                d.m();
                return;
            }
            while (r0.hasNext()) {
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ext", wj0Var.p.a);
        linkedHashMap.put("charge_url", str);
        linkedHashMap.put("apk_url", wj0Var.g);
        new ck0().b(linkedHashMap, new a(relativeLayout, wj0Var, str, i, context));
    }

    public static boolean f(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        int i;
        if (context == null || relativeLayout == null || TextUtils.isEmpty(str)) {
            return false;
        }
        wj0 c2 = c(str);
        if (c2.f()) {
            return false;
        }
        JSONObject c3 = v01.c(str);
        String optString = c3.optString("lp_url", "");
        int optInt = c3.optInt("lp_check_mode", 0);
        ik0 ik0Var = (ik0) w01.b(a, c2.e());
        if (ik0Var != null) {
            if (z && c2.c != AdDownloadStatus.DOWNLOADING && ik0Var.y()) {
                ik0Var.m();
            }
            if (ik0Var.z()) {
                pk0<?> a2 = gl0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
                ik0Var.t(a2);
                if (!ik0Var.y()) {
                    if (optInt == 1) {
                        ik0Var.D(relativeLayout, ik0Var.x(), context);
                    } else if (context instanceof Activity) {
                        ik0Var.C(relativeLayout, ik0Var.x(), (Activity) context);
                    }
                }
            }
            return true;
        } else if (al0.a(str, optString)) {
            ik0 d = d(relativeLayout, c2, optString);
            d.B(true);
            d.m();
            return true;
        } else {
            e(context, relativeLayout, optString, c2, optInt);
            return true;
        }
    }
}
