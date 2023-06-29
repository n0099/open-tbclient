package com.baidu.swan.apps.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.tieba.a12;
import com.baidu.tieba.a22;
import com.baidu.tieba.a42;
import com.baidu.tieba.b12;
import com.baidu.tieba.b22;
import com.baidu.tieba.b42;
import com.baidu.tieba.c12;
import com.baidu.tieba.c32;
import com.baidu.tieba.c42;
import com.baidu.tieba.d02;
import com.baidu.tieba.d12;
import com.baidu.tieba.d22;
import com.baidu.tieba.d32;
import com.baidu.tieba.d42;
import com.baidu.tieba.dg2;
import com.baidu.tieba.e12;
import com.baidu.tieba.e22;
import com.baidu.tieba.e32;
import com.baidu.tieba.f02;
import com.baidu.tieba.f12;
import com.baidu.tieba.f32;
import com.baidu.tieba.fo3;
import com.baidu.tieba.fp2;
import com.baidu.tieba.g02;
import com.baidu.tieba.g12;
import com.baidu.tieba.g22;
import com.baidu.tieba.g32;
import com.baidu.tieba.h22;
import com.baidu.tieba.h32;
import com.baidu.tieba.hg3;
import com.baidu.tieba.i02;
import com.baidu.tieba.i32;
import com.baidu.tieba.if3;
import com.baidu.tieba.j02;
import com.baidu.tieba.j12;
import com.baidu.tieba.j22;
import com.baidu.tieba.j32;
import com.baidu.tieba.je2;
import com.baidu.tieba.k02;
import com.baidu.tieba.k22;
import com.baidu.tieba.k32;
import com.baidu.tieba.k73;
import com.baidu.tieba.l02;
import com.baidu.tieba.l22;
import com.baidu.tieba.l32;
import com.baidu.tieba.m02;
import com.baidu.tieba.m22;
import com.baidu.tieba.n22;
import com.baidu.tieba.n32;
import com.baidu.tieba.o02;
import com.baidu.tieba.o22;
import com.baidu.tieba.p12;
import com.baidu.tieba.p22;
import com.baidu.tieba.p43;
import com.baidu.tieba.q02;
import com.baidu.tieba.q12;
import com.baidu.tieba.q22;
import com.baidu.tieba.r02;
import com.baidu.tieba.r22;
import com.baidu.tieba.s22;
import com.baidu.tieba.sm3;
import com.baidu.tieba.sz1;
import com.baidu.tieba.t13;
import com.baidu.tieba.ts1;
import com.baidu.tieba.u02;
import com.baidu.tieba.u12;
import com.baidu.tieba.v12;
import com.baidu.tieba.v13;
import com.baidu.tieba.v22;
import com.baidu.tieba.ve2;
import com.baidu.tieba.w02;
import com.baidu.tieba.w12;
import com.baidu.tieba.x02;
import com.baidu.tieba.x12;
import com.baidu.tieba.x22;
import com.baidu.tieba.y02;
import com.baidu.tieba.y12;
import com.baidu.tieba.z02;
import com.baidu.tieba.z43;
import com.baidu.tieba.zi3;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
@Keep
/* loaded from: classes4.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final d02 d02Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                j02 j02Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof j02)) {
                    j02Var = (j02) obj;
                } else {
                    j02Var = new j02(this.mSwanApiContext);
                    this.mApis.put("1930258908", j02Var);
                }
                Pair<Boolean, b42> a = d42.a(j02Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Account.checkSession")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = j02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                k02 k02Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof k02)) {
                    k02Var = (k02) obj;
                } else {
                    k02Var = new k02(this.mSwanApiContext);
                    this.mApis.put("-1017914143", k02Var);
                }
                Pair<Boolean, b42> a = d42.a(k02Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Account.getLoginCode")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 C = k02Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                l02 l02Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof l02)) {
                    l02Var = (l02) obj;
                } else {
                    l02Var = new l02(this.mSwanApiContext);
                    this.mApis.put("1754780133", l02Var);
                }
                Pair<Boolean, b42> a = d42.a(l02Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Account.getOpenId")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = l02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                sz1 sz1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof sz1)) {
                    sz1Var = (sz1) obj;
                } else {
                    sz1Var = new sz1(this.mSwanApiContext);
                    this.mApis.put("-343998465", sz1Var);
                }
                Pair<Boolean, b42> a = d42.a(sz1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Account.getUnionBDUSS")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = sz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String login(String str) {
                k02 k02Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof k02)) {
                    k02Var = (k02) obj;
                } else {
                    k02Var = new k02(this.mSwanApiContext);
                    this.mApis.put("-1017914143", k02Var);
                }
                Pair<Boolean, b42> a = d42.a(k02Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Account.login")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 I = k02Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                i02 i02Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof i02)) {
                    i02Var = (i02) obj;
                } else {
                    i02Var = new i02(this.mSwanApiContext);
                    this.mApis.put("-337742792", i02Var);
                }
                Pair<Boolean, b42> a = d42.a(i02Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Account.isBaiduAccountSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = i02Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                k02 k02Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof k02)) {
                    k02Var = (k02) obj;
                } else {
                    k02Var = new k02(this.mSwanApiContext);
                    this.mApis.put("-1017914143", k02Var);
                }
                Pair<Boolean, b42> a = d42.a(k02Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Account.isLoginSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 H = k02Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBasic", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                m02 m02Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof m02)) {
                    m02Var = (m02) obj;
                } else {
                    m02Var = new m02(this.mSwanApiContext);
                    this.mApis.put("-1249666566", m02Var);
                }
                Pair<Boolean, b42> a = d42.a(m02Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Basic.loadSubPackage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 F = m02Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                m02 m02Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof m02)) {
                    m02Var = (m02) obj;
                } else {
                    m02Var = new m02(this.mSwanApiContext);
                    this.mApis.put("-1249666566", m02Var);
                }
                Pair<Boolean, b42> a = d42.a(m02Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Basic.loadSubPackages")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 G = m02Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                ts1 ts1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ts1)) {
                    ts1Var = (ts1) obj;
                } else {
                    ts1Var = new ts1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ts1Var);
                }
                Pair<Boolean, b42> a = d42.a(ts1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Bookshelf.deleteBookshelf")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 K = ts1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                ts1 ts1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ts1)) {
                    ts1Var = (ts1) obj;
                } else {
                    ts1Var = new ts1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ts1Var);
                }
                Pair<Boolean, b42> a = d42.a(ts1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Bookshelf.insertBookshelf")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 P = ts1Var.P(str);
                if (P == null) {
                    return "";
                }
                return P.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                ts1 ts1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ts1)) {
                    ts1Var = (ts1) obj;
                } else {
                    ts1Var = new ts1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ts1Var);
                }
                Pair<Boolean, b42> a = d42.a(ts1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Bookshelf.navigateToBookshelf")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 U = ts1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                ts1 ts1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ts1)) {
                    ts1Var = (ts1) obj;
                } else {
                    ts1Var = new ts1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ts1Var);
                }
                Pair<Boolean, b42> a = d42.a(ts1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Bookshelf.queryBookshelf")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 V = ts1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                ts1 ts1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ts1)) {
                    ts1Var = (ts1) obj;
                } else {
                    ts1Var = new ts1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ts1Var);
                }
                Pair<Boolean, b42> a = d42.a(ts1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Bookshelf.updateBookshelfReadTime")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 X = ts1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naCoupon", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                g02 g02Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof g02)) {
                    g02Var = (g02) obj;
                } else {
                    g02Var = new g02(this.mSwanApiContext);
                    this.mApis.put("-277316359", g02Var);
                }
                Pair<Boolean, b42> a = d42.a(g02Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Coupon.getPlatformCoupons")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = g02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                g02 g02Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof g02)) {
                    g02Var = (g02) obj;
                } else {
                    g02Var = new g02(this.mSwanApiContext);
                    this.mApis.put("-277316359", g02Var);
                }
                Pair<Boolean, b42> a = d42.a(g02Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Coupon.getUserCoupons")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 z = g02Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                g02 g02Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof g02)) {
                    g02Var = (g02) obj;
                } else {
                    g02Var = new g02(this.mSwanApiContext);
                    this.mApis.put("-277316359", g02Var);
                }
                Pair<Boolean, b42> a = d42.a(g02Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Coupon.takeCoupons")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 C = g02Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naFavorite", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                o02 o02Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof o02)) {
                    o02Var = (o02) obj;
                } else {
                    o02Var = new o02(this.mSwanApiContext);
                    this.mApis.put("-1225406515", o02Var);
                }
                Pair<Boolean, b42> a = d42.a(o02Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Favorite.getFavorStatus")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = o02Var.x(str);
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
                Pair<Boolean, b42> a = d42.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Favorite.showFavoriteGuide")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 G = showFavoriteGuideApi.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naFile", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                q02 q02Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof q02)) {
                    q02Var = (q02) obj;
                } else {
                    q02Var = new q02(this.mSwanApiContext);
                    this.mApis.put("-2057135077", q02Var);
                }
                Pair<Boolean, b42> a = d42.a(q02Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "File.shareFile")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = q02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                fp2 fp2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof fp2)) {
                    fp2Var = (fp2) obj;
                } else {
                    fp2Var = new fp2(this.mSwanApiContext);
                    this.mApis.put("2077414795", fp2Var);
                }
                Pair<Boolean, b42> a = d42.a(fp2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "GameCenter.postGameCenterMessage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = fp2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                fp2 fp2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof fp2)) {
                    fp2Var = (fp2) obj;
                } else {
                    fp2Var = new fp2(this.mSwanApiContext);
                    this.mApis.put("2077414795", fp2Var);
                }
                Pair<Boolean, b42> a = d42.a(fp2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "GameCenter.postGameCenterMessageSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = fp2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String download(String str) {
                r02 r02Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof r02)) {
                    r02Var = (r02) obj;
                } else {
                    r02Var = new r02(this.mSwanApiContext);
                    this.mApis.put("-170124576", r02Var);
                }
                Pair<Boolean, b42> a = d42.a(r02Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "HostDownloadManager.download")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = r02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                r02 r02Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof r02)) {
                    r02Var = (r02) obj;
                } else {
                    r02Var = new r02(this.mSwanApiContext);
                    this.mApis.put("-170124576", r02Var);
                }
                Pair<Boolean, b42> a = d42.a(r02Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "HostDownloadManager.openFile")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 z = r02Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String query(String str) {
                r02 r02Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof r02)) {
                    r02Var = (r02) obj;
                } else {
                    r02Var = new r02(this.mSwanApiContext);
                    this.mApis.put("-170124576", r02Var);
                }
                Pair<Boolean, b42> a = d42.a(r02Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "HostDownloadManager.query")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 query = r02Var.query(str);
                if (query == null) {
                    return "";
                }
                return query.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                r02 r02Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof r02)) {
                    r02Var = (r02) obj;
                } else {
                    r02Var = new r02(this.mSwanApiContext);
                    this.mApis.put("-170124576", r02Var);
                }
                Pair<Boolean, b42> a = d42.a(r02Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "HostDownloadManager.openDownloadCenter")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = r02Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naImage", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                t13 t13Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof t13)) {
                    t13Var = (t13) obj;
                } else {
                    t13Var = new t13(this.mSwanApiContext);
                    this.mApis.put("1445003743", t13Var);
                }
                Pair<Boolean, b42> a = d42.a(t13Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Image.callImageMenu")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = t13Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                u02 u02Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof u02)) {
                    u02Var = (u02) obj;
                } else {
                    u02Var = new u02(this.mSwanApiContext);
                    this.mApis.put("-1252730367", u02Var);
                }
                Pair<Boolean, b42> a = d42.a(u02Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Image.compressImage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = u02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naInteraction", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                c12 c12Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof c12)) {
                    c12Var = (c12) obj;
                } else {
                    c12Var = new c12(this.mSwanApiContext);
                    this.mApis.put("-1871435471", c12Var);
                }
                Pair<Boolean, b42> a = d42.a(c12Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.closeTabBar")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = c12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                c12 c12Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof c12)) {
                    c12Var = (c12) obj;
                } else {
                    c12Var = new c12(this.mSwanApiContext);
                    this.mApis.put("-1871435471", c12Var);
                }
                Pair<Boolean, b42> a = d42.a(c12Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.closeTabBarRedDot")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = c12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                y02 y02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof y02)) {
                    y02Var = (y02) obj;
                } else {
                    y02Var = new y02(this.mSwanApiContext);
                    this.mApis.put("-246386074", y02Var);
                }
                Pair<Boolean, b42> a = d42.a(y02Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.hideNavigationBarLoading")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = y02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                a12 a12Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("-108978463", a12Var);
                }
                Pair<Boolean, b42> a = d42.a(a12Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.openMultiPicker")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 G = a12Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                a12 a12Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("-108978463", a12Var);
                }
                Pair<Boolean, b42> a = d42.a(a12Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.openPicker")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 H = a12Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                c12 c12Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof c12)) {
                    c12Var = (c12) obj;
                } else {
                    c12Var = new c12(this.mSwanApiContext);
                    this.mApis.put("-1871435471", c12Var);
                }
                Pair<Boolean, b42> a = d42.a(c12Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.openTabBar")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 C = c12Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("-1750613704", z02Var);
                }
                Pair<Boolean, b42> a = d42.a(z02Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.pageScrollTo")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = z02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                y02 y02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof y02)) {
                    y02Var = (y02) obj;
                } else {
                    y02Var = new y02(this.mSwanApiContext);
                    this.mApis.put("-246386074", y02Var);
                }
                Pair<Boolean, b42> a = d42.a(y02Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.setNavigationBarColor")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 z = y02Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                y02 y02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof y02)) {
                    y02Var = (y02) obj;
                } else {
                    y02Var = new y02(this.mSwanApiContext);
                    this.mApis.put("-246386074", y02Var);
                }
                Pair<Boolean, b42> a = d42.a(y02Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.setNavigationBarTitle")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = y02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                c12 c12Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof c12)) {
                    c12Var = (c12) obj;
                } else {
                    c12Var = new c12(this.mSwanApiContext);
                    this.mApis.put("-1871435471", c12Var);
                }
                Pair<Boolean, b42> a = d42.a(c12Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.setTabBarItem")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 D = c12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                a12 a12Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("-108978463", a12Var);
                }
                Pair<Boolean, b42> a = d42.a(a12Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.showDatePickerView")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 L = a12Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                e12 e12Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof e12)) {
                    e12Var = (e12) obj;
                } else {
                    e12Var = new e12(this.mSwanApiContext);
                    this.mApis.put("1172469410", e12Var);
                }
                Pair<Boolean, b42> a = d42.a(e12Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.showHalfScreenWebview")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 K = e12Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                w02 w02Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof w02)) {
                    w02Var = (w02) obj;
                } else {
                    w02Var = new w02(this.mSwanApiContext);
                    this.mApis.put("5236036", w02Var);
                }
                Pair<Boolean, b42> a = d42.a(w02Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.showLoading")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = w02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                x02 x02Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof x02)) {
                    x02Var = (x02) obj;
                } else {
                    x02Var = new x02(this.mSwanApiContext);
                    this.mApis.put("1913747800", x02Var);
                }
                Pair<Boolean, b42> a = d42.a(x02Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.showModal")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = x02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                y02 y02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof y02)) {
                    y02Var = (y02) obj;
                } else {
                    y02Var = new y02(this.mSwanApiContext);
                    this.mApis.put("-246386074", y02Var);
                }
                Pair<Boolean, b42> a = d42.a(y02Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.showNavigationBarLoading")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 B = y02Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                d12 d12Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof d12)) {
                    d12Var = (d12) obj;
                } else {
                    d12Var = new d12(this.mSwanApiContext);
                    this.mApis.put("1159492510", d12Var);
                }
                Pair<Boolean, b42> a = d42.a(d12Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.showToast")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 Q = d12Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                b12 b12Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof b12)) {
                    b12Var = (b12) obj;
                } else {
                    b12Var = new b12(this.mSwanApiContext);
                    this.mApis.put("1165118609", b12Var);
                }
                Pair<Boolean, b42> a = d42.a(b12Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.stopPullDownRefresh")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = b12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                a12 a12Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("-108978463", a12Var);
                }
                Pair<Boolean, b42> a = d42.a(a12Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.updateMultiPicker")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 M = a12Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                w02 w02Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof w02)) {
                    w02Var = (w02) obj;
                } else {
                    w02Var = new w02(this.mSwanApiContext);
                    this.mApis.put("5236036", w02Var);
                }
                Pair<Boolean, b42> a = d42.a(w02Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.hideLoading")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = w02Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hideToast() {
                d12 d12Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof d12)) {
                    d12Var = (d12) obj;
                } else {
                    d12Var = new d12(this.mSwanApiContext);
                    this.mApis.put("1159492510", d12Var);
                }
                Pair<Boolean, b42> a = d42.a(d12Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.hideToast")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 K = d12Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                f12 f12Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("-137346255", f12Var);
                }
                Pair<Boolean, b42> a = d42.a(f12Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Keyboard.startKeyboardHeightChange")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 C = f12Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                f12 f12Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("-137346255", f12Var);
                }
                Pair<Boolean, b42> a = d42.a(f12Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Keyboard.stopKeyboardHeightChange")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 D = f12Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naLocationService", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                g12 g12Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof g12)) {
                    g12Var = (g12) obj;
                } else {
                    g12Var = new g12(this.mSwanApiContext);
                    this.mApis.put("-397373095", g12Var);
                }
                Pair<Boolean, b42> a = d42.a(g12Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "LocationService.getLocation")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = g12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                g12 g12Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof g12)) {
                    g12Var = (g12) obj;
                } else {
                    g12Var = new g12(this.mSwanApiContext);
                    this.mApis.put("-397373095", g12Var);
                }
                Pair<Boolean, b42> a = d42.a(g12Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "LocationService.startLocationUpdate")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = g12Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                g12 g12Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof g12)) {
                    g12Var = (g12) obj;
                } else {
                    g12Var = new g12(this.mSwanApiContext);
                    this.mApis.put("-397373095", g12Var);
                }
                Pair<Boolean, b42> a = d42.a(g12Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "LocationService.stopLocationUpdate")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 B = g12Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naMenu", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                x22 x22Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof x22)) {
                    x22Var = (x22) obj;
                } else {
                    x22Var = new x22(this.mSwanApiContext);
                    this.mApis.put("538070032", x22Var);
                }
                Pair<Boolean, b42> a = d42.a(x22Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = x22Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naNetwork", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                j12 j12Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof j12)) {
                    j12Var = (j12) obj;
                } else {
                    j12Var = new j12(this.mSwanApiContext);
                    this.mApis.put("-1076509454", j12Var);
                }
                Pair<Boolean, b42> a = d42.a(j12Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Network.callService")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = j12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                q12 q12Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof q12)) {
                    q12Var = (q12) obj;
                } else {
                    q12Var = new q12(this.mSwanApiContext);
                    this.mApis.put("968563034", q12Var);
                }
                Pair<Boolean, b42> a = d42.a(q12Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Network.cancelRequest")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 D = q12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                p12 p12Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof p12)) {
                    p12Var = (p12) obj;
                } else {
                    p12Var = new p12(this.mSwanApiContext);
                    this.mApis.put("453220699", p12Var);
                }
                Pair<Boolean, b42> a = d42.a(p12Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Network.networkStatusChange")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = p12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                p12 p12Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof p12)) {
                    p12Var = (p12) obj;
                } else {
                    p12Var = new p12(this.mSwanApiContext);
                    this.mApis.put("453220699", p12Var);
                }
                Pair<Boolean, b42> a = d42.a(p12Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Network.getNetworkType")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = p12Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(JsObject jsObject) {
                q12 q12Var;
                String a;
                try {
                    a42.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof q12)) {
                        q12Var = (q12) obj;
                    } else {
                        q12Var = new q12(this.mSwanApiContext);
                        this.mApis.put("968563034", q12Var);
                    }
                    Pair<Boolean, b42> a2 = d42.a(q12Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((b42) a2.second).a();
                    } else if (je2.a(this.mSwanApiContext.d(), "Network.request")) {
                        a = new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<b42, JSONObject> t = f02.t(jsObject);
                        if (!((b42) t.first).isSuccess()) {
                            a = ((b42) t.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) t.second;
                            if (jSONObject == null) {
                                a = b42.a.a();
                            } else {
                                c42 V = q12Var.V(jSONObject);
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
                        a42.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                z43 z43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof z43)) {
                    z43Var = (z43) obj;
                } else {
                    z43Var = new z43(this.mSwanApiContext);
                    this.mApis.put("-336396851", z43Var);
                }
                Pair<Boolean, b42> a = d42.a(z43Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Payment.chooseCoupon")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = z43Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                z43 z43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof z43)) {
                    z43Var = (z43) obj;
                } else {
                    z43Var = new z43(this.mSwanApiContext);
                    this.mApis.put("-336396851", z43Var);
                }
                Pair<Boolean, b42> a = d42.a(z43Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Payment.getPaymentInfo")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = z43Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                p43 p43Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof p43)) {
                    p43Var = (p43) obj;
                } else {
                    p43Var = new p43(this.mSwanApiContext);
                    this.mApis.put("1854689529", p43Var);
                }
                Pair<Boolean, b42> a = d42.a(p43Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Payment.requestThirdPayment")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = p43Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                z43 z43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof z43)) {
                    z43Var = (z43) obj;
                } else {
                    z43Var = new z43(this.mSwanApiContext);
                    this.mApis.put("-336396851", z43Var);
                }
                Pair<Boolean, b42> a = d42.a(z43Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Payment.setPaymentInfo")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 z = z43Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPlugin", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                k73 k73Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof k73)) {
                    k73Var = (k73) obj;
                } else {
                    k73Var = new k73(this.mSwanApiContext);
                    this.mApis.put("-254510461", k73Var);
                }
                Pair<Boolean, b42> a = d42.a(k73Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Plugin.invokePluginChooseAddress")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = k73Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                k73 k73Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof k73)) {
                    k73Var = (k73) obj;
                } else {
                    k73Var = new k73(this.mSwanApiContext);
                    this.mApis.put("-254510461", k73Var);
                }
                Pair<Boolean, b42> a = d42.a(k73Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 z = k73Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                k73 k73Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof k73)) {
                    k73Var = (k73) obj;
                } else {
                    k73Var = new k73(this.mSwanApiContext);
                    this.mApis.put("-254510461", k73Var);
                }
                Pair<Boolean, b42> a = d42.a(k73Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Plugin.invokePluginPayment")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = k73Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                dg2 dg2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof dg2)) {
                    dg2Var = (dg2) obj;
                } else {
                    dg2Var = new dg2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", dg2Var);
                }
                Pair<Boolean, b42> a = d42.a(dg2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Prefetch.prefetchResources")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = dg2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPreload", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                ve2 ve2Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof ve2)) {
                    ve2Var = (ve2) obj;
                } else {
                    ve2Var = new ve2(this.mSwanApiContext);
                    this.mApis.put("423661539", ve2Var);
                }
                Pair<Boolean, b42> a = d42.a(ve2Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Preload.preloadStatus")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = ve2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                fo3 fo3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof fo3)) {
                    fo3Var = (fo3) obj;
                } else {
                    fo3Var = new fo3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", fo3Var);
                }
                Pair<Boolean, b42> a = d42.a(fo3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "PrivateFile.uploadFileToBos")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 C = fo3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naRouter", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                u12 u12Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof u12)) {
                    u12Var = (u12) obj;
                } else {
                    u12Var = new u12(this.mSwanApiContext);
                    this.mApis.put("-1495163604", u12Var);
                }
                Pair<Boolean, b42> a = d42.a(u12Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Router.hideModalPage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = u12Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                u12 u12Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof u12)) {
                    u12Var = (u12) obj;
                } else {
                    u12Var = new u12(this.mSwanApiContext);
                    this.mApis.put("-1495163604", u12Var);
                }
                Pair<Boolean, b42> a = d42.a(u12Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Router.navigateBack")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 B = u12Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                v12 v12Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof v12)) {
                    v12Var = (v12) obj;
                } else {
                    v12Var = new v12(this.mSwanApiContext);
                    this.mApis.put("1968522584", v12Var);
                }
                Pair<Boolean, b42> a = d42.a(v12Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Router.navigateTo")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 H = v12Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                x12 x12Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof x12)) {
                    x12Var = (x12) obj;
                } else {
                    x12Var = new x12(this.mSwanApiContext);
                    this.mApis.put("1317280190", x12Var);
                }
                Pair<Boolean, b42> a = d42.a(x12Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Router.reLaunch")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = x12Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                y12 y12Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof y12)) {
                    y12Var = (y12) obj;
                } else {
                    y12Var = new y12(this.mSwanApiContext);
                    this.mApis.put("-420075743", y12Var);
                }
                Pair<Boolean, b42> a = d42.a(y12Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Router.reLoadErrorPage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = y12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                w12 w12Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("1792515533", w12Var);
                }
                Pair<Boolean, b42> a = d42.a(w12Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Router.redirectTo")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 D = w12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                v12 v12Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof v12)) {
                    v12Var = (v12) obj;
                } else {
                    v12Var = new v12(this.mSwanApiContext);
                    this.mApis.put("1968522584", v12Var);
                }
                Pair<Boolean, b42> a = d42.a(v12Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Router.showModalPage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 J = v12Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naSetting", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                b22 b22Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-594895721", b22Var);
                }
                Pair<Boolean, b42> a = d42.a(b22Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Setting.getAppInfoSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 F = b22Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                b22 b22Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-594895721", b22Var);
                }
                Pair<Boolean, b42> a = d42.a(b22Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Setting.getSlaveIdSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 H = b22Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                a22 a22Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("450273045", a22Var);
                }
                Pair<Boolean, b42> a = d42.a(a22Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Setting.isAllowedAdOpenAppSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = a22Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                b22 b22Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-594895721", b22Var);
                }
                Pair<Boolean, b42> a = d42.a(b22Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Setting.getSetting")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 G = b22Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                b22 b22Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-594895721", b22Var);
                }
                Pair<Boolean, b42> a = d42.a(b22Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Setting.getSwanId")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 I = b22Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                b22 b22Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-594895721", b22Var);
                }
                Pair<Boolean, b42> a = d42.a(b22Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Setting.getUserInfo")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 J = b22Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                zi3 zi3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof zi3)) {
                    zi3Var = (zi3) obj;
                } else {
                    zi3Var = new zi3(this.mSwanApiContext);
                    this.mApis.put("712777136", zi3Var);
                }
                Pair<Boolean, b42> a = d42.a(zi3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = zi3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naStorage", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                e22 e22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("-804054859", e22Var);
                }
                Pair<Boolean, b42> a = d42.a(e22Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.clearGlobalStorage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = e22Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                e22 e22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("-804054859", e22Var);
                }
                Pair<Boolean, b42> a = d42.a(e22Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.clearGlobalStorageSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 C = e22Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                d22 d22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("130910081", d22Var);
                }
                Pair<Boolean, b42> a = d42.a(d22Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.clearStorage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = d22Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                d22 d22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("130910081", d22Var);
                }
                Pair<Boolean, b42> a = d42.a(d22Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.clearStorageSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 C = d22Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                e22 e22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("-804054859", e22Var);
                }
                Pair<Boolean, b42> a = d42.a(e22Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageInfo")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 G = e22Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                e22 e22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("-804054859", e22Var);
                }
                Pair<Boolean, b42> a = d42.a(e22Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageInfoSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 J = e22Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                d22 d22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("130910081", d22Var);
                }
                Pair<Boolean, b42> a = d42.a(d22Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.getStorageInfo")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 G = d22Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                d22 d22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("130910081", d22Var);
                }
                Pair<Boolean, b42> a = d42.a(d22Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.getStorageInfoSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 J = d22Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                e22 e22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("-804054859", e22Var);
                }
                Pair<Boolean, b42> a = d42.a(e22Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 D = e22Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                e22 e22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("-804054859", e22Var);
                }
                Pair<Boolean, b42> a = d42.a(e22Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 K = e22Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                d22 d22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("130910081", d22Var);
                }
                Pair<Boolean, b42> a = d42.a(d22Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.getStorage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 D = d22Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                d22 d22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("130910081", d22Var);
                }
                Pair<Boolean, b42> a = d42.a(d22Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.getStorageInfoAsync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 H = d22Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                d22 d22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("130910081", d22Var);
                }
                Pair<Boolean, b42> a = d42.a(d22Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.getStorageSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 K = d22Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                e22 e22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("-804054859", e22Var);
                }
                Pair<Boolean, b42> a = d42.a(e22Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.removeGlobalStorage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 R = e22Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                e22 e22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("-804054859", e22Var);
                }
                Pair<Boolean, b42> a = d42.a(e22Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.removeGlobalStorageSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 T2 = e22Var.T(str);
                if (T2 == null) {
                    return "";
                }
                return T2.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                d22 d22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("130910081", d22Var);
                }
                Pair<Boolean, b42> a = d42.a(d22Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.removeStorage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 R = d22Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                d22 d22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("130910081", d22Var);
                }
                Pair<Boolean, b42> a = d42.a(d22Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.removeStorageSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 T2 = d22Var.T(str);
                if (T2 == null) {
                    return "";
                }
                return T2.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                e22 e22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("-804054859", e22Var);
                }
                Pair<Boolean, b42> a = d42.a(e22Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.setGlobalStorage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 U = e22Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                e22 e22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("-804054859", e22Var);
                }
                Pair<Boolean, b42> a = d42.a(e22Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.setGlobalStorageSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 W = e22Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                d22 d22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("130910081", d22Var);
                }
                Pair<Boolean, b42> a = d42.a(d22Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.setStorage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 U = d22Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                d22 d22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("130910081", d22Var);
                }
                Pair<Boolean, b42> a = d42.a(d22Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.setStorageSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 W = d22Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }
        });
        hashMap.put("_naSubscription", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                g22 g22Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof g22)) {
                    g22Var = (g22) obj;
                } else {
                    g22Var = new g22(this.mSwanApiContext);
                    this.mApis.put("823117982", g22Var);
                }
                Pair<Boolean, b42> a = d42.a(g22Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Subscription.requestSubscribeFormId")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 E = g22Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                h22 h22Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof h22)) {
                    h22Var = (h22) obj;
                } else {
                    h22Var = new h22(this.mSwanApiContext);
                    this.mApis.put("-947445811", h22Var);
                }
                Pair<Boolean, b42> a = d42.a(h22Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Subscription.subscribeService")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 F = h22Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }
        });
        hashMap.put("_naSystem", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                o22 o22Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof o22)) {
                    o22Var = (o22) obj;
                } else {
                    o22Var = new o22(this.mSwanApiContext);
                    this.mApis.put("1936205521", o22Var);
                }
                Pair<Boolean, b42> a = d42.a(o22Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.exitFullScreen")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = o22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                n22 n22Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof n22)) {
                    n22Var = (n22) obj;
                } else {
                    n22Var = new n22(this.mSwanApiContext);
                    this.mApis.put("1694151270", n22Var);
                }
                Pair<Boolean, b42> a = d42.a(n22Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.getDeviceInfo")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = n22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                p22 p22Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof p22)) {
                    p22Var = (p22) obj;
                } else {
                    p22Var = new p22(this.mSwanApiContext);
                    this.mApis.put("-1321681619", p22Var);
                }
                Pair<Boolean, b42> a = d42.a(p22Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.getDeviceProfile")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = p22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                q22 q22Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof q22)) {
                    q22Var = (q22) obj;
                } else {
                    q22Var = new q22(this.mSwanApiContext);
                    this.mApis.put("-1569246082", q22Var);
                }
                Pair<Boolean, b42> a = d42.a(q22Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.makePhoneCall")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = q22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                s22 s22Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof s22)) {
                    s22Var = (s22) obj;
                } else {
                    s22Var = new s22(this.mSwanApiContext);
                    this.mApis.put("1099851202", s22Var);
                }
                Pair<Boolean, b42> a = d42.a(s22Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.openSMSPanel")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = s22Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                r22 r22Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof r22)) {
                    r22Var = (r22) obj;
                } else {
                    r22Var = new r22(this.mSwanApiContext);
                    this.mApis.put("-1707203360", r22Var);
                }
                Pair<Boolean, b42> a = d42.a(r22Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.requestFullScreen")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 F = r22Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                l22 l22Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof l22)) {
                    l22Var = (l22) obj;
                } else {
                    l22Var = new l22(this.mSwanApiContext);
                    this.mApis.put("-518757484", l22Var);
                }
                Pair<Boolean, b42> a = d42.a(l22Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.setClipboardData")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = l22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                v13 v13Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof v13)) {
                    v13Var = (v13) obj;
                } else {
                    v13Var = new v13(this.mSwanApiContext);
                    this.mApis.put("1161486049", v13Var);
                }
                Pair<Boolean, b42> a = d42.a(v13Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.setErrorPageType")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = v13Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                v22 v22Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof v22)) {
                    v22Var = (v22) obj;
                } else {
                    v22Var = new v22(this.mSwanApiContext);
                    this.mApis.put("447234992", v22Var);
                }
                Pair<Boolean, b42> a = d42.a(v22Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.setMediaVolume")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 z = v22Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                j22 j22Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof j22)) {
                    j22Var = (j22) obj;
                } else {
                    j22Var = new j22(this.mSwanApiContext);
                    this.mApis.put("1372680763", j22Var);
                }
                Pair<Boolean, b42> a = d42.a(j22Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.startAccelerometer")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = j22Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                m22 m22Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof m22)) {
                    m22Var = (m22) obj;
                } else {
                    m22Var = new m22(this.mSwanApiContext);
                    this.mApis.put("1689255576", m22Var);
                }
                Pair<Boolean, b42> a = d42.a(m22Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.startCompass")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = m22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                k22 k22Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof k22)) {
                    k22Var = (k22) obj;
                } else {
                    k22Var = new k22(this.mSwanApiContext);
                    this.mApis.put("99997465", k22Var);
                }
                Pair<Boolean, b42> a = d42.a(k22Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.getBrightness")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = k22Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                l22 l22Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof l22)) {
                    l22Var = (l22) obj;
                } else {
                    l22Var = new l22(this.mSwanApiContext);
                    this.mApis.put("-518757484", l22Var);
                }
                Pair<Boolean, b42> a = d42.a(l22Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.getClipboardData")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = l22Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                v22 v22Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof v22)) {
                    v22Var = (v22) obj;
                } else {
                    v22Var = new v22(this.mSwanApiContext);
                    this.mApis.put("447234992", v22Var);
                }
                Pair<Boolean, b42> a = d42.a(v22Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.getMediaVolume")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = v22Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                j22 j22Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof j22)) {
                    j22Var = (j22) obj;
                } else {
                    j22Var = new j22(this.mSwanApiContext);
                    this.mApis.put("1372680763", j22Var);
                }
                Pair<Boolean, b42> a = d42.a(j22Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.stopAccelerometer")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 B = j22Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                m22 m22Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof m22)) {
                    m22Var = (m22) obj;
                } else {
                    m22Var = new m22(this.mSwanApiContext);
                    this.mApis.put("1689255576", m22Var);
                }
                Pair<Boolean, b42> a = d42.a(m22Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.stopCompass")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 z = m22Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naUtils", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                g32 g32Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof g32)) {
                    g32Var = (g32) obj;
                } else {
                    g32Var = new g32(this.mSwanApiContext);
                    this.mApis.put("201194468", g32Var);
                }
                Pair<Boolean, b42> a = d42.a(g32Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.addToDesktop")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 B = g32Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                c32 c32Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof c32)) {
                    c32Var = (c32) obj;
                } else {
                    c32Var = new c32(this.mSwanApiContext);
                    this.mApis.put("-1412306947", c32Var);
                }
                Pair<Boolean, b42> a = d42.a(c32Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.calcMD5")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = c32Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                d32 d32Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof d32)) {
                    d32Var = (d32) obj;
                } else {
                    d32Var = new d32(this.mSwanApiContext);
                    this.mApis.put("1626415364", d32Var);
                }
                Pair<Boolean, b42> a = d42.a(d32Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.checkAppInstalled")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = d32Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                f32 f32Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof f32)) {
                    f32Var = (f32) obj;
                } else {
                    f32Var = new f32(this.mSwanApiContext);
                    this.mApis.put("-836768778", f32Var);
                }
                Pair<Boolean, b42> a = d42.a(f32Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.getCommonSysInfo")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = f32Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                h32 h32Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof h32)) {
                    h32Var = (h32) obj;
                } else {
                    h32Var = new h32(this.mSwanApiContext);
                    this.mApis.put("-810858308", h32Var);
                }
                Pair<Boolean, b42> a = d42.a(h32Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.getPerformanceLevel")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = h32Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                l32 l32Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof l32)) {
                    l32Var = (l32) obj;
                } else {
                    l32Var = new l32(this.mSwanApiContext);
                    this.mApis.put("-1011537871", l32Var);
                }
                Pair<Boolean, b42> a = d42.a(l32Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.getSystemInfoAsync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 I = l32Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                i32 i32Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof i32)) {
                    i32Var = (i32) obj;
                } else {
                    i32Var = new i32(this.mSwanApiContext);
                    this.mApis.put("-2097727681", i32Var);
                }
                Pair<Boolean, b42> a = d42.a(i32Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.handleException")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = i32Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                e32 e32Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof e32)) {
                    e32Var = (e32) obj;
                } else {
                    e32Var = new e32(this.mSwanApiContext);
                    this.mApis.put("2084449317", e32Var);
                }
                Pair<Boolean, b42> a = d42.a(e32Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.hasCloseHandler")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = e32Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                hg3 hg3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof hg3)) {
                    hg3Var = (hg3) obj;
                } else {
                    hg3Var = new hg3(this.mSwanApiContext);
                    this.mApis.put("1031678042", hg3Var);
                }
                Pair<Boolean, b42> a = d42.a(hg3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.hideCaptureScreenShareDialog")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = hg3Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                j32 j32Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof j32)) {
                    j32Var = (j32) obj;
                } else {
                    j32Var = new j32(this.mSwanApiContext);
                    this.mApis.put("1751900130", j32Var);
                }
                Pair<Boolean, b42> a = d42.a(j32Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.logToFile")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = j32Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                if3 if3Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof if3)) {
                    if3Var = (if3) obj;
                } else {
                    if3Var = new if3(this.mSwanApiContext);
                    this.mApis.put("1748196865", if3Var);
                }
                Pair<Boolean, b42> a = d42.a(if3Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.preloadPackage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = if3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                k32 k32Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof k32)) {
                    k32Var = (k32) obj;
                } else {
                    k32Var = new k32(this.mSwanApiContext);
                    this.mApis.put("589529211", k32Var);
                }
                Pair<Boolean, b42> a = d42.a(k32Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.previewImage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 B = k32Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                n32 n32Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof n32)) {
                    n32Var = (n32) obj;
                } else {
                    n32Var = new n32(this.mSwanApiContext);
                    this.mApis.put("-577481801", n32Var);
                }
                Pair<Boolean, b42> a = d42.a(n32Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.ubcFlowJar")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 I = n32Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                l32 l32Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof l32)) {
                    l32Var = (l32) obj;
                } else {
                    l32Var = new l32(this.mSwanApiContext);
                    this.mApis.put("-1011537871", l32Var);
                }
                Pair<Boolean, b42> a = d42.a(l32Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.getCommonSysInfoSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 E = l32Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                l32 l32Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof l32)) {
                    l32Var = (l32) obj;
                } else {
                    l32Var = new l32(this.mSwanApiContext);
                    this.mApis.put("-1011537871", l32Var);
                }
                Pair<Boolean, b42> a = d42.a(l32Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.getSystemInfo")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 H = l32Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                l32 l32Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof l32)) {
                    l32Var = (l32) obj;
                } else {
                    l32Var = new l32(this.mSwanApiContext);
                    this.mApis.put("-1011537871", l32Var);
                }
                Pair<Boolean, b42> a = d42.a(l32Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.getSystemInfoSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 J = l32Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naWifi", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                sm3 sm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof sm3)) {
                    sm3Var = (sm3) obj;
                } else {
                    sm3Var = new sm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", sm3Var);
                }
                Pair<Boolean, b42> a = d42.a(sm3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Wifi.connectWifi")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = sm3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                sm3 sm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof sm3)) {
                    sm3Var = (sm3) obj;
                } else {
                    sm3Var = new sm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", sm3Var);
                }
                Pair<Boolean, b42> a = d42.a(sm3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Wifi.getConnectedWifi")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 B = sm3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                sm3 sm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof sm3)) {
                    sm3Var = (sm3) obj;
                } else {
                    sm3Var = new sm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", sm3Var);
                }
                Pair<Boolean, b42> a = d42.a(sm3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Wifi.getWifiList")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 C = sm3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                sm3 sm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof sm3)) {
                    sm3Var = (sm3) obj;
                } else {
                    sm3Var = new sm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", sm3Var);
                }
                Pair<Boolean, b42> a = d42.a(sm3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Wifi.startWifi")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 G = sm3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                sm3 sm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof sm3)) {
                    sm3Var = (sm3) obj;
                } else {
                    sm3Var = new sm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", sm3Var);
                }
                Pair<Boolean, b42> a = d42.a(sm3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Wifi.stopWifi")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 H = sm3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final d02 d02Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                j02 j02Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof j02)) {
                    j02Var = (j02) obj;
                } else {
                    j02Var = new j02(this.mSwanApiContext);
                    this.mApis.put("1930258908", j02Var);
                }
                Pair<Boolean, b42> a = d42.a(j02Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Account.checkSession")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = j02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                k02 k02Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof k02)) {
                    k02Var = (k02) obj;
                } else {
                    k02Var = new k02(this.mSwanApiContext);
                    this.mApis.put("-1017914143", k02Var);
                }
                Pair<Boolean, b42> a = d42.a(k02Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Account.getLoginCode")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 C = k02Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                l02 l02Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof l02)) {
                    l02Var = (l02) obj;
                } else {
                    l02Var = new l02(this.mSwanApiContext);
                    this.mApis.put("1754780133", l02Var);
                }
                Pair<Boolean, b42> a = d42.a(l02Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Account.getOpenId")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = l02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                sz1 sz1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof sz1)) {
                    sz1Var = (sz1) obj;
                } else {
                    sz1Var = new sz1(this.mSwanApiContext);
                    this.mApis.put("-343998465", sz1Var);
                }
                Pair<Boolean, b42> a = d42.a(sz1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Account.getUnionBDUSS")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = sz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String login(String str) {
                k02 k02Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof k02)) {
                    k02Var = (k02) obj;
                } else {
                    k02Var = new k02(this.mSwanApiContext);
                    this.mApis.put("-1017914143", k02Var);
                }
                Pair<Boolean, b42> a = d42.a(k02Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Account.login")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 I = k02Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                i02 i02Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof i02)) {
                    i02Var = (i02) obj;
                } else {
                    i02Var = new i02(this.mSwanApiContext);
                    this.mApis.put("-337742792", i02Var);
                }
                Pair<Boolean, b42> a = d42.a(i02Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Account.isBaiduAccountSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = i02Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                k02 k02Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof k02)) {
                    k02Var = (k02) obj;
                } else {
                    k02Var = new k02(this.mSwanApiContext);
                    this.mApis.put("-1017914143", k02Var);
                }
                Pair<Boolean, b42> a = d42.a(k02Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Account.isLoginSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 H = k02Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBasic", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                m02 m02Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof m02)) {
                    m02Var = (m02) obj;
                } else {
                    m02Var = new m02(this.mSwanApiContext);
                    this.mApis.put("-1249666566", m02Var);
                }
                Pair<Boolean, b42> a = d42.a(m02Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Basic.loadSubPackage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 F = m02Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                m02 m02Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof m02)) {
                    m02Var = (m02) obj;
                } else {
                    m02Var = new m02(this.mSwanApiContext);
                    this.mApis.put("-1249666566", m02Var);
                }
                Pair<Boolean, b42> a = d42.a(m02Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Basic.loadSubPackages")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 G = m02Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                ts1 ts1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ts1)) {
                    ts1Var = (ts1) obj;
                } else {
                    ts1Var = new ts1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ts1Var);
                }
                Pair<Boolean, b42> a = d42.a(ts1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Bookshelf.deleteBookshelf")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 K = ts1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                ts1 ts1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ts1)) {
                    ts1Var = (ts1) obj;
                } else {
                    ts1Var = new ts1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ts1Var);
                }
                Pair<Boolean, b42> a = d42.a(ts1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Bookshelf.insertBookshelf")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 P = ts1Var.P(str);
                if (P == null) {
                    return "";
                }
                return P.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                ts1 ts1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ts1)) {
                    ts1Var = (ts1) obj;
                } else {
                    ts1Var = new ts1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ts1Var);
                }
                Pair<Boolean, b42> a = d42.a(ts1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Bookshelf.navigateToBookshelf")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 U = ts1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                ts1 ts1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ts1)) {
                    ts1Var = (ts1) obj;
                } else {
                    ts1Var = new ts1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ts1Var);
                }
                Pair<Boolean, b42> a = d42.a(ts1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Bookshelf.queryBookshelf")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 V = ts1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                ts1 ts1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ts1)) {
                    ts1Var = (ts1) obj;
                } else {
                    ts1Var = new ts1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ts1Var);
                }
                Pair<Boolean, b42> a = d42.a(ts1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Bookshelf.updateBookshelfReadTime")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 X = ts1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naCoupon", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                g02 g02Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof g02)) {
                    g02Var = (g02) obj;
                } else {
                    g02Var = new g02(this.mSwanApiContext);
                    this.mApis.put("-277316359", g02Var);
                }
                Pair<Boolean, b42> a = d42.a(g02Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Coupon.getPlatformCoupons")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = g02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                g02 g02Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof g02)) {
                    g02Var = (g02) obj;
                } else {
                    g02Var = new g02(this.mSwanApiContext);
                    this.mApis.put("-277316359", g02Var);
                }
                Pair<Boolean, b42> a = d42.a(g02Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Coupon.getUserCoupons")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 z = g02Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                g02 g02Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof g02)) {
                    g02Var = (g02) obj;
                } else {
                    g02Var = new g02(this.mSwanApiContext);
                    this.mApis.put("-277316359", g02Var);
                }
                Pair<Boolean, b42> a = d42.a(g02Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Coupon.takeCoupons")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 C = g02Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naFavorite", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                o02 o02Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof o02)) {
                    o02Var = (o02) obj;
                } else {
                    o02Var = new o02(this.mSwanApiContext);
                    this.mApis.put("-1225406515", o02Var);
                }
                Pair<Boolean, b42> a = d42.a(o02Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Favorite.getFavorStatus")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = o02Var.x(str);
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
                Pair<Boolean, b42> a = d42.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Favorite.showFavoriteGuide")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 G = showFavoriteGuideApi.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naFile", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                q02 q02Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof q02)) {
                    q02Var = (q02) obj;
                } else {
                    q02Var = new q02(this.mSwanApiContext);
                    this.mApis.put("-2057135077", q02Var);
                }
                Pair<Boolean, b42> a = d42.a(q02Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "File.shareFile")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = q02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                fp2 fp2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof fp2)) {
                    fp2Var = (fp2) obj;
                } else {
                    fp2Var = new fp2(this.mSwanApiContext);
                    this.mApis.put("2077414795", fp2Var);
                }
                Pair<Boolean, b42> a = d42.a(fp2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "GameCenter.postGameCenterMessage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = fp2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                fp2 fp2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof fp2)) {
                    fp2Var = (fp2) obj;
                } else {
                    fp2Var = new fp2(this.mSwanApiContext);
                    this.mApis.put("2077414795", fp2Var);
                }
                Pair<Boolean, b42> a = d42.a(fp2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "GameCenter.postGameCenterMessageSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = fp2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String download(String str) {
                r02 r02Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof r02)) {
                    r02Var = (r02) obj;
                } else {
                    r02Var = new r02(this.mSwanApiContext);
                    this.mApis.put("-170124576", r02Var);
                }
                Pair<Boolean, b42> a = d42.a(r02Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "HostDownloadManager.download")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = r02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                r02 r02Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof r02)) {
                    r02Var = (r02) obj;
                } else {
                    r02Var = new r02(this.mSwanApiContext);
                    this.mApis.put("-170124576", r02Var);
                }
                Pair<Boolean, b42> a = d42.a(r02Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "HostDownloadManager.openFile")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 z = r02Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String query(String str) {
                r02 r02Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof r02)) {
                    r02Var = (r02) obj;
                } else {
                    r02Var = new r02(this.mSwanApiContext);
                    this.mApis.put("-170124576", r02Var);
                }
                Pair<Boolean, b42> a = d42.a(r02Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "HostDownloadManager.query")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 query = r02Var.query(str);
                if (query == null) {
                    return "";
                }
                return query.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                r02 r02Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof r02)) {
                    r02Var = (r02) obj;
                } else {
                    r02Var = new r02(this.mSwanApiContext);
                    this.mApis.put("-170124576", r02Var);
                }
                Pair<Boolean, b42> a = d42.a(r02Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "HostDownloadManager.openDownloadCenter")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = r02Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naImage", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                t13 t13Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof t13)) {
                    t13Var = (t13) obj;
                } else {
                    t13Var = new t13(this.mSwanApiContext);
                    this.mApis.put("1445003743", t13Var);
                }
                Pair<Boolean, b42> a = d42.a(t13Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Image.callImageMenu")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = t13Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                u02 u02Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof u02)) {
                    u02Var = (u02) obj;
                } else {
                    u02Var = new u02(this.mSwanApiContext);
                    this.mApis.put("-1252730367", u02Var);
                }
                Pair<Boolean, b42> a = d42.a(u02Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Image.compressImage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = u02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naInteraction", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                c12 c12Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof c12)) {
                    c12Var = (c12) obj;
                } else {
                    c12Var = new c12(this.mSwanApiContext);
                    this.mApis.put("-1871435471", c12Var);
                }
                Pair<Boolean, b42> a = d42.a(c12Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.closeTabBar")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = c12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                c12 c12Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof c12)) {
                    c12Var = (c12) obj;
                } else {
                    c12Var = new c12(this.mSwanApiContext);
                    this.mApis.put("-1871435471", c12Var);
                }
                Pair<Boolean, b42> a = d42.a(c12Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.closeTabBarRedDot")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = c12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                y02 y02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof y02)) {
                    y02Var = (y02) obj;
                } else {
                    y02Var = new y02(this.mSwanApiContext);
                    this.mApis.put("-246386074", y02Var);
                }
                Pair<Boolean, b42> a = d42.a(y02Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.hideNavigationBarLoading")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = y02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                a12 a12Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("-108978463", a12Var);
                }
                Pair<Boolean, b42> a = d42.a(a12Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.openMultiPicker")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 G = a12Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                a12 a12Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("-108978463", a12Var);
                }
                Pair<Boolean, b42> a = d42.a(a12Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.openPicker")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 H = a12Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                c12 c12Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof c12)) {
                    c12Var = (c12) obj;
                } else {
                    c12Var = new c12(this.mSwanApiContext);
                    this.mApis.put("-1871435471", c12Var);
                }
                Pair<Boolean, b42> a = d42.a(c12Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.openTabBar")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 C = c12Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("-1750613704", z02Var);
                }
                Pair<Boolean, b42> a = d42.a(z02Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.pageScrollTo")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = z02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                y02 y02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof y02)) {
                    y02Var = (y02) obj;
                } else {
                    y02Var = new y02(this.mSwanApiContext);
                    this.mApis.put("-246386074", y02Var);
                }
                Pair<Boolean, b42> a = d42.a(y02Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.setNavigationBarColor")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 z = y02Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                y02 y02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof y02)) {
                    y02Var = (y02) obj;
                } else {
                    y02Var = new y02(this.mSwanApiContext);
                    this.mApis.put("-246386074", y02Var);
                }
                Pair<Boolean, b42> a = d42.a(y02Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.setNavigationBarTitle")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = y02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                c12 c12Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof c12)) {
                    c12Var = (c12) obj;
                } else {
                    c12Var = new c12(this.mSwanApiContext);
                    this.mApis.put("-1871435471", c12Var);
                }
                Pair<Boolean, b42> a = d42.a(c12Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.setTabBarItem")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 D = c12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                a12 a12Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("-108978463", a12Var);
                }
                Pair<Boolean, b42> a = d42.a(a12Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.showDatePickerView")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 L = a12Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                e12 e12Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof e12)) {
                    e12Var = (e12) obj;
                } else {
                    e12Var = new e12(this.mSwanApiContext);
                    this.mApis.put("1172469410", e12Var);
                }
                Pair<Boolean, b42> a = d42.a(e12Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.showHalfScreenWebview")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 K = e12Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                w02 w02Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof w02)) {
                    w02Var = (w02) obj;
                } else {
                    w02Var = new w02(this.mSwanApiContext);
                    this.mApis.put("5236036", w02Var);
                }
                Pair<Boolean, b42> a = d42.a(w02Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.showLoading")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = w02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                x02 x02Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof x02)) {
                    x02Var = (x02) obj;
                } else {
                    x02Var = new x02(this.mSwanApiContext);
                    this.mApis.put("1913747800", x02Var);
                }
                Pair<Boolean, b42> a = d42.a(x02Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.showModal")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = x02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                y02 y02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof y02)) {
                    y02Var = (y02) obj;
                } else {
                    y02Var = new y02(this.mSwanApiContext);
                    this.mApis.put("-246386074", y02Var);
                }
                Pair<Boolean, b42> a = d42.a(y02Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.showNavigationBarLoading")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 B = y02Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                d12 d12Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof d12)) {
                    d12Var = (d12) obj;
                } else {
                    d12Var = new d12(this.mSwanApiContext);
                    this.mApis.put("1159492510", d12Var);
                }
                Pair<Boolean, b42> a = d42.a(d12Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.showToast")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 Q = d12Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                b12 b12Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof b12)) {
                    b12Var = (b12) obj;
                } else {
                    b12Var = new b12(this.mSwanApiContext);
                    this.mApis.put("1165118609", b12Var);
                }
                Pair<Boolean, b42> a = d42.a(b12Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.stopPullDownRefresh")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = b12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                a12 a12Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("-108978463", a12Var);
                }
                Pair<Boolean, b42> a = d42.a(a12Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.updateMultiPicker")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 M = a12Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                w02 w02Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof w02)) {
                    w02Var = (w02) obj;
                } else {
                    w02Var = new w02(this.mSwanApiContext);
                    this.mApis.put("5236036", w02Var);
                }
                Pair<Boolean, b42> a = d42.a(w02Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.hideLoading")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = w02Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hideToast() {
                d12 d12Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof d12)) {
                    d12Var = (d12) obj;
                } else {
                    d12Var = new d12(this.mSwanApiContext);
                    this.mApis.put("1159492510", d12Var);
                }
                Pair<Boolean, b42> a = d42.a(d12Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Interaction.hideToast")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 K = d12Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                f12 f12Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("-137346255", f12Var);
                }
                Pair<Boolean, b42> a = d42.a(f12Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Keyboard.startKeyboardHeightChange")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 C = f12Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                f12 f12Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("-137346255", f12Var);
                }
                Pair<Boolean, b42> a = d42.a(f12Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Keyboard.stopKeyboardHeightChange")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 D = f12Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naLocationService", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                g12 g12Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof g12)) {
                    g12Var = (g12) obj;
                } else {
                    g12Var = new g12(this.mSwanApiContext);
                    this.mApis.put("-397373095", g12Var);
                }
                Pair<Boolean, b42> a = d42.a(g12Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "LocationService.getLocation")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = g12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                g12 g12Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof g12)) {
                    g12Var = (g12) obj;
                } else {
                    g12Var = new g12(this.mSwanApiContext);
                    this.mApis.put("-397373095", g12Var);
                }
                Pair<Boolean, b42> a = d42.a(g12Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "LocationService.startLocationUpdate")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = g12Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                g12 g12Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof g12)) {
                    g12Var = (g12) obj;
                } else {
                    g12Var = new g12(this.mSwanApiContext);
                    this.mApis.put("-397373095", g12Var);
                }
                Pair<Boolean, b42> a = d42.a(g12Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "LocationService.stopLocationUpdate")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 B = g12Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naMenu", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                x22 x22Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof x22)) {
                    x22Var = (x22) obj;
                } else {
                    x22Var = new x22(this.mSwanApiContext);
                    this.mApis.put("538070032", x22Var);
                }
                Pair<Boolean, b42> a = d42.a(x22Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = x22Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naNetwork", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                j12 j12Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof j12)) {
                    j12Var = (j12) obj;
                } else {
                    j12Var = new j12(this.mSwanApiContext);
                    this.mApis.put("-1076509454", j12Var);
                }
                Pair<Boolean, b42> a = d42.a(j12Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Network.callService")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = j12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                q12 q12Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof q12)) {
                    q12Var = (q12) obj;
                } else {
                    q12Var = new q12(this.mSwanApiContext);
                    this.mApis.put("968563034", q12Var);
                }
                Pair<Boolean, b42> a = d42.a(q12Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Network.cancelRequest")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 D = q12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                p12 p12Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof p12)) {
                    p12Var = (p12) obj;
                } else {
                    p12Var = new p12(this.mSwanApiContext);
                    this.mApis.put("453220699", p12Var);
                }
                Pair<Boolean, b42> a = d42.a(p12Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Network.networkStatusChange")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = p12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                p12 p12Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof p12)) {
                    p12Var = (p12) obj;
                } else {
                    p12Var = new p12(this.mSwanApiContext);
                    this.mApis.put("453220699", p12Var);
                }
                Pair<Boolean, b42> a = d42.a(p12Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Network.getNetworkType")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = p12Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(String str) {
                q12 q12Var;
                String a;
                try {
                    a42.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof q12)) {
                        q12Var = (q12) obj;
                    } else {
                        q12Var = new q12(this.mSwanApiContext);
                        this.mApis.put("968563034", q12Var);
                    }
                    Pair<Boolean, b42> a2 = d42.a(q12Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((b42) a2.second).a();
                    } else if (je2.a(this.mSwanApiContext.d(), "Network.request")) {
                        a = new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<b42, JSONObject> u = f02.u(str);
                        if (!((b42) u.first).isSuccess()) {
                            a = ((b42) u.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) u.second;
                            if (jSONObject == null) {
                                a = b42.a.a();
                            } else {
                                c42 V = q12Var.V(jSONObject);
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
                        a42.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                z43 z43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof z43)) {
                    z43Var = (z43) obj;
                } else {
                    z43Var = new z43(this.mSwanApiContext);
                    this.mApis.put("-336396851", z43Var);
                }
                Pair<Boolean, b42> a = d42.a(z43Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Payment.chooseCoupon")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = z43Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                z43 z43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof z43)) {
                    z43Var = (z43) obj;
                } else {
                    z43Var = new z43(this.mSwanApiContext);
                    this.mApis.put("-336396851", z43Var);
                }
                Pair<Boolean, b42> a = d42.a(z43Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Payment.getPaymentInfo")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = z43Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                p43 p43Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof p43)) {
                    p43Var = (p43) obj;
                } else {
                    p43Var = new p43(this.mSwanApiContext);
                    this.mApis.put("1854689529", p43Var);
                }
                Pair<Boolean, b42> a = d42.a(p43Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Payment.requestThirdPayment")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = p43Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                z43 z43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof z43)) {
                    z43Var = (z43) obj;
                } else {
                    z43Var = new z43(this.mSwanApiContext);
                    this.mApis.put("-336396851", z43Var);
                }
                Pair<Boolean, b42> a = d42.a(z43Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Payment.setPaymentInfo")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 z = z43Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPlugin", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                k73 k73Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof k73)) {
                    k73Var = (k73) obj;
                } else {
                    k73Var = new k73(this.mSwanApiContext);
                    this.mApis.put("-254510461", k73Var);
                }
                Pair<Boolean, b42> a = d42.a(k73Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Plugin.invokePluginChooseAddress")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = k73Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                k73 k73Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof k73)) {
                    k73Var = (k73) obj;
                } else {
                    k73Var = new k73(this.mSwanApiContext);
                    this.mApis.put("-254510461", k73Var);
                }
                Pair<Boolean, b42> a = d42.a(k73Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 z = k73Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                k73 k73Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof k73)) {
                    k73Var = (k73) obj;
                } else {
                    k73Var = new k73(this.mSwanApiContext);
                    this.mApis.put("-254510461", k73Var);
                }
                Pair<Boolean, b42> a = d42.a(k73Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Plugin.invokePluginPayment")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = k73Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                dg2 dg2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof dg2)) {
                    dg2Var = (dg2) obj;
                } else {
                    dg2Var = new dg2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", dg2Var);
                }
                Pair<Boolean, b42> a = d42.a(dg2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Prefetch.prefetchResources")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = dg2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPreload", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                ve2 ve2Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof ve2)) {
                    ve2Var = (ve2) obj;
                } else {
                    ve2Var = new ve2(this.mSwanApiContext);
                    this.mApis.put("423661539", ve2Var);
                }
                Pair<Boolean, b42> a = d42.a(ve2Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Preload.preloadStatus")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = ve2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                fo3 fo3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof fo3)) {
                    fo3Var = (fo3) obj;
                } else {
                    fo3Var = new fo3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", fo3Var);
                }
                Pair<Boolean, b42> a = d42.a(fo3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "PrivateFile.uploadFileToBos")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 C = fo3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naRouter", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                u12 u12Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof u12)) {
                    u12Var = (u12) obj;
                } else {
                    u12Var = new u12(this.mSwanApiContext);
                    this.mApis.put("-1495163604", u12Var);
                }
                Pair<Boolean, b42> a = d42.a(u12Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Router.hideModalPage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = u12Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                u12 u12Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof u12)) {
                    u12Var = (u12) obj;
                } else {
                    u12Var = new u12(this.mSwanApiContext);
                    this.mApis.put("-1495163604", u12Var);
                }
                Pair<Boolean, b42> a = d42.a(u12Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Router.navigateBack")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 B = u12Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                v12 v12Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof v12)) {
                    v12Var = (v12) obj;
                } else {
                    v12Var = new v12(this.mSwanApiContext);
                    this.mApis.put("1968522584", v12Var);
                }
                Pair<Boolean, b42> a = d42.a(v12Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Router.navigateTo")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 H = v12Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                x12 x12Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof x12)) {
                    x12Var = (x12) obj;
                } else {
                    x12Var = new x12(this.mSwanApiContext);
                    this.mApis.put("1317280190", x12Var);
                }
                Pair<Boolean, b42> a = d42.a(x12Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Router.reLaunch")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = x12Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                y12 y12Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof y12)) {
                    y12Var = (y12) obj;
                } else {
                    y12Var = new y12(this.mSwanApiContext);
                    this.mApis.put("-420075743", y12Var);
                }
                Pair<Boolean, b42> a = d42.a(y12Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Router.reLoadErrorPage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = y12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                w12 w12Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("1792515533", w12Var);
                }
                Pair<Boolean, b42> a = d42.a(w12Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Router.redirectTo")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 D = w12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                v12 v12Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof v12)) {
                    v12Var = (v12) obj;
                } else {
                    v12Var = new v12(this.mSwanApiContext);
                    this.mApis.put("1968522584", v12Var);
                }
                Pair<Boolean, b42> a = d42.a(v12Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Router.showModalPage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 J = v12Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naSetting", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                b22 b22Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-594895721", b22Var);
                }
                Pair<Boolean, b42> a = d42.a(b22Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Setting.getAppInfoSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 F = b22Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                b22 b22Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-594895721", b22Var);
                }
                Pair<Boolean, b42> a = d42.a(b22Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Setting.getSlaveIdSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 H = b22Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                a22 a22Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("450273045", a22Var);
                }
                Pair<Boolean, b42> a = d42.a(a22Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Setting.isAllowedAdOpenAppSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = a22Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                b22 b22Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-594895721", b22Var);
                }
                Pair<Boolean, b42> a = d42.a(b22Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Setting.getSetting")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 G = b22Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                b22 b22Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-594895721", b22Var);
                }
                Pair<Boolean, b42> a = d42.a(b22Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Setting.getSwanId")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 I = b22Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                b22 b22Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-594895721", b22Var);
                }
                Pair<Boolean, b42> a = d42.a(b22Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Setting.getUserInfo")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 J = b22Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                zi3 zi3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof zi3)) {
                    zi3Var = (zi3) obj;
                } else {
                    zi3Var = new zi3(this.mSwanApiContext);
                    this.mApis.put("712777136", zi3Var);
                }
                Pair<Boolean, b42> a = d42.a(zi3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = zi3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naStorage", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                e22 e22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("-804054859", e22Var);
                }
                Pair<Boolean, b42> a = d42.a(e22Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.clearGlobalStorage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = e22Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                e22 e22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("-804054859", e22Var);
                }
                Pair<Boolean, b42> a = d42.a(e22Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.clearGlobalStorageSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 C = e22Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                d22 d22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("130910081", d22Var);
                }
                Pair<Boolean, b42> a = d42.a(d22Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.clearStorage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = d22Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                d22 d22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("130910081", d22Var);
                }
                Pair<Boolean, b42> a = d42.a(d22Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.clearStorageSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 C = d22Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                e22 e22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("-804054859", e22Var);
                }
                Pair<Boolean, b42> a = d42.a(e22Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageInfo")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 G = e22Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                e22 e22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("-804054859", e22Var);
                }
                Pair<Boolean, b42> a = d42.a(e22Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageInfoSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 J = e22Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                d22 d22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("130910081", d22Var);
                }
                Pair<Boolean, b42> a = d42.a(d22Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.getStorageInfo")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 G = d22Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                d22 d22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("130910081", d22Var);
                }
                Pair<Boolean, b42> a = d42.a(d22Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.getStorageInfoSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 J = d22Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                e22 e22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("-804054859", e22Var);
                }
                Pair<Boolean, b42> a = d42.a(e22Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 D = e22Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                e22 e22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("-804054859", e22Var);
                }
                Pair<Boolean, b42> a = d42.a(e22Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 K = e22Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                d22 d22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("130910081", d22Var);
                }
                Pair<Boolean, b42> a = d42.a(d22Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.getStorage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 D = d22Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                d22 d22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("130910081", d22Var);
                }
                Pair<Boolean, b42> a = d42.a(d22Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.getStorageInfoAsync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 H = d22Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                d22 d22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("130910081", d22Var);
                }
                Pair<Boolean, b42> a = d42.a(d22Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.getStorageSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 K = d22Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                e22 e22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("-804054859", e22Var);
                }
                Pair<Boolean, b42> a = d42.a(e22Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.removeGlobalStorage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 R = e22Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                e22 e22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("-804054859", e22Var);
                }
                Pair<Boolean, b42> a = d42.a(e22Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.removeGlobalStorageSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 T2 = e22Var.T(str);
                if (T2 == null) {
                    return "";
                }
                return T2.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                d22 d22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("130910081", d22Var);
                }
                Pair<Boolean, b42> a = d42.a(d22Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.removeStorage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 R = d22Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                d22 d22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("130910081", d22Var);
                }
                Pair<Boolean, b42> a = d42.a(d22Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.removeStorageSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 T2 = d22Var.T(str);
                if (T2 == null) {
                    return "";
                }
                return T2.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                e22 e22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("-804054859", e22Var);
                }
                Pair<Boolean, b42> a = d42.a(e22Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.setGlobalStorage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 U = e22Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                e22 e22Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("-804054859", e22Var);
                }
                Pair<Boolean, b42> a = d42.a(e22Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.setGlobalStorageSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 W = e22Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                d22 d22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("130910081", d22Var);
                }
                Pair<Boolean, b42> a = d42.a(d22Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.setStorage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 U = d22Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                d22 d22Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("130910081", d22Var);
                }
                Pair<Boolean, b42> a = d42.a(d22Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Storage.setStorageSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 W = d22Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }
        });
        hashMap.put("_naSubscription", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                g22 g22Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof g22)) {
                    g22Var = (g22) obj;
                } else {
                    g22Var = new g22(this.mSwanApiContext);
                    this.mApis.put("823117982", g22Var);
                }
                Pair<Boolean, b42> a = d42.a(g22Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Subscription.requestSubscribeFormId")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 E = g22Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                h22 h22Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof h22)) {
                    h22Var = (h22) obj;
                } else {
                    h22Var = new h22(this.mSwanApiContext);
                    this.mApis.put("-947445811", h22Var);
                }
                Pair<Boolean, b42> a = d42.a(h22Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Subscription.subscribeService")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 F = h22Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }
        });
        hashMap.put("_naSystem", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                o22 o22Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof o22)) {
                    o22Var = (o22) obj;
                } else {
                    o22Var = new o22(this.mSwanApiContext);
                    this.mApis.put("1936205521", o22Var);
                }
                Pair<Boolean, b42> a = d42.a(o22Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.exitFullScreen")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = o22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                n22 n22Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof n22)) {
                    n22Var = (n22) obj;
                } else {
                    n22Var = new n22(this.mSwanApiContext);
                    this.mApis.put("1694151270", n22Var);
                }
                Pair<Boolean, b42> a = d42.a(n22Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.getDeviceInfo")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = n22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                p22 p22Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof p22)) {
                    p22Var = (p22) obj;
                } else {
                    p22Var = new p22(this.mSwanApiContext);
                    this.mApis.put("-1321681619", p22Var);
                }
                Pair<Boolean, b42> a = d42.a(p22Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.getDeviceProfile")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = p22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                q22 q22Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof q22)) {
                    q22Var = (q22) obj;
                } else {
                    q22Var = new q22(this.mSwanApiContext);
                    this.mApis.put("-1569246082", q22Var);
                }
                Pair<Boolean, b42> a = d42.a(q22Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.makePhoneCall")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = q22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                s22 s22Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof s22)) {
                    s22Var = (s22) obj;
                } else {
                    s22Var = new s22(this.mSwanApiContext);
                    this.mApis.put("1099851202", s22Var);
                }
                Pair<Boolean, b42> a = d42.a(s22Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.openSMSPanel")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = s22Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                r22 r22Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof r22)) {
                    r22Var = (r22) obj;
                } else {
                    r22Var = new r22(this.mSwanApiContext);
                    this.mApis.put("-1707203360", r22Var);
                }
                Pair<Boolean, b42> a = d42.a(r22Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.requestFullScreen")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 F = r22Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                l22 l22Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof l22)) {
                    l22Var = (l22) obj;
                } else {
                    l22Var = new l22(this.mSwanApiContext);
                    this.mApis.put("-518757484", l22Var);
                }
                Pair<Boolean, b42> a = d42.a(l22Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.setClipboardData")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = l22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                v13 v13Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof v13)) {
                    v13Var = (v13) obj;
                } else {
                    v13Var = new v13(this.mSwanApiContext);
                    this.mApis.put("1161486049", v13Var);
                }
                Pair<Boolean, b42> a = d42.a(v13Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.setErrorPageType")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = v13Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                v22 v22Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof v22)) {
                    v22Var = (v22) obj;
                } else {
                    v22Var = new v22(this.mSwanApiContext);
                    this.mApis.put("447234992", v22Var);
                }
                Pair<Boolean, b42> a = d42.a(v22Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.setMediaVolume")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 z = v22Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                j22 j22Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof j22)) {
                    j22Var = (j22) obj;
                } else {
                    j22Var = new j22(this.mSwanApiContext);
                    this.mApis.put("1372680763", j22Var);
                }
                Pair<Boolean, b42> a = d42.a(j22Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.startAccelerometer")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = j22Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                m22 m22Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof m22)) {
                    m22Var = (m22) obj;
                } else {
                    m22Var = new m22(this.mSwanApiContext);
                    this.mApis.put("1689255576", m22Var);
                }
                Pair<Boolean, b42> a = d42.a(m22Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.startCompass")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = m22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                k22 k22Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof k22)) {
                    k22Var = (k22) obj;
                } else {
                    k22Var = new k22(this.mSwanApiContext);
                    this.mApis.put("99997465", k22Var);
                }
                Pair<Boolean, b42> a = d42.a(k22Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.getBrightness")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = k22Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                l22 l22Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof l22)) {
                    l22Var = (l22) obj;
                } else {
                    l22Var = new l22(this.mSwanApiContext);
                    this.mApis.put("-518757484", l22Var);
                }
                Pair<Boolean, b42> a = d42.a(l22Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.getClipboardData")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = l22Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                v22 v22Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof v22)) {
                    v22Var = (v22) obj;
                } else {
                    v22Var = new v22(this.mSwanApiContext);
                    this.mApis.put("447234992", v22Var);
                }
                Pair<Boolean, b42> a = d42.a(v22Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.getMediaVolume")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = v22Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                j22 j22Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof j22)) {
                    j22Var = (j22) obj;
                } else {
                    j22Var = new j22(this.mSwanApiContext);
                    this.mApis.put("1372680763", j22Var);
                }
                Pair<Boolean, b42> a = d42.a(j22Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.stopAccelerometer")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 B = j22Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                m22 m22Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof m22)) {
                    m22Var = (m22) obj;
                } else {
                    m22Var = new m22(this.mSwanApiContext);
                    this.mApis.put("1689255576", m22Var);
                }
                Pair<Boolean, b42> a = d42.a(m22Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "System.stopCompass")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 z = m22Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naUtils", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                g32 g32Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof g32)) {
                    g32Var = (g32) obj;
                } else {
                    g32Var = new g32(this.mSwanApiContext);
                    this.mApis.put("201194468", g32Var);
                }
                Pair<Boolean, b42> a = d42.a(g32Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.addToDesktop")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 B = g32Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                c32 c32Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof c32)) {
                    c32Var = (c32) obj;
                } else {
                    c32Var = new c32(this.mSwanApiContext);
                    this.mApis.put("-1412306947", c32Var);
                }
                Pair<Boolean, b42> a = d42.a(c32Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.calcMD5")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = c32Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                d32 d32Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof d32)) {
                    d32Var = (d32) obj;
                } else {
                    d32Var = new d32(this.mSwanApiContext);
                    this.mApis.put("1626415364", d32Var);
                }
                Pair<Boolean, b42> a = d42.a(d32Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.checkAppInstalled")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = d32Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                f32 f32Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof f32)) {
                    f32Var = (f32) obj;
                } else {
                    f32Var = new f32(this.mSwanApiContext);
                    this.mApis.put("-836768778", f32Var);
                }
                Pair<Boolean, b42> a = d42.a(f32Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.getCommonSysInfo")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = f32Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                h32 h32Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof h32)) {
                    h32Var = (h32) obj;
                } else {
                    h32Var = new h32(this.mSwanApiContext);
                    this.mApis.put("-810858308", h32Var);
                }
                Pair<Boolean, b42> a = d42.a(h32Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.getPerformanceLevel")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = h32Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                l32 l32Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof l32)) {
                    l32Var = (l32) obj;
                } else {
                    l32Var = new l32(this.mSwanApiContext);
                    this.mApis.put("-1011537871", l32Var);
                }
                Pair<Boolean, b42> a = d42.a(l32Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.getSystemInfoAsync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 I = l32Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                i32 i32Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof i32)) {
                    i32Var = (i32) obj;
                } else {
                    i32Var = new i32(this.mSwanApiContext);
                    this.mApis.put("-2097727681", i32Var);
                }
                Pair<Boolean, b42> a = d42.a(i32Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.handleException")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = i32Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                e32 e32Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof e32)) {
                    e32Var = (e32) obj;
                } else {
                    e32Var = new e32(this.mSwanApiContext);
                    this.mApis.put("2084449317", e32Var);
                }
                Pair<Boolean, b42> a = d42.a(e32Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.hasCloseHandler")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = e32Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                hg3 hg3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof hg3)) {
                    hg3Var = (hg3) obj;
                } else {
                    hg3Var = new hg3(this.mSwanApiContext);
                    this.mApis.put("1031678042", hg3Var);
                }
                Pair<Boolean, b42> a = d42.a(hg3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.hideCaptureScreenShareDialog")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 x = hg3Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                j32 j32Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof j32)) {
                    j32Var = (j32) obj;
                } else {
                    j32Var = new j32(this.mSwanApiContext);
                    this.mApis.put("1751900130", j32Var);
                }
                Pair<Boolean, b42> a = d42.a(j32Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.logToFile")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = j32Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                if3 if3Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof if3)) {
                    if3Var = (if3) obj;
                } else {
                    if3Var = new if3(this.mSwanApiContext);
                    this.mApis.put("1748196865", if3Var);
                }
                Pair<Boolean, b42> a = d42.a(if3Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.preloadPackage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = if3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                k32 k32Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof k32)) {
                    k32Var = (k32) obj;
                } else {
                    k32Var = new k32(this.mSwanApiContext);
                    this.mApis.put("589529211", k32Var);
                }
                Pair<Boolean, b42> a = d42.a(k32Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.previewImage")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 B = k32Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                n32 n32Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof n32)) {
                    n32Var = (n32) obj;
                } else {
                    n32Var = new n32(this.mSwanApiContext);
                    this.mApis.put("-577481801", n32Var);
                }
                Pair<Boolean, b42> a = d42.a(n32Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.ubcFlowJar")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 I = n32Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                l32 l32Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof l32)) {
                    l32Var = (l32) obj;
                } else {
                    l32Var = new l32(this.mSwanApiContext);
                    this.mApis.put("-1011537871", l32Var);
                }
                Pair<Boolean, b42> a = d42.a(l32Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.getCommonSysInfoSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 E = l32Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                l32 l32Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof l32)) {
                    l32Var = (l32) obj;
                } else {
                    l32Var = new l32(this.mSwanApiContext);
                    this.mApis.put("-1011537871", l32Var);
                }
                Pair<Boolean, b42> a = d42.a(l32Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.getSystemInfo")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 H = l32Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                l32 l32Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof l32)) {
                    l32Var = (l32) obj;
                } else {
                    l32Var = new l32(this.mSwanApiContext);
                    this.mApis.put("-1011537871", l32Var);
                }
                Pair<Boolean, b42> a = d42.a(l32Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Utils.getSystemInfoSync")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 J = l32Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naWifi", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                sm3 sm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof sm3)) {
                    sm3Var = (sm3) obj;
                } else {
                    sm3Var = new sm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", sm3Var);
                }
                Pair<Boolean, b42> a = d42.a(sm3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Wifi.connectWifi")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 A = sm3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                sm3 sm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof sm3)) {
                    sm3Var = (sm3) obj;
                } else {
                    sm3Var = new sm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", sm3Var);
                }
                Pair<Boolean, b42> a = d42.a(sm3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Wifi.getConnectedWifi")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 B = sm3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                sm3 sm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof sm3)) {
                    sm3Var = (sm3) obj;
                } else {
                    sm3Var = new sm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", sm3Var);
                }
                Pair<Boolean, b42> a = d42.a(sm3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Wifi.getWifiList")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 C = sm3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                sm3 sm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof sm3)) {
                    sm3Var = (sm3) obj;
                } else {
                    sm3Var = new sm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", sm3Var);
                }
                Pair<Boolean, b42> a = d42.a(sm3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Wifi.startWifi")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 G = sm3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                sm3 sm3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof sm3)) {
                    sm3Var = (sm3) obj;
                } else {
                    sm3Var = new sm3(this.mSwanApiContext);
                    this.mApis.put("1879401452", sm3Var);
                }
                Pair<Boolean, b42> a = d42.a(sm3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "Wifi.stopWifi")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 H = sm3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }
}
