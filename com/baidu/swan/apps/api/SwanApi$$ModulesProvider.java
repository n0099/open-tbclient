package com.baidu.swan.apps.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.tieba.a02;
import com.baidu.tieba.a12;
import com.baidu.tieba.a22;
import com.baidu.tieba.a32;
import com.baidu.tieba.a42;
import com.baidu.tieba.ag2;
import com.baidu.tieba.b12;
import com.baidu.tieba.b22;
import com.baidu.tieba.b32;
import com.baidu.tieba.c02;
import com.baidu.tieba.c12;
import com.baidu.tieba.c32;
import com.baidu.tieba.co3;
import com.baidu.tieba.cp2;
import com.baidu.tieba.d02;
import com.baidu.tieba.d12;
import com.baidu.tieba.d22;
import com.baidu.tieba.d32;
import com.baidu.tieba.e22;
import com.baidu.tieba.e32;
import com.baidu.tieba.eg3;
import com.baidu.tieba.f02;
import com.baidu.tieba.f32;
import com.baidu.tieba.ff3;
import com.baidu.tieba.g02;
import com.baidu.tieba.g12;
import com.baidu.tieba.g22;
import com.baidu.tieba.g32;
import com.baidu.tieba.ge2;
import com.baidu.tieba.h02;
import com.baidu.tieba.h22;
import com.baidu.tieba.h32;
import com.baidu.tieba.h73;
import com.baidu.tieba.i02;
import com.baidu.tieba.i22;
import com.baidu.tieba.i32;
import com.baidu.tieba.j02;
import com.baidu.tieba.j22;
import com.baidu.tieba.k22;
import com.baidu.tieba.k32;
import com.baidu.tieba.l02;
import com.baidu.tieba.l22;
import com.baidu.tieba.m12;
import com.baidu.tieba.m22;
import com.baidu.tieba.m43;
import com.baidu.tieba.n02;
import com.baidu.tieba.n12;
import com.baidu.tieba.n22;
import com.baidu.tieba.o02;
import com.baidu.tieba.o22;
import com.baidu.tieba.p22;
import com.baidu.tieba.pm3;
import com.baidu.tieba.pz1;
import com.baidu.tieba.q13;
import com.baidu.tieba.qs1;
import com.baidu.tieba.r02;
import com.baidu.tieba.r12;
import com.baidu.tieba.s12;
import com.baidu.tieba.s13;
import com.baidu.tieba.s22;
import com.baidu.tieba.se2;
import com.baidu.tieba.t02;
import com.baidu.tieba.t12;
import com.baidu.tieba.u02;
import com.baidu.tieba.u12;
import com.baidu.tieba.u22;
import com.baidu.tieba.v02;
import com.baidu.tieba.v12;
import com.baidu.tieba.w02;
import com.baidu.tieba.w43;
import com.baidu.tieba.wi3;
import com.baidu.tieba.x02;
import com.baidu.tieba.x12;
import com.baidu.tieba.x32;
import com.baidu.tieba.y02;
import com.baidu.tieba.y12;
import com.baidu.tieba.y32;
import com.baidu.tieba.z02;
import com.baidu.tieba.z22;
import com.baidu.tieba.z32;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
@Keep
/* loaded from: classes4.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final a02 a02Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                g02 g02Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof g02)) {
                    g02Var = (g02) obj;
                } else {
                    g02Var = new g02(this.mSwanApiContext);
                    this.mApis.put("1930258908", g02Var);
                }
                Pair<Boolean, y32> a = a42.a(g02Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Account.checkSession")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = g02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                h02 h02Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof h02)) {
                    h02Var = (h02) obj;
                } else {
                    h02Var = new h02(this.mSwanApiContext);
                    this.mApis.put("-1017914143", h02Var);
                }
                Pair<Boolean, y32> a = a42.a(h02Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Account.getLoginCode")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 C = h02Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                i02 i02Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof i02)) {
                    i02Var = (i02) obj;
                } else {
                    i02Var = new i02(this.mSwanApiContext);
                    this.mApis.put("1754780133", i02Var);
                }
                Pair<Boolean, y32> a = a42.a(i02Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Account.getOpenId")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = i02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                pz1 pz1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof pz1)) {
                    pz1Var = (pz1) obj;
                } else {
                    pz1Var = new pz1(this.mSwanApiContext);
                    this.mApis.put("-343998465", pz1Var);
                }
                Pair<Boolean, y32> a = a42.a(pz1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Account.getUnionBDUSS")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = pz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String login(String str) {
                h02 h02Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof h02)) {
                    h02Var = (h02) obj;
                } else {
                    h02Var = new h02(this.mSwanApiContext);
                    this.mApis.put("-1017914143", h02Var);
                }
                Pair<Boolean, y32> a = a42.a(h02Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Account.login")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 I = h02Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                f02 f02Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof f02)) {
                    f02Var = (f02) obj;
                } else {
                    f02Var = new f02(this.mSwanApiContext);
                    this.mApis.put("-337742792", f02Var);
                }
                Pair<Boolean, y32> a = a42.a(f02Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Account.isBaiduAccountSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = f02Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                h02 h02Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof h02)) {
                    h02Var = (h02) obj;
                } else {
                    h02Var = new h02(this.mSwanApiContext);
                    this.mApis.put("-1017914143", h02Var);
                }
                Pair<Boolean, y32> a = a42.a(h02Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Account.isLoginSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 H = h02Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBasic", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                j02 j02Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof j02)) {
                    j02Var = (j02) obj;
                } else {
                    j02Var = new j02(this.mSwanApiContext);
                    this.mApis.put("-1249666566", j02Var);
                }
                Pair<Boolean, y32> a = a42.a(j02Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Basic.loadSubPackage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 F = j02Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                j02 j02Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof j02)) {
                    j02Var = (j02) obj;
                } else {
                    j02Var = new j02(this.mSwanApiContext);
                    this.mApis.put("-1249666566", j02Var);
                }
                Pair<Boolean, y32> a = a42.a(j02Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Basic.loadSubPackages")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 G = j02Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                qs1 qs1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof qs1)) {
                    qs1Var = (qs1) obj;
                } else {
                    qs1Var = new qs1(this.mSwanApiContext);
                    this.mApis.put("1460300387", qs1Var);
                }
                Pair<Boolean, y32> a = a42.a(qs1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Bookshelf.deleteBookshelf")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 K = qs1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                qs1 qs1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof qs1)) {
                    qs1Var = (qs1) obj;
                } else {
                    qs1Var = new qs1(this.mSwanApiContext);
                    this.mApis.put("1460300387", qs1Var);
                }
                Pair<Boolean, y32> a = a42.a(qs1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Bookshelf.insertBookshelf")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 P = qs1Var.P(str);
                if (P == null) {
                    return "";
                }
                return P.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                qs1 qs1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof qs1)) {
                    qs1Var = (qs1) obj;
                } else {
                    qs1Var = new qs1(this.mSwanApiContext);
                    this.mApis.put("1460300387", qs1Var);
                }
                Pair<Boolean, y32> a = a42.a(qs1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Bookshelf.navigateToBookshelf")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 U = qs1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                qs1 qs1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof qs1)) {
                    qs1Var = (qs1) obj;
                } else {
                    qs1Var = new qs1(this.mSwanApiContext);
                    this.mApis.put("1460300387", qs1Var);
                }
                Pair<Boolean, y32> a = a42.a(qs1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Bookshelf.queryBookshelf")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 V = qs1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                qs1 qs1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof qs1)) {
                    qs1Var = (qs1) obj;
                } else {
                    qs1Var = new qs1(this.mSwanApiContext);
                    this.mApis.put("1460300387", qs1Var);
                }
                Pair<Boolean, y32> a = a42.a(qs1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Bookshelf.updateBookshelfReadTime")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 X = qs1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naCoupon", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                d02 d02Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof d02)) {
                    d02Var = (d02) obj;
                } else {
                    d02Var = new d02(this.mSwanApiContext);
                    this.mApis.put("-277316359", d02Var);
                }
                Pair<Boolean, y32> a = a42.a(d02Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Coupon.getPlatformCoupons")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = d02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                d02 d02Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof d02)) {
                    d02Var = (d02) obj;
                } else {
                    d02Var = new d02(this.mSwanApiContext);
                    this.mApis.put("-277316359", d02Var);
                }
                Pair<Boolean, y32> a = a42.a(d02Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Coupon.getUserCoupons")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 z = d02Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                d02 d02Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof d02)) {
                    d02Var = (d02) obj;
                } else {
                    d02Var = new d02(this.mSwanApiContext);
                    this.mApis.put("-277316359", d02Var);
                }
                Pair<Boolean, y32> a = a42.a(d02Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Coupon.takeCoupons")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 C = d02Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naFavorite", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                l02 l02Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof l02)) {
                    l02Var = (l02) obj;
                } else {
                    l02Var = new l02(this.mSwanApiContext);
                    this.mApis.put("-1225406515", l02Var);
                }
                Pair<Boolean, y32> a = a42.a(l02Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Favorite.getFavorStatus")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = l02Var.x(str);
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
                Pair<Boolean, y32> a = a42.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Favorite.showFavoriteGuide")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 G = showFavoriteGuideApi.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naFile", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                n02 n02Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof n02)) {
                    n02Var = (n02) obj;
                } else {
                    n02Var = new n02(this.mSwanApiContext);
                    this.mApis.put("-2057135077", n02Var);
                }
                Pair<Boolean, y32> a = a42.a(n02Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "File.shareFile")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = n02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                cp2 cp2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof cp2)) {
                    cp2Var = (cp2) obj;
                } else {
                    cp2Var = new cp2(this.mSwanApiContext);
                    this.mApis.put("2077414795", cp2Var);
                }
                Pair<Boolean, y32> a = a42.a(cp2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "GameCenter.postGameCenterMessage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = cp2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                cp2 cp2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof cp2)) {
                    cp2Var = (cp2) obj;
                } else {
                    cp2Var = new cp2(this.mSwanApiContext);
                    this.mApis.put("2077414795", cp2Var);
                }
                Pair<Boolean, y32> a = a42.a(cp2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "GameCenter.postGameCenterMessageSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = cp2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String download(String str) {
                o02 o02Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof o02)) {
                    o02Var = (o02) obj;
                } else {
                    o02Var = new o02(this.mSwanApiContext);
                    this.mApis.put("-170124576", o02Var);
                }
                Pair<Boolean, y32> a = a42.a(o02Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "HostDownloadManager.download")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = o02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                o02 o02Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof o02)) {
                    o02Var = (o02) obj;
                } else {
                    o02Var = new o02(this.mSwanApiContext);
                    this.mApis.put("-170124576", o02Var);
                }
                Pair<Boolean, y32> a = a42.a(o02Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "HostDownloadManager.openFile")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 z = o02Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String query(String str) {
                o02 o02Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof o02)) {
                    o02Var = (o02) obj;
                } else {
                    o02Var = new o02(this.mSwanApiContext);
                    this.mApis.put("-170124576", o02Var);
                }
                Pair<Boolean, y32> a = a42.a(o02Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "HostDownloadManager.query")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 query = o02Var.query(str);
                if (query == null) {
                    return "";
                }
                return query.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                o02 o02Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof o02)) {
                    o02Var = (o02) obj;
                } else {
                    o02Var = new o02(this.mSwanApiContext);
                    this.mApis.put("-170124576", o02Var);
                }
                Pair<Boolean, y32> a = a42.a(o02Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "HostDownloadManager.openDownloadCenter")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = o02Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naImage", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                q13 q13Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof q13)) {
                    q13Var = (q13) obj;
                } else {
                    q13Var = new q13(this.mSwanApiContext);
                    this.mApis.put("1445003743", q13Var);
                }
                Pair<Boolean, y32> a = a42.a(q13Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Image.callImageMenu")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = q13Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                r02 r02Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof r02)) {
                    r02Var = (r02) obj;
                } else {
                    r02Var = new r02(this.mSwanApiContext);
                    this.mApis.put("-1252730367", r02Var);
                }
                Pair<Boolean, y32> a = a42.a(r02Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Image.compressImage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = r02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naInteraction", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", z02Var);
                }
                Pair<Boolean, y32> a = a42.a(z02Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.closeTabBar")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = z02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", z02Var);
                }
                Pair<Boolean, y32> a = a42.a(z02Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.closeTabBarRedDot")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = z02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                v02 v02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("-246386074", v02Var);
                }
                Pair<Boolean, y32> a = a42.a(v02Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.hideNavigationBarLoading")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = v02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                x02 x02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof x02)) {
                    x02Var = (x02) obj;
                } else {
                    x02Var = new x02(this.mSwanApiContext);
                    this.mApis.put("-108978463", x02Var);
                }
                Pair<Boolean, y32> a = a42.a(x02Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.openMultiPicker")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 G = x02Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                x02 x02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof x02)) {
                    x02Var = (x02) obj;
                } else {
                    x02Var = new x02(this.mSwanApiContext);
                    this.mApis.put("-108978463", x02Var);
                }
                Pair<Boolean, y32> a = a42.a(x02Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.openPicker")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 H = x02Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", z02Var);
                }
                Pair<Boolean, y32> a = a42.a(z02Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.openTabBar")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 C = z02Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                w02 w02Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof w02)) {
                    w02Var = (w02) obj;
                } else {
                    w02Var = new w02(this.mSwanApiContext);
                    this.mApis.put("-1750613704", w02Var);
                }
                Pair<Boolean, y32> a = a42.a(w02Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.pageScrollTo")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = w02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                v02 v02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("-246386074", v02Var);
                }
                Pair<Boolean, y32> a = a42.a(v02Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.setNavigationBarColor")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 z = v02Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                v02 v02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("-246386074", v02Var);
                }
                Pair<Boolean, y32> a = a42.a(v02Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.setNavigationBarTitle")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = v02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", z02Var);
                }
                Pair<Boolean, y32> a = a42.a(z02Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.setTabBarItem")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 D = z02Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                x02 x02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof x02)) {
                    x02Var = (x02) obj;
                } else {
                    x02Var = new x02(this.mSwanApiContext);
                    this.mApis.put("-108978463", x02Var);
                }
                Pair<Boolean, y32> a = a42.a(x02Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.showDatePickerView")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 L = x02Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                b12 b12Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof b12)) {
                    b12Var = (b12) obj;
                } else {
                    b12Var = new b12(this.mSwanApiContext);
                    this.mApis.put("1172469410", b12Var);
                }
                Pair<Boolean, y32> a = a42.a(b12Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.showHalfScreenWebview")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 K = b12Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                t02 t02Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof t02)) {
                    t02Var = (t02) obj;
                } else {
                    t02Var = new t02(this.mSwanApiContext);
                    this.mApis.put("5236036", t02Var);
                }
                Pair<Boolean, y32> a = a42.a(t02Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.showLoading")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = t02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                u02 u02Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof u02)) {
                    u02Var = (u02) obj;
                } else {
                    u02Var = new u02(this.mSwanApiContext);
                    this.mApis.put("1913747800", u02Var);
                }
                Pair<Boolean, y32> a = a42.a(u02Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.showModal")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = u02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                v02 v02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("-246386074", v02Var);
                }
                Pair<Boolean, y32> a = a42.a(v02Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.showNavigationBarLoading")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 B = v02Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                a12 a12Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("1159492510", a12Var);
                }
                Pair<Boolean, y32> a = a42.a(a12Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.showToast")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 Q = a12Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                y02 y02Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof y02)) {
                    y02Var = (y02) obj;
                } else {
                    y02Var = new y02(this.mSwanApiContext);
                    this.mApis.put("1165118609", y02Var);
                }
                Pair<Boolean, y32> a = a42.a(y02Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.stopPullDownRefresh")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = y02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                x02 x02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof x02)) {
                    x02Var = (x02) obj;
                } else {
                    x02Var = new x02(this.mSwanApiContext);
                    this.mApis.put("-108978463", x02Var);
                }
                Pair<Boolean, y32> a = a42.a(x02Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.updateMultiPicker")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 M = x02Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                t02 t02Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof t02)) {
                    t02Var = (t02) obj;
                } else {
                    t02Var = new t02(this.mSwanApiContext);
                    this.mApis.put("5236036", t02Var);
                }
                Pair<Boolean, y32> a = a42.a(t02Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.hideLoading")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = t02Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hideToast() {
                a12 a12Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("1159492510", a12Var);
                }
                Pair<Boolean, y32> a = a42.a(a12Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.hideToast")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 K = a12Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                c12 c12Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof c12)) {
                    c12Var = (c12) obj;
                } else {
                    c12Var = new c12(this.mSwanApiContext);
                    this.mApis.put("-137346255", c12Var);
                }
                Pair<Boolean, y32> a = a42.a(c12Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Keyboard.startKeyboardHeightChange")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 C = c12Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                c12 c12Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof c12)) {
                    c12Var = (c12) obj;
                } else {
                    c12Var = new c12(this.mSwanApiContext);
                    this.mApis.put("-137346255", c12Var);
                }
                Pair<Boolean, y32> a = a42.a(c12Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Keyboard.stopKeyboardHeightChange")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 D = c12Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naLocationService", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                d12 d12Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof d12)) {
                    d12Var = (d12) obj;
                } else {
                    d12Var = new d12(this.mSwanApiContext);
                    this.mApis.put("-397373095", d12Var);
                }
                Pair<Boolean, y32> a = a42.a(d12Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "LocationService.getLocation")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = d12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                d12 d12Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof d12)) {
                    d12Var = (d12) obj;
                } else {
                    d12Var = new d12(this.mSwanApiContext);
                    this.mApis.put("-397373095", d12Var);
                }
                Pair<Boolean, y32> a = a42.a(d12Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "LocationService.startLocationUpdate")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = d12Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                d12 d12Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof d12)) {
                    d12Var = (d12) obj;
                } else {
                    d12Var = new d12(this.mSwanApiContext);
                    this.mApis.put("-397373095", d12Var);
                }
                Pair<Boolean, y32> a = a42.a(d12Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "LocationService.stopLocationUpdate")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 B = d12Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naMenu", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                u22 u22Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof u22)) {
                    u22Var = (u22) obj;
                } else {
                    u22Var = new u22(this.mSwanApiContext);
                    this.mApis.put("538070032", u22Var);
                }
                Pair<Boolean, y32> a = a42.a(u22Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = u22Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naNetwork", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                g12 g12Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof g12)) {
                    g12Var = (g12) obj;
                } else {
                    g12Var = new g12(this.mSwanApiContext);
                    this.mApis.put("-1076509454", g12Var);
                }
                Pair<Boolean, y32> a = a42.a(g12Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Network.callService")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = g12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                n12 n12Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof n12)) {
                    n12Var = (n12) obj;
                } else {
                    n12Var = new n12(this.mSwanApiContext);
                    this.mApis.put("968563034", n12Var);
                }
                Pair<Boolean, y32> a = a42.a(n12Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Network.cancelRequest")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 D = n12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                m12 m12Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof m12)) {
                    m12Var = (m12) obj;
                } else {
                    m12Var = new m12(this.mSwanApiContext);
                    this.mApis.put("453220699", m12Var);
                }
                Pair<Boolean, y32> a = a42.a(m12Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Network.networkStatusChange")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = m12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                m12 m12Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof m12)) {
                    m12Var = (m12) obj;
                } else {
                    m12Var = new m12(this.mSwanApiContext);
                    this.mApis.put("453220699", m12Var);
                }
                Pair<Boolean, y32> a = a42.a(m12Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Network.getNetworkType")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = m12Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(JsObject jsObject) {
                n12 n12Var;
                String a;
                try {
                    x32.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof n12)) {
                        n12Var = (n12) obj;
                    } else {
                        n12Var = new n12(this.mSwanApiContext);
                        this.mApis.put("968563034", n12Var);
                    }
                    Pair<Boolean, y32> a2 = a42.a(n12Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((y32) a2.second).a();
                    } else if (ge2.a(this.mSwanApiContext.d(), "Network.request")) {
                        a = new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<y32, JSONObject> t = c02.t(jsObject);
                        if (!((y32) t.first).isSuccess()) {
                            a = ((y32) t.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) t.second;
                            if (jSONObject == null) {
                                a = y32.a.a();
                            } else {
                                z32 V = n12Var.V(jSONObject);
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
                        x32.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                w43 w43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof w43)) {
                    w43Var = (w43) obj;
                } else {
                    w43Var = new w43(this.mSwanApiContext);
                    this.mApis.put("-336396851", w43Var);
                }
                Pair<Boolean, y32> a = a42.a(w43Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Payment.chooseCoupon")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = w43Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                w43 w43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof w43)) {
                    w43Var = (w43) obj;
                } else {
                    w43Var = new w43(this.mSwanApiContext);
                    this.mApis.put("-336396851", w43Var);
                }
                Pair<Boolean, y32> a = a42.a(w43Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Payment.getPaymentInfo")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = w43Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                m43 m43Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof m43)) {
                    m43Var = (m43) obj;
                } else {
                    m43Var = new m43(this.mSwanApiContext);
                    this.mApis.put("1854689529", m43Var);
                }
                Pair<Boolean, y32> a = a42.a(m43Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Payment.requestThirdPayment")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = m43Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                w43 w43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof w43)) {
                    w43Var = (w43) obj;
                } else {
                    w43Var = new w43(this.mSwanApiContext);
                    this.mApis.put("-336396851", w43Var);
                }
                Pair<Boolean, y32> a = a42.a(w43Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Payment.setPaymentInfo")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 z = w43Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPlugin", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                h73 h73Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof h73)) {
                    h73Var = (h73) obj;
                } else {
                    h73Var = new h73(this.mSwanApiContext);
                    this.mApis.put("-254510461", h73Var);
                }
                Pair<Boolean, y32> a = a42.a(h73Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Plugin.invokePluginChooseAddress")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = h73Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                h73 h73Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof h73)) {
                    h73Var = (h73) obj;
                } else {
                    h73Var = new h73(this.mSwanApiContext);
                    this.mApis.put("-254510461", h73Var);
                }
                Pair<Boolean, y32> a = a42.a(h73Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 z = h73Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                h73 h73Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof h73)) {
                    h73Var = (h73) obj;
                } else {
                    h73Var = new h73(this.mSwanApiContext);
                    this.mApis.put("-254510461", h73Var);
                }
                Pair<Boolean, y32> a = a42.a(h73Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Plugin.invokePluginPayment")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = h73Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                ag2 ag2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof ag2)) {
                    ag2Var = (ag2) obj;
                } else {
                    ag2Var = new ag2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", ag2Var);
                }
                Pair<Boolean, y32> a = a42.a(ag2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Prefetch.prefetchResources")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = ag2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPreload", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                se2 se2Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof se2)) {
                    se2Var = (se2) obj;
                } else {
                    se2Var = new se2(this.mSwanApiContext);
                    this.mApis.put("423661539", se2Var);
                }
                Pair<Boolean, y32> a = a42.a(se2Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Preload.preloadStatus")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = se2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                co3 co3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof co3)) {
                    co3Var = (co3) obj;
                } else {
                    co3Var = new co3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", co3Var);
                }
                Pair<Boolean, y32> a = a42.a(co3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "PrivateFile.uploadFileToBos")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 C = co3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naRouter", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                r12 r12Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof r12)) {
                    r12Var = (r12) obj;
                } else {
                    r12Var = new r12(this.mSwanApiContext);
                    this.mApis.put("-1495163604", r12Var);
                }
                Pair<Boolean, y32> a = a42.a(r12Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Router.hideModalPage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = r12Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                r12 r12Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof r12)) {
                    r12Var = (r12) obj;
                } else {
                    r12Var = new r12(this.mSwanApiContext);
                    this.mApis.put("-1495163604", r12Var);
                }
                Pair<Boolean, y32> a = a42.a(r12Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Router.navigateBack")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 B = r12Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                s12 s12Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof s12)) {
                    s12Var = (s12) obj;
                } else {
                    s12Var = new s12(this.mSwanApiContext);
                    this.mApis.put("1968522584", s12Var);
                }
                Pair<Boolean, y32> a = a42.a(s12Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Router.navigateTo")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 H = s12Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                u12 u12Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof u12)) {
                    u12Var = (u12) obj;
                } else {
                    u12Var = new u12(this.mSwanApiContext);
                    this.mApis.put("1317280190", u12Var);
                }
                Pair<Boolean, y32> a = a42.a(u12Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Router.reLaunch")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = u12Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                v12 v12Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof v12)) {
                    v12Var = (v12) obj;
                } else {
                    v12Var = new v12(this.mSwanApiContext);
                    this.mApis.put("-420075743", v12Var);
                }
                Pair<Boolean, y32> a = a42.a(v12Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Router.reLoadErrorPage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = v12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                t12 t12Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof t12)) {
                    t12Var = (t12) obj;
                } else {
                    t12Var = new t12(this.mSwanApiContext);
                    this.mApis.put("1792515533", t12Var);
                }
                Pair<Boolean, y32> a = a42.a(t12Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Router.redirectTo")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 D = t12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                s12 s12Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof s12)) {
                    s12Var = (s12) obj;
                } else {
                    s12Var = new s12(this.mSwanApiContext);
                    this.mApis.put("1968522584", s12Var);
                }
                Pair<Boolean, y32> a = a42.a(s12Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Router.showModalPage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 J = s12Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naSetting", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                y12 y12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof y12)) {
                    y12Var = (y12) obj;
                } else {
                    y12Var = new y12(this.mSwanApiContext);
                    this.mApis.put("-594895721", y12Var);
                }
                Pair<Boolean, y32> a = a42.a(y12Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Setting.getAppInfoSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 F = y12Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                y12 y12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof y12)) {
                    y12Var = (y12) obj;
                } else {
                    y12Var = new y12(this.mSwanApiContext);
                    this.mApis.put("-594895721", y12Var);
                }
                Pair<Boolean, y32> a = a42.a(y12Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Setting.getSlaveIdSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 H = y12Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                x12 x12Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof x12)) {
                    x12Var = (x12) obj;
                } else {
                    x12Var = new x12(this.mSwanApiContext);
                    this.mApis.put("450273045", x12Var);
                }
                Pair<Boolean, y32> a = a42.a(x12Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Setting.isAllowedAdOpenAppSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = x12Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                y12 y12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof y12)) {
                    y12Var = (y12) obj;
                } else {
                    y12Var = new y12(this.mSwanApiContext);
                    this.mApis.put("-594895721", y12Var);
                }
                Pair<Boolean, y32> a = a42.a(y12Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Setting.getSetting")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 G = y12Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                y12 y12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof y12)) {
                    y12Var = (y12) obj;
                } else {
                    y12Var = new y12(this.mSwanApiContext);
                    this.mApis.put("-594895721", y12Var);
                }
                Pair<Boolean, y32> a = a42.a(y12Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Setting.getSwanId")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 I = y12Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                y12 y12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof y12)) {
                    y12Var = (y12) obj;
                } else {
                    y12Var = new y12(this.mSwanApiContext);
                    this.mApis.put("-594895721", y12Var);
                }
                Pair<Boolean, y32> a = a42.a(y12Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Setting.getUserInfo")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 J = y12Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                wi3 wi3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof wi3)) {
                    wi3Var = (wi3) obj;
                } else {
                    wi3Var = new wi3(this.mSwanApiContext);
                    this.mApis.put("712777136", wi3Var);
                }
                Pair<Boolean, y32> a = a42.a(wi3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = wi3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naStorage", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                b22 b22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-804054859", b22Var);
                }
                Pair<Boolean, y32> a = a42.a(b22Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.clearGlobalStorage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = b22Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                b22 b22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-804054859", b22Var);
                }
                Pair<Boolean, y32> a = a42.a(b22Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.clearGlobalStorageSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 C = b22Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                a22 a22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("130910081", a22Var);
                }
                Pair<Boolean, y32> a = a42.a(a22Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.clearStorage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = a22Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                a22 a22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("130910081", a22Var);
                }
                Pair<Boolean, y32> a = a42.a(a22Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.clearStorageSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 C = a22Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                b22 b22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-804054859", b22Var);
                }
                Pair<Boolean, y32> a = a42.a(b22Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageInfo")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 G = b22Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                b22 b22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-804054859", b22Var);
                }
                Pair<Boolean, y32> a = a42.a(b22Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageInfoSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 J = b22Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                a22 a22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("130910081", a22Var);
                }
                Pair<Boolean, y32> a = a42.a(a22Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.getStorageInfo")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 G = a22Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                a22 a22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("130910081", a22Var);
                }
                Pair<Boolean, y32> a = a42.a(a22Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.getStorageInfoSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 J = a22Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                b22 b22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-804054859", b22Var);
                }
                Pair<Boolean, y32> a = a42.a(b22Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 D = b22Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                b22 b22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-804054859", b22Var);
                }
                Pair<Boolean, y32> a = a42.a(b22Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 K = b22Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                a22 a22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("130910081", a22Var);
                }
                Pair<Boolean, y32> a = a42.a(a22Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.getStorage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 D = a22Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                a22 a22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("130910081", a22Var);
                }
                Pair<Boolean, y32> a = a42.a(a22Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.getStorageInfoAsync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 H = a22Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                a22 a22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("130910081", a22Var);
                }
                Pair<Boolean, y32> a = a42.a(a22Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.getStorageSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 K = a22Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                b22 b22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-804054859", b22Var);
                }
                Pair<Boolean, y32> a = a42.a(b22Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.removeGlobalStorage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 R = b22Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                b22 b22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-804054859", b22Var);
                }
                Pair<Boolean, y32> a = a42.a(b22Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.removeGlobalStorageSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 T2 = b22Var.T(str);
                if (T2 == null) {
                    return "";
                }
                return T2.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                a22 a22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("130910081", a22Var);
                }
                Pair<Boolean, y32> a = a42.a(a22Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.removeStorage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 R = a22Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                a22 a22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("130910081", a22Var);
                }
                Pair<Boolean, y32> a = a42.a(a22Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.removeStorageSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 T2 = a22Var.T(str);
                if (T2 == null) {
                    return "";
                }
                return T2.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                b22 b22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-804054859", b22Var);
                }
                Pair<Boolean, y32> a = a42.a(b22Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.setGlobalStorage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 U = b22Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                b22 b22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-804054859", b22Var);
                }
                Pair<Boolean, y32> a = a42.a(b22Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.setGlobalStorageSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 W = b22Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                a22 a22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("130910081", a22Var);
                }
                Pair<Boolean, y32> a = a42.a(a22Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.setStorage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 U = a22Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                a22 a22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("130910081", a22Var);
                }
                Pair<Boolean, y32> a = a42.a(a22Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.setStorageSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 W = a22Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }
        });
        hashMap.put("_naSubscription", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                d22 d22Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("823117982", d22Var);
                }
                Pair<Boolean, y32> a = a42.a(d22Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Subscription.requestSubscribeFormId")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 E = d22Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                e22 e22Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("-947445811", e22Var);
                }
                Pair<Boolean, y32> a = a42.a(e22Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Subscription.subscribeService")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 F = e22Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }
        });
        hashMap.put("_naSystem", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                l22 l22Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof l22)) {
                    l22Var = (l22) obj;
                } else {
                    l22Var = new l22(this.mSwanApiContext);
                    this.mApis.put("1936205521", l22Var);
                }
                Pair<Boolean, y32> a = a42.a(l22Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.exitFullScreen")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = l22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                k22 k22Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof k22)) {
                    k22Var = (k22) obj;
                } else {
                    k22Var = new k22(this.mSwanApiContext);
                    this.mApis.put("1694151270", k22Var);
                }
                Pair<Boolean, y32> a = a42.a(k22Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.getDeviceInfo")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = k22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                m22 m22Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof m22)) {
                    m22Var = (m22) obj;
                } else {
                    m22Var = new m22(this.mSwanApiContext);
                    this.mApis.put("-1321681619", m22Var);
                }
                Pair<Boolean, y32> a = a42.a(m22Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.getDeviceProfile")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = m22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                n22 n22Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof n22)) {
                    n22Var = (n22) obj;
                } else {
                    n22Var = new n22(this.mSwanApiContext);
                    this.mApis.put("-1569246082", n22Var);
                }
                Pair<Boolean, y32> a = a42.a(n22Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.makePhoneCall")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = n22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                p22 p22Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof p22)) {
                    p22Var = (p22) obj;
                } else {
                    p22Var = new p22(this.mSwanApiContext);
                    this.mApis.put("1099851202", p22Var);
                }
                Pair<Boolean, y32> a = a42.a(p22Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.openSMSPanel")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = p22Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                o22 o22Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof o22)) {
                    o22Var = (o22) obj;
                } else {
                    o22Var = new o22(this.mSwanApiContext);
                    this.mApis.put("-1707203360", o22Var);
                }
                Pair<Boolean, y32> a = a42.a(o22Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.requestFullScreen")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 F = o22Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                i22 i22Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof i22)) {
                    i22Var = (i22) obj;
                } else {
                    i22Var = new i22(this.mSwanApiContext);
                    this.mApis.put("-518757484", i22Var);
                }
                Pair<Boolean, y32> a = a42.a(i22Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.setClipboardData")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = i22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                s13 s13Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof s13)) {
                    s13Var = (s13) obj;
                } else {
                    s13Var = new s13(this.mSwanApiContext);
                    this.mApis.put("1161486049", s13Var);
                }
                Pair<Boolean, y32> a = a42.a(s13Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.setErrorPageType")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = s13Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                s22 s22Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof s22)) {
                    s22Var = (s22) obj;
                } else {
                    s22Var = new s22(this.mSwanApiContext);
                    this.mApis.put("447234992", s22Var);
                }
                Pair<Boolean, y32> a = a42.a(s22Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.setMediaVolume")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 z = s22Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                g22 g22Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof g22)) {
                    g22Var = (g22) obj;
                } else {
                    g22Var = new g22(this.mSwanApiContext);
                    this.mApis.put("1372680763", g22Var);
                }
                Pair<Boolean, y32> a = a42.a(g22Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.startAccelerometer")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = g22Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                j22 j22Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof j22)) {
                    j22Var = (j22) obj;
                } else {
                    j22Var = new j22(this.mSwanApiContext);
                    this.mApis.put("1689255576", j22Var);
                }
                Pair<Boolean, y32> a = a42.a(j22Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.startCompass")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = j22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                h22 h22Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof h22)) {
                    h22Var = (h22) obj;
                } else {
                    h22Var = new h22(this.mSwanApiContext);
                    this.mApis.put("99997465", h22Var);
                }
                Pair<Boolean, y32> a = a42.a(h22Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.getBrightness")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = h22Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                i22 i22Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof i22)) {
                    i22Var = (i22) obj;
                } else {
                    i22Var = new i22(this.mSwanApiContext);
                    this.mApis.put("-518757484", i22Var);
                }
                Pair<Boolean, y32> a = a42.a(i22Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.getClipboardData")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = i22Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                s22 s22Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof s22)) {
                    s22Var = (s22) obj;
                } else {
                    s22Var = new s22(this.mSwanApiContext);
                    this.mApis.put("447234992", s22Var);
                }
                Pair<Boolean, y32> a = a42.a(s22Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.getMediaVolume")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = s22Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                g22 g22Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof g22)) {
                    g22Var = (g22) obj;
                } else {
                    g22Var = new g22(this.mSwanApiContext);
                    this.mApis.put("1372680763", g22Var);
                }
                Pair<Boolean, y32> a = a42.a(g22Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.stopAccelerometer")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 B = g22Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                j22 j22Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof j22)) {
                    j22Var = (j22) obj;
                } else {
                    j22Var = new j22(this.mSwanApiContext);
                    this.mApis.put("1689255576", j22Var);
                }
                Pair<Boolean, y32> a = a42.a(j22Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.stopCompass")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 z = j22Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naUtils", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                d32 d32Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof d32)) {
                    d32Var = (d32) obj;
                } else {
                    d32Var = new d32(this.mSwanApiContext);
                    this.mApis.put("201194468", d32Var);
                }
                Pair<Boolean, y32> a = a42.a(d32Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.addToDesktop")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 B = d32Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                z22 z22Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof z22)) {
                    z22Var = (z22) obj;
                } else {
                    z22Var = new z22(this.mSwanApiContext);
                    this.mApis.put("-1412306947", z22Var);
                }
                Pair<Boolean, y32> a = a42.a(z22Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.calcMD5")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = z22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                a32 a32Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof a32)) {
                    a32Var = (a32) obj;
                } else {
                    a32Var = new a32(this.mSwanApiContext);
                    this.mApis.put("1626415364", a32Var);
                }
                Pair<Boolean, y32> a = a42.a(a32Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.checkAppInstalled")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = a32Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                c32 c32Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof c32)) {
                    c32Var = (c32) obj;
                } else {
                    c32Var = new c32(this.mSwanApiContext);
                    this.mApis.put("-836768778", c32Var);
                }
                Pair<Boolean, y32> a = a42.a(c32Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.getCommonSysInfo")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = c32Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                e32 e32Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof e32)) {
                    e32Var = (e32) obj;
                } else {
                    e32Var = new e32(this.mSwanApiContext);
                    this.mApis.put("-810858308", e32Var);
                }
                Pair<Boolean, y32> a = a42.a(e32Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.getPerformanceLevel")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = e32Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                i32 i32Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof i32)) {
                    i32Var = (i32) obj;
                } else {
                    i32Var = new i32(this.mSwanApiContext);
                    this.mApis.put("-1011537871", i32Var);
                }
                Pair<Boolean, y32> a = a42.a(i32Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.getSystemInfoAsync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 I = i32Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                f32 f32Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof f32)) {
                    f32Var = (f32) obj;
                } else {
                    f32Var = new f32(this.mSwanApiContext);
                    this.mApis.put("-2097727681", f32Var);
                }
                Pair<Boolean, y32> a = a42.a(f32Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.handleException")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = f32Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                b32 b32Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof b32)) {
                    b32Var = (b32) obj;
                } else {
                    b32Var = new b32(this.mSwanApiContext);
                    this.mApis.put("2084449317", b32Var);
                }
                Pair<Boolean, y32> a = a42.a(b32Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.hasCloseHandler")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = b32Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                eg3 eg3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof eg3)) {
                    eg3Var = (eg3) obj;
                } else {
                    eg3Var = new eg3(this.mSwanApiContext);
                    this.mApis.put("1031678042", eg3Var);
                }
                Pair<Boolean, y32> a = a42.a(eg3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.hideCaptureScreenShareDialog")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = eg3Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                g32 g32Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof g32)) {
                    g32Var = (g32) obj;
                } else {
                    g32Var = new g32(this.mSwanApiContext);
                    this.mApis.put("1751900130", g32Var);
                }
                Pair<Boolean, y32> a = a42.a(g32Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.logToFile")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = g32Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                ff3 ff3Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof ff3)) {
                    ff3Var = (ff3) obj;
                } else {
                    ff3Var = new ff3(this.mSwanApiContext);
                    this.mApis.put("1748196865", ff3Var);
                }
                Pair<Boolean, y32> a = a42.a(ff3Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.preloadPackage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = ff3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                h32 h32Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof h32)) {
                    h32Var = (h32) obj;
                } else {
                    h32Var = new h32(this.mSwanApiContext);
                    this.mApis.put("589529211", h32Var);
                }
                Pair<Boolean, y32> a = a42.a(h32Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.previewImage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 B = h32Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                k32 k32Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof k32)) {
                    k32Var = (k32) obj;
                } else {
                    k32Var = new k32(this.mSwanApiContext);
                    this.mApis.put("-577481801", k32Var);
                }
                Pair<Boolean, y32> a = a42.a(k32Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.ubcFlowJar")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 I = k32Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                i32 i32Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof i32)) {
                    i32Var = (i32) obj;
                } else {
                    i32Var = new i32(this.mSwanApiContext);
                    this.mApis.put("-1011537871", i32Var);
                }
                Pair<Boolean, y32> a = a42.a(i32Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.getCommonSysInfoSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 E = i32Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                i32 i32Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof i32)) {
                    i32Var = (i32) obj;
                } else {
                    i32Var = new i32(this.mSwanApiContext);
                    this.mApis.put("-1011537871", i32Var);
                }
                Pair<Boolean, y32> a = a42.a(i32Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.getSystemInfo")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 H = i32Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                i32 i32Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof i32)) {
                    i32Var = (i32) obj;
                } else {
                    i32Var = new i32(this.mSwanApiContext);
                    this.mApis.put("-1011537871", i32Var);
                }
                Pair<Boolean, y32> a = a42.a(i32Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.getSystemInfoSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 J = i32Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naWifi", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                pm3 pm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof pm3)) {
                    pm3Var = (pm3) obj;
                } else {
                    pm3Var = new pm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", pm3Var);
                }
                Pair<Boolean, y32> a = a42.a(pm3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Wifi.connectWifi")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = pm3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                pm3 pm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof pm3)) {
                    pm3Var = (pm3) obj;
                } else {
                    pm3Var = new pm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", pm3Var);
                }
                Pair<Boolean, y32> a = a42.a(pm3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Wifi.getConnectedWifi")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 B = pm3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                pm3 pm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof pm3)) {
                    pm3Var = (pm3) obj;
                } else {
                    pm3Var = new pm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", pm3Var);
                }
                Pair<Boolean, y32> a = a42.a(pm3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Wifi.getWifiList")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 C = pm3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                pm3 pm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof pm3)) {
                    pm3Var = (pm3) obj;
                } else {
                    pm3Var = new pm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", pm3Var);
                }
                Pair<Boolean, y32> a = a42.a(pm3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Wifi.startWifi")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 G = pm3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                pm3 pm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof pm3)) {
                    pm3Var = (pm3) obj;
                } else {
                    pm3Var = new pm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", pm3Var);
                }
                Pair<Boolean, y32> a = a42.a(pm3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Wifi.stopWifi")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 H = pm3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final a02 a02Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                g02 g02Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof g02)) {
                    g02Var = (g02) obj;
                } else {
                    g02Var = new g02(this.mSwanApiContext);
                    this.mApis.put("1930258908", g02Var);
                }
                Pair<Boolean, y32> a = a42.a(g02Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Account.checkSession")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = g02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                h02 h02Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof h02)) {
                    h02Var = (h02) obj;
                } else {
                    h02Var = new h02(this.mSwanApiContext);
                    this.mApis.put("-1017914143", h02Var);
                }
                Pair<Boolean, y32> a = a42.a(h02Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Account.getLoginCode")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 C = h02Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                i02 i02Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof i02)) {
                    i02Var = (i02) obj;
                } else {
                    i02Var = new i02(this.mSwanApiContext);
                    this.mApis.put("1754780133", i02Var);
                }
                Pair<Boolean, y32> a = a42.a(i02Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Account.getOpenId")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = i02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                pz1 pz1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof pz1)) {
                    pz1Var = (pz1) obj;
                } else {
                    pz1Var = new pz1(this.mSwanApiContext);
                    this.mApis.put("-343998465", pz1Var);
                }
                Pair<Boolean, y32> a = a42.a(pz1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Account.getUnionBDUSS")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = pz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String login(String str) {
                h02 h02Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof h02)) {
                    h02Var = (h02) obj;
                } else {
                    h02Var = new h02(this.mSwanApiContext);
                    this.mApis.put("-1017914143", h02Var);
                }
                Pair<Boolean, y32> a = a42.a(h02Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Account.login")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 I = h02Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                f02 f02Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof f02)) {
                    f02Var = (f02) obj;
                } else {
                    f02Var = new f02(this.mSwanApiContext);
                    this.mApis.put("-337742792", f02Var);
                }
                Pair<Boolean, y32> a = a42.a(f02Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Account.isBaiduAccountSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = f02Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                h02 h02Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof h02)) {
                    h02Var = (h02) obj;
                } else {
                    h02Var = new h02(this.mSwanApiContext);
                    this.mApis.put("-1017914143", h02Var);
                }
                Pair<Boolean, y32> a = a42.a(h02Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Account.isLoginSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 H = h02Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBasic", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                j02 j02Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof j02)) {
                    j02Var = (j02) obj;
                } else {
                    j02Var = new j02(this.mSwanApiContext);
                    this.mApis.put("-1249666566", j02Var);
                }
                Pair<Boolean, y32> a = a42.a(j02Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Basic.loadSubPackage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 F = j02Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                j02 j02Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof j02)) {
                    j02Var = (j02) obj;
                } else {
                    j02Var = new j02(this.mSwanApiContext);
                    this.mApis.put("-1249666566", j02Var);
                }
                Pair<Boolean, y32> a = a42.a(j02Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Basic.loadSubPackages")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 G = j02Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                qs1 qs1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof qs1)) {
                    qs1Var = (qs1) obj;
                } else {
                    qs1Var = new qs1(this.mSwanApiContext);
                    this.mApis.put("1460300387", qs1Var);
                }
                Pair<Boolean, y32> a = a42.a(qs1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Bookshelf.deleteBookshelf")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 K = qs1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                qs1 qs1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof qs1)) {
                    qs1Var = (qs1) obj;
                } else {
                    qs1Var = new qs1(this.mSwanApiContext);
                    this.mApis.put("1460300387", qs1Var);
                }
                Pair<Boolean, y32> a = a42.a(qs1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Bookshelf.insertBookshelf")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 P = qs1Var.P(str);
                if (P == null) {
                    return "";
                }
                return P.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                qs1 qs1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof qs1)) {
                    qs1Var = (qs1) obj;
                } else {
                    qs1Var = new qs1(this.mSwanApiContext);
                    this.mApis.put("1460300387", qs1Var);
                }
                Pair<Boolean, y32> a = a42.a(qs1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Bookshelf.navigateToBookshelf")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 U = qs1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                qs1 qs1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof qs1)) {
                    qs1Var = (qs1) obj;
                } else {
                    qs1Var = new qs1(this.mSwanApiContext);
                    this.mApis.put("1460300387", qs1Var);
                }
                Pair<Boolean, y32> a = a42.a(qs1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Bookshelf.queryBookshelf")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 V = qs1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                qs1 qs1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof qs1)) {
                    qs1Var = (qs1) obj;
                } else {
                    qs1Var = new qs1(this.mSwanApiContext);
                    this.mApis.put("1460300387", qs1Var);
                }
                Pair<Boolean, y32> a = a42.a(qs1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Bookshelf.updateBookshelfReadTime")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 X = qs1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naCoupon", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                d02 d02Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof d02)) {
                    d02Var = (d02) obj;
                } else {
                    d02Var = new d02(this.mSwanApiContext);
                    this.mApis.put("-277316359", d02Var);
                }
                Pair<Boolean, y32> a = a42.a(d02Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Coupon.getPlatformCoupons")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = d02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                d02 d02Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof d02)) {
                    d02Var = (d02) obj;
                } else {
                    d02Var = new d02(this.mSwanApiContext);
                    this.mApis.put("-277316359", d02Var);
                }
                Pair<Boolean, y32> a = a42.a(d02Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Coupon.getUserCoupons")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 z = d02Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                d02 d02Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof d02)) {
                    d02Var = (d02) obj;
                } else {
                    d02Var = new d02(this.mSwanApiContext);
                    this.mApis.put("-277316359", d02Var);
                }
                Pair<Boolean, y32> a = a42.a(d02Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Coupon.takeCoupons")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 C = d02Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naFavorite", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                l02 l02Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof l02)) {
                    l02Var = (l02) obj;
                } else {
                    l02Var = new l02(this.mSwanApiContext);
                    this.mApis.put("-1225406515", l02Var);
                }
                Pair<Boolean, y32> a = a42.a(l02Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Favorite.getFavorStatus")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = l02Var.x(str);
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
                Pair<Boolean, y32> a = a42.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Favorite.showFavoriteGuide")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 G = showFavoriteGuideApi.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naFile", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                n02 n02Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof n02)) {
                    n02Var = (n02) obj;
                } else {
                    n02Var = new n02(this.mSwanApiContext);
                    this.mApis.put("-2057135077", n02Var);
                }
                Pair<Boolean, y32> a = a42.a(n02Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "File.shareFile")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = n02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                cp2 cp2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof cp2)) {
                    cp2Var = (cp2) obj;
                } else {
                    cp2Var = new cp2(this.mSwanApiContext);
                    this.mApis.put("2077414795", cp2Var);
                }
                Pair<Boolean, y32> a = a42.a(cp2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "GameCenter.postGameCenterMessage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = cp2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                cp2 cp2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof cp2)) {
                    cp2Var = (cp2) obj;
                } else {
                    cp2Var = new cp2(this.mSwanApiContext);
                    this.mApis.put("2077414795", cp2Var);
                }
                Pair<Boolean, y32> a = a42.a(cp2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "GameCenter.postGameCenterMessageSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = cp2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String download(String str) {
                o02 o02Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof o02)) {
                    o02Var = (o02) obj;
                } else {
                    o02Var = new o02(this.mSwanApiContext);
                    this.mApis.put("-170124576", o02Var);
                }
                Pair<Boolean, y32> a = a42.a(o02Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "HostDownloadManager.download")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = o02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                o02 o02Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof o02)) {
                    o02Var = (o02) obj;
                } else {
                    o02Var = new o02(this.mSwanApiContext);
                    this.mApis.put("-170124576", o02Var);
                }
                Pair<Boolean, y32> a = a42.a(o02Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "HostDownloadManager.openFile")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 z = o02Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String query(String str) {
                o02 o02Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof o02)) {
                    o02Var = (o02) obj;
                } else {
                    o02Var = new o02(this.mSwanApiContext);
                    this.mApis.put("-170124576", o02Var);
                }
                Pair<Boolean, y32> a = a42.a(o02Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "HostDownloadManager.query")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 query = o02Var.query(str);
                if (query == null) {
                    return "";
                }
                return query.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                o02 o02Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof o02)) {
                    o02Var = (o02) obj;
                } else {
                    o02Var = new o02(this.mSwanApiContext);
                    this.mApis.put("-170124576", o02Var);
                }
                Pair<Boolean, y32> a = a42.a(o02Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "HostDownloadManager.openDownloadCenter")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = o02Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naImage", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                q13 q13Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof q13)) {
                    q13Var = (q13) obj;
                } else {
                    q13Var = new q13(this.mSwanApiContext);
                    this.mApis.put("1445003743", q13Var);
                }
                Pair<Boolean, y32> a = a42.a(q13Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Image.callImageMenu")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = q13Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                r02 r02Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof r02)) {
                    r02Var = (r02) obj;
                } else {
                    r02Var = new r02(this.mSwanApiContext);
                    this.mApis.put("-1252730367", r02Var);
                }
                Pair<Boolean, y32> a = a42.a(r02Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Image.compressImage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = r02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naInteraction", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", z02Var);
                }
                Pair<Boolean, y32> a = a42.a(z02Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.closeTabBar")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = z02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", z02Var);
                }
                Pair<Boolean, y32> a = a42.a(z02Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.closeTabBarRedDot")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = z02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                v02 v02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("-246386074", v02Var);
                }
                Pair<Boolean, y32> a = a42.a(v02Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.hideNavigationBarLoading")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = v02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                x02 x02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof x02)) {
                    x02Var = (x02) obj;
                } else {
                    x02Var = new x02(this.mSwanApiContext);
                    this.mApis.put("-108978463", x02Var);
                }
                Pair<Boolean, y32> a = a42.a(x02Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.openMultiPicker")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 G = x02Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                x02 x02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof x02)) {
                    x02Var = (x02) obj;
                } else {
                    x02Var = new x02(this.mSwanApiContext);
                    this.mApis.put("-108978463", x02Var);
                }
                Pair<Boolean, y32> a = a42.a(x02Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.openPicker")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 H = x02Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", z02Var);
                }
                Pair<Boolean, y32> a = a42.a(z02Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.openTabBar")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 C = z02Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                w02 w02Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof w02)) {
                    w02Var = (w02) obj;
                } else {
                    w02Var = new w02(this.mSwanApiContext);
                    this.mApis.put("-1750613704", w02Var);
                }
                Pair<Boolean, y32> a = a42.a(w02Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.pageScrollTo")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = w02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                v02 v02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("-246386074", v02Var);
                }
                Pair<Boolean, y32> a = a42.a(v02Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.setNavigationBarColor")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 z = v02Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                v02 v02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("-246386074", v02Var);
                }
                Pair<Boolean, y32> a = a42.a(v02Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.setNavigationBarTitle")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = v02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", z02Var);
                }
                Pair<Boolean, y32> a = a42.a(z02Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.setTabBarItem")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 D = z02Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                x02 x02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof x02)) {
                    x02Var = (x02) obj;
                } else {
                    x02Var = new x02(this.mSwanApiContext);
                    this.mApis.put("-108978463", x02Var);
                }
                Pair<Boolean, y32> a = a42.a(x02Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.showDatePickerView")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 L = x02Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                b12 b12Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof b12)) {
                    b12Var = (b12) obj;
                } else {
                    b12Var = new b12(this.mSwanApiContext);
                    this.mApis.put("1172469410", b12Var);
                }
                Pair<Boolean, y32> a = a42.a(b12Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.showHalfScreenWebview")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 K = b12Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                t02 t02Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof t02)) {
                    t02Var = (t02) obj;
                } else {
                    t02Var = new t02(this.mSwanApiContext);
                    this.mApis.put("5236036", t02Var);
                }
                Pair<Boolean, y32> a = a42.a(t02Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.showLoading")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = t02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                u02 u02Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof u02)) {
                    u02Var = (u02) obj;
                } else {
                    u02Var = new u02(this.mSwanApiContext);
                    this.mApis.put("1913747800", u02Var);
                }
                Pair<Boolean, y32> a = a42.a(u02Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.showModal")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = u02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                v02 v02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("-246386074", v02Var);
                }
                Pair<Boolean, y32> a = a42.a(v02Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.showNavigationBarLoading")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 B = v02Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                a12 a12Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("1159492510", a12Var);
                }
                Pair<Boolean, y32> a = a42.a(a12Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.showToast")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 Q = a12Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                y02 y02Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof y02)) {
                    y02Var = (y02) obj;
                } else {
                    y02Var = new y02(this.mSwanApiContext);
                    this.mApis.put("1165118609", y02Var);
                }
                Pair<Boolean, y32> a = a42.a(y02Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.stopPullDownRefresh")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = y02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                x02 x02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof x02)) {
                    x02Var = (x02) obj;
                } else {
                    x02Var = new x02(this.mSwanApiContext);
                    this.mApis.put("-108978463", x02Var);
                }
                Pair<Boolean, y32> a = a42.a(x02Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.updateMultiPicker")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 M = x02Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                t02 t02Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof t02)) {
                    t02Var = (t02) obj;
                } else {
                    t02Var = new t02(this.mSwanApiContext);
                    this.mApis.put("5236036", t02Var);
                }
                Pair<Boolean, y32> a = a42.a(t02Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.hideLoading")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = t02Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hideToast() {
                a12 a12Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("1159492510", a12Var);
                }
                Pair<Boolean, y32> a = a42.a(a12Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Interaction.hideToast")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 K = a12Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                c12 c12Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof c12)) {
                    c12Var = (c12) obj;
                } else {
                    c12Var = new c12(this.mSwanApiContext);
                    this.mApis.put("-137346255", c12Var);
                }
                Pair<Boolean, y32> a = a42.a(c12Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Keyboard.startKeyboardHeightChange")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 C = c12Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                c12 c12Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof c12)) {
                    c12Var = (c12) obj;
                } else {
                    c12Var = new c12(this.mSwanApiContext);
                    this.mApis.put("-137346255", c12Var);
                }
                Pair<Boolean, y32> a = a42.a(c12Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Keyboard.stopKeyboardHeightChange")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 D = c12Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naLocationService", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                d12 d12Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof d12)) {
                    d12Var = (d12) obj;
                } else {
                    d12Var = new d12(this.mSwanApiContext);
                    this.mApis.put("-397373095", d12Var);
                }
                Pair<Boolean, y32> a = a42.a(d12Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "LocationService.getLocation")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = d12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                d12 d12Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof d12)) {
                    d12Var = (d12) obj;
                } else {
                    d12Var = new d12(this.mSwanApiContext);
                    this.mApis.put("-397373095", d12Var);
                }
                Pair<Boolean, y32> a = a42.a(d12Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "LocationService.startLocationUpdate")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = d12Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                d12 d12Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof d12)) {
                    d12Var = (d12) obj;
                } else {
                    d12Var = new d12(this.mSwanApiContext);
                    this.mApis.put("-397373095", d12Var);
                }
                Pair<Boolean, y32> a = a42.a(d12Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "LocationService.stopLocationUpdate")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 B = d12Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naMenu", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                u22 u22Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof u22)) {
                    u22Var = (u22) obj;
                } else {
                    u22Var = new u22(this.mSwanApiContext);
                    this.mApis.put("538070032", u22Var);
                }
                Pair<Boolean, y32> a = a42.a(u22Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = u22Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naNetwork", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                g12 g12Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof g12)) {
                    g12Var = (g12) obj;
                } else {
                    g12Var = new g12(this.mSwanApiContext);
                    this.mApis.put("-1076509454", g12Var);
                }
                Pair<Boolean, y32> a = a42.a(g12Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Network.callService")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = g12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                n12 n12Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof n12)) {
                    n12Var = (n12) obj;
                } else {
                    n12Var = new n12(this.mSwanApiContext);
                    this.mApis.put("968563034", n12Var);
                }
                Pair<Boolean, y32> a = a42.a(n12Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Network.cancelRequest")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 D = n12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                m12 m12Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof m12)) {
                    m12Var = (m12) obj;
                } else {
                    m12Var = new m12(this.mSwanApiContext);
                    this.mApis.put("453220699", m12Var);
                }
                Pair<Boolean, y32> a = a42.a(m12Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Network.networkStatusChange")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = m12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                m12 m12Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof m12)) {
                    m12Var = (m12) obj;
                } else {
                    m12Var = new m12(this.mSwanApiContext);
                    this.mApis.put("453220699", m12Var);
                }
                Pair<Boolean, y32> a = a42.a(m12Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Network.getNetworkType")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = m12Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(String str) {
                n12 n12Var;
                String a;
                try {
                    x32.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof n12)) {
                        n12Var = (n12) obj;
                    } else {
                        n12Var = new n12(this.mSwanApiContext);
                        this.mApis.put("968563034", n12Var);
                    }
                    Pair<Boolean, y32> a2 = a42.a(n12Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((y32) a2.second).a();
                    } else if (ge2.a(this.mSwanApiContext.d(), "Network.request")) {
                        a = new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<y32, JSONObject> u = c02.u(str);
                        if (!((y32) u.first).isSuccess()) {
                            a = ((y32) u.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) u.second;
                            if (jSONObject == null) {
                                a = y32.a.a();
                            } else {
                                z32 V = n12Var.V(jSONObject);
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
                        x32.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                w43 w43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof w43)) {
                    w43Var = (w43) obj;
                } else {
                    w43Var = new w43(this.mSwanApiContext);
                    this.mApis.put("-336396851", w43Var);
                }
                Pair<Boolean, y32> a = a42.a(w43Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Payment.chooseCoupon")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = w43Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                w43 w43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof w43)) {
                    w43Var = (w43) obj;
                } else {
                    w43Var = new w43(this.mSwanApiContext);
                    this.mApis.put("-336396851", w43Var);
                }
                Pair<Boolean, y32> a = a42.a(w43Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Payment.getPaymentInfo")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = w43Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                m43 m43Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof m43)) {
                    m43Var = (m43) obj;
                } else {
                    m43Var = new m43(this.mSwanApiContext);
                    this.mApis.put("1854689529", m43Var);
                }
                Pair<Boolean, y32> a = a42.a(m43Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Payment.requestThirdPayment")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = m43Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                w43 w43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof w43)) {
                    w43Var = (w43) obj;
                } else {
                    w43Var = new w43(this.mSwanApiContext);
                    this.mApis.put("-336396851", w43Var);
                }
                Pair<Boolean, y32> a = a42.a(w43Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Payment.setPaymentInfo")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 z = w43Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPlugin", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                h73 h73Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof h73)) {
                    h73Var = (h73) obj;
                } else {
                    h73Var = new h73(this.mSwanApiContext);
                    this.mApis.put("-254510461", h73Var);
                }
                Pair<Boolean, y32> a = a42.a(h73Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Plugin.invokePluginChooseAddress")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = h73Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                h73 h73Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof h73)) {
                    h73Var = (h73) obj;
                } else {
                    h73Var = new h73(this.mSwanApiContext);
                    this.mApis.put("-254510461", h73Var);
                }
                Pair<Boolean, y32> a = a42.a(h73Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 z = h73Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                h73 h73Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof h73)) {
                    h73Var = (h73) obj;
                } else {
                    h73Var = new h73(this.mSwanApiContext);
                    this.mApis.put("-254510461", h73Var);
                }
                Pair<Boolean, y32> a = a42.a(h73Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Plugin.invokePluginPayment")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = h73Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                ag2 ag2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof ag2)) {
                    ag2Var = (ag2) obj;
                } else {
                    ag2Var = new ag2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", ag2Var);
                }
                Pair<Boolean, y32> a = a42.a(ag2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Prefetch.prefetchResources")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = ag2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPreload", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                se2 se2Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof se2)) {
                    se2Var = (se2) obj;
                } else {
                    se2Var = new se2(this.mSwanApiContext);
                    this.mApis.put("423661539", se2Var);
                }
                Pair<Boolean, y32> a = a42.a(se2Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Preload.preloadStatus")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = se2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                co3 co3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof co3)) {
                    co3Var = (co3) obj;
                } else {
                    co3Var = new co3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", co3Var);
                }
                Pair<Boolean, y32> a = a42.a(co3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "PrivateFile.uploadFileToBos")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 C = co3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naRouter", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                r12 r12Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof r12)) {
                    r12Var = (r12) obj;
                } else {
                    r12Var = new r12(this.mSwanApiContext);
                    this.mApis.put("-1495163604", r12Var);
                }
                Pair<Boolean, y32> a = a42.a(r12Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Router.hideModalPage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = r12Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                r12 r12Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof r12)) {
                    r12Var = (r12) obj;
                } else {
                    r12Var = new r12(this.mSwanApiContext);
                    this.mApis.put("-1495163604", r12Var);
                }
                Pair<Boolean, y32> a = a42.a(r12Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Router.navigateBack")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 B = r12Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                s12 s12Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof s12)) {
                    s12Var = (s12) obj;
                } else {
                    s12Var = new s12(this.mSwanApiContext);
                    this.mApis.put("1968522584", s12Var);
                }
                Pair<Boolean, y32> a = a42.a(s12Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Router.navigateTo")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 H = s12Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                u12 u12Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof u12)) {
                    u12Var = (u12) obj;
                } else {
                    u12Var = new u12(this.mSwanApiContext);
                    this.mApis.put("1317280190", u12Var);
                }
                Pair<Boolean, y32> a = a42.a(u12Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Router.reLaunch")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = u12Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                v12 v12Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof v12)) {
                    v12Var = (v12) obj;
                } else {
                    v12Var = new v12(this.mSwanApiContext);
                    this.mApis.put("-420075743", v12Var);
                }
                Pair<Boolean, y32> a = a42.a(v12Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Router.reLoadErrorPage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = v12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                t12 t12Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof t12)) {
                    t12Var = (t12) obj;
                } else {
                    t12Var = new t12(this.mSwanApiContext);
                    this.mApis.put("1792515533", t12Var);
                }
                Pair<Boolean, y32> a = a42.a(t12Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Router.redirectTo")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 D = t12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                s12 s12Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof s12)) {
                    s12Var = (s12) obj;
                } else {
                    s12Var = new s12(this.mSwanApiContext);
                    this.mApis.put("1968522584", s12Var);
                }
                Pair<Boolean, y32> a = a42.a(s12Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Router.showModalPage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 J = s12Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naSetting", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                y12 y12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof y12)) {
                    y12Var = (y12) obj;
                } else {
                    y12Var = new y12(this.mSwanApiContext);
                    this.mApis.put("-594895721", y12Var);
                }
                Pair<Boolean, y32> a = a42.a(y12Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Setting.getAppInfoSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 F = y12Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                y12 y12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof y12)) {
                    y12Var = (y12) obj;
                } else {
                    y12Var = new y12(this.mSwanApiContext);
                    this.mApis.put("-594895721", y12Var);
                }
                Pair<Boolean, y32> a = a42.a(y12Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Setting.getSlaveIdSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 H = y12Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                x12 x12Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof x12)) {
                    x12Var = (x12) obj;
                } else {
                    x12Var = new x12(this.mSwanApiContext);
                    this.mApis.put("450273045", x12Var);
                }
                Pair<Boolean, y32> a = a42.a(x12Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Setting.isAllowedAdOpenAppSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = x12Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                y12 y12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof y12)) {
                    y12Var = (y12) obj;
                } else {
                    y12Var = new y12(this.mSwanApiContext);
                    this.mApis.put("-594895721", y12Var);
                }
                Pair<Boolean, y32> a = a42.a(y12Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Setting.getSetting")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 G = y12Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                y12 y12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof y12)) {
                    y12Var = (y12) obj;
                } else {
                    y12Var = new y12(this.mSwanApiContext);
                    this.mApis.put("-594895721", y12Var);
                }
                Pair<Boolean, y32> a = a42.a(y12Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Setting.getSwanId")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 I = y12Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                y12 y12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof y12)) {
                    y12Var = (y12) obj;
                } else {
                    y12Var = new y12(this.mSwanApiContext);
                    this.mApis.put("-594895721", y12Var);
                }
                Pair<Boolean, y32> a = a42.a(y12Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Setting.getUserInfo")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 J = y12Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                wi3 wi3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof wi3)) {
                    wi3Var = (wi3) obj;
                } else {
                    wi3Var = new wi3(this.mSwanApiContext);
                    this.mApis.put("712777136", wi3Var);
                }
                Pair<Boolean, y32> a = a42.a(wi3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = wi3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naStorage", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                b22 b22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-804054859", b22Var);
                }
                Pair<Boolean, y32> a = a42.a(b22Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.clearGlobalStorage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = b22Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                b22 b22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-804054859", b22Var);
                }
                Pair<Boolean, y32> a = a42.a(b22Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.clearGlobalStorageSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 C = b22Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                a22 a22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("130910081", a22Var);
                }
                Pair<Boolean, y32> a = a42.a(a22Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.clearStorage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = a22Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                a22 a22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("130910081", a22Var);
                }
                Pair<Boolean, y32> a = a42.a(a22Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.clearStorageSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 C = a22Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                b22 b22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-804054859", b22Var);
                }
                Pair<Boolean, y32> a = a42.a(b22Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageInfo")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 G = b22Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                b22 b22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-804054859", b22Var);
                }
                Pair<Boolean, y32> a = a42.a(b22Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageInfoSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 J = b22Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                a22 a22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("130910081", a22Var);
                }
                Pair<Boolean, y32> a = a42.a(a22Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.getStorageInfo")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 G = a22Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                a22 a22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("130910081", a22Var);
                }
                Pair<Boolean, y32> a = a42.a(a22Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.getStorageInfoSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 J = a22Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                b22 b22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-804054859", b22Var);
                }
                Pair<Boolean, y32> a = a42.a(b22Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 D = b22Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                b22 b22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-804054859", b22Var);
                }
                Pair<Boolean, y32> a = a42.a(b22Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 K = b22Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                a22 a22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("130910081", a22Var);
                }
                Pair<Boolean, y32> a = a42.a(a22Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.getStorage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 D = a22Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                a22 a22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("130910081", a22Var);
                }
                Pair<Boolean, y32> a = a42.a(a22Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.getStorageInfoAsync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 H = a22Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                a22 a22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("130910081", a22Var);
                }
                Pair<Boolean, y32> a = a42.a(a22Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.getStorageSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 K = a22Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                b22 b22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-804054859", b22Var);
                }
                Pair<Boolean, y32> a = a42.a(b22Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.removeGlobalStorage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 R = b22Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                b22 b22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-804054859", b22Var);
                }
                Pair<Boolean, y32> a = a42.a(b22Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.removeGlobalStorageSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 T2 = b22Var.T(str);
                if (T2 == null) {
                    return "";
                }
                return T2.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                a22 a22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("130910081", a22Var);
                }
                Pair<Boolean, y32> a = a42.a(a22Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.removeStorage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 R = a22Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                a22 a22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("130910081", a22Var);
                }
                Pair<Boolean, y32> a = a42.a(a22Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.removeStorageSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 T2 = a22Var.T(str);
                if (T2 == null) {
                    return "";
                }
                return T2.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                b22 b22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-804054859", b22Var);
                }
                Pair<Boolean, y32> a = a42.a(b22Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.setGlobalStorage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 U = b22Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                b22 b22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-804054859", b22Var);
                }
                Pair<Boolean, y32> a = a42.a(b22Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.setGlobalStorageSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 W = b22Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                a22 a22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("130910081", a22Var);
                }
                Pair<Boolean, y32> a = a42.a(a22Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.setStorage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 U = a22Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                a22 a22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("130910081", a22Var);
                }
                Pair<Boolean, y32> a = a42.a(a22Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Storage.setStorageSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 W = a22Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }
        });
        hashMap.put("_naSubscription", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                d22 d22Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("823117982", d22Var);
                }
                Pair<Boolean, y32> a = a42.a(d22Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Subscription.requestSubscribeFormId")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 E = d22Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                e22 e22Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("-947445811", e22Var);
                }
                Pair<Boolean, y32> a = a42.a(e22Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Subscription.subscribeService")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 F = e22Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }
        });
        hashMap.put("_naSystem", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                l22 l22Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof l22)) {
                    l22Var = (l22) obj;
                } else {
                    l22Var = new l22(this.mSwanApiContext);
                    this.mApis.put("1936205521", l22Var);
                }
                Pair<Boolean, y32> a = a42.a(l22Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.exitFullScreen")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = l22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                k22 k22Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof k22)) {
                    k22Var = (k22) obj;
                } else {
                    k22Var = new k22(this.mSwanApiContext);
                    this.mApis.put("1694151270", k22Var);
                }
                Pair<Boolean, y32> a = a42.a(k22Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.getDeviceInfo")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = k22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                m22 m22Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof m22)) {
                    m22Var = (m22) obj;
                } else {
                    m22Var = new m22(this.mSwanApiContext);
                    this.mApis.put("-1321681619", m22Var);
                }
                Pair<Boolean, y32> a = a42.a(m22Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.getDeviceProfile")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = m22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                n22 n22Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof n22)) {
                    n22Var = (n22) obj;
                } else {
                    n22Var = new n22(this.mSwanApiContext);
                    this.mApis.put("-1569246082", n22Var);
                }
                Pair<Boolean, y32> a = a42.a(n22Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.makePhoneCall")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = n22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                p22 p22Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof p22)) {
                    p22Var = (p22) obj;
                } else {
                    p22Var = new p22(this.mSwanApiContext);
                    this.mApis.put("1099851202", p22Var);
                }
                Pair<Boolean, y32> a = a42.a(p22Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.openSMSPanel")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = p22Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                o22 o22Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof o22)) {
                    o22Var = (o22) obj;
                } else {
                    o22Var = new o22(this.mSwanApiContext);
                    this.mApis.put("-1707203360", o22Var);
                }
                Pair<Boolean, y32> a = a42.a(o22Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.requestFullScreen")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 F = o22Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                i22 i22Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof i22)) {
                    i22Var = (i22) obj;
                } else {
                    i22Var = new i22(this.mSwanApiContext);
                    this.mApis.put("-518757484", i22Var);
                }
                Pair<Boolean, y32> a = a42.a(i22Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.setClipboardData")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = i22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                s13 s13Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof s13)) {
                    s13Var = (s13) obj;
                } else {
                    s13Var = new s13(this.mSwanApiContext);
                    this.mApis.put("1161486049", s13Var);
                }
                Pair<Boolean, y32> a = a42.a(s13Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.setErrorPageType")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = s13Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                s22 s22Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof s22)) {
                    s22Var = (s22) obj;
                } else {
                    s22Var = new s22(this.mSwanApiContext);
                    this.mApis.put("447234992", s22Var);
                }
                Pair<Boolean, y32> a = a42.a(s22Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.setMediaVolume")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 z = s22Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                g22 g22Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof g22)) {
                    g22Var = (g22) obj;
                } else {
                    g22Var = new g22(this.mSwanApiContext);
                    this.mApis.put("1372680763", g22Var);
                }
                Pair<Boolean, y32> a = a42.a(g22Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.startAccelerometer")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = g22Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                j22 j22Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof j22)) {
                    j22Var = (j22) obj;
                } else {
                    j22Var = new j22(this.mSwanApiContext);
                    this.mApis.put("1689255576", j22Var);
                }
                Pair<Boolean, y32> a = a42.a(j22Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.startCompass")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = j22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                h22 h22Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof h22)) {
                    h22Var = (h22) obj;
                } else {
                    h22Var = new h22(this.mSwanApiContext);
                    this.mApis.put("99997465", h22Var);
                }
                Pair<Boolean, y32> a = a42.a(h22Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.getBrightness")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = h22Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                i22 i22Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof i22)) {
                    i22Var = (i22) obj;
                } else {
                    i22Var = new i22(this.mSwanApiContext);
                    this.mApis.put("-518757484", i22Var);
                }
                Pair<Boolean, y32> a = a42.a(i22Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.getClipboardData")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = i22Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                s22 s22Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof s22)) {
                    s22Var = (s22) obj;
                } else {
                    s22Var = new s22(this.mSwanApiContext);
                    this.mApis.put("447234992", s22Var);
                }
                Pair<Boolean, y32> a = a42.a(s22Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.getMediaVolume")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = s22Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                g22 g22Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof g22)) {
                    g22Var = (g22) obj;
                } else {
                    g22Var = new g22(this.mSwanApiContext);
                    this.mApis.put("1372680763", g22Var);
                }
                Pair<Boolean, y32> a = a42.a(g22Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.stopAccelerometer")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 B = g22Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                j22 j22Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof j22)) {
                    j22Var = (j22) obj;
                } else {
                    j22Var = new j22(this.mSwanApiContext);
                    this.mApis.put("1689255576", j22Var);
                }
                Pair<Boolean, y32> a = a42.a(j22Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "System.stopCompass")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 z = j22Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naUtils", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                d32 d32Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof d32)) {
                    d32Var = (d32) obj;
                } else {
                    d32Var = new d32(this.mSwanApiContext);
                    this.mApis.put("201194468", d32Var);
                }
                Pair<Boolean, y32> a = a42.a(d32Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.addToDesktop")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 B = d32Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                z22 z22Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof z22)) {
                    z22Var = (z22) obj;
                } else {
                    z22Var = new z22(this.mSwanApiContext);
                    this.mApis.put("-1412306947", z22Var);
                }
                Pair<Boolean, y32> a = a42.a(z22Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.calcMD5")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = z22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                a32 a32Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof a32)) {
                    a32Var = (a32) obj;
                } else {
                    a32Var = new a32(this.mSwanApiContext);
                    this.mApis.put("1626415364", a32Var);
                }
                Pair<Boolean, y32> a = a42.a(a32Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.checkAppInstalled")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = a32Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                c32 c32Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof c32)) {
                    c32Var = (c32) obj;
                } else {
                    c32Var = new c32(this.mSwanApiContext);
                    this.mApis.put("-836768778", c32Var);
                }
                Pair<Boolean, y32> a = a42.a(c32Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.getCommonSysInfo")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = c32Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                e32 e32Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof e32)) {
                    e32Var = (e32) obj;
                } else {
                    e32Var = new e32(this.mSwanApiContext);
                    this.mApis.put("-810858308", e32Var);
                }
                Pair<Boolean, y32> a = a42.a(e32Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.getPerformanceLevel")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = e32Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                i32 i32Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof i32)) {
                    i32Var = (i32) obj;
                } else {
                    i32Var = new i32(this.mSwanApiContext);
                    this.mApis.put("-1011537871", i32Var);
                }
                Pair<Boolean, y32> a = a42.a(i32Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.getSystemInfoAsync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 I = i32Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                f32 f32Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof f32)) {
                    f32Var = (f32) obj;
                } else {
                    f32Var = new f32(this.mSwanApiContext);
                    this.mApis.put("-2097727681", f32Var);
                }
                Pair<Boolean, y32> a = a42.a(f32Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.handleException")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = f32Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                b32 b32Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof b32)) {
                    b32Var = (b32) obj;
                } else {
                    b32Var = new b32(this.mSwanApiContext);
                    this.mApis.put("2084449317", b32Var);
                }
                Pair<Boolean, y32> a = a42.a(b32Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.hasCloseHandler")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = b32Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                eg3 eg3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof eg3)) {
                    eg3Var = (eg3) obj;
                } else {
                    eg3Var = new eg3(this.mSwanApiContext);
                    this.mApis.put("1031678042", eg3Var);
                }
                Pair<Boolean, y32> a = a42.a(eg3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.hideCaptureScreenShareDialog")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 x = eg3Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                g32 g32Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof g32)) {
                    g32Var = (g32) obj;
                } else {
                    g32Var = new g32(this.mSwanApiContext);
                    this.mApis.put("1751900130", g32Var);
                }
                Pair<Boolean, y32> a = a42.a(g32Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.logToFile")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = g32Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                ff3 ff3Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof ff3)) {
                    ff3Var = (ff3) obj;
                } else {
                    ff3Var = new ff3(this.mSwanApiContext);
                    this.mApis.put("1748196865", ff3Var);
                }
                Pair<Boolean, y32> a = a42.a(ff3Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.preloadPackage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = ff3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                h32 h32Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof h32)) {
                    h32Var = (h32) obj;
                } else {
                    h32Var = new h32(this.mSwanApiContext);
                    this.mApis.put("589529211", h32Var);
                }
                Pair<Boolean, y32> a = a42.a(h32Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.previewImage")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 B = h32Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                k32 k32Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof k32)) {
                    k32Var = (k32) obj;
                } else {
                    k32Var = new k32(this.mSwanApiContext);
                    this.mApis.put("-577481801", k32Var);
                }
                Pair<Boolean, y32> a = a42.a(k32Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.ubcFlowJar")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 I = k32Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                i32 i32Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof i32)) {
                    i32Var = (i32) obj;
                } else {
                    i32Var = new i32(this.mSwanApiContext);
                    this.mApis.put("-1011537871", i32Var);
                }
                Pair<Boolean, y32> a = a42.a(i32Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.getCommonSysInfoSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 E = i32Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                i32 i32Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof i32)) {
                    i32Var = (i32) obj;
                } else {
                    i32Var = new i32(this.mSwanApiContext);
                    this.mApis.put("-1011537871", i32Var);
                }
                Pair<Boolean, y32> a = a42.a(i32Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.getSystemInfo")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 H = i32Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                i32 i32Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof i32)) {
                    i32Var = (i32) obj;
                } else {
                    i32Var = new i32(this.mSwanApiContext);
                    this.mApis.put("-1011537871", i32Var);
                }
                Pair<Boolean, y32> a = a42.a(i32Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Utils.getSystemInfoSync")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 J = i32Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naWifi", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                pm3 pm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof pm3)) {
                    pm3Var = (pm3) obj;
                } else {
                    pm3Var = new pm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", pm3Var);
                }
                Pair<Boolean, y32> a = a42.a(pm3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Wifi.connectWifi")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 A = pm3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                pm3 pm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof pm3)) {
                    pm3Var = (pm3) obj;
                } else {
                    pm3Var = new pm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", pm3Var);
                }
                Pair<Boolean, y32> a = a42.a(pm3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Wifi.getConnectedWifi")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 B = pm3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                pm3 pm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof pm3)) {
                    pm3Var = (pm3) obj;
                } else {
                    pm3Var = new pm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", pm3Var);
                }
                Pair<Boolean, y32> a = a42.a(pm3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Wifi.getWifiList")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 C = pm3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                pm3 pm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof pm3)) {
                    pm3Var = (pm3) obj;
                } else {
                    pm3Var = new pm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", pm3Var);
                }
                Pair<Boolean, y32> a = a42.a(pm3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Wifi.startWifi")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 G = pm3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                pm3 pm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof pm3)) {
                    pm3Var = (pm3) obj;
                } else {
                    pm3Var = new pm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", pm3Var);
                }
                Pair<Boolean, y32> a = a42.a(pm3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "Wifi.stopWifi")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 H = pm3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }
}
