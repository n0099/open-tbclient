package com.baidu.swan.apps.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.tieba.aa2;
import com.baidu.tieba.aw1;
import com.baidu.tieba.ax1;
import com.baidu.tieba.ay1;
import com.baidu.tieba.az1;
import com.baidu.tieba.b33;
import com.baidu.tieba.bw1;
import com.baidu.tieba.by1;
import com.baidu.tieba.bz1;
import com.baidu.tieba.cw1;
import com.baidu.tieba.cy1;
import com.baidu.tieba.cz1;
import com.baidu.tieba.dw1;
import com.baidu.tieba.dy1;
import com.baidu.tieba.ey1;
import com.baidu.tieba.ez1;
import com.baidu.tieba.fw1;
import com.baidu.tieba.fy1;
import com.baidu.tieba.g03;
import com.baidu.tieba.gx1;
import com.baidu.tieba.gy1;
import com.baidu.tieba.hw1;
import com.baidu.tieba.hx1;
import com.baidu.tieba.hy1;
import com.baidu.tieba.iw1;
import com.baidu.tieba.iy1;
import com.baidu.tieba.ji3;
import com.baidu.tieba.jv1;
import com.baidu.tieba.jy1;
import com.baidu.tieba.ko1;
import com.baidu.tieba.kx2;
import com.baidu.tieba.lw1;
import com.baidu.tieba.lx1;
import com.baidu.tieba.ma2;
import com.baidu.tieba.mx1;
import com.baidu.tieba.mx2;
import com.baidu.tieba.my1;
import com.baidu.tieba.nw1;
import com.baidu.tieba.nx1;
import com.baidu.tieba.ow1;
import com.baidu.tieba.ox1;
import com.baidu.tieba.oy1;
import com.baidu.tieba.pw1;
import com.baidu.tieba.px1;
import com.baidu.tieba.q03;
import com.baidu.tieba.qe3;
import com.baidu.tieba.qw1;
import com.baidu.tieba.rw1;
import com.baidu.tieba.rx1;
import com.baidu.tieba.rz1;
import com.baidu.tieba.sw1;
import com.baidu.tieba.sx1;
import com.baidu.tieba.sz1;
import com.baidu.tieba.tw1;
import com.baidu.tieba.ty1;
import com.baidu.tieba.tz1;
import com.baidu.tieba.ub2;
import com.baidu.tieba.uv1;
import com.baidu.tieba.uw1;
import com.baidu.tieba.ux1;
import com.baidu.tieba.uy1;
import com.baidu.tieba.uz1;
import com.baidu.tieba.vw1;
import com.baidu.tieba.vx1;
import com.baidu.tieba.vy1;
import com.baidu.tieba.wj3;
import com.baidu.tieba.wk2;
import com.baidu.tieba.wv1;
import com.baidu.tieba.ww1;
import com.baidu.tieba.wy1;
import com.baidu.tieba.xv1;
import com.baidu.tieba.xw1;
import com.baidu.tieba.xx1;
import com.baidu.tieba.xy1;
import com.baidu.tieba.yb3;
import com.baidu.tieba.yx1;
import com.baidu.tieba.yy1;
import com.baidu.tieba.za3;
import com.baidu.tieba.zv1;
import com.baidu.tieba.zy1;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
@Keep
/* loaded from: classes3.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final uv1 uv1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                aw1 aw1Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof aw1)) {
                    aw1Var = (aw1) obj;
                } else {
                    aw1Var = new aw1(this.mSwanApiContext);
                    this.mApis.put("1930258908", aw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(aw1Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Account.checkSession")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = aw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                bw1 bw1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof bw1)) {
                    bw1Var = (bw1) obj;
                } else {
                    bw1Var = new bw1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", bw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(bw1Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Account.getLoginCode")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 C = bw1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                cw1 cw1Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof cw1)) {
                    cw1Var = (cw1) obj;
                } else {
                    cw1Var = new cw1(this.mSwanApiContext);
                    this.mApis.put("1754780133", cw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(cw1Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Account.getOpenId")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = cw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                jv1 jv1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof jv1)) {
                    jv1Var = (jv1) obj;
                } else {
                    jv1Var = new jv1(this.mSwanApiContext);
                    this.mApis.put("-343998465", jv1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(jv1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Account.getUnionBDUSS")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = jv1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String login(String str) {
                bw1 bw1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof bw1)) {
                    bw1Var = (bw1) obj;
                } else {
                    bw1Var = new bw1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", bw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(bw1Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Account.login")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 I = bw1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                zv1 zv1Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof zv1)) {
                    zv1Var = (zv1) obj;
                } else {
                    zv1Var = new zv1(this.mSwanApiContext);
                    this.mApis.put("-337742792", zv1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(zv1Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Account.isBaiduAccountSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = zv1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                bw1 bw1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof bw1)) {
                    bw1Var = (bw1) obj;
                } else {
                    bw1Var = new bw1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", bw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(bw1Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Account.isLoginSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 H = bw1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBasic", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                dw1 dw1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof dw1)) {
                    dw1Var = (dw1) obj;
                } else {
                    dw1Var = new dw1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", dw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(dw1Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Basic.loadSubPackage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 F = dw1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                dw1 dw1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof dw1)) {
                    dw1Var = (dw1) obj;
                } else {
                    dw1Var = new dw1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", dw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(dw1Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Basic.loadSubPackages")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 G = dw1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                ko1 ko1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ko1)) {
                    ko1Var = (ko1) obj;
                } else {
                    ko1Var = new ko1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ko1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ko1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Bookshelf.deleteBookshelf")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 K = ko1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                ko1 ko1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ko1)) {
                    ko1Var = (ko1) obj;
                } else {
                    ko1Var = new ko1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ko1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ko1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Bookshelf.insertBookshelf")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 P = ko1Var.P(str);
                if (P == null) {
                    return "";
                }
                return P.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                ko1 ko1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ko1)) {
                    ko1Var = (ko1) obj;
                } else {
                    ko1Var = new ko1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ko1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ko1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Bookshelf.navigateToBookshelf")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 U = ko1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                ko1 ko1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ko1)) {
                    ko1Var = (ko1) obj;
                } else {
                    ko1Var = new ko1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ko1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ko1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Bookshelf.queryBookshelf")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 V = ko1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                ko1 ko1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ko1)) {
                    ko1Var = (ko1) obj;
                } else {
                    ko1Var = new ko1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ko1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ko1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Bookshelf.updateBookshelfReadTime")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 X = ko1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naCoupon", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                xv1 xv1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof xv1)) {
                    xv1Var = (xv1) obj;
                } else {
                    xv1Var = new xv1(this.mSwanApiContext);
                    this.mApis.put("-277316359", xv1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(xv1Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Coupon.getPlatformCoupons")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = xv1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                xv1 xv1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof xv1)) {
                    xv1Var = (xv1) obj;
                } else {
                    xv1Var = new xv1(this.mSwanApiContext);
                    this.mApis.put("-277316359", xv1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(xv1Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Coupon.getUserCoupons")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 z = xv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                xv1 xv1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof xv1)) {
                    xv1Var = (xv1) obj;
                } else {
                    xv1Var = new xv1(this.mSwanApiContext);
                    this.mApis.put("-277316359", xv1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(xv1Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Coupon.takeCoupons")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 C = xv1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naFavorite", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                fw1 fw1Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof fw1)) {
                    fw1Var = (fw1) obj;
                } else {
                    fw1Var = new fw1(this.mSwanApiContext);
                    this.mApis.put("-1225406515", fw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(fw1Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Favorite.getFavorStatus")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = fw1Var.x(str);
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
                Pair<Boolean, sz1> a = uz1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Favorite.showFavoriteGuide")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 G = showFavoriteGuideApi.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naFile", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                hw1 hw1Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof hw1)) {
                    hw1Var = (hw1) obj;
                } else {
                    hw1Var = new hw1(this.mSwanApiContext);
                    this.mApis.put("-2057135077", hw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(hw1Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "File.shareFile")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = hw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                wk2 wk2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof wk2)) {
                    wk2Var = (wk2) obj;
                } else {
                    wk2Var = new wk2(this.mSwanApiContext);
                    this.mApis.put("2077414795", wk2Var);
                }
                Pair<Boolean, sz1> a = uz1.a(wk2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = wk2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                wk2 wk2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof wk2)) {
                    wk2Var = (wk2) obj;
                } else {
                    wk2Var = new wk2(this.mSwanApiContext);
                    this.mApis.put("2077414795", wk2Var);
                }
                Pair<Boolean, sz1> a = uz1.a(wk2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessageSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = wk2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String download(String str) {
                iw1 iw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", iw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(iw1Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "HostDownloadManager.download")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = iw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                iw1 iw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", iw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(iw1Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "HostDownloadManager.openFile")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 z = iw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String query(String str) {
                iw1 iw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", iw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(iw1Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "HostDownloadManager.query")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 query = iw1Var.query(str);
                if (query == null) {
                    return "";
                }
                return query.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                iw1 iw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", iw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(iw1Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "HostDownloadManager.openDownloadCenter")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = iw1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naImage", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                kx2 kx2Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof kx2)) {
                    kx2Var = (kx2) obj;
                } else {
                    kx2Var = new kx2(this.mSwanApiContext);
                    this.mApis.put("1445003743", kx2Var);
                }
                Pair<Boolean, sz1> a = uz1.a(kx2Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Image.callImageMenu")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = kx2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                lw1 lw1Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof lw1)) {
                    lw1Var = (lw1) obj;
                } else {
                    lw1Var = new lw1(this.mSwanApiContext);
                    this.mApis.put("-1252730367", lw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(lw1Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Image.compressImage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = lw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naInteraction", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", tw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(tw1Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.closeTabBar")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = tw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", tw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(tw1Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.closeTabBarRedDot")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = tw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                pw1 pw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof pw1)) {
                    pw1Var = (pw1) obj;
                } else {
                    pw1Var = new pw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", pw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(pw1Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.hideNavigationBarLoading")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = pw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                rw1 rw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", rw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(rw1Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.openMultiPicker")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 G = rw1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                rw1 rw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", rw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(rw1Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.openPicker")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 H = rw1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", tw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(tw1Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.openTabBar")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 C = tw1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                qw1 qw1Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof qw1)) {
                    qw1Var = (qw1) obj;
                } else {
                    qw1Var = new qw1(this.mSwanApiContext);
                    this.mApis.put("-1750613704", qw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(qw1Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.pageScrollTo")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = qw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                pw1 pw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof pw1)) {
                    pw1Var = (pw1) obj;
                } else {
                    pw1Var = new pw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", pw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(pw1Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarColor")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 z = pw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                pw1 pw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof pw1)) {
                    pw1Var = (pw1) obj;
                } else {
                    pw1Var = new pw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", pw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(pw1Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarTitle")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = pw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", tw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(tw1Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.setTabBarItem")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 D = tw1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                rw1 rw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", rw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(rw1Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.showDatePickerView")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 L = rw1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                vw1 vw1Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("1172469410", vw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(vw1Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.showHalfScreenWebview")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 K = vw1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                nw1 nw1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof nw1)) {
                    nw1Var = (nw1) obj;
                } else {
                    nw1Var = new nw1(this.mSwanApiContext);
                    this.mApis.put("5236036", nw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(nw1Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.showLoading")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = nw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                ow1 ow1Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof ow1)) {
                    ow1Var = (ow1) obj;
                } else {
                    ow1Var = new ow1(this.mSwanApiContext);
                    this.mApis.put("1913747800", ow1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ow1Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.showModal")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = ow1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                pw1 pw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof pw1)) {
                    pw1Var = (pw1) obj;
                } else {
                    pw1Var = new pw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", pw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(pw1Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.showNavigationBarLoading")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 B = pw1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                uw1 uw1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof uw1)) {
                    uw1Var = (uw1) obj;
                } else {
                    uw1Var = new uw1(this.mSwanApiContext);
                    this.mApis.put("1159492510", uw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(uw1Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.showToast")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 Q = uw1Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                sw1 sw1Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof sw1)) {
                    sw1Var = (sw1) obj;
                } else {
                    sw1Var = new sw1(this.mSwanApiContext);
                    this.mApis.put("1165118609", sw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(sw1Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.stopPullDownRefresh")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = sw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                rw1 rw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", rw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(rw1Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.updateMultiPicker")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 M = rw1Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                nw1 nw1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof nw1)) {
                    nw1Var = (nw1) obj;
                } else {
                    nw1Var = new nw1(this.mSwanApiContext);
                    this.mApis.put("5236036", nw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(nw1Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.hideLoading")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = nw1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hideToast() {
                uw1 uw1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof uw1)) {
                    uw1Var = (uw1) obj;
                } else {
                    uw1Var = new uw1(this.mSwanApiContext);
                    this.mApis.put("1159492510", uw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(uw1Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.hideToast")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 K = uw1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                ww1 ww1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof ww1)) {
                    ww1Var = (ww1) obj;
                } else {
                    ww1Var = new ww1(this.mSwanApiContext);
                    this.mApis.put("-137346255", ww1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ww1Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Keyboard.startKeyboardHeightChange")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 C = ww1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                ww1 ww1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof ww1)) {
                    ww1Var = (ww1) obj;
                } else {
                    ww1Var = new ww1(this.mSwanApiContext);
                    this.mApis.put("-137346255", ww1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ww1Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Keyboard.stopKeyboardHeightChange")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 D = ww1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naLocationService", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                xw1 xw1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof xw1)) {
                    xw1Var = (xw1) obj;
                } else {
                    xw1Var = new xw1(this.mSwanApiContext);
                    this.mApis.put("-397373095", xw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(xw1Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "LocationService.getLocation")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = xw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                xw1 xw1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof xw1)) {
                    xw1Var = (xw1) obj;
                } else {
                    xw1Var = new xw1(this.mSwanApiContext);
                    this.mApis.put("-397373095", xw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(xw1Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "LocationService.startLocationUpdate")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = xw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                xw1 xw1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof xw1)) {
                    xw1Var = (xw1) obj;
                } else {
                    xw1Var = new xw1(this.mSwanApiContext);
                    this.mApis.put("-397373095", xw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(xw1Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "LocationService.stopLocationUpdate")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 B = xw1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naMenu", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                oy1 oy1Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof oy1)) {
                    oy1Var = (oy1) obj;
                } else {
                    oy1Var = new oy1(this.mSwanApiContext);
                    this.mApis.put("538070032", oy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(oy1Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = oy1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naNetwork", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                ax1 ax1Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof ax1)) {
                    ax1Var = (ax1) obj;
                } else {
                    ax1Var = new ax1(this.mSwanApiContext);
                    this.mApis.put("-1076509454", ax1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ax1Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Network.callService")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = ax1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                hx1 hx1Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof hx1)) {
                    hx1Var = (hx1) obj;
                } else {
                    hx1Var = new hx1(this.mSwanApiContext);
                    this.mApis.put("968563034", hx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(hx1Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Network.cancelRequest")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 D = hx1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                gx1 gx1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof gx1)) {
                    gx1Var = (gx1) obj;
                } else {
                    gx1Var = new gx1(this.mSwanApiContext);
                    this.mApis.put("453220699", gx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(gx1Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Network.networkStatusChange")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = gx1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                gx1 gx1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof gx1)) {
                    gx1Var = (gx1) obj;
                } else {
                    gx1Var = new gx1(this.mSwanApiContext);
                    this.mApis.put("453220699", gx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(gx1Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Network.getNetworkType")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = gx1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(JsObject jsObject) {
                hx1 hx1Var;
                String a;
                try {
                    rz1.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof hx1)) {
                        hx1Var = (hx1) obj;
                    } else {
                        hx1Var = new hx1(this.mSwanApiContext);
                        this.mApis.put("968563034", hx1Var);
                    }
                    Pair<Boolean, sz1> a2 = uz1.a(hx1Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((sz1) a2.second).a();
                    } else if (aa2.a(this.mSwanApiContext.f(), "Network.request")) {
                        a = new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<sz1, JSONObject> t = wv1.t(jsObject);
                        if (!((sz1) t.first).isSuccess()) {
                            a = ((sz1) t.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) t.second;
                            if (jSONObject == null) {
                                a = sz1.a.a();
                            } else {
                                tz1 V = hx1Var.V(jSONObject);
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
                        rz1.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                q03 q03Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof q03)) {
                    q03Var = (q03) obj;
                } else {
                    q03Var = new q03(this.mSwanApiContext);
                    this.mApis.put("-336396851", q03Var);
                }
                Pair<Boolean, sz1> a = uz1.a(q03Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Payment.chooseCoupon")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = q03Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                q03 q03Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof q03)) {
                    q03Var = (q03) obj;
                } else {
                    q03Var = new q03(this.mSwanApiContext);
                    this.mApis.put("-336396851", q03Var);
                }
                Pair<Boolean, sz1> a = uz1.a(q03Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Payment.getPaymentInfo")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = q03Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                g03 g03Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof g03)) {
                    g03Var = (g03) obj;
                } else {
                    g03Var = new g03(this.mSwanApiContext);
                    this.mApis.put("1854689529", g03Var);
                }
                Pair<Boolean, sz1> a = uz1.a(g03Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Payment.requestThirdPayment")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = g03Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                q03 q03Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof q03)) {
                    q03Var = (q03) obj;
                } else {
                    q03Var = new q03(this.mSwanApiContext);
                    this.mApis.put("-336396851", q03Var);
                }
                Pair<Boolean, sz1> a = uz1.a(q03Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Payment.setPaymentInfo")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 z = q03Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPlugin", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                b33 b33Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof b33)) {
                    b33Var = (b33) obj;
                } else {
                    b33Var = new b33(this.mSwanApiContext);
                    this.mApis.put("-254510461", b33Var);
                }
                Pair<Boolean, sz1> a = uz1.a(b33Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Plugin.invokePluginChooseAddress")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = b33Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                b33 b33Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof b33)) {
                    b33Var = (b33) obj;
                } else {
                    b33Var = new b33(this.mSwanApiContext);
                    this.mApis.put("-254510461", b33Var);
                }
                Pair<Boolean, sz1> a = uz1.a(b33Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 z = b33Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                b33 b33Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof b33)) {
                    b33Var = (b33) obj;
                } else {
                    b33Var = new b33(this.mSwanApiContext);
                    this.mApis.put("-254510461", b33Var);
                }
                Pair<Boolean, sz1> a = uz1.a(b33Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Plugin.invokePluginPayment")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = b33Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                ub2 ub2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof ub2)) {
                    ub2Var = (ub2) obj;
                } else {
                    ub2Var = new ub2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", ub2Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ub2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Prefetch.prefetchResources")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = ub2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPreload", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                ma2 ma2Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof ma2)) {
                    ma2Var = (ma2) obj;
                } else {
                    ma2Var = new ma2(this.mSwanApiContext);
                    this.mApis.put("423661539", ma2Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ma2Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Preload.preloadStatus")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = ma2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                wj3 wj3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof wj3)) {
                    wj3Var = (wj3) obj;
                } else {
                    wj3Var = new wj3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", wj3Var);
                }
                Pair<Boolean, sz1> a = uz1.a(wj3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "PrivateFile.uploadFileToBos")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 C = wj3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naRouter", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                lx1 lx1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof lx1)) {
                    lx1Var = (lx1) obj;
                } else {
                    lx1Var = new lx1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", lx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(lx1Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Router.hideModalPage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = lx1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                lx1 lx1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof lx1)) {
                    lx1Var = (lx1) obj;
                } else {
                    lx1Var = new lx1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", lx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(lx1Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Router.navigateBack")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 B = lx1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                mx1 mx1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof mx1)) {
                    mx1Var = (mx1) obj;
                } else {
                    mx1Var = new mx1(this.mSwanApiContext);
                    this.mApis.put("1968522584", mx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(mx1Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Router.navigateTo")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 H = mx1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                ox1 ox1Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof ox1)) {
                    ox1Var = (ox1) obj;
                } else {
                    ox1Var = new ox1(this.mSwanApiContext);
                    this.mApis.put("1317280190", ox1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ox1Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Router.reLaunch")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = ox1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                px1 px1Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof px1)) {
                    px1Var = (px1) obj;
                } else {
                    px1Var = new px1(this.mSwanApiContext);
                    this.mApis.put("-420075743", px1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(px1Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Router.reLoadErrorPage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = px1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                nx1 nx1Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof nx1)) {
                    nx1Var = (nx1) obj;
                } else {
                    nx1Var = new nx1(this.mSwanApiContext);
                    this.mApis.put("1792515533", nx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(nx1Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Router.redirectTo")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 D = nx1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                mx1 mx1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof mx1)) {
                    mx1Var = (mx1) obj;
                } else {
                    mx1Var = new mx1(this.mSwanApiContext);
                    this.mApis.put("1968522584", mx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(mx1Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Router.showModalPage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 J = mx1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naSetting", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                sx1 sx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof sx1)) {
                    sx1Var = (sx1) obj;
                } else {
                    sx1Var = new sx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", sx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(sx1Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Setting.getAppInfoSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 F = sx1Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                sx1 sx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof sx1)) {
                    sx1Var = (sx1) obj;
                } else {
                    sx1Var = new sx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", sx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(sx1Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Setting.getSlaveIdSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 H = sx1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                rx1 rx1Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof rx1)) {
                    rx1Var = (rx1) obj;
                } else {
                    rx1Var = new rx1(this.mSwanApiContext);
                    this.mApis.put("450273045", rx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(rx1Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Setting.isAllowedAdOpenAppSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = rx1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                sx1 sx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof sx1)) {
                    sx1Var = (sx1) obj;
                } else {
                    sx1Var = new sx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", sx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(sx1Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Setting.getSetting")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 G = sx1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                sx1 sx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof sx1)) {
                    sx1Var = (sx1) obj;
                } else {
                    sx1Var = new sx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", sx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(sx1Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Setting.getSwanId")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 I = sx1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                sx1 sx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof sx1)) {
                    sx1Var = (sx1) obj;
                } else {
                    sx1Var = new sx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", sx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(sx1Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Setting.getUserInfo")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 J = sx1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                qe3 qe3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof qe3)) {
                    qe3Var = (qe3) obj;
                } else {
                    qe3Var = new qe3(this.mSwanApiContext);
                    this.mApis.put("712777136", qe3Var);
                }
                Pair<Boolean, sz1> a = uz1.a(qe3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = qe3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naStorage", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                vx1 vx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", vx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(vx1Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = vx1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                vx1 vx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", vx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(vx1Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorageSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 C = vx1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                ux1 ux1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("130910081", ux1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ux1Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.clearStorage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = ux1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                ux1 ux1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("130910081", ux1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ux1Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.clearStorageSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 C = ux1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                vx1 vx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", vx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(vx1Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfo")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 G = vx1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                vx1 vx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", vx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(vx1Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfoSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 J = vx1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                ux1 ux1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("130910081", ux1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ux1Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.getStorageInfo")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 G = ux1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                ux1 ux1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("130910081", ux1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ux1Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.getStorageInfoSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 J = ux1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", vx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(vx1Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 D = vx1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", vx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(vx1Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 K = vx1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                ux1 ux1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("130910081", ux1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ux1Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.getStorage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 D = ux1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                ux1 ux1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("130910081", ux1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ux1Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.getStorageInfoAsync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 H = ux1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                ux1 ux1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("130910081", ux1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ux1Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.getStorageSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 K = ux1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", vx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(vx1Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 R = vx1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", vx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(vx1Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorageSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 T = vx1Var.T(str);
                if (T == null) {
                    return "";
                }
                return T.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                ux1 ux1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("130910081", ux1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ux1Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.removeStorage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 R = ux1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                ux1 ux1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("130910081", ux1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ux1Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.removeStorageSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 T = ux1Var.T(str);
                if (T == null) {
                    return "";
                }
                return T.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", vx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(vx1Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.setGlobalStorage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 U = vx1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", vx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(vx1Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.setGlobalStorageSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 W = vx1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                ux1 ux1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("130910081", ux1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ux1Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.setStorage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 U = ux1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                ux1 ux1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("130910081", ux1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ux1Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.setStorageSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 W = ux1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }
        });
        hashMap.put("_naSubscription", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                xx1 xx1Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof xx1)) {
                    xx1Var = (xx1) obj;
                } else {
                    xx1Var = new xx1(this.mSwanApiContext);
                    this.mApis.put("823117982", xx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(xx1Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Subscription.requestSubscribeFormId")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 E = xx1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                yx1 yx1Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("-947445811", yx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(yx1Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Subscription.subscribeService")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 F = yx1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }
        });
        hashMap.put("_naSystem", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                fy1 fy1Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof fy1)) {
                    fy1Var = (fy1) obj;
                } else {
                    fy1Var = new fy1(this.mSwanApiContext);
                    this.mApis.put("1936205521", fy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(fy1Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.exitFullScreen")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = fy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                ey1 ey1Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof ey1)) {
                    ey1Var = (ey1) obj;
                } else {
                    ey1Var = new ey1(this.mSwanApiContext);
                    this.mApis.put("1694151270", ey1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ey1Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.getDeviceInfo")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = ey1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                gy1 gy1Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof gy1)) {
                    gy1Var = (gy1) obj;
                } else {
                    gy1Var = new gy1(this.mSwanApiContext);
                    this.mApis.put("-1321681619", gy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(gy1Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.getDeviceProfile")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = gy1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                hy1 hy1Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof hy1)) {
                    hy1Var = (hy1) obj;
                } else {
                    hy1Var = new hy1(this.mSwanApiContext);
                    this.mApis.put("-1569246082", hy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(hy1Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.makePhoneCall")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = hy1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                jy1 jy1Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof jy1)) {
                    jy1Var = (jy1) obj;
                } else {
                    jy1Var = new jy1(this.mSwanApiContext);
                    this.mApis.put("1099851202", jy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(jy1Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.openSMSPanel")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = jy1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                iy1 iy1Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof iy1)) {
                    iy1Var = (iy1) obj;
                } else {
                    iy1Var = new iy1(this.mSwanApiContext);
                    this.mApis.put("-1707203360", iy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(iy1Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.requestFullScreen")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 F = iy1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                cy1 cy1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof cy1)) {
                    cy1Var = (cy1) obj;
                } else {
                    cy1Var = new cy1(this.mSwanApiContext);
                    this.mApis.put("-518757484", cy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(cy1Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.setClipboardData")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = cy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                mx2 mx2Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof mx2)) {
                    mx2Var = (mx2) obj;
                } else {
                    mx2Var = new mx2(this.mSwanApiContext);
                    this.mApis.put("1161486049", mx2Var);
                }
                Pair<Boolean, sz1> a = uz1.a(mx2Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.setErrorPageType")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = mx2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                my1 my1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof my1)) {
                    my1Var = (my1) obj;
                } else {
                    my1Var = new my1(this.mSwanApiContext);
                    this.mApis.put("447234992", my1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(my1Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.setMediaVolume")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 z = my1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                ay1 ay1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof ay1)) {
                    ay1Var = (ay1) obj;
                } else {
                    ay1Var = new ay1(this.mSwanApiContext);
                    this.mApis.put("1372680763", ay1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ay1Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.startAccelerometer")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = ay1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                dy1 dy1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof dy1)) {
                    dy1Var = (dy1) obj;
                } else {
                    dy1Var = new dy1(this.mSwanApiContext);
                    this.mApis.put("1689255576", dy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(dy1Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.startCompass")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = dy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                by1 by1Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof by1)) {
                    by1Var = (by1) obj;
                } else {
                    by1Var = new by1(this.mSwanApiContext);
                    this.mApis.put("99997465", by1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(by1Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.getBrightness")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = by1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                cy1 cy1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof cy1)) {
                    cy1Var = (cy1) obj;
                } else {
                    cy1Var = new cy1(this.mSwanApiContext);
                    this.mApis.put("-518757484", cy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(cy1Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.getClipboardData")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = cy1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                my1 my1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof my1)) {
                    my1Var = (my1) obj;
                } else {
                    my1Var = new my1(this.mSwanApiContext);
                    this.mApis.put("447234992", my1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(my1Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.getMediaVolume")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = my1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                ay1 ay1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof ay1)) {
                    ay1Var = (ay1) obj;
                } else {
                    ay1Var = new ay1(this.mSwanApiContext);
                    this.mApis.put("1372680763", ay1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ay1Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.stopAccelerometer")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 B = ay1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                dy1 dy1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof dy1)) {
                    dy1Var = (dy1) obj;
                } else {
                    dy1Var = new dy1(this.mSwanApiContext);
                    this.mApis.put("1689255576", dy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(dy1Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.stopCompass")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 z = dy1Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naUtils", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                xy1 xy1Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof xy1)) {
                    xy1Var = (xy1) obj;
                } else {
                    xy1Var = new xy1(this.mSwanApiContext);
                    this.mApis.put("201194468", xy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(xy1Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.addToDesktop")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 B = xy1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                ty1 ty1Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof ty1)) {
                    ty1Var = (ty1) obj;
                } else {
                    ty1Var = new ty1(this.mSwanApiContext);
                    this.mApis.put("-1412306947", ty1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ty1Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.calcMD5")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = ty1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                uy1 uy1Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof uy1)) {
                    uy1Var = (uy1) obj;
                } else {
                    uy1Var = new uy1(this.mSwanApiContext);
                    this.mApis.put("1626415364", uy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(uy1Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.checkAppInstalled")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = uy1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                wy1 wy1Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof wy1)) {
                    wy1Var = (wy1) obj;
                } else {
                    wy1Var = new wy1(this.mSwanApiContext);
                    this.mApis.put("-836768778", wy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(wy1Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfo")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = wy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                yy1 yy1Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof yy1)) {
                    yy1Var = (yy1) obj;
                } else {
                    yy1Var = new yy1(this.mSwanApiContext);
                    this.mApis.put("-810858308", yy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(yy1Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.getPerformanceLevel")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = yy1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                cz1 cz1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof cz1)) {
                    cz1Var = (cz1) obj;
                } else {
                    cz1Var = new cz1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", cz1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(cz1Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.getSystemInfoAsync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 I = cz1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                zy1 zy1Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof zy1)) {
                    zy1Var = (zy1) obj;
                } else {
                    zy1Var = new zy1(this.mSwanApiContext);
                    this.mApis.put("-2097727681", zy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(zy1Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.handleException")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = zy1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                vy1 vy1Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof vy1)) {
                    vy1Var = (vy1) obj;
                } else {
                    vy1Var = new vy1(this.mSwanApiContext);
                    this.mApis.put("2084449317", vy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(vy1Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.hasCloseHandler")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = vy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                yb3 yb3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof yb3)) {
                    yb3Var = (yb3) obj;
                } else {
                    yb3Var = new yb3(this.mSwanApiContext);
                    this.mApis.put("1031678042", yb3Var);
                }
                Pair<Boolean, sz1> a = uz1.a(yb3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.hideCaptureScreenShareDialog")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = yb3Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                az1 az1Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof az1)) {
                    az1Var = (az1) obj;
                } else {
                    az1Var = new az1(this.mSwanApiContext);
                    this.mApis.put("1751900130", az1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(az1Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.logToFile")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = az1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                za3 za3Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof za3)) {
                    za3Var = (za3) obj;
                } else {
                    za3Var = new za3(this.mSwanApiContext);
                    this.mApis.put("1748196865", za3Var);
                }
                Pair<Boolean, sz1> a = uz1.a(za3Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.preloadPackage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = za3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                bz1 bz1Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof bz1)) {
                    bz1Var = (bz1) obj;
                } else {
                    bz1Var = new bz1(this.mSwanApiContext);
                    this.mApis.put("589529211", bz1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(bz1Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.previewImage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 B = bz1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                ez1 ez1Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof ez1)) {
                    ez1Var = (ez1) obj;
                } else {
                    ez1Var = new ez1(this.mSwanApiContext);
                    this.mApis.put("-577481801", ez1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ez1Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.ubcFlowJar")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 I = ez1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                cz1 cz1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof cz1)) {
                    cz1Var = (cz1) obj;
                } else {
                    cz1Var = new cz1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", cz1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(cz1Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfoSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 E = cz1Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                cz1 cz1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof cz1)) {
                    cz1Var = (cz1) obj;
                } else {
                    cz1Var = new cz1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", cz1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(cz1Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.getSystemInfo")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 H = cz1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                cz1 cz1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof cz1)) {
                    cz1Var = (cz1) obj;
                } else {
                    cz1Var = new cz1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", cz1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(cz1Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.getSystemInfoSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 J = cz1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naWifi", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                ji3 ji3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ji3)) {
                    ji3Var = (ji3) obj;
                } else {
                    ji3Var = new ji3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ji3Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ji3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Wifi.connectWifi")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = ji3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                ji3 ji3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ji3)) {
                    ji3Var = (ji3) obj;
                } else {
                    ji3Var = new ji3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ji3Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ji3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Wifi.getConnectedWifi")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 B = ji3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                ji3 ji3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ji3)) {
                    ji3Var = (ji3) obj;
                } else {
                    ji3Var = new ji3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ji3Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ji3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Wifi.getWifiList")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 C = ji3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                ji3 ji3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ji3)) {
                    ji3Var = (ji3) obj;
                } else {
                    ji3Var = new ji3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ji3Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ji3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Wifi.startWifi")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 G = ji3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                ji3 ji3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ji3)) {
                    ji3Var = (ji3) obj;
                } else {
                    ji3Var = new ji3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ji3Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ji3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Wifi.stopWifi")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 H = ji3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final uv1 uv1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                aw1 aw1Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof aw1)) {
                    aw1Var = (aw1) obj;
                } else {
                    aw1Var = new aw1(this.mSwanApiContext);
                    this.mApis.put("1930258908", aw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(aw1Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Account.checkSession")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = aw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                bw1 bw1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof bw1)) {
                    bw1Var = (bw1) obj;
                } else {
                    bw1Var = new bw1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", bw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(bw1Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Account.getLoginCode")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 C = bw1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                cw1 cw1Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof cw1)) {
                    cw1Var = (cw1) obj;
                } else {
                    cw1Var = new cw1(this.mSwanApiContext);
                    this.mApis.put("1754780133", cw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(cw1Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Account.getOpenId")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = cw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                jv1 jv1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof jv1)) {
                    jv1Var = (jv1) obj;
                } else {
                    jv1Var = new jv1(this.mSwanApiContext);
                    this.mApis.put("-343998465", jv1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(jv1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Account.getUnionBDUSS")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = jv1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String login(String str) {
                bw1 bw1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof bw1)) {
                    bw1Var = (bw1) obj;
                } else {
                    bw1Var = new bw1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", bw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(bw1Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Account.login")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 I = bw1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                zv1 zv1Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof zv1)) {
                    zv1Var = (zv1) obj;
                } else {
                    zv1Var = new zv1(this.mSwanApiContext);
                    this.mApis.put("-337742792", zv1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(zv1Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Account.isBaiduAccountSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = zv1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                bw1 bw1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof bw1)) {
                    bw1Var = (bw1) obj;
                } else {
                    bw1Var = new bw1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", bw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(bw1Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Account.isLoginSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 H = bw1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBasic", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                dw1 dw1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof dw1)) {
                    dw1Var = (dw1) obj;
                } else {
                    dw1Var = new dw1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", dw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(dw1Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Basic.loadSubPackage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 F = dw1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                dw1 dw1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof dw1)) {
                    dw1Var = (dw1) obj;
                } else {
                    dw1Var = new dw1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", dw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(dw1Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Basic.loadSubPackages")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 G = dw1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                ko1 ko1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ko1)) {
                    ko1Var = (ko1) obj;
                } else {
                    ko1Var = new ko1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ko1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ko1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Bookshelf.deleteBookshelf")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 K = ko1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                ko1 ko1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ko1)) {
                    ko1Var = (ko1) obj;
                } else {
                    ko1Var = new ko1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ko1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ko1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Bookshelf.insertBookshelf")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 P = ko1Var.P(str);
                if (P == null) {
                    return "";
                }
                return P.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                ko1 ko1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ko1)) {
                    ko1Var = (ko1) obj;
                } else {
                    ko1Var = new ko1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ko1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ko1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Bookshelf.navigateToBookshelf")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 U = ko1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                ko1 ko1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ko1)) {
                    ko1Var = (ko1) obj;
                } else {
                    ko1Var = new ko1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ko1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ko1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Bookshelf.queryBookshelf")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 V = ko1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                ko1 ko1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ko1)) {
                    ko1Var = (ko1) obj;
                } else {
                    ko1Var = new ko1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ko1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ko1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Bookshelf.updateBookshelfReadTime")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 X = ko1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naCoupon", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                xv1 xv1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof xv1)) {
                    xv1Var = (xv1) obj;
                } else {
                    xv1Var = new xv1(this.mSwanApiContext);
                    this.mApis.put("-277316359", xv1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(xv1Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Coupon.getPlatformCoupons")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = xv1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                xv1 xv1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof xv1)) {
                    xv1Var = (xv1) obj;
                } else {
                    xv1Var = new xv1(this.mSwanApiContext);
                    this.mApis.put("-277316359", xv1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(xv1Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Coupon.getUserCoupons")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 z = xv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                xv1 xv1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof xv1)) {
                    xv1Var = (xv1) obj;
                } else {
                    xv1Var = new xv1(this.mSwanApiContext);
                    this.mApis.put("-277316359", xv1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(xv1Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Coupon.takeCoupons")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 C = xv1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naFavorite", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                fw1 fw1Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof fw1)) {
                    fw1Var = (fw1) obj;
                } else {
                    fw1Var = new fw1(this.mSwanApiContext);
                    this.mApis.put("-1225406515", fw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(fw1Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Favorite.getFavorStatus")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = fw1Var.x(str);
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
                Pair<Boolean, sz1> a = uz1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Favorite.showFavoriteGuide")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 G = showFavoriteGuideApi.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naFile", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                hw1 hw1Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof hw1)) {
                    hw1Var = (hw1) obj;
                } else {
                    hw1Var = new hw1(this.mSwanApiContext);
                    this.mApis.put("-2057135077", hw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(hw1Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "File.shareFile")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = hw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                wk2 wk2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof wk2)) {
                    wk2Var = (wk2) obj;
                } else {
                    wk2Var = new wk2(this.mSwanApiContext);
                    this.mApis.put("2077414795", wk2Var);
                }
                Pair<Boolean, sz1> a = uz1.a(wk2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = wk2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                wk2 wk2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof wk2)) {
                    wk2Var = (wk2) obj;
                } else {
                    wk2Var = new wk2(this.mSwanApiContext);
                    this.mApis.put("2077414795", wk2Var);
                }
                Pair<Boolean, sz1> a = uz1.a(wk2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessageSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = wk2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String download(String str) {
                iw1 iw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", iw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(iw1Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "HostDownloadManager.download")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = iw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                iw1 iw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", iw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(iw1Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "HostDownloadManager.openFile")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 z = iw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String query(String str) {
                iw1 iw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", iw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(iw1Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "HostDownloadManager.query")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 query = iw1Var.query(str);
                if (query == null) {
                    return "";
                }
                return query.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                iw1 iw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", iw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(iw1Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "HostDownloadManager.openDownloadCenter")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = iw1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naImage", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                kx2 kx2Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof kx2)) {
                    kx2Var = (kx2) obj;
                } else {
                    kx2Var = new kx2(this.mSwanApiContext);
                    this.mApis.put("1445003743", kx2Var);
                }
                Pair<Boolean, sz1> a = uz1.a(kx2Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Image.callImageMenu")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = kx2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                lw1 lw1Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof lw1)) {
                    lw1Var = (lw1) obj;
                } else {
                    lw1Var = new lw1(this.mSwanApiContext);
                    this.mApis.put("-1252730367", lw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(lw1Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Image.compressImage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = lw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naInteraction", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", tw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(tw1Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.closeTabBar")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = tw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", tw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(tw1Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.closeTabBarRedDot")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = tw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                pw1 pw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof pw1)) {
                    pw1Var = (pw1) obj;
                } else {
                    pw1Var = new pw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", pw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(pw1Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.hideNavigationBarLoading")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = pw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                rw1 rw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", rw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(rw1Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.openMultiPicker")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 G = rw1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                rw1 rw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", rw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(rw1Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.openPicker")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 H = rw1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", tw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(tw1Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.openTabBar")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 C = tw1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                qw1 qw1Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof qw1)) {
                    qw1Var = (qw1) obj;
                } else {
                    qw1Var = new qw1(this.mSwanApiContext);
                    this.mApis.put("-1750613704", qw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(qw1Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.pageScrollTo")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = qw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                pw1 pw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof pw1)) {
                    pw1Var = (pw1) obj;
                } else {
                    pw1Var = new pw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", pw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(pw1Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarColor")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 z = pw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                pw1 pw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof pw1)) {
                    pw1Var = (pw1) obj;
                } else {
                    pw1Var = new pw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", pw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(pw1Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarTitle")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = pw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", tw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(tw1Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.setTabBarItem")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 D = tw1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                rw1 rw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", rw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(rw1Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.showDatePickerView")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 L = rw1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                vw1 vw1Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("1172469410", vw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(vw1Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.showHalfScreenWebview")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 K = vw1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                nw1 nw1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof nw1)) {
                    nw1Var = (nw1) obj;
                } else {
                    nw1Var = new nw1(this.mSwanApiContext);
                    this.mApis.put("5236036", nw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(nw1Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.showLoading")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = nw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                ow1 ow1Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof ow1)) {
                    ow1Var = (ow1) obj;
                } else {
                    ow1Var = new ow1(this.mSwanApiContext);
                    this.mApis.put("1913747800", ow1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ow1Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.showModal")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = ow1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                pw1 pw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof pw1)) {
                    pw1Var = (pw1) obj;
                } else {
                    pw1Var = new pw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", pw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(pw1Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.showNavigationBarLoading")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 B = pw1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                uw1 uw1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof uw1)) {
                    uw1Var = (uw1) obj;
                } else {
                    uw1Var = new uw1(this.mSwanApiContext);
                    this.mApis.put("1159492510", uw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(uw1Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.showToast")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 Q = uw1Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                sw1 sw1Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof sw1)) {
                    sw1Var = (sw1) obj;
                } else {
                    sw1Var = new sw1(this.mSwanApiContext);
                    this.mApis.put("1165118609", sw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(sw1Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.stopPullDownRefresh")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = sw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                rw1 rw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", rw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(rw1Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.updateMultiPicker")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 M = rw1Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                nw1 nw1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof nw1)) {
                    nw1Var = (nw1) obj;
                } else {
                    nw1Var = new nw1(this.mSwanApiContext);
                    this.mApis.put("5236036", nw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(nw1Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.hideLoading")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = nw1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hideToast() {
                uw1 uw1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof uw1)) {
                    uw1Var = (uw1) obj;
                } else {
                    uw1Var = new uw1(this.mSwanApiContext);
                    this.mApis.put("1159492510", uw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(uw1Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Interaction.hideToast")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 K = uw1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                ww1 ww1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof ww1)) {
                    ww1Var = (ww1) obj;
                } else {
                    ww1Var = new ww1(this.mSwanApiContext);
                    this.mApis.put("-137346255", ww1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ww1Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Keyboard.startKeyboardHeightChange")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 C = ww1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                ww1 ww1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof ww1)) {
                    ww1Var = (ww1) obj;
                } else {
                    ww1Var = new ww1(this.mSwanApiContext);
                    this.mApis.put("-137346255", ww1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ww1Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Keyboard.stopKeyboardHeightChange")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 D = ww1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naLocationService", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                xw1 xw1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof xw1)) {
                    xw1Var = (xw1) obj;
                } else {
                    xw1Var = new xw1(this.mSwanApiContext);
                    this.mApis.put("-397373095", xw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(xw1Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "LocationService.getLocation")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = xw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                xw1 xw1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof xw1)) {
                    xw1Var = (xw1) obj;
                } else {
                    xw1Var = new xw1(this.mSwanApiContext);
                    this.mApis.put("-397373095", xw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(xw1Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "LocationService.startLocationUpdate")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = xw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                xw1 xw1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof xw1)) {
                    xw1Var = (xw1) obj;
                } else {
                    xw1Var = new xw1(this.mSwanApiContext);
                    this.mApis.put("-397373095", xw1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(xw1Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "LocationService.stopLocationUpdate")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 B = xw1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naMenu", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                oy1 oy1Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof oy1)) {
                    oy1Var = (oy1) obj;
                } else {
                    oy1Var = new oy1(this.mSwanApiContext);
                    this.mApis.put("538070032", oy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(oy1Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = oy1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naNetwork", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                ax1 ax1Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof ax1)) {
                    ax1Var = (ax1) obj;
                } else {
                    ax1Var = new ax1(this.mSwanApiContext);
                    this.mApis.put("-1076509454", ax1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ax1Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Network.callService")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = ax1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                hx1 hx1Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof hx1)) {
                    hx1Var = (hx1) obj;
                } else {
                    hx1Var = new hx1(this.mSwanApiContext);
                    this.mApis.put("968563034", hx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(hx1Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Network.cancelRequest")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 D = hx1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                gx1 gx1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof gx1)) {
                    gx1Var = (gx1) obj;
                } else {
                    gx1Var = new gx1(this.mSwanApiContext);
                    this.mApis.put("453220699", gx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(gx1Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Network.networkStatusChange")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = gx1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                gx1 gx1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof gx1)) {
                    gx1Var = (gx1) obj;
                } else {
                    gx1Var = new gx1(this.mSwanApiContext);
                    this.mApis.put("453220699", gx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(gx1Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Network.getNetworkType")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = gx1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(String str) {
                hx1 hx1Var;
                String a;
                try {
                    rz1.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof hx1)) {
                        hx1Var = (hx1) obj;
                    } else {
                        hx1Var = new hx1(this.mSwanApiContext);
                        this.mApis.put("968563034", hx1Var);
                    }
                    Pair<Boolean, sz1> a2 = uz1.a(hx1Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((sz1) a2.second).a();
                    } else if (aa2.a(this.mSwanApiContext.f(), "Network.request")) {
                        a = new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<sz1, JSONObject> u = wv1.u(str);
                        if (!((sz1) u.first).isSuccess()) {
                            a = ((sz1) u.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) u.second;
                            if (jSONObject == null) {
                                a = sz1.a.a();
                            } else {
                                tz1 V = hx1Var.V(jSONObject);
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
                        rz1.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                q03 q03Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof q03)) {
                    q03Var = (q03) obj;
                } else {
                    q03Var = new q03(this.mSwanApiContext);
                    this.mApis.put("-336396851", q03Var);
                }
                Pair<Boolean, sz1> a = uz1.a(q03Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Payment.chooseCoupon")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = q03Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                q03 q03Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof q03)) {
                    q03Var = (q03) obj;
                } else {
                    q03Var = new q03(this.mSwanApiContext);
                    this.mApis.put("-336396851", q03Var);
                }
                Pair<Boolean, sz1> a = uz1.a(q03Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Payment.getPaymentInfo")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = q03Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                g03 g03Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof g03)) {
                    g03Var = (g03) obj;
                } else {
                    g03Var = new g03(this.mSwanApiContext);
                    this.mApis.put("1854689529", g03Var);
                }
                Pair<Boolean, sz1> a = uz1.a(g03Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Payment.requestThirdPayment")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = g03Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                q03 q03Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof q03)) {
                    q03Var = (q03) obj;
                } else {
                    q03Var = new q03(this.mSwanApiContext);
                    this.mApis.put("-336396851", q03Var);
                }
                Pair<Boolean, sz1> a = uz1.a(q03Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Payment.setPaymentInfo")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 z = q03Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPlugin", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                b33 b33Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof b33)) {
                    b33Var = (b33) obj;
                } else {
                    b33Var = new b33(this.mSwanApiContext);
                    this.mApis.put("-254510461", b33Var);
                }
                Pair<Boolean, sz1> a = uz1.a(b33Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Plugin.invokePluginChooseAddress")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = b33Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                b33 b33Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof b33)) {
                    b33Var = (b33) obj;
                } else {
                    b33Var = new b33(this.mSwanApiContext);
                    this.mApis.put("-254510461", b33Var);
                }
                Pair<Boolean, sz1> a = uz1.a(b33Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 z = b33Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                b33 b33Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof b33)) {
                    b33Var = (b33) obj;
                } else {
                    b33Var = new b33(this.mSwanApiContext);
                    this.mApis.put("-254510461", b33Var);
                }
                Pair<Boolean, sz1> a = uz1.a(b33Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Plugin.invokePluginPayment")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = b33Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                ub2 ub2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof ub2)) {
                    ub2Var = (ub2) obj;
                } else {
                    ub2Var = new ub2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", ub2Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ub2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Prefetch.prefetchResources")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = ub2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPreload", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                ma2 ma2Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof ma2)) {
                    ma2Var = (ma2) obj;
                } else {
                    ma2Var = new ma2(this.mSwanApiContext);
                    this.mApis.put("423661539", ma2Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ma2Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Preload.preloadStatus")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = ma2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                wj3 wj3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof wj3)) {
                    wj3Var = (wj3) obj;
                } else {
                    wj3Var = new wj3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", wj3Var);
                }
                Pair<Boolean, sz1> a = uz1.a(wj3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "PrivateFile.uploadFileToBos")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 C = wj3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naRouter", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                lx1 lx1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof lx1)) {
                    lx1Var = (lx1) obj;
                } else {
                    lx1Var = new lx1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", lx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(lx1Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Router.hideModalPage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = lx1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                lx1 lx1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof lx1)) {
                    lx1Var = (lx1) obj;
                } else {
                    lx1Var = new lx1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", lx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(lx1Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Router.navigateBack")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 B = lx1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                mx1 mx1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof mx1)) {
                    mx1Var = (mx1) obj;
                } else {
                    mx1Var = new mx1(this.mSwanApiContext);
                    this.mApis.put("1968522584", mx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(mx1Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Router.navigateTo")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 H = mx1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                ox1 ox1Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof ox1)) {
                    ox1Var = (ox1) obj;
                } else {
                    ox1Var = new ox1(this.mSwanApiContext);
                    this.mApis.put("1317280190", ox1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ox1Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Router.reLaunch")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = ox1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                px1 px1Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof px1)) {
                    px1Var = (px1) obj;
                } else {
                    px1Var = new px1(this.mSwanApiContext);
                    this.mApis.put("-420075743", px1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(px1Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Router.reLoadErrorPage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = px1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                nx1 nx1Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof nx1)) {
                    nx1Var = (nx1) obj;
                } else {
                    nx1Var = new nx1(this.mSwanApiContext);
                    this.mApis.put("1792515533", nx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(nx1Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Router.redirectTo")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 D = nx1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                mx1 mx1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof mx1)) {
                    mx1Var = (mx1) obj;
                } else {
                    mx1Var = new mx1(this.mSwanApiContext);
                    this.mApis.put("1968522584", mx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(mx1Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Router.showModalPage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 J = mx1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naSetting", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                sx1 sx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof sx1)) {
                    sx1Var = (sx1) obj;
                } else {
                    sx1Var = new sx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", sx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(sx1Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Setting.getAppInfoSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 F = sx1Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                sx1 sx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof sx1)) {
                    sx1Var = (sx1) obj;
                } else {
                    sx1Var = new sx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", sx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(sx1Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Setting.getSlaveIdSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 H = sx1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                rx1 rx1Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof rx1)) {
                    rx1Var = (rx1) obj;
                } else {
                    rx1Var = new rx1(this.mSwanApiContext);
                    this.mApis.put("450273045", rx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(rx1Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Setting.isAllowedAdOpenAppSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = rx1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                sx1 sx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof sx1)) {
                    sx1Var = (sx1) obj;
                } else {
                    sx1Var = new sx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", sx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(sx1Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Setting.getSetting")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 G = sx1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                sx1 sx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof sx1)) {
                    sx1Var = (sx1) obj;
                } else {
                    sx1Var = new sx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", sx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(sx1Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Setting.getSwanId")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 I = sx1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                sx1 sx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof sx1)) {
                    sx1Var = (sx1) obj;
                } else {
                    sx1Var = new sx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", sx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(sx1Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Setting.getUserInfo")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 J = sx1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                qe3 qe3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof qe3)) {
                    qe3Var = (qe3) obj;
                } else {
                    qe3Var = new qe3(this.mSwanApiContext);
                    this.mApis.put("712777136", qe3Var);
                }
                Pair<Boolean, sz1> a = uz1.a(qe3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = qe3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naStorage", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                vx1 vx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", vx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(vx1Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = vx1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                vx1 vx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", vx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(vx1Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorageSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 C = vx1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                ux1 ux1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("130910081", ux1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ux1Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.clearStorage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = ux1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                ux1 ux1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("130910081", ux1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ux1Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.clearStorageSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 C = ux1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                vx1 vx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", vx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(vx1Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfo")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 G = vx1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                vx1 vx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", vx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(vx1Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfoSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 J = vx1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                ux1 ux1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("130910081", ux1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ux1Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.getStorageInfo")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 G = ux1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                ux1 ux1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("130910081", ux1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ux1Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.getStorageInfoSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 J = ux1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", vx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(vx1Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 D = vx1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", vx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(vx1Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 K = vx1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                ux1 ux1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("130910081", ux1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ux1Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.getStorage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 D = ux1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                ux1 ux1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("130910081", ux1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ux1Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.getStorageInfoAsync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 H = ux1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                ux1 ux1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("130910081", ux1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ux1Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.getStorageSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 K = ux1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", vx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(vx1Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 R = vx1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", vx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(vx1Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorageSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 T = vx1Var.T(str);
                if (T == null) {
                    return "";
                }
                return T.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                ux1 ux1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("130910081", ux1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ux1Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.removeStorage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 R = ux1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                ux1 ux1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("130910081", ux1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ux1Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.removeStorageSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 T = ux1Var.T(str);
                if (T == null) {
                    return "";
                }
                return T.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", vx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(vx1Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.setGlobalStorage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 U = vx1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", vx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(vx1Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.setGlobalStorageSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 W = vx1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                ux1 ux1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("130910081", ux1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ux1Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.setStorage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 U = ux1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                ux1 ux1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("130910081", ux1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ux1Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Storage.setStorageSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 W = ux1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }
        });
        hashMap.put("_naSubscription", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                xx1 xx1Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof xx1)) {
                    xx1Var = (xx1) obj;
                } else {
                    xx1Var = new xx1(this.mSwanApiContext);
                    this.mApis.put("823117982", xx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(xx1Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Subscription.requestSubscribeFormId")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 E = xx1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                yx1 yx1Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("-947445811", yx1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(yx1Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Subscription.subscribeService")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 F = yx1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }
        });
        hashMap.put("_naSystem", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                fy1 fy1Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof fy1)) {
                    fy1Var = (fy1) obj;
                } else {
                    fy1Var = new fy1(this.mSwanApiContext);
                    this.mApis.put("1936205521", fy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(fy1Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.exitFullScreen")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = fy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                ey1 ey1Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof ey1)) {
                    ey1Var = (ey1) obj;
                } else {
                    ey1Var = new ey1(this.mSwanApiContext);
                    this.mApis.put("1694151270", ey1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ey1Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.getDeviceInfo")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = ey1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                gy1 gy1Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof gy1)) {
                    gy1Var = (gy1) obj;
                } else {
                    gy1Var = new gy1(this.mSwanApiContext);
                    this.mApis.put("-1321681619", gy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(gy1Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.getDeviceProfile")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = gy1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                hy1 hy1Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof hy1)) {
                    hy1Var = (hy1) obj;
                } else {
                    hy1Var = new hy1(this.mSwanApiContext);
                    this.mApis.put("-1569246082", hy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(hy1Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.makePhoneCall")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = hy1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                jy1 jy1Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof jy1)) {
                    jy1Var = (jy1) obj;
                } else {
                    jy1Var = new jy1(this.mSwanApiContext);
                    this.mApis.put("1099851202", jy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(jy1Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.openSMSPanel")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = jy1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                iy1 iy1Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof iy1)) {
                    iy1Var = (iy1) obj;
                } else {
                    iy1Var = new iy1(this.mSwanApiContext);
                    this.mApis.put("-1707203360", iy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(iy1Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.requestFullScreen")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 F = iy1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                cy1 cy1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof cy1)) {
                    cy1Var = (cy1) obj;
                } else {
                    cy1Var = new cy1(this.mSwanApiContext);
                    this.mApis.put("-518757484", cy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(cy1Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.setClipboardData")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = cy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                mx2 mx2Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof mx2)) {
                    mx2Var = (mx2) obj;
                } else {
                    mx2Var = new mx2(this.mSwanApiContext);
                    this.mApis.put("1161486049", mx2Var);
                }
                Pair<Boolean, sz1> a = uz1.a(mx2Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.setErrorPageType")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = mx2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                my1 my1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof my1)) {
                    my1Var = (my1) obj;
                } else {
                    my1Var = new my1(this.mSwanApiContext);
                    this.mApis.put("447234992", my1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(my1Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.setMediaVolume")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 z = my1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                ay1 ay1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof ay1)) {
                    ay1Var = (ay1) obj;
                } else {
                    ay1Var = new ay1(this.mSwanApiContext);
                    this.mApis.put("1372680763", ay1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ay1Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.startAccelerometer")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = ay1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                dy1 dy1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof dy1)) {
                    dy1Var = (dy1) obj;
                } else {
                    dy1Var = new dy1(this.mSwanApiContext);
                    this.mApis.put("1689255576", dy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(dy1Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.startCompass")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = dy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                by1 by1Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof by1)) {
                    by1Var = (by1) obj;
                } else {
                    by1Var = new by1(this.mSwanApiContext);
                    this.mApis.put("99997465", by1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(by1Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.getBrightness")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = by1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                cy1 cy1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof cy1)) {
                    cy1Var = (cy1) obj;
                } else {
                    cy1Var = new cy1(this.mSwanApiContext);
                    this.mApis.put("-518757484", cy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(cy1Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.getClipboardData")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = cy1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                my1 my1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof my1)) {
                    my1Var = (my1) obj;
                } else {
                    my1Var = new my1(this.mSwanApiContext);
                    this.mApis.put("447234992", my1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(my1Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.getMediaVolume")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = my1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                ay1 ay1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof ay1)) {
                    ay1Var = (ay1) obj;
                } else {
                    ay1Var = new ay1(this.mSwanApiContext);
                    this.mApis.put("1372680763", ay1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ay1Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.stopAccelerometer")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 B = ay1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                dy1 dy1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof dy1)) {
                    dy1Var = (dy1) obj;
                } else {
                    dy1Var = new dy1(this.mSwanApiContext);
                    this.mApis.put("1689255576", dy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(dy1Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "System.stopCompass")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 z = dy1Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naUtils", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                xy1 xy1Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof xy1)) {
                    xy1Var = (xy1) obj;
                } else {
                    xy1Var = new xy1(this.mSwanApiContext);
                    this.mApis.put("201194468", xy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(xy1Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.addToDesktop")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 B = xy1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                ty1 ty1Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof ty1)) {
                    ty1Var = (ty1) obj;
                } else {
                    ty1Var = new ty1(this.mSwanApiContext);
                    this.mApis.put("-1412306947", ty1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ty1Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.calcMD5")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = ty1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                uy1 uy1Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof uy1)) {
                    uy1Var = (uy1) obj;
                } else {
                    uy1Var = new uy1(this.mSwanApiContext);
                    this.mApis.put("1626415364", uy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(uy1Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.checkAppInstalled")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = uy1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                wy1 wy1Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof wy1)) {
                    wy1Var = (wy1) obj;
                } else {
                    wy1Var = new wy1(this.mSwanApiContext);
                    this.mApis.put("-836768778", wy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(wy1Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfo")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = wy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                yy1 yy1Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof yy1)) {
                    yy1Var = (yy1) obj;
                } else {
                    yy1Var = new yy1(this.mSwanApiContext);
                    this.mApis.put("-810858308", yy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(yy1Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.getPerformanceLevel")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = yy1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                cz1 cz1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof cz1)) {
                    cz1Var = (cz1) obj;
                } else {
                    cz1Var = new cz1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", cz1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(cz1Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.getSystemInfoAsync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 I = cz1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                zy1 zy1Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof zy1)) {
                    zy1Var = (zy1) obj;
                } else {
                    zy1Var = new zy1(this.mSwanApiContext);
                    this.mApis.put("-2097727681", zy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(zy1Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.handleException")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = zy1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                vy1 vy1Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof vy1)) {
                    vy1Var = (vy1) obj;
                } else {
                    vy1Var = new vy1(this.mSwanApiContext);
                    this.mApis.put("2084449317", vy1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(vy1Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.hasCloseHandler")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = vy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                yb3 yb3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof yb3)) {
                    yb3Var = (yb3) obj;
                } else {
                    yb3Var = new yb3(this.mSwanApiContext);
                    this.mApis.put("1031678042", yb3Var);
                }
                Pair<Boolean, sz1> a = uz1.a(yb3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.hideCaptureScreenShareDialog")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 x = yb3Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                az1 az1Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof az1)) {
                    az1Var = (az1) obj;
                } else {
                    az1Var = new az1(this.mSwanApiContext);
                    this.mApis.put("1751900130", az1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(az1Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.logToFile")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = az1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                za3 za3Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof za3)) {
                    za3Var = (za3) obj;
                } else {
                    za3Var = new za3(this.mSwanApiContext);
                    this.mApis.put("1748196865", za3Var);
                }
                Pair<Boolean, sz1> a = uz1.a(za3Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.preloadPackage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = za3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                bz1 bz1Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof bz1)) {
                    bz1Var = (bz1) obj;
                } else {
                    bz1Var = new bz1(this.mSwanApiContext);
                    this.mApis.put("589529211", bz1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(bz1Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.previewImage")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 B = bz1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                ez1 ez1Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof ez1)) {
                    ez1Var = (ez1) obj;
                } else {
                    ez1Var = new ez1(this.mSwanApiContext);
                    this.mApis.put("-577481801", ez1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ez1Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.ubcFlowJar")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 I = ez1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                cz1 cz1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof cz1)) {
                    cz1Var = (cz1) obj;
                } else {
                    cz1Var = new cz1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", cz1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(cz1Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfoSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 E = cz1Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                cz1 cz1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof cz1)) {
                    cz1Var = (cz1) obj;
                } else {
                    cz1Var = new cz1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", cz1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(cz1Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.getSystemInfo")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 H = cz1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                cz1 cz1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof cz1)) {
                    cz1Var = (cz1) obj;
                } else {
                    cz1Var = new cz1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", cz1Var);
                }
                Pair<Boolean, sz1> a = uz1.a(cz1Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Utils.getSystemInfoSync")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 J = cz1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naWifi", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                ji3 ji3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ji3)) {
                    ji3Var = (ji3) obj;
                } else {
                    ji3Var = new ji3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ji3Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ji3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Wifi.connectWifi")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 A = ji3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                ji3 ji3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ji3)) {
                    ji3Var = (ji3) obj;
                } else {
                    ji3Var = new ji3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ji3Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ji3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Wifi.getConnectedWifi")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 B = ji3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                ji3 ji3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ji3)) {
                    ji3Var = (ji3) obj;
                } else {
                    ji3Var = new ji3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ji3Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ji3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Wifi.getWifiList")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 C = ji3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                ji3 ji3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ji3)) {
                    ji3Var = (ji3) obj;
                } else {
                    ji3Var = new ji3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ji3Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ji3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Wifi.startWifi")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 G = ji3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                ji3 ji3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ji3)) {
                    ji3Var = (ji3) obj;
                } else {
                    ji3Var = new ji3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ji3Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ji3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "Wifi.stopWifi")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 H = ji3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }
}
