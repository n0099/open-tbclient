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
import com.baidu.tieba.du0;
import com.baidu.tieba.g61;
import com.baidu.tieba.gm0;
import com.baidu.tieba.km0;
import com.baidu.tieba.mm0;
import com.baidu.tieba.n41;
import com.baidu.tieba.nm0;
import com.baidu.tieba.qn0;
import com.baidu.tieba.qs0;
import com.baidu.tieba.sm0;
import com.baidu.tieba.wn0;
import com.baidu.tieba.xl0;
import com.baidu.tieba.y31;
import com.baidu.tieba.z31;
import com.baidu.tieba.zm0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LPDownloadManager {
    public static LruCache<String, sm0> a;
    public static Map<String, Integer> b;
    public static final List<String> c = new ArrayList<String>() { // from class: com.baidu.nadcore.download.presenter.LPDownloadManager.1
        {
            add("https://cover.baidu.com");
            add("http://cover.baidu.com");
        }
    };

    /* loaded from: classes3.dex */
    public class a extends du0<nm0> {
        public final /* synthetic */ RelativeLayout a;
        public final /* synthetic */ gm0 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Context e;

        @Override // com.baidu.tieba.bu0
        public void a(Exception exc, int i) {
        }

        public a(RelativeLayout relativeLayout, gm0 gm0Var, String str, int i, Context context) {
            this.a = relativeLayout;
            this.b = gm0Var;
            this.c = str;
            this.d = i;
            this.e = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cu0
        /* renamed from: f */
        public nm0 d(Headers headers, String str, int i) {
            return nm0.a(y31.c(str).optJSONObject("data"));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cu0
        /* renamed from: e */
        public void b(Headers headers, nm0 nm0Var, int i) {
            if (nm0Var == null) {
                return;
            }
            int i2 = nm0Var.a;
            if (i2 == 1) {
                sm0 d = LPDownloadManager.d(this.a, this.b, this.c);
                d.z(nm0Var);
                d.A(true);
                d.l();
            } else if (i2 != 2 && i2 != 3) {
                g61.a().a(this.e, R.string.nad_download_lp_forbid_tip);
            } else {
                qs0 qs0Var = nm0Var.b;
                if (qs0Var != null) {
                    if (this.d == 1) {
                        LPDownloadManager.g(this.b, qs0Var);
                        sm0 d2 = LPDownloadManager.d(this.a, this.b, this.c);
                        d2.z(nm0Var);
                        d2.A(false);
                        d2.C(this.a, nm0Var, this.e);
                    } else if (this.e instanceof Activity) {
                        LPDownloadManager.g(this.b, qs0Var);
                        sm0 d3 = LPDownloadManager.d(this.a, this.b, this.c);
                        d3.z(nm0Var);
                        d3.A(false);
                        d3.B(this.a, nm0Var, (Activity) this.e);
                    }
                }
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).p(this.b.p.a).u(ClogBuilder.Page.DOWNLOAD_RECTIFY).k(String.valueOf(nm0Var.a)).l(this.c);
            n41.e(clogBuilder);
        }
    }

    public static void g(@NonNull gm0 gm0Var, @NonNull qs0 qs0Var) {
        gm0Var.g = qs0Var.j;
        km0 km0Var = gm0Var.p;
        km0Var.g = qs0Var.b;
        km0Var.h = qs0Var.c;
    }

    public static gm0 c(@NonNull String str) {
        JSONObject c2 = y31.c(str);
        String optString = c2.optString("key", "");
        if (TextUtils.isEmpty(optString)) {
            optString = c2.optString("lp_url", "");
        }
        gm0 query = xl0.b().query(optString);
        if (query != null) {
            return query;
        }
        gm0 gm0Var = new gm0();
        gm0Var.g = c2.optString("url", "");
        gm0Var.h(optString);
        gm0Var.q.a = c2.optString(BdVideoAd.AD_VIDEO_DAPAGE, "");
        gm0Var.q.j = c2.optString("da_area", "");
        gm0Var.q.b = c2.optString("business");
        gm0Var.q.d = c2.optString("content_type");
        gm0Var.q.e = c2.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
        gm0Var.q.g = c2.optInt("close_v_dl");
        gm0Var.p.a = c2.optString("log_ext");
        gm0Var.p.j = c2.optString(LegoListActivityConfig.AD_ID);
        gm0Var.p.g = c2.optString("app_icon");
        gm0Var.p.h = c2.optString("app_name");
        return gm0Var;
    }

    public static sm0 d(RelativeLayout relativeLayout, gm0 gm0Var, String str) {
        int i;
        zm0<?> a2 = wn0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
        sm0 sm0Var = new sm0(gm0Var, a2);
        if (a == null) {
            a = new LruCache<>(32);
        }
        z31.e(a, gm0Var.e(), sm0Var);
        return sm0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(@NonNull Context context, @NonNull RelativeLayout relativeLayout, String str, @NonNull gm0 gm0Var, int i) {
        for (String str2 : c) {
            if (gm0Var.g.startsWith(str2) || str.startsWith(str2)) {
                sm0 d = d(relativeLayout, gm0Var, str);
                d.A(true);
                d.l();
                return;
            }
            while (r0.hasNext()) {
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ext", gm0Var.p.a);
        linkedHashMap.put("charge_url", str);
        linkedHashMap.put("apk_url", gm0Var.g);
        new mm0().b(linkedHashMap, new a(relativeLayout, gm0Var, str, i, context));
    }

    public static boolean f(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        int i;
        if (context == null || relativeLayout == null || TextUtils.isEmpty(str)) {
            return false;
        }
        gm0 c2 = c(str);
        if (c2.f()) {
            return false;
        }
        JSONObject c3 = y31.c(str);
        String optString = c3.optString("lp_url", "");
        int optInt = c3.optInt("lp_check_mode", 0);
        sm0 sm0Var = (sm0) z31.b(a, c2.e());
        if (sm0Var != null) {
            if (z && c2.c != AdDownloadStatus.DOWNLOADING && sm0Var.x()) {
                sm0Var.l();
            }
            if (sm0Var.y()) {
                zm0<?> a2 = wn0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
                sm0Var.s(a2);
                if (!sm0Var.x()) {
                    if (optInt == 1) {
                        sm0Var.C(relativeLayout, sm0Var.u(), context);
                    } else if (context instanceof Activity) {
                        sm0Var.B(relativeLayout, sm0Var.u(), (Activity) context);
                    }
                }
            }
            return true;
        } else if (qn0.a(str, optString)) {
            sm0 d = d(relativeLayout, c2, optString);
            d.A(true);
            d.l();
            return true;
        } else {
            e(context, relativeLayout, optString, c2, optInt);
            return true;
        }
    }
}
