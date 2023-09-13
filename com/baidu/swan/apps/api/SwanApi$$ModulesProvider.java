package com.baidu.swan.apps.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.tieba.a12;
import com.baidu.tieba.a13;
import com.baidu.tieba.a22;
import com.baidu.tieba.ae2;
import com.baidu.tieba.b02;
import com.baidu.tieba.b12;
import com.baidu.tieba.c02;
import com.baidu.tieba.c12;
import com.baidu.tieba.c22;
import com.baidu.tieba.d02;
import com.baidu.tieba.d12;
import com.baidu.tieba.e02;
import com.baidu.tieba.e43;
import com.baidu.tieba.ei3;
import com.baidu.tieba.f02;
import com.baidu.tieba.f12;
import com.baidu.tieba.f32;
import com.baidu.tieba.g02;
import com.baidu.tieba.g12;
import com.baidu.tieba.g32;
import com.baidu.tieba.h02;
import com.baidu.tieba.h22;
import com.baidu.tieba.h32;
import com.baidu.tieba.i02;
import com.baidu.tieba.i12;
import com.baidu.tieba.i22;
import com.baidu.tieba.i32;
import com.baidu.tieba.if2;
import com.baidu.tieba.iz1;
import com.baidu.tieba.j02;
import com.baidu.tieba.j12;
import com.baidu.tieba.j22;
import com.baidu.tieba.k02;
import com.baidu.tieba.k22;
import com.baidu.tieba.kn3;
import com.baidu.tieba.ko2;
import com.baidu.tieba.kz1;
import com.baidu.tieba.l02;
import com.baidu.tieba.l12;
import com.baidu.tieba.l22;
import com.baidu.tieba.lz1;
import com.baidu.tieba.m12;
import com.baidu.tieba.m22;
import com.baidu.tieba.mf3;
import com.baidu.tieba.n22;
import com.baidu.tieba.ne3;
import com.baidu.tieba.nz1;
import com.baidu.tieba.o02;
import com.baidu.tieba.o12;
import com.baidu.tieba.o22;
import com.baidu.tieba.od2;
import com.baidu.tieba.oz1;
import com.baidu.tieba.p12;
import com.baidu.tieba.p22;
import com.baidu.tieba.p63;
import com.baidu.tieba.pz1;
import com.baidu.tieba.q12;
import com.baidu.tieba.q22;
import com.baidu.tieba.qz1;
import com.baidu.tieba.r12;
import com.baidu.tieba.rz1;
import com.baidu.tieba.s12;
import com.baidu.tieba.s22;
import com.baidu.tieba.t12;
import com.baidu.tieba.tz1;
import com.baidu.tieba.u02;
import com.baidu.tieba.u12;
import com.baidu.tieba.u33;
import com.baidu.tieba.v02;
import com.baidu.tieba.v12;
import com.baidu.tieba.vz1;
import com.baidu.tieba.w12;
import com.baidu.tieba.wz1;
import com.baidu.tieba.x12;
import com.baidu.tieba.xl3;
import com.baidu.tieba.xy1;
import com.baidu.tieba.y03;
import com.baidu.tieba.yr1;
import com.baidu.tieba.z02;
import com.baidu.tieba.zz1;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
@Keep
/* loaded from: classes4.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final iz1 iz1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                oz1 oz1Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof oz1)) {
                    oz1Var = (oz1) obj;
                } else {
                    oz1Var = new oz1(this.mSwanApiContext);
                    this.mApis.put("1930258908", oz1Var);
                }
                Pair<Boolean, g32> a = i32.a(oz1Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Account.checkSession")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = oz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                pz1 pz1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof pz1)) {
                    pz1Var = (pz1) obj;
                } else {
                    pz1Var = new pz1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", pz1Var);
                }
                Pair<Boolean, g32> a = i32.a(pz1Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Account.getLoginCode")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 C = pz1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                qz1 qz1Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof qz1)) {
                    qz1Var = (qz1) obj;
                } else {
                    qz1Var = new qz1(this.mSwanApiContext);
                    this.mApis.put("1754780133", qz1Var);
                }
                Pair<Boolean, g32> a = i32.a(qz1Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Account.getOpenId")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = qz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                xy1 xy1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof xy1)) {
                    xy1Var = (xy1) obj;
                } else {
                    xy1Var = new xy1(this.mSwanApiContext);
                    this.mApis.put("-343998465", xy1Var);
                }
                Pair<Boolean, g32> a = i32.a(xy1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Account.getUnionBDUSS")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = xy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String login(String str) {
                pz1 pz1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof pz1)) {
                    pz1Var = (pz1) obj;
                } else {
                    pz1Var = new pz1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", pz1Var);
                }
                Pair<Boolean, g32> a = i32.a(pz1Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Account.login")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 I = pz1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                nz1 nz1Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("-337742792", nz1Var);
                }
                Pair<Boolean, g32> a = i32.a(nz1Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Account.isBaiduAccountSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = nz1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                pz1 pz1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof pz1)) {
                    pz1Var = (pz1) obj;
                } else {
                    pz1Var = new pz1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", pz1Var);
                }
                Pair<Boolean, g32> a = i32.a(pz1Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Account.isLoginSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 H = pz1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBasic", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                rz1 rz1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof rz1)) {
                    rz1Var = (rz1) obj;
                } else {
                    rz1Var = new rz1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", rz1Var);
                }
                Pair<Boolean, g32> a = i32.a(rz1Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Basic.loadSubPackage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 F = rz1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                rz1 rz1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof rz1)) {
                    rz1Var = (rz1) obj;
                } else {
                    rz1Var = new rz1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", rz1Var);
                }
                Pair<Boolean, g32> a = i32.a(rz1Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Basic.loadSubPackages")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 G = rz1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                yr1 yr1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof yr1)) {
                    yr1Var = (yr1) obj;
                } else {
                    yr1Var = new yr1(this.mSwanApiContext);
                    this.mApis.put("1460300387", yr1Var);
                }
                Pair<Boolean, g32> a = i32.a(yr1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Bookshelf.deleteBookshelf")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 K = yr1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                yr1 yr1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof yr1)) {
                    yr1Var = (yr1) obj;
                } else {
                    yr1Var = new yr1(this.mSwanApiContext);
                    this.mApis.put("1460300387", yr1Var);
                }
                Pair<Boolean, g32> a = i32.a(yr1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Bookshelf.insertBookshelf")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 P = yr1Var.P(str);
                if (P == null) {
                    return "";
                }
                return P.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                yr1 yr1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof yr1)) {
                    yr1Var = (yr1) obj;
                } else {
                    yr1Var = new yr1(this.mSwanApiContext);
                    this.mApis.put("1460300387", yr1Var);
                }
                Pair<Boolean, g32> a = i32.a(yr1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Bookshelf.navigateToBookshelf")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 U = yr1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                yr1 yr1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof yr1)) {
                    yr1Var = (yr1) obj;
                } else {
                    yr1Var = new yr1(this.mSwanApiContext);
                    this.mApis.put("1460300387", yr1Var);
                }
                Pair<Boolean, g32> a = i32.a(yr1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Bookshelf.queryBookshelf")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 V = yr1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                yr1 yr1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof yr1)) {
                    yr1Var = (yr1) obj;
                } else {
                    yr1Var = new yr1(this.mSwanApiContext);
                    this.mApis.put("1460300387", yr1Var);
                }
                Pair<Boolean, g32> a = i32.a(yr1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Bookshelf.updateBookshelfReadTime")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 X = yr1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naCoupon", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                lz1 lz1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof lz1)) {
                    lz1Var = (lz1) obj;
                } else {
                    lz1Var = new lz1(this.mSwanApiContext);
                    this.mApis.put("-277316359", lz1Var);
                }
                Pair<Boolean, g32> a = i32.a(lz1Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Coupon.getPlatformCoupons")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = lz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                lz1 lz1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof lz1)) {
                    lz1Var = (lz1) obj;
                } else {
                    lz1Var = new lz1(this.mSwanApiContext);
                    this.mApis.put("-277316359", lz1Var);
                }
                Pair<Boolean, g32> a = i32.a(lz1Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Coupon.getUserCoupons")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 z = lz1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                lz1 lz1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof lz1)) {
                    lz1Var = (lz1) obj;
                } else {
                    lz1Var = new lz1(this.mSwanApiContext);
                    this.mApis.put("-277316359", lz1Var);
                }
                Pair<Boolean, g32> a = i32.a(lz1Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Coupon.takeCoupons")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 C = lz1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naFavorite", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                tz1 tz1Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof tz1)) {
                    tz1Var = (tz1) obj;
                } else {
                    tz1Var = new tz1(this.mSwanApiContext);
                    this.mApis.put("-1225406515", tz1Var);
                }
                Pair<Boolean, g32> a = i32.a(tz1Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Favorite.getFavorStatus")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = tz1Var.x(str);
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
                Pair<Boolean, g32> a = i32.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Favorite.showFavoriteGuide")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 G = showFavoriteGuideApi.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naFile", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                vz1 vz1Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof vz1)) {
                    vz1Var = (vz1) obj;
                } else {
                    vz1Var = new vz1(this.mSwanApiContext);
                    this.mApis.put("-2057135077", vz1Var);
                }
                Pair<Boolean, g32> a = i32.a(vz1Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "File.shareFile")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = vz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                ko2 ko2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof ko2)) {
                    ko2Var = (ko2) obj;
                } else {
                    ko2Var = new ko2(this.mSwanApiContext);
                    this.mApis.put("2077414795", ko2Var);
                }
                Pair<Boolean, g32> a = i32.a(ko2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = ko2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                ko2 ko2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof ko2)) {
                    ko2Var = (ko2) obj;
                } else {
                    ko2Var = new ko2(this.mSwanApiContext);
                    this.mApis.put("2077414795", ko2Var);
                }
                Pair<Boolean, g32> a = i32.a(ko2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessageSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = ko2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String download(String str) {
                wz1 wz1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof wz1)) {
                    wz1Var = (wz1) obj;
                } else {
                    wz1Var = new wz1(this.mSwanApiContext);
                    this.mApis.put("-170124576", wz1Var);
                }
                Pair<Boolean, g32> a = i32.a(wz1Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "HostDownloadManager.download")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = wz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                wz1 wz1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof wz1)) {
                    wz1Var = (wz1) obj;
                } else {
                    wz1Var = new wz1(this.mSwanApiContext);
                    this.mApis.put("-170124576", wz1Var);
                }
                Pair<Boolean, g32> a = i32.a(wz1Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "HostDownloadManager.openFile")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 z = wz1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String query(String str) {
                wz1 wz1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof wz1)) {
                    wz1Var = (wz1) obj;
                } else {
                    wz1Var = new wz1(this.mSwanApiContext);
                    this.mApis.put("-170124576", wz1Var);
                }
                Pair<Boolean, g32> a = i32.a(wz1Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "HostDownloadManager.query")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 query = wz1Var.query(str);
                if (query == null) {
                    return "";
                }
                return query.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                wz1 wz1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof wz1)) {
                    wz1Var = (wz1) obj;
                } else {
                    wz1Var = new wz1(this.mSwanApiContext);
                    this.mApis.put("-170124576", wz1Var);
                }
                Pair<Boolean, g32> a = i32.a(wz1Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "HostDownloadManager.openDownloadCenter")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = wz1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naImage", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                y03 y03Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof y03)) {
                    y03Var = (y03) obj;
                } else {
                    y03Var = new y03(this.mSwanApiContext);
                    this.mApis.put("1445003743", y03Var);
                }
                Pair<Boolean, g32> a = i32.a(y03Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Image.callImageMenu")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = y03Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                zz1 zz1Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof zz1)) {
                    zz1Var = (zz1) obj;
                } else {
                    zz1Var = new zz1(this.mSwanApiContext);
                    this.mApis.put("-1252730367", zz1Var);
                }
                Pair<Boolean, g32> a = i32.a(zz1Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Image.compressImage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = zz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naInteraction", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                h02 h02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof h02)) {
                    h02Var = (h02) obj;
                } else {
                    h02Var = new h02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", h02Var);
                }
                Pair<Boolean, g32> a = i32.a(h02Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.closeTabBar")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = h02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                h02 h02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof h02)) {
                    h02Var = (h02) obj;
                } else {
                    h02Var = new h02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", h02Var);
                }
                Pair<Boolean, g32> a = i32.a(h02Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.closeTabBarRedDot")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = h02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                d02 d02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof d02)) {
                    d02Var = (d02) obj;
                } else {
                    d02Var = new d02(this.mSwanApiContext);
                    this.mApis.put("-246386074", d02Var);
                }
                Pair<Boolean, g32> a = i32.a(d02Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.hideNavigationBarLoading")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = d02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                f02 f02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof f02)) {
                    f02Var = (f02) obj;
                } else {
                    f02Var = new f02(this.mSwanApiContext);
                    this.mApis.put("-108978463", f02Var);
                }
                Pair<Boolean, g32> a = i32.a(f02Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.openMultiPicker")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 G = f02Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                f02 f02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof f02)) {
                    f02Var = (f02) obj;
                } else {
                    f02Var = new f02(this.mSwanApiContext);
                    this.mApis.put("-108978463", f02Var);
                }
                Pair<Boolean, g32> a = i32.a(f02Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.openPicker")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 H = f02Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                h02 h02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof h02)) {
                    h02Var = (h02) obj;
                } else {
                    h02Var = new h02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", h02Var);
                }
                Pair<Boolean, g32> a = i32.a(h02Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.openTabBar")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 C = h02Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                e02 e02Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof e02)) {
                    e02Var = (e02) obj;
                } else {
                    e02Var = new e02(this.mSwanApiContext);
                    this.mApis.put("-1750613704", e02Var);
                }
                Pair<Boolean, g32> a = i32.a(e02Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.pageScrollTo")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = e02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                d02 d02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof d02)) {
                    d02Var = (d02) obj;
                } else {
                    d02Var = new d02(this.mSwanApiContext);
                    this.mApis.put("-246386074", d02Var);
                }
                Pair<Boolean, g32> a = i32.a(d02Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarColor")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 z = d02Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                d02 d02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof d02)) {
                    d02Var = (d02) obj;
                } else {
                    d02Var = new d02(this.mSwanApiContext);
                    this.mApis.put("-246386074", d02Var);
                }
                Pair<Boolean, g32> a = i32.a(d02Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarTitle")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = d02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                h02 h02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof h02)) {
                    h02Var = (h02) obj;
                } else {
                    h02Var = new h02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", h02Var);
                }
                Pair<Boolean, g32> a = i32.a(h02Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.setTabBarItem")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 D = h02Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                f02 f02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof f02)) {
                    f02Var = (f02) obj;
                } else {
                    f02Var = new f02(this.mSwanApiContext);
                    this.mApis.put("-108978463", f02Var);
                }
                Pair<Boolean, g32> a = i32.a(f02Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.showDatePickerView")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 L = f02Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                j02 j02Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof j02)) {
                    j02Var = (j02) obj;
                } else {
                    j02Var = new j02(this.mSwanApiContext);
                    this.mApis.put("1172469410", j02Var);
                }
                Pair<Boolean, g32> a = i32.a(j02Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.showHalfScreenWebview")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 K = j02Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                b02 b02Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof b02)) {
                    b02Var = (b02) obj;
                } else {
                    b02Var = new b02(this.mSwanApiContext);
                    this.mApis.put("5236036", b02Var);
                }
                Pair<Boolean, g32> a = i32.a(b02Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.showLoading")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = b02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                c02 c02Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof c02)) {
                    c02Var = (c02) obj;
                } else {
                    c02Var = new c02(this.mSwanApiContext);
                    this.mApis.put("1913747800", c02Var);
                }
                Pair<Boolean, g32> a = i32.a(c02Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.showModal")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = c02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                d02 d02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof d02)) {
                    d02Var = (d02) obj;
                } else {
                    d02Var = new d02(this.mSwanApiContext);
                    this.mApis.put("-246386074", d02Var);
                }
                Pair<Boolean, g32> a = i32.a(d02Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.showNavigationBarLoading")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 B = d02Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                i02 i02Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof i02)) {
                    i02Var = (i02) obj;
                } else {
                    i02Var = new i02(this.mSwanApiContext);
                    this.mApis.put("1159492510", i02Var);
                }
                Pair<Boolean, g32> a = i32.a(i02Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.showToast")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 Q = i02Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                g02 g02Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof g02)) {
                    g02Var = (g02) obj;
                } else {
                    g02Var = new g02(this.mSwanApiContext);
                    this.mApis.put("1165118609", g02Var);
                }
                Pair<Boolean, g32> a = i32.a(g02Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.stopPullDownRefresh")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = g02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                f02 f02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof f02)) {
                    f02Var = (f02) obj;
                } else {
                    f02Var = new f02(this.mSwanApiContext);
                    this.mApis.put("-108978463", f02Var);
                }
                Pair<Boolean, g32> a = i32.a(f02Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.updateMultiPicker")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 M = f02Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                b02 b02Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof b02)) {
                    b02Var = (b02) obj;
                } else {
                    b02Var = new b02(this.mSwanApiContext);
                    this.mApis.put("5236036", b02Var);
                }
                Pair<Boolean, g32> a = i32.a(b02Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.hideLoading")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = b02Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hideToast() {
                i02 i02Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof i02)) {
                    i02Var = (i02) obj;
                } else {
                    i02Var = new i02(this.mSwanApiContext);
                    this.mApis.put("1159492510", i02Var);
                }
                Pair<Boolean, g32> a = i32.a(i02Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.hideToast")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 K = i02Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                k02 k02Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof k02)) {
                    k02Var = (k02) obj;
                } else {
                    k02Var = new k02(this.mSwanApiContext);
                    this.mApis.put("-137346255", k02Var);
                }
                Pair<Boolean, g32> a = i32.a(k02Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Keyboard.startKeyboardHeightChange")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 C = k02Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                k02 k02Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof k02)) {
                    k02Var = (k02) obj;
                } else {
                    k02Var = new k02(this.mSwanApiContext);
                    this.mApis.put("-137346255", k02Var);
                }
                Pair<Boolean, g32> a = i32.a(k02Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Keyboard.stopKeyboardHeightChange")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 D = k02Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naLocationService", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                l02 l02Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof l02)) {
                    l02Var = (l02) obj;
                } else {
                    l02Var = new l02(this.mSwanApiContext);
                    this.mApis.put("-397373095", l02Var);
                }
                Pair<Boolean, g32> a = i32.a(l02Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "LocationService.getLocation")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = l02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                l02 l02Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof l02)) {
                    l02Var = (l02) obj;
                } else {
                    l02Var = new l02(this.mSwanApiContext);
                    this.mApis.put("-397373095", l02Var);
                }
                Pair<Boolean, g32> a = i32.a(l02Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "LocationService.startLocationUpdate")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = l02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                l02 l02Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof l02)) {
                    l02Var = (l02) obj;
                } else {
                    l02Var = new l02(this.mSwanApiContext);
                    this.mApis.put("-397373095", l02Var);
                }
                Pair<Boolean, g32> a = i32.a(l02Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "LocationService.stopLocationUpdate")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 B = l02Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naMenu", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                c22 c22Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof c22)) {
                    c22Var = (c22) obj;
                } else {
                    c22Var = new c22(this.mSwanApiContext);
                    this.mApis.put("538070032", c22Var);
                }
                Pair<Boolean, g32> a = i32.a(c22Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = c22Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naNetwork", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                o02 o02Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof o02)) {
                    o02Var = (o02) obj;
                } else {
                    o02Var = new o02(this.mSwanApiContext);
                    this.mApis.put("-1076509454", o02Var);
                }
                Pair<Boolean, g32> a = i32.a(o02Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Network.callService")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = o02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                v02 v02Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("968563034", v02Var);
                }
                Pair<Boolean, g32> a = i32.a(v02Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Network.cancelRequest")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 D = v02Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                u02 u02Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof u02)) {
                    u02Var = (u02) obj;
                } else {
                    u02Var = new u02(this.mSwanApiContext);
                    this.mApis.put("453220699", u02Var);
                }
                Pair<Boolean, g32> a = i32.a(u02Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Network.networkStatusChange")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = u02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                u02 u02Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof u02)) {
                    u02Var = (u02) obj;
                } else {
                    u02Var = new u02(this.mSwanApiContext);
                    this.mApis.put("453220699", u02Var);
                }
                Pair<Boolean, g32> a = i32.a(u02Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Network.getNetworkType")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = u02Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(JsObject jsObject) {
                v02 v02Var;
                String a;
                try {
                    f32.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof v02)) {
                        v02Var = (v02) obj;
                    } else {
                        v02Var = new v02(this.mSwanApiContext);
                        this.mApis.put("968563034", v02Var);
                    }
                    Pair<Boolean, g32> a2 = i32.a(v02Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((g32) a2.second).a();
                    } else if (od2.a(this.mSwanApiContext.e(), "Network.request")) {
                        a = new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<g32, JSONObject> t = kz1.t(jsObject);
                        if (!((g32) t.first).isSuccess()) {
                            a = ((g32) t.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) t.second;
                            if (jSONObject == null) {
                                a = g32.a.a();
                            } else {
                                h32 V = v02Var.V(jSONObject);
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
                        f32.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                e43 e43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof e43)) {
                    e43Var = (e43) obj;
                } else {
                    e43Var = new e43(this.mSwanApiContext);
                    this.mApis.put("-336396851", e43Var);
                }
                Pair<Boolean, g32> a = i32.a(e43Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Payment.chooseCoupon")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = e43Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                e43 e43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof e43)) {
                    e43Var = (e43) obj;
                } else {
                    e43Var = new e43(this.mSwanApiContext);
                    this.mApis.put("-336396851", e43Var);
                }
                Pair<Boolean, g32> a = i32.a(e43Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Payment.getPaymentInfo")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = e43Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                u33 u33Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof u33)) {
                    u33Var = (u33) obj;
                } else {
                    u33Var = new u33(this.mSwanApiContext);
                    this.mApis.put("1854689529", u33Var);
                }
                Pair<Boolean, g32> a = i32.a(u33Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Payment.requestThirdPayment")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = u33Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                e43 e43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof e43)) {
                    e43Var = (e43) obj;
                } else {
                    e43Var = new e43(this.mSwanApiContext);
                    this.mApis.put("-336396851", e43Var);
                }
                Pair<Boolean, g32> a = i32.a(e43Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Payment.setPaymentInfo")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 z = e43Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPlugin", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                p63 p63Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof p63)) {
                    p63Var = (p63) obj;
                } else {
                    p63Var = new p63(this.mSwanApiContext);
                    this.mApis.put("-254510461", p63Var);
                }
                Pair<Boolean, g32> a = i32.a(p63Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Plugin.invokePluginChooseAddress")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = p63Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                p63 p63Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof p63)) {
                    p63Var = (p63) obj;
                } else {
                    p63Var = new p63(this.mSwanApiContext);
                    this.mApis.put("-254510461", p63Var);
                }
                Pair<Boolean, g32> a = i32.a(p63Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 z = p63Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                p63 p63Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof p63)) {
                    p63Var = (p63) obj;
                } else {
                    p63Var = new p63(this.mSwanApiContext);
                    this.mApis.put("-254510461", p63Var);
                }
                Pair<Boolean, g32> a = i32.a(p63Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Plugin.invokePluginPayment")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = p63Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                if2 if2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof if2)) {
                    if2Var = (if2) obj;
                } else {
                    if2Var = new if2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", if2Var);
                }
                Pair<Boolean, g32> a = i32.a(if2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Prefetch.prefetchResources")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = if2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPreload", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                ae2 ae2Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof ae2)) {
                    ae2Var = (ae2) obj;
                } else {
                    ae2Var = new ae2(this.mSwanApiContext);
                    this.mApis.put("423661539", ae2Var);
                }
                Pair<Boolean, g32> a = i32.a(ae2Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Preload.preloadStatus")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = ae2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                kn3 kn3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof kn3)) {
                    kn3Var = (kn3) obj;
                } else {
                    kn3Var = new kn3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", kn3Var);
                }
                Pair<Boolean, g32> a = i32.a(kn3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "PrivateFile.uploadFileToBos")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 C = kn3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naRouter", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                z02 z02Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("-1495163604", z02Var);
                }
                Pair<Boolean, g32> a = i32.a(z02Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Router.hideModalPage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = z02Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("-1495163604", z02Var);
                }
                Pair<Boolean, g32> a = i32.a(z02Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Router.navigateBack")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 B = z02Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                a12 a12Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("1968522584", a12Var);
                }
                Pair<Boolean, g32> a = i32.a(a12Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Router.navigateTo")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 H = a12Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                c12 c12Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof c12)) {
                    c12Var = (c12) obj;
                } else {
                    c12Var = new c12(this.mSwanApiContext);
                    this.mApis.put("1317280190", c12Var);
                }
                Pair<Boolean, g32> a = i32.a(c12Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Router.reLaunch")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = c12Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                d12 d12Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof d12)) {
                    d12Var = (d12) obj;
                } else {
                    d12Var = new d12(this.mSwanApiContext);
                    this.mApis.put("-420075743", d12Var);
                }
                Pair<Boolean, g32> a = i32.a(d12Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Router.reLoadErrorPage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = d12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                b12 b12Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof b12)) {
                    b12Var = (b12) obj;
                } else {
                    b12Var = new b12(this.mSwanApiContext);
                    this.mApis.put("1792515533", b12Var);
                }
                Pair<Boolean, g32> a = i32.a(b12Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Router.redirectTo")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 D = b12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                a12 a12Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("1968522584", a12Var);
                }
                Pair<Boolean, g32> a = i32.a(a12Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Router.showModalPage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 J = a12Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naSetting", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                g12 g12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof g12)) {
                    g12Var = (g12) obj;
                } else {
                    g12Var = new g12(this.mSwanApiContext);
                    this.mApis.put("-594895721", g12Var);
                }
                Pair<Boolean, g32> a = i32.a(g12Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Setting.getAppInfoSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 F = g12Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                g12 g12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof g12)) {
                    g12Var = (g12) obj;
                } else {
                    g12Var = new g12(this.mSwanApiContext);
                    this.mApis.put("-594895721", g12Var);
                }
                Pair<Boolean, g32> a = i32.a(g12Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Setting.getSlaveIdSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 H = g12Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                f12 f12Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("450273045", f12Var);
                }
                Pair<Boolean, g32> a = i32.a(f12Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Setting.isAllowedAdOpenAppSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = f12Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                g12 g12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof g12)) {
                    g12Var = (g12) obj;
                } else {
                    g12Var = new g12(this.mSwanApiContext);
                    this.mApis.put("-594895721", g12Var);
                }
                Pair<Boolean, g32> a = i32.a(g12Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Setting.getSetting")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 G = g12Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                g12 g12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof g12)) {
                    g12Var = (g12) obj;
                } else {
                    g12Var = new g12(this.mSwanApiContext);
                    this.mApis.put("-594895721", g12Var);
                }
                Pair<Boolean, g32> a = i32.a(g12Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Setting.getSwanId")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 I = g12Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                g12 g12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof g12)) {
                    g12Var = (g12) obj;
                } else {
                    g12Var = new g12(this.mSwanApiContext);
                    this.mApis.put("-594895721", g12Var);
                }
                Pair<Boolean, g32> a = i32.a(g12Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Setting.getUserInfo")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 J = g12Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                ei3 ei3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof ei3)) {
                    ei3Var = (ei3) obj;
                } else {
                    ei3Var = new ei3(this.mSwanApiContext);
                    this.mApis.put("712777136", ei3Var);
                }
                Pair<Boolean, g32> a = i32.a(ei3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = ei3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naStorage", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                j12 j12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof j12)) {
                    j12Var = (j12) obj;
                } else {
                    j12Var = new j12(this.mSwanApiContext);
                    this.mApis.put("-804054859", j12Var);
                }
                Pair<Boolean, g32> a = i32.a(j12Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = j12Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                j12 j12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof j12)) {
                    j12Var = (j12) obj;
                } else {
                    j12Var = new j12(this.mSwanApiContext);
                    this.mApis.put("-804054859", j12Var);
                }
                Pair<Boolean, g32> a = i32.a(j12Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorageSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 C = j12Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                i12 i12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("130910081", i12Var);
                }
                Pair<Boolean, g32> a = i32.a(i12Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.clearStorage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = i12Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                i12 i12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("130910081", i12Var);
                }
                Pair<Boolean, g32> a = i32.a(i12Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.clearStorageSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 C = i12Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                j12 j12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof j12)) {
                    j12Var = (j12) obj;
                } else {
                    j12Var = new j12(this.mSwanApiContext);
                    this.mApis.put("-804054859", j12Var);
                }
                Pair<Boolean, g32> a = i32.a(j12Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfo")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 G = j12Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                j12 j12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof j12)) {
                    j12Var = (j12) obj;
                } else {
                    j12Var = new j12(this.mSwanApiContext);
                    this.mApis.put("-804054859", j12Var);
                }
                Pair<Boolean, g32> a = i32.a(j12Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfoSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 J = j12Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                i12 i12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("130910081", i12Var);
                }
                Pair<Boolean, g32> a = i32.a(i12Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.getStorageInfo")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 G = i12Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                i12 i12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("130910081", i12Var);
                }
                Pair<Boolean, g32> a = i32.a(i12Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.getStorageInfoSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 J = i12Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                j12 j12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof j12)) {
                    j12Var = (j12) obj;
                } else {
                    j12Var = new j12(this.mSwanApiContext);
                    this.mApis.put("-804054859", j12Var);
                }
                Pair<Boolean, g32> a = i32.a(j12Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.getGlobalStorage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 D = j12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                j12 j12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof j12)) {
                    j12Var = (j12) obj;
                } else {
                    j12Var = new j12(this.mSwanApiContext);
                    this.mApis.put("-804054859", j12Var);
                }
                Pair<Boolean, g32> a = i32.a(j12Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 K = j12Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                i12 i12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("130910081", i12Var);
                }
                Pair<Boolean, g32> a = i32.a(i12Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.getStorage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 D = i12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                i12 i12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("130910081", i12Var);
                }
                Pair<Boolean, g32> a = i32.a(i12Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.getStorageInfoAsync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 H = i12Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                i12 i12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("130910081", i12Var);
                }
                Pair<Boolean, g32> a = i32.a(i12Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.getStorageSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 K = i12Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                j12 j12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof j12)) {
                    j12Var = (j12) obj;
                } else {
                    j12Var = new j12(this.mSwanApiContext);
                    this.mApis.put("-804054859", j12Var);
                }
                Pair<Boolean, g32> a = i32.a(j12Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 R = j12Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                j12 j12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof j12)) {
                    j12Var = (j12) obj;
                } else {
                    j12Var = new j12(this.mSwanApiContext);
                    this.mApis.put("-804054859", j12Var);
                }
                Pair<Boolean, g32> a = i32.a(j12Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorageSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 T2 = j12Var.T(str);
                if (T2 == null) {
                    return "";
                }
                return T2.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                i12 i12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("130910081", i12Var);
                }
                Pair<Boolean, g32> a = i32.a(i12Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.removeStorage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 R = i12Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                i12 i12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("130910081", i12Var);
                }
                Pair<Boolean, g32> a = i32.a(i12Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.removeStorageSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 T2 = i12Var.T(str);
                if (T2 == null) {
                    return "";
                }
                return T2.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                j12 j12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof j12)) {
                    j12Var = (j12) obj;
                } else {
                    j12Var = new j12(this.mSwanApiContext);
                    this.mApis.put("-804054859", j12Var);
                }
                Pair<Boolean, g32> a = i32.a(j12Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.setGlobalStorage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 U = j12Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                j12 j12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof j12)) {
                    j12Var = (j12) obj;
                } else {
                    j12Var = new j12(this.mSwanApiContext);
                    this.mApis.put("-804054859", j12Var);
                }
                Pair<Boolean, g32> a = i32.a(j12Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.setGlobalStorageSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 W = j12Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                i12 i12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("130910081", i12Var);
                }
                Pair<Boolean, g32> a = i32.a(i12Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.setStorage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 U = i12Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                i12 i12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("130910081", i12Var);
                }
                Pair<Boolean, g32> a = i32.a(i12Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.setStorageSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 W = i12Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }
        });
        hashMap.put("_naSubscription", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                l12 l12Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof l12)) {
                    l12Var = (l12) obj;
                } else {
                    l12Var = new l12(this.mSwanApiContext);
                    this.mApis.put("823117982", l12Var);
                }
                Pair<Boolean, g32> a = i32.a(l12Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Subscription.requestSubscribeFormId")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 E = l12Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                m12 m12Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof m12)) {
                    m12Var = (m12) obj;
                } else {
                    m12Var = new m12(this.mSwanApiContext);
                    this.mApis.put("-947445811", m12Var);
                }
                Pair<Boolean, g32> a = i32.a(m12Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Subscription.subscribeService")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 F = m12Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }
        });
        hashMap.put("_naSystem", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                t12 t12Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof t12)) {
                    t12Var = (t12) obj;
                } else {
                    t12Var = new t12(this.mSwanApiContext);
                    this.mApis.put("1936205521", t12Var);
                }
                Pair<Boolean, g32> a = i32.a(t12Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.exitFullScreen")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = t12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                s12 s12Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof s12)) {
                    s12Var = (s12) obj;
                } else {
                    s12Var = new s12(this.mSwanApiContext);
                    this.mApis.put("1694151270", s12Var);
                }
                Pair<Boolean, g32> a = i32.a(s12Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.getDeviceInfo")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = s12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                u12 u12Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof u12)) {
                    u12Var = (u12) obj;
                } else {
                    u12Var = new u12(this.mSwanApiContext);
                    this.mApis.put("-1321681619", u12Var);
                }
                Pair<Boolean, g32> a = i32.a(u12Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.getDeviceProfile")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = u12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                v12 v12Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof v12)) {
                    v12Var = (v12) obj;
                } else {
                    v12Var = new v12(this.mSwanApiContext);
                    this.mApis.put("-1569246082", v12Var);
                }
                Pair<Boolean, g32> a = i32.a(v12Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.makePhoneCall")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = v12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                x12 x12Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof x12)) {
                    x12Var = (x12) obj;
                } else {
                    x12Var = new x12(this.mSwanApiContext);
                    this.mApis.put("1099851202", x12Var);
                }
                Pair<Boolean, g32> a = i32.a(x12Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.openSMSPanel")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = x12Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                w12 w12Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("-1707203360", w12Var);
                }
                Pair<Boolean, g32> a = i32.a(w12Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.requestFullScreen")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 F = w12Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                q12 q12Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof q12)) {
                    q12Var = (q12) obj;
                } else {
                    q12Var = new q12(this.mSwanApiContext);
                    this.mApis.put("-518757484", q12Var);
                }
                Pair<Boolean, g32> a = i32.a(q12Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.setClipboardData")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = q12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                a13 a13Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof a13)) {
                    a13Var = (a13) obj;
                } else {
                    a13Var = new a13(this.mSwanApiContext);
                    this.mApis.put("1161486049", a13Var);
                }
                Pair<Boolean, g32> a = i32.a(a13Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.setErrorPageType")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = a13Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                a22 a22Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("447234992", a22Var);
                }
                Pair<Boolean, g32> a = i32.a(a22Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.setMediaVolume")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 z = a22Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                o12 o12Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof o12)) {
                    o12Var = (o12) obj;
                } else {
                    o12Var = new o12(this.mSwanApiContext);
                    this.mApis.put("1372680763", o12Var);
                }
                Pair<Boolean, g32> a = i32.a(o12Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.startAccelerometer")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = o12Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                r12 r12Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof r12)) {
                    r12Var = (r12) obj;
                } else {
                    r12Var = new r12(this.mSwanApiContext);
                    this.mApis.put("1689255576", r12Var);
                }
                Pair<Boolean, g32> a = i32.a(r12Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.startCompass")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = r12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                p12 p12Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof p12)) {
                    p12Var = (p12) obj;
                } else {
                    p12Var = new p12(this.mSwanApiContext);
                    this.mApis.put("99997465", p12Var);
                }
                Pair<Boolean, g32> a = i32.a(p12Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.getBrightness")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = p12Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                q12 q12Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof q12)) {
                    q12Var = (q12) obj;
                } else {
                    q12Var = new q12(this.mSwanApiContext);
                    this.mApis.put("-518757484", q12Var);
                }
                Pair<Boolean, g32> a = i32.a(q12Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.getClipboardData")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = q12Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                a22 a22Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("447234992", a22Var);
                }
                Pair<Boolean, g32> a = i32.a(a22Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.getMediaVolume")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = a22Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                o12 o12Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof o12)) {
                    o12Var = (o12) obj;
                } else {
                    o12Var = new o12(this.mSwanApiContext);
                    this.mApis.put("1372680763", o12Var);
                }
                Pair<Boolean, g32> a = i32.a(o12Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.stopAccelerometer")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 B = o12Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                r12 r12Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof r12)) {
                    r12Var = (r12) obj;
                } else {
                    r12Var = new r12(this.mSwanApiContext);
                    this.mApis.put("1689255576", r12Var);
                }
                Pair<Boolean, g32> a = i32.a(r12Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.stopCompass")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 z = r12Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naUtils", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                l22 l22Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof l22)) {
                    l22Var = (l22) obj;
                } else {
                    l22Var = new l22(this.mSwanApiContext);
                    this.mApis.put("201194468", l22Var);
                }
                Pair<Boolean, g32> a = i32.a(l22Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.addToDesktop")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 B = l22Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                h22 h22Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof h22)) {
                    h22Var = (h22) obj;
                } else {
                    h22Var = new h22(this.mSwanApiContext);
                    this.mApis.put("-1412306947", h22Var);
                }
                Pair<Boolean, g32> a = i32.a(h22Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.calcMD5")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = h22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                i22 i22Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof i22)) {
                    i22Var = (i22) obj;
                } else {
                    i22Var = new i22(this.mSwanApiContext);
                    this.mApis.put("1626415364", i22Var);
                }
                Pair<Boolean, g32> a = i32.a(i22Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.checkAppInstalled")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = i22Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                k22 k22Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof k22)) {
                    k22Var = (k22) obj;
                } else {
                    k22Var = new k22(this.mSwanApiContext);
                    this.mApis.put("-836768778", k22Var);
                }
                Pair<Boolean, g32> a = i32.a(k22Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfo")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = k22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                m22 m22Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof m22)) {
                    m22Var = (m22) obj;
                } else {
                    m22Var = new m22(this.mSwanApiContext);
                    this.mApis.put("-810858308", m22Var);
                }
                Pair<Boolean, g32> a = i32.a(m22Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.getPerformanceLevel")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = m22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                q22 q22Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof q22)) {
                    q22Var = (q22) obj;
                } else {
                    q22Var = new q22(this.mSwanApiContext);
                    this.mApis.put("-1011537871", q22Var);
                }
                Pair<Boolean, g32> a = i32.a(q22Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.getSystemInfoAsync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 I = q22Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                n22 n22Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof n22)) {
                    n22Var = (n22) obj;
                } else {
                    n22Var = new n22(this.mSwanApiContext);
                    this.mApis.put("-2097727681", n22Var);
                }
                Pair<Boolean, g32> a = i32.a(n22Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.handleException")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = n22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                j22 j22Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof j22)) {
                    j22Var = (j22) obj;
                } else {
                    j22Var = new j22(this.mSwanApiContext);
                    this.mApis.put("2084449317", j22Var);
                }
                Pair<Boolean, g32> a = i32.a(j22Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.hasCloseHandler")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = j22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                mf3 mf3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof mf3)) {
                    mf3Var = (mf3) obj;
                } else {
                    mf3Var = new mf3(this.mSwanApiContext);
                    this.mApis.put("1031678042", mf3Var);
                }
                Pair<Boolean, g32> a = i32.a(mf3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.hideCaptureScreenShareDialog")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = mf3Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                o22 o22Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof o22)) {
                    o22Var = (o22) obj;
                } else {
                    o22Var = new o22(this.mSwanApiContext);
                    this.mApis.put("1751900130", o22Var);
                }
                Pair<Boolean, g32> a = i32.a(o22Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.logToFile")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = o22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                ne3 ne3Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof ne3)) {
                    ne3Var = (ne3) obj;
                } else {
                    ne3Var = new ne3(this.mSwanApiContext);
                    this.mApis.put("1748196865", ne3Var);
                }
                Pair<Boolean, g32> a = i32.a(ne3Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.preloadPackage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = ne3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                p22 p22Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof p22)) {
                    p22Var = (p22) obj;
                } else {
                    p22Var = new p22(this.mSwanApiContext);
                    this.mApis.put("589529211", p22Var);
                }
                Pair<Boolean, g32> a = i32.a(p22Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.previewImage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 B = p22Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                s22 s22Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof s22)) {
                    s22Var = (s22) obj;
                } else {
                    s22Var = new s22(this.mSwanApiContext);
                    this.mApis.put("-577481801", s22Var);
                }
                Pair<Boolean, g32> a = i32.a(s22Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.ubcFlowJar")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 I = s22Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                q22 q22Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof q22)) {
                    q22Var = (q22) obj;
                } else {
                    q22Var = new q22(this.mSwanApiContext);
                    this.mApis.put("-1011537871", q22Var);
                }
                Pair<Boolean, g32> a = i32.a(q22Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfoSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 E = q22Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                q22 q22Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof q22)) {
                    q22Var = (q22) obj;
                } else {
                    q22Var = new q22(this.mSwanApiContext);
                    this.mApis.put("-1011537871", q22Var);
                }
                Pair<Boolean, g32> a = i32.a(q22Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.getSystemInfo")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 H = q22Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                q22 q22Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof q22)) {
                    q22Var = (q22) obj;
                } else {
                    q22Var = new q22(this.mSwanApiContext);
                    this.mApis.put("-1011537871", q22Var);
                }
                Pair<Boolean, g32> a = i32.a(q22Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.getSystemInfoSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 J = q22Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naWifi", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                xl3 xl3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof xl3)) {
                    xl3Var = (xl3) obj;
                } else {
                    xl3Var = new xl3(this.mSwanApiContext);
                    this.mApis.put("1879401452", xl3Var);
                }
                Pair<Boolean, g32> a = i32.a(xl3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Wifi.connectWifi")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = xl3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                xl3 xl3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof xl3)) {
                    xl3Var = (xl3) obj;
                } else {
                    xl3Var = new xl3(this.mSwanApiContext);
                    this.mApis.put("1879401452", xl3Var);
                }
                Pair<Boolean, g32> a = i32.a(xl3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Wifi.getConnectedWifi")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 B = xl3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                xl3 xl3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof xl3)) {
                    xl3Var = (xl3) obj;
                } else {
                    xl3Var = new xl3(this.mSwanApiContext);
                    this.mApis.put("1879401452", xl3Var);
                }
                Pair<Boolean, g32> a = i32.a(xl3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Wifi.getWifiList")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 C = xl3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                xl3 xl3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof xl3)) {
                    xl3Var = (xl3) obj;
                } else {
                    xl3Var = new xl3(this.mSwanApiContext);
                    this.mApis.put("1879401452", xl3Var);
                }
                Pair<Boolean, g32> a = i32.a(xl3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Wifi.startWifi")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 G = xl3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                xl3 xl3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof xl3)) {
                    xl3Var = (xl3) obj;
                } else {
                    xl3Var = new xl3(this.mSwanApiContext);
                    this.mApis.put("1879401452", xl3Var);
                }
                Pair<Boolean, g32> a = i32.a(xl3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Wifi.stopWifi")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 H = xl3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final iz1 iz1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                oz1 oz1Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof oz1)) {
                    oz1Var = (oz1) obj;
                } else {
                    oz1Var = new oz1(this.mSwanApiContext);
                    this.mApis.put("1930258908", oz1Var);
                }
                Pair<Boolean, g32> a = i32.a(oz1Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Account.checkSession")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = oz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                pz1 pz1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof pz1)) {
                    pz1Var = (pz1) obj;
                } else {
                    pz1Var = new pz1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", pz1Var);
                }
                Pair<Boolean, g32> a = i32.a(pz1Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Account.getLoginCode")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 C = pz1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                qz1 qz1Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof qz1)) {
                    qz1Var = (qz1) obj;
                } else {
                    qz1Var = new qz1(this.mSwanApiContext);
                    this.mApis.put("1754780133", qz1Var);
                }
                Pair<Boolean, g32> a = i32.a(qz1Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Account.getOpenId")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = qz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                xy1 xy1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof xy1)) {
                    xy1Var = (xy1) obj;
                } else {
                    xy1Var = new xy1(this.mSwanApiContext);
                    this.mApis.put("-343998465", xy1Var);
                }
                Pair<Boolean, g32> a = i32.a(xy1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Account.getUnionBDUSS")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = xy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String login(String str) {
                pz1 pz1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof pz1)) {
                    pz1Var = (pz1) obj;
                } else {
                    pz1Var = new pz1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", pz1Var);
                }
                Pair<Boolean, g32> a = i32.a(pz1Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Account.login")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 I = pz1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                nz1 nz1Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("-337742792", nz1Var);
                }
                Pair<Boolean, g32> a = i32.a(nz1Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Account.isBaiduAccountSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = nz1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                pz1 pz1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof pz1)) {
                    pz1Var = (pz1) obj;
                } else {
                    pz1Var = new pz1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", pz1Var);
                }
                Pair<Boolean, g32> a = i32.a(pz1Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Account.isLoginSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 H = pz1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBasic", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                rz1 rz1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof rz1)) {
                    rz1Var = (rz1) obj;
                } else {
                    rz1Var = new rz1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", rz1Var);
                }
                Pair<Boolean, g32> a = i32.a(rz1Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Basic.loadSubPackage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 F = rz1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                rz1 rz1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof rz1)) {
                    rz1Var = (rz1) obj;
                } else {
                    rz1Var = new rz1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", rz1Var);
                }
                Pair<Boolean, g32> a = i32.a(rz1Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Basic.loadSubPackages")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 G = rz1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                yr1 yr1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof yr1)) {
                    yr1Var = (yr1) obj;
                } else {
                    yr1Var = new yr1(this.mSwanApiContext);
                    this.mApis.put("1460300387", yr1Var);
                }
                Pair<Boolean, g32> a = i32.a(yr1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Bookshelf.deleteBookshelf")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 K = yr1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                yr1 yr1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof yr1)) {
                    yr1Var = (yr1) obj;
                } else {
                    yr1Var = new yr1(this.mSwanApiContext);
                    this.mApis.put("1460300387", yr1Var);
                }
                Pair<Boolean, g32> a = i32.a(yr1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Bookshelf.insertBookshelf")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 P = yr1Var.P(str);
                if (P == null) {
                    return "";
                }
                return P.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                yr1 yr1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof yr1)) {
                    yr1Var = (yr1) obj;
                } else {
                    yr1Var = new yr1(this.mSwanApiContext);
                    this.mApis.put("1460300387", yr1Var);
                }
                Pair<Boolean, g32> a = i32.a(yr1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Bookshelf.navigateToBookshelf")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 U = yr1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                yr1 yr1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof yr1)) {
                    yr1Var = (yr1) obj;
                } else {
                    yr1Var = new yr1(this.mSwanApiContext);
                    this.mApis.put("1460300387", yr1Var);
                }
                Pair<Boolean, g32> a = i32.a(yr1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Bookshelf.queryBookshelf")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 V = yr1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                yr1 yr1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof yr1)) {
                    yr1Var = (yr1) obj;
                } else {
                    yr1Var = new yr1(this.mSwanApiContext);
                    this.mApis.put("1460300387", yr1Var);
                }
                Pair<Boolean, g32> a = i32.a(yr1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Bookshelf.updateBookshelfReadTime")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 X = yr1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naCoupon", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                lz1 lz1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof lz1)) {
                    lz1Var = (lz1) obj;
                } else {
                    lz1Var = new lz1(this.mSwanApiContext);
                    this.mApis.put("-277316359", lz1Var);
                }
                Pair<Boolean, g32> a = i32.a(lz1Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Coupon.getPlatformCoupons")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = lz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                lz1 lz1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof lz1)) {
                    lz1Var = (lz1) obj;
                } else {
                    lz1Var = new lz1(this.mSwanApiContext);
                    this.mApis.put("-277316359", lz1Var);
                }
                Pair<Boolean, g32> a = i32.a(lz1Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Coupon.getUserCoupons")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 z = lz1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                lz1 lz1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof lz1)) {
                    lz1Var = (lz1) obj;
                } else {
                    lz1Var = new lz1(this.mSwanApiContext);
                    this.mApis.put("-277316359", lz1Var);
                }
                Pair<Boolean, g32> a = i32.a(lz1Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Coupon.takeCoupons")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 C = lz1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naFavorite", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                tz1 tz1Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof tz1)) {
                    tz1Var = (tz1) obj;
                } else {
                    tz1Var = new tz1(this.mSwanApiContext);
                    this.mApis.put("-1225406515", tz1Var);
                }
                Pair<Boolean, g32> a = i32.a(tz1Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Favorite.getFavorStatus")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = tz1Var.x(str);
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
                Pair<Boolean, g32> a = i32.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Favorite.showFavoriteGuide")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 G = showFavoriteGuideApi.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naFile", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                vz1 vz1Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof vz1)) {
                    vz1Var = (vz1) obj;
                } else {
                    vz1Var = new vz1(this.mSwanApiContext);
                    this.mApis.put("-2057135077", vz1Var);
                }
                Pair<Boolean, g32> a = i32.a(vz1Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "File.shareFile")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = vz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                ko2 ko2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof ko2)) {
                    ko2Var = (ko2) obj;
                } else {
                    ko2Var = new ko2(this.mSwanApiContext);
                    this.mApis.put("2077414795", ko2Var);
                }
                Pair<Boolean, g32> a = i32.a(ko2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = ko2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                ko2 ko2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof ko2)) {
                    ko2Var = (ko2) obj;
                } else {
                    ko2Var = new ko2(this.mSwanApiContext);
                    this.mApis.put("2077414795", ko2Var);
                }
                Pair<Boolean, g32> a = i32.a(ko2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessageSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = ko2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String download(String str) {
                wz1 wz1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof wz1)) {
                    wz1Var = (wz1) obj;
                } else {
                    wz1Var = new wz1(this.mSwanApiContext);
                    this.mApis.put("-170124576", wz1Var);
                }
                Pair<Boolean, g32> a = i32.a(wz1Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "HostDownloadManager.download")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = wz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                wz1 wz1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof wz1)) {
                    wz1Var = (wz1) obj;
                } else {
                    wz1Var = new wz1(this.mSwanApiContext);
                    this.mApis.put("-170124576", wz1Var);
                }
                Pair<Boolean, g32> a = i32.a(wz1Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "HostDownloadManager.openFile")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 z = wz1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String query(String str) {
                wz1 wz1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof wz1)) {
                    wz1Var = (wz1) obj;
                } else {
                    wz1Var = new wz1(this.mSwanApiContext);
                    this.mApis.put("-170124576", wz1Var);
                }
                Pair<Boolean, g32> a = i32.a(wz1Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "HostDownloadManager.query")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 query = wz1Var.query(str);
                if (query == null) {
                    return "";
                }
                return query.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                wz1 wz1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof wz1)) {
                    wz1Var = (wz1) obj;
                } else {
                    wz1Var = new wz1(this.mSwanApiContext);
                    this.mApis.put("-170124576", wz1Var);
                }
                Pair<Boolean, g32> a = i32.a(wz1Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "HostDownloadManager.openDownloadCenter")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = wz1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naImage", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                y03 y03Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof y03)) {
                    y03Var = (y03) obj;
                } else {
                    y03Var = new y03(this.mSwanApiContext);
                    this.mApis.put("1445003743", y03Var);
                }
                Pair<Boolean, g32> a = i32.a(y03Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Image.callImageMenu")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = y03Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                zz1 zz1Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof zz1)) {
                    zz1Var = (zz1) obj;
                } else {
                    zz1Var = new zz1(this.mSwanApiContext);
                    this.mApis.put("-1252730367", zz1Var);
                }
                Pair<Boolean, g32> a = i32.a(zz1Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Image.compressImage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = zz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naInteraction", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                h02 h02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof h02)) {
                    h02Var = (h02) obj;
                } else {
                    h02Var = new h02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", h02Var);
                }
                Pair<Boolean, g32> a = i32.a(h02Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.closeTabBar")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = h02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                h02 h02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof h02)) {
                    h02Var = (h02) obj;
                } else {
                    h02Var = new h02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", h02Var);
                }
                Pair<Boolean, g32> a = i32.a(h02Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.closeTabBarRedDot")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = h02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                d02 d02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof d02)) {
                    d02Var = (d02) obj;
                } else {
                    d02Var = new d02(this.mSwanApiContext);
                    this.mApis.put("-246386074", d02Var);
                }
                Pair<Boolean, g32> a = i32.a(d02Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.hideNavigationBarLoading")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = d02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                f02 f02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof f02)) {
                    f02Var = (f02) obj;
                } else {
                    f02Var = new f02(this.mSwanApiContext);
                    this.mApis.put("-108978463", f02Var);
                }
                Pair<Boolean, g32> a = i32.a(f02Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.openMultiPicker")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 G = f02Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                f02 f02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof f02)) {
                    f02Var = (f02) obj;
                } else {
                    f02Var = new f02(this.mSwanApiContext);
                    this.mApis.put("-108978463", f02Var);
                }
                Pair<Boolean, g32> a = i32.a(f02Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.openPicker")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 H = f02Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                h02 h02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof h02)) {
                    h02Var = (h02) obj;
                } else {
                    h02Var = new h02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", h02Var);
                }
                Pair<Boolean, g32> a = i32.a(h02Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.openTabBar")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 C = h02Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                e02 e02Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof e02)) {
                    e02Var = (e02) obj;
                } else {
                    e02Var = new e02(this.mSwanApiContext);
                    this.mApis.put("-1750613704", e02Var);
                }
                Pair<Boolean, g32> a = i32.a(e02Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.pageScrollTo")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = e02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                d02 d02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof d02)) {
                    d02Var = (d02) obj;
                } else {
                    d02Var = new d02(this.mSwanApiContext);
                    this.mApis.put("-246386074", d02Var);
                }
                Pair<Boolean, g32> a = i32.a(d02Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarColor")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 z = d02Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                d02 d02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof d02)) {
                    d02Var = (d02) obj;
                } else {
                    d02Var = new d02(this.mSwanApiContext);
                    this.mApis.put("-246386074", d02Var);
                }
                Pair<Boolean, g32> a = i32.a(d02Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarTitle")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = d02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                h02 h02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof h02)) {
                    h02Var = (h02) obj;
                } else {
                    h02Var = new h02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", h02Var);
                }
                Pair<Boolean, g32> a = i32.a(h02Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.setTabBarItem")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 D = h02Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                f02 f02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof f02)) {
                    f02Var = (f02) obj;
                } else {
                    f02Var = new f02(this.mSwanApiContext);
                    this.mApis.put("-108978463", f02Var);
                }
                Pair<Boolean, g32> a = i32.a(f02Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.showDatePickerView")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 L = f02Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                j02 j02Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof j02)) {
                    j02Var = (j02) obj;
                } else {
                    j02Var = new j02(this.mSwanApiContext);
                    this.mApis.put("1172469410", j02Var);
                }
                Pair<Boolean, g32> a = i32.a(j02Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.showHalfScreenWebview")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 K = j02Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                b02 b02Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof b02)) {
                    b02Var = (b02) obj;
                } else {
                    b02Var = new b02(this.mSwanApiContext);
                    this.mApis.put("5236036", b02Var);
                }
                Pair<Boolean, g32> a = i32.a(b02Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.showLoading")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = b02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                c02 c02Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof c02)) {
                    c02Var = (c02) obj;
                } else {
                    c02Var = new c02(this.mSwanApiContext);
                    this.mApis.put("1913747800", c02Var);
                }
                Pair<Boolean, g32> a = i32.a(c02Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.showModal")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = c02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                d02 d02Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof d02)) {
                    d02Var = (d02) obj;
                } else {
                    d02Var = new d02(this.mSwanApiContext);
                    this.mApis.put("-246386074", d02Var);
                }
                Pair<Boolean, g32> a = i32.a(d02Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.showNavigationBarLoading")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 B = d02Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                i02 i02Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof i02)) {
                    i02Var = (i02) obj;
                } else {
                    i02Var = new i02(this.mSwanApiContext);
                    this.mApis.put("1159492510", i02Var);
                }
                Pair<Boolean, g32> a = i32.a(i02Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.showToast")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 Q = i02Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                g02 g02Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof g02)) {
                    g02Var = (g02) obj;
                } else {
                    g02Var = new g02(this.mSwanApiContext);
                    this.mApis.put("1165118609", g02Var);
                }
                Pair<Boolean, g32> a = i32.a(g02Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.stopPullDownRefresh")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = g02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                f02 f02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof f02)) {
                    f02Var = (f02) obj;
                } else {
                    f02Var = new f02(this.mSwanApiContext);
                    this.mApis.put("-108978463", f02Var);
                }
                Pair<Boolean, g32> a = i32.a(f02Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.updateMultiPicker")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 M = f02Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                b02 b02Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof b02)) {
                    b02Var = (b02) obj;
                } else {
                    b02Var = new b02(this.mSwanApiContext);
                    this.mApis.put("5236036", b02Var);
                }
                Pair<Boolean, g32> a = i32.a(b02Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.hideLoading")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = b02Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hideToast() {
                i02 i02Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof i02)) {
                    i02Var = (i02) obj;
                } else {
                    i02Var = new i02(this.mSwanApiContext);
                    this.mApis.put("1159492510", i02Var);
                }
                Pair<Boolean, g32> a = i32.a(i02Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Interaction.hideToast")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 K = i02Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                k02 k02Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof k02)) {
                    k02Var = (k02) obj;
                } else {
                    k02Var = new k02(this.mSwanApiContext);
                    this.mApis.put("-137346255", k02Var);
                }
                Pair<Boolean, g32> a = i32.a(k02Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Keyboard.startKeyboardHeightChange")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 C = k02Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                k02 k02Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof k02)) {
                    k02Var = (k02) obj;
                } else {
                    k02Var = new k02(this.mSwanApiContext);
                    this.mApis.put("-137346255", k02Var);
                }
                Pair<Boolean, g32> a = i32.a(k02Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Keyboard.stopKeyboardHeightChange")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 D = k02Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naLocationService", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                l02 l02Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof l02)) {
                    l02Var = (l02) obj;
                } else {
                    l02Var = new l02(this.mSwanApiContext);
                    this.mApis.put("-397373095", l02Var);
                }
                Pair<Boolean, g32> a = i32.a(l02Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "LocationService.getLocation")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = l02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                l02 l02Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof l02)) {
                    l02Var = (l02) obj;
                } else {
                    l02Var = new l02(this.mSwanApiContext);
                    this.mApis.put("-397373095", l02Var);
                }
                Pair<Boolean, g32> a = i32.a(l02Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "LocationService.startLocationUpdate")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = l02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                l02 l02Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof l02)) {
                    l02Var = (l02) obj;
                } else {
                    l02Var = new l02(this.mSwanApiContext);
                    this.mApis.put("-397373095", l02Var);
                }
                Pair<Boolean, g32> a = i32.a(l02Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "LocationService.stopLocationUpdate")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 B = l02Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naMenu", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                c22 c22Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof c22)) {
                    c22Var = (c22) obj;
                } else {
                    c22Var = new c22(this.mSwanApiContext);
                    this.mApis.put("538070032", c22Var);
                }
                Pair<Boolean, g32> a = i32.a(c22Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = c22Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naNetwork", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                o02 o02Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof o02)) {
                    o02Var = (o02) obj;
                } else {
                    o02Var = new o02(this.mSwanApiContext);
                    this.mApis.put("-1076509454", o02Var);
                }
                Pair<Boolean, g32> a = i32.a(o02Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Network.callService")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = o02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                v02 v02Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("968563034", v02Var);
                }
                Pair<Boolean, g32> a = i32.a(v02Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Network.cancelRequest")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 D = v02Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                u02 u02Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof u02)) {
                    u02Var = (u02) obj;
                } else {
                    u02Var = new u02(this.mSwanApiContext);
                    this.mApis.put("453220699", u02Var);
                }
                Pair<Boolean, g32> a = i32.a(u02Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Network.networkStatusChange")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = u02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                u02 u02Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof u02)) {
                    u02Var = (u02) obj;
                } else {
                    u02Var = new u02(this.mSwanApiContext);
                    this.mApis.put("453220699", u02Var);
                }
                Pair<Boolean, g32> a = i32.a(u02Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Network.getNetworkType")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = u02Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(String str) {
                v02 v02Var;
                String a;
                try {
                    f32.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof v02)) {
                        v02Var = (v02) obj;
                    } else {
                        v02Var = new v02(this.mSwanApiContext);
                        this.mApis.put("968563034", v02Var);
                    }
                    Pair<Boolean, g32> a2 = i32.a(v02Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((g32) a2.second).a();
                    } else if (od2.a(this.mSwanApiContext.e(), "Network.request")) {
                        a = new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<g32, JSONObject> u = kz1.u(str);
                        if (!((g32) u.first).isSuccess()) {
                            a = ((g32) u.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) u.second;
                            if (jSONObject == null) {
                                a = g32.a.a();
                            } else {
                                h32 V = v02Var.V(jSONObject);
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
                        f32.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                e43 e43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof e43)) {
                    e43Var = (e43) obj;
                } else {
                    e43Var = new e43(this.mSwanApiContext);
                    this.mApis.put("-336396851", e43Var);
                }
                Pair<Boolean, g32> a = i32.a(e43Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Payment.chooseCoupon")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = e43Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                e43 e43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof e43)) {
                    e43Var = (e43) obj;
                } else {
                    e43Var = new e43(this.mSwanApiContext);
                    this.mApis.put("-336396851", e43Var);
                }
                Pair<Boolean, g32> a = i32.a(e43Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Payment.getPaymentInfo")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = e43Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                u33 u33Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof u33)) {
                    u33Var = (u33) obj;
                } else {
                    u33Var = new u33(this.mSwanApiContext);
                    this.mApis.put("1854689529", u33Var);
                }
                Pair<Boolean, g32> a = i32.a(u33Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Payment.requestThirdPayment")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = u33Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                e43 e43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof e43)) {
                    e43Var = (e43) obj;
                } else {
                    e43Var = new e43(this.mSwanApiContext);
                    this.mApis.put("-336396851", e43Var);
                }
                Pair<Boolean, g32> a = i32.a(e43Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Payment.setPaymentInfo")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 z = e43Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPlugin", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                p63 p63Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof p63)) {
                    p63Var = (p63) obj;
                } else {
                    p63Var = new p63(this.mSwanApiContext);
                    this.mApis.put("-254510461", p63Var);
                }
                Pair<Boolean, g32> a = i32.a(p63Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Plugin.invokePluginChooseAddress")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = p63Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                p63 p63Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof p63)) {
                    p63Var = (p63) obj;
                } else {
                    p63Var = new p63(this.mSwanApiContext);
                    this.mApis.put("-254510461", p63Var);
                }
                Pair<Boolean, g32> a = i32.a(p63Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 z = p63Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                p63 p63Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof p63)) {
                    p63Var = (p63) obj;
                } else {
                    p63Var = new p63(this.mSwanApiContext);
                    this.mApis.put("-254510461", p63Var);
                }
                Pair<Boolean, g32> a = i32.a(p63Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Plugin.invokePluginPayment")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = p63Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                if2 if2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof if2)) {
                    if2Var = (if2) obj;
                } else {
                    if2Var = new if2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", if2Var);
                }
                Pair<Boolean, g32> a = i32.a(if2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Prefetch.prefetchResources")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = if2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPreload", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                ae2 ae2Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof ae2)) {
                    ae2Var = (ae2) obj;
                } else {
                    ae2Var = new ae2(this.mSwanApiContext);
                    this.mApis.put("423661539", ae2Var);
                }
                Pair<Boolean, g32> a = i32.a(ae2Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Preload.preloadStatus")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = ae2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                kn3 kn3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof kn3)) {
                    kn3Var = (kn3) obj;
                } else {
                    kn3Var = new kn3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", kn3Var);
                }
                Pair<Boolean, g32> a = i32.a(kn3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "PrivateFile.uploadFileToBos")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 C = kn3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naRouter", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                z02 z02Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("-1495163604", z02Var);
                }
                Pair<Boolean, g32> a = i32.a(z02Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Router.hideModalPage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = z02Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("-1495163604", z02Var);
                }
                Pair<Boolean, g32> a = i32.a(z02Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Router.navigateBack")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 B = z02Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                a12 a12Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("1968522584", a12Var);
                }
                Pair<Boolean, g32> a = i32.a(a12Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Router.navigateTo")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 H = a12Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                c12 c12Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof c12)) {
                    c12Var = (c12) obj;
                } else {
                    c12Var = new c12(this.mSwanApiContext);
                    this.mApis.put("1317280190", c12Var);
                }
                Pair<Boolean, g32> a = i32.a(c12Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Router.reLaunch")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = c12Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                d12 d12Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof d12)) {
                    d12Var = (d12) obj;
                } else {
                    d12Var = new d12(this.mSwanApiContext);
                    this.mApis.put("-420075743", d12Var);
                }
                Pair<Boolean, g32> a = i32.a(d12Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Router.reLoadErrorPage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = d12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                b12 b12Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof b12)) {
                    b12Var = (b12) obj;
                } else {
                    b12Var = new b12(this.mSwanApiContext);
                    this.mApis.put("1792515533", b12Var);
                }
                Pair<Boolean, g32> a = i32.a(b12Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Router.redirectTo")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 D = b12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                a12 a12Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("1968522584", a12Var);
                }
                Pair<Boolean, g32> a = i32.a(a12Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Router.showModalPage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 J = a12Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naSetting", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                g12 g12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof g12)) {
                    g12Var = (g12) obj;
                } else {
                    g12Var = new g12(this.mSwanApiContext);
                    this.mApis.put("-594895721", g12Var);
                }
                Pair<Boolean, g32> a = i32.a(g12Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Setting.getAppInfoSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 F = g12Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                g12 g12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof g12)) {
                    g12Var = (g12) obj;
                } else {
                    g12Var = new g12(this.mSwanApiContext);
                    this.mApis.put("-594895721", g12Var);
                }
                Pair<Boolean, g32> a = i32.a(g12Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Setting.getSlaveIdSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 H = g12Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                f12 f12Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("450273045", f12Var);
                }
                Pair<Boolean, g32> a = i32.a(f12Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Setting.isAllowedAdOpenAppSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = f12Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                g12 g12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof g12)) {
                    g12Var = (g12) obj;
                } else {
                    g12Var = new g12(this.mSwanApiContext);
                    this.mApis.put("-594895721", g12Var);
                }
                Pair<Boolean, g32> a = i32.a(g12Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Setting.getSetting")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 G = g12Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                g12 g12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof g12)) {
                    g12Var = (g12) obj;
                } else {
                    g12Var = new g12(this.mSwanApiContext);
                    this.mApis.put("-594895721", g12Var);
                }
                Pair<Boolean, g32> a = i32.a(g12Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Setting.getSwanId")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 I = g12Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                g12 g12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof g12)) {
                    g12Var = (g12) obj;
                } else {
                    g12Var = new g12(this.mSwanApiContext);
                    this.mApis.put("-594895721", g12Var);
                }
                Pair<Boolean, g32> a = i32.a(g12Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Setting.getUserInfo")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 J = g12Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                ei3 ei3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof ei3)) {
                    ei3Var = (ei3) obj;
                } else {
                    ei3Var = new ei3(this.mSwanApiContext);
                    this.mApis.put("712777136", ei3Var);
                }
                Pair<Boolean, g32> a = i32.a(ei3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = ei3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naStorage", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                j12 j12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof j12)) {
                    j12Var = (j12) obj;
                } else {
                    j12Var = new j12(this.mSwanApiContext);
                    this.mApis.put("-804054859", j12Var);
                }
                Pair<Boolean, g32> a = i32.a(j12Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = j12Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                j12 j12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof j12)) {
                    j12Var = (j12) obj;
                } else {
                    j12Var = new j12(this.mSwanApiContext);
                    this.mApis.put("-804054859", j12Var);
                }
                Pair<Boolean, g32> a = i32.a(j12Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorageSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 C = j12Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                i12 i12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("130910081", i12Var);
                }
                Pair<Boolean, g32> a = i32.a(i12Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.clearStorage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = i12Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                i12 i12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("130910081", i12Var);
                }
                Pair<Boolean, g32> a = i32.a(i12Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.clearStorageSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 C = i12Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                j12 j12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof j12)) {
                    j12Var = (j12) obj;
                } else {
                    j12Var = new j12(this.mSwanApiContext);
                    this.mApis.put("-804054859", j12Var);
                }
                Pair<Boolean, g32> a = i32.a(j12Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfo")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 G = j12Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                j12 j12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof j12)) {
                    j12Var = (j12) obj;
                } else {
                    j12Var = new j12(this.mSwanApiContext);
                    this.mApis.put("-804054859", j12Var);
                }
                Pair<Boolean, g32> a = i32.a(j12Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfoSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 J = j12Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                i12 i12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("130910081", i12Var);
                }
                Pair<Boolean, g32> a = i32.a(i12Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.getStorageInfo")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 G = i12Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                i12 i12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("130910081", i12Var);
                }
                Pair<Boolean, g32> a = i32.a(i12Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.getStorageInfoSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 J = i12Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                j12 j12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof j12)) {
                    j12Var = (j12) obj;
                } else {
                    j12Var = new j12(this.mSwanApiContext);
                    this.mApis.put("-804054859", j12Var);
                }
                Pair<Boolean, g32> a = i32.a(j12Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.getGlobalStorage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 D = j12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                j12 j12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof j12)) {
                    j12Var = (j12) obj;
                } else {
                    j12Var = new j12(this.mSwanApiContext);
                    this.mApis.put("-804054859", j12Var);
                }
                Pair<Boolean, g32> a = i32.a(j12Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 K = j12Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                i12 i12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("130910081", i12Var);
                }
                Pair<Boolean, g32> a = i32.a(i12Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.getStorage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 D = i12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                i12 i12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("130910081", i12Var);
                }
                Pair<Boolean, g32> a = i32.a(i12Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.getStorageInfoAsync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 H = i12Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                i12 i12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("130910081", i12Var);
                }
                Pair<Boolean, g32> a = i32.a(i12Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.getStorageSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 K = i12Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                j12 j12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof j12)) {
                    j12Var = (j12) obj;
                } else {
                    j12Var = new j12(this.mSwanApiContext);
                    this.mApis.put("-804054859", j12Var);
                }
                Pair<Boolean, g32> a = i32.a(j12Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 R = j12Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                j12 j12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof j12)) {
                    j12Var = (j12) obj;
                } else {
                    j12Var = new j12(this.mSwanApiContext);
                    this.mApis.put("-804054859", j12Var);
                }
                Pair<Boolean, g32> a = i32.a(j12Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorageSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 T2 = j12Var.T(str);
                if (T2 == null) {
                    return "";
                }
                return T2.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                i12 i12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("130910081", i12Var);
                }
                Pair<Boolean, g32> a = i32.a(i12Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.removeStorage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 R = i12Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                i12 i12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("130910081", i12Var);
                }
                Pair<Boolean, g32> a = i32.a(i12Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.removeStorageSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 T2 = i12Var.T(str);
                if (T2 == null) {
                    return "";
                }
                return T2.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                j12 j12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof j12)) {
                    j12Var = (j12) obj;
                } else {
                    j12Var = new j12(this.mSwanApiContext);
                    this.mApis.put("-804054859", j12Var);
                }
                Pair<Boolean, g32> a = i32.a(j12Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.setGlobalStorage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 U = j12Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                j12 j12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof j12)) {
                    j12Var = (j12) obj;
                } else {
                    j12Var = new j12(this.mSwanApiContext);
                    this.mApis.put("-804054859", j12Var);
                }
                Pair<Boolean, g32> a = i32.a(j12Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.setGlobalStorageSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 W = j12Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                i12 i12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("130910081", i12Var);
                }
                Pair<Boolean, g32> a = i32.a(i12Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.setStorage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 U = i12Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                i12 i12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("130910081", i12Var);
                }
                Pair<Boolean, g32> a = i32.a(i12Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Storage.setStorageSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 W = i12Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }
        });
        hashMap.put("_naSubscription", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                l12 l12Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof l12)) {
                    l12Var = (l12) obj;
                } else {
                    l12Var = new l12(this.mSwanApiContext);
                    this.mApis.put("823117982", l12Var);
                }
                Pair<Boolean, g32> a = i32.a(l12Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Subscription.requestSubscribeFormId")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 E = l12Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                m12 m12Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof m12)) {
                    m12Var = (m12) obj;
                } else {
                    m12Var = new m12(this.mSwanApiContext);
                    this.mApis.put("-947445811", m12Var);
                }
                Pair<Boolean, g32> a = i32.a(m12Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Subscription.subscribeService")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 F = m12Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }
        });
        hashMap.put("_naSystem", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                t12 t12Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof t12)) {
                    t12Var = (t12) obj;
                } else {
                    t12Var = new t12(this.mSwanApiContext);
                    this.mApis.put("1936205521", t12Var);
                }
                Pair<Boolean, g32> a = i32.a(t12Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.exitFullScreen")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = t12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                s12 s12Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof s12)) {
                    s12Var = (s12) obj;
                } else {
                    s12Var = new s12(this.mSwanApiContext);
                    this.mApis.put("1694151270", s12Var);
                }
                Pair<Boolean, g32> a = i32.a(s12Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.getDeviceInfo")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = s12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                u12 u12Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof u12)) {
                    u12Var = (u12) obj;
                } else {
                    u12Var = new u12(this.mSwanApiContext);
                    this.mApis.put("-1321681619", u12Var);
                }
                Pair<Boolean, g32> a = i32.a(u12Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.getDeviceProfile")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = u12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                v12 v12Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof v12)) {
                    v12Var = (v12) obj;
                } else {
                    v12Var = new v12(this.mSwanApiContext);
                    this.mApis.put("-1569246082", v12Var);
                }
                Pair<Boolean, g32> a = i32.a(v12Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.makePhoneCall")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = v12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                x12 x12Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof x12)) {
                    x12Var = (x12) obj;
                } else {
                    x12Var = new x12(this.mSwanApiContext);
                    this.mApis.put("1099851202", x12Var);
                }
                Pair<Boolean, g32> a = i32.a(x12Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.openSMSPanel")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = x12Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                w12 w12Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("-1707203360", w12Var);
                }
                Pair<Boolean, g32> a = i32.a(w12Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.requestFullScreen")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 F = w12Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                q12 q12Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof q12)) {
                    q12Var = (q12) obj;
                } else {
                    q12Var = new q12(this.mSwanApiContext);
                    this.mApis.put("-518757484", q12Var);
                }
                Pair<Boolean, g32> a = i32.a(q12Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.setClipboardData")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = q12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                a13 a13Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof a13)) {
                    a13Var = (a13) obj;
                } else {
                    a13Var = new a13(this.mSwanApiContext);
                    this.mApis.put("1161486049", a13Var);
                }
                Pair<Boolean, g32> a = i32.a(a13Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.setErrorPageType")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = a13Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                a22 a22Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("447234992", a22Var);
                }
                Pair<Boolean, g32> a = i32.a(a22Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.setMediaVolume")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 z = a22Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                o12 o12Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof o12)) {
                    o12Var = (o12) obj;
                } else {
                    o12Var = new o12(this.mSwanApiContext);
                    this.mApis.put("1372680763", o12Var);
                }
                Pair<Boolean, g32> a = i32.a(o12Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.startAccelerometer")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = o12Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                r12 r12Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof r12)) {
                    r12Var = (r12) obj;
                } else {
                    r12Var = new r12(this.mSwanApiContext);
                    this.mApis.put("1689255576", r12Var);
                }
                Pair<Boolean, g32> a = i32.a(r12Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.startCompass")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = r12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                p12 p12Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof p12)) {
                    p12Var = (p12) obj;
                } else {
                    p12Var = new p12(this.mSwanApiContext);
                    this.mApis.put("99997465", p12Var);
                }
                Pair<Boolean, g32> a = i32.a(p12Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.getBrightness")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = p12Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                q12 q12Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof q12)) {
                    q12Var = (q12) obj;
                } else {
                    q12Var = new q12(this.mSwanApiContext);
                    this.mApis.put("-518757484", q12Var);
                }
                Pair<Boolean, g32> a = i32.a(q12Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.getClipboardData")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = q12Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                a22 a22Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("447234992", a22Var);
                }
                Pair<Boolean, g32> a = i32.a(a22Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.getMediaVolume")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = a22Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                o12 o12Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof o12)) {
                    o12Var = (o12) obj;
                } else {
                    o12Var = new o12(this.mSwanApiContext);
                    this.mApis.put("1372680763", o12Var);
                }
                Pair<Boolean, g32> a = i32.a(o12Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.stopAccelerometer")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 B = o12Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                r12 r12Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof r12)) {
                    r12Var = (r12) obj;
                } else {
                    r12Var = new r12(this.mSwanApiContext);
                    this.mApis.put("1689255576", r12Var);
                }
                Pair<Boolean, g32> a = i32.a(r12Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "System.stopCompass")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 z = r12Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naUtils", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                l22 l22Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof l22)) {
                    l22Var = (l22) obj;
                } else {
                    l22Var = new l22(this.mSwanApiContext);
                    this.mApis.put("201194468", l22Var);
                }
                Pair<Boolean, g32> a = i32.a(l22Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.addToDesktop")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 B = l22Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                h22 h22Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof h22)) {
                    h22Var = (h22) obj;
                } else {
                    h22Var = new h22(this.mSwanApiContext);
                    this.mApis.put("-1412306947", h22Var);
                }
                Pair<Boolean, g32> a = i32.a(h22Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.calcMD5")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = h22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                i22 i22Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof i22)) {
                    i22Var = (i22) obj;
                } else {
                    i22Var = new i22(this.mSwanApiContext);
                    this.mApis.put("1626415364", i22Var);
                }
                Pair<Boolean, g32> a = i32.a(i22Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.checkAppInstalled")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = i22Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                k22 k22Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof k22)) {
                    k22Var = (k22) obj;
                } else {
                    k22Var = new k22(this.mSwanApiContext);
                    this.mApis.put("-836768778", k22Var);
                }
                Pair<Boolean, g32> a = i32.a(k22Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfo")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = k22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                m22 m22Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof m22)) {
                    m22Var = (m22) obj;
                } else {
                    m22Var = new m22(this.mSwanApiContext);
                    this.mApis.put("-810858308", m22Var);
                }
                Pair<Boolean, g32> a = i32.a(m22Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.getPerformanceLevel")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = m22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                q22 q22Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof q22)) {
                    q22Var = (q22) obj;
                } else {
                    q22Var = new q22(this.mSwanApiContext);
                    this.mApis.put("-1011537871", q22Var);
                }
                Pair<Boolean, g32> a = i32.a(q22Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.getSystemInfoAsync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 I = q22Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                n22 n22Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof n22)) {
                    n22Var = (n22) obj;
                } else {
                    n22Var = new n22(this.mSwanApiContext);
                    this.mApis.put("-2097727681", n22Var);
                }
                Pair<Boolean, g32> a = i32.a(n22Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.handleException")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = n22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                j22 j22Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof j22)) {
                    j22Var = (j22) obj;
                } else {
                    j22Var = new j22(this.mSwanApiContext);
                    this.mApis.put("2084449317", j22Var);
                }
                Pair<Boolean, g32> a = i32.a(j22Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.hasCloseHandler")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = j22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                mf3 mf3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof mf3)) {
                    mf3Var = (mf3) obj;
                } else {
                    mf3Var = new mf3(this.mSwanApiContext);
                    this.mApis.put("1031678042", mf3Var);
                }
                Pair<Boolean, g32> a = i32.a(mf3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.hideCaptureScreenShareDialog")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 x = mf3Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                o22 o22Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof o22)) {
                    o22Var = (o22) obj;
                } else {
                    o22Var = new o22(this.mSwanApiContext);
                    this.mApis.put("1751900130", o22Var);
                }
                Pair<Boolean, g32> a = i32.a(o22Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.logToFile")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = o22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                ne3 ne3Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof ne3)) {
                    ne3Var = (ne3) obj;
                } else {
                    ne3Var = new ne3(this.mSwanApiContext);
                    this.mApis.put("1748196865", ne3Var);
                }
                Pair<Boolean, g32> a = i32.a(ne3Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.preloadPackage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = ne3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                p22 p22Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof p22)) {
                    p22Var = (p22) obj;
                } else {
                    p22Var = new p22(this.mSwanApiContext);
                    this.mApis.put("589529211", p22Var);
                }
                Pair<Boolean, g32> a = i32.a(p22Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.previewImage")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 B = p22Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                s22 s22Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof s22)) {
                    s22Var = (s22) obj;
                } else {
                    s22Var = new s22(this.mSwanApiContext);
                    this.mApis.put("-577481801", s22Var);
                }
                Pair<Boolean, g32> a = i32.a(s22Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.ubcFlowJar")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 I = s22Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                q22 q22Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof q22)) {
                    q22Var = (q22) obj;
                } else {
                    q22Var = new q22(this.mSwanApiContext);
                    this.mApis.put("-1011537871", q22Var);
                }
                Pair<Boolean, g32> a = i32.a(q22Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfoSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 E = q22Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                q22 q22Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof q22)) {
                    q22Var = (q22) obj;
                } else {
                    q22Var = new q22(this.mSwanApiContext);
                    this.mApis.put("-1011537871", q22Var);
                }
                Pair<Boolean, g32> a = i32.a(q22Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.getSystemInfo")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 H = q22Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                q22 q22Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof q22)) {
                    q22Var = (q22) obj;
                } else {
                    q22Var = new q22(this.mSwanApiContext);
                    this.mApis.put("-1011537871", q22Var);
                }
                Pair<Boolean, g32> a = i32.a(q22Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Utils.getSystemInfoSync")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 J = q22Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naWifi", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                xl3 xl3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof xl3)) {
                    xl3Var = (xl3) obj;
                } else {
                    xl3Var = new xl3(this.mSwanApiContext);
                    this.mApis.put("1879401452", xl3Var);
                }
                Pair<Boolean, g32> a = i32.a(xl3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Wifi.connectWifi")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 A = xl3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                xl3 xl3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof xl3)) {
                    xl3Var = (xl3) obj;
                } else {
                    xl3Var = new xl3(this.mSwanApiContext);
                    this.mApis.put("1879401452", xl3Var);
                }
                Pair<Boolean, g32> a = i32.a(xl3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Wifi.getConnectedWifi")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 B = xl3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                xl3 xl3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof xl3)) {
                    xl3Var = (xl3) obj;
                } else {
                    xl3Var = new xl3(this.mSwanApiContext);
                    this.mApis.put("1879401452", xl3Var);
                }
                Pair<Boolean, g32> a = i32.a(xl3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Wifi.getWifiList")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 C = xl3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                xl3 xl3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof xl3)) {
                    xl3Var = (xl3) obj;
                } else {
                    xl3Var = new xl3(this.mSwanApiContext);
                    this.mApis.put("1879401452", xl3Var);
                }
                Pair<Boolean, g32> a = i32.a(xl3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Wifi.startWifi")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 G = xl3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                xl3 xl3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof xl3)) {
                    xl3Var = (xl3) obj;
                } else {
                    xl3Var = new xl3(this.mSwanApiContext);
                    this.mApis.put("1879401452", xl3Var);
                }
                Pair<Boolean, g32> a = i32.a(xl3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "Wifi.stopWifi")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 H = xl3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }
}
