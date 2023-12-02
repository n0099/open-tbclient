package com.baidu.swan.apps.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.tieba.ah3;
import com.baidu.tieba.av1;
import com.baidu.tieba.ax1;
import com.baidu.tieba.bu1;
import com.baidu.tieba.bw2;
import com.baidu.tieba.bx1;
import com.baidu.tieba.cn1;
import com.baidu.tieba.d92;
import com.baidu.tieba.dv1;
import com.baidu.tieba.dw1;
import com.baidu.tieba.dw2;
import com.baidu.tieba.ew1;
import com.baidu.tieba.ex1;
import com.baidu.tieba.fv1;
import com.baidu.tieba.fw1;
import com.baidu.tieba.gv1;
import com.baidu.tieba.gw1;
import com.baidu.tieba.gx1;
import com.baidu.tieba.hd3;
import com.baidu.tieba.hv1;
import com.baidu.tieba.hw1;
import com.baidu.tieba.hz2;
import com.baidu.tieba.iv1;
import com.baidu.tieba.jv1;
import com.baidu.tieba.jw1;
import com.baidu.tieba.jy1;
import com.baidu.tieba.kv1;
import com.baidu.tieba.kw1;
import com.baidu.tieba.ky1;
import com.baidu.tieba.la2;
import com.baidu.tieba.lv1;
import com.baidu.tieba.lx1;
import com.baidu.tieba.ly1;
import com.baidu.tieba.mu1;
import com.baidu.tieba.mv1;
import com.baidu.tieba.mw1;
import com.baidu.tieba.mx1;
import com.baidu.tieba.my1;
import com.baidu.tieba.ni3;
import com.baidu.tieba.nj2;
import com.baidu.tieba.nv1;
import com.baidu.tieba.nw1;
import com.baidu.tieba.nx1;
import com.baidu.tieba.ou1;
import com.baidu.tieba.ov1;
import com.baidu.tieba.ox1;
import com.baidu.tieba.pa3;
import com.baidu.tieba.pu1;
import com.baidu.tieba.pv1;
import com.baidu.tieba.pw1;
import com.baidu.tieba.px1;
import com.baidu.tieba.q93;
import com.baidu.tieba.qw1;
import com.baidu.tieba.qx1;
import com.baidu.tieba.r82;
import com.baidu.tieba.ru1;
import com.baidu.tieba.rx1;
import com.baidu.tieba.s13;
import com.baidu.tieba.su1;
import com.baidu.tieba.sv1;
import com.baidu.tieba.sw1;
import com.baidu.tieba.sx1;
import com.baidu.tieba.tu1;
import com.baidu.tieba.tw1;
import com.baidu.tieba.tx1;
import com.baidu.tieba.uu1;
import com.baidu.tieba.uw1;
import com.baidu.tieba.ux1;
import com.baidu.tieba.vu1;
import com.baidu.tieba.vw1;
import com.baidu.tieba.ww1;
import com.baidu.tieba.wx1;
import com.baidu.tieba.xu1;
import com.baidu.tieba.xw1;
import com.baidu.tieba.xy2;
import com.baidu.tieba.yv1;
import com.baidu.tieba.yw1;
import com.baidu.tieba.zu1;
import com.baidu.tieba.zv1;
import com.baidu.tieba.zw1;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
@Keep
/* loaded from: classes4.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final mu1 mu1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                su1 su1Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof su1)) {
                    su1Var = (su1) obj;
                } else {
                    su1Var = new su1(this.mSwanApiContext);
                    this.mApis.put("1930258908", su1Var);
                }
                Pair<Boolean, ky1> a = my1.a(su1Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Account.checkSession")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = su1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                tu1 tu1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof tu1)) {
                    tu1Var = (tu1) obj;
                } else {
                    tu1Var = new tu1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", tu1Var);
                }
                Pair<Boolean, ky1> a = my1.a(tu1Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Account.getLoginCode")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 D = tu1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                uu1 uu1Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof uu1)) {
                    uu1Var = (uu1) obj;
                } else {
                    uu1Var = new uu1(this.mSwanApiContext);
                    this.mApis.put("1754780133", uu1Var);
                }
                Pair<Boolean, ky1> a = my1.a(uu1Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Account.getOpenId")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = uu1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                bu1 bu1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof bu1)) {
                    bu1Var = (bu1) obj;
                } else {
                    bu1Var = new bu1(this.mSwanApiContext);
                    this.mApis.put("-343998465", bu1Var);
                }
                Pair<Boolean, ky1> a = my1.a(bu1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Account.getUnionBDUSS")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = bu1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String login(String str) {
                tu1 tu1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof tu1)) {
                    tu1Var = (tu1) obj;
                } else {
                    tu1Var = new tu1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", tu1Var);
                }
                Pair<Boolean, ky1> a = my1.a(tu1Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Account.login")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 J = tu1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                ru1 ru1Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof ru1)) {
                    ru1Var = (ru1) obj;
                } else {
                    ru1Var = new ru1(this.mSwanApiContext);
                    this.mApis.put("-337742792", ru1Var);
                }
                Pair<Boolean, ky1> a = my1.a(ru1Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Account.isBaiduAccountSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = ru1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                tu1 tu1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof tu1)) {
                    tu1Var = (tu1) obj;
                } else {
                    tu1Var = new tu1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", tu1Var);
                }
                Pair<Boolean, ky1> a = my1.a(tu1Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Account.isLoginSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 I = tu1Var.I();
                if (I == null) {
                    return "";
                }
                return I.a();
            }
        });
        hashMap.put("_naBasic", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                vu1 vu1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof vu1)) {
                    vu1Var = (vu1) obj;
                } else {
                    vu1Var = new vu1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", vu1Var);
                }
                Pair<Boolean, ky1> a = my1.a(vu1Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Basic.loadSubPackage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 G = vu1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                vu1 vu1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof vu1)) {
                    vu1Var = (vu1) obj;
                } else {
                    vu1Var = new vu1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", vu1Var);
                }
                Pair<Boolean, ky1> a = my1.a(vu1Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Basic.loadSubPackages")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 H = vu1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                cn1 cn1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof cn1)) {
                    cn1Var = (cn1) obj;
                } else {
                    cn1Var = new cn1(this.mSwanApiContext);
                    this.mApis.put("1460300387", cn1Var);
                }
                Pair<Boolean, ky1> a = my1.a(cn1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Bookshelf.deleteBookshelf")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 L = cn1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                cn1 cn1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof cn1)) {
                    cn1Var = (cn1) obj;
                } else {
                    cn1Var = new cn1(this.mSwanApiContext);
                    this.mApis.put("1460300387", cn1Var);
                }
                Pair<Boolean, ky1> a = my1.a(cn1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Bookshelf.insertBookshelf")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 Q = cn1Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                cn1 cn1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof cn1)) {
                    cn1Var = (cn1) obj;
                } else {
                    cn1Var = new cn1(this.mSwanApiContext);
                    this.mApis.put("1460300387", cn1Var);
                }
                Pair<Boolean, ky1> a = my1.a(cn1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Bookshelf.navigateToBookshelf")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 V = cn1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                cn1 cn1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof cn1)) {
                    cn1Var = (cn1) obj;
                } else {
                    cn1Var = new cn1(this.mSwanApiContext);
                    this.mApis.put("1460300387", cn1Var);
                }
                Pair<Boolean, ky1> a = my1.a(cn1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Bookshelf.queryBookshelf")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 W = cn1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                cn1 cn1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof cn1)) {
                    cn1Var = (cn1) obj;
                } else {
                    cn1Var = new cn1(this.mSwanApiContext);
                    this.mApis.put("1460300387", cn1Var);
                }
                Pair<Boolean, ky1> a = my1.a(cn1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Bookshelf.updateBookshelfReadTime")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 Y = cn1Var.Y(str);
                if (Y == null) {
                    return "";
                }
                return Y.a();
            }
        });
        hashMap.put("_naCoupon", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                pu1 pu1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof pu1)) {
                    pu1Var = (pu1) obj;
                } else {
                    pu1Var = new pu1(this.mSwanApiContext);
                    this.mApis.put("-277316359", pu1Var);
                }
                Pair<Boolean, ky1> a = my1.a(pu1Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Coupon.getPlatformCoupons")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = pu1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                pu1 pu1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof pu1)) {
                    pu1Var = (pu1) obj;
                } else {
                    pu1Var = new pu1(this.mSwanApiContext);
                    this.mApis.put("-277316359", pu1Var);
                }
                Pair<Boolean, ky1> a = my1.a(pu1Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Coupon.getUserCoupons")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 A = pu1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                pu1 pu1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof pu1)) {
                    pu1Var = (pu1) obj;
                } else {
                    pu1Var = new pu1(this.mSwanApiContext);
                    this.mApis.put("-277316359", pu1Var);
                }
                Pair<Boolean, ky1> a = my1.a(pu1Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Coupon.takeCoupons")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 D = pu1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naFavorite", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                xu1 xu1Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof xu1)) {
                    xu1Var = (xu1) obj;
                } else {
                    xu1Var = new xu1(this.mSwanApiContext);
                    this.mApis.put("-1225406515", xu1Var);
                }
                Pair<Boolean, ky1> a = my1.a(xu1Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Favorite.getFavorStatus")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = xu1Var.y(str);
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
                Pair<Boolean, ky1> a = my1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Favorite.showFavoriteGuide")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 H = showFavoriteGuideApi.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naFile", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                zu1 zu1Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof zu1)) {
                    zu1Var = (zu1) obj;
                } else {
                    zu1Var = new zu1(this.mSwanApiContext);
                    this.mApis.put("-2057135077", zu1Var);
                }
                Pair<Boolean, ky1> a = my1.a(zu1Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "File.shareFile")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = zu1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                nj2 nj2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof nj2)) {
                    nj2Var = (nj2) obj;
                } else {
                    nj2Var = new nj2(this.mSwanApiContext);
                    this.mApis.put("2077414795", nj2Var);
                }
                Pair<Boolean, ky1> a = my1.a(nj2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = nj2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                nj2 nj2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof nj2)) {
                    nj2Var = (nj2) obj;
                } else {
                    nj2Var = new nj2(this.mSwanApiContext);
                    this.mApis.put("2077414795", nj2Var);
                }
                Pair<Boolean, ky1> a = my1.a(nj2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessageSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = nj2Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String download(String str) {
                av1 av1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof av1)) {
                    av1Var = (av1) obj;
                } else {
                    av1Var = new av1(this.mSwanApiContext);
                    this.mApis.put("-170124576", av1Var);
                }
                Pair<Boolean, ky1> a = my1.a(av1Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "HostDownloadManager.download")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = av1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                av1 av1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof av1)) {
                    av1Var = (av1) obj;
                } else {
                    av1Var = new av1(this.mSwanApiContext);
                    this.mApis.put("-170124576", av1Var);
                }
                Pair<Boolean, ky1> a = my1.a(av1Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "HostDownloadManager.openFile")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 A = av1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String query(String str) {
                av1 av1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof av1)) {
                    av1Var = (av1) obj;
                } else {
                    av1Var = new av1(this.mSwanApiContext);
                    this.mApis.put("-170124576", av1Var);
                }
                Pair<Boolean, ky1> a = my1.a(av1Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "HostDownloadManager.query")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = av1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                av1 av1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof av1)) {
                    av1Var = (av1) obj;
                } else {
                    av1Var = new av1(this.mSwanApiContext);
                    this.mApis.put("-170124576", av1Var);
                }
                Pair<Boolean, ky1> a = my1.a(av1Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "HostDownloadManager.openDownloadCenter")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = av1Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naImage", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                bw2 bw2Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof bw2)) {
                    bw2Var = (bw2) obj;
                } else {
                    bw2Var = new bw2(this.mSwanApiContext);
                    this.mApis.put("1445003743", bw2Var);
                }
                Pair<Boolean, ky1> a = my1.a(bw2Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Image.callImageMenu")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = bw2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                dv1 dv1Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof dv1)) {
                    dv1Var = (dv1) obj;
                } else {
                    dv1Var = new dv1(this.mSwanApiContext);
                    this.mApis.put("-1252730367", dv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(dv1Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Image.compressImage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = dv1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naInteraction", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                lv1 lv1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof lv1)) {
                    lv1Var = (lv1) obj;
                } else {
                    lv1Var = new lv1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", lv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(lv1Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.closeTabBar")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = lv1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                lv1 lv1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof lv1)) {
                    lv1Var = (lv1) obj;
                } else {
                    lv1Var = new lv1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", lv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(lv1Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.closeTabBarRedDot")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = lv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                hv1 hv1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof hv1)) {
                    hv1Var = (hv1) obj;
                } else {
                    hv1Var = new hv1(this.mSwanApiContext);
                    this.mApis.put("-246386074", hv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(hv1Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.hideNavigationBarLoading")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = hv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                jv1 jv1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof jv1)) {
                    jv1Var = (jv1) obj;
                } else {
                    jv1Var = new jv1(this.mSwanApiContext);
                    this.mApis.put("-108978463", jv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(jv1Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.openMultiPicker")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 H = jv1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                jv1 jv1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof jv1)) {
                    jv1Var = (jv1) obj;
                } else {
                    jv1Var = new jv1(this.mSwanApiContext);
                    this.mApis.put("-108978463", jv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(jv1Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.openPicker")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 I = jv1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                lv1 lv1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof lv1)) {
                    lv1Var = (lv1) obj;
                } else {
                    lv1Var = new lv1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", lv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(lv1Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.openTabBar")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 D = lv1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                iv1 iv1Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof iv1)) {
                    iv1Var = (iv1) obj;
                } else {
                    iv1Var = new iv1(this.mSwanApiContext);
                    this.mApis.put("-1750613704", iv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(iv1Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.pageScrollTo")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = iv1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                hv1 hv1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof hv1)) {
                    hv1Var = (hv1) obj;
                } else {
                    hv1Var = new hv1(this.mSwanApiContext);
                    this.mApis.put("-246386074", hv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(hv1Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarColor")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 A = hv1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                hv1 hv1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof hv1)) {
                    hv1Var = (hv1) obj;
                } else {
                    hv1Var = new hv1(this.mSwanApiContext);
                    this.mApis.put("-246386074", hv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(hv1Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarTitle")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = hv1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                lv1 lv1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof lv1)) {
                    lv1Var = (lv1) obj;
                } else {
                    lv1Var = new lv1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", lv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(lv1Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.setTabBarItem")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 E = lv1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                jv1 jv1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof jv1)) {
                    jv1Var = (jv1) obj;
                } else {
                    jv1Var = new jv1(this.mSwanApiContext);
                    this.mApis.put("-108978463", jv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(jv1Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.showDatePickerView")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 M = jv1Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                nv1 nv1Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof nv1)) {
                    nv1Var = (nv1) obj;
                } else {
                    nv1Var = new nv1(this.mSwanApiContext);
                    this.mApis.put("1172469410", nv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(nv1Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.showHalfScreenWebview")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 L = nv1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                fv1 fv1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof fv1)) {
                    fv1Var = (fv1) obj;
                } else {
                    fv1Var = new fv1(this.mSwanApiContext);
                    this.mApis.put("5236036", fv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(fv1Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.showLoading")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = fv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                gv1 gv1Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof gv1)) {
                    gv1Var = (gv1) obj;
                } else {
                    gv1Var = new gv1(this.mSwanApiContext);
                    this.mApis.put("1913747800", gv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(gv1Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.showModal")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = gv1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                hv1 hv1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof hv1)) {
                    hv1Var = (hv1) obj;
                } else {
                    hv1Var = new hv1(this.mSwanApiContext);
                    this.mApis.put("-246386074", hv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(hv1Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.showNavigationBarLoading")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 C = hv1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                mv1 mv1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof mv1)) {
                    mv1Var = (mv1) obj;
                } else {
                    mv1Var = new mv1(this.mSwanApiContext);
                    this.mApis.put("1159492510", mv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(mv1Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.showToast")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 R = mv1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                kv1 kv1Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof kv1)) {
                    kv1Var = (kv1) obj;
                } else {
                    kv1Var = new kv1(this.mSwanApiContext);
                    this.mApis.put("1165118609", kv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(kv1Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.stopPullDownRefresh")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = kv1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                jv1 jv1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof jv1)) {
                    jv1Var = (jv1) obj;
                } else {
                    jv1Var = new jv1(this.mSwanApiContext);
                    this.mApis.put("-108978463", jv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(jv1Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.updateMultiPicker")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 N = jv1Var.N(str);
                if (N == null) {
                    return "";
                }
                return N.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                fv1 fv1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof fv1)) {
                    fv1Var = (fv1) obj;
                } else {
                    fv1Var = new fv1(this.mSwanApiContext);
                    this.mApis.put("5236036", fv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(fv1Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.hideLoading")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = fv1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideToast() {
                mv1 mv1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof mv1)) {
                    mv1Var = (mv1) obj;
                } else {
                    mv1Var = new mv1(this.mSwanApiContext);
                    this.mApis.put("1159492510", mv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(mv1Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.hideToast")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 L = mv1Var.L();
                if (L == null) {
                    return "";
                }
                return L.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                ov1 ov1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof ov1)) {
                    ov1Var = (ov1) obj;
                } else {
                    ov1Var = new ov1(this.mSwanApiContext);
                    this.mApis.put("-137346255", ov1Var);
                }
                Pair<Boolean, ky1> a = my1.a(ov1Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Keyboard.startKeyboardHeightChange")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 D = ov1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                ov1 ov1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof ov1)) {
                    ov1Var = (ov1) obj;
                } else {
                    ov1Var = new ov1(this.mSwanApiContext);
                    this.mApis.put("-137346255", ov1Var);
                }
                Pair<Boolean, ky1> a = my1.a(ov1Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Keyboard.stopKeyboardHeightChange")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 E = ov1Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }
        });
        hashMap.put("_naLocationService", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                pv1 pv1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof pv1)) {
                    pv1Var = (pv1) obj;
                } else {
                    pv1Var = new pv1(this.mSwanApiContext);
                    this.mApis.put("-397373095", pv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(pv1Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "LocationService.getLocation")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = pv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                pv1 pv1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof pv1)) {
                    pv1Var = (pv1) obj;
                } else {
                    pv1Var = new pv1(this.mSwanApiContext);
                    this.mApis.put("-397373095", pv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(pv1Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "LocationService.startLocationUpdate")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = pv1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                pv1 pv1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof pv1)) {
                    pv1Var = (pv1) obj;
                } else {
                    pv1Var = new pv1(this.mSwanApiContext);
                    this.mApis.put("-397373095", pv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(pv1Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "LocationService.stopLocationUpdate")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 C = pv1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naMenu", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                gx1 gx1Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof gx1)) {
                    gx1Var = (gx1) obj;
                } else {
                    gx1Var = new gx1(this.mSwanApiContext);
                    this.mApis.put("538070032", gx1Var);
                }
                Pair<Boolean, ky1> a = my1.a(gx1Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = gx1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naNetwork", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                sv1 sv1Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof sv1)) {
                    sv1Var = (sv1) obj;
                } else {
                    sv1Var = new sv1(this.mSwanApiContext);
                    this.mApis.put("-1076509454", sv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(sv1Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Network.callService")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = sv1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                zv1 zv1Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof zv1)) {
                    zv1Var = (zv1) obj;
                } else {
                    zv1Var = new zv1(this.mSwanApiContext);
                    this.mApis.put("968563034", zv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(zv1Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Network.cancelRequest")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 E = zv1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                yv1 yv1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof yv1)) {
                    yv1Var = (yv1) obj;
                } else {
                    yv1Var = new yv1(this.mSwanApiContext);
                    this.mApis.put("453220699", yv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(yv1Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Network.networkStatusChange")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = yv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                yv1 yv1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof yv1)) {
                    yv1Var = (yv1) obj;
                } else {
                    yv1Var = new yv1(this.mSwanApiContext);
                    this.mApis.put("453220699", yv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(yv1Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Network.getNetworkType")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = yv1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(JsObject jsObject) {
                zv1 zv1Var;
                String a;
                try {
                    jy1.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof zv1)) {
                        zv1Var = (zv1) obj;
                    } else {
                        zv1Var = new zv1(this.mSwanApiContext);
                        this.mApis.put("968563034", zv1Var);
                    }
                    Pair<Boolean, ky1> a2 = my1.a(zv1Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((ky1) a2.second).a();
                    } else if (r82.a(this.mSwanApiContext.e(), "Network.request")) {
                        a = new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<ky1, JSONObject> u = ou1.u(jsObject);
                        if (!((ky1) u.first).isSuccess()) {
                            a = ((ky1) u.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) u.second;
                            if (jSONObject == null) {
                                a = ky1.a.a();
                            } else {
                                ly1 W = zv1Var.W(jSONObject);
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
                        jy1.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                hz2 hz2Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof hz2)) {
                    hz2Var = (hz2) obj;
                } else {
                    hz2Var = new hz2(this.mSwanApiContext);
                    this.mApis.put("-336396851", hz2Var);
                }
                Pair<Boolean, ky1> a = my1.a(hz2Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Payment.chooseCoupon")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = hz2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                hz2 hz2Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof hz2)) {
                    hz2Var = (hz2) obj;
                } else {
                    hz2Var = new hz2(this.mSwanApiContext);
                    this.mApis.put("-336396851", hz2Var);
                }
                Pair<Boolean, ky1> a = my1.a(hz2Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Payment.getPaymentInfo")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = hz2Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                xy2 xy2Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof xy2)) {
                    xy2Var = (xy2) obj;
                } else {
                    xy2Var = new xy2(this.mSwanApiContext);
                    this.mApis.put("1854689529", xy2Var);
                }
                Pair<Boolean, ky1> a = my1.a(xy2Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Payment.requestThirdPayment")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = xy2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                hz2 hz2Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof hz2)) {
                    hz2Var = (hz2) obj;
                } else {
                    hz2Var = new hz2(this.mSwanApiContext);
                    this.mApis.put("-336396851", hz2Var);
                }
                Pair<Boolean, ky1> a = my1.a(hz2Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Payment.setPaymentInfo")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 A = hz2Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPlugin", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                s13 s13Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof s13)) {
                    s13Var = (s13) obj;
                } else {
                    s13Var = new s13(this.mSwanApiContext);
                    this.mApis.put("-254510461", s13Var);
                }
                Pair<Boolean, ky1> a = my1.a(s13Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Plugin.invokePluginChooseAddress")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = s13Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                s13 s13Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof s13)) {
                    s13Var = (s13) obj;
                } else {
                    s13Var = new s13(this.mSwanApiContext);
                    this.mApis.put("-254510461", s13Var);
                }
                Pair<Boolean, ky1> a = my1.a(s13Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 A = s13Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                s13 s13Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof s13)) {
                    s13Var = (s13) obj;
                } else {
                    s13Var = new s13(this.mSwanApiContext);
                    this.mApis.put("-254510461", s13Var);
                }
                Pair<Boolean, ky1> a = my1.a(s13Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Plugin.invokePluginPayment")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = s13Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                la2 la2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof la2)) {
                    la2Var = (la2) obj;
                } else {
                    la2Var = new la2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", la2Var);
                }
                Pair<Boolean, ky1> a = my1.a(la2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Prefetch.prefetchResources")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = la2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPreload", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                d92 d92Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof d92)) {
                    d92Var = (d92) obj;
                } else {
                    d92Var = new d92(this.mSwanApiContext);
                    this.mApis.put("423661539", d92Var);
                }
                Pair<Boolean, ky1> a = my1.a(d92Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Preload.preloadStatus")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = d92Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                ni3 ni3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof ni3)) {
                    ni3Var = (ni3) obj;
                } else {
                    ni3Var = new ni3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", ni3Var);
                }
                Pair<Boolean, ky1> a = my1.a(ni3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "PrivateFile.uploadFileToBos")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 D = ni3Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naRouter", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                dw1 dw1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof dw1)) {
                    dw1Var = (dw1) obj;
                } else {
                    dw1Var = new dw1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", dw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(dw1Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Router.hideModalPage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = dw1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                dw1 dw1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof dw1)) {
                    dw1Var = (dw1) obj;
                } else {
                    dw1Var = new dw1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", dw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(dw1Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Router.navigateBack")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 C = dw1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                ew1 ew1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof ew1)) {
                    ew1Var = (ew1) obj;
                } else {
                    ew1Var = new ew1(this.mSwanApiContext);
                    this.mApis.put("1968522584", ew1Var);
                }
                Pair<Boolean, ky1> a = my1.a(ew1Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Router.navigateTo")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 I = ew1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                gw1 gw1Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof gw1)) {
                    gw1Var = (gw1) obj;
                } else {
                    gw1Var = new gw1(this.mSwanApiContext);
                    this.mApis.put("1317280190", gw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(gw1Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Router.reLaunch")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = gw1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                hw1 hw1Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof hw1)) {
                    hw1Var = (hw1) obj;
                } else {
                    hw1Var = new hw1(this.mSwanApiContext);
                    this.mApis.put("-420075743", hw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(hw1Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Router.reLoadErrorPage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = hw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                fw1 fw1Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof fw1)) {
                    fw1Var = (fw1) obj;
                } else {
                    fw1Var = new fw1(this.mSwanApiContext);
                    this.mApis.put("1792515533", fw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(fw1Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Router.redirectTo")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 E = fw1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                ew1 ew1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof ew1)) {
                    ew1Var = (ew1) obj;
                } else {
                    ew1Var = new ew1(this.mSwanApiContext);
                    this.mApis.put("1968522584", ew1Var);
                }
                Pair<Boolean, ky1> a = my1.a(ew1Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Router.showModalPage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 K = ew1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naSetting", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                kw1 kw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", kw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(kw1Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Setting.getAppInfoSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 G = kw1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                kw1 kw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", kw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(kw1Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Setting.getSlaveIdSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 I = kw1Var.I();
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                jw1 jw1Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("450273045", jw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(jw1Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Setting.isAllowedAdOpenAppSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = jw1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                kw1 kw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", kw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(kw1Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Setting.getSetting")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 H = kw1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                kw1 kw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", kw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(kw1Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Setting.getSwanId")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 J = kw1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                kw1 kw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", kw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(kw1Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Setting.getUserInfo")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 K = kw1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                hd3 hd3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof hd3)) {
                    hd3Var = (hd3) obj;
                } else {
                    hd3Var = new hd3(this.mSwanApiContext);
                    this.mApis.put("712777136", hd3Var);
                }
                Pair<Boolean, ky1> a = my1.a(hd3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = hd3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naStorage", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                nw1 nw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof nw1)) {
                    nw1Var = (nw1) obj;
                } else {
                    nw1Var = new nw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", nw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(nw1Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = nw1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                nw1 nw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof nw1)) {
                    nw1Var = (nw1) obj;
                } else {
                    nw1Var = new nw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", nw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(nw1Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorageSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 D = nw1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                mw1 mw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("130910081", mw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(mw1Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.clearStorage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = mw1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                mw1 mw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("130910081", mw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(mw1Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.clearStorageSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 D = mw1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                nw1 nw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof nw1)) {
                    nw1Var = (nw1) obj;
                } else {
                    nw1Var = new nw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", nw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(nw1Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfo")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 H = nw1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                nw1 nw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof nw1)) {
                    nw1Var = (nw1) obj;
                } else {
                    nw1Var = new nw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", nw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(nw1Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfoSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 K = nw1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                mw1 mw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("130910081", mw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(mw1Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.getStorageInfo")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 H = mw1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                mw1 mw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("130910081", mw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(mw1Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.getStorageInfoSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 K = mw1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                nw1 nw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof nw1)) {
                    nw1Var = (nw1) obj;
                } else {
                    nw1Var = new nw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", nw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(nw1Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.getGlobalStorage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 E = nw1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                nw1 nw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof nw1)) {
                    nw1Var = (nw1) obj;
                } else {
                    nw1Var = new nw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", nw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(nw1Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 L = nw1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                mw1 mw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("130910081", mw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(mw1Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.getStorage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 E = mw1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                mw1 mw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("130910081", mw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(mw1Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.getStorageInfoAsync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 I = mw1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                mw1 mw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("130910081", mw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(mw1Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.getStorageSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 L = mw1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                nw1 nw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof nw1)) {
                    nw1Var = (nw1) obj;
                } else {
                    nw1Var = new nw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", nw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(nw1Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 S = nw1Var.S(str);
                if (S == null) {
                    return "";
                }
                return S.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                nw1 nw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof nw1)) {
                    nw1Var = (nw1) obj;
                } else {
                    nw1Var = new nw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", nw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(nw1Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorageSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 U = nw1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                mw1 mw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("130910081", mw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(mw1Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.removeStorage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 S = mw1Var.S(str);
                if (S == null) {
                    return "";
                }
                return S.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                mw1 mw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("130910081", mw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(mw1Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.removeStorageSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 U = mw1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                nw1 nw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof nw1)) {
                    nw1Var = (nw1) obj;
                } else {
                    nw1Var = new nw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", nw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(nw1Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.setGlobalStorage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 V = nw1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                nw1 nw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof nw1)) {
                    nw1Var = (nw1) obj;
                } else {
                    nw1Var = new nw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", nw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(nw1Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.setGlobalStorageSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 X = nw1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                mw1 mw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("130910081", mw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(mw1Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.setStorage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 V = mw1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                mw1 mw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("130910081", mw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(mw1Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.setStorageSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 X = mw1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naSubscription", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                pw1 pw1Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof pw1)) {
                    pw1Var = (pw1) obj;
                } else {
                    pw1Var = new pw1(this.mSwanApiContext);
                    this.mApis.put("823117982", pw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(pw1Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Subscription.requestSubscribeFormId")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 F = pw1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                qw1 qw1Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof qw1)) {
                    qw1Var = (qw1) obj;
                } else {
                    qw1Var = new qw1(this.mSwanApiContext);
                    this.mApis.put("-947445811", qw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(qw1Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Subscription.subscribeService")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 G = qw1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naSystem", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                xw1 xw1Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof xw1)) {
                    xw1Var = (xw1) obj;
                } else {
                    xw1Var = new xw1(this.mSwanApiContext);
                    this.mApis.put("1936205521", xw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(xw1Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.exitFullScreen")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = xw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                ww1 ww1Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof ww1)) {
                    ww1Var = (ww1) obj;
                } else {
                    ww1Var = new ww1(this.mSwanApiContext);
                    this.mApis.put("1694151270", ww1Var);
                }
                Pair<Boolean, ky1> a = my1.a(ww1Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.getDeviceInfo")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = ww1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                yw1 yw1Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof yw1)) {
                    yw1Var = (yw1) obj;
                } else {
                    yw1Var = new yw1(this.mSwanApiContext);
                    this.mApis.put("-1321681619", yw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(yw1Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.getDeviceProfile")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = yw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                zw1 zw1Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof zw1)) {
                    zw1Var = (zw1) obj;
                } else {
                    zw1Var = new zw1(this.mSwanApiContext);
                    this.mApis.put("-1569246082", zw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(zw1Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.makePhoneCall")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = zw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                bx1 bx1Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof bx1)) {
                    bx1Var = (bx1) obj;
                } else {
                    bx1Var = new bx1(this.mSwanApiContext);
                    this.mApis.put("1099851202", bx1Var);
                }
                Pair<Boolean, ky1> a = my1.a(bx1Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.openSMSPanel")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = bx1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                ax1 ax1Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof ax1)) {
                    ax1Var = (ax1) obj;
                } else {
                    ax1Var = new ax1(this.mSwanApiContext);
                    this.mApis.put("-1707203360", ax1Var);
                }
                Pair<Boolean, ky1> a = my1.a(ax1Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.requestFullScreen")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 G = ax1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                uw1 uw1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof uw1)) {
                    uw1Var = (uw1) obj;
                } else {
                    uw1Var = new uw1(this.mSwanApiContext);
                    this.mApis.put("-518757484", uw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(uw1Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.setClipboardData")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = uw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                dw2 dw2Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof dw2)) {
                    dw2Var = (dw2) obj;
                } else {
                    dw2Var = new dw2(this.mSwanApiContext);
                    this.mApis.put("1161486049", dw2Var);
                }
                Pair<Boolean, ky1> a = my1.a(dw2Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.setErrorPageType")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = dw2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                ex1 ex1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof ex1)) {
                    ex1Var = (ex1) obj;
                } else {
                    ex1Var = new ex1(this.mSwanApiContext);
                    this.mApis.put("447234992", ex1Var);
                }
                Pair<Boolean, ky1> a = my1.a(ex1Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.setMediaVolume")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 A = ex1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                sw1 sw1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof sw1)) {
                    sw1Var = (sw1) obj;
                } else {
                    sw1Var = new sw1(this.mSwanApiContext);
                    this.mApis.put("1372680763", sw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(sw1Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.startAccelerometer")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = sw1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                vw1 vw1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("1689255576", vw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(vw1Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.startCompass")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = vw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                tw1 tw1Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("99997465", tw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(tw1Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.getBrightness")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = tw1Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                uw1 uw1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof uw1)) {
                    uw1Var = (uw1) obj;
                } else {
                    uw1Var = new uw1(this.mSwanApiContext);
                    this.mApis.put("-518757484", uw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(uw1Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.getClipboardData")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = uw1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                ex1 ex1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof ex1)) {
                    ex1Var = (ex1) obj;
                } else {
                    ex1Var = new ex1(this.mSwanApiContext);
                    this.mApis.put("447234992", ex1Var);
                }
                Pair<Boolean, ky1> a = my1.a(ex1Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.getMediaVolume")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = ex1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                sw1 sw1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof sw1)) {
                    sw1Var = (sw1) obj;
                } else {
                    sw1Var = new sw1(this.mSwanApiContext);
                    this.mApis.put("1372680763", sw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(sw1Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.stopAccelerometer")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 C = sw1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                vw1 vw1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("1689255576", vw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(vw1Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.stopCompass")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 A = vw1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naUtils", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                px1 px1Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof px1)) {
                    px1Var = (px1) obj;
                } else {
                    px1Var = new px1(this.mSwanApiContext);
                    this.mApis.put("201194468", px1Var);
                }
                Pair<Boolean, ky1> a = my1.a(px1Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.addToDesktop")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 C = px1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                lx1 lx1Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof lx1)) {
                    lx1Var = (lx1) obj;
                } else {
                    lx1Var = new lx1(this.mSwanApiContext);
                    this.mApis.put("-1412306947", lx1Var);
                }
                Pair<Boolean, ky1> a = my1.a(lx1Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.calcMD5")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = lx1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                mx1 mx1Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof mx1)) {
                    mx1Var = (mx1) obj;
                } else {
                    mx1Var = new mx1(this.mSwanApiContext);
                    this.mApis.put("1626415364", mx1Var);
                }
                Pair<Boolean, ky1> a = my1.a(mx1Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.checkAppInstalled")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = mx1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                ox1 ox1Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof ox1)) {
                    ox1Var = (ox1) obj;
                } else {
                    ox1Var = new ox1(this.mSwanApiContext);
                    this.mApis.put("-836768778", ox1Var);
                }
                Pair<Boolean, ky1> a = my1.a(ox1Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfo")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = ox1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                qx1 qx1Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("-810858308", qx1Var);
                }
                Pair<Boolean, ky1> a = my1.a(qx1Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.getPerformanceLevel")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = qx1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                ux1 ux1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", ux1Var);
                }
                Pair<Boolean, ky1> a = my1.a(ux1Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.getSystemInfoAsync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 J = ux1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                rx1 rx1Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof rx1)) {
                    rx1Var = (rx1) obj;
                } else {
                    rx1Var = new rx1(this.mSwanApiContext);
                    this.mApis.put("-2097727681", rx1Var);
                }
                Pair<Boolean, ky1> a = my1.a(rx1Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.handleException")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = rx1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                nx1 nx1Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof nx1)) {
                    nx1Var = (nx1) obj;
                } else {
                    nx1Var = new nx1(this.mSwanApiContext);
                    this.mApis.put("2084449317", nx1Var);
                }
                Pair<Boolean, ky1> a = my1.a(nx1Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.hasCloseHandler")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = nx1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                pa3 pa3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof pa3)) {
                    pa3Var = (pa3) obj;
                } else {
                    pa3Var = new pa3(this.mSwanApiContext);
                    this.mApis.put("1031678042", pa3Var);
                }
                Pair<Boolean, ky1> a = my1.a(pa3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.hideCaptureScreenShareDialog")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = pa3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                sx1 sx1Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof sx1)) {
                    sx1Var = (sx1) obj;
                } else {
                    sx1Var = new sx1(this.mSwanApiContext);
                    this.mApis.put("1751900130", sx1Var);
                }
                Pair<Boolean, ky1> a = my1.a(sx1Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.logToFile")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = sx1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                q93 q93Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof q93)) {
                    q93Var = (q93) obj;
                } else {
                    q93Var = new q93(this.mSwanApiContext);
                    this.mApis.put("1748196865", q93Var);
                }
                Pair<Boolean, ky1> a = my1.a(q93Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.preloadPackage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = q93Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                tx1 tx1Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof tx1)) {
                    tx1Var = (tx1) obj;
                } else {
                    tx1Var = new tx1(this.mSwanApiContext);
                    this.mApis.put("589529211", tx1Var);
                }
                Pair<Boolean, ky1> a = my1.a(tx1Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.previewImage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 C = tx1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-577481801", wx1Var);
                }
                Pair<Boolean, ky1> a = my1.a(wx1Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.ubcFlowJar")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 J = wx1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                ux1 ux1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", ux1Var);
                }
                Pair<Boolean, ky1> a = my1.a(ux1Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfoSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 F = ux1Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                ux1 ux1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", ux1Var);
                }
                Pair<Boolean, ky1> a = my1.a(ux1Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.getSystemInfo")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 I = ux1Var.I();
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                ux1 ux1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", ux1Var);
                }
                Pair<Boolean, ky1> a = my1.a(ux1Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.getSystemInfoSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 K = ux1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naWifi", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                ah3 ah3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ah3)) {
                    ah3Var = (ah3) obj;
                } else {
                    ah3Var = new ah3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ah3Var);
                }
                Pair<Boolean, ky1> a = my1.a(ah3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Wifi.connectWifi")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = ah3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                ah3 ah3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ah3)) {
                    ah3Var = (ah3) obj;
                } else {
                    ah3Var = new ah3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ah3Var);
                }
                Pair<Boolean, ky1> a = my1.a(ah3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Wifi.getConnectedWifi")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 C = ah3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                ah3 ah3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ah3)) {
                    ah3Var = (ah3) obj;
                } else {
                    ah3Var = new ah3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ah3Var);
                }
                Pair<Boolean, ky1> a = my1.a(ah3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Wifi.getWifiList")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 D = ah3Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                ah3 ah3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ah3)) {
                    ah3Var = (ah3) obj;
                } else {
                    ah3Var = new ah3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ah3Var);
                }
                Pair<Boolean, ky1> a = my1.a(ah3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Wifi.startWifi")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 H = ah3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                ah3 ah3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ah3)) {
                    ah3Var = (ah3) obj;
                } else {
                    ah3Var = new ah3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ah3Var);
                }
                Pair<Boolean, ky1> a = my1.a(ah3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Wifi.stopWifi")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 I = ah3Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final mu1 mu1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                su1 su1Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof su1)) {
                    su1Var = (su1) obj;
                } else {
                    su1Var = new su1(this.mSwanApiContext);
                    this.mApis.put("1930258908", su1Var);
                }
                Pair<Boolean, ky1> a = my1.a(su1Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Account.checkSession")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = su1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                tu1 tu1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof tu1)) {
                    tu1Var = (tu1) obj;
                } else {
                    tu1Var = new tu1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", tu1Var);
                }
                Pair<Boolean, ky1> a = my1.a(tu1Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Account.getLoginCode")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 D = tu1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                uu1 uu1Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof uu1)) {
                    uu1Var = (uu1) obj;
                } else {
                    uu1Var = new uu1(this.mSwanApiContext);
                    this.mApis.put("1754780133", uu1Var);
                }
                Pair<Boolean, ky1> a = my1.a(uu1Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Account.getOpenId")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = uu1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                bu1 bu1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof bu1)) {
                    bu1Var = (bu1) obj;
                } else {
                    bu1Var = new bu1(this.mSwanApiContext);
                    this.mApis.put("-343998465", bu1Var);
                }
                Pair<Boolean, ky1> a = my1.a(bu1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Account.getUnionBDUSS")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = bu1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String login(String str) {
                tu1 tu1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof tu1)) {
                    tu1Var = (tu1) obj;
                } else {
                    tu1Var = new tu1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", tu1Var);
                }
                Pair<Boolean, ky1> a = my1.a(tu1Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Account.login")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 J = tu1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                ru1 ru1Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof ru1)) {
                    ru1Var = (ru1) obj;
                } else {
                    ru1Var = new ru1(this.mSwanApiContext);
                    this.mApis.put("-337742792", ru1Var);
                }
                Pair<Boolean, ky1> a = my1.a(ru1Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Account.isBaiduAccountSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = ru1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                tu1 tu1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof tu1)) {
                    tu1Var = (tu1) obj;
                } else {
                    tu1Var = new tu1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", tu1Var);
                }
                Pair<Boolean, ky1> a = my1.a(tu1Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Account.isLoginSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 I = tu1Var.I();
                if (I == null) {
                    return "";
                }
                return I.a();
            }
        });
        hashMap.put("_naBasic", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                vu1 vu1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof vu1)) {
                    vu1Var = (vu1) obj;
                } else {
                    vu1Var = new vu1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", vu1Var);
                }
                Pair<Boolean, ky1> a = my1.a(vu1Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Basic.loadSubPackage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 G = vu1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                vu1 vu1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof vu1)) {
                    vu1Var = (vu1) obj;
                } else {
                    vu1Var = new vu1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", vu1Var);
                }
                Pair<Boolean, ky1> a = my1.a(vu1Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Basic.loadSubPackages")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 H = vu1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                cn1 cn1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof cn1)) {
                    cn1Var = (cn1) obj;
                } else {
                    cn1Var = new cn1(this.mSwanApiContext);
                    this.mApis.put("1460300387", cn1Var);
                }
                Pair<Boolean, ky1> a = my1.a(cn1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Bookshelf.deleteBookshelf")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 L = cn1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                cn1 cn1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof cn1)) {
                    cn1Var = (cn1) obj;
                } else {
                    cn1Var = new cn1(this.mSwanApiContext);
                    this.mApis.put("1460300387", cn1Var);
                }
                Pair<Boolean, ky1> a = my1.a(cn1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Bookshelf.insertBookshelf")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 Q = cn1Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                cn1 cn1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof cn1)) {
                    cn1Var = (cn1) obj;
                } else {
                    cn1Var = new cn1(this.mSwanApiContext);
                    this.mApis.put("1460300387", cn1Var);
                }
                Pair<Boolean, ky1> a = my1.a(cn1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Bookshelf.navigateToBookshelf")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 V = cn1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                cn1 cn1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof cn1)) {
                    cn1Var = (cn1) obj;
                } else {
                    cn1Var = new cn1(this.mSwanApiContext);
                    this.mApis.put("1460300387", cn1Var);
                }
                Pair<Boolean, ky1> a = my1.a(cn1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Bookshelf.queryBookshelf")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 W = cn1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                cn1 cn1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof cn1)) {
                    cn1Var = (cn1) obj;
                } else {
                    cn1Var = new cn1(this.mSwanApiContext);
                    this.mApis.put("1460300387", cn1Var);
                }
                Pair<Boolean, ky1> a = my1.a(cn1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Bookshelf.updateBookshelfReadTime")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 Y = cn1Var.Y(str);
                if (Y == null) {
                    return "";
                }
                return Y.a();
            }
        });
        hashMap.put("_naCoupon", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                pu1 pu1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof pu1)) {
                    pu1Var = (pu1) obj;
                } else {
                    pu1Var = new pu1(this.mSwanApiContext);
                    this.mApis.put("-277316359", pu1Var);
                }
                Pair<Boolean, ky1> a = my1.a(pu1Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Coupon.getPlatformCoupons")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = pu1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                pu1 pu1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof pu1)) {
                    pu1Var = (pu1) obj;
                } else {
                    pu1Var = new pu1(this.mSwanApiContext);
                    this.mApis.put("-277316359", pu1Var);
                }
                Pair<Boolean, ky1> a = my1.a(pu1Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Coupon.getUserCoupons")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 A = pu1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                pu1 pu1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof pu1)) {
                    pu1Var = (pu1) obj;
                } else {
                    pu1Var = new pu1(this.mSwanApiContext);
                    this.mApis.put("-277316359", pu1Var);
                }
                Pair<Boolean, ky1> a = my1.a(pu1Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Coupon.takeCoupons")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 D = pu1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naFavorite", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                xu1 xu1Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof xu1)) {
                    xu1Var = (xu1) obj;
                } else {
                    xu1Var = new xu1(this.mSwanApiContext);
                    this.mApis.put("-1225406515", xu1Var);
                }
                Pair<Boolean, ky1> a = my1.a(xu1Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Favorite.getFavorStatus")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = xu1Var.y(str);
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
                Pair<Boolean, ky1> a = my1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Favorite.showFavoriteGuide")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 H = showFavoriteGuideApi.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naFile", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                zu1 zu1Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof zu1)) {
                    zu1Var = (zu1) obj;
                } else {
                    zu1Var = new zu1(this.mSwanApiContext);
                    this.mApis.put("-2057135077", zu1Var);
                }
                Pair<Boolean, ky1> a = my1.a(zu1Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "File.shareFile")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = zu1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                nj2 nj2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof nj2)) {
                    nj2Var = (nj2) obj;
                } else {
                    nj2Var = new nj2(this.mSwanApiContext);
                    this.mApis.put("2077414795", nj2Var);
                }
                Pair<Boolean, ky1> a = my1.a(nj2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = nj2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                nj2 nj2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof nj2)) {
                    nj2Var = (nj2) obj;
                } else {
                    nj2Var = new nj2(this.mSwanApiContext);
                    this.mApis.put("2077414795", nj2Var);
                }
                Pair<Boolean, ky1> a = my1.a(nj2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessageSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = nj2Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String download(String str) {
                av1 av1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof av1)) {
                    av1Var = (av1) obj;
                } else {
                    av1Var = new av1(this.mSwanApiContext);
                    this.mApis.put("-170124576", av1Var);
                }
                Pair<Boolean, ky1> a = my1.a(av1Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "HostDownloadManager.download")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = av1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                av1 av1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof av1)) {
                    av1Var = (av1) obj;
                } else {
                    av1Var = new av1(this.mSwanApiContext);
                    this.mApis.put("-170124576", av1Var);
                }
                Pair<Boolean, ky1> a = my1.a(av1Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "HostDownloadManager.openFile")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 A = av1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String query(String str) {
                av1 av1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof av1)) {
                    av1Var = (av1) obj;
                } else {
                    av1Var = new av1(this.mSwanApiContext);
                    this.mApis.put("-170124576", av1Var);
                }
                Pair<Boolean, ky1> a = my1.a(av1Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "HostDownloadManager.query")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = av1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                av1 av1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof av1)) {
                    av1Var = (av1) obj;
                } else {
                    av1Var = new av1(this.mSwanApiContext);
                    this.mApis.put("-170124576", av1Var);
                }
                Pair<Boolean, ky1> a = my1.a(av1Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "HostDownloadManager.openDownloadCenter")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = av1Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naImage", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                bw2 bw2Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof bw2)) {
                    bw2Var = (bw2) obj;
                } else {
                    bw2Var = new bw2(this.mSwanApiContext);
                    this.mApis.put("1445003743", bw2Var);
                }
                Pair<Boolean, ky1> a = my1.a(bw2Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Image.callImageMenu")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = bw2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                dv1 dv1Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof dv1)) {
                    dv1Var = (dv1) obj;
                } else {
                    dv1Var = new dv1(this.mSwanApiContext);
                    this.mApis.put("-1252730367", dv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(dv1Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Image.compressImage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = dv1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naInteraction", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                lv1 lv1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof lv1)) {
                    lv1Var = (lv1) obj;
                } else {
                    lv1Var = new lv1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", lv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(lv1Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.closeTabBar")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = lv1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                lv1 lv1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof lv1)) {
                    lv1Var = (lv1) obj;
                } else {
                    lv1Var = new lv1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", lv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(lv1Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.closeTabBarRedDot")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = lv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                hv1 hv1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof hv1)) {
                    hv1Var = (hv1) obj;
                } else {
                    hv1Var = new hv1(this.mSwanApiContext);
                    this.mApis.put("-246386074", hv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(hv1Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.hideNavigationBarLoading")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = hv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                jv1 jv1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof jv1)) {
                    jv1Var = (jv1) obj;
                } else {
                    jv1Var = new jv1(this.mSwanApiContext);
                    this.mApis.put("-108978463", jv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(jv1Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.openMultiPicker")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 H = jv1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                jv1 jv1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof jv1)) {
                    jv1Var = (jv1) obj;
                } else {
                    jv1Var = new jv1(this.mSwanApiContext);
                    this.mApis.put("-108978463", jv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(jv1Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.openPicker")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 I = jv1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                lv1 lv1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof lv1)) {
                    lv1Var = (lv1) obj;
                } else {
                    lv1Var = new lv1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", lv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(lv1Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.openTabBar")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 D = lv1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                iv1 iv1Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof iv1)) {
                    iv1Var = (iv1) obj;
                } else {
                    iv1Var = new iv1(this.mSwanApiContext);
                    this.mApis.put("-1750613704", iv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(iv1Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.pageScrollTo")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = iv1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                hv1 hv1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof hv1)) {
                    hv1Var = (hv1) obj;
                } else {
                    hv1Var = new hv1(this.mSwanApiContext);
                    this.mApis.put("-246386074", hv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(hv1Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarColor")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 A = hv1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                hv1 hv1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof hv1)) {
                    hv1Var = (hv1) obj;
                } else {
                    hv1Var = new hv1(this.mSwanApiContext);
                    this.mApis.put("-246386074", hv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(hv1Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarTitle")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = hv1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                lv1 lv1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof lv1)) {
                    lv1Var = (lv1) obj;
                } else {
                    lv1Var = new lv1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", lv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(lv1Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.setTabBarItem")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 E = lv1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                jv1 jv1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof jv1)) {
                    jv1Var = (jv1) obj;
                } else {
                    jv1Var = new jv1(this.mSwanApiContext);
                    this.mApis.put("-108978463", jv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(jv1Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.showDatePickerView")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 M = jv1Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                nv1 nv1Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof nv1)) {
                    nv1Var = (nv1) obj;
                } else {
                    nv1Var = new nv1(this.mSwanApiContext);
                    this.mApis.put("1172469410", nv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(nv1Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.showHalfScreenWebview")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 L = nv1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                fv1 fv1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof fv1)) {
                    fv1Var = (fv1) obj;
                } else {
                    fv1Var = new fv1(this.mSwanApiContext);
                    this.mApis.put("5236036", fv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(fv1Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.showLoading")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = fv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                gv1 gv1Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof gv1)) {
                    gv1Var = (gv1) obj;
                } else {
                    gv1Var = new gv1(this.mSwanApiContext);
                    this.mApis.put("1913747800", gv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(gv1Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.showModal")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = gv1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                hv1 hv1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof hv1)) {
                    hv1Var = (hv1) obj;
                } else {
                    hv1Var = new hv1(this.mSwanApiContext);
                    this.mApis.put("-246386074", hv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(hv1Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.showNavigationBarLoading")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 C = hv1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                mv1 mv1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof mv1)) {
                    mv1Var = (mv1) obj;
                } else {
                    mv1Var = new mv1(this.mSwanApiContext);
                    this.mApis.put("1159492510", mv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(mv1Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.showToast")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 R = mv1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                kv1 kv1Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof kv1)) {
                    kv1Var = (kv1) obj;
                } else {
                    kv1Var = new kv1(this.mSwanApiContext);
                    this.mApis.put("1165118609", kv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(kv1Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.stopPullDownRefresh")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = kv1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                jv1 jv1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof jv1)) {
                    jv1Var = (jv1) obj;
                } else {
                    jv1Var = new jv1(this.mSwanApiContext);
                    this.mApis.put("-108978463", jv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(jv1Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.updateMultiPicker")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 N = jv1Var.N(str);
                if (N == null) {
                    return "";
                }
                return N.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                fv1 fv1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof fv1)) {
                    fv1Var = (fv1) obj;
                } else {
                    fv1Var = new fv1(this.mSwanApiContext);
                    this.mApis.put("5236036", fv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(fv1Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.hideLoading")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = fv1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideToast() {
                mv1 mv1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof mv1)) {
                    mv1Var = (mv1) obj;
                } else {
                    mv1Var = new mv1(this.mSwanApiContext);
                    this.mApis.put("1159492510", mv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(mv1Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Interaction.hideToast")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 L = mv1Var.L();
                if (L == null) {
                    return "";
                }
                return L.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                ov1 ov1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof ov1)) {
                    ov1Var = (ov1) obj;
                } else {
                    ov1Var = new ov1(this.mSwanApiContext);
                    this.mApis.put("-137346255", ov1Var);
                }
                Pair<Boolean, ky1> a = my1.a(ov1Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Keyboard.startKeyboardHeightChange")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 D = ov1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                ov1 ov1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof ov1)) {
                    ov1Var = (ov1) obj;
                } else {
                    ov1Var = new ov1(this.mSwanApiContext);
                    this.mApis.put("-137346255", ov1Var);
                }
                Pair<Boolean, ky1> a = my1.a(ov1Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Keyboard.stopKeyboardHeightChange")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 E = ov1Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }
        });
        hashMap.put("_naLocationService", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                pv1 pv1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof pv1)) {
                    pv1Var = (pv1) obj;
                } else {
                    pv1Var = new pv1(this.mSwanApiContext);
                    this.mApis.put("-397373095", pv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(pv1Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "LocationService.getLocation")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = pv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                pv1 pv1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof pv1)) {
                    pv1Var = (pv1) obj;
                } else {
                    pv1Var = new pv1(this.mSwanApiContext);
                    this.mApis.put("-397373095", pv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(pv1Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "LocationService.startLocationUpdate")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = pv1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                pv1 pv1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof pv1)) {
                    pv1Var = (pv1) obj;
                } else {
                    pv1Var = new pv1(this.mSwanApiContext);
                    this.mApis.put("-397373095", pv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(pv1Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "LocationService.stopLocationUpdate")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 C = pv1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naMenu", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                gx1 gx1Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof gx1)) {
                    gx1Var = (gx1) obj;
                } else {
                    gx1Var = new gx1(this.mSwanApiContext);
                    this.mApis.put("538070032", gx1Var);
                }
                Pair<Boolean, ky1> a = my1.a(gx1Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = gx1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naNetwork", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                sv1 sv1Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof sv1)) {
                    sv1Var = (sv1) obj;
                } else {
                    sv1Var = new sv1(this.mSwanApiContext);
                    this.mApis.put("-1076509454", sv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(sv1Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Network.callService")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = sv1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                zv1 zv1Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof zv1)) {
                    zv1Var = (zv1) obj;
                } else {
                    zv1Var = new zv1(this.mSwanApiContext);
                    this.mApis.put("968563034", zv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(zv1Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Network.cancelRequest")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 E = zv1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                yv1 yv1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof yv1)) {
                    yv1Var = (yv1) obj;
                } else {
                    yv1Var = new yv1(this.mSwanApiContext);
                    this.mApis.put("453220699", yv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(yv1Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Network.networkStatusChange")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = yv1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                yv1 yv1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof yv1)) {
                    yv1Var = (yv1) obj;
                } else {
                    yv1Var = new yv1(this.mSwanApiContext);
                    this.mApis.put("453220699", yv1Var);
                }
                Pair<Boolean, ky1> a = my1.a(yv1Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Network.getNetworkType")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = yv1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(String str) {
                zv1 zv1Var;
                String a;
                try {
                    jy1.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof zv1)) {
                        zv1Var = (zv1) obj;
                    } else {
                        zv1Var = new zv1(this.mSwanApiContext);
                        this.mApis.put("968563034", zv1Var);
                    }
                    Pair<Boolean, ky1> a2 = my1.a(zv1Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((ky1) a2.second).a();
                    } else if (r82.a(this.mSwanApiContext.e(), "Network.request")) {
                        a = new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<ky1, JSONObject> v = ou1.v(str);
                        if (!((ky1) v.first).isSuccess()) {
                            a = ((ky1) v.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) v.second;
                            if (jSONObject == null) {
                                a = ky1.a.a();
                            } else {
                                ly1 W = zv1Var.W(jSONObject);
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
                        jy1.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                hz2 hz2Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof hz2)) {
                    hz2Var = (hz2) obj;
                } else {
                    hz2Var = new hz2(this.mSwanApiContext);
                    this.mApis.put("-336396851", hz2Var);
                }
                Pair<Boolean, ky1> a = my1.a(hz2Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Payment.chooseCoupon")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = hz2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                hz2 hz2Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof hz2)) {
                    hz2Var = (hz2) obj;
                } else {
                    hz2Var = new hz2(this.mSwanApiContext);
                    this.mApis.put("-336396851", hz2Var);
                }
                Pair<Boolean, ky1> a = my1.a(hz2Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Payment.getPaymentInfo")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = hz2Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                xy2 xy2Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof xy2)) {
                    xy2Var = (xy2) obj;
                } else {
                    xy2Var = new xy2(this.mSwanApiContext);
                    this.mApis.put("1854689529", xy2Var);
                }
                Pair<Boolean, ky1> a = my1.a(xy2Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Payment.requestThirdPayment")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = xy2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                hz2 hz2Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof hz2)) {
                    hz2Var = (hz2) obj;
                } else {
                    hz2Var = new hz2(this.mSwanApiContext);
                    this.mApis.put("-336396851", hz2Var);
                }
                Pair<Boolean, ky1> a = my1.a(hz2Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Payment.setPaymentInfo")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 A = hz2Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPlugin", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                s13 s13Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof s13)) {
                    s13Var = (s13) obj;
                } else {
                    s13Var = new s13(this.mSwanApiContext);
                    this.mApis.put("-254510461", s13Var);
                }
                Pair<Boolean, ky1> a = my1.a(s13Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Plugin.invokePluginChooseAddress")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = s13Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                s13 s13Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof s13)) {
                    s13Var = (s13) obj;
                } else {
                    s13Var = new s13(this.mSwanApiContext);
                    this.mApis.put("-254510461", s13Var);
                }
                Pair<Boolean, ky1> a = my1.a(s13Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 A = s13Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                s13 s13Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof s13)) {
                    s13Var = (s13) obj;
                } else {
                    s13Var = new s13(this.mSwanApiContext);
                    this.mApis.put("-254510461", s13Var);
                }
                Pair<Boolean, ky1> a = my1.a(s13Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Plugin.invokePluginPayment")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = s13Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                la2 la2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof la2)) {
                    la2Var = (la2) obj;
                } else {
                    la2Var = new la2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", la2Var);
                }
                Pair<Boolean, ky1> a = my1.a(la2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Prefetch.prefetchResources")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = la2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPreload", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                d92 d92Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof d92)) {
                    d92Var = (d92) obj;
                } else {
                    d92Var = new d92(this.mSwanApiContext);
                    this.mApis.put("423661539", d92Var);
                }
                Pair<Boolean, ky1> a = my1.a(d92Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Preload.preloadStatus")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = d92Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                ni3 ni3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof ni3)) {
                    ni3Var = (ni3) obj;
                } else {
                    ni3Var = new ni3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", ni3Var);
                }
                Pair<Boolean, ky1> a = my1.a(ni3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "PrivateFile.uploadFileToBos")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 D = ni3Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naRouter", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                dw1 dw1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof dw1)) {
                    dw1Var = (dw1) obj;
                } else {
                    dw1Var = new dw1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", dw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(dw1Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Router.hideModalPage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = dw1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                dw1 dw1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof dw1)) {
                    dw1Var = (dw1) obj;
                } else {
                    dw1Var = new dw1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", dw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(dw1Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Router.navigateBack")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 C = dw1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                ew1 ew1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof ew1)) {
                    ew1Var = (ew1) obj;
                } else {
                    ew1Var = new ew1(this.mSwanApiContext);
                    this.mApis.put("1968522584", ew1Var);
                }
                Pair<Boolean, ky1> a = my1.a(ew1Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Router.navigateTo")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 I = ew1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                gw1 gw1Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof gw1)) {
                    gw1Var = (gw1) obj;
                } else {
                    gw1Var = new gw1(this.mSwanApiContext);
                    this.mApis.put("1317280190", gw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(gw1Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Router.reLaunch")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = gw1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                hw1 hw1Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof hw1)) {
                    hw1Var = (hw1) obj;
                } else {
                    hw1Var = new hw1(this.mSwanApiContext);
                    this.mApis.put("-420075743", hw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(hw1Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Router.reLoadErrorPage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = hw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                fw1 fw1Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof fw1)) {
                    fw1Var = (fw1) obj;
                } else {
                    fw1Var = new fw1(this.mSwanApiContext);
                    this.mApis.put("1792515533", fw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(fw1Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Router.redirectTo")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 E = fw1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                ew1 ew1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof ew1)) {
                    ew1Var = (ew1) obj;
                } else {
                    ew1Var = new ew1(this.mSwanApiContext);
                    this.mApis.put("1968522584", ew1Var);
                }
                Pair<Boolean, ky1> a = my1.a(ew1Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Router.showModalPage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 K = ew1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naSetting", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                kw1 kw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", kw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(kw1Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Setting.getAppInfoSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 G = kw1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                kw1 kw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", kw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(kw1Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Setting.getSlaveIdSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 I = kw1Var.I();
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                jw1 jw1Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("450273045", jw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(jw1Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Setting.isAllowedAdOpenAppSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = jw1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                kw1 kw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", kw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(kw1Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Setting.getSetting")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 H = kw1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                kw1 kw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", kw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(kw1Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Setting.getSwanId")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 J = kw1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                kw1 kw1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof kw1)) {
                    kw1Var = (kw1) obj;
                } else {
                    kw1Var = new kw1(this.mSwanApiContext);
                    this.mApis.put("-594895721", kw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(kw1Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Setting.getUserInfo")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 K = kw1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                hd3 hd3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof hd3)) {
                    hd3Var = (hd3) obj;
                } else {
                    hd3Var = new hd3(this.mSwanApiContext);
                    this.mApis.put("712777136", hd3Var);
                }
                Pair<Boolean, ky1> a = my1.a(hd3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = hd3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naStorage", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                nw1 nw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof nw1)) {
                    nw1Var = (nw1) obj;
                } else {
                    nw1Var = new nw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", nw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(nw1Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = nw1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                nw1 nw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof nw1)) {
                    nw1Var = (nw1) obj;
                } else {
                    nw1Var = new nw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", nw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(nw1Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorageSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 D = nw1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                mw1 mw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("130910081", mw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(mw1Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.clearStorage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = mw1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                mw1 mw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("130910081", mw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(mw1Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.clearStorageSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 D = mw1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                nw1 nw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof nw1)) {
                    nw1Var = (nw1) obj;
                } else {
                    nw1Var = new nw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", nw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(nw1Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfo")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 H = nw1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                nw1 nw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof nw1)) {
                    nw1Var = (nw1) obj;
                } else {
                    nw1Var = new nw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", nw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(nw1Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfoSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 K = nw1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                mw1 mw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("130910081", mw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(mw1Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.getStorageInfo")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 H = mw1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                mw1 mw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("130910081", mw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(mw1Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.getStorageInfoSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 K = mw1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                nw1 nw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof nw1)) {
                    nw1Var = (nw1) obj;
                } else {
                    nw1Var = new nw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", nw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(nw1Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.getGlobalStorage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 E = nw1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                nw1 nw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof nw1)) {
                    nw1Var = (nw1) obj;
                } else {
                    nw1Var = new nw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", nw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(nw1Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 L = nw1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                mw1 mw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("130910081", mw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(mw1Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.getStorage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 E = mw1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                mw1 mw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("130910081", mw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(mw1Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.getStorageInfoAsync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 I = mw1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                mw1 mw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("130910081", mw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(mw1Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.getStorageSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 L = mw1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                nw1 nw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof nw1)) {
                    nw1Var = (nw1) obj;
                } else {
                    nw1Var = new nw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", nw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(nw1Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 S = nw1Var.S(str);
                if (S == null) {
                    return "";
                }
                return S.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                nw1 nw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof nw1)) {
                    nw1Var = (nw1) obj;
                } else {
                    nw1Var = new nw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", nw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(nw1Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorageSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 U = nw1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                mw1 mw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("130910081", mw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(mw1Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.removeStorage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 S = mw1Var.S(str);
                if (S == null) {
                    return "";
                }
                return S.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                mw1 mw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("130910081", mw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(mw1Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.removeStorageSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 U = mw1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                nw1 nw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof nw1)) {
                    nw1Var = (nw1) obj;
                } else {
                    nw1Var = new nw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", nw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(nw1Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.setGlobalStorage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 V = nw1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                nw1 nw1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof nw1)) {
                    nw1Var = (nw1) obj;
                } else {
                    nw1Var = new nw1(this.mSwanApiContext);
                    this.mApis.put("-804054859", nw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(nw1Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.setGlobalStorageSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 X = nw1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                mw1 mw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("130910081", mw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(mw1Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.setStorage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 V = mw1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                mw1 mw1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("130910081", mw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(mw1Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Storage.setStorageSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 X = mw1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naSubscription", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                pw1 pw1Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof pw1)) {
                    pw1Var = (pw1) obj;
                } else {
                    pw1Var = new pw1(this.mSwanApiContext);
                    this.mApis.put("823117982", pw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(pw1Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Subscription.requestSubscribeFormId")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 F = pw1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                qw1 qw1Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof qw1)) {
                    qw1Var = (qw1) obj;
                } else {
                    qw1Var = new qw1(this.mSwanApiContext);
                    this.mApis.put("-947445811", qw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(qw1Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Subscription.subscribeService")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 G = qw1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naSystem", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                xw1 xw1Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof xw1)) {
                    xw1Var = (xw1) obj;
                } else {
                    xw1Var = new xw1(this.mSwanApiContext);
                    this.mApis.put("1936205521", xw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(xw1Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.exitFullScreen")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = xw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                ww1 ww1Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof ww1)) {
                    ww1Var = (ww1) obj;
                } else {
                    ww1Var = new ww1(this.mSwanApiContext);
                    this.mApis.put("1694151270", ww1Var);
                }
                Pair<Boolean, ky1> a = my1.a(ww1Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.getDeviceInfo")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = ww1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                yw1 yw1Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof yw1)) {
                    yw1Var = (yw1) obj;
                } else {
                    yw1Var = new yw1(this.mSwanApiContext);
                    this.mApis.put("-1321681619", yw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(yw1Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.getDeviceProfile")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = yw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                zw1 zw1Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof zw1)) {
                    zw1Var = (zw1) obj;
                } else {
                    zw1Var = new zw1(this.mSwanApiContext);
                    this.mApis.put("-1569246082", zw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(zw1Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.makePhoneCall")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = zw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                bx1 bx1Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof bx1)) {
                    bx1Var = (bx1) obj;
                } else {
                    bx1Var = new bx1(this.mSwanApiContext);
                    this.mApis.put("1099851202", bx1Var);
                }
                Pair<Boolean, ky1> a = my1.a(bx1Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.openSMSPanel")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = bx1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                ax1 ax1Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof ax1)) {
                    ax1Var = (ax1) obj;
                } else {
                    ax1Var = new ax1(this.mSwanApiContext);
                    this.mApis.put("-1707203360", ax1Var);
                }
                Pair<Boolean, ky1> a = my1.a(ax1Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.requestFullScreen")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 G = ax1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                uw1 uw1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof uw1)) {
                    uw1Var = (uw1) obj;
                } else {
                    uw1Var = new uw1(this.mSwanApiContext);
                    this.mApis.put("-518757484", uw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(uw1Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.setClipboardData")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = uw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                dw2 dw2Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof dw2)) {
                    dw2Var = (dw2) obj;
                } else {
                    dw2Var = new dw2(this.mSwanApiContext);
                    this.mApis.put("1161486049", dw2Var);
                }
                Pair<Boolean, ky1> a = my1.a(dw2Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.setErrorPageType")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = dw2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                ex1 ex1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof ex1)) {
                    ex1Var = (ex1) obj;
                } else {
                    ex1Var = new ex1(this.mSwanApiContext);
                    this.mApis.put("447234992", ex1Var);
                }
                Pair<Boolean, ky1> a = my1.a(ex1Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.setMediaVolume")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 A = ex1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                sw1 sw1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof sw1)) {
                    sw1Var = (sw1) obj;
                } else {
                    sw1Var = new sw1(this.mSwanApiContext);
                    this.mApis.put("1372680763", sw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(sw1Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.startAccelerometer")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = sw1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                vw1 vw1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("1689255576", vw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(vw1Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.startCompass")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = vw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                tw1 tw1Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("99997465", tw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(tw1Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.getBrightness")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = tw1Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                uw1 uw1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof uw1)) {
                    uw1Var = (uw1) obj;
                } else {
                    uw1Var = new uw1(this.mSwanApiContext);
                    this.mApis.put("-518757484", uw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(uw1Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.getClipboardData")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = uw1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                ex1 ex1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof ex1)) {
                    ex1Var = (ex1) obj;
                } else {
                    ex1Var = new ex1(this.mSwanApiContext);
                    this.mApis.put("447234992", ex1Var);
                }
                Pair<Boolean, ky1> a = my1.a(ex1Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.getMediaVolume")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = ex1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                sw1 sw1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof sw1)) {
                    sw1Var = (sw1) obj;
                } else {
                    sw1Var = new sw1(this.mSwanApiContext);
                    this.mApis.put("1372680763", sw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(sw1Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.stopAccelerometer")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 C = sw1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                vw1 vw1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("1689255576", vw1Var);
                }
                Pair<Boolean, ky1> a = my1.a(vw1Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "System.stopCompass")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 A = vw1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naUtils", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                px1 px1Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof px1)) {
                    px1Var = (px1) obj;
                } else {
                    px1Var = new px1(this.mSwanApiContext);
                    this.mApis.put("201194468", px1Var);
                }
                Pair<Boolean, ky1> a = my1.a(px1Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.addToDesktop")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 C = px1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                lx1 lx1Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof lx1)) {
                    lx1Var = (lx1) obj;
                } else {
                    lx1Var = new lx1(this.mSwanApiContext);
                    this.mApis.put("-1412306947", lx1Var);
                }
                Pair<Boolean, ky1> a = my1.a(lx1Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.calcMD5")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = lx1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                mx1 mx1Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof mx1)) {
                    mx1Var = (mx1) obj;
                } else {
                    mx1Var = new mx1(this.mSwanApiContext);
                    this.mApis.put("1626415364", mx1Var);
                }
                Pair<Boolean, ky1> a = my1.a(mx1Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.checkAppInstalled")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = mx1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                ox1 ox1Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof ox1)) {
                    ox1Var = (ox1) obj;
                } else {
                    ox1Var = new ox1(this.mSwanApiContext);
                    this.mApis.put("-836768778", ox1Var);
                }
                Pair<Boolean, ky1> a = my1.a(ox1Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfo")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = ox1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                qx1 qx1Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("-810858308", qx1Var);
                }
                Pair<Boolean, ky1> a = my1.a(qx1Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.getPerformanceLevel")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = qx1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                ux1 ux1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", ux1Var);
                }
                Pair<Boolean, ky1> a = my1.a(ux1Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.getSystemInfoAsync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 J = ux1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                rx1 rx1Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof rx1)) {
                    rx1Var = (rx1) obj;
                } else {
                    rx1Var = new rx1(this.mSwanApiContext);
                    this.mApis.put("-2097727681", rx1Var);
                }
                Pair<Boolean, ky1> a = my1.a(rx1Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.handleException")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = rx1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                nx1 nx1Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof nx1)) {
                    nx1Var = (nx1) obj;
                } else {
                    nx1Var = new nx1(this.mSwanApiContext);
                    this.mApis.put("2084449317", nx1Var);
                }
                Pair<Boolean, ky1> a = my1.a(nx1Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.hasCloseHandler")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = nx1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                pa3 pa3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof pa3)) {
                    pa3Var = (pa3) obj;
                } else {
                    pa3Var = new pa3(this.mSwanApiContext);
                    this.mApis.put("1031678042", pa3Var);
                }
                Pair<Boolean, ky1> a = my1.a(pa3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.hideCaptureScreenShareDialog")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 y = pa3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                sx1 sx1Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof sx1)) {
                    sx1Var = (sx1) obj;
                } else {
                    sx1Var = new sx1(this.mSwanApiContext);
                    this.mApis.put("1751900130", sx1Var);
                }
                Pair<Boolean, ky1> a = my1.a(sx1Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.logToFile")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = sx1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                q93 q93Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof q93)) {
                    q93Var = (q93) obj;
                } else {
                    q93Var = new q93(this.mSwanApiContext);
                    this.mApis.put("1748196865", q93Var);
                }
                Pair<Boolean, ky1> a = my1.a(q93Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.preloadPackage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = q93Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                tx1 tx1Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof tx1)) {
                    tx1Var = (tx1) obj;
                } else {
                    tx1Var = new tx1(this.mSwanApiContext);
                    this.mApis.put("589529211", tx1Var);
                }
                Pair<Boolean, ky1> a = my1.a(tx1Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.previewImage")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 C = tx1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-577481801", wx1Var);
                }
                Pair<Boolean, ky1> a = my1.a(wx1Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.ubcFlowJar")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 J = wx1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                ux1 ux1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", ux1Var);
                }
                Pair<Boolean, ky1> a = my1.a(ux1Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfoSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 F = ux1Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                ux1 ux1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", ux1Var);
                }
                Pair<Boolean, ky1> a = my1.a(ux1Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.getSystemInfo")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 I = ux1Var.I();
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                ux1 ux1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", ux1Var);
                }
                Pair<Boolean, ky1> a = my1.a(ux1Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Utils.getSystemInfoSync")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 K = ux1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naWifi", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                ah3 ah3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ah3)) {
                    ah3Var = (ah3) obj;
                } else {
                    ah3Var = new ah3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ah3Var);
                }
                Pair<Boolean, ky1> a = my1.a(ah3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Wifi.connectWifi")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 B = ah3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                ah3 ah3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ah3)) {
                    ah3Var = (ah3) obj;
                } else {
                    ah3Var = new ah3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ah3Var);
                }
                Pair<Boolean, ky1> a = my1.a(ah3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Wifi.getConnectedWifi")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 C = ah3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                ah3 ah3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ah3)) {
                    ah3Var = (ah3) obj;
                } else {
                    ah3Var = new ah3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ah3Var);
                }
                Pair<Boolean, ky1> a = my1.a(ah3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Wifi.getWifiList")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 D = ah3Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                ah3 ah3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ah3)) {
                    ah3Var = (ah3) obj;
                } else {
                    ah3Var = new ah3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ah3Var);
                }
                Pair<Boolean, ky1> a = my1.a(ah3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Wifi.startWifi")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 H = ah3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                ah3 ah3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ah3)) {
                    ah3Var = (ah3) obj;
                } else {
                    ah3Var = new ah3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ah3Var);
                }
                Pair<Boolean, ky1> a = my1.a(ah3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "Wifi.stopWifi")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 I = ah3Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }
        });
        return hashMap;
    }
}
