package com.baidu.swan.apps.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.tieba.ab3;
import com.baidu.tieba.aw1;
import com.baidu.tieba.az1;
import com.baidu.tieba.ba2;
import com.baidu.tieba.bw1;
import com.baidu.tieba.bx1;
import com.baidu.tieba.by1;
import com.baidu.tieba.bz1;
import com.baidu.tieba.c33;
import com.baidu.tieba.cw1;
import com.baidu.tieba.cy1;
import com.baidu.tieba.cz1;
import com.baidu.tieba.dw1;
import com.baidu.tieba.dy1;
import com.baidu.tieba.dz1;
import com.baidu.tieba.ew1;
import com.baidu.tieba.ey1;
import com.baidu.tieba.fy1;
import com.baidu.tieba.fz1;
import com.baidu.tieba.gw1;
import com.baidu.tieba.gy1;
import com.baidu.tieba.h03;
import com.baidu.tieba.hx1;
import com.baidu.tieba.hy1;
import com.baidu.tieba.iw1;
import com.baidu.tieba.ix1;
import com.baidu.tieba.iy1;
import com.baidu.tieba.jw1;
import com.baidu.tieba.jy1;
import com.baidu.tieba.ki3;
import com.baidu.tieba.kv1;
import com.baidu.tieba.ky1;
import com.baidu.tieba.lo1;
import com.baidu.tieba.lx2;
import com.baidu.tieba.mw1;
import com.baidu.tieba.mx1;
import com.baidu.tieba.na2;
import com.baidu.tieba.nx1;
import com.baidu.tieba.nx2;
import com.baidu.tieba.ny1;
import com.baidu.tieba.ow1;
import com.baidu.tieba.ox1;
import com.baidu.tieba.pw1;
import com.baidu.tieba.px1;
import com.baidu.tieba.py1;
import com.baidu.tieba.qw1;
import com.baidu.tieba.qx1;
import com.baidu.tieba.r03;
import com.baidu.tieba.re3;
import com.baidu.tieba.rw1;
import com.baidu.tieba.sw1;
import com.baidu.tieba.sx1;
import com.baidu.tieba.sz1;
import com.baidu.tieba.tw1;
import com.baidu.tieba.tx1;
import com.baidu.tieba.tz1;
import com.baidu.tieba.uw1;
import com.baidu.tieba.uy1;
import com.baidu.tieba.uz1;
import com.baidu.tieba.vb2;
import com.baidu.tieba.vv1;
import com.baidu.tieba.vw1;
import com.baidu.tieba.vx1;
import com.baidu.tieba.vy1;
import com.baidu.tieba.vz1;
import com.baidu.tieba.ww1;
import com.baidu.tieba.wx1;
import com.baidu.tieba.wy1;
import com.baidu.tieba.xj3;
import com.baidu.tieba.xk2;
import com.baidu.tieba.xv1;
import com.baidu.tieba.xw1;
import com.baidu.tieba.xy1;
import com.baidu.tieba.yv1;
import com.baidu.tieba.yw1;
import com.baidu.tieba.yx1;
import com.baidu.tieba.yy1;
import com.baidu.tieba.zb3;
import com.baidu.tieba.zx1;
import com.baidu.tieba.zy1;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
@Keep
/* loaded from: classes3.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final vv1 vv1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                bw1 bw1Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof bw1)) {
                    bw1Var = (bw1) obj;
                } else {
                    bw1Var = new bw1(this.mSwanApiContext);
                    this.mApis.put("1930258908", bw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(bw1Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Account.checkSession")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = bw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                cw1 cw1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof cw1)) {
                    cw1Var = (cw1) obj;
                } else {
                    cw1Var = new cw1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", cw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(cw1Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Account.getLoginCode")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 C = cw1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                dw1 dw1Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof dw1)) {
                    dw1Var = (dw1) obj;
                } else {
                    dw1Var = new dw1(this.mSwanApiContext);
                    this.mApis.put("1754780133", dw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(dw1Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Account.getOpenId")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = dw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                kv1 kv1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof kv1)) {
                    kv1Var = (kv1) obj;
                } else {
                    kv1Var = new kv1(this.mSwanApiContext);
                    this.mApis.put("-343998465", kv1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(kv1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Account.getUnionBDUSS")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = kv1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String login(String str) {
                cw1 cw1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof cw1)) {
                    cw1Var = (cw1) obj;
                } else {
                    cw1Var = new cw1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", cw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(cw1Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Account.login")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 I = cw1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                aw1 aw1Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof aw1)) {
                    aw1Var = (aw1) obj;
                } else {
                    aw1Var = new aw1(this.mSwanApiContext);
                    this.mApis.put("-337742792", aw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(aw1Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Account.isBaiduAccountSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = aw1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                cw1 cw1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof cw1)) {
                    cw1Var = (cw1) obj;
                } else {
                    cw1Var = new cw1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", cw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(cw1Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Account.isLoginSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 H = cw1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBasic", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                ew1 ew1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof ew1)) {
                    ew1Var = (ew1) obj;
                } else {
                    ew1Var = new ew1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", ew1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ew1Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Basic.loadSubPackage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 F = ew1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                ew1 ew1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof ew1)) {
                    ew1Var = (ew1) obj;
                } else {
                    ew1Var = new ew1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", ew1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ew1Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Basic.loadSubPackages")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 G = ew1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                lo1 lo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof lo1)) {
                    lo1Var = (lo1) obj;
                } else {
                    lo1Var = new lo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", lo1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(lo1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Bookshelf.deleteBookshelf")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 K = lo1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                lo1 lo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof lo1)) {
                    lo1Var = (lo1) obj;
                } else {
                    lo1Var = new lo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", lo1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(lo1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Bookshelf.insertBookshelf")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 P = lo1Var.P(str);
                if (P == null) {
                    return "";
                }
                return P.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                lo1 lo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof lo1)) {
                    lo1Var = (lo1) obj;
                } else {
                    lo1Var = new lo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", lo1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(lo1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Bookshelf.navigateToBookshelf")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 U = lo1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                lo1 lo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof lo1)) {
                    lo1Var = (lo1) obj;
                } else {
                    lo1Var = new lo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", lo1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(lo1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Bookshelf.queryBookshelf")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 V = lo1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                lo1 lo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof lo1)) {
                    lo1Var = (lo1) obj;
                } else {
                    lo1Var = new lo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", lo1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(lo1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Bookshelf.updateBookshelfReadTime")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 X = lo1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naCoupon", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                yv1 yv1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof yv1)) {
                    yv1Var = (yv1) obj;
                } else {
                    yv1Var = new yv1(this.mSwanApiContext);
                    this.mApis.put("-277316359", yv1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(yv1Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Coupon.getPlatformCoupons")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = yv1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                yv1 yv1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof yv1)) {
                    yv1Var = (yv1) obj;
                } else {
                    yv1Var = new yv1(this.mSwanApiContext);
                    this.mApis.put("-277316359", yv1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(yv1Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Coupon.getUserCoupons")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 z = yv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                yv1 yv1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof yv1)) {
                    yv1Var = (yv1) obj;
                } else {
                    yv1Var = new yv1(this.mSwanApiContext);
                    this.mApis.put("-277316359", yv1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(yv1Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Coupon.takeCoupons")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 C = yv1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naFavorite", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                gw1 gw1Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof gw1)) {
                    gw1Var = (gw1) obj;
                } else {
                    gw1Var = new gw1(this.mSwanApiContext);
                    this.mApis.put("-1225406515", gw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(gw1Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Favorite.getFavorStatus")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = gw1Var.x(str);
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
                Pair<Boolean, tz1> a = vz1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Favorite.showFavoriteGuide")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 G = showFavoriteGuideApi.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naFile", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                iw1 iw1Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("-2057135077", iw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(iw1Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "File.shareFile")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = iw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                xk2 xk2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof xk2)) {
                    xk2Var = (xk2) obj;
                } else {
                    xk2Var = new xk2(this.mSwanApiContext);
                    this.mApis.put("2077414795", xk2Var);
                }
                Pair<Boolean, tz1> a = vz1.a(xk2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = xk2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                xk2 xk2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof xk2)) {
                    xk2Var = (xk2) obj;
                } else {
                    xk2Var = new xk2(this.mSwanApiContext);
                    this.mApis.put("2077414795", xk2Var);
                }
                Pair<Boolean, tz1> a = vz1.a(xk2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessageSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = xk2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String download(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", jw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(jw1Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "HostDownloadManager.download")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = jw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", jw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(jw1Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "HostDownloadManager.openFile")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 z = jw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String query(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", jw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(jw1Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "HostDownloadManager.query")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 query = jw1Var.query(str);
                if (query == null) {
                    return "";
                }
                return query.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                jw1 jw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", jw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(jw1Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "HostDownloadManager.openDownloadCenter")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = jw1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naImage", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                lx2 lx2Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof lx2)) {
                    lx2Var = (lx2) obj;
                } else {
                    lx2Var = new lx2(this.mSwanApiContext);
                    this.mApis.put("1445003743", lx2Var);
                }
                Pair<Boolean, tz1> a = vz1.a(lx2Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Image.callImageMenu")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = lx2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                mw1 mw1Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("-1252730367", mw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(mw1Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Image.compressImage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = mw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naInteraction", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                uw1 uw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof uw1)) {
                    uw1Var = (uw1) obj;
                } else {
                    uw1Var = new uw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", uw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(uw1Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.closeTabBar")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = uw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                uw1 uw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof uw1)) {
                    uw1Var = (uw1) obj;
                } else {
                    uw1Var = new uw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", uw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(uw1Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.closeTabBarRedDot")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = uw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                qw1 qw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof qw1)) {
                    qw1Var = (qw1) obj;
                } else {
                    qw1Var = new qw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", qw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(qw1Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.hideNavigationBarLoading")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = qw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                sw1 sw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof sw1)) {
                    sw1Var = (sw1) obj;
                } else {
                    sw1Var = new sw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", sw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(sw1Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.openMultiPicker")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 G = sw1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                sw1 sw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof sw1)) {
                    sw1Var = (sw1) obj;
                } else {
                    sw1Var = new sw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", sw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(sw1Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.openPicker")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 H = sw1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                uw1 uw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof uw1)) {
                    uw1Var = (uw1) obj;
                } else {
                    uw1Var = new uw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", uw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(uw1Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.openTabBar")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 C = uw1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                rw1 rw1Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("-1750613704", rw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(rw1Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.pageScrollTo")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = rw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                qw1 qw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof qw1)) {
                    qw1Var = (qw1) obj;
                } else {
                    qw1Var = new qw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", qw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(qw1Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarColor")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 z = qw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                qw1 qw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof qw1)) {
                    qw1Var = (qw1) obj;
                } else {
                    qw1Var = new qw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", qw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(qw1Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarTitle")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = qw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                uw1 uw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof uw1)) {
                    uw1Var = (uw1) obj;
                } else {
                    uw1Var = new uw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", uw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(uw1Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.setTabBarItem")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 D = uw1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                sw1 sw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof sw1)) {
                    sw1Var = (sw1) obj;
                } else {
                    sw1Var = new sw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", sw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(sw1Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.showDatePickerView")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 L = sw1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                ww1 ww1Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof ww1)) {
                    ww1Var = (ww1) obj;
                } else {
                    ww1Var = new ww1(this.mSwanApiContext);
                    this.mApis.put("1172469410", ww1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ww1Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.showHalfScreenWebview")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 K = ww1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                ow1 ow1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof ow1)) {
                    ow1Var = (ow1) obj;
                } else {
                    ow1Var = new ow1(this.mSwanApiContext);
                    this.mApis.put("5236036", ow1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ow1Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.showLoading")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = ow1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                pw1 pw1Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof pw1)) {
                    pw1Var = (pw1) obj;
                } else {
                    pw1Var = new pw1(this.mSwanApiContext);
                    this.mApis.put("1913747800", pw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(pw1Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.showModal")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = pw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                qw1 qw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof qw1)) {
                    qw1Var = (qw1) obj;
                } else {
                    qw1Var = new qw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", qw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(qw1Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.showNavigationBarLoading")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 B = qw1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                vw1 vw1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("1159492510", vw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vw1Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.showToast")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 Q = vw1Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("1165118609", tw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(tw1Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.stopPullDownRefresh")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = tw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                sw1 sw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof sw1)) {
                    sw1Var = (sw1) obj;
                } else {
                    sw1Var = new sw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", sw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(sw1Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.updateMultiPicker")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 M = sw1Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                ow1 ow1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof ow1)) {
                    ow1Var = (ow1) obj;
                } else {
                    ow1Var = new ow1(this.mSwanApiContext);
                    this.mApis.put("5236036", ow1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ow1Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.hideLoading")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = ow1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hideToast() {
                vw1 vw1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("1159492510", vw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vw1Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.hideToast")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 K = vw1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                xw1 xw1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof xw1)) {
                    xw1Var = (xw1) obj;
                } else {
                    xw1Var = new xw1(this.mSwanApiContext);
                    this.mApis.put("-137346255", xw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(xw1Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Keyboard.startKeyboardHeightChange")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 C = xw1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                xw1 xw1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof xw1)) {
                    xw1Var = (xw1) obj;
                } else {
                    xw1Var = new xw1(this.mSwanApiContext);
                    this.mApis.put("-137346255", xw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(xw1Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Keyboard.stopKeyboardHeightChange")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 D = xw1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naLocationService", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                yw1 yw1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof yw1)) {
                    yw1Var = (yw1) obj;
                } else {
                    yw1Var = new yw1(this.mSwanApiContext);
                    this.mApis.put("-397373095", yw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(yw1Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "LocationService.getLocation")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = yw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                yw1 yw1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof yw1)) {
                    yw1Var = (yw1) obj;
                } else {
                    yw1Var = new yw1(this.mSwanApiContext);
                    this.mApis.put("-397373095", yw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(yw1Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "LocationService.startLocationUpdate")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = yw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                yw1 yw1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof yw1)) {
                    yw1Var = (yw1) obj;
                } else {
                    yw1Var = new yw1(this.mSwanApiContext);
                    this.mApis.put("-397373095", yw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(yw1Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "LocationService.stopLocationUpdate")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 B = yw1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naMenu", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                py1 py1Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof py1)) {
                    py1Var = (py1) obj;
                } else {
                    py1Var = new py1(this.mSwanApiContext);
                    this.mApis.put("538070032", py1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(py1Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = py1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naNetwork", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                bx1 bx1Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof bx1)) {
                    bx1Var = (bx1) obj;
                } else {
                    bx1Var = new bx1(this.mSwanApiContext);
                    this.mApis.put("-1076509454", bx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(bx1Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Network.callService")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = bx1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                ix1 ix1Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof ix1)) {
                    ix1Var = (ix1) obj;
                } else {
                    ix1Var = new ix1(this.mSwanApiContext);
                    this.mApis.put("968563034", ix1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ix1Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Network.cancelRequest")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 D = ix1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                hx1 hx1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof hx1)) {
                    hx1Var = (hx1) obj;
                } else {
                    hx1Var = new hx1(this.mSwanApiContext);
                    this.mApis.put("453220699", hx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(hx1Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Network.networkStatusChange")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = hx1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                hx1 hx1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof hx1)) {
                    hx1Var = (hx1) obj;
                } else {
                    hx1Var = new hx1(this.mSwanApiContext);
                    this.mApis.put("453220699", hx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(hx1Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Network.getNetworkType")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = hx1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(JsObject jsObject) {
                ix1 ix1Var;
                String a;
                try {
                    sz1.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof ix1)) {
                        ix1Var = (ix1) obj;
                    } else {
                        ix1Var = new ix1(this.mSwanApiContext);
                        this.mApis.put("968563034", ix1Var);
                    }
                    Pair<Boolean, tz1> a2 = vz1.a(ix1Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((tz1) a2.second).a();
                    } else if (ba2.a(this.mSwanApiContext.f(), "Network.request")) {
                        a = new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<tz1, JSONObject> t = xv1.t(jsObject);
                        if (!((tz1) t.first).isSuccess()) {
                            a = ((tz1) t.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) t.second;
                            if (jSONObject == null) {
                                a = tz1.a.a();
                            } else {
                                uz1 V = ix1Var.V(jSONObject);
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
                        sz1.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                r03 r03Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof r03)) {
                    r03Var = (r03) obj;
                } else {
                    r03Var = new r03(this.mSwanApiContext);
                    this.mApis.put("-336396851", r03Var);
                }
                Pair<Boolean, tz1> a = vz1.a(r03Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Payment.chooseCoupon")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = r03Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                r03 r03Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof r03)) {
                    r03Var = (r03) obj;
                } else {
                    r03Var = new r03(this.mSwanApiContext);
                    this.mApis.put("-336396851", r03Var);
                }
                Pair<Boolean, tz1> a = vz1.a(r03Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Payment.getPaymentInfo")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = r03Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                h03 h03Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof h03)) {
                    h03Var = (h03) obj;
                } else {
                    h03Var = new h03(this.mSwanApiContext);
                    this.mApis.put("1854689529", h03Var);
                }
                Pair<Boolean, tz1> a = vz1.a(h03Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Payment.requestThirdPayment")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = h03Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                r03 r03Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof r03)) {
                    r03Var = (r03) obj;
                } else {
                    r03Var = new r03(this.mSwanApiContext);
                    this.mApis.put("-336396851", r03Var);
                }
                Pair<Boolean, tz1> a = vz1.a(r03Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Payment.setPaymentInfo")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 z = r03Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPlugin", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                c33 c33Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof c33)) {
                    c33Var = (c33) obj;
                } else {
                    c33Var = new c33(this.mSwanApiContext);
                    this.mApis.put("-254510461", c33Var);
                }
                Pair<Boolean, tz1> a = vz1.a(c33Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Plugin.invokePluginChooseAddress")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = c33Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                c33 c33Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof c33)) {
                    c33Var = (c33) obj;
                } else {
                    c33Var = new c33(this.mSwanApiContext);
                    this.mApis.put("-254510461", c33Var);
                }
                Pair<Boolean, tz1> a = vz1.a(c33Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 z = c33Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                c33 c33Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof c33)) {
                    c33Var = (c33) obj;
                } else {
                    c33Var = new c33(this.mSwanApiContext);
                    this.mApis.put("-254510461", c33Var);
                }
                Pair<Boolean, tz1> a = vz1.a(c33Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Plugin.invokePluginPayment")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = c33Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                vb2 vb2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof vb2)) {
                    vb2Var = (vb2) obj;
                } else {
                    vb2Var = new vb2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", vb2Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vb2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Prefetch.prefetchResources")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = vb2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPreload", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                na2 na2Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof na2)) {
                    na2Var = (na2) obj;
                } else {
                    na2Var = new na2(this.mSwanApiContext);
                    this.mApis.put("423661539", na2Var);
                }
                Pair<Boolean, tz1> a = vz1.a(na2Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Preload.preloadStatus")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = na2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                xj3 xj3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof xj3)) {
                    xj3Var = (xj3) obj;
                } else {
                    xj3Var = new xj3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", xj3Var);
                }
                Pair<Boolean, tz1> a = vz1.a(xj3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "PrivateFile.uploadFileToBos")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 C = xj3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naRouter", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                mx1 mx1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof mx1)) {
                    mx1Var = (mx1) obj;
                } else {
                    mx1Var = new mx1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", mx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(mx1Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Router.hideModalPage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = mx1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                mx1 mx1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof mx1)) {
                    mx1Var = (mx1) obj;
                } else {
                    mx1Var = new mx1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", mx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(mx1Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Router.navigateBack")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 B = mx1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                nx1 nx1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof nx1)) {
                    nx1Var = (nx1) obj;
                } else {
                    nx1Var = new nx1(this.mSwanApiContext);
                    this.mApis.put("1968522584", nx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(nx1Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Router.navigateTo")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 H = nx1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                px1 px1Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof px1)) {
                    px1Var = (px1) obj;
                } else {
                    px1Var = new px1(this.mSwanApiContext);
                    this.mApis.put("1317280190", px1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(px1Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Router.reLaunch")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = px1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                qx1 qx1Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("-420075743", qx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(qx1Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Router.reLoadErrorPage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = qx1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                ox1 ox1Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof ox1)) {
                    ox1Var = (ox1) obj;
                } else {
                    ox1Var = new ox1(this.mSwanApiContext);
                    this.mApis.put("1792515533", ox1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ox1Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Router.redirectTo")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 D = ox1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                nx1 nx1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof nx1)) {
                    nx1Var = (nx1) obj;
                } else {
                    nx1Var = new nx1(this.mSwanApiContext);
                    this.mApis.put("1968522584", nx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(nx1Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Router.showModalPage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 J = nx1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naSetting", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                tx1 tx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof tx1)) {
                    tx1Var = (tx1) obj;
                } else {
                    tx1Var = new tx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", tx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(tx1Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Setting.getAppInfoSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 F = tx1Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                tx1 tx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof tx1)) {
                    tx1Var = (tx1) obj;
                } else {
                    tx1Var = new tx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", tx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(tx1Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Setting.getSlaveIdSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 H = tx1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                sx1 sx1Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof sx1)) {
                    sx1Var = (sx1) obj;
                } else {
                    sx1Var = new sx1(this.mSwanApiContext);
                    this.mApis.put("450273045", sx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(sx1Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Setting.isAllowedAdOpenAppSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = sx1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                tx1 tx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof tx1)) {
                    tx1Var = (tx1) obj;
                } else {
                    tx1Var = new tx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", tx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(tx1Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Setting.getSetting")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 G = tx1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                tx1 tx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof tx1)) {
                    tx1Var = (tx1) obj;
                } else {
                    tx1Var = new tx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", tx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(tx1Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Setting.getSwanId")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 I = tx1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                tx1 tx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof tx1)) {
                    tx1Var = (tx1) obj;
                } else {
                    tx1Var = new tx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", tx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(tx1Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Setting.getUserInfo")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 J = tx1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                re3 re3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof re3)) {
                    re3Var = (re3) obj;
                } else {
                    re3Var = new re3(this.mSwanApiContext);
                    this.mApis.put("712777136", re3Var);
                }
                Pair<Boolean, tz1> a = vz1.a(re3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = re3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naStorage", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                wx1 wx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", wx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(wx1Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = wx1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                wx1 wx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", wx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(wx1Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorageSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 C = wx1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                vx1 vx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("130910081", vx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vx1Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.clearStorage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = vx1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                vx1 vx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("130910081", vx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vx1Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.clearStorageSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 C = vx1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                wx1 wx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", wx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(wx1Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfo")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 G = wx1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                wx1 wx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", wx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(wx1Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfoSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 J = wx1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                vx1 vx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("130910081", vx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vx1Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.getStorageInfo")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 G = vx1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                vx1 vx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("130910081", vx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vx1Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.getStorageInfoSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 J = vx1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", wx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(wx1Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 D = wx1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", wx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(wx1Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 K = wx1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("130910081", vx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vx1Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.getStorage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 D = vx1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("130910081", vx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vx1Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.getStorageInfoAsync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 H = vx1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("130910081", vx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vx1Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.getStorageSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 K = vx1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", wx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(wx1Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 R = wx1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", wx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(wx1Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorageSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 T = wx1Var.T(str);
                if (T == null) {
                    return "";
                }
                return T.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("130910081", vx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vx1Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.removeStorage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 R = vx1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("130910081", vx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vx1Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.removeStorageSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 T = vx1Var.T(str);
                if (T == null) {
                    return "";
                }
                return T.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", wx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(wx1Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.setGlobalStorage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 U = wx1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", wx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(wx1Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.setGlobalStorageSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 W = wx1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("130910081", vx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vx1Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.setStorage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 U = vx1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("130910081", vx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vx1Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.setStorageSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 W = vx1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }
        });
        hashMap.put("_naSubscription", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                yx1 yx1Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("823117982", yx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(yx1Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Subscription.requestSubscribeFormId")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 E = yx1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                zx1 zx1Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof zx1)) {
                    zx1Var = (zx1) obj;
                } else {
                    zx1Var = new zx1(this.mSwanApiContext);
                    this.mApis.put("-947445811", zx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(zx1Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Subscription.subscribeService")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 F = zx1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }
        });
        hashMap.put("_naSystem", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                gy1 gy1Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof gy1)) {
                    gy1Var = (gy1) obj;
                } else {
                    gy1Var = new gy1(this.mSwanApiContext);
                    this.mApis.put("1936205521", gy1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(gy1Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.exitFullScreen")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = gy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                fy1 fy1Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof fy1)) {
                    fy1Var = (fy1) obj;
                } else {
                    fy1Var = new fy1(this.mSwanApiContext);
                    this.mApis.put("1694151270", fy1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(fy1Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.getDeviceInfo")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = fy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                hy1 hy1Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof hy1)) {
                    hy1Var = (hy1) obj;
                } else {
                    hy1Var = new hy1(this.mSwanApiContext);
                    this.mApis.put("-1321681619", hy1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(hy1Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.getDeviceProfile")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = hy1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                iy1 iy1Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof iy1)) {
                    iy1Var = (iy1) obj;
                } else {
                    iy1Var = new iy1(this.mSwanApiContext);
                    this.mApis.put("-1569246082", iy1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(iy1Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.makePhoneCall")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = iy1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                ky1 ky1Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof ky1)) {
                    ky1Var = (ky1) obj;
                } else {
                    ky1Var = new ky1(this.mSwanApiContext);
                    this.mApis.put("1099851202", ky1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ky1Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.openSMSPanel")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = ky1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                jy1 jy1Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof jy1)) {
                    jy1Var = (jy1) obj;
                } else {
                    jy1Var = new jy1(this.mSwanApiContext);
                    this.mApis.put("-1707203360", jy1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(jy1Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.requestFullScreen")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 F = jy1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                dy1 dy1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof dy1)) {
                    dy1Var = (dy1) obj;
                } else {
                    dy1Var = new dy1(this.mSwanApiContext);
                    this.mApis.put("-518757484", dy1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(dy1Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.setClipboardData")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = dy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                nx2 nx2Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof nx2)) {
                    nx2Var = (nx2) obj;
                } else {
                    nx2Var = new nx2(this.mSwanApiContext);
                    this.mApis.put("1161486049", nx2Var);
                }
                Pair<Boolean, tz1> a = vz1.a(nx2Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.setErrorPageType")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = nx2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                ny1 ny1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof ny1)) {
                    ny1Var = (ny1) obj;
                } else {
                    ny1Var = new ny1(this.mSwanApiContext);
                    this.mApis.put("447234992", ny1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ny1Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.setMediaVolume")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 z = ny1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                by1 by1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof by1)) {
                    by1Var = (by1) obj;
                } else {
                    by1Var = new by1(this.mSwanApiContext);
                    this.mApis.put("1372680763", by1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(by1Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.startAccelerometer")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = by1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                ey1 ey1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof ey1)) {
                    ey1Var = (ey1) obj;
                } else {
                    ey1Var = new ey1(this.mSwanApiContext);
                    this.mApis.put("1689255576", ey1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ey1Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.startCompass")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = ey1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                cy1 cy1Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof cy1)) {
                    cy1Var = (cy1) obj;
                } else {
                    cy1Var = new cy1(this.mSwanApiContext);
                    this.mApis.put("99997465", cy1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(cy1Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.getBrightness")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = cy1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                dy1 dy1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof dy1)) {
                    dy1Var = (dy1) obj;
                } else {
                    dy1Var = new dy1(this.mSwanApiContext);
                    this.mApis.put("-518757484", dy1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(dy1Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.getClipboardData")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = dy1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                ny1 ny1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof ny1)) {
                    ny1Var = (ny1) obj;
                } else {
                    ny1Var = new ny1(this.mSwanApiContext);
                    this.mApis.put("447234992", ny1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ny1Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.getMediaVolume")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = ny1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                by1 by1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof by1)) {
                    by1Var = (by1) obj;
                } else {
                    by1Var = new by1(this.mSwanApiContext);
                    this.mApis.put("1372680763", by1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(by1Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.stopAccelerometer")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 B = by1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                ey1 ey1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof ey1)) {
                    ey1Var = (ey1) obj;
                } else {
                    ey1Var = new ey1(this.mSwanApiContext);
                    this.mApis.put("1689255576", ey1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ey1Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.stopCompass")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 z = ey1Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naUtils", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                yy1 yy1Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof yy1)) {
                    yy1Var = (yy1) obj;
                } else {
                    yy1Var = new yy1(this.mSwanApiContext);
                    this.mApis.put("201194468", yy1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(yy1Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.addToDesktop")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 B = yy1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                uy1 uy1Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof uy1)) {
                    uy1Var = (uy1) obj;
                } else {
                    uy1Var = new uy1(this.mSwanApiContext);
                    this.mApis.put("-1412306947", uy1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(uy1Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.calcMD5")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = uy1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                vy1 vy1Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof vy1)) {
                    vy1Var = (vy1) obj;
                } else {
                    vy1Var = new vy1(this.mSwanApiContext);
                    this.mApis.put("1626415364", vy1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vy1Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.checkAppInstalled")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = vy1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                xy1 xy1Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof xy1)) {
                    xy1Var = (xy1) obj;
                } else {
                    xy1Var = new xy1(this.mSwanApiContext);
                    this.mApis.put("-836768778", xy1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(xy1Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfo")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = xy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                zy1 zy1Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof zy1)) {
                    zy1Var = (zy1) obj;
                } else {
                    zy1Var = new zy1(this.mSwanApiContext);
                    this.mApis.put("-810858308", zy1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(zy1Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.getPerformanceLevel")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = zy1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                dz1 dz1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof dz1)) {
                    dz1Var = (dz1) obj;
                } else {
                    dz1Var = new dz1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", dz1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(dz1Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.getSystemInfoAsync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 I = dz1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                az1 az1Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof az1)) {
                    az1Var = (az1) obj;
                } else {
                    az1Var = new az1(this.mSwanApiContext);
                    this.mApis.put("-2097727681", az1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(az1Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.handleException")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = az1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                wy1 wy1Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof wy1)) {
                    wy1Var = (wy1) obj;
                } else {
                    wy1Var = new wy1(this.mSwanApiContext);
                    this.mApis.put("2084449317", wy1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(wy1Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.hasCloseHandler")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = wy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                zb3 zb3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof zb3)) {
                    zb3Var = (zb3) obj;
                } else {
                    zb3Var = new zb3(this.mSwanApiContext);
                    this.mApis.put("1031678042", zb3Var);
                }
                Pair<Boolean, tz1> a = vz1.a(zb3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.hideCaptureScreenShareDialog")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = zb3Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                bz1 bz1Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof bz1)) {
                    bz1Var = (bz1) obj;
                } else {
                    bz1Var = new bz1(this.mSwanApiContext);
                    this.mApis.put("1751900130", bz1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(bz1Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.logToFile")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = bz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                ab3 ab3Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof ab3)) {
                    ab3Var = (ab3) obj;
                } else {
                    ab3Var = new ab3(this.mSwanApiContext);
                    this.mApis.put("1748196865", ab3Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ab3Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.preloadPackage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = ab3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                cz1 cz1Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof cz1)) {
                    cz1Var = (cz1) obj;
                } else {
                    cz1Var = new cz1(this.mSwanApiContext);
                    this.mApis.put("589529211", cz1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(cz1Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.previewImage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 B = cz1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                fz1 fz1Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof fz1)) {
                    fz1Var = (fz1) obj;
                } else {
                    fz1Var = new fz1(this.mSwanApiContext);
                    this.mApis.put("-577481801", fz1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(fz1Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.ubcFlowJar")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 I = fz1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                dz1 dz1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof dz1)) {
                    dz1Var = (dz1) obj;
                } else {
                    dz1Var = new dz1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", dz1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(dz1Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfoSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 E = dz1Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                dz1 dz1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof dz1)) {
                    dz1Var = (dz1) obj;
                } else {
                    dz1Var = new dz1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", dz1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(dz1Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.getSystemInfo")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 H = dz1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                dz1 dz1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof dz1)) {
                    dz1Var = (dz1) obj;
                } else {
                    dz1Var = new dz1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", dz1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(dz1Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.getSystemInfoSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 J = dz1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naWifi", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                ki3 ki3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ki3)) {
                    ki3Var = (ki3) obj;
                } else {
                    ki3Var = new ki3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ki3Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ki3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Wifi.connectWifi")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = ki3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                ki3 ki3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ki3)) {
                    ki3Var = (ki3) obj;
                } else {
                    ki3Var = new ki3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ki3Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ki3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Wifi.getConnectedWifi")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 B = ki3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                ki3 ki3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ki3)) {
                    ki3Var = (ki3) obj;
                } else {
                    ki3Var = new ki3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ki3Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ki3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Wifi.getWifiList")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 C = ki3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                ki3 ki3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ki3)) {
                    ki3Var = (ki3) obj;
                } else {
                    ki3Var = new ki3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ki3Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ki3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Wifi.startWifi")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 G = ki3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                ki3 ki3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ki3)) {
                    ki3Var = (ki3) obj;
                } else {
                    ki3Var = new ki3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ki3Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ki3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Wifi.stopWifi")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 H = ki3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final vv1 vv1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                bw1 bw1Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof bw1)) {
                    bw1Var = (bw1) obj;
                } else {
                    bw1Var = new bw1(this.mSwanApiContext);
                    this.mApis.put("1930258908", bw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(bw1Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Account.checkSession")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = bw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                cw1 cw1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof cw1)) {
                    cw1Var = (cw1) obj;
                } else {
                    cw1Var = new cw1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", cw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(cw1Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Account.getLoginCode")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 C = cw1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                dw1 dw1Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof dw1)) {
                    dw1Var = (dw1) obj;
                } else {
                    dw1Var = new dw1(this.mSwanApiContext);
                    this.mApis.put("1754780133", dw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(dw1Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Account.getOpenId")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = dw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                kv1 kv1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof kv1)) {
                    kv1Var = (kv1) obj;
                } else {
                    kv1Var = new kv1(this.mSwanApiContext);
                    this.mApis.put("-343998465", kv1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(kv1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Account.getUnionBDUSS")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = kv1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String login(String str) {
                cw1 cw1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof cw1)) {
                    cw1Var = (cw1) obj;
                } else {
                    cw1Var = new cw1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", cw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(cw1Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Account.login")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 I = cw1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                aw1 aw1Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof aw1)) {
                    aw1Var = (aw1) obj;
                } else {
                    aw1Var = new aw1(this.mSwanApiContext);
                    this.mApis.put("-337742792", aw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(aw1Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Account.isBaiduAccountSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = aw1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                cw1 cw1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof cw1)) {
                    cw1Var = (cw1) obj;
                } else {
                    cw1Var = new cw1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", cw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(cw1Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Account.isLoginSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 H = cw1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBasic", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                ew1 ew1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof ew1)) {
                    ew1Var = (ew1) obj;
                } else {
                    ew1Var = new ew1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", ew1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ew1Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Basic.loadSubPackage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 F = ew1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                ew1 ew1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof ew1)) {
                    ew1Var = (ew1) obj;
                } else {
                    ew1Var = new ew1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", ew1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ew1Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Basic.loadSubPackages")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 G = ew1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                lo1 lo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof lo1)) {
                    lo1Var = (lo1) obj;
                } else {
                    lo1Var = new lo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", lo1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(lo1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Bookshelf.deleteBookshelf")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 K = lo1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                lo1 lo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof lo1)) {
                    lo1Var = (lo1) obj;
                } else {
                    lo1Var = new lo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", lo1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(lo1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Bookshelf.insertBookshelf")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 P = lo1Var.P(str);
                if (P == null) {
                    return "";
                }
                return P.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                lo1 lo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof lo1)) {
                    lo1Var = (lo1) obj;
                } else {
                    lo1Var = new lo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", lo1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(lo1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Bookshelf.navigateToBookshelf")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 U = lo1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                lo1 lo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof lo1)) {
                    lo1Var = (lo1) obj;
                } else {
                    lo1Var = new lo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", lo1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(lo1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Bookshelf.queryBookshelf")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 V = lo1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                lo1 lo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof lo1)) {
                    lo1Var = (lo1) obj;
                } else {
                    lo1Var = new lo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", lo1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(lo1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Bookshelf.updateBookshelfReadTime")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 X = lo1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naCoupon", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                yv1 yv1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof yv1)) {
                    yv1Var = (yv1) obj;
                } else {
                    yv1Var = new yv1(this.mSwanApiContext);
                    this.mApis.put("-277316359", yv1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(yv1Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Coupon.getPlatformCoupons")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = yv1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                yv1 yv1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof yv1)) {
                    yv1Var = (yv1) obj;
                } else {
                    yv1Var = new yv1(this.mSwanApiContext);
                    this.mApis.put("-277316359", yv1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(yv1Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Coupon.getUserCoupons")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 z = yv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                yv1 yv1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof yv1)) {
                    yv1Var = (yv1) obj;
                } else {
                    yv1Var = new yv1(this.mSwanApiContext);
                    this.mApis.put("-277316359", yv1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(yv1Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Coupon.takeCoupons")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 C = yv1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naFavorite", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                gw1 gw1Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof gw1)) {
                    gw1Var = (gw1) obj;
                } else {
                    gw1Var = new gw1(this.mSwanApiContext);
                    this.mApis.put("-1225406515", gw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(gw1Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Favorite.getFavorStatus")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = gw1Var.x(str);
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
                Pair<Boolean, tz1> a = vz1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Favorite.showFavoriteGuide")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 G = showFavoriteGuideApi.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naFile", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                iw1 iw1Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("-2057135077", iw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(iw1Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "File.shareFile")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = iw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                xk2 xk2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof xk2)) {
                    xk2Var = (xk2) obj;
                } else {
                    xk2Var = new xk2(this.mSwanApiContext);
                    this.mApis.put("2077414795", xk2Var);
                }
                Pair<Boolean, tz1> a = vz1.a(xk2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = xk2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                xk2 xk2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof xk2)) {
                    xk2Var = (xk2) obj;
                } else {
                    xk2Var = new xk2(this.mSwanApiContext);
                    this.mApis.put("2077414795", xk2Var);
                }
                Pair<Boolean, tz1> a = vz1.a(xk2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessageSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = xk2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String download(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", jw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(jw1Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "HostDownloadManager.download")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = jw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", jw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(jw1Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "HostDownloadManager.openFile")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 z = jw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String query(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", jw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(jw1Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "HostDownloadManager.query")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 query = jw1Var.query(str);
                if (query == null) {
                    return "";
                }
                return query.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                jw1 jw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", jw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(jw1Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "HostDownloadManager.openDownloadCenter")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = jw1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naImage", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                lx2 lx2Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof lx2)) {
                    lx2Var = (lx2) obj;
                } else {
                    lx2Var = new lx2(this.mSwanApiContext);
                    this.mApis.put("1445003743", lx2Var);
                }
                Pair<Boolean, tz1> a = vz1.a(lx2Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Image.callImageMenu")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = lx2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                mw1 mw1Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("-1252730367", mw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(mw1Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Image.compressImage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = mw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naInteraction", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                uw1 uw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof uw1)) {
                    uw1Var = (uw1) obj;
                } else {
                    uw1Var = new uw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", uw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(uw1Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.closeTabBar")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = uw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                uw1 uw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof uw1)) {
                    uw1Var = (uw1) obj;
                } else {
                    uw1Var = new uw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", uw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(uw1Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.closeTabBarRedDot")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = uw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                qw1 qw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof qw1)) {
                    qw1Var = (qw1) obj;
                } else {
                    qw1Var = new qw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", qw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(qw1Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.hideNavigationBarLoading")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = qw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                sw1 sw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof sw1)) {
                    sw1Var = (sw1) obj;
                } else {
                    sw1Var = new sw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", sw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(sw1Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.openMultiPicker")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 G = sw1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                sw1 sw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof sw1)) {
                    sw1Var = (sw1) obj;
                } else {
                    sw1Var = new sw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", sw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(sw1Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.openPicker")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 H = sw1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                uw1 uw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof uw1)) {
                    uw1Var = (uw1) obj;
                } else {
                    uw1Var = new uw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", uw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(uw1Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.openTabBar")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 C = uw1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                rw1 rw1Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("-1750613704", rw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(rw1Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.pageScrollTo")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = rw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                qw1 qw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof qw1)) {
                    qw1Var = (qw1) obj;
                } else {
                    qw1Var = new qw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", qw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(qw1Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarColor")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 z = qw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                qw1 qw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof qw1)) {
                    qw1Var = (qw1) obj;
                } else {
                    qw1Var = new qw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", qw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(qw1Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarTitle")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = qw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                uw1 uw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof uw1)) {
                    uw1Var = (uw1) obj;
                } else {
                    uw1Var = new uw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", uw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(uw1Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.setTabBarItem")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 D = uw1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                sw1 sw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof sw1)) {
                    sw1Var = (sw1) obj;
                } else {
                    sw1Var = new sw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", sw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(sw1Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.showDatePickerView")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 L = sw1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                ww1 ww1Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof ww1)) {
                    ww1Var = (ww1) obj;
                } else {
                    ww1Var = new ww1(this.mSwanApiContext);
                    this.mApis.put("1172469410", ww1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ww1Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.showHalfScreenWebview")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 K = ww1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                ow1 ow1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof ow1)) {
                    ow1Var = (ow1) obj;
                } else {
                    ow1Var = new ow1(this.mSwanApiContext);
                    this.mApis.put("5236036", ow1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ow1Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.showLoading")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = ow1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                pw1 pw1Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof pw1)) {
                    pw1Var = (pw1) obj;
                } else {
                    pw1Var = new pw1(this.mSwanApiContext);
                    this.mApis.put("1913747800", pw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(pw1Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.showModal")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = pw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                qw1 qw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof qw1)) {
                    qw1Var = (qw1) obj;
                } else {
                    qw1Var = new qw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", qw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(qw1Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.showNavigationBarLoading")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 B = qw1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                vw1 vw1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("1159492510", vw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vw1Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.showToast")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 Q = vw1Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("1165118609", tw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(tw1Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.stopPullDownRefresh")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = tw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                sw1 sw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof sw1)) {
                    sw1Var = (sw1) obj;
                } else {
                    sw1Var = new sw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", sw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(sw1Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.updateMultiPicker")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 M = sw1Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                ow1 ow1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof ow1)) {
                    ow1Var = (ow1) obj;
                } else {
                    ow1Var = new ow1(this.mSwanApiContext);
                    this.mApis.put("5236036", ow1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ow1Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.hideLoading")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = ow1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hideToast() {
                vw1 vw1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("1159492510", vw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vw1Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Interaction.hideToast")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 K = vw1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                xw1 xw1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof xw1)) {
                    xw1Var = (xw1) obj;
                } else {
                    xw1Var = new xw1(this.mSwanApiContext);
                    this.mApis.put("-137346255", xw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(xw1Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Keyboard.startKeyboardHeightChange")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 C = xw1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                xw1 xw1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof xw1)) {
                    xw1Var = (xw1) obj;
                } else {
                    xw1Var = new xw1(this.mSwanApiContext);
                    this.mApis.put("-137346255", xw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(xw1Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Keyboard.stopKeyboardHeightChange")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 D = xw1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naLocationService", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                yw1 yw1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof yw1)) {
                    yw1Var = (yw1) obj;
                } else {
                    yw1Var = new yw1(this.mSwanApiContext);
                    this.mApis.put("-397373095", yw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(yw1Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "LocationService.getLocation")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = yw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                yw1 yw1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof yw1)) {
                    yw1Var = (yw1) obj;
                } else {
                    yw1Var = new yw1(this.mSwanApiContext);
                    this.mApis.put("-397373095", yw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(yw1Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "LocationService.startLocationUpdate")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = yw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                yw1 yw1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof yw1)) {
                    yw1Var = (yw1) obj;
                } else {
                    yw1Var = new yw1(this.mSwanApiContext);
                    this.mApis.put("-397373095", yw1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(yw1Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "LocationService.stopLocationUpdate")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 B = yw1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naMenu", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                py1 py1Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof py1)) {
                    py1Var = (py1) obj;
                } else {
                    py1Var = new py1(this.mSwanApiContext);
                    this.mApis.put("538070032", py1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(py1Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = py1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naNetwork", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                bx1 bx1Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof bx1)) {
                    bx1Var = (bx1) obj;
                } else {
                    bx1Var = new bx1(this.mSwanApiContext);
                    this.mApis.put("-1076509454", bx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(bx1Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Network.callService")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = bx1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                ix1 ix1Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof ix1)) {
                    ix1Var = (ix1) obj;
                } else {
                    ix1Var = new ix1(this.mSwanApiContext);
                    this.mApis.put("968563034", ix1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ix1Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Network.cancelRequest")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 D = ix1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                hx1 hx1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof hx1)) {
                    hx1Var = (hx1) obj;
                } else {
                    hx1Var = new hx1(this.mSwanApiContext);
                    this.mApis.put("453220699", hx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(hx1Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Network.networkStatusChange")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = hx1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                hx1 hx1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof hx1)) {
                    hx1Var = (hx1) obj;
                } else {
                    hx1Var = new hx1(this.mSwanApiContext);
                    this.mApis.put("453220699", hx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(hx1Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Network.getNetworkType")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = hx1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(String str) {
                ix1 ix1Var;
                String a;
                try {
                    sz1.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof ix1)) {
                        ix1Var = (ix1) obj;
                    } else {
                        ix1Var = new ix1(this.mSwanApiContext);
                        this.mApis.put("968563034", ix1Var);
                    }
                    Pair<Boolean, tz1> a2 = vz1.a(ix1Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((tz1) a2.second).a();
                    } else if (ba2.a(this.mSwanApiContext.f(), "Network.request")) {
                        a = new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<tz1, JSONObject> u = xv1.u(str);
                        if (!((tz1) u.first).isSuccess()) {
                            a = ((tz1) u.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) u.second;
                            if (jSONObject == null) {
                                a = tz1.a.a();
                            } else {
                                uz1 V = ix1Var.V(jSONObject);
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
                        sz1.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                r03 r03Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof r03)) {
                    r03Var = (r03) obj;
                } else {
                    r03Var = new r03(this.mSwanApiContext);
                    this.mApis.put("-336396851", r03Var);
                }
                Pair<Boolean, tz1> a = vz1.a(r03Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Payment.chooseCoupon")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = r03Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                r03 r03Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof r03)) {
                    r03Var = (r03) obj;
                } else {
                    r03Var = new r03(this.mSwanApiContext);
                    this.mApis.put("-336396851", r03Var);
                }
                Pair<Boolean, tz1> a = vz1.a(r03Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Payment.getPaymentInfo")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = r03Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                h03 h03Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof h03)) {
                    h03Var = (h03) obj;
                } else {
                    h03Var = new h03(this.mSwanApiContext);
                    this.mApis.put("1854689529", h03Var);
                }
                Pair<Boolean, tz1> a = vz1.a(h03Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Payment.requestThirdPayment")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = h03Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                r03 r03Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof r03)) {
                    r03Var = (r03) obj;
                } else {
                    r03Var = new r03(this.mSwanApiContext);
                    this.mApis.put("-336396851", r03Var);
                }
                Pair<Boolean, tz1> a = vz1.a(r03Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Payment.setPaymentInfo")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 z = r03Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPlugin", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                c33 c33Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof c33)) {
                    c33Var = (c33) obj;
                } else {
                    c33Var = new c33(this.mSwanApiContext);
                    this.mApis.put("-254510461", c33Var);
                }
                Pair<Boolean, tz1> a = vz1.a(c33Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Plugin.invokePluginChooseAddress")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = c33Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                c33 c33Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof c33)) {
                    c33Var = (c33) obj;
                } else {
                    c33Var = new c33(this.mSwanApiContext);
                    this.mApis.put("-254510461", c33Var);
                }
                Pair<Boolean, tz1> a = vz1.a(c33Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 z = c33Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                c33 c33Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof c33)) {
                    c33Var = (c33) obj;
                } else {
                    c33Var = new c33(this.mSwanApiContext);
                    this.mApis.put("-254510461", c33Var);
                }
                Pair<Boolean, tz1> a = vz1.a(c33Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Plugin.invokePluginPayment")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = c33Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                vb2 vb2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof vb2)) {
                    vb2Var = (vb2) obj;
                } else {
                    vb2Var = new vb2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", vb2Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vb2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Prefetch.prefetchResources")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = vb2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPreload", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                na2 na2Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof na2)) {
                    na2Var = (na2) obj;
                } else {
                    na2Var = new na2(this.mSwanApiContext);
                    this.mApis.put("423661539", na2Var);
                }
                Pair<Boolean, tz1> a = vz1.a(na2Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Preload.preloadStatus")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = na2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                xj3 xj3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof xj3)) {
                    xj3Var = (xj3) obj;
                } else {
                    xj3Var = new xj3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", xj3Var);
                }
                Pair<Boolean, tz1> a = vz1.a(xj3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "PrivateFile.uploadFileToBos")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 C = xj3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naRouter", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                mx1 mx1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof mx1)) {
                    mx1Var = (mx1) obj;
                } else {
                    mx1Var = new mx1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", mx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(mx1Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Router.hideModalPage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = mx1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                mx1 mx1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof mx1)) {
                    mx1Var = (mx1) obj;
                } else {
                    mx1Var = new mx1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", mx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(mx1Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Router.navigateBack")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 B = mx1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                nx1 nx1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof nx1)) {
                    nx1Var = (nx1) obj;
                } else {
                    nx1Var = new nx1(this.mSwanApiContext);
                    this.mApis.put("1968522584", nx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(nx1Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Router.navigateTo")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 H = nx1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                px1 px1Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof px1)) {
                    px1Var = (px1) obj;
                } else {
                    px1Var = new px1(this.mSwanApiContext);
                    this.mApis.put("1317280190", px1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(px1Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Router.reLaunch")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = px1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                qx1 qx1Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("-420075743", qx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(qx1Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Router.reLoadErrorPage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = qx1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                ox1 ox1Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof ox1)) {
                    ox1Var = (ox1) obj;
                } else {
                    ox1Var = new ox1(this.mSwanApiContext);
                    this.mApis.put("1792515533", ox1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ox1Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Router.redirectTo")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 D = ox1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                nx1 nx1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof nx1)) {
                    nx1Var = (nx1) obj;
                } else {
                    nx1Var = new nx1(this.mSwanApiContext);
                    this.mApis.put("1968522584", nx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(nx1Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Router.showModalPage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 J = nx1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naSetting", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                tx1 tx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof tx1)) {
                    tx1Var = (tx1) obj;
                } else {
                    tx1Var = new tx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", tx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(tx1Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Setting.getAppInfoSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 F = tx1Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                tx1 tx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof tx1)) {
                    tx1Var = (tx1) obj;
                } else {
                    tx1Var = new tx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", tx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(tx1Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Setting.getSlaveIdSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 H = tx1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                sx1 sx1Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof sx1)) {
                    sx1Var = (sx1) obj;
                } else {
                    sx1Var = new sx1(this.mSwanApiContext);
                    this.mApis.put("450273045", sx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(sx1Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Setting.isAllowedAdOpenAppSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = sx1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                tx1 tx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof tx1)) {
                    tx1Var = (tx1) obj;
                } else {
                    tx1Var = new tx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", tx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(tx1Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Setting.getSetting")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 G = tx1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                tx1 tx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof tx1)) {
                    tx1Var = (tx1) obj;
                } else {
                    tx1Var = new tx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", tx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(tx1Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Setting.getSwanId")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 I = tx1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                tx1 tx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof tx1)) {
                    tx1Var = (tx1) obj;
                } else {
                    tx1Var = new tx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", tx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(tx1Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Setting.getUserInfo")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 J = tx1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                re3 re3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof re3)) {
                    re3Var = (re3) obj;
                } else {
                    re3Var = new re3(this.mSwanApiContext);
                    this.mApis.put("712777136", re3Var);
                }
                Pair<Boolean, tz1> a = vz1.a(re3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = re3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naStorage", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                wx1 wx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", wx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(wx1Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = wx1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                wx1 wx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", wx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(wx1Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorageSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 C = wx1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                vx1 vx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("130910081", vx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vx1Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.clearStorage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = vx1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                vx1 vx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("130910081", vx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vx1Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.clearStorageSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 C = vx1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                wx1 wx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", wx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(wx1Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfo")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 G = wx1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                wx1 wx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", wx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(wx1Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfoSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 J = wx1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                vx1 vx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("130910081", vx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vx1Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.getStorageInfo")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 G = vx1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                vx1 vx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("130910081", vx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vx1Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.getStorageInfoSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 J = vx1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", wx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(wx1Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 D = wx1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", wx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(wx1Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 K = wx1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("130910081", vx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vx1Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.getStorage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 D = vx1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("130910081", vx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vx1Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.getStorageInfoAsync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 H = vx1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("130910081", vx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vx1Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.getStorageSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 K = vx1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", wx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(wx1Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 R = wx1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", wx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(wx1Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorageSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 T = wx1Var.T(str);
                if (T == null) {
                    return "";
                }
                return T.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("130910081", vx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vx1Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.removeStorage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 R = vx1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("130910081", vx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vx1Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.removeStorageSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 T = vx1Var.T(str);
                if (T == null) {
                    return "";
                }
                return T.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", wx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(wx1Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.setGlobalStorage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 U = wx1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", wx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(wx1Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.setGlobalStorageSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 W = wx1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("130910081", vx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vx1Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.setStorage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 U = vx1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("130910081", vx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vx1Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Storage.setStorageSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 W = vx1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }
        });
        hashMap.put("_naSubscription", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                yx1 yx1Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("823117982", yx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(yx1Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Subscription.requestSubscribeFormId")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 E = yx1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                zx1 zx1Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof zx1)) {
                    zx1Var = (zx1) obj;
                } else {
                    zx1Var = new zx1(this.mSwanApiContext);
                    this.mApis.put("-947445811", zx1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(zx1Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Subscription.subscribeService")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 F = zx1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }
        });
        hashMap.put("_naSystem", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                gy1 gy1Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof gy1)) {
                    gy1Var = (gy1) obj;
                } else {
                    gy1Var = new gy1(this.mSwanApiContext);
                    this.mApis.put("1936205521", gy1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(gy1Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.exitFullScreen")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = gy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                fy1 fy1Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof fy1)) {
                    fy1Var = (fy1) obj;
                } else {
                    fy1Var = new fy1(this.mSwanApiContext);
                    this.mApis.put("1694151270", fy1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(fy1Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.getDeviceInfo")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = fy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                hy1 hy1Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof hy1)) {
                    hy1Var = (hy1) obj;
                } else {
                    hy1Var = new hy1(this.mSwanApiContext);
                    this.mApis.put("-1321681619", hy1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(hy1Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.getDeviceProfile")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = hy1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                iy1 iy1Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof iy1)) {
                    iy1Var = (iy1) obj;
                } else {
                    iy1Var = new iy1(this.mSwanApiContext);
                    this.mApis.put("-1569246082", iy1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(iy1Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.makePhoneCall")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = iy1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                ky1 ky1Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof ky1)) {
                    ky1Var = (ky1) obj;
                } else {
                    ky1Var = new ky1(this.mSwanApiContext);
                    this.mApis.put("1099851202", ky1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ky1Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.openSMSPanel")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = ky1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                jy1 jy1Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof jy1)) {
                    jy1Var = (jy1) obj;
                } else {
                    jy1Var = new jy1(this.mSwanApiContext);
                    this.mApis.put("-1707203360", jy1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(jy1Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.requestFullScreen")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 F = jy1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                dy1 dy1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof dy1)) {
                    dy1Var = (dy1) obj;
                } else {
                    dy1Var = new dy1(this.mSwanApiContext);
                    this.mApis.put("-518757484", dy1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(dy1Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.setClipboardData")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = dy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                nx2 nx2Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof nx2)) {
                    nx2Var = (nx2) obj;
                } else {
                    nx2Var = new nx2(this.mSwanApiContext);
                    this.mApis.put("1161486049", nx2Var);
                }
                Pair<Boolean, tz1> a = vz1.a(nx2Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.setErrorPageType")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = nx2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                ny1 ny1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof ny1)) {
                    ny1Var = (ny1) obj;
                } else {
                    ny1Var = new ny1(this.mSwanApiContext);
                    this.mApis.put("447234992", ny1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ny1Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.setMediaVolume")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 z = ny1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                by1 by1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof by1)) {
                    by1Var = (by1) obj;
                } else {
                    by1Var = new by1(this.mSwanApiContext);
                    this.mApis.put("1372680763", by1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(by1Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.startAccelerometer")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = by1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                ey1 ey1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof ey1)) {
                    ey1Var = (ey1) obj;
                } else {
                    ey1Var = new ey1(this.mSwanApiContext);
                    this.mApis.put("1689255576", ey1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ey1Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.startCompass")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = ey1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                cy1 cy1Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof cy1)) {
                    cy1Var = (cy1) obj;
                } else {
                    cy1Var = new cy1(this.mSwanApiContext);
                    this.mApis.put("99997465", cy1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(cy1Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.getBrightness")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = cy1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                dy1 dy1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof dy1)) {
                    dy1Var = (dy1) obj;
                } else {
                    dy1Var = new dy1(this.mSwanApiContext);
                    this.mApis.put("-518757484", dy1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(dy1Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.getClipboardData")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = dy1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                ny1 ny1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof ny1)) {
                    ny1Var = (ny1) obj;
                } else {
                    ny1Var = new ny1(this.mSwanApiContext);
                    this.mApis.put("447234992", ny1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ny1Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.getMediaVolume")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = ny1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                by1 by1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof by1)) {
                    by1Var = (by1) obj;
                } else {
                    by1Var = new by1(this.mSwanApiContext);
                    this.mApis.put("1372680763", by1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(by1Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.stopAccelerometer")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 B = by1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                ey1 ey1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof ey1)) {
                    ey1Var = (ey1) obj;
                } else {
                    ey1Var = new ey1(this.mSwanApiContext);
                    this.mApis.put("1689255576", ey1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ey1Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "System.stopCompass")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 z = ey1Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naUtils", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                yy1 yy1Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof yy1)) {
                    yy1Var = (yy1) obj;
                } else {
                    yy1Var = new yy1(this.mSwanApiContext);
                    this.mApis.put("201194468", yy1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(yy1Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.addToDesktop")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 B = yy1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                uy1 uy1Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof uy1)) {
                    uy1Var = (uy1) obj;
                } else {
                    uy1Var = new uy1(this.mSwanApiContext);
                    this.mApis.put("-1412306947", uy1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(uy1Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.calcMD5")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = uy1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                vy1 vy1Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof vy1)) {
                    vy1Var = (vy1) obj;
                } else {
                    vy1Var = new vy1(this.mSwanApiContext);
                    this.mApis.put("1626415364", vy1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(vy1Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.checkAppInstalled")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = vy1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                xy1 xy1Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof xy1)) {
                    xy1Var = (xy1) obj;
                } else {
                    xy1Var = new xy1(this.mSwanApiContext);
                    this.mApis.put("-836768778", xy1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(xy1Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfo")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = xy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                zy1 zy1Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof zy1)) {
                    zy1Var = (zy1) obj;
                } else {
                    zy1Var = new zy1(this.mSwanApiContext);
                    this.mApis.put("-810858308", zy1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(zy1Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.getPerformanceLevel")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = zy1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                dz1 dz1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof dz1)) {
                    dz1Var = (dz1) obj;
                } else {
                    dz1Var = new dz1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", dz1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(dz1Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.getSystemInfoAsync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 I = dz1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                az1 az1Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof az1)) {
                    az1Var = (az1) obj;
                } else {
                    az1Var = new az1(this.mSwanApiContext);
                    this.mApis.put("-2097727681", az1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(az1Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.handleException")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = az1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                wy1 wy1Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof wy1)) {
                    wy1Var = (wy1) obj;
                } else {
                    wy1Var = new wy1(this.mSwanApiContext);
                    this.mApis.put("2084449317", wy1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(wy1Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.hasCloseHandler")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = wy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                zb3 zb3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof zb3)) {
                    zb3Var = (zb3) obj;
                } else {
                    zb3Var = new zb3(this.mSwanApiContext);
                    this.mApis.put("1031678042", zb3Var);
                }
                Pair<Boolean, tz1> a = vz1.a(zb3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.hideCaptureScreenShareDialog")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 x = zb3Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                bz1 bz1Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof bz1)) {
                    bz1Var = (bz1) obj;
                } else {
                    bz1Var = new bz1(this.mSwanApiContext);
                    this.mApis.put("1751900130", bz1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(bz1Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.logToFile")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = bz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                ab3 ab3Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof ab3)) {
                    ab3Var = (ab3) obj;
                } else {
                    ab3Var = new ab3(this.mSwanApiContext);
                    this.mApis.put("1748196865", ab3Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ab3Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.preloadPackage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = ab3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                cz1 cz1Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof cz1)) {
                    cz1Var = (cz1) obj;
                } else {
                    cz1Var = new cz1(this.mSwanApiContext);
                    this.mApis.put("589529211", cz1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(cz1Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.previewImage")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 B = cz1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                fz1 fz1Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof fz1)) {
                    fz1Var = (fz1) obj;
                } else {
                    fz1Var = new fz1(this.mSwanApiContext);
                    this.mApis.put("-577481801", fz1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(fz1Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.ubcFlowJar")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 I = fz1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                dz1 dz1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof dz1)) {
                    dz1Var = (dz1) obj;
                } else {
                    dz1Var = new dz1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", dz1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(dz1Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfoSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 E = dz1Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                dz1 dz1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof dz1)) {
                    dz1Var = (dz1) obj;
                } else {
                    dz1Var = new dz1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", dz1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(dz1Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.getSystemInfo")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 H = dz1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                dz1 dz1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof dz1)) {
                    dz1Var = (dz1) obj;
                } else {
                    dz1Var = new dz1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", dz1Var);
                }
                Pair<Boolean, tz1> a = vz1.a(dz1Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Utils.getSystemInfoSync")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 J = dz1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naWifi", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                ki3 ki3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ki3)) {
                    ki3Var = (ki3) obj;
                } else {
                    ki3Var = new ki3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ki3Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ki3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Wifi.connectWifi")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 A = ki3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                ki3 ki3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ki3)) {
                    ki3Var = (ki3) obj;
                } else {
                    ki3Var = new ki3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ki3Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ki3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Wifi.getConnectedWifi")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 B = ki3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                ki3 ki3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ki3)) {
                    ki3Var = (ki3) obj;
                } else {
                    ki3Var = new ki3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ki3Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ki3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Wifi.getWifiList")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 C = ki3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                ki3 ki3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ki3)) {
                    ki3Var = (ki3) obj;
                } else {
                    ki3Var = new ki3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ki3Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ki3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Wifi.startWifi")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 G = ki3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                ki3 ki3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ki3)) {
                    ki3Var = (ki3) obj;
                } else {
                    ki3Var = new ki3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ki3Var);
                }
                Pair<Boolean, tz1> a = vz1.a(ki3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "Wifi.stopWifi")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 H = ki3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }
}
