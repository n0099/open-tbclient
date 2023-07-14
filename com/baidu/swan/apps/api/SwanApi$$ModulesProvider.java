package com.baidu.swan.apps.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.tieba.a22;
import com.baidu.tieba.a32;
import com.baidu.tieba.ag3;
import com.baidu.tieba.b02;
import com.baidu.tieba.b32;
import com.baidu.tieba.bf3;
import com.baidu.tieba.c02;
import com.baidu.tieba.c12;
import com.baidu.tieba.c22;
import com.baidu.tieba.c32;
import com.baidu.tieba.ce2;
import com.baidu.tieba.d02;
import com.baidu.tieba.d22;
import com.baidu.tieba.d32;
import com.baidu.tieba.d73;
import com.baidu.tieba.e02;
import com.baidu.tieba.e22;
import com.baidu.tieba.e32;
import com.baidu.tieba.f02;
import com.baidu.tieba.f22;
import com.baidu.tieba.g22;
import com.baidu.tieba.g32;
import com.baidu.tieba.h02;
import com.baidu.tieba.h22;
import com.baidu.tieba.i12;
import com.baidu.tieba.i22;
import com.baidu.tieba.i43;
import com.baidu.tieba.j02;
import com.baidu.tieba.j12;
import com.baidu.tieba.j22;
import com.baidu.tieba.k02;
import com.baidu.tieba.k22;
import com.baidu.tieba.l22;
import com.baidu.tieba.lm3;
import com.baidu.tieba.lz1;
import com.baidu.tieba.m13;
import com.baidu.tieba.ms1;
import com.baidu.tieba.n02;
import com.baidu.tieba.n12;
import com.baidu.tieba.o12;
import com.baidu.tieba.o13;
import com.baidu.tieba.o22;
import com.baidu.tieba.oe2;
import com.baidu.tieba.p02;
import com.baidu.tieba.p12;
import com.baidu.tieba.q02;
import com.baidu.tieba.q12;
import com.baidu.tieba.q22;
import com.baidu.tieba.r02;
import com.baidu.tieba.r12;
import com.baidu.tieba.s02;
import com.baidu.tieba.s43;
import com.baidu.tieba.si3;
import com.baidu.tieba.t02;
import com.baidu.tieba.t12;
import com.baidu.tieba.t32;
import com.baidu.tieba.u02;
import com.baidu.tieba.u12;
import com.baidu.tieba.u32;
import com.baidu.tieba.v02;
import com.baidu.tieba.v22;
import com.baidu.tieba.v32;
import com.baidu.tieba.w02;
import com.baidu.tieba.w12;
import com.baidu.tieba.w22;
import com.baidu.tieba.w32;
import com.baidu.tieba.wf2;
import com.baidu.tieba.wz1;
import com.baidu.tieba.x02;
import com.baidu.tieba.x12;
import com.baidu.tieba.x22;
import com.baidu.tieba.y02;
import com.baidu.tieba.y22;
import com.baidu.tieba.yn3;
import com.baidu.tieba.yo2;
import com.baidu.tieba.yz1;
import com.baidu.tieba.z02;
import com.baidu.tieba.z12;
import com.baidu.tieba.z22;
import com.baidu.tieba.zz1;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
@Keep
/* loaded from: classes4.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final wz1 wz1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                c02 c02Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof c02)) {
                    c02Var = (c02) obj;
                } else {
                    c02Var = new c02(this.mSwanApiContext);
                    this.mApis.put("1930258908", c02Var);
                }
                Pair<Boolean, u32> a = w32.a(c02Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Account.checkSession")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = c02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                d02 d02Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof d02)) {
                    d02Var = (d02) obj;
                } else {
                    d02Var = new d02(this.mSwanApiContext);
                    this.mApis.put("-1017914143", d02Var);
                }
                Pair<Boolean, u32> a = w32.a(d02Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Account.getLoginCode")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 C = d02Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                e02 e02Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof e02)) {
                    e02Var = (e02) obj;
                } else {
                    e02Var = new e02(this.mSwanApiContext);
                    this.mApis.put("1754780133", e02Var);
                }
                Pair<Boolean, u32> a = w32.a(e02Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Account.getOpenId")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = e02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                lz1 lz1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof lz1)) {
                    lz1Var = (lz1) obj;
                } else {
                    lz1Var = new lz1(this.mSwanApiContext);
                    this.mApis.put("-343998465", lz1Var);
                }
                Pair<Boolean, u32> a = w32.a(lz1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Account.getUnionBDUSS")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = lz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String login(String str) {
                d02 d02Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof d02)) {
                    d02Var = (d02) obj;
                } else {
                    d02Var = new d02(this.mSwanApiContext);
                    this.mApis.put("-1017914143", d02Var);
                }
                Pair<Boolean, u32> a = w32.a(d02Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Account.login")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 I = d02Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                b02 b02Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof b02)) {
                    b02Var = (b02) obj;
                } else {
                    b02Var = new b02(this.mSwanApiContext);
                    this.mApis.put("-337742792", b02Var);
                }
                Pair<Boolean, u32> a = w32.a(b02Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Account.isBaiduAccountSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = b02Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                d02 d02Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof d02)) {
                    d02Var = (d02) obj;
                } else {
                    d02Var = new d02(this.mSwanApiContext);
                    this.mApis.put("-1017914143", d02Var);
                }
                Pair<Boolean, u32> a = w32.a(d02Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Account.isLoginSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 H = d02Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBasic", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                f02 f02Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof f02)) {
                    f02Var = (f02) obj;
                } else {
                    f02Var = new f02(this.mSwanApiContext);
                    this.mApis.put("-1249666566", f02Var);
                }
                Pair<Boolean, u32> a = w32.a(f02Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Basic.loadSubPackage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 F = f02Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                f02 f02Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof f02)) {
                    f02Var = (f02) obj;
                } else {
                    f02Var = new f02(this.mSwanApiContext);
                    this.mApis.put("-1249666566", f02Var);
                }
                Pair<Boolean, u32> a = w32.a(f02Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Basic.loadSubPackages")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 G = f02Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                ms1 ms1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ms1)) {
                    ms1Var = (ms1) obj;
                } else {
                    ms1Var = new ms1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ms1Var);
                }
                Pair<Boolean, u32> a = w32.a(ms1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Bookshelf.deleteBookshelf")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 K = ms1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                ms1 ms1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ms1)) {
                    ms1Var = (ms1) obj;
                } else {
                    ms1Var = new ms1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ms1Var);
                }
                Pair<Boolean, u32> a = w32.a(ms1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Bookshelf.insertBookshelf")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 P = ms1Var.P(str);
                if (P == null) {
                    return "";
                }
                return P.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                ms1 ms1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ms1)) {
                    ms1Var = (ms1) obj;
                } else {
                    ms1Var = new ms1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ms1Var);
                }
                Pair<Boolean, u32> a = w32.a(ms1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Bookshelf.navigateToBookshelf")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 U = ms1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                ms1 ms1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ms1)) {
                    ms1Var = (ms1) obj;
                } else {
                    ms1Var = new ms1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ms1Var);
                }
                Pair<Boolean, u32> a = w32.a(ms1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Bookshelf.queryBookshelf")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 V = ms1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                ms1 ms1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ms1)) {
                    ms1Var = (ms1) obj;
                } else {
                    ms1Var = new ms1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ms1Var);
                }
                Pair<Boolean, u32> a = w32.a(ms1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Bookshelf.updateBookshelfReadTime")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 X = ms1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naCoupon", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                zz1 zz1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof zz1)) {
                    zz1Var = (zz1) obj;
                } else {
                    zz1Var = new zz1(this.mSwanApiContext);
                    this.mApis.put("-277316359", zz1Var);
                }
                Pair<Boolean, u32> a = w32.a(zz1Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Coupon.getPlatformCoupons")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = zz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                zz1 zz1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof zz1)) {
                    zz1Var = (zz1) obj;
                } else {
                    zz1Var = new zz1(this.mSwanApiContext);
                    this.mApis.put("-277316359", zz1Var);
                }
                Pair<Boolean, u32> a = w32.a(zz1Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Coupon.getUserCoupons")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 z = zz1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                zz1 zz1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof zz1)) {
                    zz1Var = (zz1) obj;
                } else {
                    zz1Var = new zz1(this.mSwanApiContext);
                    this.mApis.put("-277316359", zz1Var);
                }
                Pair<Boolean, u32> a = w32.a(zz1Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Coupon.takeCoupons")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 C = zz1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naFavorite", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                h02 h02Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof h02)) {
                    h02Var = (h02) obj;
                } else {
                    h02Var = new h02(this.mSwanApiContext);
                    this.mApis.put("-1225406515", h02Var);
                }
                Pair<Boolean, u32> a = w32.a(h02Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Favorite.getFavorStatus")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = h02Var.x(str);
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
                Pair<Boolean, u32> a = w32.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Favorite.showFavoriteGuide")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 G = showFavoriteGuideApi.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naFile", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                j02 j02Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof j02)) {
                    j02Var = (j02) obj;
                } else {
                    j02Var = new j02(this.mSwanApiContext);
                    this.mApis.put("-2057135077", j02Var);
                }
                Pair<Boolean, u32> a = w32.a(j02Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "File.shareFile")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = j02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                yo2 yo2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof yo2)) {
                    yo2Var = (yo2) obj;
                } else {
                    yo2Var = new yo2(this.mSwanApiContext);
                    this.mApis.put("2077414795", yo2Var);
                }
                Pair<Boolean, u32> a = w32.a(yo2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "GameCenter.postGameCenterMessage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = yo2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                yo2 yo2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof yo2)) {
                    yo2Var = (yo2) obj;
                } else {
                    yo2Var = new yo2(this.mSwanApiContext);
                    this.mApis.put("2077414795", yo2Var);
                }
                Pair<Boolean, u32> a = w32.a(yo2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "GameCenter.postGameCenterMessageSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = yo2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String download(String str) {
                k02 k02Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof k02)) {
                    k02Var = (k02) obj;
                } else {
                    k02Var = new k02(this.mSwanApiContext);
                    this.mApis.put("-170124576", k02Var);
                }
                Pair<Boolean, u32> a = w32.a(k02Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "HostDownloadManager.download")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = k02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                k02 k02Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof k02)) {
                    k02Var = (k02) obj;
                } else {
                    k02Var = new k02(this.mSwanApiContext);
                    this.mApis.put("-170124576", k02Var);
                }
                Pair<Boolean, u32> a = w32.a(k02Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "HostDownloadManager.openFile")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 z = k02Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String query(String str) {
                k02 k02Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof k02)) {
                    k02Var = (k02) obj;
                } else {
                    k02Var = new k02(this.mSwanApiContext);
                    this.mApis.put("-170124576", k02Var);
                }
                Pair<Boolean, u32> a = w32.a(k02Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "HostDownloadManager.query")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 query = k02Var.query(str);
                if (query == null) {
                    return "";
                }
                return query.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                k02 k02Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof k02)) {
                    k02Var = (k02) obj;
                } else {
                    k02Var = new k02(this.mSwanApiContext);
                    this.mApis.put("-170124576", k02Var);
                }
                Pair<Boolean, u32> a = w32.a(k02Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "HostDownloadManager.openDownloadCenter")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = k02Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naImage", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                m13 m13Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof m13)) {
                    m13Var = (m13) obj;
                } else {
                    m13Var = new m13(this.mSwanApiContext);
                    this.mApis.put("1445003743", m13Var);
                }
                Pair<Boolean, u32> a = w32.a(m13Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Image.callImageMenu")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = m13Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                n02 n02Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof n02)) {
                    n02Var = (n02) obj;
                } else {
                    n02Var = new n02(this.mSwanApiContext);
                    this.mApis.put("-1252730367", n02Var);
                }
                Pair<Boolean, u32> a = w32.a(n02Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Image.compressImage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = n02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naInteraction", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                v02 v02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", v02Var);
                }
                Pair<Boolean, u32> a = w32.a(v02Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.closeTabBar")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = v02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                v02 v02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", v02Var);
                }
                Pair<Boolean, u32> a = w32.a(v02Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.closeTabBarRedDot")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = v02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                r02 r02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof r02)) {
                    r02Var = (r02) obj;
                } else {
                    r02Var = new r02(this.mSwanApiContext);
                    this.mApis.put("-246386074", r02Var);
                }
                Pair<Boolean, u32> a = w32.a(r02Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.hideNavigationBarLoading")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = r02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                t02 t02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof t02)) {
                    t02Var = (t02) obj;
                } else {
                    t02Var = new t02(this.mSwanApiContext);
                    this.mApis.put("-108978463", t02Var);
                }
                Pair<Boolean, u32> a = w32.a(t02Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.openMultiPicker")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 G = t02Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                t02 t02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof t02)) {
                    t02Var = (t02) obj;
                } else {
                    t02Var = new t02(this.mSwanApiContext);
                    this.mApis.put("-108978463", t02Var);
                }
                Pair<Boolean, u32> a = w32.a(t02Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.openPicker")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 H = t02Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                v02 v02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", v02Var);
                }
                Pair<Boolean, u32> a = w32.a(v02Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.openTabBar")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 C = v02Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                s02 s02Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof s02)) {
                    s02Var = (s02) obj;
                } else {
                    s02Var = new s02(this.mSwanApiContext);
                    this.mApis.put("-1750613704", s02Var);
                }
                Pair<Boolean, u32> a = w32.a(s02Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.pageScrollTo")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = s02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                r02 r02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof r02)) {
                    r02Var = (r02) obj;
                } else {
                    r02Var = new r02(this.mSwanApiContext);
                    this.mApis.put("-246386074", r02Var);
                }
                Pair<Boolean, u32> a = w32.a(r02Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.setNavigationBarColor")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 z = r02Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                r02 r02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof r02)) {
                    r02Var = (r02) obj;
                } else {
                    r02Var = new r02(this.mSwanApiContext);
                    this.mApis.put("-246386074", r02Var);
                }
                Pair<Boolean, u32> a = w32.a(r02Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.setNavigationBarTitle")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = r02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                v02 v02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", v02Var);
                }
                Pair<Boolean, u32> a = w32.a(v02Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.setTabBarItem")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 D = v02Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                t02 t02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof t02)) {
                    t02Var = (t02) obj;
                } else {
                    t02Var = new t02(this.mSwanApiContext);
                    this.mApis.put("-108978463", t02Var);
                }
                Pair<Boolean, u32> a = w32.a(t02Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.showDatePickerView")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 L = t02Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                x02 x02Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof x02)) {
                    x02Var = (x02) obj;
                } else {
                    x02Var = new x02(this.mSwanApiContext);
                    this.mApis.put("1172469410", x02Var);
                }
                Pair<Boolean, u32> a = w32.a(x02Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.showHalfScreenWebview")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 K = x02Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                p02 p02Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof p02)) {
                    p02Var = (p02) obj;
                } else {
                    p02Var = new p02(this.mSwanApiContext);
                    this.mApis.put("5236036", p02Var);
                }
                Pair<Boolean, u32> a = w32.a(p02Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.showLoading")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = p02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                q02 q02Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof q02)) {
                    q02Var = (q02) obj;
                } else {
                    q02Var = new q02(this.mSwanApiContext);
                    this.mApis.put("1913747800", q02Var);
                }
                Pair<Boolean, u32> a = w32.a(q02Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.showModal")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = q02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                r02 r02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof r02)) {
                    r02Var = (r02) obj;
                } else {
                    r02Var = new r02(this.mSwanApiContext);
                    this.mApis.put("-246386074", r02Var);
                }
                Pair<Boolean, u32> a = w32.a(r02Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.showNavigationBarLoading")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 B = r02Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                w02 w02Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof w02)) {
                    w02Var = (w02) obj;
                } else {
                    w02Var = new w02(this.mSwanApiContext);
                    this.mApis.put("1159492510", w02Var);
                }
                Pair<Boolean, u32> a = w32.a(w02Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.showToast")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 Q = w02Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                u02 u02Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof u02)) {
                    u02Var = (u02) obj;
                } else {
                    u02Var = new u02(this.mSwanApiContext);
                    this.mApis.put("1165118609", u02Var);
                }
                Pair<Boolean, u32> a = w32.a(u02Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.stopPullDownRefresh")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = u02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                t02 t02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof t02)) {
                    t02Var = (t02) obj;
                } else {
                    t02Var = new t02(this.mSwanApiContext);
                    this.mApis.put("-108978463", t02Var);
                }
                Pair<Boolean, u32> a = w32.a(t02Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.updateMultiPicker")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 M = t02Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                p02 p02Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof p02)) {
                    p02Var = (p02) obj;
                } else {
                    p02Var = new p02(this.mSwanApiContext);
                    this.mApis.put("5236036", p02Var);
                }
                Pair<Boolean, u32> a = w32.a(p02Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.hideLoading")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = p02Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hideToast() {
                w02 w02Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof w02)) {
                    w02Var = (w02) obj;
                } else {
                    w02Var = new w02(this.mSwanApiContext);
                    this.mApis.put("1159492510", w02Var);
                }
                Pair<Boolean, u32> a = w32.a(w02Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.hideToast")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 K = w02Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                y02 y02Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof y02)) {
                    y02Var = (y02) obj;
                } else {
                    y02Var = new y02(this.mSwanApiContext);
                    this.mApis.put("-137346255", y02Var);
                }
                Pair<Boolean, u32> a = w32.a(y02Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Keyboard.startKeyboardHeightChange")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 C = y02Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                y02 y02Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof y02)) {
                    y02Var = (y02) obj;
                } else {
                    y02Var = new y02(this.mSwanApiContext);
                    this.mApis.put("-137346255", y02Var);
                }
                Pair<Boolean, u32> a = w32.a(y02Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Keyboard.stopKeyboardHeightChange")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 D = y02Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naLocationService", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("-397373095", z02Var);
                }
                Pair<Boolean, u32> a = w32.a(z02Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "LocationService.getLocation")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = z02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("-397373095", z02Var);
                }
                Pair<Boolean, u32> a = w32.a(z02Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "LocationService.startLocationUpdate")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = z02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                z02 z02Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("-397373095", z02Var);
                }
                Pair<Boolean, u32> a = w32.a(z02Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "LocationService.stopLocationUpdate")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 B = z02Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naMenu", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                q22 q22Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof q22)) {
                    q22Var = (q22) obj;
                } else {
                    q22Var = new q22(this.mSwanApiContext);
                    this.mApis.put("538070032", q22Var);
                }
                Pair<Boolean, u32> a = w32.a(q22Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = q22Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naNetwork", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                c12 c12Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof c12)) {
                    c12Var = (c12) obj;
                } else {
                    c12Var = new c12(this.mSwanApiContext);
                    this.mApis.put("-1076509454", c12Var);
                }
                Pair<Boolean, u32> a = w32.a(c12Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Network.callService")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = c12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                j12 j12Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof j12)) {
                    j12Var = (j12) obj;
                } else {
                    j12Var = new j12(this.mSwanApiContext);
                    this.mApis.put("968563034", j12Var);
                }
                Pair<Boolean, u32> a = w32.a(j12Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Network.cancelRequest")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 D = j12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                i12 i12Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("453220699", i12Var);
                }
                Pair<Boolean, u32> a = w32.a(i12Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Network.networkStatusChange")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = i12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                i12 i12Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("453220699", i12Var);
                }
                Pair<Boolean, u32> a = w32.a(i12Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Network.getNetworkType")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = i12Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(JsObject jsObject) {
                j12 j12Var;
                String a;
                try {
                    t32.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof j12)) {
                        j12Var = (j12) obj;
                    } else {
                        j12Var = new j12(this.mSwanApiContext);
                        this.mApis.put("968563034", j12Var);
                    }
                    Pair<Boolean, u32> a2 = w32.a(j12Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((u32) a2.second).a();
                    } else if (ce2.a(this.mSwanApiContext.d(), "Network.request")) {
                        a = new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<u32, JSONObject> t = yz1.t(jsObject);
                        if (!((u32) t.first).isSuccess()) {
                            a = ((u32) t.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) t.second;
                            if (jSONObject == null) {
                                a = u32.a.a();
                            } else {
                                v32 V = j12Var.V(jSONObject);
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
                        t32.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                s43 s43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof s43)) {
                    s43Var = (s43) obj;
                } else {
                    s43Var = new s43(this.mSwanApiContext);
                    this.mApis.put("-336396851", s43Var);
                }
                Pair<Boolean, u32> a = w32.a(s43Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Payment.chooseCoupon")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = s43Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                s43 s43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof s43)) {
                    s43Var = (s43) obj;
                } else {
                    s43Var = new s43(this.mSwanApiContext);
                    this.mApis.put("-336396851", s43Var);
                }
                Pair<Boolean, u32> a = w32.a(s43Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Payment.getPaymentInfo")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = s43Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                i43 i43Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof i43)) {
                    i43Var = (i43) obj;
                } else {
                    i43Var = new i43(this.mSwanApiContext);
                    this.mApis.put("1854689529", i43Var);
                }
                Pair<Boolean, u32> a = w32.a(i43Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Payment.requestThirdPayment")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = i43Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                s43 s43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof s43)) {
                    s43Var = (s43) obj;
                } else {
                    s43Var = new s43(this.mSwanApiContext);
                    this.mApis.put("-336396851", s43Var);
                }
                Pair<Boolean, u32> a = w32.a(s43Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Payment.setPaymentInfo")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 z = s43Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPlugin", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                d73 d73Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof d73)) {
                    d73Var = (d73) obj;
                } else {
                    d73Var = new d73(this.mSwanApiContext);
                    this.mApis.put("-254510461", d73Var);
                }
                Pair<Boolean, u32> a = w32.a(d73Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Plugin.invokePluginChooseAddress")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = d73Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                d73 d73Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof d73)) {
                    d73Var = (d73) obj;
                } else {
                    d73Var = new d73(this.mSwanApiContext);
                    this.mApis.put("-254510461", d73Var);
                }
                Pair<Boolean, u32> a = w32.a(d73Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 z = d73Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                d73 d73Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof d73)) {
                    d73Var = (d73) obj;
                } else {
                    d73Var = new d73(this.mSwanApiContext);
                    this.mApis.put("-254510461", d73Var);
                }
                Pair<Boolean, u32> a = w32.a(d73Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Plugin.invokePluginPayment")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = d73Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                wf2 wf2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof wf2)) {
                    wf2Var = (wf2) obj;
                } else {
                    wf2Var = new wf2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", wf2Var);
                }
                Pair<Boolean, u32> a = w32.a(wf2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Prefetch.prefetchResources")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = wf2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPreload", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                oe2 oe2Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof oe2)) {
                    oe2Var = (oe2) obj;
                } else {
                    oe2Var = new oe2(this.mSwanApiContext);
                    this.mApis.put("423661539", oe2Var);
                }
                Pair<Boolean, u32> a = w32.a(oe2Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Preload.preloadStatus")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = oe2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                yn3 yn3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof yn3)) {
                    yn3Var = (yn3) obj;
                } else {
                    yn3Var = new yn3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", yn3Var);
                }
                Pair<Boolean, u32> a = w32.a(yn3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "PrivateFile.uploadFileToBos")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 C = yn3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naRouter", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                n12 n12Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof n12)) {
                    n12Var = (n12) obj;
                } else {
                    n12Var = new n12(this.mSwanApiContext);
                    this.mApis.put("-1495163604", n12Var);
                }
                Pair<Boolean, u32> a = w32.a(n12Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Router.hideModalPage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = n12Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                n12 n12Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof n12)) {
                    n12Var = (n12) obj;
                } else {
                    n12Var = new n12(this.mSwanApiContext);
                    this.mApis.put("-1495163604", n12Var);
                }
                Pair<Boolean, u32> a = w32.a(n12Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Router.navigateBack")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 B = n12Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                o12 o12Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof o12)) {
                    o12Var = (o12) obj;
                } else {
                    o12Var = new o12(this.mSwanApiContext);
                    this.mApis.put("1968522584", o12Var);
                }
                Pair<Boolean, u32> a = w32.a(o12Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Router.navigateTo")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 H = o12Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                q12 q12Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof q12)) {
                    q12Var = (q12) obj;
                } else {
                    q12Var = new q12(this.mSwanApiContext);
                    this.mApis.put("1317280190", q12Var);
                }
                Pair<Boolean, u32> a = w32.a(q12Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Router.reLaunch")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = q12Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                r12 r12Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof r12)) {
                    r12Var = (r12) obj;
                } else {
                    r12Var = new r12(this.mSwanApiContext);
                    this.mApis.put("-420075743", r12Var);
                }
                Pair<Boolean, u32> a = w32.a(r12Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Router.reLoadErrorPage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = r12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                p12 p12Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof p12)) {
                    p12Var = (p12) obj;
                } else {
                    p12Var = new p12(this.mSwanApiContext);
                    this.mApis.put("1792515533", p12Var);
                }
                Pair<Boolean, u32> a = w32.a(p12Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Router.redirectTo")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 D = p12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                o12 o12Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof o12)) {
                    o12Var = (o12) obj;
                } else {
                    o12Var = new o12(this.mSwanApiContext);
                    this.mApis.put("1968522584", o12Var);
                }
                Pair<Boolean, u32> a = w32.a(o12Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Router.showModalPage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 J = o12Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naSetting", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                u12 u12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof u12)) {
                    u12Var = (u12) obj;
                } else {
                    u12Var = new u12(this.mSwanApiContext);
                    this.mApis.put("-594895721", u12Var);
                }
                Pair<Boolean, u32> a = w32.a(u12Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Setting.getAppInfoSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 F = u12Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                u12 u12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof u12)) {
                    u12Var = (u12) obj;
                } else {
                    u12Var = new u12(this.mSwanApiContext);
                    this.mApis.put("-594895721", u12Var);
                }
                Pair<Boolean, u32> a = w32.a(u12Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Setting.getSlaveIdSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 H = u12Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                t12 t12Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof t12)) {
                    t12Var = (t12) obj;
                } else {
                    t12Var = new t12(this.mSwanApiContext);
                    this.mApis.put("450273045", t12Var);
                }
                Pair<Boolean, u32> a = w32.a(t12Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Setting.isAllowedAdOpenAppSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = t12Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                u12 u12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof u12)) {
                    u12Var = (u12) obj;
                } else {
                    u12Var = new u12(this.mSwanApiContext);
                    this.mApis.put("-594895721", u12Var);
                }
                Pair<Boolean, u32> a = w32.a(u12Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Setting.getSetting")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 G = u12Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                u12 u12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof u12)) {
                    u12Var = (u12) obj;
                } else {
                    u12Var = new u12(this.mSwanApiContext);
                    this.mApis.put("-594895721", u12Var);
                }
                Pair<Boolean, u32> a = w32.a(u12Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Setting.getSwanId")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 I = u12Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                u12 u12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof u12)) {
                    u12Var = (u12) obj;
                } else {
                    u12Var = new u12(this.mSwanApiContext);
                    this.mApis.put("-594895721", u12Var);
                }
                Pair<Boolean, u32> a = w32.a(u12Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Setting.getUserInfo")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 J = u12Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                si3 si3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof si3)) {
                    si3Var = (si3) obj;
                } else {
                    si3Var = new si3(this.mSwanApiContext);
                    this.mApis.put("712777136", si3Var);
                }
                Pair<Boolean, u32> a = w32.a(si3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = si3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naStorage", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                x12 x12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof x12)) {
                    x12Var = (x12) obj;
                } else {
                    x12Var = new x12(this.mSwanApiContext);
                    this.mApis.put("-804054859", x12Var);
                }
                Pair<Boolean, u32> a = w32.a(x12Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.clearGlobalStorage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = x12Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                x12 x12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof x12)) {
                    x12Var = (x12) obj;
                } else {
                    x12Var = new x12(this.mSwanApiContext);
                    this.mApis.put("-804054859", x12Var);
                }
                Pair<Boolean, u32> a = w32.a(x12Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.clearGlobalStorageSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 C = x12Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                w12 w12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("130910081", w12Var);
                }
                Pair<Boolean, u32> a = w32.a(w12Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.clearStorage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = w12Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                w12 w12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("130910081", w12Var);
                }
                Pair<Boolean, u32> a = w32.a(w12Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.clearStorageSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 C = w12Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                x12 x12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof x12)) {
                    x12Var = (x12) obj;
                } else {
                    x12Var = new x12(this.mSwanApiContext);
                    this.mApis.put("-804054859", x12Var);
                }
                Pair<Boolean, u32> a = w32.a(x12Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageInfo")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 G = x12Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                x12 x12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof x12)) {
                    x12Var = (x12) obj;
                } else {
                    x12Var = new x12(this.mSwanApiContext);
                    this.mApis.put("-804054859", x12Var);
                }
                Pair<Boolean, u32> a = w32.a(x12Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageInfoSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 J = x12Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                w12 w12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("130910081", w12Var);
                }
                Pair<Boolean, u32> a = w32.a(w12Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.getStorageInfo")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 G = w12Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                w12 w12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("130910081", w12Var);
                }
                Pair<Boolean, u32> a = w32.a(w12Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.getStorageInfoSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 J = w12Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                x12 x12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof x12)) {
                    x12Var = (x12) obj;
                } else {
                    x12Var = new x12(this.mSwanApiContext);
                    this.mApis.put("-804054859", x12Var);
                }
                Pair<Boolean, u32> a = w32.a(x12Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 D = x12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                x12 x12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof x12)) {
                    x12Var = (x12) obj;
                } else {
                    x12Var = new x12(this.mSwanApiContext);
                    this.mApis.put("-804054859", x12Var);
                }
                Pair<Boolean, u32> a = w32.a(x12Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 K = x12Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                w12 w12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("130910081", w12Var);
                }
                Pair<Boolean, u32> a = w32.a(w12Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.getStorage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 D = w12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                w12 w12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("130910081", w12Var);
                }
                Pair<Boolean, u32> a = w32.a(w12Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.getStorageInfoAsync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 H = w12Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                w12 w12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("130910081", w12Var);
                }
                Pair<Boolean, u32> a = w32.a(w12Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.getStorageSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 K = w12Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                x12 x12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof x12)) {
                    x12Var = (x12) obj;
                } else {
                    x12Var = new x12(this.mSwanApiContext);
                    this.mApis.put("-804054859", x12Var);
                }
                Pair<Boolean, u32> a = w32.a(x12Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.removeGlobalStorage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 R = x12Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                x12 x12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof x12)) {
                    x12Var = (x12) obj;
                } else {
                    x12Var = new x12(this.mSwanApiContext);
                    this.mApis.put("-804054859", x12Var);
                }
                Pair<Boolean, u32> a = w32.a(x12Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.removeGlobalStorageSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 T2 = x12Var.T(str);
                if (T2 == null) {
                    return "";
                }
                return T2.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                w12 w12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("130910081", w12Var);
                }
                Pair<Boolean, u32> a = w32.a(w12Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.removeStorage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 R = w12Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                w12 w12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("130910081", w12Var);
                }
                Pair<Boolean, u32> a = w32.a(w12Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.removeStorageSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 T2 = w12Var.T(str);
                if (T2 == null) {
                    return "";
                }
                return T2.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                x12 x12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof x12)) {
                    x12Var = (x12) obj;
                } else {
                    x12Var = new x12(this.mSwanApiContext);
                    this.mApis.put("-804054859", x12Var);
                }
                Pair<Boolean, u32> a = w32.a(x12Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.setGlobalStorage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 U = x12Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                x12 x12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof x12)) {
                    x12Var = (x12) obj;
                } else {
                    x12Var = new x12(this.mSwanApiContext);
                    this.mApis.put("-804054859", x12Var);
                }
                Pair<Boolean, u32> a = w32.a(x12Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.setGlobalStorageSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 W = x12Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                w12 w12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("130910081", w12Var);
                }
                Pair<Boolean, u32> a = w32.a(w12Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.setStorage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 U = w12Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                w12 w12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("130910081", w12Var);
                }
                Pair<Boolean, u32> a = w32.a(w12Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.setStorageSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 W = w12Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }
        });
        hashMap.put("_naSubscription", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                z12 z12Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof z12)) {
                    z12Var = (z12) obj;
                } else {
                    z12Var = new z12(this.mSwanApiContext);
                    this.mApis.put("823117982", z12Var);
                }
                Pair<Boolean, u32> a = w32.a(z12Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Subscription.requestSubscribeFormId")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 E = z12Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                a22 a22Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("-947445811", a22Var);
                }
                Pair<Boolean, u32> a = w32.a(a22Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Subscription.subscribeService")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 F = a22Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }
        });
        hashMap.put("_naSystem", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                h22 h22Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof h22)) {
                    h22Var = (h22) obj;
                } else {
                    h22Var = new h22(this.mSwanApiContext);
                    this.mApis.put("1936205521", h22Var);
                }
                Pair<Boolean, u32> a = w32.a(h22Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.exitFullScreen")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = h22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                g22 g22Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof g22)) {
                    g22Var = (g22) obj;
                } else {
                    g22Var = new g22(this.mSwanApiContext);
                    this.mApis.put("1694151270", g22Var);
                }
                Pair<Boolean, u32> a = w32.a(g22Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.getDeviceInfo")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = g22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                i22 i22Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof i22)) {
                    i22Var = (i22) obj;
                } else {
                    i22Var = new i22(this.mSwanApiContext);
                    this.mApis.put("-1321681619", i22Var);
                }
                Pair<Boolean, u32> a = w32.a(i22Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.getDeviceProfile")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = i22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                j22 j22Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof j22)) {
                    j22Var = (j22) obj;
                } else {
                    j22Var = new j22(this.mSwanApiContext);
                    this.mApis.put("-1569246082", j22Var);
                }
                Pair<Boolean, u32> a = w32.a(j22Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.makePhoneCall")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = j22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                l22 l22Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof l22)) {
                    l22Var = (l22) obj;
                } else {
                    l22Var = new l22(this.mSwanApiContext);
                    this.mApis.put("1099851202", l22Var);
                }
                Pair<Boolean, u32> a = w32.a(l22Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.openSMSPanel")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = l22Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                k22 k22Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof k22)) {
                    k22Var = (k22) obj;
                } else {
                    k22Var = new k22(this.mSwanApiContext);
                    this.mApis.put("-1707203360", k22Var);
                }
                Pair<Boolean, u32> a = w32.a(k22Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.requestFullScreen")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 F = k22Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                e22 e22Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("-518757484", e22Var);
                }
                Pair<Boolean, u32> a = w32.a(e22Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.setClipboardData")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = e22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                o13 o13Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof o13)) {
                    o13Var = (o13) obj;
                } else {
                    o13Var = new o13(this.mSwanApiContext);
                    this.mApis.put("1161486049", o13Var);
                }
                Pair<Boolean, u32> a = w32.a(o13Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.setErrorPageType")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = o13Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                o22 o22Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof o22)) {
                    o22Var = (o22) obj;
                } else {
                    o22Var = new o22(this.mSwanApiContext);
                    this.mApis.put("447234992", o22Var);
                }
                Pair<Boolean, u32> a = w32.a(o22Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.setMediaVolume")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 z = o22Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                c22 c22Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof c22)) {
                    c22Var = (c22) obj;
                } else {
                    c22Var = new c22(this.mSwanApiContext);
                    this.mApis.put("1372680763", c22Var);
                }
                Pair<Boolean, u32> a = w32.a(c22Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.startAccelerometer")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = c22Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                f22 f22Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof f22)) {
                    f22Var = (f22) obj;
                } else {
                    f22Var = new f22(this.mSwanApiContext);
                    this.mApis.put("1689255576", f22Var);
                }
                Pair<Boolean, u32> a = w32.a(f22Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.startCompass")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = f22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                d22 d22Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("99997465", d22Var);
                }
                Pair<Boolean, u32> a = w32.a(d22Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.getBrightness")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = d22Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                e22 e22Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("-518757484", e22Var);
                }
                Pair<Boolean, u32> a = w32.a(e22Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.getClipboardData")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = e22Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                o22 o22Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof o22)) {
                    o22Var = (o22) obj;
                } else {
                    o22Var = new o22(this.mSwanApiContext);
                    this.mApis.put("447234992", o22Var);
                }
                Pair<Boolean, u32> a = w32.a(o22Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.getMediaVolume")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = o22Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                c22 c22Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof c22)) {
                    c22Var = (c22) obj;
                } else {
                    c22Var = new c22(this.mSwanApiContext);
                    this.mApis.put("1372680763", c22Var);
                }
                Pair<Boolean, u32> a = w32.a(c22Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.stopAccelerometer")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 B = c22Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                f22 f22Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof f22)) {
                    f22Var = (f22) obj;
                } else {
                    f22Var = new f22(this.mSwanApiContext);
                    this.mApis.put("1689255576", f22Var);
                }
                Pair<Boolean, u32> a = w32.a(f22Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.stopCompass")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 z = f22Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naUtils", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                z22 z22Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof z22)) {
                    z22Var = (z22) obj;
                } else {
                    z22Var = new z22(this.mSwanApiContext);
                    this.mApis.put("201194468", z22Var);
                }
                Pair<Boolean, u32> a = w32.a(z22Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.addToDesktop")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 B = z22Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                v22 v22Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof v22)) {
                    v22Var = (v22) obj;
                } else {
                    v22Var = new v22(this.mSwanApiContext);
                    this.mApis.put("-1412306947", v22Var);
                }
                Pair<Boolean, u32> a = w32.a(v22Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.calcMD5")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = v22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                w22 w22Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof w22)) {
                    w22Var = (w22) obj;
                } else {
                    w22Var = new w22(this.mSwanApiContext);
                    this.mApis.put("1626415364", w22Var);
                }
                Pair<Boolean, u32> a = w32.a(w22Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.checkAppInstalled")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = w22Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                y22 y22Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof y22)) {
                    y22Var = (y22) obj;
                } else {
                    y22Var = new y22(this.mSwanApiContext);
                    this.mApis.put("-836768778", y22Var);
                }
                Pair<Boolean, u32> a = w32.a(y22Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.getCommonSysInfo")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = y22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                a32 a32Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof a32)) {
                    a32Var = (a32) obj;
                } else {
                    a32Var = new a32(this.mSwanApiContext);
                    this.mApis.put("-810858308", a32Var);
                }
                Pair<Boolean, u32> a = w32.a(a32Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.getPerformanceLevel")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = a32Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                e32 e32Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof e32)) {
                    e32Var = (e32) obj;
                } else {
                    e32Var = new e32(this.mSwanApiContext);
                    this.mApis.put("-1011537871", e32Var);
                }
                Pair<Boolean, u32> a = w32.a(e32Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.getSystemInfoAsync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 I = e32Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                b32 b32Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof b32)) {
                    b32Var = (b32) obj;
                } else {
                    b32Var = new b32(this.mSwanApiContext);
                    this.mApis.put("-2097727681", b32Var);
                }
                Pair<Boolean, u32> a = w32.a(b32Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.handleException")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = b32Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                x22 x22Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof x22)) {
                    x22Var = (x22) obj;
                } else {
                    x22Var = new x22(this.mSwanApiContext);
                    this.mApis.put("2084449317", x22Var);
                }
                Pair<Boolean, u32> a = w32.a(x22Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.hasCloseHandler")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = x22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                ag3 ag3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof ag3)) {
                    ag3Var = (ag3) obj;
                } else {
                    ag3Var = new ag3(this.mSwanApiContext);
                    this.mApis.put("1031678042", ag3Var);
                }
                Pair<Boolean, u32> a = w32.a(ag3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.hideCaptureScreenShareDialog")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = ag3Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                c32 c32Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof c32)) {
                    c32Var = (c32) obj;
                } else {
                    c32Var = new c32(this.mSwanApiContext);
                    this.mApis.put("1751900130", c32Var);
                }
                Pair<Boolean, u32> a = w32.a(c32Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.logToFile")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = c32Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                bf3 bf3Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof bf3)) {
                    bf3Var = (bf3) obj;
                } else {
                    bf3Var = new bf3(this.mSwanApiContext);
                    this.mApis.put("1748196865", bf3Var);
                }
                Pair<Boolean, u32> a = w32.a(bf3Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.preloadPackage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = bf3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                d32 d32Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof d32)) {
                    d32Var = (d32) obj;
                } else {
                    d32Var = new d32(this.mSwanApiContext);
                    this.mApis.put("589529211", d32Var);
                }
                Pair<Boolean, u32> a = w32.a(d32Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.previewImage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 B = d32Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                g32 g32Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof g32)) {
                    g32Var = (g32) obj;
                } else {
                    g32Var = new g32(this.mSwanApiContext);
                    this.mApis.put("-577481801", g32Var);
                }
                Pair<Boolean, u32> a = w32.a(g32Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.ubcFlowJar")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 I = g32Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                e32 e32Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof e32)) {
                    e32Var = (e32) obj;
                } else {
                    e32Var = new e32(this.mSwanApiContext);
                    this.mApis.put("-1011537871", e32Var);
                }
                Pair<Boolean, u32> a = w32.a(e32Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.getCommonSysInfoSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 E = e32Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                e32 e32Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof e32)) {
                    e32Var = (e32) obj;
                } else {
                    e32Var = new e32(this.mSwanApiContext);
                    this.mApis.put("-1011537871", e32Var);
                }
                Pair<Boolean, u32> a = w32.a(e32Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.getSystemInfo")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 H = e32Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                e32 e32Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof e32)) {
                    e32Var = (e32) obj;
                } else {
                    e32Var = new e32(this.mSwanApiContext);
                    this.mApis.put("-1011537871", e32Var);
                }
                Pair<Boolean, u32> a = w32.a(e32Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.getSystemInfoSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 J = e32Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naWifi", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                lm3 lm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof lm3)) {
                    lm3Var = (lm3) obj;
                } else {
                    lm3Var = new lm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", lm3Var);
                }
                Pair<Boolean, u32> a = w32.a(lm3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Wifi.connectWifi")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = lm3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                lm3 lm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof lm3)) {
                    lm3Var = (lm3) obj;
                } else {
                    lm3Var = new lm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", lm3Var);
                }
                Pair<Boolean, u32> a = w32.a(lm3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Wifi.getConnectedWifi")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 B = lm3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                lm3 lm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof lm3)) {
                    lm3Var = (lm3) obj;
                } else {
                    lm3Var = new lm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", lm3Var);
                }
                Pair<Boolean, u32> a = w32.a(lm3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Wifi.getWifiList")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 C = lm3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                lm3 lm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof lm3)) {
                    lm3Var = (lm3) obj;
                } else {
                    lm3Var = new lm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", lm3Var);
                }
                Pair<Boolean, u32> a = w32.a(lm3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Wifi.startWifi")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 G = lm3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                lm3 lm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof lm3)) {
                    lm3Var = (lm3) obj;
                } else {
                    lm3Var = new lm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", lm3Var);
                }
                Pair<Boolean, u32> a = w32.a(lm3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Wifi.stopWifi")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 H = lm3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final wz1 wz1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                c02 c02Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof c02)) {
                    c02Var = (c02) obj;
                } else {
                    c02Var = new c02(this.mSwanApiContext);
                    this.mApis.put("1930258908", c02Var);
                }
                Pair<Boolean, u32> a = w32.a(c02Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Account.checkSession")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = c02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                d02 d02Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof d02)) {
                    d02Var = (d02) obj;
                } else {
                    d02Var = new d02(this.mSwanApiContext);
                    this.mApis.put("-1017914143", d02Var);
                }
                Pair<Boolean, u32> a = w32.a(d02Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Account.getLoginCode")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 C = d02Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                e02 e02Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof e02)) {
                    e02Var = (e02) obj;
                } else {
                    e02Var = new e02(this.mSwanApiContext);
                    this.mApis.put("1754780133", e02Var);
                }
                Pair<Boolean, u32> a = w32.a(e02Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Account.getOpenId")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = e02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                lz1 lz1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof lz1)) {
                    lz1Var = (lz1) obj;
                } else {
                    lz1Var = new lz1(this.mSwanApiContext);
                    this.mApis.put("-343998465", lz1Var);
                }
                Pair<Boolean, u32> a = w32.a(lz1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Account.getUnionBDUSS")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = lz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String login(String str) {
                d02 d02Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof d02)) {
                    d02Var = (d02) obj;
                } else {
                    d02Var = new d02(this.mSwanApiContext);
                    this.mApis.put("-1017914143", d02Var);
                }
                Pair<Boolean, u32> a = w32.a(d02Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Account.login")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 I = d02Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                b02 b02Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof b02)) {
                    b02Var = (b02) obj;
                } else {
                    b02Var = new b02(this.mSwanApiContext);
                    this.mApis.put("-337742792", b02Var);
                }
                Pair<Boolean, u32> a = w32.a(b02Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Account.isBaiduAccountSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = b02Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                d02 d02Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof d02)) {
                    d02Var = (d02) obj;
                } else {
                    d02Var = new d02(this.mSwanApiContext);
                    this.mApis.put("-1017914143", d02Var);
                }
                Pair<Boolean, u32> a = w32.a(d02Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Account.isLoginSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 H = d02Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBasic", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                f02 f02Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof f02)) {
                    f02Var = (f02) obj;
                } else {
                    f02Var = new f02(this.mSwanApiContext);
                    this.mApis.put("-1249666566", f02Var);
                }
                Pair<Boolean, u32> a = w32.a(f02Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Basic.loadSubPackage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 F = f02Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                f02 f02Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof f02)) {
                    f02Var = (f02) obj;
                } else {
                    f02Var = new f02(this.mSwanApiContext);
                    this.mApis.put("-1249666566", f02Var);
                }
                Pair<Boolean, u32> a = w32.a(f02Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Basic.loadSubPackages")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 G = f02Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                ms1 ms1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ms1)) {
                    ms1Var = (ms1) obj;
                } else {
                    ms1Var = new ms1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ms1Var);
                }
                Pair<Boolean, u32> a = w32.a(ms1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Bookshelf.deleteBookshelf")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 K = ms1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                ms1 ms1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ms1)) {
                    ms1Var = (ms1) obj;
                } else {
                    ms1Var = new ms1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ms1Var);
                }
                Pair<Boolean, u32> a = w32.a(ms1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Bookshelf.insertBookshelf")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 P = ms1Var.P(str);
                if (P == null) {
                    return "";
                }
                return P.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                ms1 ms1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ms1)) {
                    ms1Var = (ms1) obj;
                } else {
                    ms1Var = new ms1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ms1Var);
                }
                Pair<Boolean, u32> a = w32.a(ms1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Bookshelf.navigateToBookshelf")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 U = ms1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                ms1 ms1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ms1)) {
                    ms1Var = (ms1) obj;
                } else {
                    ms1Var = new ms1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ms1Var);
                }
                Pair<Boolean, u32> a = w32.a(ms1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Bookshelf.queryBookshelf")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 V = ms1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                ms1 ms1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ms1)) {
                    ms1Var = (ms1) obj;
                } else {
                    ms1Var = new ms1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ms1Var);
                }
                Pair<Boolean, u32> a = w32.a(ms1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Bookshelf.updateBookshelfReadTime")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 X = ms1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naCoupon", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                zz1 zz1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof zz1)) {
                    zz1Var = (zz1) obj;
                } else {
                    zz1Var = new zz1(this.mSwanApiContext);
                    this.mApis.put("-277316359", zz1Var);
                }
                Pair<Boolean, u32> a = w32.a(zz1Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Coupon.getPlatformCoupons")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = zz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                zz1 zz1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof zz1)) {
                    zz1Var = (zz1) obj;
                } else {
                    zz1Var = new zz1(this.mSwanApiContext);
                    this.mApis.put("-277316359", zz1Var);
                }
                Pair<Boolean, u32> a = w32.a(zz1Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Coupon.getUserCoupons")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 z = zz1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                zz1 zz1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof zz1)) {
                    zz1Var = (zz1) obj;
                } else {
                    zz1Var = new zz1(this.mSwanApiContext);
                    this.mApis.put("-277316359", zz1Var);
                }
                Pair<Boolean, u32> a = w32.a(zz1Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Coupon.takeCoupons")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 C = zz1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naFavorite", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                h02 h02Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof h02)) {
                    h02Var = (h02) obj;
                } else {
                    h02Var = new h02(this.mSwanApiContext);
                    this.mApis.put("-1225406515", h02Var);
                }
                Pair<Boolean, u32> a = w32.a(h02Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Favorite.getFavorStatus")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = h02Var.x(str);
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
                Pair<Boolean, u32> a = w32.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Favorite.showFavoriteGuide")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 G = showFavoriteGuideApi.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naFile", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                j02 j02Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof j02)) {
                    j02Var = (j02) obj;
                } else {
                    j02Var = new j02(this.mSwanApiContext);
                    this.mApis.put("-2057135077", j02Var);
                }
                Pair<Boolean, u32> a = w32.a(j02Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "File.shareFile")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = j02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                yo2 yo2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof yo2)) {
                    yo2Var = (yo2) obj;
                } else {
                    yo2Var = new yo2(this.mSwanApiContext);
                    this.mApis.put("2077414795", yo2Var);
                }
                Pair<Boolean, u32> a = w32.a(yo2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "GameCenter.postGameCenterMessage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = yo2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                yo2 yo2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof yo2)) {
                    yo2Var = (yo2) obj;
                } else {
                    yo2Var = new yo2(this.mSwanApiContext);
                    this.mApis.put("2077414795", yo2Var);
                }
                Pair<Boolean, u32> a = w32.a(yo2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "GameCenter.postGameCenterMessageSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = yo2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String download(String str) {
                k02 k02Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof k02)) {
                    k02Var = (k02) obj;
                } else {
                    k02Var = new k02(this.mSwanApiContext);
                    this.mApis.put("-170124576", k02Var);
                }
                Pair<Boolean, u32> a = w32.a(k02Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "HostDownloadManager.download")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = k02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                k02 k02Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof k02)) {
                    k02Var = (k02) obj;
                } else {
                    k02Var = new k02(this.mSwanApiContext);
                    this.mApis.put("-170124576", k02Var);
                }
                Pair<Boolean, u32> a = w32.a(k02Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "HostDownloadManager.openFile")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 z = k02Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String query(String str) {
                k02 k02Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof k02)) {
                    k02Var = (k02) obj;
                } else {
                    k02Var = new k02(this.mSwanApiContext);
                    this.mApis.put("-170124576", k02Var);
                }
                Pair<Boolean, u32> a = w32.a(k02Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "HostDownloadManager.query")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 query = k02Var.query(str);
                if (query == null) {
                    return "";
                }
                return query.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                k02 k02Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof k02)) {
                    k02Var = (k02) obj;
                } else {
                    k02Var = new k02(this.mSwanApiContext);
                    this.mApis.put("-170124576", k02Var);
                }
                Pair<Boolean, u32> a = w32.a(k02Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "HostDownloadManager.openDownloadCenter")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = k02Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naImage", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                m13 m13Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof m13)) {
                    m13Var = (m13) obj;
                } else {
                    m13Var = new m13(this.mSwanApiContext);
                    this.mApis.put("1445003743", m13Var);
                }
                Pair<Boolean, u32> a = w32.a(m13Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Image.callImageMenu")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = m13Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                n02 n02Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof n02)) {
                    n02Var = (n02) obj;
                } else {
                    n02Var = new n02(this.mSwanApiContext);
                    this.mApis.put("-1252730367", n02Var);
                }
                Pair<Boolean, u32> a = w32.a(n02Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Image.compressImage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = n02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naInteraction", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                v02 v02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", v02Var);
                }
                Pair<Boolean, u32> a = w32.a(v02Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.closeTabBar")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = v02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                v02 v02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", v02Var);
                }
                Pair<Boolean, u32> a = w32.a(v02Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.closeTabBarRedDot")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = v02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                r02 r02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof r02)) {
                    r02Var = (r02) obj;
                } else {
                    r02Var = new r02(this.mSwanApiContext);
                    this.mApis.put("-246386074", r02Var);
                }
                Pair<Boolean, u32> a = w32.a(r02Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.hideNavigationBarLoading")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = r02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                t02 t02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof t02)) {
                    t02Var = (t02) obj;
                } else {
                    t02Var = new t02(this.mSwanApiContext);
                    this.mApis.put("-108978463", t02Var);
                }
                Pair<Boolean, u32> a = w32.a(t02Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.openMultiPicker")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 G = t02Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                t02 t02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof t02)) {
                    t02Var = (t02) obj;
                } else {
                    t02Var = new t02(this.mSwanApiContext);
                    this.mApis.put("-108978463", t02Var);
                }
                Pair<Boolean, u32> a = w32.a(t02Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.openPicker")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 H = t02Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                v02 v02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", v02Var);
                }
                Pair<Boolean, u32> a = w32.a(v02Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.openTabBar")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 C = v02Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                s02 s02Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof s02)) {
                    s02Var = (s02) obj;
                } else {
                    s02Var = new s02(this.mSwanApiContext);
                    this.mApis.put("-1750613704", s02Var);
                }
                Pair<Boolean, u32> a = w32.a(s02Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.pageScrollTo")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = s02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                r02 r02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof r02)) {
                    r02Var = (r02) obj;
                } else {
                    r02Var = new r02(this.mSwanApiContext);
                    this.mApis.put("-246386074", r02Var);
                }
                Pair<Boolean, u32> a = w32.a(r02Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.setNavigationBarColor")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 z = r02Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                r02 r02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof r02)) {
                    r02Var = (r02) obj;
                } else {
                    r02Var = new r02(this.mSwanApiContext);
                    this.mApis.put("-246386074", r02Var);
                }
                Pair<Boolean, u32> a = w32.a(r02Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.setNavigationBarTitle")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = r02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                v02 v02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", v02Var);
                }
                Pair<Boolean, u32> a = w32.a(v02Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.setTabBarItem")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 D = v02Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                t02 t02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof t02)) {
                    t02Var = (t02) obj;
                } else {
                    t02Var = new t02(this.mSwanApiContext);
                    this.mApis.put("-108978463", t02Var);
                }
                Pair<Boolean, u32> a = w32.a(t02Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.showDatePickerView")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 L = t02Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                x02 x02Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof x02)) {
                    x02Var = (x02) obj;
                } else {
                    x02Var = new x02(this.mSwanApiContext);
                    this.mApis.put("1172469410", x02Var);
                }
                Pair<Boolean, u32> a = w32.a(x02Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.showHalfScreenWebview")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 K = x02Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                p02 p02Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof p02)) {
                    p02Var = (p02) obj;
                } else {
                    p02Var = new p02(this.mSwanApiContext);
                    this.mApis.put("5236036", p02Var);
                }
                Pair<Boolean, u32> a = w32.a(p02Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.showLoading")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = p02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                q02 q02Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof q02)) {
                    q02Var = (q02) obj;
                } else {
                    q02Var = new q02(this.mSwanApiContext);
                    this.mApis.put("1913747800", q02Var);
                }
                Pair<Boolean, u32> a = w32.a(q02Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.showModal")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = q02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                r02 r02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof r02)) {
                    r02Var = (r02) obj;
                } else {
                    r02Var = new r02(this.mSwanApiContext);
                    this.mApis.put("-246386074", r02Var);
                }
                Pair<Boolean, u32> a = w32.a(r02Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.showNavigationBarLoading")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 B = r02Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                w02 w02Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof w02)) {
                    w02Var = (w02) obj;
                } else {
                    w02Var = new w02(this.mSwanApiContext);
                    this.mApis.put("1159492510", w02Var);
                }
                Pair<Boolean, u32> a = w32.a(w02Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.showToast")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 Q = w02Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                u02 u02Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof u02)) {
                    u02Var = (u02) obj;
                } else {
                    u02Var = new u02(this.mSwanApiContext);
                    this.mApis.put("1165118609", u02Var);
                }
                Pair<Boolean, u32> a = w32.a(u02Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.stopPullDownRefresh")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = u02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                t02 t02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof t02)) {
                    t02Var = (t02) obj;
                } else {
                    t02Var = new t02(this.mSwanApiContext);
                    this.mApis.put("-108978463", t02Var);
                }
                Pair<Boolean, u32> a = w32.a(t02Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.updateMultiPicker")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 M = t02Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                p02 p02Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof p02)) {
                    p02Var = (p02) obj;
                } else {
                    p02Var = new p02(this.mSwanApiContext);
                    this.mApis.put("5236036", p02Var);
                }
                Pair<Boolean, u32> a = w32.a(p02Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.hideLoading")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = p02Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hideToast() {
                w02 w02Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof w02)) {
                    w02Var = (w02) obj;
                } else {
                    w02Var = new w02(this.mSwanApiContext);
                    this.mApis.put("1159492510", w02Var);
                }
                Pair<Boolean, u32> a = w32.a(w02Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Interaction.hideToast")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 K = w02Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                y02 y02Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof y02)) {
                    y02Var = (y02) obj;
                } else {
                    y02Var = new y02(this.mSwanApiContext);
                    this.mApis.put("-137346255", y02Var);
                }
                Pair<Boolean, u32> a = w32.a(y02Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Keyboard.startKeyboardHeightChange")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 C = y02Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                y02 y02Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof y02)) {
                    y02Var = (y02) obj;
                } else {
                    y02Var = new y02(this.mSwanApiContext);
                    this.mApis.put("-137346255", y02Var);
                }
                Pair<Boolean, u32> a = w32.a(y02Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Keyboard.stopKeyboardHeightChange")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 D = y02Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naLocationService", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("-397373095", z02Var);
                }
                Pair<Boolean, u32> a = w32.a(z02Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "LocationService.getLocation")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = z02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("-397373095", z02Var);
                }
                Pair<Boolean, u32> a = w32.a(z02Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "LocationService.startLocationUpdate")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = z02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                z02 z02Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("-397373095", z02Var);
                }
                Pair<Boolean, u32> a = w32.a(z02Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "LocationService.stopLocationUpdate")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 B = z02Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naMenu", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                q22 q22Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof q22)) {
                    q22Var = (q22) obj;
                } else {
                    q22Var = new q22(this.mSwanApiContext);
                    this.mApis.put("538070032", q22Var);
                }
                Pair<Boolean, u32> a = w32.a(q22Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = q22Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naNetwork", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                c12 c12Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof c12)) {
                    c12Var = (c12) obj;
                } else {
                    c12Var = new c12(this.mSwanApiContext);
                    this.mApis.put("-1076509454", c12Var);
                }
                Pair<Boolean, u32> a = w32.a(c12Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Network.callService")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = c12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                j12 j12Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof j12)) {
                    j12Var = (j12) obj;
                } else {
                    j12Var = new j12(this.mSwanApiContext);
                    this.mApis.put("968563034", j12Var);
                }
                Pair<Boolean, u32> a = w32.a(j12Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Network.cancelRequest")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 D = j12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                i12 i12Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("453220699", i12Var);
                }
                Pair<Boolean, u32> a = w32.a(i12Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Network.networkStatusChange")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = i12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                i12 i12Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("453220699", i12Var);
                }
                Pair<Boolean, u32> a = w32.a(i12Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Network.getNetworkType")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = i12Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(String str) {
                j12 j12Var;
                String a;
                try {
                    t32.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof j12)) {
                        j12Var = (j12) obj;
                    } else {
                        j12Var = new j12(this.mSwanApiContext);
                        this.mApis.put("968563034", j12Var);
                    }
                    Pair<Boolean, u32> a2 = w32.a(j12Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((u32) a2.second).a();
                    } else if (ce2.a(this.mSwanApiContext.d(), "Network.request")) {
                        a = new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<u32, JSONObject> u = yz1.u(str);
                        if (!((u32) u.first).isSuccess()) {
                            a = ((u32) u.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) u.second;
                            if (jSONObject == null) {
                                a = u32.a.a();
                            } else {
                                v32 V = j12Var.V(jSONObject);
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
                        t32.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                s43 s43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof s43)) {
                    s43Var = (s43) obj;
                } else {
                    s43Var = new s43(this.mSwanApiContext);
                    this.mApis.put("-336396851", s43Var);
                }
                Pair<Boolean, u32> a = w32.a(s43Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Payment.chooseCoupon")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = s43Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                s43 s43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof s43)) {
                    s43Var = (s43) obj;
                } else {
                    s43Var = new s43(this.mSwanApiContext);
                    this.mApis.put("-336396851", s43Var);
                }
                Pair<Boolean, u32> a = w32.a(s43Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Payment.getPaymentInfo")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = s43Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                i43 i43Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof i43)) {
                    i43Var = (i43) obj;
                } else {
                    i43Var = new i43(this.mSwanApiContext);
                    this.mApis.put("1854689529", i43Var);
                }
                Pair<Boolean, u32> a = w32.a(i43Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Payment.requestThirdPayment")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = i43Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                s43 s43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof s43)) {
                    s43Var = (s43) obj;
                } else {
                    s43Var = new s43(this.mSwanApiContext);
                    this.mApis.put("-336396851", s43Var);
                }
                Pair<Boolean, u32> a = w32.a(s43Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Payment.setPaymentInfo")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 z = s43Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPlugin", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                d73 d73Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof d73)) {
                    d73Var = (d73) obj;
                } else {
                    d73Var = new d73(this.mSwanApiContext);
                    this.mApis.put("-254510461", d73Var);
                }
                Pair<Boolean, u32> a = w32.a(d73Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Plugin.invokePluginChooseAddress")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = d73Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                d73 d73Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof d73)) {
                    d73Var = (d73) obj;
                } else {
                    d73Var = new d73(this.mSwanApiContext);
                    this.mApis.put("-254510461", d73Var);
                }
                Pair<Boolean, u32> a = w32.a(d73Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 z = d73Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                d73 d73Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof d73)) {
                    d73Var = (d73) obj;
                } else {
                    d73Var = new d73(this.mSwanApiContext);
                    this.mApis.put("-254510461", d73Var);
                }
                Pair<Boolean, u32> a = w32.a(d73Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Plugin.invokePluginPayment")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = d73Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                wf2 wf2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof wf2)) {
                    wf2Var = (wf2) obj;
                } else {
                    wf2Var = new wf2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", wf2Var);
                }
                Pair<Boolean, u32> a = w32.a(wf2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Prefetch.prefetchResources")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = wf2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPreload", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                oe2 oe2Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof oe2)) {
                    oe2Var = (oe2) obj;
                } else {
                    oe2Var = new oe2(this.mSwanApiContext);
                    this.mApis.put("423661539", oe2Var);
                }
                Pair<Boolean, u32> a = w32.a(oe2Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Preload.preloadStatus")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = oe2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                yn3 yn3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof yn3)) {
                    yn3Var = (yn3) obj;
                } else {
                    yn3Var = new yn3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", yn3Var);
                }
                Pair<Boolean, u32> a = w32.a(yn3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "PrivateFile.uploadFileToBos")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 C = yn3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naRouter", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                n12 n12Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof n12)) {
                    n12Var = (n12) obj;
                } else {
                    n12Var = new n12(this.mSwanApiContext);
                    this.mApis.put("-1495163604", n12Var);
                }
                Pair<Boolean, u32> a = w32.a(n12Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Router.hideModalPage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = n12Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                n12 n12Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof n12)) {
                    n12Var = (n12) obj;
                } else {
                    n12Var = new n12(this.mSwanApiContext);
                    this.mApis.put("-1495163604", n12Var);
                }
                Pair<Boolean, u32> a = w32.a(n12Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Router.navigateBack")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 B = n12Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                o12 o12Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof o12)) {
                    o12Var = (o12) obj;
                } else {
                    o12Var = new o12(this.mSwanApiContext);
                    this.mApis.put("1968522584", o12Var);
                }
                Pair<Boolean, u32> a = w32.a(o12Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Router.navigateTo")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 H = o12Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                q12 q12Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof q12)) {
                    q12Var = (q12) obj;
                } else {
                    q12Var = new q12(this.mSwanApiContext);
                    this.mApis.put("1317280190", q12Var);
                }
                Pair<Boolean, u32> a = w32.a(q12Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Router.reLaunch")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = q12Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                r12 r12Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof r12)) {
                    r12Var = (r12) obj;
                } else {
                    r12Var = new r12(this.mSwanApiContext);
                    this.mApis.put("-420075743", r12Var);
                }
                Pair<Boolean, u32> a = w32.a(r12Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Router.reLoadErrorPage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = r12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                p12 p12Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof p12)) {
                    p12Var = (p12) obj;
                } else {
                    p12Var = new p12(this.mSwanApiContext);
                    this.mApis.put("1792515533", p12Var);
                }
                Pair<Boolean, u32> a = w32.a(p12Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Router.redirectTo")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 D = p12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                o12 o12Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof o12)) {
                    o12Var = (o12) obj;
                } else {
                    o12Var = new o12(this.mSwanApiContext);
                    this.mApis.put("1968522584", o12Var);
                }
                Pair<Boolean, u32> a = w32.a(o12Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Router.showModalPage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 J = o12Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naSetting", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                u12 u12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof u12)) {
                    u12Var = (u12) obj;
                } else {
                    u12Var = new u12(this.mSwanApiContext);
                    this.mApis.put("-594895721", u12Var);
                }
                Pair<Boolean, u32> a = w32.a(u12Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Setting.getAppInfoSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 F = u12Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                u12 u12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof u12)) {
                    u12Var = (u12) obj;
                } else {
                    u12Var = new u12(this.mSwanApiContext);
                    this.mApis.put("-594895721", u12Var);
                }
                Pair<Boolean, u32> a = w32.a(u12Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Setting.getSlaveIdSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 H = u12Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                t12 t12Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof t12)) {
                    t12Var = (t12) obj;
                } else {
                    t12Var = new t12(this.mSwanApiContext);
                    this.mApis.put("450273045", t12Var);
                }
                Pair<Boolean, u32> a = w32.a(t12Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Setting.isAllowedAdOpenAppSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = t12Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                u12 u12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof u12)) {
                    u12Var = (u12) obj;
                } else {
                    u12Var = new u12(this.mSwanApiContext);
                    this.mApis.put("-594895721", u12Var);
                }
                Pair<Boolean, u32> a = w32.a(u12Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Setting.getSetting")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 G = u12Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                u12 u12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof u12)) {
                    u12Var = (u12) obj;
                } else {
                    u12Var = new u12(this.mSwanApiContext);
                    this.mApis.put("-594895721", u12Var);
                }
                Pair<Boolean, u32> a = w32.a(u12Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Setting.getSwanId")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 I = u12Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                u12 u12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof u12)) {
                    u12Var = (u12) obj;
                } else {
                    u12Var = new u12(this.mSwanApiContext);
                    this.mApis.put("-594895721", u12Var);
                }
                Pair<Boolean, u32> a = w32.a(u12Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Setting.getUserInfo")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 J = u12Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                si3 si3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof si3)) {
                    si3Var = (si3) obj;
                } else {
                    si3Var = new si3(this.mSwanApiContext);
                    this.mApis.put("712777136", si3Var);
                }
                Pair<Boolean, u32> a = w32.a(si3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = si3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naStorage", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                x12 x12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof x12)) {
                    x12Var = (x12) obj;
                } else {
                    x12Var = new x12(this.mSwanApiContext);
                    this.mApis.put("-804054859", x12Var);
                }
                Pair<Boolean, u32> a = w32.a(x12Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.clearGlobalStorage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = x12Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                x12 x12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof x12)) {
                    x12Var = (x12) obj;
                } else {
                    x12Var = new x12(this.mSwanApiContext);
                    this.mApis.put("-804054859", x12Var);
                }
                Pair<Boolean, u32> a = w32.a(x12Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.clearGlobalStorageSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 C = x12Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                w12 w12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("130910081", w12Var);
                }
                Pair<Boolean, u32> a = w32.a(w12Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.clearStorage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = w12Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                w12 w12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("130910081", w12Var);
                }
                Pair<Boolean, u32> a = w32.a(w12Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.clearStorageSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 C = w12Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                x12 x12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof x12)) {
                    x12Var = (x12) obj;
                } else {
                    x12Var = new x12(this.mSwanApiContext);
                    this.mApis.put("-804054859", x12Var);
                }
                Pair<Boolean, u32> a = w32.a(x12Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageInfo")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 G = x12Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                x12 x12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof x12)) {
                    x12Var = (x12) obj;
                } else {
                    x12Var = new x12(this.mSwanApiContext);
                    this.mApis.put("-804054859", x12Var);
                }
                Pair<Boolean, u32> a = w32.a(x12Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageInfoSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 J = x12Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                w12 w12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("130910081", w12Var);
                }
                Pair<Boolean, u32> a = w32.a(w12Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.getStorageInfo")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 G = w12Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                w12 w12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("130910081", w12Var);
                }
                Pair<Boolean, u32> a = w32.a(w12Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.getStorageInfoSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 J = w12Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                x12 x12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof x12)) {
                    x12Var = (x12) obj;
                } else {
                    x12Var = new x12(this.mSwanApiContext);
                    this.mApis.put("-804054859", x12Var);
                }
                Pair<Boolean, u32> a = w32.a(x12Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 D = x12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                x12 x12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof x12)) {
                    x12Var = (x12) obj;
                } else {
                    x12Var = new x12(this.mSwanApiContext);
                    this.mApis.put("-804054859", x12Var);
                }
                Pair<Boolean, u32> a = w32.a(x12Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 K = x12Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                w12 w12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("130910081", w12Var);
                }
                Pair<Boolean, u32> a = w32.a(w12Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.getStorage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 D = w12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                w12 w12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("130910081", w12Var);
                }
                Pair<Boolean, u32> a = w32.a(w12Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.getStorageInfoAsync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 H = w12Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                w12 w12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("130910081", w12Var);
                }
                Pair<Boolean, u32> a = w32.a(w12Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.getStorageSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 K = w12Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                x12 x12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof x12)) {
                    x12Var = (x12) obj;
                } else {
                    x12Var = new x12(this.mSwanApiContext);
                    this.mApis.put("-804054859", x12Var);
                }
                Pair<Boolean, u32> a = w32.a(x12Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.removeGlobalStorage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 R = x12Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                x12 x12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof x12)) {
                    x12Var = (x12) obj;
                } else {
                    x12Var = new x12(this.mSwanApiContext);
                    this.mApis.put("-804054859", x12Var);
                }
                Pair<Boolean, u32> a = w32.a(x12Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.removeGlobalStorageSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 T2 = x12Var.T(str);
                if (T2 == null) {
                    return "";
                }
                return T2.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                w12 w12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("130910081", w12Var);
                }
                Pair<Boolean, u32> a = w32.a(w12Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.removeStorage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 R = w12Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                w12 w12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("130910081", w12Var);
                }
                Pair<Boolean, u32> a = w32.a(w12Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.removeStorageSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 T2 = w12Var.T(str);
                if (T2 == null) {
                    return "";
                }
                return T2.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                x12 x12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof x12)) {
                    x12Var = (x12) obj;
                } else {
                    x12Var = new x12(this.mSwanApiContext);
                    this.mApis.put("-804054859", x12Var);
                }
                Pair<Boolean, u32> a = w32.a(x12Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.setGlobalStorage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 U = x12Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                x12 x12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof x12)) {
                    x12Var = (x12) obj;
                } else {
                    x12Var = new x12(this.mSwanApiContext);
                    this.mApis.put("-804054859", x12Var);
                }
                Pair<Boolean, u32> a = w32.a(x12Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.setGlobalStorageSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 W = x12Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                w12 w12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("130910081", w12Var);
                }
                Pair<Boolean, u32> a = w32.a(w12Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.setStorage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 U = w12Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                w12 w12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("130910081", w12Var);
                }
                Pair<Boolean, u32> a = w32.a(w12Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Storage.setStorageSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 W = w12Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }
        });
        hashMap.put("_naSubscription", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                z12 z12Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof z12)) {
                    z12Var = (z12) obj;
                } else {
                    z12Var = new z12(this.mSwanApiContext);
                    this.mApis.put("823117982", z12Var);
                }
                Pair<Boolean, u32> a = w32.a(z12Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Subscription.requestSubscribeFormId")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 E = z12Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                a22 a22Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("-947445811", a22Var);
                }
                Pair<Boolean, u32> a = w32.a(a22Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Subscription.subscribeService")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 F = a22Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }
        });
        hashMap.put("_naSystem", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                h22 h22Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof h22)) {
                    h22Var = (h22) obj;
                } else {
                    h22Var = new h22(this.mSwanApiContext);
                    this.mApis.put("1936205521", h22Var);
                }
                Pair<Boolean, u32> a = w32.a(h22Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.exitFullScreen")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = h22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                g22 g22Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof g22)) {
                    g22Var = (g22) obj;
                } else {
                    g22Var = new g22(this.mSwanApiContext);
                    this.mApis.put("1694151270", g22Var);
                }
                Pair<Boolean, u32> a = w32.a(g22Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.getDeviceInfo")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = g22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                i22 i22Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof i22)) {
                    i22Var = (i22) obj;
                } else {
                    i22Var = new i22(this.mSwanApiContext);
                    this.mApis.put("-1321681619", i22Var);
                }
                Pair<Boolean, u32> a = w32.a(i22Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.getDeviceProfile")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = i22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                j22 j22Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof j22)) {
                    j22Var = (j22) obj;
                } else {
                    j22Var = new j22(this.mSwanApiContext);
                    this.mApis.put("-1569246082", j22Var);
                }
                Pair<Boolean, u32> a = w32.a(j22Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.makePhoneCall")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = j22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                l22 l22Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof l22)) {
                    l22Var = (l22) obj;
                } else {
                    l22Var = new l22(this.mSwanApiContext);
                    this.mApis.put("1099851202", l22Var);
                }
                Pair<Boolean, u32> a = w32.a(l22Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.openSMSPanel")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = l22Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                k22 k22Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof k22)) {
                    k22Var = (k22) obj;
                } else {
                    k22Var = new k22(this.mSwanApiContext);
                    this.mApis.put("-1707203360", k22Var);
                }
                Pair<Boolean, u32> a = w32.a(k22Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.requestFullScreen")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 F = k22Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                e22 e22Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("-518757484", e22Var);
                }
                Pair<Boolean, u32> a = w32.a(e22Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.setClipboardData")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = e22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                o13 o13Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof o13)) {
                    o13Var = (o13) obj;
                } else {
                    o13Var = new o13(this.mSwanApiContext);
                    this.mApis.put("1161486049", o13Var);
                }
                Pair<Boolean, u32> a = w32.a(o13Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.setErrorPageType")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = o13Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                o22 o22Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof o22)) {
                    o22Var = (o22) obj;
                } else {
                    o22Var = new o22(this.mSwanApiContext);
                    this.mApis.put("447234992", o22Var);
                }
                Pair<Boolean, u32> a = w32.a(o22Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.setMediaVolume")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 z = o22Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                c22 c22Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof c22)) {
                    c22Var = (c22) obj;
                } else {
                    c22Var = new c22(this.mSwanApiContext);
                    this.mApis.put("1372680763", c22Var);
                }
                Pair<Boolean, u32> a = w32.a(c22Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.startAccelerometer")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = c22Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                f22 f22Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof f22)) {
                    f22Var = (f22) obj;
                } else {
                    f22Var = new f22(this.mSwanApiContext);
                    this.mApis.put("1689255576", f22Var);
                }
                Pair<Boolean, u32> a = w32.a(f22Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.startCompass")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = f22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                d22 d22Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("99997465", d22Var);
                }
                Pair<Boolean, u32> a = w32.a(d22Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.getBrightness")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = d22Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                e22 e22Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("-518757484", e22Var);
                }
                Pair<Boolean, u32> a = w32.a(e22Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.getClipboardData")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = e22Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                o22 o22Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof o22)) {
                    o22Var = (o22) obj;
                } else {
                    o22Var = new o22(this.mSwanApiContext);
                    this.mApis.put("447234992", o22Var);
                }
                Pair<Boolean, u32> a = w32.a(o22Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.getMediaVolume")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = o22Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                c22 c22Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof c22)) {
                    c22Var = (c22) obj;
                } else {
                    c22Var = new c22(this.mSwanApiContext);
                    this.mApis.put("1372680763", c22Var);
                }
                Pair<Boolean, u32> a = w32.a(c22Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.stopAccelerometer")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 B = c22Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                f22 f22Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof f22)) {
                    f22Var = (f22) obj;
                } else {
                    f22Var = new f22(this.mSwanApiContext);
                    this.mApis.put("1689255576", f22Var);
                }
                Pair<Boolean, u32> a = w32.a(f22Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "System.stopCompass")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 z = f22Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naUtils", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                z22 z22Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof z22)) {
                    z22Var = (z22) obj;
                } else {
                    z22Var = new z22(this.mSwanApiContext);
                    this.mApis.put("201194468", z22Var);
                }
                Pair<Boolean, u32> a = w32.a(z22Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.addToDesktop")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 B = z22Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                v22 v22Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof v22)) {
                    v22Var = (v22) obj;
                } else {
                    v22Var = new v22(this.mSwanApiContext);
                    this.mApis.put("-1412306947", v22Var);
                }
                Pair<Boolean, u32> a = w32.a(v22Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.calcMD5")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = v22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                w22 w22Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof w22)) {
                    w22Var = (w22) obj;
                } else {
                    w22Var = new w22(this.mSwanApiContext);
                    this.mApis.put("1626415364", w22Var);
                }
                Pair<Boolean, u32> a = w32.a(w22Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.checkAppInstalled")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = w22Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                y22 y22Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof y22)) {
                    y22Var = (y22) obj;
                } else {
                    y22Var = new y22(this.mSwanApiContext);
                    this.mApis.put("-836768778", y22Var);
                }
                Pair<Boolean, u32> a = w32.a(y22Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.getCommonSysInfo")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = y22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                a32 a32Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof a32)) {
                    a32Var = (a32) obj;
                } else {
                    a32Var = new a32(this.mSwanApiContext);
                    this.mApis.put("-810858308", a32Var);
                }
                Pair<Boolean, u32> a = w32.a(a32Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.getPerformanceLevel")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = a32Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                e32 e32Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof e32)) {
                    e32Var = (e32) obj;
                } else {
                    e32Var = new e32(this.mSwanApiContext);
                    this.mApis.put("-1011537871", e32Var);
                }
                Pair<Boolean, u32> a = w32.a(e32Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.getSystemInfoAsync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 I = e32Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                b32 b32Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof b32)) {
                    b32Var = (b32) obj;
                } else {
                    b32Var = new b32(this.mSwanApiContext);
                    this.mApis.put("-2097727681", b32Var);
                }
                Pair<Boolean, u32> a = w32.a(b32Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.handleException")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = b32Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                x22 x22Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof x22)) {
                    x22Var = (x22) obj;
                } else {
                    x22Var = new x22(this.mSwanApiContext);
                    this.mApis.put("2084449317", x22Var);
                }
                Pair<Boolean, u32> a = w32.a(x22Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.hasCloseHandler")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = x22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                ag3 ag3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof ag3)) {
                    ag3Var = (ag3) obj;
                } else {
                    ag3Var = new ag3(this.mSwanApiContext);
                    this.mApis.put("1031678042", ag3Var);
                }
                Pair<Boolean, u32> a = w32.a(ag3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.hideCaptureScreenShareDialog")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 x = ag3Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                c32 c32Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof c32)) {
                    c32Var = (c32) obj;
                } else {
                    c32Var = new c32(this.mSwanApiContext);
                    this.mApis.put("1751900130", c32Var);
                }
                Pair<Boolean, u32> a = w32.a(c32Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.logToFile")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = c32Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                bf3 bf3Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof bf3)) {
                    bf3Var = (bf3) obj;
                } else {
                    bf3Var = new bf3(this.mSwanApiContext);
                    this.mApis.put("1748196865", bf3Var);
                }
                Pair<Boolean, u32> a = w32.a(bf3Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.preloadPackage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = bf3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                d32 d32Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof d32)) {
                    d32Var = (d32) obj;
                } else {
                    d32Var = new d32(this.mSwanApiContext);
                    this.mApis.put("589529211", d32Var);
                }
                Pair<Boolean, u32> a = w32.a(d32Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.previewImage")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 B = d32Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                g32 g32Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof g32)) {
                    g32Var = (g32) obj;
                } else {
                    g32Var = new g32(this.mSwanApiContext);
                    this.mApis.put("-577481801", g32Var);
                }
                Pair<Boolean, u32> a = w32.a(g32Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.ubcFlowJar")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 I = g32Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                e32 e32Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof e32)) {
                    e32Var = (e32) obj;
                } else {
                    e32Var = new e32(this.mSwanApiContext);
                    this.mApis.put("-1011537871", e32Var);
                }
                Pair<Boolean, u32> a = w32.a(e32Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.getCommonSysInfoSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 E = e32Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                e32 e32Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof e32)) {
                    e32Var = (e32) obj;
                } else {
                    e32Var = new e32(this.mSwanApiContext);
                    this.mApis.put("-1011537871", e32Var);
                }
                Pair<Boolean, u32> a = w32.a(e32Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.getSystemInfo")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 H = e32Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                e32 e32Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof e32)) {
                    e32Var = (e32) obj;
                } else {
                    e32Var = new e32(this.mSwanApiContext);
                    this.mApis.put("-1011537871", e32Var);
                }
                Pair<Boolean, u32> a = w32.a(e32Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Utils.getSystemInfoSync")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 J = e32Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naWifi", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                lm3 lm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof lm3)) {
                    lm3Var = (lm3) obj;
                } else {
                    lm3Var = new lm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", lm3Var);
                }
                Pair<Boolean, u32> a = w32.a(lm3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Wifi.connectWifi")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 A = lm3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                lm3 lm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof lm3)) {
                    lm3Var = (lm3) obj;
                } else {
                    lm3Var = new lm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", lm3Var);
                }
                Pair<Boolean, u32> a = w32.a(lm3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Wifi.getConnectedWifi")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 B = lm3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                lm3 lm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof lm3)) {
                    lm3Var = (lm3) obj;
                } else {
                    lm3Var = new lm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", lm3Var);
                }
                Pair<Boolean, u32> a = w32.a(lm3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Wifi.getWifiList")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 C = lm3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                lm3 lm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof lm3)) {
                    lm3Var = (lm3) obj;
                } else {
                    lm3Var = new lm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", lm3Var);
                }
                Pair<Boolean, u32> a = w32.a(lm3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Wifi.startWifi")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 G = lm3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                lm3 lm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof lm3)) {
                    lm3Var = (lm3) obj;
                } else {
                    lm3Var = new lm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", lm3Var);
                }
                Pair<Boolean, u32> a = w32.a(lm3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "Wifi.stopWifi")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 H = lm3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }
}
