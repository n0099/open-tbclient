package com.baidu.swan.apps.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.tieba.ay1;
import com.baidu.tieba.az1;
import com.baidu.tieba.b02;
import com.baidu.tieba.by1;
import com.baidu.tieba.bz1;
import com.baidu.tieba.cy1;
import com.baidu.tieba.cz1;
import com.baidu.tieba.d23;
import com.baidu.tieba.dg3;
import com.baidu.tieba.dy1;
import com.baidu.tieba.e12;
import com.baidu.tieba.ey1;
import com.baidu.tieba.ez1;
import com.baidu.tieba.f12;
import com.baidu.tieba.fy1;
import com.baidu.tieba.fz1;
import com.baidu.tieba.g02;
import com.baidu.tieba.g12;
import com.baidu.tieba.gy1;
import com.baidu.tieba.h02;
import com.baidu.tieba.h12;
import com.baidu.tieba.hd2;
import com.baidu.tieba.hx1;
import com.baidu.tieba.hy1;
import com.baidu.tieba.hz1;
import com.baidu.tieba.i02;
import com.baidu.tieba.iy1;
import com.baidu.tieba.iz1;
import com.baidu.tieba.j02;
import com.baidu.tieba.jl3;
import com.baidu.tieba.jm2;
import com.baidu.tieba.jx1;
import com.baidu.tieba.jy1;
import com.baidu.tieba.k02;
import com.baidu.tieba.kx1;
import com.baidu.tieba.ky1;
import com.baidu.tieba.kz1;
import com.baidu.tieba.l02;
import com.baidu.tieba.ld3;
import com.baidu.tieba.lz1;
import com.baidu.tieba.m02;
import com.baidu.tieba.mc3;
import com.baidu.tieba.mx1;
import com.baidu.tieba.n02;
import com.baidu.tieba.nb2;
import com.baidu.tieba.nx1;
import com.baidu.tieba.ny1;
import com.baidu.tieba.nz1;
import com.baidu.tieba.o02;
import com.baidu.tieba.o43;
import com.baidu.tieba.ox1;
import com.baidu.tieba.oz1;
import com.baidu.tieba.p02;
import com.baidu.tieba.px1;
import com.baidu.tieba.pz1;
import com.baidu.tieba.qx1;
import com.baidu.tieba.qz1;
import com.baidu.tieba.r02;
import com.baidu.tieba.rz1;
import com.baidu.tieba.sx1;
import com.baidu.tieba.sz1;
import com.baidu.tieba.t13;
import com.baidu.tieba.ty1;
import com.baidu.tieba.tz1;
import com.baidu.tieba.ux1;
import com.baidu.tieba.uy1;
import com.baidu.tieba.uz1;
import com.baidu.tieba.vx1;
import com.baidu.tieba.vz1;
import com.baidu.tieba.wj3;
import com.baidu.tieba.ww1;
import com.baidu.tieba.wz1;
import com.baidu.tieba.xp1;
import com.baidu.tieba.xy2;
import com.baidu.tieba.yx1;
import com.baidu.tieba.yy1;
import com.baidu.tieba.zb2;
import com.baidu.tieba.zy1;
import com.baidu.tieba.zy2;
import com.baidu.tieba.zz1;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
@Keep
/* loaded from: classes4.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final hx1 hx1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                nx1 nx1Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof nx1)) {
                    nx1Var = (nx1) obj;
                } else {
                    nx1Var = new nx1(this.mSwanApiContext);
                    this.mApis.put("1930258908", nx1Var);
                }
                Pair<Boolean, f12> a = h12.a(nx1Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Account.checkSession")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = nx1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                ox1 ox1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof ox1)) {
                    ox1Var = (ox1) obj;
                } else {
                    ox1Var = new ox1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", ox1Var);
                }
                Pair<Boolean, f12> a = h12.a(ox1Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Account.getLoginCode")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 C = ox1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                px1 px1Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof px1)) {
                    px1Var = (px1) obj;
                } else {
                    px1Var = new px1(this.mSwanApiContext);
                    this.mApis.put("1754780133", px1Var);
                }
                Pair<Boolean, f12> a = h12.a(px1Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Account.getOpenId")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = px1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                ww1 ww1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof ww1)) {
                    ww1Var = (ww1) obj;
                } else {
                    ww1Var = new ww1(this.mSwanApiContext);
                    this.mApis.put("-343998465", ww1Var);
                }
                Pair<Boolean, f12> a = h12.a(ww1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Account.getUnionBDUSS")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = ww1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String login(String str) {
                ox1 ox1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof ox1)) {
                    ox1Var = (ox1) obj;
                } else {
                    ox1Var = new ox1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", ox1Var);
                }
                Pair<Boolean, f12> a = h12.a(ox1Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Account.login")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 I = ox1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                mx1 mx1Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof mx1)) {
                    mx1Var = (mx1) obj;
                } else {
                    mx1Var = new mx1(this.mSwanApiContext);
                    this.mApis.put("-337742792", mx1Var);
                }
                Pair<Boolean, f12> a = h12.a(mx1Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Account.isBaiduAccountSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = mx1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                ox1 ox1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof ox1)) {
                    ox1Var = (ox1) obj;
                } else {
                    ox1Var = new ox1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", ox1Var);
                }
                Pair<Boolean, f12> a = h12.a(ox1Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Account.isLoginSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 H = ox1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBasic", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                qx1 qx1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", qx1Var);
                }
                Pair<Boolean, f12> a = h12.a(qx1Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Basic.loadSubPackage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 F = qx1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                qx1 qx1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", qx1Var);
                }
                Pair<Boolean, f12> a = h12.a(qx1Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Basic.loadSubPackages")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 G = qx1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                xp1 xp1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof xp1)) {
                    xp1Var = (xp1) obj;
                } else {
                    xp1Var = new xp1(this.mSwanApiContext);
                    this.mApis.put("1460300387", xp1Var);
                }
                Pair<Boolean, f12> a = h12.a(xp1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Bookshelf.deleteBookshelf")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 K = xp1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                xp1 xp1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof xp1)) {
                    xp1Var = (xp1) obj;
                } else {
                    xp1Var = new xp1(this.mSwanApiContext);
                    this.mApis.put("1460300387", xp1Var);
                }
                Pair<Boolean, f12> a = h12.a(xp1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Bookshelf.insertBookshelf")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 P = xp1Var.P(str);
                if (P == null) {
                    return "";
                }
                return P.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                xp1 xp1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof xp1)) {
                    xp1Var = (xp1) obj;
                } else {
                    xp1Var = new xp1(this.mSwanApiContext);
                    this.mApis.put("1460300387", xp1Var);
                }
                Pair<Boolean, f12> a = h12.a(xp1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Bookshelf.navigateToBookshelf")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 U = xp1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                xp1 xp1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof xp1)) {
                    xp1Var = (xp1) obj;
                } else {
                    xp1Var = new xp1(this.mSwanApiContext);
                    this.mApis.put("1460300387", xp1Var);
                }
                Pair<Boolean, f12> a = h12.a(xp1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Bookshelf.queryBookshelf")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 V = xp1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                xp1 xp1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof xp1)) {
                    xp1Var = (xp1) obj;
                } else {
                    xp1Var = new xp1(this.mSwanApiContext);
                    this.mApis.put("1460300387", xp1Var);
                }
                Pair<Boolean, f12> a = h12.a(xp1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Bookshelf.updateBookshelfReadTime")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 X = xp1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naCoupon", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                kx1 kx1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof kx1)) {
                    kx1Var = (kx1) obj;
                } else {
                    kx1Var = new kx1(this.mSwanApiContext);
                    this.mApis.put("-277316359", kx1Var);
                }
                Pair<Boolean, f12> a = h12.a(kx1Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Coupon.getPlatformCoupons")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = kx1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                kx1 kx1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof kx1)) {
                    kx1Var = (kx1) obj;
                } else {
                    kx1Var = new kx1(this.mSwanApiContext);
                    this.mApis.put("-277316359", kx1Var);
                }
                Pair<Boolean, f12> a = h12.a(kx1Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Coupon.getUserCoupons")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 z = kx1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                kx1 kx1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof kx1)) {
                    kx1Var = (kx1) obj;
                } else {
                    kx1Var = new kx1(this.mSwanApiContext);
                    this.mApis.put("-277316359", kx1Var);
                }
                Pair<Boolean, f12> a = h12.a(kx1Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Coupon.takeCoupons")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 C = kx1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naFavorite", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                sx1 sx1Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof sx1)) {
                    sx1Var = (sx1) obj;
                } else {
                    sx1Var = new sx1(this.mSwanApiContext);
                    this.mApis.put("-1225406515", sx1Var);
                }
                Pair<Boolean, f12> a = h12.a(sx1Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Favorite.getFavorStatus")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = sx1Var.x(str);
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
                Pair<Boolean, f12> a = h12.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Favorite.showFavoriteGuide")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 G = showFavoriteGuideApi.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naFile", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                ux1 ux1Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("-2057135077", ux1Var);
                }
                Pair<Boolean, f12> a = h12.a(ux1Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "File.shareFile")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = ux1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                jm2 jm2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof jm2)) {
                    jm2Var = (jm2) obj;
                } else {
                    jm2Var = new jm2(this.mSwanApiContext);
                    this.mApis.put("2077414795", jm2Var);
                }
                Pair<Boolean, f12> a = h12.a(jm2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = jm2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                jm2 jm2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof jm2)) {
                    jm2Var = (jm2) obj;
                } else {
                    jm2Var = new jm2(this.mSwanApiContext);
                    this.mApis.put("2077414795", jm2Var);
                }
                Pair<Boolean, f12> a = h12.a(jm2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessageSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = jm2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String download(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("-170124576", vx1Var);
                }
                Pair<Boolean, f12> a = h12.a(vx1Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "HostDownloadManager.download")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = vx1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("-170124576", vx1Var);
                }
                Pair<Boolean, f12> a = h12.a(vx1Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "HostDownloadManager.openFile")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 z = vx1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String query(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("-170124576", vx1Var);
                }
                Pair<Boolean, f12> a = h12.a(vx1Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "HostDownloadManager.query")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 query = vx1Var.query(str);
                if (query == null) {
                    return "";
                }
                return query.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                vx1 vx1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("-170124576", vx1Var);
                }
                Pair<Boolean, f12> a = h12.a(vx1Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "HostDownloadManager.openDownloadCenter")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = vx1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naImage", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                xy2 xy2Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof xy2)) {
                    xy2Var = (xy2) obj;
                } else {
                    xy2Var = new xy2(this.mSwanApiContext);
                    this.mApis.put("1445003743", xy2Var);
                }
                Pair<Boolean, f12> a = h12.a(xy2Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Image.callImageMenu")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = xy2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                yx1 yx1Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("-1252730367", yx1Var);
                }
                Pair<Boolean, f12> a = h12.a(yx1Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Image.compressImage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = yx1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naInteraction", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                gy1 gy1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof gy1)) {
                    gy1Var = (gy1) obj;
                } else {
                    gy1Var = new gy1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", gy1Var);
                }
                Pair<Boolean, f12> a = h12.a(gy1Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.closeTabBar")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = gy1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                gy1 gy1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof gy1)) {
                    gy1Var = (gy1) obj;
                } else {
                    gy1Var = new gy1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", gy1Var);
                }
                Pair<Boolean, f12> a = h12.a(gy1Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.closeTabBarRedDot")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = gy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                cy1 cy1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof cy1)) {
                    cy1Var = (cy1) obj;
                } else {
                    cy1Var = new cy1(this.mSwanApiContext);
                    this.mApis.put("-246386074", cy1Var);
                }
                Pair<Boolean, f12> a = h12.a(cy1Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.hideNavigationBarLoading")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = cy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                ey1 ey1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof ey1)) {
                    ey1Var = (ey1) obj;
                } else {
                    ey1Var = new ey1(this.mSwanApiContext);
                    this.mApis.put("-108978463", ey1Var);
                }
                Pair<Boolean, f12> a = h12.a(ey1Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.openMultiPicker")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 G = ey1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                ey1 ey1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof ey1)) {
                    ey1Var = (ey1) obj;
                } else {
                    ey1Var = new ey1(this.mSwanApiContext);
                    this.mApis.put("-108978463", ey1Var);
                }
                Pair<Boolean, f12> a = h12.a(ey1Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.openPicker")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 H = ey1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                gy1 gy1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof gy1)) {
                    gy1Var = (gy1) obj;
                } else {
                    gy1Var = new gy1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", gy1Var);
                }
                Pair<Boolean, f12> a = h12.a(gy1Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.openTabBar")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 C = gy1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                dy1 dy1Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof dy1)) {
                    dy1Var = (dy1) obj;
                } else {
                    dy1Var = new dy1(this.mSwanApiContext);
                    this.mApis.put("-1750613704", dy1Var);
                }
                Pair<Boolean, f12> a = h12.a(dy1Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.pageScrollTo")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = dy1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                cy1 cy1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof cy1)) {
                    cy1Var = (cy1) obj;
                } else {
                    cy1Var = new cy1(this.mSwanApiContext);
                    this.mApis.put("-246386074", cy1Var);
                }
                Pair<Boolean, f12> a = h12.a(cy1Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarColor")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 z = cy1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                cy1 cy1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof cy1)) {
                    cy1Var = (cy1) obj;
                } else {
                    cy1Var = new cy1(this.mSwanApiContext);
                    this.mApis.put("-246386074", cy1Var);
                }
                Pair<Boolean, f12> a = h12.a(cy1Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarTitle")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = cy1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                gy1 gy1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof gy1)) {
                    gy1Var = (gy1) obj;
                } else {
                    gy1Var = new gy1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", gy1Var);
                }
                Pair<Boolean, f12> a = h12.a(gy1Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.setTabBarItem")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 D = gy1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                ey1 ey1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof ey1)) {
                    ey1Var = (ey1) obj;
                } else {
                    ey1Var = new ey1(this.mSwanApiContext);
                    this.mApis.put("-108978463", ey1Var);
                }
                Pair<Boolean, f12> a = h12.a(ey1Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.showDatePickerView")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 L = ey1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                iy1 iy1Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof iy1)) {
                    iy1Var = (iy1) obj;
                } else {
                    iy1Var = new iy1(this.mSwanApiContext);
                    this.mApis.put("1172469410", iy1Var);
                }
                Pair<Boolean, f12> a = h12.a(iy1Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.showHalfScreenWebview")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 K = iy1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                ay1 ay1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof ay1)) {
                    ay1Var = (ay1) obj;
                } else {
                    ay1Var = new ay1(this.mSwanApiContext);
                    this.mApis.put("5236036", ay1Var);
                }
                Pair<Boolean, f12> a = h12.a(ay1Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.showLoading")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = ay1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                by1 by1Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof by1)) {
                    by1Var = (by1) obj;
                } else {
                    by1Var = new by1(this.mSwanApiContext);
                    this.mApis.put("1913747800", by1Var);
                }
                Pair<Boolean, f12> a = h12.a(by1Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.showModal")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = by1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                cy1 cy1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof cy1)) {
                    cy1Var = (cy1) obj;
                } else {
                    cy1Var = new cy1(this.mSwanApiContext);
                    this.mApis.put("-246386074", cy1Var);
                }
                Pair<Boolean, f12> a = h12.a(cy1Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.showNavigationBarLoading")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 B = cy1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                hy1 hy1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof hy1)) {
                    hy1Var = (hy1) obj;
                } else {
                    hy1Var = new hy1(this.mSwanApiContext);
                    this.mApis.put("1159492510", hy1Var);
                }
                Pair<Boolean, f12> a = h12.a(hy1Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.showToast")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 Q = hy1Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                fy1 fy1Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof fy1)) {
                    fy1Var = (fy1) obj;
                } else {
                    fy1Var = new fy1(this.mSwanApiContext);
                    this.mApis.put("1165118609", fy1Var);
                }
                Pair<Boolean, f12> a = h12.a(fy1Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.stopPullDownRefresh")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = fy1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                ey1 ey1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof ey1)) {
                    ey1Var = (ey1) obj;
                } else {
                    ey1Var = new ey1(this.mSwanApiContext);
                    this.mApis.put("-108978463", ey1Var);
                }
                Pair<Boolean, f12> a = h12.a(ey1Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.updateMultiPicker")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 M = ey1Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                ay1 ay1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof ay1)) {
                    ay1Var = (ay1) obj;
                } else {
                    ay1Var = new ay1(this.mSwanApiContext);
                    this.mApis.put("5236036", ay1Var);
                }
                Pair<Boolean, f12> a = h12.a(ay1Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.hideLoading")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = ay1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hideToast() {
                hy1 hy1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof hy1)) {
                    hy1Var = (hy1) obj;
                } else {
                    hy1Var = new hy1(this.mSwanApiContext);
                    this.mApis.put("1159492510", hy1Var);
                }
                Pair<Boolean, f12> a = h12.a(hy1Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.hideToast")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 K = hy1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                jy1 jy1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof jy1)) {
                    jy1Var = (jy1) obj;
                } else {
                    jy1Var = new jy1(this.mSwanApiContext);
                    this.mApis.put("-137346255", jy1Var);
                }
                Pair<Boolean, f12> a = h12.a(jy1Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Keyboard.startKeyboardHeightChange")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 C = jy1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                jy1 jy1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof jy1)) {
                    jy1Var = (jy1) obj;
                } else {
                    jy1Var = new jy1(this.mSwanApiContext);
                    this.mApis.put("-137346255", jy1Var);
                }
                Pair<Boolean, f12> a = h12.a(jy1Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Keyboard.stopKeyboardHeightChange")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 D = jy1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naLocationService", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                ky1 ky1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof ky1)) {
                    ky1Var = (ky1) obj;
                } else {
                    ky1Var = new ky1(this.mSwanApiContext);
                    this.mApis.put("-397373095", ky1Var);
                }
                Pair<Boolean, f12> a = h12.a(ky1Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "LocationService.getLocation")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = ky1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                ky1 ky1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof ky1)) {
                    ky1Var = (ky1) obj;
                } else {
                    ky1Var = new ky1(this.mSwanApiContext);
                    this.mApis.put("-397373095", ky1Var);
                }
                Pair<Boolean, f12> a = h12.a(ky1Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "LocationService.startLocationUpdate")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = ky1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                ky1 ky1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof ky1)) {
                    ky1Var = (ky1) obj;
                } else {
                    ky1Var = new ky1(this.mSwanApiContext);
                    this.mApis.put("-397373095", ky1Var);
                }
                Pair<Boolean, f12> a = h12.a(ky1Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "LocationService.stopLocationUpdate")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 B = ky1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naMenu", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                b02 b02Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof b02)) {
                    b02Var = (b02) obj;
                } else {
                    b02Var = new b02(this.mSwanApiContext);
                    this.mApis.put("538070032", b02Var);
                }
                Pair<Boolean, f12> a = h12.a(b02Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = b02Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naNetwork", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                ny1 ny1Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof ny1)) {
                    ny1Var = (ny1) obj;
                } else {
                    ny1Var = new ny1(this.mSwanApiContext);
                    this.mApis.put("-1076509454", ny1Var);
                }
                Pair<Boolean, f12> a = h12.a(ny1Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Network.callService")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = ny1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                uy1 uy1Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof uy1)) {
                    uy1Var = (uy1) obj;
                } else {
                    uy1Var = new uy1(this.mSwanApiContext);
                    this.mApis.put("968563034", uy1Var);
                }
                Pair<Boolean, f12> a = h12.a(uy1Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Network.cancelRequest")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 D = uy1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                ty1 ty1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof ty1)) {
                    ty1Var = (ty1) obj;
                } else {
                    ty1Var = new ty1(this.mSwanApiContext);
                    this.mApis.put("453220699", ty1Var);
                }
                Pair<Boolean, f12> a = h12.a(ty1Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Network.networkStatusChange")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = ty1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                ty1 ty1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof ty1)) {
                    ty1Var = (ty1) obj;
                } else {
                    ty1Var = new ty1(this.mSwanApiContext);
                    this.mApis.put("453220699", ty1Var);
                }
                Pair<Boolean, f12> a = h12.a(ty1Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Network.getNetworkType")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = ty1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(JsObject jsObject) {
                uy1 uy1Var;
                String a;
                try {
                    e12.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof uy1)) {
                        uy1Var = (uy1) obj;
                    } else {
                        uy1Var = new uy1(this.mSwanApiContext);
                        this.mApis.put("968563034", uy1Var);
                    }
                    Pair<Boolean, f12> a2 = h12.a(uy1Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((f12) a2.second).a();
                    } else if (nb2.a(this.mSwanApiContext.f(), "Network.request")) {
                        a = new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<f12, JSONObject> t = jx1.t(jsObject);
                        if (!((f12) t.first).isSuccess()) {
                            a = ((f12) t.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) t.second;
                            if (jSONObject == null) {
                                a = f12.a.a();
                            } else {
                                g12 V = uy1Var.V(jSONObject);
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
                        e12.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                d23 d23Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof d23)) {
                    d23Var = (d23) obj;
                } else {
                    d23Var = new d23(this.mSwanApiContext);
                    this.mApis.put("-336396851", d23Var);
                }
                Pair<Boolean, f12> a = h12.a(d23Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Payment.chooseCoupon")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = d23Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                d23 d23Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof d23)) {
                    d23Var = (d23) obj;
                } else {
                    d23Var = new d23(this.mSwanApiContext);
                    this.mApis.put("-336396851", d23Var);
                }
                Pair<Boolean, f12> a = h12.a(d23Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Payment.getPaymentInfo")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = d23Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                t13 t13Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof t13)) {
                    t13Var = (t13) obj;
                } else {
                    t13Var = new t13(this.mSwanApiContext);
                    this.mApis.put("1854689529", t13Var);
                }
                Pair<Boolean, f12> a = h12.a(t13Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Payment.requestThirdPayment")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = t13Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                d23 d23Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof d23)) {
                    d23Var = (d23) obj;
                } else {
                    d23Var = new d23(this.mSwanApiContext);
                    this.mApis.put("-336396851", d23Var);
                }
                Pair<Boolean, f12> a = h12.a(d23Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Payment.setPaymentInfo")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 z = d23Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPlugin", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                o43 o43Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof o43)) {
                    o43Var = (o43) obj;
                } else {
                    o43Var = new o43(this.mSwanApiContext);
                    this.mApis.put("-254510461", o43Var);
                }
                Pair<Boolean, f12> a = h12.a(o43Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Plugin.invokePluginChooseAddress")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = o43Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                o43 o43Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof o43)) {
                    o43Var = (o43) obj;
                } else {
                    o43Var = new o43(this.mSwanApiContext);
                    this.mApis.put("-254510461", o43Var);
                }
                Pair<Boolean, f12> a = h12.a(o43Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 z = o43Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                o43 o43Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof o43)) {
                    o43Var = (o43) obj;
                } else {
                    o43Var = new o43(this.mSwanApiContext);
                    this.mApis.put("-254510461", o43Var);
                }
                Pair<Boolean, f12> a = h12.a(o43Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Plugin.invokePluginPayment")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = o43Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                hd2 hd2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof hd2)) {
                    hd2Var = (hd2) obj;
                } else {
                    hd2Var = new hd2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", hd2Var);
                }
                Pair<Boolean, f12> a = h12.a(hd2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Prefetch.prefetchResources")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = hd2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPreload", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                zb2 zb2Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof zb2)) {
                    zb2Var = (zb2) obj;
                } else {
                    zb2Var = new zb2(this.mSwanApiContext);
                    this.mApis.put("423661539", zb2Var);
                }
                Pair<Boolean, f12> a = h12.a(zb2Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Preload.preloadStatus")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = zb2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                jl3 jl3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof jl3)) {
                    jl3Var = (jl3) obj;
                } else {
                    jl3Var = new jl3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", jl3Var);
                }
                Pair<Boolean, f12> a = h12.a(jl3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "PrivateFile.uploadFileToBos")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 C = jl3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naRouter", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                yy1 yy1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof yy1)) {
                    yy1Var = (yy1) obj;
                } else {
                    yy1Var = new yy1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", yy1Var);
                }
                Pair<Boolean, f12> a = h12.a(yy1Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Router.hideModalPage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = yy1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                yy1 yy1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof yy1)) {
                    yy1Var = (yy1) obj;
                } else {
                    yy1Var = new yy1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", yy1Var);
                }
                Pair<Boolean, f12> a = h12.a(yy1Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Router.navigateBack")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 B = yy1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                zy1 zy1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof zy1)) {
                    zy1Var = (zy1) obj;
                } else {
                    zy1Var = new zy1(this.mSwanApiContext);
                    this.mApis.put("1968522584", zy1Var);
                }
                Pair<Boolean, f12> a = h12.a(zy1Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Router.navigateTo")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 H = zy1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                bz1 bz1Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof bz1)) {
                    bz1Var = (bz1) obj;
                } else {
                    bz1Var = new bz1(this.mSwanApiContext);
                    this.mApis.put("1317280190", bz1Var);
                }
                Pair<Boolean, f12> a = h12.a(bz1Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Router.reLaunch")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = bz1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                cz1 cz1Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof cz1)) {
                    cz1Var = (cz1) obj;
                } else {
                    cz1Var = new cz1(this.mSwanApiContext);
                    this.mApis.put("-420075743", cz1Var);
                }
                Pair<Boolean, f12> a = h12.a(cz1Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Router.reLoadErrorPage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = cz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                az1 az1Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof az1)) {
                    az1Var = (az1) obj;
                } else {
                    az1Var = new az1(this.mSwanApiContext);
                    this.mApis.put("1792515533", az1Var);
                }
                Pair<Boolean, f12> a = h12.a(az1Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Router.redirectTo")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 D = az1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                zy1 zy1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof zy1)) {
                    zy1Var = (zy1) obj;
                } else {
                    zy1Var = new zy1(this.mSwanApiContext);
                    this.mApis.put("1968522584", zy1Var);
                }
                Pair<Boolean, f12> a = h12.a(zy1Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Router.showModalPage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 J = zy1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naSetting", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                fz1 fz1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof fz1)) {
                    fz1Var = (fz1) obj;
                } else {
                    fz1Var = new fz1(this.mSwanApiContext);
                    this.mApis.put("-594895721", fz1Var);
                }
                Pair<Boolean, f12> a = h12.a(fz1Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Setting.getAppInfoSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 F = fz1Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                fz1 fz1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof fz1)) {
                    fz1Var = (fz1) obj;
                } else {
                    fz1Var = new fz1(this.mSwanApiContext);
                    this.mApis.put("-594895721", fz1Var);
                }
                Pair<Boolean, f12> a = h12.a(fz1Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Setting.getSlaveIdSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 H = fz1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                ez1 ez1Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof ez1)) {
                    ez1Var = (ez1) obj;
                } else {
                    ez1Var = new ez1(this.mSwanApiContext);
                    this.mApis.put("450273045", ez1Var);
                }
                Pair<Boolean, f12> a = h12.a(ez1Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Setting.isAllowedAdOpenAppSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = ez1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                fz1 fz1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof fz1)) {
                    fz1Var = (fz1) obj;
                } else {
                    fz1Var = new fz1(this.mSwanApiContext);
                    this.mApis.put("-594895721", fz1Var);
                }
                Pair<Boolean, f12> a = h12.a(fz1Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Setting.getSetting")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 G = fz1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                fz1 fz1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof fz1)) {
                    fz1Var = (fz1) obj;
                } else {
                    fz1Var = new fz1(this.mSwanApiContext);
                    this.mApis.put("-594895721", fz1Var);
                }
                Pair<Boolean, f12> a = h12.a(fz1Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Setting.getSwanId")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 I = fz1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                fz1 fz1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof fz1)) {
                    fz1Var = (fz1) obj;
                } else {
                    fz1Var = new fz1(this.mSwanApiContext);
                    this.mApis.put("-594895721", fz1Var);
                }
                Pair<Boolean, f12> a = h12.a(fz1Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Setting.getUserInfo")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 J = fz1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                dg3 dg3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof dg3)) {
                    dg3Var = (dg3) obj;
                } else {
                    dg3Var = new dg3(this.mSwanApiContext);
                    this.mApis.put("712777136", dg3Var);
                }
                Pair<Boolean, f12> a = h12.a(dg3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = dg3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naStorage", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                iz1 iz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof iz1)) {
                    iz1Var = (iz1) obj;
                } else {
                    iz1Var = new iz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", iz1Var);
                }
                Pair<Boolean, f12> a = h12.a(iz1Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = iz1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                iz1 iz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof iz1)) {
                    iz1Var = (iz1) obj;
                } else {
                    iz1Var = new iz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", iz1Var);
                }
                Pair<Boolean, f12> a = h12.a(iz1Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorageSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 C = iz1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                hz1 hz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("130910081", hz1Var);
                }
                Pair<Boolean, f12> a = h12.a(hz1Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.clearStorage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = hz1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                hz1 hz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("130910081", hz1Var);
                }
                Pair<Boolean, f12> a = h12.a(hz1Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.clearStorageSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 C = hz1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                iz1 iz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof iz1)) {
                    iz1Var = (iz1) obj;
                } else {
                    iz1Var = new iz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", iz1Var);
                }
                Pair<Boolean, f12> a = h12.a(iz1Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfo")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 G = iz1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                iz1 iz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof iz1)) {
                    iz1Var = (iz1) obj;
                } else {
                    iz1Var = new iz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", iz1Var);
                }
                Pair<Boolean, f12> a = h12.a(iz1Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfoSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 J = iz1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                hz1 hz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("130910081", hz1Var);
                }
                Pair<Boolean, f12> a = h12.a(hz1Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.getStorageInfo")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 G = hz1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                hz1 hz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("130910081", hz1Var);
                }
                Pair<Boolean, f12> a = h12.a(hz1Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.getStorageInfoSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 J = hz1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                iz1 iz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof iz1)) {
                    iz1Var = (iz1) obj;
                } else {
                    iz1Var = new iz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", iz1Var);
                }
                Pair<Boolean, f12> a = h12.a(iz1Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 D = iz1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                iz1 iz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof iz1)) {
                    iz1Var = (iz1) obj;
                } else {
                    iz1Var = new iz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", iz1Var);
                }
                Pair<Boolean, f12> a = h12.a(iz1Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 K = iz1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                hz1 hz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("130910081", hz1Var);
                }
                Pair<Boolean, f12> a = h12.a(hz1Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.getStorage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 D = hz1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                hz1 hz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("130910081", hz1Var);
                }
                Pair<Boolean, f12> a = h12.a(hz1Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.getStorageInfoAsync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 H = hz1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                hz1 hz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("130910081", hz1Var);
                }
                Pair<Boolean, f12> a = h12.a(hz1Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.getStorageSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 K = hz1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                iz1 iz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof iz1)) {
                    iz1Var = (iz1) obj;
                } else {
                    iz1Var = new iz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", iz1Var);
                }
                Pair<Boolean, f12> a = h12.a(iz1Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 R = iz1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                iz1 iz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof iz1)) {
                    iz1Var = (iz1) obj;
                } else {
                    iz1Var = new iz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", iz1Var);
                }
                Pair<Boolean, f12> a = h12.a(iz1Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorageSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 T = iz1Var.T(str);
                if (T == null) {
                    return "";
                }
                return T.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                hz1 hz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("130910081", hz1Var);
                }
                Pair<Boolean, f12> a = h12.a(hz1Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.removeStorage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 R = hz1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                hz1 hz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("130910081", hz1Var);
                }
                Pair<Boolean, f12> a = h12.a(hz1Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.removeStorageSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 T = hz1Var.T(str);
                if (T == null) {
                    return "";
                }
                return T.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                iz1 iz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof iz1)) {
                    iz1Var = (iz1) obj;
                } else {
                    iz1Var = new iz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", iz1Var);
                }
                Pair<Boolean, f12> a = h12.a(iz1Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.setGlobalStorage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 U = iz1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                iz1 iz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof iz1)) {
                    iz1Var = (iz1) obj;
                } else {
                    iz1Var = new iz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", iz1Var);
                }
                Pair<Boolean, f12> a = h12.a(iz1Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.setGlobalStorageSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 W = iz1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                hz1 hz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("130910081", hz1Var);
                }
                Pair<Boolean, f12> a = h12.a(hz1Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.setStorage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 U = hz1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                hz1 hz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("130910081", hz1Var);
                }
                Pair<Boolean, f12> a = h12.a(hz1Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.setStorageSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 W = hz1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }
        });
        hashMap.put("_naSubscription", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                kz1 kz1Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof kz1)) {
                    kz1Var = (kz1) obj;
                } else {
                    kz1Var = new kz1(this.mSwanApiContext);
                    this.mApis.put("823117982", kz1Var);
                }
                Pair<Boolean, f12> a = h12.a(kz1Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Subscription.requestSubscribeFormId")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 E = kz1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                lz1 lz1Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof lz1)) {
                    lz1Var = (lz1) obj;
                } else {
                    lz1Var = new lz1(this.mSwanApiContext);
                    this.mApis.put("-947445811", lz1Var);
                }
                Pair<Boolean, f12> a = h12.a(lz1Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Subscription.subscribeService")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 F = lz1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }
        });
        hashMap.put("_naSystem", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                sz1 sz1Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof sz1)) {
                    sz1Var = (sz1) obj;
                } else {
                    sz1Var = new sz1(this.mSwanApiContext);
                    this.mApis.put("1936205521", sz1Var);
                }
                Pair<Boolean, f12> a = h12.a(sz1Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.exitFullScreen")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = sz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                rz1 rz1Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof rz1)) {
                    rz1Var = (rz1) obj;
                } else {
                    rz1Var = new rz1(this.mSwanApiContext);
                    this.mApis.put("1694151270", rz1Var);
                }
                Pair<Boolean, f12> a = h12.a(rz1Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.getDeviceInfo")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = rz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                tz1 tz1Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof tz1)) {
                    tz1Var = (tz1) obj;
                } else {
                    tz1Var = new tz1(this.mSwanApiContext);
                    this.mApis.put("-1321681619", tz1Var);
                }
                Pair<Boolean, f12> a = h12.a(tz1Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.getDeviceProfile")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = tz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                uz1 uz1Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof uz1)) {
                    uz1Var = (uz1) obj;
                } else {
                    uz1Var = new uz1(this.mSwanApiContext);
                    this.mApis.put("-1569246082", uz1Var);
                }
                Pair<Boolean, f12> a = h12.a(uz1Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.makePhoneCall")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = uz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                wz1 wz1Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof wz1)) {
                    wz1Var = (wz1) obj;
                } else {
                    wz1Var = new wz1(this.mSwanApiContext);
                    this.mApis.put("1099851202", wz1Var);
                }
                Pair<Boolean, f12> a = h12.a(wz1Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.openSMSPanel")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = wz1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                vz1 vz1Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof vz1)) {
                    vz1Var = (vz1) obj;
                } else {
                    vz1Var = new vz1(this.mSwanApiContext);
                    this.mApis.put("-1707203360", vz1Var);
                }
                Pair<Boolean, f12> a = h12.a(vz1Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.requestFullScreen")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 F = vz1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                pz1 pz1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof pz1)) {
                    pz1Var = (pz1) obj;
                } else {
                    pz1Var = new pz1(this.mSwanApiContext);
                    this.mApis.put("-518757484", pz1Var);
                }
                Pair<Boolean, f12> a = h12.a(pz1Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.setClipboardData")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = pz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                zy2 zy2Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof zy2)) {
                    zy2Var = (zy2) obj;
                } else {
                    zy2Var = new zy2(this.mSwanApiContext);
                    this.mApis.put("1161486049", zy2Var);
                }
                Pair<Boolean, f12> a = h12.a(zy2Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.setErrorPageType")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = zy2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                zz1 zz1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof zz1)) {
                    zz1Var = (zz1) obj;
                } else {
                    zz1Var = new zz1(this.mSwanApiContext);
                    this.mApis.put("447234992", zz1Var);
                }
                Pair<Boolean, f12> a = h12.a(zz1Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.setMediaVolume")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 z = zz1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                nz1 nz1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("1372680763", nz1Var);
                }
                Pair<Boolean, f12> a = h12.a(nz1Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.startAccelerometer")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = nz1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                qz1 qz1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof qz1)) {
                    qz1Var = (qz1) obj;
                } else {
                    qz1Var = new qz1(this.mSwanApiContext);
                    this.mApis.put("1689255576", qz1Var);
                }
                Pair<Boolean, f12> a = h12.a(qz1Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.startCompass")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = qz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                oz1 oz1Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof oz1)) {
                    oz1Var = (oz1) obj;
                } else {
                    oz1Var = new oz1(this.mSwanApiContext);
                    this.mApis.put("99997465", oz1Var);
                }
                Pair<Boolean, f12> a = h12.a(oz1Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.getBrightness")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = oz1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                pz1 pz1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof pz1)) {
                    pz1Var = (pz1) obj;
                } else {
                    pz1Var = new pz1(this.mSwanApiContext);
                    this.mApis.put("-518757484", pz1Var);
                }
                Pair<Boolean, f12> a = h12.a(pz1Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.getClipboardData")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = pz1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                zz1 zz1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof zz1)) {
                    zz1Var = (zz1) obj;
                } else {
                    zz1Var = new zz1(this.mSwanApiContext);
                    this.mApis.put("447234992", zz1Var);
                }
                Pair<Boolean, f12> a = h12.a(zz1Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.getMediaVolume")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = zz1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                nz1 nz1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("1372680763", nz1Var);
                }
                Pair<Boolean, f12> a = h12.a(nz1Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.stopAccelerometer")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 B = nz1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                qz1 qz1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof qz1)) {
                    qz1Var = (qz1) obj;
                } else {
                    qz1Var = new qz1(this.mSwanApiContext);
                    this.mApis.put("1689255576", qz1Var);
                }
                Pair<Boolean, f12> a = h12.a(qz1Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.stopCompass")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 z = qz1Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naUtils", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                k02 k02Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof k02)) {
                    k02Var = (k02) obj;
                } else {
                    k02Var = new k02(this.mSwanApiContext);
                    this.mApis.put("201194468", k02Var);
                }
                Pair<Boolean, f12> a = h12.a(k02Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.addToDesktop")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 B = k02Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                g02 g02Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof g02)) {
                    g02Var = (g02) obj;
                } else {
                    g02Var = new g02(this.mSwanApiContext);
                    this.mApis.put("-1412306947", g02Var);
                }
                Pair<Boolean, f12> a = h12.a(g02Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.calcMD5")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = g02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                h02 h02Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof h02)) {
                    h02Var = (h02) obj;
                } else {
                    h02Var = new h02(this.mSwanApiContext);
                    this.mApis.put("1626415364", h02Var);
                }
                Pair<Boolean, f12> a = h12.a(h02Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.checkAppInstalled")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = h02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                j02 j02Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof j02)) {
                    j02Var = (j02) obj;
                } else {
                    j02Var = new j02(this.mSwanApiContext);
                    this.mApis.put("-836768778", j02Var);
                }
                Pair<Boolean, f12> a = h12.a(j02Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfo")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = j02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                l02 l02Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof l02)) {
                    l02Var = (l02) obj;
                } else {
                    l02Var = new l02(this.mSwanApiContext);
                    this.mApis.put("-810858308", l02Var);
                }
                Pair<Boolean, f12> a = h12.a(l02Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.getPerformanceLevel")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = l02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                p02 p02Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof p02)) {
                    p02Var = (p02) obj;
                } else {
                    p02Var = new p02(this.mSwanApiContext);
                    this.mApis.put("-1011537871", p02Var);
                }
                Pair<Boolean, f12> a = h12.a(p02Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.getSystemInfoAsync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 I = p02Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                m02 m02Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof m02)) {
                    m02Var = (m02) obj;
                } else {
                    m02Var = new m02(this.mSwanApiContext);
                    this.mApis.put("-2097727681", m02Var);
                }
                Pair<Boolean, f12> a = h12.a(m02Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.handleException")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = m02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                i02 i02Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof i02)) {
                    i02Var = (i02) obj;
                } else {
                    i02Var = new i02(this.mSwanApiContext);
                    this.mApis.put("2084449317", i02Var);
                }
                Pair<Boolean, f12> a = h12.a(i02Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.hasCloseHandler")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = i02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                ld3 ld3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof ld3)) {
                    ld3Var = (ld3) obj;
                } else {
                    ld3Var = new ld3(this.mSwanApiContext);
                    this.mApis.put("1031678042", ld3Var);
                }
                Pair<Boolean, f12> a = h12.a(ld3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.hideCaptureScreenShareDialog")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = ld3Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                n02 n02Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof n02)) {
                    n02Var = (n02) obj;
                } else {
                    n02Var = new n02(this.mSwanApiContext);
                    this.mApis.put("1751900130", n02Var);
                }
                Pair<Boolean, f12> a = h12.a(n02Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.logToFile")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = n02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                mc3 mc3Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof mc3)) {
                    mc3Var = (mc3) obj;
                } else {
                    mc3Var = new mc3(this.mSwanApiContext);
                    this.mApis.put("1748196865", mc3Var);
                }
                Pair<Boolean, f12> a = h12.a(mc3Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.preloadPackage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = mc3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                o02 o02Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof o02)) {
                    o02Var = (o02) obj;
                } else {
                    o02Var = new o02(this.mSwanApiContext);
                    this.mApis.put("589529211", o02Var);
                }
                Pair<Boolean, f12> a = h12.a(o02Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.previewImage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 B = o02Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                r02 r02Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof r02)) {
                    r02Var = (r02) obj;
                } else {
                    r02Var = new r02(this.mSwanApiContext);
                    this.mApis.put("-577481801", r02Var);
                }
                Pair<Boolean, f12> a = h12.a(r02Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.ubcFlowJar")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 I = r02Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                p02 p02Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof p02)) {
                    p02Var = (p02) obj;
                } else {
                    p02Var = new p02(this.mSwanApiContext);
                    this.mApis.put("-1011537871", p02Var);
                }
                Pair<Boolean, f12> a = h12.a(p02Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfoSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 E = p02Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                p02 p02Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof p02)) {
                    p02Var = (p02) obj;
                } else {
                    p02Var = new p02(this.mSwanApiContext);
                    this.mApis.put("-1011537871", p02Var);
                }
                Pair<Boolean, f12> a = h12.a(p02Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.getSystemInfo")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 H = p02Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                p02 p02Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof p02)) {
                    p02Var = (p02) obj;
                } else {
                    p02Var = new p02(this.mSwanApiContext);
                    this.mApis.put("-1011537871", p02Var);
                }
                Pair<Boolean, f12> a = h12.a(p02Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.getSystemInfoSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 J = p02Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naWifi", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                wj3 wj3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof wj3)) {
                    wj3Var = (wj3) obj;
                } else {
                    wj3Var = new wj3(this.mSwanApiContext);
                    this.mApis.put("1879401452", wj3Var);
                }
                Pair<Boolean, f12> a = h12.a(wj3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Wifi.connectWifi")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = wj3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                wj3 wj3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof wj3)) {
                    wj3Var = (wj3) obj;
                } else {
                    wj3Var = new wj3(this.mSwanApiContext);
                    this.mApis.put("1879401452", wj3Var);
                }
                Pair<Boolean, f12> a = h12.a(wj3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Wifi.getConnectedWifi")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 B = wj3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                wj3 wj3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof wj3)) {
                    wj3Var = (wj3) obj;
                } else {
                    wj3Var = new wj3(this.mSwanApiContext);
                    this.mApis.put("1879401452", wj3Var);
                }
                Pair<Boolean, f12> a = h12.a(wj3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Wifi.getWifiList")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 C = wj3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                wj3 wj3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof wj3)) {
                    wj3Var = (wj3) obj;
                } else {
                    wj3Var = new wj3(this.mSwanApiContext);
                    this.mApis.put("1879401452", wj3Var);
                }
                Pair<Boolean, f12> a = h12.a(wj3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Wifi.startWifi")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 G = wj3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                wj3 wj3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof wj3)) {
                    wj3Var = (wj3) obj;
                } else {
                    wj3Var = new wj3(this.mSwanApiContext);
                    this.mApis.put("1879401452", wj3Var);
                }
                Pair<Boolean, f12> a = h12.a(wj3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Wifi.stopWifi")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 H = wj3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final hx1 hx1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                nx1 nx1Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof nx1)) {
                    nx1Var = (nx1) obj;
                } else {
                    nx1Var = new nx1(this.mSwanApiContext);
                    this.mApis.put("1930258908", nx1Var);
                }
                Pair<Boolean, f12> a = h12.a(nx1Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Account.checkSession")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = nx1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                ox1 ox1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof ox1)) {
                    ox1Var = (ox1) obj;
                } else {
                    ox1Var = new ox1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", ox1Var);
                }
                Pair<Boolean, f12> a = h12.a(ox1Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Account.getLoginCode")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 C = ox1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                px1 px1Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof px1)) {
                    px1Var = (px1) obj;
                } else {
                    px1Var = new px1(this.mSwanApiContext);
                    this.mApis.put("1754780133", px1Var);
                }
                Pair<Boolean, f12> a = h12.a(px1Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Account.getOpenId")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = px1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                ww1 ww1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof ww1)) {
                    ww1Var = (ww1) obj;
                } else {
                    ww1Var = new ww1(this.mSwanApiContext);
                    this.mApis.put("-343998465", ww1Var);
                }
                Pair<Boolean, f12> a = h12.a(ww1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Account.getUnionBDUSS")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = ww1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String login(String str) {
                ox1 ox1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof ox1)) {
                    ox1Var = (ox1) obj;
                } else {
                    ox1Var = new ox1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", ox1Var);
                }
                Pair<Boolean, f12> a = h12.a(ox1Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Account.login")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 I = ox1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                mx1 mx1Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof mx1)) {
                    mx1Var = (mx1) obj;
                } else {
                    mx1Var = new mx1(this.mSwanApiContext);
                    this.mApis.put("-337742792", mx1Var);
                }
                Pair<Boolean, f12> a = h12.a(mx1Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Account.isBaiduAccountSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = mx1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                ox1 ox1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof ox1)) {
                    ox1Var = (ox1) obj;
                } else {
                    ox1Var = new ox1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", ox1Var);
                }
                Pair<Boolean, f12> a = h12.a(ox1Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Account.isLoginSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 H = ox1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBasic", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                qx1 qx1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", qx1Var);
                }
                Pair<Boolean, f12> a = h12.a(qx1Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Basic.loadSubPackage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 F = qx1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                qx1 qx1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", qx1Var);
                }
                Pair<Boolean, f12> a = h12.a(qx1Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Basic.loadSubPackages")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 G = qx1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                xp1 xp1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof xp1)) {
                    xp1Var = (xp1) obj;
                } else {
                    xp1Var = new xp1(this.mSwanApiContext);
                    this.mApis.put("1460300387", xp1Var);
                }
                Pair<Boolean, f12> a = h12.a(xp1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Bookshelf.deleteBookshelf")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 K = xp1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                xp1 xp1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof xp1)) {
                    xp1Var = (xp1) obj;
                } else {
                    xp1Var = new xp1(this.mSwanApiContext);
                    this.mApis.put("1460300387", xp1Var);
                }
                Pair<Boolean, f12> a = h12.a(xp1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Bookshelf.insertBookshelf")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 P = xp1Var.P(str);
                if (P == null) {
                    return "";
                }
                return P.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                xp1 xp1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof xp1)) {
                    xp1Var = (xp1) obj;
                } else {
                    xp1Var = new xp1(this.mSwanApiContext);
                    this.mApis.put("1460300387", xp1Var);
                }
                Pair<Boolean, f12> a = h12.a(xp1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Bookshelf.navigateToBookshelf")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 U = xp1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                xp1 xp1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof xp1)) {
                    xp1Var = (xp1) obj;
                } else {
                    xp1Var = new xp1(this.mSwanApiContext);
                    this.mApis.put("1460300387", xp1Var);
                }
                Pair<Boolean, f12> a = h12.a(xp1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Bookshelf.queryBookshelf")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 V = xp1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                xp1 xp1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof xp1)) {
                    xp1Var = (xp1) obj;
                } else {
                    xp1Var = new xp1(this.mSwanApiContext);
                    this.mApis.put("1460300387", xp1Var);
                }
                Pair<Boolean, f12> a = h12.a(xp1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Bookshelf.updateBookshelfReadTime")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 X = xp1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naCoupon", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                kx1 kx1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof kx1)) {
                    kx1Var = (kx1) obj;
                } else {
                    kx1Var = new kx1(this.mSwanApiContext);
                    this.mApis.put("-277316359", kx1Var);
                }
                Pair<Boolean, f12> a = h12.a(kx1Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Coupon.getPlatformCoupons")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = kx1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                kx1 kx1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof kx1)) {
                    kx1Var = (kx1) obj;
                } else {
                    kx1Var = new kx1(this.mSwanApiContext);
                    this.mApis.put("-277316359", kx1Var);
                }
                Pair<Boolean, f12> a = h12.a(kx1Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Coupon.getUserCoupons")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 z = kx1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                kx1 kx1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof kx1)) {
                    kx1Var = (kx1) obj;
                } else {
                    kx1Var = new kx1(this.mSwanApiContext);
                    this.mApis.put("-277316359", kx1Var);
                }
                Pair<Boolean, f12> a = h12.a(kx1Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Coupon.takeCoupons")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 C = kx1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naFavorite", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                sx1 sx1Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof sx1)) {
                    sx1Var = (sx1) obj;
                } else {
                    sx1Var = new sx1(this.mSwanApiContext);
                    this.mApis.put("-1225406515", sx1Var);
                }
                Pair<Boolean, f12> a = h12.a(sx1Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Favorite.getFavorStatus")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = sx1Var.x(str);
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
                Pair<Boolean, f12> a = h12.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Favorite.showFavoriteGuide")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 G = showFavoriteGuideApi.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naFile", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                ux1 ux1Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("-2057135077", ux1Var);
                }
                Pair<Boolean, f12> a = h12.a(ux1Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "File.shareFile")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = ux1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                jm2 jm2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof jm2)) {
                    jm2Var = (jm2) obj;
                } else {
                    jm2Var = new jm2(this.mSwanApiContext);
                    this.mApis.put("2077414795", jm2Var);
                }
                Pair<Boolean, f12> a = h12.a(jm2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = jm2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                jm2 jm2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof jm2)) {
                    jm2Var = (jm2) obj;
                } else {
                    jm2Var = new jm2(this.mSwanApiContext);
                    this.mApis.put("2077414795", jm2Var);
                }
                Pair<Boolean, f12> a = h12.a(jm2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessageSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = jm2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String download(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("-170124576", vx1Var);
                }
                Pair<Boolean, f12> a = h12.a(vx1Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "HostDownloadManager.download")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = vx1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("-170124576", vx1Var);
                }
                Pair<Boolean, f12> a = h12.a(vx1Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "HostDownloadManager.openFile")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 z = vx1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String query(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("-170124576", vx1Var);
                }
                Pair<Boolean, f12> a = h12.a(vx1Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "HostDownloadManager.query")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 query = vx1Var.query(str);
                if (query == null) {
                    return "";
                }
                return query.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                vx1 vx1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("-170124576", vx1Var);
                }
                Pair<Boolean, f12> a = h12.a(vx1Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "HostDownloadManager.openDownloadCenter")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = vx1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naImage", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                xy2 xy2Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof xy2)) {
                    xy2Var = (xy2) obj;
                } else {
                    xy2Var = new xy2(this.mSwanApiContext);
                    this.mApis.put("1445003743", xy2Var);
                }
                Pair<Boolean, f12> a = h12.a(xy2Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Image.callImageMenu")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = xy2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                yx1 yx1Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("-1252730367", yx1Var);
                }
                Pair<Boolean, f12> a = h12.a(yx1Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Image.compressImage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = yx1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naInteraction", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                gy1 gy1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof gy1)) {
                    gy1Var = (gy1) obj;
                } else {
                    gy1Var = new gy1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", gy1Var);
                }
                Pair<Boolean, f12> a = h12.a(gy1Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.closeTabBar")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = gy1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                gy1 gy1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof gy1)) {
                    gy1Var = (gy1) obj;
                } else {
                    gy1Var = new gy1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", gy1Var);
                }
                Pair<Boolean, f12> a = h12.a(gy1Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.closeTabBarRedDot")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = gy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                cy1 cy1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof cy1)) {
                    cy1Var = (cy1) obj;
                } else {
                    cy1Var = new cy1(this.mSwanApiContext);
                    this.mApis.put("-246386074", cy1Var);
                }
                Pair<Boolean, f12> a = h12.a(cy1Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.hideNavigationBarLoading")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = cy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                ey1 ey1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof ey1)) {
                    ey1Var = (ey1) obj;
                } else {
                    ey1Var = new ey1(this.mSwanApiContext);
                    this.mApis.put("-108978463", ey1Var);
                }
                Pair<Boolean, f12> a = h12.a(ey1Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.openMultiPicker")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 G = ey1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                ey1 ey1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof ey1)) {
                    ey1Var = (ey1) obj;
                } else {
                    ey1Var = new ey1(this.mSwanApiContext);
                    this.mApis.put("-108978463", ey1Var);
                }
                Pair<Boolean, f12> a = h12.a(ey1Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.openPicker")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 H = ey1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                gy1 gy1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof gy1)) {
                    gy1Var = (gy1) obj;
                } else {
                    gy1Var = new gy1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", gy1Var);
                }
                Pair<Boolean, f12> a = h12.a(gy1Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.openTabBar")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 C = gy1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                dy1 dy1Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof dy1)) {
                    dy1Var = (dy1) obj;
                } else {
                    dy1Var = new dy1(this.mSwanApiContext);
                    this.mApis.put("-1750613704", dy1Var);
                }
                Pair<Boolean, f12> a = h12.a(dy1Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.pageScrollTo")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = dy1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                cy1 cy1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof cy1)) {
                    cy1Var = (cy1) obj;
                } else {
                    cy1Var = new cy1(this.mSwanApiContext);
                    this.mApis.put("-246386074", cy1Var);
                }
                Pair<Boolean, f12> a = h12.a(cy1Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarColor")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 z = cy1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                cy1 cy1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof cy1)) {
                    cy1Var = (cy1) obj;
                } else {
                    cy1Var = new cy1(this.mSwanApiContext);
                    this.mApis.put("-246386074", cy1Var);
                }
                Pair<Boolean, f12> a = h12.a(cy1Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarTitle")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = cy1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                gy1 gy1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof gy1)) {
                    gy1Var = (gy1) obj;
                } else {
                    gy1Var = new gy1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", gy1Var);
                }
                Pair<Boolean, f12> a = h12.a(gy1Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.setTabBarItem")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 D = gy1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                ey1 ey1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof ey1)) {
                    ey1Var = (ey1) obj;
                } else {
                    ey1Var = new ey1(this.mSwanApiContext);
                    this.mApis.put("-108978463", ey1Var);
                }
                Pair<Boolean, f12> a = h12.a(ey1Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.showDatePickerView")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 L = ey1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                iy1 iy1Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof iy1)) {
                    iy1Var = (iy1) obj;
                } else {
                    iy1Var = new iy1(this.mSwanApiContext);
                    this.mApis.put("1172469410", iy1Var);
                }
                Pair<Boolean, f12> a = h12.a(iy1Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.showHalfScreenWebview")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 K = iy1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                ay1 ay1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof ay1)) {
                    ay1Var = (ay1) obj;
                } else {
                    ay1Var = new ay1(this.mSwanApiContext);
                    this.mApis.put("5236036", ay1Var);
                }
                Pair<Boolean, f12> a = h12.a(ay1Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.showLoading")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = ay1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                by1 by1Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof by1)) {
                    by1Var = (by1) obj;
                } else {
                    by1Var = new by1(this.mSwanApiContext);
                    this.mApis.put("1913747800", by1Var);
                }
                Pair<Boolean, f12> a = h12.a(by1Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.showModal")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = by1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                cy1 cy1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof cy1)) {
                    cy1Var = (cy1) obj;
                } else {
                    cy1Var = new cy1(this.mSwanApiContext);
                    this.mApis.put("-246386074", cy1Var);
                }
                Pair<Boolean, f12> a = h12.a(cy1Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.showNavigationBarLoading")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 B = cy1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                hy1 hy1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof hy1)) {
                    hy1Var = (hy1) obj;
                } else {
                    hy1Var = new hy1(this.mSwanApiContext);
                    this.mApis.put("1159492510", hy1Var);
                }
                Pair<Boolean, f12> a = h12.a(hy1Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.showToast")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 Q = hy1Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                fy1 fy1Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof fy1)) {
                    fy1Var = (fy1) obj;
                } else {
                    fy1Var = new fy1(this.mSwanApiContext);
                    this.mApis.put("1165118609", fy1Var);
                }
                Pair<Boolean, f12> a = h12.a(fy1Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.stopPullDownRefresh")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = fy1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                ey1 ey1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof ey1)) {
                    ey1Var = (ey1) obj;
                } else {
                    ey1Var = new ey1(this.mSwanApiContext);
                    this.mApis.put("-108978463", ey1Var);
                }
                Pair<Boolean, f12> a = h12.a(ey1Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.updateMultiPicker")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 M = ey1Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                ay1 ay1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof ay1)) {
                    ay1Var = (ay1) obj;
                } else {
                    ay1Var = new ay1(this.mSwanApiContext);
                    this.mApis.put("5236036", ay1Var);
                }
                Pair<Boolean, f12> a = h12.a(ay1Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.hideLoading")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = ay1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hideToast() {
                hy1 hy1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof hy1)) {
                    hy1Var = (hy1) obj;
                } else {
                    hy1Var = new hy1(this.mSwanApiContext);
                    this.mApis.put("1159492510", hy1Var);
                }
                Pair<Boolean, f12> a = h12.a(hy1Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Interaction.hideToast")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 K = hy1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                jy1 jy1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof jy1)) {
                    jy1Var = (jy1) obj;
                } else {
                    jy1Var = new jy1(this.mSwanApiContext);
                    this.mApis.put("-137346255", jy1Var);
                }
                Pair<Boolean, f12> a = h12.a(jy1Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Keyboard.startKeyboardHeightChange")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 C = jy1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                jy1 jy1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof jy1)) {
                    jy1Var = (jy1) obj;
                } else {
                    jy1Var = new jy1(this.mSwanApiContext);
                    this.mApis.put("-137346255", jy1Var);
                }
                Pair<Boolean, f12> a = h12.a(jy1Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Keyboard.stopKeyboardHeightChange")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 D = jy1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naLocationService", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                ky1 ky1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof ky1)) {
                    ky1Var = (ky1) obj;
                } else {
                    ky1Var = new ky1(this.mSwanApiContext);
                    this.mApis.put("-397373095", ky1Var);
                }
                Pair<Boolean, f12> a = h12.a(ky1Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "LocationService.getLocation")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = ky1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                ky1 ky1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof ky1)) {
                    ky1Var = (ky1) obj;
                } else {
                    ky1Var = new ky1(this.mSwanApiContext);
                    this.mApis.put("-397373095", ky1Var);
                }
                Pair<Boolean, f12> a = h12.a(ky1Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "LocationService.startLocationUpdate")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = ky1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                ky1 ky1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof ky1)) {
                    ky1Var = (ky1) obj;
                } else {
                    ky1Var = new ky1(this.mSwanApiContext);
                    this.mApis.put("-397373095", ky1Var);
                }
                Pair<Boolean, f12> a = h12.a(ky1Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "LocationService.stopLocationUpdate")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 B = ky1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naMenu", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                b02 b02Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof b02)) {
                    b02Var = (b02) obj;
                } else {
                    b02Var = new b02(this.mSwanApiContext);
                    this.mApis.put("538070032", b02Var);
                }
                Pair<Boolean, f12> a = h12.a(b02Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = b02Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naNetwork", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                ny1 ny1Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof ny1)) {
                    ny1Var = (ny1) obj;
                } else {
                    ny1Var = new ny1(this.mSwanApiContext);
                    this.mApis.put("-1076509454", ny1Var);
                }
                Pair<Boolean, f12> a = h12.a(ny1Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Network.callService")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = ny1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                uy1 uy1Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof uy1)) {
                    uy1Var = (uy1) obj;
                } else {
                    uy1Var = new uy1(this.mSwanApiContext);
                    this.mApis.put("968563034", uy1Var);
                }
                Pair<Boolean, f12> a = h12.a(uy1Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Network.cancelRequest")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 D = uy1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                ty1 ty1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof ty1)) {
                    ty1Var = (ty1) obj;
                } else {
                    ty1Var = new ty1(this.mSwanApiContext);
                    this.mApis.put("453220699", ty1Var);
                }
                Pair<Boolean, f12> a = h12.a(ty1Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Network.networkStatusChange")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = ty1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                ty1 ty1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof ty1)) {
                    ty1Var = (ty1) obj;
                } else {
                    ty1Var = new ty1(this.mSwanApiContext);
                    this.mApis.put("453220699", ty1Var);
                }
                Pair<Boolean, f12> a = h12.a(ty1Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Network.getNetworkType")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = ty1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(String str) {
                uy1 uy1Var;
                String a;
                try {
                    e12.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof uy1)) {
                        uy1Var = (uy1) obj;
                    } else {
                        uy1Var = new uy1(this.mSwanApiContext);
                        this.mApis.put("968563034", uy1Var);
                    }
                    Pair<Boolean, f12> a2 = h12.a(uy1Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((f12) a2.second).a();
                    } else if (nb2.a(this.mSwanApiContext.f(), "Network.request")) {
                        a = new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<f12, JSONObject> u = jx1.u(str);
                        if (!((f12) u.first).isSuccess()) {
                            a = ((f12) u.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) u.second;
                            if (jSONObject == null) {
                                a = f12.a.a();
                            } else {
                                g12 V = uy1Var.V(jSONObject);
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
                        e12.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                d23 d23Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof d23)) {
                    d23Var = (d23) obj;
                } else {
                    d23Var = new d23(this.mSwanApiContext);
                    this.mApis.put("-336396851", d23Var);
                }
                Pair<Boolean, f12> a = h12.a(d23Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Payment.chooseCoupon")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = d23Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                d23 d23Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof d23)) {
                    d23Var = (d23) obj;
                } else {
                    d23Var = new d23(this.mSwanApiContext);
                    this.mApis.put("-336396851", d23Var);
                }
                Pair<Boolean, f12> a = h12.a(d23Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Payment.getPaymentInfo")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = d23Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                t13 t13Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof t13)) {
                    t13Var = (t13) obj;
                } else {
                    t13Var = new t13(this.mSwanApiContext);
                    this.mApis.put("1854689529", t13Var);
                }
                Pair<Boolean, f12> a = h12.a(t13Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Payment.requestThirdPayment")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = t13Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                d23 d23Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof d23)) {
                    d23Var = (d23) obj;
                } else {
                    d23Var = new d23(this.mSwanApiContext);
                    this.mApis.put("-336396851", d23Var);
                }
                Pair<Boolean, f12> a = h12.a(d23Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Payment.setPaymentInfo")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 z = d23Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPlugin", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                o43 o43Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof o43)) {
                    o43Var = (o43) obj;
                } else {
                    o43Var = new o43(this.mSwanApiContext);
                    this.mApis.put("-254510461", o43Var);
                }
                Pair<Boolean, f12> a = h12.a(o43Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Plugin.invokePluginChooseAddress")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = o43Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                o43 o43Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof o43)) {
                    o43Var = (o43) obj;
                } else {
                    o43Var = new o43(this.mSwanApiContext);
                    this.mApis.put("-254510461", o43Var);
                }
                Pair<Boolean, f12> a = h12.a(o43Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 z = o43Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                o43 o43Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof o43)) {
                    o43Var = (o43) obj;
                } else {
                    o43Var = new o43(this.mSwanApiContext);
                    this.mApis.put("-254510461", o43Var);
                }
                Pair<Boolean, f12> a = h12.a(o43Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Plugin.invokePluginPayment")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = o43Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                hd2 hd2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof hd2)) {
                    hd2Var = (hd2) obj;
                } else {
                    hd2Var = new hd2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", hd2Var);
                }
                Pair<Boolean, f12> a = h12.a(hd2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Prefetch.prefetchResources")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = hd2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPreload", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                zb2 zb2Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof zb2)) {
                    zb2Var = (zb2) obj;
                } else {
                    zb2Var = new zb2(this.mSwanApiContext);
                    this.mApis.put("423661539", zb2Var);
                }
                Pair<Boolean, f12> a = h12.a(zb2Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Preload.preloadStatus")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = zb2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                jl3 jl3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof jl3)) {
                    jl3Var = (jl3) obj;
                } else {
                    jl3Var = new jl3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", jl3Var);
                }
                Pair<Boolean, f12> a = h12.a(jl3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "PrivateFile.uploadFileToBos")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 C = jl3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naRouter", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                yy1 yy1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof yy1)) {
                    yy1Var = (yy1) obj;
                } else {
                    yy1Var = new yy1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", yy1Var);
                }
                Pair<Boolean, f12> a = h12.a(yy1Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Router.hideModalPage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = yy1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                yy1 yy1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof yy1)) {
                    yy1Var = (yy1) obj;
                } else {
                    yy1Var = new yy1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", yy1Var);
                }
                Pair<Boolean, f12> a = h12.a(yy1Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Router.navigateBack")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 B = yy1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                zy1 zy1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof zy1)) {
                    zy1Var = (zy1) obj;
                } else {
                    zy1Var = new zy1(this.mSwanApiContext);
                    this.mApis.put("1968522584", zy1Var);
                }
                Pair<Boolean, f12> a = h12.a(zy1Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Router.navigateTo")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 H = zy1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                bz1 bz1Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof bz1)) {
                    bz1Var = (bz1) obj;
                } else {
                    bz1Var = new bz1(this.mSwanApiContext);
                    this.mApis.put("1317280190", bz1Var);
                }
                Pair<Boolean, f12> a = h12.a(bz1Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Router.reLaunch")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = bz1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                cz1 cz1Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof cz1)) {
                    cz1Var = (cz1) obj;
                } else {
                    cz1Var = new cz1(this.mSwanApiContext);
                    this.mApis.put("-420075743", cz1Var);
                }
                Pair<Boolean, f12> a = h12.a(cz1Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Router.reLoadErrorPage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = cz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                az1 az1Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof az1)) {
                    az1Var = (az1) obj;
                } else {
                    az1Var = new az1(this.mSwanApiContext);
                    this.mApis.put("1792515533", az1Var);
                }
                Pair<Boolean, f12> a = h12.a(az1Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Router.redirectTo")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 D = az1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                zy1 zy1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof zy1)) {
                    zy1Var = (zy1) obj;
                } else {
                    zy1Var = new zy1(this.mSwanApiContext);
                    this.mApis.put("1968522584", zy1Var);
                }
                Pair<Boolean, f12> a = h12.a(zy1Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Router.showModalPage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 J = zy1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naSetting", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                fz1 fz1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof fz1)) {
                    fz1Var = (fz1) obj;
                } else {
                    fz1Var = new fz1(this.mSwanApiContext);
                    this.mApis.put("-594895721", fz1Var);
                }
                Pair<Boolean, f12> a = h12.a(fz1Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Setting.getAppInfoSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 F = fz1Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                fz1 fz1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof fz1)) {
                    fz1Var = (fz1) obj;
                } else {
                    fz1Var = new fz1(this.mSwanApiContext);
                    this.mApis.put("-594895721", fz1Var);
                }
                Pair<Boolean, f12> a = h12.a(fz1Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Setting.getSlaveIdSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 H = fz1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                ez1 ez1Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof ez1)) {
                    ez1Var = (ez1) obj;
                } else {
                    ez1Var = new ez1(this.mSwanApiContext);
                    this.mApis.put("450273045", ez1Var);
                }
                Pair<Boolean, f12> a = h12.a(ez1Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Setting.isAllowedAdOpenAppSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = ez1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                fz1 fz1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof fz1)) {
                    fz1Var = (fz1) obj;
                } else {
                    fz1Var = new fz1(this.mSwanApiContext);
                    this.mApis.put("-594895721", fz1Var);
                }
                Pair<Boolean, f12> a = h12.a(fz1Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Setting.getSetting")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 G = fz1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                fz1 fz1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof fz1)) {
                    fz1Var = (fz1) obj;
                } else {
                    fz1Var = new fz1(this.mSwanApiContext);
                    this.mApis.put("-594895721", fz1Var);
                }
                Pair<Boolean, f12> a = h12.a(fz1Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Setting.getSwanId")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 I = fz1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                fz1 fz1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof fz1)) {
                    fz1Var = (fz1) obj;
                } else {
                    fz1Var = new fz1(this.mSwanApiContext);
                    this.mApis.put("-594895721", fz1Var);
                }
                Pair<Boolean, f12> a = h12.a(fz1Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Setting.getUserInfo")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 J = fz1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                dg3 dg3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof dg3)) {
                    dg3Var = (dg3) obj;
                } else {
                    dg3Var = new dg3(this.mSwanApiContext);
                    this.mApis.put("712777136", dg3Var);
                }
                Pair<Boolean, f12> a = h12.a(dg3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = dg3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naStorage", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                iz1 iz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof iz1)) {
                    iz1Var = (iz1) obj;
                } else {
                    iz1Var = new iz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", iz1Var);
                }
                Pair<Boolean, f12> a = h12.a(iz1Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = iz1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                iz1 iz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof iz1)) {
                    iz1Var = (iz1) obj;
                } else {
                    iz1Var = new iz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", iz1Var);
                }
                Pair<Boolean, f12> a = h12.a(iz1Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorageSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 C = iz1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                hz1 hz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("130910081", hz1Var);
                }
                Pair<Boolean, f12> a = h12.a(hz1Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.clearStorage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = hz1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                hz1 hz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("130910081", hz1Var);
                }
                Pair<Boolean, f12> a = h12.a(hz1Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.clearStorageSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 C = hz1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                iz1 iz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof iz1)) {
                    iz1Var = (iz1) obj;
                } else {
                    iz1Var = new iz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", iz1Var);
                }
                Pair<Boolean, f12> a = h12.a(iz1Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfo")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 G = iz1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                iz1 iz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof iz1)) {
                    iz1Var = (iz1) obj;
                } else {
                    iz1Var = new iz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", iz1Var);
                }
                Pair<Boolean, f12> a = h12.a(iz1Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfoSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 J = iz1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                hz1 hz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("130910081", hz1Var);
                }
                Pair<Boolean, f12> a = h12.a(hz1Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.getStorageInfo")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 G = hz1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                hz1 hz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("130910081", hz1Var);
                }
                Pair<Boolean, f12> a = h12.a(hz1Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.getStorageInfoSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 J = hz1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                iz1 iz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof iz1)) {
                    iz1Var = (iz1) obj;
                } else {
                    iz1Var = new iz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", iz1Var);
                }
                Pair<Boolean, f12> a = h12.a(iz1Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 D = iz1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                iz1 iz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof iz1)) {
                    iz1Var = (iz1) obj;
                } else {
                    iz1Var = new iz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", iz1Var);
                }
                Pair<Boolean, f12> a = h12.a(iz1Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 K = iz1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                hz1 hz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("130910081", hz1Var);
                }
                Pair<Boolean, f12> a = h12.a(hz1Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.getStorage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 D = hz1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                hz1 hz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("130910081", hz1Var);
                }
                Pair<Boolean, f12> a = h12.a(hz1Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.getStorageInfoAsync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 H = hz1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                hz1 hz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("130910081", hz1Var);
                }
                Pair<Boolean, f12> a = h12.a(hz1Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.getStorageSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 K = hz1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                iz1 iz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof iz1)) {
                    iz1Var = (iz1) obj;
                } else {
                    iz1Var = new iz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", iz1Var);
                }
                Pair<Boolean, f12> a = h12.a(iz1Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 R = iz1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                iz1 iz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof iz1)) {
                    iz1Var = (iz1) obj;
                } else {
                    iz1Var = new iz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", iz1Var);
                }
                Pair<Boolean, f12> a = h12.a(iz1Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorageSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 T = iz1Var.T(str);
                if (T == null) {
                    return "";
                }
                return T.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                hz1 hz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("130910081", hz1Var);
                }
                Pair<Boolean, f12> a = h12.a(hz1Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.removeStorage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 R = hz1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                hz1 hz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("130910081", hz1Var);
                }
                Pair<Boolean, f12> a = h12.a(hz1Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.removeStorageSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 T = hz1Var.T(str);
                if (T == null) {
                    return "";
                }
                return T.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                iz1 iz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof iz1)) {
                    iz1Var = (iz1) obj;
                } else {
                    iz1Var = new iz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", iz1Var);
                }
                Pair<Boolean, f12> a = h12.a(iz1Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.setGlobalStorage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 U = iz1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                iz1 iz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof iz1)) {
                    iz1Var = (iz1) obj;
                } else {
                    iz1Var = new iz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", iz1Var);
                }
                Pair<Boolean, f12> a = h12.a(iz1Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.setGlobalStorageSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 W = iz1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                hz1 hz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("130910081", hz1Var);
                }
                Pair<Boolean, f12> a = h12.a(hz1Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.setStorage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 U = hz1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                hz1 hz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("130910081", hz1Var);
                }
                Pair<Boolean, f12> a = h12.a(hz1Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Storage.setStorageSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 W = hz1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }
        });
        hashMap.put("_naSubscription", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                kz1 kz1Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof kz1)) {
                    kz1Var = (kz1) obj;
                } else {
                    kz1Var = new kz1(this.mSwanApiContext);
                    this.mApis.put("823117982", kz1Var);
                }
                Pair<Boolean, f12> a = h12.a(kz1Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Subscription.requestSubscribeFormId")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 E = kz1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                lz1 lz1Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof lz1)) {
                    lz1Var = (lz1) obj;
                } else {
                    lz1Var = new lz1(this.mSwanApiContext);
                    this.mApis.put("-947445811", lz1Var);
                }
                Pair<Boolean, f12> a = h12.a(lz1Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Subscription.subscribeService")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 F = lz1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }
        });
        hashMap.put("_naSystem", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                sz1 sz1Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof sz1)) {
                    sz1Var = (sz1) obj;
                } else {
                    sz1Var = new sz1(this.mSwanApiContext);
                    this.mApis.put("1936205521", sz1Var);
                }
                Pair<Boolean, f12> a = h12.a(sz1Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.exitFullScreen")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = sz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                rz1 rz1Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof rz1)) {
                    rz1Var = (rz1) obj;
                } else {
                    rz1Var = new rz1(this.mSwanApiContext);
                    this.mApis.put("1694151270", rz1Var);
                }
                Pair<Boolean, f12> a = h12.a(rz1Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.getDeviceInfo")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = rz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                tz1 tz1Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof tz1)) {
                    tz1Var = (tz1) obj;
                } else {
                    tz1Var = new tz1(this.mSwanApiContext);
                    this.mApis.put("-1321681619", tz1Var);
                }
                Pair<Boolean, f12> a = h12.a(tz1Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.getDeviceProfile")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = tz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                uz1 uz1Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof uz1)) {
                    uz1Var = (uz1) obj;
                } else {
                    uz1Var = new uz1(this.mSwanApiContext);
                    this.mApis.put("-1569246082", uz1Var);
                }
                Pair<Boolean, f12> a = h12.a(uz1Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.makePhoneCall")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = uz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                wz1 wz1Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof wz1)) {
                    wz1Var = (wz1) obj;
                } else {
                    wz1Var = new wz1(this.mSwanApiContext);
                    this.mApis.put("1099851202", wz1Var);
                }
                Pair<Boolean, f12> a = h12.a(wz1Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.openSMSPanel")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = wz1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                vz1 vz1Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof vz1)) {
                    vz1Var = (vz1) obj;
                } else {
                    vz1Var = new vz1(this.mSwanApiContext);
                    this.mApis.put("-1707203360", vz1Var);
                }
                Pair<Boolean, f12> a = h12.a(vz1Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.requestFullScreen")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 F = vz1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                pz1 pz1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof pz1)) {
                    pz1Var = (pz1) obj;
                } else {
                    pz1Var = new pz1(this.mSwanApiContext);
                    this.mApis.put("-518757484", pz1Var);
                }
                Pair<Boolean, f12> a = h12.a(pz1Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.setClipboardData")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = pz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                zy2 zy2Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof zy2)) {
                    zy2Var = (zy2) obj;
                } else {
                    zy2Var = new zy2(this.mSwanApiContext);
                    this.mApis.put("1161486049", zy2Var);
                }
                Pair<Boolean, f12> a = h12.a(zy2Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.setErrorPageType")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = zy2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                zz1 zz1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof zz1)) {
                    zz1Var = (zz1) obj;
                } else {
                    zz1Var = new zz1(this.mSwanApiContext);
                    this.mApis.put("447234992", zz1Var);
                }
                Pair<Boolean, f12> a = h12.a(zz1Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.setMediaVolume")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 z = zz1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                nz1 nz1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("1372680763", nz1Var);
                }
                Pair<Boolean, f12> a = h12.a(nz1Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.startAccelerometer")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = nz1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                qz1 qz1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof qz1)) {
                    qz1Var = (qz1) obj;
                } else {
                    qz1Var = new qz1(this.mSwanApiContext);
                    this.mApis.put("1689255576", qz1Var);
                }
                Pair<Boolean, f12> a = h12.a(qz1Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.startCompass")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = qz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                oz1 oz1Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof oz1)) {
                    oz1Var = (oz1) obj;
                } else {
                    oz1Var = new oz1(this.mSwanApiContext);
                    this.mApis.put("99997465", oz1Var);
                }
                Pair<Boolean, f12> a = h12.a(oz1Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.getBrightness")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = oz1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                pz1 pz1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof pz1)) {
                    pz1Var = (pz1) obj;
                } else {
                    pz1Var = new pz1(this.mSwanApiContext);
                    this.mApis.put("-518757484", pz1Var);
                }
                Pair<Boolean, f12> a = h12.a(pz1Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.getClipboardData")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = pz1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                zz1 zz1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof zz1)) {
                    zz1Var = (zz1) obj;
                } else {
                    zz1Var = new zz1(this.mSwanApiContext);
                    this.mApis.put("447234992", zz1Var);
                }
                Pair<Boolean, f12> a = h12.a(zz1Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.getMediaVolume")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = zz1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                nz1 nz1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("1372680763", nz1Var);
                }
                Pair<Boolean, f12> a = h12.a(nz1Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.stopAccelerometer")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 B = nz1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                qz1 qz1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof qz1)) {
                    qz1Var = (qz1) obj;
                } else {
                    qz1Var = new qz1(this.mSwanApiContext);
                    this.mApis.put("1689255576", qz1Var);
                }
                Pair<Boolean, f12> a = h12.a(qz1Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "System.stopCompass")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 z = qz1Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naUtils", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                k02 k02Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof k02)) {
                    k02Var = (k02) obj;
                } else {
                    k02Var = new k02(this.mSwanApiContext);
                    this.mApis.put("201194468", k02Var);
                }
                Pair<Boolean, f12> a = h12.a(k02Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.addToDesktop")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 B = k02Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                g02 g02Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof g02)) {
                    g02Var = (g02) obj;
                } else {
                    g02Var = new g02(this.mSwanApiContext);
                    this.mApis.put("-1412306947", g02Var);
                }
                Pair<Boolean, f12> a = h12.a(g02Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.calcMD5")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = g02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                h02 h02Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof h02)) {
                    h02Var = (h02) obj;
                } else {
                    h02Var = new h02(this.mSwanApiContext);
                    this.mApis.put("1626415364", h02Var);
                }
                Pair<Boolean, f12> a = h12.a(h02Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.checkAppInstalled")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = h02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                j02 j02Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof j02)) {
                    j02Var = (j02) obj;
                } else {
                    j02Var = new j02(this.mSwanApiContext);
                    this.mApis.put("-836768778", j02Var);
                }
                Pair<Boolean, f12> a = h12.a(j02Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfo")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = j02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                l02 l02Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof l02)) {
                    l02Var = (l02) obj;
                } else {
                    l02Var = new l02(this.mSwanApiContext);
                    this.mApis.put("-810858308", l02Var);
                }
                Pair<Boolean, f12> a = h12.a(l02Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.getPerformanceLevel")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = l02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                p02 p02Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof p02)) {
                    p02Var = (p02) obj;
                } else {
                    p02Var = new p02(this.mSwanApiContext);
                    this.mApis.put("-1011537871", p02Var);
                }
                Pair<Boolean, f12> a = h12.a(p02Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.getSystemInfoAsync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 I = p02Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                m02 m02Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof m02)) {
                    m02Var = (m02) obj;
                } else {
                    m02Var = new m02(this.mSwanApiContext);
                    this.mApis.put("-2097727681", m02Var);
                }
                Pair<Boolean, f12> a = h12.a(m02Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.handleException")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = m02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                i02 i02Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof i02)) {
                    i02Var = (i02) obj;
                } else {
                    i02Var = new i02(this.mSwanApiContext);
                    this.mApis.put("2084449317", i02Var);
                }
                Pair<Boolean, f12> a = h12.a(i02Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.hasCloseHandler")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = i02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                ld3 ld3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof ld3)) {
                    ld3Var = (ld3) obj;
                } else {
                    ld3Var = new ld3(this.mSwanApiContext);
                    this.mApis.put("1031678042", ld3Var);
                }
                Pair<Boolean, f12> a = h12.a(ld3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.hideCaptureScreenShareDialog")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 x = ld3Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                n02 n02Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof n02)) {
                    n02Var = (n02) obj;
                } else {
                    n02Var = new n02(this.mSwanApiContext);
                    this.mApis.put("1751900130", n02Var);
                }
                Pair<Boolean, f12> a = h12.a(n02Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.logToFile")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = n02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                mc3 mc3Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof mc3)) {
                    mc3Var = (mc3) obj;
                } else {
                    mc3Var = new mc3(this.mSwanApiContext);
                    this.mApis.put("1748196865", mc3Var);
                }
                Pair<Boolean, f12> a = h12.a(mc3Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.preloadPackage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = mc3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                o02 o02Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof o02)) {
                    o02Var = (o02) obj;
                } else {
                    o02Var = new o02(this.mSwanApiContext);
                    this.mApis.put("589529211", o02Var);
                }
                Pair<Boolean, f12> a = h12.a(o02Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.previewImage")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 B = o02Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                r02 r02Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof r02)) {
                    r02Var = (r02) obj;
                } else {
                    r02Var = new r02(this.mSwanApiContext);
                    this.mApis.put("-577481801", r02Var);
                }
                Pair<Boolean, f12> a = h12.a(r02Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.ubcFlowJar")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 I = r02Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                p02 p02Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof p02)) {
                    p02Var = (p02) obj;
                } else {
                    p02Var = new p02(this.mSwanApiContext);
                    this.mApis.put("-1011537871", p02Var);
                }
                Pair<Boolean, f12> a = h12.a(p02Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfoSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 E = p02Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                p02 p02Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof p02)) {
                    p02Var = (p02) obj;
                } else {
                    p02Var = new p02(this.mSwanApiContext);
                    this.mApis.put("-1011537871", p02Var);
                }
                Pair<Boolean, f12> a = h12.a(p02Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.getSystemInfo")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 H = p02Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                p02 p02Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof p02)) {
                    p02Var = (p02) obj;
                } else {
                    p02Var = new p02(this.mSwanApiContext);
                    this.mApis.put("-1011537871", p02Var);
                }
                Pair<Boolean, f12> a = h12.a(p02Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Utils.getSystemInfoSync")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 J = p02Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naWifi", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                wj3 wj3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof wj3)) {
                    wj3Var = (wj3) obj;
                } else {
                    wj3Var = new wj3(this.mSwanApiContext);
                    this.mApis.put("1879401452", wj3Var);
                }
                Pair<Boolean, f12> a = h12.a(wj3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Wifi.connectWifi")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 A = wj3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                wj3 wj3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof wj3)) {
                    wj3Var = (wj3) obj;
                } else {
                    wj3Var = new wj3(this.mSwanApiContext);
                    this.mApis.put("1879401452", wj3Var);
                }
                Pair<Boolean, f12> a = h12.a(wj3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Wifi.getConnectedWifi")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 B = wj3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                wj3 wj3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof wj3)) {
                    wj3Var = (wj3) obj;
                } else {
                    wj3Var = new wj3(this.mSwanApiContext);
                    this.mApis.put("1879401452", wj3Var);
                }
                Pair<Boolean, f12> a = h12.a(wj3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Wifi.getWifiList")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 C = wj3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                wj3 wj3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof wj3)) {
                    wj3Var = (wj3) obj;
                } else {
                    wj3Var = new wj3(this.mSwanApiContext);
                    this.mApis.put("1879401452", wj3Var);
                }
                Pair<Boolean, f12> a = h12.a(wj3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Wifi.startWifi")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 G = wj3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                wj3 wj3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof wj3)) {
                    wj3Var = (wj3) obj;
                } else {
                    wj3Var = new wj3(this.mSwanApiContext);
                    this.mApis.put("1879401452", wj3Var);
                }
                Pair<Boolean, f12> a = h12.a(wj3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "Wifi.stopWifi")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 H = wj3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }
}
