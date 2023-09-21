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
import com.baidu.tieba.h31;
import com.baidu.tieba.hl0;
import com.baidu.tieba.i31;
import com.baidu.tieba.ll0;
import com.baidu.tieba.mt0;
import com.baidu.tieba.nl0;
import com.baidu.tieba.ol0;
import com.baidu.tieba.r51;
import com.baidu.tieba.rm0;
import com.baidu.tieba.tl0;
import com.baidu.tieba.w31;
import com.baidu.tieba.xm0;
import com.baidu.tieba.yk0;
import com.baidu.tieba.zr0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LPDownloadManager {
    public static LruCache<String, tl0> a;
    public static Map<String, Integer> b;
    public static final List<String> c = new ArrayList<String>() { // from class: com.baidu.nadcore.download.presenter.LPDownloadManager.1
        {
            add("https://cover.baidu.com");
            add("http://cover.baidu.com");
        }
    };

    /* loaded from: classes3.dex */
    public class a extends mt0<ol0> {
        public final /* synthetic */ RelativeLayout a;
        public final /* synthetic */ hl0 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Context e;

        @Override // com.baidu.tieba.kt0
        public void a(Exception exc, int i) {
        }

        public a(RelativeLayout relativeLayout, hl0 hl0Var, String str, int i, Context context) {
            this.a = relativeLayout;
            this.b = hl0Var;
            this.c = str;
            this.d = i;
            this.e = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lt0
        /* renamed from: f */
        public ol0 d(Headers headers, String str, int i) {
            return ol0.a(h31.c(str).optJSONObject("data"));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lt0
        /* renamed from: e */
        public void b(Headers headers, ol0 ol0Var, int i) {
            if (ol0Var == null) {
                return;
            }
            int i2 = ol0Var.a;
            if (i2 == 1) {
                tl0 d = LPDownloadManager.d(this.a, this.b, this.c);
                d.z(ol0Var);
                d.A(true);
                d.l();
            } else if (i2 != 2 && i2 != 3) {
                r51.a().a(this.e, R.string.nad_download_lp_forbid_tip);
            } else {
                zr0 zr0Var = ol0Var.b;
                if (zr0Var != null) {
                    if (this.d == 1) {
                        LPDownloadManager.g(this.b, zr0Var);
                        tl0 d2 = LPDownloadManager.d(this.a, this.b, this.c);
                        d2.z(ol0Var);
                        d2.A(false);
                        d2.C(this.a, ol0Var, this.e);
                    } else if (this.e instanceof Activity) {
                        LPDownloadManager.g(this.b, zr0Var);
                        tl0 d3 = LPDownloadManager.d(this.a, this.b, this.c);
                        d3.z(ol0Var);
                        d3.A(false);
                        d3.B(this.a, ol0Var, (Activity) this.e);
                    }
                }
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).p(this.b.p.a).u(ClogBuilder.Page.DOWNLOAD_RECTIFY).k(String.valueOf(ol0Var.a)).l(this.c);
            w31.e(clogBuilder);
        }
    }

    public static void g(@NonNull hl0 hl0Var, @NonNull zr0 zr0Var) {
        hl0Var.g = zr0Var.k;
        ll0 ll0Var = hl0Var.p;
        ll0Var.g = zr0Var.b;
        ll0Var.h = zr0Var.c;
    }

    public static hl0 c(@NonNull String str) {
        JSONObject c2 = h31.c(str);
        String optString = c2.optString("key", "");
        if (TextUtils.isEmpty(optString)) {
            optString = c2.optString("lp_url", "");
        }
        hl0 query = yk0.b().query(optString);
        if (query != null) {
            return query;
        }
        hl0 hl0Var = new hl0();
        hl0Var.g = c2.optString("url", "");
        hl0Var.h(optString);
        hl0Var.q.a = c2.optString(BdVideoAd.AD_VIDEO_DAPAGE, "");
        hl0Var.q.j = c2.optString("da_area", "");
        hl0Var.q.b = c2.optString("business");
        hl0Var.q.d = c2.optString("content_type");
        hl0Var.q.e = c2.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
        hl0Var.q.g = c2.optInt("close_v_dl");
        hl0Var.p.a = c2.optString("log_ext");
        hl0Var.p.j = c2.optString(LegoListActivityConfig.AD_ID);
        hl0Var.p.g = c2.optString("app_icon");
        hl0Var.p.h = c2.optString("app_name");
        return hl0Var;
    }

    public static tl0 d(RelativeLayout relativeLayout, hl0 hl0Var, String str) {
        int i;
        am0<?> a2 = xm0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
        tl0 tl0Var = new tl0(hl0Var, a2);
        if (a == null) {
            a = new LruCache<>(32);
        }
        i31.e(a, hl0Var.e(), tl0Var);
        return tl0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(@NonNull Context context, @NonNull RelativeLayout relativeLayout, String str, @NonNull hl0 hl0Var, int i) {
        for (String str2 : c) {
            if (hl0Var.g.startsWith(str2) || str.startsWith(str2)) {
                tl0 d = d(relativeLayout, hl0Var, str);
                d.A(true);
                d.l();
                return;
            }
            while (r0.hasNext()) {
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ext", hl0Var.p.a);
        linkedHashMap.put("charge_url", str);
        linkedHashMap.put("apk_url", hl0Var.g);
        new nl0().b(linkedHashMap, new a(relativeLayout, hl0Var, str, i, context));
    }

    public static boolean f(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        int i;
        if (context == null || relativeLayout == null || TextUtils.isEmpty(str)) {
            return false;
        }
        hl0 c2 = c(str);
        if (c2.f()) {
            return false;
        }
        JSONObject c3 = h31.c(str);
        String optString = c3.optString("lp_url", "");
        int optInt = c3.optInt("lp_check_mode", 0);
        tl0 tl0Var = (tl0) i31.b(a, c2.e());
        if (tl0Var != null) {
            if (z && c2.c != AdDownloadStatus.DOWNLOADING && tl0Var.x()) {
                tl0Var.l();
            }
            if (tl0Var.y()) {
                am0<?> a2 = xm0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
                tl0Var.s(a2);
                if (!tl0Var.x()) {
                    if (optInt == 1) {
                        tl0Var.C(relativeLayout, tl0Var.u(), context);
                    } else if (context instanceof Activity) {
                        tl0Var.B(relativeLayout, tl0Var.u(), (Activity) context);
                    }
                }
            }
            return true;
        } else if (rm0.a(str, optString)) {
            tl0 d = d(relativeLayout, c2, optString);
            d.A(true);
            d.l();
            return true;
        } else {
            e(context, relativeLayout, optString, c2, optInt);
            return true;
        }
    }
}
