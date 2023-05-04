package com.baidu.swan.apps.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.tieba.ak3;
import com.baidu.tieba.al2;
import com.baidu.tieba.aw1;
import com.baidu.tieba.ax1;
import com.baidu.tieba.az1;
import com.baidu.tieba.bw1;
import com.baidu.tieba.bx1;
import com.baidu.tieba.by1;
import com.baidu.tieba.bz1;
import com.baidu.tieba.cc3;
import com.baidu.tieba.cy1;
import com.baidu.tieba.cz1;
import com.baidu.tieba.db3;
import com.baidu.tieba.dw1;
import com.baidu.tieba.dz1;
import com.baidu.tieba.ea2;
import com.baidu.tieba.ew1;
import com.baidu.tieba.ex1;
import com.baidu.tieba.ey1;
import com.baidu.tieba.ez1;
import com.baidu.tieba.f33;
import com.baidu.tieba.fw1;
import com.baidu.tieba.fy1;
import com.baidu.tieba.fz1;
import com.baidu.tieba.gw1;
import com.baidu.tieba.gy1;
import com.baidu.tieba.gz1;
import com.baidu.tieba.hw1;
import com.baidu.tieba.hy1;
import com.baidu.tieba.iy1;
import com.baidu.tieba.iz1;
import com.baidu.tieba.jw1;
import com.baidu.tieba.jy1;
import com.baidu.tieba.k03;
import com.baidu.tieba.kx1;
import com.baidu.tieba.ky1;
import com.baidu.tieba.lw1;
import com.baidu.tieba.lx1;
import com.baidu.tieba.ly1;
import com.baidu.tieba.mw1;
import com.baidu.tieba.my1;
import com.baidu.tieba.ni3;
import com.baidu.tieba.nv1;
import com.baidu.tieba.ny1;
import com.baidu.tieba.oo1;
import com.baidu.tieba.ox2;
import com.baidu.tieba.pw1;
import com.baidu.tieba.px1;
import com.baidu.tieba.qa2;
import com.baidu.tieba.qx1;
import com.baidu.tieba.qx2;
import com.baidu.tieba.qy1;
import com.baidu.tieba.rw1;
import com.baidu.tieba.rx1;
import com.baidu.tieba.sw1;
import com.baidu.tieba.sx1;
import com.baidu.tieba.sy1;
import com.baidu.tieba.tw1;
import com.baidu.tieba.tx1;
import com.baidu.tieba.u03;
import com.baidu.tieba.ue3;
import com.baidu.tieba.uw1;
import com.baidu.tieba.vw1;
import com.baidu.tieba.vx1;
import com.baidu.tieba.vz1;
import com.baidu.tieba.ww1;
import com.baidu.tieba.wx1;
import com.baidu.tieba.wz1;
import com.baidu.tieba.xw1;
import com.baidu.tieba.xy1;
import com.baidu.tieba.xz1;
import com.baidu.tieba.yb2;
import com.baidu.tieba.yv1;
import com.baidu.tieba.yw1;
import com.baidu.tieba.yx1;
import com.baidu.tieba.yy1;
import com.baidu.tieba.yz1;
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
    public static Map<String, Object> getV8ApiModules(final yv1 yv1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                ew1 ew1Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof ew1)) {
                    ew1Var = (ew1) obj;
                } else {
                    ew1Var = new ew1(this.mSwanApiContext);
                    this.mApis.put("1930258908", ew1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ew1Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Account.checkSession")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = ew1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                fw1 fw1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof fw1)) {
                    fw1Var = (fw1) obj;
                } else {
                    fw1Var = new fw1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", fw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(fw1Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Account.getLoginCode")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 C = fw1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                gw1 gw1Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof gw1)) {
                    gw1Var = (gw1) obj;
                } else {
                    gw1Var = new gw1(this.mSwanApiContext);
                    this.mApis.put("1754780133", gw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(gw1Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Account.getOpenId")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = gw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                nv1 nv1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof nv1)) {
                    nv1Var = (nv1) obj;
                } else {
                    nv1Var = new nv1(this.mSwanApiContext);
                    this.mApis.put("-343998465", nv1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(nv1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Account.getUnionBDUSS")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = nv1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String login(String str) {
                fw1 fw1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof fw1)) {
                    fw1Var = (fw1) obj;
                } else {
                    fw1Var = new fw1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", fw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(fw1Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Account.login")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 I = fw1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                dw1 dw1Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof dw1)) {
                    dw1Var = (dw1) obj;
                } else {
                    dw1Var = new dw1(this.mSwanApiContext);
                    this.mApis.put("-337742792", dw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(dw1Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Account.isBaiduAccountSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = dw1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                fw1 fw1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof fw1)) {
                    fw1Var = (fw1) obj;
                } else {
                    fw1Var = new fw1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", fw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(fw1Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Account.isLoginSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 H = fw1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBasic", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                hw1 hw1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof hw1)) {
                    hw1Var = (hw1) obj;
                } else {
                    hw1Var = new hw1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", hw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(hw1Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Basic.loadSubPackage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 F = hw1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                hw1 hw1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof hw1)) {
                    hw1Var = (hw1) obj;
                } else {
                    hw1Var = new hw1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", hw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(hw1Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Basic.loadSubPackages")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 G = hw1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                oo1 oo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof oo1)) {
                    oo1Var = (oo1) obj;
                } else {
                    oo1Var = new oo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", oo1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(oo1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Bookshelf.deleteBookshelf")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 K = oo1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                oo1 oo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof oo1)) {
                    oo1Var = (oo1) obj;
                } else {
                    oo1Var = new oo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", oo1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(oo1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Bookshelf.insertBookshelf")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 P = oo1Var.P(str);
                if (P == null) {
                    return "";
                }
                return P.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                oo1 oo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof oo1)) {
                    oo1Var = (oo1) obj;
                } else {
                    oo1Var = new oo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", oo1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(oo1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Bookshelf.navigateToBookshelf")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 U = oo1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                oo1 oo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof oo1)) {
                    oo1Var = (oo1) obj;
                } else {
                    oo1Var = new oo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", oo1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(oo1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Bookshelf.queryBookshelf")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 V = oo1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                oo1 oo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof oo1)) {
                    oo1Var = (oo1) obj;
                } else {
                    oo1Var = new oo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", oo1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(oo1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Bookshelf.updateBookshelfReadTime")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 X = oo1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naCoupon", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                bw1 bw1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof bw1)) {
                    bw1Var = (bw1) obj;
                } else {
                    bw1Var = new bw1(this.mSwanApiContext);
                    this.mApis.put("-277316359", bw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(bw1Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Coupon.getPlatformCoupons")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = bw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                bw1 bw1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof bw1)) {
                    bw1Var = (bw1) obj;
                } else {
                    bw1Var = new bw1(this.mSwanApiContext);
                    this.mApis.put("-277316359", bw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(bw1Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Coupon.getUserCoupons")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 z = bw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                bw1 bw1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof bw1)) {
                    bw1Var = (bw1) obj;
                } else {
                    bw1Var = new bw1(this.mSwanApiContext);
                    this.mApis.put("-277316359", bw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(bw1Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Coupon.takeCoupons")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 C = bw1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naFavorite", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-1225406515", jw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(jw1Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Favorite.getFavorStatus")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = jw1Var.x(str);
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
                Pair<Boolean, wz1> a = yz1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Favorite.showFavoriteGuide")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 G = showFavoriteGuideApi.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naFile", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                lw1 lw1Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof lw1)) {
                    lw1Var = (lw1) obj;
                } else {
                    lw1Var = new lw1(this.mSwanApiContext);
                    this.mApis.put("-2057135077", lw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(lw1Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "File.shareFile")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = lw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                al2 al2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof al2)) {
                    al2Var = (al2) obj;
                } else {
                    al2Var = new al2(this.mSwanApiContext);
                    this.mApis.put("2077414795", al2Var);
                }
                Pair<Boolean, wz1> a = yz1.a(al2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = al2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                al2 al2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof al2)) {
                    al2Var = (al2) obj;
                } else {
                    al2Var = new al2(this.mSwanApiContext);
                    this.mApis.put("2077414795", al2Var);
                }
                Pair<Boolean, wz1> a = yz1.a(al2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessageSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = al2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String download(String str) {
                mw1 mw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", mw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(mw1Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "HostDownloadManager.download")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = mw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                mw1 mw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", mw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(mw1Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "HostDownloadManager.openFile")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 z = mw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String query(String str) {
                mw1 mw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", mw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(mw1Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "HostDownloadManager.query")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 query = mw1Var.query(str);
                if (query == null) {
                    return "";
                }
                return query.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                mw1 mw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", mw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(mw1Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "HostDownloadManager.openDownloadCenter")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = mw1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naImage", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                ox2 ox2Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof ox2)) {
                    ox2Var = (ox2) obj;
                } else {
                    ox2Var = new ox2(this.mSwanApiContext);
                    this.mApis.put("1445003743", ox2Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ox2Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Image.callImageMenu")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = ox2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                pw1 pw1Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof pw1)) {
                    pw1Var = (pw1) obj;
                } else {
                    pw1Var = new pw1(this.mSwanApiContext);
                    this.mApis.put("-1252730367", pw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(pw1Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Image.compressImage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = pw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naInteraction", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                xw1 xw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof xw1)) {
                    xw1Var = (xw1) obj;
                } else {
                    xw1Var = new xw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", xw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(xw1Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.closeTabBar")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = xw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                xw1 xw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof xw1)) {
                    xw1Var = (xw1) obj;
                } else {
                    xw1Var = new xw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", xw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(xw1Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.closeTabBarRedDot")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = xw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", tw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(tw1Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.hideNavigationBarLoading")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = tw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                vw1 vw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", vw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(vw1Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.openMultiPicker")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 G = vw1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                vw1 vw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", vw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(vw1Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.openPicker")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 H = vw1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                xw1 xw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof xw1)) {
                    xw1Var = (xw1) obj;
                } else {
                    xw1Var = new xw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", xw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(xw1Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.openTabBar")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 C = xw1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                uw1 uw1Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof uw1)) {
                    uw1Var = (uw1) obj;
                } else {
                    uw1Var = new uw1(this.mSwanApiContext);
                    this.mApis.put("-1750613704", uw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(uw1Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.pageScrollTo")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = uw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", tw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(tw1Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarColor")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 z = tw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", tw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(tw1Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarTitle")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = tw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                xw1 xw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof xw1)) {
                    xw1Var = (xw1) obj;
                } else {
                    xw1Var = new xw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", xw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(xw1Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.setTabBarItem")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 D = xw1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                vw1 vw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", vw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(vw1Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.showDatePickerView")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 L = vw1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                zw1 zw1Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof zw1)) {
                    zw1Var = (zw1) obj;
                } else {
                    zw1Var = new zw1(this.mSwanApiContext);
                    this.mApis.put("1172469410", zw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(zw1Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.showHalfScreenWebview")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 K = zw1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                rw1 rw1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("5236036", rw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(rw1Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.showLoading")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = rw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                sw1 sw1Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof sw1)) {
                    sw1Var = (sw1) obj;
                } else {
                    sw1Var = new sw1(this.mSwanApiContext);
                    this.mApis.put("1913747800", sw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(sw1Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.showModal")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = sw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", tw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(tw1Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.showNavigationBarLoading")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 B = tw1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                yw1 yw1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof yw1)) {
                    yw1Var = (yw1) obj;
                } else {
                    yw1Var = new yw1(this.mSwanApiContext);
                    this.mApis.put("1159492510", yw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yw1Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.showToast")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 Q = yw1Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                ww1 ww1Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof ww1)) {
                    ww1Var = (ww1) obj;
                } else {
                    ww1Var = new ww1(this.mSwanApiContext);
                    this.mApis.put("1165118609", ww1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ww1Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.stopPullDownRefresh")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = ww1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                vw1 vw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", vw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(vw1Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.updateMultiPicker")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 M = vw1Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                rw1 rw1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("5236036", rw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(rw1Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.hideLoading")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = rw1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hideToast() {
                yw1 yw1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof yw1)) {
                    yw1Var = (yw1) obj;
                } else {
                    yw1Var = new yw1(this.mSwanApiContext);
                    this.mApis.put("1159492510", yw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yw1Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.hideToast")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 K = yw1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                ax1 ax1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof ax1)) {
                    ax1Var = (ax1) obj;
                } else {
                    ax1Var = new ax1(this.mSwanApiContext);
                    this.mApis.put("-137346255", ax1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ax1Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Keyboard.startKeyboardHeightChange")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 C = ax1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                ax1 ax1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof ax1)) {
                    ax1Var = (ax1) obj;
                } else {
                    ax1Var = new ax1(this.mSwanApiContext);
                    this.mApis.put("-137346255", ax1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ax1Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Keyboard.stopKeyboardHeightChange")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 D = ax1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naLocationService", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                bx1 bx1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof bx1)) {
                    bx1Var = (bx1) obj;
                } else {
                    bx1Var = new bx1(this.mSwanApiContext);
                    this.mApis.put("-397373095", bx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(bx1Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "LocationService.getLocation")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = bx1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                bx1 bx1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof bx1)) {
                    bx1Var = (bx1) obj;
                } else {
                    bx1Var = new bx1(this.mSwanApiContext);
                    this.mApis.put("-397373095", bx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(bx1Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "LocationService.startLocationUpdate")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = bx1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                bx1 bx1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof bx1)) {
                    bx1Var = (bx1) obj;
                } else {
                    bx1Var = new bx1(this.mSwanApiContext);
                    this.mApis.put("-397373095", bx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(bx1Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "LocationService.stopLocationUpdate")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 B = bx1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naMenu", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                sy1 sy1Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof sy1)) {
                    sy1Var = (sy1) obj;
                } else {
                    sy1Var = new sy1(this.mSwanApiContext);
                    this.mApis.put("538070032", sy1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(sy1Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = sy1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naNetwork", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                ex1 ex1Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof ex1)) {
                    ex1Var = (ex1) obj;
                } else {
                    ex1Var = new ex1(this.mSwanApiContext);
                    this.mApis.put("-1076509454", ex1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ex1Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Network.callService")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = ex1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                lx1 lx1Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof lx1)) {
                    lx1Var = (lx1) obj;
                } else {
                    lx1Var = new lx1(this.mSwanApiContext);
                    this.mApis.put("968563034", lx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(lx1Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Network.cancelRequest")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 D = lx1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                kx1 kx1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof kx1)) {
                    kx1Var = (kx1) obj;
                } else {
                    kx1Var = new kx1(this.mSwanApiContext);
                    this.mApis.put("453220699", kx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(kx1Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Network.networkStatusChange")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = kx1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                kx1 kx1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof kx1)) {
                    kx1Var = (kx1) obj;
                } else {
                    kx1Var = new kx1(this.mSwanApiContext);
                    this.mApis.put("453220699", kx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(kx1Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Network.getNetworkType")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = kx1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(JsObject jsObject) {
                lx1 lx1Var;
                String a;
                try {
                    vz1.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof lx1)) {
                        lx1Var = (lx1) obj;
                    } else {
                        lx1Var = new lx1(this.mSwanApiContext);
                        this.mApis.put("968563034", lx1Var);
                    }
                    Pair<Boolean, wz1> a2 = yz1.a(lx1Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((wz1) a2.second).a();
                    } else if (ea2.a(this.mSwanApiContext.e(), "Network.request")) {
                        a = new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<wz1, JSONObject> t = aw1.t(jsObject);
                        if (!((wz1) t.first).isSuccess()) {
                            a = ((wz1) t.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) t.second;
                            if (jSONObject == null) {
                                a = wz1.a.a();
                            } else {
                                xz1 V = lx1Var.V(jSONObject);
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
                        vz1.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                u03 u03Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof u03)) {
                    u03Var = (u03) obj;
                } else {
                    u03Var = new u03(this.mSwanApiContext);
                    this.mApis.put("-336396851", u03Var);
                }
                Pair<Boolean, wz1> a = yz1.a(u03Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Payment.chooseCoupon")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = u03Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                u03 u03Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof u03)) {
                    u03Var = (u03) obj;
                } else {
                    u03Var = new u03(this.mSwanApiContext);
                    this.mApis.put("-336396851", u03Var);
                }
                Pair<Boolean, wz1> a = yz1.a(u03Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Payment.getPaymentInfo")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = u03Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                k03 k03Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof k03)) {
                    k03Var = (k03) obj;
                } else {
                    k03Var = new k03(this.mSwanApiContext);
                    this.mApis.put("1854689529", k03Var);
                }
                Pair<Boolean, wz1> a = yz1.a(k03Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Payment.requestThirdPayment")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = k03Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                u03 u03Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof u03)) {
                    u03Var = (u03) obj;
                } else {
                    u03Var = new u03(this.mSwanApiContext);
                    this.mApis.put("-336396851", u03Var);
                }
                Pair<Boolean, wz1> a = yz1.a(u03Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Payment.setPaymentInfo")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 z = u03Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPlugin", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                f33 f33Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof f33)) {
                    f33Var = (f33) obj;
                } else {
                    f33Var = new f33(this.mSwanApiContext);
                    this.mApis.put("-254510461", f33Var);
                }
                Pair<Boolean, wz1> a = yz1.a(f33Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Plugin.invokePluginChooseAddress")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = f33Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                f33 f33Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof f33)) {
                    f33Var = (f33) obj;
                } else {
                    f33Var = new f33(this.mSwanApiContext);
                    this.mApis.put("-254510461", f33Var);
                }
                Pair<Boolean, wz1> a = yz1.a(f33Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 z = f33Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                f33 f33Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof f33)) {
                    f33Var = (f33) obj;
                } else {
                    f33Var = new f33(this.mSwanApiContext);
                    this.mApis.put("-254510461", f33Var);
                }
                Pair<Boolean, wz1> a = yz1.a(f33Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Plugin.invokePluginPayment")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = f33Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                yb2 yb2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof yb2)) {
                    yb2Var = (yb2) obj;
                } else {
                    yb2Var = new yb2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", yb2Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yb2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Prefetch.prefetchResources")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = yb2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPreload", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                qa2 qa2Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof qa2)) {
                    qa2Var = (qa2) obj;
                } else {
                    qa2Var = new qa2(this.mSwanApiContext);
                    this.mApis.put("423661539", qa2Var);
                }
                Pair<Boolean, wz1> a = yz1.a(qa2Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Preload.preloadStatus")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = qa2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                ak3 ak3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof ak3)) {
                    ak3Var = (ak3) obj;
                } else {
                    ak3Var = new ak3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", ak3Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ak3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "PrivateFile.uploadFileToBos")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 C = ak3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naRouter", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                px1 px1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof px1)) {
                    px1Var = (px1) obj;
                } else {
                    px1Var = new px1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", px1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(px1Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Router.hideModalPage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = px1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                px1 px1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof px1)) {
                    px1Var = (px1) obj;
                } else {
                    px1Var = new px1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", px1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(px1Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Router.navigateBack")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 B = px1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                qx1 qx1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("1968522584", qx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(qx1Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Router.navigateTo")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 H = qx1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                sx1 sx1Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof sx1)) {
                    sx1Var = (sx1) obj;
                } else {
                    sx1Var = new sx1(this.mSwanApiContext);
                    this.mApis.put("1317280190", sx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(sx1Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Router.reLaunch")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = sx1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                tx1 tx1Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof tx1)) {
                    tx1Var = (tx1) obj;
                } else {
                    tx1Var = new tx1(this.mSwanApiContext);
                    this.mApis.put("-420075743", tx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(tx1Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Router.reLoadErrorPage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = tx1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                rx1 rx1Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof rx1)) {
                    rx1Var = (rx1) obj;
                } else {
                    rx1Var = new rx1(this.mSwanApiContext);
                    this.mApis.put("1792515533", rx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(rx1Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Router.redirectTo")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 D = rx1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                qx1 qx1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("1968522584", qx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(qx1Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Router.showModalPage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 J = qx1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naSetting", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                wx1 wx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", wx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(wx1Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Setting.getAppInfoSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 F = wx1Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                wx1 wx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", wx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(wx1Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Setting.getSlaveIdSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 H = wx1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                vx1 vx1Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("450273045", vx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(vx1Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Setting.isAllowedAdOpenAppSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = vx1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", wx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(wx1Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Setting.getSetting")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 G = wx1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", wx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(wx1Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Setting.getSwanId")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 I = wx1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", wx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(wx1Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Setting.getUserInfo")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 J = wx1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                ue3 ue3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof ue3)) {
                    ue3Var = (ue3) obj;
                } else {
                    ue3Var = new ue3(this.mSwanApiContext);
                    this.mApis.put("712777136", ue3Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ue3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = ue3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naStorage", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                zx1 zx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof zx1)) {
                    zx1Var = (zx1) obj;
                } else {
                    zx1Var = new zx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", zx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(zx1Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = zx1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                zx1 zx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof zx1)) {
                    zx1Var = (zx1) obj;
                } else {
                    zx1Var = new zx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", zx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(zx1Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorageSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 C = zx1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                yx1 yx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("130910081", yx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yx1Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.clearStorage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = yx1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                yx1 yx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("130910081", yx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yx1Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.clearStorageSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 C = yx1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                zx1 zx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof zx1)) {
                    zx1Var = (zx1) obj;
                } else {
                    zx1Var = new zx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", zx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(zx1Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfo")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 G = zx1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                zx1 zx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof zx1)) {
                    zx1Var = (zx1) obj;
                } else {
                    zx1Var = new zx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", zx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(zx1Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfoSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 J = zx1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                yx1 yx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("130910081", yx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yx1Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.getStorageInfo")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 G = yx1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                yx1 yx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("130910081", yx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yx1Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.getStorageInfoSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 J = yx1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                zx1 zx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof zx1)) {
                    zx1Var = (zx1) obj;
                } else {
                    zx1Var = new zx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", zx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(zx1Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.getGlobalStorage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 D = zx1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                zx1 zx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof zx1)) {
                    zx1Var = (zx1) obj;
                } else {
                    zx1Var = new zx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", zx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(zx1Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 K = zx1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                yx1 yx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("130910081", yx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yx1Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.getStorage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 D = yx1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                yx1 yx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("130910081", yx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yx1Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.getStorageInfoAsync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 H = yx1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                yx1 yx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("130910081", yx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yx1Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.getStorageSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 K = yx1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                zx1 zx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof zx1)) {
                    zx1Var = (zx1) obj;
                } else {
                    zx1Var = new zx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", zx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(zx1Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 R = zx1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                zx1 zx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof zx1)) {
                    zx1Var = (zx1) obj;
                } else {
                    zx1Var = new zx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", zx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(zx1Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorageSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 T = zx1Var.T(str);
                if (T == null) {
                    return "";
                }
                return T.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                yx1 yx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("130910081", yx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yx1Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.removeStorage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 R = yx1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                yx1 yx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("130910081", yx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yx1Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.removeStorageSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 T = yx1Var.T(str);
                if (T == null) {
                    return "";
                }
                return T.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                zx1 zx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof zx1)) {
                    zx1Var = (zx1) obj;
                } else {
                    zx1Var = new zx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", zx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(zx1Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.setGlobalStorage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 U = zx1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                zx1 zx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof zx1)) {
                    zx1Var = (zx1) obj;
                } else {
                    zx1Var = new zx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", zx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(zx1Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.setGlobalStorageSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 W = zx1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                yx1 yx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("130910081", yx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yx1Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.setStorage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 U = yx1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                yx1 yx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("130910081", yx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yx1Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.setStorageSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 W = yx1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }
        });
        hashMap.put("_naSubscription", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                by1 by1Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof by1)) {
                    by1Var = (by1) obj;
                } else {
                    by1Var = new by1(this.mSwanApiContext);
                    this.mApis.put("823117982", by1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(by1Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Subscription.requestSubscribeFormId")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 E = by1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                cy1 cy1Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof cy1)) {
                    cy1Var = (cy1) obj;
                } else {
                    cy1Var = new cy1(this.mSwanApiContext);
                    this.mApis.put("-947445811", cy1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(cy1Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Subscription.subscribeService")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 F = cy1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }
        });
        hashMap.put("_naSystem", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                jy1 jy1Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof jy1)) {
                    jy1Var = (jy1) obj;
                } else {
                    jy1Var = new jy1(this.mSwanApiContext);
                    this.mApis.put("1936205521", jy1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(jy1Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.exitFullScreen")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = jy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                iy1 iy1Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof iy1)) {
                    iy1Var = (iy1) obj;
                } else {
                    iy1Var = new iy1(this.mSwanApiContext);
                    this.mApis.put("1694151270", iy1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(iy1Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.getDeviceInfo")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = iy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                ky1 ky1Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof ky1)) {
                    ky1Var = (ky1) obj;
                } else {
                    ky1Var = new ky1(this.mSwanApiContext);
                    this.mApis.put("-1321681619", ky1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ky1Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.getDeviceProfile")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = ky1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                ly1 ly1Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof ly1)) {
                    ly1Var = (ly1) obj;
                } else {
                    ly1Var = new ly1(this.mSwanApiContext);
                    this.mApis.put("-1569246082", ly1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ly1Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.makePhoneCall")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = ly1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                ny1 ny1Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof ny1)) {
                    ny1Var = (ny1) obj;
                } else {
                    ny1Var = new ny1(this.mSwanApiContext);
                    this.mApis.put("1099851202", ny1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ny1Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.openSMSPanel")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = ny1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                my1 my1Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof my1)) {
                    my1Var = (my1) obj;
                } else {
                    my1Var = new my1(this.mSwanApiContext);
                    this.mApis.put("-1707203360", my1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(my1Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.requestFullScreen")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 F = my1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                gy1 gy1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof gy1)) {
                    gy1Var = (gy1) obj;
                } else {
                    gy1Var = new gy1(this.mSwanApiContext);
                    this.mApis.put("-518757484", gy1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(gy1Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.setClipboardData")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = gy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                qx2 qx2Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof qx2)) {
                    qx2Var = (qx2) obj;
                } else {
                    qx2Var = new qx2(this.mSwanApiContext);
                    this.mApis.put("1161486049", qx2Var);
                }
                Pair<Boolean, wz1> a = yz1.a(qx2Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.setErrorPageType")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = qx2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                qy1 qy1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof qy1)) {
                    qy1Var = (qy1) obj;
                } else {
                    qy1Var = new qy1(this.mSwanApiContext);
                    this.mApis.put("447234992", qy1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(qy1Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.setMediaVolume")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 z = qy1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                ey1 ey1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof ey1)) {
                    ey1Var = (ey1) obj;
                } else {
                    ey1Var = new ey1(this.mSwanApiContext);
                    this.mApis.put("1372680763", ey1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ey1Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.startAccelerometer")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = ey1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                hy1 hy1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof hy1)) {
                    hy1Var = (hy1) obj;
                } else {
                    hy1Var = new hy1(this.mSwanApiContext);
                    this.mApis.put("1689255576", hy1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(hy1Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.startCompass")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = hy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                fy1 fy1Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof fy1)) {
                    fy1Var = (fy1) obj;
                } else {
                    fy1Var = new fy1(this.mSwanApiContext);
                    this.mApis.put("99997465", fy1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(fy1Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.getBrightness")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = fy1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                gy1 gy1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof gy1)) {
                    gy1Var = (gy1) obj;
                } else {
                    gy1Var = new gy1(this.mSwanApiContext);
                    this.mApis.put("-518757484", gy1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(gy1Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.getClipboardData")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = gy1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                qy1 qy1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof qy1)) {
                    qy1Var = (qy1) obj;
                } else {
                    qy1Var = new qy1(this.mSwanApiContext);
                    this.mApis.put("447234992", qy1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(qy1Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.getMediaVolume")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = qy1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                ey1 ey1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof ey1)) {
                    ey1Var = (ey1) obj;
                } else {
                    ey1Var = new ey1(this.mSwanApiContext);
                    this.mApis.put("1372680763", ey1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ey1Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.stopAccelerometer")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 B = ey1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                hy1 hy1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof hy1)) {
                    hy1Var = (hy1) obj;
                } else {
                    hy1Var = new hy1(this.mSwanApiContext);
                    this.mApis.put("1689255576", hy1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(hy1Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.stopCompass")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 z = hy1Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naUtils", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                bz1 bz1Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof bz1)) {
                    bz1Var = (bz1) obj;
                } else {
                    bz1Var = new bz1(this.mSwanApiContext);
                    this.mApis.put("201194468", bz1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(bz1Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.addToDesktop")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 B = bz1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                xy1 xy1Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof xy1)) {
                    xy1Var = (xy1) obj;
                } else {
                    xy1Var = new xy1(this.mSwanApiContext);
                    this.mApis.put("-1412306947", xy1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(xy1Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.calcMD5")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = xy1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                yy1 yy1Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof yy1)) {
                    yy1Var = (yy1) obj;
                } else {
                    yy1Var = new yy1(this.mSwanApiContext);
                    this.mApis.put("1626415364", yy1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yy1Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.checkAppInstalled")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = yy1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                az1 az1Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof az1)) {
                    az1Var = (az1) obj;
                } else {
                    az1Var = new az1(this.mSwanApiContext);
                    this.mApis.put("-836768778", az1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(az1Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfo")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = az1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                cz1 cz1Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof cz1)) {
                    cz1Var = (cz1) obj;
                } else {
                    cz1Var = new cz1(this.mSwanApiContext);
                    this.mApis.put("-810858308", cz1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(cz1Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.getPerformanceLevel")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = cz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                gz1 gz1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof gz1)) {
                    gz1Var = (gz1) obj;
                } else {
                    gz1Var = new gz1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", gz1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(gz1Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.getSystemInfoAsync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 I = gz1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                dz1 dz1Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof dz1)) {
                    dz1Var = (dz1) obj;
                } else {
                    dz1Var = new dz1(this.mSwanApiContext);
                    this.mApis.put("-2097727681", dz1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(dz1Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.handleException")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = dz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                zy1 zy1Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof zy1)) {
                    zy1Var = (zy1) obj;
                } else {
                    zy1Var = new zy1(this.mSwanApiContext);
                    this.mApis.put("2084449317", zy1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(zy1Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.hasCloseHandler")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = zy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                cc3 cc3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof cc3)) {
                    cc3Var = (cc3) obj;
                } else {
                    cc3Var = new cc3(this.mSwanApiContext);
                    this.mApis.put("1031678042", cc3Var);
                }
                Pair<Boolean, wz1> a = yz1.a(cc3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.hideCaptureScreenShareDialog")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = cc3Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                ez1 ez1Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof ez1)) {
                    ez1Var = (ez1) obj;
                } else {
                    ez1Var = new ez1(this.mSwanApiContext);
                    this.mApis.put("1751900130", ez1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ez1Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.logToFile")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = ez1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                db3 db3Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof db3)) {
                    db3Var = (db3) obj;
                } else {
                    db3Var = new db3(this.mSwanApiContext);
                    this.mApis.put("1748196865", db3Var);
                }
                Pair<Boolean, wz1> a = yz1.a(db3Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.preloadPackage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = db3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                fz1 fz1Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof fz1)) {
                    fz1Var = (fz1) obj;
                } else {
                    fz1Var = new fz1(this.mSwanApiContext);
                    this.mApis.put("589529211", fz1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(fz1Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.previewImage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 B = fz1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                iz1 iz1Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof iz1)) {
                    iz1Var = (iz1) obj;
                } else {
                    iz1Var = new iz1(this.mSwanApiContext);
                    this.mApis.put("-577481801", iz1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(iz1Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.ubcFlowJar")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 I = iz1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                gz1 gz1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof gz1)) {
                    gz1Var = (gz1) obj;
                } else {
                    gz1Var = new gz1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", gz1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(gz1Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfoSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 E = gz1Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                gz1 gz1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof gz1)) {
                    gz1Var = (gz1) obj;
                } else {
                    gz1Var = new gz1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", gz1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(gz1Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.getSystemInfo")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 H = gz1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                gz1 gz1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof gz1)) {
                    gz1Var = (gz1) obj;
                } else {
                    gz1Var = new gz1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", gz1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(gz1Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.getSystemInfoSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 J = gz1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naWifi", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                ni3 ni3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ni3)) {
                    ni3Var = (ni3) obj;
                } else {
                    ni3Var = new ni3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ni3Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ni3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Wifi.connectWifi")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = ni3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                ni3 ni3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ni3)) {
                    ni3Var = (ni3) obj;
                } else {
                    ni3Var = new ni3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ni3Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ni3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Wifi.getConnectedWifi")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 B = ni3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                ni3 ni3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ni3)) {
                    ni3Var = (ni3) obj;
                } else {
                    ni3Var = new ni3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ni3Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ni3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Wifi.getWifiList")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 C = ni3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                ni3 ni3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ni3)) {
                    ni3Var = (ni3) obj;
                } else {
                    ni3Var = new ni3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ni3Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ni3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Wifi.startWifi")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 G = ni3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                ni3 ni3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ni3)) {
                    ni3Var = (ni3) obj;
                } else {
                    ni3Var = new ni3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ni3Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ni3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Wifi.stopWifi")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 H = ni3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final yv1 yv1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                ew1 ew1Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof ew1)) {
                    ew1Var = (ew1) obj;
                } else {
                    ew1Var = new ew1(this.mSwanApiContext);
                    this.mApis.put("1930258908", ew1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ew1Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Account.checkSession")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = ew1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                fw1 fw1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof fw1)) {
                    fw1Var = (fw1) obj;
                } else {
                    fw1Var = new fw1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", fw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(fw1Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Account.getLoginCode")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 C = fw1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                gw1 gw1Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof gw1)) {
                    gw1Var = (gw1) obj;
                } else {
                    gw1Var = new gw1(this.mSwanApiContext);
                    this.mApis.put("1754780133", gw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(gw1Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Account.getOpenId")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = gw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                nv1 nv1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof nv1)) {
                    nv1Var = (nv1) obj;
                } else {
                    nv1Var = new nv1(this.mSwanApiContext);
                    this.mApis.put("-343998465", nv1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(nv1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Account.getUnionBDUSS")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = nv1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String login(String str) {
                fw1 fw1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof fw1)) {
                    fw1Var = (fw1) obj;
                } else {
                    fw1Var = new fw1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", fw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(fw1Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Account.login")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 I = fw1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                dw1 dw1Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof dw1)) {
                    dw1Var = (dw1) obj;
                } else {
                    dw1Var = new dw1(this.mSwanApiContext);
                    this.mApis.put("-337742792", dw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(dw1Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Account.isBaiduAccountSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = dw1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                fw1 fw1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof fw1)) {
                    fw1Var = (fw1) obj;
                } else {
                    fw1Var = new fw1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", fw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(fw1Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Account.isLoginSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 H = fw1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBasic", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                hw1 hw1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof hw1)) {
                    hw1Var = (hw1) obj;
                } else {
                    hw1Var = new hw1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", hw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(hw1Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Basic.loadSubPackage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 F = hw1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                hw1 hw1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof hw1)) {
                    hw1Var = (hw1) obj;
                } else {
                    hw1Var = new hw1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", hw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(hw1Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Basic.loadSubPackages")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 G = hw1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                oo1 oo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof oo1)) {
                    oo1Var = (oo1) obj;
                } else {
                    oo1Var = new oo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", oo1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(oo1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Bookshelf.deleteBookshelf")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 K = oo1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                oo1 oo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof oo1)) {
                    oo1Var = (oo1) obj;
                } else {
                    oo1Var = new oo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", oo1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(oo1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Bookshelf.insertBookshelf")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 P = oo1Var.P(str);
                if (P == null) {
                    return "";
                }
                return P.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                oo1 oo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof oo1)) {
                    oo1Var = (oo1) obj;
                } else {
                    oo1Var = new oo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", oo1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(oo1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Bookshelf.navigateToBookshelf")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 U = oo1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                oo1 oo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof oo1)) {
                    oo1Var = (oo1) obj;
                } else {
                    oo1Var = new oo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", oo1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(oo1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Bookshelf.queryBookshelf")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 V = oo1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                oo1 oo1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof oo1)) {
                    oo1Var = (oo1) obj;
                } else {
                    oo1Var = new oo1(this.mSwanApiContext);
                    this.mApis.put("1460300387", oo1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(oo1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Bookshelf.updateBookshelfReadTime")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 X = oo1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naCoupon", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                bw1 bw1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof bw1)) {
                    bw1Var = (bw1) obj;
                } else {
                    bw1Var = new bw1(this.mSwanApiContext);
                    this.mApis.put("-277316359", bw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(bw1Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Coupon.getPlatformCoupons")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = bw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                bw1 bw1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof bw1)) {
                    bw1Var = (bw1) obj;
                } else {
                    bw1Var = new bw1(this.mSwanApiContext);
                    this.mApis.put("-277316359", bw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(bw1Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Coupon.getUserCoupons")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 z = bw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                bw1 bw1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof bw1)) {
                    bw1Var = (bw1) obj;
                } else {
                    bw1Var = new bw1(this.mSwanApiContext);
                    this.mApis.put("-277316359", bw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(bw1Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Coupon.takeCoupons")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 C = bw1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naFavorite", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                jw1 jw1Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof jw1)) {
                    jw1Var = (jw1) obj;
                } else {
                    jw1Var = new jw1(this.mSwanApiContext);
                    this.mApis.put("-1225406515", jw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(jw1Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Favorite.getFavorStatus")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = jw1Var.x(str);
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
                Pair<Boolean, wz1> a = yz1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Favorite.showFavoriteGuide")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 G = showFavoriteGuideApi.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naFile", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                lw1 lw1Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof lw1)) {
                    lw1Var = (lw1) obj;
                } else {
                    lw1Var = new lw1(this.mSwanApiContext);
                    this.mApis.put("-2057135077", lw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(lw1Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "File.shareFile")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = lw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                al2 al2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof al2)) {
                    al2Var = (al2) obj;
                } else {
                    al2Var = new al2(this.mSwanApiContext);
                    this.mApis.put("2077414795", al2Var);
                }
                Pair<Boolean, wz1> a = yz1.a(al2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = al2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                al2 al2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof al2)) {
                    al2Var = (al2) obj;
                } else {
                    al2Var = new al2(this.mSwanApiContext);
                    this.mApis.put("2077414795", al2Var);
                }
                Pair<Boolean, wz1> a = yz1.a(al2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessageSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = al2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String download(String str) {
                mw1 mw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", mw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(mw1Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "HostDownloadManager.download")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = mw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                mw1 mw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", mw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(mw1Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "HostDownloadManager.openFile")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 z = mw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String query(String str) {
                mw1 mw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", mw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(mw1Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "HostDownloadManager.query")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 query = mw1Var.query(str);
                if (query == null) {
                    return "";
                }
                return query.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                mw1 mw1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof mw1)) {
                    mw1Var = (mw1) obj;
                } else {
                    mw1Var = new mw1(this.mSwanApiContext);
                    this.mApis.put("-170124576", mw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(mw1Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "HostDownloadManager.openDownloadCenter")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = mw1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naImage", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                ox2 ox2Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof ox2)) {
                    ox2Var = (ox2) obj;
                } else {
                    ox2Var = new ox2(this.mSwanApiContext);
                    this.mApis.put("1445003743", ox2Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ox2Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Image.callImageMenu")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = ox2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                pw1 pw1Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof pw1)) {
                    pw1Var = (pw1) obj;
                } else {
                    pw1Var = new pw1(this.mSwanApiContext);
                    this.mApis.put("-1252730367", pw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(pw1Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Image.compressImage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = pw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naInteraction", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                xw1 xw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof xw1)) {
                    xw1Var = (xw1) obj;
                } else {
                    xw1Var = new xw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", xw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(xw1Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.closeTabBar")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = xw1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                xw1 xw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof xw1)) {
                    xw1Var = (xw1) obj;
                } else {
                    xw1Var = new xw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", xw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(xw1Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.closeTabBarRedDot")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = xw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", tw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(tw1Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.hideNavigationBarLoading")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = tw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                vw1 vw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", vw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(vw1Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.openMultiPicker")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 G = vw1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                vw1 vw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", vw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(vw1Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.openPicker")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 H = vw1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                xw1 xw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof xw1)) {
                    xw1Var = (xw1) obj;
                } else {
                    xw1Var = new xw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", xw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(xw1Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.openTabBar")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 C = xw1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                uw1 uw1Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof uw1)) {
                    uw1Var = (uw1) obj;
                } else {
                    uw1Var = new uw1(this.mSwanApiContext);
                    this.mApis.put("-1750613704", uw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(uw1Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.pageScrollTo")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = uw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", tw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(tw1Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarColor")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 z = tw1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", tw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(tw1Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarTitle")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = tw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                xw1 xw1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof xw1)) {
                    xw1Var = (xw1) obj;
                } else {
                    xw1Var = new xw1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", xw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(xw1Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.setTabBarItem")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 D = xw1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                vw1 vw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", vw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(vw1Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.showDatePickerView")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 L = vw1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                zw1 zw1Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof zw1)) {
                    zw1Var = (zw1) obj;
                } else {
                    zw1Var = new zw1(this.mSwanApiContext);
                    this.mApis.put("1172469410", zw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(zw1Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.showHalfScreenWebview")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 K = zw1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                rw1 rw1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("5236036", rw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(rw1Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.showLoading")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = rw1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                sw1 sw1Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof sw1)) {
                    sw1Var = (sw1) obj;
                } else {
                    sw1Var = new sw1(this.mSwanApiContext);
                    this.mApis.put("1913747800", sw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(sw1Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.showModal")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = sw1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                tw1 tw1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof tw1)) {
                    tw1Var = (tw1) obj;
                } else {
                    tw1Var = new tw1(this.mSwanApiContext);
                    this.mApis.put("-246386074", tw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(tw1Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.showNavigationBarLoading")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 B = tw1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                yw1 yw1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof yw1)) {
                    yw1Var = (yw1) obj;
                } else {
                    yw1Var = new yw1(this.mSwanApiContext);
                    this.mApis.put("1159492510", yw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yw1Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.showToast")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 Q = yw1Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                ww1 ww1Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof ww1)) {
                    ww1Var = (ww1) obj;
                } else {
                    ww1Var = new ww1(this.mSwanApiContext);
                    this.mApis.put("1165118609", ww1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ww1Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.stopPullDownRefresh")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = ww1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                vw1 vw1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof vw1)) {
                    vw1Var = (vw1) obj;
                } else {
                    vw1Var = new vw1(this.mSwanApiContext);
                    this.mApis.put("-108978463", vw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(vw1Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.updateMultiPicker")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 M = vw1Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                rw1 rw1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof rw1)) {
                    rw1Var = (rw1) obj;
                } else {
                    rw1Var = new rw1(this.mSwanApiContext);
                    this.mApis.put("5236036", rw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(rw1Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.hideLoading")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = rw1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hideToast() {
                yw1 yw1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof yw1)) {
                    yw1Var = (yw1) obj;
                } else {
                    yw1Var = new yw1(this.mSwanApiContext);
                    this.mApis.put("1159492510", yw1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yw1Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Interaction.hideToast")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 K = yw1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                ax1 ax1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof ax1)) {
                    ax1Var = (ax1) obj;
                } else {
                    ax1Var = new ax1(this.mSwanApiContext);
                    this.mApis.put("-137346255", ax1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ax1Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Keyboard.startKeyboardHeightChange")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 C = ax1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                ax1 ax1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof ax1)) {
                    ax1Var = (ax1) obj;
                } else {
                    ax1Var = new ax1(this.mSwanApiContext);
                    this.mApis.put("-137346255", ax1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ax1Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Keyboard.stopKeyboardHeightChange")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 D = ax1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naLocationService", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                bx1 bx1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof bx1)) {
                    bx1Var = (bx1) obj;
                } else {
                    bx1Var = new bx1(this.mSwanApiContext);
                    this.mApis.put("-397373095", bx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(bx1Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "LocationService.getLocation")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = bx1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                bx1 bx1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof bx1)) {
                    bx1Var = (bx1) obj;
                } else {
                    bx1Var = new bx1(this.mSwanApiContext);
                    this.mApis.put("-397373095", bx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(bx1Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "LocationService.startLocationUpdate")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = bx1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                bx1 bx1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof bx1)) {
                    bx1Var = (bx1) obj;
                } else {
                    bx1Var = new bx1(this.mSwanApiContext);
                    this.mApis.put("-397373095", bx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(bx1Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "LocationService.stopLocationUpdate")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 B = bx1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naMenu", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                sy1 sy1Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof sy1)) {
                    sy1Var = (sy1) obj;
                } else {
                    sy1Var = new sy1(this.mSwanApiContext);
                    this.mApis.put("538070032", sy1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(sy1Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = sy1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naNetwork", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                ex1 ex1Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof ex1)) {
                    ex1Var = (ex1) obj;
                } else {
                    ex1Var = new ex1(this.mSwanApiContext);
                    this.mApis.put("-1076509454", ex1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ex1Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Network.callService")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = ex1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                lx1 lx1Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof lx1)) {
                    lx1Var = (lx1) obj;
                } else {
                    lx1Var = new lx1(this.mSwanApiContext);
                    this.mApis.put("968563034", lx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(lx1Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Network.cancelRequest")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 D = lx1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                kx1 kx1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof kx1)) {
                    kx1Var = (kx1) obj;
                } else {
                    kx1Var = new kx1(this.mSwanApiContext);
                    this.mApis.put("453220699", kx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(kx1Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Network.networkStatusChange")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = kx1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                kx1 kx1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof kx1)) {
                    kx1Var = (kx1) obj;
                } else {
                    kx1Var = new kx1(this.mSwanApiContext);
                    this.mApis.put("453220699", kx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(kx1Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Network.getNetworkType")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = kx1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(String str) {
                lx1 lx1Var;
                String a;
                try {
                    vz1.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof lx1)) {
                        lx1Var = (lx1) obj;
                    } else {
                        lx1Var = new lx1(this.mSwanApiContext);
                        this.mApis.put("968563034", lx1Var);
                    }
                    Pair<Boolean, wz1> a2 = yz1.a(lx1Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((wz1) a2.second).a();
                    } else if (ea2.a(this.mSwanApiContext.e(), "Network.request")) {
                        a = new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<wz1, JSONObject> u = aw1.u(str);
                        if (!((wz1) u.first).isSuccess()) {
                            a = ((wz1) u.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) u.second;
                            if (jSONObject == null) {
                                a = wz1.a.a();
                            } else {
                                xz1 V = lx1Var.V(jSONObject);
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
                        vz1.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                u03 u03Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof u03)) {
                    u03Var = (u03) obj;
                } else {
                    u03Var = new u03(this.mSwanApiContext);
                    this.mApis.put("-336396851", u03Var);
                }
                Pair<Boolean, wz1> a = yz1.a(u03Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Payment.chooseCoupon")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = u03Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                u03 u03Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof u03)) {
                    u03Var = (u03) obj;
                } else {
                    u03Var = new u03(this.mSwanApiContext);
                    this.mApis.put("-336396851", u03Var);
                }
                Pair<Boolean, wz1> a = yz1.a(u03Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Payment.getPaymentInfo")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = u03Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                k03 k03Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof k03)) {
                    k03Var = (k03) obj;
                } else {
                    k03Var = new k03(this.mSwanApiContext);
                    this.mApis.put("1854689529", k03Var);
                }
                Pair<Boolean, wz1> a = yz1.a(k03Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Payment.requestThirdPayment")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = k03Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                u03 u03Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof u03)) {
                    u03Var = (u03) obj;
                } else {
                    u03Var = new u03(this.mSwanApiContext);
                    this.mApis.put("-336396851", u03Var);
                }
                Pair<Boolean, wz1> a = yz1.a(u03Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Payment.setPaymentInfo")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 z = u03Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPlugin", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                f33 f33Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof f33)) {
                    f33Var = (f33) obj;
                } else {
                    f33Var = new f33(this.mSwanApiContext);
                    this.mApis.put("-254510461", f33Var);
                }
                Pair<Boolean, wz1> a = yz1.a(f33Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Plugin.invokePluginChooseAddress")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = f33Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                f33 f33Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof f33)) {
                    f33Var = (f33) obj;
                } else {
                    f33Var = new f33(this.mSwanApiContext);
                    this.mApis.put("-254510461", f33Var);
                }
                Pair<Boolean, wz1> a = yz1.a(f33Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 z = f33Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                f33 f33Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof f33)) {
                    f33Var = (f33) obj;
                } else {
                    f33Var = new f33(this.mSwanApiContext);
                    this.mApis.put("-254510461", f33Var);
                }
                Pair<Boolean, wz1> a = yz1.a(f33Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Plugin.invokePluginPayment")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = f33Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                yb2 yb2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof yb2)) {
                    yb2Var = (yb2) obj;
                } else {
                    yb2Var = new yb2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", yb2Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yb2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Prefetch.prefetchResources")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = yb2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPreload", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                qa2 qa2Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof qa2)) {
                    qa2Var = (qa2) obj;
                } else {
                    qa2Var = new qa2(this.mSwanApiContext);
                    this.mApis.put("423661539", qa2Var);
                }
                Pair<Boolean, wz1> a = yz1.a(qa2Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Preload.preloadStatus")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = qa2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                ak3 ak3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof ak3)) {
                    ak3Var = (ak3) obj;
                } else {
                    ak3Var = new ak3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", ak3Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ak3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "PrivateFile.uploadFileToBos")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 C = ak3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naRouter", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                px1 px1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof px1)) {
                    px1Var = (px1) obj;
                } else {
                    px1Var = new px1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", px1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(px1Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Router.hideModalPage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = px1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                px1 px1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof px1)) {
                    px1Var = (px1) obj;
                } else {
                    px1Var = new px1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", px1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(px1Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Router.navigateBack")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 B = px1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                qx1 qx1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("1968522584", qx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(qx1Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Router.navigateTo")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 H = qx1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                sx1 sx1Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof sx1)) {
                    sx1Var = (sx1) obj;
                } else {
                    sx1Var = new sx1(this.mSwanApiContext);
                    this.mApis.put("1317280190", sx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(sx1Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Router.reLaunch")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = sx1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                tx1 tx1Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof tx1)) {
                    tx1Var = (tx1) obj;
                } else {
                    tx1Var = new tx1(this.mSwanApiContext);
                    this.mApis.put("-420075743", tx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(tx1Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Router.reLoadErrorPage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = tx1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                rx1 rx1Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof rx1)) {
                    rx1Var = (rx1) obj;
                } else {
                    rx1Var = new rx1(this.mSwanApiContext);
                    this.mApis.put("1792515533", rx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(rx1Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Router.redirectTo")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 D = rx1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                qx1 qx1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("1968522584", qx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(qx1Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Router.showModalPage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 J = qx1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naSetting", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                wx1 wx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", wx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(wx1Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Setting.getAppInfoSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 F = wx1Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                wx1 wx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", wx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(wx1Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Setting.getSlaveIdSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 H = wx1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                vx1 vx1Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("450273045", vx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(vx1Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Setting.isAllowedAdOpenAppSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = vx1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", wx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(wx1Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Setting.getSetting")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 G = wx1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", wx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(wx1Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Setting.getSwanId")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 I = wx1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-594895721", wx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(wx1Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Setting.getUserInfo")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 J = wx1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                ue3 ue3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof ue3)) {
                    ue3Var = (ue3) obj;
                } else {
                    ue3Var = new ue3(this.mSwanApiContext);
                    this.mApis.put("712777136", ue3Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ue3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = ue3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naStorage", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                zx1 zx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof zx1)) {
                    zx1Var = (zx1) obj;
                } else {
                    zx1Var = new zx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", zx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(zx1Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = zx1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                zx1 zx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof zx1)) {
                    zx1Var = (zx1) obj;
                } else {
                    zx1Var = new zx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", zx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(zx1Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorageSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 C = zx1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                yx1 yx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("130910081", yx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yx1Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.clearStorage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = yx1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                yx1 yx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("130910081", yx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yx1Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.clearStorageSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 C = yx1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                zx1 zx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof zx1)) {
                    zx1Var = (zx1) obj;
                } else {
                    zx1Var = new zx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", zx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(zx1Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfo")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 G = zx1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                zx1 zx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof zx1)) {
                    zx1Var = (zx1) obj;
                } else {
                    zx1Var = new zx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", zx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(zx1Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfoSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 J = zx1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                yx1 yx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("130910081", yx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yx1Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.getStorageInfo")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 G = yx1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                yx1 yx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("130910081", yx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yx1Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.getStorageInfoSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 J = yx1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                zx1 zx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof zx1)) {
                    zx1Var = (zx1) obj;
                } else {
                    zx1Var = new zx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", zx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(zx1Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.getGlobalStorage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 D = zx1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                zx1 zx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof zx1)) {
                    zx1Var = (zx1) obj;
                } else {
                    zx1Var = new zx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", zx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(zx1Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 K = zx1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                yx1 yx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("130910081", yx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yx1Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.getStorage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 D = yx1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                yx1 yx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("130910081", yx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yx1Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.getStorageInfoAsync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 H = yx1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                yx1 yx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("130910081", yx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yx1Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.getStorageSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 K = yx1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                zx1 zx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof zx1)) {
                    zx1Var = (zx1) obj;
                } else {
                    zx1Var = new zx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", zx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(zx1Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 R = zx1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                zx1 zx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof zx1)) {
                    zx1Var = (zx1) obj;
                } else {
                    zx1Var = new zx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", zx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(zx1Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorageSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 T = zx1Var.T(str);
                if (T == null) {
                    return "";
                }
                return T.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                yx1 yx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("130910081", yx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yx1Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.removeStorage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 R = yx1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                yx1 yx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("130910081", yx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yx1Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.removeStorageSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 T = yx1Var.T(str);
                if (T == null) {
                    return "";
                }
                return T.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                zx1 zx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof zx1)) {
                    zx1Var = (zx1) obj;
                } else {
                    zx1Var = new zx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", zx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(zx1Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.setGlobalStorage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 U = zx1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                zx1 zx1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof zx1)) {
                    zx1Var = (zx1) obj;
                } else {
                    zx1Var = new zx1(this.mSwanApiContext);
                    this.mApis.put("-804054859", zx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(zx1Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.setGlobalStorageSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 W = zx1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                yx1 yx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("130910081", yx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yx1Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.setStorage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 U = yx1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                yx1 yx1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("130910081", yx1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yx1Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Storage.setStorageSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 W = yx1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }
        });
        hashMap.put("_naSubscription", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                by1 by1Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof by1)) {
                    by1Var = (by1) obj;
                } else {
                    by1Var = new by1(this.mSwanApiContext);
                    this.mApis.put("823117982", by1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(by1Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Subscription.requestSubscribeFormId")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 E = by1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                cy1 cy1Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof cy1)) {
                    cy1Var = (cy1) obj;
                } else {
                    cy1Var = new cy1(this.mSwanApiContext);
                    this.mApis.put("-947445811", cy1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(cy1Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Subscription.subscribeService")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 F = cy1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }
        });
        hashMap.put("_naSystem", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                jy1 jy1Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof jy1)) {
                    jy1Var = (jy1) obj;
                } else {
                    jy1Var = new jy1(this.mSwanApiContext);
                    this.mApis.put("1936205521", jy1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(jy1Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.exitFullScreen")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = jy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                iy1 iy1Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof iy1)) {
                    iy1Var = (iy1) obj;
                } else {
                    iy1Var = new iy1(this.mSwanApiContext);
                    this.mApis.put("1694151270", iy1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(iy1Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.getDeviceInfo")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = iy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                ky1 ky1Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof ky1)) {
                    ky1Var = (ky1) obj;
                } else {
                    ky1Var = new ky1(this.mSwanApiContext);
                    this.mApis.put("-1321681619", ky1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ky1Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.getDeviceProfile")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = ky1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                ly1 ly1Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof ly1)) {
                    ly1Var = (ly1) obj;
                } else {
                    ly1Var = new ly1(this.mSwanApiContext);
                    this.mApis.put("-1569246082", ly1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ly1Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.makePhoneCall")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = ly1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                ny1 ny1Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof ny1)) {
                    ny1Var = (ny1) obj;
                } else {
                    ny1Var = new ny1(this.mSwanApiContext);
                    this.mApis.put("1099851202", ny1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ny1Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.openSMSPanel")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = ny1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                my1 my1Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof my1)) {
                    my1Var = (my1) obj;
                } else {
                    my1Var = new my1(this.mSwanApiContext);
                    this.mApis.put("-1707203360", my1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(my1Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.requestFullScreen")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 F = my1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                gy1 gy1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof gy1)) {
                    gy1Var = (gy1) obj;
                } else {
                    gy1Var = new gy1(this.mSwanApiContext);
                    this.mApis.put("-518757484", gy1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(gy1Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.setClipboardData")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = gy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                qx2 qx2Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof qx2)) {
                    qx2Var = (qx2) obj;
                } else {
                    qx2Var = new qx2(this.mSwanApiContext);
                    this.mApis.put("1161486049", qx2Var);
                }
                Pair<Boolean, wz1> a = yz1.a(qx2Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.setErrorPageType")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = qx2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                qy1 qy1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof qy1)) {
                    qy1Var = (qy1) obj;
                } else {
                    qy1Var = new qy1(this.mSwanApiContext);
                    this.mApis.put("447234992", qy1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(qy1Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.setMediaVolume")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 z = qy1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                ey1 ey1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof ey1)) {
                    ey1Var = (ey1) obj;
                } else {
                    ey1Var = new ey1(this.mSwanApiContext);
                    this.mApis.put("1372680763", ey1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ey1Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.startAccelerometer")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = ey1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                hy1 hy1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof hy1)) {
                    hy1Var = (hy1) obj;
                } else {
                    hy1Var = new hy1(this.mSwanApiContext);
                    this.mApis.put("1689255576", hy1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(hy1Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.startCompass")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = hy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                fy1 fy1Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof fy1)) {
                    fy1Var = (fy1) obj;
                } else {
                    fy1Var = new fy1(this.mSwanApiContext);
                    this.mApis.put("99997465", fy1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(fy1Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.getBrightness")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = fy1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                gy1 gy1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof gy1)) {
                    gy1Var = (gy1) obj;
                } else {
                    gy1Var = new gy1(this.mSwanApiContext);
                    this.mApis.put("-518757484", gy1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(gy1Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.getClipboardData")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = gy1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                qy1 qy1Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof qy1)) {
                    qy1Var = (qy1) obj;
                } else {
                    qy1Var = new qy1(this.mSwanApiContext);
                    this.mApis.put("447234992", qy1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(qy1Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.getMediaVolume")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = qy1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                ey1 ey1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof ey1)) {
                    ey1Var = (ey1) obj;
                } else {
                    ey1Var = new ey1(this.mSwanApiContext);
                    this.mApis.put("1372680763", ey1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ey1Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.stopAccelerometer")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 B = ey1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                hy1 hy1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof hy1)) {
                    hy1Var = (hy1) obj;
                } else {
                    hy1Var = new hy1(this.mSwanApiContext);
                    this.mApis.put("1689255576", hy1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(hy1Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "System.stopCompass")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 z = hy1Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naUtils", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                bz1 bz1Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof bz1)) {
                    bz1Var = (bz1) obj;
                } else {
                    bz1Var = new bz1(this.mSwanApiContext);
                    this.mApis.put("201194468", bz1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(bz1Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.addToDesktop")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 B = bz1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                xy1 xy1Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof xy1)) {
                    xy1Var = (xy1) obj;
                } else {
                    xy1Var = new xy1(this.mSwanApiContext);
                    this.mApis.put("-1412306947", xy1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(xy1Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.calcMD5")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = xy1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                yy1 yy1Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof yy1)) {
                    yy1Var = (yy1) obj;
                } else {
                    yy1Var = new yy1(this.mSwanApiContext);
                    this.mApis.put("1626415364", yy1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(yy1Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.checkAppInstalled")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = yy1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                az1 az1Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof az1)) {
                    az1Var = (az1) obj;
                } else {
                    az1Var = new az1(this.mSwanApiContext);
                    this.mApis.put("-836768778", az1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(az1Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfo")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = az1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                cz1 cz1Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof cz1)) {
                    cz1Var = (cz1) obj;
                } else {
                    cz1Var = new cz1(this.mSwanApiContext);
                    this.mApis.put("-810858308", cz1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(cz1Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.getPerformanceLevel")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = cz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                gz1 gz1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof gz1)) {
                    gz1Var = (gz1) obj;
                } else {
                    gz1Var = new gz1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", gz1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(gz1Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.getSystemInfoAsync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 I = gz1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                dz1 dz1Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof dz1)) {
                    dz1Var = (dz1) obj;
                } else {
                    dz1Var = new dz1(this.mSwanApiContext);
                    this.mApis.put("-2097727681", dz1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(dz1Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.handleException")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = dz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                zy1 zy1Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof zy1)) {
                    zy1Var = (zy1) obj;
                } else {
                    zy1Var = new zy1(this.mSwanApiContext);
                    this.mApis.put("2084449317", zy1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(zy1Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.hasCloseHandler")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = zy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                cc3 cc3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof cc3)) {
                    cc3Var = (cc3) obj;
                } else {
                    cc3Var = new cc3(this.mSwanApiContext);
                    this.mApis.put("1031678042", cc3Var);
                }
                Pair<Boolean, wz1> a = yz1.a(cc3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.hideCaptureScreenShareDialog")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 x = cc3Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                ez1 ez1Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof ez1)) {
                    ez1Var = (ez1) obj;
                } else {
                    ez1Var = new ez1(this.mSwanApiContext);
                    this.mApis.put("1751900130", ez1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ez1Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.logToFile")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = ez1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                db3 db3Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof db3)) {
                    db3Var = (db3) obj;
                } else {
                    db3Var = new db3(this.mSwanApiContext);
                    this.mApis.put("1748196865", db3Var);
                }
                Pair<Boolean, wz1> a = yz1.a(db3Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.preloadPackage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = db3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                fz1 fz1Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof fz1)) {
                    fz1Var = (fz1) obj;
                } else {
                    fz1Var = new fz1(this.mSwanApiContext);
                    this.mApis.put("589529211", fz1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(fz1Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.previewImage")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 B = fz1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                iz1 iz1Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof iz1)) {
                    iz1Var = (iz1) obj;
                } else {
                    iz1Var = new iz1(this.mSwanApiContext);
                    this.mApis.put("-577481801", iz1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(iz1Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.ubcFlowJar")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 I = iz1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                gz1 gz1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof gz1)) {
                    gz1Var = (gz1) obj;
                } else {
                    gz1Var = new gz1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", gz1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(gz1Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfoSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 E = gz1Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                gz1 gz1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof gz1)) {
                    gz1Var = (gz1) obj;
                } else {
                    gz1Var = new gz1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", gz1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(gz1Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.getSystemInfo")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 H = gz1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                gz1 gz1Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof gz1)) {
                    gz1Var = (gz1) obj;
                } else {
                    gz1Var = new gz1(this.mSwanApiContext);
                    this.mApis.put("-1011537871", gz1Var);
                }
                Pair<Boolean, wz1> a = yz1.a(gz1Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Utils.getSystemInfoSync")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 J = gz1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naWifi", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                ni3 ni3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ni3)) {
                    ni3Var = (ni3) obj;
                } else {
                    ni3Var = new ni3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ni3Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ni3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Wifi.connectWifi")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 A = ni3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                ni3 ni3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ni3)) {
                    ni3Var = (ni3) obj;
                } else {
                    ni3Var = new ni3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ni3Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ni3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Wifi.getConnectedWifi")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 B = ni3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                ni3 ni3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ni3)) {
                    ni3Var = (ni3) obj;
                } else {
                    ni3Var = new ni3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ni3Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ni3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Wifi.getWifiList")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 C = ni3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                ni3 ni3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ni3)) {
                    ni3Var = (ni3) obj;
                } else {
                    ni3Var = new ni3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ni3Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ni3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Wifi.startWifi")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 G = ni3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                ni3 ni3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ni3)) {
                    ni3Var = (ni3) obj;
                } else {
                    ni3Var = new ni3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ni3Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ni3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "Wifi.stopWifi")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 H = ni3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }
}
