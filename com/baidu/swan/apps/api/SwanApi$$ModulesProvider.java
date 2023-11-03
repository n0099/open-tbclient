package com.baidu.swan.apps.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.tieba.aw1;
import com.baidu.tieba.ax1;
import com.baidu.tieba.bv1;
import com.baidu.tieba.bw1;
import com.baidu.tieba.cv1;
import com.baidu.tieba.cw1;
import com.baidu.tieba.cx1;
import com.baidu.tieba.dd3;
import com.baidu.tieba.dv1;
import com.baidu.tieba.dw1;
import com.baidu.tieba.dz2;
import com.baidu.tieba.ev1;
import com.baidu.tieba.fv1;
import com.baidu.tieba.fw1;
import com.baidu.tieba.fy1;
import com.baidu.tieba.gv1;
import com.baidu.tieba.gw1;
import com.baidu.tieba.gy1;
import com.baidu.tieba.ha2;
import com.baidu.tieba.hv1;
import com.baidu.tieba.hx1;
import com.baidu.tieba.hy1;
import com.baidu.tieba.iu1;
import com.baidu.tieba.iv1;
import com.baidu.tieba.iw1;
import com.baidu.tieba.ix1;
import com.baidu.tieba.iy1;
import com.baidu.tieba.ji3;
import com.baidu.tieba.jj2;
import com.baidu.tieba.jv1;
import com.baidu.tieba.jw1;
import com.baidu.tieba.jx1;
import com.baidu.tieba.ku1;
import com.baidu.tieba.kv1;
import com.baidu.tieba.kx1;
import com.baidu.tieba.la3;
import com.baidu.tieba.lu1;
import com.baidu.tieba.lv1;
import com.baidu.tieba.lw1;
import com.baidu.tieba.lx1;
import com.baidu.tieba.m93;
import com.baidu.tieba.mw1;
import com.baidu.tieba.mx1;
import com.baidu.tieba.n82;
import com.baidu.tieba.nu1;
import com.baidu.tieba.nx1;
import com.baidu.tieba.o13;
import com.baidu.tieba.ou1;
import com.baidu.tieba.ov1;
import com.baidu.tieba.ow1;
import com.baidu.tieba.ox1;
import com.baidu.tieba.pu1;
import com.baidu.tieba.pw1;
import com.baidu.tieba.px1;
import com.baidu.tieba.qu1;
import com.baidu.tieba.qw1;
import com.baidu.tieba.qx1;
import com.baidu.tieba.ru1;
import com.baidu.tieba.rw1;
import com.baidu.tieba.sw1;
import com.baidu.tieba.sx1;
import com.baidu.tieba.tu1;
import com.baidu.tieba.tw1;
import com.baidu.tieba.ty2;
import com.baidu.tieba.uv1;
import com.baidu.tieba.uw1;
import com.baidu.tieba.vu1;
import com.baidu.tieba.vv1;
import com.baidu.tieba.vw1;
import com.baidu.tieba.wg3;
import com.baidu.tieba.wu1;
import com.baidu.tieba.ww1;
import com.baidu.tieba.xt1;
import com.baidu.tieba.xv2;
import com.baidu.tieba.xw1;
import com.baidu.tieba.ym1;
import com.baidu.tieba.z82;
import com.baidu.tieba.zu1;
import com.baidu.tieba.zv1;
import com.baidu.tieba.zv2;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
@Keep
/* loaded from: classes4.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final iu1 iu1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                ou1 ou1Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof ou1)) {
                    ou1Var = (ou1) obj;
                } else {
                    ou1Var = new ou1(this.mSwanApiContext);
                    this.mApis.put("1930258908", ou1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ou1Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Account.checkSession")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = ou1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                pu1 pu1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof pu1)) {
                    pu1Var = (pu1) obj;
                } else {
                    pu1Var = new pu1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", pu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(pu1Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Account.getLoginCode")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 D = pu1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                qu1 qu1Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof qu1)) {
                    qu1Var = (qu1) obj;
                } else {
                    qu1Var = new qu1(this.mSwanApiContext);
                    this.mApis.put("1754780133", qu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(qu1Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Account.getOpenId")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = qu1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                xt1 xt1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof xt1)) {
                    xt1Var = (xt1) obj;
                } else {
                    xt1Var = new xt1(this.mSwanApiContext);
                    this.mApis.put("-343998465", xt1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(xt1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Account.getUnionBDUSS")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = xt1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String login(String str) {
                pu1 pu1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof pu1)) {
                    pu1Var = (pu1) obj;
                } else {
                    pu1Var = new pu1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", pu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(pu1Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Account.login")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 J = pu1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                nu1 nu1Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof nu1)) {
                    nu1Var = (nu1) obj;
                } else {
                    nu1Var = new nu1(this.mSwanApiContext);
                    this.mApis.put("-337742792", nu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(nu1Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Account.isBaiduAccountSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = nu1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                pu1 pu1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof pu1)) {
                    pu1Var = (pu1) obj;
                } else {
                    pu1Var = new pu1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", pu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(pu1Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Account.isLoginSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 I = pu1Var.I();
                if (I == null) {
                    return "";
                }
                return I.a();
            }
        });
        hashMap.put("_naBasic", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                ru1 ru1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof ru1)) {
                    ru1Var = (ru1) obj;
                } else {
                    ru1Var = new ru1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", ru1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ru1Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Basic.loadSubPackage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 G = ru1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                ru1 ru1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof ru1)) {
                    ru1Var = (ru1) obj;
                } else {
                    ru1Var = new ru1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", ru1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ru1Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Basic.loadSubPackages")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 H = ru1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                ym1 ym1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ym1)) {
                    ym1Var = (ym1) obj;
                } else {
                    ym1Var = new ym1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ym1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ym1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Bookshelf.deleteBookshelf")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 L = ym1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                ym1 ym1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ym1)) {
                    ym1Var = (ym1) obj;
                } else {
                    ym1Var = new ym1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ym1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ym1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Bookshelf.insertBookshelf")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 Q = ym1Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                ym1 ym1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ym1)) {
                    ym1Var = (ym1) obj;
                } else {
                    ym1Var = new ym1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ym1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ym1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Bookshelf.navigateToBookshelf")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 V = ym1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                ym1 ym1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ym1)) {
                    ym1Var = (ym1) obj;
                } else {
                    ym1Var = new ym1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ym1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ym1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Bookshelf.queryBookshelf")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 W = ym1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                ym1 ym1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ym1)) {
                    ym1Var = (ym1) obj;
                } else {
                    ym1Var = new ym1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ym1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ym1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Bookshelf.updateBookshelfReadTime")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 Y = ym1Var.Y(str);
                if (Y == null) {
                    return "";
                }
                return Y.a();
            }
        });
        hashMap.put("_naCoupon", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                lu1 lu1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof lu1)) {
                    lu1Var = (lu1) obj;
                } else {
                    lu1Var = new lu1(this.mSwanApiContext);
                    this.mApis.put("-277316359", lu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(lu1Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Coupon.getPlatformCoupons")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = lu1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                lu1 lu1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof lu1)) {
                    lu1Var = (lu1) obj;
                } else {
                    lu1Var = new lu1(this.mSwanApiContext);
                    this.mApis.put("-277316359", lu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(lu1Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Coupon.getUserCoupons")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 A = lu1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                lu1 lu1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof lu1)) {
                    lu1Var = (lu1) obj;
                } else {
                    lu1Var = new lu1(this.mSwanApiContext);
                    this.mApis.put("-277316359", lu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(lu1Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Coupon.takeCoupons")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 D = lu1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naFavorite", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                tu1 tu1Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof tu1)) {
                    tu1Var = (tu1) obj;
                } else {
                    tu1Var = new tu1(this.mSwanApiContext);
                    this.mApis.put("-1225406515", tu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(tu1Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Favorite.getFavorStatus")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = tu1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
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
                Pair<Boolean, gy1> a = iy1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Favorite.showFavoriteGuide")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 H = showFavoriteGuideApi.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naFile", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                vu1 vu1Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof vu1)) {
                    vu1Var = (vu1) obj;
                } else {
                    vu1Var = new vu1(this.mSwanApiContext);
                    this.mApis.put("-2057135077", vu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(vu1Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "File.shareFile")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = vu1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                jj2 jj2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof jj2)) {
                    jj2Var = (jj2) obj;
                } else {
                    jj2Var = new jj2(this.mSwanApiContext);
                    this.mApis.put("2077414795", jj2Var);
                }
                Pair<Boolean, gy1> a = iy1.a(jj2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = jj2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                jj2 jj2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof jj2)) {
                    jj2Var = (jj2) obj;
                } else {
                    jj2Var = new jj2(this.mSwanApiContext);
                    this.mApis.put("2077414795", jj2Var);
                }
                Pair<Boolean, gy1> a = iy1.a(jj2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessageSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = jj2Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String download(String str) {
                wu1 wu1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof wu1)) {
                    wu1Var = (wu1) obj;
                } else {
                    wu1Var = new wu1(this.mSwanApiContext);
                    this.mApis.put("-170124576", wu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(wu1Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "HostDownloadManager.download")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = wu1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                wu1 wu1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof wu1)) {
                    wu1Var = (wu1) obj;
                } else {
                    wu1Var = new wu1(this.mSwanApiContext);
                    this.mApis.put("-170124576", wu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(wu1Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "HostDownloadManager.openFile")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 A = wu1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String query(String str) {
                wu1 wu1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof wu1)) {
                    wu1Var = (wu1) obj;
                } else {
                    wu1Var = new wu1(this.mSwanApiContext);
                    this.mApis.put("-170124576", wu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(wu1Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "HostDownloadManager.query")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = wu1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                wu1 wu1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof wu1)) {
                    wu1Var = (wu1) obj;
                } else {
                    wu1Var = new wu1(this.mSwanApiContext);
                    this.mApis.put("-170124576", wu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(wu1Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "HostDownloadManager.openDownloadCenter")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = wu1Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naImage", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                xv2 xv2Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof xv2)) {
                    xv2Var = (xv2) obj;
                } else {
                    xv2Var = new xv2(this.mSwanApiContext);
                    this.mApis.put("1445003743", xv2Var);
                }
                Pair<Boolean, gy1> a = iy1.a(xv2Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Image.callImageMenu")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = xv2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                zu1 zu1Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof zu1)) {
                    zu1Var = (zu1) obj;
                } else {
                    zu1Var = new zu1(this.mSwanApiContext);
                    this.mApis.put("-1252730367", zu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(zu1Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Image.compressImage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = zu1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naInteraction", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                hv1 hv1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof hv1)) {
                    hv1Var = (hv1) obj;
                } else {
                    hv1Var = new hv1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", hv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(hv1Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.closeTabBar")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = hv1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                hv1 hv1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof hv1)) {
                    hv1Var = (hv1) obj;
                } else {
                    hv1Var = new hv1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", hv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(hv1Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.closeTabBarRedDot")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = hv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                dv1 dv1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof dv1)) {
                    dv1Var = (dv1) obj;
                } else {
                    dv1Var = new dv1(this.mSwanApiContext);
                    this.mApis.put("-246386074", dv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(dv1Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.hideNavigationBarLoading")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = dv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                fv1 fv1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof fv1)) {
                    fv1Var = (fv1) obj;
                } else {
                    fv1Var = new fv1(this.mSwanApiContext);
                    this.mApis.put("-108978463", fv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(fv1Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.openMultiPicker")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 H = fv1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                fv1 fv1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof fv1)) {
                    fv1Var = (fv1) obj;
                } else {
                    fv1Var = new fv1(this.mSwanApiContext);
                    this.mApis.put("-108978463", fv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(fv1Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.openPicker")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 I = fv1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                hv1 hv1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof hv1)) {
                    hv1Var = (hv1) obj;
                } else {
                    hv1Var = new hv1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", hv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(hv1Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.openTabBar")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 D = hv1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                ev1 ev1Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof ev1)) {
                    ev1Var = (ev1) obj;
                } else {
                    ev1Var = new ev1(this.mSwanApiContext);
                    this.mApis.put("-1750613704", ev1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ev1Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.pageScrollTo")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = ev1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                dv1 dv1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof dv1)) {
                    dv1Var = (dv1) obj;
                } else {
                    dv1Var = new dv1(this.mSwanApiContext);
                    this.mApis.put("-246386074", dv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(dv1Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarColor")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 A = dv1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                dv1 dv1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof dv1)) {
                    dv1Var = (dv1) obj;
                } else {
                    dv1Var = new dv1(this.mSwanApiContext);
                    this.mApis.put("-246386074", dv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(dv1Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarTitle")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = dv1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                hv1 hv1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof hv1)) {
                    hv1Var = (hv1) obj;
                } else {
                    hv1Var = new hv1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", hv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(hv1Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.setTabBarItem")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 E = hv1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                fv1 fv1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof fv1)) {
                    fv1Var = (fv1) obj;
                } else {
                    fv1Var = new fv1(this.mSwanApiContext);
                    this.mApis.put("-108978463", fv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(fv1Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.showDatePickerView")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 M = fv1Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                jv1 jv1Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof jv1)) {
                    jv1Var = (jv1) obj;
                } else {
                    jv1Var = new jv1(this.mSwanApiContext);
                    this.mApis.put("1172469410", jv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(jv1Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.showHalfScreenWebview")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 L = jv1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                bv1 bv1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof bv1)) {
                    bv1Var = (bv1) obj;
                } else {
                    bv1Var = new bv1(this.mSwanApiContext);
                    this.mApis.put("5236036", bv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(bv1Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.showLoading")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = bv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                cv1 cv1Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof cv1)) {
                    cv1Var = (cv1) obj;
                } else {
                    cv1Var = new cv1(this.mSwanApiContext);
                    this.mApis.put("1913747800", cv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(cv1Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.showModal")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = cv1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                dv1 dv1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof dv1)) {
                    dv1Var = (dv1) obj;
                } else {
                    dv1Var = new dv1(this.mSwanApiContext);
                    this.mApis.put("-246386074", dv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(dv1Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.showNavigationBarLoading")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 C = dv1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                iv1 iv1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof iv1)) {
                    iv1Var = (iv1) obj;
                } else {
                    iv1Var = new iv1(this.mSwanApiContext);
                    this.mApis.put("1159492510", iv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(iv1Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.showToast")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 R = iv1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                gv1 gv1Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof gv1)) {
                    gv1Var = (gv1) obj;
                } else {
                    gv1Var = new gv1(this.mSwanApiContext);
                    this.mApis.put("1165118609", gv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(gv1Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.stopPullDownRefresh")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = gv1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                fv1 fv1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof fv1)) {
                    fv1Var = (fv1) obj;
                } else {
                    fv1Var = new fv1(this.mSwanApiContext);
                    this.mApis.put("-108978463", fv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(fv1Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.updateMultiPicker")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 N = fv1Var.N(str);
                if (N == null) {
                    return "";
                }
                return N.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                bv1 bv1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof bv1)) {
                    bv1Var = (bv1) obj;
                } else {
                    bv1Var = new bv1(this.mSwanApiContext);
                    this.mApis.put("5236036", bv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(bv1Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.hideLoading")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = bv1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideToast() {
                iv1 iv1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof iv1)) {
                    iv1Var = (iv1) obj;
                } else {
                    iv1Var = new iv1(this.mSwanApiContext);
                    this.mApis.put("1159492510", iv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(iv1Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.hideToast")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 L = iv1Var.L();
                if (L == null) {
                    return "";
                }
                return L.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                kv1 kv1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof kv1)) {
                    kv1Var = (kv1) obj;
                } else {
                    kv1Var = new kv1(this.mSwanApiContext);
                    this.mApis.put("-137346255", kv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(kv1Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Keyboard.startKeyboardHeightChange")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 D = kv1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                kv1 kv1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof kv1)) {
                    kv1Var = (kv1) obj;
                } else {
                    kv1Var = new kv1(this.mSwanApiContext);
                    this.mApis.put("-137346255", kv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(kv1Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Keyboard.stopKeyboardHeightChange")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 E = kv1Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }
        });
        hashMap.put("_naLocationService", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                lv1 lv1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof lv1)) {
                    lv1Var = (lv1) obj;
                } else {
                    lv1Var = new lv1(this.mSwanApiContext);
                    this.mApis.put("-397373095", lv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(lv1Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "LocationService.getLocation")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = lv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                lv1 lv1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof lv1)) {
                    lv1Var = (lv1) obj;
                } else {
                    lv1Var = new lv1(this.mSwanApiContext);
                    this.mApis.put("-397373095", lv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(lv1Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "LocationService.startLocationUpdate")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = lv1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                lv1 lv1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof lv1)) {
                    lv1Var = (lv1) obj;
                } else {
                    lv1Var = new lv1(this.mSwanApiContext);
                    this.mApis.put("-397373095", lv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(lv1Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "LocationService.stopLocationUpdate")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 C = lv1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naMenu", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                cx1 cx1Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof cx1)) {
                    cx1Var = (cx1) obj;
                } else {
                    cx1Var = new cx1(this.mSwanApiContext);
                    this.mApis.put("538070032", cx1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(cx1Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = cx1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naNetwork", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                ov1 ov1Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof ov1)) {
                    ov1Var = (ov1) obj;
                } else {
                    ov1Var = new ov1(this.mSwanApiContext);
                    this.mApis.put("-1076509454", ov1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ov1Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Network.callService")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = ov1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                vv1 vv1Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof vv1)) {
                    vv1Var = (vv1) obj;
                } else {
                    vv1Var = new vv1(this.mSwanApiContext);
                    this.mApis.put("968563034", vv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(vv1Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Network.cancelRequest")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 E = vv1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                uv1 uv1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof uv1)) {
                    uv1Var = (uv1) obj;
                } else {
                    uv1Var = new uv1(this.mSwanApiContext);
                    this.mApis.put("453220699", uv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(uv1Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Network.networkStatusChange")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = uv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                uv1 uv1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof uv1)) {
                    uv1Var = (uv1) obj;
                } else {
                    uv1Var = new uv1(this.mSwanApiContext);
                    this.mApis.put("453220699", uv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(uv1Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Network.getNetworkType")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = uv1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(JsObject jsObject) {
                vv1 vv1Var;
                String a;
                try {
                    fy1.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof vv1)) {
                        vv1Var = (vv1) obj;
                    } else {
                        vv1Var = new vv1(this.mSwanApiContext);
                        this.mApis.put("968563034", vv1Var);
                    }
                    Pair<Boolean, gy1> a2 = iy1.a(vv1Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((gy1) a2.second).a();
                    } else if (n82.a(this.mSwanApiContext.e(), "Network.request")) {
                        a = new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<gy1, JSONObject> u = ku1.u(jsObject);
                        if (!((gy1) u.first).isSuccess()) {
                            a = ((gy1) u.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) u.second;
                            if (jSONObject == null) {
                                a = gy1.a.a();
                            } else {
                                hy1 W = vv1Var.W(jSONObject);
                                if (W == null) {
                                    a = "";
                                } else {
                                    a = W.a();
                                }
                            }
                        }
                    }
                    return a;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } finally {
                        fy1.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                dz2 dz2Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof dz2)) {
                    dz2Var = (dz2) obj;
                } else {
                    dz2Var = new dz2(this.mSwanApiContext);
                    this.mApis.put("-336396851", dz2Var);
                }
                Pair<Boolean, gy1> a = iy1.a(dz2Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Payment.chooseCoupon")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = dz2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                dz2 dz2Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof dz2)) {
                    dz2Var = (dz2) obj;
                } else {
                    dz2Var = new dz2(this.mSwanApiContext);
                    this.mApis.put("-336396851", dz2Var);
                }
                Pair<Boolean, gy1> a = iy1.a(dz2Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Payment.getPaymentInfo")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = dz2Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                ty2 ty2Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof ty2)) {
                    ty2Var = (ty2) obj;
                } else {
                    ty2Var = new ty2(this.mSwanApiContext);
                    this.mApis.put("1854689529", ty2Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ty2Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Payment.requestThirdPayment")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = ty2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                dz2 dz2Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof dz2)) {
                    dz2Var = (dz2) obj;
                } else {
                    dz2Var = new dz2(this.mSwanApiContext);
                    this.mApis.put("-336396851", dz2Var);
                }
                Pair<Boolean, gy1> a = iy1.a(dz2Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Payment.setPaymentInfo")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 A = dz2Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPlugin", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                o13 o13Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof o13)) {
                    o13Var = (o13) obj;
                } else {
                    o13Var = new o13(this.mSwanApiContext);
                    this.mApis.put("-254510461", o13Var);
                }
                Pair<Boolean, gy1> a = iy1.a(o13Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Plugin.invokePluginChooseAddress")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = o13Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                o13 o13Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof o13)) {
                    o13Var = (o13) obj;
                } else {
                    o13Var = new o13(this.mSwanApiContext);
                    this.mApis.put("-254510461", o13Var);
                }
                Pair<Boolean, gy1> a = iy1.a(o13Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 A = o13Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                o13 o13Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof o13)) {
                    o13Var = (o13) obj;
                } else {
                    o13Var = new o13(this.mSwanApiContext);
                    this.mApis.put("-254510461", o13Var);
                }
                Pair<Boolean, gy1> a = iy1.a(o13Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Plugin.invokePluginPayment")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = o13Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                ha2 ha2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof ha2)) {
                    ha2Var = (ha2) obj;
                } else {
                    ha2Var = new ha2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", ha2Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ha2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Prefetch.prefetchResources")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = ha2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPreload", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                z82 z82Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof z82)) {
                    z82Var = (z82) obj;
                } else {
                    z82Var = new z82(this.mSwanApiContext);
                    this.mApis.put("423661539", z82Var);
                }
                Pair<Boolean, gy1> a = iy1.a(z82Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Preload.preloadStatus")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = z82Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                ji3 ji3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof ji3)) {
                    ji3Var = (ji3) obj;
                } else {
                    ji3Var = new ji3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", ji3Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ji3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "PrivateFile.uploadFileToBos")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 D = ji3Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naRouter", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                zv1 zv1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof zv1)) {
                    zv1Var = (zv1) obj;
                } else {
                    zv1Var = new zv1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", zv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(zv1Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Router.hideModalPage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = zv1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                zv1 zv1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof zv1)) {
                    zv1Var = (zv1) obj;
                } else {
                    zv1Var = new zv1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", zv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(zv1Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Router.navigateBack")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 C = zv1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                aw1 aw1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof aw1)) {
                    aw1Var = (aw1) obj;
                } else {
                    aw1Var = new aw1(this.mSwanApiContext);
                    this.mApis.put("1968522584", aw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(aw1Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Router.navigateTo")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 I = aw1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                cw1 cw1Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof cw1)) {
                    cw1Var = (cw1) obj;
                } else {
                    cw1Var = new cw1(this.mSwanApiContext);
                    this.mApis.put("1317280190", cw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(cw1Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Router.reLaunch")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = cw1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                dw1 dw1Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof dw1)) {
                    dw1Var = (dw1) obj;
                } else {
                    dw1Var = new dw1(this.mSwanApiContext);
                    this.mApis.put("-420075743", dw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(dw1Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Router.reLoadErrorPage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = dw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                bw1 bw1Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof bw1)) {
                    bw1Var = (bw1) obj;
                } else {
                    bw1Var = new bw1(this.mSwanApiContext);
                    this.mApis.put("1792515533", bw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(bw1Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Router.redirectTo")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 E = bw1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                aw1 aw1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof aw1)) {
                    aw1Var = (aw1) obj;
                } else {
                    aw1Var = new aw1(this.mSwanApiContext);
                    this.mApis.put("1968522584", aw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(aw1Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Router.showModalPage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 K = aw1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naSetting", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                gw1 gw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof gw1)) {
                    gw1Var = (gw1) obj;
                } else {
                    gw1Var = new gw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", gw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(gw1Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Setting.getAppInfoSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 G = gw1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                gw1 gw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof gw1)) {
                    gw1Var = (gw1) obj;
                } else {
                    gw1Var = new gw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", gw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(gw1Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Setting.getSlaveIdSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 I = gw1Var.I();
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                fw1 fw1Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof fw1)) {
                    fw1Var = (fw1) obj;
                } else {
                    fw1Var = new fw1(this.mSwanApiContext);
                    this.mApis.put("450273045", fw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(fw1Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Setting.isAllowedAdOpenAppSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = fw1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                gw1 gw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof gw1)) {
                    gw1Var = (gw1) obj;
                } else {
                    gw1Var = new gw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", gw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(gw1Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Setting.getSetting")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 H = gw1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                gw1 gw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof gw1)) {
                    gw1Var = (gw1) obj;
                } else {
                    gw1Var = new gw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", gw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(gw1Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Setting.getSwanId")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 J = gw1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                gw1 gw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof gw1)) {
                    gw1Var = (gw1) obj;
                } else {
                    gw1Var = new gw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", gw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(gw1Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Setting.getUserInfo")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 K = gw1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                dd3 dd3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof dd3)) {
                    dd3Var = (dd3) obj;
                } else {
                    dd3Var = new dd3(this.mSwanApiContext);
                    this.mApis.put("712777136", dd3Var);
                }
                Pair<Boolean, gy1> a = iy1.a(dd3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = dd3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naStorage", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                jw1 jw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", jw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(jw1Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = jw1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                jw1 jw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", jw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(jw1Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorageSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 D = jw1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                iw1 iw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("130910081", iw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(iw1Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.clearStorage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = iw1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                iw1 iw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("130910081", iw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(iw1Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.clearStorageSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 D = iw1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                jw1 jw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", jw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(jw1Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfo")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 H = jw1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                jw1 jw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", jw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(jw1Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfoSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 K = jw1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                iw1 iw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("130910081", iw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(iw1Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.getStorageInfo")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 H = iw1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                iw1 iw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("130910081", iw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(iw1Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.getStorageInfoSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 K = iw1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", jw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(jw1Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.getGlobalStorage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 E = jw1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", jw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(jw1Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 L = jw1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                iw1 iw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("130910081", iw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(iw1Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.getStorage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 E = iw1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                iw1 iw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("130910081", iw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(iw1Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.getStorageInfoAsync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 I = iw1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                iw1 iw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("130910081", iw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(iw1Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.getStorageSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 L = iw1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", jw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(jw1Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 S = jw1Var.S(str);
                if (S == null) {
                    return "";
                }
                return S.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", jw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(jw1Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorageSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 U = jw1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                iw1 iw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("130910081", iw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(iw1Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.removeStorage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 S = iw1Var.S(str);
                if (S == null) {
                    return "";
                }
                return S.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                iw1 iw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("130910081", iw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(iw1Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.removeStorageSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 U = iw1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", jw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(jw1Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.setGlobalStorage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 V = jw1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", jw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(jw1Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.setGlobalStorageSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 X = jw1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                iw1 iw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("130910081", iw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(iw1Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.setStorage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 V = iw1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                iw1 iw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("130910081", iw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(iw1Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.setStorageSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 X = iw1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naSubscription", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                lw1 lw1Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof lw1)) {
                    lw1Var = (lw1) obj;
                } else {
                    lw1Var = new lw1(this.mSwanApiContext);
                    this.mApis.put("823117982", lw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(lw1Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Subscription.requestSubscribeFormId")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 F = lw1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                mw1 mw1Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("-947445811", mw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(mw1Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Subscription.subscribeService")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 G = mw1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naSystem", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("1936205521", tw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(tw1Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.exitFullScreen")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = tw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                sw1 sw1Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof sw1)) {
                    sw1Var = (sw1) obj;
                } else {
                    sw1Var = new sw1(this.mSwanApiContext);
                    this.mApis.put("1694151270", sw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(sw1Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.getDeviceInfo")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = sw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                uw1 uw1Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof uw1)) {
                    uw1Var = (uw1) obj;
                } else {
                    uw1Var = new uw1(this.mSwanApiContext);
                    this.mApis.put("-1321681619", uw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(uw1Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.getDeviceProfile")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = uw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                vw1 vw1Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("-1569246082", vw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(vw1Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.makePhoneCall")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = vw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                xw1 xw1Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof xw1)) {
                    xw1Var = (xw1) obj;
                } else {
                    xw1Var = new xw1(this.mSwanApiContext);
                    this.mApis.put("1099851202", xw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(xw1Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.openSMSPanel")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = xw1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                ww1 ww1Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof ww1)) {
                    ww1Var = (ww1) obj;
                } else {
                    ww1Var = new ww1(this.mSwanApiContext);
                    this.mApis.put("-1707203360", ww1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ww1Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.requestFullScreen")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 G = ww1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                qw1 qw1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof qw1)) {
                    qw1Var = (qw1) obj;
                } else {
                    qw1Var = new qw1(this.mSwanApiContext);
                    this.mApis.put("-518757484", qw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(qw1Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.setClipboardData")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = qw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                zv2 zv2Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof zv2)) {
                    zv2Var = (zv2) obj;
                } else {
                    zv2Var = new zv2(this.mSwanApiContext);
                    this.mApis.put("1161486049", zv2Var);
                }
                Pair<Boolean, gy1> a = iy1.a(zv2Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.setErrorPageType")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = zv2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                ax1 ax1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof ax1)) {
                    ax1Var = (ax1) obj;
                } else {
                    ax1Var = new ax1(this.mSwanApiContext);
                    this.mApis.put("447234992", ax1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ax1Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.setMediaVolume")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 A = ax1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                ow1 ow1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof ow1)) {
                    ow1Var = (ow1) obj;
                } else {
                    ow1Var = new ow1(this.mSwanApiContext);
                    this.mApis.put("1372680763", ow1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ow1Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.startAccelerometer")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = ow1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                rw1 rw1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("1689255576", rw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(rw1Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.startCompass")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = rw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                pw1 pw1Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof pw1)) {
                    pw1Var = (pw1) obj;
                } else {
                    pw1Var = new pw1(this.mSwanApiContext);
                    this.mApis.put("99997465", pw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(pw1Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.getBrightness")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = pw1Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                qw1 qw1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof qw1)) {
                    qw1Var = (qw1) obj;
                } else {
                    qw1Var = new qw1(this.mSwanApiContext);
                    this.mApis.put("-518757484", qw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(qw1Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.getClipboardData")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = qw1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                ax1 ax1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof ax1)) {
                    ax1Var = (ax1) obj;
                } else {
                    ax1Var = new ax1(this.mSwanApiContext);
                    this.mApis.put("447234992", ax1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ax1Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.getMediaVolume")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = ax1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                ow1 ow1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof ow1)) {
                    ow1Var = (ow1) obj;
                } else {
                    ow1Var = new ow1(this.mSwanApiContext);
                    this.mApis.put("1372680763", ow1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ow1Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.stopAccelerometer")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 C = ow1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                rw1 rw1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("1689255576", rw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(rw1Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.stopCompass")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 A = rw1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naUtils", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                lx1 lx1Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof lx1)) {
                    lx1Var = (lx1) obj;
                } else {
                    lx1Var = new lx1(this.mSwanApiContext);
                    this.mApis.put("201194468", lx1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(lx1Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.addToDesktop")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 C = lx1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                hx1 hx1Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof hx1)) {
                    hx1Var = (hx1) obj;
                } else {
                    hx1Var = new hx1(this.mSwanApiContext);
                    this.mApis.put("-1412306947", hx1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(hx1Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.calcMD5")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = hx1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                ix1 ix1Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof ix1)) {
                    ix1Var = (ix1) obj;
                } else {
                    ix1Var = new ix1(this.mSwanApiContext);
                    this.mApis.put("1626415364", ix1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ix1Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.checkAppInstalled")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = ix1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                kx1 kx1Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof kx1)) {
                    kx1Var = (kx1) obj;
                } else {
                    kx1Var = new kx1(this.mSwanApiContext);
                    this.mApis.put("-836768778", kx1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(kx1Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfo")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = kx1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                mx1 mx1Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof mx1)) {
                    mx1Var = (mx1) obj;
                } else {
                    mx1Var = new mx1(this.mSwanApiContext);
                    this.mApis.put("-810858308", mx1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(mx1Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.getPerformanceLevel")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = mx1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                qx1 qx1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", qx1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(qx1Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.getSystemInfoAsync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 J = qx1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                nx1 nx1Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof nx1)) {
                    nx1Var = (nx1) obj;
                } else {
                    nx1Var = new nx1(this.mSwanApiContext);
                    this.mApis.put("-2097727681", nx1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(nx1Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.handleException")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = nx1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                jx1 jx1Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof jx1)) {
                    jx1Var = (jx1) obj;
                } else {
                    jx1Var = new jx1(this.mSwanApiContext);
                    this.mApis.put("2084449317", jx1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(jx1Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.hasCloseHandler")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = jx1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                la3 la3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof la3)) {
                    la3Var = (la3) obj;
                } else {
                    la3Var = new la3(this.mSwanApiContext);
                    this.mApis.put("1031678042", la3Var);
                }
                Pair<Boolean, gy1> a = iy1.a(la3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.hideCaptureScreenShareDialog")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = la3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                ox1 ox1Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof ox1)) {
                    ox1Var = (ox1) obj;
                } else {
                    ox1Var = new ox1(this.mSwanApiContext);
                    this.mApis.put("1751900130", ox1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ox1Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.logToFile")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = ox1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                m93 m93Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof m93)) {
                    m93Var = (m93) obj;
                } else {
                    m93Var = new m93(this.mSwanApiContext);
                    this.mApis.put("1748196865", m93Var);
                }
                Pair<Boolean, gy1> a = iy1.a(m93Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.preloadPackage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = m93Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                px1 px1Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof px1)) {
                    px1Var = (px1) obj;
                } else {
                    px1Var = new px1(this.mSwanApiContext);
                    this.mApis.put("589529211", px1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(px1Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.previewImage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 C = px1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                sx1 sx1Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof sx1)) {
                    sx1Var = (sx1) obj;
                } else {
                    sx1Var = new sx1(this.mSwanApiContext);
                    this.mApis.put("-577481801", sx1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(sx1Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.ubcFlowJar")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 J = sx1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                qx1 qx1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", qx1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(qx1Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfoSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 F = qx1Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                qx1 qx1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", qx1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(qx1Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.getSystemInfo")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 I = qx1Var.I();
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                qx1 qx1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", qx1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(qx1Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.getSystemInfoSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 K = qx1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naWifi", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                wg3 wg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof wg3)) {
                    wg3Var = (wg3) obj;
                } else {
                    wg3Var = new wg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", wg3Var);
                }
                Pair<Boolean, gy1> a = iy1.a(wg3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Wifi.connectWifi")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = wg3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                wg3 wg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof wg3)) {
                    wg3Var = (wg3) obj;
                } else {
                    wg3Var = new wg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", wg3Var);
                }
                Pair<Boolean, gy1> a = iy1.a(wg3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Wifi.getConnectedWifi")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 C = wg3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                wg3 wg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof wg3)) {
                    wg3Var = (wg3) obj;
                } else {
                    wg3Var = new wg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", wg3Var);
                }
                Pair<Boolean, gy1> a = iy1.a(wg3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Wifi.getWifiList")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 D = wg3Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                wg3 wg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof wg3)) {
                    wg3Var = (wg3) obj;
                } else {
                    wg3Var = new wg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", wg3Var);
                }
                Pair<Boolean, gy1> a = iy1.a(wg3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Wifi.startWifi")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 H = wg3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                wg3 wg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof wg3)) {
                    wg3Var = (wg3) obj;
                } else {
                    wg3Var = new wg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", wg3Var);
                }
                Pair<Boolean, gy1> a = iy1.a(wg3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Wifi.stopWifi")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 I = wg3Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final iu1 iu1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                ou1 ou1Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof ou1)) {
                    ou1Var = (ou1) obj;
                } else {
                    ou1Var = new ou1(this.mSwanApiContext);
                    this.mApis.put("1930258908", ou1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ou1Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Account.checkSession")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = ou1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                pu1 pu1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof pu1)) {
                    pu1Var = (pu1) obj;
                } else {
                    pu1Var = new pu1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", pu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(pu1Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Account.getLoginCode")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 D = pu1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                qu1 qu1Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof qu1)) {
                    qu1Var = (qu1) obj;
                } else {
                    qu1Var = new qu1(this.mSwanApiContext);
                    this.mApis.put("1754780133", qu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(qu1Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Account.getOpenId")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = qu1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                xt1 xt1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof xt1)) {
                    xt1Var = (xt1) obj;
                } else {
                    xt1Var = new xt1(this.mSwanApiContext);
                    this.mApis.put("-343998465", xt1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(xt1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Account.getUnionBDUSS")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = xt1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String login(String str) {
                pu1 pu1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof pu1)) {
                    pu1Var = (pu1) obj;
                } else {
                    pu1Var = new pu1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", pu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(pu1Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Account.login")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 J = pu1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                nu1 nu1Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof nu1)) {
                    nu1Var = (nu1) obj;
                } else {
                    nu1Var = new nu1(this.mSwanApiContext);
                    this.mApis.put("-337742792", nu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(nu1Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Account.isBaiduAccountSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = nu1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                pu1 pu1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof pu1)) {
                    pu1Var = (pu1) obj;
                } else {
                    pu1Var = new pu1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", pu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(pu1Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Account.isLoginSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 I = pu1Var.I();
                if (I == null) {
                    return "";
                }
                return I.a();
            }
        });
        hashMap.put("_naBasic", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                ru1 ru1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof ru1)) {
                    ru1Var = (ru1) obj;
                } else {
                    ru1Var = new ru1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", ru1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ru1Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Basic.loadSubPackage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 G = ru1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                ru1 ru1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof ru1)) {
                    ru1Var = (ru1) obj;
                } else {
                    ru1Var = new ru1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", ru1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ru1Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Basic.loadSubPackages")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 H = ru1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                ym1 ym1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ym1)) {
                    ym1Var = (ym1) obj;
                } else {
                    ym1Var = new ym1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ym1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ym1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Bookshelf.deleteBookshelf")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 L = ym1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                ym1 ym1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ym1)) {
                    ym1Var = (ym1) obj;
                } else {
                    ym1Var = new ym1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ym1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ym1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Bookshelf.insertBookshelf")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 Q = ym1Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                ym1 ym1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ym1)) {
                    ym1Var = (ym1) obj;
                } else {
                    ym1Var = new ym1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ym1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ym1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Bookshelf.navigateToBookshelf")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 V = ym1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                ym1 ym1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ym1)) {
                    ym1Var = (ym1) obj;
                } else {
                    ym1Var = new ym1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ym1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ym1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Bookshelf.queryBookshelf")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 W = ym1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                ym1 ym1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ym1)) {
                    ym1Var = (ym1) obj;
                } else {
                    ym1Var = new ym1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ym1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ym1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Bookshelf.updateBookshelfReadTime")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 Y = ym1Var.Y(str);
                if (Y == null) {
                    return "";
                }
                return Y.a();
            }
        });
        hashMap.put("_naCoupon", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                lu1 lu1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof lu1)) {
                    lu1Var = (lu1) obj;
                } else {
                    lu1Var = new lu1(this.mSwanApiContext);
                    this.mApis.put("-277316359", lu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(lu1Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Coupon.getPlatformCoupons")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = lu1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                lu1 lu1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof lu1)) {
                    lu1Var = (lu1) obj;
                } else {
                    lu1Var = new lu1(this.mSwanApiContext);
                    this.mApis.put("-277316359", lu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(lu1Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Coupon.getUserCoupons")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 A = lu1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                lu1 lu1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof lu1)) {
                    lu1Var = (lu1) obj;
                } else {
                    lu1Var = new lu1(this.mSwanApiContext);
                    this.mApis.put("-277316359", lu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(lu1Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Coupon.takeCoupons")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 D = lu1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naFavorite", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                tu1 tu1Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof tu1)) {
                    tu1Var = (tu1) obj;
                } else {
                    tu1Var = new tu1(this.mSwanApiContext);
                    this.mApis.put("-1225406515", tu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(tu1Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Favorite.getFavorStatus")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = tu1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
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
                Pair<Boolean, gy1> a = iy1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Favorite.showFavoriteGuide")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 H = showFavoriteGuideApi.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naFile", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                vu1 vu1Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof vu1)) {
                    vu1Var = (vu1) obj;
                } else {
                    vu1Var = new vu1(this.mSwanApiContext);
                    this.mApis.put("-2057135077", vu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(vu1Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "File.shareFile")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = vu1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                jj2 jj2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof jj2)) {
                    jj2Var = (jj2) obj;
                } else {
                    jj2Var = new jj2(this.mSwanApiContext);
                    this.mApis.put("2077414795", jj2Var);
                }
                Pair<Boolean, gy1> a = iy1.a(jj2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = jj2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                jj2 jj2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof jj2)) {
                    jj2Var = (jj2) obj;
                } else {
                    jj2Var = new jj2(this.mSwanApiContext);
                    this.mApis.put("2077414795", jj2Var);
                }
                Pair<Boolean, gy1> a = iy1.a(jj2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessageSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = jj2Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String download(String str) {
                wu1 wu1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof wu1)) {
                    wu1Var = (wu1) obj;
                } else {
                    wu1Var = new wu1(this.mSwanApiContext);
                    this.mApis.put("-170124576", wu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(wu1Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "HostDownloadManager.download")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = wu1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                wu1 wu1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof wu1)) {
                    wu1Var = (wu1) obj;
                } else {
                    wu1Var = new wu1(this.mSwanApiContext);
                    this.mApis.put("-170124576", wu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(wu1Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "HostDownloadManager.openFile")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 A = wu1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String query(String str) {
                wu1 wu1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof wu1)) {
                    wu1Var = (wu1) obj;
                } else {
                    wu1Var = new wu1(this.mSwanApiContext);
                    this.mApis.put("-170124576", wu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(wu1Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "HostDownloadManager.query")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = wu1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                wu1 wu1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof wu1)) {
                    wu1Var = (wu1) obj;
                } else {
                    wu1Var = new wu1(this.mSwanApiContext);
                    this.mApis.put("-170124576", wu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(wu1Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "HostDownloadManager.openDownloadCenter")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = wu1Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naImage", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                xv2 xv2Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof xv2)) {
                    xv2Var = (xv2) obj;
                } else {
                    xv2Var = new xv2(this.mSwanApiContext);
                    this.mApis.put("1445003743", xv2Var);
                }
                Pair<Boolean, gy1> a = iy1.a(xv2Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Image.callImageMenu")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = xv2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                zu1 zu1Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof zu1)) {
                    zu1Var = (zu1) obj;
                } else {
                    zu1Var = new zu1(this.mSwanApiContext);
                    this.mApis.put("-1252730367", zu1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(zu1Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Image.compressImage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = zu1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naInteraction", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                hv1 hv1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof hv1)) {
                    hv1Var = (hv1) obj;
                } else {
                    hv1Var = new hv1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", hv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(hv1Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.closeTabBar")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = hv1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                hv1 hv1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof hv1)) {
                    hv1Var = (hv1) obj;
                } else {
                    hv1Var = new hv1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", hv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(hv1Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.closeTabBarRedDot")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = hv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                dv1 dv1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof dv1)) {
                    dv1Var = (dv1) obj;
                } else {
                    dv1Var = new dv1(this.mSwanApiContext);
                    this.mApis.put("-246386074", dv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(dv1Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.hideNavigationBarLoading")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = dv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                fv1 fv1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof fv1)) {
                    fv1Var = (fv1) obj;
                } else {
                    fv1Var = new fv1(this.mSwanApiContext);
                    this.mApis.put("-108978463", fv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(fv1Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.openMultiPicker")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 H = fv1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                fv1 fv1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof fv1)) {
                    fv1Var = (fv1) obj;
                } else {
                    fv1Var = new fv1(this.mSwanApiContext);
                    this.mApis.put("-108978463", fv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(fv1Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.openPicker")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 I = fv1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                hv1 hv1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof hv1)) {
                    hv1Var = (hv1) obj;
                } else {
                    hv1Var = new hv1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", hv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(hv1Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.openTabBar")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 D = hv1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                ev1 ev1Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof ev1)) {
                    ev1Var = (ev1) obj;
                } else {
                    ev1Var = new ev1(this.mSwanApiContext);
                    this.mApis.put("-1750613704", ev1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ev1Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.pageScrollTo")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = ev1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                dv1 dv1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof dv1)) {
                    dv1Var = (dv1) obj;
                } else {
                    dv1Var = new dv1(this.mSwanApiContext);
                    this.mApis.put("-246386074", dv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(dv1Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarColor")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 A = dv1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                dv1 dv1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof dv1)) {
                    dv1Var = (dv1) obj;
                } else {
                    dv1Var = new dv1(this.mSwanApiContext);
                    this.mApis.put("-246386074", dv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(dv1Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarTitle")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = dv1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                hv1 hv1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof hv1)) {
                    hv1Var = (hv1) obj;
                } else {
                    hv1Var = new hv1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", hv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(hv1Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.setTabBarItem")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 E = hv1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                fv1 fv1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof fv1)) {
                    fv1Var = (fv1) obj;
                } else {
                    fv1Var = new fv1(this.mSwanApiContext);
                    this.mApis.put("-108978463", fv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(fv1Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.showDatePickerView")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 M = fv1Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                jv1 jv1Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof jv1)) {
                    jv1Var = (jv1) obj;
                } else {
                    jv1Var = new jv1(this.mSwanApiContext);
                    this.mApis.put("1172469410", jv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(jv1Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.showHalfScreenWebview")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 L = jv1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                bv1 bv1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof bv1)) {
                    bv1Var = (bv1) obj;
                } else {
                    bv1Var = new bv1(this.mSwanApiContext);
                    this.mApis.put("5236036", bv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(bv1Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.showLoading")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = bv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                cv1 cv1Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof cv1)) {
                    cv1Var = (cv1) obj;
                } else {
                    cv1Var = new cv1(this.mSwanApiContext);
                    this.mApis.put("1913747800", cv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(cv1Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.showModal")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = cv1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                dv1 dv1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof dv1)) {
                    dv1Var = (dv1) obj;
                } else {
                    dv1Var = new dv1(this.mSwanApiContext);
                    this.mApis.put("-246386074", dv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(dv1Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.showNavigationBarLoading")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 C = dv1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                iv1 iv1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof iv1)) {
                    iv1Var = (iv1) obj;
                } else {
                    iv1Var = new iv1(this.mSwanApiContext);
                    this.mApis.put("1159492510", iv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(iv1Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.showToast")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 R = iv1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                gv1 gv1Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof gv1)) {
                    gv1Var = (gv1) obj;
                } else {
                    gv1Var = new gv1(this.mSwanApiContext);
                    this.mApis.put("1165118609", gv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(gv1Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.stopPullDownRefresh")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = gv1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                fv1 fv1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof fv1)) {
                    fv1Var = (fv1) obj;
                } else {
                    fv1Var = new fv1(this.mSwanApiContext);
                    this.mApis.put("-108978463", fv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(fv1Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.updateMultiPicker")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 N = fv1Var.N(str);
                if (N == null) {
                    return "";
                }
                return N.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                bv1 bv1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof bv1)) {
                    bv1Var = (bv1) obj;
                } else {
                    bv1Var = new bv1(this.mSwanApiContext);
                    this.mApis.put("5236036", bv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(bv1Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.hideLoading")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = bv1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideToast() {
                iv1 iv1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof iv1)) {
                    iv1Var = (iv1) obj;
                } else {
                    iv1Var = new iv1(this.mSwanApiContext);
                    this.mApis.put("1159492510", iv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(iv1Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Interaction.hideToast")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 L = iv1Var.L();
                if (L == null) {
                    return "";
                }
                return L.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                kv1 kv1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof kv1)) {
                    kv1Var = (kv1) obj;
                } else {
                    kv1Var = new kv1(this.mSwanApiContext);
                    this.mApis.put("-137346255", kv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(kv1Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Keyboard.startKeyboardHeightChange")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 D = kv1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                kv1 kv1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof kv1)) {
                    kv1Var = (kv1) obj;
                } else {
                    kv1Var = new kv1(this.mSwanApiContext);
                    this.mApis.put("-137346255", kv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(kv1Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Keyboard.stopKeyboardHeightChange")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 E = kv1Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }
        });
        hashMap.put("_naLocationService", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                lv1 lv1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof lv1)) {
                    lv1Var = (lv1) obj;
                } else {
                    lv1Var = new lv1(this.mSwanApiContext);
                    this.mApis.put("-397373095", lv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(lv1Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "LocationService.getLocation")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = lv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                lv1 lv1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof lv1)) {
                    lv1Var = (lv1) obj;
                } else {
                    lv1Var = new lv1(this.mSwanApiContext);
                    this.mApis.put("-397373095", lv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(lv1Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "LocationService.startLocationUpdate")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = lv1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                lv1 lv1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof lv1)) {
                    lv1Var = (lv1) obj;
                } else {
                    lv1Var = new lv1(this.mSwanApiContext);
                    this.mApis.put("-397373095", lv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(lv1Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "LocationService.stopLocationUpdate")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 C = lv1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naMenu", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                cx1 cx1Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof cx1)) {
                    cx1Var = (cx1) obj;
                } else {
                    cx1Var = new cx1(this.mSwanApiContext);
                    this.mApis.put("538070032", cx1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(cx1Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = cx1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naNetwork", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                ov1 ov1Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof ov1)) {
                    ov1Var = (ov1) obj;
                } else {
                    ov1Var = new ov1(this.mSwanApiContext);
                    this.mApis.put("-1076509454", ov1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ov1Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Network.callService")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = ov1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                vv1 vv1Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof vv1)) {
                    vv1Var = (vv1) obj;
                } else {
                    vv1Var = new vv1(this.mSwanApiContext);
                    this.mApis.put("968563034", vv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(vv1Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Network.cancelRequest")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 E = vv1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                uv1 uv1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof uv1)) {
                    uv1Var = (uv1) obj;
                } else {
                    uv1Var = new uv1(this.mSwanApiContext);
                    this.mApis.put("453220699", uv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(uv1Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Network.networkStatusChange")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = uv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                uv1 uv1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof uv1)) {
                    uv1Var = (uv1) obj;
                } else {
                    uv1Var = new uv1(this.mSwanApiContext);
                    this.mApis.put("453220699", uv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(uv1Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Network.getNetworkType")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = uv1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(String str) {
                vv1 vv1Var;
                String a;
                try {
                    fy1.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof vv1)) {
                        vv1Var = (vv1) obj;
                    } else {
                        vv1Var = new vv1(this.mSwanApiContext);
                        this.mApis.put("968563034", vv1Var);
                    }
                    Pair<Boolean, gy1> a2 = iy1.a(vv1Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((gy1) a2.second).a();
                    } else if (n82.a(this.mSwanApiContext.e(), "Network.request")) {
                        a = new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<gy1, JSONObject> v = ku1.v(str);
                        if (!((gy1) v.first).isSuccess()) {
                            a = ((gy1) v.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) v.second;
                            if (jSONObject == null) {
                                a = gy1.a.a();
                            } else {
                                hy1 W = vv1Var.W(jSONObject);
                                if (W == null) {
                                    a = "";
                                } else {
                                    a = W.a();
                                }
                            }
                        }
                    }
                    return a;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } finally {
                        fy1.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                dz2 dz2Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof dz2)) {
                    dz2Var = (dz2) obj;
                } else {
                    dz2Var = new dz2(this.mSwanApiContext);
                    this.mApis.put("-336396851", dz2Var);
                }
                Pair<Boolean, gy1> a = iy1.a(dz2Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Payment.chooseCoupon")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = dz2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                dz2 dz2Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof dz2)) {
                    dz2Var = (dz2) obj;
                } else {
                    dz2Var = new dz2(this.mSwanApiContext);
                    this.mApis.put("-336396851", dz2Var);
                }
                Pair<Boolean, gy1> a = iy1.a(dz2Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Payment.getPaymentInfo")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = dz2Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                ty2 ty2Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof ty2)) {
                    ty2Var = (ty2) obj;
                } else {
                    ty2Var = new ty2(this.mSwanApiContext);
                    this.mApis.put("1854689529", ty2Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ty2Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Payment.requestThirdPayment")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = ty2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                dz2 dz2Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof dz2)) {
                    dz2Var = (dz2) obj;
                } else {
                    dz2Var = new dz2(this.mSwanApiContext);
                    this.mApis.put("-336396851", dz2Var);
                }
                Pair<Boolean, gy1> a = iy1.a(dz2Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Payment.setPaymentInfo")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 A = dz2Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPlugin", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                o13 o13Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof o13)) {
                    o13Var = (o13) obj;
                } else {
                    o13Var = new o13(this.mSwanApiContext);
                    this.mApis.put("-254510461", o13Var);
                }
                Pair<Boolean, gy1> a = iy1.a(o13Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Plugin.invokePluginChooseAddress")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = o13Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                o13 o13Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof o13)) {
                    o13Var = (o13) obj;
                } else {
                    o13Var = new o13(this.mSwanApiContext);
                    this.mApis.put("-254510461", o13Var);
                }
                Pair<Boolean, gy1> a = iy1.a(o13Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 A = o13Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                o13 o13Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof o13)) {
                    o13Var = (o13) obj;
                } else {
                    o13Var = new o13(this.mSwanApiContext);
                    this.mApis.put("-254510461", o13Var);
                }
                Pair<Boolean, gy1> a = iy1.a(o13Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Plugin.invokePluginPayment")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = o13Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                ha2 ha2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof ha2)) {
                    ha2Var = (ha2) obj;
                } else {
                    ha2Var = new ha2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", ha2Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ha2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Prefetch.prefetchResources")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = ha2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPreload", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                z82 z82Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof z82)) {
                    z82Var = (z82) obj;
                } else {
                    z82Var = new z82(this.mSwanApiContext);
                    this.mApis.put("423661539", z82Var);
                }
                Pair<Boolean, gy1> a = iy1.a(z82Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Preload.preloadStatus")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = z82Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                ji3 ji3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof ji3)) {
                    ji3Var = (ji3) obj;
                } else {
                    ji3Var = new ji3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", ji3Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ji3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "PrivateFile.uploadFileToBos")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 D = ji3Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naRouter", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                zv1 zv1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof zv1)) {
                    zv1Var = (zv1) obj;
                } else {
                    zv1Var = new zv1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", zv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(zv1Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Router.hideModalPage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = zv1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                zv1 zv1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof zv1)) {
                    zv1Var = (zv1) obj;
                } else {
                    zv1Var = new zv1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", zv1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(zv1Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Router.navigateBack")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 C = zv1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                aw1 aw1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof aw1)) {
                    aw1Var = (aw1) obj;
                } else {
                    aw1Var = new aw1(this.mSwanApiContext);
                    this.mApis.put("1968522584", aw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(aw1Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Router.navigateTo")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 I = aw1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                cw1 cw1Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof cw1)) {
                    cw1Var = (cw1) obj;
                } else {
                    cw1Var = new cw1(this.mSwanApiContext);
                    this.mApis.put("1317280190", cw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(cw1Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Router.reLaunch")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = cw1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                dw1 dw1Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof dw1)) {
                    dw1Var = (dw1) obj;
                } else {
                    dw1Var = new dw1(this.mSwanApiContext);
                    this.mApis.put("-420075743", dw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(dw1Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Router.reLoadErrorPage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = dw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                bw1 bw1Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof bw1)) {
                    bw1Var = (bw1) obj;
                } else {
                    bw1Var = new bw1(this.mSwanApiContext);
                    this.mApis.put("1792515533", bw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(bw1Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Router.redirectTo")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 E = bw1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                aw1 aw1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof aw1)) {
                    aw1Var = (aw1) obj;
                } else {
                    aw1Var = new aw1(this.mSwanApiContext);
                    this.mApis.put("1968522584", aw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(aw1Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Router.showModalPage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 K = aw1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naSetting", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                gw1 gw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof gw1)) {
                    gw1Var = (gw1) obj;
                } else {
                    gw1Var = new gw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", gw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(gw1Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Setting.getAppInfoSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 G = gw1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                gw1 gw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof gw1)) {
                    gw1Var = (gw1) obj;
                } else {
                    gw1Var = new gw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", gw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(gw1Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Setting.getSlaveIdSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 I = gw1Var.I();
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                fw1 fw1Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof fw1)) {
                    fw1Var = (fw1) obj;
                } else {
                    fw1Var = new fw1(this.mSwanApiContext);
                    this.mApis.put("450273045", fw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(fw1Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Setting.isAllowedAdOpenAppSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = fw1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                gw1 gw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof gw1)) {
                    gw1Var = (gw1) obj;
                } else {
                    gw1Var = new gw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", gw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(gw1Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Setting.getSetting")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 H = gw1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                gw1 gw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof gw1)) {
                    gw1Var = (gw1) obj;
                } else {
                    gw1Var = new gw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", gw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(gw1Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Setting.getSwanId")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 J = gw1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                gw1 gw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof gw1)) {
                    gw1Var = (gw1) obj;
                } else {
                    gw1Var = new gw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", gw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(gw1Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Setting.getUserInfo")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 K = gw1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                dd3 dd3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof dd3)) {
                    dd3Var = (dd3) obj;
                } else {
                    dd3Var = new dd3(this.mSwanApiContext);
                    this.mApis.put("712777136", dd3Var);
                }
                Pair<Boolean, gy1> a = iy1.a(dd3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = dd3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naStorage", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                jw1 jw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", jw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(jw1Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = jw1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                jw1 jw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", jw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(jw1Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorageSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 D = jw1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                iw1 iw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("130910081", iw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(iw1Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.clearStorage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = iw1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                iw1 iw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("130910081", iw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(iw1Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.clearStorageSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 D = iw1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                jw1 jw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", jw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(jw1Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfo")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 H = jw1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                jw1 jw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", jw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(jw1Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfoSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 K = jw1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                iw1 iw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("130910081", iw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(iw1Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.getStorageInfo")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 H = iw1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                iw1 iw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("130910081", iw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(iw1Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.getStorageInfoSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 K = iw1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", jw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(jw1Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.getGlobalStorage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 E = jw1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", jw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(jw1Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 L = jw1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                iw1 iw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("130910081", iw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(iw1Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.getStorage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 E = iw1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                iw1 iw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("130910081", iw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(iw1Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.getStorageInfoAsync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 I = iw1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                iw1 iw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("130910081", iw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(iw1Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.getStorageSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 L = iw1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", jw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(jw1Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 S = jw1Var.S(str);
                if (S == null) {
                    return "";
                }
                return S.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", jw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(jw1Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorageSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 U = jw1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                iw1 iw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("130910081", iw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(iw1Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.removeStorage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 S = iw1Var.S(str);
                if (S == null) {
                    return "";
                }
                return S.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                iw1 iw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("130910081", iw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(iw1Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.removeStorageSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 U = iw1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", jw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(jw1Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.setGlobalStorage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 V = jw1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", jw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(jw1Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.setGlobalStorageSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 X = jw1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                iw1 iw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("130910081", iw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(iw1Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.setStorage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 V = iw1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                iw1 iw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof iw1)) {
                    iw1Var = (iw1) obj;
                } else {
                    iw1Var = new iw1(this.mSwanApiContext);
                    this.mApis.put("130910081", iw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(iw1Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Storage.setStorageSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 X = iw1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naSubscription", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                lw1 lw1Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof lw1)) {
                    lw1Var = (lw1) obj;
                } else {
                    lw1Var = new lw1(this.mSwanApiContext);
                    this.mApis.put("823117982", lw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(lw1Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Subscription.requestSubscribeFormId")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 F = lw1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                mw1 mw1Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("-947445811", mw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(mw1Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Subscription.subscribeService")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 G = mw1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naSystem", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("1936205521", tw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(tw1Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.exitFullScreen")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = tw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                sw1 sw1Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof sw1)) {
                    sw1Var = (sw1) obj;
                } else {
                    sw1Var = new sw1(this.mSwanApiContext);
                    this.mApis.put("1694151270", sw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(sw1Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.getDeviceInfo")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = sw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                uw1 uw1Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof uw1)) {
                    uw1Var = (uw1) obj;
                } else {
                    uw1Var = new uw1(this.mSwanApiContext);
                    this.mApis.put("-1321681619", uw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(uw1Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.getDeviceProfile")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = uw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                vw1 vw1Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("-1569246082", vw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(vw1Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.makePhoneCall")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = vw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                xw1 xw1Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof xw1)) {
                    xw1Var = (xw1) obj;
                } else {
                    xw1Var = new xw1(this.mSwanApiContext);
                    this.mApis.put("1099851202", xw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(xw1Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.openSMSPanel")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = xw1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                ww1 ww1Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof ww1)) {
                    ww1Var = (ww1) obj;
                } else {
                    ww1Var = new ww1(this.mSwanApiContext);
                    this.mApis.put("-1707203360", ww1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ww1Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.requestFullScreen")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 G = ww1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                qw1 qw1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof qw1)) {
                    qw1Var = (qw1) obj;
                } else {
                    qw1Var = new qw1(this.mSwanApiContext);
                    this.mApis.put("-518757484", qw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(qw1Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.setClipboardData")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = qw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                zv2 zv2Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof zv2)) {
                    zv2Var = (zv2) obj;
                } else {
                    zv2Var = new zv2(this.mSwanApiContext);
                    this.mApis.put("1161486049", zv2Var);
                }
                Pair<Boolean, gy1> a = iy1.a(zv2Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.setErrorPageType")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = zv2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                ax1 ax1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof ax1)) {
                    ax1Var = (ax1) obj;
                } else {
                    ax1Var = new ax1(this.mSwanApiContext);
                    this.mApis.put("447234992", ax1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ax1Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.setMediaVolume")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 A = ax1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                ow1 ow1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof ow1)) {
                    ow1Var = (ow1) obj;
                } else {
                    ow1Var = new ow1(this.mSwanApiContext);
                    this.mApis.put("1372680763", ow1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ow1Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.startAccelerometer")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = ow1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                rw1 rw1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("1689255576", rw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(rw1Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.startCompass")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = rw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                pw1 pw1Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof pw1)) {
                    pw1Var = (pw1) obj;
                } else {
                    pw1Var = new pw1(this.mSwanApiContext);
                    this.mApis.put("99997465", pw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(pw1Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.getBrightness")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = pw1Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                qw1 qw1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof qw1)) {
                    qw1Var = (qw1) obj;
                } else {
                    qw1Var = new qw1(this.mSwanApiContext);
                    this.mApis.put("-518757484", qw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(qw1Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.getClipboardData")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = qw1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                ax1 ax1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof ax1)) {
                    ax1Var = (ax1) obj;
                } else {
                    ax1Var = new ax1(this.mSwanApiContext);
                    this.mApis.put("447234992", ax1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ax1Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.getMediaVolume")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = ax1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                ow1 ow1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof ow1)) {
                    ow1Var = (ow1) obj;
                } else {
                    ow1Var = new ow1(this.mSwanApiContext);
                    this.mApis.put("1372680763", ow1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ow1Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.stopAccelerometer")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 C = ow1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                rw1 rw1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("1689255576", rw1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(rw1Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "System.stopCompass")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 A = rw1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naUtils", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                lx1 lx1Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof lx1)) {
                    lx1Var = (lx1) obj;
                } else {
                    lx1Var = new lx1(this.mSwanApiContext);
                    this.mApis.put("201194468", lx1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(lx1Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.addToDesktop")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 C = lx1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                hx1 hx1Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof hx1)) {
                    hx1Var = (hx1) obj;
                } else {
                    hx1Var = new hx1(this.mSwanApiContext);
                    this.mApis.put("-1412306947", hx1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(hx1Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.calcMD5")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = hx1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                ix1 ix1Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof ix1)) {
                    ix1Var = (ix1) obj;
                } else {
                    ix1Var = new ix1(this.mSwanApiContext);
                    this.mApis.put("1626415364", ix1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ix1Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.checkAppInstalled")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = ix1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                kx1 kx1Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof kx1)) {
                    kx1Var = (kx1) obj;
                } else {
                    kx1Var = new kx1(this.mSwanApiContext);
                    this.mApis.put("-836768778", kx1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(kx1Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfo")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = kx1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                mx1 mx1Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof mx1)) {
                    mx1Var = (mx1) obj;
                } else {
                    mx1Var = new mx1(this.mSwanApiContext);
                    this.mApis.put("-810858308", mx1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(mx1Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.getPerformanceLevel")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = mx1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                qx1 qx1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", qx1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(qx1Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.getSystemInfoAsync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 J = qx1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                nx1 nx1Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof nx1)) {
                    nx1Var = (nx1) obj;
                } else {
                    nx1Var = new nx1(this.mSwanApiContext);
                    this.mApis.put("-2097727681", nx1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(nx1Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.handleException")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = nx1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                jx1 jx1Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof jx1)) {
                    jx1Var = (jx1) obj;
                } else {
                    jx1Var = new jx1(this.mSwanApiContext);
                    this.mApis.put("2084449317", jx1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(jx1Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.hasCloseHandler")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = jx1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                la3 la3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof la3)) {
                    la3Var = (la3) obj;
                } else {
                    la3Var = new la3(this.mSwanApiContext);
                    this.mApis.put("1031678042", la3Var);
                }
                Pair<Boolean, gy1> a = iy1.a(la3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.hideCaptureScreenShareDialog")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 y = la3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                ox1 ox1Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof ox1)) {
                    ox1Var = (ox1) obj;
                } else {
                    ox1Var = new ox1(this.mSwanApiContext);
                    this.mApis.put("1751900130", ox1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(ox1Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.logToFile")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = ox1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                m93 m93Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof m93)) {
                    m93Var = (m93) obj;
                } else {
                    m93Var = new m93(this.mSwanApiContext);
                    this.mApis.put("1748196865", m93Var);
                }
                Pair<Boolean, gy1> a = iy1.a(m93Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.preloadPackage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = m93Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                px1 px1Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof px1)) {
                    px1Var = (px1) obj;
                } else {
                    px1Var = new px1(this.mSwanApiContext);
                    this.mApis.put("589529211", px1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(px1Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.previewImage")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 C = px1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                sx1 sx1Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof sx1)) {
                    sx1Var = (sx1) obj;
                } else {
                    sx1Var = new sx1(this.mSwanApiContext);
                    this.mApis.put("-577481801", sx1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(sx1Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.ubcFlowJar")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 J = sx1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                qx1 qx1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", qx1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(qx1Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfoSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 F = qx1Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                qx1 qx1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", qx1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(qx1Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.getSystemInfo")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 I = qx1Var.I();
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                qx1 qx1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", qx1Var);
                }
                Pair<Boolean, gy1> a = iy1.a(qx1Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Utils.getSystemInfoSync")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 K = qx1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naWifi", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                wg3 wg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof wg3)) {
                    wg3Var = (wg3) obj;
                } else {
                    wg3Var = new wg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", wg3Var);
                }
                Pair<Boolean, gy1> a = iy1.a(wg3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Wifi.connectWifi")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 B = wg3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                wg3 wg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof wg3)) {
                    wg3Var = (wg3) obj;
                } else {
                    wg3Var = new wg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", wg3Var);
                }
                Pair<Boolean, gy1> a = iy1.a(wg3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Wifi.getConnectedWifi")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 C = wg3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                wg3 wg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof wg3)) {
                    wg3Var = (wg3) obj;
                } else {
                    wg3Var = new wg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", wg3Var);
                }
                Pair<Boolean, gy1> a = iy1.a(wg3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Wifi.getWifiList")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 D = wg3Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                wg3 wg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof wg3)) {
                    wg3Var = (wg3) obj;
                } else {
                    wg3Var = new wg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", wg3Var);
                }
                Pair<Boolean, gy1> a = iy1.a(wg3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Wifi.startWifi")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 H = wg3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                wg3 wg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof wg3)) {
                    wg3Var = (wg3) obj;
                } else {
                    wg3Var = new wg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", wg3Var);
                }
                Pair<Boolean, gy1> a = iy1.a(wg3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "Wifi.stopWifi")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 I = wg3Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }
        });
        return hashMap;
    }
}
