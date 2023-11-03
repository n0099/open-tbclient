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
import com.baidu.tieba.ap0;
import com.baidu.tieba.az0;
import com.baidu.tieba.bh0;
import com.baidu.tieba.ch0;
import com.baidu.tieba.fi0;
import com.baidu.tieba.hh0;
import com.baidu.tieba.li0;
import com.baidu.tieba.ly0;
import com.baidu.tieba.mg0;
import com.baidu.tieba.my0;
import com.baidu.tieba.nn0;
import com.baidu.tieba.oh0;
import com.baidu.tieba.v01;
import com.baidu.tieba.vg0;
import com.baidu.tieba.zg0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LPDownloadManager {
    public static LruCache<String, hh0> a;
    public static Map<String, Integer> b;
    public static final List<String> c = new ArrayList<String>() { // from class: com.baidu.nadcore.download.presenter.LPDownloadManager.1
        {
            add("https://cover.baidu.com");
            add("http://cover.baidu.com");
        }
    };

    /* loaded from: classes3.dex */
    public class a extends ap0<ch0> {
        public final /* synthetic */ RelativeLayout a;
        public final /* synthetic */ vg0 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Context e;

        @Override // com.baidu.tieba.yo0
        public void a(Exception exc, int i) {
        }

        public a(RelativeLayout relativeLayout, vg0 vg0Var, String str, int i, Context context) {
            this.a = relativeLayout;
            this.b = vg0Var;
            this.c = str;
            this.d = i;
            this.e = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zo0
        /* renamed from: f */
        public ch0 d(Headers headers, String str, int i) {
            return ch0.a(ly0.c(str).optJSONObject("data"));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zo0
        /* renamed from: e */
        public void b(Headers headers, ch0 ch0Var, int i) {
            if (ch0Var == null) {
                return;
            }
            int i2 = ch0Var.a;
            if (i2 == 1) {
                hh0 d = LPDownloadManager.d(this.a, this.b, this.c);
                d.z(ch0Var);
                d.A(true);
                d.m();
            } else if (i2 != 2 && i2 != 3) {
                v01.a().a(this.e, R.string.nad_download_lp_forbid_tip);
            } else {
                nn0 nn0Var = ch0Var.b;
                if (nn0Var != null) {
                    if (this.d == 1) {
                        LPDownloadManager.g(this.b, nn0Var);
                        hh0 d2 = LPDownloadManager.d(this.a, this.b, this.c);
                        d2.z(ch0Var);
                        d2.A(false);
                        d2.C(this.a, ch0Var, this.e);
                    } else if (this.e instanceof Activity) {
                        LPDownloadManager.g(this.b, nn0Var);
                        hh0 d3 = LPDownloadManager.d(this.a, this.b, this.c);
                        d3.z(ch0Var);
                        d3.A(false);
                        d3.B(this.a, ch0Var, (Activity) this.e);
                    }
                }
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).p(this.b.p.a).u(ClogBuilder.Page.DOWNLOAD_RECTIFY).k(String.valueOf(ch0Var.a)).l(this.c);
            az0.e(clogBuilder);
        }
    }

    public static void g(@NonNull vg0 vg0Var, @NonNull nn0 nn0Var) {
        vg0Var.g = nn0Var.k;
        zg0 zg0Var = vg0Var.p;
        zg0Var.g = nn0Var.b;
        zg0Var.h = nn0Var.c;
    }

    public static vg0 c(@NonNull String str) {
        JSONObject c2 = ly0.c(str);
        String optString = c2.optString("key", "");
        if (TextUtils.isEmpty(optString)) {
            optString = c2.optString("lp_url", "");
        }
        vg0 d = mg0.b().d(optString);
        if (d != null) {
            return d;
        }
        vg0 vg0Var = new vg0();
        vg0Var.g = c2.optString("url", "");
        vg0Var.h(optString);
        vg0Var.q.a = c2.optString(BdVideoAd.AD_VIDEO_DAPAGE, "");
        vg0Var.q.j = c2.optString("da_area", "");
        vg0Var.q.b = c2.optString("business");
        vg0Var.q.d = c2.optString("content_type");
        vg0Var.q.e = c2.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
        vg0Var.q.g = c2.optInt("close_v_dl");
        vg0Var.p.a = c2.optString("log_ext");
        vg0Var.p.j = c2.optString(LegoListActivityConfig.AD_ID);
        vg0Var.p.g = c2.optString("app_icon");
        vg0Var.p.h = c2.optString("app_name");
        return vg0Var;
    }

    public static hh0 d(RelativeLayout relativeLayout, vg0 vg0Var, String str) {
        int i;
        oh0<?> a2 = li0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
        hh0 hh0Var = new hh0(vg0Var, a2);
        if (a == null) {
            a = new LruCache<>(32);
        }
        my0.e(a, vg0Var.e(), hh0Var);
        return hh0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(@NonNull Context context, @NonNull RelativeLayout relativeLayout, String str, @NonNull vg0 vg0Var, int i) {
        for (String str2 : c) {
            if (vg0Var.g.startsWith(str2) || str.startsWith(str2)) {
                hh0 d = d(relativeLayout, vg0Var, str);
                d.A(true);
                d.m();
                return;
            }
            while (r0.hasNext()) {
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ext", vg0Var.p.a);
        linkedHashMap.put("charge_url", str);
        linkedHashMap.put("apk_url", vg0Var.g);
        new bh0().b(linkedHashMap, new a(relativeLayout, vg0Var, str, i, context));
    }

    public static boolean f(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        int i;
        if (context == null || relativeLayout == null || TextUtils.isEmpty(str)) {
            return false;
        }
        vg0 c2 = c(str);
        if (c2.f()) {
            return false;
        }
        JSONObject c3 = ly0.c(str);
        String optString = c3.optString("lp_url", "");
        int optInt = c3.optInt("lp_check_mode", 0);
        hh0 hh0Var = (hh0) my0.b(a, c2.e());
        if (hh0Var != null) {
            if (z && c2.c != AdDownloadStatus.DOWNLOADING && hh0Var.x()) {
                hh0Var.m();
            }
            if (hh0Var.y()) {
                oh0<?> a2 = li0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
                hh0Var.s(a2);
                if (!hh0Var.x()) {
                    if (optInt == 1) {
                        hh0Var.C(relativeLayout, hh0Var.u(), context);
                    } else if (context instanceof Activity) {
                        hh0Var.B(relativeLayout, hh0Var.u(), (Activity) context);
                    }
                }
            }
            return true;
        } else if (fi0.a(str, optString)) {
            hh0 d = d(relativeLayout, c2, optString);
            d.A(true);
            d.m();
            return true;
        } else {
            e(context, relativeLayout, optString, c2, optInt);
            return true;
        }
    }
}
