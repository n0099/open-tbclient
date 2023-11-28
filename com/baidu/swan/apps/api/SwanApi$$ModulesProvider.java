package com.baidu.swan.apps.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.tieba.a92;
import com.baidu.tieba.av1;
import com.baidu.tieba.aw1;
import com.baidu.tieba.aw2;
import com.baidu.tieba.bw1;
import com.baidu.tieba.bx1;
import com.baidu.tieba.cv1;
import com.baidu.tieba.cw1;
import com.baidu.tieba.dv1;
import com.baidu.tieba.dw1;
import com.baidu.tieba.dx1;
import com.baidu.tieba.ed3;
import com.baidu.tieba.ev1;
import com.baidu.tieba.ew1;
import com.baidu.tieba.ez2;
import com.baidu.tieba.fv1;
import com.baidu.tieba.gv1;
import com.baidu.tieba.gw1;
import com.baidu.tieba.gy1;
import com.baidu.tieba.hv1;
import com.baidu.tieba.hw1;
import com.baidu.tieba.hy1;
import com.baidu.tieba.ia2;
import com.baidu.tieba.iv1;
import com.baidu.tieba.ix1;
import com.baidu.tieba.iy1;
import com.baidu.tieba.ju1;
import com.baidu.tieba.jv1;
import com.baidu.tieba.jw1;
import com.baidu.tieba.jx1;
import com.baidu.tieba.jy1;
import com.baidu.tieba.ki3;
import com.baidu.tieba.kj2;
import com.baidu.tieba.kv1;
import com.baidu.tieba.kw1;
import com.baidu.tieba.kx1;
import com.baidu.tieba.lu1;
import com.baidu.tieba.lv1;
import com.baidu.tieba.lx1;
import com.baidu.tieba.ma3;
import com.baidu.tieba.mu1;
import com.baidu.tieba.mv1;
import com.baidu.tieba.mw1;
import com.baidu.tieba.mx1;
import com.baidu.tieba.n93;
import com.baidu.tieba.nw1;
import com.baidu.tieba.nx1;
import com.baidu.tieba.o82;
import com.baidu.tieba.ou1;
import com.baidu.tieba.ox1;
import com.baidu.tieba.p13;
import com.baidu.tieba.pu1;
import com.baidu.tieba.pv1;
import com.baidu.tieba.pw1;
import com.baidu.tieba.px1;
import com.baidu.tieba.qu1;
import com.baidu.tieba.qw1;
import com.baidu.tieba.qx1;
import com.baidu.tieba.ru1;
import com.baidu.tieba.rw1;
import com.baidu.tieba.rx1;
import com.baidu.tieba.su1;
import com.baidu.tieba.sw1;
import com.baidu.tieba.tw1;
import com.baidu.tieba.tx1;
import com.baidu.tieba.uu1;
import com.baidu.tieba.uw1;
import com.baidu.tieba.uy2;
import com.baidu.tieba.vv1;
import com.baidu.tieba.vw1;
import com.baidu.tieba.wu1;
import com.baidu.tieba.wv1;
import com.baidu.tieba.ww1;
import com.baidu.tieba.xg3;
import com.baidu.tieba.xu1;
import com.baidu.tieba.xw1;
import com.baidu.tieba.yt1;
import com.baidu.tieba.yv2;
import com.baidu.tieba.yw1;
import com.baidu.tieba.zm1;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
@Keep
/* loaded from: classes4.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final ju1 ju1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                pu1 pu1Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof pu1)) {
                    pu1Var = (pu1) obj;
                } else {
                    pu1Var = new pu1(this.mSwanApiContext);
                    this.mApis.put("1930258908", pu1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(pu1Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Account.checkSession")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = pu1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                qu1 qu1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof qu1)) {
                    qu1Var = (qu1) obj;
                } else {
                    qu1Var = new qu1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", qu1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(qu1Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Account.getLoginCode")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 D = qu1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                ru1 ru1Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof ru1)) {
                    ru1Var = (ru1) obj;
                } else {
                    ru1Var = new ru1(this.mSwanApiContext);
                    this.mApis.put("1754780133", ru1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ru1Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Account.getOpenId")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = ru1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                yt1 yt1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof yt1)) {
                    yt1Var = (yt1) obj;
                } else {
                    yt1Var = new yt1(this.mSwanApiContext);
                    this.mApis.put("-343998465", yt1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(yt1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Account.getUnionBDUSS")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = yt1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String login(String str) {
                qu1 qu1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof qu1)) {
                    qu1Var = (qu1) obj;
                } else {
                    qu1Var = new qu1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", qu1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(qu1Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Account.login")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 J = qu1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                ou1 ou1Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof ou1)) {
                    ou1Var = (ou1) obj;
                } else {
                    ou1Var = new ou1(this.mSwanApiContext);
                    this.mApis.put("-337742792", ou1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ou1Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Account.isBaiduAccountSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = ou1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                qu1 qu1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof qu1)) {
                    qu1Var = (qu1) obj;
                } else {
                    qu1Var = new qu1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", qu1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(qu1Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Account.isLoginSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 I = qu1Var.I();
                if (I == null) {
                    return "";
                }
                return I.a();
            }
        });
        hashMap.put("_naBasic", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                su1 su1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof su1)) {
                    su1Var = (su1) obj;
                } else {
                    su1Var = new su1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", su1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(su1Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Basic.loadSubPackage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 G = su1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                su1 su1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof su1)) {
                    su1Var = (su1) obj;
                } else {
                    su1Var = new su1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", su1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(su1Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Basic.loadSubPackages")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 H = su1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                zm1 zm1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof zm1)) {
                    zm1Var = (zm1) obj;
                } else {
                    zm1Var = new zm1(this.mSwanApiContext);
                    this.mApis.put("1460300387", zm1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(zm1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Bookshelf.deleteBookshelf")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 L = zm1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                zm1 zm1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof zm1)) {
                    zm1Var = (zm1) obj;
                } else {
                    zm1Var = new zm1(this.mSwanApiContext);
                    this.mApis.put("1460300387", zm1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(zm1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Bookshelf.insertBookshelf")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 Q = zm1Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                zm1 zm1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof zm1)) {
                    zm1Var = (zm1) obj;
                } else {
                    zm1Var = new zm1(this.mSwanApiContext);
                    this.mApis.put("1460300387", zm1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(zm1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Bookshelf.navigateToBookshelf")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 V = zm1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                zm1 zm1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof zm1)) {
                    zm1Var = (zm1) obj;
                } else {
                    zm1Var = new zm1(this.mSwanApiContext);
                    this.mApis.put("1460300387", zm1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(zm1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Bookshelf.queryBookshelf")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 W = zm1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                zm1 zm1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof zm1)) {
                    zm1Var = (zm1) obj;
                } else {
                    zm1Var = new zm1(this.mSwanApiContext);
                    this.mApis.put("1460300387", zm1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(zm1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Bookshelf.updateBookshelfReadTime")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 Y = zm1Var.Y(str);
                if (Y == null) {
                    return "";
                }
                return Y.a();
            }
        });
        hashMap.put("_naCoupon", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                mu1 mu1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof mu1)) {
                    mu1Var = (mu1) obj;
                } else {
                    mu1Var = new mu1(this.mSwanApiContext);
                    this.mApis.put("-277316359", mu1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(mu1Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Coupon.getPlatformCoupons")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = mu1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                mu1 mu1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof mu1)) {
                    mu1Var = (mu1) obj;
                } else {
                    mu1Var = new mu1(this.mSwanApiContext);
                    this.mApis.put("-277316359", mu1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(mu1Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Coupon.getUserCoupons")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 A = mu1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                mu1 mu1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof mu1)) {
                    mu1Var = (mu1) obj;
                } else {
                    mu1Var = new mu1(this.mSwanApiContext);
                    this.mApis.put("-277316359", mu1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(mu1Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Coupon.takeCoupons")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 D = mu1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naFavorite", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                uu1 uu1Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof uu1)) {
                    uu1Var = (uu1) obj;
                } else {
                    uu1Var = new uu1(this.mSwanApiContext);
                    this.mApis.put("-1225406515", uu1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(uu1Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Favorite.getFavorStatus")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = uu1Var.y(str);
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
                Pair<Boolean, hy1> a = jy1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Favorite.showFavoriteGuide")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 H = showFavoriteGuideApi.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naFile", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                wu1 wu1Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof wu1)) {
                    wu1Var = (wu1) obj;
                } else {
                    wu1Var = new wu1(this.mSwanApiContext);
                    this.mApis.put("-2057135077", wu1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(wu1Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "File.shareFile")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = wu1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                kj2 kj2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof kj2)) {
                    kj2Var = (kj2) obj;
                } else {
                    kj2Var = new kj2(this.mSwanApiContext);
                    this.mApis.put("2077414795", kj2Var);
                }
                Pair<Boolean, hy1> a = jy1.a(kj2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = kj2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                kj2 kj2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof kj2)) {
                    kj2Var = (kj2) obj;
                } else {
                    kj2Var = new kj2(this.mSwanApiContext);
                    this.mApis.put("2077414795", kj2Var);
                }
                Pair<Boolean, hy1> a = jy1.a(kj2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessageSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = kj2Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String download(String str) {
                xu1 xu1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof xu1)) {
                    xu1Var = (xu1) obj;
                } else {
                    xu1Var = new xu1(this.mSwanApiContext);
                    this.mApis.put("-170124576", xu1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(xu1Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "HostDownloadManager.download")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = xu1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                xu1 xu1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof xu1)) {
                    xu1Var = (xu1) obj;
                } else {
                    xu1Var = new xu1(this.mSwanApiContext);
                    this.mApis.put("-170124576", xu1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(xu1Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "HostDownloadManager.openFile")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 A = xu1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String query(String str) {
                xu1 xu1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof xu1)) {
                    xu1Var = (xu1) obj;
                } else {
                    xu1Var = new xu1(this.mSwanApiContext);
                    this.mApis.put("-170124576", xu1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(xu1Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "HostDownloadManager.query")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = xu1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                xu1 xu1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof xu1)) {
                    xu1Var = (xu1) obj;
                } else {
                    xu1Var = new xu1(this.mSwanApiContext);
                    this.mApis.put("-170124576", xu1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(xu1Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "HostDownloadManager.openDownloadCenter")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = xu1Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naImage", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                yv2 yv2Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof yv2)) {
                    yv2Var = (yv2) obj;
                } else {
                    yv2Var = new yv2(this.mSwanApiContext);
                    this.mApis.put("1445003743", yv2Var);
                }
                Pair<Boolean, hy1> a = jy1.a(yv2Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Image.callImageMenu")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = yv2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                av1 av1Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof av1)) {
                    av1Var = (av1) obj;
                } else {
                    av1Var = new av1(this.mSwanApiContext);
                    this.mApis.put("-1252730367", av1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(av1Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Image.compressImage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = av1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naInteraction", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                iv1 iv1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof iv1)) {
                    iv1Var = (iv1) obj;
                } else {
                    iv1Var = new iv1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", iv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(iv1Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.closeTabBar")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = iv1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                iv1 iv1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof iv1)) {
                    iv1Var = (iv1) obj;
                } else {
                    iv1Var = new iv1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", iv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(iv1Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.closeTabBarRedDot")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = iv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                ev1 ev1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof ev1)) {
                    ev1Var = (ev1) obj;
                } else {
                    ev1Var = new ev1(this.mSwanApiContext);
                    this.mApis.put("-246386074", ev1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ev1Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.hideNavigationBarLoading")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = ev1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                gv1 gv1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof gv1)) {
                    gv1Var = (gv1) obj;
                } else {
                    gv1Var = new gv1(this.mSwanApiContext);
                    this.mApis.put("-108978463", gv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(gv1Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.openMultiPicker")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 H = gv1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                gv1 gv1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof gv1)) {
                    gv1Var = (gv1) obj;
                } else {
                    gv1Var = new gv1(this.mSwanApiContext);
                    this.mApis.put("-108978463", gv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(gv1Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.openPicker")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 I = gv1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                iv1 iv1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof iv1)) {
                    iv1Var = (iv1) obj;
                } else {
                    iv1Var = new iv1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", iv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(iv1Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.openTabBar")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 D = iv1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                fv1 fv1Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof fv1)) {
                    fv1Var = (fv1) obj;
                } else {
                    fv1Var = new fv1(this.mSwanApiContext);
                    this.mApis.put("-1750613704", fv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(fv1Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.pageScrollTo")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = fv1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                ev1 ev1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof ev1)) {
                    ev1Var = (ev1) obj;
                } else {
                    ev1Var = new ev1(this.mSwanApiContext);
                    this.mApis.put("-246386074", ev1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ev1Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarColor")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 A = ev1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                ev1 ev1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof ev1)) {
                    ev1Var = (ev1) obj;
                } else {
                    ev1Var = new ev1(this.mSwanApiContext);
                    this.mApis.put("-246386074", ev1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ev1Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarTitle")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = ev1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                iv1 iv1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof iv1)) {
                    iv1Var = (iv1) obj;
                } else {
                    iv1Var = new iv1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", iv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(iv1Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.setTabBarItem")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 E = iv1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                gv1 gv1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof gv1)) {
                    gv1Var = (gv1) obj;
                } else {
                    gv1Var = new gv1(this.mSwanApiContext);
                    this.mApis.put("-108978463", gv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(gv1Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.showDatePickerView")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 M = gv1Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                kv1 kv1Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof kv1)) {
                    kv1Var = (kv1) obj;
                } else {
                    kv1Var = new kv1(this.mSwanApiContext);
                    this.mApis.put("1172469410", kv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(kv1Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.showHalfScreenWebview")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 L = kv1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                cv1 cv1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof cv1)) {
                    cv1Var = (cv1) obj;
                } else {
                    cv1Var = new cv1(this.mSwanApiContext);
                    this.mApis.put("5236036", cv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(cv1Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.showLoading")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = cv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                dv1 dv1Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof dv1)) {
                    dv1Var = (dv1) obj;
                } else {
                    dv1Var = new dv1(this.mSwanApiContext);
                    this.mApis.put("1913747800", dv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(dv1Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.showModal")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = dv1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                ev1 ev1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof ev1)) {
                    ev1Var = (ev1) obj;
                } else {
                    ev1Var = new ev1(this.mSwanApiContext);
                    this.mApis.put("-246386074", ev1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ev1Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.showNavigationBarLoading")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 C = ev1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                jv1 jv1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof jv1)) {
                    jv1Var = (jv1) obj;
                } else {
                    jv1Var = new jv1(this.mSwanApiContext);
                    this.mApis.put("1159492510", jv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(jv1Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.showToast")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 R = jv1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                hv1 hv1Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof hv1)) {
                    hv1Var = (hv1) obj;
                } else {
                    hv1Var = new hv1(this.mSwanApiContext);
                    this.mApis.put("1165118609", hv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(hv1Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.stopPullDownRefresh")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = hv1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                gv1 gv1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof gv1)) {
                    gv1Var = (gv1) obj;
                } else {
                    gv1Var = new gv1(this.mSwanApiContext);
                    this.mApis.put("-108978463", gv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(gv1Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.updateMultiPicker")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 N = gv1Var.N(str);
                if (N == null) {
                    return "";
                }
                return N.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                cv1 cv1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof cv1)) {
                    cv1Var = (cv1) obj;
                } else {
                    cv1Var = new cv1(this.mSwanApiContext);
                    this.mApis.put("5236036", cv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(cv1Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.hideLoading")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = cv1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideToast() {
                jv1 jv1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof jv1)) {
                    jv1Var = (jv1) obj;
                } else {
                    jv1Var = new jv1(this.mSwanApiContext);
                    this.mApis.put("1159492510", jv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(jv1Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.hideToast")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 L = jv1Var.L();
                if (L == null) {
                    return "";
                }
                return L.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                lv1 lv1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof lv1)) {
                    lv1Var = (lv1) obj;
                } else {
                    lv1Var = new lv1(this.mSwanApiContext);
                    this.mApis.put("-137346255", lv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(lv1Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Keyboard.startKeyboardHeightChange")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 D = lv1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                lv1 lv1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof lv1)) {
                    lv1Var = (lv1) obj;
                } else {
                    lv1Var = new lv1(this.mSwanApiContext);
                    this.mApis.put("-137346255", lv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(lv1Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Keyboard.stopKeyboardHeightChange")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 E = lv1Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }
        });
        hashMap.put("_naLocationService", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                mv1 mv1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof mv1)) {
                    mv1Var = (mv1) obj;
                } else {
                    mv1Var = new mv1(this.mSwanApiContext);
                    this.mApis.put("-397373095", mv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(mv1Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "LocationService.getLocation")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = mv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                mv1 mv1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof mv1)) {
                    mv1Var = (mv1) obj;
                } else {
                    mv1Var = new mv1(this.mSwanApiContext);
                    this.mApis.put("-397373095", mv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(mv1Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "LocationService.startLocationUpdate")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = mv1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                mv1 mv1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof mv1)) {
                    mv1Var = (mv1) obj;
                } else {
                    mv1Var = new mv1(this.mSwanApiContext);
                    this.mApis.put("-397373095", mv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(mv1Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "LocationService.stopLocationUpdate")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 C = mv1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naMenu", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                dx1 dx1Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof dx1)) {
                    dx1Var = (dx1) obj;
                } else {
                    dx1Var = new dx1(this.mSwanApiContext);
                    this.mApis.put("538070032", dx1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(dx1Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = dx1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naNetwork", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                pv1 pv1Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof pv1)) {
                    pv1Var = (pv1) obj;
                } else {
                    pv1Var = new pv1(this.mSwanApiContext);
                    this.mApis.put("-1076509454", pv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(pv1Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Network.callService")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = pv1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                wv1 wv1Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof wv1)) {
                    wv1Var = (wv1) obj;
                } else {
                    wv1Var = new wv1(this.mSwanApiContext);
                    this.mApis.put("968563034", wv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(wv1Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Network.cancelRequest")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 E = wv1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                vv1 vv1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof vv1)) {
                    vv1Var = (vv1) obj;
                } else {
                    vv1Var = new vv1(this.mSwanApiContext);
                    this.mApis.put("453220699", vv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(vv1Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Network.networkStatusChange")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = vv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                vv1 vv1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof vv1)) {
                    vv1Var = (vv1) obj;
                } else {
                    vv1Var = new vv1(this.mSwanApiContext);
                    this.mApis.put("453220699", vv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(vv1Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Network.getNetworkType")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = vv1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(JsObject jsObject) {
                wv1 wv1Var;
                String a;
                try {
                    gy1.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof wv1)) {
                        wv1Var = (wv1) obj;
                    } else {
                        wv1Var = new wv1(this.mSwanApiContext);
                        this.mApis.put("968563034", wv1Var);
                    }
                    Pair<Boolean, hy1> a2 = jy1.a(wv1Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((hy1) a2.second).a();
                    } else if (o82.a(this.mSwanApiContext.e(), "Network.request")) {
                        a = new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<hy1, JSONObject> u = lu1.u(jsObject);
                        if (!((hy1) u.first).isSuccess()) {
                            a = ((hy1) u.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) u.second;
                            if (jSONObject == null) {
                                a = hy1.a.a();
                            } else {
                                iy1 W = wv1Var.W(jSONObject);
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
                        gy1.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                ez2 ez2Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof ez2)) {
                    ez2Var = (ez2) obj;
                } else {
                    ez2Var = new ez2(this.mSwanApiContext);
                    this.mApis.put("-336396851", ez2Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ez2Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Payment.chooseCoupon")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = ez2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                ez2 ez2Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof ez2)) {
                    ez2Var = (ez2) obj;
                } else {
                    ez2Var = new ez2(this.mSwanApiContext);
                    this.mApis.put("-336396851", ez2Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ez2Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Payment.getPaymentInfo")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = ez2Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                uy2 uy2Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof uy2)) {
                    uy2Var = (uy2) obj;
                } else {
                    uy2Var = new uy2(this.mSwanApiContext);
                    this.mApis.put("1854689529", uy2Var);
                }
                Pair<Boolean, hy1> a = jy1.a(uy2Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Payment.requestThirdPayment")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = uy2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                ez2 ez2Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof ez2)) {
                    ez2Var = (ez2) obj;
                } else {
                    ez2Var = new ez2(this.mSwanApiContext);
                    this.mApis.put("-336396851", ez2Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ez2Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Payment.setPaymentInfo")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 A = ez2Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPlugin", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                p13 p13Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof p13)) {
                    p13Var = (p13) obj;
                } else {
                    p13Var = new p13(this.mSwanApiContext);
                    this.mApis.put("-254510461", p13Var);
                }
                Pair<Boolean, hy1> a = jy1.a(p13Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Plugin.invokePluginChooseAddress")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = p13Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                p13 p13Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof p13)) {
                    p13Var = (p13) obj;
                } else {
                    p13Var = new p13(this.mSwanApiContext);
                    this.mApis.put("-254510461", p13Var);
                }
                Pair<Boolean, hy1> a = jy1.a(p13Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 A = p13Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                p13 p13Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof p13)) {
                    p13Var = (p13) obj;
                } else {
                    p13Var = new p13(this.mSwanApiContext);
                    this.mApis.put("-254510461", p13Var);
                }
                Pair<Boolean, hy1> a = jy1.a(p13Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Plugin.invokePluginPayment")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = p13Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                ia2 ia2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof ia2)) {
                    ia2Var = (ia2) obj;
                } else {
                    ia2Var = new ia2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", ia2Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ia2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Prefetch.prefetchResources")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = ia2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPreload", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                a92 a92Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof a92)) {
                    a92Var = (a92) obj;
                } else {
                    a92Var = new a92(this.mSwanApiContext);
                    this.mApis.put("423661539", a92Var);
                }
                Pair<Boolean, hy1> a = jy1.a(a92Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Preload.preloadStatus")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = a92Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                ki3 ki3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof ki3)) {
                    ki3Var = (ki3) obj;
                } else {
                    ki3Var = new ki3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", ki3Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ki3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "PrivateFile.uploadFileToBos")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 D = ki3Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naRouter", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                aw1 aw1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof aw1)) {
                    aw1Var = (aw1) obj;
                } else {
                    aw1Var = new aw1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", aw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(aw1Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Router.hideModalPage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = aw1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                aw1 aw1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof aw1)) {
                    aw1Var = (aw1) obj;
                } else {
                    aw1Var = new aw1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", aw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(aw1Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Router.navigateBack")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 C = aw1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                bw1 bw1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof bw1)) {
                    bw1Var = (bw1) obj;
                } else {
                    bw1Var = new bw1(this.mSwanApiContext);
                    this.mApis.put("1968522584", bw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(bw1Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Router.navigateTo")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 I = bw1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                dw1 dw1Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof dw1)) {
                    dw1Var = (dw1) obj;
                } else {
                    dw1Var = new dw1(this.mSwanApiContext);
                    this.mApis.put("1317280190", dw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(dw1Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Router.reLaunch")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = dw1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                ew1 ew1Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof ew1)) {
                    ew1Var = (ew1) obj;
                } else {
                    ew1Var = new ew1(this.mSwanApiContext);
                    this.mApis.put("-420075743", ew1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ew1Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Router.reLoadErrorPage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = ew1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                cw1 cw1Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof cw1)) {
                    cw1Var = (cw1) obj;
                } else {
                    cw1Var = new cw1(this.mSwanApiContext);
                    this.mApis.put("1792515533", cw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(cw1Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Router.redirectTo")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 E = cw1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                bw1 bw1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof bw1)) {
                    bw1Var = (bw1) obj;
                } else {
                    bw1Var = new bw1(this.mSwanApiContext);
                    this.mApis.put("1968522584", bw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(bw1Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Router.showModalPage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 K = bw1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naSetting", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                hw1 hw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof hw1)) {
                    hw1Var = (hw1) obj;
                } else {
                    hw1Var = new hw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", hw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(hw1Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Setting.getAppInfoSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 G = hw1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                hw1 hw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof hw1)) {
                    hw1Var = (hw1) obj;
                } else {
                    hw1Var = new hw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", hw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(hw1Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Setting.getSlaveIdSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 I = hw1Var.I();
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                gw1 gw1Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof gw1)) {
                    gw1Var = (gw1) obj;
                } else {
                    gw1Var = new gw1(this.mSwanApiContext);
                    this.mApis.put("450273045", gw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(gw1Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Setting.isAllowedAdOpenAppSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = gw1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                hw1 hw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof hw1)) {
                    hw1Var = (hw1) obj;
                } else {
                    hw1Var = new hw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", hw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(hw1Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Setting.getSetting")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 H = hw1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                hw1 hw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof hw1)) {
                    hw1Var = (hw1) obj;
                } else {
                    hw1Var = new hw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", hw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(hw1Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Setting.getSwanId")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 J = hw1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                hw1 hw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof hw1)) {
                    hw1Var = (hw1) obj;
                } else {
                    hw1Var = new hw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", hw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(hw1Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Setting.getUserInfo")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 K = hw1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                ed3 ed3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof ed3)) {
                    ed3Var = (ed3) obj;
                } else {
                    ed3Var = new ed3(this.mSwanApiContext);
                    this.mApis.put("712777136", ed3Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ed3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = ed3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naStorage", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                kw1 kw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", kw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(kw1Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = kw1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                kw1 kw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", kw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(kw1Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorageSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 D = kw1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                jw1 jw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("130910081", jw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(jw1Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.clearStorage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = jw1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                jw1 jw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("130910081", jw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(jw1Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.clearStorageSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 D = jw1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                kw1 kw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", kw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(kw1Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfo")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 H = kw1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                kw1 kw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", kw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(kw1Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfoSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 K = kw1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                jw1 jw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("130910081", jw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(jw1Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.getStorageInfo")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 H = jw1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                jw1 jw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("130910081", jw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(jw1Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.getStorageInfoSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 K = jw1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                kw1 kw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", kw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(kw1Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.getGlobalStorage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 E = kw1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                kw1 kw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", kw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(kw1Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 L = kw1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("130910081", jw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(jw1Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.getStorage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 E = jw1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("130910081", jw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(jw1Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.getStorageInfoAsync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 I = jw1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("130910081", jw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(jw1Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.getStorageSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 L = jw1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                kw1 kw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", kw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(kw1Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 S = kw1Var.S(str);
                if (S == null) {
                    return "";
                }
                return S.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                kw1 kw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", kw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(kw1Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorageSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 U = kw1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("130910081", jw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(jw1Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.removeStorage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 S = jw1Var.S(str);
                if (S == null) {
                    return "";
                }
                return S.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("130910081", jw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(jw1Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.removeStorageSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 U = jw1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                kw1 kw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", kw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(kw1Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.setGlobalStorage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 V = kw1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                kw1 kw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", kw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(kw1Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.setGlobalStorageSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 X = kw1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("130910081", jw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(jw1Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.setStorage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 V = jw1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("130910081", jw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(jw1Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.setStorageSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 X = jw1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naSubscription", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                mw1 mw1Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("823117982", mw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(mw1Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Subscription.requestSubscribeFormId")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 F = mw1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                nw1 nw1Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof nw1)) {
                    nw1Var = (nw1) obj;
                } else {
                    nw1Var = new nw1(this.mSwanApiContext);
                    this.mApis.put("-947445811", nw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(nw1Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Subscription.subscribeService")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 G = nw1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naSystem", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                uw1 uw1Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof uw1)) {
                    uw1Var = (uw1) obj;
                } else {
                    uw1Var = new uw1(this.mSwanApiContext);
                    this.mApis.put("1936205521", uw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(uw1Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.exitFullScreen")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = uw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("1694151270", tw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(tw1Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.getDeviceInfo")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = tw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                vw1 vw1Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("-1321681619", vw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(vw1Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.getDeviceProfile")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = vw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                ww1 ww1Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof ww1)) {
                    ww1Var = (ww1) obj;
                } else {
                    ww1Var = new ww1(this.mSwanApiContext);
                    this.mApis.put("-1569246082", ww1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ww1Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.makePhoneCall")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = ww1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                yw1 yw1Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof yw1)) {
                    yw1Var = (yw1) obj;
                } else {
                    yw1Var = new yw1(this.mSwanApiContext);
                    this.mApis.put("1099851202", yw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(yw1Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.openSMSPanel")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = yw1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                xw1 xw1Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof xw1)) {
                    xw1Var = (xw1) obj;
                } else {
                    xw1Var = new xw1(this.mSwanApiContext);
                    this.mApis.put("-1707203360", xw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(xw1Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.requestFullScreen")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 G = xw1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                rw1 rw1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("-518757484", rw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(rw1Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.setClipboardData")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = rw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                aw2 aw2Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof aw2)) {
                    aw2Var = (aw2) obj;
                } else {
                    aw2Var = new aw2(this.mSwanApiContext);
                    this.mApis.put("1161486049", aw2Var);
                }
                Pair<Boolean, hy1> a = jy1.a(aw2Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.setErrorPageType")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = aw2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                bx1 bx1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof bx1)) {
                    bx1Var = (bx1) obj;
                } else {
                    bx1Var = new bx1(this.mSwanApiContext);
                    this.mApis.put("447234992", bx1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(bx1Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.setMediaVolume")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 A = bx1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                pw1 pw1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof pw1)) {
                    pw1Var = (pw1) obj;
                } else {
                    pw1Var = new pw1(this.mSwanApiContext);
                    this.mApis.put("1372680763", pw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(pw1Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.startAccelerometer")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = pw1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                sw1 sw1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof sw1)) {
                    sw1Var = (sw1) obj;
                } else {
                    sw1Var = new sw1(this.mSwanApiContext);
                    this.mApis.put("1689255576", sw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(sw1Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.startCompass")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = sw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                qw1 qw1Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof qw1)) {
                    qw1Var = (qw1) obj;
                } else {
                    qw1Var = new qw1(this.mSwanApiContext);
                    this.mApis.put("99997465", qw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(qw1Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.getBrightness")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = qw1Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                rw1 rw1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("-518757484", rw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(rw1Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.getClipboardData")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = rw1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                bx1 bx1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof bx1)) {
                    bx1Var = (bx1) obj;
                } else {
                    bx1Var = new bx1(this.mSwanApiContext);
                    this.mApis.put("447234992", bx1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(bx1Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.getMediaVolume")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = bx1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                pw1 pw1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof pw1)) {
                    pw1Var = (pw1) obj;
                } else {
                    pw1Var = new pw1(this.mSwanApiContext);
                    this.mApis.put("1372680763", pw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(pw1Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.stopAccelerometer")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 C = pw1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                sw1 sw1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof sw1)) {
                    sw1Var = (sw1) obj;
                } else {
                    sw1Var = new sw1(this.mSwanApiContext);
                    this.mApis.put("1689255576", sw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(sw1Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.stopCompass")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 A = sw1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naUtils", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                mx1 mx1Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof mx1)) {
                    mx1Var = (mx1) obj;
                } else {
                    mx1Var = new mx1(this.mSwanApiContext);
                    this.mApis.put("201194468", mx1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(mx1Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.addToDesktop")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 C = mx1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                ix1 ix1Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof ix1)) {
                    ix1Var = (ix1) obj;
                } else {
                    ix1Var = new ix1(this.mSwanApiContext);
                    this.mApis.put("-1412306947", ix1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ix1Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.calcMD5")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = ix1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                jx1 jx1Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof jx1)) {
                    jx1Var = (jx1) obj;
                } else {
                    jx1Var = new jx1(this.mSwanApiContext);
                    this.mApis.put("1626415364", jx1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(jx1Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.checkAppInstalled")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = jx1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                lx1 lx1Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof lx1)) {
                    lx1Var = (lx1) obj;
                } else {
                    lx1Var = new lx1(this.mSwanApiContext);
                    this.mApis.put("-836768778", lx1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(lx1Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfo")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = lx1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                nx1 nx1Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof nx1)) {
                    nx1Var = (nx1) obj;
                } else {
                    nx1Var = new nx1(this.mSwanApiContext);
                    this.mApis.put("-810858308", nx1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(nx1Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.getPerformanceLevel")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = nx1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                rx1 rx1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof rx1)) {
                    rx1Var = (rx1) obj;
                } else {
                    rx1Var = new rx1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", rx1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(rx1Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.getSystemInfoAsync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 J = rx1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                ox1 ox1Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof ox1)) {
                    ox1Var = (ox1) obj;
                } else {
                    ox1Var = new ox1(this.mSwanApiContext);
                    this.mApis.put("-2097727681", ox1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ox1Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.handleException")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = ox1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                kx1 kx1Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof kx1)) {
                    kx1Var = (kx1) obj;
                } else {
                    kx1Var = new kx1(this.mSwanApiContext);
                    this.mApis.put("2084449317", kx1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(kx1Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.hasCloseHandler")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = kx1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                ma3 ma3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof ma3)) {
                    ma3Var = (ma3) obj;
                } else {
                    ma3Var = new ma3(this.mSwanApiContext);
                    this.mApis.put("1031678042", ma3Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ma3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.hideCaptureScreenShareDialog")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = ma3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                px1 px1Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof px1)) {
                    px1Var = (px1) obj;
                } else {
                    px1Var = new px1(this.mSwanApiContext);
                    this.mApis.put("1751900130", px1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(px1Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.logToFile")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = px1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                n93 n93Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof n93)) {
                    n93Var = (n93) obj;
                } else {
                    n93Var = new n93(this.mSwanApiContext);
                    this.mApis.put("1748196865", n93Var);
                }
                Pair<Boolean, hy1> a = jy1.a(n93Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.preloadPackage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = n93Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                qx1 qx1Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("589529211", qx1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(qx1Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.previewImage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 C = qx1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                tx1 tx1Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof tx1)) {
                    tx1Var = (tx1) obj;
                } else {
                    tx1Var = new tx1(this.mSwanApiContext);
                    this.mApis.put("-577481801", tx1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(tx1Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.ubcFlowJar")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 J = tx1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                rx1 rx1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof rx1)) {
                    rx1Var = (rx1) obj;
                } else {
                    rx1Var = new rx1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", rx1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(rx1Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfoSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 F = rx1Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                rx1 rx1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof rx1)) {
                    rx1Var = (rx1) obj;
                } else {
                    rx1Var = new rx1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", rx1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(rx1Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.getSystemInfo")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 I = rx1Var.I();
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                rx1 rx1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof rx1)) {
                    rx1Var = (rx1) obj;
                } else {
                    rx1Var = new rx1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", rx1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(rx1Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.getSystemInfoSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 K = rx1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naWifi", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                xg3 xg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof xg3)) {
                    xg3Var = (xg3) obj;
                } else {
                    xg3Var = new xg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", xg3Var);
                }
                Pair<Boolean, hy1> a = jy1.a(xg3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Wifi.connectWifi")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = xg3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                xg3 xg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof xg3)) {
                    xg3Var = (xg3) obj;
                } else {
                    xg3Var = new xg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", xg3Var);
                }
                Pair<Boolean, hy1> a = jy1.a(xg3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Wifi.getConnectedWifi")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 C = xg3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                xg3 xg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof xg3)) {
                    xg3Var = (xg3) obj;
                } else {
                    xg3Var = new xg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", xg3Var);
                }
                Pair<Boolean, hy1> a = jy1.a(xg3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Wifi.getWifiList")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 D = xg3Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                xg3 xg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof xg3)) {
                    xg3Var = (xg3) obj;
                } else {
                    xg3Var = new xg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", xg3Var);
                }
                Pair<Boolean, hy1> a = jy1.a(xg3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Wifi.startWifi")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 H = xg3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                xg3 xg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof xg3)) {
                    xg3Var = (xg3) obj;
                } else {
                    xg3Var = new xg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", xg3Var);
                }
                Pair<Boolean, hy1> a = jy1.a(xg3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Wifi.stopWifi")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 I = xg3Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final ju1 ju1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                pu1 pu1Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof pu1)) {
                    pu1Var = (pu1) obj;
                } else {
                    pu1Var = new pu1(this.mSwanApiContext);
                    this.mApis.put("1930258908", pu1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(pu1Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Account.checkSession")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = pu1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                qu1 qu1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof qu1)) {
                    qu1Var = (qu1) obj;
                } else {
                    qu1Var = new qu1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", qu1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(qu1Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Account.getLoginCode")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 D = qu1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                ru1 ru1Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof ru1)) {
                    ru1Var = (ru1) obj;
                } else {
                    ru1Var = new ru1(this.mSwanApiContext);
                    this.mApis.put("1754780133", ru1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ru1Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Account.getOpenId")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = ru1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                yt1 yt1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof yt1)) {
                    yt1Var = (yt1) obj;
                } else {
                    yt1Var = new yt1(this.mSwanApiContext);
                    this.mApis.put("-343998465", yt1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(yt1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Account.getUnionBDUSS")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = yt1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String login(String str) {
                qu1 qu1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof qu1)) {
                    qu1Var = (qu1) obj;
                } else {
                    qu1Var = new qu1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", qu1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(qu1Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Account.login")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 J = qu1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                ou1 ou1Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof ou1)) {
                    ou1Var = (ou1) obj;
                } else {
                    ou1Var = new ou1(this.mSwanApiContext);
                    this.mApis.put("-337742792", ou1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ou1Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Account.isBaiduAccountSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = ou1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                qu1 qu1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof qu1)) {
                    qu1Var = (qu1) obj;
                } else {
                    qu1Var = new qu1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", qu1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(qu1Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Account.isLoginSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 I = qu1Var.I();
                if (I == null) {
                    return "";
                }
                return I.a();
            }
        });
        hashMap.put("_naBasic", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                su1 su1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof su1)) {
                    su1Var = (su1) obj;
                } else {
                    su1Var = new su1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", su1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(su1Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Basic.loadSubPackage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 G = su1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                su1 su1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof su1)) {
                    su1Var = (su1) obj;
                } else {
                    su1Var = new su1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", su1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(su1Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Basic.loadSubPackages")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 H = su1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                zm1 zm1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof zm1)) {
                    zm1Var = (zm1) obj;
                } else {
                    zm1Var = new zm1(this.mSwanApiContext);
                    this.mApis.put("1460300387", zm1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(zm1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Bookshelf.deleteBookshelf")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 L = zm1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                zm1 zm1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof zm1)) {
                    zm1Var = (zm1) obj;
                } else {
                    zm1Var = new zm1(this.mSwanApiContext);
                    this.mApis.put("1460300387", zm1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(zm1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Bookshelf.insertBookshelf")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 Q = zm1Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                zm1 zm1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof zm1)) {
                    zm1Var = (zm1) obj;
                } else {
                    zm1Var = new zm1(this.mSwanApiContext);
                    this.mApis.put("1460300387", zm1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(zm1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Bookshelf.navigateToBookshelf")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 V = zm1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                zm1 zm1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof zm1)) {
                    zm1Var = (zm1) obj;
                } else {
                    zm1Var = new zm1(this.mSwanApiContext);
                    this.mApis.put("1460300387", zm1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(zm1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Bookshelf.queryBookshelf")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 W = zm1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                zm1 zm1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof zm1)) {
                    zm1Var = (zm1) obj;
                } else {
                    zm1Var = new zm1(this.mSwanApiContext);
                    this.mApis.put("1460300387", zm1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(zm1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Bookshelf.updateBookshelfReadTime")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 Y = zm1Var.Y(str);
                if (Y == null) {
                    return "";
                }
                return Y.a();
            }
        });
        hashMap.put("_naCoupon", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                mu1 mu1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof mu1)) {
                    mu1Var = (mu1) obj;
                } else {
                    mu1Var = new mu1(this.mSwanApiContext);
                    this.mApis.put("-277316359", mu1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(mu1Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Coupon.getPlatformCoupons")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = mu1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                mu1 mu1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof mu1)) {
                    mu1Var = (mu1) obj;
                } else {
                    mu1Var = new mu1(this.mSwanApiContext);
                    this.mApis.put("-277316359", mu1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(mu1Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Coupon.getUserCoupons")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 A = mu1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                mu1 mu1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof mu1)) {
                    mu1Var = (mu1) obj;
                } else {
                    mu1Var = new mu1(this.mSwanApiContext);
                    this.mApis.put("-277316359", mu1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(mu1Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Coupon.takeCoupons")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 D = mu1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naFavorite", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                uu1 uu1Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof uu1)) {
                    uu1Var = (uu1) obj;
                } else {
                    uu1Var = new uu1(this.mSwanApiContext);
                    this.mApis.put("-1225406515", uu1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(uu1Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Favorite.getFavorStatus")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = uu1Var.y(str);
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
                Pair<Boolean, hy1> a = jy1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Favorite.showFavoriteGuide")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 H = showFavoriteGuideApi.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naFile", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                wu1 wu1Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof wu1)) {
                    wu1Var = (wu1) obj;
                } else {
                    wu1Var = new wu1(this.mSwanApiContext);
                    this.mApis.put("-2057135077", wu1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(wu1Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "File.shareFile")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = wu1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                kj2 kj2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof kj2)) {
                    kj2Var = (kj2) obj;
                } else {
                    kj2Var = new kj2(this.mSwanApiContext);
                    this.mApis.put("2077414795", kj2Var);
                }
                Pair<Boolean, hy1> a = jy1.a(kj2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = kj2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                kj2 kj2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof kj2)) {
                    kj2Var = (kj2) obj;
                } else {
                    kj2Var = new kj2(this.mSwanApiContext);
                    this.mApis.put("2077414795", kj2Var);
                }
                Pair<Boolean, hy1> a = jy1.a(kj2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessageSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = kj2Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String download(String str) {
                xu1 xu1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof xu1)) {
                    xu1Var = (xu1) obj;
                } else {
                    xu1Var = new xu1(this.mSwanApiContext);
                    this.mApis.put("-170124576", xu1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(xu1Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "HostDownloadManager.download")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = xu1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                xu1 xu1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof xu1)) {
                    xu1Var = (xu1) obj;
                } else {
                    xu1Var = new xu1(this.mSwanApiContext);
                    this.mApis.put("-170124576", xu1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(xu1Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "HostDownloadManager.openFile")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 A = xu1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String query(String str) {
                xu1 xu1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof xu1)) {
                    xu1Var = (xu1) obj;
                } else {
                    xu1Var = new xu1(this.mSwanApiContext);
                    this.mApis.put("-170124576", xu1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(xu1Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "HostDownloadManager.query")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = xu1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                xu1 xu1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof xu1)) {
                    xu1Var = (xu1) obj;
                } else {
                    xu1Var = new xu1(this.mSwanApiContext);
                    this.mApis.put("-170124576", xu1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(xu1Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "HostDownloadManager.openDownloadCenter")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = xu1Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naImage", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                yv2 yv2Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof yv2)) {
                    yv2Var = (yv2) obj;
                } else {
                    yv2Var = new yv2(this.mSwanApiContext);
                    this.mApis.put("1445003743", yv2Var);
                }
                Pair<Boolean, hy1> a = jy1.a(yv2Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Image.callImageMenu")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = yv2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                av1 av1Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof av1)) {
                    av1Var = (av1) obj;
                } else {
                    av1Var = new av1(this.mSwanApiContext);
                    this.mApis.put("-1252730367", av1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(av1Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Image.compressImage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = av1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naInteraction", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                iv1 iv1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof iv1)) {
                    iv1Var = (iv1) obj;
                } else {
                    iv1Var = new iv1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", iv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(iv1Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.closeTabBar")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = iv1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                iv1 iv1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof iv1)) {
                    iv1Var = (iv1) obj;
                } else {
                    iv1Var = new iv1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", iv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(iv1Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.closeTabBarRedDot")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = iv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                ev1 ev1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof ev1)) {
                    ev1Var = (ev1) obj;
                } else {
                    ev1Var = new ev1(this.mSwanApiContext);
                    this.mApis.put("-246386074", ev1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ev1Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.hideNavigationBarLoading")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = ev1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                gv1 gv1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof gv1)) {
                    gv1Var = (gv1) obj;
                } else {
                    gv1Var = new gv1(this.mSwanApiContext);
                    this.mApis.put("-108978463", gv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(gv1Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.openMultiPicker")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 H = gv1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                gv1 gv1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof gv1)) {
                    gv1Var = (gv1) obj;
                } else {
                    gv1Var = new gv1(this.mSwanApiContext);
                    this.mApis.put("-108978463", gv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(gv1Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.openPicker")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 I = gv1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                iv1 iv1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof iv1)) {
                    iv1Var = (iv1) obj;
                } else {
                    iv1Var = new iv1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", iv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(iv1Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.openTabBar")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 D = iv1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                fv1 fv1Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof fv1)) {
                    fv1Var = (fv1) obj;
                } else {
                    fv1Var = new fv1(this.mSwanApiContext);
                    this.mApis.put("-1750613704", fv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(fv1Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.pageScrollTo")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = fv1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                ev1 ev1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof ev1)) {
                    ev1Var = (ev1) obj;
                } else {
                    ev1Var = new ev1(this.mSwanApiContext);
                    this.mApis.put("-246386074", ev1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ev1Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarColor")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 A = ev1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                ev1 ev1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof ev1)) {
                    ev1Var = (ev1) obj;
                } else {
                    ev1Var = new ev1(this.mSwanApiContext);
                    this.mApis.put("-246386074", ev1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ev1Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarTitle")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = ev1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                iv1 iv1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof iv1)) {
                    iv1Var = (iv1) obj;
                } else {
                    iv1Var = new iv1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", iv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(iv1Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.setTabBarItem")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 E = iv1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                gv1 gv1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof gv1)) {
                    gv1Var = (gv1) obj;
                } else {
                    gv1Var = new gv1(this.mSwanApiContext);
                    this.mApis.put("-108978463", gv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(gv1Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.showDatePickerView")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 M = gv1Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                kv1 kv1Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof kv1)) {
                    kv1Var = (kv1) obj;
                } else {
                    kv1Var = new kv1(this.mSwanApiContext);
                    this.mApis.put("1172469410", kv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(kv1Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.showHalfScreenWebview")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 L = kv1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                cv1 cv1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof cv1)) {
                    cv1Var = (cv1) obj;
                } else {
                    cv1Var = new cv1(this.mSwanApiContext);
                    this.mApis.put("5236036", cv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(cv1Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.showLoading")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = cv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                dv1 dv1Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof dv1)) {
                    dv1Var = (dv1) obj;
                } else {
                    dv1Var = new dv1(this.mSwanApiContext);
                    this.mApis.put("1913747800", dv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(dv1Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.showModal")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = dv1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                ev1 ev1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof ev1)) {
                    ev1Var = (ev1) obj;
                } else {
                    ev1Var = new ev1(this.mSwanApiContext);
                    this.mApis.put("-246386074", ev1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ev1Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.showNavigationBarLoading")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 C = ev1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                jv1 jv1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof jv1)) {
                    jv1Var = (jv1) obj;
                } else {
                    jv1Var = new jv1(this.mSwanApiContext);
                    this.mApis.put("1159492510", jv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(jv1Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.showToast")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 R = jv1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                hv1 hv1Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof hv1)) {
                    hv1Var = (hv1) obj;
                } else {
                    hv1Var = new hv1(this.mSwanApiContext);
                    this.mApis.put("1165118609", hv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(hv1Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.stopPullDownRefresh")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = hv1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                gv1 gv1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof gv1)) {
                    gv1Var = (gv1) obj;
                } else {
                    gv1Var = new gv1(this.mSwanApiContext);
                    this.mApis.put("-108978463", gv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(gv1Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.updateMultiPicker")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 N = gv1Var.N(str);
                if (N == null) {
                    return "";
                }
                return N.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                cv1 cv1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof cv1)) {
                    cv1Var = (cv1) obj;
                } else {
                    cv1Var = new cv1(this.mSwanApiContext);
                    this.mApis.put("5236036", cv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(cv1Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.hideLoading")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = cv1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideToast() {
                jv1 jv1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof jv1)) {
                    jv1Var = (jv1) obj;
                } else {
                    jv1Var = new jv1(this.mSwanApiContext);
                    this.mApis.put("1159492510", jv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(jv1Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Interaction.hideToast")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 L = jv1Var.L();
                if (L == null) {
                    return "";
                }
                return L.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                lv1 lv1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof lv1)) {
                    lv1Var = (lv1) obj;
                } else {
                    lv1Var = new lv1(this.mSwanApiContext);
                    this.mApis.put("-137346255", lv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(lv1Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Keyboard.startKeyboardHeightChange")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 D = lv1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                lv1 lv1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof lv1)) {
                    lv1Var = (lv1) obj;
                } else {
                    lv1Var = new lv1(this.mSwanApiContext);
                    this.mApis.put("-137346255", lv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(lv1Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Keyboard.stopKeyboardHeightChange")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 E = lv1Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }
        });
        hashMap.put("_naLocationService", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                mv1 mv1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof mv1)) {
                    mv1Var = (mv1) obj;
                } else {
                    mv1Var = new mv1(this.mSwanApiContext);
                    this.mApis.put("-397373095", mv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(mv1Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "LocationService.getLocation")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = mv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                mv1 mv1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof mv1)) {
                    mv1Var = (mv1) obj;
                } else {
                    mv1Var = new mv1(this.mSwanApiContext);
                    this.mApis.put("-397373095", mv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(mv1Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "LocationService.startLocationUpdate")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = mv1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                mv1 mv1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof mv1)) {
                    mv1Var = (mv1) obj;
                } else {
                    mv1Var = new mv1(this.mSwanApiContext);
                    this.mApis.put("-397373095", mv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(mv1Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "LocationService.stopLocationUpdate")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 C = mv1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naMenu", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                dx1 dx1Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof dx1)) {
                    dx1Var = (dx1) obj;
                } else {
                    dx1Var = new dx1(this.mSwanApiContext);
                    this.mApis.put("538070032", dx1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(dx1Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = dx1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naNetwork", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                pv1 pv1Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof pv1)) {
                    pv1Var = (pv1) obj;
                } else {
                    pv1Var = new pv1(this.mSwanApiContext);
                    this.mApis.put("-1076509454", pv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(pv1Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Network.callService")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = pv1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                wv1 wv1Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof wv1)) {
                    wv1Var = (wv1) obj;
                } else {
                    wv1Var = new wv1(this.mSwanApiContext);
                    this.mApis.put("968563034", wv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(wv1Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Network.cancelRequest")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 E = wv1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                vv1 vv1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof vv1)) {
                    vv1Var = (vv1) obj;
                } else {
                    vv1Var = new vv1(this.mSwanApiContext);
                    this.mApis.put("453220699", vv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(vv1Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Network.networkStatusChange")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = vv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                vv1 vv1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof vv1)) {
                    vv1Var = (vv1) obj;
                } else {
                    vv1Var = new vv1(this.mSwanApiContext);
                    this.mApis.put("453220699", vv1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(vv1Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Network.getNetworkType")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = vv1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(String str) {
                wv1 wv1Var;
                String a;
                try {
                    gy1.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof wv1)) {
                        wv1Var = (wv1) obj;
                    } else {
                        wv1Var = new wv1(this.mSwanApiContext);
                        this.mApis.put("968563034", wv1Var);
                    }
                    Pair<Boolean, hy1> a2 = jy1.a(wv1Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((hy1) a2.second).a();
                    } else if (o82.a(this.mSwanApiContext.e(), "Network.request")) {
                        a = new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<hy1, JSONObject> v = lu1.v(str);
                        if (!((hy1) v.first).isSuccess()) {
                            a = ((hy1) v.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) v.second;
                            if (jSONObject == null) {
                                a = hy1.a.a();
                            } else {
                                iy1 W = wv1Var.W(jSONObject);
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
                        gy1.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                ez2 ez2Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof ez2)) {
                    ez2Var = (ez2) obj;
                } else {
                    ez2Var = new ez2(this.mSwanApiContext);
                    this.mApis.put("-336396851", ez2Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ez2Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Payment.chooseCoupon")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = ez2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                ez2 ez2Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof ez2)) {
                    ez2Var = (ez2) obj;
                } else {
                    ez2Var = new ez2(this.mSwanApiContext);
                    this.mApis.put("-336396851", ez2Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ez2Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Payment.getPaymentInfo")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = ez2Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                uy2 uy2Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof uy2)) {
                    uy2Var = (uy2) obj;
                } else {
                    uy2Var = new uy2(this.mSwanApiContext);
                    this.mApis.put("1854689529", uy2Var);
                }
                Pair<Boolean, hy1> a = jy1.a(uy2Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Payment.requestThirdPayment")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = uy2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                ez2 ez2Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof ez2)) {
                    ez2Var = (ez2) obj;
                } else {
                    ez2Var = new ez2(this.mSwanApiContext);
                    this.mApis.put("-336396851", ez2Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ez2Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Payment.setPaymentInfo")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 A = ez2Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPlugin", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                p13 p13Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof p13)) {
                    p13Var = (p13) obj;
                } else {
                    p13Var = new p13(this.mSwanApiContext);
                    this.mApis.put("-254510461", p13Var);
                }
                Pair<Boolean, hy1> a = jy1.a(p13Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Plugin.invokePluginChooseAddress")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = p13Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                p13 p13Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof p13)) {
                    p13Var = (p13) obj;
                } else {
                    p13Var = new p13(this.mSwanApiContext);
                    this.mApis.put("-254510461", p13Var);
                }
                Pair<Boolean, hy1> a = jy1.a(p13Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 A = p13Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                p13 p13Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof p13)) {
                    p13Var = (p13) obj;
                } else {
                    p13Var = new p13(this.mSwanApiContext);
                    this.mApis.put("-254510461", p13Var);
                }
                Pair<Boolean, hy1> a = jy1.a(p13Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Plugin.invokePluginPayment")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = p13Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                ia2 ia2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof ia2)) {
                    ia2Var = (ia2) obj;
                } else {
                    ia2Var = new ia2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", ia2Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ia2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Prefetch.prefetchResources")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = ia2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPreload", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                a92 a92Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof a92)) {
                    a92Var = (a92) obj;
                } else {
                    a92Var = new a92(this.mSwanApiContext);
                    this.mApis.put("423661539", a92Var);
                }
                Pair<Boolean, hy1> a = jy1.a(a92Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Preload.preloadStatus")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = a92Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                ki3 ki3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof ki3)) {
                    ki3Var = (ki3) obj;
                } else {
                    ki3Var = new ki3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", ki3Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ki3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "PrivateFile.uploadFileToBos")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 D = ki3Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naRouter", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                aw1 aw1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof aw1)) {
                    aw1Var = (aw1) obj;
                } else {
                    aw1Var = new aw1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", aw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(aw1Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Router.hideModalPage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = aw1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                aw1 aw1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof aw1)) {
                    aw1Var = (aw1) obj;
                } else {
                    aw1Var = new aw1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", aw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(aw1Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Router.navigateBack")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 C = aw1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                bw1 bw1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof bw1)) {
                    bw1Var = (bw1) obj;
                } else {
                    bw1Var = new bw1(this.mSwanApiContext);
                    this.mApis.put("1968522584", bw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(bw1Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Router.navigateTo")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 I = bw1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                dw1 dw1Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof dw1)) {
                    dw1Var = (dw1) obj;
                } else {
                    dw1Var = new dw1(this.mSwanApiContext);
                    this.mApis.put("1317280190", dw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(dw1Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Router.reLaunch")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = dw1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                ew1 ew1Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof ew1)) {
                    ew1Var = (ew1) obj;
                } else {
                    ew1Var = new ew1(this.mSwanApiContext);
                    this.mApis.put("-420075743", ew1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ew1Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Router.reLoadErrorPage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = ew1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                cw1 cw1Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof cw1)) {
                    cw1Var = (cw1) obj;
                } else {
                    cw1Var = new cw1(this.mSwanApiContext);
                    this.mApis.put("1792515533", cw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(cw1Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Router.redirectTo")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 E = cw1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                bw1 bw1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof bw1)) {
                    bw1Var = (bw1) obj;
                } else {
                    bw1Var = new bw1(this.mSwanApiContext);
                    this.mApis.put("1968522584", bw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(bw1Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Router.showModalPage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 K = bw1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naSetting", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                hw1 hw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof hw1)) {
                    hw1Var = (hw1) obj;
                } else {
                    hw1Var = new hw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", hw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(hw1Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Setting.getAppInfoSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 G = hw1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                hw1 hw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof hw1)) {
                    hw1Var = (hw1) obj;
                } else {
                    hw1Var = new hw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", hw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(hw1Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Setting.getSlaveIdSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 I = hw1Var.I();
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                gw1 gw1Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof gw1)) {
                    gw1Var = (gw1) obj;
                } else {
                    gw1Var = new gw1(this.mSwanApiContext);
                    this.mApis.put("450273045", gw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(gw1Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Setting.isAllowedAdOpenAppSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = gw1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                hw1 hw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof hw1)) {
                    hw1Var = (hw1) obj;
                } else {
                    hw1Var = new hw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", hw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(hw1Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Setting.getSetting")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 H = hw1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                hw1 hw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof hw1)) {
                    hw1Var = (hw1) obj;
                } else {
                    hw1Var = new hw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", hw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(hw1Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Setting.getSwanId")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 J = hw1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                hw1 hw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof hw1)) {
                    hw1Var = (hw1) obj;
                } else {
                    hw1Var = new hw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", hw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(hw1Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Setting.getUserInfo")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 K = hw1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                ed3 ed3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof ed3)) {
                    ed3Var = (ed3) obj;
                } else {
                    ed3Var = new ed3(this.mSwanApiContext);
                    this.mApis.put("712777136", ed3Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ed3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = ed3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naStorage", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                kw1 kw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", kw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(kw1Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = kw1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                kw1 kw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", kw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(kw1Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorageSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 D = kw1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                jw1 jw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("130910081", jw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(jw1Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.clearStorage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = jw1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                jw1 jw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("130910081", jw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(jw1Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.clearStorageSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 D = jw1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                kw1 kw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", kw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(kw1Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfo")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 H = kw1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                kw1 kw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", kw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(kw1Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfoSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 K = kw1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                jw1 jw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("130910081", jw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(jw1Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.getStorageInfo")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 H = jw1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                jw1 jw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("130910081", jw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(jw1Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.getStorageInfoSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 K = jw1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                kw1 kw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", kw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(kw1Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.getGlobalStorage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 E = kw1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                kw1 kw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", kw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(kw1Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 L = kw1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("130910081", jw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(jw1Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.getStorage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 E = jw1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("130910081", jw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(jw1Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.getStorageInfoAsync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 I = jw1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("130910081", jw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(jw1Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.getStorageSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 L = jw1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                kw1 kw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", kw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(kw1Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 S = kw1Var.S(str);
                if (S == null) {
                    return "";
                }
                return S.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                kw1 kw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", kw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(kw1Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorageSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 U = kw1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("130910081", jw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(jw1Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.removeStorage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 S = jw1Var.S(str);
                if (S == null) {
                    return "";
                }
                return S.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("130910081", jw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(jw1Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.removeStorageSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 U = jw1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                kw1 kw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", kw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(kw1Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.setGlobalStorage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 V = kw1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                kw1 kw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", kw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(kw1Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.setGlobalStorageSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 X = kw1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("130910081", jw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(jw1Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.setStorage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 V = jw1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("130910081", jw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(jw1Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Storage.setStorageSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 X = jw1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naSubscription", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                mw1 mw1Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("823117982", mw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(mw1Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Subscription.requestSubscribeFormId")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 F = mw1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                nw1 nw1Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof nw1)) {
                    nw1Var = (nw1) obj;
                } else {
                    nw1Var = new nw1(this.mSwanApiContext);
                    this.mApis.put("-947445811", nw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(nw1Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Subscription.subscribeService")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 G = nw1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naSystem", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                uw1 uw1Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof uw1)) {
                    uw1Var = (uw1) obj;
                } else {
                    uw1Var = new uw1(this.mSwanApiContext);
                    this.mApis.put("1936205521", uw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(uw1Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.exitFullScreen")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = uw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("1694151270", tw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(tw1Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.getDeviceInfo")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = tw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                vw1 vw1Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("-1321681619", vw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(vw1Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.getDeviceProfile")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = vw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                ww1 ww1Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof ww1)) {
                    ww1Var = (ww1) obj;
                } else {
                    ww1Var = new ww1(this.mSwanApiContext);
                    this.mApis.put("-1569246082", ww1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ww1Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.makePhoneCall")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = ww1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                yw1 yw1Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof yw1)) {
                    yw1Var = (yw1) obj;
                } else {
                    yw1Var = new yw1(this.mSwanApiContext);
                    this.mApis.put("1099851202", yw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(yw1Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.openSMSPanel")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = yw1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                xw1 xw1Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof xw1)) {
                    xw1Var = (xw1) obj;
                } else {
                    xw1Var = new xw1(this.mSwanApiContext);
                    this.mApis.put("-1707203360", xw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(xw1Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.requestFullScreen")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 G = xw1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                rw1 rw1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("-518757484", rw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(rw1Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.setClipboardData")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = rw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                aw2 aw2Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof aw2)) {
                    aw2Var = (aw2) obj;
                } else {
                    aw2Var = new aw2(this.mSwanApiContext);
                    this.mApis.put("1161486049", aw2Var);
                }
                Pair<Boolean, hy1> a = jy1.a(aw2Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.setErrorPageType")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = aw2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                bx1 bx1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof bx1)) {
                    bx1Var = (bx1) obj;
                } else {
                    bx1Var = new bx1(this.mSwanApiContext);
                    this.mApis.put("447234992", bx1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(bx1Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.setMediaVolume")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 A = bx1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                pw1 pw1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof pw1)) {
                    pw1Var = (pw1) obj;
                } else {
                    pw1Var = new pw1(this.mSwanApiContext);
                    this.mApis.put("1372680763", pw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(pw1Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.startAccelerometer")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = pw1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                sw1 sw1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof sw1)) {
                    sw1Var = (sw1) obj;
                } else {
                    sw1Var = new sw1(this.mSwanApiContext);
                    this.mApis.put("1689255576", sw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(sw1Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.startCompass")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = sw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                qw1 qw1Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof qw1)) {
                    qw1Var = (qw1) obj;
                } else {
                    qw1Var = new qw1(this.mSwanApiContext);
                    this.mApis.put("99997465", qw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(qw1Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.getBrightness")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = qw1Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                rw1 rw1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("-518757484", rw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(rw1Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.getClipboardData")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = rw1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                bx1 bx1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof bx1)) {
                    bx1Var = (bx1) obj;
                } else {
                    bx1Var = new bx1(this.mSwanApiContext);
                    this.mApis.put("447234992", bx1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(bx1Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.getMediaVolume")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = bx1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                pw1 pw1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof pw1)) {
                    pw1Var = (pw1) obj;
                } else {
                    pw1Var = new pw1(this.mSwanApiContext);
                    this.mApis.put("1372680763", pw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(pw1Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.stopAccelerometer")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 C = pw1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                sw1 sw1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof sw1)) {
                    sw1Var = (sw1) obj;
                } else {
                    sw1Var = new sw1(this.mSwanApiContext);
                    this.mApis.put("1689255576", sw1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(sw1Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "System.stopCompass")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 A = sw1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naUtils", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                mx1 mx1Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof mx1)) {
                    mx1Var = (mx1) obj;
                } else {
                    mx1Var = new mx1(this.mSwanApiContext);
                    this.mApis.put("201194468", mx1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(mx1Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.addToDesktop")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 C = mx1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                ix1 ix1Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof ix1)) {
                    ix1Var = (ix1) obj;
                } else {
                    ix1Var = new ix1(this.mSwanApiContext);
                    this.mApis.put("-1412306947", ix1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ix1Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.calcMD5")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = ix1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                jx1 jx1Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof jx1)) {
                    jx1Var = (jx1) obj;
                } else {
                    jx1Var = new jx1(this.mSwanApiContext);
                    this.mApis.put("1626415364", jx1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(jx1Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.checkAppInstalled")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = jx1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                lx1 lx1Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof lx1)) {
                    lx1Var = (lx1) obj;
                } else {
                    lx1Var = new lx1(this.mSwanApiContext);
                    this.mApis.put("-836768778", lx1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(lx1Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfo")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = lx1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                nx1 nx1Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof nx1)) {
                    nx1Var = (nx1) obj;
                } else {
                    nx1Var = new nx1(this.mSwanApiContext);
                    this.mApis.put("-810858308", nx1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(nx1Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.getPerformanceLevel")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = nx1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                rx1 rx1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof rx1)) {
                    rx1Var = (rx1) obj;
                } else {
                    rx1Var = new rx1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", rx1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(rx1Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.getSystemInfoAsync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 J = rx1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                ox1 ox1Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof ox1)) {
                    ox1Var = (ox1) obj;
                } else {
                    ox1Var = new ox1(this.mSwanApiContext);
                    this.mApis.put("-2097727681", ox1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ox1Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.handleException")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = ox1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                kx1 kx1Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof kx1)) {
                    kx1Var = (kx1) obj;
                } else {
                    kx1Var = new kx1(this.mSwanApiContext);
                    this.mApis.put("2084449317", kx1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(kx1Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.hasCloseHandler")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = kx1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                ma3 ma3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof ma3)) {
                    ma3Var = (ma3) obj;
                } else {
                    ma3Var = new ma3(this.mSwanApiContext);
                    this.mApis.put("1031678042", ma3Var);
                }
                Pair<Boolean, hy1> a = jy1.a(ma3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.hideCaptureScreenShareDialog")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 y = ma3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                px1 px1Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof px1)) {
                    px1Var = (px1) obj;
                } else {
                    px1Var = new px1(this.mSwanApiContext);
                    this.mApis.put("1751900130", px1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(px1Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.logToFile")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 z = px1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                n93 n93Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof n93)) {
                    n93Var = (n93) obj;
                } else {
                    n93Var = new n93(this.mSwanApiContext);
                    this.mApis.put("1748196865", n93Var);
                }
                Pair<Boolean, hy1> a = jy1.a(n93Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.preloadPackage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = n93Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                qx1 qx1Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("589529211", qx1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(qx1Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.previewImage")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 C = qx1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                tx1 tx1Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof tx1)) {
                    tx1Var = (tx1) obj;
                } else {
                    tx1Var = new tx1(this.mSwanApiContext);
                    this.mApis.put("-577481801", tx1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(tx1Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.ubcFlowJar")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 J = tx1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                rx1 rx1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof rx1)) {
                    rx1Var = (rx1) obj;
                } else {
                    rx1Var = new rx1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", rx1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(rx1Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfoSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 F = rx1Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                rx1 rx1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof rx1)) {
                    rx1Var = (rx1) obj;
                } else {
                    rx1Var = new rx1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", rx1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(rx1Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.getSystemInfo")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 I = rx1Var.I();
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                rx1 rx1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof rx1)) {
                    rx1Var = (rx1) obj;
                } else {
                    rx1Var = new rx1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", rx1Var);
                }
                Pair<Boolean, hy1> a = jy1.a(rx1Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Utils.getSystemInfoSync")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 K = rx1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naWifi", new Object(ju1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ju1 mSwanApiContext;

            {
                this.mSwanApiContext = ju1Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                xg3 xg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof xg3)) {
                    xg3Var = (xg3) obj;
                } else {
                    xg3Var = new xg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", xg3Var);
                }
                Pair<Boolean, hy1> a = jy1.a(xg3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Wifi.connectWifi")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 B = xg3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                xg3 xg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof xg3)) {
                    xg3Var = (xg3) obj;
                } else {
                    xg3Var = new xg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", xg3Var);
                }
                Pair<Boolean, hy1> a = jy1.a(xg3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Wifi.getConnectedWifi")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 C = xg3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                xg3 xg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof xg3)) {
                    xg3Var = (xg3) obj;
                } else {
                    xg3Var = new xg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", xg3Var);
                }
                Pair<Boolean, hy1> a = jy1.a(xg3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Wifi.getWifiList")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 D = xg3Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                xg3 xg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof xg3)) {
                    xg3Var = (xg3) obj;
                } else {
                    xg3Var = new xg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", xg3Var);
                }
                Pair<Boolean, hy1> a = jy1.a(xg3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Wifi.startWifi")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 H = xg3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                xg3 xg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof xg3)) {
                    xg3Var = (xg3) obj;
                } else {
                    xg3Var = new xg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", xg3Var);
                }
                Pair<Boolean, hy1> a = jy1.a(xg3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((hy1) a.second).a();
                }
                if (o82.a(this.mSwanApiContext.e(), "Wifi.stopWifi")) {
                    return new iy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                iy1 I = xg3Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }
        });
        return hashMap;
    }
}
