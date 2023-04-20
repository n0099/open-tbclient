package com.baidu.swan.apps.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.tieba.ac3;
import com.baidu.tieba.ay1;
import com.baidu.tieba.az1;
import com.baidu.tieba.bb3;
import com.baidu.tieba.bw1;
import com.baidu.tieba.bz1;
import com.baidu.tieba.ca2;
import com.baidu.tieba.cw1;
import com.baidu.tieba.cx1;
import com.baidu.tieba.cy1;
import com.baidu.tieba.cz1;
import com.baidu.tieba.d33;
import com.baidu.tieba.dw1;
import com.baidu.tieba.dy1;
import com.baidu.tieba.dz1;
import com.baidu.tieba.ew1;
import com.baidu.tieba.ey1;
import com.baidu.tieba.ez1;
import com.baidu.tieba.fw1;
import com.baidu.tieba.fy1;
import com.baidu.tieba.gy1;
import com.baidu.tieba.gz1;
import com.baidu.tieba.hw1;
import com.baidu.tieba.hy1;
import com.baidu.tieba.i03;
import com.baidu.tieba.ix1;
import com.baidu.tieba.iy1;
import com.baidu.tieba.jw1;
import com.baidu.tieba.jx1;
import com.baidu.tieba.jy1;
import com.baidu.tieba.kw1;
import com.baidu.tieba.ky1;
import com.baidu.tieba.li3;
import com.baidu.tieba.lv1;
import com.baidu.tieba.ly1;
import com.baidu.tieba.mo1;
import com.baidu.tieba.mx2;
import com.baidu.tieba.nw1;
import com.baidu.tieba.nx1;
import com.baidu.tieba.oa2;
import com.baidu.tieba.ox1;
import com.baidu.tieba.ox2;
import com.baidu.tieba.oy1;
import com.baidu.tieba.pw1;
import com.baidu.tieba.px1;
import com.baidu.tieba.qw1;
import com.baidu.tieba.qx1;
import com.baidu.tieba.qy1;
import com.baidu.tieba.rw1;
import com.baidu.tieba.rx1;
import com.baidu.tieba.s03;
import com.baidu.tieba.se3;
import com.baidu.tieba.sw1;
import com.baidu.tieba.tw1;
import com.baidu.tieba.tx1;
import com.baidu.tieba.tz1;
import com.baidu.tieba.uw1;
import com.baidu.tieba.ux1;
import com.baidu.tieba.uz1;
import com.baidu.tieba.vw1;
import com.baidu.tieba.vy1;
import com.baidu.tieba.vz1;
import com.baidu.tieba.wb2;
import com.baidu.tieba.wv1;
import com.baidu.tieba.ww1;
import com.baidu.tieba.wx1;
import com.baidu.tieba.wy1;
import com.baidu.tieba.wz1;
import com.baidu.tieba.xw1;
import com.baidu.tieba.xx1;
import com.baidu.tieba.xy1;
import com.baidu.tieba.yj3;
import com.baidu.tieba.yk2;
import com.baidu.tieba.yv1;
import com.baidu.tieba.yw1;
import com.baidu.tieba.yy1;
import com.baidu.tieba.zv1;
import com.baidu.tieba.zw1;
import com.baidu.tieba.zx1;
import com.baidu.tieba.zy1;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
@Keep
/* loaded from: classes3.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final wv1 wv1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                cw1 cw1Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof cw1)) {
                    cw1Var = (cw1) obj;
                } else {
                    cw1Var = new cw1(this.mSwanApiContext);
                    this.mApis.put("1930258908", cw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(cw1Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Account.checkSession")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = cw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                dw1 dw1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof dw1)) {
                    dw1Var = (dw1) obj;
                } else {
                    dw1Var = new dw1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", dw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(dw1Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Account.getLoginCode")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 C = dw1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                ew1 ew1Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof ew1)) {
                    ew1Var = (ew1) obj;
                } else {
                    ew1Var = new ew1(this.mSwanApiContext);
                    this.mApis.put("1754780133", ew1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ew1Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Account.getOpenId")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = ew1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                lv1 lv1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof lv1)) {
                    lv1Var = (lv1) obj;
                } else {
                    lv1Var = new lv1(this.mSwanApiContext);
                    this.mApis.put("-343998465", lv1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(lv1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Account.getUnionBDUSS")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = lv1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String login(String str) {
                dw1 dw1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof dw1)) {
                    dw1Var = (dw1) obj;
                } else {
                    dw1Var = new dw1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", dw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(dw1Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Account.login")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 I = dw1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                bw1 bw1Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof bw1)) {
                    bw1Var = (bw1) obj;
                } else {
                    bw1Var = new bw1(this.mSwanApiContext);
                    this.mApis.put("-337742792", bw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(bw1Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Account.isBaiduAccountSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = bw1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                dw1 dw1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof dw1)) {
                    dw1Var = (dw1) obj;
                } else {
                    dw1Var = new dw1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", dw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(dw1Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Account.isLoginSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 H = dw1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBasic", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                fw1 fw1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof fw1)) {
                    fw1Var = (fw1) obj;
                } else {
                    fw1Var = new fw1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", fw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(fw1Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Basic.loadSubPackage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 F = fw1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                fw1 fw1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof fw1)) {
                    fw1Var = (fw1) obj;
                } else {
                    fw1Var = new fw1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", fw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(fw1Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Basic.loadSubPackages")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 G = fw1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                mo1 mo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof mo1)) {
                    mo1Var = (mo1) obj;
                } else {
                    mo1Var = new mo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", mo1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(mo1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Bookshelf.deleteBookshelf")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 K = mo1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                mo1 mo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof mo1)) {
                    mo1Var = (mo1) obj;
                } else {
                    mo1Var = new mo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", mo1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(mo1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Bookshelf.insertBookshelf")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 P = mo1Var.P(str);
                if (P == null) {
                    return "";
                }
                return P.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                mo1 mo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof mo1)) {
                    mo1Var = (mo1) obj;
                } else {
                    mo1Var = new mo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", mo1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(mo1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Bookshelf.navigateToBookshelf")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 U = mo1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                mo1 mo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof mo1)) {
                    mo1Var = (mo1) obj;
                } else {
                    mo1Var = new mo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", mo1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(mo1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Bookshelf.queryBookshelf")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 V = mo1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                mo1 mo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof mo1)) {
                    mo1Var = (mo1) obj;
                } else {
                    mo1Var = new mo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", mo1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(mo1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Bookshelf.updateBookshelfReadTime")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 X = mo1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naCoupon", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                zv1 zv1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof zv1)) {
                    zv1Var = (zv1) obj;
                } else {
                    zv1Var = new zv1(this.mSwanApiContext);
                    this.mApis.put("-277316359", zv1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(zv1Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Coupon.getPlatformCoupons")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = zv1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                zv1 zv1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof zv1)) {
                    zv1Var = (zv1) obj;
                } else {
                    zv1Var = new zv1(this.mSwanApiContext);
                    this.mApis.put("-277316359", zv1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(zv1Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Coupon.getUserCoupons")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 z = zv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                zv1 zv1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof zv1)) {
                    zv1Var = (zv1) obj;
                } else {
                    zv1Var = new zv1(this.mSwanApiContext);
                    this.mApis.put("-277316359", zv1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(zv1Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Coupon.takeCoupons")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 C = zv1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naFavorite", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                hw1 hw1Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof hw1)) {
                    hw1Var = (hw1) obj;
                } else {
                    hw1Var = new hw1(this.mSwanApiContext);
                    this.mApis.put("-1225406515", hw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(hw1Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Favorite.getFavorStatus")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = hw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String showFavoriteGuide(String str) {
                ShowFavoriteGuideApi showFavoriteGuideApi;
                Object obj = this.mApis.get("269275578");
                if (obj != null && (obj instanceof ShowFavoriteGuideApi)) {
                    showFavoriteGuideApi = (ShowFavoriteGuideApi) obj;
                } else {
                    showFavoriteGuideApi = new ShowFavoriteGuideApi(this.mSwanApiContext);
                    this.mApis.put("269275578", showFavoriteGuideApi);
                }
                Pair<Boolean, uz1> a = wz1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Favorite.showFavoriteGuide")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 G = showFavoriteGuideApi.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naFile", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-2057135077", jw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(jw1Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "File.shareFile")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = jw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                yk2 yk2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof yk2)) {
                    yk2Var = (yk2) obj;
                } else {
                    yk2Var = new yk2(this.mSwanApiContext);
                    this.mApis.put("2077414795", yk2Var);
                }
                Pair<Boolean, uz1> a = wz1.a(yk2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = yk2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                yk2 yk2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof yk2)) {
                    yk2Var = (yk2) obj;
                } else {
                    yk2Var = new yk2(this.mSwanApiContext);
                    this.mApis.put("2077414795", yk2Var);
                }
                Pair<Boolean, uz1> a = wz1.a(yk2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessageSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = yk2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String download(String str) {
                kw1 kw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", kw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(kw1Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "HostDownloadManager.download")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = kw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                kw1 kw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", kw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(kw1Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "HostDownloadManager.openFile")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 z = kw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String query(String str) {
                kw1 kw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", kw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(kw1Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "HostDownloadManager.query")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 query = kw1Var.query(str);
                if (query == null) {
                    return "";
                }
                return query.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                kw1 kw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", kw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(kw1Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "HostDownloadManager.openDownloadCenter")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = kw1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naImage", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                mx2 mx2Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof mx2)) {
                    mx2Var = (mx2) obj;
                } else {
                    mx2Var = new mx2(this.mSwanApiContext);
                    this.mApis.put("1445003743", mx2Var);
                }
                Pair<Boolean, uz1> a = wz1.a(mx2Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Image.callImageMenu")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = mx2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                nw1 nw1Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof nw1)) {
                    nw1Var = (nw1) obj;
                } else {
                    nw1Var = new nw1(this.mSwanApiContext);
                    this.mApis.put("-1252730367", nw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(nw1Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Image.compressImage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = nw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naInteraction", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                vw1 vw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", vw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(vw1Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.closeTabBar")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = vw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                vw1 vw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", vw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(vw1Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.closeTabBarRedDot")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = vw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                rw1 rw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", rw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(rw1Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.hideNavigationBarLoading")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = rw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", tw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(tw1Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.openMultiPicker")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 G = tw1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", tw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(tw1Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.openPicker")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 H = tw1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                vw1 vw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", vw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(vw1Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.openTabBar")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 C = vw1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                sw1 sw1Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof sw1)) {
                    sw1Var = (sw1) obj;
                } else {
                    sw1Var = new sw1(this.mSwanApiContext);
                    this.mApis.put("-1750613704", sw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(sw1Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.pageScrollTo")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = sw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                rw1 rw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", rw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(rw1Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarColor")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 z = rw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                rw1 rw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", rw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(rw1Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarTitle")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = rw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                vw1 vw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", vw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(vw1Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.setTabBarItem")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 D = vw1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", tw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(tw1Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.showDatePickerView")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 L = tw1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                xw1 xw1Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof xw1)) {
                    xw1Var = (xw1) obj;
                } else {
                    xw1Var = new xw1(this.mSwanApiContext);
                    this.mApis.put("1172469410", xw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(xw1Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.showHalfScreenWebview")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 K = xw1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                pw1 pw1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof pw1)) {
                    pw1Var = (pw1) obj;
                } else {
                    pw1Var = new pw1(this.mSwanApiContext);
                    this.mApis.put("5236036", pw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(pw1Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.showLoading")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = pw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                qw1 qw1Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof qw1)) {
                    qw1Var = (qw1) obj;
                } else {
                    qw1Var = new qw1(this.mSwanApiContext);
                    this.mApis.put("1913747800", qw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(qw1Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.showModal")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = qw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                rw1 rw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", rw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(rw1Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.showNavigationBarLoading")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 B = rw1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                ww1 ww1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof ww1)) {
                    ww1Var = (ww1) obj;
                } else {
                    ww1Var = new ww1(this.mSwanApiContext);
                    this.mApis.put("1159492510", ww1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ww1Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.showToast")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 Q = ww1Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                uw1 uw1Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof uw1)) {
                    uw1Var = (uw1) obj;
                } else {
                    uw1Var = new uw1(this.mSwanApiContext);
                    this.mApis.put("1165118609", uw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(uw1Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.stopPullDownRefresh")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = uw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", tw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(tw1Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.updateMultiPicker")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 M = tw1Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                pw1 pw1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof pw1)) {
                    pw1Var = (pw1) obj;
                } else {
                    pw1Var = new pw1(this.mSwanApiContext);
                    this.mApis.put("5236036", pw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(pw1Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.hideLoading")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = pw1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hideToast() {
                ww1 ww1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof ww1)) {
                    ww1Var = (ww1) obj;
                } else {
                    ww1Var = new ww1(this.mSwanApiContext);
                    this.mApis.put("1159492510", ww1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ww1Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.hideToast")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 K = ww1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                yw1 yw1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof yw1)) {
                    yw1Var = (yw1) obj;
                } else {
                    yw1Var = new yw1(this.mSwanApiContext);
                    this.mApis.put("-137346255", yw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(yw1Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Keyboard.startKeyboardHeightChange")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 C = yw1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                yw1 yw1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof yw1)) {
                    yw1Var = (yw1) obj;
                } else {
                    yw1Var = new yw1(this.mSwanApiContext);
                    this.mApis.put("-137346255", yw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(yw1Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Keyboard.stopKeyboardHeightChange")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 D = yw1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naLocationService", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                zw1 zw1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof zw1)) {
                    zw1Var = (zw1) obj;
                } else {
                    zw1Var = new zw1(this.mSwanApiContext);
                    this.mApis.put("-397373095", zw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(zw1Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "LocationService.getLocation")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = zw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                zw1 zw1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof zw1)) {
                    zw1Var = (zw1) obj;
                } else {
                    zw1Var = new zw1(this.mSwanApiContext);
                    this.mApis.put("-397373095", zw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(zw1Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "LocationService.startLocationUpdate")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = zw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                zw1 zw1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof zw1)) {
                    zw1Var = (zw1) obj;
                } else {
                    zw1Var = new zw1(this.mSwanApiContext);
                    this.mApis.put("-397373095", zw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(zw1Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "LocationService.stopLocationUpdate")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 B = zw1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naMenu", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                qy1 qy1Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof qy1)) {
                    qy1Var = (qy1) obj;
                } else {
                    qy1Var = new qy1(this.mSwanApiContext);
                    this.mApis.put("538070032", qy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(qy1Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = qy1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naNetwork", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                cx1 cx1Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof cx1)) {
                    cx1Var = (cx1) obj;
                } else {
                    cx1Var = new cx1(this.mSwanApiContext);
                    this.mApis.put("-1076509454", cx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(cx1Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Network.callService")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = cx1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                jx1 jx1Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof jx1)) {
                    jx1Var = (jx1) obj;
                } else {
                    jx1Var = new jx1(this.mSwanApiContext);
                    this.mApis.put("968563034", jx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(jx1Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Network.cancelRequest")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 D = jx1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                ix1 ix1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof ix1)) {
                    ix1Var = (ix1) obj;
                } else {
                    ix1Var = new ix1(this.mSwanApiContext);
                    this.mApis.put("453220699", ix1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ix1Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Network.networkStatusChange")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = ix1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                ix1 ix1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof ix1)) {
                    ix1Var = (ix1) obj;
                } else {
                    ix1Var = new ix1(this.mSwanApiContext);
                    this.mApis.put("453220699", ix1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ix1Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Network.getNetworkType")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = ix1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(JsObject jsObject) {
                jx1 jx1Var;
                String a;
                try {
                    tz1.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof jx1)) {
                        jx1Var = (jx1) obj;
                    } else {
                        jx1Var = new jx1(this.mSwanApiContext);
                        this.mApis.put("968563034", jx1Var);
                    }
                    Pair<Boolean, uz1> a2 = wz1.a(jx1Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((uz1) a2.second).a();
                    } else if (ca2.a(this.mSwanApiContext.f(), "Network.request")) {
                        a = new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<uz1, JSONObject> t = yv1.t(jsObject);
                        if (!((uz1) t.first).isSuccess()) {
                            a = ((uz1) t.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) t.second;
                            if (jSONObject == null) {
                                a = uz1.a.a();
                            } else {
                                vz1 V = jx1Var.V(jSONObject);
                                if (V == null) {
                                    a = "";
                                } else {
                                    a = V.a();
                                }
                            }
                        }
                    }
                    return a;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } finally {
                        tz1.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                s03 s03Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof s03)) {
                    s03Var = (s03) obj;
                } else {
                    s03Var = new s03(this.mSwanApiContext);
                    this.mApis.put("-336396851", s03Var);
                }
                Pair<Boolean, uz1> a = wz1.a(s03Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Payment.chooseCoupon")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = s03Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                s03 s03Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof s03)) {
                    s03Var = (s03) obj;
                } else {
                    s03Var = new s03(this.mSwanApiContext);
                    this.mApis.put("-336396851", s03Var);
                }
                Pair<Boolean, uz1> a = wz1.a(s03Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Payment.getPaymentInfo")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = s03Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                i03 i03Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof i03)) {
                    i03Var = (i03) obj;
                } else {
                    i03Var = new i03(this.mSwanApiContext);
                    this.mApis.put("1854689529", i03Var);
                }
                Pair<Boolean, uz1> a = wz1.a(i03Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Payment.requestThirdPayment")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = i03Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                s03 s03Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof s03)) {
                    s03Var = (s03) obj;
                } else {
                    s03Var = new s03(this.mSwanApiContext);
                    this.mApis.put("-336396851", s03Var);
                }
                Pair<Boolean, uz1> a = wz1.a(s03Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Payment.setPaymentInfo")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 z = s03Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPlugin", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                d33 d33Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof d33)) {
                    d33Var = (d33) obj;
                } else {
                    d33Var = new d33(this.mSwanApiContext);
                    this.mApis.put("-254510461", d33Var);
                }
                Pair<Boolean, uz1> a = wz1.a(d33Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Plugin.invokePluginChooseAddress")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = d33Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                d33 d33Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof d33)) {
                    d33Var = (d33) obj;
                } else {
                    d33Var = new d33(this.mSwanApiContext);
                    this.mApis.put("-254510461", d33Var);
                }
                Pair<Boolean, uz1> a = wz1.a(d33Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 z = d33Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                d33 d33Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof d33)) {
                    d33Var = (d33) obj;
                } else {
                    d33Var = new d33(this.mSwanApiContext);
                    this.mApis.put("-254510461", d33Var);
                }
                Pair<Boolean, uz1> a = wz1.a(d33Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Plugin.invokePluginPayment")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = d33Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                wb2 wb2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof wb2)) {
                    wb2Var = (wb2) obj;
                } else {
                    wb2Var = new wb2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", wb2Var);
                }
                Pair<Boolean, uz1> a = wz1.a(wb2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Prefetch.prefetchResources")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = wb2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPreload", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                oa2 oa2Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof oa2)) {
                    oa2Var = (oa2) obj;
                } else {
                    oa2Var = new oa2(this.mSwanApiContext);
                    this.mApis.put("423661539", oa2Var);
                }
                Pair<Boolean, uz1> a = wz1.a(oa2Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Preload.preloadStatus")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = oa2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                yj3 yj3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof yj3)) {
                    yj3Var = (yj3) obj;
                } else {
                    yj3Var = new yj3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", yj3Var);
                }
                Pair<Boolean, uz1> a = wz1.a(yj3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "PrivateFile.uploadFileToBos")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 C = yj3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naRouter", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                nx1 nx1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof nx1)) {
                    nx1Var = (nx1) obj;
                } else {
                    nx1Var = new nx1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", nx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(nx1Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Router.hideModalPage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = nx1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                nx1 nx1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof nx1)) {
                    nx1Var = (nx1) obj;
                } else {
                    nx1Var = new nx1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", nx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(nx1Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Router.navigateBack")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 B = nx1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                ox1 ox1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof ox1)) {
                    ox1Var = (ox1) obj;
                } else {
                    ox1Var = new ox1(this.mSwanApiContext);
                    this.mApis.put("1968522584", ox1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ox1Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Router.navigateTo")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 H = ox1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                qx1 qx1Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("1317280190", qx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(qx1Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Router.reLaunch")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = qx1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                rx1 rx1Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof rx1)) {
                    rx1Var = (rx1) obj;
                } else {
                    rx1Var = new rx1(this.mSwanApiContext);
                    this.mApis.put("-420075743", rx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(rx1Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Router.reLoadErrorPage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = rx1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                px1 px1Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof px1)) {
                    px1Var = (px1) obj;
                } else {
                    px1Var = new px1(this.mSwanApiContext);
                    this.mApis.put("1792515533", px1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(px1Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Router.redirectTo")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 D = px1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                ox1 ox1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof ox1)) {
                    ox1Var = (ox1) obj;
                } else {
                    ox1Var = new ox1(this.mSwanApiContext);
                    this.mApis.put("1968522584", ox1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ox1Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Router.showModalPage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 J = ox1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naSetting", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                ux1 ux1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("-594895721", ux1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ux1Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Setting.getAppInfoSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 F = ux1Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                ux1 ux1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("-594895721", ux1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ux1Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Setting.getSlaveIdSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 H = ux1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                tx1 tx1Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof tx1)) {
                    tx1Var = (tx1) obj;
                } else {
                    tx1Var = new tx1(this.mSwanApiContext);
                    this.mApis.put("450273045", tx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(tx1Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Setting.isAllowedAdOpenAppSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = tx1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                ux1 ux1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("-594895721", ux1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ux1Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Setting.getSetting")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 G = ux1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                ux1 ux1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("-594895721", ux1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ux1Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Setting.getSwanId")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 I = ux1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                ux1 ux1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("-594895721", ux1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ux1Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Setting.getUserInfo")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 J = ux1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                se3 se3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof se3)) {
                    se3Var = (se3) obj;
                } else {
                    se3Var = new se3(this.mSwanApiContext);
                    this.mApis.put("712777136", se3Var);
                }
                Pair<Boolean, uz1> a = wz1.a(se3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = se3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naStorage", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                xx1 xx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof xx1)) {
                    xx1Var = (xx1) obj;
                } else {
                    xx1Var = new xx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", xx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(xx1Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = xx1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                xx1 xx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof xx1)) {
                    xx1Var = (xx1) obj;
                } else {
                    xx1Var = new xx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", xx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(xx1Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorageSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 C = xx1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                wx1 wx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("130910081", wx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(wx1Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.clearStorage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = wx1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                wx1 wx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("130910081", wx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(wx1Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.clearStorageSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 C = wx1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                xx1 xx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof xx1)) {
                    xx1Var = (xx1) obj;
                } else {
                    xx1Var = new xx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", xx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(xx1Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfo")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 G = xx1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                xx1 xx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof xx1)) {
                    xx1Var = (xx1) obj;
                } else {
                    xx1Var = new xx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", xx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(xx1Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfoSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 J = xx1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                wx1 wx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("130910081", wx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(wx1Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.getStorageInfo")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 G = wx1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                wx1 wx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("130910081", wx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(wx1Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.getStorageInfoSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 J = wx1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                xx1 xx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof xx1)) {
                    xx1Var = (xx1) obj;
                } else {
                    xx1Var = new xx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", xx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(xx1Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 D = xx1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                xx1 xx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof xx1)) {
                    xx1Var = (xx1) obj;
                } else {
                    xx1Var = new xx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", xx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(xx1Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 K = xx1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("130910081", wx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(wx1Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.getStorage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 D = wx1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("130910081", wx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(wx1Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.getStorageInfoAsync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 H = wx1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("130910081", wx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(wx1Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.getStorageSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 K = wx1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                xx1 xx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof xx1)) {
                    xx1Var = (xx1) obj;
                } else {
                    xx1Var = new xx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", xx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(xx1Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 R = xx1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                xx1 xx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof xx1)) {
                    xx1Var = (xx1) obj;
                } else {
                    xx1Var = new xx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", xx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(xx1Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorageSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 T = xx1Var.T(str);
                if (T == null) {
                    return "";
                }
                return T.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("130910081", wx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(wx1Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.removeStorage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 R = wx1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("130910081", wx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(wx1Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.removeStorageSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 T = wx1Var.T(str);
                if (T == null) {
                    return "";
                }
                return T.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                xx1 xx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof xx1)) {
                    xx1Var = (xx1) obj;
                } else {
                    xx1Var = new xx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", xx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(xx1Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.setGlobalStorage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 U = xx1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                xx1 xx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof xx1)) {
                    xx1Var = (xx1) obj;
                } else {
                    xx1Var = new xx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", xx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(xx1Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.setGlobalStorageSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 W = xx1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("130910081", wx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(wx1Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.setStorage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 U = wx1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("130910081", wx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(wx1Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.setStorageSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 W = wx1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }
        });
        hashMap.put("_naSubscription", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                zx1 zx1Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof zx1)) {
                    zx1Var = (zx1) obj;
                } else {
                    zx1Var = new zx1(this.mSwanApiContext);
                    this.mApis.put("823117982", zx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(zx1Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Subscription.requestSubscribeFormId")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 E = zx1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                ay1 ay1Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof ay1)) {
                    ay1Var = (ay1) obj;
                } else {
                    ay1Var = new ay1(this.mSwanApiContext);
                    this.mApis.put("-947445811", ay1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ay1Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Subscription.subscribeService")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 F = ay1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }
        });
        hashMap.put("_naSystem", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                hy1 hy1Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof hy1)) {
                    hy1Var = (hy1) obj;
                } else {
                    hy1Var = new hy1(this.mSwanApiContext);
                    this.mApis.put("1936205521", hy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(hy1Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.exitFullScreen")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = hy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                gy1 gy1Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof gy1)) {
                    gy1Var = (gy1) obj;
                } else {
                    gy1Var = new gy1(this.mSwanApiContext);
                    this.mApis.put("1694151270", gy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(gy1Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.getDeviceInfo")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = gy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                iy1 iy1Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof iy1)) {
                    iy1Var = (iy1) obj;
                } else {
                    iy1Var = new iy1(this.mSwanApiContext);
                    this.mApis.put("-1321681619", iy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(iy1Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.getDeviceProfile")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = iy1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                jy1 jy1Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof jy1)) {
                    jy1Var = (jy1) obj;
                } else {
                    jy1Var = new jy1(this.mSwanApiContext);
                    this.mApis.put("-1569246082", jy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(jy1Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.makePhoneCall")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = jy1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                ly1 ly1Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof ly1)) {
                    ly1Var = (ly1) obj;
                } else {
                    ly1Var = new ly1(this.mSwanApiContext);
                    this.mApis.put("1099851202", ly1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ly1Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.openSMSPanel")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = ly1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                ky1 ky1Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof ky1)) {
                    ky1Var = (ky1) obj;
                } else {
                    ky1Var = new ky1(this.mSwanApiContext);
                    this.mApis.put("-1707203360", ky1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ky1Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.requestFullScreen")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 F = ky1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                ey1 ey1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof ey1)) {
                    ey1Var = (ey1) obj;
                } else {
                    ey1Var = new ey1(this.mSwanApiContext);
                    this.mApis.put("-518757484", ey1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ey1Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.setClipboardData")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = ey1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                ox2 ox2Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof ox2)) {
                    ox2Var = (ox2) obj;
                } else {
                    ox2Var = new ox2(this.mSwanApiContext);
                    this.mApis.put("1161486049", ox2Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ox2Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.setErrorPageType")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = ox2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                oy1 oy1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof oy1)) {
                    oy1Var = (oy1) obj;
                } else {
                    oy1Var = new oy1(this.mSwanApiContext);
                    this.mApis.put("447234992", oy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(oy1Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.setMediaVolume")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 z = oy1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                cy1 cy1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof cy1)) {
                    cy1Var = (cy1) obj;
                } else {
                    cy1Var = new cy1(this.mSwanApiContext);
                    this.mApis.put("1372680763", cy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(cy1Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.startAccelerometer")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = cy1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                fy1 fy1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof fy1)) {
                    fy1Var = (fy1) obj;
                } else {
                    fy1Var = new fy1(this.mSwanApiContext);
                    this.mApis.put("1689255576", fy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(fy1Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.startCompass")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = fy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                dy1 dy1Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof dy1)) {
                    dy1Var = (dy1) obj;
                } else {
                    dy1Var = new dy1(this.mSwanApiContext);
                    this.mApis.put("99997465", dy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(dy1Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.getBrightness")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = dy1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                ey1 ey1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof ey1)) {
                    ey1Var = (ey1) obj;
                } else {
                    ey1Var = new ey1(this.mSwanApiContext);
                    this.mApis.put("-518757484", ey1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ey1Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.getClipboardData")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = ey1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                oy1 oy1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof oy1)) {
                    oy1Var = (oy1) obj;
                } else {
                    oy1Var = new oy1(this.mSwanApiContext);
                    this.mApis.put("447234992", oy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(oy1Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.getMediaVolume")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = oy1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                cy1 cy1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof cy1)) {
                    cy1Var = (cy1) obj;
                } else {
                    cy1Var = new cy1(this.mSwanApiContext);
                    this.mApis.put("1372680763", cy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(cy1Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.stopAccelerometer")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 B = cy1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                fy1 fy1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof fy1)) {
                    fy1Var = (fy1) obj;
                } else {
                    fy1Var = new fy1(this.mSwanApiContext);
                    this.mApis.put("1689255576", fy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(fy1Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.stopCompass")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 z = fy1Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naUtils", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                zy1 zy1Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof zy1)) {
                    zy1Var = (zy1) obj;
                } else {
                    zy1Var = new zy1(this.mSwanApiContext);
                    this.mApis.put("201194468", zy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(zy1Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.addToDesktop")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 B = zy1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                vy1 vy1Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof vy1)) {
                    vy1Var = (vy1) obj;
                } else {
                    vy1Var = new vy1(this.mSwanApiContext);
                    this.mApis.put("-1412306947", vy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(vy1Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.calcMD5")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = vy1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                wy1 wy1Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof wy1)) {
                    wy1Var = (wy1) obj;
                } else {
                    wy1Var = new wy1(this.mSwanApiContext);
                    this.mApis.put("1626415364", wy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(wy1Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.checkAppInstalled")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = wy1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                yy1 yy1Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof yy1)) {
                    yy1Var = (yy1) obj;
                } else {
                    yy1Var = new yy1(this.mSwanApiContext);
                    this.mApis.put("-836768778", yy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(yy1Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfo")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = yy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                az1 az1Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof az1)) {
                    az1Var = (az1) obj;
                } else {
                    az1Var = new az1(this.mSwanApiContext);
                    this.mApis.put("-810858308", az1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(az1Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.getPerformanceLevel")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = az1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                ez1 ez1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof ez1)) {
                    ez1Var = (ez1) obj;
                } else {
                    ez1Var = new ez1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", ez1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ez1Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.getSystemInfoAsync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 I = ez1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                bz1 bz1Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof bz1)) {
                    bz1Var = (bz1) obj;
                } else {
                    bz1Var = new bz1(this.mSwanApiContext);
                    this.mApis.put("-2097727681", bz1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(bz1Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.handleException")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = bz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                xy1 xy1Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof xy1)) {
                    xy1Var = (xy1) obj;
                } else {
                    xy1Var = new xy1(this.mSwanApiContext);
                    this.mApis.put("2084449317", xy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(xy1Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.hasCloseHandler")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = xy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                ac3 ac3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof ac3)) {
                    ac3Var = (ac3) obj;
                } else {
                    ac3Var = new ac3(this.mSwanApiContext);
                    this.mApis.put("1031678042", ac3Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ac3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.hideCaptureScreenShareDialog")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = ac3Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                cz1 cz1Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof cz1)) {
                    cz1Var = (cz1) obj;
                } else {
                    cz1Var = new cz1(this.mSwanApiContext);
                    this.mApis.put("1751900130", cz1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(cz1Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.logToFile")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = cz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                bb3 bb3Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof bb3)) {
                    bb3Var = (bb3) obj;
                } else {
                    bb3Var = new bb3(this.mSwanApiContext);
                    this.mApis.put("1748196865", bb3Var);
                }
                Pair<Boolean, uz1> a = wz1.a(bb3Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.preloadPackage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = bb3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                dz1 dz1Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof dz1)) {
                    dz1Var = (dz1) obj;
                } else {
                    dz1Var = new dz1(this.mSwanApiContext);
                    this.mApis.put("589529211", dz1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(dz1Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.previewImage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 B = dz1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                gz1 gz1Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof gz1)) {
                    gz1Var = (gz1) obj;
                } else {
                    gz1Var = new gz1(this.mSwanApiContext);
                    this.mApis.put("-577481801", gz1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(gz1Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.ubcFlowJar")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 I = gz1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                ez1 ez1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof ez1)) {
                    ez1Var = (ez1) obj;
                } else {
                    ez1Var = new ez1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", ez1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ez1Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfoSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 E = ez1Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                ez1 ez1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof ez1)) {
                    ez1Var = (ez1) obj;
                } else {
                    ez1Var = new ez1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", ez1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ez1Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.getSystemInfo")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 H = ez1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                ez1 ez1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof ez1)) {
                    ez1Var = (ez1) obj;
                } else {
                    ez1Var = new ez1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", ez1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ez1Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.getSystemInfoSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 J = ez1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naWifi", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                li3 li3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof li3)) {
                    li3Var = (li3) obj;
                } else {
                    li3Var = new li3(this.mSwanApiContext);
                    this.mApis.put("1879401452", li3Var);
                }
                Pair<Boolean, uz1> a = wz1.a(li3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Wifi.connectWifi")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = li3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                li3 li3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof li3)) {
                    li3Var = (li3) obj;
                } else {
                    li3Var = new li3(this.mSwanApiContext);
                    this.mApis.put("1879401452", li3Var);
                }
                Pair<Boolean, uz1> a = wz1.a(li3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Wifi.getConnectedWifi")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 B = li3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                li3 li3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof li3)) {
                    li3Var = (li3) obj;
                } else {
                    li3Var = new li3(this.mSwanApiContext);
                    this.mApis.put("1879401452", li3Var);
                }
                Pair<Boolean, uz1> a = wz1.a(li3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Wifi.getWifiList")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 C = li3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                li3 li3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof li3)) {
                    li3Var = (li3) obj;
                } else {
                    li3Var = new li3(this.mSwanApiContext);
                    this.mApis.put("1879401452", li3Var);
                }
                Pair<Boolean, uz1> a = wz1.a(li3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Wifi.startWifi")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 G = li3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                li3 li3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof li3)) {
                    li3Var = (li3) obj;
                } else {
                    li3Var = new li3(this.mSwanApiContext);
                    this.mApis.put("1879401452", li3Var);
                }
                Pair<Boolean, uz1> a = wz1.a(li3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Wifi.stopWifi")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 H = li3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final wv1 wv1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                cw1 cw1Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof cw1)) {
                    cw1Var = (cw1) obj;
                } else {
                    cw1Var = new cw1(this.mSwanApiContext);
                    this.mApis.put("1930258908", cw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(cw1Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Account.checkSession")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = cw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                dw1 dw1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof dw1)) {
                    dw1Var = (dw1) obj;
                } else {
                    dw1Var = new dw1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", dw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(dw1Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Account.getLoginCode")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 C = dw1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                ew1 ew1Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof ew1)) {
                    ew1Var = (ew1) obj;
                } else {
                    ew1Var = new ew1(this.mSwanApiContext);
                    this.mApis.put("1754780133", ew1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ew1Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Account.getOpenId")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = ew1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                lv1 lv1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof lv1)) {
                    lv1Var = (lv1) obj;
                } else {
                    lv1Var = new lv1(this.mSwanApiContext);
                    this.mApis.put("-343998465", lv1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(lv1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Account.getUnionBDUSS")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = lv1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String login(String str) {
                dw1 dw1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof dw1)) {
                    dw1Var = (dw1) obj;
                } else {
                    dw1Var = new dw1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", dw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(dw1Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Account.login")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 I = dw1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                bw1 bw1Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof bw1)) {
                    bw1Var = (bw1) obj;
                } else {
                    bw1Var = new bw1(this.mSwanApiContext);
                    this.mApis.put("-337742792", bw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(bw1Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Account.isBaiduAccountSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = bw1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                dw1 dw1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof dw1)) {
                    dw1Var = (dw1) obj;
                } else {
                    dw1Var = new dw1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", dw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(dw1Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Account.isLoginSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 H = dw1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBasic", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                fw1 fw1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof fw1)) {
                    fw1Var = (fw1) obj;
                } else {
                    fw1Var = new fw1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", fw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(fw1Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Basic.loadSubPackage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 F = fw1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                fw1 fw1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof fw1)) {
                    fw1Var = (fw1) obj;
                } else {
                    fw1Var = new fw1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", fw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(fw1Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Basic.loadSubPackages")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 G = fw1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                mo1 mo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof mo1)) {
                    mo1Var = (mo1) obj;
                } else {
                    mo1Var = new mo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", mo1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(mo1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Bookshelf.deleteBookshelf")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 K = mo1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                mo1 mo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof mo1)) {
                    mo1Var = (mo1) obj;
                } else {
                    mo1Var = new mo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", mo1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(mo1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Bookshelf.insertBookshelf")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 P = mo1Var.P(str);
                if (P == null) {
                    return "";
                }
                return P.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                mo1 mo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof mo1)) {
                    mo1Var = (mo1) obj;
                } else {
                    mo1Var = new mo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", mo1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(mo1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Bookshelf.navigateToBookshelf")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 U = mo1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                mo1 mo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof mo1)) {
                    mo1Var = (mo1) obj;
                } else {
                    mo1Var = new mo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", mo1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(mo1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Bookshelf.queryBookshelf")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 V = mo1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                mo1 mo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof mo1)) {
                    mo1Var = (mo1) obj;
                } else {
                    mo1Var = new mo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", mo1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(mo1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Bookshelf.updateBookshelfReadTime")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 X = mo1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naCoupon", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                zv1 zv1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof zv1)) {
                    zv1Var = (zv1) obj;
                } else {
                    zv1Var = new zv1(this.mSwanApiContext);
                    this.mApis.put("-277316359", zv1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(zv1Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Coupon.getPlatformCoupons")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = zv1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                zv1 zv1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof zv1)) {
                    zv1Var = (zv1) obj;
                } else {
                    zv1Var = new zv1(this.mSwanApiContext);
                    this.mApis.put("-277316359", zv1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(zv1Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Coupon.getUserCoupons")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 z = zv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                zv1 zv1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof zv1)) {
                    zv1Var = (zv1) obj;
                } else {
                    zv1Var = new zv1(this.mSwanApiContext);
                    this.mApis.put("-277316359", zv1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(zv1Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Coupon.takeCoupons")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 C = zv1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naFavorite", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                hw1 hw1Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof hw1)) {
                    hw1Var = (hw1) obj;
                } else {
                    hw1Var = new hw1(this.mSwanApiContext);
                    this.mApis.put("-1225406515", hw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(hw1Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Favorite.getFavorStatus")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = hw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String showFavoriteGuide(String str) {
                ShowFavoriteGuideApi showFavoriteGuideApi;
                Object obj = this.mApis.get("269275578");
                if (obj != null && (obj instanceof ShowFavoriteGuideApi)) {
                    showFavoriteGuideApi = (ShowFavoriteGuideApi) obj;
                } else {
                    showFavoriteGuideApi = new ShowFavoriteGuideApi(this.mSwanApiContext);
                    this.mApis.put("269275578", showFavoriteGuideApi);
                }
                Pair<Boolean, uz1> a = wz1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Favorite.showFavoriteGuide")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 G = showFavoriteGuideApi.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naFile", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-2057135077", jw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(jw1Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "File.shareFile")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = jw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                yk2 yk2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof yk2)) {
                    yk2Var = (yk2) obj;
                } else {
                    yk2Var = new yk2(this.mSwanApiContext);
                    this.mApis.put("2077414795", yk2Var);
                }
                Pair<Boolean, uz1> a = wz1.a(yk2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = yk2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                yk2 yk2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof yk2)) {
                    yk2Var = (yk2) obj;
                } else {
                    yk2Var = new yk2(this.mSwanApiContext);
                    this.mApis.put("2077414795", yk2Var);
                }
                Pair<Boolean, uz1> a = wz1.a(yk2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessageSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = yk2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String download(String str) {
                kw1 kw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", kw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(kw1Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "HostDownloadManager.download")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = kw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                kw1 kw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", kw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(kw1Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "HostDownloadManager.openFile")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 z = kw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String query(String str) {
                kw1 kw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", kw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(kw1Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "HostDownloadManager.query")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 query = kw1Var.query(str);
                if (query == null) {
                    return "";
                }
                return query.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                kw1 kw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", kw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(kw1Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "HostDownloadManager.openDownloadCenter")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = kw1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naImage", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                mx2 mx2Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof mx2)) {
                    mx2Var = (mx2) obj;
                } else {
                    mx2Var = new mx2(this.mSwanApiContext);
                    this.mApis.put("1445003743", mx2Var);
                }
                Pair<Boolean, uz1> a = wz1.a(mx2Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Image.callImageMenu")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = mx2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                nw1 nw1Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof nw1)) {
                    nw1Var = (nw1) obj;
                } else {
                    nw1Var = new nw1(this.mSwanApiContext);
                    this.mApis.put("-1252730367", nw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(nw1Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Image.compressImage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = nw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naInteraction", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                vw1 vw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", vw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(vw1Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.closeTabBar")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = vw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                vw1 vw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", vw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(vw1Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.closeTabBarRedDot")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = vw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                rw1 rw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", rw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(rw1Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.hideNavigationBarLoading")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = rw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", tw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(tw1Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.openMultiPicker")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 G = tw1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", tw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(tw1Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.openPicker")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 H = tw1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                vw1 vw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", vw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(vw1Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.openTabBar")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 C = vw1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                sw1 sw1Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof sw1)) {
                    sw1Var = (sw1) obj;
                } else {
                    sw1Var = new sw1(this.mSwanApiContext);
                    this.mApis.put("-1750613704", sw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(sw1Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.pageScrollTo")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = sw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                rw1 rw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", rw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(rw1Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarColor")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 z = rw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                rw1 rw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", rw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(rw1Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarTitle")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = rw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                vw1 vw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", vw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(vw1Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.setTabBarItem")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 D = vw1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", tw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(tw1Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.showDatePickerView")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 L = tw1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                xw1 xw1Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof xw1)) {
                    xw1Var = (xw1) obj;
                } else {
                    xw1Var = new xw1(this.mSwanApiContext);
                    this.mApis.put("1172469410", xw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(xw1Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.showHalfScreenWebview")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 K = xw1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                pw1 pw1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof pw1)) {
                    pw1Var = (pw1) obj;
                } else {
                    pw1Var = new pw1(this.mSwanApiContext);
                    this.mApis.put("5236036", pw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(pw1Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.showLoading")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = pw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                qw1 qw1Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof qw1)) {
                    qw1Var = (qw1) obj;
                } else {
                    qw1Var = new qw1(this.mSwanApiContext);
                    this.mApis.put("1913747800", qw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(qw1Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.showModal")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = qw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                rw1 rw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", rw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(rw1Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.showNavigationBarLoading")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 B = rw1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                ww1 ww1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof ww1)) {
                    ww1Var = (ww1) obj;
                } else {
                    ww1Var = new ww1(this.mSwanApiContext);
                    this.mApis.put("1159492510", ww1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ww1Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.showToast")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 Q = ww1Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                uw1 uw1Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof uw1)) {
                    uw1Var = (uw1) obj;
                } else {
                    uw1Var = new uw1(this.mSwanApiContext);
                    this.mApis.put("1165118609", uw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(uw1Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.stopPullDownRefresh")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = uw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", tw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(tw1Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.updateMultiPicker")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 M = tw1Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                pw1 pw1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof pw1)) {
                    pw1Var = (pw1) obj;
                } else {
                    pw1Var = new pw1(this.mSwanApiContext);
                    this.mApis.put("5236036", pw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(pw1Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.hideLoading")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = pw1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hideToast() {
                ww1 ww1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof ww1)) {
                    ww1Var = (ww1) obj;
                } else {
                    ww1Var = new ww1(this.mSwanApiContext);
                    this.mApis.put("1159492510", ww1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ww1Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Interaction.hideToast")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 K = ww1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                yw1 yw1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof yw1)) {
                    yw1Var = (yw1) obj;
                } else {
                    yw1Var = new yw1(this.mSwanApiContext);
                    this.mApis.put("-137346255", yw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(yw1Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Keyboard.startKeyboardHeightChange")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 C = yw1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                yw1 yw1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof yw1)) {
                    yw1Var = (yw1) obj;
                } else {
                    yw1Var = new yw1(this.mSwanApiContext);
                    this.mApis.put("-137346255", yw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(yw1Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Keyboard.stopKeyboardHeightChange")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 D = yw1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naLocationService", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                zw1 zw1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof zw1)) {
                    zw1Var = (zw1) obj;
                } else {
                    zw1Var = new zw1(this.mSwanApiContext);
                    this.mApis.put("-397373095", zw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(zw1Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "LocationService.getLocation")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = zw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                zw1 zw1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof zw1)) {
                    zw1Var = (zw1) obj;
                } else {
                    zw1Var = new zw1(this.mSwanApiContext);
                    this.mApis.put("-397373095", zw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(zw1Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "LocationService.startLocationUpdate")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = zw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                zw1 zw1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof zw1)) {
                    zw1Var = (zw1) obj;
                } else {
                    zw1Var = new zw1(this.mSwanApiContext);
                    this.mApis.put("-397373095", zw1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(zw1Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "LocationService.stopLocationUpdate")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 B = zw1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naMenu", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                qy1 qy1Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof qy1)) {
                    qy1Var = (qy1) obj;
                } else {
                    qy1Var = new qy1(this.mSwanApiContext);
                    this.mApis.put("538070032", qy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(qy1Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = qy1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naNetwork", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                cx1 cx1Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof cx1)) {
                    cx1Var = (cx1) obj;
                } else {
                    cx1Var = new cx1(this.mSwanApiContext);
                    this.mApis.put("-1076509454", cx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(cx1Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Network.callService")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = cx1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                jx1 jx1Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof jx1)) {
                    jx1Var = (jx1) obj;
                } else {
                    jx1Var = new jx1(this.mSwanApiContext);
                    this.mApis.put("968563034", jx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(jx1Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Network.cancelRequest")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 D = jx1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                ix1 ix1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof ix1)) {
                    ix1Var = (ix1) obj;
                } else {
                    ix1Var = new ix1(this.mSwanApiContext);
                    this.mApis.put("453220699", ix1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ix1Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Network.networkStatusChange")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = ix1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                ix1 ix1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof ix1)) {
                    ix1Var = (ix1) obj;
                } else {
                    ix1Var = new ix1(this.mSwanApiContext);
                    this.mApis.put("453220699", ix1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ix1Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Network.getNetworkType")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = ix1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(String str) {
                jx1 jx1Var;
                String a;
                try {
                    tz1.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof jx1)) {
                        jx1Var = (jx1) obj;
                    } else {
                        jx1Var = new jx1(this.mSwanApiContext);
                        this.mApis.put("968563034", jx1Var);
                    }
                    Pair<Boolean, uz1> a2 = wz1.a(jx1Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((uz1) a2.second).a();
                    } else if (ca2.a(this.mSwanApiContext.f(), "Network.request")) {
                        a = new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<uz1, JSONObject> u = yv1.u(str);
                        if (!((uz1) u.first).isSuccess()) {
                            a = ((uz1) u.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) u.second;
                            if (jSONObject == null) {
                                a = uz1.a.a();
                            } else {
                                vz1 V = jx1Var.V(jSONObject);
                                if (V == null) {
                                    a = "";
                                } else {
                                    a = V.a();
                                }
                            }
                        }
                    }
                    return a;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } finally {
                        tz1.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                s03 s03Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof s03)) {
                    s03Var = (s03) obj;
                } else {
                    s03Var = new s03(this.mSwanApiContext);
                    this.mApis.put("-336396851", s03Var);
                }
                Pair<Boolean, uz1> a = wz1.a(s03Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Payment.chooseCoupon")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = s03Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                s03 s03Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof s03)) {
                    s03Var = (s03) obj;
                } else {
                    s03Var = new s03(this.mSwanApiContext);
                    this.mApis.put("-336396851", s03Var);
                }
                Pair<Boolean, uz1> a = wz1.a(s03Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Payment.getPaymentInfo")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = s03Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                i03 i03Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof i03)) {
                    i03Var = (i03) obj;
                } else {
                    i03Var = new i03(this.mSwanApiContext);
                    this.mApis.put("1854689529", i03Var);
                }
                Pair<Boolean, uz1> a = wz1.a(i03Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Payment.requestThirdPayment")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = i03Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                s03 s03Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof s03)) {
                    s03Var = (s03) obj;
                } else {
                    s03Var = new s03(this.mSwanApiContext);
                    this.mApis.put("-336396851", s03Var);
                }
                Pair<Boolean, uz1> a = wz1.a(s03Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Payment.setPaymentInfo")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 z = s03Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPlugin", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                d33 d33Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof d33)) {
                    d33Var = (d33) obj;
                } else {
                    d33Var = new d33(this.mSwanApiContext);
                    this.mApis.put("-254510461", d33Var);
                }
                Pair<Boolean, uz1> a = wz1.a(d33Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Plugin.invokePluginChooseAddress")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = d33Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                d33 d33Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof d33)) {
                    d33Var = (d33) obj;
                } else {
                    d33Var = new d33(this.mSwanApiContext);
                    this.mApis.put("-254510461", d33Var);
                }
                Pair<Boolean, uz1> a = wz1.a(d33Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 z = d33Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                d33 d33Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof d33)) {
                    d33Var = (d33) obj;
                } else {
                    d33Var = new d33(this.mSwanApiContext);
                    this.mApis.put("-254510461", d33Var);
                }
                Pair<Boolean, uz1> a = wz1.a(d33Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Plugin.invokePluginPayment")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = d33Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                wb2 wb2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof wb2)) {
                    wb2Var = (wb2) obj;
                } else {
                    wb2Var = new wb2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", wb2Var);
                }
                Pair<Boolean, uz1> a = wz1.a(wb2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Prefetch.prefetchResources")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = wb2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPreload", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                oa2 oa2Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof oa2)) {
                    oa2Var = (oa2) obj;
                } else {
                    oa2Var = new oa2(this.mSwanApiContext);
                    this.mApis.put("423661539", oa2Var);
                }
                Pair<Boolean, uz1> a = wz1.a(oa2Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Preload.preloadStatus")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = oa2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                yj3 yj3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof yj3)) {
                    yj3Var = (yj3) obj;
                } else {
                    yj3Var = new yj3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", yj3Var);
                }
                Pair<Boolean, uz1> a = wz1.a(yj3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "PrivateFile.uploadFileToBos")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 C = yj3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naRouter", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                nx1 nx1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof nx1)) {
                    nx1Var = (nx1) obj;
                } else {
                    nx1Var = new nx1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", nx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(nx1Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Router.hideModalPage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = nx1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                nx1 nx1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof nx1)) {
                    nx1Var = (nx1) obj;
                } else {
                    nx1Var = new nx1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", nx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(nx1Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Router.navigateBack")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 B = nx1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                ox1 ox1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof ox1)) {
                    ox1Var = (ox1) obj;
                } else {
                    ox1Var = new ox1(this.mSwanApiContext);
                    this.mApis.put("1968522584", ox1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ox1Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Router.navigateTo")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 H = ox1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                qx1 qx1Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("1317280190", qx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(qx1Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Router.reLaunch")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = qx1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                rx1 rx1Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof rx1)) {
                    rx1Var = (rx1) obj;
                } else {
                    rx1Var = new rx1(this.mSwanApiContext);
                    this.mApis.put("-420075743", rx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(rx1Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Router.reLoadErrorPage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = rx1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                px1 px1Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof px1)) {
                    px1Var = (px1) obj;
                } else {
                    px1Var = new px1(this.mSwanApiContext);
                    this.mApis.put("1792515533", px1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(px1Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Router.redirectTo")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 D = px1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                ox1 ox1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof ox1)) {
                    ox1Var = (ox1) obj;
                } else {
                    ox1Var = new ox1(this.mSwanApiContext);
                    this.mApis.put("1968522584", ox1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ox1Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Router.showModalPage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 J = ox1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naSetting", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                ux1 ux1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("-594895721", ux1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ux1Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Setting.getAppInfoSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 F = ux1Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                ux1 ux1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("-594895721", ux1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ux1Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Setting.getSlaveIdSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 H = ux1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                tx1 tx1Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof tx1)) {
                    tx1Var = (tx1) obj;
                } else {
                    tx1Var = new tx1(this.mSwanApiContext);
                    this.mApis.put("450273045", tx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(tx1Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Setting.isAllowedAdOpenAppSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = tx1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                ux1 ux1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("-594895721", ux1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ux1Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Setting.getSetting")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 G = ux1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                ux1 ux1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("-594895721", ux1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ux1Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Setting.getSwanId")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 I = ux1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                ux1 ux1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("-594895721", ux1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ux1Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Setting.getUserInfo")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 J = ux1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                se3 se3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof se3)) {
                    se3Var = (se3) obj;
                } else {
                    se3Var = new se3(this.mSwanApiContext);
                    this.mApis.put("712777136", se3Var);
                }
                Pair<Boolean, uz1> a = wz1.a(se3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = se3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naStorage", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                xx1 xx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof xx1)) {
                    xx1Var = (xx1) obj;
                } else {
                    xx1Var = new xx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", xx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(xx1Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = xx1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                xx1 xx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof xx1)) {
                    xx1Var = (xx1) obj;
                } else {
                    xx1Var = new xx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", xx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(xx1Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorageSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 C = xx1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                wx1 wx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("130910081", wx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(wx1Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.clearStorage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = wx1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                wx1 wx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("130910081", wx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(wx1Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.clearStorageSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 C = wx1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                xx1 xx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof xx1)) {
                    xx1Var = (xx1) obj;
                } else {
                    xx1Var = new xx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", xx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(xx1Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfo")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 G = xx1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                xx1 xx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof xx1)) {
                    xx1Var = (xx1) obj;
                } else {
                    xx1Var = new xx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", xx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(xx1Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfoSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 J = xx1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                wx1 wx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("130910081", wx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(wx1Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.getStorageInfo")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 G = wx1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                wx1 wx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("130910081", wx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(wx1Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.getStorageInfoSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 J = wx1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                xx1 xx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof xx1)) {
                    xx1Var = (xx1) obj;
                } else {
                    xx1Var = new xx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", xx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(xx1Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 D = xx1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                xx1 xx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof xx1)) {
                    xx1Var = (xx1) obj;
                } else {
                    xx1Var = new xx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", xx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(xx1Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 K = xx1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("130910081", wx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(wx1Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.getStorage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 D = wx1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("130910081", wx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(wx1Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.getStorageInfoAsync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 H = wx1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("130910081", wx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(wx1Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.getStorageSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 K = wx1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                xx1 xx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof xx1)) {
                    xx1Var = (xx1) obj;
                } else {
                    xx1Var = new xx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", xx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(xx1Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 R = xx1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                xx1 xx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof xx1)) {
                    xx1Var = (xx1) obj;
                } else {
                    xx1Var = new xx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", xx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(xx1Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorageSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 T = xx1Var.T(str);
                if (T == null) {
                    return "";
                }
                return T.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("130910081", wx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(wx1Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.removeStorage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 R = wx1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("130910081", wx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(wx1Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.removeStorageSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 T = wx1Var.T(str);
                if (T == null) {
                    return "";
                }
                return T.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                xx1 xx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof xx1)) {
                    xx1Var = (xx1) obj;
                } else {
                    xx1Var = new xx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", xx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(xx1Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.setGlobalStorage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 U = xx1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                xx1 xx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof xx1)) {
                    xx1Var = (xx1) obj;
                } else {
                    xx1Var = new xx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", xx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(xx1Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.setGlobalStorageSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 W = xx1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("130910081", wx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(wx1Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.setStorage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 U = wx1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("130910081", wx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(wx1Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Storage.setStorageSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 W = wx1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }
        });
        hashMap.put("_naSubscription", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                zx1 zx1Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof zx1)) {
                    zx1Var = (zx1) obj;
                } else {
                    zx1Var = new zx1(this.mSwanApiContext);
                    this.mApis.put("823117982", zx1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(zx1Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Subscription.requestSubscribeFormId")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 E = zx1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                ay1 ay1Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof ay1)) {
                    ay1Var = (ay1) obj;
                } else {
                    ay1Var = new ay1(this.mSwanApiContext);
                    this.mApis.put("-947445811", ay1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ay1Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Subscription.subscribeService")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 F = ay1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }
        });
        hashMap.put("_naSystem", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                hy1 hy1Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof hy1)) {
                    hy1Var = (hy1) obj;
                } else {
                    hy1Var = new hy1(this.mSwanApiContext);
                    this.mApis.put("1936205521", hy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(hy1Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.exitFullScreen")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = hy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                gy1 gy1Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof gy1)) {
                    gy1Var = (gy1) obj;
                } else {
                    gy1Var = new gy1(this.mSwanApiContext);
                    this.mApis.put("1694151270", gy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(gy1Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.getDeviceInfo")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = gy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                iy1 iy1Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof iy1)) {
                    iy1Var = (iy1) obj;
                } else {
                    iy1Var = new iy1(this.mSwanApiContext);
                    this.mApis.put("-1321681619", iy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(iy1Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.getDeviceProfile")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = iy1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                jy1 jy1Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof jy1)) {
                    jy1Var = (jy1) obj;
                } else {
                    jy1Var = new jy1(this.mSwanApiContext);
                    this.mApis.put("-1569246082", jy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(jy1Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.makePhoneCall")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = jy1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                ly1 ly1Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof ly1)) {
                    ly1Var = (ly1) obj;
                } else {
                    ly1Var = new ly1(this.mSwanApiContext);
                    this.mApis.put("1099851202", ly1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ly1Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.openSMSPanel")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = ly1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                ky1 ky1Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof ky1)) {
                    ky1Var = (ky1) obj;
                } else {
                    ky1Var = new ky1(this.mSwanApiContext);
                    this.mApis.put("-1707203360", ky1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ky1Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.requestFullScreen")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 F = ky1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                ey1 ey1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof ey1)) {
                    ey1Var = (ey1) obj;
                } else {
                    ey1Var = new ey1(this.mSwanApiContext);
                    this.mApis.put("-518757484", ey1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ey1Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.setClipboardData")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = ey1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                ox2 ox2Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof ox2)) {
                    ox2Var = (ox2) obj;
                } else {
                    ox2Var = new ox2(this.mSwanApiContext);
                    this.mApis.put("1161486049", ox2Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ox2Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.setErrorPageType")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = ox2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                oy1 oy1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof oy1)) {
                    oy1Var = (oy1) obj;
                } else {
                    oy1Var = new oy1(this.mSwanApiContext);
                    this.mApis.put("447234992", oy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(oy1Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.setMediaVolume")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 z = oy1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                cy1 cy1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof cy1)) {
                    cy1Var = (cy1) obj;
                } else {
                    cy1Var = new cy1(this.mSwanApiContext);
                    this.mApis.put("1372680763", cy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(cy1Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.startAccelerometer")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = cy1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                fy1 fy1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof fy1)) {
                    fy1Var = (fy1) obj;
                } else {
                    fy1Var = new fy1(this.mSwanApiContext);
                    this.mApis.put("1689255576", fy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(fy1Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.startCompass")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = fy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                dy1 dy1Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof dy1)) {
                    dy1Var = (dy1) obj;
                } else {
                    dy1Var = new dy1(this.mSwanApiContext);
                    this.mApis.put("99997465", dy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(dy1Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.getBrightness")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = dy1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                ey1 ey1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof ey1)) {
                    ey1Var = (ey1) obj;
                } else {
                    ey1Var = new ey1(this.mSwanApiContext);
                    this.mApis.put("-518757484", ey1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ey1Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.getClipboardData")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = ey1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                oy1 oy1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof oy1)) {
                    oy1Var = (oy1) obj;
                } else {
                    oy1Var = new oy1(this.mSwanApiContext);
                    this.mApis.put("447234992", oy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(oy1Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.getMediaVolume")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = oy1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                cy1 cy1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof cy1)) {
                    cy1Var = (cy1) obj;
                } else {
                    cy1Var = new cy1(this.mSwanApiContext);
                    this.mApis.put("1372680763", cy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(cy1Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.stopAccelerometer")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 B = cy1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                fy1 fy1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof fy1)) {
                    fy1Var = (fy1) obj;
                } else {
                    fy1Var = new fy1(this.mSwanApiContext);
                    this.mApis.put("1689255576", fy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(fy1Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "System.stopCompass")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 z = fy1Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naUtils", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                zy1 zy1Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof zy1)) {
                    zy1Var = (zy1) obj;
                } else {
                    zy1Var = new zy1(this.mSwanApiContext);
                    this.mApis.put("201194468", zy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(zy1Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.addToDesktop")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 B = zy1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                vy1 vy1Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof vy1)) {
                    vy1Var = (vy1) obj;
                } else {
                    vy1Var = new vy1(this.mSwanApiContext);
                    this.mApis.put("-1412306947", vy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(vy1Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.calcMD5")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = vy1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                wy1 wy1Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof wy1)) {
                    wy1Var = (wy1) obj;
                } else {
                    wy1Var = new wy1(this.mSwanApiContext);
                    this.mApis.put("1626415364", wy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(wy1Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.checkAppInstalled")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = wy1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                yy1 yy1Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof yy1)) {
                    yy1Var = (yy1) obj;
                } else {
                    yy1Var = new yy1(this.mSwanApiContext);
                    this.mApis.put("-836768778", yy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(yy1Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfo")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = yy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                az1 az1Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof az1)) {
                    az1Var = (az1) obj;
                } else {
                    az1Var = new az1(this.mSwanApiContext);
                    this.mApis.put("-810858308", az1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(az1Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.getPerformanceLevel")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = az1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                ez1 ez1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof ez1)) {
                    ez1Var = (ez1) obj;
                } else {
                    ez1Var = new ez1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", ez1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ez1Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.getSystemInfoAsync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 I = ez1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                bz1 bz1Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof bz1)) {
                    bz1Var = (bz1) obj;
                } else {
                    bz1Var = new bz1(this.mSwanApiContext);
                    this.mApis.put("-2097727681", bz1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(bz1Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.handleException")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = bz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                xy1 xy1Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof xy1)) {
                    xy1Var = (xy1) obj;
                } else {
                    xy1Var = new xy1(this.mSwanApiContext);
                    this.mApis.put("2084449317", xy1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(xy1Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.hasCloseHandler")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = xy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                ac3 ac3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof ac3)) {
                    ac3Var = (ac3) obj;
                } else {
                    ac3Var = new ac3(this.mSwanApiContext);
                    this.mApis.put("1031678042", ac3Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ac3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.hideCaptureScreenShareDialog")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 x = ac3Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                cz1 cz1Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof cz1)) {
                    cz1Var = (cz1) obj;
                } else {
                    cz1Var = new cz1(this.mSwanApiContext);
                    this.mApis.put("1751900130", cz1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(cz1Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.logToFile")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 y = cz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                bb3 bb3Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof bb3)) {
                    bb3Var = (bb3) obj;
                } else {
                    bb3Var = new bb3(this.mSwanApiContext);
                    this.mApis.put("1748196865", bb3Var);
                }
                Pair<Boolean, uz1> a = wz1.a(bb3Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.preloadPackage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = bb3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                dz1 dz1Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof dz1)) {
                    dz1Var = (dz1) obj;
                } else {
                    dz1Var = new dz1(this.mSwanApiContext);
                    this.mApis.put("589529211", dz1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(dz1Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.previewImage")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 B = dz1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                gz1 gz1Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof gz1)) {
                    gz1Var = (gz1) obj;
                } else {
                    gz1Var = new gz1(this.mSwanApiContext);
                    this.mApis.put("-577481801", gz1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(gz1Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.ubcFlowJar")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 I = gz1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                ez1 ez1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof ez1)) {
                    ez1Var = (ez1) obj;
                } else {
                    ez1Var = new ez1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", ez1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ez1Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfoSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 E = ez1Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                ez1 ez1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof ez1)) {
                    ez1Var = (ez1) obj;
                } else {
                    ez1Var = new ez1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", ez1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ez1Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.getSystemInfo")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 H = ez1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                ez1 ez1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof ez1)) {
                    ez1Var = (ez1) obj;
                } else {
                    ez1Var = new ez1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", ez1Var);
                }
                Pair<Boolean, uz1> a = wz1.a(ez1Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Utils.getSystemInfoSync")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 J = ez1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naWifi", new Object(wv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wv1 mSwanApiContext;

            {
                this.mSwanApiContext = wv1Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                li3 li3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof li3)) {
                    li3Var = (li3) obj;
                } else {
                    li3Var = new li3(this.mSwanApiContext);
                    this.mApis.put("1879401452", li3Var);
                }
                Pair<Boolean, uz1> a = wz1.a(li3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Wifi.connectWifi")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 A = li3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                li3 li3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof li3)) {
                    li3Var = (li3) obj;
                } else {
                    li3Var = new li3(this.mSwanApiContext);
                    this.mApis.put("1879401452", li3Var);
                }
                Pair<Boolean, uz1> a = wz1.a(li3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Wifi.getConnectedWifi")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 B = li3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                li3 li3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof li3)) {
                    li3Var = (li3) obj;
                } else {
                    li3Var = new li3(this.mSwanApiContext);
                    this.mApis.put("1879401452", li3Var);
                }
                Pair<Boolean, uz1> a = wz1.a(li3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Wifi.getWifiList")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 C = li3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                li3 li3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof li3)) {
                    li3Var = (li3) obj;
                } else {
                    li3Var = new li3(this.mSwanApiContext);
                    this.mApis.put("1879401452", li3Var);
                }
                Pair<Boolean, uz1> a = wz1.a(li3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Wifi.startWifi")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 G = li3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                li3 li3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof li3)) {
                    li3Var = (li3) obj;
                } else {
                    li3Var = new li3(this.mSwanApiContext);
                    this.mApis.put("1879401452", li3Var);
                }
                Pair<Boolean, uz1> a = wz1.a(li3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((uz1) a.second).a();
                }
                if (ca2.a(this.mSwanApiContext.f(), "Wifi.stopWifi")) {
                    return new vz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                vz1 H = li3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }
}
