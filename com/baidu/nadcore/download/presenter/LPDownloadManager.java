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
import com.baidu.tieba.ah0;
import com.baidu.tieba.ch0;
import com.baidu.tieba.dh0;
import com.baidu.tieba.dp0;
import com.baidu.tieba.dz0;
import com.baidu.tieba.gi0;
import com.baidu.tieba.ih0;
import com.baidu.tieba.mi0;
import com.baidu.tieba.ng0;
import com.baidu.tieba.oy0;
import com.baidu.tieba.ph0;
import com.baidu.tieba.pn0;
import com.baidu.tieba.py0;
import com.baidu.tieba.wg0;
import com.baidu.tieba.y01;
import com.baidu.tieba.y11;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LPDownloadManager {
    public static LruCache<String, ih0> a;
    public static Map<String, Integer> b;
    public static final List<String> c = new ArrayList<String>() { // from class: com.baidu.nadcore.download.presenter.LPDownloadManager.1
        {
            add("https://cover.baidu.com");
            add("http://cover.baidu.com");
        }
    };

    /* loaded from: classes3.dex */
    public class a extends dp0<dh0> {
        public final /* synthetic */ RelativeLayout a;
        public final /* synthetic */ wg0 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Context e;

        @Override // com.baidu.tieba.bp0
        public void a(Exception exc, int i) {
        }

        public a(RelativeLayout relativeLayout, wg0 wg0Var, String str, int i, Context context) {
            this.a = relativeLayout;
            this.b = wg0Var;
            this.c = str;
            this.d = i;
            this.e = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cp0
        /* renamed from: f */
        public dh0 d(Headers headers, String str, int i) {
            return dh0.a(oy0.c(str).optJSONObject("data"));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cp0
        /* renamed from: e */
        public void b(Headers headers, dh0 dh0Var, int i) {
            if (dh0Var == null) {
                return;
            }
            int i2 = dh0Var.a;
            if (i2 == 1) {
                ih0 d = LPDownloadManager.d(this.a, this.b, this.c);
                d.z(dh0Var);
                d.A(true);
                d.l();
            } else if (i2 != 2 && i2 != 3) {
                if (y11.a()) {
                    y01.a().a(this.e, R.string.obfuscated_res_0x7f0f0db6);
                } else {
                    y01.a().a(this.e, R.string.nad_download_lp_forbid_tip);
                }
            } else {
                pn0 pn0Var = dh0Var.b;
                if (pn0Var != null) {
                    if (this.d == 1) {
                        LPDownloadManager.g(this.b, pn0Var);
                        ih0 d2 = LPDownloadManager.d(this.a, this.b, this.c);
                        d2.z(dh0Var);
                        d2.A(false);
                        d2.C(this.a, dh0Var, this.e);
                    } else if (this.e instanceof Activity) {
                        LPDownloadManager.g(this.b, pn0Var);
                        ih0 d3 = LPDownloadManager.d(this.a, this.b, this.c);
                        d3.z(dh0Var);
                        d3.A(false);
                        d3.B(this.a, dh0Var, (Activity) this.e);
                    }
                }
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).p(this.b.p.a).u(ClogBuilder.Page.DOWNLOAD_RECTIFY).k(String.valueOf(dh0Var.a)).l(this.c);
            dz0.e(clogBuilder);
        }
    }

    public static void g(@NonNull wg0 wg0Var, @NonNull pn0 pn0Var) {
        wg0Var.g = pn0Var.l;
        ah0 ah0Var = wg0Var.p;
        ah0Var.g = pn0Var.b;
        ah0Var.h = pn0Var.c;
    }

    public static wg0 c(@NonNull String str) {
        JSONObject c2 = oy0.c(str);
        String optString = c2.optString("key", "");
        if (TextUtils.isEmpty(optString)) {
            optString = c2.optString("lp_url", "");
        }
        wg0 d = ng0.b().d(optString);
        if (d != null) {
            return d;
        }
        wg0 wg0Var = new wg0();
        wg0Var.g = c2.optString("url", "");
        wg0Var.h(optString);
        wg0Var.q.a = c2.optString(BdVideoAd.AD_VIDEO_DAPAGE, "");
        wg0Var.q.j = c2.optString("da_area", "");
        wg0Var.q.b = c2.optString("business");
        wg0Var.q.d = c2.optString("content_type");
        wg0Var.q.e = c2.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
        wg0Var.q.g = c2.optInt("close_v_dl");
        wg0Var.p.a = c2.optString("log_ext");
        wg0Var.p.j = c2.optString(LegoListActivityConfig.AD_ID);
        wg0Var.p.g = c2.optString("app_icon");
        wg0Var.p.h = c2.optString("app_name");
        return wg0Var;
    }

    public static ih0 d(RelativeLayout relativeLayout, wg0 wg0Var, String str) {
        int i;
        ph0<?> a2 = mi0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
        ih0 ih0Var = new ih0(wg0Var, a2);
        if (a == null) {
            a = new LruCache<>(32);
        }
        py0.e(a, wg0Var.e(), ih0Var);
        return ih0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(@NonNull Context context, @NonNull RelativeLayout relativeLayout, String str, @NonNull wg0 wg0Var, int i) {
        for (String str2 : c) {
            if (wg0Var.g.startsWith(str2) || str.startsWith(str2)) {
                ih0 d = d(relativeLayout, wg0Var, str);
                d.A(true);
                d.l();
                return;
            }
            while (r0.hasNext()) {
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ext", wg0Var.p.a);
        linkedHashMap.put("charge_url", str);
        linkedHashMap.put("apk_url", wg0Var.g);
        new ch0().b(linkedHashMap, new a(relativeLayout, wg0Var, str, i, context));
    }

    public static boolean f(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        int i;
        if (context == null || relativeLayout == null || TextUtils.isEmpty(str)) {
            return false;
        }
        wg0 c2 = c(str);
        if (c2.f()) {
            return false;
        }
        JSONObject c3 = oy0.c(str);
        String optString = c3.optString("lp_url", "");
        int optInt = c3.optInt("lp_check_mode", 0);
        ih0 ih0Var = (ih0) py0.b(a, c2.e());
        if (ih0Var != null) {
            if (z && c2.c != AdDownloadStatus.DOWNLOADING && ih0Var.x()) {
                ih0Var.l();
            }
            if (ih0Var.y()) {
                ph0<?> a2 = mi0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
                ih0Var.s(a2);
                if (!ih0Var.x()) {
                    if (optInt == 1) {
                        ih0Var.C(relativeLayout, ih0Var.u(), context);
                    } else if (context instanceof Activity) {
                        ih0Var.B(relativeLayout, ih0Var.u(), (Activity) context);
                    }
                }
            }
            return true;
        } else if (gi0.a(str, optString)) {
            ih0 d = d(relativeLayout, c2, optString);
            d.A(true);
            d.l();
            return true;
        } else {
            e(context, relativeLayout, optString, c2, optInt);
            return true;
        }
    }
}
