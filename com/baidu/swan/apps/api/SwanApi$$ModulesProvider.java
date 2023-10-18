package com.baidu.swan.apps.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.tieba.au1;
import com.baidu.tieba.aw1;
import com.baidu.tieba.bw1;
import com.baidu.tieba.bx1;
import com.baidu.tieba.cu1;
import com.baidu.tieba.cw1;
import com.baidu.tieba.cy2;
import com.baidu.tieba.dv1;
import com.baidu.tieba.dw1;
import com.baidu.tieba.eu1;
import com.baidu.tieba.ev1;
import com.baidu.tieba.ew1;
import com.baidu.tieba.fg3;
import com.baidu.tieba.fu1;
import com.baidu.tieba.fw1;
import com.baidu.tieba.gt1;
import com.baidu.tieba.gv2;
import com.baidu.tieba.gw1;
import com.baidu.tieba.hm1;
import com.baidu.tieba.i82;
import com.baidu.tieba.iu1;
import com.baidu.tieba.iv1;
import com.baidu.tieba.iv2;
import com.baidu.tieba.jv1;
import com.baidu.tieba.jw1;
import com.baidu.tieba.ku1;
import com.baidu.tieba.kv1;
import com.baidu.tieba.lu1;
import com.baidu.tieba.lv1;
import com.baidu.tieba.lw1;
import com.baidu.tieba.mc3;
import com.baidu.tieba.mu1;
import com.baidu.tieba.mv1;
import com.baidu.tieba.my2;
import com.baidu.tieba.nu1;
import com.baidu.tieba.ou1;
import com.baidu.tieba.ov1;
import com.baidu.tieba.ox1;
import com.baidu.tieba.pu1;
import com.baidu.tieba.pv1;
import com.baidu.tieba.px1;
import com.baidu.tieba.q92;
import com.baidu.tieba.qu1;
import com.baidu.tieba.qw1;
import com.baidu.tieba.qx1;
import com.baidu.tieba.rt1;
import com.baidu.tieba.ru1;
import com.baidu.tieba.rv1;
import com.baidu.tieba.rw1;
import com.baidu.tieba.rx1;
import com.baidu.tieba.sh3;
import com.baidu.tieba.si2;
import com.baidu.tieba.su1;
import com.baidu.tieba.sv1;
import com.baidu.tieba.sw1;
import com.baidu.tieba.tt1;
import com.baidu.tieba.tu1;
import com.baidu.tieba.tw1;
import com.baidu.tieba.u93;
import com.baidu.tieba.ut1;
import com.baidu.tieba.uu1;
import com.baidu.tieba.uv1;
import com.baidu.tieba.uw1;
import com.baidu.tieba.v83;
import com.baidu.tieba.vv1;
import com.baidu.tieba.vw1;
import com.baidu.tieba.w72;
import com.baidu.tieba.wt1;
import com.baidu.tieba.ww1;
import com.baidu.tieba.x03;
import com.baidu.tieba.xt1;
import com.baidu.tieba.xu1;
import com.baidu.tieba.xv1;
import com.baidu.tieba.xw1;
import com.baidu.tieba.yt1;
import com.baidu.tieba.yv1;
import com.baidu.tieba.yw1;
import com.baidu.tieba.zt1;
import com.baidu.tieba.zv1;
import com.baidu.tieba.zw1;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
@Keep
/* loaded from: classes4.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final rt1 rt1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                xt1 xt1Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof xt1)) {
                    xt1Var = (xt1) obj;
                } else {
                    xt1Var = new xt1(this.mSwanApiContext);
                    this.mApis.put("1930258908", xt1Var);
                }
                Pair<Boolean, px1> a = rx1.a(xt1Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Account.checkSession")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = xt1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                yt1 yt1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof yt1)) {
                    yt1Var = (yt1) obj;
                } else {
                    yt1Var = new yt1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", yt1Var);
                }
                Pair<Boolean, px1> a = rx1.a(yt1Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Account.getLoginCode")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 D = yt1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                zt1 zt1Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof zt1)) {
                    zt1Var = (zt1) obj;
                } else {
                    zt1Var = new zt1(this.mSwanApiContext);
                    this.mApis.put("1754780133", zt1Var);
                }
                Pair<Boolean, px1> a = rx1.a(zt1Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Account.getOpenId")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = zt1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                gt1 gt1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof gt1)) {
                    gt1Var = (gt1) obj;
                } else {
                    gt1Var = new gt1(this.mSwanApiContext);
                    this.mApis.put("-343998465", gt1Var);
                }
                Pair<Boolean, px1> a = rx1.a(gt1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Account.getUnionBDUSS")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = gt1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String login(String str) {
                yt1 yt1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof yt1)) {
                    yt1Var = (yt1) obj;
                } else {
                    yt1Var = new yt1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", yt1Var);
                }
                Pair<Boolean, px1> a = rx1.a(yt1Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Account.login")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 J = yt1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                wt1 wt1Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof wt1)) {
                    wt1Var = (wt1) obj;
                } else {
                    wt1Var = new wt1(this.mSwanApiContext);
                    this.mApis.put("-337742792", wt1Var);
                }
                Pair<Boolean, px1> a = rx1.a(wt1Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Account.isBaiduAccountSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = wt1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                yt1 yt1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof yt1)) {
                    yt1Var = (yt1) obj;
                } else {
                    yt1Var = new yt1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", yt1Var);
                }
                Pair<Boolean, px1> a = rx1.a(yt1Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Account.isLoginSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 I = yt1Var.I();
                if (I == null) {
                    return "";
                }
                return I.a();
            }
        });
        hashMap.put("_naBasic", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                au1 au1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof au1)) {
                    au1Var = (au1) obj;
                } else {
                    au1Var = new au1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", au1Var);
                }
                Pair<Boolean, px1> a = rx1.a(au1Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Basic.loadSubPackage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 G = au1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                au1 au1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof au1)) {
                    au1Var = (au1) obj;
                } else {
                    au1Var = new au1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", au1Var);
                }
                Pair<Boolean, px1> a = rx1.a(au1Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Basic.loadSubPackages")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 H = au1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                hm1 hm1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof hm1)) {
                    hm1Var = (hm1) obj;
                } else {
                    hm1Var = new hm1(this.mSwanApiContext);
                    this.mApis.put("1460300387", hm1Var);
                }
                Pair<Boolean, px1> a = rx1.a(hm1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Bookshelf.deleteBookshelf")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 L = hm1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                hm1 hm1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof hm1)) {
                    hm1Var = (hm1) obj;
                } else {
                    hm1Var = new hm1(this.mSwanApiContext);
                    this.mApis.put("1460300387", hm1Var);
                }
                Pair<Boolean, px1> a = rx1.a(hm1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Bookshelf.insertBookshelf")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 Q = hm1Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                hm1 hm1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof hm1)) {
                    hm1Var = (hm1) obj;
                } else {
                    hm1Var = new hm1(this.mSwanApiContext);
                    this.mApis.put("1460300387", hm1Var);
                }
                Pair<Boolean, px1> a = rx1.a(hm1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Bookshelf.navigateToBookshelf")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 V = hm1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                hm1 hm1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof hm1)) {
                    hm1Var = (hm1) obj;
                } else {
                    hm1Var = new hm1(this.mSwanApiContext);
                    this.mApis.put("1460300387", hm1Var);
                }
                Pair<Boolean, px1> a = rx1.a(hm1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Bookshelf.queryBookshelf")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 W = hm1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                hm1 hm1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof hm1)) {
                    hm1Var = (hm1) obj;
                } else {
                    hm1Var = new hm1(this.mSwanApiContext);
                    this.mApis.put("1460300387", hm1Var);
                }
                Pair<Boolean, px1> a = rx1.a(hm1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Bookshelf.updateBookshelfReadTime")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 Y = hm1Var.Y(str);
                if (Y == null) {
                    return "";
                }
                return Y.a();
            }
        });
        hashMap.put("_naCoupon", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                ut1 ut1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof ut1)) {
                    ut1Var = (ut1) obj;
                } else {
                    ut1Var = new ut1(this.mSwanApiContext);
                    this.mApis.put("-277316359", ut1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ut1Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Coupon.getPlatformCoupons")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = ut1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                ut1 ut1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof ut1)) {
                    ut1Var = (ut1) obj;
                } else {
                    ut1Var = new ut1(this.mSwanApiContext);
                    this.mApis.put("-277316359", ut1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ut1Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Coupon.getUserCoupons")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 A = ut1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                ut1 ut1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof ut1)) {
                    ut1Var = (ut1) obj;
                } else {
                    ut1Var = new ut1(this.mSwanApiContext);
                    this.mApis.put("-277316359", ut1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ut1Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Coupon.takeCoupons")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 D = ut1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naFavorite", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                cu1 cu1Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof cu1)) {
                    cu1Var = (cu1) obj;
                } else {
                    cu1Var = new cu1(this.mSwanApiContext);
                    this.mApis.put("-1225406515", cu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(cu1Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Favorite.getFavorStatus")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = cu1Var.y(str);
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
                Pair<Boolean, px1> a = rx1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Favorite.showFavoriteGuide")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 H = showFavoriteGuideApi.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naFile", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                eu1 eu1Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof eu1)) {
                    eu1Var = (eu1) obj;
                } else {
                    eu1Var = new eu1(this.mSwanApiContext);
                    this.mApis.put("-2057135077", eu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(eu1Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "File.shareFile")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = eu1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                si2 si2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof si2)) {
                    si2Var = (si2) obj;
                } else {
                    si2Var = new si2(this.mSwanApiContext);
                    this.mApis.put("2077414795", si2Var);
                }
                Pair<Boolean, px1> a = rx1.a(si2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = si2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                si2 si2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof si2)) {
                    si2Var = (si2) obj;
                } else {
                    si2Var = new si2(this.mSwanApiContext);
                    this.mApis.put("2077414795", si2Var);
                }
                Pair<Boolean, px1> a = rx1.a(si2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessageSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = si2Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String download(String str) {
                fu1 fu1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof fu1)) {
                    fu1Var = (fu1) obj;
                } else {
                    fu1Var = new fu1(this.mSwanApiContext);
                    this.mApis.put("-170124576", fu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(fu1Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "HostDownloadManager.download")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = fu1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                fu1 fu1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof fu1)) {
                    fu1Var = (fu1) obj;
                } else {
                    fu1Var = new fu1(this.mSwanApiContext);
                    this.mApis.put("-170124576", fu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(fu1Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "HostDownloadManager.openFile")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 A = fu1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String query(String str) {
                fu1 fu1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof fu1)) {
                    fu1Var = (fu1) obj;
                } else {
                    fu1Var = new fu1(this.mSwanApiContext);
                    this.mApis.put("-170124576", fu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(fu1Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "HostDownloadManager.query")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = fu1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                fu1 fu1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof fu1)) {
                    fu1Var = (fu1) obj;
                } else {
                    fu1Var = new fu1(this.mSwanApiContext);
                    this.mApis.put("-170124576", fu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(fu1Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "HostDownloadManager.openDownloadCenter")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = fu1Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naImage", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                gv2 gv2Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof gv2)) {
                    gv2Var = (gv2) obj;
                } else {
                    gv2Var = new gv2(this.mSwanApiContext);
                    this.mApis.put("1445003743", gv2Var);
                }
                Pair<Boolean, px1> a = rx1.a(gv2Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Image.callImageMenu")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = gv2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                iu1 iu1Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof iu1)) {
                    iu1Var = (iu1) obj;
                } else {
                    iu1Var = new iu1(this.mSwanApiContext);
                    this.mApis.put("-1252730367", iu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(iu1Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Image.compressImage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = iu1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naInteraction", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                qu1 qu1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof qu1)) {
                    qu1Var = (qu1) obj;
                } else {
                    qu1Var = new qu1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", qu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(qu1Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.closeTabBar")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = qu1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                qu1 qu1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof qu1)) {
                    qu1Var = (qu1) obj;
                } else {
                    qu1Var = new qu1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", qu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(qu1Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.closeTabBarRedDot")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = qu1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                mu1 mu1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof mu1)) {
                    mu1Var = (mu1) obj;
                } else {
                    mu1Var = new mu1(this.mSwanApiContext);
                    this.mApis.put("-246386074", mu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(mu1Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.hideNavigationBarLoading")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = mu1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                ou1 ou1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof ou1)) {
                    ou1Var = (ou1) obj;
                } else {
                    ou1Var = new ou1(this.mSwanApiContext);
                    this.mApis.put("-108978463", ou1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ou1Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.openMultiPicker")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 H = ou1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                ou1 ou1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof ou1)) {
                    ou1Var = (ou1) obj;
                } else {
                    ou1Var = new ou1(this.mSwanApiContext);
                    this.mApis.put("-108978463", ou1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ou1Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.openPicker")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 I = ou1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                qu1 qu1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof qu1)) {
                    qu1Var = (qu1) obj;
                } else {
                    qu1Var = new qu1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", qu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(qu1Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.openTabBar")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 D = qu1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                nu1 nu1Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof nu1)) {
                    nu1Var = (nu1) obj;
                } else {
                    nu1Var = new nu1(this.mSwanApiContext);
                    this.mApis.put("-1750613704", nu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(nu1Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.pageScrollTo")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = nu1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                mu1 mu1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof mu1)) {
                    mu1Var = (mu1) obj;
                } else {
                    mu1Var = new mu1(this.mSwanApiContext);
                    this.mApis.put("-246386074", mu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(mu1Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarColor")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 A = mu1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                mu1 mu1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof mu1)) {
                    mu1Var = (mu1) obj;
                } else {
                    mu1Var = new mu1(this.mSwanApiContext);
                    this.mApis.put("-246386074", mu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(mu1Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarTitle")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = mu1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                qu1 qu1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof qu1)) {
                    qu1Var = (qu1) obj;
                } else {
                    qu1Var = new qu1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", qu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(qu1Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.setTabBarItem")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 E = qu1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                ou1 ou1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof ou1)) {
                    ou1Var = (ou1) obj;
                } else {
                    ou1Var = new ou1(this.mSwanApiContext);
                    this.mApis.put("-108978463", ou1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ou1Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.showDatePickerView")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 M = ou1Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                su1 su1Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof su1)) {
                    su1Var = (su1) obj;
                } else {
                    su1Var = new su1(this.mSwanApiContext);
                    this.mApis.put("1172469410", su1Var);
                }
                Pair<Boolean, px1> a = rx1.a(su1Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.showHalfScreenWebview")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 L = su1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                ku1 ku1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof ku1)) {
                    ku1Var = (ku1) obj;
                } else {
                    ku1Var = new ku1(this.mSwanApiContext);
                    this.mApis.put("5236036", ku1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ku1Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.showLoading")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = ku1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                lu1 lu1Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof lu1)) {
                    lu1Var = (lu1) obj;
                } else {
                    lu1Var = new lu1(this.mSwanApiContext);
                    this.mApis.put("1913747800", lu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(lu1Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.showModal")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = lu1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                mu1 mu1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof mu1)) {
                    mu1Var = (mu1) obj;
                } else {
                    mu1Var = new mu1(this.mSwanApiContext);
                    this.mApis.put("-246386074", mu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(mu1Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.showNavigationBarLoading")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 C = mu1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                ru1 ru1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof ru1)) {
                    ru1Var = (ru1) obj;
                } else {
                    ru1Var = new ru1(this.mSwanApiContext);
                    this.mApis.put("1159492510", ru1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ru1Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.showToast")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 R = ru1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                pu1 pu1Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof pu1)) {
                    pu1Var = (pu1) obj;
                } else {
                    pu1Var = new pu1(this.mSwanApiContext);
                    this.mApis.put("1165118609", pu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(pu1Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.stopPullDownRefresh")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = pu1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                ou1 ou1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof ou1)) {
                    ou1Var = (ou1) obj;
                } else {
                    ou1Var = new ou1(this.mSwanApiContext);
                    this.mApis.put("-108978463", ou1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ou1Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.updateMultiPicker")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 N = ou1Var.N(str);
                if (N == null) {
                    return "";
                }
                return N.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                ku1 ku1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof ku1)) {
                    ku1Var = (ku1) obj;
                } else {
                    ku1Var = new ku1(this.mSwanApiContext);
                    this.mApis.put("5236036", ku1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ku1Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.hideLoading")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = ku1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideToast() {
                ru1 ru1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof ru1)) {
                    ru1Var = (ru1) obj;
                } else {
                    ru1Var = new ru1(this.mSwanApiContext);
                    this.mApis.put("1159492510", ru1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ru1Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.hideToast")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 L = ru1Var.L();
                if (L == null) {
                    return "";
                }
                return L.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                tu1 tu1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof tu1)) {
                    tu1Var = (tu1) obj;
                } else {
                    tu1Var = new tu1(this.mSwanApiContext);
                    this.mApis.put("-137346255", tu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(tu1Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Keyboard.startKeyboardHeightChange")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 D = tu1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                tu1 tu1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof tu1)) {
                    tu1Var = (tu1) obj;
                } else {
                    tu1Var = new tu1(this.mSwanApiContext);
                    this.mApis.put("-137346255", tu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(tu1Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Keyboard.stopKeyboardHeightChange")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 E = tu1Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }
        });
        hashMap.put("_naLocationService", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                uu1 uu1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof uu1)) {
                    uu1Var = (uu1) obj;
                } else {
                    uu1Var = new uu1(this.mSwanApiContext);
                    this.mApis.put("-397373095", uu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(uu1Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "LocationService.getLocation")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = uu1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                uu1 uu1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof uu1)) {
                    uu1Var = (uu1) obj;
                } else {
                    uu1Var = new uu1(this.mSwanApiContext);
                    this.mApis.put("-397373095", uu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(uu1Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "LocationService.startLocationUpdate")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = uu1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                uu1 uu1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof uu1)) {
                    uu1Var = (uu1) obj;
                } else {
                    uu1Var = new uu1(this.mSwanApiContext);
                    this.mApis.put("-397373095", uu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(uu1Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "LocationService.stopLocationUpdate")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 C = uu1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naMenu", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                lw1 lw1Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof lw1)) {
                    lw1Var = (lw1) obj;
                } else {
                    lw1Var = new lw1(this.mSwanApiContext);
                    this.mApis.put("538070032", lw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(lw1Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = lw1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naNetwork", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                xu1 xu1Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof xu1)) {
                    xu1Var = (xu1) obj;
                } else {
                    xu1Var = new xu1(this.mSwanApiContext);
                    this.mApis.put("-1076509454", xu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(xu1Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Network.callService")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = xu1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                ev1 ev1Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof ev1)) {
                    ev1Var = (ev1) obj;
                } else {
                    ev1Var = new ev1(this.mSwanApiContext);
                    this.mApis.put("968563034", ev1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ev1Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Network.cancelRequest")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 E = ev1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                dv1 dv1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof dv1)) {
                    dv1Var = (dv1) obj;
                } else {
                    dv1Var = new dv1(this.mSwanApiContext);
                    this.mApis.put("453220699", dv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(dv1Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Network.networkStatusChange")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = dv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                dv1 dv1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof dv1)) {
                    dv1Var = (dv1) obj;
                } else {
                    dv1Var = new dv1(this.mSwanApiContext);
                    this.mApis.put("453220699", dv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(dv1Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Network.getNetworkType")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = dv1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(JsObject jsObject) {
                ev1 ev1Var;
                String a;
                try {
                    ox1.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof ev1)) {
                        ev1Var = (ev1) obj;
                    } else {
                        ev1Var = new ev1(this.mSwanApiContext);
                        this.mApis.put("968563034", ev1Var);
                    }
                    Pair<Boolean, px1> a2 = rx1.a(ev1Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((px1) a2.second).a();
                    } else if (w72.a(this.mSwanApiContext.e(), "Network.request")) {
                        a = new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<px1, JSONObject> u = tt1.u(jsObject);
                        if (!((px1) u.first).isSuccess()) {
                            a = ((px1) u.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) u.second;
                            if (jSONObject == null) {
                                a = px1.a.a();
                            } else {
                                qx1 W = ev1Var.W(jSONObject);
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
                        ox1.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                my2 my2Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof my2)) {
                    my2Var = (my2) obj;
                } else {
                    my2Var = new my2(this.mSwanApiContext);
                    this.mApis.put("-336396851", my2Var);
                }
                Pair<Boolean, px1> a = rx1.a(my2Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Payment.chooseCoupon")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = my2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                my2 my2Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof my2)) {
                    my2Var = (my2) obj;
                } else {
                    my2Var = new my2(this.mSwanApiContext);
                    this.mApis.put("-336396851", my2Var);
                }
                Pair<Boolean, px1> a = rx1.a(my2Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Payment.getPaymentInfo")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = my2Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                cy2 cy2Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof cy2)) {
                    cy2Var = (cy2) obj;
                } else {
                    cy2Var = new cy2(this.mSwanApiContext);
                    this.mApis.put("1854689529", cy2Var);
                }
                Pair<Boolean, px1> a = rx1.a(cy2Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Payment.requestThirdPayment")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = cy2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                my2 my2Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof my2)) {
                    my2Var = (my2) obj;
                } else {
                    my2Var = new my2(this.mSwanApiContext);
                    this.mApis.put("-336396851", my2Var);
                }
                Pair<Boolean, px1> a = rx1.a(my2Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Payment.setPaymentInfo")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 A = my2Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPlugin", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                x03 x03Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof x03)) {
                    x03Var = (x03) obj;
                } else {
                    x03Var = new x03(this.mSwanApiContext);
                    this.mApis.put("-254510461", x03Var);
                }
                Pair<Boolean, px1> a = rx1.a(x03Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Plugin.invokePluginChooseAddress")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = x03Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                x03 x03Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof x03)) {
                    x03Var = (x03) obj;
                } else {
                    x03Var = new x03(this.mSwanApiContext);
                    this.mApis.put("-254510461", x03Var);
                }
                Pair<Boolean, px1> a = rx1.a(x03Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 A = x03Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                x03 x03Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof x03)) {
                    x03Var = (x03) obj;
                } else {
                    x03Var = new x03(this.mSwanApiContext);
                    this.mApis.put("-254510461", x03Var);
                }
                Pair<Boolean, px1> a = rx1.a(x03Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Plugin.invokePluginPayment")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = x03Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                q92 q92Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof q92)) {
                    q92Var = (q92) obj;
                } else {
                    q92Var = new q92(this.mSwanApiContext);
                    this.mApis.put("-2068479848", q92Var);
                }
                Pair<Boolean, px1> a = rx1.a(q92Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Prefetch.prefetchResources")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = q92Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPreload", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                i82 i82Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof i82)) {
                    i82Var = (i82) obj;
                } else {
                    i82Var = new i82(this.mSwanApiContext);
                    this.mApis.put("423661539", i82Var);
                }
                Pair<Boolean, px1> a = rx1.a(i82Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Preload.preloadStatus")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = i82Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                sh3 sh3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof sh3)) {
                    sh3Var = (sh3) obj;
                } else {
                    sh3Var = new sh3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", sh3Var);
                }
                Pair<Boolean, px1> a = rx1.a(sh3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "PrivateFile.uploadFileToBos")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 D = sh3Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naRouter", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                iv1 iv1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof iv1)) {
                    iv1Var = (iv1) obj;
                } else {
                    iv1Var = new iv1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", iv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(iv1Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Router.hideModalPage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = iv1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                iv1 iv1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof iv1)) {
                    iv1Var = (iv1) obj;
                } else {
                    iv1Var = new iv1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", iv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(iv1Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Router.navigateBack")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 C = iv1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                jv1 jv1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof jv1)) {
                    jv1Var = (jv1) obj;
                } else {
                    jv1Var = new jv1(this.mSwanApiContext);
                    this.mApis.put("1968522584", jv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(jv1Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Router.navigateTo")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 I = jv1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                lv1 lv1Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof lv1)) {
                    lv1Var = (lv1) obj;
                } else {
                    lv1Var = new lv1(this.mSwanApiContext);
                    this.mApis.put("1317280190", lv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(lv1Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Router.reLaunch")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = lv1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                mv1 mv1Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof mv1)) {
                    mv1Var = (mv1) obj;
                } else {
                    mv1Var = new mv1(this.mSwanApiContext);
                    this.mApis.put("-420075743", mv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(mv1Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Router.reLoadErrorPage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = mv1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                kv1 kv1Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof kv1)) {
                    kv1Var = (kv1) obj;
                } else {
                    kv1Var = new kv1(this.mSwanApiContext);
                    this.mApis.put("1792515533", kv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(kv1Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Router.redirectTo")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 E = kv1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                jv1 jv1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof jv1)) {
                    jv1Var = (jv1) obj;
                } else {
                    jv1Var = new jv1(this.mSwanApiContext);
                    this.mApis.put("1968522584", jv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(jv1Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Router.showModalPage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 K = jv1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naSetting", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                pv1 pv1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof pv1)) {
                    pv1Var = (pv1) obj;
                } else {
                    pv1Var = new pv1(this.mSwanApiContext);
                    this.mApis.put("-594895721", pv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(pv1Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Setting.getAppInfoSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 G = pv1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                pv1 pv1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof pv1)) {
                    pv1Var = (pv1) obj;
                } else {
                    pv1Var = new pv1(this.mSwanApiContext);
                    this.mApis.put("-594895721", pv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(pv1Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Setting.getSlaveIdSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 I = pv1Var.I();
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                ov1 ov1Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof ov1)) {
                    ov1Var = (ov1) obj;
                } else {
                    ov1Var = new ov1(this.mSwanApiContext);
                    this.mApis.put("450273045", ov1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ov1Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Setting.isAllowedAdOpenAppSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = ov1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                pv1 pv1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof pv1)) {
                    pv1Var = (pv1) obj;
                } else {
                    pv1Var = new pv1(this.mSwanApiContext);
                    this.mApis.put("-594895721", pv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(pv1Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Setting.getSetting")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 H = pv1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                pv1 pv1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof pv1)) {
                    pv1Var = (pv1) obj;
                } else {
                    pv1Var = new pv1(this.mSwanApiContext);
                    this.mApis.put("-594895721", pv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(pv1Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Setting.getSwanId")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 J = pv1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                pv1 pv1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof pv1)) {
                    pv1Var = (pv1) obj;
                } else {
                    pv1Var = new pv1(this.mSwanApiContext);
                    this.mApis.put("-594895721", pv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(pv1Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Setting.getUserInfo")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 K = pv1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                mc3 mc3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof mc3)) {
                    mc3Var = (mc3) obj;
                } else {
                    mc3Var = new mc3(this.mSwanApiContext);
                    this.mApis.put("712777136", mc3Var);
                }
                Pair<Boolean, px1> a = rx1.a(mc3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = mc3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naStorage", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                sv1 sv1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof sv1)) {
                    sv1Var = (sv1) obj;
                } else {
                    sv1Var = new sv1(this.mSwanApiContext);
                    this.mApis.put("-804054859", sv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(sv1Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = sv1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                sv1 sv1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof sv1)) {
                    sv1Var = (sv1) obj;
                } else {
                    sv1Var = new sv1(this.mSwanApiContext);
                    this.mApis.put("-804054859", sv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(sv1Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorageSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 D = sv1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                rv1 rv1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof rv1)) {
                    rv1Var = (rv1) obj;
                } else {
                    rv1Var = new rv1(this.mSwanApiContext);
                    this.mApis.put("130910081", rv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(rv1Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.clearStorage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = rv1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                rv1 rv1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof rv1)) {
                    rv1Var = (rv1) obj;
                } else {
                    rv1Var = new rv1(this.mSwanApiContext);
                    this.mApis.put("130910081", rv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(rv1Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.clearStorageSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 D = rv1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                sv1 sv1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof sv1)) {
                    sv1Var = (sv1) obj;
                } else {
                    sv1Var = new sv1(this.mSwanApiContext);
                    this.mApis.put("-804054859", sv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(sv1Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfo")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 H = sv1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                sv1 sv1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof sv1)) {
                    sv1Var = (sv1) obj;
                } else {
                    sv1Var = new sv1(this.mSwanApiContext);
                    this.mApis.put("-804054859", sv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(sv1Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfoSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 K = sv1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                rv1 rv1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof rv1)) {
                    rv1Var = (rv1) obj;
                } else {
                    rv1Var = new rv1(this.mSwanApiContext);
                    this.mApis.put("130910081", rv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(rv1Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.getStorageInfo")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 H = rv1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                rv1 rv1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof rv1)) {
                    rv1Var = (rv1) obj;
                } else {
                    rv1Var = new rv1(this.mSwanApiContext);
                    this.mApis.put("130910081", rv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(rv1Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.getStorageInfoSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 K = rv1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                sv1 sv1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof sv1)) {
                    sv1Var = (sv1) obj;
                } else {
                    sv1Var = new sv1(this.mSwanApiContext);
                    this.mApis.put("-804054859", sv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(sv1Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.getGlobalStorage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 E = sv1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                sv1 sv1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof sv1)) {
                    sv1Var = (sv1) obj;
                } else {
                    sv1Var = new sv1(this.mSwanApiContext);
                    this.mApis.put("-804054859", sv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(sv1Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 L = sv1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                rv1 rv1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof rv1)) {
                    rv1Var = (rv1) obj;
                } else {
                    rv1Var = new rv1(this.mSwanApiContext);
                    this.mApis.put("130910081", rv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(rv1Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.getStorage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 E = rv1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                rv1 rv1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof rv1)) {
                    rv1Var = (rv1) obj;
                } else {
                    rv1Var = new rv1(this.mSwanApiContext);
                    this.mApis.put("130910081", rv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(rv1Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.getStorageInfoAsync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 I = rv1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                rv1 rv1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof rv1)) {
                    rv1Var = (rv1) obj;
                } else {
                    rv1Var = new rv1(this.mSwanApiContext);
                    this.mApis.put("130910081", rv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(rv1Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.getStorageSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 L = rv1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                sv1 sv1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof sv1)) {
                    sv1Var = (sv1) obj;
                } else {
                    sv1Var = new sv1(this.mSwanApiContext);
                    this.mApis.put("-804054859", sv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(sv1Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 S = sv1Var.S(str);
                if (S == null) {
                    return "";
                }
                return S.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                sv1 sv1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof sv1)) {
                    sv1Var = (sv1) obj;
                } else {
                    sv1Var = new sv1(this.mSwanApiContext);
                    this.mApis.put("-804054859", sv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(sv1Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorageSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 U = sv1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                rv1 rv1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof rv1)) {
                    rv1Var = (rv1) obj;
                } else {
                    rv1Var = new rv1(this.mSwanApiContext);
                    this.mApis.put("130910081", rv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(rv1Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.removeStorage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 S = rv1Var.S(str);
                if (S == null) {
                    return "";
                }
                return S.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                rv1 rv1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof rv1)) {
                    rv1Var = (rv1) obj;
                } else {
                    rv1Var = new rv1(this.mSwanApiContext);
                    this.mApis.put("130910081", rv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(rv1Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.removeStorageSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 U = rv1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                sv1 sv1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof sv1)) {
                    sv1Var = (sv1) obj;
                } else {
                    sv1Var = new sv1(this.mSwanApiContext);
                    this.mApis.put("-804054859", sv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(sv1Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.setGlobalStorage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 V = sv1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                sv1 sv1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof sv1)) {
                    sv1Var = (sv1) obj;
                } else {
                    sv1Var = new sv1(this.mSwanApiContext);
                    this.mApis.put("-804054859", sv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(sv1Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.setGlobalStorageSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 X = sv1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                rv1 rv1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof rv1)) {
                    rv1Var = (rv1) obj;
                } else {
                    rv1Var = new rv1(this.mSwanApiContext);
                    this.mApis.put("130910081", rv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(rv1Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.setStorage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 V = rv1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                rv1 rv1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof rv1)) {
                    rv1Var = (rv1) obj;
                } else {
                    rv1Var = new rv1(this.mSwanApiContext);
                    this.mApis.put("130910081", rv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(rv1Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.setStorageSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 X = rv1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naSubscription", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                uv1 uv1Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof uv1)) {
                    uv1Var = (uv1) obj;
                } else {
                    uv1Var = new uv1(this.mSwanApiContext);
                    this.mApis.put("823117982", uv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(uv1Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Subscription.requestSubscribeFormId")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 F = uv1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                vv1 vv1Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof vv1)) {
                    vv1Var = (vv1) obj;
                } else {
                    vv1Var = new vv1(this.mSwanApiContext);
                    this.mApis.put("-947445811", vv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(vv1Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Subscription.subscribeService")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 G = vv1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naSystem", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                cw1 cw1Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof cw1)) {
                    cw1Var = (cw1) obj;
                } else {
                    cw1Var = new cw1(this.mSwanApiContext);
                    this.mApis.put("1936205521", cw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(cw1Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.exitFullScreen")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = cw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                bw1 bw1Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof bw1)) {
                    bw1Var = (bw1) obj;
                } else {
                    bw1Var = new bw1(this.mSwanApiContext);
                    this.mApis.put("1694151270", bw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(bw1Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.getDeviceInfo")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = bw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                dw1 dw1Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof dw1)) {
                    dw1Var = (dw1) obj;
                } else {
                    dw1Var = new dw1(this.mSwanApiContext);
                    this.mApis.put("-1321681619", dw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(dw1Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.getDeviceProfile")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = dw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                ew1 ew1Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof ew1)) {
                    ew1Var = (ew1) obj;
                } else {
                    ew1Var = new ew1(this.mSwanApiContext);
                    this.mApis.put("-1569246082", ew1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ew1Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.makePhoneCall")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = ew1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                gw1 gw1Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof gw1)) {
                    gw1Var = (gw1) obj;
                } else {
                    gw1Var = new gw1(this.mSwanApiContext);
                    this.mApis.put("1099851202", gw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(gw1Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.openSMSPanel")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = gw1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                fw1 fw1Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof fw1)) {
                    fw1Var = (fw1) obj;
                } else {
                    fw1Var = new fw1(this.mSwanApiContext);
                    this.mApis.put("-1707203360", fw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(fw1Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.requestFullScreen")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 G = fw1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                zv1 zv1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof zv1)) {
                    zv1Var = (zv1) obj;
                } else {
                    zv1Var = new zv1(this.mSwanApiContext);
                    this.mApis.put("-518757484", zv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(zv1Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.setClipboardData")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = zv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                iv2 iv2Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof iv2)) {
                    iv2Var = (iv2) obj;
                } else {
                    iv2Var = new iv2(this.mSwanApiContext);
                    this.mApis.put("1161486049", iv2Var);
                }
                Pair<Boolean, px1> a = rx1.a(iv2Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.setErrorPageType")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = iv2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("447234992", jw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(jw1Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.setMediaVolume")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 A = jw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                xv1 xv1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof xv1)) {
                    xv1Var = (xv1) obj;
                } else {
                    xv1Var = new xv1(this.mSwanApiContext);
                    this.mApis.put("1372680763", xv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(xv1Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.startAccelerometer")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = xv1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                aw1 aw1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof aw1)) {
                    aw1Var = (aw1) obj;
                } else {
                    aw1Var = new aw1(this.mSwanApiContext);
                    this.mApis.put("1689255576", aw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(aw1Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.startCompass")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = aw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                yv1 yv1Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof yv1)) {
                    yv1Var = (yv1) obj;
                } else {
                    yv1Var = new yv1(this.mSwanApiContext);
                    this.mApis.put("99997465", yv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(yv1Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.getBrightness")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = yv1Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                zv1 zv1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof zv1)) {
                    zv1Var = (zv1) obj;
                } else {
                    zv1Var = new zv1(this.mSwanApiContext);
                    this.mApis.put("-518757484", zv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(zv1Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.getClipboardData")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = zv1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                jw1 jw1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("447234992", jw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(jw1Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.getMediaVolume")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = jw1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                xv1 xv1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof xv1)) {
                    xv1Var = (xv1) obj;
                } else {
                    xv1Var = new xv1(this.mSwanApiContext);
                    this.mApis.put("1372680763", xv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(xv1Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.stopAccelerometer")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 C = xv1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                aw1 aw1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof aw1)) {
                    aw1Var = (aw1) obj;
                } else {
                    aw1Var = new aw1(this.mSwanApiContext);
                    this.mApis.put("1689255576", aw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(aw1Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.stopCompass")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 A = aw1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naUtils", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                uw1 uw1Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof uw1)) {
                    uw1Var = (uw1) obj;
                } else {
                    uw1Var = new uw1(this.mSwanApiContext);
                    this.mApis.put("201194468", uw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(uw1Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.addToDesktop")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 C = uw1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                qw1 qw1Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof qw1)) {
                    qw1Var = (qw1) obj;
                } else {
                    qw1Var = new qw1(this.mSwanApiContext);
                    this.mApis.put("-1412306947", qw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(qw1Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.calcMD5")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = qw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                rw1 rw1Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("1626415364", rw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(rw1Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.checkAppInstalled")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = rw1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("-836768778", tw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(tw1Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfo")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = tw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                vw1 vw1Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("-810858308", vw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(vw1Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.getPerformanceLevel")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = vw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                zw1 zw1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof zw1)) {
                    zw1Var = (zw1) obj;
                } else {
                    zw1Var = new zw1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", zw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(zw1Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.getSystemInfoAsync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 J = zw1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                ww1 ww1Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof ww1)) {
                    ww1Var = (ww1) obj;
                } else {
                    ww1Var = new ww1(this.mSwanApiContext);
                    this.mApis.put("-2097727681", ww1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ww1Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.handleException")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = ww1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                sw1 sw1Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof sw1)) {
                    sw1Var = (sw1) obj;
                } else {
                    sw1Var = new sw1(this.mSwanApiContext);
                    this.mApis.put("2084449317", sw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(sw1Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.hasCloseHandler")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = sw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                u93 u93Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof u93)) {
                    u93Var = (u93) obj;
                } else {
                    u93Var = new u93(this.mSwanApiContext);
                    this.mApis.put("1031678042", u93Var);
                }
                Pair<Boolean, px1> a = rx1.a(u93Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.hideCaptureScreenShareDialog")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = u93Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                xw1 xw1Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof xw1)) {
                    xw1Var = (xw1) obj;
                } else {
                    xw1Var = new xw1(this.mSwanApiContext);
                    this.mApis.put("1751900130", xw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(xw1Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.logToFile")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = xw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                v83 v83Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof v83)) {
                    v83Var = (v83) obj;
                } else {
                    v83Var = new v83(this.mSwanApiContext);
                    this.mApis.put("1748196865", v83Var);
                }
                Pair<Boolean, px1> a = rx1.a(v83Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.preloadPackage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = v83Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                yw1 yw1Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof yw1)) {
                    yw1Var = (yw1) obj;
                } else {
                    yw1Var = new yw1(this.mSwanApiContext);
                    this.mApis.put("589529211", yw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(yw1Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.previewImage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 C = yw1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                bx1 bx1Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof bx1)) {
                    bx1Var = (bx1) obj;
                } else {
                    bx1Var = new bx1(this.mSwanApiContext);
                    this.mApis.put("-577481801", bx1Var);
                }
                Pair<Boolean, px1> a = rx1.a(bx1Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.ubcFlowJar")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 J = bx1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                zw1 zw1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof zw1)) {
                    zw1Var = (zw1) obj;
                } else {
                    zw1Var = new zw1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", zw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(zw1Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfoSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 F = zw1Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                zw1 zw1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof zw1)) {
                    zw1Var = (zw1) obj;
                } else {
                    zw1Var = new zw1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", zw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(zw1Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.getSystemInfo")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 I = zw1Var.I();
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                zw1 zw1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof zw1)) {
                    zw1Var = (zw1) obj;
                } else {
                    zw1Var = new zw1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", zw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(zw1Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.getSystemInfoSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 K = zw1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naWifi", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                fg3 fg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof fg3)) {
                    fg3Var = (fg3) obj;
                } else {
                    fg3Var = new fg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", fg3Var);
                }
                Pair<Boolean, px1> a = rx1.a(fg3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Wifi.connectWifi")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = fg3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                fg3 fg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof fg3)) {
                    fg3Var = (fg3) obj;
                } else {
                    fg3Var = new fg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", fg3Var);
                }
                Pair<Boolean, px1> a = rx1.a(fg3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Wifi.getConnectedWifi")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 C = fg3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                fg3 fg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof fg3)) {
                    fg3Var = (fg3) obj;
                } else {
                    fg3Var = new fg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", fg3Var);
                }
                Pair<Boolean, px1> a = rx1.a(fg3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Wifi.getWifiList")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 D = fg3Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                fg3 fg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof fg3)) {
                    fg3Var = (fg3) obj;
                } else {
                    fg3Var = new fg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", fg3Var);
                }
                Pair<Boolean, px1> a = rx1.a(fg3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Wifi.startWifi")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 H = fg3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                fg3 fg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof fg3)) {
                    fg3Var = (fg3) obj;
                } else {
                    fg3Var = new fg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", fg3Var);
                }
                Pair<Boolean, px1> a = rx1.a(fg3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Wifi.stopWifi")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 I = fg3Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final rt1 rt1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                xt1 xt1Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof xt1)) {
                    xt1Var = (xt1) obj;
                } else {
                    xt1Var = new xt1(this.mSwanApiContext);
                    this.mApis.put("1930258908", xt1Var);
                }
                Pair<Boolean, px1> a = rx1.a(xt1Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Account.checkSession")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = xt1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                yt1 yt1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof yt1)) {
                    yt1Var = (yt1) obj;
                } else {
                    yt1Var = new yt1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", yt1Var);
                }
                Pair<Boolean, px1> a = rx1.a(yt1Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Account.getLoginCode")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 D = yt1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                zt1 zt1Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof zt1)) {
                    zt1Var = (zt1) obj;
                } else {
                    zt1Var = new zt1(this.mSwanApiContext);
                    this.mApis.put("1754780133", zt1Var);
                }
                Pair<Boolean, px1> a = rx1.a(zt1Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Account.getOpenId")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = zt1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                gt1 gt1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof gt1)) {
                    gt1Var = (gt1) obj;
                } else {
                    gt1Var = new gt1(this.mSwanApiContext);
                    this.mApis.put("-343998465", gt1Var);
                }
                Pair<Boolean, px1> a = rx1.a(gt1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Account.getUnionBDUSS")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = gt1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String login(String str) {
                yt1 yt1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof yt1)) {
                    yt1Var = (yt1) obj;
                } else {
                    yt1Var = new yt1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", yt1Var);
                }
                Pair<Boolean, px1> a = rx1.a(yt1Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Account.login")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 J = yt1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                wt1 wt1Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof wt1)) {
                    wt1Var = (wt1) obj;
                } else {
                    wt1Var = new wt1(this.mSwanApiContext);
                    this.mApis.put("-337742792", wt1Var);
                }
                Pair<Boolean, px1> a = rx1.a(wt1Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Account.isBaiduAccountSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = wt1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                yt1 yt1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof yt1)) {
                    yt1Var = (yt1) obj;
                } else {
                    yt1Var = new yt1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", yt1Var);
                }
                Pair<Boolean, px1> a = rx1.a(yt1Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Account.isLoginSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 I = yt1Var.I();
                if (I == null) {
                    return "";
                }
                return I.a();
            }
        });
        hashMap.put("_naBasic", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                au1 au1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof au1)) {
                    au1Var = (au1) obj;
                } else {
                    au1Var = new au1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", au1Var);
                }
                Pair<Boolean, px1> a = rx1.a(au1Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Basic.loadSubPackage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 G = au1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                au1 au1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof au1)) {
                    au1Var = (au1) obj;
                } else {
                    au1Var = new au1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", au1Var);
                }
                Pair<Boolean, px1> a = rx1.a(au1Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Basic.loadSubPackages")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 H = au1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                hm1 hm1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof hm1)) {
                    hm1Var = (hm1) obj;
                } else {
                    hm1Var = new hm1(this.mSwanApiContext);
                    this.mApis.put("1460300387", hm1Var);
                }
                Pair<Boolean, px1> a = rx1.a(hm1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Bookshelf.deleteBookshelf")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 L = hm1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                hm1 hm1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof hm1)) {
                    hm1Var = (hm1) obj;
                } else {
                    hm1Var = new hm1(this.mSwanApiContext);
                    this.mApis.put("1460300387", hm1Var);
                }
                Pair<Boolean, px1> a = rx1.a(hm1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Bookshelf.insertBookshelf")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 Q = hm1Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                hm1 hm1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof hm1)) {
                    hm1Var = (hm1) obj;
                } else {
                    hm1Var = new hm1(this.mSwanApiContext);
                    this.mApis.put("1460300387", hm1Var);
                }
                Pair<Boolean, px1> a = rx1.a(hm1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Bookshelf.navigateToBookshelf")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 V = hm1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                hm1 hm1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof hm1)) {
                    hm1Var = (hm1) obj;
                } else {
                    hm1Var = new hm1(this.mSwanApiContext);
                    this.mApis.put("1460300387", hm1Var);
                }
                Pair<Boolean, px1> a = rx1.a(hm1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Bookshelf.queryBookshelf")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 W = hm1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                hm1 hm1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof hm1)) {
                    hm1Var = (hm1) obj;
                } else {
                    hm1Var = new hm1(this.mSwanApiContext);
                    this.mApis.put("1460300387", hm1Var);
                }
                Pair<Boolean, px1> a = rx1.a(hm1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Bookshelf.updateBookshelfReadTime")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 Y = hm1Var.Y(str);
                if (Y == null) {
                    return "";
                }
                return Y.a();
            }
        });
        hashMap.put("_naCoupon", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                ut1 ut1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof ut1)) {
                    ut1Var = (ut1) obj;
                } else {
                    ut1Var = new ut1(this.mSwanApiContext);
                    this.mApis.put("-277316359", ut1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ut1Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Coupon.getPlatformCoupons")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = ut1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                ut1 ut1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof ut1)) {
                    ut1Var = (ut1) obj;
                } else {
                    ut1Var = new ut1(this.mSwanApiContext);
                    this.mApis.put("-277316359", ut1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ut1Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Coupon.getUserCoupons")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 A = ut1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                ut1 ut1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof ut1)) {
                    ut1Var = (ut1) obj;
                } else {
                    ut1Var = new ut1(this.mSwanApiContext);
                    this.mApis.put("-277316359", ut1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ut1Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Coupon.takeCoupons")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 D = ut1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naFavorite", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                cu1 cu1Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof cu1)) {
                    cu1Var = (cu1) obj;
                } else {
                    cu1Var = new cu1(this.mSwanApiContext);
                    this.mApis.put("-1225406515", cu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(cu1Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Favorite.getFavorStatus")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = cu1Var.y(str);
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
                Pair<Boolean, px1> a = rx1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Favorite.showFavoriteGuide")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 H = showFavoriteGuideApi.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naFile", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                eu1 eu1Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof eu1)) {
                    eu1Var = (eu1) obj;
                } else {
                    eu1Var = new eu1(this.mSwanApiContext);
                    this.mApis.put("-2057135077", eu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(eu1Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "File.shareFile")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = eu1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                si2 si2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof si2)) {
                    si2Var = (si2) obj;
                } else {
                    si2Var = new si2(this.mSwanApiContext);
                    this.mApis.put("2077414795", si2Var);
                }
                Pair<Boolean, px1> a = rx1.a(si2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = si2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                si2 si2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof si2)) {
                    si2Var = (si2) obj;
                } else {
                    si2Var = new si2(this.mSwanApiContext);
                    this.mApis.put("2077414795", si2Var);
                }
                Pair<Boolean, px1> a = rx1.a(si2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessageSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = si2Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String download(String str) {
                fu1 fu1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof fu1)) {
                    fu1Var = (fu1) obj;
                } else {
                    fu1Var = new fu1(this.mSwanApiContext);
                    this.mApis.put("-170124576", fu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(fu1Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "HostDownloadManager.download")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = fu1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                fu1 fu1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof fu1)) {
                    fu1Var = (fu1) obj;
                } else {
                    fu1Var = new fu1(this.mSwanApiContext);
                    this.mApis.put("-170124576", fu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(fu1Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "HostDownloadManager.openFile")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 A = fu1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String query(String str) {
                fu1 fu1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof fu1)) {
                    fu1Var = (fu1) obj;
                } else {
                    fu1Var = new fu1(this.mSwanApiContext);
                    this.mApis.put("-170124576", fu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(fu1Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "HostDownloadManager.query")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = fu1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                fu1 fu1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof fu1)) {
                    fu1Var = (fu1) obj;
                } else {
                    fu1Var = new fu1(this.mSwanApiContext);
                    this.mApis.put("-170124576", fu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(fu1Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "HostDownloadManager.openDownloadCenter")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = fu1Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naImage", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                gv2 gv2Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof gv2)) {
                    gv2Var = (gv2) obj;
                } else {
                    gv2Var = new gv2(this.mSwanApiContext);
                    this.mApis.put("1445003743", gv2Var);
                }
                Pair<Boolean, px1> a = rx1.a(gv2Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Image.callImageMenu")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = gv2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                iu1 iu1Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof iu1)) {
                    iu1Var = (iu1) obj;
                } else {
                    iu1Var = new iu1(this.mSwanApiContext);
                    this.mApis.put("-1252730367", iu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(iu1Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Image.compressImage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = iu1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naInteraction", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                qu1 qu1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof qu1)) {
                    qu1Var = (qu1) obj;
                } else {
                    qu1Var = new qu1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", qu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(qu1Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.closeTabBar")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = qu1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                qu1 qu1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof qu1)) {
                    qu1Var = (qu1) obj;
                } else {
                    qu1Var = new qu1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", qu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(qu1Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.closeTabBarRedDot")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = qu1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                mu1 mu1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof mu1)) {
                    mu1Var = (mu1) obj;
                } else {
                    mu1Var = new mu1(this.mSwanApiContext);
                    this.mApis.put("-246386074", mu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(mu1Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.hideNavigationBarLoading")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = mu1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                ou1 ou1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof ou1)) {
                    ou1Var = (ou1) obj;
                } else {
                    ou1Var = new ou1(this.mSwanApiContext);
                    this.mApis.put("-108978463", ou1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ou1Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.openMultiPicker")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 H = ou1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                ou1 ou1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof ou1)) {
                    ou1Var = (ou1) obj;
                } else {
                    ou1Var = new ou1(this.mSwanApiContext);
                    this.mApis.put("-108978463", ou1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ou1Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.openPicker")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 I = ou1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                qu1 qu1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof qu1)) {
                    qu1Var = (qu1) obj;
                } else {
                    qu1Var = new qu1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", qu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(qu1Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.openTabBar")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 D = qu1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                nu1 nu1Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof nu1)) {
                    nu1Var = (nu1) obj;
                } else {
                    nu1Var = new nu1(this.mSwanApiContext);
                    this.mApis.put("-1750613704", nu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(nu1Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.pageScrollTo")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = nu1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                mu1 mu1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof mu1)) {
                    mu1Var = (mu1) obj;
                } else {
                    mu1Var = new mu1(this.mSwanApiContext);
                    this.mApis.put("-246386074", mu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(mu1Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarColor")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 A = mu1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                mu1 mu1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof mu1)) {
                    mu1Var = (mu1) obj;
                } else {
                    mu1Var = new mu1(this.mSwanApiContext);
                    this.mApis.put("-246386074", mu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(mu1Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarTitle")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = mu1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                qu1 qu1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof qu1)) {
                    qu1Var = (qu1) obj;
                } else {
                    qu1Var = new qu1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", qu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(qu1Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.setTabBarItem")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 E = qu1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                ou1 ou1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof ou1)) {
                    ou1Var = (ou1) obj;
                } else {
                    ou1Var = new ou1(this.mSwanApiContext);
                    this.mApis.put("-108978463", ou1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ou1Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.showDatePickerView")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 M = ou1Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                su1 su1Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof su1)) {
                    su1Var = (su1) obj;
                } else {
                    su1Var = new su1(this.mSwanApiContext);
                    this.mApis.put("1172469410", su1Var);
                }
                Pair<Boolean, px1> a = rx1.a(su1Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.showHalfScreenWebview")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 L = su1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                ku1 ku1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof ku1)) {
                    ku1Var = (ku1) obj;
                } else {
                    ku1Var = new ku1(this.mSwanApiContext);
                    this.mApis.put("5236036", ku1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ku1Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.showLoading")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = ku1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                lu1 lu1Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof lu1)) {
                    lu1Var = (lu1) obj;
                } else {
                    lu1Var = new lu1(this.mSwanApiContext);
                    this.mApis.put("1913747800", lu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(lu1Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.showModal")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = lu1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                mu1 mu1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof mu1)) {
                    mu1Var = (mu1) obj;
                } else {
                    mu1Var = new mu1(this.mSwanApiContext);
                    this.mApis.put("-246386074", mu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(mu1Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.showNavigationBarLoading")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 C = mu1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                ru1 ru1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof ru1)) {
                    ru1Var = (ru1) obj;
                } else {
                    ru1Var = new ru1(this.mSwanApiContext);
                    this.mApis.put("1159492510", ru1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ru1Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.showToast")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 R = ru1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                pu1 pu1Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof pu1)) {
                    pu1Var = (pu1) obj;
                } else {
                    pu1Var = new pu1(this.mSwanApiContext);
                    this.mApis.put("1165118609", pu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(pu1Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.stopPullDownRefresh")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = pu1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                ou1 ou1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof ou1)) {
                    ou1Var = (ou1) obj;
                } else {
                    ou1Var = new ou1(this.mSwanApiContext);
                    this.mApis.put("-108978463", ou1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ou1Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.updateMultiPicker")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 N = ou1Var.N(str);
                if (N == null) {
                    return "";
                }
                return N.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                ku1 ku1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof ku1)) {
                    ku1Var = (ku1) obj;
                } else {
                    ku1Var = new ku1(this.mSwanApiContext);
                    this.mApis.put("5236036", ku1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ku1Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.hideLoading")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = ku1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideToast() {
                ru1 ru1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof ru1)) {
                    ru1Var = (ru1) obj;
                } else {
                    ru1Var = new ru1(this.mSwanApiContext);
                    this.mApis.put("1159492510", ru1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ru1Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Interaction.hideToast")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 L = ru1Var.L();
                if (L == null) {
                    return "";
                }
                return L.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                tu1 tu1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof tu1)) {
                    tu1Var = (tu1) obj;
                } else {
                    tu1Var = new tu1(this.mSwanApiContext);
                    this.mApis.put("-137346255", tu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(tu1Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Keyboard.startKeyboardHeightChange")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 D = tu1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                tu1 tu1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof tu1)) {
                    tu1Var = (tu1) obj;
                } else {
                    tu1Var = new tu1(this.mSwanApiContext);
                    this.mApis.put("-137346255", tu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(tu1Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Keyboard.stopKeyboardHeightChange")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 E = tu1Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }
        });
        hashMap.put("_naLocationService", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                uu1 uu1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof uu1)) {
                    uu1Var = (uu1) obj;
                } else {
                    uu1Var = new uu1(this.mSwanApiContext);
                    this.mApis.put("-397373095", uu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(uu1Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "LocationService.getLocation")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = uu1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                uu1 uu1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof uu1)) {
                    uu1Var = (uu1) obj;
                } else {
                    uu1Var = new uu1(this.mSwanApiContext);
                    this.mApis.put("-397373095", uu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(uu1Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "LocationService.startLocationUpdate")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = uu1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                uu1 uu1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof uu1)) {
                    uu1Var = (uu1) obj;
                } else {
                    uu1Var = new uu1(this.mSwanApiContext);
                    this.mApis.put("-397373095", uu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(uu1Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "LocationService.stopLocationUpdate")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 C = uu1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naMenu", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                lw1 lw1Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof lw1)) {
                    lw1Var = (lw1) obj;
                } else {
                    lw1Var = new lw1(this.mSwanApiContext);
                    this.mApis.put("538070032", lw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(lw1Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = lw1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naNetwork", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                xu1 xu1Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof xu1)) {
                    xu1Var = (xu1) obj;
                } else {
                    xu1Var = new xu1(this.mSwanApiContext);
                    this.mApis.put("-1076509454", xu1Var);
                }
                Pair<Boolean, px1> a = rx1.a(xu1Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Network.callService")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = xu1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                ev1 ev1Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof ev1)) {
                    ev1Var = (ev1) obj;
                } else {
                    ev1Var = new ev1(this.mSwanApiContext);
                    this.mApis.put("968563034", ev1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ev1Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Network.cancelRequest")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 E = ev1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                dv1 dv1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof dv1)) {
                    dv1Var = (dv1) obj;
                } else {
                    dv1Var = new dv1(this.mSwanApiContext);
                    this.mApis.put("453220699", dv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(dv1Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Network.networkStatusChange")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = dv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                dv1 dv1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof dv1)) {
                    dv1Var = (dv1) obj;
                } else {
                    dv1Var = new dv1(this.mSwanApiContext);
                    this.mApis.put("453220699", dv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(dv1Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Network.getNetworkType")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = dv1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(String str) {
                ev1 ev1Var;
                String a;
                try {
                    ox1.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof ev1)) {
                        ev1Var = (ev1) obj;
                    } else {
                        ev1Var = new ev1(this.mSwanApiContext);
                        this.mApis.put("968563034", ev1Var);
                    }
                    Pair<Boolean, px1> a2 = rx1.a(ev1Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((px1) a2.second).a();
                    } else if (w72.a(this.mSwanApiContext.e(), "Network.request")) {
                        a = new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<px1, JSONObject> v = tt1.v(str);
                        if (!((px1) v.first).isSuccess()) {
                            a = ((px1) v.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) v.second;
                            if (jSONObject == null) {
                                a = px1.a.a();
                            } else {
                                qx1 W = ev1Var.W(jSONObject);
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
                        ox1.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                my2 my2Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof my2)) {
                    my2Var = (my2) obj;
                } else {
                    my2Var = new my2(this.mSwanApiContext);
                    this.mApis.put("-336396851", my2Var);
                }
                Pair<Boolean, px1> a = rx1.a(my2Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Payment.chooseCoupon")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = my2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                my2 my2Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof my2)) {
                    my2Var = (my2) obj;
                } else {
                    my2Var = new my2(this.mSwanApiContext);
                    this.mApis.put("-336396851", my2Var);
                }
                Pair<Boolean, px1> a = rx1.a(my2Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Payment.getPaymentInfo")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = my2Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                cy2 cy2Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof cy2)) {
                    cy2Var = (cy2) obj;
                } else {
                    cy2Var = new cy2(this.mSwanApiContext);
                    this.mApis.put("1854689529", cy2Var);
                }
                Pair<Boolean, px1> a = rx1.a(cy2Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Payment.requestThirdPayment")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = cy2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                my2 my2Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof my2)) {
                    my2Var = (my2) obj;
                } else {
                    my2Var = new my2(this.mSwanApiContext);
                    this.mApis.put("-336396851", my2Var);
                }
                Pair<Boolean, px1> a = rx1.a(my2Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Payment.setPaymentInfo")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 A = my2Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPlugin", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                x03 x03Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof x03)) {
                    x03Var = (x03) obj;
                } else {
                    x03Var = new x03(this.mSwanApiContext);
                    this.mApis.put("-254510461", x03Var);
                }
                Pair<Boolean, px1> a = rx1.a(x03Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Plugin.invokePluginChooseAddress")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = x03Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                x03 x03Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof x03)) {
                    x03Var = (x03) obj;
                } else {
                    x03Var = new x03(this.mSwanApiContext);
                    this.mApis.put("-254510461", x03Var);
                }
                Pair<Boolean, px1> a = rx1.a(x03Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 A = x03Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                x03 x03Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof x03)) {
                    x03Var = (x03) obj;
                } else {
                    x03Var = new x03(this.mSwanApiContext);
                    this.mApis.put("-254510461", x03Var);
                }
                Pair<Boolean, px1> a = rx1.a(x03Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Plugin.invokePluginPayment")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = x03Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                q92 q92Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof q92)) {
                    q92Var = (q92) obj;
                } else {
                    q92Var = new q92(this.mSwanApiContext);
                    this.mApis.put("-2068479848", q92Var);
                }
                Pair<Boolean, px1> a = rx1.a(q92Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Prefetch.prefetchResources")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = q92Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPreload", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                i82 i82Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof i82)) {
                    i82Var = (i82) obj;
                } else {
                    i82Var = new i82(this.mSwanApiContext);
                    this.mApis.put("423661539", i82Var);
                }
                Pair<Boolean, px1> a = rx1.a(i82Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Preload.preloadStatus")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = i82Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                sh3 sh3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof sh3)) {
                    sh3Var = (sh3) obj;
                } else {
                    sh3Var = new sh3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", sh3Var);
                }
                Pair<Boolean, px1> a = rx1.a(sh3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "PrivateFile.uploadFileToBos")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 D = sh3Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naRouter", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                iv1 iv1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof iv1)) {
                    iv1Var = (iv1) obj;
                } else {
                    iv1Var = new iv1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", iv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(iv1Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Router.hideModalPage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = iv1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                iv1 iv1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof iv1)) {
                    iv1Var = (iv1) obj;
                } else {
                    iv1Var = new iv1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", iv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(iv1Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Router.navigateBack")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 C = iv1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                jv1 jv1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof jv1)) {
                    jv1Var = (jv1) obj;
                } else {
                    jv1Var = new jv1(this.mSwanApiContext);
                    this.mApis.put("1968522584", jv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(jv1Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Router.navigateTo")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 I = jv1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                lv1 lv1Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof lv1)) {
                    lv1Var = (lv1) obj;
                } else {
                    lv1Var = new lv1(this.mSwanApiContext);
                    this.mApis.put("1317280190", lv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(lv1Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Router.reLaunch")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = lv1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                mv1 mv1Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof mv1)) {
                    mv1Var = (mv1) obj;
                } else {
                    mv1Var = new mv1(this.mSwanApiContext);
                    this.mApis.put("-420075743", mv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(mv1Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Router.reLoadErrorPage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = mv1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                kv1 kv1Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof kv1)) {
                    kv1Var = (kv1) obj;
                } else {
                    kv1Var = new kv1(this.mSwanApiContext);
                    this.mApis.put("1792515533", kv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(kv1Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Router.redirectTo")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 E = kv1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                jv1 jv1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof jv1)) {
                    jv1Var = (jv1) obj;
                } else {
                    jv1Var = new jv1(this.mSwanApiContext);
                    this.mApis.put("1968522584", jv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(jv1Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Router.showModalPage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 K = jv1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naSetting", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                pv1 pv1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof pv1)) {
                    pv1Var = (pv1) obj;
                } else {
                    pv1Var = new pv1(this.mSwanApiContext);
                    this.mApis.put("-594895721", pv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(pv1Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Setting.getAppInfoSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 G = pv1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                pv1 pv1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof pv1)) {
                    pv1Var = (pv1) obj;
                } else {
                    pv1Var = new pv1(this.mSwanApiContext);
                    this.mApis.put("-594895721", pv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(pv1Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Setting.getSlaveIdSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 I = pv1Var.I();
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                ov1 ov1Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof ov1)) {
                    ov1Var = (ov1) obj;
                } else {
                    ov1Var = new ov1(this.mSwanApiContext);
                    this.mApis.put("450273045", ov1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ov1Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Setting.isAllowedAdOpenAppSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = ov1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                pv1 pv1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof pv1)) {
                    pv1Var = (pv1) obj;
                } else {
                    pv1Var = new pv1(this.mSwanApiContext);
                    this.mApis.put("-594895721", pv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(pv1Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Setting.getSetting")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 H = pv1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                pv1 pv1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof pv1)) {
                    pv1Var = (pv1) obj;
                } else {
                    pv1Var = new pv1(this.mSwanApiContext);
                    this.mApis.put("-594895721", pv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(pv1Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Setting.getSwanId")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 J = pv1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                pv1 pv1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof pv1)) {
                    pv1Var = (pv1) obj;
                } else {
                    pv1Var = new pv1(this.mSwanApiContext);
                    this.mApis.put("-594895721", pv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(pv1Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Setting.getUserInfo")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 K = pv1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                mc3 mc3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof mc3)) {
                    mc3Var = (mc3) obj;
                } else {
                    mc3Var = new mc3(this.mSwanApiContext);
                    this.mApis.put("712777136", mc3Var);
                }
                Pair<Boolean, px1> a = rx1.a(mc3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = mc3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naStorage", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                sv1 sv1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof sv1)) {
                    sv1Var = (sv1) obj;
                } else {
                    sv1Var = new sv1(this.mSwanApiContext);
                    this.mApis.put("-804054859", sv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(sv1Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = sv1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                sv1 sv1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof sv1)) {
                    sv1Var = (sv1) obj;
                } else {
                    sv1Var = new sv1(this.mSwanApiContext);
                    this.mApis.put("-804054859", sv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(sv1Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorageSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 D = sv1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                rv1 rv1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof rv1)) {
                    rv1Var = (rv1) obj;
                } else {
                    rv1Var = new rv1(this.mSwanApiContext);
                    this.mApis.put("130910081", rv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(rv1Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.clearStorage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = rv1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                rv1 rv1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof rv1)) {
                    rv1Var = (rv1) obj;
                } else {
                    rv1Var = new rv1(this.mSwanApiContext);
                    this.mApis.put("130910081", rv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(rv1Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.clearStorageSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 D = rv1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                sv1 sv1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof sv1)) {
                    sv1Var = (sv1) obj;
                } else {
                    sv1Var = new sv1(this.mSwanApiContext);
                    this.mApis.put("-804054859", sv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(sv1Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfo")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 H = sv1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                sv1 sv1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof sv1)) {
                    sv1Var = (sv1) obj;
                } else {
                    sv1Var = new sv1(this.mSwanApiContext);
                    this.mApis.put("-804054859", sv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(sv1Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfoSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 K = sv1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                rv1 rv1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof rv1)) {
                    rv1Var = (rv1) obj;
                } else {
                    rv1Var = new rv1(this.mSwanApiContext);
                    this.mApis.put("130910081", rv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(rv1Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.getStorageInfo")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 H = rv1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                rv1 rv1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof rv1)) {
                    rv1Var = (rv1) obj;
                } else {
                    rv1Var = new rv1(this.mSwanApiContext);
                    this.mApis.put("130910081", rv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(rv1Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.getStorageInfoSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 K = rv1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                sv1 sv1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof sv1)) {
                    sv1Var = (sv1) obj;
                } else {
                    sv1Var = new sv1(this.mSwanApiContext);
                    this.mApis.put("-804054859", sv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(sv1Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.getGlobalStorage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 E = sv1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                sv1 sv1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof sv1)) {
                    sv1Var = (sv1) obj;
                } else {
                    sv1Var = new sv1(this.mSwanApiContext);
                    this.mApis.put("-804054859", sv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(sv1Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 L = sv1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                rv1 rv1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof rv1)) {
                    rv1Var = (rv1) obj;
                } else {
                    rv1Var = new rv1(this.mSwanApiContext);
                    this.mApis.put("130910081", rv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(rv1Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.getStorage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 E = rv1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                rv1 rv1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof rv1)) {
                    rv1Var = (rv1) obj;
                } else {
                    rv1Var = new rv1(this.mSwanApiContext);
                    this.mApis.put("130910081", rv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(rv1Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.getStorageInfoAsync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 I = rv1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                rv1 rv1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof rv1)) {
                    rv1Var = (rv1) obj;
                } else {
                    rv1Var = new rv1(this.mSwanApiContext);
                    this.mApis.put("130910081", rv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(rv1Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.getStorageSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 L = rv1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                sv1 sv1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof sv1)) {
                    sv1Var = (sv1) obj;
                } else {
                    sv1Var = new sv1(this.mSwanApiContext);
                    this.mApis.put("-804054859", sv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(sv1Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 S = sv1Var.S(str);
                if (S == null) {
                    return "";
                }
                return S.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                sv1 sv1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof sv1)) {
                    sv1Var = (sv1) obj;
                } else {
                    sv1Var = new sv1(this.mSwanApiContext);
                    this.mApis.put("-804054859", sv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(sv1Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorageSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 U = sv1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                rv1 rv1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof rv1)) {
                    rv1Var = (rv1) obj;
                } else {
                    rv1Var = new rv1(this.mSwanApiContext);
                    this.mApis.put("130910081", rv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(rv1Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.removeStorage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 S = rv1Var.S(str);
                if (S == null) {
                    return "";
                }
                return S.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                rv1 rv1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof rv1)) {
                    rv1Var = (rv1) obj;
                } else {
                    rv1Var = new rv1(this.mSwanApiContext);
                    this.mApis.put("130910081", rv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(rv1Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.removeStorageSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 U = rv1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                sv1 sv1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof sv1)) {
                    sv1Var = (sv1) obj;
                } else {
                    sv1Var = new sv1(this.mSwanApiContext);
                    this.mApis.put("-804054859", sv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(sv1Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.setGlobalStorage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 V = sv1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                sv1 sv1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof sv1)) {
                    sv1Var = (sv1) obj;
                } else {
                    sv1Var = new sv1(this.mSwanApiContext);
                    this.mApis.put("-804054859", sv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(sv1Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.setGlobalStorageSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 X = sv1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                rv1 rv1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof rv1)) {
                    rv1Var = (rv1) obj;
                } else {
                    rv1Var = new rv1(this.mSwanApiContext);
                    this.mApis.put("130910081", rv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(rv1Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.setStorage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 V = rv1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                rv1 rv1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof rv1)) {
                    rv1Var = (rv1) obj;
                } else {
                    rv1Var = new rv1(this.mSwanApiContext);
                    this.mApis.put("130910081", rv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(rv1Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Storage.setStorageSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 X = rv1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naSubscription", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                uv1 uv1Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof uv1)) {
                    uv1Var = (uv1) obj;
                } else {
                    uv1Var = new uv1(this.mSwanApiContext);
                    this.mApis.put("823117982", uv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(uv1Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Subscription.requestSubscribeFormId")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 F = uv1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                vv1 vv1Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof vv1)) {
                    vv1Var = (vv1) obj;
                } else {
                    vv1Var = new vv1(this.mSwanApiContext);
                    this.mApis.put("-947445811", vv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(vv1Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Subscription.subscribeService")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 G = vv1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naSystem", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                cw1 cw1Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof cw1)) {
                    cw1Var = (cw1) obj;
                } else {
                    cw1Var = new cw1(this.mSwanApiContext);
                    this.mApis.put("1936205521", cw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(cw1Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.exitFullScreen")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = cw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                bw1 bw1Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof bw1)) {
                    bw1Var = (bw1) obj;
                } else {
                    bw1Var = new bw1(this.mSwanApiContext);
                    this.mApis.put("1694151270", bw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(bw1Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.getDeviceInfo")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = bw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                dw1 dw1Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof dw1)) {
                    dw1Var = (dw1) obj;
                } else {
                    dw1Var = new dw1(this.mSwanApiContext);
                    this.mApis.put("-1321681619", dw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(dw1Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.getDeviceProfile")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = dw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                ew1 ew1Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof ew1)) {
                    ew1Var = (ew1) obj;
                } else {
                    ew1Var = new ew1(this.mSwanApiContext);
                    this.mApis.put("-1569246082", ew1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ew1Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.makePhoneCall")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = ew1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                gw1 gw1Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof gw1)) {
                    gw1Var = (gw1) obj;
                } else {
                    gw1Var = new gw1(this.mSwanApiContext);
                    this.mApis.put("1099851202", gw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(gw1Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.openSMSPanel")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = gw1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                fw1 fw1Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof fw1)) {
                    fw1Var = (fw1) obj;
                } else {
                    fw1Var = new fw1(this.mSwanApiContext);
                    this.mApis.put("-1707203360", fw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(fw1Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.requestFullScreen")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 G = fw1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                zv1 zv1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof zv1)) {
                    zv1Var = (zv1) obj;
                } else {
                    zv1Var = new zv1(this.mSwanApiContext);
                    this.mApis.put("-518757484", zv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(zv1Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.setClipboardData")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = zv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                iv2 iv2Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof iv2)) {
                    iv2Var = (iv2) obj;
                } else {
                    iv2Var = new iv2(this.mSwanApiContext);
                    this.mApis.put("1161486049", iv2Var);
                }
                Pair<Boolean, px1> a = rx1.a(iv2Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.setErrorPageType")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = iv2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("447234992", jw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(jw1Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.setMediaVolume")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 A = jw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                xv1 xv1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof xv1)) {
                    xv1Var = (xv1) obj;
                } else {
                    xv1Var = new xv1(this.mSwanApiContext);
                    this.mApis.put("1372680763", xv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(xv1Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.startAccelerometer")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = xv1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                aw1 aw1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof aw1)) {
                    aw1Var = (aw1) obj;
                } else {
                    aw1Var = new aw1(this.mSwanApiContext);
                    this.mApis.put("1689255576", aw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(aw1Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.startCompass")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = aw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                yv1 yv1Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof yv1)) {
                    yv1Var = (yv1) obj;
                } else {
                    yv1Var = new yv1(this.mSwanApiContext);
                    this.mApis.put("99997465", yv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(yv1Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.getBrightness")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = yv1Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                zv1 zv1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof zv1)) {
                    zv1Var = (zv1) obj;
                } else {
                    zv1Var = new zv1(this.mSwanApiContext);
                    this.mApis.put("-518757484", zv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(zv1Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.getClipboardData")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = zv1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                jw1 jw1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("447234992", jw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(jw1Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.getMediaVolume")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = jw1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                xv1 xv1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof xv1)) {
                    xv1Var = (xv1) obj;
                } else {
                    xv1Var = new xv1(this.mSwanApiContext);
                    this.mApis.put("1372680763", xv1Var);
                }
                Pair<Boolean, px1> a = rx1.a(xv1Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.stopAccelerometer")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 C = xv1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                aw1 aw1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof aw1)) {
                    aw1Var = (aw1) obj;
                } else {
                    aw1Var = new aw1(this.mSwanApiContext);
                    this.mApis.put("1689255576", aw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(aw1Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "System.stopCompass")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 A = aw1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naUtils", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                uw1 uw1Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof uw1)) {
                    uw1Var = (uw1) obj;
                } else {
                    uw1Var = new uw1(this.mSwanApiContext);
                    this.mApis.put("201194468", uw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(uw1Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.addToDesktop")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 C = uw1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                qw1 qw1Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof qw1)) {
                    qw1Var = (qw1) obj;
                } else {
                    qw1Var = new qw1(this.mSwanApiContext);
                    this.mApis.put("-1412306947", qw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(qw1Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.calcMD5")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = qw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                rw1 rw1Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("1626415364", rw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(rw1Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.checkAppInstalled")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = rw1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("-836768778", tw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(tw1Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfo")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = tw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                vw1 vw1Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("-810858308", vw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(vw1Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.getPerformanceLevel")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = vw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                zw1 zw1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof zw1)) {
                    zw1Var = (zw1) obj;
                } else {
                    zw1Var = new zw1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", zw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(zw1Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.getSystemInfoAsync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 J = zw1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                ww1 ww1Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof ww1)) {
                    ww1Var = (ww1) obj;
                } else {
                    ww1Var = new ww1(this.mSwanApiContext);
                    this.mApis.put("-2097727681", ww1Var);
                }
                Pair<Boolean, px1> a = rx1.a(ww1Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.handleException")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = ww1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                sw1 sw1Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof sw1)) {
                    sw1Var = (sw1) obj;
                } else {
                    sw1Var = new sw1(this.mSwanApiContext);
                    this.mApis.put("2084449317", sw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(sw1Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.hasCloseHandler")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = sw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                u93 u93Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof u93)) {
                    u93Var = (u93) obj;
                } else {
                    u93Var = new u93(this.mSwanApiContext);
                    this.mApis.put("1031678042", u93Var);
                }
                Pair<Boolean, px1> a = rx1.a(u93Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.hideCaptureScreenShareDialog")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 y = u93Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                xw1 xw1Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof xw1)) {
                    xw1Var = (xw1) obj;
                } else {
                    xw1Var = new xw1(this.mSwanApiContext);
                    this.mApis.put("1751900130", xw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(xw1Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.logToFile")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = xw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                v83 v83Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof v83)) {
                    v83Var = (v83) obj;
                } else {
                    v83Var = new v83(this.mSwanApiContext);
                    this.mApis.put("1748196865", v83Var);
                }
                Pair<Boolean, px1> a = rx1.a(v83Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.preloadPackage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = v83Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                yw1 yw1Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof yw1)) {
                    yw1Var = (yw1) obj;
                } else {
                    yw1Var = new yw1(this.mSwanApiContext);
                    this.mApis.put("589529211", yw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(yw1Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.previewImage")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 C = yw1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                bx1 bx1Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof bx1)) {
                    bx1Var = (bx1) obj;
                } else {
                    bx1Var = new bx1(this.mSwanApiContext);
                    this.mApis.put("-577481801", bx1Var);
                }
                Pair<Boolean, px1> a = rx1.a(bx1Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.ubcFlowJar")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 J = bx1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                zw1 zw1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof zw1)) {
                    zw1Var = (zw1) obj;
                } else {
                    zw1Var = new zw1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", zw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(zw1Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfoSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 F = zw1Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                zw1 zw1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof zw1)) {
                    zw1Var = (zw1) obj;
                } else {
                    zw1Var = new zw1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", zw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(zw1Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.getSystemInfo")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 I = zw1Var.I();
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                zw1 zw1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof zw1)) {
                    zw1Var = (zw1) obj;
                } else {
                    zw1Var = new zw1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", zw1Var);
                }
                Pair<Boolean, px1> a = rx1.a(zw1Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Utils.getSystemInfoSync")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 K = zw1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naWifi", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                fg3 fg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof fg3)) {
                    fg3Var = (fg3) obj;
                } else {
                    fg3Var = new fg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", fg3Var);
                }
                Pair<Boolean, px1> a = rx1.a(fg3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Wifi.connectWifi")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 B = fg3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                fg3 fg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof fg3)) {
                    fg3Var = (fg3) obj;
                } else {
                    fg3Var = new fg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", fg3Var);
                }
                Pair<Boolean, px1> a = rx1.a(fg3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Wifi.getConnectedWifi")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 C = fg3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                fg3 fg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof fg3)) {
                    fg3Var = (fg3) obj;
                } else {
                    fg3Var = new fg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", fg3Var);
                }
                Pair<Boolean, px1> a = rx1.a(fg3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Wifi.getWifiList")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 D = fg3Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                fg3 fg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof fg3)) {
                    fg3Var = (fg3) obj;
                } else {
                    fg3Var = new fg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", fg3Var);
                }
                Pair<Boolean, px1> a = rx1.a(fg3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Wifi.startWifi")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 H = fg3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                fg3 fg3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof fg3)) {
                    fg3Var = (fg3) obj;
                } else {
                    fg3Var = new fg3(this.mSwanApiContext);
                    this.mApis.put("1879401452", fg3Var);
                }
                Pair<Boolean, px1> a = rx1.a(fg3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "Wifi.stopWifi")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 I = fg3Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }
        });
        return hashMap;
    }
}
