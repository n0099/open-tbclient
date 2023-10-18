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
import com.baidu.tieba.e01;
import com.baidu.tieba.eg0;
import com.baidu.tieba.ig0;
import com.baidu.tieba.jo0;
import com.baidu.tieba.jy0;
import com.baidu.tieba.kg0;
import com.baidu.tieba.lg0;
import com.baidu.tieba.oh0;
import com.baidu.tieba.qg0;
import com.baidu.tieba.uh0;
import com.baidu.tieba.ux0;
import com.baidu.tieba.vf0;
import com.baidu.tieba.vx0;
import com.baidu.tieba.wm0;
import com.baidu.tieba.xg0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LPDownloadManager {
    public static LruCache<String, qg0> a;
    public static Map<String, Integer> b;
    public static final List<String> c = new ArrayList<String>() { // from class: com.baidu.nadcore.download.presenter.LPDownloadManager.1
        {
            add("https://cover.baidu.com");
            add("http://cover.baidu.com");
        }
    };

    /* loaded from: classes3.dex */
    public class a extends jo0<lg0> {
        public final /* synthetic */ RelativeLayout a;
        public final /* synthetic */ eg0 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Context e;

        @Override // com.baidu.tieba.ho0
        public void a(Exception exc, int i) {
        }

        public a(RelativeLayout relativeLayout, eg0 eg0Var, String str, int i, Context context) {
            this.a = relativeLayout;
            this.b = eg0Var;
            this.c = str;
            this.d = i;
            this.e = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.io0
        /* renamed from: f */
        public lg0 d(Headers headers, String str, int i) {
            return lg0.a(ux0.c(str).optJSONObject("data"));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.io0
        /* renamed from: e */
        public void b(Headers headers, lg0 lg0Var, int i) {
            if (lg0Var == null) {
                return;
            }
            int i2 = lg0Var.a;
            if (i2 == 1) {
                qg0 d = LPDownloadManager.d(this.a, this.b, this.c);
                d.y(lg0Var);
                d.z(true);
                d.l();
            } else if (i2 != 2 && i2 != 3) {
                e01.a().a(this.e, R.string.nad_download_lp_forbid_tip);
            } else {
                wm0 wm0Var = lg0Var.b;
                if (wm0Var != null) {
                    if (this.d == 1) {
                        LPDownloadManager.g(this.b, wm0Var);
                        qg0 d2 = LPDownloadManager.d(this.a, this.b, this.c);
                        d2.y(lg0Var);
                        d2.z(false);
                        d2.B(this.a, lg0Var, this.e);
                    } else if (this.e instanceof Activity) {
                        LPDownloadManager.g(this.b, wm0Var);
                        qg0 d3 = LPDownloadManager.d(this.a, this.b, this.c);
                        d3.y(lg0Var);
                        d3.z(false);
                        d3.A(this.a, lg0Var, (Activity) this.e);
                    }
                }
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).p(this.b.p.a).u(ClogBuilder.Page.DOWNLOAD_RECTIFY).k(String.valueOf(lg0Var.a)).l(this.c);
            jy0.e(clogBuilder);
        }
    }

    public static void g(@NonNull eg0 eg0Var, @NonNull wm0 wm0Var) {
        eg0Var.g = wm0Var.k;
        ig0 ig0Var = eg0Var.p;
        ig0Var.g = wm0Var.b;
        ig0Var.h = wm0Var.c;
    }

    public static eg0 c(@NonNull String str) {
        JSONObject c2 = ux0.c(str);
        String optString = c2.optString("key", "");
        if (TextUtils.isEmpty(optString)) {
            optString = c2.optString("lp_url", "");
        }
        eg0 d = vf0.b().d(optString);
        if (d != null) {
            return d;
        }
        eg0 eg0Var = new eg0();
        eg0Var.g = c2.optString("url", "");
        eg0Var.h(optString);
        eg0Var.q.a = c2.optString(BdVideoAd.AD_VIDEO_DAPAGE, "");
        eg0Var.q.j = c2.optString("da_area", "");
        eg0Var.q.b = c2.optString("business");
        eg0Var.q.d = c2.optString("content_type");
        eg0Var.q.e = c2.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
        eg0Var.q.g = c2.optInt("close_v_dl");
        eg0Var.p.a = c2.optString("log_ext");
        eg0Var.p.j = c2.optString(LegoListActivityConfig.AD_ID);
        eg0Var.p.g = c2.optString("app_icon");
        eg0Var.p.h = c2.optString("app_name");
        return eg0Var;
    }

    public static qg0 d(RelativeLayout relativeLayout, eg0 eg0Var, String str) {
        int i;
        xg0<?> a2 = uh0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
        qg0 qg0Var = new qg0(eg0Var, a2);
        if (a == null) {
            a = new LruCache<>(32);
        }
        vx0.e(a, eg0Var.e(), qg0Var);
        return qg0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(@NonNull Context context, @NonNull RelativeLayout relativeLayout, String str, @NonNull eg0 eg0Var, int i) {
        for (String str2 : c) {
            if (eg0Var.g.startsWith(str2) || str.startsWith(str2)) {
                qg0 d = d(relativeLayout, eg0Var, str);
                d.z(true);
                d.l();
                return;
            }
            while (r0.hasNext()) {
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ext", eg0Var.p.a);
        linkedHashMap.put("charge_url", str);
        linkedHashMap.put("apk_url", eg0Var.g);
        new kg0().b(linkedHashMap, new a(relativeLayout, eg0Var, str, i, context));
    }

    public static boolean f(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        int i;
        if (context == null || relativeLayout == null || TextUtils.isEmpty(str)) {
            return false;
        }
        eg0 c2 = c(str);
        if (c2.f()) {
            return false;
        }
        JSONObject c3 = ux0.c(str);
        String optString = c3.optString("lp_url", "");
        int optInt = c3.optInt("lp_check_mode", 0);
        qg0 qg0Var = (qg0) vx0.b(a, c2.e());
        if (qg0Var != null) {
            if (z && c2.c != AdDownloadStatus.DOWNLOADING && qg0Var.u()) {
                qg0Var.l();
            }
            if (qg0Var.x()) {
                xg0<?> a2 = uh0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
                qg0Var.r(a2);
                if (!qg0Var.u()) {
                    if (optInt == 1) {
                        qg0Var.B(relativeLayout, qg0Var.t(), context);
                    } else if (context instanceof Activity) {
                        qg0Var.A(relativeLayout, qg0Var.t(), (Activity) context);
                    }
                }
            }
            return true;
        } else if (oh0.a(str, optString)) {
            qg0 d = d(relativeLayout, c2, optString);
            d.z(true);
            d.l();
            return true;
        } else {
            e(context, relativeLayout, optString, c2, optInt);
            return true;
        }
    }
}
